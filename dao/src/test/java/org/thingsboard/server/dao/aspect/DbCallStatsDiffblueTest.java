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
package org.thingsboard.server.dao.aspect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DbCallStats.onMethodCall(String, boolean, long)"})
  public void testOnMethodCall_thenDbCallStatsWithTenantIdIsSystem_tenantFailureCallsIsZero() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DbCallStats.onMethodCall(String, boolean, long)"})
  public void testOnMethodCall_thenDbCallStatsWithTenantIdIsSystem_tenantSuccessCallsIsZero() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DbCallStats dbCallStats = new DbCallStats(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertNotEquals(dbCallStats, new DbCallStats(null));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DbCallStats.equals(Object)", "int DbCallStats.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DbCallStats(ModelConstants.SYSTEM_TENANT), "Different type to DbCallStats");
  }
}
