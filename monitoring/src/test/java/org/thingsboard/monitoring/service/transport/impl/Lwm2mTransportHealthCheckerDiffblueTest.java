package org.thingsboard.monitoring.service.transport.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.monitoring.config.transport.DeviceConfig;
import org.thingsboard.monitoring.config.transport.Lwm2mTransportMonitoringConfig;
import org.thingsboard.monitoring.config.transport.TransportMonitoringTarget;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class Lwm2mTransportHealthCheckerDiffblueTest {
  /**
   * Test {@link Lwm2mTransportHealthChecker#createTestPayload(String)}.
   *
   * <p>Method under test: {@link Lwm2mTransportHealthChecker#createTestPayload(String)}
   */
  @Test
  @DisplayName("Test createTestPayload(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Lwm2mTransportHealthChecker.createTestPayload(String)"})
  void testCreateTestPayload() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DeviceConfig device = new DeviceConfig();
    device.setCredentials(new DeviceCredentials());
    device.setId("");
    device.setName("Name");

    TransportMonitoringTarget target = new TransportMonitoringTarget();
    target.setBaseUrl("https://example.org/example");
    target.setCheckDomainIps(true);
    target.setDevice(device);
    target.setQueue("Queue");
    Lwm2mTransportHealthChecker lwm2mTransportHealthChecker =
        new Lwm2mTransportHealthChecker(new Lwm2mTransportMonitoringConfig(), target);

    // Act and Assert
    assertEquals("42", lwm2mTransportHealthChecker.createTestPayload("42"));
  }
}
