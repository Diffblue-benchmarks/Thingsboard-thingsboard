package org.thingsboard.server.coapserver;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoapServerContextDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CoapServerContext#getDtlsSettings()}
   *   <li>{@link CoapServerContext#getHost()}
   *   <li>{@link CoapServerContext#getPort()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    CoapServerContext coapServerContext = new CoapServerContext();

    // Act
    TbCoapDtlsSettings actualDtlsSettings = coapServerContext.getDtlsSettings();
    String actualHost = coapServerContext.getHost();

    // Assert
    assertNull(coapServerContext.getPort());
    assertNull(actualHost);
    assertNull(actualDtlsSettings);
  }
}
