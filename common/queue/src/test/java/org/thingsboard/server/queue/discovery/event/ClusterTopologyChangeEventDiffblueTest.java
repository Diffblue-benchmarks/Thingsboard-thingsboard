package org.thingsboard.server.queue.discovery.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.discovery.QueueKey;

class ClusterTopologyChangeEventDiffblueTest {
  /**
   * Test {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return QueueKeys Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClusterTopologyChangeEvent#ClusterTopologyChangeEvent(Object, Set)}
   */
  @Test
  @DisplayName("Test new ClusterTopologyChangeEvent(Object, Set); when HashSet(); then return QueueKeys Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ClusterTopologyChangeEvent.<init>(Object, Set)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ClusterTopologyChangeEvent.getQueueKeys()"})
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
