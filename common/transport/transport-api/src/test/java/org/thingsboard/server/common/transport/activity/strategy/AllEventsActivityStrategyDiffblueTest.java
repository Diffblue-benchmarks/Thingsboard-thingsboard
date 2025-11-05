package org.thingsboard.server.common.transport.activity.strategy;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AllEventsActivityStrategyDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Method under test: {@link AllEventsActivityStrategy#getInstance()}
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AllEventsActivityStrategy AllEventsActivityStrategy.getInstance()"})
  void testGettersAndSetters() {
    // Arrange and Act
    AllEventsActivityStrategy actualInstance = AllEventsActivityStrategy.getInstance();
    AllEventsActivityStrategy actualInstance2 = actualInstance.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance2);
  }

  /**
   * Test {@link AllEventsActivityStrategy#onActivity()}.
   *
   * <p>Method under test: {@link AllEventsActivityStrategy#onActivity()}
   */
  @Test
  @DisplayName("Test onActivity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AllEventsActivityStrategy.onActivity()"})
  void testOnActivity() {
    // Arrange, Act and Assert
    assertTrue(AllEventsActivityStrategy.getInstance().onActivity());
  }

  /**
   * Test {@link AllEventsActivityStrategy#onReportingPeriodEnd()}.
   *
   * <p>Method under test: {@link AllEventsActivityStrategy#onReportingPeriodEnd()}
   */
  @Test
  @DisplayName("Test onReportingPeriodEnd()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AllEventsActivityStrategy.onReportingPeriodEnd()"})
  void testOnReportingPeriodEnd() {
    // Arrange, Act and Assert
    assertTrue(AllEventsActivityStrategy.getInstance().onReportingPeriodEnd());
  }
}
