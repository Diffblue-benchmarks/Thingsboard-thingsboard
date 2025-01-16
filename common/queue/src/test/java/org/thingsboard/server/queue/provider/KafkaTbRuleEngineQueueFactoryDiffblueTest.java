package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.kafka.TbKafkaConsumerStatisticConfig;
import org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService;
import org.thingsboard.server.queue.kafka.TbKafkaSettings;
import org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;

@ContextConfiguration(classes = {KafkaTbRuleEngineQueueFactory.class, TbKafkaSettings.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class KafkaTbRuleEngineQueueFactoryDiffblueTest {
  @Autowired
  private KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;

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
  private TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;

  @MockBean
  private TbServiceInfoProvider tbServiceInfoProvider;

  @MockBean
  private TopicService topicService;

  /**
   * Test
   * {@link KafkaTbRuleEngineQueueFactory#createTransportNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2391 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbRuleEngineQueueFactory.createTransportNotificationsMsgProducer();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createRuleEngineMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateRuleEngineMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2278 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbRuleEngineQueueFactory.createRuleEngineMsgProducer();
  }

  /**
   * Test
   * {@link KafkaTbRuleEngineQueueFactory#createRuleEngineNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateRuleEngineNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2281 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbRuleEngineQueueFactory.createRuleEngineNotificationsMsgProducer();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createTbCoreMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2284 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbRuleEngineQueueFactory.createTbCoreMsgProducer();
  }

  /**
   * Test
   * {@link KafkaTbRuleEngineQueueFactory#createToOtaPackageStateServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createToOtaPackageStateServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateToOtaPackageStateServiceMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2290 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbRuleEngineQueueFactory.createToOtaPackageStateServiceMsgProducer();
  }

  /**
   * Test
   * {@link KafkaTbRuleEngineQueueFactory#createTbCoreNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2287 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbRuleEngineQueueFactory.createTbCoreNotificationsMsgProducer();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createEdgeMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateEdgeMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2266 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbRuleEngineQueueFactory.createEdgeMsgProducer();
  }

  /**
   * Test
   * {@link KafkaTbRuleEngineQueueFactory#createEdgeNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateEdgeNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2269 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbRuleEngineQueueFactory.createEdgeNotificationsMsgProducer();
  }

  /**
   * Test
   * {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   * with {@code configuration}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   */
  @Test
  @DisplayName("Test createToRuleEngineMsgConsumer(Queue) with 'configuration'")
  void testCreateToRuleEngineMsgConsumerWithConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbKafkaTopicConfigs kafkaTopicConfigs = mock(TbKafkaTopicConfigs.class);
    when(kafkaTopicConfigs.getCoreConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getEdgeConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getFwUpdatesConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getHousekeeperConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getJsExecutorRequestConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getJsExecutorResponseConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getNotificationsConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getRuleEngineConfigs()).thenReturn(new HashMap<>());
    TopicService topicService = mock(TopicService.class);
    TbKafkaSettings kafkaSettings = new TbKafkaSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueRemoteJsInvokeSettings jsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    TbKafkaSettings kafkaSettings2 = new TbKafkaSettings();
    TbKafkaConsumerStatsService consumerStatsService = new TbKafkaConsumerStatsService(kafkaSettings2,
        new TbKafkaConsumerStatisticConfig());

    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory = new KafkaTbRuleEngineQueueFactory(topicService,
        kafkaSettings, serviceInfoProvider, coreSettings, ruleEngineSettings, jsInvokeSettings, consumerStatsService,
        transportNotificationSettings, new TbQueueEdgeSettings(), kafkaTopicConfigs);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createToRuleEngineMsgConsumer(new Queue()));
    verify(kafkaTopicConfigs).getCoreConfigs();
    verify(kafkaTopicConfigs).getEdgeConfigs();
    verify(kafkaTopicConfigs).getFwUpdatesConfigs();
    verify(kafkaTopicConfigs).getHousekeeperConfigs();
    verify(kafkaTopicConfigs).getJsExecutorRequestConfigs();
    verify(kafkaTopicConfigs).getJsExecutorResponseConfigs();
    verify(kafkaTopicConfigs).getNotificationsConfigs();
    verify(kafkaTopicConfigs).getRuleEngineConfigs();
  }

  /**
   * Test
   * {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   * with {@code configuration}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   */
  @Test
  @DisplayName("Test createToRuleEngineMsgConsumer(Queue) with 'configuration'")
  @Disabled("TODO: Complete this test")
  void testCreateToRuleEngineMsgConsumerWithConfiguration2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2293 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbRuleEngineQueueFactory.createToRuleEngineMsgConsumer(new Queue());
  }

  /**
   * Test
   * {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue, Integer)}
   * with {@code configuration}, {@code partitionId}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue, Integer)}
   */
  @Test
  @DisplayName("Test createToRuleEngineMsgConsumer(Queue, Integer) with 'configuration', 'partitionId'")
  @Disabled("TODO: Complete this test")
  void testCreateToRuleEngineMsgConsumerWithConfigurationPartitionId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2326 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbRuleEngineQueueFactory.createToRuleEngineMsgConsumer(new Queue(), 1);
  }

  /**
   * Test
   * {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineNotificationsMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToRuleEngineNotificationsMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToRuleEngineNotificationsMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2385 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbRuleEngineQueueFactory.createToRuleEngineNotificationsMsgConsumer();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createRemoteJsRequestTemplate()}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate()")
  @Disabled("TODO: Complete this test")
  void testCreateRemoteJsRequestTemplate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2275 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbRuleEngineQueueFactory.createRemoteJsRequestTemplate();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createRemoteJsRequestTemplate()}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate(); then throw UnsupportedOperationException")
  void testCreateRemoteJsRequestTemplate_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException("rule-engine-node-"));

    TbQueueRemoteJsInvokeSettings jsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    jsInvokeSettings.setPrefix("Prefix");
    TbKafkaTopicConfigs kafkaTopicConfigs = mock(TbKafkaTopicConfigs.class);
    when(kafkaTopicConfigs.getCoreConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getEdgeConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getFwUpdatesConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getHousekeeperConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getJsExecutorRequestConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getJsExecutorResponseConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getNotificationsConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getRuleEngineConfigs()).thenReturn(new HashMap<>());
    TbKafkaSettings kafkaSettings = new TbKafkaSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbKafkaSettings kafkaSettings2 = new TbKafkaSettings();
    TbKafkaConsumerStatsService consumerStatsService = new TbKafkaConsumerStatsService(kafkaSettings2,
        new TbKafkaConsumerStatisticConfig());

    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new KafkaTbRuleEngineQueueFactory(topicService, kafkaSettings, serviceInfoProvider, coreSettings,
            ruleEngineSettings, jsInvokeSettings, consumerStatsService, transportNotificationSettings,
            new TbQueueEdgeSettings(), kafkaTopicConfigs)).createRemoteJsRequestTemplate());
    verify(topicService).buildTopicName(eq("rule-engine-node-"));
    verify(kafkaTopicConfigs).getCoreConfigs();
    verify(kafkaTopicConfigs).getEdgeConfigs();
    verify(kafkaTopicConfigs).getFwUpdatesConfigs();
    verify(kafkaTopicConfigs).getHousekeeperConfigs();
    verify(kafkaTopicConfigs).getJsExecutorRequestConfigs();
    verify(kafkaTopicConfigs).getJsExecutorResponseConfigs();
    verify(kafkaTopicConfigs).getNotificationsConfigs();
    verify(kafkaTopicConfigs).getRuleEngineConfigs();
  }

  /**
   * Test
   * {@link KafkaTbRuleEngineQueueFactory#createToUsageStatsServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateToUsageStatsServiceMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2388 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbRuleEngineQueueFactory.createToUsageStatsServiceMsgProducer();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createHousekeeperMsgProducer()}.
   * <p>
   * Method under test:
   * {@link KafkaTbRuleEngineQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory
    //   - org.thingsboard.server.queue.kafka.TbKafkaSettings
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory.class,org.thingsboard.server.queue.kafka.TbKafkaSettings.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2272 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService tbKafkaConsumerStatsService;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.kafka.TbKafkaSettings tbKafkaSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs tbKafkaTopicConfigs;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings tbQueueRuleEngineSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TbServiceInfoProvider tbServiceInfoProvider;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    kafkaTbRuleEngineQueueFactory.createHousekeeperMsgProducer();
  }
}
