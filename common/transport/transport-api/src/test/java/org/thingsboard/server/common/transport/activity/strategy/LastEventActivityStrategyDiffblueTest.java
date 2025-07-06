package org.thingsboard.server.common.transport.activity.strategy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LastEventActivityStrategyDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Method under test: {@link LastEventActivityStrategy#getInstance()}
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LastEventActivityStrategy LastEventActivityStrategy.getInstance()"})
  void testGettersAndSetters() {
    // Arrange and Act
    LastEventActivityStrategy actualInstance = LastEventActivityStrategy.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance.getInstance());
  }

  /**
   * Test {@link LastEventActivityStrategy#onActivity()}.
   *
   * <p>Method under test: {@link LastEventActivityStrategy#onActivity()}
   */
  @Test
  @DisplayName("Test onActivity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LastEventActivityStrategy.onActivity()"})
  void testOnActivity() {
    // Arrange, Act and Assert
    assertFalse(LastEventActivityStrategy.getInstance().onActivity());
  }

  /**
   * Test {@link LastEventActivityStrategy#onReportingPeriodEnd()}.
   *
   * <p>Method under test: {@link LastEventActivityStrategy#onReportingPeriodEnd()}
   */
  @Test
  @DisplayName("Test onReportingPeriodEnd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LastEventActivityStrategy.onReportingPeriodEnd()"})
  void testOnReportingPeriodEnd() {
    // Arrange, Act and Assert
    assertTrue(LastEventActivityStrategy.getInstance().onReportingPeriodEnd());
  }
}
