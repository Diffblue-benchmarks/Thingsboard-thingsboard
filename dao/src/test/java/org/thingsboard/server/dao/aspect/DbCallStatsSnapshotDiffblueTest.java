package org.thingsboard.server.dao.aspect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.aspect.DbCallStatsSnapshot.DbCallStatsSnapshotBuilder;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {DbCallStatsSnapshotBuilder.class})
@ExtendWith(SpringExtension.class)
class DbCallStatsSnapshotDiffblueTest {
  @Autowired private DbCallStatsSnapshotBuilder dbCallStatsSnapshotBuilder;

  /**
   * Test DbCallStatsSnapshotBuilder {@link DbCallStatsSnapshotBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DbCallStatsSnapshotBuilder#build()}
   *   <li>{@link DbCallStatsSnapshotBuilder#methodStats(Map)}
   *   <li>{@link DbCallStatsSnapshotBuilder#tenantId(TenantId)}
   *   <li>{@link DbCallStatsSnapshotBuilder#totalFailure(int)}
   *   <li>{@link DbCallStatsSnapshotBuilder#totalSuccess(int)}
   *   <li>{@link DbCallStatsSnapshotBuilder#totalTiming(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test DbCallStatsSnapshotBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DbCallStatsSnapshotBuilder.<init>()",
    "DbCallStatsSnapshot DbCallStatsSnapshotBuilder.build()",
    "DbCallStatsSnapshotBuilder DbCallStatsSnapshotBuilder.methodStats(Map)",
    "DbCallStatsSnapshotBuilder DbCallStatsSnapshotBuilder.tenantId(TenantId)",
    "String DbCallStatsSnapshotBuilder.toString()",
    "DbCallStatsSnapshotBuilder DbCallStatsSnapshotBuilder.totalFailure(int)",
    "DbCallStatsSnapshotBuilder DbCallStatsSnapshotBuilder.totalSuccess(int)",
    "DbCallStatsSnapshotBuilder DbCallStatsSnapshotBuilder.totalTiming(long)"
  })
  void testDbCallStatsSnapshotBuilderBuild() {
    // Arrange and Act
    DbCallStatsSnapshotBuilder actualBuilderResult = DbCallStatsSnapshot.builder();
    HashMap<String, MethodCallStatsSnapshot> methodStats = new HashMap<>();
    DbCallStatsSnapshot actualDbCallStatsSnapshot =
        actualBuilderResult
            .methodStats(methodStats)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build();

    // Assert
    assertEquals(1, actualDbCallStatsSnapshot.getTotalFailure());
    assertEquals(1, actualDbCallStatsSnapshot.getTotalSuccess());
    assertEquals(1L, actualDbCallStatsSnapshot.getTotalTiming());
    assertEquals(2, actualDbCallStatsSnapshot.getTotalCalls());
    Map<String, MethodCallStatsSnapshot> methodStats2 = actualDbCallStatsSnapshot.getMethodStats();
    assertTrue(methodStats2.isEmpty());
    assertSame(methodStats, methodStats2);
    assertSame(TenantId.SYS_TENANT_ID, actualDbCallStatsSnapshot.getTenantId());
  }

  /**
   * Test {@link DbCallStatsSnapshot#getTotalCalls()}.
   *
   * <p>Method under test: {@link DbCallStatsSnapshot#getTotalCalls()}
   */
  @Test
  @DisplayName("Test getTotalCalls()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DbCallStatsSnapshot.getTotalCalls()"})
  void testGetTotalCalls() {
    // Arrange
    DbCallStatsSnapshot dbCallStatsSnapshot =
        new DbCallStatsSnapshot(ModelConstants.SYSTEM_TENANT, 1, 1, 1L, new HashMap<>());

    // Act and Assert
    assertEquals(2, dbCallStatsSnapshot.getTotalCalls());
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}, and {@link DbCallStatsSnapshot#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DbCallStatsSnapshot#equals(Object)}
   *   <li>{@link DbCallStatsSnapshot#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DbCallStatsSnapshot.equals(Object)",
    "int DbCallStatsSnapshot.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot dbCallStatsSnapshot =
        builderResult
            .methodStats(new HashMap<>())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build();

    DbCallStatsSnapshotBuilder builderResult2 = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot dbCallStatsSnapshot2 =
        builderResult2
            .methodStats(new HashMap<>())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build();

    // Act and Assert
    assertEquals(dbCallStatsSnapshot, dbCallStatsSnapshot2);
    assertEquals(dbCallStatsSnapshot.hashCode(), dbCallStatsSnapshot2.hashCode());
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}, and {@link DbCallStatsSnapshot#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DbCallStatsSnapshot#equals(Object)}
   *   <li>{@link DbCallStatsSnapshot#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DbCallStatsSnapshot.equals(Object)",
    "int DbCallStatsSnapshot.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot dbCallStatsSnapshot =
        builderResult
            .methodStats(new HashMap<>())
            .tenantId(null)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build();

    DbCallStatsSnapshotBuilder builderResult2 = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot dbCallStatsSnapshot2 =
        builderResult2
            .methodStats(new HashMap<>())
            .tenantId(null)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build();

    // Act and Assert
    assertEquals(dbCallStatsSnapshot, dbCallStatsSnapshot2);
    assertEquals(dbCallStatsSnapshot.hashCode(), dbCallStatsSnapshot2.hashCode());
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}, and {@link DbCallStatsSnapshot#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DbCallStatsSnapshot#equals(Object)}
   *   <li>{@link DbCallStatsSnapshot#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DbCallStatsSnapshot.equals(Object)",
    "int DbCallStatsSnapshot.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot dbCallStatsSnapshot =
        builderResult
            .methodStats(new HashMap<>())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build();

    // Act and Assert
    assertEquals(dbCallStatsSnapshot, dbCallStatsSnapshot);
    int expectedHashCodeResult = dbCallStatsSnapshot.hashCode();
    assertEquals(expectedHashCodeResult, dbCallStatsSnapshot.hashCode());
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStatsSnapshot#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DbCallStatsSnapshot.equals(Object)",
    "int DbCallStatsSnapshot.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<String, MethodCallStatsSnapshot> methodStats = new HashMap<>();
    methodStats.put("Key", new MethodCallStatsSnapshot(1, 1, 1L));
    DbCallStatsSnapshot dbCallStatsSnapshot =
        DbCallStatsSnapshot.builder()
            .methodStats(methodStats)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build();

    DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();

    // Act and Assert
    assertNotEquals(
        dbCallStatsSnapshot,
        builderResult
            .methodStats(new HashMap<>())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build());
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStatsSnapshot#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DbCallStatsSnapshot.equals(Object)",
    "int DbCallStatsSnapshot.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();

    DbCallStatsSnapshotBuilder methodStatsResult = builderResult.methodStats(new HashMap<>());
    DbCallStatsSnapshot dbCallStatsSnapshot =
        methodStatsResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build();

    DbCallStatsSnapshotBuilder builderResult2 = DbCallStatsSnapshot.builder();

    // Act and Assert
    assertNotEquals(
        dbCallStatsSnapshot,
        builderResult2
            .methodStats(new HashMap<>())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build());
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStatsSnapshot#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DbCallStatsSnapshot.equals(Object)",
    "int DbCallStatsSnapshot.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot dbCallStatsSnapshot =
        builderResult
            .methodStats(new HashMap<>())
            .tenantId(null)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build();

    DbCallStatsSnapshotBuilder builderResult2 = DbCallStatsSnapshot.builder();

    // Act and Assert
    assertNotEquals(
        dbCallStatsSnapshot,
        builderResult2
            .methodStats(new HashMap<>())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build());
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStatsSnapshot#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DbCallStatsSnapshot.equals(Object)",
    "int DbCallStatsSnapshot.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot dbCallStatsSnapshot =
        builderResult
            .methodStats(new HashMap<>())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(3)
            .totalSuccess(1)
            .totalTiming(1L)
            .build();

    DbCallStatsSnapshotBuilder builderResult2 = DbCallStatsSnapshot.builder();

    // Act and Assert
    assertNotEquals(
        dbCallStatsSnapshot,
        builderResult2
            .methodStats(new HashMap<>())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build());
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStatsSnapshot#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DbCallStatsSnapshot.equals(Object)",
    "int DbCallStatsSnapshot.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot dbCallStatsSnapshot =
        builderResult
            .methodStats(new HashMap<>())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(3)
            .totalTiming(1L)
            .build();

    DbCallStatsSnapshotBuilder builderResult2 = DbCallStatsSnapshot.builder();

    // Act and Assert
    assertNotEquals(
        dbCallStatsSnapshot,
        builderResult2
            .methodStats(new HashMap<>())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build());
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStatsSnapshot#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DbCallStatsSnapshot.equals(Object)",
    "int DbCallStatsSnapshot.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot dbCallStatsSnapshot =
        builderResult
            .methodStats(new HashMap<>())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(3L)
            .build();

    DbCallStatsSnapshotBuilder builderResult2 = DbCallStatsSnapshot.builder();

    // Act and Assert
    assertNotEquals(
        dbCallStatsSnapshot,
        builderResult2
            .methodStats(new HashMap<>())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build());
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStatsSnapshot#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DbCallStatsSnapshot.equals(Object)",
    "int DbCallStatsSnapshot.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .methodStats(new HashMap<>())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build(),
        null);
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DbCallStatsSnapshot#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DbCallStatsSnapshot.equals(Object)",
    "int DbCallStatsSnapshot.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .methodStats(new HashMap<>())
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build(),
        "Different type to DbCallStatsSnapshot");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DbCallStatsSnapshot#toString()}
   *   <li>{@link DbCallStatsSnapshot#getMethodStats()}
   *   <li>{@link DbCallStatsSnapshot#getTenantId()}
   *   <li>{@link DbCallStatsSnapshot#getTotalFailure()}
   *   <li>{@link DbCallStatsSnapshot#getTotalSuccess()}
   *   <li>{@link DbCallStatsSnapshot#getTotalTiming()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DbCallStatsSnapshot.getMethodStats()",
    "TenantId DbCallStatsSnapshot.getTenantId()",
    "int DbCallStatsSnapshot.getTotalFailure()",
    "int DbCallStatsSnapshot.getTotalSuccess()",
    "long DbCallStatsSnapshot.getTotalTiming()",
    "String DbCallStatsSnapshot.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    HashMap<String, MethodCallStatsSnapshot> methodStats = new HashMap<>();
    DbCallStatsSnapshot dbCallStatsSnapshot =
        builderResult
            .methodStats(methodStats)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .totalFailure(1)
            .totalSuccess(1)
            .totalTiming(1L)
            .build();

    // Act
    String actualToStringResult = dbCallStatsSnapshot.toString();
    Map<String, MethodCallStatsSnapshot> actualMethodStats = dbCallStatsSnapshot.getMethodStats();
    TenantId actualTenantId = dbCallStatsSnapshot.getTenantId();
    int actualTotalFailure = dbCallStatsSnapshot.getTotalFailure();
    int actualTotalSuccess = dbCallStatsSnapshot.getTotalSuccess();

    // Assert
    assertEquals(
        "DbCallStatsSnapshot(tenantId=13814000-1dd2-11b2-8080-808080808080, totalSuccess=1, totalFailure=1,"
            + " totalTiming=1, methodStats={})",
        actualToStringResult);
    assertEquals(1, actualTotalFailure);
    assertEquals(1, actualTotalSuccess);
    assertEquals(1L, dbCallStatsSnapshot.getTotalTiming());
    assertTrue(actualMethodStats.isEmpty());
    assertSame(methodStats, actualMethodStats);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link DbCallStatsSnapshot#DbCallStatsSnapshot(TenantId, int, int, long, Map)}.
   *
   * <p>Method under test: {@link DbCallStatsSnapshot#DbCallStatsSnapshot(TenantId, int, int, long,
   * Map)}
   */
  @Test
  @DisplayName("Test new DbCallStatsSnapshot(TenantId, int, int, long, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DbCallStatsSnapshot.<init>(TenantId, int, int, long, Map)"})
  void testNewDbCallStatsSnapshot() {
    // Arrange and Act
    DbCallStatsSnapshot actualDbCallStatsSnapshot =
        new DbCallStatsSnapshot(ModelConstants.SYSTEM_TENANT, 1, 1, 1L, new HashMap<>());

    // Assert
    assertEquals(1, actualDbCallStatsSnapshot.getTotalFailure());
    assertEquals(1, actualDbCallStatsSnapshot.getTotalSuccess());
    assertEquals(1L, actualDbCallStatsSnapshot.getTotalTiming());
    assertEquals(2, actualDbCallStatsSnapshot.getTotalCalls());
    assertTrue(actualDbCallStatsSnapshot.getMethodStats().isEmpty());
    assertSame(TenantId.SYS_TENANT_ID, actualDbCallStatsSnapshot.getTenantId());
  }
}
