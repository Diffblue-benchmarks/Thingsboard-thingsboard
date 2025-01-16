package org.thingsboard.server.dao.aspect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class MethodCallStatsDiffblueTest {
  /**
   * Test {@link MethodCallStats#snapshot()}.
   * <p>
   * Method under test: {@link MethodCallStats#snapshot()}
   */
  @Test
  public void testSnapshot() {
    // Arrange and Act
    MethodCallStatsSnapshot actualSnapshotResult = (new MethodCallStats()).snapshot();

    // Assert
    assertEquals(0, actualSnapshotResult.getExecutions());
    assertEquals(0, actualSnapshotResult.getFailures());
    assertEquals(0L, actualSnapshotResult.getTiming());
  }

  /**
   * Test {@link MethodCallStats#equals(Object)}, and
   * {@link MethodCallStats#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MethodCallStats#equals(Object)}
   *   <li>{@link MethodCallStats#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodCallStats methodCallStats = new MethodCallStats();

    // Act and Assert
    assertEquals(methodCallStats, methodCallStats);
    int expectedHashCodeResult = methodCallStats.hashCode();
    assertEquals(expectedHashCodeResult, methodCallStats.hashCode());
  }

  /**
   * Test {@link MethodCallStats#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MethodCallStats#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodCallStats methodCallStats = new MethodCallStats();

    // Act and Assert
    assertNotEquals(methodCallStats, new MethodCallStats());
  }

  /**
   * Test {@link MethodCallStats#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MethodCallStats#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodCallStats(), null);
  }

  /**
   * Test {@link MethodCallStats#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MethodCallStats#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodCallStats(), "Different type to MethodCallStats");
  }
}
