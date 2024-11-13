package org.thingsboard.server.transport.lwm2m.server.uplink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LwM2mTypeServerDiffblueTest {
  /**
   * Test {@link LwM2mTypeServer#fromLwM2mTypeServer(String)}.
   * <ul>
   *   <li>When {@code bootstrap}.</li>
   *   <li>Then return {@code BOOTSTRAP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mTypeServer#fromLwM2mTypeServer(String)}
   */
  @Test
  @DisplayName("Test fromLwM2mTypeServer(String); when 'bootstrap'; then return 'BOOTSTRAP'")
  void testFromLwM2mTypeServer_whenBootstrap_thenReturnBootstrap() {
    // Arrange, Act and Assert
    assertEquals(LwM2mTypeServer.BOOTSTRAP, LwM2mTypeServer.fromLwM2mTypeServer("bootstrap"));
  }
}
