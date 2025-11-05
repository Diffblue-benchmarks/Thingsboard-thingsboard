package org.thingsboard.monitoring.service.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.thingsboard.monitoring.config.transport.CoapTransportMonitoringConfig;
import org.thingsboard.monitoring.config.transport.DeviceConfig;
import org.thingsboard.monitoring.config.transport.TransportMonitoringConfig;
import org.thingsboard.monitoring.config.transport.TransportMonitoringTarget;
import org.thingsboard.monitoring.service.BaseHealthChecker;
import org.thingsboard.monitoring.service.transport.impl.CoapTransportHealthChecker;
import org.thingsboard.server.common.data.security.DeviceCredentials;

@ExtendWith(MockitoExtension.class)
class TransportsMonitoringServiceDiffblueTest {
  @Mock private ApplicationContext applicationContext;

  @InjectMocks private TransportsMonitoringService transportsMonitoringService;

  /**
   * Test {@link TransportsMonitoringService#createHealthChecker(TransportMonitoringConfig,
   * TransportMonitoringTarget)} with {@code TransportMonitoringConfig}, {@code
   * TransportMonitoringTarget}.
   *
   * <p>Method under test: {@link
   * TransportsMonitoringService#createHealthChecker(TransportMonitoringConfig,
   * TransportMonitoringTarget)}
   */
  @Test
  @DisplayName(
      "Test createHealthChecker(TransportMonitoringConfig, TransportMonitoringTarget) with 'TransportMonitoringConfig', 'TransportMonitoringTarget'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BaseHealthChecker TransportsMonitoringService.createHealthChecker(TransportMonitoringConfig, TransportMonitoringTarget)"
  })
  void testCreateHealthCheckerWithTransportMonitoringConfigTransportMonitoringTarget()
      throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    when(applicationContext.getBean(eq(CoapTransportHealthChecker.class), isA(Object[].class)))
        .thenReturn(null);
    CoapTransportMonitoringConfig config = new CoapTransportMonitoringConfig();

    DeviceConfig device = new DeviceConfig();
    device.setCredentials(new DeviceCredentials());
    device.setId("");
    device.setName("Name");

    TransportMonitoringTarget target = new TransportMonitoringTarget();
    target.setBaseUrl("https://example.org/example");
    target.setCheckDomainIps(true);
    target.setDevice(device);
    target.setQueue("Queue");

    // Act
    BaseHealthChecker<?, ?> actualCreateHealthCheckerResult =
        transportsMonitoringService.createHealthChecker(config, target);

    // Assert
    verify(applicationContext).getBean(isA(Class.class), isA(Object[].class));
    assertNull(actualCreateHealthCheckerResult);
  }

  /**
   * Test {@link TransportsMonitoringService#createTarget(String)}.
   *
   * <p>Method under test: {@link TransportsMonitoringService#createTarget(String)}
   */
  @Test
  @DisplayName("Test createTarget(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TransportMonitoringTarget TransportsMonitoringService.createTarget(String)"})
  void testCreateTarget() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    TransportMonitoringTarget actualCreateTargetResult =
        new TransportsMonitoringService().createTarget("https://example.org/example");

    // Assert
    assertEquals("Main", actualCreateTargetResult.getQueue());
    assertEquals("https://example.org/example", actualCreateTargetResult.getBaseUrl());
    assertNull(actualCreateTargetResult.getDevice());
    assertFalse(actualCreateTargetResult.isCheckDomainIps());
  }

  /**
   * Test {@link TransportsMonitoringService#getName()}.
   *
   * <p>Method under test: {@link TransportsMonitoringService#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransportsMonitoringService.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("transports check", new TransportsMonitoringService().getName());
  }
}
