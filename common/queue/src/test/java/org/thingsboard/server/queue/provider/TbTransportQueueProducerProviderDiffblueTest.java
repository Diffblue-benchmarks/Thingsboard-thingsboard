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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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

class TbTransportQueueProducerProviderDiffblueTest {
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
