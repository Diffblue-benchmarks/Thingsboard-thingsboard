package org.thingsboard.server.transport.coap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CoapTransportServiceDiffblueTest {
  /**
   * Test {@link CoapTransportService#getName()}.
   * <p>
   * Method under test: {@link CoapTransportService#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String CoapTransportService.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("COAP", (new CoapTransportService()).getName());
  }
}
