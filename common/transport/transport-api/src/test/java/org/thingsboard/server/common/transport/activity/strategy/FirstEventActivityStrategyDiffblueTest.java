package org.thingsboard.server.common.transport.activity.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FirstEventActivityStrategyDiffblueTest {
  /**
   * Test {@link FirstEventActivityStrategy#onActivity()}.
   *
   * <p>Method under test: {@link FirstEventActivityStrategy#onActivity()}
   */
  @Test
  @DisplayName("Test onActivity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FirstEventActivityStrategy.onActivity()"})
  void testOnActivity() {
    // Arrange, Act and Assert
    assertTrue(new FirstEventActivityStrategy().onActivity());
  }

  /**
   * Test {@link FirstEventActivityStrategy#equals(Object)}, and {@link
   * FirstEventActivityStrategy#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FirstEventActivityStrategy#equals(Object)}
   *   <li>{@link FirstEventActivityStrategy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FirstEventActivityStrategy.equals(Object)",
    "int FirstEventActivityStrategy.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FirstEventActivityStrategy firstEventActivityStrategy = new FirstEventActivityStrategy();
    FirstEventActivityStrategy firstEventActivityStrategy2 = new FirstEventActivityStrategy();

    // Act and Assert
    assertEquals(firstEventActivityStrategy, firstEventActivityStrategy2);
    assertEquals(firstEventActivityStrategy.hashCode(), firstEventActivityStrategy2.hashCode());
  }

  /**
   * Test {@link FirstEventActivityStrategy#equals(Object)}, and {@link
   * FirstEventActivityStrategy#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FirstEventActivityStrategy#equals(Object)}
   *   <li>{@link FirstEventActivityStrategy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FirstEventActivityStrategy.equals(Object)",
    "int FirstEventActivityStrategy.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FirstEventActivityStrategy firstEventActivityStrategy = new FirstEventActivityStrategy();

    // Act and Assert
    assertEquals(firstEventActivityStrategy, firstEventActivityStrategy);
    int expectedHashCodeResult = firstEventActivityStrategy.hashCode();
    assertEquals(expectedHashCodeResult, firstEventActivityStrategy.hashCode());
  }

  /**
   * Test {@link FirstEventActivityStrategy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FirstEventActivityStrategy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FirstEventActivityStrategy.equals(Object)",
    "int FirstEventActivityStrategy.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FirstEventActivityStrategy(), 1);
  }

  /**
   * Test {@link FirstEventActivityStrategy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FirstEventActivityStrategy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FirstEventActivityStrategy.equals(Object)",
    "int FirstEventActivityStrategy.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FirstEventActivityStrategy(), null);
  }

  /**
   * Test {@link FirstEventActivityStrategy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FirstEventActivityStrategy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FirstEventActivityStrategy.equals(Object)",
    "int FirstEventActivityStrategy.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new FirstEventActivityStrategy(), "Different type to FirstEventActivityStrategy");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FirstEventActivityStrategy}
   *   <li>{@link FirstEventActivityStrategy#onReportingPeriodEnd()}
   *   <li>{@link FirstEventActivityStrategy#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FirstEventActivityStrategy.<init>()",
    "boolean FirstEventActivityStrategy.onReportingPeriodEnd()",
    "java.lang.String FirstEventActivityStrategy.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    FirstEventActivityStrategy actualFirstEventActivityStrategy = new FirstEventActivityStrategy();
    boolean actualOnReportingPeriodEndResult =
        actualFirstEventActivityStrategy.onReportingPeriodEnd();

    // Assert
    assertEquals(
        "FirstEventActivityStrategy(firstEventReceived=false)",
        actualFirstEventActivityStrategy.toString());
    assertFalse(actualOnReportingPeriodEndResult);
  }
}
