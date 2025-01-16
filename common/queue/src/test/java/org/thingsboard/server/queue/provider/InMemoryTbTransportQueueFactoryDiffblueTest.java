package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.TbQueueProducer;
import org.thingsboard.server.queue.TbQueueRequestTemplate;
import org.thingsboard.server.queue.common.DefaultTbQueueRequestTemplate;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryTbQueueConsumer;
import org.thingsboard.server.queue.memory.InMemoryTbQueueProducer;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;

@ContextConfiguration(classes = {InMemoryTbTransportQueueFactory.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class InMemoryTbTransportQueueFactoryDiffblueTest {
  @MockBean
  private InMemoryStorage inMemoryStorage;

  @Autowired
  private InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory;

  @MockBean
  private TbQueueCoreSettings tbQueueCoreSettings;

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
   * {@link InMemoryTbTransportQueueFactory#createTransportApiRequestTemplate()}.
   * <p>
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createTransportApiRequestTemplate()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestTemplate()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportApiRequestTemplate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2024 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
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
    inMemoryTbTransportQueueFactory.createTransportApiRequestTemplate();
  }

  /**
   * Test
   * {@link InMemoryTbTransportQueueFactory#createTransportApiRequestTemplate()}.
   * <ul>
   *   <li>Then return {@link DefaultTbQueueRequestTemplate}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createTransportApiRequestTemplate()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestTemplate(); then return DefaultTbQueueRequestTemplate")
  void testCreateTransportApiRequestTemplate_thenReturnDefaultTbQueueRequestTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueTransportApiSettings transportApiSettings = mock(TbQueueTransportApiSettings.class);
    when(transportApiSettings.getMaxPendingRequests()).thenReturn(3);
    when(transportApiSettings.getMaxRequestsTimeout()).thenReturn(3);
    when(transportApiSettings.getResponsesTopic()).thenReturn("Responses Topic");
    when(transportApiSettings.getResponsePollInterval()).thenReturn(42L);
    when(transportApiSettings.getRequestsTopic()).thenReturn("Requests Topic");
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();

    // Act
    TbQueueRequestTemplate<TbProtoQueueMsg<TransportProtos.TransportApiRequestMsg>, TbProtoQueueMsg<TransportProtos.TransportApiResponseMsg>> actualCreateTransportApiRequestTemplateResult = (new InMemoryTbTransportQueueFactory(
        transportApiSettings, transportNotificationSettings, serviceInfoProvider, coreSettings,
        new DefaultInMemoryStorage(), topicService)).createTransportApiRequestTemplate();

    // Assert
    verify(topicService, atLeast(1)).buildTopicName(Mockito.<String>any());
    verify(transportApiSettings).getMaxPendingRequests();
    verify(transportApiSettings).getMaxRequestsTimeout();
    verify(transportApiSettings).getRequestsTopic();
    verify(transportApiSettings).getResponsePollInterval();
    verify(transportApiSettings).getResponsesTopic();
    assertTrue(actualCreateTransportApiRequestTemplateResult instanceof DefaultTbQueueRequestTemplate);
  }

  /**
   * Test {@link InMemoryTbTransportQueueFactory#createRuleEngineMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateRuleEngineMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2012 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
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
    inMemoryTbTransportQueueFactory.createRuleEngineMsgProducer();
  }

  /**
   * Test {@link InMemoryTbTransportQueueFactory#createRuleEngineMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateRuleEngineMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueTransportApiSettings transportApiSettings = mock(TbQueueTransportApiSettings.class);
    when(transportApiSettings.getRequestsTopic()).thenReturn("Requests Topic");
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> actualCreateRuleEngineMsgProducerResult = (new InMemoryTbTransportQueueFactory(
        transportApiSettings, transportNotificationSettings, serviceInfoProvider, coreSettings, storage, topicService))
        .createRuleEngineMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Requests Topic"));
    verify(transportApiSettings).getRequestsTopic();
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>>) actualCreateRuleEngineMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateRuleEngineMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateRuleEngineMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryTbTransportQueueFactory#createTbCoreMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2015 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
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
    inMemoryTbTransportQueueFactory.createTbCoreMsgProducer();
  }

  /**
   * Test {@link InMemoryTbTransportQueueFactory#createTbCoreMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateTbCoreMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreMsg>> actualCreateTbCoreMsgProducerResult = (new InMemoryTbTransportQueueFactory(
        transportApiSettings, transportNotificationSettings, serviceInfoProvider, coreSettings, storage, topicService))
        .createTbCoreMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreMsg>>) actualCreateTbCoreMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateTbCoreMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateTbCoreMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryTbTransportQueueFactory#createTbCoreNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2018 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
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
    inMemoryTbTransportQueueFactory.createTbCoreNotificationsMsgProducer();
  }

  /**
   * Test
   * {@link InMemoryTbTransportQueueFactory#createTbCoreNotificationsMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateTbCoreNotificationsMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreNotificationMsg>> actualCreateTbCoreNotificationsMsgProducerResult = (new InMemoryTbTransportQueueFactory(
        transportApiSettings, transportNotificationSettings, serviceInfoProvider, coreSettings, storage, topicService))
        .createTbCoreNotificationsMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreNotificationMsg>>) actualCreateTbCoreNotificationsMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateTbCoreNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateTbCoreNotificationsMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryTbTransportQueueFactory#createTransportNotificationsConsumer()}.
   * <p>
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createTransportNotificationsConsumer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportNotificationsConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2027 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
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
    inMemoryTbTransportQueueFactory.createTransportNotificationsConsumer();
  }

  /**
   * Test
   * {@link InMemoryTbTransportQueueFactory#createTransportNotificationsConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createTransportNotificationsConsumer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateTransportNotificationsConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToTransportMsg>> actualCreateTransportNotificationsConsumerResult = (new InMemoryTbTransportQueueFactory(
        transportApiSettings, transportNotificationSettings, serviceInfoProvider, coreSettings,
        new DefaultInMemoryStorage(), topicService)).createTransportNotificationsConsumer();

    // Assert
    verify(topicService).buildTopicName(eq("null.null"));
    assertTrue(actualCreateTransportNotificationsConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateTransportNotificationsConsumerResult.getTopic());
    assertFalse(actualCreateTransportNotificationsConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryTbTransportQueueFactory#createToUsageStatsServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateToUsageStatsServiceMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2021 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
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
    inMemoryTbTransportQueueFactory.createToUsageStatsServiceMsgProducer();
  }

  /**
   * Test
   * {@link InMemoryTbTransportQueueFactory#createToUsageStatsServiceMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateToUsageStatsServiceMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToUsageStatsServiceMsg>> actualCreateToUsageStatsServiceMsgProducerResult = (new InMemoryTbTransportQueueFactory(
        transportApiSettings, transportNotificationSettings, serviceInfoProvider, coreSettings, storage, topicService))
        .createToUsageStatsServiceMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToUsageStatsServiceMsg>>) actualCreateToUsageStatsServiceMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateToUsageStatsServiceMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateToUsageStatsServiceMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryTbTransportQueueFactory#createHousekeeperMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2009 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
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
    inMemoryTbTransportQueueFactory.createHousekeeperMsgProducer();
  }

  /**
   * Test {@link InMemoryTbTransportQueueFactory#createHousekeeperMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateHousekeeperMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>> actualCreateHousekeeperMsgProducerResult = (new InMemoryTbTransportQueueFactory(
        transportApiSettings, transportNotificationSettings, serviceInfoProvider, coreSettings, storage, topicService))
        .createHousekeeperMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>>) actualCreateHousekeeperMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateHousekeeperMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateHousekeeperMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }
}
