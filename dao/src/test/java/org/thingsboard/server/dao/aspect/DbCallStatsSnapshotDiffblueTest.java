package org.thingsboard.server.dao.aspect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.aspect.DbCallStatsSnapshot.DbCallStatsSnapshotBuilder;
import org.thingsboard.server.dao.model.ModelConstants;

public class DbCallStatsSnapshotDiffblueTest {
  /**
   * Test DbCallStatsSnapshotBuilder {@link DbCallStatsSnapshotBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DbCallStatsSnapshot.DbCallStatsSnapshotBuilder#build()}
   *   <li>{@link DbCallStatsSnapshot.DbCallStatsSnapshotBuilder#methodStats(Map)}
   *   <li>{@link DbCallStatsSnapshot.DbCallStatsSnapshotBuilder#tenantId(TenantId)}
   *   <li>{@link DbCallStatsSnapshot.DbCallStatsSnapshotBuilder#totalFailure(int)}
   *   <li>{@link DbCallStatsSnapshot.DbCallStatsSnapshotBuilder#totalSuccess(int)}
   *   <li>{@link DbCallStatsSnapshot.DbCallStatsSnapshotBuilder#totalTiming(long)}
   * </ul>
   */
  @Test
  public void testDbCallStatsSnapshotBuilderBuild() {
    // Arrange
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    HashMap<String, MethodCallStatsSnapshot> methodStats = new HashMap<>();

    // Act
    DbCallStatsSnapshot actualBuildResult = builderResult.methodStats(methodStats)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();

    // Assert
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(1, actualBuildResult.getTotalFailure());
    assertEquals(1, actualBuildResult.getTotalSuccess());
    assertEquals(1L, actualBuildResult.getTotalTiming());
    assertEquals(2, actualBuildResult.getTotalCalls());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    Map<String, MethodCallStatsSnapshot> methodStats2 = actualBuildResult.getMethodStats();
    assertTrue(methodStats2.isEmpty());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(methodStats, methodStats2);
  }

  /**
   * Test {@link DbCallStatsSnapshot#getTotalCalls()}.
   * <p>
   * Method under test: {@link DbCallStatsSnapshot#getTotalCalls()}
   */
  @Test
  public void testGetTotalCalls() {
    // Arrange, Act and Assert
    assertEquals(2, (new DbCallStatsSnapshot(ModelConstants.SYSTEM_TENANT, 1, 1, 1L, new HashMap<>())).getTotalCalls());
  }

  /**
   * Test {@link DbCallStatsSnapshot#getTotalCalls()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DbCallStatsSnapshot#getTotalCalls()}
   */
  @Test
  public void testGetTotalCalls_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, MethodCallStatsSnapshot> methodStats = new HashMap<>();
    methodStats.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals(2, (new DbCallStatsSnapshot(ModelConstants.SYSTEM_TENANT, 1, 1, 1L, methodStats)).getTotalCalls());
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}, and
   * {@link DbCallStatsSnapshot#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DbCallStatsSnapshot#equals(Object)}
   *   <li>{@link DbCallStatsSnapshot#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot buildResult = builderResult.methodStats(new HashMap<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder builderResult2 = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot buildResult2 = builderResult2.methodStats(new HashMap<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}, and
   * {@link DbCallStatsSnapshot#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DbCallStatsSnapshot#equals(Object)}
   *   <li>{@link DbCallStatsSnapshot#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot buildResult = builderResult.methodStats(new HashMap<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DbCallStatsSnapshot#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder dbCallStatsSnapshotBuilder = mock(
        DbCallStatsSnapshot.DbCallStatsSnapshotBuilder.class);
    when(dbCallStatsSnapshotBuilder.methodStats(Mockito.<Map<String, MethodCallStatsSnapshot>>any()))
        .thenReturn(DbCallStatsSnapshot.builder());
    DbCallStatsSnapshot buildResult = dbCallStatsSnapshotBuilder.methodStats(new HashMap<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot buildResult2 = builderResult.methodStats(new HashMap<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DbCallStatsSnapshot#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder dbCallStatsSnapshotBuilder = mock(
        DbCallStatsSnapshot.DbCallStatsSnapshotBuilder.class);
    when(dbCallStatsSnapshotBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(DbCallStatsSnapshot.builder());
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder dbCallStatsSnapshotBuilder2 = mock(
        DbCallStatsSnapshot.DbCallStatsSnapshotBuilder.class);
    when(dbCallStatsSnapshotBuilder2.methodStats(Mockito.<Map<String, MethodCallStatsSnapshot>>any()))
        .thenReturn(dbCallStatsSnapshotBuilder);
    DbCallStatsSnapshot buildResult = dbCallStatsSnapshotBuilder2.methodStats(new HashMap<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot buildResult2 = builderResult.methodStats(new HashMap<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DbCallStatsSnapshot#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder dbCallStatsSnapshotBuilder = mock(
        DbCallStatsSnapshot.DbCallStatsSnapshotBuilder.class);
    when(dbCallStatsSnapshotBuilder.totalFailure(anyInt())).thenReturn(DbCallStatsSnapshot.builder());
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder dbCallStatsSnapshotBuilder2 = mock(
        DbCallStatsSnapshot.DbCallStatsSnapshotBuilder.class);
    when(dbCallStatsSnapshotBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(dbCallStatsSnapshotBuilder);
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder dbCallStatsSnapshotBuilder3 = mock(
        DbCallStatsSnapshot.DbCallStatsSnapshotBuilder.class);
    when(dbCallStatsSnapshotBuilder3.methodStats(Mockito.<Map<String, MethodCallStatsSnapshot>>any()))
        .thenReturn(dbCallStatsSnapshotBuilder2);
    DbCallStatsSnapshot buildResult = dbCallStatsSnapshotBuilder3.methodStats(new HashMap<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot buildResult2 = builderResult.methodStats(new HashMap<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DbCallStatsSnapshot#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder dbCallStatsSnapshotBuilder = mock(
        DbCallStatsSnapshot.DbCallStatsSnapshotBuilder.class);
    when(dbCallStatsSnapshotBuilder.totalSuccess(anyInt())).thenReturn(DbCallStatsSnapshot.builder());
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder dbCallStatsSnapshotBuilder2 = mock(
        DbCallStatsSnapshot.DbCallStatsSnapshotBuilder.class);
    when(dbCallStatsSnapshotBuilder2.totalFailure(anyInt())).thenReturn(dbCallStatsSnapshotBuilder);
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder dbCallStatsSnapshotBuilder3 = mock(
        DbCallStatsSnapshot.DbCallStatsSnapshotBuilder.class);
    when(dbCallStatsSnapshotBuilder3.tenantId(Mockito.<TenantId>any())).thenReturn(dbCallStatsSnapshotBuilder2);
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder dbCallStatsSnapshotBuilder4 = mock(
        DbCallStatsSnapshot.DbCallStatsSnapshotBuilder.class);
    when(dbCallStatsSnapshotBuilder4.methodStats(Mockito.<Map<String, MethodCallStatsSnapshot>>any()))
        .thenReturn(dbCallStatsSnapshotBuilder3);
    DbCallStatsSnapshot buildResult = dbCallStatsSnapshotBuilder4.methodStats(new HashMap<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot buildResult2 = builderResult.methodStats(new HashMap<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DbCallStatsSnapshot#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot buildResult = builderResult.methodStats(new HashMap<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link DbCallStatsSnapshot#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DbCallStatsSnapshot#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    DbCallStatsSnapshot buildResult = builderResult.methodStats(new HashMap<>())
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to DbCallStatsSnapshot");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange
    DbCallStatsSnapshot.DbCallStatsSnapshotBuilder builderResult = DbCallStatsSnapshot.builder();
    HashMap<String, MethodCallStatsSnapshot> methodStats = new HashMap<>();
    DbCallStatsSnapshot buildResult = builderResult.methodStats(methodStats)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .totalFailure(1)
        .totalSuccess(1)
        .totalTiming(1L)
        .build();

    // Act
    String actualToStringResult = buildResult.toString();
    Map<String, MethodCallStatsSnapshot> actualMethodStats = buildResult.getMethodStats();
    TenantId actualTenantId = buildResult.getTenantId();
    int actualTotalFailure = buildResult.getTotalFailure();
    int actualTotalSuccess = buildResult.getTotalSuccess();

    // Assert
    assertEquals("DbCallStatsSnapshot(tenantId=13814000-1dd2-11b2-8080-808080808080, totalSuccess=1, totalFailure=1,"
        + " totalTiming=1, methodStats={})", actualToStringResult);
    assertEquals(1, actualTotalFailure);
    assertEquals(1, actualTotalSuccess);
    assertEquals(1L, buildResult.getTotalTiming());
    assertTrue(actualMethodStats.isEmpty());
    assertSame(methodStats, actualMethodStats);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test
   * {@link DbCallStatsSnapshot#DbCallStatsSnapshot(TenantId, int, int, long, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DbCallStatsSnapshot#DbCallStatsSnapshot(TenantId, int, int, long, Map)}
   */
  @Test
  public void testNewDbCallStatsSnapshot_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    HashMap<String, MethodCallStatsSnapshot> methodStats = new HashMap<>();
    methodStats.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    DbCallStatsSnapshot actualDbCallStatsSnapshot = new DbCallStatsSnapshot(tenantId, 1, 1, 1L, methodStats);

    // Assert
    assertEquals(1, actualDbCallStatsSnapshot.getTotalFailure());
    assertEquals(1, actualDbCallStatsSnapshot.getTotalSuccess());
    assertEquals(1L, actualDbCallStatsSnapshot.getTotalTiming());
    assertEquals(2, actualDbCallStatsSnapshot.getTotalCalls());
    assertTrue(actualDbCallStatsSnapshot.getMethodStats().isEmpty());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualDbCallStatsSnapshot.getTenantId());
  }

  /**
   * Test
   * {@link DbCallStatsSnapshot#DbCallStatsSnapshot(TenantId, int, int, long, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DbCallStatsSnapshot#DbCallStatsSnapshot(TenantId, int, int, long, Map)}
   */
  @Test
  public void testNewDbCallStatsSnapshot_whenHashMap() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    DbCallStatsSnapshot actualDbCallStatsSnapshot = new DbCallStatsSnapshot(tenantId, 1, 1, 1L, new HashMap<>());

    // Assert
    assertEquals(1, actualDbCallStatsSnapshot.getTotalFailure());
    assertEquals(1, actualDbCallStatsSnapshot.getTotalSuccess());
    assertEquals(1L, actualDbCallStatsSnapshot.getTotalTiming());
    assertEquals(2, actualDbCallStatsSnapshot.getTotalCalls());
    assertTrue(actualDbCallStatsSnapshot.getMethodStats().isEmpty());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualDbCallStatsSnapshot.getTenantId());
  }
}
