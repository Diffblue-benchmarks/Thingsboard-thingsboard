package org.thingsboard.monitoring.config.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HttpTransportMonitoringConfigDiffblueTest {
  /**
   * Test {@link HttpTransportMonitoringConfig#getTransportType()}.
   * <p>
   * Method under test: {@link HttpTransportMonitoringConfig#getTransportType()}
   */
  @Test
  @DisplayName("Test getTransportType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportType HttpTransportMonitoringConfig.getTransportType()"})
  void testGetTransportType() {
    // Arrange, Act and Assert
    assertEquals(TransportType.HTTP, (new HttpTransportMonitoringConfig()).getTransportType());
  }
}
