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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.google.api.Advice;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.queue.TbQueueCallback;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.common.DefaultTbQueueMsg;
import org.thingsboard.server.queue.common.TbProtoJsQueueMsg;
import org.thingsboard.server.queue.common.TbQueueTbMsgCallbackWrapper;

class InMemoryTbQueueProducerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InMemoryTbQueueProducer#equals(Object)}
   *   <li>{@link InMemoryTbQueueProducer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(null, "Default Topic");
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer2 = new InMemoryTbQueueProducer<>(null, "Default Topic");

    // Act and Assert
    assertEquals(inMemoryTbQueueProducer, inMemoryTbQueueProducer2);
    int expectedHashCodeResult = inMemoryTbQueueProducer.hashCode();
    assertEquals(expectedHashCodeResult, inMemoryTbQueueProducer2.hashCode());
  }

  /**
   * Method under test:
   * {@link InMemoryTbQueueProducer#send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)}
   */
  @Test
  void testSend() {
    // Arrange
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(storage,
        "Default Topic");
    TopicPartitionInfo tpi = new TopicPartitionInfo("Topic", new TenantId(UUID.randomUUID()), 1, true);

    UUID key = UUID.randomUUID();
    DefaultTbQueueMsg defaultTbQueueMsg = new DefaultTbQueueMsg(
        new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance()));
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onSuccess();

    // Act
    inMemoryTbQueueProducer.send(tpi, defaultTbQueueMsg, new TbQueueTbMsgCallbackWrapper(tbMsgCallback));

    // Assert
    verify(tbMsgCallback).onSuccess();
    InMemoryStorage storage2 = inMemoryTbQueueProducer.getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertEquals(1, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Method under test:
   * {@link InMemoryTbQueueProducer#send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)}
   */
  @Test
  void testSend2() {
    // Arrange
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(storage,
        "Default Topic");
    TopicPartitionInfo tpi = new TopicPartitionInfo("Topic", new TenantId(UUID.randomUUID()), 1, true);

    UUID key = UUID.randomUUID();

    // Act
    inMemoryTbQueueProducer.send(tpi, new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance())),
        null);

    // Assert
    InMemoryStorage storage2 = inMemoryTbQueueProducer.getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertEquals(1, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InMemoryTbQueueProducer#equals(Object)}
   *   <li>{@link InMemoryTbQueueProducer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(null, null);
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer2 = new InMemoryTbQueueProducer<>(null, null);

    // Act and Assert
    assertEquals(inMemoryTbQueueProducer, inMemoryTbQueueProducer2);
    int expectedHashCodeResult = inMemoryTbQueueProducer.hashCode();
    assertEquals(expectedHashCodeResult, inMemoryTbQueueProducer2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InMemoryTbQueueProducer#equals(Object)}
   *   <li>{@link InMemoryTbQueueProducer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(
        new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertEquals(inMemoryTbQueueProducer, inMemoryTbQueueProducer);
    int expectedHashCodeResult = inMemoryTbQueueProducer.hashCode();
    assertEquals(expectedHashCodeResult, inMemoryTbQueueProducer.hashCode());
  }

  /**
   * Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(
        new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer,
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic"));
  }

  /**
   * Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(null, "Default Topic");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer,
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic"));
  }

  /**
   * Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(
        mock(InMemoryStorage.class), "Default Topic");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer,
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic"));
  }

  /**
   * Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(null, null);

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, new InMemoryTbQueueProducer<>(null, "Default Topic"));
  }

  /**
   * Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(null,
        "org.thingsboard.server.queue.memory.InMemoryTbQueueProducer");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, new InMemoryTbQueueProducer<>(null, "Default Topic"));
  }

  /**
   * Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(
        new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, null);
  }

  /**
   * Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(
        new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, "Different type to InMemoryTbQueueProducer");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link InMemoryTbQueueProducer#InMemoryTbQueueProducer(InMemoryStorage, String)}
   *   <li>{@link InMemoryTbQueueProducer#init()}
   *   <li>{@link InMemoryTbQueueProducer#stop()}
   *   <li>{@link InMemoryTbQueueProducer#toString()}
   *   <li>{@link InMemoryTbQueueProducer#getDefaultTopic()}
   *   <li>{@link InMemoryTbQueueProducer#getStorage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    InMemoryTbQueueProducer<TbQueueMsg> actualInMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(storage,
        "Default Topic");
    actualInMemoryTbQueueProducer.init();
    actualInMemoryTbQueueProducer.stop();
    actualInMemoryTbQueueProducer.toString();
    String actualDefaultTopic = actualInMemoryTbQueueProducer.getDefaultTopic();
    InMemoryStorage actualStorage = actualInMemoryTbQueueProducer.getStorage();

    // Assert that nothing has changed
    assertTrue(actualStorage instanceof DefaultInMemoryStorage);
    assertEquals("Default Topic", actualDefaultTopic);
    assertSame(storage, actualStorage);
  }
}
