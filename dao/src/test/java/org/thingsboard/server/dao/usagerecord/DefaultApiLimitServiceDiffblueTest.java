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
package org.thingsboard.server.dao.usagerecord;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
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
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.query.EntityCountQuery;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.dao.entity.EntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.TenantProfileServiceTest;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;

@ContextConfiguration(classes = {DefaultApiLimitService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultApiLimitServiceDiffblueTest {
  @Autowired private DefaultApiLimitService defaultApiLimitService;

  @MockBean private EntityService entityService;

  @MockBean private TbTenantProfileCache tbTenantProfileCache;

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getDefaultProfileConfiguration()).thenThrow(new IllegalArgumentException());
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultApiLimitService.checkEntitiesLimit(tenantId, EntityType.TENANT));
    verify(tenantProfile).getDefaultProfileConfiguration();
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit2() {
    // Arrange
    when(entityService.countEntitiesByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<EntityCountQuery>any()))
        .thenThrow(new IllegalArgumentException());

    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getDefaultProfileConfiguration())
        .thenReturn(
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
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultApiLimitService.checkEntitiesLimit(tenantId, EntityType.CUSTOMER));
    verify(tenantProfile).getDefaultProfileConfiguration();
    verify(tenantId).isSysTenantId();
    verify(entityService)
        .countEntitiesByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityCountQuery.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link EntityService} {@link EntityService#countEntitiesByQuery(TenantId,
   *       CustomerId, EntityCountQuery)} return zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit_givenEntityServiceCountEntitiesByQueryReturnZero() {
    // Arrange
    when(entityService.countEntitiesByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<EntityCountQuery>any()))
        .thenReturn(0L);

    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getDefaultProfileConfiguration())
        .thenReturn(
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
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act
    boolean actualCheckEntitiesLimitResult =
        defaultApiLimitService.checkEntitiesLimit(tenantId, EntityType.CUSTOMER);

    // Assert
    verify(tenantProfile).getDefaultProfileConfiguration();
    verify(tenantId).isSysTenantId();
    verify(entityService)
        .countEntitiesByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityCountQuery.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertTrue(actualCheckEntitiesLimitResult);
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit_givenIllegalArgumentException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultApiLimitService.checkEntitiesLimit(tenantId, EntityType.TENANT));
    verify(tenantId).isSysTenantId();
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache} {@link TbTenantProfileCache#get(TenantId)} return
   *       createTenantProfile {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit_givenTbTenantProfileCacheGetReturnCreateTenantProfileName() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act
    boolean actualCheckEntitiesLimitResult =
        defaultApiLimitService.checkEntitiesLimit(tenantId, EntityType.TENANT);

    // Assert
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertTrue(actualCheckEntitiesLimitResult);
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache} {@link TbTenantProfileCache#get(TenantId)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit_givenTbTenantProfileCacheGetReturnNull() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(null);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultApiLimitService.checkEntitiesLimit(tenantId, EntityType.TENANT));
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache} {@link TbTenantProfileCache#get(TenantId)} return
   *       {@link TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit_givenTbTenantProfileCacheGetReturnTenantProfile() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act
    boolean actualCheckEntitiesLimitResult =
        defaultApiLimitService.checkEntitiesLimit(tenantId, EntityType.TENANT);

    // Assert
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertTrue(actualCheckEntitiesLimitResult);
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit_givenTbTenantProfileCache_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(defaultApiLimitService.checkEntitiesLimit(null, EntityType.TENANT));
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}.
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit_givenTbTenantProfileCache_whenSystem_tenant() {
    // Arrange, Act and Assert
    assertTrue(
        defaultApiLimitService.checkEntitiesLimit(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#checkEntitiesLimit(TenantId, EntityType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultApiLimitService.checkEntitiesLimit(TenantId, EntityType)"})
  public void testCheckEntitiesLimit_thenReturnFalse() {
    // Arrange
    when(entityService.countEntitiesByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<EntityCountQuery>any()))
        .thenReturn(3L);

    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getDefaultProfileConfiguration())
        .thenReturn(
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
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act
    boolean actualCheckEntitiesLimitResult =
        defaultApiLimitService.checkEntitiesLimit(tenantId, EntityType.CUSTOMER);

    // Assert
    verify(tenantProfile).getDefaultProfileConfiguration();
    verify(tenantId).isSysTenantId();
    verify(entityService)
        .countEntitiesByQuery(
            isA(TenantId.class), isA(CustomerId.class), isA(EntityCountQuery.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertFalse(actualCheckEntitiesLimitResult);
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_givenNull_whenFunctionApplyReturnNull_thenReturnZero() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    Function<DefaultTenantProfileConfiguration, Number> extractor = mock(Function.class);
    when(extractor.apply(Mockito.<DefaultTenantProfileConfiguration>any())).thenReturn(null);

    // Act
    long actualLimit = defaultApiLimitService.getLimit(tenantId, extractor);

    // Assert
    verify(extractor).apply(isA(DefaultTenantProfileConfiguration.class));
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertEquals(0L, actualLimit);
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache} {@link TbTenantProfileCache#get(TenantId)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_givenTbTenantProfileCacheGetReturnNull() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(null);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultApiLimitService.getLimit(tenantId, mock(Function.class)));
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache} {@link TbTenantProfileCache#get(TenantId)} return
   *       {@link TenantProfile#TenantProfile()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_givenTbTenantProfileCacheGetReturnTenantProfile_thenReturnOne() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    Function<DefaultTenantProfileConfiguration, Number> extractor = mock(Function.class);
    when(extractor.apply(Mockito.<DefaultTenantProfileConfiguration>any()))
        .thenReturn(Integer.valueOf(1));

    // Act
    long actualLimit = defaultApiLimitService.getLimit(tenantId, extractor);

    // Assert
    verify(extractor).apply(isA(DefaultTenantProfileConfiguration.class));
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertEquals(1L, actualLimit);
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}.
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_givenTbTenantProfileCache_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, defaultApiLimitService.getLimit(null, mock(Function.class)));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}.
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_givenTbTenantProfileCache_whenSystem_tenant_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0L, defaultApiLimitService.getLimit(ModelConstants.SYSTEM_TENANT, mock(Function.class)));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>Given valueOf one.
   *   <li>When {@link Function} {@link Function#apply(Object)} return valueOf one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_givenValueOfOne_whenFunctionApplyReturnValueOfOne_thenReturnOne() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    Function<DefaultTenantProfileConfiguration, Number> extractor = mock(Function.class);
    when(extractor.apply(Mockito.<DefaultTenantProfileConfiguration>any()))
        .thenReturn(Integer.valueOf(1));

    // Act
    long actualLimit = defaultApiLimitService.getLimit(tenantId, extractor);

    // Assert
    verify(extractor).apply(isA(DefaultTenantProfileConfiguration.class));
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertEquals(1L, actualLimit);
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantProfile#getDefaultProfileConfiguration()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_thenCallsGetDefaultProfileConfiguration() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getDefaultProfileConfiguration()).thenThrow(new IllegalArgumentException());
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultApiLimitService.getLimit(tenantId, mock(Function.class)));
    verify(tenantProfile).getDefaultProfileConfiguration();
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>When {@link Function} {@link Function#apply(Object)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_whenFunctionApplyThrowIllegalArgumentException() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    Function<DefaultTenantProfileConfiguration, Number> extractor = mock(Function.class);
    when(extractor.apply(Mockito.<DefaultTenantProfileConfiguration>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultApiLimitService.getLimit(tenantId, extractor));
    verify(extractor).apply(isA(DefaultTenantProfileConfiguration.class));
    verify(tenantId).isSysTenantId();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultApiLimitService#getLimit(TenantId, Function)}.
   *
   * <ul>
   *   <li>When {@link TenantId} {@link TenantId#isSysTenantId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultApiLimitService#getLimit(TenantId, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long DefaultApiLimitService.getLimit(TenantId, Function)"})
  public void testGetLimit_whenTenantIdIsSysTenantIdThrowIllegalArgumentException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultApiLimitService.getLimit(tenantId, mock(Function.class)));
    verify(tenantId).isSysTenantId();
  }
}
