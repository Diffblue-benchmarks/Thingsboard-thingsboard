package org.thingsboard.server.common.data.transport.snmp.config.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.transport.snmp.SnmpCommunicationSpec;
import org.thingsboard.server.common.data.transport.snmp.SnmpMethod;

class SharedAttributesSettingSnmpCommunicationConfigDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SharedAttributesSettingSnmpCommunicationConfig}
   *   <li>{@link SharedAttributesSettingSnmpCommunicationConfig#getMethod()}
   *   <li>{@link SharedAttributesSettingSnmpCommunicationConfig#getSpec()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    SharedAttributesSettingSnmpCommunicationConfig actualSharedAttributesSettingSnmpCommunicationConfig = new SharedAttributesSettingSnmpCommunicationConfig();
    SnmpMethod actualMethod = actualSharedAttributesSettingSnmpCommunicationConfig.getMethod();
    SnmpCommunicationSpec actualSpec = actualSharedAttributesSettingSnmpCommunicationConfig.getSpec();

    // Assert
    assertNull(actualSharedAttributesSettingSnmpCommunicationConfig.getAllMappings());
    assertNull(actualSharedAttributesSettingSnmpCommunicationConfig.getMappings());
    assertEquals(SnmpCommunicationSpec.SHARED_ATTRIBUTES_SETTING, actualSpec);
    assertEquals(SnmpMethod.SET, actualMethod);
  }
}
