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
package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {TopicService.class})
@ExtendWith(SpringExtension.class)
class TopicServiceDiffblueTest {
  @Autowired
  private TopicService topicService;

  /**
   * Method under test:
   * {@link TopicService#getNotificationsTopic(ServiceType, String)}
   */
  @Test
  void testGetNotificationsTopic() {
    // Arrange and Act
    TopicPartitionInfo actualNotificationsTopic = topicService.getNotificationsTopic(ServiceType.TB_CORE, "42");

    // Assert
    assertEquals("tb_core.notifications.42", actualNotificationsTopic.getFullTopicName());
    assertEquals("tb_core.notifications.42", actualNotificationsTopic.getTopic());
    Optional<Integer> partition = actualNotificationsTopic.getPartition();
    assertFalse(partition.isPresent());
    assertFalse(actualNotificationsTopic.isMyPartition());
    assertSame(partition, actualNotificationsTopic.getTenantId());
  }

  /**
   * Method under test:
   * {@link TopicService#getNotificationsTopic(ServiceType, String)}
   */
  @Test
  void testGetNotificationsTopic2() {
    // Arrange and Act
    TopicPartitionInfo actualNotificationsTopic = topicService.getNotificationsTopic(ServiceType.TB_RULE_ENGINE, "42");

    // Assert
    assertEquals("tb_rule_engine.notifications.42", actualNotificationsTopic.getFullTopicName());
    assertEquals("tb_rule_engine.notifications.42", actualNotificationsTopic.getTopic());
    Optional<Integer> partition = actualNotificationsTopic.getPartition();
    assertFalse(partition.isPresent());
    assertFalse(actualNotificationsTopic.isMyPartition());
    assertSame(partition, actualNotificationsTopic.getTenantId());
  }

  /**
   * Method under test:
   * {@link TopicService#getNotificationsTopic(ServiceType, String)}
   */
  @Test
  void testGetNotificationsTopic3() {
    // Arrange and Act
    TopicPartitionInfo actualNotificationsTopic = topicService.getNotificationsTopic(ServiceType.TB_TRANSPORT, "42");

    // Assert
    assertEquals("tb_transport.notifications.42", actualNotificationsTopic.getFullTopicName());
    assertEquals("tb_transport.notifications.42", actualNotificationsTopic.getTopic());
    Optional<Integer> partition = actualNotificationsTopic.getPartition();
    assertFalse(partition.isPresent());
    assertFalse(actualNotificationsTopic.isMyPartition());
    assertSame(partition, actualNotificationsTopic.getTenantId());
  }

  /**
   * Method under test: {@link TopicService#getEdgeNotificationsTopic(String)}
   */
  @Test
  void testGetEdgeNotificationsTopic() {
    // Arrange and Act
    TopicPartitionInfo actualEdgeNotificationsTopic = topicService.getEdgeNotificationsTopic("42");

    // Assert
    assertEquals("tb_edge.notifications.42", actualEdgeNotificationsTopic.getFullTopicName());
    assertEquals("tb_edge.notifications.42", actualEdgeNotificationsTopic.getTopic());
    Optional<Integer> partition = actualEdgeNotificationsTopic.getPartition();
    assertFalse(partition.isPresent());
    assertFalse(actualEdgeNotificationsTopic.isMyPartition());
    assertSame(partition, actualEdgeNotificationsTopic.getTenantId());
  }

  /**
   * Method under test:
   * {@link TopicService#buildTopicPartitionInfo(String, TenantId, Integer, boolean)}
   */
  @Test
  void testBuildTopicPartitionInfo() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TopicPartitionInfo actualBuildTopicPartitionInfoResult = topicService.buildTopicPartitionInfo("Topic", tenantId, 1,
        true);

    // Assert
    assertEquals("Topic", actualBuildTopicPartitionInfoResult.getTopic());
    Optional<Integer> partition = actualBuildTopicPartitionInfoResult.getPartition();
    assertEquals(1, partition.get().intValue());
    assertTrue(partition.isPresent());
    Optional<TenantId> tenantId2 = actualBuildTopicPartitionInfoResult.getTenantId();
    assertTrue(tenantId2.isPresent());
    assertTrue(actualBuildTopicPartitionInfoResult.isMyPartition());
    assertSame(tenantId, tenantId2.get());
  }

  /**
   * Method under test:
   * {@link TopicService#buildTopicPartitionInfo(String, TenantId, Integer, boolean)}
   */
  @Test
  void testBuildTopicPartitionInfo2() {
    // Arrange and Act
    TopicPartitionInfo actualBuildTopicPartitionInfoResult = topicService.buildTopicPartitionInfo("Topic", null, 1,
        true);

    // Assert
    assertEquals("Topic", actualBuildTopicPartitionInfoResult.getTopic());
    assertEquals("Topic.1", actualBuildTopicPartitionInfoResult.getFullTopicName());
    Optional<Integer> partition = actualBuildTopicPartitionInfoResult.getPartition();
    assertEquals(1, partition.get().intValue());
    assertFalse(actualBuildTopicPartitionInfoResult.getTenantId().isPresent());
    assertTrue(partition.isPresent());
    assertTrue(actualBuildTopicPartitionInfoResult.isMyPartition());
  }

  /**
   * Method under test: {@link TopicService#buildTopicName(String)}
   */
  @Test
  void testBuildTopicName() {
    // Arrange, Act and Assert
    assertEquals("Topic", topicService.buildTopicName("Topic"));
  }

  /**
   * Method under test: {@link TopicService#suffix(Integer)}
   */
  @Test
  void testSuffix() {
    // Arrange, Act and Assert
    assertEquals("-1", topicService.suffix(1));
    assertEquals("", topicService.suffix(null));
  }
}
