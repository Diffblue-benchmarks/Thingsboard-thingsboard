/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
            partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build());
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    TopicPartitionInfoBuilder partitionResult2 =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult2.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build());
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
    assertTrue(
        tbCoreQueueProducerProvider.getTbCoreNotificationsMsgProducer()
            instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<ToEdgeMsg>> tbEdgeMsgProducer =
        tbCoreQueueProducerProvider.getTbEdgeMsgProducer();
    assertTrue(tbEdgeMsgProducer instanceof InMemoryTbQueueProducer);
    assertTrue(
        tbCoreQueueProducerProvider.getTbEdgeNotificationsMsgProducer()
            instanceof InMemoryTbQueueProducer);
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
