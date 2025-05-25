package org.thingsboard.server.common.data.transport.snmp.config.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.transport.snmp.SnmpCommunicationSpec;

class ToDeviceRpcRequestSnmpCommunicationConfigDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ToDeviceRpcRequestSnmpCommunicationConfig}
   *   <li>{@link ToDeviceRpcRequestSnmpCommunicationConfig#getSpec()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ToDeviceRpcRequestSnmpCommunicationConfig.<init>()",
      "SnmpCommunicationSpec ToDeviceRpcRequestSnmpCommunicationConfig.getSpec()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ToDeviceRpcRequestSnmpCommunicationConfig actualToDeviceRpcRequestSnmpCommunicationConfig = new ToDeviceRpcRequestSnmpCommunicationConfig();
    SnmpCommunicationSpec actualSpec = actualToDeviceRpcRequestSnmpCommunicationConfig.getSpec();

    // Assert
    assertNull(actualToDeviceRpcRequestSnmpCommunicationConfig.getAllMappings());
    assertNull(actualToDeviceRpcRequestSnmpCommunicationConfig.getMappings());
    assertEquals(SnmpCommunicationSpec.TO_DEVICE_RPC_REQUEST, actualSpec);
  }
}
