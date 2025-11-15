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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.queue.ProcessingStrategy;
import org.thingsboard.server.common.data.queue.ProcessingStrategyType;
import org.thingsboard.server.common.data.queue.SubmitStrategy;
import org.thingsboard.server.common.data.queue.SubmitStrategyType;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;

class TenantProfileDiffblueTest {
  /**
   * Method under test: {@link TenantProfile#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new TenantProfile()).getId());
  }

  /**
   * Method under test: {@link TenantProfile#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TenantProfile()).getCreatedTime());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  void testGetProfileData() {
    // Arrange and Act
    TenantProfileData actualProfileData = (new TenantProfile()).getProfileData();

    // Assert
    TenantProfileConfiguration configuration = actualProfileData.getConfiguration();
    assertTrue(configuration instanceof DefaultTenantProfileConfiguration);
    assertNull(((DefaultTenantProfileConfiguration) configuration).getSmsEnabled());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCustomerServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityExportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityImportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        ((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getWsUpdatesPerSessionRateLimit());
    assertNull(actualProfileData.getQueueConfiguration());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getAlarmsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getDefaultStorageTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerCustomer());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerPublicUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerRegularUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerTenant());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getQueueStatsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRpcTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRuleEngineExceptionsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getWsMsgQueueLimitPerSession());
    assertEquals(0, configuration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0.0d, ((DefaultTenantProfileConfiguration) configuration).getWarnThreshold());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxAssets());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCreatedAlarms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCustomers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDPStorageDays());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDashboards());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDevices());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxEmails());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxJSExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxOtaPackagesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxREExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourceSize());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourcesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleChains());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxSms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTbelExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportDataPoints());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportMessages());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxUsers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, configuration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  void testGetProfileData2() {
    // Arrange and Act
    TenantProfileData actualProfileData = (new TenantProfile(new TenantProfile())).getProfileData();

    // Assert
    TenantProfileConfiguration configuration = actualProfileData.getConfiguration();
    assertTrue(configuration instanceof DefaultTenantProfileConfiguration);
    assertNull(((DefaultTenantProfileConfiguration) configuration).getSmsEnabled());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCustomerServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityExportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityImportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        ((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getWsUpdatesPerSessionRateLimit());
    assertNull(actualProfileData.getQueueConfiguration());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getAlarmsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getDefaultStorageTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerCustomer());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerPublicUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerRegularUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerTenant());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getQueueStatsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRpcTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRuleEngineExceptionsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getWsMsgQueueLimitPerSession());
    assertEquals(0, configuration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0.0d, ((DefaultTenantProfileConfiguration) configuration).getWarnThreshold());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxAssets());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCreatedAlarms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCustomers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDPStorageDays());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDashboards());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDevices());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxEmails());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxJSExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxOtaPackagesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxREExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourceSize());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourcesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleChains());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxSms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTbelExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportDataPoints());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportMessages());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxUsers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, configuration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  void testGetProfileData3() throws UnsupportedEncodingException {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    TenantProfileConfiguration configuration = actualProfileData.getConfiguration();
    assertTrue(configuration instanceof DefaultTenantProfileConfiguration);
    assertNull(((DefaultTenantProfileConfiguration) configuration).getSmsEnabled());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCustomerServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityExportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityImportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        ((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getWsUpdatesPerSessionRateLimit());
    assertNull(actualProfileData.getQueueConfiguration());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getAlarmsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getDefaultStorageTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerCustomer());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerPublicUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerRegularUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerTenant());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getQueueStatsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRpcTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRuleEngineExceptionsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getWsMsgQueueLimitPerSession());
    assertEquals(0, configuration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0.0d, ((DefaultTenantProfileConfiguration) configuration).getWarnThreshold());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxAssets());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCreatedAlarms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCustomers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDPStorageDays());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDashboards());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDevices());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxEmails());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxJSExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxOtaPackagesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxREExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourceSize());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourcesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleChains());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxSms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTbelExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportDataPoints());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportMessages());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxUsers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, configuration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  void testGetProfileData4() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    TenantProfileConfiguration configuration = actualProfileData.getConfiguration();
    assertTrue(configuration instanceof DefaultTenantProfileConfiguration);
    assertNull(((DefaultTenantProfileConfiguration) configuration).getSmsEnabled());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCustomerServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityExportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityImportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        ((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getWsUpdatesPerSessionRateLimit());
    assertNull(actualProfileData.getQueueConfiguration());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getAlarmsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getDefaultStorageTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerCustomer());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerPublicUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerRegularUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerTenant());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getQueueStatsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRpcTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRuleEngineExceptionsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getWsMsgQueueLimitPerSession());
    assertEquals(0, configuration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0.0d, ((DefaultTenantProfileConfiguration) configuration).getWarnThreshold());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxAssets());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCreatedAlarms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCustomers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDPStorageDays());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDashboards());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDevices());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxEmails());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxJSExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxOtaPackagesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxREExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourceSize());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourcesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleChains());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxSms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTbelExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportDataPoints());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportMessages());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxUsers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, configuration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  void testGetProfileData5() throws UnsupportedEncodingException {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(";XAXAXAX".getBytes("UTF-8"));

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    TenantProfileConfiguration configuration = actualProfileData.getConfiguration();
    assertTrue(configuration instanceof DefaultTenantProfileConfiguration);
    assertNull(((DefaultTenantProfileConfiguration) configuration).getSmsEnabled());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCustomerServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityExportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityImportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        ((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getWsUpdatesPerSessionRateLimit());
    assertNull(actualProfileData.getQueueConfiguration());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getAlarmsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getDefaultStorageTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerCustomer());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerPublicUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerRegularUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerTenant());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getQueueStatsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRpcTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRuleEngineExceptionsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getWsMsgQueueLimitPerSession());
    assertEquals(0, configuration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0.0d, ((DefaultTenantProfileConfiguration) configuration).getWarnThreshold());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxAssets());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCreatedAlarms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCustomers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDPStorageDays());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDashboards());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDevices());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxEmails());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxJSExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxOtaPackagesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxREExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourceSize());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourcesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleChains());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxSms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTbelExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportDataPoints());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportMessages());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxUsers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, configuration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  void testGetProfileData6() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    TenantProfileConfiguration configuration = actualProfileData.getConfiguration();
    assertTrue(configuration instanceof DefaultTenantProfileConfiguration);
    assertNull(((DefaultTenantProfileConfiguration) configuration).getSmsEnabled());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCustomerServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityExportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityImportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        ((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getWsUpdatesPerSessionRateLimit());
    assertNull(actualProfileData.getQueueConfiguration());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getAlarmsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getDefaultStorageTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerCustomer());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerPublicUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerRegularUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerTenant());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getQueueStatsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRpcTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRuleEngineExceptionsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getWsMsgQueueLimitPerSession());
    assertEquals(0, configuration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0.0d, ((DefaultTenantProfileConfiguration) configuration).getWarnThreshold());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxAssets());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCreatedAlarms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCustomers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDPStorageDays());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDashboards());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDevices());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxEmails());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxJSExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxOtaPackagesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxREExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourceSize());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourcesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleChains());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxSms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTbelExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportDataPoints());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportMessages());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxUsers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, configuration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  void testGetProfileData7() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{});

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    TenantProfileConfiguration configuration = actualProfileData.getConfiguration();
    assertTrue(configuration instanceof DefaultTenantProfileConfiguration);
    assertNull(((DefaultTenantProfileConfiguration) configuration).getSmsEnabled());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCustomerServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityExportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityImportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        ((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getWsUpdatesPerSessionRateLimit());
    assertNull(actualProfileData.getQueueConfiguration());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getAlarmsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getDefaultStorageTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerCustomer());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerPublicUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerRegularUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerTenant());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getQueueStatsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRpcTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRuleEngineExceptionsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getWsMsgQueueLimitPerSession());
    assertEquals(0, configuration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0.0d, ((DefaultTenantProfileConfiguration) configuration).getWarnThreshold());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxAssets());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCreatedAlarms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCustomers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDPStorageDays());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDashboards());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDevices());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxEmails());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxJSExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxOtaPackagesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxREExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourceSize());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourcesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleChains());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxSms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTbelExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportDataPoints());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportMessages());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxUsers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, configuration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  void testGetProfileData8() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    TenantProfileConfiguration configuration = actualProfileData.getConfiguration();
    assertTrue(configuration instanceof DefaultTenantProfileConfiguration);
    assertNull(((DefaultTenantProfileConfiguration) configuration).getSmsEnabled());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCustomerServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityExportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityImportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        ((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getWsUpdatesPerSessionRateLimit());
    assertNull(actualProfileData.getQueueConfiguration());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getAlarmsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getDefaultStorageTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerCustomer());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerPublicUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerRegularUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerTenant());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getQueueStatsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRpcTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRuleEngineExceptionsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getWsMsgQueueLimitPerSession());
    assertEquals(0, configuration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0.0d, ((DefaultTenantProfileConfiguration) configuration).getWarnThreshold());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxAssets());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCreatedAlarms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCustomers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDPStorageDays());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDashboards());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDevices());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxEmails());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxJSExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxOtaPackagesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxREExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourceSize());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourcesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleChains());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxSms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTbelExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportDataPoints());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportMessages());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxUsers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, configuration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileData()}
   */
  @Test
  void testGetProfileData9() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'});

    // Act
    TenantProfileData actualProfileData = tenantProfile.getProfileData();

    // Assert
    TenantProfileConfiguration configuration = actualProfileData.getConfiguration();
    assertTrue(configuration instanceof DefaultTenantProfileConfiguration);
    assertNull(((DefaultTenantProfileConfiguration) configuration).getSmsEnabled());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCustomerServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityExportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityImportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        ((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getWsUpdatesPerSessionRateLimit());
    assertNull(actualProfileData.getQueueConfiguration());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getAlarmsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getDefaultStorageTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerCustomer());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerPublicUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerRegularUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerTenant());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getQueueStatsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRpcTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRuleEngineExceptionsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getWsMsgQueueLimitPerSession());
    assertEquals(0, configuration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0.0d, ((DefaultTenantProfileConfiguration) configuration).getWarnThreshold());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxAssets());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCreatedAlarms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCustomers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDPStorageDays());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDashboards());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDevices());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxEmails());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxJSExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxOtaPackagesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxREExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourceSize());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourcesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleChains());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxSms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTbelExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportDataPoints());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportMessages());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxUsers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, configuration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  void testGetProfileConfiguration() {
    // Arrange and Act
    Optional<DefaultTenantProfileConfiguration> actualProfileConfiguration = (new TenantProfile())
        .getProfileConfiguration();

    // Assert
    DefaultTenantProfileConfiguration getResult = actualProfileConfiguration.get();
    assertNull(getResult.getSmsEnabled());
    assertNull(getResult.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(getResult.getCustomerServerRestLimitsConfiguration());
    assertNull(getResult.getEdgeEventRateLimits());
    assertNull(getResult.getEdgeEventRateLimitsPerEdge());
    assertNull(getResult.getEdgeUplinkMessagesRateLimits());
    assertNull(getResult.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(getResult.getTenantEntityExportRateLimit());
    assertNull(getResult.getTenantEntityImportRateLimit());
    assertNull(getResult.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(getResult.getTenantNotificationRequestsRateLimit());
    assertNull(getResult.getTenantServerRestLimitsConfiguration());
    assertNull(getResult.getTransportDeviceMsgRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayMsgRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(getResult.getTransportTenantMsgRateLimit());
    assertNull(getResult.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportTenantTelemetryMsgRateLimit());
    assertNull(getResult.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, getResult.getAlarmsTtlDays());
    assertEquals(0, getResult.getDefaultStorageTtlDays());
    assertEquals(0, getResult.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, getResult.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, getResult.getMaxWsSessionsPerCustomer());
    assertEquals(0, getResult.getMaxWsSessionsPerPublicUser());
    assertEquals(0, getResult.getMaxWsSessionsPerRegularUser());
    assertEquals(0, getResult.getMaxWsSessionsPerTenant());
    assertEquals(0, getResult.getQueueStatsTtlDays());
    assertEquals(0, getResult.getRpcTtlDays());
    assertEquals(0, getResult.getRuleEngineExceptionsTtlDays());
    assertEquals(0, getResult.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, getResult.getWarnThreshold());
    assertEquals(0L, getResult.getMaxAssets());
    assertEquals(0L, getResult.getMaxCreatedAlarms());
    assertEquals(0L, getResult.getMaxCustomers());
    assertEquals(0L, getResult.getMaxDPStorageDays());
    assertEquals(0L, getResult.getMaxDashboards());
    assertEquals(0L, getResult.getMaxDevices());
    assertEquals(0L, getResult.getMaxEmails());
    assertEquals(0L, getResult.getMaxJSExecutions());
    assertEquals(0L, getResult.getMaxOtaPackagesInBytes());
    assertEquals(0L, getResult.getMaxREExecutions());
    assertEquals(0L, getResult.getMaxResourceSize());
    assertEquals(0L, getResult.getMaxResourcesInBytes());
    assertEquals(0L, getResult.getMaxRuleChains());
    assertEquals(0L, getResult.getMaxSms());
    assertEquals(0L, getResult.getMaxTbelExecutions());
    assertEquals(0L, getResult.getMaxTransportDataPoints());
    assertEquals(0L, getResult.getMaxTransportMessages());
    assertEquals(0L, getResult.getMaxUsers());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, getResult.getType());
    assertTrue(actualProfileConfiguration.isPresent());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  void testGetProfileConfiguration2() {
    // Arrange and Act
    Optional<DefaultTenantProfileConfiguration> actualProfileConfiguration = (new TenantProfile(new TenantProfile()))
        .getProfileConfiguration();

    // Assert
    DefaultTenantProfileConfiguration getResult = actualProfileConfiguration.get();
    assertNull(getResult.getSmsEnabled());
    assertNull(getResult.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(getResult.getCustomerServerRestLimitsConfiguration());
    assertNull(getResult.getEdgeEventRateLimits());
    assertNull(getResult.getEdgeEventRateLimitsPerEdge());
    assertNull(getResult.getEdgeUplinkMessagesRateLimits());
    assertNull(getResult.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(getResult.getTenantEntityExportRateLimit());
    assertNull(getResult.getTenantEntityImportRateLimit());
    assertNull(getResult.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(getResult.getTenantNotificationRequestsRateLimit());
    assertNull(getResult.getTenantServerRestLimitsConfiguration());
    assertNull(getResult.getTransportDeviceMsgRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayMsgRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(getResult.getTransportTenantMsgRateLimit());
    assertNull(getResult.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportTenantTelemetryMsgRateLimit());
    assertNull(getResult.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, getResult.getAlarmsTtlDays());
    assertEquals(0, getResult.getDefaultStorageTtlDays());
    assertEquals(0, getResult.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, getResult.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, getResult.getMaxWsSessionsPerCustomer());
    assertEquals(0, getResult.getMaxWsSessionsPerPublicUser());
    assertEquals(0, getResult.getMaxWsSessionsPerRegularUser());
    assertEquals(0, getResult.getMaxWsSessionsPerTenant());
    assertEquals(0, getResult.getQueueStatsTtlDays());
    assertEquals(0, getResult.getRpcTtlDays());
    assertEquals(0, getResult.getRuleEngineExceptionsTtlDays());
    assertEquals(0, getResult.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, getResult.getWarnThreshold());
    assertEquals(0L, getResult.getMaxAssets());
    assertEquals(0L, getResult.getMaxCreatedAlarms());
    assertEquals(0L, getResult.getMaxCustomers());
    assertEquals(0L, getResult.getMaxDPStorageDays());
    assertEquals(0L, getResult.getMaxDashboards());
    assertEquals(0L, getResult.getMaxDevices());
    assertEquals(0L, getResult.getMaxEmails());
    assertEquals(0L, getResult.getMaxJSExecutions());
    assertEquals(0L, getResult.getMaxOtaPackagesInBytes());
    assertEquals(0L, getResult.getMaxREExecutions());
    assertEquals(0L, getResult.getMaxResourceSize());
    assertEquals(0L, getResult.getMaxResourcesInBytes());
    assertEquals(0L, getResult.getMaxRuleChains());
    assertEquals(0L, getResult.getMaxSms());
    assertEquals(0L, getResult.getMaxTbelExecutions());
    assertEquals(0L, getResult.getMaxTransportDataPoints());
    assertEquals(0L, getResult.getMaxTransportMessages());
    assertEquals(0L, getResult.getMaxUsers());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, getResult.getType());
    assertTrue(actualProfileConfiguration.isPresent());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  void testGetProfileConfiguration3() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    Optional<DefaultTenantProfileConfiguration> actualProfileConfiguration = tenantProfile.getProfileConfiguration();

    // Assert
    DefaultTenantProfileConfiguration getResult = actualProfileConfiguration.get();
    assertNull(getResult.getSmsEnabled());
    assertNull(getResult.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(getResult.getCustomerServerRestLimitsConfiguration());
    assertNull(getResult.getEdgeEventRateLimits());
    assertNull(getResult.getEdgeEventRateLimitsPerEdge());
    assertNull(getResult.getEdgeUplinkMessagesRateLimits());
    assertNull(getResult.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(getResult.getTenantEntityExportRateLimit());
    assertNull(getResult.getTenantEntityImportRateLimit());
    assertNull(getResult.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(getResult.getTenantNotificationRequestsRateLimit());
    assertNull(getResult.getTenantServerRestLimitsConfiguration());
    assertNull(getResult.getTransportDeviceMsgRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayMsgRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(getResult.getTransportTenantMsgRateLimit());
    assertNull(getResult.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportTenantTelemetryMsgRateLimit());
    assertNull(getResult.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, getResult.getAlarmsTtlDays());
    assertEquals(0, getResult.getDefaultStorageTtlDays());
    assertEquals(0, getResult.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, getResult.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, getResult.getMaxWsSessionsPerCustomer());
    assertEquals(0, getResult.getMaxWsSessionsPerPublicUser());
    assertEquals(0, getResult.getMaxWsSessionsPerRegularUser());
    assertEquals(0, getResult.getMaxWsSessionsPerTenant());
    assertEquals(0, getResult.getQueueStatsTtlDays());
    assertEquals(0, getResult.getRpcTtlDays());
    assertEquals(0, getResult.getRuleEngineExceptionsTtlDays());
    assertEquals(0, getResult.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, getResult.getWarnThreshold());
    assertEquals(0L, getResult.getMaxAssets());
    assertEquals(0L, getResult.getMaxCreatedAlarms());
    assertEquals(0L, getResult.getMaxCustomers());
    assertEquals(0L, getResult.getMaxDPStorageDays());
    assertEquals(0L, getResult.getMaxDashboards());
    assertEquals(0L, getResult.getMaxDevices());
    assertEquals(0L, getResult.getMaxEmails());
    assertEquals(0L, getResult.getMaxJSExecutions());
    assertEquals(0L, getResult.getMaxOtaPackagesInBytes());
    assertEquals(0L, getResult.getMaxREExecutions());
    assertEquals(0L, getResult.getMaxResourceSize());
    assertEquals(0L, getResult.getMaxResourcesInBytes());
    assertEquals(0L, getResult.getMaxRuleChains());
    assertEquals(0L, getResult.getMaxSms());
    assertEquals(0L, getResult.getMaxTbelExecutions());
    assertEquals(0L, getResult.getMaxTransportDataPoints());
    assertEquals(0L, getResult.getMaxTransportMessages());
    assertEquals(0L, getResult.getMaxUsers());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, getResult.getType());
    assertTrue(actualProfileConfiguration.isPresent());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  void testGetProfileConfiguration4() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{3, 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    Optional<DefaultTenantProfileConfiguration> actualProfileConfiguration = tenantProfile.getProfileConfiguration();

    // Assert
    DefaultTenantProfileConfiguration getResult = actualProfileConfiguration.get();
    assertNull(getResult.getSmsEnabled());
    assertNull(getResult.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(getResult.getCustomerServerRestLimitsConfiguration());
    assertNull(getResult.getEdgeEventRateLimits());
    assertNull(getResult.getEdgeEventRateLimitsPerEdge());
    assertNull(getResult.getEdgeUplinkMessagesRateLimits());
    assertNull(getResult.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(getResult.getTenantEntityExportRateLimit());
    assertNull(getResult.getTenantEntityImportRateLimit());
    assertNull(getResult.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(getResult.getTenantNotificationRequestsRateLimit());
    assertNull(getResult.getTenantServerRestLimitsConfiguration());
    assertNull(getResult.getTransportDeviceMsgRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayMsgRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(getResult.getTransportTenantMsgRateLimit());
    assertNull(getResult.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportTenantTelemetryMsgRateLimit());
    assertNull(getResult.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, getResult.getAlarmsTtlDays());
    assertEquals(0, getResult.getDefaultStorageTtlDays());
    assertEquals(0, getResult.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, getResult.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, getResult.getMaxWsSessionsPerCustomer());
    assertEquals(0, getResult.getMaxWsSessionsPerPublicUser());
    assertEquals(0, getResult.getMaxWsSessionsPerRegularUser());
    assertEquals(0, getResult.getMaxWsSessionsPerTenant());
    assertEquals(0, getResult.getQueueStatsTtlDays());
    assertEquals(0, getResult.getRpcTtlDays());
    assertEquals(0, getResult.getRuleEngineExceptionsTtlDays());
    assertEquals(0, getResult.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, getResult.getWarnThreshold());
    assertEquals(0L, getResult.getMaxAssets());
    assertEquals(0L, getResult.getMaxCreatedAlarms());
    assertEquals(0L, getResult.getMaxCustomers());
    assertEquals(0L, getResult.getMaxDPStorageDays());
    assertEquals(0L, getResult.getMaxDashboards());
    assertEquals(0L, getResult.getMaxDevices());
    assertEquals(0L, getResult.getMaxEmails());
    assertEquals(0L, getResult.getMaxJSExecutions());
    assertEquals(0L, getResult.getMaxOtaPackagesInBytes());
    assertEquals(0L, getResult.getMaxREExecutions());
    assertEquals(0L, getResult.getMaxResourceSize());
    assertEquals(0L, getResult.getMaxResourcesInBytes());
    assertEquals(0L, getResult.getMaxRuleChains());
    assertEquals(0L, getResult.getMaxSms());
    assertEquals(0L, getResult.getMaxTbelExecutions());
    assertEquals(0L, getResult.getMaxTransportDataPoints());
    assertEquals(0L, getResult.getMaxTransportMessages());
    assertEquals(0L, getResult.getMaxUsers());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, getResult.getType());
    assertTrue(actualProfileConfiguration.isPresent());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  void testGetProfileConfiguration5() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{0, 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    Optional<DefaultTenantProfileConfiguration> actualProfileConfiguration = tenantProfile.getProfileConfiguration();

    // Assert
    DefaultTenantProfileConfiguration getResult = actualProfileConfiguration.get();
    assertNull(getResult.getSmsEnabled());
    assertNull(getResult.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(getResult.getCustomerServerRestLimitsConfiguration());
    assertNull(getResult.getEdgeEventRateLimits());
    assertNull(getResult.getEdgeEventRateLimitsPerEdge());
    assertNull(getResult.getEdgeUplinkMessagesRateLimits());
    assertNull(getResult.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(getResult.getTenantEntityExportRateLimit());
    assertNull(getResult.getTenantEntityImportRateLimit());
    assertNull(getResult.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(getResult.getTenantNotificationRequestsRateLimit());
    assertNull(getResult.getTenantServerRestLimitsConfiguration());
    assertNull(getResult.getTransportDeviceMsgRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayMsgRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(getResult.getTransportTenantMsgRateLimit());
    assertNull(getResult.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportTenantTelemetryMsgRateLimit());
    assertNull(getResult.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, getResult.getAlarmsTtlDays());
    assertEquals(0, getResult.getDefaultStorageTtlDays());
    assertEquals(0, getResult.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, getResult.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, getResult.getMaxWsSessionsPerCustomer());
    assertEquals(0, getResult.getMaxWsSessionsPerPublicUser());
    assertEquals(0, getResult.getMaxWsSessionsPerRegularUser());
    assertEquals(0, getResult.getMaxWsSessionsPerTenant());
    assertEquals(0, getResult.getQueueStatsTtlDays());
    assertEquals(0, getResult.getRpcTtlDays());
    assertEquals(0, getResult.getRuleEngineExceptionsTtlDays());
    assertEquals(0, getResult.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, getResult.getWarnThreshold());
    assertEquals(0L, getResult.getMaxAssets());
    assertEquals(0L, getResult.getMaxCreatedAlarms());
    assertEquals(0L, getResult.getMaxCustomers());
    assertEquals(0L, getResult.getMaxDPStorageDays());
    assertEquals(0L, getResult.getMaxDashboards());
    assertEquals(0L, getResult.getMaxDevices());
    assertEquals(0L, getResult.getMaxEmails());
    assertEquals(0L, getResult.getMaxJSExecutions());
    assertEquals(0L, getResult.getMaxOtaPackagesInBytes());
    assertEquals(0L, getResult.getMaxREExecutions());
    assertEquals(0L, getResult.getMaxResourceSize());
    assertEquals(0L, getResult.getMaxResourcesInBytes());
    assertEquals(0L, getResult.getMaxRuleChains());
    assertEquals(0L, getResult.getMaxSms());
    assertEquals(0L, getResult.getMaxTbelExecutions());
    assertEquals(0L, getResult.getMaxTransportDataPoints());
    assertEquals(0L, getResult.getMaxTransportMessages());
    assertEquals(0L, getResult.getMaxUsers());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, getResult.getType());
    assertTrue(actualProfileConfiguration.isPresent());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  void testGetProfileConfiguration6() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{';', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    Optional<DefaultTenantProfileConfiguration> actualProfileConfiguration = tenantProfile.getProfileConfiguration();

    // Assert
    DefaultTenantProfileConfiguration getResult = actualProfileConfiguration.get();
    assertNull(getResult.getSmsEnabled());
    assertNull(getResult.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(getResult.getCustomerServerRestLimitsConfiguration());
    assertNull(getResult.getEdgeEventRateLimits());
    assertNull(getResult.getEdgeEventRateLimitsPerEdge());
    assertNull(getResult.getEdgeUplinkMessagesRateLimits());
    assertNull(getResult.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(getResult.getTenantEntityExportRateLimit());
    assertNull(getResult.getTenantEntityImportRateLimit());
    assertNull(getResult.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(getResult.getTenantNotificationRequestsRateLimit());
    assertNull(getResult.getTenantServerRestLimitsConfiguration());
    assertNull(getResult.getTransportDeviceMsgRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayMsgRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(getResult.getTransportTenantMsgRateLimit());
    assertNull(getResult.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportTenantTelemetryMsgRateLimit());
    assertNull(getResult.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, getResult.getAlarmsTtlDays());
    assertEquals(0, getResult.getDefaultStorageTtlDays());
    assertEquals(0, getResult.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, getResult.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, getResult.getMaxWsSessionsPerCustomer());
    assertEquals(0, getResult.getMaxWsSessionsPerPublicUser());
    assertEquals(0, getResult.getMaxWsSessionsPerRegularUser());
    assertEquals(0, getResult.getMaxWsSessionsPerTenant());
    assertEquals(0, getResult.getQueueStatsTtlDays());
    assertEquals(0, getResult.getRpcTtlDays());
    assertEquals(0, getResult.getRuleEngineExceptionsTtlDays());
    assertEquals(0, getResult.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, getResult.getWarnThreshold());
    assertEquals(0L, getResult.getMaxAssets());
    assertEquals(0L, getResult.getMaxCreatedAlarms());
    assertEquals(0L, getResult.getMaxCustomers());
    assertEquals(0L, getResult.getMaxDPStorageDays());
    assertEquals(0L, getResult.getMaxDashboards());
    assertEquals(0L, getResult.getMaxDevices());
    assertEquals(0L, getResult.getMaxEmails());
    assertEquals(0L, getResult.getMaxJSExecutions());
    assertEquals(0L, getResult.getMaxOtaPackagesInBytes());
    assertEquals(0L, getResult.getMaxREExecutions());
    assertEquals(0L, getResult.getMaxResourceSize());
    assertEquals(0L, getResult.getMaxResourcesInBytes());
    assertEquals(0L, getResult.getMaxRuleChains());
    assertEquals(0L, getResult.getMaxSms());
    assertEquals(0L, getResult.getMaxTbelExecutions());
    assertEquals(0L, getResult.getMaxTransportDataPoints());
    assertEquals(0L, getResult.getMaxTransportMessages());
    assertEquals(0L, getResult.getMaxUsers());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, getResult.getType());
    assertTrue(actualProfileConfiguration.isPresent());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  void testGetProfileConfiguration7() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{'A', 0, 'A', 3, 'A', 3, 'A', 3});

    // Act
    Optional<DefaultTenantProfileConfiguration> actualProfileConfiguration = tenantProfile.getProfileConfiguration();

    // Assert
    DefaultTenantProfileConfiguration getResult = actualProfileConfiguration.get();
    assertNull(getResult.getSmsEnabled());
    assertNull(getResult.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(getResult.getCustomerServerRestLimitsConfiguration());
    assertNull(getResult.getEdgeEventRateLimits());
    assertNull(getResult.getEdgeEventRateLimitsPerEdge());
    assertNull(getResult.getEdgeUplinkMessagesRateLimits());
    assertNull(getResult.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(getResult.getTenantEntityExportRateLimit());
    assertNull(getResult.getTenantEntityImportRateLimit());
    assertNull(getResult.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(getResult.getTenantNotificationRequestsRateLimit());
    assertNull(getResult.getTenantServerRestLimitsConfiguration());
    assertNull(getResult.getTransportDeviceMsgRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayMsgRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(getResult.getTransportTenantMsgRateLimit());
    assertNull(getResult.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportTenantTelemetryMsgRateLimit());
    assertNull(getResult.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, getResult.getAlarmsTtlDays());
    assertEquals(0, getResult.getDefaultStorageTtlDays());
    assertEquals(0, getResult.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, getResult.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, getResult.getMaxWsSessionsPerCustomer());
    assertEquals(0, getResult.getMaxWsSessionsPerPublicUser());
    assertEquals(0, getResult.getMaxWsSessionsPerRegularUser());
    assertEquals(0, getResult.getMaxWsSessionsPerTenant());
    assertEquals(0, getResult.getQueueStatsTtlDays());
    assertEquals(0, getResult.getRpcTtlDays());
    assertEquals(0, getResult.getRuleEngineExceptionsTtlDays());
    assertEquals(0, getResult.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, getResult.getWarnThreshold());
    assertEquals(0L, getResult.getMaxAssets());
    assertEquals(0L, getResult.getMaxCreatedAlarms());
    assertEquals(0L, getResult.getMaxCustomers());
    assertEquals(0L, getResult.getMaxDPStorageDays());
    assertEquals(0L, getResult.getMaxDashboards());
    assertEquals(0L, getResult.getMaxDevices());
    assertEquals(0L, getResult.getMaxEmails());
    assertEquals(0L, getResult.getMaxJSExecutions());
    assertEquals(0L, getResult.getMaxOtaPackagesInBytes());
    assertEquals(0L, getResult.getMaxREExecutions());
    assertEquals(0L, getResult.getMaxResourceSize());
    assertEquals(0L, getResult.getMaxResourcesInBytes());
    assertEquals(0L, getResult.getMaxRuleChains());
    assertEquals(0L, getResult.getMaxSms());
    assertEquals(0L, getResult.getMaxTbelExecutions());
    assertEquals(0L, getResult.getMaxTransportDataPoints());
    assertEquals(0L, getResult.getMaxTransportMessages());
    assertEquals(0L, getResult.getMaxUsers());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, getResult.getType());
    assertTrue(actualProfileConfiguration.isPresent());
  }

  /**
   * Method under test: {@link TenantProfile#getProfileConfiguration()}
   */
  @Test
  void testGetProfileConfiguration8() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{});

    // Act
    Optional<DefaultTenantProfileConfiguration> actualProfileConfiguration = tenantProfile.getProfileConfiguration();

    // Assert
    DefaultTenantProfileConfiguration getResult = actualProfileConfiguration.get();
    assertNull(getResult.getSmsEnabled());
    assertNull(getResult.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(getResult.getCustomerServerRestLimitsConfiguration());
    assertNull(getResult.getEdgeEventRateLimits());
    assertNull(getResult.getEdgeEventRateLimitsPerEdge());
    assertNull(getResult.getEdgeUplinkMessagesRateLimits());
    assertNull(getResult.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(getResult.getTenantEntityExportRateLimit());
    assertNull(getResult.getTenantEntityImportRateLimit());
    assertNull(getResult.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(getResult.getTenantNotificationRequestsRateLimit());
    assertNull(getResult.getTenantServerRestLimitsConfiguration());
    assertNull(getResult.getTransportDeviceMsgRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceMsgRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(getResult.getTransportGatewayMsgRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(getResult.getTransportTenantMsgRateLimit());
    assertNull(getResult.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(getResult.getTransportTenantTelemetryMsgRateLimit());
    assertNull(getResult.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, getResult.getAlarmsTtlDays());
    assertEquals(0, getResult.getDefaultStorageTtlDays());
    assertEquals(0, getResult.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, getResult.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, getResult.getMaxWsSessionsPerCustomer());
    assertEquals(0, getResult.getMaxWsSessionsPerPublicUser());
    assertEquals(0, getResult.getMaxWsSessionsPerRegularUser());
    assertEquals(0, getResult.getMaxWsSessionsPerTenant());
    assertEquals(0, getResult.getQueueStatsTtlDays());
    assertEquals(0, getResult.getRpcTtlDays());
    assertEquals(0, getResult.getRuleEngineExceptionsTtlDays());
    assertEquals(0, getResult.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, getResult.getWarnThreshold());
    assertEquals(0L, getResult.getMaxAssets());
    assertEquals(0L, getResult.getMaxCreatedAlarms());
    assertEquals(0L, getResult.getMaxCustomers());
    assertEquals(0L, getResult.getMaxDPStorageDays());
    assertEquals(0L, getResult.getMaxDashboards());
    assertEquals(0L, getResult.getMaxDevices());
    assertEquals(0L, getResult.getMaxEmails());
    assertEquals(0L, getResult.getMaxJSExecutions());
    assertEquals(0L, getResult.getMaxOtaPackagesInBytes());
    assertEquals(0L, getResult.getMaxREExecutions());
    assertEquals(0L, getResult.getMaxResourceSize());
    assertEquals(0L, getResult.getMaxResourcesInBytes());
    assertEquals(0L, getResult.getMaxRuleChains());
    assertEquals(0L, getResult.getMaxSms());
    assertEquals(0L, getResult.getMaxTbelExecutions());
    assertEquals(0L, getResult.getMaxTransportDataPoints());
    assertEquals(0L, getResult.getMaxTransportMessages());
    assertEquals(0L, getResult.getMaxUsers());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, getResult.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, getResult.getType());
    assertTrue(actualProfileConfiguration.isPresent());
  }

  /**
   * Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  void testGetDefaultProfileConfiguration() {
    // Arrange and Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration = (new TenantProfile())
        .getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  void testGetDefaultProfileConfiguration2() {
    // Arrange and Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration = (new TenantProfile(new TenantProfile()))
        .getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  void testGetDefaultProfileConfiguration3() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration = tenantProfile
        .getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  void testGetDefaultProfileConfiguration4() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{3, 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration = tenantProfile
        .getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  void testGetDefaultProfileConfiguration5() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{0, 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration = tenantProfile
        .getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  void testGetDefaultProfileConfiguration6() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{';', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration = tenantProfile
        .getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  void testGetDefaultProfileConfiguration7() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{'A', 0, 'A', 3, 'A', 3, 'A', 3});

    // Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration = tenantProfile
        .getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#getDefaultProfileConfiguration()}
   */
  @Test
  void testGetDefaultProfileConfiguration8() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{});

    // Act
    DefaultTenantProfileConfiguration actualDefaultProfileConfiguration = tenantProfile
        .getDefaultProfileConfiguration();

    // Assert
    assertNull(actualDefaultProfileConfiguration.getSmsEnabled());
    assertNull(actualDefaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(actualDefaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(actualDefaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(actualDefaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    assertEquals(0, actualDefaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, actualDefaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, actualDefaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, actualDefaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, actualDefaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxSms());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, actualDefaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, actualDefaultProfileConfiguration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#createDefaultTenantProfileData()}
   */
  @Test
  void testCreateDefaultTenantProfileData() {
    // Arrange and Act
    TenantProfileData actualCreateDefaultTenantProfileDataResult = (new TenantProfile())
        .createDefaultTenantProfileData();

    // Assert
    TenantProfileConfiguration configuration = actualCreateDefaultTenantProfileDataResult.getConfiguration();
    assertTrue(configuration instanceof DefaultTenantProfileConfiguration);
    assertNull(((DefaultTenantProfileConfiguration) configuration).getSmsEnabled());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCustomerServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityExportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityImportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        ((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getWsUpdatesPerSessionRateLimit());
    assertNull(actualCreateDefaultTenantProfileDataResult.getQueueConfiguration());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getAlarmsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getDefaultStorageTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerCustomer());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerPublicUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerRegularUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerTenant());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getQueueStatsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRpcTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRuleEngineExceptionsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getWsMsgQueueLimitPerSession());
    assertEquals(0, configuration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0.0d, ((DefaultTenantProfileConfiguration) configuration).getWarnThreshold());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxAssets());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCreatedAlarms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCustomers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDPStorageDays());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDashboards());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDevices());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxEmails());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxJSExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxOtaPackagesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxREExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourceSize());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourcesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleChains());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxSms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTbelExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportDataPoints());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportMessages());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxUsers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerTenant());
    assertEquals(TenantProfileType.DEFAULT, configuration.getType());
  }

  /**
   * Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  void testSetProfileData() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    TenantProfileData data = new TenantProfileData();
    DefaultTenantProfileConfiguration configuration = new DefaultTenantProfileConfiguration();
    data.setConfiguration(configuration);
    data.setQueueConfiguration(new ArrayList<>());

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    byte[] profileDataBytes = tenantProfile.getProfileDataBytes();
    assertEquals(1903, profileDataBytes.length);
    assertEquals(',', profileDataBytes[1878]);
    assertEquals(':', profileDataBytes[1899]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('C', profileDataBytes[1885]);
    assertEquals('[', profileDataBytes[1900]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[1879]);
    assertEquals('"', profileDataBytes[1898]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals(']', profileDataBytes[1901]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[1893]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('e', profileDataBytes[1882]);
    assertEquals('e', profileDataBytes[1884]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('f', profileDataBytes[1888]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[1890]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[1889]);
    assertEquals('i', profileDataBytes[1895]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[1887]);
    assertEquals('n', profileDataBytes[1897]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[1886]);
    assertEquals('o', profileDataBytes[1896]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('q', profileDataBytes[1880]);
    assertEquals('r', profileDataBytes[1892]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[1894]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('u', profileDataBytes[1881]);
    assertEquals('u', profileDataBytes[1883]);
    assertEquals('u', profileDataBytes[1891]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[1902]);
    assertSame(configuration, tenantProfile.getProfileConfiguration().get());
    assertSame(configuration, tenantProfile.getDefaultProfileConfiguration());
    assertSame(data, tenantProfile.getProfileData());
  }

  /**
   * Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  void testSetProfileData2() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    // Act
    tenantProfile.setProfileData(null);

    // Assert
    assertNull(tenantProfile.getProfileDataBytes());
  }

  /**
   * Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  void testSetProfileData3() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile(new TenantProfile());

    TenantProfileData data = new TenantProfileData();
    DefaultTenantProfileConfiguration configuration = new DefaultTenantProfileConfiguration();
    data.setConfiguration(configuration);
    data.setQueueConfiguration(new ArrayList<>());

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    byte[] profileDataBytes = tenantProfile.getProfileDataBytes();
    assertEquals(1903, profileDataBytes.length);
    assertEquals(',', profileDataBytes[1878]);
    assertEquals('[', profileDataBytes[1900]);
    assertEquals('"', profileDataBytes[1879]);
    assertEquals(']', profileDataBytes[1901]);
    assertEquals('}', profileDataBytes[1902]);
    assertSame(configuration, tenantProfile.getProfileConfiguration().get());
    assertSame(configuration, tenantProfile.getDefaultProfileConfiguration());
    assertSame(data, tenantProfile.getProfileData());
  }

  /**
   * Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  void testSetProfileData4() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    TenantProfileData data = new TenantProfileData();
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
    data.setConfiguration(configuration);
    data.setQueueConfiguration(new ArrayList<>());

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    byte[] profileDataBytes = tenantProfile.getProfileDataBytes();
    assertEquals(2780, profileDataBytes.length);
    assertEquals(',', profileDataBytes[2755]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[2776]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('C', profileDataBytes[2762]);
    assertEquals('[', profileDataBytes[2777]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('"', profileDataBytes[2756]);
    assertEquals('"', profileDataBytes[2775]);
    assertEquals(']', profileDataBytes[2778]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[2770]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('e', profileDataBytes[2759]);
    assertEquals('e', profileDataBytes[2761]);
    assertEquals('f', profileDataBytes[2765]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[2767]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[2766]);
    assertEquals('i', profileDataBytes[2772]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[2764]);
    assertEquals('n', profileDataBytes[2774]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[2763]);
    assertEquals('o', profileDataBytes[2773]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('q', profileDataBytes[2757]);
    assertEquals('r', profileDataBytes[2769]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('t', profileDataBytes[2771]);
    assertEquals('u', profileDataBytes[2758]);
    assertEquals('u', profileDataBytes[2760]);
    assertEquals('u', profileDataBytes[2768]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[2779]);
    assertSame(data, tenantProfile.getProfileData());
  }

  /**
   * Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  void testSetProfileData5() throws UnsupportedEncodingException {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    TenantProfileData data = new TenantProfileData();
    data.setConfiguration(null);
    data.setQueueConfiguration(new ArrayList<>());

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    assertNull(tenantProfile.getDefaultProfileConfiguration());
    assertFalse(tenantProfile.getProfileConfiguration().isPresent());
    assertSame(data, tenantProfile.getProfileData());
    byte[] expectedProfileDataBytes = "{\"configuration\":null,\"queueConfiguration\":[]}".getBytes("UTF-8");
    assertArrayEquals(expectedProfileDataBytes, tenantProfile.getProfileDataBytes());
  }

  /**
   * Method under test: {@link TenantProfile#setProfileData(TenantProfileData)}
   */
  @Test
  void testSetProfileData6() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

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

    TenantProfileData data = new TenantProfileData();
    DefaultTenantProfileConfiguration configuration = new DefaultTenantProfileConfiguration();
    data.setConfiguration(configuration);
    data.setQueueConfiguration(queueConfiguration);

    // Act
    tenantProfile.setProfileData(data);

    // Assert
    byte[] profileDataBytes = tenantProfile.getProfileDataBytes();
    assertEquals(2229, profileDataBytes.length);
    assertEquals(',', profileDataBytes[2204]);
    assertEquals(':', profileDataBytes[2221]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('I', profileDataBytes[2216]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[2205]);
    assertEquals('"', profileDataBytes[2220]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals(']', profileDataBytes[2227]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[2206]);
    assertEquals('a', profileDataBytes[2214]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('d', profileDataBytes[2207]);
    assertEquals('d', profileDataBytes[2208]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('f', profileDataBytes[2218]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[2209]);
    assertEquals('i', profileDataBytes[2211]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[2215]);
    assertEquals('l', profileDataBytes[2224]);
    assertEquals('l', profileDataBytes[2225]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[2213]);
    assertEquals('n', profileDataBytes[2217]);
    assertEquals('n', profileDataBytes[2222]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[2212]);
    assertEquals('o', profileDataBytes[2219]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('t', profileDataBytes[2210]);
    assertEquals('u', profileDataBytes[2223]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[2226]);
    assertEquals('}', profileDataBytes[2228]);
    assertSame(configuration, tenantProfile.getProfileConfiguration().get());
    assertSame(configuration, tenantProfile.getDefaultProfileConfiguration());
    assertSame(data, tenantProfile.getProfileData());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfile#equals(Object)}
   *   <li>{@link TenantProfile#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    TenantProfile tenantProfile2 = new TenantProfile();

    // Act and Assert
    assertEquals(tenantProfile, tenantProfile2);
    int expectedHashCodeResult = tenantProfile.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfile2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfile#equals(Object)}
   *   <li>{@link TenantProfile#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setName("Name");

    TenantProfile tenantProfile2 = new TenantProfile();
    tenantProfile2.setName("Name");

    // Act and Assert
    assertEquals(tenantProfile, tenantProfile2);
    int expectedHashCodeResult = tenantProfile.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfile2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfile#equals(Object)}
   *   <li>{@link TenantProfile#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDescription("The characteristics of someone or something");

    TenantProfile tenantProfile2 = new TenantProfile();
    tenantProfile2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals(tenantProfile, tenantProfile2);
    int expectedHashCodeResult = tenantProfile.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfile2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfile#equals(Object)}
   *   <li>{@link TenantProfile#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    // Act and Assert
    assertEquals(tenantProfile, tenantProfile);
    int expectedHashCodeResult = tenantProfile.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfile.hashCode());
  }

  /**
   * Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile(new TenantProfile());

    // Act and Assert
    assertNotEquals(tenantProfile, new TenantProfile());
  }

  /**
   * Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantProfile(), mock(AdminSettings.class));
  }

  /**
   * Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setName("Name");

    // Act and Assert
    assertNotEquals(tenantProfile, new TenantProfile());
  }

  /**
   * Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(tenantProfile, new TenantProfile());
  }

  /**
   * Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDefault(true);

    // Act and Assert
    assertNotEquals(tenantProfile, new TenantProfile());
  }

  /**
   * Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setIsolatedTbRuleEngine(true);

    // Act and Assert
    assertNotEquals(tenantProfile, new TenantProfile());
  }

  /**
   * Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(tenantProfile, new TenantProfile());
  }

  /**
   * Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    TenantProfile tenantProfile2 = new TenantProfile();
    tenantProfile2.setName("Name");

    // Act and Assert
    assertNotEquals(tenantProfile, tenantProfile2);
  }

  /**
   * Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();

    TenantProfile tenantProfile2 = new TenantProfile();
    tenantProfile2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(tenantProfile, tenantProfile2);
  }

  /**
   * Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantProfile(), null);
  }

  /**
   * Method under test: {@link TenantProfile#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantProfile(), "Different type to TenantProfile");
  }

  /**
   * Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  void testNewTenantProfile() {
    // Arrange and Act
    TenantProfile actualTenantProfile = new TenantProfile(new TenantProfile());

    // Assert
    DefaultTenantProfileConfiguration defaultProfileConfiguration = actualTenantProfile
        .getDefaultProfileConfiguration();
    assertNull(defaultProfileConfiguration.getSmsEnabled());
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(defaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(defaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    TenantProfileData profileData = actualTenantProfile.getProfileData();
    assertNull(profileData.getQueueConfiguration());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0, defaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, defaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, defaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, defaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, defaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, defaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, defaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, defaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, defaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, defaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, defaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, defaultProfileConfiguration.getMaxSms());
    assertEquals(0L, defaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, defaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    byte[] profileDataBytes = actualTenantProfile.getProfileDataBytes();
    assertEquals(1905, profileDataBytes.length);
    assertEquals(TenantProfileType.DEFAULT, defaultProfileConfiguration.getType());
    assertFalse(actualTenantProfile.isDefault());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
    Optional<DefaultTenantProfileConfiguration> profileConfiguration = actualTenantProfile.getProfileConfiguration();
    assertTrue(profileConfiguration.isPresent());
    assertEquals(':', profileDataBytes[1899]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('C', profileDataBytes[1885]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[1898]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[1893]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('e', profileDataBytes[1882]);
    assertEquals('e', profileDataBytes[1884]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('f', profileDataBytes[1888]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[1890]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[1889]);
    assertEquals('i', profileDataBytes[1895]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[1902]);
    assertEquals('l', profileDataBytes[1903]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[1887]);
    assertEquals('n', profileDataBytes[1897]);
    assertEquals('n', profileDataBytes[1900]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[1886]);
    assertEquals('o', profileDataBytes[1896]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('q', profileDataBytes[1880]);
    assertEquals('r', profileDataBytes[1892]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[1894]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('u', profileDataBytes[1881]);
    assertEquals('u', profileDataBytes[1883]);
    assertEquals('u', profileDataBytes[1891]);
    assertEquals('u', profileDataBytes[1901]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[1904]);
    assertSame(defaultProfileConfiguration, profileConfiguration.get());
    assertSame(defaultProfileConfiguration, profileData.getConfiguration());
  }

  /**
   * Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  void testNewTenantProfile2() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile(new TenantProfile());

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    assertNull(tenantProfile.getDescription());
    assertNull(tenantProfile.getName());
    assertNull(tenantProfile.getUuidId());
    assertNull(tenantProfile.getId());
    assertEquals(0L, tenantProfile.getCreatedTime());
    byte[] profileDataBytes = tenantProfile.getProfileDataBytes();
    assertEquals(1905, profileDataBytes.length);
    assertFalse(tenantProfile.isDefault());
    assertFalse(tenantProfile.isIsolatedTbRuleEngine());
    assertTrue(tenantProfile.getProfileConfiguration().isPresent());
    assertEquals(tenantProfile, actualTenantProfile);
    assertEquals(':', profileDataBytes[1899]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('C', profileDataBytes[1885]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[1898]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[1893]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('e', profileDataBytes[1882]);
    assertEquals('e', profileDataBytes[1884]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('f', profileDataBytes[1888]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[1890]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[1889]);
    assertEquals('i', profileDataBytes[1895]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[1902]);
    assertEquals('l', profileDataBytes[1903]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[1887]);
    assertEquals('n', profileDataBytes[1897]);
    assertEquals('n', profileDataBytes[1900]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[1886]);
    assertEquals('o', profileDataBytes[1896]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('q', profileDataBytes[1880]);
    assertEquals('r', profileDataBytes[1892]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[1894]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('u', profileDataBytes[1881]);
    assertEquals('u', profileDataBytes[1883]);
    assertEquals('u', profileDataBytes[1891]);
    assertEquals('u', profileDataBytes[1901]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[1904]);
  }

  /**
   * Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  void testNewTenantProfile3() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setDefault(true);

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    DefaultTenantProfileConfiguration defaultProfileConfiguration = actualTenantProfile
        .getDefaultProfileConfiguration();
    assertNull(defaultProfileConfiguration.getSmsEnabled());
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(defaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(defaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    TenantProfileData profileData = actualTenantProfile.getProfileData();
    assertNull(profileData.getQueueConfiguration());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0, defaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, defaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, defaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, defaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, defaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, defaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, defaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, defaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, defaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, defaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, defaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, defaultProfileConfiguration.getMaxSms());
    assertEquals(0L, defaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, defaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    byte[] profileDataBytes = actualTenantProfile.getProfileDataBytes();
    assertEquals(1905, profileDataBytes.length);
    assertEquals(TenantProfileType.DEFAULT, defaultProfileConfiguration.getType());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
    Optional<DefaultTenantProfileConfiguration> profileConfiguration = actualTenantProfile.getProfileConfiguration();
    assertTrue(profileConfiguration.isPresent());
    assertTrue(actualTenantProfile.isDefault());
    assertEquals(':', profileDataBytes[1899]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('C', profileDataBytes[1885]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[1898]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[1893]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('e', profileDataBytes[1882]);
    assertEquals('e', profileDataBytes[1884]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('f', profileDataBytes[1888]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[1890]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[1889]);
    assertEquals('i', profileDataBytes[1895]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[1902]);
    assertEquals('l', profileDataBytes[1903]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[1887]);
    assertEquals('n', profileDataBytes[1897]);
    assertEquals('n', profileDataBytes[1900]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[1886]);
    assertEquals('o', profileDataBytes[1896]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('q', profileDataBytes[1880]);
    assertEquals('r', profileDataBytes[1892]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[1894]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('u', profileDataBytes[1881]);
    assertEquals('u', profileDataBytes[1883]);
    assertEquals('u', profileDataBytes[1891]);
    assertEquals('u', profileDataBytes[1901]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[1904]);
    assertSame(defaultProfileConfiguration, profileConfiguration.get());
    assertSame(defaultProfileConfiguration, profileData.getConfiguration());
  }

  /**
   * Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  void testNewTenantProfile4() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    DefaultTenantProfileConfiguration defaultProfileConfiguration = actualTenantProfile
        .getDefaultProfileConfiguration();
    assertNull(defaultProfileConfiguration.getSmsEnabled());
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(defaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(defaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    TenantProfileData profileData = actualTenantProfile.getProfileData();
    assertNull(profileData.getQueueConfiguration());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0, defaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, defaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, defaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, defaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, defaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, defaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, defaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, defaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, defaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, defaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, defaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, defaultProfileConfiguration.getMaxSms());
    assertEquals(0L, defaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, defaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    byte[] profileDataBytes = actualTenantProfile.getProfileDataBytes();
    assertEquals(1905, profileDataBytes.length);
    assertEquals(TenantProfileType.DEFAULT, defaultProfileConfiguration.getType());
    assertFalse(actualTenantProfile.isDefault());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
    Optional<DefaultTenantProfileConfiguration> profileConfiguration = actualTenantProfile.getProfileConfiguration();
    assertTrue(profileConfiguration.isPresent());
    assertEquals(':', profileDataBytes[1899]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('C', profileDataBytes[1885]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[1898]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[1893]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('e', profileDataBytes[1882]);
    assertEquals('e', profileDataBytes[1884]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('f', profileDataBytes[1888]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[1890]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[1889]);
    assertEquals('i', profileDataBytes[1895]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[1902]);
    assertEquals('l', profileDataBytes[1903]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[1887]);
    assertEquals('n', profileDataBytes[1897]);
    assertEquals('n', profileDataBytes[1900]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[1886]);
    assertEquals('o', profileDataBytes[1896]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('q', profileDataBytes[1880]);
    assertEquals('r', profileDataBytes[1892]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[1894]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('u', profileDataBytes[1881]);
    assertEquals('u', profileDataBytes[1883]);
    assertEquals('u', profileDataBytes[1891]);
    assertEquals('u', profileDataBytes[1901]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[1904]);
    assertSame(defaultProfileConfiguration, profileConfiguration.get());
    assertSame(defaultProfileConfiguration, profileData.getConfiguration());
  }

  /**
   * Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  void testNewTenantProfile5() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{3, 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    DefaultTenantProfileConfiguration defaultProfileConfiguration = actualTenantProfile
        .getDefaultProfileConfiguration();
    assertNull(defaultProfileConfiguration.getSmsEnabled());
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(defaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(defaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    TenantProfileData profileData = actualTenantProfile.getProfileData();
    assertNull(profileData.getQueueConfiguration());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0, defaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, defaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, defaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, defaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, defaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, defaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, defaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, defaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, defaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, defaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, defaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, defaultProfileConfiguration.getMaxSms());
    assertEquals(0L, defaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, defaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    byte[] profileDataBytes = actualTenantProfile.getProfileDataBytes();
    assertEquals(1905, profileDataBytes.length);
    assertEquals(TenantProfileType.DEFAULT, defaultProfileConfiguration.getType());
    assertFalse(actualTenantProfile.isDefault());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
    Optional<DefaultTenantProfileConfiguration> profileConfiguration = actualTenantProfile.getProfileConfiguration();
    assertTrue(profileConfiguration.isPresent());
    assertEquals(':', profileDataBytes[1899]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('C', profileDataBytes[1885]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[1898]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[1893]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('e', profileDataBytes[1882]);
    assertEquals('e', profileDataBytes[1884]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('f', profileDataBytes[1888]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[1890]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[1889]);
    assertEquals('i', profileDataBytes[1895]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[1902]);
    assertEquals('l', profileDataBytes[1903]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[1887]);
    assertEquals('n', profileDataBytes[1897]);
    assertEquals('n', profileDataBytes[1900]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[1886]);
    assertEquals('o', profileDataBytes[1896]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('q', profileDataBytes[1880]);
    assertEquals('r', profileDataBytes[1892]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[1894]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('u', profileDataBytes[1881]);
    assertEquals('u', profileDataBytes[1883]);
    assertEquals('u', profileDataBytes[1891]);
    assertEquals('u', profileDataBytes[1901]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[1904]);
    assertSame(defaultProfileConfiguration, profileConfiguration.get());
    assertSame(defaultProfileConfiguration, profileData.getConfiguration());
  }

  /**
   * Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  void testNewTenantProfile6() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{0, 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    DefaultTenantProfileConfiguration defaultProfileConfiguration = actualTenantProfile
        .getDefaultProfileConfiguration();
    assertNull(defaultProfileConfiguration.getSmsEnabled());
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(defaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(defaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    TenantProfileData profileData = actualTenantProfile.getProfileData();
    assertNull(profileData.getQueueConfiguration());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0, defaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, defaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, defaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, defaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, defaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, defaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, defaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, defaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, defaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, defaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, defaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, defaultProfileConfiguration.getMaxSms());
    assertEquals(0L, defaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, defaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    byte[] profileDataBytes = actualTenantProfile.getProfileDataBytes();
    assertEquals(1905, profileDataBytes.length);
    assertEquals(TenantProfileType.DEFAULT, defaultProfileConfiguration.getType());
    assertFalse(actualTenantProfile.isDefault());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
    Optional<DefaultTenantProfileConfiguration> profileConfiguration = actualTenantProfile.getProfileConfiguration();
    assertTrue(profileConfiguration.isPresent());
    assertEquals(':', profileDataBytes[1899]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('C', profileDataBytes[1885]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[1898]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[1893]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('e', profileDataBytes[1882]);
    assertEquals('e', profileDataBytes[1884]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('f', profileDataBytes[1888]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[1890]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[1889]);
    assertEquals('i', profileDataBytes[1895]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[1902]);
    assertEquals('l', profileDataBytes[1903]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[1887]);
    assertEquals('n', profileDataBytes[1897]);
    assertEquals('n', profileDataBytes[1900]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[1886]);
    assertEquals('o', profileDataBytes[1896]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('q', profileDataBytes[1880]);
    assertEquals('r', profileDataBytes[1892]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[1894]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('u', profileDataBytes[1881]);
    assertEquals('u', profileDataBytes[1883]);
    assertEquals('u', profileDataBytes[1891]);
    assertEquals('u', profileDataBytes[1901]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[1904]);
    assertSame(defaultProfileConfiguration, profileConfiguration.get());
    assertSame(defaultProfileConfiguration, profileData.getConfiguration());
  }

  /**
   * Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  void testNewTenantProfile7() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{';', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    DefaultTenantProfileConfiguration defaultProfileConfiguration = actualTenantProfile
        .getDefaultProfileConfiguration();
    assertNull(defaultProfileConfiguration.getSmsEnabled());
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(defaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(defaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    TenantProfileData profileData = actualTenantProfile.getProfileData();
    assertNull(profileData.getQueueConfiguration());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0, defaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, defaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, defaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, defaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, defaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, defaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, defaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, defaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, defaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, defaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, defaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, defaultProfileConfiguration.getMaxSms());
    assertEquals(0L, defaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, defaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    byte[] profileDataBytes = actualTenantProfile.getProfileDataBytes();
    assertEquals(1905, profileDataBytes.length);
    assertEquals(TenantProfileType.DEFAULT, defaultProfileConfiguration.getType());
    assertFalse(actualTenantProfile.isDefault());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
    Optional<DefaultTenantProfileConfiguration> profileConfiguration = actualTenantProfile.getProfileConfiguration();
    assertTrue(profileConfiguration.isPresent());
    assertEquals(':', profileDataBytes[1899]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('C', profileDataBytes[1885]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[1898]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[1893]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('e', profileDataBytes[1882]);
    assertEquals('e', profileDataBytes[1884]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('f', profileDataBytes[1888]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[1890]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[1889]);
    assertEquals('i', profileDataBytes[1895]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[1902]);
    assertEquals('l', profileDataBytes[1903]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[1887]);
    assertEquals('n', profileDataBytes[1897]);
    assertEquals('n', profileDataBytes[1900]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[1886]);
    assertEquals('o', profileDataBytes[1896]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('q', profileDataBytes[1880]);
    assertEquals('r', profileDataBytes[1892]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[1894]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('u', profileDataBytes[1881]);
    assertEquals('u', profileDataBytes[1883]);
    assertEquals('u', profileDataBytes[1891]);
    assertEquals('u', profileDataBytes[1901]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[1904]);
    assertSame(defaultProfileConfiguration, profileConfiguration.get());
    assertSame(defaultProfileConfiguration, profileData.getConfiguration());
  }

  /**
   * Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  void testNewTenantProfile8() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{'A', 0, 'A', 3, 'A', 3, 'A', 3});

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    DefaultTenantProfileConfiguration defaultProfileConfiguration = actualTenantProfile
        .getDefaultProfileConfiguration();
    assertNull(defaultProfileConfiguration.getSmsEnabled());
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(defaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(defaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    TenantProfileData profileData = actualTenantProfile.getProfileData();
    assertNull(profileData.getQueueConfiguration());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0, defaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, defaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, defaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, defaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, defaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, defaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, defaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, defaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, defaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, defaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, defaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, defaultProfileConfiguration.getMaxSms());
    assertEquals(0L, defaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, defaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    byte[] profileDataBytes = actualTenantProfile.getProfileDataBytes();
    assertEquals(1905, profileDataBytes.length);
    assertEquals(TenantProfileType.DEFAULT, defaultProfileConfiguration.getType());
    assertFalse(actualTenantProfile.isDefault());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
    Optional<DefaultTenantProfileConfiguration> profileConfiguration = actualTenantProfile.getProfileConfiguration();
    assertTrue(profileConfiguration.isPresent());
    assertEquals(':', profileDataBytes[1899]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('C', profileDataBytes[1885]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[1898]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[1893]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('e', profileDataBytes[1882]);
    assertEquals('e', profileDataBytes[1884]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('f', profileDataBytes[1888]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[1890]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[1889]);
    assertEquals('i', profileDataBytes[1895]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[1902]);
    assertEquals('l', profileDataBytes[1903]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[1887]);
    assertEquals('n', profileDataBytes[1897]);
    assertEquals('n', profileDataBytes[1900]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[1886]);
    assertEquals('o', profileDataBytes[1896]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('q', profileDataBytes[1880]);
    assertEquals('r', profileDataBytes[1892]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[1894]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('u', profileDataBytes[1881]);
    assertEquals('u', profileDataBytes[1883]);
    assertEquals('u', profileDataBytes[1891]);
    assertEquals('u', profileDataBytes[1901]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[1904]);
    assertSame(defaultProfileConfiguration, profileConfiguration.get());
    assertSame(defaultProfileConfiguration, profileData.getConfiguration());
  }

  /**
   * Method under test: {@link TenantProfile#TenantProfile(TenantProfile)}
   */
  @Test
  void testNewTenantProfile9() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    tenantProfile.setProfileDataBytes(new byte[]{});

    // Act
    TenantProfile actualTenantProfile = new TenantProfile(tenantProfile);

    // Assert
    DefaultTenantProfileConfiguration defaultProfileConfiguration = actualTenantProfile
        .getDefaultProfileConfiguration();
    assertNull(defaultProfileConfiguration.getSmsEnabled());
    assertNull(actualTenantProfile.getDescription());
    assertNull(actualTenantProfile.getName());
    assertNull(defaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(defaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    TenantProfileData profileData = actualTenantProfile.getProfileData();
    assertNull(profileData.getQueueConfiguration());
    assertNull(actualTenantProfile.getUuidId());
    assertNull(actualTenantProfile.getId());
    assertEquals(0, defaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, defaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, defaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, actualTenantProfile.getCreatedTime());
    assertEquals(0L, defaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, defaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, defaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, defaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, defaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, defaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, defaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, defaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, defaultProfileConfiguration.getMaxSms());
    assertEquals(0L, defaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, defaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    byte[] profileDataBytes = actualTenantProfile.getProfileDataBytes();
    assertEquals(1905, profileDataBytes.length);
    assertEquals(TenantProfileType.DEFAULT, defaultProfileConfiguration.getType());
    assertFalse(actualTenantProfile.isDefault());
    assertFalse(actualTenantProfile.isIsolatedTbRuleEngine());
    Optional<DefaultTenantProfileConfiguration> profileConfiguration = actualTenantProfile.getProfileConfiguration();
    assertTrue(profileConfiguration.isPresent());
    assertEquals(':', profileDataBytes[1899]);
    assertEquals(':', profileDataBytes[24]);
    assertEquals(':', profileDataBytes[Short.SIZE]);
    assertEquals('C', profileDataBytes[1885]);
    assertEquals('"', profileDataBytes[1]);
    assertEquals('"', profileDataBytes[15]);
    assertEquals('"', profileDataBytes[18]);
    assertEquals('"', profileDataBytes[1898]);
    assertEquals('"', profileDataBytes[23]);
    assertEquals('a', profileDataBytes[10]);
    assertEquals('a', profileDataBytes[1893]);
    assertEquals('c', profileDataBytes[2]);
    assertEquals('e', profileDataBytes[1882]);
    assertEquals('e', profileDataBytes[1884]);
    assertEquals('e', profileDataBytes[22]);
    assertEquals('f', profileDataBytes[1888]);
    assertEquals('f', profileDataBytes[5]);
    assertEquals('g', profileDataBytes[1890]);
    assertEquals('g', profileDataBytes[7]);
    assertEquals('i', profileDataBytes[12]);
    assertEquals('i', profileDataBytes[1889]);
    assertEquals('i', profileDataBytes[1895]);
    assertEquals('i', profileDataBytes[6]);
    assertEquals('l', profileDataBytes[1902]);
    assertEquals('l', profileDataBytes[1903]);
    assertEquals('n', profileDataBytes[14]);
    assertEquals('n', profileDataBytes[1887]);
    assertEquals('n', profileDataBytes[1897]);
    assertEquals('n', profileDataBytes[1900]);
    assertEquals('n', profileDataBytes[4]);
    assertEquals('o', profileDataBytes[13]);
    assertEquals('o', profileDataBytes[1886]);
    assertEquals('o', profileDataBytes[1896]);
    assertEquals('o', profileDataBytes[3]);
    assertEquals('p', profileDataBytes[21]);
    assertEquals('q', profileDataBytes[1880]);
    assertEquals('r', profileDataBytes[1892]);
    assertEquals('r', profileDataBytes[9]);
    assertEquals('t', profileDataBytes[11]);
    assertEquals('t', profileDataBytes[1894]);
    assertEquals('t', profileDataBytes[19]);
    assertEquals('u', profileDataBytes[1881]);
    assertEquals('u', profileDataBytes[1883]);
    assertEquals('u', profileDataBytes[1891]);
    assertEquals('u', profileDataBytes[1901]);
    assertEquals('u', profileDataBytes[8]);
    assertEquals('y', profileDataBytes[20]);
    assertEquals('{', profileDataBytes[0]);
    assertEquals('{', profileDataBytes[17]);
    assertEquals('}', profileDataBytes[1904]);
    assertSame(defaultProfileConfiguration, profileConfiguration.get());
    assertSame(defaultProfileConfiguration, profileData.getConfiguration());
  }
}
