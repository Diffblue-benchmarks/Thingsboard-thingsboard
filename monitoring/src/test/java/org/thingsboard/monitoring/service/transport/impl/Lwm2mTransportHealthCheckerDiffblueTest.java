package org.thingsboard.monitoring.service.transport.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.monitoring.config.transport.Lwm2mTransportMonitoringConfig;
import org.thingsboard.monitoring.config.transport.TransportMonitoringTarget;

class Lwm2mTransportHealthCheckerDiffblueTest {
  /**
   * Test {@link Lwm2mTransportHealthChecker#createTestPayload(String)}.
   * <p>
   * Method under test:
   * {@link Lwm2mTransportHealthChecker#createTestPayload(String)}
   */
  @Test
  @DisplayName("Test createTestPayload(String)")
  void testCreateTestPayload() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Lwm2mTransportMonitoringConfig config = new Lwm2mTransportMonitoringConfig();

    // Act and Assert
    assertEquals("42",
        (new Lwm2mTransportHealthChecker(config, new TransportMonitoringTarget())).createTestPayload("42"));
  }

  /**
   * Test {@link Lwm2mTransportHealthChecker#createTestPayload(String)}.
   * <p>
   * Method under test:
   * {@link Lwm2mTransportHealthChecker#createTestPayload(String)}
   */
  @Test
  @DisplayName("Test createTestPayload(String)")
  void testCreateTestPayload2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42",
        (new Lwm2mTransportHealthChecker(new Lwm2mTransportMonitoringConfig(), mock(TransportMonitoringTarget.class)))
            .createTestPayload("42"));
  }
}
