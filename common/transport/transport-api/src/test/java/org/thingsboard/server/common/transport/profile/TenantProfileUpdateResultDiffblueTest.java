package org.thingsboard.server.common.transport.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * Test {@link TenantProfileUpdateResult#equals(Object)}, and {@link TenantProfileUpdateResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileUpdateResult#equals(Object)}
   *   <li>{@link TenantProfileUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantProfileUpdateResult.equals(Object)", "int TenantProfileUpdateResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfile profile = new TenantProfile();
    TenantProfileUpdateResult tenantProfileUpdateResult = new TenantProfileUpdateResult(profile, new HashSet<>());
    TenantProfile profile2 = new TenantProfile();
    TenantProfileUpdateResult tenantProfileUpdateResult2 = new TenantProfileUpdateResult(profile2, new HashSet<>());

    // Act and Assert
    assertEquals(tenantProfileUpdateResult, tenantProfileUpdateResult2);
    int expectedHashCodeResult = tenantProfileUpdateResult.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileUpdateResult2.hashCode());
  }

  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}, and {@link TenantProfileUpdateResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileUpdateResult#equals(Object)}
   *   <li>{@link TenantProfileUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantProfileUpdateResult.equals(Object)", "int TenantProfileUpdateResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantProfileUpdateResult tenantProfileUpdateResult = new TenantProfileUpdateResult(null, new HashSet<>());
    TenantProfileUpdateResult tenantProfileUpdateResult2 = new TenantProfileUpdateResult(null, new HashSet<>());

    // Act and Assert
    assertEquals(tenantProfileUpdateResult, tenantProfileUpdateResult2);
    int expectedHashCodeResult = tenantProfileUpdateResult.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileUpdateResult2.hashCode());
  }

  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}, and {@link TenantProfileUpdateResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileUpdateResult#equals(Object)}
   *   <li>{@link TenantProfileUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantProfileUpdateResult.equals(Object)", "int TenantProfileUpdateResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantProfile profile = new TenantProfile();
    TenantProfileUpdateResult tenantProfileUpdateResult = new TenantProfileUpdateResult(profile, new HashSet<>());

    // Act and Assert
    assertEquals(tenantProfileUpdateResult, tenantProfileUpdateResult);
    int expectedHashCodeResult = tenantProfileUpdateResult.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileUpdateResult.hashCode());
  }

  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantProfileUpdateResult.equals(Object)", "int TenantProfileUpdateResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantProfileUpdateResult tenantProfileUpdateResult = new TenantProfileUpdateResult(null, new HashSet<>());
    TenantProfile profile = new TenantProfile();

    // Act and Assert
    assertNotEquals(tenantProfileUpdateResult, new TenantProfileUpdateResult(profile, new HashSet<>()));
  }

  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantProfileUpdateResult.equals(Object)", "int TenantProfileUpdateResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantProfile profile = new TenantProfile(new TenantProfile());
    TenantProfileUpdateResult tenantProfileUpdateResult = new TenantProfileUpdateResult(profile, new HashSet<>());
    TenantProfile profile2 = new TenantProfile();

    // Act and Assert
    assertNotEquals(tenantProfileUpdateResult, new TenantProfileUpdateResult(profile2, new HashSet<>()));
  }

  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantProfileUpdateResult.equals(Object)", "int TenantProfileUpdateResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<TenantId> affectedTenants = new HashSet<>();
    affectedTenants.add(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TenantProfileUpdateResult tenantProfileUpdateResult = new TenantProfileUpdateResult(new TenantProfile(),
        affectedTenants);
    TenantProfile profile = new TenantProfile();

    // Act and Assert
    assertNotEquals(tenantProfileUpdateResult, new TenantProfileUpdateResult(profile, new HashSet<>()));
  }

  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantProfileUpdateResult.equals(Object)", "int TenantProfileUpdateResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantProfile profile = new TenantProfile();

    // Act and Assert
    assertNotEquals(new TenantProfileUpdateResult(profile, new HashSet<>()), null);
  }

  /**
   * Test {@link TenantProfileUpdateResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantProfileUpdateResult.equals(Object)", "int TenantProfileUpdateResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantProfile profile = new TenantProfile();

    // Act and Assert
    assertNotEquals(new TenantProfileUpdateResult(profile, new HashSet<>()),
        "Different type to TenantProfileUpdateResult");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileUpdateResult#TenantProfileUpdateResult(TenantProfile, Set)}
   *   <li>{@link TenantProfileUpdateResult#toString()}
   *   <li>{@link TenantProfileUpdateResult#getAffectedTenants()}
   *   <li>{@link TenantProfileUpdateResult#getProfile()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantProfileUpdateResult.<init>(TenantProfile, Set)",
      "Set TenantProfileUpdateResult.getAffectedTenants()", "TenantProfile TenantProfileUpdateResult.getProfile()",
      "String TenantProfileUpdateResult.toString()"})
  void testGettersAndSetters() {
    // Arrange
    TenantProfile profile = new TenantProfile();
    HashSet<TenantId> affectedTenants = new HashSet<>();

    // Act
    TenantProfileUpdateResult actualTenantProfileUpdateResult = new TenantProfileUpdateResult(profile, affectedTenants);
    String actualToStringResult = actualTenantProfileUpdateResult.toString();
    Set<TenantId> actualAffectedTenants = actualTenantProfileUpdateResult.getAffectedTenants();
    TenantProfile actualProfile = actualTenantProfileUpdateResult.getProfile();

    // Assert
    assertEquals("TenantProfileUpdateResult(profile=TenantProfile(name=null, description=null, isDefault=false,"
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
        + " affectedTenants=[])", actualToStringResult);
    assertTrue(actualAffectedTenants.isEmpty());
    assertSame(affectedTenants, actualAffectedTenants);
    assertSame(profile, actualProfile);
  }
}
