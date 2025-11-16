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
package org.thingsboard.server.queue.kafka;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KafkaTbQueueMsgMetadataDiffblueTest {
  /**
   * Test {@link KafkaTbQueueMsgMetadata#equals(Object)}, and {@link
   * KafkaTbQueueMsgMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KafkaTbQueueMsgMetadata#equals(Object)}
   *   <li>{@link KafkaTbQueueMsgMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KafkaTbQueueMsgMetadata.equals(Object)",
    "int KafkaTbQueueMsgMetadata.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KafkaTbQueueMsgMetadata kafkaTbQueueMsgMetadata = new KafkaTbQueueMsgMetadata(null);
    KafkaTbQueueMsgMetadata kafkaTbQueueMsgMetadata2 = new KafkaTbQueueMsgMetadata(null);

    // Act and Assert
    assertEquals(kafkaTbQueueMsgMetadata, kafkaTbQueueMsgMetadata2);
    assertEquals(kafkaTbQueueMsgMetadata.hashCode(), kafkaTbQueueMsgMetadata2.hashCode());
  }

  /**
   * Test {@link KafkaTbQueueMsgMetadata#equals(Object)}, and {@link
   * KafkaTbQueueMsgMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KafkaTbQueueMsgMetadata#equals(Object)}
   *   <li>{@link KafkaTbQueueMsgMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KafkaTbQueueMsgMetadata.equals(Object)",
    "int KafkaTbQueueMsgMetadata.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RecordMetadata metadata = new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3);
    KafkaTbQueueMsgMetadata kafkaTbQueueMsgMetadata = new KafkaTbQueueMsgMetadata(metadata);

    // Act and Assert
    assertEquals(kafkaTbQueueMsgMetadata, kafkaTbQueueMsgMetadata);
    int expectedHashCodeResult = kafkaTbQueueMsgMetadata.hashCode();
    assertEquals(expectedHashCodeResult, kafkaTbQueueMsgMetadata.hashCode());
  }

  /**
   * Test {@link KafkaTbQueueMsgMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KafkaTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KafkaTbQueueMsgMetadata.equals(Object)",
    "int KafkaTbQueueMsgMetadata.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RecordMetadata metadata = new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3);
    KafkaTbQueueMsgMetadata kafkaTbQueueMsgMetadata = new KafkaTbQueueMsgMetadata(metadata);
    RecordMetadata metadata2 = new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3);

    // Act and Assert
    assertNotEquals(kafkaTbQueueMsgMetadata, new KafkaTbQueueMsgMetadata(metadata2));
  }

  /**
   * Test {@link KafkaTbQueueMsgMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KafkaTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KafkaTbQueueMsgMetadata.equals(Object)",
    "int KafkaTbQueueMsgMetadata.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KafkaTbQueueMsgMetadata kafkaTbQueueMsgMetadata = new KafkaTbQueueMsgMetadata(null);
    RecordMetadata metadata = new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3);

    // Act and Assert
    assertNotEquals(kafkaTbQueueMsgMetadata, new KafkaTbQueueMsgMetadata(metadata));
  }

  /**
   * Test {@link KafkaTbQueueMsgMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KafkaTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KafkaTbQueueMsgMetadata.equals(Object)",
    "int KafkaTbQueueMsgMetadata.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RecordMetadata metadata = new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3);

    // Act and Assert
    assertNotEquals(new KafkaTbQueueMsgMetadata(metadata), null);
  }

  /**
   * Test {@link KafkaTbQueueMsgMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KafkaTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean KafkaTbQueueMsgMetadata.equals(Object)",
    "int KafkaTbQueueMsgMetadata.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RecordMetadata metadata = new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3);

    // Act and Assert
    assertNotEquals(
        new KafkaTbQueueMsgMetadata(metadata), "Different type to KafkaTbQueueMsgMetadata");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KafkaTbQueueMsgMetadata#KafkaTbQueueMsgMetadata(RecordMetadata)}
   *   <li>{@link KafkaTbQueueMsgMetadata#setMetadata(RecordMetadata)}
   *   <li>{@link KafkaTbQueueMsgMetadata#toString()}
   *   <li>{@link KafkaTbQueueMsgMetadata#getMetadata()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void KafkaTbQueueMsgMetadata.<init>(RecordMetadata)",
    "RecordMetadata KafkaTbQueueMsgMetadata.getMetadata()",
    "void KafkaTbQueueMsgMetadata.setMetadata(RecordMetadata)",
    "String KafkaTbQueueMsgMetadata.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    RecordMetadata metadata = new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3);

    // Act
    KafkaTbQueueMsgMetadata actualKafkaTbQueueMsgMetadata = new KafkaTbQueueMsgMetadata(metadata);
    RecordMetadata metadata2 = new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3);
    actualKafkaTbQueueMsgMetadata.setMetadata(metadata2);
    String actualToStringResult = actualKafkaTbQueueMsgMetadata.toString();

    // Assert
    assertEquals("KafkaTbQueueMsgMetadata(metadata=Topic-1@2)", actualToStringResult);
    assertSame(metadata2, actualKafkaTbQueueMsgMetadata.getMetadata());
  }
}
