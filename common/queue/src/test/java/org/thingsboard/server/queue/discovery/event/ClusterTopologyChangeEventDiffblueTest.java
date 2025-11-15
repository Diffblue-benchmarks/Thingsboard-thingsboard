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
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.queue.discovery.QueueKey;

class ClusterTopologyChangeEventDiffblueTest {
  /**
   * Method under test: {@link ClusterTopologyChangeEvent#getQueueKeys()}
   */
  @Test
  void testGetQueueKeys() {
    // Arrange
    HashSet<QueueKey> queueKeys = new HashSet<>();

    // Act
    Set<QueueKey> actualQueueKeys = (new ClusterTopologyChangeEvent("Source", queueKeys)).getQueueKeys();

    // Assert
    assertTrue(actualQueueKeys.isEmpty());
    assertSame(queueKeys, actualQueueKeys);
  }

  /**
   * Method under test:
   * {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object, Set)}
   */
  @Test
  void testNewClusterTopologyChangeEvent() {
    // Arrange
    HashSet<QueueKey> queueKeys = new HashSet<>();

    // Act
    ClusterTopologyChangeEvent actualClusterTopologyChangeEvent = new ClusterTopologyChangeEvent("Source", queueKeys);

    // Assert
    assertEquals("Source", actualClusterTopologyChangeEvent.getSource());
    Set<QueueKey> queueKeys2 = actualClusterTopologyChangeEvent.getQueueKeys();
    assertTrue(queueKeys2.isEmpty());
    assertSame(queueKeys, queueKeys2);
  }

  /**
   * Method under test:
   * {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object, Set)}
   */
  @Test
  void testNewClusterTopologyChangeEvent2() {
    // Arrange
    HashSet<QueueKey> queueKeys = new HashSet<>();
    queueKeys.add(new QueueKey(ServiceType.TB_CORE));

    // Act
    ClusterTopologyChangeEvent actualClusterTopologyChangeEvent = new ClusterTopologyChangeEvent("Source", queueKeys);

    // Assert
    assertEquals("Source", actualClusterTopologyChangeEvent.getSource());
    Set<QueueKey> queueKeys2 = actualClusterTopologyChangeEvent.getQueueKeys();
    assertEquals(1, queueKeys2.size());
    assertSame(queueKeys, queueKeys2);
  }

  /**
   * Method under test:
   * {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object, Set)}
   */
  @Test
  void testNewClusterTopologyChangeEvent3() {
    // Arrange
    HashSet<QueueKey> queueKeys = new HashSet<>();
    queueKeys.add(new QueueKey(ServiceType.TB_RULE_ENGINE));
    queueKeys.add(new QueueKey(ServiceType.TB_CORE));

    // Act
    ClusterTopologyChangeEvent actualClusterTopologyChangeEvent = new ClusterTopologyChangeEvent("Source", queueKeys);

    // Assert
    assertEquals("Source", actualClusterTopologyChangeEvent.getSource());
    assertSame(queueKeys, actualClusterTopologyChangeEvent.getQueueKeys());
  }
}
