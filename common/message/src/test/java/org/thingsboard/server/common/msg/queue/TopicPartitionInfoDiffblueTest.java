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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo.TopicPartitionInfoBuilder;

@ContextConfiguration(classes = {TopicPartitionInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class TopicPartitionInfoDiffblueTest {
  @Autowired private TopicPartitionInfoBuilder topicPartitionInfoBuilder;

  /**
   * Test {@link TopicPartitionInfo#TopicPartitionInfo(String, TenantId, Integer, boolean)}.
   *
   * <ul>
   *   <li>Then return not Partition Present.
   * </ul>
   *
   * <p>Method under test: {@link TopicPartitionInfo#TopicPartitionInfo(String, TenantId, Integer,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new TopicPartitionInfo(String, TenantId, Integer, boolean); then return not Partition Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TopicPartitionInfo.<init>(String, TenantId, Integer, boolean)"})
  void testNewTopicPartitionInfo_thenReturnNotPartitionPresent() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TopicPartitionInfo actualTopicPartitionInfo =
        new TopicPartitionInfo("Topic", tenantId, null, true);

    // Assert
    assertFalse(actualTopicPartitionInfo.getPartition().isPresent());
    Optional<TenantId> tenantId2 = actualTopicPartitionInfo.getTenantId();
    assertTrue(tenantId2.isPresent());
    assertSame(tenantId, tenantId2.get());
  }

  /**
   * Test {@link TopicPartitionInfo#TopicPartitionInfo(String, TenantId, Integer, boolean)}.
   *
   * <ul>
   *   <li>Then return Partition intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link TopicPartitionInfo#TopicPartitionInfo(String, TenantId, Integer,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new TopicPartitionInfo(String, TenantId, Integer, boolean); then return Partition intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TopicPartitionInfo.<init>(String, TenantId, Integer, boolean)"})
  void testNewTopicPartitionInfo_thenReturnPartitionIntValueIsOne() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TopicPartitionInfo actualTopicPartitionInfo =
        new TopicPartitionInfo("Topic", tenantId, 1, true);

    // Assert
    Optional<Integer> partition = actualTopicPartitionInfo.getPartition();
    assertEquals(1, partition.get().intValue());
    assertTrue(partition.isPresent());
    Optional<TenantId> tenantId2 = actualTopicPartitionInfo.getTenantId();
    assertTrue(tenantId2.isPresent());
    assertSame(tenantId, tenantId2.get());
  }

  /**
   * Test {@link TopicPartitionInfo#TopicPartitionInfo(String, TenantId, Integer, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return FullTopicName is {@code Topic.1}.
   * </ul>
   *
   * <p>Method under test: {@link TopicPartitionInfo#TopicPartitionInfo(String, TenantId, Integer,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test new TopicPartitionInfo(String, TenantId, Integer, boolean); when 'null'; then return FullTopicName is 'Topic.1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TopicPartitionInfo.<init>(String, TenantId, Integer, boolean)"})
  void testNewTopicPartitionInfo_whenNull_thenReturnFullTopicNameIsTopic1() {
    // Arrange and Act
    TopicPartitionInfo actualTopicPartitionInfo = new TopicPartitionInfo("Topic", null, 1, true);

    // Assert
    assertEquals("Topic.1", actualTopicPartitionInfo.getFullTopicName());
    Optional<Integer> partition = actualTopicPartitionInfo.getPartition();
    assertEquals(1, partition.get().intValue());
    assertFalse(actualTopicPartitionInfo.getTenantId().isPresent());
    assertTrue(partition.isPresent());
  }

  /**
   * Test {@link TopicPartitionInfo#newByTopic(String)}.
   *
   * <p>Method under test: {@link TopicPartitionInfo#newByTopic(String)}
   */
  @Test
  @DisplayName("Test newByTopic(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TopicPartitionInfo TopicPartitionInfo.newByTopic(String)"})
  void testNewByTopic() {
    // Arrange
    TopicPartitionInfo topicPartitionInfo =
        new TopicPartitionInfo("Topic", new TenantId(UUID.randomUUID()), 1, true);

    // Act
    TopicPartitionInfo actualNewByTopicResult = topicPartitionInfo.newByTopic("Topic");

    // Assert
    assertEquals(topicPartitionInfo, actualNewByTopicResult);
  }

  /**
   * Test {@link TopicPartitionInfo#newByTopic(String)}.
   *
   * <p>Method under test: {@link TopicPartitionInfo#newByTopic(String)}
   */
  @Test
  @DisplayName("Test newByTopic(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TopicPartitionInfo TopicPartitionInfo.newByTopic(String)"})
  void testNewByTopic2() {
    // Arrange
    TopicPartitionInfo topicPartitionInfo =
        new TopicPartitionInfo("Topic", new TenantId(UUID.randomUUID()), null, true);

    // Act
    TopicPartitionInfo actualNewByTopicResult = topicPartitionInfo.newByTopic("Topic");

    // Assert
    assertEquals(topicPartitionInfo, actualNewByTopicResult);
  }

  /**
   * Test {@link TopicPartitionInfo#newByTopic(String)}.
   *
   * <p>Method under test: {@link TopicPartitionInfo#newByTopic(String)}
   */
  @Test
  @DisplayName("Test newByTopic(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TopicPartitionInfo TopicPartitionInfo.newByTopic(String)"})
  void testNewByTopic3() {
    // Arrange
    TopicPartitionInfo topicPartitionInfo = new TopicPartitionInfo("Topic", null, 1, true);

    // Act
    TopicPartitionInfo actualNewByTopicResult = topicPartitionInfo.newByTopic("Topic");

    // Assert
    assertEquals(topicPartitionInfo, actualNewByTopicResult);
  }

  /**
   * Test {@link TopicPartitionInfo#getTenantId()}.
   *
   * <p>Method under test: {@link TopicPartitionInfo#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional TopicPartitionInfo.getTenantId()"})
  void testGetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TopicPartitionInfo topicPartitionInfo = new TopicPartitionInfo("Topic", tenantId, 1, true);

    // Act
    Optional<TenantId> actualTenantId = topicPartitionInfo.getTenantId();

    // Assert
    assertTrue(actualTenantId.isPresent());
    assertSame(tenantId, actualTenantId.get());
  }

  /**
   * Test {@link TopicPartitionInfo#getPartition()}.
   *
   * <p>Method under test: {@link TopicPartitionInfo#getPartition()}
   */
  @Test
  @DisplayName("Test getPartition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional TopicPartitionInfo.getPartition()"})
  void testGetPartition() {
    // Arrange
    TopicPartitionInfo topicPartitionInfo =
        new TopicPartitionInfo("Topic", new TenantId(UUID.randomUUID()), 1, true);

    // Act
    Optional<Integer> actualPartition = topicPartitionInfo.getPartition();

    // Assert
    assertEquals(1, actualPartition.get().intValue());
    assertTrue(actualPartition.isPresent());
  }

  /**
   * Test {@link TopicPartitionInfo#equals(Object)}, and {@link TopicPartitionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TopicPartitionInfo#equals(Object)}
   *   <li>{@link TopicPartitionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TopicPartitionInfo.equals(Object)",
    "int TopicPartitionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    TopicPartitionInfo topicPartitionInfo =
        partitionResult.tenantId(new TenantId(new UUID(1L, 1L))).topic("Topic").build();

    TopicPartitionInfoBuilder partitionResult2 =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    TopicPartitionInfo topicPartitionInfo2 =
        partitionResult2.tenantId(new TenantId(new UUID(1L, 1L))).topic("Topic").build();

    // Act and Assert
    assertEquals(topicPartitionInfo, topicPartitionInfo2);
    assertEquals(topicPartitionInfo.hashCode(), topicPartitionInfo2.hashCode());
  }

  /**
   * Test {@link TopicPartitionInfo#equals(Object)}, and {@link TopicPartitionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TopicPartitionInfo#equals(Object)}
   *   <li>{@link TopicPartitionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TopicPartitionInfo.equals(Object)",
    "int TopicPartitionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    TopicPartitionInfo topicPartitionInfo =
        partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act and Assert
    assertEquals(topicPartitionInfo, topicPartitionInfo);
    int expectedHashCodeResult = topicPartitionInfo.hashCode();
    assertEquals(expectedHashCodeResult, topicPartitionInfo.hashCode());
  }

  /**
   * Test {@link TopicPartitionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TopicPartitionInfo.equals(Object)",
    "int TopicPartitionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    TopicPartitionInfo topicPartitionInfo =
        partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    TopicPartitionInfoBuilder partitionResult2 =
        TopicPartitionInfo.builder().myPartition(true).partition(1);

    // Act and Assert
    assertNotEquals(
        topicPartitionInfo,
        partitionResult2.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build());
  }

  /**
   * Test {@link TopicPartitionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TopicPartitionInfo.equals(Object)",
    "int TopicPartitionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    TopicPartitionInfo topicPartitionInfo =
        partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("42").build();

    TopicPartitionInfoBuilder partitionResult2 =
        TopicPartitionInfo.builder().myPartition(true).partition(1);

    // Act and Assert
    assertNotEquals(
        topicPartitionInfo,
        partitionResult2.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build());
  }

  /**
   * Test {@link TopicPartitionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TopicPartitionInfo.equals(Object)",
    "int TopicPartitionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(0);
    TopicPartitionInfo topicPartitionInfo =
        partitionResult.tenantId(new TenantId(new UUID(1L, 1L))).topic("Topic").build();

    TopicPartitionInfoBuilder partitionResult2 =
        TopicPartitionInfo.builder().myPartition(true).partition(1);

    // Act and Assert
    assertNotEquals(
        topicPartitionInfo,
        partitionResult2.tenantId(new TenantId(new UUID(1L, 1L))).topic("Topic").build());
  }

  /**
   * Test {@link TopicPartitionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TopicPartitionInfo.equals(Object)",
    "int TopicPartitionInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);

    // Act and Assert
    assertNotEquals(
        partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build(), null);
  }

  /**
   * Test {@link TopicPartitionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TopicPartitionInfo.equals(Object)",
    "int TopicPartitionInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);

    // Act and Assert
    assertNotEquals(
        partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build(),
        "Different type to TopicPartitionInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TopicPartitionInfo#toString()}
   *   <li>{@link TopicPartitionInfo#getFullTopicName()}
   *   <li>{@link TopicPartitionInfo#getTopic()}
   *   <li>{@link TopicPartitionInfo#isMyPartition()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TopicPartitionInfo.getFullTopicName()",
    "String TopicPartitionInfo.getTopic()",
    "boolean TopicPartitionInfo.isMyPartition()",
    "String TopicPartitionInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    TopicPartitionInfo topicPartitionInfo =
        partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act
    topicPartitionInfo.toString();
    topicPartitionInfo.getFullTopicName();
    String actualTopic = topicPartitionInfo.getTopic();

    // Assert
    assertEquals("Topic", actualTopic);
    assertTrue(topicPartitionInfo.isMyPartition());
  }

  /**
   * Test TopicPartitionInfoBuilder {@link TopicPartitionInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TopicPartitionInfoBuilder#build()}
   *   <li>{@link TopicPartitionInfoBuilder#myPartition(boolean)}
   *   <li>{@link TopicPartitionInfoBuilder#partition(Integer)}
   *   <li>{@link TopicPartitionInfoBuilder#tenantId(TenantId)}
   *   <li>{@link TopicPartitionInfoBuilder#topic(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TopicPartitionInfoBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TopicPartitionInfoBuilder.<init>()",
    "TopicPartitionInfo TopicPartitionInfoBuilder.build()",
    "TopicPartitionInfoBuilder TopicPartitionInfoBuilder.myPartition(boolean)",
    "TopicPartitionInfoBuilder TopicPartitionInfoBuilder.partition(Integer)",
    "TopicPartitionInfoBuilder TopicPartitionInfoBuilder.tenantId(TenantId)",
    "String TopicPartitionInfoBuilder.toString()",
    "TopicPartitionInfoBuilder TopicPartitionInfoBuilder.topic(String)"
  })
  void testTopicPartitionInfoBuilderBuild() {
    // Arrange and Act
    TopicPartitionInfoBuilder actualPartitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TopicPartitionInfo actualTopicPartitionInfo =
        actualPartitionResult.tenantId(tenantId).topic("Topic").build();

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
}
