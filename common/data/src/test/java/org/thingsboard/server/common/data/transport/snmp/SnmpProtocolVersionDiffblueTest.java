package org.thingsboard.server.common.data.transport.snmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SnmpProtocolVersionDiffblueTest {
  /**
   * Test {@link SnmpProtocolVersion#getCode()}.
   * <p>
   * Method under test: {@link SnmpProtocolVersion#getCode()}
   */
  @Test
  @DisplayName("Test getCode()")
  void testGetCode() {
    // Arrange, Act and Assert
    assertEquals(0, SnmpProtocolVersion.valueOf("V1").getCode());
  }
}
