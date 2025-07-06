package org.thingsboard.server.dao.aspect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MethodCallStatsSnapshotDiffblueTest {
  /**
   * Test {@link MethodCallStatsSnapshot#equals(Object)}, and {@link
   * MethodCallStatsSnapshot#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodCallStatsSnapshot#equals(Object)}
   *   <li>{@link MethodCallStatsSnapshot#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodCallStatsSnapshot.equals(Object)",
    "int MethodCallStatsSnapshot.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MethodCallStatsSnapshot methodCallStatsSnapshot = new MethodCallStatsSnapshot(1, 1, 1L);
    MethodCallStatsSnapshot methodCallStatsSnapshot2 = new MethodCallStatsSnapshot(1, 1, 1L);

    // Act and Assert
    assertEquals(methodCallStatsSnapshot, methodCallStatsSnapshot2);
    int expectedHashCodeResult = methodCallStatsSnapshot.hashCode();
    assertEquals(expectedHashCodeResult, methodCallStatsSnapshot2.hashCode());
  }

  /**
   * Test {@link MethodCallStatsSnapshot#equals(Object)}, and {@link
   * MethodCallStatsSnapshot#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodCallStatsSnapshot#equals(Object)}
   *   <li>{@link MethodCallStatsSnapshot#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodCallStatsSnapshot.equals(Object)",
    "int MethodCallStatsSnapshot.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MethodCallStatsSnapshot methodCallStatsSnapshot = new MethodCallStatsSnapshot(1, 1, 1L);

    // Act and Assert
    assertEquals(methodCallStatsSnapshot, methodCallStatsSnapshot);
    int expectedHashCodeResult = methodCallStatsSnapshot.hashCode();
    assertEquals(expectedHashCodeResult, methodCallStatsSnapshot.hashCode());
  }

  /**
   * Test {@link MethodCallStatsSnapshot#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodCallStatsSnapshot#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodCallStatsSnapshot.equals(Object)",
    "int MethodCallStatsSnapshot.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MethodCallStatsSnapshot methodCallStatsSnapshot = new MethodCallStatsSnapshot(3, 1, 1L);

    // Act and Assert
    assertNotEquals(methodCallStatsSnapshot, new MethodCallStatsSnapshot(1, 1, 1L));
  }

  /**
   * Test {@link MethodCallStatsSnapshot#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodCallStatsSnapshot#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodCallStatsSnapshot.equals(Object)",
    "int MethodCallStatsSnapshot.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MethodCallStatsSnapshot methodCallStatsSnapshot = new MethodCallStatsSnapshot(1, 3, 1L);

    // Act and Assert
    assertNotEquals(methodCallStatsSnapshot, new MethodCallStatsSnapshot(1, 1, 1L));
  }

  /**
   * Test {@link MethodCallStatsSnapshot#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodCallStatsSnapshot#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodCallStatsSnapshot.equals(Object)",
    "int MethodCallStatsSnapshot.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MethodCallStatsSnapshot methodCallStatsSnapshot = new MethodCallStatsSnapshot(1, 1, 3L);

    // Act and Assert
    assertNotEquals(methodCallStatsSnapshot, new MethodCallStatsSnapshot(1, 1, 1L));
  }

  /**
   * Test {@link MethodCallStatsSnapshot#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodCallStatsSnapshot#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodCallStatsSnapshot.equals(Object)",
    "int MethodCallStatsSnapshot.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MethodCallStatsSnapshot(1, 1, 1L), null);
  }

  /**
   * Test {@link MethodCallStatsSnapshot#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MethodCallStatsSnapshot#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean MethodCallStatsSnapshot.equals(Object)",
    "int MethodCallStatsSnapshot.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new MethodCallStatsSnapshot(1, 1, 1L), "Different type to MethodCallStatsSnapshot");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodCallStatsSnapshot#MethodCallStatsSnapshot(int, int, long)}
   *   <li>{@link MethodCallStatsSnapshot#toString()}
   *   <li>{@link MethodCallStatsSnapshot#getExecutions()}
   *   <li>{@link MethodCallStatsSnapshot#getFailures()}
   *   <li>{@link MethodCallStatsSnapshot#getTiming()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodCallStatsSnapshot.<init>(int, int, long)",
    "int MethodCallStatsSnapshot.getExecutions()",
    "int MethodCallStatsSnapshot.getFailures()",
    "long MethodCallStatsSnapshot.getTiming()",
    "String MethodCallStatsSnapshot.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MethodCallStatsSnapshot actualMethodCallStatsSnapshot = new MethodCallStatsSnapshot(1, 1, 1L);
    String actualToStringResult = actualMethodCallStatsSnapshot.toString();
    int actualExecutions = actualMethodCallStatsSnapshot.getExecutions();
    int actualFailures = actualMethodCallStatsSnapshot.getFailures();

    // Assert
    assertEquals(
        "MethodCallStatsSnapshot(executions=1, failures=1, timing=1)", actualToStringResult);
    assertEquals(1, actualExecutions);
    assertEquals(1, actualFailures);
    assertEquals(1L, actualMethodCallStatsSnapshot.getTiming());
  }
}
