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
package org.thingsboard.server.common.data.tenant.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.queue.ProcessingStrategy;
import org.thingsboard.server.common.data.queue.ProcessingStrategyType;
import org.thingsboard.server.common.data.queue.SubmitStrategy;
import org.thingsboard.server.common.data.queue.SubmitStrategyType;

class TenantProfileDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileData#equals(Object)}
   *   <li>{@link TenantProfileData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantProfileData tenantProfileData2 = new TenantProfileData();
    tenantProfileData2.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData2.setQueueConfiguration(new ArrayList<>());

    // Act and Assert
    assertEquals(tenantProfileData, tenantProfileData2);
    int expectedHashCodeResult = tenantProfileData.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileData#equals(Object)}
   *   <li>{@link TenantProfileData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    // Act and Assert
    assertEquals(tenantProfileData, tenantProfileData);
    int expectedHashCodeResult = tenantProfileData.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileData.hashCode());
  }

  /**
   * Method under test: {@link TenantProfileData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantProfileData tenantProfileData = new TenantProfileData();
    DefaultTenantProfileConfiguration configuration = DefaultTenantProfileConfiguration.builder()
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
    tenantProfileData.setConfiguration(configuration);
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantProfileData tenantProfileData2 = new TenantProfileData();
    tenantProfileData2.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData2.setQueueConfiguration(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tenantProfileData, tenantProfileData2);
  }

  /**
   * Method under test: {@link TenantProfileData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(null);
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantProfileData tenantProfileData2 = new TenantProfileData();
    tenantProfileData2.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData2.setQueueConfiguration(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tenantProfileData, tenantProfileData2);
  }

  /**
   * Method under test: {@link TenantProfileData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(mock(DefaultTenantProfileConfiguration.class));
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantProfileData tenantProfileData2 = new TenantProfileData();
    tenantProfileData2.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData2.setQueueConfiguration(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tenantProfileData, tenantProfileData2);
  }

  /**
   * Method under test: {@link TenantProfileData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ArrayList<TenantProfileQueueConfiguration> queueConfiguration = new ArrayList<>();
    queueConfiguration.add(tenantProfileQueueConfiguration);

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(queueConfiguration);

    TenantProfileData tenantProfileData2 = new TenantProfileData();
    tenantProfileData2.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData2.setQueueConfiguration(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tenantProfileData, tenantProfileData2);
  }

  /**
   * Method under test: {@link TenantProfileData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tenantProfileData, null);
  }

  /**
   * Method under test: {@link TenantProfileData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tenantProfileData, "Different type to TenantProfileData");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TenantProfileData}
   *   <li>{@link TenantProfileData#setConfiguration(TenantProfileConfiguration)}
   *   <li>{@link TenantProfileData#setQueueConfiguration(List)}
   *   <li>{@link TenantProfileData#toString()}
   *   <li>{@link TenantProfileData#getConfiguration()}
   *   <li>{@link TenantProfileData#getQueueConfiguration()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TenantProfileData actualTenantProfileData = new TenantProfileData();
    DefaultTenantProfileConfiguration configuration = new DefaultTenantProfileConfiguration();
    actualTenantProfileData.setConfiguration(configuration);
    ArrayList<TenantProfileQueueConfiguration> queueConfiguration = new ArrayList<>();
    actualTenantProfileData.setQueueConfiguration(queueConfiguration);
    String actualToStringResult = actualTenantProfileData.toString();
    TenantProfileConfiguration actualConfiguration = actualTenantProfileData.getConfiguration();
    List<TenantProfileQueueConfiguration> actualQueueConfiguration = actualTenantProfileData.getQueueConfiguration();

    // Assert that nothing has changed
    assertEquals(
        "TenantProfileData(configuration=DefaultTenantProfileConfiguration(maxDevices=0, maxAssets=0, maxCustomers=0,"
            + " maxUsers=0, maxDashboards=0, maxRuleChains=0, maxResourcesInBytes=0, maxOtaPackagesInBytes=0,"
            + " maxResourceSize=0, transportTenantMsgRateLimit=null, transportTenantTelemetryMsgRateLimit=null,"
            + " transportTenantTelemetryDataPointsRateLimit=null, transportDeviceMsgRateLimit=null, transportDevice"
            + "TelemetryMsgRateLimit=null, transportDeviceTelemetryDataPointsRateLimit=null, transportGatewayMsgRateLimit"
            + "=null, transportGatewayTelemetryMsgRateLimit=null, transportGatewayTelemetryDataPointsRateLimit=null,"
            + " transportGatewayDeviceMsgRateLimit=null, transportGatewayDeviceTelemetryMsgRateLimit=null,"
            + " transportGatewayDeviceTelemetryDataPointsRateLimit=null, tenantEntityExportRateLimit=null,"
            + " tenantEntityImportRateLimit=null, tenantNotificationRequestsRateLimit=null, tenantNotificationReque"
            + "stsPerRuleRateLimit=null, maxTransportMessages=0, maxTransportDataPoints=0, maxREExecutions=0,"
            + " maxJSExecutions=0, maxTbelExecutions=0, maxDPStorageDays=0, maxRuleNodeExecutionsPerMessage=0,"
            + " maxEmails=0, smsEnabled=null, maxSms=0, maxCreatedAlarms=0, tenantServerRestLimitsConfiguration=null,"
            + " customerServerRestLimitsConfiguration=null, maxWsSessionsPerTenant=0, maxWsSessionsPerCustomer=0,"
            + " maxWsSessionsPerRegularUser=0, maxWsSessionsPerPublicUser=0, wsMsgQueueLimitPerSession=0, maxWsSubs"
            + "criptionsPerTenant=0, maxWsSubscriptionsPerCustomer=0, maxWsSubscriptionsPerRegularUser=0, maxWsSubs"
            + "criptionsPerPublicUser=0, wsUpdatesPerSessionRateLimit=null, cassandraQueryTenantRateLimitsConfiguration"
            + "=null, edgeEventRateLimits=null, edgeEventRateLimitsPerEdge=null, edgeUplinkMessagesRateLimits=null,"
            + " edgeUplinkMessagesRateLimitsPerEdge=null, defaultStorageTtlDays=0, alarmsTtlDays=0, rpcTtlDays=0,"
            + " queueStatsTtlDays=0, ruleEngineExceptionsTtlDays=0, warnThreshold=0.0), queueConfiguration=[])",
        actualToStringResult);
    assertTrue(actualQueueConfiguration.isEmpty());
    assertSame(queueConfiguration, actualQueueConfiguration);
    assertSame(configuration, actualConfiguration);
  }
}
