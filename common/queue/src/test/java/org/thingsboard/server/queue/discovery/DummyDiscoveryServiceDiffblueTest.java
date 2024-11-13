package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.gen.transport.TransportProtos;

class DummyDiscoveryServiceDiffblueTest {
  /**
   * Test {@link DummyDiscoveryService#onApplicationEvent(ApplicationReadyEvent)}.
   * <ul>
   *   <li>Then calls
   * {@link HashPartitionService#recalculatePartitions(ServiceInfo, List)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DummyDiscoveryService#onApplicationEvent(ApplicationReadyEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(ApplicationReadyEvent); then calls recalculatePartitions(ServiceInfo, List)")
  void testOnApplicationEvent_thenCallsRecalculatePartitions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashPartitionService partitionService = mock(HashPartitionService.class);
    doNothing().when(partitionService)
        .recalculatePartitions(Mockito.<TransportProtos.ServiceInfo>any(),
            Mockito.<List<TransportProtos.ServiceInfo>>any());
    DummyDiscoveryService dummyDiscoveryService = new DummyDiscoveryService(new DefaultTbServiceInfoProvider(),
        partitionService);
    Class<Object> forNameResult = Object.class;
    SpringApplication application = new SpringApplication(forNameResult);

    // Act
    dummyDiscoveryService.onApplicationEvent(new ApplicationReadyEvent(application, new String[]{"Args"},
        new AnnotationConfigReactiveWebApplicationContext(), null));

    // Assert that nothing has changed
    verify(partitionService).recalculatePartitions(isNull(), isA(List.class));
  }

  /**
   * Test {@link DummyDiscoveryService#getOtherServers()}.
   * <p>
   * Method under test: {@link DummyDiscoveryService#getOtherServers()}
   */
  @Test
  @DisplayName("Test getOtherServers()")
  void testGetOtherServers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    // Act and Assert
    assertTrue((new DummyDiscoveryService(serviceInfoProvider, new HashPartitionService(serviceInfoProvider2,
        tenantRoutingInfoService, applicationEventPublisher, queueRoutingInfoService, new TopicService())))
        .getOtherServers()
        .isEmpty());
  }

  /**
   * Test {@link DummyDiscoveryService#isMonolith()}.
   * <p>
   * Method under test: {@link DummyDiscoveryService#isMonolith()}
   */
  @Test
  @DisplayName("Test isMonolith()")
  void testIsMonolith() {
    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    // Act and Assert
    assertTrue((new DummyDiscoveryService(serviceInfoProvider, new HashPartitionService(serviceInfoProvider2,
        tenantRoutingInfoService, applicationEventPublisher, queueRoutingInfoService, new TopicService())))
        .isMonolith());
  }
}
