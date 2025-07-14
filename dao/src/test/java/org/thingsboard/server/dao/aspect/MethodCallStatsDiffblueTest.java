package org.thingsboard.server.dao.aspect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MethodCallStatsDiffblueTest {
  /**
   * Test {@link MethodCallStats#snapshot()}.
   *
   * <p>Method under test: {@link MethodCallStats#snapshot()}
   */
  @Test
  @DisplayName("Test snapshot()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MethodCallStatsSnapshot MethodCallStats.snapshot()"})
  void testSnapshot() {
    // Arrange and Act
    MethodCallStatsSnapshot actualSnapshotResult = new MethodCallStats().snapshot();

    // Assert
    assertEquals(0, actualSnapshotResult.getExecutions());
    assertEquals(0, actualSnapshotResult.getFailures());
    assertEquals(0L, actualSnapshotResult.getTiming());
  }

  /**
   * Test {@link MethodCallStats#equals(Object)}, and {@link MethodCallStats#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodCallStats#equals(Object)}
   *   <li>{@link MethodCallStats#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MethodCallStats.equals(Object)", "int MethodCallStats.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodCallStats methodCallStats = new MethodCallStats();

    // Act and Assert
    assertEquals(methodCallStats, methodCallStats);
    int expectedHashCodeResult = methodCallStats.hashCode();
    assertEquals(expectedHashCodeResult, methodCallStats.hashCode());
  }

  /**
   * Test {@link MethodCallStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodCallStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MethodCallStats.equals(Object)", "int MethodCallStats.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodCallStats methodCallStats = new MethodCallStats();

    // Act and Assert
    assertNotEquals(methodCallStats, new MethodCallStats());
  }

  /**
   * Test {@link MethodCallStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodCallStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MethodCallStats.equals(Object)", "int MethodCallStats.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodCallStats(), null);
  }

  /**
   * Test {@link MethodCallStats#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodCallStats#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MethodCallStats.equals(Object)", "int MethodCallStats.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodCallStats(), "Different type to MethodCallStats");
  }
}
