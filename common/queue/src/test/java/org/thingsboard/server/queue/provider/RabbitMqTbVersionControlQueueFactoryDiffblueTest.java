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
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.rabbitmq.TbRabbitMqQueueArguments;
import org.thingsboard.server.queue.rabbitmq.TbRabbitMqSettings;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;

@ContextConfiguration(classes = {RabbitMqTbVersionControlQueueFactory.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class RabbitMqTbVersionControlQueueFactoryDiffblueTest {
  @Autowired
  private RabbitMqTbVersionControlQueueFactory rabbitMqTbVersionControlQueueFactory;

  @MockBean
  private TbQueueCoreSettings tbQueueCoreSettings;

  @MockBean
  private TbQueueVersionControlSettings tbQueueVersionControlSettings;

  @MockBean
  private TbRabbitMqQueueArguments tbRabbitMqQueueArguments;

  @MockBean
  private TbRabbitMqSettings tbRabbitMqSettings;

  @MockBean
  private TopicService topicService;

  /**
   * Test
   * {@link RabbitMqTbVersionControlQueueFactory#createToUsageStatsServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link RabbitMqTbVersionControlQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateToUsageStatsServiceMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.RabbitMqTbVersionControlQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.RabbitMqTbVersionControlQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2958 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.RabbitMqTbVersionControlQueueFactory rabbitMqTbVersionControlQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.rabbitmq.TbRabbitMqQueueArguments tbRabbitMqQueueArguments;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.rabbitmq.TbRabbitMqSettings tbRabbitMqSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    rabbitMqTbVersionControlQueueFactory.createToUsageStatsServiceMsgProducer();
  }

  /**
   * Test
   * {@link RabbitMqTbVersionControlQueueFactory#createTbCoreNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link RabbitMqTbVersionControlQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.RabbitMqTbVersionControlQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.RabbitMqTbVersionControlQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2955 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.RabbitMqTbVersionControlQueueFactory rabbitMqTbVersionControlQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.rabbitmq.TbRabbitMqQueueArguments tbRabbitMqQueueArguments;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.rabbitmq.TbRabbitMqSettings tbRabbitMqSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    rabbitMqTbVersionControlQueueFactory.createTbCoreNotificationsMsgProducer();
  }

  /**
   * Test
   * {@link RabbitMqTbVersionControlQueueFactory#createToVersionControlMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link RabbitMqTbVersionControlQueueFactory#createToVersionControlMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToVersionControlMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToVersionControlMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.RabbitMqTbVersionControlQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.RabbitMqTbVersionControlQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2961 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.RabbitMqTbVersionControlQueueFactory rabbitMqTbVersionControlQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.rabbitmq.TbRabbitMqQueueArguments tbRabbitMqQueueArguments;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.rabbitmq.TbRabbitMqSettings tbRabbitMqSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    rabbitMqTbVersionControlQueueFactory.createToVersionControlMsgConsumer();
  }

  /**
   * Test
   * {@link RabbitMqTbVersionControlQueueFactory#createHousekeeperMsgProducer()}.
   * <p>
   * Method under test:
   * {@link RabbitMqTbVersionControlQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.RabbitMqTbVersionControlQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.RabbitMqTbVersionControlQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2952 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.RabbitMqTbVersionControlQueueFactory rabbitMqTbVersionControlQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.rabbitmq.TbRabbitMqQueueArguments tbRabbitMqQueueArguments;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.rabbitmq.TbRabbitMqSettings tbRabbitMqSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    rabbitMqTbVersionControlQueueFactory.createHousekeeperMsgProducer();
  }
}
