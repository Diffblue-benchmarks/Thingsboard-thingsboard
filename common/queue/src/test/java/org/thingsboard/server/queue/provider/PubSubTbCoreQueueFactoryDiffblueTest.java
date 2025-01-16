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
import org.thingsboard.server.queue.pubsub.TbPubSubSettings;
import org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;

@ContextConfiguration(classes = {PubSubTbCoreQueueFactory.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class PubSubTbCoreQueueFactoryDiffblueTest {
  @Autowired
  private PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;

  @MockBean
  private TbPubSubSettings tbPubSubSettings;

  @MockBean
  private TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;

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
  private TbServiceInfoProvider tbServiceInfoProvider;

  @MockBean
  private TopicService topicService;

  /**
   * Test
   * {@link PubSubTbCoreQueueFactory#createTransportNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2598 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createTransportNotificationsMsgProducer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createRuleEngineMsgProducer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateRuleEngineMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2559 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createRuleEngineMsgProducer();
  }

  /**
   * Test
   * {@link PubSubTbCoreQueueFactory#createRuleEngineNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateRuleEngineNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2562 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createRuleEngineNotificationsMsgProducer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createTbCoreMsgProducer()}.
   * <p>
   * Method under test: {@link PubSubTbCoreQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2565 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createTbCoreMsgProducer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createTbCoreNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2568 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createTbCoreNotificationsMsgProducer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createToCoreMsgConsumer()}.
   * <p>
   * Method under test: {@link PubSubTbCoreQueueFactory#createToCoreMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToCoreMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2571 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createToCoreMsgConsumer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createToCoreNotificationsMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createToCoreNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreNotificationsMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToCoreNotificationsMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2574 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createToCoreNotificationsMsgConsumer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createTransportApiRequestConsumer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createTransportApiRequestConsumer()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportApiRequestConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2592 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createTransportApiRequestConsumer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createTransportApiResponseProducer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createTransportApiResponseProducer()}
   */
  @Test
  @DisplayName("Test createTransportApiResponseProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportApiResponseProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2595 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createTransportApiResponseProducer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createRemoteJsRequestTemplate()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate()")
  @Disabled("TODO: Complete this test")
  void testCreateRemoteJsRequestTemplate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2556 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createRemoteJsRequestTemplate();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createToUsageStatsServiceMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createToUsageStatsServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToUsageStatsServiceMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2586 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createToUsageStatsServiceMsgConsumer();
  }

  /**
   * Test
   * {@link PubSubTbCoreQueueFactory#createToOtaPackageStateServiceMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createToOtaPackageStateServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToOtaPackageStateServiceMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2580 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createToOtaPackageStateServiceMsgConsumer();
  }

  /**
   * Test
   * {@link PubSubTbCoreQueueFactory#createToOtaPackageStateServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createToOtaPackageStateServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateToOtaPackageStateServiceMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2583 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createToOtaPackageStateServiceMsgProducer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createToUsageStatsServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateToUsageStatsServiceMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2589 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createToUsageStatsServiceMsgProducer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createVersionControlMsgProducer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test createVersionControlMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateVersionControlMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2601 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createVersionControlMsgProducer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createHousekeeperMsgProducer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2547 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createHousekeeperMsgProducer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createHousekeeperMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createHousekeeperMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2544 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createHousekeeperMsgConsumer();
  }

  /**
   * Test
   * {@link PubSubTbCoreQueueFactory#createHousekeeperReprocessingMsgProducer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createHousekeeperReprocessingMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperReprocessingMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2553 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createHousekeeperReprocessingMsgProducer();
  }

  /**
   * Test
   * {@link PubSubTbCoreQueueFactory#createHousekeeperReprocessingMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createHousekeeperReprocessingMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperReprocessingMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2550 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createHousekeeperReprocessingMsgConsumer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createEdgeMsgConsumer()}.
   * <p>
   * Method under test: {@link PubSubTbCoreQueueFactory#createEdgeMsgConsumer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateEdgeMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2535 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createEdgeMsgConsumer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createEdgeMsgProducer()}.
   * <p>
   * Method under test: {@link PubSubTbCoreQueueFactory#createEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateEdgeMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2538 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createEdgeMsgProducer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createToEdgeNotificationsMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createToEdgeNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToEdgeNotificationsMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToEdgeNotificationsMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2577 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createToEdgeNotificationsMsgConsumer();
  }

  /**
   * Test {@link PubSubTbCoreQueueFactory#createEdgeNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link PubSubTbCoreQueueFactory#createEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateEdgeNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2541 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.PubSubTbCoreQueueFactory pubSubTbCoreQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSettings tbPubSubSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.pubsub.TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;
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
    pubSubTbCoreQueueFactory.createEdgeNotificationsMsgProducer();
  }
}
