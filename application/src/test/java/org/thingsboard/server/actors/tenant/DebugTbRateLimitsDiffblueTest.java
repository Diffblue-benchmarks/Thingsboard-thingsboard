package org.thingsboard.server.actors.tenant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
  @Tag("MaintainedByDiffblue")
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
    int expectedHashCodeResult = debugTbRateLimits.hashCode();
    assertEquals(expectedHashCodeResult, debugTbRateLimits2.hashCode());
  }
}
