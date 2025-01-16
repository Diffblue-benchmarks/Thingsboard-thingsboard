package org.thingsboard.server.common.data.tenant.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TenantProfileType;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder;

class DefaultTenantProfileConfigurationDiffblueTest {
  /**
   * Test DefaultTenantProfileConfigurationBuilder
   * {@link DefaultTenantProfileConfigurationBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#build()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#alarmsTtlDays(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#cassandraQueryTenantRateLimitsConfiguration(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#customerServerRestLimitsConfiguration(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#defaultStorageTtlDays(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#edgeEventRateLimits(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#edgeEventRateLimitsPerEdge(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#edgeUplinkMessagesRateLimits(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#edgeUplinkMessagesRateLimitsPerEdge(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxAssets(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxCreatedAlarms(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxCustomers(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxDPStorageDays(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxDashboards(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxDevices(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxEmails(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxJSExecutions(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxOtaPackagesInBytes(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxREExecutions(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxResourceSize(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxResourcesInBytes(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxRuleChains(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxRuleNodeExecutionsPerMessage(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxSms(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxTbelExecutions(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxTransportDataPoints(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxTransportMessages(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxUsers(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxWsSessionsPerCustomer(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxWsSessionsPerPublicUser(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxWsSessionsPerRegularUser(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxWsSessionsPerTenant(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxWsSubscriptionsPerCustomer(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxWsSubscriptionsPerPublicUser(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxWsSubscriptionsPerRegularUser(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#maxWsSubscriptionsPerTenant(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#queueStatsTtlDays(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#rpcTtlDays(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#ruleEngineExceptionsTtlDays(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#smsEnabled(Boolean)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#tenantEntityExportRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#tenantEntityImportRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#tenantNotificationRequestsPerRuleRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#tenantNotificationRequestsRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#tenantServerRestLimitsConfiguration(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#transportDeviceMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#transportDeviceTelemetryDataPointsRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#transportDeviceTelemetryMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#transportGatewayDeviceMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#transportGatewayDeviceTelemetryDataPointsRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#transportGatewayDeviceTelemetryMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#transportGatewayMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#transportGatewayTelemetryDataPointsRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#transportGatewayTelemetryMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#transportTenantMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#transportTenantTelemetryDataPointsRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#transportTenantTelemetryMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#warnThreshold(double)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#wsMsgQueueLimitPerSession(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder#wsUpdatesPerSessionRateLimit(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test DefaultTenantProfileConfigurationBuilder build()")
  void testDefaultTenantProfileConfigurationBuilderBuild() {
    // Arrange and Act
    DefaultTenantProfileConfiguration actualBuildResult = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Assert
    assertEquals("2020-03-01", actualBuildResult.getWsUpdatesPerSessionRateLimit());
    assertEquals("Cassandra Query Tenant Rate Limits Configuration",
        actualBuildResult.getCassandraQueryTenantRateLimitsConfiguration());
    assertEquals("Customer Server Rest Limits Configuration",
        actualBuildResult.getCustomerServerRestLimitsConfiguration());
    assertEquals("Edge Event Rate Limits Per Edge", actualBuildResult.getEdgeEventRateLimitsPerEdge());
    assertEquals("Edge Event Rate Limits", actualBuildResult.getEdgeEventRateLimits());
    assertEquals("Edge Uplink Messages Rate Limits Per Edge",
        actualBuildResult.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertEquals("Edge Uplink Messages Rate Limits", actualBuildResult.getEdgeUplinkMessagesRateLimits());
    assertEquals("Tenant Entity Export Rate Limit", actualBuildResult.getTenantEntityExportRateLimit());
    assertEquals("Tenant Entity Import Rate Limit", actualBuildResult.getTenantEntityImportRateLimit());
    assertEquals("Tenant Notification Requests Per Rule Rate Limit",
        actualBuildResult.getTenantNotificationRequestsPerRuleRateLimit());
    assertEquals("Tenant Notification Requests Rate Limit", actualBuildResult.getTenantNotificationRequestsRateLimit());
    assertEquals("Tenant Server Rest Limits Configuration", actualBuildResult.getTenantServerRestLimitsConfiguration());
    assertEquals("Transport Device Msg Rate Limit", actualBuildResult.getTransportDeviceMsgRateLimit());
    assertEquals("Transport Device Telemetry Data Points Rate Limit",
        actualBuildResult.getTransportDeviceTelemetryDataPointsRateLimit());
    assertEquals("Transport Device Telemetry Msg Rate Limit",
        actualBuildResult.getTransportDeviceTelemetryMsgRateLimit());
    assertEquals("Transport Gateway Device Msg Rate Limit", actualBuildResult.getTransportGatewayDeviceMsgRateLimit());
    assertEquals("Transport Gateway Device Telemetry Data Points Rate Limit",
        actualBuildResult.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertEquals("Transport Gateway Device Telemetry Msg Rate Limit",
        actualBuildResult.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertEquals("Transport Gateway Msg Rate Limit", actualBuildResult.getTransportGatewayMsgRateLimit());
    assertEquals("Transport Gateway Telemetry Data Points Rate Limit",
        actualBuildResult.getTransportGatewayTelemetryDataPointsRateLimit());
    assertEquals("Transport Gateway Telemetry Msg Rate Limit",
        actualBuildResult.getTransportGatewayTelemetryMsgRateLimit());
    assertEquals("Transport Tenant Msg Rate Limit", actualBuildResult.getTransportTenantMsgRateLimit());
    assertEquals("Transport Tenant Telemetry Data Points Rate Limit",
        actualBuildResult.getTransportTenantTelemetryDataPointsRateLimit());
    assertEquals("Transport Tenant Telemetry Msg Rate Limit",
        actualBuildResult.getTransportTenantTelemetryMsgRateLimit());
    assertEquals(1, actualBuildResult.getAlarmsTtlDays());
    assertEquals(1, actualBuildResult.getDefaultStorageTtlDays());
    assertEquals(1, actualBuildResult.getQueueStatsTtlDays());
    assertEquals(1, actualBuildResult.getRpcTtlDays());
    assertEquals(1, actualBuildResult.getRuleEngineExceptionsTtlDays());
    assertEquals(1, actualBuildResult.getWsMsgQueueLimitPerSession());
    assertEquals(10.0d, actualBuildResult.getWarnThreshold());
    assertEquals(1L, actualBuildResult.getMaxAssets());
    assertEquals(1L, actualBuildResult.getMaxCreatedAlarms());
    assertEquals(1L, actualBuildResult.getMaxCustomers());
    assertEquals(1L, actualBuildResult.getMaxDPStorageDays());
    assertEquals(1L, actualBuildResult.getMaxDashboards());
    assertEquals(1L, actualBuildResult.getMaxDevices());
    assertEquals(1L, actualBuildResult.getMaxEmails());
    assertEquals(1L, actualBuildResult.getMaxJSExecutions());
    assertEquals(1L, actualBuildResult.getMaxOtaPackagesInBytes());
    assertEquals(1L, actualBuildResult.getMaxREExecutions());
    assertEquals(1L, actualBuildResult.getMaxResourcesInBytes());
    assertEquals(1L, actualBuildResult.getMaxRuleChains());
    assertEquals(1L, actualBuildResult.getMaxSms());
    assertEquals(1L, actualBuildResult.getMaxTbelExecutions());
    assertEquals(1L, actualBuildResult.getMaxTransportDataPoints());
    assertEquals(1L, actualBuildResult.getMaxTransportMessages());
    assertEquals(1L, actualBuildResult.getMaxUsers());
    assertEquals(1L, actualBuildResult.getMaxWsSubscriptionsPerCustomer());
    assertEquals(1L, actualBuildResult.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(1L, actualBuildResult.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(1L, actualBuildResult.getMaxWsSubscriptionsPerTenant());
    assertEquals(3, actualBuildResult.getMaxRuleNodeExecsPerMessage());
    assertEquals(3, actualBuildResult.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(3, actualBuildResult.getMaxWsSessionsPerCustomer());
    assertEquals(3, actualBuildResult.getMaxWsSessionsPerPublicUser());
    assertEquals(3, actualBuildResult.getMaxWsSessionsPerRegularUser());
    assertEquals(3, actualBuildResult.getMaxWsSessionsPerTenant());
    assertEquals(3L, actualBuildResult.getMaxResourceSize());
    assertEquals(TenantProfileType.DEFAULT, actualBuildResult.getType());
    assertTrue(actualBuildResult.getSmsEnabled());
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}.
   * <ul>
   *   <li>When {@code CREATED_ALARMS_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileThreshold(ApiUsageRecordKey); when 'CREATED_ALARMS_COUNT'")
  void testGetProfileThreshold_whenCreatedAlarmsCount() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new DefaultTenantProfileConfiguration()).getProfileThreshold(ApiUsageRecordKey.CREATED_ALARMS_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}.
   * <ul>
   *   <li>When {@code EMAIL_EXEC_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileThreshold(ApiUsageRecordKey); when 'EMAIL_EXEC_COUNT'")
  void testGetProfileThreshold_whenEmailExecCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DefaultTenantProfileConfiguration()).getProfileThreshold(ApiUsageRecordKey.EMAIL_EXEC_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}.
   * <ul>
   *   <li>When {@code JS_EXEC_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileThreshold(ApiUsageRecordKey); when 'JS_EXEC_COUNT'")
  void testGetProfileThreshold_whenJsExecCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DefaultTenantProfileConfiguration()).getProfileThreshold(ApiUsageRecordKey.JS_EXEC_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}.
   * <ul>
   *   <li>When {@code RE_EXEC_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileThreshold(ApiUsageRecordKey); when 'RE_EXEC_COUNT'")
  void testGetProfileThreshold_whenReExecCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DefaultTenantProfileConfiguration()).getProfileThreshold(ApiUsageRecordKey.RE_EXEC_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}.
   * <ul>
   *   <li>When {@code SMS_EXEC_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileThreshold(ApiUsageRecordKey); when 'SMS_EXEC_COUNT'")
  void testGetProfileThreshold_whenSmsExecCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DefaultTenantProfileConfiguration()).getProfileThreshold(ApiUsageRecordKey.SMS_EXEC_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}.
   * <ul>
   *   <li>When {@code STORAGE_DP_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileThreshold(ApiUsageRecordKey); when 'STORAGE_DP_COUNT'")
  void testGetProfileThreshold_whenStorageDpCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DefaultTenantProfileConfiguration()).getProfileThreshold(ApiUsageRecordKey.STORAGE_DP_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}.
   * <ul>
   *   <li>When {@code TBEL_EXEC_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileThreshold(ApiUsageRecordKey); when 'TBEL_EXEC_COUNT'")
  void testGetProfileThreshold_whenTbelExecCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DefaultTenantProfileConfiguration()).getProfileThreshold(ApiUsageRecordKey.TBEL_EXEC_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}.
   * <ul>
   *   <li>When {@code TRANSPORT_DP_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileThreshold(ApiUsageRecordKey); when 'TRANSPORT_DP_COUNT'")
  void testGetProfileThreshold_whenTransportDpCount() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new DefaultTenantProfileConfiguration()).getProfileThreshold(ApiUsageRecordKey.TRANSPORT_DP_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}.
   * <ul>
   *   <li>When {@code TRANSPORT_MSG_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileThreshold(ApiUsageRecordKey); when 'TRANSPORT_MSG_COUNT'")
  void testGetProfileThreshold_whenTransportMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new DefaultTenantProfileConfiguration()).getProfileThreshold(ApiUsageRecordKey.TRANSPORT_MSG_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getProfileFeatureEnabled(ApiUsageRecordKey)}.
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getProfileFeatureEnabled(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileFeatureEnabled(ApiUsageRecordKey)")
  void testGetProfileFeatureEnabled() {
    // Arrange
    DefaultTenantProfileConfiguration buildResult = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertTrue(buildResult.getProfileFeatureEnabled(ApiUsageRecordKey.SMS_EXEC_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getProfileFeatureEnabled(ApiUsageRecordKey)}.
   * <ul>
   *   <li>Given
   * {@link DefaultTenantProfileConfiguration#DefaultTenantProfileConfiguration()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getProfileFeatureEnabled(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileFeatureEnabled(ApiUsageRecordKey); given DefaultTenantProfileConfiguration()")
  void testGetProfileFeatureEnabled_givenDefaultTenantProfileConfiguration() {
    // Arrange, Act and Assert
    assertTrue((new DefaultTenantProfileConfiguration()).getProfileFeatureEnabled(ApiUsageRecordKey.SMS_EXEC_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getProfileFeatureEnabled(ApiUsageRecordKey)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getProfileFeatureEnabled(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileFeatureEnabled(ApiUsageRecordKey); then return 'false'")
  void testGetProfileFeatureEnabled_thenReturnFalse() {
    // Arrange
    DefaultTenantProfileConfiguration buildResult = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .smsEnabled(false)
        .tenantEntityExportRateLimit("Tenant Entity Export Rate Limit")
        .tenantEntityImportRateLimit("Tenant Entity Import Rate Limit")
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertFalse(buildResult.getProfileFeatureEnabled(ApiUsageRecordKey.SMS_EXEC_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getProfileFeatureEnabled(ApiUsageRecordKey)}.
   * <ul>
   *   <li>When {@code TRANSPORT_MSG_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getProfileFeatureEnabled(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileFeatureEnabled(ApiUsageRecordKey); when 'TRANSPORT_MSG_COUNT'")
  void testGetProfileFeatureEnabled_whenTransportMsgCount() {
    // Arrange, Act and Assert
    assertTrue(
        (new DefaultTenantProfileConfiguration()).getProfileFeatureEnabled(ApiUsageRecordKey.TRANSPORT_MSG_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   * with {@code ApiUsageRecordKey}.
   * <ul>
   *   <li>Given
   * {@link DefaultTenantProfileConfiguration#DefaultTenantProfileConfiguration()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getWarnThreshold(ApiUsageRecordKey) with 'ApiUsageRecordKey'; given DefaultTenantProfileConfiguration()")
  void testGetWarnThresholdWithApiUsageRecordKey_givenDefaultTenantProfileConfiguration() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DefaultTenantProfileConfiguration()).getWarnThreshold(ApiUsageRecordKey.TRANSPORT_MSG_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   * with {@code ApiUsageRecordKey}.
   * <ul>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getWarnThreshold(ApiUsageRecordKey) with 'ApiUsageRecordKey'; then return ten")
  void testGetWarnThresholdWithApiUsageRecordKey_thenReturnTen() {
    // Arrange
    DefaultTenantProfileConfiguration buildResult = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertEquals(10L, buildResult.getWarnThreshold(ApiUsageRecordKey.TRANSPORT_MSG_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   * with {@code ApiUsageRecordKey}.
   * <ul>
   *   <li>When {@code CREATED_ALARMS_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getWarnThreshold(ApiUsageRecordKey) with 'ApiUsageRecordKey'; when 'CREATED_ALARMS_COUNT'")
  void testGetWarnThresholdWithApiUsageRecordKey_whenCreatedAlarmsCount() {
    // Arrange
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = new DefaultTenantProfileConfiguration();
    defaultTenantProfileConfiguration.setWarnThreshold(0.0d);

    // Act and Assert
    assertEquals(0L, defaultTenantProfileConfiguration.getWarnThreshold(ApiUsageRecordKey.CREATED_ALARMS_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   * with {@code ApiUsageRecordKey}.
   * <ul>
   *   <li>When {@code EMAIL_EXEC_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getWarnThreshold(ApiUsageRecordKey) with 'ApiUsageRecordKey'; when 'EMAIL_EXEC_COUNT'")
  void testGetWarnThresholdWithApiUsageRecordKey_whenEmailExecCount() {
    // Arrange
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = new DefaultTenantProfileConfiguration();
    defaultTenantProfileConfiguration.setWarnThreshold(0.0d);

    // Act and Assert
    assertEquals(0L, defaultTenantProfileConfiguration.getWarnThreshold(ApiUsageRecordKey.EMAIL_EXEC_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   * with {@code ApiUsageRecordKey}.
   * <ul>
   *   <li>When {@code JS_EXEC_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getWarnThreshold(ApiUsageRecordKey) with 'ApiUsageRecordKey'; when 'JS_EXEC_COUNT'")
  void testGetWarnThresholdWithApiUsageRecordKey_whenJsExecCount() {
    // Arrange
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = new DefaultTenantProfileConfiguration();
    defaultTenantProfileConfiguration.setWarnThreshold(0.0d);

    // Act and Assert
    assertEquals(0L, defaultTenantProfileConfiguration.getWarnThreshold(ApiUsageRecordKey.JS_EXEC_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   * with {@code ApiUsageRecordKey}.
   * <ul>
   *   <li>When {@code RE_EXEC_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getWarnThreshold(ApiUsageRecordKey) with 'ApiUsageRecordKey'; when 'RE_EXEC_COUNT'")
  void testGetWarnThresholdWithApiUsageRecordKey_whenReExecCount() {
    // Arrange
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = new DefaultTenantProfileConfiguration();
    defaultTenantProfileConfiguration.setWarnThreshold(0.0d);

    // Act and Assert
    assertEquals(0L, defaultTenantProfileConfiguration.getWarnThreshold(ApiUsageRecordKey.RE_EXEC_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   * with {@code ApiUsageRecordKey}.
   * <ul>
   *   <li>When {@code SMS_EXEC_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getWarnThreshold(ApiUsageRecordKey) with 'ApiUsageRecordKey'; when 'SMS_EXEC_COUNT'")
  void testGetWarnThresholdWithApiUsageRecordKey_whenSmsExecCount() {
    // Arrange
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = new DefaultTenantProfileConfiguration();
    defaultTenantProfileConfiguration.setWarnThreshold(0.0d);

    // Act and Assert
    assertEquals(0L, defaultTenantProfileConfiguration.getWarnThreshold(ApiUsageRecordKey.SMS_EXEC_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   * with {@code ApiUsageRecordKey}.
   * <ul>
   *   <li>When {@code STORAGE_DP_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getWarnThreshold(ApiUsageRecordKey) with 'ApiUsageRecordKey'; when 'STORAGE_DP_COUNT'")
  void testGetWarnThresholdWithApiUsageRecordKey_whenStorageDpCount() {
    // Arrange
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = new DefaultTenantProfileConfiguration();
    defaultTenantProfileConfiguration.setWarnThreshold(0.0d);

    // Act and Assert
    assertEquals(0L, defaultTenantProfileConfiguration.getWarnThreshold(ApiUsageRecordKey.STORAGE_DP_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   * with {@code ApiUsageRecordKey}.
   * <ul>
   *   <li>When {@code TBEL_EXEC_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getWarnThreshold(ApiUsageRecordKey) with 'ApiUsageRecordKey'; when 'TBEL_EXEC_COUNT'")
  void testGetWarnThresholdWithApiUsageRecordKey_whenTbelExecCount() {
    // Arrange
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = new DefaultTenantProfileConfiguration();
    defaultTenantProfileConfiguration.setWarnThreshold(0.0d);

    // Act and Assert
    assertEquals(0L, defaultTenantProfileConfiguration.getWarnThreshold(ApiUsageRecordKey.TBEL_EXEC_COUNT));
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   * with {@code ApiUsageRecordKey}.
   * <ul>
   *   <li>When {@code TRANSPORT_DP_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getWarnThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getWarnThreshold(ApiUsageRecordKey) with 'ApiUsageRecordKey'; when 'TRANSPORT_DP_COUNT'")
  void testGetWarnThresholdWithApiUsageRecordKey_whenTransportDpCount() {
    // Arrange
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = new DefaultTenantProfileConfiguration();
    defaultTenantProfileConfiguration.setWarnThreshold(0.0d);

    // Act and Assert
    assertEquals(0L, defaultTenantProfileConfiguration.getWarnThreshold(ApiUsageRecordKey.TRANSPORT_DP_COUNT));
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#getEntitiesLimit(EntityType)}.
   * <ul>
   *   <li>When {@code ASSET}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getEntitiesLimit(EntityType)}
   */
  @Test
  @DisplayName("Test getEntitiesLimit(EntityType); when 'ASSET'")
  void testGetEntitiesLimit_whenAsset() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DefaultTenantProfileConfiguration()).getEntitiesLimit(EntityType.ASSET));
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#getEntitiesLimit(EntityType)}.
   * <ul>
   *   <li>When {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getEntitiesLimit(EntityType)}
   */
  @Test
  @DisplayName("Test getEntitiesLimit(EntityType); when 'CUSTOMER'")
  void testGetEntitiesLimit_whenCustomer() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DefaultTenantProfileConfiguration()).getEntitiesLimit(EntityType.CUSTOMER));
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#getEntitiesLimit(EntityType)}.
   * <ul>
   *   <li>When {@code DASHBOARD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getEntitiesLimit(EntityType)}
   */
  @Test
  @DisplayName("Test getEntitiesLimit(EntityType); when 'DASHBOARD'")
  void testGetEntitiesLimit_whenDashboard() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DefaultTenantProfileConfiguration()).getEntitiesLimit(EntityType.DASHBOARD));
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#getEntitiesLimit(EntityType)}.
   * <ul>
   *   <li>When {@code DEVICE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getEntitiesLimit(EntityType)}
   */
  @Test
  @DisplayName("Test getEntitiesLimit(EntityType); when 'DEVICE'")
  void testGetEntitiesLimit_whenDevice() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DefaultTenantProfileConfiguration()).getEntitiesLimit(EntityType.DEVICE));
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#getEntitiesLimit(EntityType)}.
   * <ul>
   *   <li>When {@code RULE_CHAIN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getEntitiesLimit(EntityType)}
   */
  @Test
  @DisplayName("Test getEntitiesLimit(EntityType); when 'RULE_CHAIN'")
  void testGetEntitiesLimit_whenRuleChain() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DefaultTenantProfileConfiguration()).getEntitiesLimit(EntityType.RULE_CHAIN));
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#getEntitiesLimit(EntityType)}.
   * <ul>
   *   <li>When {@code TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getEntitiesLimit(EntityType)}
   */
  @Test
  @DisplayName("Test getEntitiesLimit(EntityType); when 'TENANT'")
  void testGetEntitiesLimit_whenTenant() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DefaultTenantProfileConfiguration()).getEntitiesLimit(EntityType.TENANT));
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#getEntitiesLimit(EntityType)}.
   * <ul>
   *   <li>When {@code USER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#getEntitiesLimit(EntityType)}
   */
  @Test
  @DisplayName("Test getEntitiesLimit(EntityType); when 'USER'")
  void testGetEntitiesLimit_whenUser() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DefaultTenantProfileConfiguration()).getEntitiesLimit(EntityType.USER));
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}, and
   * {@link DefaultTenantProfileConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTenantProfileConfiguration#equals(Object)}
   *   <li>{@link DefaultTenantProfileConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultTenantProfileConfiguration buildResult = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}, and
   * {@link DefaultTenantProfileConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTenantProfileConfiguration#equals(Object)}
   *   <li>{@link DefaultTenantProfileConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultTenantProfileConfiguration buildResult = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
        .customerServerRestLimitsConfiguration("Customer Server Rest Limits Configuration")
        .defaultStorageTtlDays(3)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
        .customerServerRestLimitsConfiguration("Customer Server Rest Limits Configuration")
        .defaultStorageTtlDays(1)
        .edgeEventRateLimits("Edge Event Rate Limits")
        .edgeEventRateLimitsPerEdge("Edge Event Rate Limits Per Edge")
        .edgeUplinkMessagesRateLimits("Edge Uplink Messages Rate Limits")
        .edgeUplinkMessagesRateLimitsPerEdge("Edge Uplink Messages Rate Limits Per Edge")
        .maxAssets(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
        .customerServerRestLimitsConfiguration("Customer Server Rest Limits Configuration")
        .defaultStorageTtlDays(1)
        .edgeEventRateLimits("Edge Event Rate Limits")
        .edgeEventRateLimitsPerEdge("Edge Event Rate Limits Per Edge")
        .edgeUplinkMessagesRateLimits("Edge Uplink Messages Rate Limits")
        .edgeUplinkMessagesRateLimitsPerEdge("Edge Uplink Messages Rate Limits Per Edge")
        .maxAssets(1L)
        .maxCreatedAlarms(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
        .customerServerRestLimitsConfiguration("Customer Server Rest Limits Configuration")
        .defaultStorageTtlDays(1)
        .edgeEventRateLimits("Edge Event Rate Limits")
        .edgeEventRateLimitsPerEdge("Edge Event Rate Limits Per Edge")
        .edgeUplinkMessagesRateLimits("Edge Uplink Messages Rate Limits")
        .edgeUplinkMessagesRateLimitsPerEdge("Edge Uplink Messages Rate Limits Per Edge")
        .maxAssets(1L)
        .maxCreatedAlarms(1L)
        .maxCustomers(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
        .customerServerRestLimitsConfiguration("Customer Server Rest Limits Configuration")
        .defaultStorageTtlDays(1)
        .edgeEventRateLimits("Edge Event Rate Limits")
        .edgeEventRateLimitsPerEdge("Edge Event Rate Limits Per Edge")
        .edgeUplinkMessagesRateLimits("Edge Uplink Messages Rate Limits")
        .edgeUplinkMessagesRateLimitsPerEdge("Edge Uplink Messages Rate Limits Per Edge")
        .maxAssets(1L)
        .maxCreatedAlarms(1L)
        .maxCustomers(1L)
        .maxDPStorageDays(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxDashboards(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxDevices(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxEmails(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxJSExecutions(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxOtaPackagesInBytes(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxREExecutions(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxResourceSize(1L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxResourcesInBytes(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxRuleChains(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxRuleNodeExecutionsPerMessage(1)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxSms(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxTbelExecutions(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxTransportDataPoints(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxTransportMessages(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxUsers(3L)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxWsSessionsPerCustomer(1)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxWsSessionsPerPublicUser(1)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxWsSessionsPerRegularUser(1)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxWsSessionsPerTenant(1)
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxWsSubscriptionsPerCustomer(3L)
        .maxWsSubscriptionsPerPublicUser(1L)
        .maxWsSubscriptionsPerRegularUser(1L)
        .maxWsSubscriptionsPerTenant(1L)
        .queueStatsTtlDays(1)
        .rpcTtlDays(1)
        .ruleEngineExceptionsTtlDays(1)
        .smsEnabled(true)
        .tenantEntityExportRateLimit("Tenant Entity Export Rate Limit")
        .tenantEntityImportRateLimit("Tenant Entity Import Rate Limit")
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxWsSubscriptionsPerPublicUser(3L)
        .maxWsSubscriptionsPerRegularUser(1L)
        .maxWsSubscriptionsPerTenant(1L)
        .queueStatsTtlDays(1)
        .rpcTtlDays(1)
        .ruleEngineExceptionsTtlDays(1)
        .smsEnabled(true)
        .tenantEntityExportRateLimit("Tenant Entity Export Rate Limit")
        .tenantEntityImportRateLimit("Tenant Entity Import Rate Limit")
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxWsSubscriptionsPerRegularUser(3L)
        .maxWsSubscriptionsPerTenant(1L)
        .queueStatsTtlDays(1)
        .rpcTtlDays(1)
        .ruleEngineExceptionsTtlDays(1)
        .smsEnabled(true)
        .tenantEntityExportRateLimit("Tenant Entity Export Rate Limit")
        .tenantEntityImportRateLimit("Tenant Entity Import Rate Limit")
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual29() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .maxWsSubscriptionsPerTenant(3L)
        .queueStatsTtlDays(1)
        .rpcTtlDays(1)
        .ruleEngineExceptionsTtlDays(1)
        .smsEnabled(true)
        .tenantEntityExportRateLimit("Tenant Entity Export Rate Limit")
        .tenantEntityImportRateLimit("Tenant Entity Import Rate Limit")
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual30() {
    // Arrange
    DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder defaultTenantProfileConfigurationBuilder = mock(
        DefaultTenantProfileConfiguration.DefaultTenantProfileConfigurationBuilder.class);
    when(defaultTenantProfileConfigurationBuilder.alarmsTtlDays(anyInt()))
        .thenReturn(DefaultTenantProfileConfiguration.builder());
    DefaultTenantProfileConfiguration buildResult = defaultTenantProfileConfigurationBuilder.alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(3)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    DefaultTenantProfileConfiguration buildResult2 = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultTenantProfileConfiguration buildResult = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link DefaultTenantProfileConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTenantProfileConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DefaultTenantProfileConfiguration buildResult = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
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
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to DefaultTenantProfileConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DefaultTenantProfileConfiguration#DefaultTenantProfileConfiguration()}
   *   <li>{@link DefaultTenantProfileConfiguration#setAlarmsTtlDays(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setCassandraQueryTenantRateLimitsConfiguration(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setCustomerServerRestLimitsConfiguration(String)}
   *   <li>{@link DefaultTenantProfileConfiguration#setDefaultStorageTtlDays(int)}
   *   <li>{@link DefaultTenantProfileConfiguration#setEdgeEventRateLimits(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setEdgeEventRateLimitsPerEdge(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setEdgeUplinkMessagesRateLimits(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setEdgeUplinkMessagesRateLimitsPerEdge(String)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxAssets(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxCreatedAlarms(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxCustomers(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxDPStorageDays(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxDashboards(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxDevices(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxEmails(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxJSExecutions(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxOtaPackagesInBytes(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxREExecutions(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxResourceSize(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxResourcesInBytes(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxRuleChains(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setMaxRuleNodeExecutionsPerMessage(int)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxSms(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxTbelExecutions(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxTransportDataPoints(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxTransportMessages(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxUsers(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setMaxWsSessionsPerCustomer(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setMaxWsSessionsPerPublicUser(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setMaxWsSessionsPerRegularUser(int)}
   *   <li>{@link DefaultTenantProfileConfiguration#setMaxWsSessionsPerTenant(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setMaxWsSubscriptionsPerCustomer(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setMaxWsSubscriptionsPerPublicUser(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setMaxWsSubscriptionsPerRegularUser(long)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setMaxWsSubscriptionsPerTenant(long)}
   *   <li>{@link DefaultTenantProfileConfiguration#setQueueStatsTtlDays(int)}
   *   <li>{@link DefaultTenantProfileConfiguration#setRpcTtlDays(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setRuleEngineExceptionsTtlDays(int)}
   *   <li>{@link DefaultTenantProfileConfiguration#setSmsEnabled(Boolean)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTenantEntityExportRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTenantEntityImportRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTenantNotificationRequestsPerRuleRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTenantNotificationRequestsRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTenantServerRestLimitsConfiguration(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTransportDeviceMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTransportDeviceTelemetryDataPointsRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTransportDeviceTelemetryMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTransportGatewayDeviceMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTransportGatewayDeviceTelemetryDataPointsRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTransportGatewayDeviceTelemetryMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTransportGatewayMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTransportGatewayTelemetryDataPointsRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTransportGatewayTelemetryMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTransportTenantMsgRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTransportTenantTelemetryDataPointsRateLimit(String)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setTransportTenantTelemetryMsgRateLimit(String)}
   *   <li>{@link DefaultTenantProfileConfiguration#setWarnThreshold(double)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setWsMsgQueueLimitPerSession(int)}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#setWsUpdatesPerSessionRateLimit(String)}
   *   <li>{@link DefaultTenantProfileConfiguration#toString()}
   *   <li>{@link DefaultTenantProfileConfiguration#getAlarmsTtlDays()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getCassandraQueryTenantRateLimitsConfiguration()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getCustomerServerRestLimitsConfiguration()}
   *   <li>{@link DefaultTenantProfileConfiguration#getDefaultStorageTtlDays()}
   *   <li>{@link DefaultTenantProfileConfiguration#getEdgeEventRateLimits()}
   *   <li>{@link DefaultTenantProfileConfiguration#getEdgeEventRateLimitsPerEdge()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getEdgeUplinkMessagesRateLimits()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getEdgeUplinkMessagesRateLimitsPerEdge()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxAssets()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxCreatedAlarms()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxCustomers()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxDPStorageDays()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxDashboards()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxDevices()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxEmails()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxJSExecutions()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxOtaPackagesInBytes()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxREExecutions()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxResourceSize()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxResourcesInBytes()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxRuleChains()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxRuleNodeExecsPerMessage()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getMaxRuleNodeExecutionsPerMessage()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxSms()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxTbelExecutions()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxTransportDataPoints()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxTransportMessages()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxUsers()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxWsSessionsPerCustomer()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxWsSessionsPerPublicUser()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getMaxWsSessionsPerRegularUser()}
   *   <li>{@link DefaultTenantProfileConfiguration#getMaxWsSessionsPerTenant()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getMaxWsSubscriptionsPerCustomer()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getMaxWsSubscriptionsPerPublicUser()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getMaxWsSubscriptionsPerRegularUser()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getMaxWsSubscriptionsPerTenant()}
   *   <li>{@link DefaultTenantProfileConfiguration#getQueueStatsTtlDays()}
   *   <li>{@link DefaultTenantProfileConfiguration#getRpcTtlDays()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getRuleEngineExceptionsTtlDays()}
   *   <li>{@link DefaultTenantProfileConfiguration#getSmsEnabled()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTenantEntityExportRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTenantEntityImportRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTenantNotificationRequestsPerRuleRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTenantNotificationRequestsRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTenantServerRestLimitsConfiguration()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTransportDeviceMsgRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTransportDeviceTelemetryDataPointsRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTransportDeviceTelemetryMsgRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTransportGatewayDeviceMsgRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTransportGatewayDeviceTelemetryDataPointsRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTransportGatewayDeviceTelemetryMsgRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTransportGatewayMsgRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTransportGatewayTelemetryDataPointsRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTransportGatewayTelemetryMsgRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTransportTenantMsgRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTransportTenantTelemetryDataPointsRateLimit()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getTransportTenantTelemetryMsgRateLimit()}
   *   <li>{@link DefaultTenantProfileConfiguration#getType()}
   *   <li>{@link DefaultTenantProfileConfiguration#getWarnThreshold()}
   *   <li>{@link DefaultTenantProfileConfiguration#getWsMsgQueueLimitPerSession()}
   *   <li>
   * {@link DefaultTenantProfileConfiguration#getWsUpdatesPerSessionRateLimit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultTenantProfileConfiguration actualDefaultTenantProfileConfiguration = new DefaultTenantProfileConfiguration();
    actualDefaultTenantProfileConfiguration.setAlarmsTtlDays(1);
    actualDefaultTenantProfileConfiguration
        .setCassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration");
    actualDefaultTenantProfileConfiguration
        .setCustomerServerRestLimitsConfiguration("Customer Server Rest Limits Configuration");
    actualDefaultTenantProfileConfiguration.setDefaultStorageTtlDays(1);
    actualDefaultTenantProfileConfiguration.setEdgeEventRateLimits("Edge Event Rate Limits");
    actualDefaultTenantProfileConfiguration.setEdgeEventRateLimitsPerEdge("Edge Event Rate Limits Per Edge");
    actualDefaultTenantProfileConfiguration.setEdgeUplinkMessagesRateLimits("Edge Uplink Messages Rate Limits");
    actualDefaultTenantProfileConfiguration
        .setEdgeUplinkMessagesRateLimitsPerEdge("Edge Uplink Messages Rate Limits Per Edge");
    actualDefaultTenantProfileConfiguration.setMaxAssets(1L);
    actualDefaultTenantProfileConfiguration.setMaxCreatedAlarms(1L);
    actualDefaultTenantProfileConfiguration.setMaxCustomers(1L);
    actualDefaultTenantProfileConfiguration.setMaxDPStorageDays(1L);
    actualDefaultTenantProfileConfiguration.setMaxDashboards(1L);
    actualDefaultTenantProfileConfiguration.setMaxDevices(1L);
    actualDefaultTenantProfileConfiguration.setMaxEmails(1L);
    actualDefaultTenantProfileConfiguration.setMaxJSExecutions(1L);
    actualDefaultTenantProfileConfiguration.setMaxOtaPackagesInBytes(1L);
    actualDefaultTenantProfileConfiguration.setMaxREExecutions(1L);
    actualDefaultTenantProfileConfiguration.setMaxResourceSize(3L);
    actualDefaultTenantProfileConfiguration.setMaxResourcesInBytes(1L);
    actualDefaultTenantProfileConfiguration.setMaxRuleChains(1L);
    actualDefaultTenantProfileConfiguration.setMaxRuleNodeExecutionsPerMessage(3);
    actualDefaultTenantProfileConfiguration.setMaxSms(1L);
    actualDefaultTenantProfileConfiguration.setMaxTbelExecutions(1L);
    actualDefaultTenantProfileConfiguration.setMaxTransportDataPoints(1L);
    actualDefaultTenantProfileConfiguration.setMaxTransportMessages(1L);
    actualDefaultTenantProfileConfiguration.setMaxUsers(1L);
    actualDefaultTenantProfileConfiguration.setMaxWsSessionsPerCustomer(3);
    actualDefaultTenantProfileConfiguration.setMaxWsSessionsPerPublicUser(3);
    actualDefaultTenantProfileConfiguration.setMaxWsSessionsPerRegularUser(3);
    actualDefaultTenantProfileConfiguration.setMaxWsSessionsPerTenant(3);
    actualDefaultTenantProfileConfiguration.setMaxWsSubscriptionsPerCustomer(1L);
    actualDefaultTenantProfileConfiguration.setMaxWsSubscriptionsPerPublicUser(1L);
    actualDefaultTenantProfileConfiguration.setMaxWsSubscriptionsPerRegularUser(1L);
    actualDefaultTenantProfileConfiguration.setMaxWsSubscriptionsPerTenant(1L);
    actualDefaultTenantProfileConfiguration.setQueueStatsTtlDays(1);
    actualDefaultTenantProfileConfiguration.setRpcTtlDays(1);
    actualDefaultTenantProfileConfiguration.setRuleEngineExceptionsTtlDays(1);
    actualDefaultTenantProfileConfiguration.setSmsEnabled(true);
    actualDefaultTenantProfileConfiguration.setTenantEntityExportRateLimit("Tenant Entity Export Rate Limit");
    actualDefaultTenantProfileConfiguration.setTenantEntityImportRateLimit("Tenant Entity Import Rate Limit");
    actualDefaultTenantProfileConfiguration
        .setTenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit");
    actualDefaultTenantProfileConfiguration
        .setTenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit");
    actualDefaultTenantProfileConfiguration
        .setTenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration");
    actualDefaultTenantProfileConfiguration.setTransportDeviceMsgRateLimit("Transport Device Msg Rate Limit");
    actualDefaultTenantProfileConfiguration
        .setTransportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit");
    actualDefaultTenantProfileConfiguration
        .setTransportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit");
    actualDefaultTenantProfileConfiguration
        .setTransportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit");
    actualDefaultTenantProfileConfiguration.setTransportGatewayDeviceTelemetryDataPointsRateLimit(
        "Transport Gateway Device Telemetry Data Points Rate Limit");
    actualDefaultTenantProfileConfiguration
        .setTransportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit");
    actualDefaultTenantProfileConfiguration.setTransportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit");
    actualDefaultTenantProfileConfiguration
        .setTransportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit");
    actualDefaultTenantProfileConfiguration
        .setTransportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit");
    actualDefaultTenantProfileConfiguration.setTransportTenantMsgRateLimit("Transport Tenant Msg Rate Limit");
    actualDefaultTenantProfileConfiguration
        .setTransportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit");
    actualDefaultTenantProfileConfiguration
        .setTransportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit");
    actualDefaultTenantProfileConfiguration.setWarnThreshold(10.0d);
    actualDefaultTenantProfileConfiguration.setWsMsgQueueLimitPerSession(1);
    actualDefaultTenantProfileConfiguration.setWsUpdatesPerSessionRateLimit("2020-03-01");
    String actualToStringResult = actualDefaultTenantProfileConfiguration.toString();
    int actualAlarmsTtlDays = actualDefaultTenantProfileConfiguration.getAlarmsTtlDays();
    String actualCassandraQueryTenantRateLimitsConfiguration = actualDefaultTenantProfileConfiguration
        .getCassandraQueryTenantRateLimitsConfiguration();
    String actualCustomerServerRestLimitsConfiguration = actualDefaultTenantProfileConfiguration
        .getCustomerServerRestLimitsConfiguration();
    int actualDefaultStorageTtlDays = actualDefaultTenantProfileConfiguration.getDefaultStorageTtlDays();
    String actualEdgeEventRateLimits = actualDefaultTenantProfileConfiguration.getEdgeEventRateLimits();
    String actualEdgeEventRateLimitsPerEdge = actualDefaultTenantProfileConfiguration.getEdgeEventRateLimitsPerEdge();
    String actualEdgeUplinkMessagesRateLimits = actualDefaultTenantProfileConfiguration
        .getEdgeUplinkMessagesRateLimits();
    String actualEdgeUplinkMessagesRateLimitsPerEdge = actualDefaultTenantProfileConfiguration
        .getEdgeUplinkMessagesRateLimitsPerEdge();
    long actualMaxAssets = actualDefaultTenantProfileConfiguration.getMaxAssets();
    long actualMaxCreatedAlarms = actualDefaultTenantProfileConfiguration.getMaxCreatedAlarms();
    long actualMaxCustomers = actualDefaultTenantProfileConfiguration.getMaxCustomers();
    long actualMaxDPStorageDays = actualDefaultTenantProfileConfiguration.getMaxDPStorageDays();
    long actualMaxDashboards = actualDefaultTenantProfileConfiguration.getMaxDashboards();
    long actualMaxDevices = actualDefaultTenantProfileConfiguration.getMaxDevices();
    long actualMaxEmails = actualDefaultTenantProfileConfiguration.getMaxEmails();
    long actualMaxJSExecutions = actualDefaultTenantProfileConfiguration.getMaxJSExecutions();
    long actualMaxOtaPackagesInBytes = actualDefaultTenantProfileConfiguration.getMaxOtaPackagesInBytes();
    long actualMaxREExecutions = actualDefaultTenantProfileConfiguration.getMaxREExecutions();
    long actualMaxResourceSize = actualDefaultTenantProfileConfiguration.getMaxResourceSize();
    long actualMaxResourcesInBytes = actualDefaultTenantProfileConfiguration.getMaxResourcesInBytes();
    long actualMaxRuleChains = actualDefaultTenantProfileConfiguration.getMaxRuleChains();
    int actualMaxRuleNodeExecsPerMessage = actualDefaultTenantProfileConfiguration.getMaxRuleNodeExecsPerMessage();
    int actualMaxRuleNodeExecutionsPerMessage = actualDefaultTenantProfileConfiguration
        .getMaxRuleNodeExecutionsPerMessage();
    long actualMaxSms = actualDefaultTenantProfileConfiguration.getMaxSms();
    long actualMaxTbelExecutions = actualDefaultTenantProfileConfiguration.getMaxTbelExecutions();
    long actualMaxTransportDataPoints = actualDefaultTenantProfileConfiguration.getMaxTransportDataPoints();
    long actualMaxTransportMessages = actualDefaultTenantProfileConfiguration.getMaxTransportMessages();
    long actualMaxUsers = actualDefaultTenantProfileConfiguration.getMaxUsers();
    int actualMaxWsSessionsPerCustomer = actualDefaultTenantProfileConfiguration.getMaxWsSessionsPerCustomer();
    int actualMaxWsSessionsPerPublicUser = actualDefaultTenantProfileConfiguration.getMaxWsSessionsPerPublicUser();
    int actualMaxWsSessionsPerRegularUser = actualDefaultTenantProfileConfiguration.getMaxWsSessionsPerRegularUser();
    int actualMaxWsSessionsPerTenant = actualDefaultTenantProfileConfiguration.getMaxWsSessionsPerTenant();
    long actualMaxWsSubscriptionsPerCustomer = actualDefaultTenantProfileConfiguration
        .getMaxWsSubscriptionsPerCustomer();
    long actualMaxWsSubscriptionsPerPublicUser = actualDefaultTenantProfileConfiguration
        .getMaxWsSubscriptionsPerPublicUser();
    long actualMaxWsSubscriptionsPerRegularUser = actualDefaultTenantProfileConfiguration
        .getMaxWsSubscriptionsPerRegularUser();
    long actualMaxWsSubscriptionsPerTenant = actualDefaultTenantProfileConfiguration.getMaxWsSubscriptionsPerTenant();
    int actualQueueStatsTtlDays = actualDefaultTenantProfileConfiguration.getQueueStatsTtlDays();
    int actualRpcTtlDays = actualDefaultTenantProfileConfiguration.getRpcTtlDays();
    int actualRuleEngineExceptionsTtlDays = actualDefaultTenantProfileConfiguration.getRuleEngineExceptionsTtlDays();
    Boolean actualSmsEnabled = actualDefaultTenantProfileConfiguration.getSmsEnabled();
    String actualTenantEntityExportRateLimit = actualDefaultTenantProfileConfiguration.getTenantEntityExportRateLimit();
    String actualTenantEntityImportRateLimit = actualDefaultTenantProfileConfiguration.getTenantEntityImportRateLimit();
    String actualTenantNotificationRequestsPerRuleRateLimit = actualDefaultTenantProfileConfiguration
        .getTenantNotificationRequestsPerRuleRateLimit();
    String actualTenantNotificationRequestsRateLimit = actualDefaultTenantProfileConfiguration
        .getTenantNotificationRequestsRateLimit();
    String actualTenantServerRestLimitsConfiguration = actualDefaultTenantProfileConfiguration
        .getTenantServerRestLimitsConfiguration();
    String actualTransportDeviceMsgRateLimit = actualDefaultTenantProfileConfiguration.getTransportDeviceMsgRateLimit();
    String actualTransportDeviceTelemetryDataPointsRateLimit = actualDefaultTenantProfileConfiguration
        .getTransportDeviceTelemetryDataPointsRateLimit();
    String actualTransportDeviceTelemetryMsgRateLimit = actualDefaultTenantProfileConfiguration
        .getTransportDeviceTelemetryMsgRateLimit();
    String actualTransportGatewayDeviceMsgRateLimit = actualDefaultTenantProfileConfiguration
        .getTransportGatewayDeviceMsgRateLimit();
    String actualTransportGatewayDeviceTelemetryDataPointsRateLimit = actualDefaultTenantProfileConfiguration
        .getTransportGatewayDeviceTelemetryDataPointsRateLimit();
    String actualTransportGatewayDeviceTelemetryMsgRateLimit = actualDefaultTenantProfileConfiguration
        .getTransportGatewayDeviceTelemetryMsgRateLimit();
    String actualTransportGatewayMsgRateLimit = actualDefaultTenantProfileConfiguration
        .getTransportGatewayMsgRateLimit();
    String actualTransportGatewayTelemetryDataPointsRateLimit = actualDefaultTenantProfileConfiguration
        .getTransportGatewayTelemetryDataPointsRateLimit();
    String actualTransportGatewayTelemetryMsgRateLimit = actualDefaultTenantProfileConfiguration
        .getTransportGatewayTelemetryMsgRateLimit();
    String actualTransportTenantMsgRateLimit = actualDefaultTenantProfileConfiguration.getTransportTenantMsgRateLimit();
    String actualTransportTenantTelemetryDataPointsRateLimit = actualDefaultTenantProfileConfiguration
        .getTransportTenantTelemetryDataPointsRateLimit();
    String actualTransportTenantTelemetryMsgRateLimit = actualDefaultTenantProfileConfiguration
        .getTransportTenantTelemetryMsgRateLimit();
    TenantProfileType actualType = actualDefaultTenantProfileConfiguration.getType();
    double actualWarnThreshold = actualDefaultTenantProfileConfiguration.getWarnThreshold();
    int actualWsMsgQueueLimitPerSession = actualDefaultTenantProfileConfiguration.getWsMsgQueueLimitPerSession();

    // Assert that nothing has changed
    assertEquals("2020-03-01", actualDefaultTenantProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals("Cassandra Query Tenant Rate Limits Configuration", actualCassandraQueryTenantRateLimitsConfiguration);
    assertEquals("Customer Server Rest Limits Configuration", actualCustomerServerRestLimitsConfiguration);
    assertEquals(
        "DefaultTenantProfileConfiguration(maxDevices=1, maxAssets=1, maxCustomers=1, maxUsers=1, maxDashboards=1,"
            + " maxRuleChains=1, maxResourcesInBytes=1, maxOtaPackagesInBytes=1, maxResourceSize=3, transportTenant"
            + "MsgRateLimit=Transport Tenant Msg Rate Limit, transportTenantTelemetryMsgRateLimit=Transport Tenant"
            + " Telemetry Msg Rate Limit, transportTenantTelemetryDataPointsRateLimit=Transport Tenant Telemetry Data"
            + " Points Rate Limit, transportDeviceMsgRateLimit=Transport Device Msg Rate Limit, transportDeviceTele"
            + "metryMsgRateLimit=Transport Device Telemetry Msg Rate Limit, transportDeviceTelemetryDataPointsRateLimit"
            + "=Transport Device Telemetry Data Points Rate Limit, transportGatewayMsgRateLimit=Transport Gateway Msg"
            + " Rate Limit, transportGatewayTelemetryMsgRateLimit=Transport Gateway Telemetry Msg Rate Limit,"
            + " transportGatewayTelemetryDataPointsRateLimit=Transport Gateway Telemetry Data Points Rate Limit,"
            + " transportGatewayDeviceMsgRateLimit=Transport Gateway Device Msg Rate Limit, transportGatewayDeviceT"
            + "elemetryMsgRateLimit=Transport Gateway Device Telemetry Msg Rate Limit, transportGatewayDeviceTeleme"
            + "tryDataPointsRateLimit=Transport Gateway Device Telemetry Data Points Rate Limit, tenantEntityExportRateLimit"
            + "=Tenant Entity Export Rate Limit, tenantEntityImportRateLimit=Tenant Entity Import Rate Limit,"
            + " tenantNotificationRequestsRateLimit=Tenant Notification Requests Rate Limit, tenantNotificationRequ"
            + "estsPerRuleRateLimit=Tenant Notification Requests Per Rule Rate Limit, maxTransportMessages=1,"
            + " maxTransportDataPoints=1, maxREExecutions=1, maxJSExecutions=1, maxTbelExecutions=1, maxDPStorageDays=1,"
            + " maxRuleNodeExecutionsPerMessage=3, maxEmails=1, smsEnabled=true, maxSms=1, maxCreatedAlarms=1,"
            + " tenantServerRestLimitsConfiguration=Tenant Server Rest Limits Configuration, customerServerRestLimi"
            + "tsConfiguration=Customer Server Rest Limits Configuration, maxWsSessionsPerTenant=3, maxWsSessionsPerCustomer"
            + "=3, maxWsSessionsPerRegularUser=3, maxWsSessionsPerPublicUser=3, wsMsgQueueLimitPerSession=1,"
            + " maxWsSubscriptionsPerTenant=1, maxWsSubscriptionsPerCustomer=1, maxWsSubscriptionsPerRegularUser=1,"
            + " maxWsSubscriptionsPerPublicUser=1, wsUpdatesPerSessionRateLimit=2020-03-01, cassandraQueryTenantRat"
            + "eLimitsConfiguration=Cassandra Query Tenant Rate Limits Configuration, edgeEventRateLimits=Edge Event"
            + " Rate Limits, edgeEventRateLimitsPerEdge=Edge Event Rate Limits Per Edge, edgeUplinkMessagesRateLimits=Edge"
            + " Uplink Messages Rate Limits, edgeUplinkMessagesRateLimitsPerEdge=Edge Uplink Messages Rate Limits Per"
            + " Edge, defaultStorageTtlDays=1, alarmsTtlDays=1, rpcTtlDays=1, queueStatsTtlDays=1, ruleEngineExcept"
            + "ionsTtlDays=1, warnThreshold=10.0)",
        actualToStringResult);
    assertEquals("Edge Event Rate Limits Per Edge", actualEdgeEventRateLimitsPerEdge);
    assertEquals("Edge Event Rate Limits", actualEdgeEventRateLimits);
    assertEquals("Edge Uplink Messages Rate Limits Per Edge", actualEdgeUplinkMessagesRateLimitsPerEdge);
    assertEquals("Edge Uplink Messages Rate Limits", actualEdgeUplinkMessagesRateLimits);
    assertEquals("Tenant Entity Export Rate Limit", actualTenantEntityExportRateLimit);
    assertEquals("Tenant Entity Import Rate Limit", actualTenantEntityImportRateLimit);
    assertEquals("Tenant Notification Requests Per Rule Rate Limit", actualTenantNotificationRequestsPerRuleRateLimit);
    assertEquals("Tenant Notification Requests Rate Limit", actualTenantNotificationRequestsRateLimit);
    assertEquals("Tenant Server Rest Limits Configuration", actualTenantServerRestLimitsConfiguration);
    assertEquals("Transport Device Msg Rate Limit", actualTransportDeviceMsgRateLimit);
    assertEquals("Transport Device Telemetry Data Points Rate Limit",
        actualTransportDeviceTelemetryDataPointsRateLimit);
    assertEquals("Transport Device Telemetry Msg Rate Limit", actualTransportDeviceTelemetryMsgRateLimit);
    assertEquals("Transport Gateway Device Msg Rate Limit", actualTransportGatewayDeviceMsgRateLimit);
    assertEquals("Transport Gateway Device Telemetry Data Points Rate Limit",
        actualTransportGatewayDeviceTelemetryDataPointsRateLimit);
    assertEquals("Transport Gateway Device Telemetry Msg Rate Limit",
        actualTransportGatewayDeviceTelemetryMsgRateLimit);
    assertEquals("Transport Gateway Msg Rate Limit", actualTransportGatewayMsgRateLimit);
    assertEquals("Transport Gateway Telemetry Data Points Rate Limit",
        actualTransportGatewayTelemetryDataPointsRateLimit);
    assertEquals("Transport Gateway Telemetry Msg Rate Limit", actualTransportGatewayTelemetryMsgRateLimit);
    assertEquals("Transport Tenant Msg Rate Limit", actualTransportTenantMsgRateLimit);
    assertEquals("Transport Tenant Telemetry Data Points Rate Limit",
        actualTransportTenantTelemetryDataPointsRateLimit);
    assertEquals("Transport Tenant Telemetry Msg Rate Limit", actualTransportTenantTelemetryMsgRateLimit);
    assertEquals(1, actualAlarmsTtlDays);
    assertEquals(1, actualDefaultStorageTtlDays);
    assertEquals(1, actualQueueStatsTtlDays);
    assertEquals(1, actualRpcTtlDays);
    assertEquals(1, actualRuleEngineExceptionsTtlDays);
    assertEquals(1, actualWsMsgQueueLimitPerSession);
    assertEquals(10.0d, actualWarnThreshold);
    assertEquals(1L, actualMaxAssets);
    assertEquals(1L, actualMaxCreatedAlarms);
    assertEquals(1L, actualMaxCustomers);
    assertEquals(1L, actualMaxDPStorageDays);
    assertEquals(1L, actualMaxDashboards);
    assertEquals(1L, actualMaxDevices);
    assertEquals(1L, actualMaxEmails);
    assertEquals(1L, actualMaxJSExecutions);
    assertEquals(1L, actualMaxOtaPackagesInBytes);
    assertEquals(1L, actualMaxREExecutions);
    assertEquals(1L, actualMaxResourcesInBytes);
    assertEquals(1L, actualMaxRuleChains);
    assertEquals(1L, actualMaxSms);
    assertEquals(1L, actualMaxTbelExecutions);
    assertEquals(1L, actualMaxTransportDataPoints);
    assertEquals(1L, actualMaxTransportMessages);
    assertEquals(1L, actualMaxUsers);
    assertEquals(1L, actualMaxWsSubscriptionsPerCustomer);
    assertEquals(1L, actualMaxWsSubscriptionsPerPublicUser);
    assertEquals(1L, actualMaxWsSubscriptionsPerRegularUser);
    assertEquals(1L, actualMaxWsSubscriptionsPerTenant);
    assertEquals(3, actualMaxRuleNodeExecsPerMessage);
    assertEquals(3, actualMaxRuleNodeExecutionsPerMessage);
    assertEquals(3, actualMaxWsSessionsPerCustomer);
    assertEquals(3, actualMaxWsSessionsPerPublicUser);
    assertEquals(3, actualMaxWsSessionsPerRegularUser);
    assertEquals(3, actualMaxWsSessionsPerTenant);
    assertEquals(3L, actualMaxResourceSize);
    assertEquals(TenantProfileType.DEFAULT, actualType);
    assertTrue(actualSmsEnabled);
  }

  /**
   * Test
   * {@link DefaultTenantProfileConfiguration#DefaultTenantProfileConfiguration(long, long, long, long, long, long, long, long, long, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, long, long, long, long, long, long, int, long, Boolean, long, long, String, String, int, int, int, int, int, long, long, long, long, String, String, String, String, String, String, int, int, int, int, int, double)}.
   * <p>
   * Method under test:
   * {@link DefaultTenantProfileConfiguration#DefaultTenantProfileConfiguration(long, long, long, long, long, long, long, long, long, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, long, long, long, long, long, long, int, long, Boolean, long, long, String, String, int, int, int, int, int, long, long, long, long, String, String, String, String, String, String, int, int, int, int, int, double)}
   */
  @Test
  @DisplayName("Test new DefaultTenantProfileConfiguration(long, long, long, long, long, long, long, long, long, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, long, long, long, long, long, long, int, long, Boolean, long, long, String, String, int, int, int, int, int, long, long, long, long, String, String, String, String, String, String, int, int, int, int, int, double)")
  void testNewDefaultTenantProfileConfiguration() {
    // Arrange and Act
    DefaultTenantProfileConfiguration actualDefaultTenantProfileConfiguration = new DefaultTenantProfileConfiguration(
        1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 3L, "Transport Tenant Msg Rate Limit",
        "Transport Tenant Telemetry Msg Rate Limit", "Transport Tenant Telemetry Data Points Rate Limit",
        "Transport Device Msg Rate Limit", "Transport Device Telemetry Msg Rate Limit",
        "Transport Device Telemetry Data Points Rate Limit", "Transport Gateway Msg Rate Limit",
        "Transport Gateway Telemetry Msg Rate Limit", "Transport Gateway Telemetry Data Points Rate Limit",
        "Transport Gateway Device Msg Rate Limit", "Transport Gateway Device Telemetry Msg Rate Limit",
        "Transport Gateway Device Telemetry Data Points Rate Limit", "Tenant Entity Export Rate Limit",
        "Tenant Entity Import Rate Limit", "Tenant Notification Requests Rate Limit",
        "Tenant Notification Requests Per Rule Rate Limit", 1L, 1L, 1L, 1L, 1L, 1L, 3, 1L, true, 1L, 1L,
        "Tenant Server Rest Limits Configuration", "Customer Server Rest Limits Configuration", 3, 3, 3, 3, 1, 1L, 1L,
        1L, 1L, "2020-03-01", "Cassandra Query Tenant Rate Limits Configuration", "Edge Event Rate Limits",
        "Edge Event Rate Limits Per Edge", "Edge Uplink Messages Rate Limits",
        "Edge Uplink Messages Rate Limits Per Edge", 1, 1, 1, 1, 1, 10.0d);

    // Assert
    assertEquals("2020-03-01", actualDefaultTenantProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals("Cassandra Query Tenant Rate Limits Configuration",
        actualDefaultTenantProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertEquals("Customer Server Rest Limits Configuration",
        actualDefaultTenantProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertEquals("Edge Event Rate Limits Per Edge",
        actualDefaultTenantProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertEquals("Edge Event Rate Limits", actualDefaultTenantProfileConfiguration.getEdgeEventRateLimits());
    assertEquals("Edge Uplink Messages Rate Limits Per Edge",
        actualDefaultTenantProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertEquals("Edge Uplink Messages Rate Limits",
        actualDefaultTenantProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertEquals("Tenant Entity Export Rate Limit",
        actualDefaultTenantProfileConfiguration.getTenantEntityExportRateLimit());
    assertEquals("Tenant Entity Import Rate Limit",
        actualDefaultTenantProfileConfiguration.getTenantEntityImportRateLimit());
    assertEquals("Tenant Notification Requests Per Rule Rate Limit",
        actualDefaultTenantProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertEquals("Tenant Notification Requests Rate Limit",
        actualDefaultTenantProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertEquals("Tenant Server Rest Limits Configuration",
        actualDefaultTenantProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertEquals("Transport Device Msg Rate Limit",
        actualDefaultTenantProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertEquals("Transport Device Telemetry Data Points Rate Limit",
        actualDefaultTenantProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertEquals("Transport Device Telemetry Msg Rate Limit",
        actualDefaultTenantProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertEquals("Transport Gateway Device Msg Rate Limit",
        actualDefaultTenantProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertEquals("Transport Gateway Device Telemetry Data Points Rate Limit",
        actualDefaultTenantProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertEquals("Transport Gateway Device Telemetry Msg Rate Limit",
        actualDefaultTenantProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertEquals("Transport Gateway Msg Rate Limit",
        actualDefaultTenantProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertEquals("Transport Gateway Telemetry Data Points Rate Limit",
        actualDefaultTenantProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertEquals("Transport Gateway Telemetry Msg Rate Limit",
        actualDefaultTenantProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertEquals("Transport Tenant Msg Rate Limit",
        actualDefaultTenantProfileConfiguration.getTransportTenantMsgRateLimit());
    assertEquals("Transport Tenant Telemetry Data Points Rate Limit",
        actualDefaultTenantProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertEquals("Transport Tenant Telemetry Msg Rate Limit",
        actualDefaultTenantProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertEquals(1, actualDefaultTenantProfileConfiguration.getAlarmsTtlDays());
    assertEquals(1, actualDefaultTenantProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(1, actualDefaultTenantProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(1, actualDefaultTenantProfileConfiguration.getRpcTtlDays());
    assertEquals(1, actualDefaultTenantProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(1, actualDefaultTenantProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(10.0d, actualDefaultTenantProfileConfiguration.getWarnThreshold());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxAssets());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxCustomers());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxDPStorageDays());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxDashboards());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxDevices());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxEmails());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxJSExecutions());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxREExecutions());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxRuleChains());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxSms());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxTbelExecutions());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxTransportMessages());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxUsers());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(1L, actualDefaultTenantProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(3, actualDefaultTenantProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(3, actualDefaultTenantProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(3, actualDefaultTenantProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(3, actualDefaultTenantProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(3, actualDefaultTenantProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(3, actualDefaultTenantProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(3L, actualDefaultTenantProfileConfiguration.getMaxResourceSize());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultTenantProfileConfiguration.getType());
    assertTrue(actualDefaultTenantProfileConfiguration.getSmsEnabled());
  }
}
