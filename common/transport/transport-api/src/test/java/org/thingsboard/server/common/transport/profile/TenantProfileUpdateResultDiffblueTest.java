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
package org.thingsboard.server.common.transport.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;

class TenantProfileUpdateResultDiffblueTest {
  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}, and {@link
   * TenantProfileUpdateResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileUpdateResult#equals(Object)}
   *   <li>{@link TenantProfileUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileUpdateResult.equals(Object)",
    "int TenantProfileUpdateResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfile profile = new TenantProfile();
    TenantProfileUpdateResult tenantProfileUpdateResult =
        new TenantProfileUpdateResult(profile, new HashSet<>());
    TenantProfile profile2 = new TenantProfile();
    TenantProfileUpdateResult tenantProfileUpdateResult2 =
        new TenantProfileUpdateResult(profile2, new HashSet<>());

    // Act and Assert
    assertEquals(tenantProfileUpdateResult, tenantProfileUpdateResult2);
    assertEquals(tenantProfileUpdateResult.hashCode(), tenantProfileUpdateResult2.hashCode());
  }

  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}, and {@link
   * TenantProfileUpdateResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileUpdateResult#equals(Object)}
   *   <li>{@link TenantProfileUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileUpdateResult.equals(Object)",
    "int TenantProfileUpdateResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantProfileUpdateResult tenantProfileUpdateResult =
        new TenantProfileUpdateResult(null, new HashSet<>());
    TenantProfileUpdateResult tenantProfileUpdateResult2 =
        new TenantProfileUpdateResult(null, new HashSet<>());

    // Act and Assert
    assertEquals(tenantProfileUpdateResult, tenantProfileUpdateResult2);
    assertEquals(tenantProfileUpdateResult.hashCode(), tenantProfileUpdateResult2.hashCode());
  }

  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}, and {@link
   * TenantProfileUpdateResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileUpdateResult#equals(Object)}
   *   <li>{@link TenantProfileUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileUpdateResult.equals(Object)",
    "int TenantProfileUpdateResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantProfile profile = new TenantProfile();
    TenantProfileUpdateResult tenantProfileUpdateResult =
        new TenantProfileUpdateResult(profile, new HashSet<>());

    // Act and Assert
    assertEquals(tenantProfileUpdateResult, tenantProfileUpdateResult);
    int expectedHashCodeResult = tenantProfileUpdateResult.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileUpdateResult.hashCode());
  }

  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileUpdateResult.equals(Object)",
    "int TenantProfileUpdateResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantProfileUpdateResult tenantProfileUpdateResult =
        new TenantProfileUpdateResult(null, new HashSet<>());
    TenantProfile profile = new TenantProfile();
    TenantProfileUpdateResult tenantProfileUpdateResult2 =
        new TenantProfileUpdateResult(profile, new HashSet<>());

    // Act and Assert
    assertNotEquals(tenantProfileUpdateResult, tenantProfileUpdateResult2);
  }

  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileUpdateResult.equals(Object)",
    "int TenantProfileUpdateResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantProfile profile = new TenantProfile(new TenantProfile());
    TenantProfileUpdateResult tenantProfileUpdateResult =
        new TenantProfileUpdateResult(profile, new HashSet<>());
    TenantProfile profile2 = new TenantProfile();
    TenantProfileUpdateResult tenantProfileUpdateResult2 =
        new TenantProfileUpdateResult(profile2, new HashSet<>());

    // Act and Assert
    assertNotEquals(tenantProfileUpdateResult, tenantProfileUpdateResult2);
  }

  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileUpdateResult.equals(Object)",
    "int TenantProfileUpdateResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<TenantId> affectedTenants = new HashSet<>();
    affectedTenants.add(new TenantId(UUID.randomUUID()));
    TenantProfileUpdateResult tenantProfileUpdateResult =
        new TenantProfileUpdateResult(new TenantProfile(), affectedTenants);
    TenantProfile profile = new TenantProfile();
    TenantProfileUpdateResult tenantProfileUpdateResult2 =
        new TenantProfileUpdateResult(profile, new HashSet<>());

    // Act and Assert
    assertNotEquals(tenantProfileUpdateResult, tenantProfileUpdateResult2);
  }

  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileUpdateResult.equals(Object)",
    "int TenantProfileUpdateResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantProfile profile = new TenantProfile();
    TenantProfileUpdateResult tenantProfileUpdateResult =
        new TenantProfileUpdateResult(profile, new HashSet<>());

    // Act and Assert
    assertNotEquals(tenantProfileUpdateResult, null);
  }

  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantProfileUpdateResult.equals(Object)",
    "int TenantProfileUpdateResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantProfile profile = new TenantProfile();
    TenantProfileUpdateResult tenantProfileUpdateResult =
        new TenantProfileUpdateResult(profile, new HashSet<>());

    // Act and Assert
    assertNotEquals(tenantProfileUpdateResult, "Different type to TenantProfileUpdateResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantProfileUpdateResult#TenantProfileUpdateResult(TenantProfile, Set)}
   *   <li>{@link TenantProfileUpdateResult#toString()}
   *   <li>{@link TenantProfileUpdateResult#getAffectedTenants()}
   *   <li>{@link TenantProfileUpdateResult#getProfile()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantProfileUpdateResult.<init>(TenantProfile, Set)",
    "Set TenantProfileUpdateResult.getAffectedTenants()",
    "TenantProfile TenantProfileUpdateResult.getProfile()",
    "String TenantProfileUpdateResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TenantProfile profile = new TenantProfile();
    HashSet<TenantId> affectedTenants = new HashSet<>();

    // Act
    TenantProfileUpdateResult actualTenantProfileUpdateResult =
        new TenantProfileUpdateResult(profile, affectedTenants);
    String actualToStringResult = actualTenantProfileUpdateResult.toString();
    Set<TenantId> actualAffectedTenants = actualTenantProfileUpdateResult.getAffectedTenants();
    TenantProfile actualProfile = actualTenantProfileUpdateResult.getProfile();

    // Assert
    assertEquals(
        "TenantProfileUpdateResult(profile=TenantProfile(name=null, description=null, isDefault=false,"
            + " isolatedTbRuleEngine=false, profileData=TenantProfileData(configuration=DefaultTenantProfileConfiguration"
            + "(maxDevices=0, maxAssets=0, maxCustomers=0, maxUsers=0, maxDashboards=0, maxRuleChains=0, maxResourcesInBytes"
            + "=0, maxOtaPackagesInBytes=0, maxResourceSize=0, transportTenantMsgRateLimit=null, transportTenantTel"
            + "emetryMsgRateLimit=null, transportTenantTelemetryDataPointsRateLimit=null, transportDeviceMsgRateLimit=null,"
            + " transportDeviceTelemetryMsgRateLimit=null, transportDeviceTelemetryDataPointsRateLimit=null,"
            + " transportGatewayMsgRateLimit=null, transportGatewayTelemetryMsgRateLimit=null, transportGatewayTele"
            + "metryDataPointsRateLimit=null, transportGatewayDeviceMsgRateLimit=null, transportGatewayDeviceTeleme"
            + "tryMsgRateLimit=null, transportGatewayDeviceTelemetryDataPointsRateLimit=null, tenantEntityExportRateLimit"
            + "=null, tenantEntityImportRateLimit=null, tenantNotificationRequestsRateLimit=null, tenantNotificatio"
            + "nRequestsPerRuleRateLimit=null, maxTransportMessages=0, maxTransportDataPoints=0, maxREExecutions=0,"
            + " maxJSExecutions=0, maxTbelExecutions=0, maxDPStorageDays=0, maxRuleNodeExecutionsPerMessage=0,"
            + " maxEmails=0, smsEnabled=null, maxSms=0, maxCreatedAlarms=0, tenantServerRestLimitsConfiguration=null,"
            + " customerServerRestLimitsConfiguration=null, maxWsSessionsPerTenant=0, maxWsSessionsPerCustomer=0,"
            + " maxWsSessionsPerRegularUser=0, maxWsSessionsPerPublicUser=0, wsMsgQueueLimitPerSession=0, maxWsSubs"
            + "criptionsPerTenant=0, maxWsSubscriptionsPerCustomer=0, maxWsSubscriptionsPerRegularUser=0, maxWsSubs"
            + "criptionsPerPublicUser=0, wsUpdatesPerSessionRateLimit=null, cassandraQueryTenantRateLimitsConfiguration"
            + "=null, edgeEventRateLimits=null, edgeEventRateLimitsPerEdge=null, edgeUplinkMessagesRateLimits=null,"
            + " edgeUplinkMessagesRateLimitsPerEdge=null, defaultStorageTtlDays=0, alarmsTtlDays=0, rpcTtlDays=0,"
            + " queueStatsTtlDays=0, ruleEngineExceptionsTtlDays=0, warnThreshold=0.0), queueConfiguration=null)),"
            + " affectedTenants=[])",
        actualToStringResult);
    assertTrue(actualAffectedTenants.isEmpty());
    assertSame(affectedTenants, actualAffectedTenants);
    assertSame(profile, actualProfile);
  }
}
