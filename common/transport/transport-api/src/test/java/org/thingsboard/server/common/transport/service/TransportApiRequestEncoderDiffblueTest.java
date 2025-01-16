package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;

class TransportApiRequestEncoderDiffblueTest {
  /**
   * Test {@link TransportApiRequestEncoder#encode(TransportApiRequestMsg)} with
   * {@code TransportApiRequestMsg}.
   * <p>
   * Method under test:
   * {@link TransportApiRequestEncoder#encode(TransportProtos.TransportApiRequestMsg)}
   */
  @Test
  @DisplayName("Test encode(TransportApiRequestMsg) with 'TransportApiRequestMsg'")
  void testEncodeWithTransportApiRequestMsg() {
    // Arrange
    TransportApiRequestEncoder transportApiRequestEncoder = new TransportApiRequestEncoder();

    // Act and Assert
    assertEquals(0,
        transportApiRequestEncoder.encode(TransportProtos.TransportApiRequestMsg.getDefaultInstance()).length);
  }
}
