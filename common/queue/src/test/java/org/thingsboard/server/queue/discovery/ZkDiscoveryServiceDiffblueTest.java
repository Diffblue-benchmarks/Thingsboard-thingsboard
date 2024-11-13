package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.aot.DisabledInAotMode;

@DisabledInAotMode
class ZkDiscoveryServiceDiffblueTest {
  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private PartitionService partitionService;

  @MockBean
  private TbServiceInfoProvider tbServiceInfoProvider;

  /**
   * Test {@link ZkDiscoveryService#isMonolith()}.
   * <p>
   * Method under test: {@link ZkDiscoveryService#isMonolith()}
   */
  @Test
  @DisplayName("Test isMonolith()")
  void testIsMonolith() {
    // Arrange
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    // Act and Assert
    assertFalse((new ZkDiscoveryService(applicationEventPublisher, serviceInfoProvider,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher2,
            queueRoutingInfoService, new TopicService())))
        .isMonolith());
  }

  /**
   * Test {@link ZkDiscoveryService#missingProperty(String)}.
   * <p>
   * Method under test: {@link ZkDiscoveryService#missingProperty(String)}
   */
  @Test
  @DisplayName("Test missingProperty(String)")
  void testMissingProperty() {
    // Arrange, Act and Assert
    assertEquals("The Property Name property need to be set!", ZkDiscoveryService.missingProperty("Property Name"));
  }
}
