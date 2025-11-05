package org.thingsboard.server.dao.aspect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

class DbCallStatsDiffblueTest {
  /**
   * Test {@link DbCallStats#onMethodCall(String, boolean, long)}.
   *
   * <ul>
   *   <li>Then {@link DbCallStats#DbCallStats(TenantId)} with tenantId is {@link
   *       ModelConstants#SYSTEM_TENANT} FailureCalls is zero.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStats#onMethodCall(String, boolean, long)}
   */
  @Test
  @DisplayName(
      "Test onMethodCall(String, boolean, long); then DbCallStats(TenantId) with tenantId is SYSTEM_TENANT FailureCalls is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DbCallStats.onMethodCall(String, boolean, long)"})
  void testOnMethodCall_thenDbCallStatsWithTenantIdIsSystem_tenantFailureCallsIsZero() {
    // Arrange
    DbCallStats dbCallStats = new DbCallStats(ModelConstants.SYSTEM_TENANT);

    // Act
    dbCallStats.onMethodCall("Method Name", true, 1L);

    // Assert
    AtomicInteger failureCalls = dbCallStats.getFailureCalls();
    assertEquals(0, failureCalls.get());
    ConcurrentMap<String, MethodCallStats> methodStats = dbCallStats.getMethodStats();
    assertEquals(1, methodStats.size());
    MethodCallStats getResult = methodStats.get("Method Name");
    AtomicInteger failures = getResult.getFailures();
    assertEquals(0, failures.get());
    assertEquals(0, failureCalls.getAcquire());
    assertEquals(0, failures.getAcquire());
    assertEquals(0, failureCalls.getOpaque());
    assertEquals(0, failures.getOpaque());
    assertEquals(0, failureCalls.getPlain());
    assertEquals(0, failures.getPlain());
    assertEquals(0, getResult.snapshot().getFailures());
    AtomicInteger successCalls = dbCallStats.getSuccessCalls();
    assertEquals(1, successCalls.get());
    assertEquals(1, successCalls.getAcquire());
    assertEquals(1, successCalls.getOpaque());
    assertEquals(1, successCalls.getPlain());
  }

  /**
   * Test {@link DbCallStats#onMethodCall(String, boolean, long)}.
   *
   * <ul>
   *   <li>Then {@link DbCallStats#DbCallStats(TenantId)} with tenantId is {@link
   *       ModelConstants#SYSTEM_TENANT} SuccessCalls is zero.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStats#onMethodCall(String, boolean, long)}
   */
  @Test
  @DisplayName(
      "Test onMethodCall(String, boolean, long); then DbCallStats(TenantId) with tenantId is SYSTEM_TENANT SuccessCalls is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DbCallStats.onMethodCall(String, boolean, long)"})
  void testOnMethodCall_thenDbCallStatsWithTenantIdIsSystem_tenantSuccessCallsIsZero() {
    // Arrange
    DbCallStats dbCallStats = new DbCallStats(ModelConstants.SYSTEM_TENANT);

    // Act
    dbCallStats.onMethodCall("Method Name", false, 1L);

    // Assert
    AtomicInteger successCalls = dbCallStats.getSuccessCalls();
    assertEquals(0, successCalls.get());
    assertEquals(0, successCalls.getAcquire());
    assertEquals(0, successCalls.getOpaque());
    assertEquals(0, successCalls.getPlain());
    ConcurrentMap<String, MethodCallStats> methodStats = dbCallStats.getMethodStats();
    assertEquals(1, methodStats.size());
    AtomicInteger failureCalls = dbCallStats.getFailureCalls();
    assertEquals(1, failureCalls.get());
    MethodCallStats getResult = methodStats.get("Method Name");
    AtomicInteger failures = getResult.getFailures();
    assertEquals(1, failures.get());
    assertEquals(1, failureCalls.getAcquire());
    assertEquals(1, failures.getAcquire());
    assertEquals(1, failureCalls.getOpaque());
    assertEquals(1, failures.getOpaque());
    assertEquals(1, failureCalls.getPlain());
    assertEquals(1, failures.getPlain());
    assertEquals(1, getResult.snapshot().getFailures());
  }

  /**
   * Test {@link DbCallStats#snapshot()}.
   *
   * <p>Method under test: {@link DbCallStats#snapshot()}
   */
  @Test
  @DisplayName("Test snapshot()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DbCallStatsSnapshot DbCallStats.snapshot()"})
  void testSnapshot() {
    // Arrange and Act
    DbCallStatsSnapshot actualSnapshotResult =
        new DbCallStats(ModelConstants.SYSTEM_TENANT).snapshot();

    // Assert
    TenantId tenantId = actualSnapshotResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(0, actualSnapshotResult.getTotalCalls());
    assertEquals(0, actualSnapshotResult.getTotalFailure());
    assertEquals(0, actualSnapshotResult.getTotalSuccess());
    assertEquals(0L, actualSnapshotResult.getTotalTiming());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(actualSnapshotResult.getMethodStats().isEmpty());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link DbCallStats#equals(Object)}, and {@link DbCallStats#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DbCallStats#equals(Object)}
   *   <li>{@link DbCallStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DbCallStats dbCallStats = new DbCallStats(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertEquals(dbCallStats, dbCallStats);
    int expectedHashCodeResult = dbCallStats.hashCode();
    assertEquals(expectedHashCodeResult, dbCallStats.hashCode());
  }

  /**
   * Test {@link DbCallStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DbCallStats dbCallStats = new DbCallStats(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertNotEquals(dbCallStats, new DbCallStats(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link DbCallStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DbCallStats dbCallStats = new DbCallStats(tenantId);

    // Act and Assert
    assertNotEquals(dbCallStats, new DbCallStats(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link DbCallStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DbCallStats dbCallStats = new DbCallStats(null);

    // Act and Assert
    assertNotEquals(dbCallStats, new DbCallStats(ModelConstants.SYSTEM_TENANT));
  }

  /**
   * Test {@link DbCallStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DbCallStats dbCallStats = new DbCallStats(null);

    // Act and Assert
    assertNotEquals(dbCallStats, new DbCallStats(null));
  }

  /**
   * Test {@link DbCallStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DbCallStats(ModelConstants.SYSTEM_TENANT), null);
  }

  /**
   * Test {@link DbCallStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DbCallStats(ModelConstants.SYSTEM_TENANT), "Different type to DbCallStats");
  }
}
