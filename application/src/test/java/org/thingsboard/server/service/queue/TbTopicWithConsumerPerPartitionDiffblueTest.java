package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;

@ContextConfiguration(classes = {TbTopicWithConsumerPerPartition.class, String.class})
@ExtendWith(SpringExtension.class)
class TbTopicWithConsumerPerPartitionDiffblueTest {
  @Autowired
  private TbTopicWithConsumerPerPartition tbTopicWithConsumerPerPartition;

  /**
   * Test {@link TbTopicWithConsumerPerPartition#equals(Object)}, and
   * {@link TbTopicWithConsumerPerPartition#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbTopicWithConsumerPerPartition#equals(Object)}
   *   <li>{@link TbTopicWithConsumerPerPartition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbTopicWithConsumerPerPartition tbTopicWithConsumerPerPartition = new TbTopicWithConsumerPerPartition("Topic");

    // Act and Assert
    assertEquals(tbTopicWithConsumerPerPartition, tbTopicWithConsumerPerPartition);
    int expectedHashCodeResult = tbTopicWithConsumerPerPartition.hashCode();
    assertEquals(expectedHashCodeResult, tbTopicWithConsumerPerPartition.hashCode());
  }

  /**
   * Test {@link TbTopicWithConsumerPerPartition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTopicWithConsumerPerPartition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbTopicWithConsumerPerPartition tbTopicWithConsumerPerPartition = new TbTopicWithConsumerPerPartition("Topic");

    // Act and Assert
    assertNotEquals(tbTopicWithConsumerPerPartition, new TbTopicWithConsumerPerPartition("Topic"));
  }

  /**
   * Test {@link TbTopicWithConsumerPerPartition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTopicWithConsumerPerPartition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbTopicWithConsumerPerPartition tbTopicWithConsumerPerPartition = new TbTopicWithConsumerPerPartition(null);

    // Act and Assert
    assertNotEquals(tbTopicWithConsumerPerPartition, new TbTopicWithConsumerPerPartition("Topic"));
  }

  /**
   * Test {@link TbTopicWithConsumerPerPartition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTopicWithConsumerPerPartition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbTopicWithConsumerPerPartition tbTopicWithConsumerPerPartition = new TbTopicWithConsumerPerPartition(
        "org.thingsboard.server.service.queue.TbTopicWithConsumerPerPartition");

    // Act and Assert
    assertNotEquals(tbTopicWithConsumerPerPartition, new TbTopicWithConsumerPerPartition("Topic"));
  }

  /**
   * Test {@link TbTopicWithConsumerPerPartition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTopicWithConsumerPerPartition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbTopicWithConsumerPerPartition tbTopicWithConsumerPerPartition = new TbTopicWithConsumerPerPartition(null);

    // Act and Assert
    assertNotEquals(tbTopicWithConsumerPerPartition, new TbTopicWithConsumerPerPartition(null));
  }

  /**
   * Test {@link TbTopicWithConsumerPerPartition#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTopicWithConsumerPerPartition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbTopicWithConsumerPerPartition("Topic"), null);
  }

  /**
   * Test {@link TbTopicWithConsumerPerPartition#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTopicWithConsumerPerPartition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbTopicWithConsumerPerPartition("Topic"), "Different type to TbTopicWithConsumerPerPartition");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbTopicWithConsumerPerPartition#setPartitions(Set)}
   *   <li>{@link TbTopicWithConsumerPerPartition#toString()}
   *   <li>{@link TbTopicWithConsumerPerPartition#getConsumers()}
   *   <li>{@link TbTopicWithConsumerPerPartition#getLock()}
   *   <li>{@link TbTopicWithConsumerPerPartition#getPartitions()}
   *   <li>{@link TbTopicWithConsumerPerPartition#getSubscribeQueue()}
   *   <li>{@link TbTopicWithConsumerPerPartition#getTopic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbTopicWithConsumerPerPartition tbTopicWithConsumerPerPartition = new TbTopicWithConsumerPerPartition("Topic");
    HashSet<TopicPartitionInfo> partitions = new HashSet<>();

    // Act
    tbTopicWithConsumerPerPartition.setPartitions(partitions);
    tbTopicWithConsumerPerPartition.toString();
    ConcurrentMap<TopicPartitionInfo, TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>>> actualConsumers = tbTopicWithConsumerPerPartition
        .getConsumers();
    ReentrantLock actualLock = tbTopicWithConsumerPerPartition.getLock();
    Set<TopicPartitionInfo> actualPartitions = tbTopicWithConsumerPerPartition.getPartitions();
    Queue<Set<TopicPartitionInfo>> actualSubscribeQueue = tbTopicWithConsumerPerPartition.getSubscribeQueue();

    // Assert that nothing has changed
    assertEquals("Topic", tbTopicWithConsumerPerPartition.getTopic());
    assertEquals(0, actualLock.getHoldCount());
    assertEquals(0, actualLock.getQueueLength());
    assertFalse(actualLock.hasQueuedThreads());
    assertFalse(actualLock.isFair());
    assertFalse(actualLock.isHeldByCurrentThread());
    assertFalse(actualLock.isLocked());
    assertTrue(actualSubscribeQueue.isEmpty());
    assertTrue(actualConsumers.isEmpty());
    assertTrue(actualPartitions.isEmpty());
    assertSame(partitions, actualPartitions);
  }

  /**
   * Test
   * {@link TbTopicWithConsumerPerPartition#TbTopicWithConsumerPerPartition(String)}.
   * <p>
   * Method under test:
   * {@link TbTopicWithConsumerPerPartition#TbTopicWithConsumerPerPartition(String)}
   */
  @Test
  @DisplayName("Test new TbTopicWithConsumerPerPartition(String)")
  void testNewTbTopicWithConsumerPerPartition() {
    // Arrange and Act
    TbTopicWithConsumerPerPartition actualTbTopicWithConsumerPerPartition = new TbTopicWithConsumerPerPartition(
        "Topic");

    // Assert
    assertEquals("Topic", actualTbTopicWithConsumerPerPartition.getTopic());
    ReentrantLock lock = actualTbTopicWithConsumerPerPartition.getLock();
    assertEquals(0, lock.getHoldCount());
    assertEquals(0, lock.getQueueLength());
    assertFalse(lock.hasQueuedThreads());
    assertFalse(lock.isFair());
    assertFalse(lock.isHeldByCurrentThread());
    assertFalse(lock.isLocked());
    assertTrue(actualTbTopicWithConsumerPerPartition.getSubscribeQueue().isEmpty());
    assertTrue(actualTbTopicWithConsumerPerPartition.getConsumers().isEmpty());
    assertTrue(actualTbTopicWithConsumerPerPartition.getPartitions().isEmpty());
  }
}
