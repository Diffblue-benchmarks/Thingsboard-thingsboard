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
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;

@ContextConfiguration(classes = {KafkaTbCoreQueueFactory.class, TbKafkaSettings.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class KafkaTbCoreQueueFactoryDiffblueTest {
  @Autowired
  private KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;

  @MockBean
  private TbKafkaConsumerStatsService tbKafkaConsumerStatsService;

  @Autowired
  private TbKafkaSettings tbKafkaSettings;

  @MockBean
  private TbKafkaTopicConfigs tbKafkaTopicConfigs;

  @MockBean
  private TbQueueCoreSettings tbQueueCoreSettings;

  @MockBean
  private TbQueueEdgeSettings tbQueueEdgeSettings;

  @MockBean
  private TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;

  @MockBean
  private TbQueueRuleEngineSettings tbQueueRuleEngineSettings;

  @MockBean
  private TbQueueTransportApiSettings tbQueueTransportApiSettings;

  @MockBean
  private TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;

  @MockBean
  private TbQueueVersionControlSettings tbQueueVersionControlSettings;

  @MockBean
  private TbServiceInfoProvider tbServiceInfoProvider;

  @MockBean
  private TopicService topicService;

  /**
   * Test
   * {@link KafkaTbCoreQueueFactory#createTransportNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2260 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createTransportNotificationsMsgProducer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createRuleEngineMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateRuleEngineMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2221 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createRuleEngineMsgProducer();
  }

  /**
   * Test
   * {@link KafkaTbCoreQueueFactory#createRuleEngineNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateRuleEngineNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2224 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createRuleEngineNotificationsMsgProducer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createTbCoreMsgProducer()}.
   * <p>
   * Method under test: {@link KafkaTbCoreQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2227 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createTbCoreMsgProducer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createTbCoreNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2230 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createTbCoreNotificationsMsgProducer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createToCoreMsgConsumer()}.
   * <p>
   * Method under test: {@link KafkaTbCoreQueueFactory#createToCoreMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToCoreMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2233 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createToCoreMsgConsumer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createToCoreNotificationsMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createToCoreNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreNotificationsMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToCoreNotificationsMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2236 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createToCoreNotificationsMsgConsumer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createTransportApiRequestConsumer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createTransportApiRequestConsumer()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportApiRequestConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2254 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createTransportApiRequestConsumer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createTransportApiResponseProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createTransportApiResponseProducer()}
   */
  @Test
  @DisplayName("Test createTransportApiResponseProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportApiResponseProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2257 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createTransportApiResponseProducer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createRemoteJsRequestTemplate()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate()")
  @Disabled("TODO: Complete this test")
  void testCreateRemoteJsRequestTemplate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2218 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createRemoteJsRequestTemplate();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createToUsageStatsServiceMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createToUsageStatsServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToUsageStatsServiceMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2248 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createToUsageStatsServiceMsgConsumer();
  }

  /**
   * Test
   * {@link KafkaTbCoreQueueFactory#createToOtaPackageStateServiceMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createToOtaPackageStateServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToOtaPackageStateServiceMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2242 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createToOtaPackageStateServiceMsgConsumer();
  }

  /**
   * Test
   * {@link KafkaTbCoreQueueFactory#createToOtaPackageStateServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createToOtaPackageStateServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateToOtaPackageStateServiceMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2245 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createToOtaPackageStateServiceMsgProducer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createToUsageStatsServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateToUsageStatsServiceMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2251 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createToUsageStatsServiceMsgProducer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createVersionControlMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test createVersionControlMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateVersionControlMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2263 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createVersionControlMsgProducer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createHousekeeperMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2209 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createHousekeeperMsgProducer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createHousekeeperMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createHousekeeperMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2206 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createHousekeeperMsgConsumer();
  }

  /**
   * Test
   * {@link KafkaTbCoreQueueFactory#createHousekeeperReprocessingMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createHousekeeperReprocessingMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperReprocessingMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2215 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createHousekeeperReprocessingMsgProducer();
  }

  /**
   * Test
   * {@link KafkaTbCoreQueueFactory#createHousekeeperReprocessingMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createHousekeeperReprocessingMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperReprocessingMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2212 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createHousekeeperReprocessingMsgConsumer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createEdgeMsgConsumer()}.
   * <p>
   * Method under test: {@link KafkaTbCoreQueueFactory#createEdgeMsgConsumer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateEdgeMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2197 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createEdgeMsgConsumer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createEdgeMsgProducer()}.
   * <p>
   * Method under test: {@link KafkaTbCoreQueueFactory#createEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateEdgeMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2200 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createEdgeMsgProducer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createToEdgeNotificationsMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createToEdgeNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToEdgeNotificationsMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToEdgeNotificationsMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2239 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createToEdgeNotificationsMsgConsumer();
  }

  /**
   * Test {@link KafkaTbCoreQueueFactory#createEdgeNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbCoreQueueFactory#createEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateEdgeNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2203 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbCoreQueueFactory kafkaTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportApiSettings tbQueueTransportApiSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbCoreQueueFactory.createEdgeNotificationsMsgProducer();
  }
}
