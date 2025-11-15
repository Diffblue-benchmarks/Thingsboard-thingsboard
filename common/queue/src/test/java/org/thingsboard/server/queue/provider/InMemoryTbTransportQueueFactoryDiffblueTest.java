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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.TbQueueProducer;
import org.thingsboard.server.queue.TbQueueRequestTemplate;
import org.thingsboard.server.queue.common.DefaultTbQueueRequestTemplate;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryTbQueueConsumer;
import org.thingsboard.server.queue.memory.InMemoryTbQueueProducer;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;

class InMemoryTbTransportQueueFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createTransportApiRequestTemplate()}
   */
  @Test
  void testCreateTransportApiRequestTemplate() {
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
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  void testCreateRuleEngineMsgProducer() {
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
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  void testCreateTbCoreMsgProducer() {
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
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  void testCreateTbCoreNotificationsMsgProducer() {
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
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createTransportNotificationsConsumer()}
   */
  @Test
  void testCreateTransportNotificationsConsumer() {
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
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  void testCreateToUsageStatsServiceMsgProducer() {
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
   * Method under test:
   * {@link InMemoryTbTransportQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  void testCreateHousekeeperMsgProducer() {
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
