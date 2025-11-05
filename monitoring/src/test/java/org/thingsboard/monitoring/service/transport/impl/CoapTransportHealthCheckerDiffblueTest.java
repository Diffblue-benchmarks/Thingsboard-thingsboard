package org.thingsboard.monitoring.service.transport.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.monitoring.config.transport.CoapTransportMonitoringConfig;
import org.thingsboard.monitoring.config.transport.DeviceConfig;
import org.thingsboard.monitoring.config.transport.TransportMonitoringTarget;
import org.thingsboard.server.common.data.security.DeviceCredentials;

@ExtendWith(MockitoExtension.class)
class CoapTransportHealthCheckerDiffblueTest {
  @InjectMocks private CoapTransportHealthChecker coapTransportHealthChecker;

  @Mock private CoapTransportMonitoringConfig coapTransportMonitoringConfig;

  @Mock private TransportMonitoringTarget transportMonitoringTarget;

  /**
   * Test {@link CoapTransportHealthChecker#initClient()}.
   *
   * <ul>
   *   <li>Then calls {@link CoapTransportMonitoringConfig#getRequestTimeoutMs()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapTransportHealthChecker#initClient()}
   */
  @Test
  @DisplayName("Test initClient(); then calls getRequestTimeoutMs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapTransportHealthChecker.initClient()"})
  void testInitClient_thenCallsGetRequestTimeoutMs() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    when(coapTransportMonitoringConfig.getRequestTimeoutMs()).thenReturn(10);

    DeviceConfig deviceConfig = new DeviceConfig();
    deviceConfig.setCredentials(new DeviceCredentials());
    deviceConfig.setId("");
    deviceConfig.setName("Name");
    when(transportMonitoringTarget.getBaseUrl()).thenReturn("https://example.org/example");
    when(transportMonitoringTarget.getDevice()).thenReturn(deviceConfig);

    // Act
    coapTransportHealthChecker.initClient();

    // Assert
    verify(coapTransportMonitoringConfig).getRequestTimeoutMs();
    verify(transportMonitoringTarget).getBaseUrl();
    verify(transportMonitoringTarget).getDevice();
  }
}
