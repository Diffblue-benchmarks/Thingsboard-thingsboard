package org.thingsboard.server.common.transport.activity.strategy;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AllEventsActivityStrategyDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Method under test: {@link AllEventsActivityStrategy#getInstance()}
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AllEventsActivityStrategy actualInstance = AllEventsActivityStrategy.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance.getInstance());
  }

  /**
   * Test {@link AllEventsActivityStrategy#onActivity()}.
   * <p>
   * Method under test: {@link AllEventsActivityStrategy#onActivity()}
   */
  @Test
  @DisplayName("Test onActivity()")
  void testOnActivity() {
    // Arrange, Act and Assert
    assertTrue(AllEventsActivityStrategy.getInstance().onActivity());
  }

  /**
   * Test {@link AllEventsActivityStrategy#onReportingPeriodEnd()}.
   * <p>
   * Method under test: {@link AllEventsActivityStrategy#onReportingPeriodEnd()}
   */
  @Test
  @DisplayName("Test onReportingPeriodEnd()")
  void testOnReportingPeriodEnd() {
    // Arrange, Act and Assert
    assertTrue(AllEventsActivityStrategy.getInstance().onReportingPeriodEnd());
  }
}
