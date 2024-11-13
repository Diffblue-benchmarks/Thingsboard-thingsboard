package org.thingsboard.server.coapserver;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultCoapServerServiceDiffblueTest {
  /**
   * Test {@link DefaultCoapServerService#getDtlsSessionsMap()}.
   * <p>
   * Method under test: {@link DefaultCoapServerService#getDtlsSessionsMap()}
   */
  @Test
  @DisplayName("Test getDtlsSessionsMap()")
  void testGetDtlsSessionsMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DefaultCoapServerService()).getDtlsSessionsMap());
  }
}
