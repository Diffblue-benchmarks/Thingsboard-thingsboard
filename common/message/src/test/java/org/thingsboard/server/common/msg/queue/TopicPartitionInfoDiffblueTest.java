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
package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class TopicPartitionInfoDiffblueTest {
  /**
   * Method under test: {@link TopicPartitionInfo#newByTopic(String)}
   */
  @Test
  void testNewByTopic() {
    // Arrange
    TopicPartitionInfo topicPartitionInfo = new TopicPartitionInfo("Topic", new TenantId(UUID.randomUUID()), 1, true);

    // Act and Assert
    assertEquals(topicPartitionInfo, topicPartitionInfo.newByTopic("Topic"));
  }

  /**
   * Method under test: {@link TopicPartitionInfo#newByTopic(String)}
   */
  @Test
  void testNewByTopic2() {
    // Arrange
    TopicPartitionInfo topicPartitionInfo = new TopicPartitionInfo("Topic", null, 1, true);

    // Act and Assert
    assertEquals(topicPartitionInfo, topicPartitionInfo.newByTopic("Topic"));
  }

  /**
   * Method under test: {@link TopicPartitionInfo#newByTopic(String)}
   */
  @Test
  void testNewByTopic3() {
    // Arrange
    TopicPartitionInfo topicPartitionInfo = new TopicPartitionInfo("Topic", new TenantId(UUID.randomUUID()), null,
        true);

    // Act and Assert
    assertEquals(topicPartitionInfo, topicPartitionInfo.newByTopic("Topic"));
  }

  /**
   * Method under test: {@link TopicPartitionInfo#getTenantId()}
   */
  @Test
  void testGetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    Optional<TenantId> actualTenantId = (new TopicPartitionInfo("Topic", tenantId, 1, true)).getTenantId();

    // Assert
    assertTrue(actualTenantId.isPresent());
    assertSame(tenantId, actualTenantId.get());
  }

  /**
   * Method under test: {@link TopicPartitionInfo#getPartition()}
   */
  @Test
  void testGetPartition() {
    // Arrange and Act
    Optional<Integer> actualPartition = (new TopicPartitionInfo("Topic", new TenantId(UUID.randomUUID()), 1, true))
        .getPartition();

    // Assert
    assertEquals(1, actualPartition.get().intValue());
    assertTrue(actualPartition.isPresent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TopicPartitionInfo#equals(Object)}
   *   <li>{@link TopicPartitionInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult2 = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult2 = partitionResult2.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder topicPartitionInfoBuilder = mock(
        TopicPartitionInfo.TopicPartitionInfoBuilder.class);
    when(topicPartitionInfoBuilder.myPartition(anyBoolean())).thenReturn(TopicPartitionInfo.builder());
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = topicPartitionInfoBuilder.myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult2 = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult2 = partitionResult2.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder topicPartitionInfoBuilder = mock(
        TopicPartitionInfo.TopicPartitionInfoBuilder.class);
    when(topicPartitionInfoBuilder.myPartition(anyBoolean())).thenReturn(TopicPartitionInfo.builder());
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = topicPartitionInfoBuilder.myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("42").build();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult2 = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult2 = partitionResult2.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TopicPartitionInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TopicPartitionInfo#toString()}
   *   <li>{@link TopicPartitionInfo#getFullTopicName()}
   *   <li>{@link TopicPartitionInfo#getTopic()}
   *   <li>{@link TopicPartitionInfo#isMyPartition()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act
    buildResult.toString();
    buildResult.getFullTopicName();
    String actualTopic = buildResult.getTopic();

    // Assert
    assertEquals("Topic", actualTopic);
    assertTrue(buildResult.isMyPartition());
  }

  /**
   * Method under test:
   * {@link TopicPartitionInfo#TopicPartitionInfo(String, TenantId, Integer, boolean)}
   */
  @Test
  void testNewTopicPartitionInfo() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TopicPartitionInfo actualTopicPartitionInfo = new TopicPartitionInfo("Topic", tenantId, 1, true);

    // Assert
    assertEquals("Topic", actualTopicPartitionInfo.getTopic());
    Optional<Integer> partition = actualTopicPartitionInfo.getPartition();
    assertEquals(1, partition.get().intValue());
    assertTrue(partition.isPresent());
    Optional<TenantId> tenantId2 = actualTopicPartitionInfo.getTenantId();
    assertTrue(tenantId2.isPresent());
    assertTrue(actualTopicPartitionInfo.isMyPartition());
    assertSame(tenantId, tenantId2.get());
  }

  /**
   * Method under test:
   * {@link TopicPartitionInfo#TopicPartitionInfo(String, TenantId, Integer, boolean)}
   */
  @Test
  void testNewTopicPartitionInfo2() {
    // Arrange and Act
    TopicPartitionInfo actualTopicPartitionInfo = new TopicPartitionInfo("Topic", null, null, true);

    // Assert
    assertEquals("Topic", actualTopicPartitionInfo.getFullTopicName());
    assertEquals("Topic", actualTopicPartitionInfo.getTopic());
    Optional<Integer> partition = actualTopicPartitionInfo.getPartition();
    assertFalse(partition.isPresent());
    assertTrue(actualTopicPartitionInfo.isMyPartition());
    assertSame(partition, actualTopicPartitionInfo.getTenantId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TopicPartitionInfo.TopicPartitionInfoBuilder#build()}
   *   <li>{@link TopicPartitionInfo.TopicPartitionInfoBuilder#myPartition(boolean)}
   *   <li>{@link TopicPartitionInfo.TopicPartitionInfoBuilder#partition(Integer)}
   *   <li>{@link TopicPartitionInfo.TopicPartitionInfoBuilder#tenantId(TenantId)}
   *   <li>{@link TopicPartitionInfo.TopicPartitionInfoBuilder#topic(String)}
   * </ul>
   */
  @Test
  void testTopicPartitionInfoBuilderBuild() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TopicPartitionInfo actualBuildResult = partitionResult.tenantId(tenantId).topic("Topic").build();

    // Assert
    assertEquals("Topic", actualBuildResult.getTopic());
    Optional<Integer> partition = actualBuildResult.getPartition();
    assertEquals(1, partition.get().intValue());
    assertTrue(partition.isPresent());
    Optional<TenantId> tenantId2 = actualBuildResult.getTenantId();
    assertTrue(tenantId2.isPresent());
    assertTrue(actualBuildResult.isMyPartition());
    assertSame(tenantId, tenantId2.get());
  }
}
