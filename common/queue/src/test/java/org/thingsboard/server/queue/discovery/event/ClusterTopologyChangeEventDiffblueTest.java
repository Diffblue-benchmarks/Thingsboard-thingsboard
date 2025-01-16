package org.thingsboard.server.queue.discovery.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.queue.discovery.QueueKey;

class ClusterTopologyChangeEventDiffblueTest {
  /**
   * Test
   * {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object, Set)}.
   * <ul>
   *   <li>Given {@link QueueKey#QueueKey(ServiceType)} with type is
   * {@code TB_RULE_ENGINE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object, Set)}
   */
  @Test
  @DisplayName("Test new ClusterTopologyChangeEvent(Object, Set); given QueueKey(ServiceType) with type is 'TB_RULE_ENGINE'")
  void testNewClusterTopologyChangeEvent_givenQueueKeyWithTypeIsTbRuleEngine() {
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

  /**
   * Test
   * {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object, Set)}.
   * <ul>
   *   <li>Then return QueueKeys is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object, Set)}
   */
  @Test
  @DisplayName("Test new ClusterTopologyChangeEvent(Object, Set); then return QueueKeys is HashSet()")
  void testNewClusterTopologyChangeEvent_thenReturnQueueKeysIsHashSet() {
    // Arrange
    HashSet<QueueKey> queueKeys = new HashSet<>();
    queueKeys.add(new QueueKey(ServiceType.TB_CORE));

    // Act
    ClusterTopologyChangeEvent actualClusterTopologyChangeEvent = new ClusterTopologyChangeEvent("Source", queueKeys);

    // Assert
    assertEquals("Source", actualClusterTopologyChangeEvent.getSource());
    assertSame(queueKeys, actualClusterTopologyChangeEvent.getQueueKeys());
  }

  /**
   * Test
   * {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return QueueKeys Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object, Set)}
   */
  @Test
  @DisplayName("Test new ClusterTopologyChangeEvent(Object, Set); when HashSet(); then return QueueKeys Empty")
  void testNewClusterTopologyChangeEvent_whenHashSet_thenReturnQueueKeysEmpty() {
    // Arrange and Act
    ClusterTopologyChangeEvent actualClusterTopologyChangeEvent = new ClusterTopologyChangeEvent("Source",
        new HashSet<>());

    // Assert
    assertEquals("Source", actualClusterTopologyChangeEvent.getSource());
    assertTrue(actualClusterTopologyChangeEvent.getQueueKeys().isEmpty());
  }

  /**
   * Test {@link ClusterTopologyChangeEvent#getQueueKeys()}.
   * <p>
   * Method under test: {@link ClusterTopologyChangeEvent#getQueueKeys()}
   */
  @Test
  @DisplayName("Test getQueueKeys()")
  void testGetQueueKeys() {
    // Arrange
    HashSet<QueueKey> queueKeys = new HashSet<>();

    // Act
    Set<QueueKey> actualQueueKeys = (new ClusterTopologyChangeEvent("Source", queueKeys)).getQueueKeys();

    // Assert
    assertTrue(actualQueueKeys.isEmpty());
    assertSame(queueKeys, actualQueueKeys);
  }
}
