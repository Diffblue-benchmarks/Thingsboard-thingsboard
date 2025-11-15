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
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.junit.jupiter.api.Test;

class KafkaTbQueueMsgMetadataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KafkaTbQueueMsgMetadata#equals(Object)}
   *   <li>{@link KafkaTbQueueMsgMetadata#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KafkaTbQueueMsgMetadata kafkaTbQueueMsgMetadata = new KafkaTbQueueMsgMetadata(null);
    KafkaTbQueueMsgMetadata kafkaTbQueueMsgMetadata2 = new KafkaTbQueueMsgMetadata(null);

    // Act and Assert
    assertEquals(kafkaTbQueueMsgMetadata, kafkaTbQueueMsgMetadata2);
    int expectedHashCodeResult = kafkaTbQueueMsgMetadata.hashCode();
    assertEquals(expectedHashCodeResult, kafkaTbQueueMsgMetadata2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KafkaTbQueueMsgMetadata#equals(Object)}
   *   <li>{@link KafkaTbQueueMsgMetadata#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KafkaTbQueueMsgMetadata kafkaTbQueueMsgMetadata = new KafkaTbQueueMsgMetadata(
        new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3));

    // Act and Assert
    assertEquals(kafkaTbQueueMsgMetadata, kafkaTbQueueMsgMetadata);
    int expectedHashCodeResult = kafkaTbQueueMsgMetadata.hashCode();
    assertEquals(expectedHashCodeResult, kafkaTbQueueMsgMetadata.hashCode());
  }

  /**
   * Method under test: {@link KafkaTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KafkaTbQueueMsgMetadata kafkaTbQueueMsgMetadata = new KafkaTbQueueMsgMetadata(
        new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3));

    // Act and Assert
    assertNotEquals(kafkaTbQueueMsgMetadata,
        new KafkaTbQueueMsgMetadata(new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3)));
  }

  /**
   * Method under test: {@link KafkaTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KafkaTbQueueMsgMetadata kafkaTbQueueMsgMetadata = new KafkaTbQueueMsgMetadata(null);

    // Act and Assert
    assertNotEquals(kafkaTbQueueMsgMetadata,
        new KafkaTbQueueMsgMetadata(new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3)));
  }

  /**
   * Method under test: {@link KafkaTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KafkaTbQueueMsgMetadata(new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3)),
        null);
  }

  /**
   * Method under test: {@link KafkaTbQueueMsgMetadata#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KafkaTbQueueMsgMetadata(new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3)),
        "Different type to KafkaTbQueueMsgMetadata");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KafkaTbQueueMsgMetadata#KafkaTbQueueMsgMetadata(RecordMetadata)}
   *   <li>{@link KafkaTbQueueMsgMetadata#setMetadata(RecordMetadata)}
   *   <li>{@link KafkaTbQueueMsgMetadata#toString()}
   *   <li>{@link KafkaTbQueueMsgMetadata#getMetadata()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    KafkaTbQueueMsgMetadata actualKafkaTbQueueMsgMetadata = new KafkaTbQueueMsgMetadata(
        new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3));
    RecordMetadata metadata = new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3);

    actualKafkaTbQueueMsgMetadata.setMetadata(metadata);
    String actualToStringResult = actualKafkaTbQueueMsgMetadata.toString();

    // Assert that nothing has changed
    assertEquals("KafkaTbQueueMsgMetadata(metadata=Topic-1@2)", actualToStringResult);
    assertSame(metadata, actualKafkaTbQueueMsgMetadata.getMetadata());
  }
}
