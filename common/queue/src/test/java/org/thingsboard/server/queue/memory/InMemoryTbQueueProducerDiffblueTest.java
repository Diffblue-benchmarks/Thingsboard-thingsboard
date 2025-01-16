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
import org.junit.jupiter.api.DisplayName;
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
   * Test {@link InMemoryTbQueueProducer#equals(Object)}, and
   * {@link InMemoryTbQueueProducer#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InMemoryTbQueueProducer#equals(Object)}
   *   <li>{@link InMemoryTbQueueProducer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link InMemoryTbQueueProducer#equals(Object)}, and
   * {@link InMemoryTbQueueProducer#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InMemoryTbQueueProducer#equals(Object)}
   *   <li>{@link InMemoryTbQueueProducer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link InMemoryTbQueueProducer#equals(Object)}, and
   * {@link InMemoryTbQueueProducer#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InMemoryTbQueueProducer#equals(Object)}
   *   <li>{@link InMemoryTbQueueProducer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(
        new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer,
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic"));
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(null, "Default Topic");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer,
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic"));
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(
        mock(InMemoryStorage.class), "Default Topic");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer,
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic"));
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(null, null);

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, new InMemoryTbQueueProducer<>(null, "Default Topic"));
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(null,
        "org.thingsboard.server.queue.memory.InMemoryTbQueueProducer");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, new InMemoryTbQueueProducer<>(null, "Default Topic"));
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(
        new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, null);
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(
        new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, "Different type to InMemoryTbQueueProducer");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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

  /**
   * Test
   * {@link InMemoryTbQueueProducer#send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)}.
   * <p>
   * Method under test:
   * {@link InMemoryTbQueueProducer#send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)}
   */
  @Test
  @DisplayName("Test send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)")
  void testSend() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(
        new DefaultInMemoryStorage(), "Default Topic");
    TopicPartitionInfo tpi = new TopicPartitionInfo("Topic",
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), 1, true);

    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    inMemoryTbQueueProducer.send(tpi, new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance())),
        null);

    // Assert
    InMemoryStorage storage = inMemoryTbQueueProducer.getStorage();
    assertTrue(storage instanceof DefaultInMemoryStorage);
    assertEquals(1, storage.getLagTotal());
  }

  /**
   * Test
   * {@link InMemoryTbQueueProducer#send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)}.
   * <ul>
   *   <li>When {@link TbMsgCallback} {@link TbMsgCallback#onSuccess()} does
   * nothing.</li>
   *   <li>Then calls {@link TbMsgCallback#onSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryTbQueueProducer#send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)}
   */
  @Test
  @DisplayName("Test send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback); when TbMsgCallback onSuccess() does nothing; then calls onSuccess()")
  void testSend_whenTbMsgCallbackOnSuccessDoesNothing_thenCallsOnSuccess() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer = new InMemoryTbQueueProducer<>(
        new DefaultInMemoryStorage(), "Default Topic");
    TopicPartitionInfo tpi = new TopicPartitionInfo("Topic",
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), 1, true);

    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DefaultTbQueueMsg defaultTbQueueMsg = new DefaultTbQueueMsg(
        new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance()));
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onSuccess();

    // Act
    inMemoryTbQueueProducer.send(tpi, defaultTbQueueMsg, new TbQueueTbMsgCallbackWrapper(tbMsgCallback));

    // Assert
    verify(tbMsgCallback).onSuccess();
    InMemoryStorage storage = inMemoryTbQueueProducer.getStorage();
    assertTrue(storage instanceof DefaultInMemoryStorage);
    assertEquals(1, storage.getLagTotal());
  }
}
