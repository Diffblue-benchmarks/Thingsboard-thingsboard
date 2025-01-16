package org.thingsboard.monitoring.config.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoapTransportMonitoringConfigDiffblueTest {
  /**
   * Test {@link CoapTransportMonitoringConfig#getTransportType()}.
   * <p>
   * Method under test: {@link CoapTransportMonitoringConfig#getTransportType()}
   */
  @Test
  @DisplayName("Test getTransportType()")
  void testGetTransportType() {
    // Arrange, Act and Assert
    assertEquals(TransportType.COAP, (new CoapTransportMonitoringConfig()).getTransportType());
  }
}
