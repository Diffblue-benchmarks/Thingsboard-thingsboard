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
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService;
import org.thingsboard.server.queue.kafka.TbKafkaSettings;
import org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;

@ContextConfiguration(classes = {KafkaTbTransportQueueFactory.class, TbKafkaSettings.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class KafkaTbTransportQueueFactoryDiffblueTest {
  @Autowired
  private KafkaTbTransportQueueFactory kafkaTbTransportQueueFactory;

  @MockBean
  private TbKafkaConsumerStatsService tbKafkaConsumerStatsService;

  @Autowired
  private TbKafkaSettings tbKafkaSettings;

  @MockBean
  private TbKafkaTopicConfigs tbKafkaTopicConfigs;

  @MockBean
  private TbQueueCoreSettings tbQueueCoreSettings;

  @MockBean
  private TbQueueRuleEngineSettings tbQueueRuleEngineSettings;

  @MockBean
  private TbQueueTransportApiSettings tbQueueTransportApiSettings;

  @MockBean
  private TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;

  @MockBean
  private TbServiceInfoProvider tbServiceInfoProvider;

  @MockBean
  private TopicService topicService;

  /**
   * Test
   * {@link KafkaTbTransportQueueFactory#createTransportApiRequestTemplate()}.
   * <p>
   * Method under test:
   * {@link KafkaTbTransportQueueFactory#createTransportApiRequestTemplate()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestTemplate()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportApiRequestTemplate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2409 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory kafkaTbTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbTransportQueueFactory.createTransportApiRequestTemplate();
  }

  /**
   * Test {@link KafkaTbTransportQueueFactory#createRuleEngineMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbTransportQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateRuleEngineMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2397 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory kafkaTbTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbTransportQueueFactory.createRuleEngineMsgProducer();
  }

  /**
   * Test {@link KafkaTbTransportQueueFactory#createTbCoreMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbTransportQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2400 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory kafkaTbTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbTransportQueueFactory.createTbCoreMsgProducer();
  }

  /**
   * Test
   * {@link KafkaTbTransportQueueFactory#createTbCoreNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbTransportQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2403 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory kafkaTbTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbTransportQueueFactory.createTbCoreNotificationsMsgProducer();
  }

  /**
   * Test
   * {@link KafkaTbTransportQueueFactory#createTransportNotificationsConsumer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbTransportQueueFactory#createTransportNotificationsConsumer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportNotificationsConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2412 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory kafkaTbTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbTransportQueueFactory.createTransportNotificationsConsumer();
  }

  /**
   * Test
   * {@link KafkaTbTransportQueueFactory#createToUsageStatsServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbTransportQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateToUsageStatsServiceMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2406 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory kafkaTbTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbTransportQueueFactory.createToUsageStatsServiceMsgProducer();
  }

  /**
   * Test {@link KafkaTbTransportQueueFactory#createHousekeeperMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbTransportQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2394 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbTransportQueueFactory kafkaTbTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbTransportQueueFactory.createHousekeeperMsgProducer();
  }
}
