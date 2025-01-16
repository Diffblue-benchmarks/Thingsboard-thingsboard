package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.TbQueueProducer;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryTbQueueConsumer;
import org.thingsboard.server.queue.memory.InMemoryTbQueueProducer;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;

@ContextConfiguration(classes = {InMemoryMonolithQueueFactory.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class InMemoryMonolithQueueFactoryDiffblueTest {
  @Autowired
  private InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;

  @MockBean
  private InMemoryStorage inMemoryStorage;

  @MockBean
  private TbQueueCoreSettings tbQueueCoreSettings;

  @MockBean
  private TbQueueEdgeSettings tbQueueEdgeSettings;

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
   * {@link InMemoryMonolithQueueFactory#createTransportNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsMsgProducer()")
  void testCreateTransportNotificationsMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToTransportMsg>> actualCreateTransportNotificationsMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createTransportNotificationsMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToTransportMsg>>) actualCreateTransportNotificationsMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateTransportNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateTransportNotificationsMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createTransportNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportNotificationsMsgProducer2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2003 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createTransportNotificationsMsgProducer();
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createRuleEngineMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateRuleEngineMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1925 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createRuleEngineMsgProducer();
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createRuleEngineMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateRuleEngineMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> actualCreateRuleEngineMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createRuleEngineMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>>) actualCreateRuleEngineMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateRuleEngineMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateRuleEngineMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineNotificationsMsgProducer()")
  void testCreateRuleEngineNotificationsMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineNotificationMsg>> actualCreateRuleEngineNotificationsMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createRuleEngineNotificationsMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineNotificationMsg>>) actualCreateRuleEngineNotificationsMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateRuleEngineNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateRuleEngineNotificationsMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateRuleEngineNotificationsMsgProducer2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1928 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createRuleEngineNotificationsMsgProducer();
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createTbCoreMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1931 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createTbCoreMsgProducer();
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createTbCoreMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateTbCoreMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreMsg>> actualCreateTbCoreMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createTbCoreMsgProducer();

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
   * {@link InMemoryMonolithQueueFactory#createTbCoreNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTbCoreNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1934 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createTbCoreNotificationsMsgProducer();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createTbCoreNotificationsMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateTbCoreNotificationsMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .topic("Topic")
        .build();
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any())).thenReturn(buildResult);
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreNotificationMsg>> actualCreateTbCoreNotificationsMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createTbCoreNotificationsMsgProducer();

    // Assert
    verify(topicService).getNotificationsTopic(eq(ServiceType.TB_CORE), isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreNotificationMsg>>) actualCreateTbCoreNotificationsMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateTbCoreNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1",
        actualCreateTbCoreNotificationsMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToVersionControlMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToVersionControlMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToVersionControlMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToVersionControlMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1994 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createToVersionControlMsgConsumer();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToVersionControlMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToVersionControlMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToVersionControlMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateToVersionControlMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToVersionControlServiceMsg>> actualCreateToVersionControlMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())).createToVersionControlMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateToVersionControlMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToVersionControlMsgConsumerResult.getTopic());
    assertFalse(actualCreateToVersionControlMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   * with {@code configuration}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   */
  @Test
  @DisplayName("Test createToRuleEngineMsgConsumer(Queue) with 'configuration'")
  void testCreateToRuleEngineMsgConsumerWithConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory = new InMemoryMonolithQueueFactory(topicService,
        coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage());

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> actualCreateToRuleEngineMsgConsumerResult = inMemoryMonolithQueueFactory
        .createToRuleEngineMsgConsumer(new Queue());

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateToRuleEngineMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToRuleEngineMsgConsumerResult.getTopic());
    assertFalse(actualCreateToRuleEngineMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   * with {@code configuration}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   */
  @Test
  @DisplayName("Test createToRuleEngineMsgConsumer(Queue) with 'configuration'")
  @Disabled("TODO: Complete this test")
  void testCreateToRuleEngineMsgConsumerWithConfiguration2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1952 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createToRuleEngineMsgConsumer(new Queue());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToRuleEngineNotificationsMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToRuleEngineNotificationsMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1985 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createToRuleEngineNotificationsMsgConsumer();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToRuleEngineNotificationsMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateToRuleEngineNotificationsMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .topic("Topic")
        .build();
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any())).thenReturn(buildResult);
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToRuleEngineNotificationMsg>> actualCreateToRuleEngineNotificationsMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))
        .createToRuleEngineNotificationsMsgConsumer();

    // Assert
    verify(topicService).getNotificationsTopic(eq(ServiceType.TB_RULE_ENGINE), isNull());
    assertTrue(actualCreateToRuleEngineNotificationsMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1",
        actualCreateToRuleEngineNotificationsMsgConsumerResult.getTopic());
    assertFalse(actualCreateToRuleEngineNotificationsMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToCoreMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToCoreMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToCoreMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1937 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createToCoreMsgConsumer();
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToCoreMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToCoreMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateToCoreMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToCoreMsg>> actualCreateToCoreMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())).createToCoreMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateToCoreMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToCoreMsgConsumerResult.getTopic());
    assertFalse(actualCreateToCoreMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreNotificationsMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToCoreNotificationsMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1940 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createToCoreNotificationsMsgConsumer();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreNotificationsMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateToCoreNotificationsMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .topic("Topic")
        .build();
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any())).thenReturn(buildResult);
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToCoreNotificationMsg>> actualCreateToCoreNotificationsMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))
        .createToCoreNotificationsMsgConsumer();

    // Assert
    verify(topicService).getNotificationsTopic(eq(ServiceType.TB_CORE), isNull());
    assertTrue(actualCreateToCoreNotificationsMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1",
        actualCreateToCoreNotificationsMsgConsumerResult.getTopic());
    assertFalse(actualCreateToCoreNotificationsMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createTransportApiRequestConsumer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTransportApiRequestConsumer()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportApiRequestConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1997 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createTransportApiRequestConsumer();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createTransportApiRequestConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTransportApiRequestConsumer()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateTransportApiRequestConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.TransportApiRequestMsg>> actualCreateTransportApiRequestConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())).createTransportApiRequestConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateTransportApiRequestConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateTransportApiRequestConsumerResult.getTopic());
    assertFalse(actualCreateTransportApiRequestConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createTransportApiResponseProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTransportApiResponseProducer()}
   */
  @Test
  @DisplayName("Test createTransportApiResponseProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateTransportApiResponseProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2000 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createTransportApiResponseProducer();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createTransportApiResponseProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTransportApiResponseProducer()}
   */
  @Test
  @DisplayName("Test createTransportApiResponseProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateTransportApiResponseProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.TransportApiResponseMsg>> actualCreateTransportApiResponseProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createTransportApiResponseProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.TransportApiResponseMsg>>) actualCreateTransportApiResponseProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateTransportApiResponseProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateTransportApiResponseProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createRemoteJsRequestTemplate()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate()")
  void testCreateRemoteJsRequestTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertNull((new InMemoryMonolithQueueFactory(topicService, coreSettings, ruleEngineSettings, vcSettings,
        serviceInfoProvider, transportApiSettings, transportNotificationSettings, edgeSettings,
        new DefaultInMemoryStorage())).createRemoteJsRequestTemplate());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createRemoteJsRequestTemplate()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate()")
  void testCreateRemoteJsRequestTemplate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertNull((new InMemoryMonolithQueueFactory(topicService, coreSettings, ruleEngineSettings, vcSettings,
        serviceInfoProvider, transportApiSettings, transportNotificationSettings, edgeSettings,
        new DefaultInMemoryStorage())).createRemoteJsRequestTemplate());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createRemoteJsRequestTemplate()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate()")
  @Disabled("TODO: Complete this test")
  void testCreateRemoteJsRequestTemplate3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1922 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createRemoteJsRequestTemplate();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToUsageStatsServiceMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1988 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createToUsageStatsServiceMsgConsumer();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateToUsageStatsServiceMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToUsageStatsServiceMsg>> actualCreateToUsageStatsServiceMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))
        .createToUsageStatsServiceMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateToUsageStatsServiceMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToUsageStatsServiceMsgConsumerResult.getTopic());
    assertFalse(actualCreateToUsageStatsServiceMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToOtaPackageStateServiceMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1946 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createToOtaPackageStateServiceMsgConsumer();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateToOtaPackageStateServiceMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToOtaPackageStateServiceMsg>> actualCreateToOtaPackageStateServiceMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))
        .createToOtaPackageStateServiceMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateToOtaPackageStateServiceMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToOtaPackageStateServiceMsgConsumerResult.getTopic());
    assertFalse(actualCreateToOtaPackageStateServiceMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgProducer()")
  void testCreateToOtaPackageStateServiceMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToOtaPackageStateServiceMsg>> actualCreateToOtaPackageStateServiceMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createToOtaPackageStateServiceMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToOtaPackageStateServiceMsg>>) actualCreateToOtaPackageStateServiceMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateToOtaPackageStateServiceMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateToOtaPackageStateServiceMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateToOtaPackageStateServiceMsgProducer2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1949 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createToOtaPackageStateServiceMsgProducer();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateToUsageStatsServiceMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1991 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createToUsageStatsServiceMsgProducer();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateToUsageStatsServiceMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToUsageStatsServiceMsg>> actualCreateToUsageStatsServiceMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createToUsageStatsServiceMsgProducer();

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
   * Test {@link InMemoryMonolithQueueFactory#createVersionControlMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test createVersionControlMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateVersionControlMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2006 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createVersionControlMsgProducer();
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createVersionControlMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test createVersionControlMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateVersionControlMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToVersionControlServiceMsg>> actualCreateVersionControlMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createVersionControlMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToVersionControlServiceMsg>>) actualCreateVersionControlMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateVersionControlMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateVersionControlMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1913 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createHousekeeperMsgProducer();
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateHousekeeperMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>> actualCreateHousekeeperMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createHousekeeperMsgProducer();

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

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createHousekeeperMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1910 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createHousekeeperMsgConsumer();
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createHousekeeperMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateHousekeeperMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>> actualCreateHousekeeperMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())).createHousekeeperMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateHousekeeperMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateHousekeeperMsgConsumerResult.getTopic());
    assertFalse(actualCreateHousekeeperMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgProducer()")
  void testCreateHousekeeperReprocessingMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>> actualCreateHousekeeperReprocessingMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createHousekeeperReprocessingMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>>) actualCreateHousekeeperReprocessingMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateHousekeeperReprocessingMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateHousekeeperReprocessingMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperReprocessingMsgProducer2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1919 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createHousekeeperReprocessingMsgProducer();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateHousekeeperReprocessingMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1916 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createHousekeeperReprocessingMsgConsumer();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateHousekeeperReprocessingMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>> actualCreateHousekeeperReprocessingMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))
        .createHousekeeperReprocessingMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateHousekeeperReprocessingMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateHousekeeperReprocessingMsgConsumerResult.getTopic());
    assertFalse(actualCreateHousekeeperReprocessingMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createEdgeMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createEdgeMsgConsumer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateEdgeMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1901 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createEdgeMsgConsumer();
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createEdgeMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createEdgeMsgConsumer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateEdgeMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToEdgeMsg>> actualCreateEdgeMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())).createEdgeMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateEdgeMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateEdgeMsgConsumerResult.getTopic());
    assertFalse(actualCreateEdgeMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createEdgeMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateEdgeMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1904 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createEdgeMsgProducer();
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createEdgeMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateEdgeMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToEdgeMsg>> actualCreateEdgeMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createEdgeMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToEdgeMsg>>) actualCreateEdgeMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateEdgeMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateEdgeMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToEdgeNotificationsMsgConsumer()")
  @Disabled("TODO: Complete this test")
  void testCreateToEdgeNotificationsMsgConsumer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1943 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createToEdgeNotificationsMsgConsumer();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToEdgeNotificationsMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateToEdgeNotificationsMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .topic("Topic")
        .build();
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any())).thenReturn(buildResult);
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToEdgeNotificationMsg>> actualCreateToEdgeNotificationsMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))
        .createToEdgeNotificationsMsgConsumer();

    // Assert
    verify(topicService).getEdgeNotificationsTopic(isNull());
    assertTrue(actualCreateToEdgeNotificationsMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1",
        actualCreateToEdgeNotificationsMsgConsumerResult.getTopic());
    assertFalse(actualCreateToEdgeNotificationsMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createEdgeNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testCreateEdgeNotificationsMsgProducer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1907 {
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.memory.InMemoryStorage inMemoryStorage;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueCoreSettings tbQueueCoreSettings;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.settings.TbQueueEdgeSettings tbQueueEdgeSettings;
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
    inMemoryMonolithQueueFactory.createEdgeNotificationsMsgProducer();
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createEdgeNotificationsMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeNotificationsMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateEdgeNotificationsMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .topic("Topic")
        .build();
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any())).thenReturn(buildResult);
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToEdgeNotificationMsg>> actualCreateEdgeNotificationsMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createEdgeNotificationsMsgProducer();

    // Assert
    verify(topicService).getEdgeNotificationsTopic(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToEdgeNotificationMsg>>) actualCreateEdgeNotificationsMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateEdgeNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1",
        actualCreateEdgeNotificationsMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }
}
