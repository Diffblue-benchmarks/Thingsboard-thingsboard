package org.thingsboard.monitoring.config.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CoapTransportMonitoringConfigDiffblueTest {
  /**
   * Test {@link CoapTransportMonitoringConfig#getTransportType()}.
   *
   * <p>Method under test: {@link CoapTransportMonitoringConfig#getTransportType()}
   */
  @Test
  @DisplayName("Test getTransportType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TransportType CoapTransportMonitoringConfig.getTransportType()"})
  void testGetTransportType() {
    // Arrange, Act and Assert
    assertEquals(TransportType.COAP, new CoapTransportMonitoringConfig().getTransportType());
  }
}
