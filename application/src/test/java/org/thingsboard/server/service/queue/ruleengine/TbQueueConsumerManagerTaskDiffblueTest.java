package org.thingsboard.server.service.queue.ruleengine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.data.queue.QueueConfig;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo.TopicPartitionInfoBuilder;
import org.thingsboard.server.service.queue.DefaultTbCoreConsumerService;

class TbQueueConsumerManagerTaskDiffblueTest {
  /**
   * Test {@link TbQueueConsumerManagerTask#delete(boolean)}.
   * <p>
   * Method under test: {@link TbQueueConsumerManagerTask#delete(boolean)}
   */
  @Test
  @DisplayName("Test delete(boolean)")
  void testDelete() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TbQueueConsumerManagerTask actualDeleteResult = TbQueueConsumerManagerTask.delete(true);

    // Assert
    assertNull(actualDeleteResult.getPartitions());
    assertNull(actualDeleteResult.getConfig());
    assertEquals(QueueEvent.DELETE, actualDeleteResult.getEvent());
    assertTrue(actualDeleteResult.isDrainQueue());
  }

  /**
   * Test {@link TbQueueConsumerManagerTask#configUpdate(QueueConfig)}.
   * <p>
   * Method under test:
   * {@link TbQueueConsumerManagerTask#configUpdate(QueueConfig)}
   */
  @Test
  @DisplayName("Test configUpdate(QueueConfig)")
  void testConfigUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbCoreConsumerService.CoreQueueConfig config = DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 42);

    // Act and Assert
    assertSame(config, TbQueueConsumerManagerTask.configUpdate(config).getConfig());
  }

  /**
   * Test {@link TbQueueConsumerManagerTask#configUpdate(QueueConfig)}.
   * <ul>
   *   <li>When {@link Queue}.</li>
   *   <li>Then return Partitions is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbQueueConsumerManagerTask#configUpdate(QueueConfig)}
   */
  @Test
  @DisplayName("Test configUpdate(QueueConfig); when Queue; then return Partitions is 'null'")
  void testConfigUpdate_whenQueue_thenReturnPartitionsIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Queue config = mock(Queue.class);

    // Act
    TbQueueConsumerManagerTask actualConfigUpdateResult = TbQueueConsumerManagerTask.configUpdate(config);

    // Assert
    assertNull(actualConfigUpdateResult.getPartitions());
    assertEquals(QueueEvent.CONFIG_UPDATE, actualConfigUpdateResult.getEvent());
    assertFalse(actualConfigUpdateResult.isDrainQueue());
    assertSame(config, actualConfigUpdateResult.getConfig());
  }

  /**
   * Test {@link TbQueueConsumerManagerTask#partitionChange(Set)}.
   * <p>
   * Method under test: {@link TbQueueConsumerManagerTask#partitionChange(Set)}
   */
  @Test
  @DisplayName("Test partitionChange(Set)")
  void testPartitionChange() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashSet<TopicPartitionInfo> partitions = new HashSet<>();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    partitions.add(buildResult);

    // Act
    TbQueueConsumerManagerTask actualPartitionChangeResult = TbQueueConsumerManagerTask.partitionChange(partitions);

    // Assert
    assertNull(actualPartitionChangeResult.getConfig());
    assertEquals(QueueEvent.PARTITION_CHANGE, actualPartitionChangeResult.getEvent());
    assertFalse(actualPartitionChangeResult.isDrainQueue());
    assertSame(partitions, actualPartitionChangeResult.getPartitions());
  }

  /**
   * Test {@link TbQueueConsumerManagerTask#partitionChange(Set)}.
   * <p>
   * Method under test: {@link TbQueueConsumerManagerTask#partitionChange(Set)}
   */
  @Test
  @DisplayName("Test partitionChange(Set)")
  void testPartitionChange2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashSet<TopicPartitionInfo> partitions = new HashSet<>();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    partitions.add(buildResult);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult2 = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult2 = partitionResult2.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    partitions.add(buildResult2);

    // Act
    TbQueueConsumerManagerTask actualPartitionChangeResult = TbQueueConsumerManagerTask.partitionChange(partitions);

    // Assert
    assertNull(actualPartitionChangeResult.getConfig());
    assertEquals(QueueEvent.PARTITION_CHANGE, actualPartitionChangeResult.getEvent());
    assertFalse(actualPartitionChangeResult.isDrainQueue());
    assertSame(partitions, actualPartitionChangeResult.getPartitions());
  }

  /**
   * Test {@link TbQueueConsumerManagerTask#partitionChange(Set)}.
   * <ul>
   *   <li>Then calls {@link TopicPartitionInfoBuilder#myPartition(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueConsumerManagerTask#partitionChange(Set)}
   */
  @Test
  @DisplayName("Test partitionChange(Set); then calls myPartition(boolean)")
  void testPartitionChange_thenCallsMyPartition() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder topicPartitionInfoBuilder = mock(
        TopicPartitionInfo.TopicPartitionInfoBuilder.class);
    when(topicPartitionInfoBuilder.myPartition(anyBoolean())).thenReturn(TopicPartitionInfo.builder());
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = topicPartitionInfoBuilder.myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    HashSet<TopicPartitionInfo> partitions = new HashSet<>();
    partitions.add(buildResult);

    // Act
    TbQueueConsumerManagerTask actualPartitionChangeResult = TbQueueConsumerManagerTask.partitionChange(partitions);

    // Assert
    verify(topicPartitionInfoBuilder).myPartition(eq(true));
    assertNull(actualPartitionChangeResult.getConfig());
    assertEquals(QueueEvent.PARTITION_CHANGE, actualPartitionChangeResult.getEvent());
    assertFalse(actualPartitionChangeResult.isDrainQueue());
    assertSame(partitions, actualPartitionChangeResult.getPartitions());
  }

  /**
   * Test {@link TbQueueConsumerManagerTask#partitionChange(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Partitions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueConsumerManagerTask#partitionChange(Set)}
   */
  @Test
  @DisplayName("Test partitionChange(Set); when HashSet(); then return Partitions Empty")
  void testPartitionChange_whenHashSet_thenReturnPartitionsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TbQueueConsumerManagerTask actualPartitionChangeResult = TbQueueConsumerManagerTask
        .partitionChange(new HashSet<>());

    // Assert
    assertNull(actualPartitionChangeResult.getConfig());
    assertEquals(QueueEvent.PARTITION_CHANGE, actualPartitionChangeResult.getEvent());
    assertFalse(actualPartitionChangeResult.isDrainQueue());
    assertTrue(actualPartitionChangeResult.getPartitions().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbQueueConsumerManagerTask#TbQueueConsumerManagerTask(QueueEvent, QueueConfig, Set, boolean)}
   *   <li>{@link TbQueueConsumerManagerTask#toString()}
   *   <li>{@link TbQueueConsumerManagerTask#getConfig()}
   *   <li>{@link TbQueueConsumerManagerTask#getEvent()}
   *   <li>{@link TbQueueConsumerManagerTask#getPartitions()}
   *   <li>{@link TbQueueConsumerManagerTask#isDrainQueue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    DefaultTbCoreConsumerService.CoreQueueConfig config = DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 42);
    HashSet<TopicPartitionInfo> partitions = new HashSet<>();

    // Act
    TbQueueConsumerManagerTask actualTbQueueConsumerManagerTask = new TbQueueConsumerManagerTask(
        QueueEvent.PARTITION_CHANGE, config, partitions, true);
    String actualToStringResult = actualTbQueueConsumerManagerTask.toString();
    QueueConfig actualConfig = actualTbQueueConsumerManagerTask.getConfig();
    QueueEvent actualEvent = actualTbQueueConsumerManagerTask.getEvent();
    Set<TopicPartitionInfo> actualPartitions = actualTbQueueConsumerManagerTask.getPartitions();
    boolean actualIsDrainQueueResult = actualTbQueueConsumerManagerTask.isDrainQueue();

    // Assert
    assertEquals(
        "TbQueueConsumerManagerTask(event=PARTITION_CHANGE, config=DefaultTbCoreConsumerService.CoreQueueConfig"
            + "(consumerPerPartition=true, pollInterval=42), partitions=[], drainQueue=true)",
        actualToStringResult);
    assertEquals(QueueEvent.PARTITION_CHANGE, actualEvent);
    assertTrue(actualPartitions.isEmpty());
    assertTrue(actualIsDrainQueueResult);
    assertSame(partitions, actualPartitions);
    assertSame(config, actualConfig);
  }
}
