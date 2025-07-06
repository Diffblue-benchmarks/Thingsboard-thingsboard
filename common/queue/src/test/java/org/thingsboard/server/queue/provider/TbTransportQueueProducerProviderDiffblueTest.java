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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ToCoreMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToCoreNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToHousekeeperServiceMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToRuleEngineMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToUsageStatsServiceMsg;
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

@ExtendWith(MockitoExtension.class)
class TbTransportQueueProducerProviderDiffblueTest {
  @Mock private TbTransportQueueFactory tbTransportQueueFactory;

  @InjectMocks private TbTransportQueueProducerProvider tbTransportQueueProducerProvider;

  /**
   * Test {@link TbTransportQueueProducerProvider#init()}.
   *
   * <p>Method under test: {@link TbTransportQueueProducerProvider#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbTransportQueueProducerProvider.init()"})
  void testInit() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    TbTransportQueueProducerProvider tbTransportQueueProducerProvider =
        new TbTransportQueueProducerProvider(
            new InMemoryTbTransportQueueFactory(
                transportApiSettings,
                transportNotificationSettings,
                serviceInfoProvider,
                coreSettings,
                storage,
                topicService));

    // Act
    tbTransportQueueProducerProvider.init();

    // Assert
    verify(topicService, atLeast(1)).buildTopicName(isNull());
    TbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>> housekeeperMsgProducer =
        tbTransportQueueProducerProvider.getHousekeeperMsgProducer();
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>) housekeeperMsgProducer)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(housekeeperMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<ToRuleEngineMsg>> ruleEngineMsgProducer =
        tbTransportQueueProducerProvider.getRuleEngineMsgProducer();
    assertTrue(ruleEngineMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<ToCoreMsg>> tbCoreMsgProducer =
        tbTransportQueueProducerProvider.getTbCoreMsgProducer();
    assertTrue(tbCoreMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<ToCoreNotificationMsg>> tbCoreNotificationsMsgProducer =
        tbTransportQueueProducerProvider.getTbCoreNotificationsMsgProducer();
    assertTrue(tbCoreNotificationsMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<ToUsageStatsServiceMsg>> tbUsageStatsMsgProducer =
        tbTransportQueueProducerProvider.getTbUsageStatsMsgProducer();
    assertTrue(tbUsageStatsMsgProducer instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", housekeeperMsgProducer.getDefaultTopic());
    assertEquals(housekeeperMsgProducer, ruleEngineMsgProducer);
    assertEquals(housekeeperMsgProducer, tbCoreMsgProducer);
    assertEquals(housekeeperMsgProducer, tbCoreNotificationsMsgProducer);
    assertEquals(housekeeperMsgProducer, tbUsageStatsMsgProducer);
    assertSame(storage, storage2);
  }

  /**
   * Test {@link TbTransportQueueProducerProvider#init()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbTransportQueueProducerProvider#init()}
   */
  @Test
  @DisplayName("Test init(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbTransportQueueProducerProvider.init()"})
  void testInit_thenThrowRuntimeException() {
    // Arrange
    when(tbTransportQueueFactory.createTbCoreMsgProducer()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbTransportQueueProducerProvider.init());
    verify(tbTransportQueueFactory).createTbCoreMsgProducer();
  }

  /**
   * Test {@link TbTransportQueueProducerProvider#getTransportNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * TbTransportQueueProducerProvider#getTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getTransportNotificationsMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer TbTransportQueueProducerProvider.getTransportNotificationsMsgProducer()"
  })
  void testGetTransportNotificationsMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbTransportQueueProducerProvider.getTransportNotificationsMsgProducer());
  }

  /**
   * Test {@link TbTransportQueueProducerProvider#getRuleEngineNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * TbTransportQueueProducerProvider#getRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getRuleEngineNotificationsMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer TbTransportQueueProducerProvider.getRuleEngineNotificationsMsgProducer()"
  })
  void testGetRuleEngineNotificationsMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbTransportQueueProducerProvider.getRuleEngineNotificationsMsgProducer());
  }

  /**
   * Test {@link TbTransportQueueProducerProvider#getTbEdgeMsgProducer()}.
   *
   * <p>Method under test: {@link TbTransportQueueProducerProvider#getTbEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbEdgeMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbQueueProducer TbTransportQueueProducerProvider.getTbEdgeMsgProducer()"})
  void testGetTbEdgeMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbTransportQueueProducerProvider.getTbEdgeMsgProducer());
  }

  /**
   * Test {@link TbTransportQueueProducerProvider#getTbEdgeNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * TbTransportQueueProducerProvider#getTbEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbEdgeNotificationsMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer TbTransportQueueProducerProvider.getTbEdgeNotificationsMsgProducer()"
  })
  void testGetTbEdgeNotificationsMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbTransportQueueProducerProvider.getTbEdgeNotificationsMsgProducer());
  }

  /**
   * Test {@link TbTransportQueueProducerProvider#getTbVersionControlMsgProducer()}.
   *
   * <p>Method under test: {@link TbTransportQueueProducerProvider#getTbVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbVersionControlMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer TbTransportQueueProducerProvider.getTbVersionControlMsgProducer()"
  })
  void testGetTbVersionControlMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbTransportQueueProducerProvider.getTbVersionControlMsgProducer());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbTransportQueueProducerProvider#getHousekeeperMsgProducer()}
   *   <li>{@link TbTransportQueueProducerProvider#getRuleEngineMsgProducer()}
   *   <li>{@link TbTransportQueueProducerProvider#getTbCoreMsgProducer()}
   *   <li>{@link TbTransportQueueProducerProvider#getTbCoreNotificationsMsgProducer()}
   *   <li>{@link TbTransportQueueProducerProvider#getTbUsageStatsMsgProducer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer TbTransportQueueProducerProvider.getHousekeeperMsgProducer()",
    "TbQueueProducer TbTransportQueueProducerProvider.getRuleEngineMsgProducer()",
    "TbQueueProducer TbTransportQueueProducerProvider.getTbCoreMsgProducer()",
    "TbQueueProducer TbTransportQueueProducerProvider.getTbCoreNotificationsMsgProducer()",
    "TbQueueProducer TbTransportQueueProducerProvider.getTbUsageStatsMsgProducer()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    TbTransportQueueProducerProvider tbTransportQueueProducerProvider =
        new TbTransportQueueProducerProvider(
            new InMemoryTbTransportQueueFactory(
                transportApiSettings,
                transportNotificationSettings,
                serviceInfoProvider,
                coreSettings,
                storage,
                new TopicService()));

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>> actualHousekeeperMsgProducer =
        tbTransportQueueProducerProvider.getHousekeeperMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<ToRuleEngineMsg>> actualRuleEngineMsgProducer =
        tbTransportQueueProducerProvider.getRuleEngineMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<ToCoreMsg>> actualTbCoreMsgProducer =
        tbTransportQueueProducerProvider.getTbCoreMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<ToCoreNotificationMsg>> actualTbCoreNotificationsMsgProducer =
        tbTransportQueueProducerProvider.getTbCoreNotificationsMsgProducer();

    // Assert
    assertNull(actualTbCoreMsgProducer);
    assertNull(actualTbCoreNotificationsMsgProducer);
    assertNull(actualHousekeeperMsgProducer);
    assertNull(actualRuleEngineMsgProducer);
    assertNull(tbTransportQueueProducerProvider.getTbUsageStatsMsgProducer());
  }
}
