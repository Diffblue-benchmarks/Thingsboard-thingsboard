package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo.TopicPartitionInfoBuilder;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ToCoreMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToCoreNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToEdgeMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToEdgeNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToHousekeeperServiceMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToRuleEngineMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToRuleEngineNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToTransportMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToUsageStatsServiceMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToVersionControlServiceMsg;
import org.thingsboard.server.queue.TbQueueProducer;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryTbQueueProducer;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;

class TbCoreQueueProducerProviderDiffblueTest {
  /**
   * Test {@link TbCoreQueueProducerProvider#init()}.
   *
   * <p>Method under test: {@link TbCoreQueueProducerProvider#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCoreQueueProducerProvider.init()"})
  void testInit() {
    // Arrange
    TopicService topicService = mock(TopicService.class);

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    TopicPartitionInfoBuilder partitionResult2 =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult2
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider tbCoreQueueProducerProvider =
        new TbCoreQueueProducerProvider(tbQueueProvider);

    // Act
    tbCoreQueueProducerProvider.init();

    // Assert
    verify(topicService, atLeast(1)).buildTopicName(null);
    verify(topicService).getEdgeNotificationsTopic(null);
    verify(topicService).getNotificationsTopic(ServiceType.TB_CORE, null);
    TbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>> housekeeperMsgProducer =
        tbCoreQueueProducerProvider.getHousekeeperMsgProducer();
    assertTrue(housekeeperMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<ToRuleEngineMsg>> ruleEngineMsgProducer =
        tbCoreQueueProducerProvider.getRuleEngineMsgProducer();
    assertTrue(ruleEngineMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<ToRuleEngineNotificationMsg>>
        ruleEngineNotificationsMsgProducer =
            tbCoreQueueProducerProvider.getRuleEngineNotificationsMsgProducer();
    assertTrue(ruleEngineNotificationsMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<ToCoreMsg>> tbCoreMsgProducer =
        tbCoreQueueProducerProvider.getTbCoreMsgProducer();
    assertTrue(tbCoreMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<ToCoreNotificationMsg>> tbCoreNotificationsMsgProducer =
        tbCoreQueueProducerProvider.getTbCoreNotificationsMsgProducer();
    assertTrue(tbCoreNotificationsMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<ToEdgeMsg>> tbEdgeMsgProducer =
        tbCoreQueueProducerProvider.getTbEdgeMsgProducer();
    assertTrue(tbEdgeMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<ToEdgeNotificationMsg>> tbEdgeNotificationsMsgProducer =
        tbCoreQueueProducerProvider.getTbEdgeNotificationsMsgProducer();
    assertTrue(tbEdgeNotificationsMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<ToUsageStatsServiceMsg>> tbUsageStatsMsgProducer =
        tbCoreQueueProducerProvider.getTbUsageStatsMsgProducer();
    assertTrue(tbUsageStatsMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<ToVersionControlServiceMsg>> tbVersionControlMsgProducer =
        tbCoreQueueProducerProvider.getTbVersionControlMsgProducer();
    assertTrue(tbVersionControlMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<ToTransportMsg>> transportNotificationsMsgProducer =
        tbCoreQueueProducerProvider.getTransportNotificationsMsgProducer();
    assertTrue(transportNotificationsMsgProducer instanceof InMemoryTbQueueProducer);
    assertEquals(housekeeperMsgProducer, ruleEngineMsgProducer);
    assertEquals(housekeeperMsgProducer, ruleEngineNotificationsMsgProducer);
    assertEquals(housekeeperMsgProducer, tbCoreMsgProducer);
    assertEquals(housekeeperMsgProducer, tbEdgeMsgProducer);
    assertEquals(housekeeperMsgProducer, tbUsageStatsMsgProducer);
    assertEquals(housekeeperMsgProducer, tbVersionControlMsgProducer);
    assertEquals(housekeeperMsgProducer, transportNotificationsMsgProducer);
    assertEquals(tbCoreNotificationsMsgProducer, tbEdgeNotificationsMsgProducer);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCoreQueueProducerProvider#getHousekeeperMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getRuleEngineMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getRuleEngineNotificationsMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getTbCoreMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getTbCoreNotificationsMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getTbEdgeMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getTbEdgeNotificationsMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getTbUsageStatsMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getTbVersionControlMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getTransportNotificationsMsgProducer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer TbCoreQueueProducerProvider.getHousekeeperMsgProducer()",
    "TbQueueProducer TbCoreQueueProducerProvider.getRuleEngineMsgProducer()",
    "TbQueueProducer TbCoreQueueProducerProvider.getRuleEngineNotificationsMsgProducer()",
    "TbQueueProducer TbCoreQueueProducerProvider.getTbCoreMsgProducer()",
    "TbQueueProducer TbCoreQueueProducerProvider.getTbCoreNotificationsMsgProducer()",
    "TbQueueProducer TbCoreQueueProducerProvider.getTbEdgeMsgProducer()",
    "TbQueueProducer TbCoreQueueProducerProvider.getTbEdgeNotificationsMsgProducer()",
    "TbQueueProducer TbCoreQueueProducerProvider.getTbUsageStatsMsgProducer()",
    "TbQueueProducer TbCoreQueueProducerProvider.getTbVersionControlMsgProducer()",
    "TbQueueProducer TbCoreQueueProducerProvider.getTransportNotificationsMsgProducer()"
  })
  void testGettersAndSetters() {
    // Arrange
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider tbCoreQueueProducerProvider =
        new TbCoreQueueProducerProvider(tbQueueProvider);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>> actualHousekeeperMsgProducer =
        tbCoreQueueProducerProvider.getHousekeeperMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<ToRuleEngineMsg>> actualRuleEngineMsgProducer =
        tbCoreQueueProducerProvider.getRuleEngineMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<ToRuleEngineNotificationMsg>>
        actualRuleEngineNotificationsMsgProducer =
            tbCoreQueueProducerProvider.getRuleEngineNotificationsMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<ToCoreMsg>> actualTbCoreMsgProducer =
        tbCoreQueueProducerProvider.getTbCoreMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<ToCoreNotificationMsg>> actualTbCoreNotificationsMsgProducer =
        tbCoreQueueProducerProvider.getTbCoreNotificationsMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<ToEdgeMsg>> actualTbEdgeMsgProducer =
        tbCoreQueueProducerProvider.getTbEdgeMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<ToEdgeNotificationMsg>> actualTbEdgeNotificationsMsgProducer =
        tbCoreQueueProducerProvider.getTbEdgeNotificationsMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<ToUsageStatsServiceMsg>> actualTbUsageStatsMsgProducer =
        tbCoreQueueProducerProvider.getTbUsageStatsMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<ToVersionControlServiceMsg>> actualTbVersionControlMsgProducer =
        tbCoreQueueProducerProvider.getTbVersionControlMsgProducer();

    // Assert
    assertNull(actualTbCoreMsgProducer);
    assertNull(actualTbCoreNotificationsMsgProducer);
    assertNull(actualTbEdgeMsgProducer);
    assertNull(actualTbEdgeNotificationsMsgProducer);
    assertNull(actualHousekeeperMsgProducer);
    assertNull(actualRuleEngineMsgProducer);
    assertNull(actualRuleEngineNotificationsMsgProducer);
    assertNull(tbCoreQueueProducerProvider.getTransportNotificationsMsgProducer());
    assertNull(actualTbUsageStatsMsgProducer);
    assertNull(actualTbVersionControlMsgProducer);
  }
}
