package org.thingsboard.monitoring.config.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Lwm2mTransportMonitoringConfigDiffblueTest {
  /**
   * Test {@link Lwm2mTransportMonitoringConfig#getTransportType()}.
   * <p>
   * Method under test: {@link Lwm2mTransportMonitoringConfig#getTransportType()}
   */
  @Test
  @DisplayName("Test getTransportType()")
  void testGetTransportType() {
    // Arrange, Act and Assert
    assertEquals(TransportType.LWM2M, (new Lwm2mTransportMonitoringConfig()).getTransportType());
  }
}
