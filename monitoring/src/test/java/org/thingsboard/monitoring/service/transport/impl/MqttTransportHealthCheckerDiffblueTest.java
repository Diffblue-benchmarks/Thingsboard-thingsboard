package org.thingsboard.monitoring.service.transport.impl;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.monitoring.config.transport.DeviceConfig;
import org.thingsboard.monitoring.config.transport.MqttTransportMonitoringConfig;
import org.thingsboard.monitoring.config.transport.TransportMonitoringTarget;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class MqttTransportHealthCheckerDiffblueTest {
  /**
   * Test {@link MqttTransportHealthChecker#destroyClient()}.
   * <ul>
   *   <li>Then calls {@link DeviceConfig#setCredentials(DeviceCredentials)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTransportHealthChecker#destroyClient()}
   */
  @Test
  @DisplayName("Test destroyClient(); then calls setCredentials(DeviceCredentials)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportHealthChecker.destroyClient()"})
  void testDestroyClient_thenCallsSetCredentials() throws Exception {
    // Arrange
    DeviceConfig device = mock(DeviceConfig.class);
    doNothing().when(device).setCredentials(Mockito.<DeviceCredentials>any());
    doNothing().when(device).setId(Mockito.<String>any());
    doNothing().when(device).setName(Mockito.<String>any());
    device.setCredentials(new DeviceCredentials());
    device.setId("42");
    device.setName("Name");

    TransportMonitoringTarget target = new TransportMonitoringTarget();
    target.setBaseUrl("https://example.org/example");
    target.setCheckDomainIps(true);
    target.setDevice(device);
    target.setQueue("Queue");

    // Act
    (new MqttTransportHealthChecker(new MqttTransportMonitoringConfig(), target)).destroyClient();

    // Assert
    verify(device).setCredentials(isA(DeviceCredentials.class));
    verify(device).setId(eq("42"));
    verify(device).setName(eq("Name"));
  }
}
