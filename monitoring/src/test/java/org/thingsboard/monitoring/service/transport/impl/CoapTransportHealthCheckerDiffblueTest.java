package org.thingsboard.monitoring.service.transport.impl;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.monitoring.config.transport.CoapTransportMonitoringConfig;
import org.thingsboard.monitoring.config.transport.DeviceConfig;
import org.thingsboard.monitoring.config.transport.TransportMonitoringTarget;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class CoapTransportHealthCheckerDiffblueTest {
  /**
   * Test {@link CoapTransportHealthChecker#initClient()}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceConfig#getCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapTransportHealthChecker#initClient()}
   */
  @Test
  @DisplayName("Test initClient(); then calls getCredentials()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapTransportHealthChecker.initClient()"})
  void testInitClient_thenCallsGetCredentials() throws Exception {
    // Arrange
    DeviceConfig device = mock(DeviceConfig.class);
    when(device.getCredentials()).thenReturn(new DeviceCredentials());
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
    new CoapTransportHealthChecker(new CoapTransportMonitoringConfig(), target).initClient();

    // Assert
    verify(device).getCredentials();
    verify(device).setCredentials(isA(DeviceCredentials.class));
    verify(device).setId(eq("42"));
    verify(device).setName(eq("Name"));
  }

  /**
   * Test {@link CoapTransportHealthChecker#destroyClient()}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceConfig#setCredentials(DeviceCredentials)}.
   * </ul>
   *
   * <p>Method under test: {@link CoapTransportHealthChecker#destroyClient()}
   */
  @Test
  @DisplayName("Test destroyClient(); then calls setCredentials(DeviceCredentials)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapTransportHealthChecker.destroyClient()"})
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
    new CoapTransportHealthChecker(new CoapTransportMonitoringConfig(), target).destroyClient();

    // Assert
    verify(device).setCredentials(isA(DeviceCredentials.class));
    verify(device).setId(eq("42"));
    verify(device).setName(eq("Name"));
  }
}
