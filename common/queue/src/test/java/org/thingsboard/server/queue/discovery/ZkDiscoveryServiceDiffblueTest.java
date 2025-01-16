package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkImpl;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ZkDiscoveryService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ZkDiscoveryServiceDiffblueTest {
  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private PartitionService partitionService;

  @MockBean
  private TbServiceInfoProvider tbServiceInfoProvider;

  @Autowired
  private ZkDiscoveryService zkDiscoveryService;

  /**
   * Test {@link ZkDiscoveryService#init()}.
   * <p>
   * Method under test: {@link ZkDiscoveryService#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Disabled("TODO: Complete this test")
  void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.discovery.ZkDiscoveryService
    //   when running class:
    //   package org.thingsboard.server.queue.discovery;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.discovery.ZkDiscoveryService.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5708 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.context.ApplicationEventPublisher applicationEventPublisher;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.PartitionService partitionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.discovery.ZkDiscoveryService zkDiscoveryService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    zkDiscoveryService.init();
  }

  /**
   * Test {@link ZkDiscoveryService#getOtherServers()}.
   * <p>
   * Method under test: {@link ZkDiscoveryService#getOtherServers()}
   */
  @Test
  @DisplayName("Test getOtherServers()")
  @Disabled("TODO: Complete this test")
  void testGetOtherServers() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.discovery.ZkDiscoveryService
    //   when running class:
    //   package org.thingsboard.server.queue.discovery;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.discovery.ZkDiscoveryService.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5705 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.context.ApplicationEventPublisher applicationEventPublisher;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.PartitionService partitionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.discovery.ZkDiscoveryService zkDiscoveryService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    zkDiscoveryService.getOtherServers();
  }

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
   * Test {@link ZkDiscoveryService#onApplicationEvent(ApplicationReadyEvent)}.
   * <p>
   * Method under test:
   * {@link ZkDiscoveryService#onApplicationEvent(ApplicationReadyEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(ApplicationReadyEvent)")
  @Disabled("TODO: Complete this test")
  void testOnApplicationEvent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.discovery.ZkDiscoveryService
    //   when running class:
    //   package org.thingsboard.server.queue.discovery;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.discovery.ZkDiscoveryService.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6031 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.context.ApplicationEventPublisher applicationEventPublisher;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.PartitionService partitionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.discovery.ZkDiscoveryService zkDiscoveryService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    Class<Object> forNameResult = Object.class;
    SpringApplication application = new SpringApplication(forNameResult);

    // Act
    zkDiscoveryService.onApplicationEvent(new ApplicationReadyEvent(application, new String[]{"Args"},
        new AnnotationConfigReactiveWebApplicationContext(), null));
  }

  /**
   * Test {@link ZkDiscoveryService#publishCurrentServer()}.
   * <p>
   * Method under test: {@link ZkDiscoveryService#publishCurrentServer()}
   */
  @Test
  @DisplayName("Test publishCurrentServer()")
  @Disabled("TODO: Complete this test")
  void testPublishCurrentServer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.discovery.ZkDiscoveryService
    //   when running class:
    //   package org.thingsboard.server.queue.discovery;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.discovery.ZkDiscoveryService.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6656 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.context.ApplicationEventPublisher applicationEventPublisher;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.PartitionService partitionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.discovery.ZkDiscoveryService zkDiscoveryService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    zkDiscoveryService.publishCurrentServer();
  }

  /**
   * Test {@link ZkDiscoveryService#destroy()}.
   * <p>
   * Method under test: {@link ZkDiscoveryService#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  @Disabled("TODO: Complete this test")
  void testDestroy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.discovery.ZkDiscoveryService
    //   when running class:
    //   package org.thingsboard.server.queue.discovery;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.discovery.ZkDiscoveryService.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5702 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.context.ApplicationEventPublisher applicationEventPublisher;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.PartitionService partitionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.discovery.ZkDiscoveryService zkDiscoveryService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    zkDiscoveryService.destroy();
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

  /**
   * Test
   * {@link ZkDiscoveryService#childEvent(CuratorFramework, PathChildrenCacheEvent)}.
   * <p>
   * Method under test:
   * {@link ZkDiscoveryService#childEvent(CuratorFramework, PathChildrenCacheEvent)}
   */
  @Test
  @DisplayName("Test childEvent(CuratorFramework, PathChildrenCacheEvent)")
  @Disabled("TODO: Complete this test")
  void testChildEvent() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.discovery.ZkDiscoveryService
    //   when running class:
    //   package org.thingsboard.server.queue.discovery;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.discovery.ZkDiscoveryService.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5363 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.context.ApplicationEventPublisher applicationEventPublisher;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.PartitionService partitionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.discovery.ZkDiscoveryService zkDiscoveryService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CuratorFrameworkImpl curatorFramework = new CuratorFrameworkImpl(CuratorFrameworkFactory.builder());
    Stat stat = new Stat(1L, 1L, 10L, 10L, 1, 1, 1, 1L, 3, 10, 1L);

    // Act
    zkDiscoveryService.childEvent(curatorFramework, new PathChildrenCacheEvent(PathChildrenCacheEvent.Type.CHILD_ADDED,
        new ChildData("Path", stat, "AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link ZkDiscoveryService#recalculatePartitions()}.
   * <p>
   * Method under test: {@link ZkDiscoveryService#recalculatePartitions()}
   */
  @Test
  @DisplayName("Test recalculatePartitions()")
  @Disabled("TODO: Complete this test")
  void testRecalculatePartitions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.discovery.ZkDiscoveryService
    //   when running class:
    //   package org.thingsboard.server.queue.discovery;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.discovery.ZkDiscoveryService.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6659 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.context.ApplicationEventPublisher applicationEventPublisher;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.PartitionService partitionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.discovery.ZkDiscoveryService zkDiscoveryService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    zkDiscoveryService.recalculatePartitions();
  }
}
