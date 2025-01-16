package org.thingsboard.server.common.data.transport.snmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SnmpMethodDiffblueTest {
  /**
   * Test {@link SnmpMethod#getCode()}.
   * <p>
   * Method under test: {@link SnmpMethod#getCode()}
   */
  @Test
  @DisplayName("Test getCode()")
  void testGetCode() {
    // Arrange, Act and Assert
    assertEquals(-96, SnmpMethod.valueOf("GET").getCode());
  }
}
