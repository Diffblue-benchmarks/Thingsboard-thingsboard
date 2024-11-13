package org.thingsboard.monitoring.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.monitoring.config.transport.TransportMonitoringTarget;

class MonitoringTargetDiffblueTest {
  /**
   * Test {@link MonitoringTarget#getQueue()}.
   * <p>
   * Method under test: {@link MonitoringTarget#getQueue()}
   */
  @Test
  @DisplayName("Test getQueue()")
  void testGetQueue() {
    // Arrange, Act and Assert
    assertEquals("Main", (new TransportMonitoringTarget()).getQueue());
  }
}
