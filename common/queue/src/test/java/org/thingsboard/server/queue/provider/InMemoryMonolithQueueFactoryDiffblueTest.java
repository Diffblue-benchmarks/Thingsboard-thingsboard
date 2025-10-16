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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo.TopicPartitionInfoBuilder;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ToEdgeMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToEdgeNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToHousekeeperServiceMsg;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.TbQueueProducer;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.InMemoryTbQueueConsumer;
import org.thingsboard.server.queue.memory.InMemoryTbQueueProducer;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;

@ExtendWith(MockitoExtension.class)
class InMemoryMonolithQueueFactoryDiffblueTest {
  @InjectMocks private InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;

  @Mock private TbQueueCoreSettings tbQueueCoreSettings;

  @Mock private TbQueueEdgeSettings tbQueueEdgeSettings;

  @Mock private TbServiceInfoProvider tbServiceInfoProvider;

  @Mock private TopicService topicService;

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueProducer InMemoryMonolithQueueFactory.createHousekeeperMsgProducer()"})
  void testCreateHousekeeperMsgProducer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueCoreSettings.getHousekeeperTopic()).thenReturn("Housekeeper Topic");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>
        actualCreateHousekeeperMsgProducerResult =
            inMemoryMonolithQueueFactory.createHousekeeperMsgProducer();

    // Assert
    verify(topicService).buildTopicName("Housekeeper Topic");
    verify(tbQueueCoreSettings).getHousekeeperTopic();
    assertTrue(actualCreateHousekeeperMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateHousekeeperMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperMsgConsumer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createHousekeeperMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueConsumer InMemoryMonolithQueueFactory.createHousekeeperMsgConsumer()"})
  void testCreateHousekeeperMsgConsumer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueCoreSettings.getHousekeeperTopic()).thenReturn("Housekeeper Topic");

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>
        actualCreateHousekeeperMsgConsumerResult =
            inMemoryMonolithQueueFactory.createHousekeeperMsgConsumer();

    // Assert
    verify(topicService).buildTopicName("Housekeeper Topic");
    verify(tbQueueCoreSettings).getHousekeeperTopic();
    assertTrue(actualCreateHousekeeperMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateHousekeeperMsgConsumerResult.getTopic());
    assertFalse(actualCreateHousekeeperMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createHousekeeperReprocessingMsgProducer()"
  })
  void testCreateHousekeeperReprocessingMsgProducer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueCoreSettings.getHousekeeperReprocessingTopic())
        .thenReturn("Housekeeper Reprocessing Topic");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>
        actualCreateHousekeeperReprocessingMsgProducerResult =
            inMemoryMonolithQueueFactory.createHousekeeperReprocessingMsgProducer();

    // Assert
    verify(topicService).buildTopicName("Housekeeper Reprocessing Topic");
    verify(tbQueueCoreSettings).getHousekeeperReprocessingTopic();
    assertTrue(
        actualCreateHousekeeperReprocessingMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name", actualCreateHousekeeperReprocessingMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createHousekeeperReprocessingMsgConsumer()"
  })
  void testCreateHousekeeperReprocessingMsgConsumer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueCoreSettings.getHousekeeperReprocessingTopic())
        .thenReturn("Housekeeper Reprocessing Topic");

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>
        actualCreateHousekeeperReprocessingMsgConsumerResult =
            inMemoryMonolithQueueFactory.createHousekeeperReprocessingMsgConsumer();

    // Assert
    verify(topicService).buildTopicName("Housekeeper Reprocessing Topic");
    verify(tbQueueCoreSettings).getHousekeeperReprocessingTopic();
    assertTrue(
        actualCreateHousekeeperReprocessingMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals(
        "Build Topic Name", actualCreateHousekeeperReprocessingMsgConsumerResult.getTopic());
    assertFalse(actualCreateHousekeeperReprocessingMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createEdgeMsgConsumer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createEdgeMsgConsumer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueConsumer InMemoryMonolithQueueFactory.createEdgeMsgConsumer()"})
  void testCreateEdgeMsgConsumer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueEdgeSettings.getTopic()).thenReturn("Topic");

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToEdgeMsg>> actualCreateEdgeMsgConsumerResult =
        inMemoryMonolithQueueFactory.createEdgeMsgConsumer();

    // Assert
    verify(topicService).buildTopicName("Topic");
    verify(tbQueueEdgeSettings).getTopic();
    assertTrue(actualCreateEdgeMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateEdgeMsgConsumerResult.getTopic());
    assertFalse(actualCreateEdgeMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createEdgeMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueProducer InMemoryMonolithQueueFactory.createEdgeMsgProducer()"})
  void testCreateEdgeMsgProducer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueEdgeSettings.getTopic()).thenReturn("Topic");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToEdgeMsg>> actualCreateEdgeMsgProducerResult =
        inMemoryMonolithQueueFactory.createEdgeMsgProducer();

    // Assert
    verify(topicService).buildTopicName("Topic");
    verify(tbQueueEdgeSettings).getTopic();
    assertTrue(actualCreateEdgeMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateEdgeMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createEdgeNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createEdgeNotificationsMsgProducer()"
  })
  void testCreateEdgeNotificationsMsgProducer() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any()))
        .thenReturn(
            partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToEdgeNotificationMsg>>
        actualCreateEdgeNotificationsMsgProducerResult =
            inMemoryMonolithQueueFactory.createEdgeNotificationsMsgProducer();

    // Assert
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).getEdgeNotificationsTopic("42");
    assertTrue(actualCreateEdgeNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
  }
}
