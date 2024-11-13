package org.thingsboard.server.transport.lwm2m.server;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LwM2mTransportContextDiffblueTest {
  /**
   * Test {@link LwM2mTransportContext#getServer()}.
   * <p>
   * Method under test: {@link LwM2mTransportContext#getServer()}
   */
  @Test
  @DisplayName("Test getServer()")
  void testGetServer() {
    // Arrange, Act and Assert
    assertNull((new LwM2mTransportContext()).getServer());
  }
}
