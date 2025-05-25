package org.thingsboard.server.common.data.transport.snmp.config;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SnmpCommunicationConfigDiffblueTest {
  /**
   * Test {@link SnmpCommunicationConfig#getMethod()}.
   * <p>
   * Method under test: {@link SnmpCommunicationConfig#getMethod()}
   */
  @Test
  @DisplayName("Test getMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.transport.snmp.SnmpMethod SnmpCommunicationConfig.getMethod()"})
  void testGetMethod() {
    // Arrange, Act and Assert
    assertNull((new ToServerRpcRequestSnmpCommunicationConfig()).getMethod());
  }
}
