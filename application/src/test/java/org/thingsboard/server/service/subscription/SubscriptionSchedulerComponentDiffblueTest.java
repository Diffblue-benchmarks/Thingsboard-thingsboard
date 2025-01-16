package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SubscriptionSchedulerComponentDiffblueTest {
  /**
   * Test {@link SubscriptionSchedulerComponent#getScheduler()}.
   * <p>
   * Method under test: {@link SubscriptionSchedulerComponent#getScheduler()}
   */
  @Test
  @DisplayName("Test getScheduler()")
  void testGetScheduler() {
    // Arrange, Act and Assert
    assertNull((new SubscriptionSchedulerComponent()).getScheduler());
  }
}
