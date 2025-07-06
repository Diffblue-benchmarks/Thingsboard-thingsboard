package org.thingsboard.monitoring.service.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.monitoring.client.TbClient;
import org.thingsboard.monitoring.client.WsClientFactory;
import org.thingsboard.monitoring.config.transport.CoapTransportMonitoringConfig;
import org.thingsboard.monitoring.config.transport.DeviceConfig;
import org.thingsboard.monitoring.config.transport.TransportMonitoringConfig;
import org.thingsboard.monitoring.config.transport.TransportMonitoringTarget;
import org.thingsboard.monitoring.service.BaseHealthChecker;
import org.thingsboard.monitoring.service.MonitoringReporter;
import org.thingsboard.monitoring.service.transport.impl.CoapTransportHealthChecker;
import org.thingsboard.monitoring.util.TbStopWatch;
import org.thingsboard.server.common.data.security.DeviceCredentials;

@ContextConfiguration(classes = {TransportsMonitoringService.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class TransportsMonitoringServiceDiffblueTest {
  @Mock private ApplicationContext applicationContext;

  @Autowired private ApplicationContext applicationContext2;

  @Autowired private List<TransportMonitoringConfig> list;

  @MockBean private MonitoringReporter monitoringReporter;

  @MockBean private TbClient tbClient;

  @MockBean private TbStopWatch tbStopWatch;

  @MockBean private TransportMonitoringConfig transportMonitoringConfig;

  @InjectMocks private TransportsMonitoringService transportsMonitoringService;

  @Autowired private TransportsMonitoringService transportsMonitoringService2;

  @MockBean private WsClientFactory wsClientFactory;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "BaseHealthChecker TransportsMonitoringService.createHealthChecker(TransportMonitoringConfig, TransportMonitoringTarget)"
  })
  void testCreateHealthCheckerWithTransportMonitoringConfigTransportMonitoringTarget()
      throws BeansException {
    // Arrange
    when(applicationContext.getBean(
            Mockito.<Class<CoapTransportHealthChecker>>any(), isA(Object[].class)))
        .thenReturn(null);
    CoapTransportMonitoringConfig config = new CoapTransportMonitoringConfig();
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
    BaseHealthChecker<?, ?> actualCreateHealthCheckerResult =
        transportsMonitoringService.createHealthChecker(config, target);

    // Assert
    verify(applicationContext).getBean(isA(Class.class), isA(Object[].class));
    verify(device).setCredentials(isA(DeviceCredentials.class));
    verify(device).setId(eq("42"));
    verify(device).setName(eq("Name"));
    assertNull(actualCreateHealthCheckerResult);
  }

  /**
   * Test {@link TransportsMonitoringService#createTarget(String)}.
   *
   * <p>Method under test: {@link TransportsMonitoringService#createTarget(String)}
   */
  @Test
  @DisplayName("Test createTarget(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportMonitoringTarget TransportsMonitoringService.createTarget(String)"})
  void testCreateTarget() {
    // Arrange and Act
    TransportMonitoringTarget actualCreateTargetResult =
        transportsMonitoringService2.createTarget("https://example.org/example");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TransportsMonitoringService.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("transports check", new TransportsMonitoringService().getName());
  }
}
