package org.thingsboard.server.transport.snmp;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SnmpTransportContextDiffblueTest {
  @InjectMocks
  private SnmpTransportContext snmpTransportContext;

  /**
   * Test {@link SnmpTransportContext#getSessions()}.
   * <p>
   * Method under test: {@link SnmpTransportContext#getSessions()}
   */
  @Test
  @DisplayName("Test getSessions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Collection SnmpTransportContext.getSessions()"})
  void testGetSessions() {
    // Arrange, Act and Assert
    assertTrue(snmpTransportContext.getSessions().isEmpty());
  }
}
