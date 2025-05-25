package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InitFailureStrategyDiffblueTest {
  /**
   * Test {@link InitFailureStrategy#retryImmediately()}.
   * <p>
   * Method under test: {@link InitFailureStrategy#retryImmediately()}
   */
  @Test
  @DisplayName("Test retryImmediately()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InitFailureStrategy InitFailureStrategy.retryImmediately()"})
  void testRetryImmediately() {
    // Arrange and Act
    InitFailureStrategy actualRetryImmediatelyResult = InitFailureStrategy.retryImmediately();

    // Assert
    assertEquals(0L, actualRetryImmediatelyResult.getRetryDelay());
    assertFalse(actualRetryImmediatelyResult.isStop());
  }

  /**
   * Test {@link InitFailureStrategy#retryWithDelay(long)}.
   * <p>
   * Method under test: {@link InitFailureStrategy#retryWithDelay(long)}
   */
  @Test
  @DisplayName("Test retryWithDelay(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InitFailureStrategy InitFailureStrategy.retryWithDelay(long)"})
  void testRetryWithDelay() {
    // Arrange and Act
    InitFailureStrategy actualRetryWithDelayResult = InitFailureStrategy.retryWithDelay(1L);

    // Assert
    assertEquals(1L, actualRetryWithDelayResult.getRetryDelay());
    assertFalse(actualRetryWithDelayResult.isStop());
  }

  /**
   * Test {@link InitFailureStrategy#stop()}.
   * <p>
   * Method under test: {@link InitFailureStrategy#stop()}
   */
  @Test
  @DisplayName("Test stop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InitFailureStrategy InitFailureStrategy.stop()"})
  void testStop() {
    // Arrange and Act
    InitFailureStrategy actualStopResult = InitFailureStrategy.stop();

    // Assert
    assertEquals(0L, actualStopResult.getRetryDelay());
    assertTrue(actualStopResult.isStop());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InitFailureStrategy#toString()}
   *   <li>{@link InitFailureStrategy#getRetryDelay()}
   *   <li>{@link InitFailureStrategy#isStop()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long InitFailureStrategy.getRetryDelay()", "boolean InitFailureStrategy.isStop()",
      "String InitFailureStrategy.toString()"})
  void testGettersAndSetters() {
    // Arrange
    InitFailureStrategy retryImmediatelyResult = InitFailureStrategy.retryImmediately();

    // Act
    String actualToStringResult = retryImmediatelyResult.toString();
    long actualRetryDelay = retryImmediatelyResult.getRetryDelay();

    // Assert
    assertEquals("InitFailureStrategy(stop=false, retryDelay=0)", actualToStringResult);
    assertEquals(0L, actualRetryDelay);
    assertFalse(retryImmediatelyResult.isStop());
  }
}
