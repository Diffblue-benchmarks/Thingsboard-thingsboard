package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.gen.transport.TransportProtos;

@ContextConfiguration(classes = {DummyDiscoveryService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DummyDiscoveryServiceDiffblueTest {
  @Autowired
  private DummyDiscoveryService dummyDiscoveryService;

  @MockBean
  private PartitionService partitionService;

  @MockBean
  private TbServiceInfoProvider tbServiceInfoProvider;

  /**
   * Test {@link DummyDiscoveryService#onApplicationEvent(ApplicationReadyEvent)}.
   * <p>
   * Method under test:
   * {@link DummyDiscoveryService#onApplicationEvent(ApplicationReadyEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(ApplicationReadyEvent)")
  @Disabled("TODO: Complete this test")
  void testOnApplicationEvent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: ApplicationContext failure threshold (1) exceeded: skipping repeated attempt to load context for [MergedContextConfiguration@5022f90f testClass = org.thingsboard.server.queue.discovery.DiffblueFakeClass252, locations = [], classes = [org.thingsboard.server.queue.discovery.DummyDiscoveryService], contextInitializerClasses = [], activeProfiles = [], propertySourceDescriptors = [], propertySourceProperties = [], contextCustomizers = [org.springframework.boot.test.autoconfigure.actuate.observability.ObservabilityContextCustomizerFactory$DisableObservabilityContextCustomizer@1f, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizer@72294b52, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@45387cbe, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@6aad4170, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@e38cd2aa], contextLoader = org.springframework.test.context.support.DelegatingSmartContextLoader, parent = null]
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:145)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    //   See https://diff.blue/R026 to resolve this issue.

    // Arrange
    Class<Object> forNameResult = Object.class;
    SpringApplication application = new SpringApplication(forNameResult);

    // Act
    dummyDiscoveryService.onApplicationEvent(new ApplicationReadyEvent(application, new String[]{"Args"},
        new AnnotationConfigReactiveWebApplicationContext(), null));
  }

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
   * Test {@link DummyDiscoveryService#getOtherServers()}.
   * <p>
   * Method under test: {@link DummyDiscoveryService#getOtherServers()}
   */
  @Test
  @DisplayName("Test getOtherServers()")
  @Disabled("TODO: Complete this test")
  void testGetOtherServers2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.thingsboard.server.queue.discovery;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.discovery.DummyDiscoveryService.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass251 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.discovery.DummyDiscoveryService dummyDiscoveryService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.PartitionService partitionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    dummyDiscoveryService.getOtherServers();
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
