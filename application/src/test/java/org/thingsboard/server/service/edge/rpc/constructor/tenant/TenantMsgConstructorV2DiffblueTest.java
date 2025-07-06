package org.thingsboard.server.service.edge.rpc.constructor.tenant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.gen.edge.v1.TenantProfileUpdateMsg;
import org.thingsboard.server.gen.edge.v1.TenantUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class TenantMsgConstructorV2DiffblueTest {
  /**
   * Test {@link TenantMsgConstructorV2#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   *
   * <ul>
   *   <li>Then return MsgTypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link TenantMsgConstructorV2#constructTenantUpdateMsg(UpdateMsgType,
   * Tenant)}
   */
  @Test
  @DisplayName(
      "Test constructTenantUpdateMsg(UpdateMsgType, Tenant); then return MsgTypeValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TenantUpdateMsg TenantMsgConstructorV2.constructTenantUpdateMsg(UpdateMsgType, Tenant)"
  })
  void testConstructTenantUpdateMsg_thenReturnMsgTypeValueIsOne() {
    // Arrange
    TenantMsgConstructorV2 tenantMsgConstructorV2 = new TenantMsgConstructorV2();

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult =
        tenantMsgConstructorV2.constructTenantUpdateMsg(
            UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, new Tenant());

    // Assert
    assertEquals(1, actualConstructTenantUpdateMsgResult.getMsgTypeValue());
    assertEquals(2, actualConstructTenantUpdateMsgResult.getAllFields().size());
    assertEquals(240, actualConstructTenantUpdateMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE,
        actualConstructTenantUpdateMsgResult.getMsgType());
  }

  /**
   * Test {@link TenantMsgConstructorV2#constructTenantProfileUpdateMsg(UpdateMsgType,
   * TenantProfile, EdgeVersion)}.
   *
   * <p>Method under test: {@link
   * TenantMsgConstructorV2#constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile,
   * EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TenantProfileUpdateMsg TenantMsgConstructorV2.constructTenantProfileUpdateMsg(UpdateMsgType, TenantProfile, EdgeVersion)"
  })
  void testConstructTenantProfileUpdateMsg() {
    // Arrange
    TenantMsgConstructorV2 tenantMsgConstructorV2 = new TenantMsgConstructorV2();

    // Act
    TenantProfileUpdateMsg actualConstructTenantProfileUpdateMsgResult =
        tenantMsgConstructorV2.constructTenantProfileUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, new TenantProfile(), EdgeVersion.V_3_3_0);

    // Assert
    assertEquals("", actualConstructTenantProfileUpdateMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructTenantProfileUpdateMsgResult.getDescription());
    assertEquals("", actualConstructTenantProfileUpdateMsgResult.getName());
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"name\":null,\"description\":null,\"isolatedTbRuleEngine\":false,\"profileData\""
            + ":{\"configuration\":{\"type\":\"DEFAULT\",\"maxDevices\":0,\"maxAssets\":0,\"maxCustomers\":0,\"maxUsers\":0,"
            + "\"maxDashboards\":0,\"maxRuleChains\":0,\"maxResourcesInBytes\":0,\"maxOtaPackagesInBytes\":0,\"maxResourceSize"
            + "\":0,\"transportTenantMsgRateLimit\":null,\"transportTenantTelemetryMsgRateLimit\":null,\"transportTenantT"
            + "elemetryDataPointsRateLimit\":null,\"transportDeviceMsgRateLimit\":null,\"transportDeviceTelemetryMsgRateLimit"
            + "\":null,\"transportDeviceTelemetryDataPointsRateLimit\":null,\"transportGatewayMsgRateLimit\":null,"
            + "\"transportGatewayTelemetryMsgRateLimit\":null,\"transportGatewayTelemetryDataPointsRateLimit\":null,"
            + "\"transportGatewayDeviceMsgRateLimit\":null,\"transportGatewayDeviceTelemetryMsgRateLimit\":null,"
            + "\"transportGatewayDeviceTelemetryDataPointsRateLimit\":null,\"tenantEntityExportRateLimit\":null,"
            + "\"tenantEntityImportRateLimit\":null,\"tenantNotificationRequestsRateLimit\":null,\"tenantNotificationReq"
            + "uestsPerRuleRateLimit\":null,\"maxTransportMessages\":0,\"maxTransportDataPoints\":0,\"maxREExecutions\":0,"
            + "\"maxJSExecutions\":0,\"maxTbelExecutions\":0,\"maxDPStorageDays\":0,\"maxRuleNodeExecutionsPerMessage\":0,"
            + "\"maxEmails\":0,\"smsEnabled\":null,\"maxSms\":0,\"maxCreatedAlarms\":0,\"tenantServerRestLimitsConfiguration"
            + "\":null,\"customerServerRestLimitsConfiguration\":null,\"maxWsSessionsPerTenant\":0,\"maxWsSessionsPerCustomer"
            + "\":0,\"maxWsSessionsPerRegularUser\":0,\"maxWsSessionsPerPublicUser\":0,\"wsMsgQueueLimitPerSession\":0,"
            + "\"maxWsSubscriptionsPerTenant\":0,\"maxWsSubscriptionsPerCustomer\":0,\"maxWsSubscriptionsPerRegularUser\""
            + ":0,\"maxWsSubscriptionsPerPublicUser\":0,\"wsUpdatesPerSessionRateLimit\":null,\"cassandraQueryTenantRate"
            + "LimitsConfiguration\":null,\"edgeEventRateLimits\":null,\"edgeEventRateLimitsPerEdge\":null,\"edgeUplinkMe"
            + "ssagesRateLimits\":null,\"edgeUplinkMessagesRateLimitsPerEdge\":null,\"defaultStorageTtlDays\":0,\"alarmsTtlDays"
            + "\":0,\"rpcTtlDays\":0,\"queueStatsTtlDays\":0,\"ruleEngineExceptionsTtlDays\":0,\"warnThreshold\":0.0},"
            + "\"queueConfiguration\":null},\"default\":false}",
        actualConstructTenantProfileUpdateMsgResult.getEntity());
    assertEquals(0, actualConstructTenantProfileUpdateMsgResult.getMsgTypeValue());
    assertEquals(0L, actualConstructTenantProfileUpdateMsgResult.getIdLSB());
    assertEquals(0L, actualConstructTenantProfileUpdateMsgResult.getIdMSB());
    assertEquals(1, actualConstructTenantProfileUpdateMsgResult.getAllFields().size());
    assertEquals(2026, actualConstructTenantProfileUpdateMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructTenantProfileUpdateMsgResult.getMsgType());
    assertFalse(actualConstructTenantProfileUpdateMsgResult.getDefault());
    assertFalse(actualConstructTenantProfileUpdateMsgResult.getIsolatedRuleChain());
    assertFalse(actualConstructTenantProfileUpdateMsgResult.hasDescription());
    assertTrue(actualConstructTenantProfileUpdateMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructTenantProfileUpdateMsgResult.isInitialized());
  }
}
