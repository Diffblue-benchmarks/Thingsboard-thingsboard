package org.thingsboard.monitoring.service.transport.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.monitoring.config.transport.DeviceConfig;
import org.thingsboard.monitoring.config.transport.Lwm2mTransportMonitoringConfig;
import org.thingsboard.monitoring.config.transport.TransportMonitoringTarget;
import org.thingsboard.server.common.data.security.DeviceCredentials;

@ExtendWith(MockitoExtension.class)
class Lwm2mTransportHealthCheckerDiffblueTest {
  @InjectMocks
  private Lwm2mTransportHealthChecker lwm2mTransportHealthChecker;

  /**
   * Test {@link Lwm2mTransportHealthChecker#createTestPayload(String)}.
   * <p>
   * Method under test: {@link Lwm2mTransportHealthChecker#createTestPayload(String)}
   */
  @Test
  @DisplayName("Test createTestPayload(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Lwm2mTransportHealthChecker.createTestPayload(String)"})
  void testCreateTestPayload() {
    // Arrange, Act and Assert
    assertEquals("42", lwm2mTransportHealthChecker.createTestPayload("42"));
  }

  /**
   * Test {@link Lwm2mTransportHealthChecker#destroyClient()}.
   * <ul>
   *   <li>Then calls {@link DeviceConfig#setCredentials(DeviceCredentials)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Lwm2mTransportHealthChecker#destroyClient()}
   */
  @Test
  @DisplayName("Test destroyClient(); then calls setCredentials(DeviceCredentials)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Lwm2mTransportHealthChecker.destroyClient()"})
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
    (new Lwm2mTransportHealthChecker(new Lwm2mTransportMonitoringConfig(), target)).destroyClient();

    // Assert
    verify(device).setCredentials(isA(DeviceCredentials.class));
    verify(device).setId(eq("42"));
    verify(device).setName(eq("Name"));
  }
}
