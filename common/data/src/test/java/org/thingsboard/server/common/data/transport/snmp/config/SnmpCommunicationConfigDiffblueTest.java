package org.thingsboard.server.common.data.transport.snmp.config;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SnmpCommunicationConfigDiffblueTest {
  /**
   * Test {@link SnmpCommunicationConfig#getMethod()}.
   * <p>
   * Method under test: {@link SnmpCommunicationConfig#getMethod()}
   */
  @Test
  @DisplayName("Test getMethod()")
  void testGetMethod() {
    // Arrange, Act and Assert
    assertNull((new ToServerRpcRequestSnmpCommunicationConfig()).getMethod());
  }
}
