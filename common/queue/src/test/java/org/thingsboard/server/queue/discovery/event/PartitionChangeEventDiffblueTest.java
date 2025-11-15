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
package org.thingsboard.server.queue.discovery.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import io.grpc.netty.shaded.io.netty.channel.group.DefaultChannelGroup;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.queue.discovery.QueueKey;

class PartitionChangeEventDiffblueTest {
  /**
   * Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  void testGetCorePartitions() {
    // Arrange, Act and Assert
    assertTrue(
        (new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>())).getCorePartitions().isEmpty());
  }

  /**
   * Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  void testGetCorePartitions2() {
    // Arrange
    DefaultChannelGroup defaultChannelGroup = mock(DefaultChannelGroup.class);

    // Act and Assert
    assertTrue((new PartitionChangeEvent(defaultChannelGroup, ServiceType.TB_CORE, new HashMap<>())).getCorePartitions()
        .isEmpty());
  }

  /**
   * Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  void testGetCorePartitions3() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);
    partitionsMap.put(queueKey, new HashSet<>());

    // Act and Assert
    assertTrue((new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap)).getCorePartitions().isEmpty());
  }

  /**
   * Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  void testGetCorePartitions4() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_RULE_ENGINE);
    partitionsMap.put(queueKey, new HashSet<>());

    // Act and Assert
    assertTrue((new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap)).getCorePartitions().isEmpty());
  }

  /**
   * Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  void testGetCorePartitions5() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_RULE_ENGINE);
    partitionsMap.put(queueKey, new HashSet<>());
    QueueKey queueKey2 = new QueueKey(ServiceType.TB_CORE);
    partitionsMap.put(queueKey2, new HashSet<>());

    // Act and Assert
    assertTrue((new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap)).getCorePartitions().isEmpty());
  }

  /**
   * Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  void testGetCorePartitions6() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE, new Queue());

    partitionsMap.put(queueKey, new HashSet<>());

    // Act and Assert
    assertTrue((new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap)).getCorePartitions().isEmpty());
  }

  /**
   * Method under test: {@link PartitionChangeEvent#getEdgePartitions()}
   */
  @Test
  void testGetEdgePartitions() {
    // Arrange, Act and Assert
    assertTrue(
        (new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>())).getEdgePartitions().isEmpty());
  }

  /**
   * Method under test: {@link PartitionChangeEvent#getEdgePartitions()}
   */
  @Test
  void testGetEdgePartitions2() {
    // Arrange
    DefaultChannelGroup defaultChannelGroup = mock(DefaultChannelGroup.class);

    // Act and Assert
    assertTrue((new PartitionChangeEvent(defaultChannelGroup, ServiceType.TB_CORE, new HashMap<>())).getEdgePartitions()
        .isEmpty());
  }

  /**
   * Method under test: {@link PartitionChangeEvent#getEdgePartitions()}
   */
  @Test
  void testGetEdgePartitions3() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);
    partitionsMap.put(queueKey, new HashSet<>());

    // Act and Assert
    assertTrue((new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap)).getEdgePartitions().isEmpty());
  }

  /**
   * Method under test: {@link PartitionChangeEvent#getEdgePartitions()}
   */
  @Test
  void testGetEdgePartitions4() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_RULE_ENGINE);
    partitionsMap.put(queueKey, new HashSet<>());

    // Act and Assert
    assertTrue((new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap)).getEdgePartitions().isEmpty());
  }

  /**
   * Method under test: {@link PartitionChangeEvent#getEdgePartitions()}
   */
  @Test
  void testGetEdgePartitions5() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_RULE_ENGINE);
    partitionsMap.put(queueKey, new HashSet<>());
    QueueKey queueKey2 = new QueueKey(ServiceType.TB_CORE);
    partitionsMap.put(queueKey2, new HashSet<>());

    // Act and Assert
    assertTrue((new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap)).getEdgePartitions().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PartitionChangeEvent#toString()}
   *   <li>{@link PartitionChangeEvent#getPartitionsMap()}
   *   <li>{@link PartitionChangeEvent#getServiceType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    PartitionChangeEvent partitionChangeEvent = new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap);

    // Act
    partitionChangeEvent.toString();
    Map<QueueKey, Set<TopicPartitionInfo>> actualPartitionsMap = partitionChangeEvent.getPartitionsMap();

    // Assert
    assertEquals(ServiceType.TB_CORE, partitionChangeEvent.getServiceType());
    assertTrue(actualPartitionsMap.isEmpty());
    assertSame(partitionsMap, actualPartitionsMap);
  }

  /**
   * Method under test:
   * {@link PartitionChangeEvent#PartitionChangeEvent(Object, ServiceType, Map)}
   */
  @Test
  void testNewPartitionChangeEvent() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();

    // Act
    PartitionChangeEvent actualPartitionChangeEvent = new PartitionChangeEvent("Source", ServiceType.TB_CORE,
        partitionsMap);

    // Assert
    assertEquals("Source", actualPartitionChangeEvent.getSource());
    assertEquals(ServiceType.TB_CORE, actualPartitionChangeEvent.getServiceType());
    Map<QueueKey, Set<TopicPartitionInfo>> partitionsMap2 = actualPartitionChangeEvent.getPartitionsMap();
    assertTrue(partitionsMap2.isEmpty());
    assertTrue(actualPartitionChangeEvent.getCorePartitions().isEmpty());
    assertTrue(actualPartitionChangeEvent.getEdgePartitions().isEmpty());
    assertSame(partitionsMap, partitionsMap2);
  }

  /**
   * Method under test:
   * {@link PartitionChangeEvent#PartitionChangeEvent(Object, ServiceType, Map)}
   */
  @Test
  void testNewPartitionChangeEvent2() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    partitionsMap.computeIfPresent(new QueueKey(ServiceType.TB_CORE), mock(BiFunction.class));

    // Act
    PartitionChangeEvent actualPartitionChangeEvent = new PartitionChangeEvent("Source", ServiceType.TB_CORE,
        partitionsMap);

    // Assert
    assertEquals("Source", actualPartitionChangeEvent.getSource());
    assertEquals(ServiceType.TB_CORE, actualPartitionChangeEvent.getServiceType());
    Map<QueueKey, Set<TopicPartitionInfo>> partitionsMap2 = actualPartitionChangeEvent.getPartitionsMap();
    assertTrue(partitionsMap2.isEmpty());
    assertTrue(actualPartitionChangeEvent.getCorePartitions().isEmpty());
    assertTrue(actualPartitionChangeEvent.getEdgePartitions().isEmpty());
    assertSame(partitionsMap, partitionsMap2);
  }
}
