package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.thingsboard.server.queue.TbQueueProducer;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryTbQueueProducer;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;

@ContextConfiguration(classes = {TbTransportQueueProducerProvider.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TbTransportQueueProducerProviderDiffblueTest {
  @MockBean
  private TbTransportQueueFactory tbTransportQueueFactory;

  @Autowired
  private TbTransportQueueProducerProvider tbTransportQueueProducerProvider;

  /**
   * Test {@link TbTransportQueueProducerProvider#init()}.
   * <p>
   * Method under test: {@link TbTransportQueueProducerProvider#init()}
   */
  @Test
  @DisplayName("Test init()")
  void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    TbTransportQueueProducerProvider tbTransportQueueProducerProvider = new TbTransportQueueProducerProvider(
        new InMemoryTbTransportQueueFactory(transportApiSettings, transportNotificationSettings, serviceInfoProvider,
            coreSettings, storage, topicService));

    // Act
    tbTransportQueueProducerProvider.init();

    // Assert
    verify(topicService, atLeast(1)).buildTopicName(isNull());
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>> housekeeperMsgProducer = tbTransportQueueProducerProvider
        .getHousekeeperMsgProducer();
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>>) housekeeperMsgProducer)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(housekeeperMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> ruleEngineMsgProducer = tbTransportQueueProducerProvider
        .getRuleEngineMsgProducer();
    assertTrue(ruleEngineMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreMsg>> tbCoreMsgProducer = tbTransportQueueProducerProvider
        .getTbCoreMsgProducer();
    assertTrue(tbCoreMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreNotificationMsg>> tbCoreNotificationsMsgProducer = tbTransportQueueProducerProvider
        .getTbCoreNotificationsMsgProducer();
    assertTrue(tbCoreNotificationsMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToUsageStatsServiceMsg>> tbUsageStatsMsgProducer = tbTransportQueueProducerProvider
        .getTbUsageStatsMsgProducer();
    assertTrue(tbUsageStatsMsgProducer instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", housekeeperMsgProducer.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertEquals(housekeeperMsgProducer, ruleEngineMsgProducer);
    assertEquals(housekeeperMsgProducer, tbCoreMsgProducer);
    assertEquals(housekeeperMsgProducer, tbCoreNotificationsMsgProducer);
    assertEquals(housekeeperMsgProducer, tbUsageStatsMsgProducer);
    assertSame(storage, storage2);
  }

  /**
   * Test {@link TbTransportQueueProducerProvider#init()}.
   * <p>
   * Method under test: {@link TbTransportQueueProducerProvider#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Disabled("TODO: Complete this test")
  void testInit2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3347 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbTransportQueueFactory tbTransportQueueFactory;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider tbTransportQueueProducerProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbTransportQueueProducerProvider.init();
  }

  /**
   * Test
   * {@link TbTransportQueueProducerProvider#getTransportNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbTransportQueueProducerProvider#getTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getTransportNotificationsMsgProducer()")
  void testGetTransportNotificationsMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbTransportQueueProducerProvider(new InMemoryTbTransportQueueFactory(transportApiSettings,
            transportNotificationSettings, serviceInfoProvider, coreSettings, storage, new TopicService())))
            .getTransportNotificationsMsgProducer());
  }

  /**
   * Test
   * {@link TbTransportQueueProducerProvider#getTransportNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbTransportQueueProducerProvider#getTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getTransportNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testGetTransportNotificationsMsgProducer2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3344 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbTransportQueueFactory tbTransportQueueFactory;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider tbTransportQueueProducerProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbTransportQueueProducerProvider.getTransportNotificationsMsgProducer();
  }

  /**
   * Test
   * {@link TbTransportQueueProducerProvider#getRuleEngineNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbTransportQueueProducerProvider#getRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getRuleEngineNotificationsMsgProducer()")
  void testGetRuleEngineNotificationsMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbTransportQueueProducerProvider(new InMemoryTbTransportQueueFactory(transportApiSettings,
            transportNotificationSettings, serviceInfoProvider, coreSettings, storage, new TopicService())))
            .getRuleEngineNotificationsMsgProducer());
  }

  /**
   * Test
   * {@link TbTransportQueueProducerProvider#getRuleEngineNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbTransportQueueProducerProvider#getRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getRuleEngineNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testGetRuleEngineNotificationsMsgProducer2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3332 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbTransportQueueFactory tbTransportQueueFactory;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider tbTransportQueueProducerProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbTransportQueueProducerProvider.getRuleEngineNotificationsMsgProducer();
  }

  /**
   * Test {@link TbTransportQueueProducerProvider#getTbEdgeMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbTransportQueueProducerProvider#getTbEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbEdgeMsgProducer()")
  void testGetTbEdgeMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbTransportQueueProducerProvider(new InMemoryTbTransportQueueFactory(transportApiSettings,
            transportNotificationSettings, serviceInfoProvider, coreSettings, storage, new TopicService())))
            .getTbEdgeMsgProducer());
  }

  /**
   * Test {@link TbTransportQueueProducerProvider#getTbEdgeMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbTransportQueueProducerProvider#getTbEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbEdgeMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testGetTbEdgeMsgProducer2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3335 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbTransportQueueFactory tbTransportQueueFactory;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider tbTransportQueueProducerProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbTransportQueueProducerProvider.getTbEdgeMsgProducer();
  }

  /**
   * Test
   * {@link TbTransportQueueProducerProvider#getTbEdgeNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbTransportQueueProducerProvider#getTbEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbEdgeNotificationsMsgProducer()")
  void testGetTbEdgeNotificationsMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbTransportQueueProducerProvider(new InMemoryTbTransportQueueFactory(transportApiSettings,
            transportNotificationSettings, serviceInfoProvider, coreSettings, storage, new TopicService())))
            .getTbEdgeNotificationsMsgProducer());
  }

  /**
   * Test
   * {@link TbTransportQueueProducerProvider#getTbEdgeNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbTransportQueueProducerProvider#getTbEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbEdgeNotificationsMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testGetTbEdgeNotificationsMsgProducer2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3338 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbTransportQueueFactory tbTransportQueueFactory;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider tbTransportQueueProducerProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbTransportQueueProducerProvider.getTbEdgeNotificationsMsgProducer();
  }

  /**
   * Test
   * {@link TbTransportQueueProducerProvider#getTbVersionControlMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbTransportQueueProducerProvider#getTbVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbVersionControlMsgProducer()")
  void testGetTbVersionControlMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbTransportQueueProducerProvider(new InMemoryTbTransportQueueFactory(transportApiSettings,
            transportNotificationSettings, serviceInfoProvider, coreSettings, storage, new TopicService())))
            .getTbVersionControlMsgProducer());
  }

  /**
   * Test
   * {@link TbTransportQueueProducerProvider#getTbVersionControlMsgProducer()}.
   * <p>
   * Method under test:
   * {@link TbTransportQueueProducerProvider#getTbVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbVersionControlMsgProducer()")
  @Disabled("TODO: Complete this test")
  void testGetTbVersionControlMsgProducer2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider
    //   when running class:
    //   package org.thingsboard.server.queue.provider;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3341 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.thingsboard.server.queue.provider.TbTransportQueueFactory tbTransportQueueFactory;
    //     @org.springframework.beans.factory.annotation.Autowired org.thingsboard.server.queue.provider.TbTransportQueueProducerProvider tbTransportQueueProducerProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    tbTransportQueueProducerProvider.getTbVersionControlMsgProducer();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbTransportQueueProducerProvider#getHousekeeperMsgProducer()}
   *   <li>{@link TbTransportQueueProducerProvider#getRuleEngineMsgProducer()}
   *   <li>{@link TbTransportQueueProducerProvider#getTbCoreMsgProducer()}
   *   <li>
   * {@link TbTransportQueueProducerProvider#getTbCoreNotificationsMsgProducer()}
   *   <li>{@link TbTransportQueueProducerProvider#getTbUsageStatsMsgProducer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    TbTransportQueueProducerProvider tbTransportQueueProducerProvider = new TbTransportQueueProducerProvider(
        new InMemoryTbTransportQueueFactory(transportApiSettings, transportNotificationSettings, serviceInfoProvider,
            coreSettings, storage, new TopicService()));

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>> actualHousekeeperMsgProducer = tbTransportQueueProducerProvider
        .getHousekeeperMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> actualRuleEngineMsgProducer = tbTransportQueueProducerProvider
        .getRuleEngineMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreMsg>> actualTbCoreMsgProducer = tbTransportQueueProducerProvider
        .getTbCoreMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreNotificationMsg>> actualTbCoreNotificationsMsgProducer = tbTransportQueueProducerProvider
        .getTbCoreNotificationsMsgProducer();

    // Assert
    assertNull(actualTbCoreMsgProducer);
    assertNull(actualTbCoreNotificationsMsgProducer);
    assertNull(actualHousekeeperMsgProducer);
    assertNull(actualRuleEngineMsgProducer);
    assertNull(tbTransportQueueProducerProvider.getTbUsageStatsMsgProducer());
  }
}
