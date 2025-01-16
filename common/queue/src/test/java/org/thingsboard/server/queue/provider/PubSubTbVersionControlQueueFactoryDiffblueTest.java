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
import org.thingsboard.server.queue.pubsub.TbPubSubSettings;
import org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;

@ContextConfiguration(classes = {PubSubTbVersionControlQueueFactory.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class PubSubTbVersionControlQueueFactoryDiffblueTest {
  @Autowired
  private PubSubTbVersionControlQueueFactory pubSubTbVersionControlQueueFactory;

  @MockBean
  private TbPubSubSettings tbPubSubSettings;

  @MockBean
  private TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;

  @MockBean
  private TbQueueCoreSettings tbQueueCoreSettings;

  @MockBean
  private TbQueueVersionControlSettings tbQueueVersionControlSettings;

  @MockBean
  private TopicService topicService;

  /**
   * Test
   * {@link PubSubTbVersionControlQueueFactory#createToUsageStatsServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbVersionControlQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateToUsageStatsServiceMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbVersionControlQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbVersionControlQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2679 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbVersionControlQueueFactory pubSubTbVersionControlQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    pubSubTbVersionControlQueueFactory.createToUsageStatsServiceMsgProducer();
  }

  /**
   * Test
   * {@link PubSubTbVersionControlQueueFactory#createTbCoreNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbVersionControlQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbVersionControlQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbVersionControlQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2676 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbVersionControlQueueFactory pubSubTbVersionControlQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    pubSubTbVersionControlQueueFactory.createTbCoreNotificationsMsgProducer();
  }

  /**
   * Test
   * {@link PubSubTbVersionControlQueueFactory#createToVersionControlMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbVersionControlQueueFactory#createToVersionControlMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToVersionControlMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToVersionControlMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbVersionControlQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbVersionControlQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2682 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbVersionControlQueueFactory pubSubTbVersionControlQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    pubSubTbVersionControlQueueFactory.createToVersionControlMsgConsumer();
  }

  /**
   * Test
   * {@link PubSubTbVersionControlQueueFactory#createHousekeeperMsgProducer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbVersionControlQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbVersionControlQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbVersionControlQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2673 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbVersionControlQueueFactory pubSubTbVersionControlQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueVersionControlSettings tbQueueVersionControlSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.discovery.TopicService topicService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    pubSubTbVersionControlQueueFactory.createHousekeeperMsgProducer();
  }
}
