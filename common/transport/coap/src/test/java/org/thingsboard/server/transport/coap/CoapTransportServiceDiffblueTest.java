package org.thingsboard.server.transport.coap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoapTransportServiceDiffblueTest {
  /**
   * Test {@link CoapTransportService#getName()}.
   * <p>
   * Method under test: {@link CoapTransportService#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("COAP", (new CoapTransportService()).getName());
  }
}
