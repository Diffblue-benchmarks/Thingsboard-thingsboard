package org.thingsboard.monitoring.service.transport.impl;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.monitoring.config.transport.CoapTransportMonitoringConfig;
import org.thingsboard.monitoring.config.transport.DeviceConfig;
import org.thingsboard.monitoring.config.transport.TransportMonitoringTarget;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class CoapTransportHealthCheckerDiffblueTest {
  /**
   * Test {@link CoapTransportHealthChecker#initClient()}.
   * <ul>
   *   <li>Then calls {@link DeviceConfig#getCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapTransportHealthChecker#initClient()}
   */
  @Test
  @DisplayName("Test initClient(); then calls getCredentials()")
  void testInitClient_thenCallsGetCredentials() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceConfig deviceConfig = mock(DeviceConfig.class);
    when(deviceConfig.getCredentials()).thenReturn(new DeviceCredentials());
    doNothing().when(deviceConfig).setCredentials(Mockito.<DeviceCredentials>any());
    doNothing().when(deviceConfig).setId(Mockito.<String>any());
    doNothing().when(deviceConfig).setName(Mockito.<String>any());
    deviceConfig.setCredentials(new DeviceCredentials());
    deviceConfig.setId("42");
    deviceConfig.setName("Name");
    TransportMonitoringTarget target = mock(TransportMonitoringTarget.class);
    when(target.getBaseUrl()).thenReturn("https://example.org/example");
    when(target.getDevice()).thenReturn(deviceConfig);

    // Act
    (new CoapTransportHealthChecker(new CoapTransportMonitoringConfig(), target)).initClient();

    // Assert
    verify(deviceConfig).getCredentials();
    verify(deviceConfig).setCredentials(isA(DeviceCredentials.class));
    verify(deviceConfig).setId(eq("42"));
    verify(deviceConfig).setName(eq("Name"));
    verify(target).getBaseUrl();
    verify(target).getDevice();
  }
}
