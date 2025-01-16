package org.thingsboard.server.queue.provider;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusQueueConfigs;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;

@ContextConfiguration(classes = {ServiceBusTransportQueueFactory.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ServiceBusTransportQueueFactoryDiffblueTest {
  @Autowired
  private ServiceBusTransportQueueFactory serviceBusTransportQueueFactory;

  @MockBean
  private TbQueueCoreSettings tbQueueCoreSettings;

  @MockBean
  private TbQueueRuleEngineSettings tbQueueRuleEngineSettings;

  @MockBean
  private TbQueueTransportApiSettings tbQueueTransportApiSettings;

  @MockBean
  private TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;

  @MockBean
  private TbServiceBusQueueConfigs tbServiceBusQueueConfigs;

  @MockBean
  private TbServiceBusSettings tbServiceBusSettings;

  @MockBean
  private TbServiceInfoProvider tbServiceInfoProvider;

  @MockBean
  private TopicService topicService;

  /**
   * Test
   * {@link ServiceBusTransportQueueFactory#createTransportApiRequestTemplate()}.
   * <p>
   * Method under test:
   * {@link ServiceBusTransportQueueFactory#createTransportApiRequestTemplate()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestTemplate()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportApiRequestTemplate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3258 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory serviceBusTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.azure.servicebus.TbServiceBusQueueConfigs tbServiceBusQueueConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings tbServiceBusSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    serviceBusTransportQueueFactory.createTransportApiRequestTemplate();
  }

  /**
   * Test {@link ServiceBusTransportQueueFactory#createRuleEngineMsgProducer()}.
   * <p>
   * Method under test:
   * {@link ServiceBusTransportQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateRuleEngineMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3246 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory serviceBusTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.azure.servicebus.TbServiceBusQueueConfigs tbServiceBusQueueConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings tbServiceBusSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    serviceBusTransportQueueFactory.createRuleEngineMsgProducer();
  }

  /**
   * Test {@link ServiceBusTransportQueueFactory#createTbCoreMsgProducer()}.
   * <p>
   * Method under test:
   * {@link ServiceBusTransportQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3249 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory serviceBusTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.azure.servicebus.TbServiceBusQueueConfigs tbServiceBusQueueConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings tbServiceBusSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    serviceBusTransportQueueFactory.createTbCoreMsgProducer();
  }

  /**
   * Test
   * {@link ServiceBusTransportQueueFactory#createTbCoreNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link ServiceBusTransportQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3252 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory serviceBusTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.azure.servicebus.TbServiceBusQueueConfigs tbServiceBusQueueConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings tbServiceBusSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    serviceBusTransportQueueFactory.createTbCoreNotificationsMsgProducer();
  }

  /**
   * Test
   * {@link ServiceBusTransportQueueFactory#createTransportNotificationsConsumer()}.
   * <p>
   * Method under test:
   * {@link ServiceBusTransportQueueFactory#createTransportNotificationsConsumer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportNotificationsConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3261 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory serviceBusTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.azure.servicebus.TbServiceBusQueueConfigs tbServiceBusQueueConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings tbServiceBusSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    serviceBusTransportQueueFactory.createTransportNotificationsConsumer();
  }

  /**
   * Test
   * {@link ServiceBusTransportQueueFactory#createToUsageStatsServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link ServiceBusTransportQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateToUsageStatsServiceMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3255 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory serviceBusTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.azure.servicebus.TbServiceBusQueueConfigs tbServiceBusQueueConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings tbServiceBusSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    serviceBusTransportQueueFactory.createToUsageStatsServiceMsgProducer();
  }

  /**
   * Test {@link ServiceBusTransportQueueFactory#createHousekeeperMsgProducer()}.
   * <p>
   * Method under test:
   * {@link ServiceBusTransportQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3243 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.ServiceBusTransportQueueFactory serviceBusTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.azure.servicebus.TbServiceBusQueueConfigs tbServiceBusQueueConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings tbServiceBusSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    serviceBusTransportQueueFactory.createHousekeeperMsgProducer();
  }
}
