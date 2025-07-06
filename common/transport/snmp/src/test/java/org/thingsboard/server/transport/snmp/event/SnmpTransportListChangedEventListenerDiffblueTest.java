package org.thingsboard.server.transport.snmp.event;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.transport.snmp.SnmpTransportContext;

@ExtendWith(MockitoExtension.class)
class SnmpTransportListChangedEventListenerDiffblueTest {
  @Mock private SnmpTransportContext snmpTransportContext;

  @InjectMocks private SnmpTransportListChangedEventListener snmpTransportListChangedEventListener;

  /**
   * Test {@link
   * SnmpTransportListChangedEventListener#onTbApplicationEvent(SnmpTransportListChangedEvent)} with
   * {@code SnmpTransportListChangedEvent}.
   *
   * <p>Method under test: {@link
   * SnmpTransportListChangedEventListener#onTbApplicationEvent(SnmpTransportListChangedEvent)}
   */
  @Test
  @DisplayName(
      "Test onTbApplicationEvent(SnmpTransportListChangedEvent) with 'SnmpTransportListChangedEvent'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void SnmpTransportListChangedEventListener.onTbApplicationEvent(SnmpTransportListChangedEvent)"
  })
  void testOnTbApplicationEventWithSnmpTransportListChangedEvent() {
    // Arrange
    doNothing().when(snmpTransportContext).onSnmpTransportListChanged();

    // Act
    snmpTransportListChangedEventListener.onTbApplicationEvent(new SnmpTransportListChangedEvent());

    // Assert
    verify(snmpTransportContext).onSnmpTransportListChanged();
  }
}
