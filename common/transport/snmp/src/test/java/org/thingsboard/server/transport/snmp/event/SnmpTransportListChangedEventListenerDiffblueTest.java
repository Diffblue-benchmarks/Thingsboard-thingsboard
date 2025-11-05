package org.thingsboard.server.transport.snmp.event;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.snmp.SnmpTransportContext;

class SnmpTransportListChangedEventListenerDiffblueTest {
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SnmpTransportListChangedEventListener.onTbApplicationEvent(SnmpTransportListChangedEvent)"
  })
  void testOnTbApplicationEventWithSnmpTransportListChangedEvent() {
    // Arrange
    SnmpTransportContext snmpTransportContext = mock(SnmpTransportContext.class);
    doNothing().when(snmpTransportContext).onSnmpTransportListChanged();
    SnmpTransportListChangedEventListener snmpTransportListChangedEventListener =
        new SnmpTransportListChangedEventListener(snmpTransportContext);

    // Act
    snmpTransportListChangedEventListener.onTbApplicationEvent(new SnmpTransportListChangedEvent());

    // Assert
    verify(snmpTransportContext).onSnmpTransportListChanged();
  }
}
