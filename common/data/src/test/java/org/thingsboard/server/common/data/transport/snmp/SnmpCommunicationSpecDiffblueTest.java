package org.thingsboard.server.common.data.transport.snmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SnmpCommunicationSpecDiffblueTest {
  /**
   * Test {@link SnmpCommunicationSpec#getLabel()}.
   * <p>
   * Method under test: {@link SnmpCommunicationSpec#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("telemetryQuerying", SnmpCommunicationSpec.valueOf("TELEMETRY_QUERYING").getLabel());
  }
}
