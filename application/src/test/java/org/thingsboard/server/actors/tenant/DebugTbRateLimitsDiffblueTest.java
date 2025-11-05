package org.thingsboard.server.actors.tenant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.tools.TbRateLimits;

class DebugTbRateLimitsDiffblueTest {
  /**
   * Test {@link DebugTbRateLimits#equals(Object)}, and {@link DebugTbRateLimits#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DebugTbRateLimits#equals(Object)}
   *   <li>{@link DebugTbRateLimits#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DebugTbRateLimits.equals(Object)",
    "int DebugTbRateLimits.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DebugTbRateLimits debugTbRateLimits = new DebugTbRateLimits(null, true);
    DebugTbRateLimits debugTbRateLimits2 = new DebugTbRateLimits(null, true);

    // Act and Assert
    assertEquals(debugTbRateLimits, debugTbRateLimits2);
    assertEquals(debugTbRateLimits.hashCode(), debugTbRateLimits2.hashCode());
  }

  /**
   * Test {@link DebugTbRateLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DebugTbRateLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DebugTbRateLimits.equals(Object)",
    "int DebugTbRateLimits.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DebugTbRateLimits debugTbRateLimits = new DebugTbRateLimits(null, false);

    // Act and Assert
    assertNotEquals(debugTbRateLimits, new DebugTbRateLimits(null, true));
  }

  /**
   * Test {@link DebugTbRateLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DebugTbRateLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DebugTbRateLimits.equals(Object)",
    "int DebugTbRateLimits.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DebugTbRateLimits(null, true), 1);
  }

  /**
   * Test {@link DebugTbRateLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DebugTbRateLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DebugTbRateLimits.equals(Object)",
    "int DebugTbRateLimits.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DebugTbRateLimits debugTbRateLimits = new DebugTbRateLimits(mock(TbRateLimits.class), true);

    // Act and Assert
    assertNotEquals(debugTbRateLimits, new DebugTbRateLimits(null, true));
  }

  /**
   * Test {@link DebugTbRateLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DebugTbRateLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DebugTbRateLimits.equals(Object)",
    "int DebugTbRateLimits.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DebugTbRateLimits debugTbRateLimits = new DebugTbRateLimits(null, true);

    // Act and Assert
    assertNotEquals(debugTbRateLimits, new DebugTbRateLimits(mock(TbRateLimits.class), true));
  }
}
