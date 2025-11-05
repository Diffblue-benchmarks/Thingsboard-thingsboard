package org.thingsboard.server.common.data.transport.snmp.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.transport.snmp.SnmpCommunicationSpec;

class ToServerRpcRequestSnmpCommunicationConfigDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ToServerRpcRequestSnmpCommunicationConfig}
   *   <li>{@link ToServerRpcRequestSnmpCommunicationConfig#getSpec()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToServerRpcRequestSnmpCommunicationConfig.<init>()",
    "SnmpCommunicationSpec ToServerRpcRequestSnmpCommunicationConfig.getSpec()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ToServerRpcRequestSnmpCommunicationConfig actualToServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    SnmpCommunicationSpec actualSpec = actualToServerRpcRequestSnmpCommunicationConfig.getSpec();

    // Assert
    assertNull(actualToServerRpcRequestSnmpCommunicationConfig.getAllMappings());
    assertNull(actualToServerRpcRequestSnmpCommunicationConfig.getMappings());
    assertEquals(SnmpCommunicationSpec.TO_SERVER_RPC_REQUEST, actualSpec);
  }
}
