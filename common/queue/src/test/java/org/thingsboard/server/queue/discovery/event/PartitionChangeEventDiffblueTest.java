package org.thingsboard.server.queue.discovery.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.queue.discovery.QueueKey;

class PartitionChangeEventDiffblueTest {
  /**
   * Test {@link PartitionChangeEvent#PartitionChangeEvent(Object, ServiceType, Map)}.
   *
   * <p>Method under test: {@link PartitionChangeEvent#PartitionChangeEvent(Object, ServiceType,
   * Map)}
   */
  @Test
  @DisplayName("Test new PartitionChangeEvent(Object, ServiceType, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PartitionChangeEvent.<init>(Object, ServiceType, Map)"})
  void testNewPartitionChangeEvent() {
    // Arrange and Act
    PartitionChangeEvent actualPartitionChangeEvent =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>());

    // Assert
    assertEquals("Source", actualPartitionChangeEvent.getSource());
    assertEquals(ServiceType.TB_CORE, actualPartitionChangeEvent.getServiceType());
    assertTrue(actualPartitionChangeEvent.getPartitionsMap().isEmpty());
    assertTrue(actualPartitionChangeEvent.getCorePartitions().isEmpty());
    assertTrue(actualPartitionChangeEvent.getEdgePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getCorePartitions()}.
   *
   * <p>Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  @DisplayName("Test getCorePartitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PartitionChangeEvent.getCorePartitions()"})
  void testGetCorePartitions() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE, new Queue());
    partitionsMap.put(queueKey, new HashSet<>());
    PartitionChangeEvent partitionChangeEvent =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap);

    // Act and Assert
    assertTrue(partitionChangeEvent.getCorePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getCorePartitions()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link QueueKey#QueueKey(ServiceType)} with type is
   *       {@code TB_CORE} is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  @DisplayName(
      "Test getCorePartitions(); given HashMap() QueueKey(ServiceType) with type is 'TB_CORE' is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PartitionChangeEvent.getCorePartitions()"})
  void testGetCorePartitions_givenHashMapQueueKeyWithTypeIsTbCoreIsHashSet() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);
    partitionsMap.put(queueKey, new HashSet<>());
    PartitionChangeEvent partitionChangeEvent =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap);

    // Act and Assert
    assertTrue(partitionChangeEvent.getCorePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getCorePartitions()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link QueueKey#QueueKey(ServiceType)} with type is
   *       {@code TB_RULE_ENGINE} is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  @DisplayName(
      "Test getCorePartitions(); given HashMap() QueueKey(ServiceType) with type is 'TB_RULE_ENGINE' is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PartitionChangeEvent.getCorePartitions()"})
  void testGetCorePartitions_givenHashMapQueueKeyWithTypeIsTbRuleEngineIsHashSet() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_RULE_ENGINE);
    partitionsMap.put(queueKey, new HashSet<>());
    PartitionChangeEvent partitionChangeEvent =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap);

    // Act and Assert
    assertTrue(partitionChangeEvent.getCorePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getCorePartitions()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link QueueKey#QueueKey(ServiceType)} with type is
   *       {@code TB_RULE_ENGINE} is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  @DisplayName(
      "Test getCorePartitions(); given HashMap() QueueKey(ServiceType) with type is 'TB_RULE_ENGINE' is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PartitionChangeEvent.getCorePartitions()"})
  void testGetCorePartitions_givenHashMapQueueKeyWithTypeIsTbRuleEngineIsHashSet2() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_RULE_ENGINE);
    partitionsMap.put(queueKey, new HashSet<>());
    QueueKey queueKey2 = new QueueKey(ServiceType.TB_CORE);
    partitionsMap.put(queueKey2, new HashSet<>());
    PartitionChangeEvent partitionChangeEvent =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap);

    // Act and Assert
    assertTrue(partitionChangeEvent.getCorePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getCorePartitions()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  @DisplayName("Test getCorePartitions(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PartitionChangeEvent.getCorePartitions()"})
  void testGetCorePartitions_thenReturnEmpty() {
    // Arrange
    PartitionChangeEvent partitionChangeEvent =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>());

    // Act and Assert
    assertTrue(partitionChangeEvent.getCorePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getEdgePartitions()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link QueueKey#QueueKey(ServiceType)} with type is
   *       {@code TB_CORE} is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PartitionChangeEvent#getEdgePartitions()}
   */
  @Test
  @DisplayName(
      "Test getEdgePartitions(); given HashMap() QueueKey(ServiceType) with type is 'TB_CORE' is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PartitionChangeEvent.getEdgePartitions()"})
  void testGetEdgePartitions_givenHashMapQueueKeyWithTypeIsTbCoreIsHashSet() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);
    partitionsMap.put(queueKey, new HashSet<>());
    PartitionChangeEvent partitionChangeEvent =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap);

    // Act and Assert
    assertTrue(partitionChangeEvent.getEdgePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getEdgePartitions()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link QueueKey#QueueKey(ServiceType)} with type is
   *       {@code TB_RULE_ENGINE} is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PartitionChangeEvent#getEdgePartitions()}
   */
  @Test
  @DisplayName(
      "Test getEdgePartitions(); given HashMap() QueueKey(ServiceType) with type is 'TB_RULE_ENGINE' is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PartitionChangeEvent.getEdgePartitions()"})
  void testGetEdgePartitions_givenHashMapQueueKeyWithTypeIsTbRuleEngineIsHashSet() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_RULE_ENGINE);
    partitionsMap.put(queueKey, new HashSet<>());
    PartitionChangeEvent partitionChangeEvent =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap);

    // Act and Assert
    assertTrue(partitionChangeEvent.getEdgePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getEdgePartitions()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link QueueKey#QueueKey(ServiceType)} with type is
   *       {@code TB_RULE_ENGINE} is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PartitionChangeEvent#getEdgePartitions()}
   */
  @Test
  @DisplayName(
      "Test getEdgePartitions(); given HashMap() QueueKey(ServiceType) with type is 'TB_RULE_ENGINE' is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PartitionChangeEvent.getEdgePartitions()"})
  void testGetEdgePartitions_givenHashMapQueueKeyWithTypeIsTbRuleEngineIsHashSet2() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_RULE_ENGINE);
    partitionsMap.put(queueKey, new HashSet<>());
    QueueKey queueKey2 = new QueueKey(ServiceType.TB_CORE);
    partitionsMap.put(queueKey2, new HashSet<>());
    PartitionChangeEvent partitionChangeEvent =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap);

    // Act and Assert
    assertTrue(partitionChangeEvent.getEdgePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getEdgePartitions()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PartitionChangeEvent#getEdgePartitions()}
   */
  @Test
  @DisplayName("Test getEdgePartitions(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PartitionChangeEvent.getEdgePartitions()"})
  void testGetEdgePartitions_thenReturnEmpty() {
    // Arrange
    PartitionChangeEvent partitionChangeEvent =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>());

    // Act and Assert
    assertTrue(partitionChangeEvent.getEdgePartitions().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PartitionChangeEvent#toString()}
   *   <li>{@link PartitionChangeEvent#getPartitionsMap()}
   *   <li>{@link PartitionChangeEvent#getServiceType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map PartitionChangeEvent.getPartitionsMap()",
    "ServiceType PartitionChangeEvent.getServiceType()",
    "java.lang.String PartitionChangeEvent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    PartitionChangeEvent partitionChangeEvent =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap);

    // Act
    partitionChangeEvent.toString();
    Map<QueueKey, Set<TopicPartitionInfo>> actualPartitionsMap =
        partitionChangeEvent.getPartitionsMap();

    // Assert
    assertEquals(ServiceType.TB_CORE, partitionChangeEvent.getServiceType());
    assertTrue(actualPartitionsMap.isEmpty());
    assertSame(partitionsMap, actualPartitionsMap);
  }
}
