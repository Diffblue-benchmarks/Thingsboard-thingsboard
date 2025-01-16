package org.thingsboard.server.common.data.transport.snmp.config.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.transport.snmp.SnmpCommunicationSpec;

class ClientAttributesQueryingSnmpCommunicationConfigDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ClientAttributesQueryingSnmpCommunicationConfig}
   *   <li>{@link ClientAttributesQueryingSnmpCommunicationConfig#getSpec()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    ClientAttributesQueryingSnmpCommunicationConfig actualClientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    SnmpCommunicationSpec actualSpec = actualClientAttributesQueryingSnmpCommunicationConfig.getSpec();

    // Assert
    assertNull(actualClientAttributesQueryingSnmpCommunicationConfig.getQueryingFrequencyMs());
    assertNull(actualClientAttributesQueryingSnmpCommunicationConfig.getAllMappings());
    assertNull(actualClientAttributesQueryingSnmpCommunicationConfig.getMappings());
    assertEquals(SnmpCommunicationSpec.CLIENT_ATTRIBUTES_QUERYING, actualSpec);
  }
}
