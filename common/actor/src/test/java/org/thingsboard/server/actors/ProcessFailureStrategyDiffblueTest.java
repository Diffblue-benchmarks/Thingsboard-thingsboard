package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProcessFailureStrategyDiffblueTest {
  /**
   * Test {@link ProcessFailureStrategy#stop()}.
   * <p>
   * Method under test: {@link ProcessFailureStrategy#stop()}
   */
  @Test
  @DisplayName("Test stop()")
  void testStop() {
    // Arrange, Act and Assert
    assertTrue(ProcessFailureStrategy.stop().isStop());
  }

  /**
   * Test {@link ProcessFailureStrategy#resume()}.
   * <p>
   * Method under test: {@link ProcessFailureStrategy#resume()}
   */
  @Test
  @DisplayName("Test resume()")
  void testResume() {
    // Arrange, Act and Assert
    assertFalse(ProcessFailureStrategy.resume().isStop());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProcessFailureStrategy#toString()}
   *   <li>{@link ProcessFailureStrategy#isStop()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    ProcessFailureStrategy resumeResult = ProcessFailureStrategy.resume();

    // Act
    String actualToStringResult = resumeResult.toString();

    // Assert
    assertEquals("ProcessFailureStrategy(stop=false)", actualToStringResult);
    assertFalse(resumeResult.isStop());
  }
}
