package org.thingsboard.server.dao.aspect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class DbCallStatsDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DbCallStats.onMethodCall(String, boolean, long)"})
  public void testOnMethodCall_thenDbCallStatsWithTenantIdIsSystem_tenantFailureCallsIsZero() {
    // Arrange
    DbCallStats dbCallStats = new DbCallStats(ModelConstants.SYSTEM_TENANT);

    // Act
    dbCallStats.onMethodCall("Method Name", true, 1L);

    // Assert
    assertEquals(0, dbCallStats.getFailureCalls().get());
    ConcurrentMap<String, MethodCallStats> methodStats = dbCallStats.getMethodStats();
    assertEquals(1, methodStats.size());
    MethodCallStats getResult = methodStats.get("Method Name");
    assertEquals(0, getResult.getFailures().get());
    assertEquals(0, getResult.snapshot().getFailures());
    assertEquals(1, dbCallStats.getSuccessCalls().get());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DbCallStats.onMethodCall(String, boolean, long)"})
  public void testOnMethodCall_thenDbCallStatsWithTenantIdIsSystem_tenantSuccessCallsIsZero() {
    // Arrange
    DbCallStats dbCallStats = new DbCallStats(ModelConstants.SYSTEM_TENANT);

    // Act
    dbCallStats.onMethodCall("Method Name", false, 1L);

    // Assert
    assertEquals(0, dbCallStats.getSuccessCalls().get());
    ConcurrentMap<String, MethodCallStats> methodStats = dbCallStats.getMethodStats();
    assertEquals(1, methodStats.size());
    assertEquals(1, dbCallStats.getFailureCalls().get());
    MethodCallStats getResult = methodStats.get("Method Name");
    assertEquals(1, getResult.getFailures().get());
    assertEquals(1, getResult.snapshot().getFailures());
  }

  /**
   * Test {@link DbCallStats#snapshot()}.
   *
   * <p>Method under test: {@link DbCallStats#snapshot()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DbCallStatsSnapshot DbCallStats.snapshot()"})
  public void testSnapshot() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DbCallStats dbCallStats =
        new DbCallStats(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DbCallStats(ModelConstants.SYSTEM_TENANT), "Different type to DbCallStats");
  }
}
