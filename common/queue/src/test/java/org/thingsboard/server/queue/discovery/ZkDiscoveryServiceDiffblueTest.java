package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class ZkDiscoveryServiceDiffblueTest {
  @Mock
  private TbServiceInfoProvider tbServiceInfoProvider;

  @InjectMocks
  private ZkDiscoveryService zkDiscoveryService;

  /**
   * Test {@link ZkDiscoveryService#isMonolith()}.
   * <p>
   * Method under test: {@link ZkDiscoveryService#isMonolith()}
   */
  @Test
  @DisplayName("Test isMonolith()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ZkDiscoveryService.isMonolith()"})
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
   * Test {@link ZkDiscoveryService#publishCurrentServer()}.
   * <p>
   * Method under test: {@link ZkDiscoveryService#publishCurrentServer()}
   */
  @Test
  @DisplayName("Test publishCurrentServer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ZkDiscoveryService.publishCurrentServer()"})
  void testPublishCurrentServer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceInfo())
        .thenThrow(new RuntimeException("[{}] Creating ZK node for current instance"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> zkDiscoveryService.publishCurrentServer());
    verify(tbServiceInfoProvider).getServiceInfo();
  }

  /**
   * Test {@link ZkDiscoveryService#missingProperty(String)}.
   * <p>
   * Method under test: {@link ZkDiscoveryService#missingProperty(String)}
   */
  @Test
  @DisplayName("Test missingProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ZkDiscoveryService.missingProperty(String)"})
  void testMissingProperty() {
    // Arrange, Act and Assert
    assertEquals("The Property Name property need to be set!", ZkDiscoveryService.missingProperty("Property Name"));
  }

  /**
   * Test {@link ZkDiscoveryService#recalculatePartitions()}.
   * <p>
   * Method under test: {@link ZkDiscoveryService#recalculatePartitions()}
   */
  @Test
  @DisplayName("Test recalculatePartitions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ZkDiscoveryService.recalculatePartitions()"})
  void testRecalculatePartitions() {
    // Arrange
    when(tbServiceInfoProvider.getServiceInfo()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> zkDiscoveryService.recalculatePartitions());
    verify(tbServiceInfoProvider).getServiceInfo();
  }
}
