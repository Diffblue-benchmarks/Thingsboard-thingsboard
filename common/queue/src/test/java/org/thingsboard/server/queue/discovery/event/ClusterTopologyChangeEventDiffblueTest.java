package org.thingsboard.server.queue.discovery.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.queue.discovery.QueueKey;

class ClusterTopologyChangeEventDiffblueTest {
  /**
   * Test {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object, Set)}.
   *
   * <ul>
   *   <li>Given {@link QueueKey#QueueKey(ServiceType)} with type is {@code TB_RULE_ENGINE}.
   * </ul>
   *
   * <p>Method under test: {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new ClusterTopologyChangeEvent(Object, Set); given QueueKey(ServiceType) with type is 'TB_RULE_ENGINE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClusterTopologyChangeEvent.<init>(Object, Set)"})
  void testNewClusterTopologyChangeEvent_givenQueueKeyWithTypeIsTbRuleEngine() {
    // Arrange
    HashSet<QueueKey> queueKeys = new HashSet<>();
    queueKeys.add(new QueueKey(ServiceType.TB_RULE_ENGINE));
    queueKeys.add(new QueueKey(ServiceType.TB_CORE));

    // Act
    ClusterTopologyChangeEvent actualClusterTopologyChangeEvent =
        new ClusterTopologyChangeEvent("Source", queueKeys);

    // Assert
    assertEquals("Source", actualClusterTopologyChangeEvent.getSource());
    assertSame(queueKeys, actualClusterTopologyChangeEvent.getQueueKeys());
  }

  /**
   * Test {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object, Set)}.
   *
   * <ul>
   *   <li>Then return QueueKeys is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new ClusterTopologyChangeEvent(Object, Set); then return QueueKeys is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClusterTopologyChangeEvent.<init>(Object, Set)"})
  void testNewClusterTopologyChangeEvent_thenReturnQueueKeysIsHashSet() {
    // Arrange
    HashSet<QueueKey> queueKeys = new HashSet<>();
    queueKeys.add(new QueueKey(ServiceType.TB_CORE));

    // Act
    ClusterTopologyChangeEvent actualClusterTopologyChangeEvent =
        new ClusterTopologyChangeEvent("Source", queueKeys);

    // Assert
    assertEquals("Source", actualClusterTopologyChangeEvent.getSource());
    assertSame(queueKeys, actualClusterTopologyChangeEvent.getQueueKeys());
  }

  /**
   * Test {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return QueueKeys Empty.
   * </ul>
   *
   * <p>Method under test: {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test new ClusterTopologyChangeEvent(Object, Set); when HashSet(); then return QueueKeys Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClusterTopologyChangeEvent.<init>(Object, Set)"})
  void testNewClusterTopologyChangeEvent_whenHashSet_thenReturnQueueKeysEmpty() {
    // Arrange and Act
    ClusterTopologyChangeEvent actualClusterTopologyChangeEvent =
        new ClusterTopologyChangeEvent("Source", new HashSet<>());

    // Assert
    assertEquals("Source", actualClusterTopologyChangeEvent.getSource());
    assertTrue(actualClusterTopologyChangeEvent.getQueueKeys().isEmpty());
  }

  /**
   * Test {@link ClusterTopologyChangeEvent#getQueueKeys()}.
   *
   * <p>Method under test: {@link ClusterTopologyChangeEvent#getQueueKeys()}
   */
  @Test
  @DisplayName("Test getQueueKeys()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ClusterTopologyChangeEvent.getQueueKeys()"})
  void testGetQueueKeys() {
    // Arrange
    HashSet<QueueKey> queueKeys = new HashSet<>();
    ClusterTopologyChangeEvent clusterTopologyChangeEvent =
        new ClusterTopologyChangeEvent("Source", queueKeys);

    // Act
    Set<QueueKey> actualQueueKeys = clusterTopologyChangeEvent.getQueueKeys();

    // Assert
    assertTrue(actualQueueKeys.isEmpty());
    assertSame(queueKeys, actualQueueKeys);
  }
}
