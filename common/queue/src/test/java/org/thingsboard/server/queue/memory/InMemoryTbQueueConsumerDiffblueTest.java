package org.thingsboard.server.queue.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.queue.TbQueueMsg;

class InMemoryTbQueueConsumerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link InMemoryTbQueueConsumer#InMemoryTbQueueConsumer(InMemoryStorage, String)}
   *   <li>{@link InMemoryTbQueueConsumer#commit()}
   *   <li>{@link InMemoryTbQueueConsumer#stop()}
   *   <li>{@link InMemoryTbQueueConsumer#getTopic()}
   *   <li>{@link InMemoryTbQueueConsumer#isStopped()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    InMemoryTbQueueConsumer<TbQueueMsg> actualInMemoryTbQueueConsumer = new InMemoryTbQueueConsumer<>(
        new DefaultInMemoryStorage(), "Topic");
    actualInMemoryTbQueueConsumer.commit();
    actualInMemoryTbQueueConsumer.stop();
    String actualTopic = actualInMemoryTbQueueConsumer.getTopic();

    // Assert that nothing has changed
    assertEquals("Topic", actualTopic);
    assertTrue(actualInMemoryTbQueueConsumer.isStopped());
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#subscribe()}.
   * <p>
   * Method under test: {@link InMemoryTbQueueConsumer#subscribe()}
   */
  @Test
  @DisplayName("Test subscribe()")
  void testSubscribe() {
    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer = new InMemoryTbQueueConsumer<>(
        new DefaultInMemoryStorage(), "Topic");

    // Act
    inMemoryTbQueueConsumer.subscribe();

    // Assert
    List<String> fullTopicNames = inMemoryTbQueueConsumer.getFullTopicNames();
    assertEquals(1, fullTopicNames.size());
    assertEquals("Topic", fullTopicNames.get(0));
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#subscribe(Set)} with {@code Set}.
   * <p>
   * Method under test: {@link InMemoryTbQueueConsumer#subscribe(Set)}
   */
  @Test
  @DisplayName("Test subscribe(Set) with 'Set'")
  void testSubscribeWithSet() {
    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer = new InMemoryTbQueueConsumer<>(
        new DefaultInMemoryStorage(), "Topic");

    // Act
    inMemoryTbQueueConsumer.subscribe(new HashSet<>());

    // Assert
    assertTrue(inMemoryTbQueueConsumer.getFullTopicNames().isEmpty());
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#subscribe(Set)} with {@code Set}.
   * <p>
   * Method under test: {@link InMemoryTbQueueConsumer#subscribe(Set)}
   */
  @Test
  @DisplayName("Test subscribe(Set) with 'Set'")
  void testSubscribeWithSet2() {
    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer = new InMemoryTbQueueConsumer<>(
        new DefaultInMemoryStorage(), "Topic");

    HashSet<TopicPartitionInfo> partitions = new HashSet<>();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .topic("Topic")
        .build();
    partitions.add(buildResult);

    // Act
    inMemoryTbQueueConsumer.subscribe(partitions);

    // Assert
    List<String> fullTopicNames = inMemoryTbQueueConsumer.getFullTopicNames();
    assertEquals(1, fullTopicNames.size());
    assertEquals("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1", fullTopicNames.get(0));
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#subscribe(Set)} with {@code Set}.
   * <p>
   * Method under test: {@link InMemoryTbQueueConsumer#subscribe(Set)}
   */
  @Test
  @DisplayName("Test subscribe(Set) with 'Set'")
  void testSubscribeWithSet3() {
    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer = new InMemoryTbQueueConsumer<>(
        new DefaultInMemoryStorage(), "Topic");

    HashSet<TopicPartitionInfo> partitions = new HashSet<>();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(-1);
    TopicPartitionInfo buildResult = partitionResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .topic("Topic")
        .build();
    partitions.add(buildResult);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult2 = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult2 = partitionResult2
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .topic("Topic")
        .build();
    partitions.add(buildResult2);

    // Act
    inMemoryTbQueueConsumer.subscribe(partitions);

    // Assert
    List<String> fullTopicNames = inMemoryTbQueueConsumer.getFullTopicNames();
    assertEquals(2, fullTopicNames.size());
    assertEquals("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.-1", fullTopicNames.get(0));
    assertEquals("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1", fullTopicNames.get(1));
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#unsubscribe()}.
   * <p>
   * Method under test: {@link InMemoryTbQueueConsumer#unsubscribe()}
   */
  @Test
  @DisplayName("Test unsubscribe()")
  void testUnsubscribe() {
    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer = new InMemoryTbQueueConsumer<>(
        new DefaultInMemoryStorage(), "Topic");

    // Act
    inMemoryTbQueueConsumer.unsubscribe();

    // Assert
    assertTrue(inMemoryTbQueueConsumer.isStopped());
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#poll(long)}.
   * <p>
   * Method under test: {@link InMemoryTbQueueConsumer#poll(long)}
   */
  @Test
  @DisplayName("Test poll(long)")
  void testPoll() {
    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer = new InMemoryTbQueueConsumer<>(
        new DefaultInMemoryStorage(), "Topic");

    // Act and Assert
    assertTrue(inMemoryTbQueueConsumer.poll(1L).isEmpty());
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#getFullTopicNames()}.
   * <p>
   * Method under test: {@link InMemoryTbQueueConsumer#getFullTopicNames()}
   */
  @Test
  @DisplayName("Test getFullTopicNames()")
  @Disabled("TODO: Complete this test")
  void testGetFullTopicNames() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException: Cannot invoke "java.util.Collection.stream()" because "that" is null
    //       at org.thingsboard.server.queue.memory.InMemoryTbQueueConsumer.getFullTopicNames(InMemoryTbQueueConsumer.java:114)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer = new InMemoryTbQueueConsumer<>(
        new DefaultInMemoryStorage(), "Topic");

    // Act
    inMemoryTbQueueConsumer.getFullTopicNames();
  }
}
