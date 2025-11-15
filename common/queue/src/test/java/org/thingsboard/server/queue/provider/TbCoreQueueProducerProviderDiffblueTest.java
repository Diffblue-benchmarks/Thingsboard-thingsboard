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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.TbQueueProducer;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryTbQueueProducer;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;

class TbCoreQueueProducerProviderDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbCoreQueueProducerProvider#getHousekeeperMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getRuleEngineMsgProducer()}
   *   <li>
   * {@link TbCoreQueueProducerProvider#getRuleEngineNotificationsMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getTbCoreMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getTbCoreNotificationsMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getTbEdgeMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getTbEdgeNotificationsMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getTbUsageStatsMsgProducer()}
   *   <li>{@link TbCoreQueueProducerProvider#getTbVersionControlMsgProducer()}
   *   <li>
   * {@link TbCoreQueueProducerProvider#getTransportNotificationsMsgProducer()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider tbCoreQueueProducerProvider = new TbCoreQueueProducerProvider(
        new InMemoryMonolithQueueFactory(topicService, coreSettings, ruleEngineSettings, vcSettings,
            serviceInfoProvider, transportApiSettings, transportNotificationSettings, edgeSettings,
            new DefaultInMemoryStorage()));

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>> actualHousekeeperMsgProducer = tbCoreQueueProducerProvider
        .getHousekeeperMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> actualRuleEngineMsgProducer = tbCoreQueueProducerProvider
        .getRuleEngineMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineNotificationMsg>> actualRuleEngineNotificationsMsgProducer = tbCoreQueueProducerProvider
        .getRuleEngineNotificationsMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreMsg>> actualTbCoreMsgProducer = tbCoreQueueProducerProvider
        .getTbCoreMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreNotificationMsg>> actualTbCoreNotificationsMsgProducer = tbCoreQueueProducerProvider
        .getTbCoreNotificationsMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToEdgeMsg>> actualTbEdgeMsgProducer = tbCoreQueueProducerProvider
        .getTbEdgeMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToEdgeNotificationMsg>> actualTbEdgeNotificationsMsgProducer = tbCoreQueueProducerProvider
        .getTbEdgeNotificationsMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToUsageStatsServiceMsg>> actualTbUsageStatsMsgProducer = tbCoreQueueProducerProvider
        .getTbUsageStatsMsgProducer();
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToVersionControlServiceMsg>> actualTbVersionControlMsgProducer = tbCoreQueueProducerProvider
        .getTbVersionControlMsgProducer();

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

  /**
   * Method under test: {@link TbCoreQueueProducerProvider#init()}
   */
  @Test
  void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any())).thenReturn(buildResult);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult2 = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult2 = partitionResult2.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(buildResult2);
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    TbCoreQueueProducerProvider tbCoreQueueProducerProvider = new TbCoreQueueProducerProvider(
        new InMemoryMonolithQueueFactory(topicService, coreSettings, ruleEngineSettings, vcSettings,
            serviceInfoProvider, transportApiSettings, transportNotificationSettings, edgeSettings, storage));

    // Act
    tbCoreQueueProducerProvider.init();

    // Assert
    verify(topicService, atLeast(1)).buildTopicName(isNull());
    verify(topicService).getEdgeNotificationsTopic(isNull());
    verify(topicService).getNotificationsTopic(eq(ServiceType.TB_CORE), isNull());
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>> housekeeperMsgProducer = tbCoreQueueProducerProvider
        .getHousekeeperMsgProducer();
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>>) housekeeperMsgProducer)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(housekeeperMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> ruleEngineMsgProducer = tbCoreQueueProducerProvider
        .getRuleEngineMsgProducer();
    assertTrue(ruleEngineMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineNotificationMsg>> ruleEngineNotificationsMsgProducer = tbCoreQueueProducerProvider
        .getRuleEngineNotificationsMsgProducer();
    assertTrue(ruleEngineNotificationsMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreMsg>> tbCoreMsgProducer = tbCoreQueueProducerProvider
        .getTbCoreMsgProducer();
    assertTrue(tbCoreMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreNotificationMsg>> tbCoreNotificationsMsgProducer = tbCoreQueueProducerProvider
        .getTbCoreNotificationsMsgProducer();
    assertTrue(tbCoreNotificationsMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToEdgeMsg>> tbEdgeMsgProducer = tbCoreQueueProducerProvider
        .getTbEdgeMsgProducer();
    assertTrue(tbEdgeMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToEdgeNotificationMsg>> tbEdgeNotificationsMsgProducer = tbCoreQueueProducerProvider
        .getTbEdgeNotificationsMsgProducer();
    assertTrue(tbEdgeNotificationsMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToUsageStatsServiceMsg>> tbUsageStatsMsgProducer = tbCoreQueueProducerProvider
        .getTbUsageStatsMsgProducer();
    assertTrue(tbUsageStatsMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToVersionControlServiceMsg>> tbVersionControlMsgProducer = tbCoreQueueProducerProvider
        .getTbVersionControlMsgProducer();
    assertTrue(tbVersionControlMsgProducer instanceof InMemoryTbQueueProducer);
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToTransportMsg>> transportNotificationsMsgProducer = tbCoreQueueProducerProvider
        .getTransportNotificationsMsgProducer();
    assertTrue(transportNotificationsMsgProducer instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", housekeeperMsgProducer.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertEquals(housekeeperMsgProducer, ruleEngineMsgProducer);
    assertEquals(housekeeperMsgProducer, ruleEngineNotificationsMsgProducer);
    assertEquals(housekeeperMsgProducer, tbCoreMsgProducer);
    assertEquals(housekeeperMsgProducer, tbEdgeMsgProducer);
    assertEquals(housekeeperMsgProducer, tbUsageStatsMsgProducer);
    assertEquals(housekeeperMsgProducer, tbVersionControlMsgProducer);
    assertEquals(housekeeperMsgProducer, transportNotificationsMsgProducer);
    assertSame(storage, storage2);
    assertSame(storage,
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreNotificationMsg>>) tbCoreNotificationsMsgProducer)
            .getStorage());
    assertSame(storage,
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToEdgeNotificationMsg>>) tbEdgeNotificationsMsgProducer)
            .getStorage());
  }
}
