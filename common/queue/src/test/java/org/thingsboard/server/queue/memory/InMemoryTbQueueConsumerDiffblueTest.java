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
package org.thingsboard.server.queue.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo.TopicPartitionInfoBuilder;
import org.thingsboard.server.queue.TbQueueMsg;

class InMemoryTbQueueConsumerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InMemoryTbQueueConsumer#InMemoryTbQueueConsumer(InMemoryStorage, String)}
   *   <li>{@link InMemoryTbQueueConsumer#commit()}
   *   <li>{@link InMemoryTbQueueConsumer#stop()}
   *   <li>{@link InMemoryTbQueueConsumer#getTopic()}
   *   <li>{@link InMemoryTbQueueConsumer#isStopped()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InMemoryTbQueueConsumer.<init>(InMemoryStorage, String)",
    "void InMemoryTbQueueConsumer.commit()",
    "String InMemoryTbQueueConsumer.getTopic()",
    "boolean InMemoryTbQueueConsumer.isStopped()",
    "void InMemoryTbQueueConsumer.stop()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    InMemoryTbQueueConsumer<TbQueueMsg> actualInMemoryTbQueueConsumer =
        new InMemoryTbQueueConsumer<>(new DefaultInMemoryStorage(), "Topic");
    actualInMemoryTbQueueConsumer.commit();
    actualInMemoryTbQueueConsumer.stop();
    String actualTopic = actualInMemoryTbQueueConsumer.getTopic();

    // Assert
    assertEquals("Topic", actualTopic);
    assertTrue(actualInMemoryTbQueueConsumer.isStopped());
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#subscribe()}.
   *
   * <p>Method under test: {@link InMemoryTbQueueConsumer#subscribe()}
   */
  @Test
  @DisplayName("Test subscribe()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InMemoryTbQueueConsumer.subscribe()"})
  void testSubscribe() {
    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer =
        new InMemoryTbQueueConsumer<>(new DefaultInMemoryStorage(), "Topic");

    // Act
    inMemoryTbQueueConsumer.subscribe();

    // Assert
    List<String> fullTopicNames = inMemoryTbQueueConsumer.getFullTopicNames();
    assertEquals(1, fullTopicNames.size());
    assertEquals("Topic", fullTopicNames.get(0));
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#subscribe(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link InMemoryTbQueueConsumer#subscribe(Set)}
   */
  @Test
  @DisplayName("Test subscribe(Set) with 'Set'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InMemoryTbQueueConsumer.subscribe(Set)"})
  void testSubscribeWithSet() {
    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer =
        new InMemoryTbQueueConsumer<>(new DefaultInMemoryStorage(), "Topic");

    // Act
    inMemoryTbQueueConsumer.subscribe(new HashSet<>());

    // Assert
    assertTrue(inMemoryTbQueueConsumer.getFullTopicNames().isEmpty());
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#subscribe(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link InMemoryTbQueueConsumer#subscribe(Set)}
   */
  @Test
  @DisplayName("Test subscribe(Set) with 'Set'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InMemoryTbQueueConsumer.subscribe(Set)"})
  void testSubscribeWithSet2() {
    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer =
        new InMemoryTbQueueConsumer<>(new DefaultInMemoryStorage(), "Topic");

    HashSet<TopicPartitionInfo> partitions = new HashSet<>();

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    partitions.add(
        partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build());

    // Act
    inMemoryTbQueueConsumer.subscribe(partitions);

    // Assert
    assertEquals(1, inMemoryTbQueueConsumer.getFullTopicNames().size());
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#subscribe(Set)} with {@code Set}.
   *
   * <p>Method under test: {@link InMemoryTbQueueConsumer#subscribe(Set)}
   */
  @Test
  @DisplayName("Test subscribe(Set) with 'Set'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InMemoryTbQueueConsumer.subscribe(Set)"})
  void testSubscribeWithSet3() {
    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer =
        new InMemoryTbQueueConsumer<>(new DefaultInMemoryStorage(), "Topic");

    HashSet<TopicPartitionInfo> partitions = new HashSet<>();

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    partitions.add(
        partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build());

    TopicPartitionInfoBuilder partitionResult2 =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    partitions.add(
        partitionResult2.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build());

    // Act
    inMemoryTbQueueConsumer.subscribe(partitions);

    // Assert
    assertEquals(2, inMemoryTbQueueConsumer.getFullTopicNames().size());
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#unsubscribe()}.
   *
   * <p>Method under test: {@link InMemoryTbQueueConsumer#unsubscribe()}
   */
  @Test
  @DisplayName("Test unsubscribe()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InMemoryTbQueueConsumer.unsubscribe()"})
  void testUnsubscribe() {
    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer =
        new InMemoryTbQueueConsumer<>(new DefaultInMemoryStorage(), "Topic");

    // Act
    inMemoryTbQueueConsumer.unsubscribe();

    // Assert
    assertTrue(inMemoryTbQueueConsumer.isStopped());
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#poll(long)}.
   *
   * <p>Method under test: {@link InMemoryTbQueueConsumer#poll(long)}
   */
  @Test
  @DisplayName("Test poll(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InMemoryTbQueueConsumer.poll(long)"})
  void testPoll() {
    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer =
        new InMemoryTbQueueConsumer<>(new DefaultInMemoryStorage(), "Topic");

    // Act and Assert
    assertTrue(inMemoryTbQueueConsumer.poll(1L).isEmpty());
  }
}
