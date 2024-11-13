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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.queue.discovery.QueueKey;

class PartitionChangeEventDiffblueTest {
  /**
   * Test
   * {@link PartitionChangeEvent#PartitionChangeEvent(Object, ServiceType, Map)}.
   * <ul>
   *   <li>Given {@link QueueKey#QueueKey(ServiceType)} with type is
   * {@code TB_CORE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PartitionChangeEvent#PartitionChangeEvent(Object, ServiceType, Map)}
   */
  @Test
  @DisplayName("Test new PartitionChangeEvent(Object, ServiceType, Map); given QueueKey(ServiceType) with type is 'TB_CORE'")
  void testNewPartitionChangeEvent_givenQueueKeyWithTypeIsTbCore() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    partitionsMap.computeIfPresent(new QueueKey(ServiceType.TB_CORE), mock(BiFunction.class));

    // Act
    PartitionChangeEvent actualPartitionChangeEvent = new PartitionChangeEvent("Source", ServiceType.TB_CORE,
        partitionsMap);

    // Assert
    assertEquals("Source", actualPartitionChangeEvent.getSource());
    assertEquals(ServiceType.TB_CORE, actualPartitionChangeEvent.getServiceType());
    assertTrue(actualPartitionChangeEvent.getPartitionsMap().isEmpty());
    assertTrue(actualPartitionChangeEvent.getCorePartitions().isEmpty());
    assertTrue(actualPartitionChangeEvent.getEdgePartitions().isEmpty());
  }

  /**
   * Test
   * {@link PartitionChangeEvent#PartitionChangeEvent(Object, ServiceType, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PartitionChangeEvent#PartitionChangeEvent(Object, ServiceType, Map)}
   */
  @Test
  @DisplayName("Test new PartitionChangeEvent(Object, ServiceType, Map); when HashMap()")
  void testNewPartitionChangeEvent_whenHashMap() {
    // Arrange and Act
    PartitionChangeEvent actualPartitionChangeEvent = new PartitionChangeEvent("Source", ServiceType.TB_CORE,
        new HashMap<>());

    // Assert
    assertEquals("Source", actualPartitionChangeEvent.getSource());
    assertEquals(ServiceType.TB_CORE, actualPartitionChangeEvent.getServiceType());
    assertTrue(actualPartitionChangeEvent.getPartitionsMap().isEmpty());
    assertTrue(actualPartitionChangeEvent.getCorePartitions().isEmpty());
    assertTrue(actualPartitionChangeEvent.getEdgePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getCorePartitions()}.
   * <p>
   * Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  @DisplayName("Test getCorePartitions()")
  void testGetCorePartitions() {
    // Arrange
    DefaultChannelGroup defaultChannelGroup = mock(DefaultChannelGroup.class);

    // Act and Assert
    assertTrue((new PartitionChangeEvent(defaultChannelGroup, ServiceType.TB_CORE, new HashMap<>())).getCorePartitions()
        .isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getCorePartitions()}.
   * <p>
   * Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  @DisplayName("Test getCorePartitions()")
  void testGetCorePartitions2() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE, new Queue());

    partitionsMap.put(queueKey, new HashSet<>());

    // Act and Assert
    assertTrue((new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap)).getCorePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getCorePartitions()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link QueueKey#QueueKey(ServiceType)}
   * with type is {@code TB_CORE} is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  @DisplayName("Test getCorePartitions(); given HashMap() QueueKey(ServiceType) with type is 'TB_CORE' is HashSet()")
  void testGetCorePartitions_givenHashMapQueueKeyWithTypeIsTbCoreIsHashSet() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);
    partitionsMap.put(queueKey, new HashSet<>());

    // Act and Assert
    assertTrue((new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap)).getCorePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getCorePartitions()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link QueueKey#QueueKey(ServiceType)}
   * with type is {@code TB_RULE_ENGINE} is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  @DisplayName("Test getCorePartitions(); given HashMap() QueueKey(ServiceType) with type is 'TB_RULE_ENGINE' is HashSet()")
  void testGetCorePartitions_givenHashMapQueueKeyWithTypeIsTbRuleEngineIsHashSet() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_RULE_ENGINE);
    partitionsMap.put(queueKey, new HashSet<>());

    // Act and Assert
    assertTrue((new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap)).getCorePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getCorePartitions()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link QueueKey#QueueKey(ServiceType)}
   * with type is {@code TB_RULE_ENGINE} is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  @DisplayName("Test getCorePartitions(); given HashMap() QueueKey(ServiceType) with type is 'TB_RULE_ENGINE' is HashSet()")
  void testGetCorePartitions_givenHashMapQueueKeyWithTypeIsTbRuleEngineIsHashSet2() {
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
   * Test {@link PartitionChangeEvent#getCorePartitions()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartitionChangeEvent#getCorePartitions()}
   */
  @Test
  @DisplayName("Test getCorePartitions(); then return Empty")
  void testGetCorePartitions_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        (new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>())).getCorePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getEdgePartitions()}.
   * <p>
   * Method under test: {@link PartitionChangeEvent#getEdgePartitions()}
   */
  @Test
  @DisplayName("Test getEdgePartitions()")
  void testGetEdgePartitions() {
    // Arrange
    DefaultChannelGroup defaultChannelGroup = mock(DefaultChannelGroup.class);

    // Act and Assert
    assertTrue((new PartitionChangeEvent(defaultChannelGroup, ServiceType.TB_CORE, new HashMap<>())).getEdgePartitions()
        .isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getEdgePartitions()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link QueueKey#QueueKey(ServiceType)}
   * with type is {@code TB_CORE} is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartitionChangeEvent#getEdgePartitions()}
   */
  @Test
  @DisplayName("Test getEdgePartitions(); given HashMap() QueueKey(ServiceType) with type is 'TB_CORE' is HashSet()")
  void testGetEdgePartitions_givenHashMapQueueKeyWithTypeIsTbCoreIsHashSet() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);
    partitionsMap.put(queueKey, new HashSet<>());

    // Act and Assert
    assertTrue((new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap)).getEdgePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getEdgePartitions()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link QueueKey#QueueKey(ServiceType)}
   * with type is {@code TB_RULE_ENGINE} is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartitionChangeEvent#getEdgePartitions()}
   */
  @Test
  @DisplayName("Test getEdgePartitions(); given HashMap() QueueKey(ServiceType) with type is 'TB_RULE_ENGINE' is HashSet()")
  void testGetEdgePartitions_givenHashMapQueueKeyWithTypeIsTbRuleEngineIsHashSet() {
    // Arrange
    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_RULE_ENGINE);
    partitionsMap.put(queueKey, new HashSet<>());

    // Act and Assert
    assertTrue((new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap)).getEdgePartitions().isEmpty());
  }

  /**
   * Test {@link PartitionChangeEvent#getEdgePartitions()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@link QueueKey#QueueKey(ServiceType)}
   * with type is {@code TB_RULE_ENGINE} is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartitionChangeEvent#getEdgePartitions()}
   */
  @Test
  @DisplayName("Test getEdgePartitions(); given HashMap() QueueKey(ServiceType) with type is 'TB_RULE_ENGINE' is HashSet()")
  void testGetEdgePartitions_givenHashMapQueueKeyWithTypeIsTbRuleEngineIsHashSet2() {
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
   * Test {@link PartitionChangeEvent#getEdgePartitions()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PartitionChangeEvent#getEdgePartitions()}
   */
  @Test
  @DisplayName("Test getEdgePartitions(); then return Empty")
  void testGetEdgePartitions_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        (new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>())).getEdgePartitions().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PartitionChangeEvent#toString()}
   *   <li>{@link PartitionChangeEvent#getPartitionsMap()}
   *   <li>{@link PartitionChangeEvent#getServiceType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
}
