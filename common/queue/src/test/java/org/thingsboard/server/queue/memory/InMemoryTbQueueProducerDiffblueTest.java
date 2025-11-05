package org.thingsboard.server.queue.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.RuleEngineException;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.queue.TbQueueCallback;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.common.DefaultTbQueueMsg;
import org.thingsboard.server.queue.common.DefaultTbQueueMsgHeaders;
import org.thingsboard.server.queue.common.TbQueueTbMsgCallbackWrapper;

class InMemoryTbQueueProducerDiffblueTest {
  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}, and {@link
   * InMemoryTbQueueProducer#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InMemoryTbQueueProducer#equals(Object)}
   *   <li>{@link InMemoryTbQueueProducer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(null, "Default Topic");
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer2 =
        new InMemoryTbQueueProducer<>(null, "Default Topic");

    // Act and Assert
    assertEquals(inMemoryTbQueueProducer, inMemoryTbQueueProducer2);
    assertEquals(inMemoryTbQueueProducer.hashCode(), inMemoryTbQueueProducer2.hashCode());
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}, and {@link
   * InMemoryTbQueueProducer#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InMemoryTbQueueProducer#equals(Object)}
   *   <li>{@link InMemoryTbQueueProducer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(null, null);
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer2 =
        new InMemoryTbQueueProducer<>(null, null);

    // Act and Assert
    assertEquals(inMemoryTbQueueProducer, inMemoryTbQueueProducer2);
    assertEquals(inMemoryTbQueueProducer.hashCode(), inMemoryTbQueueProducer2.hashCode());
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}, and {@link
   * InMemoryTbQueueProducer#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InMemoryTbQueueProducer#equals(Object)}
   *   <li>{@link InMemoryTbQueueProducer#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertEquals(inMemoryTbQueueProducer, inMemoryTbQueueProducer);
    int expectedHashCodeResult = inMemoryTbQueueProducer.hashCode();
    assertEquals(expectedHashCodeResult, inMemoryTbQueueProducer.hashCode());
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertNotEquals(
        inMemoryTbQueueProducer,
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic"));
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(null, "Default Topic");

    // Act and Assert
    assertNotEquals(
        inMemoryTbQueueProducer,
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic"));
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(null, null);

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, new InMemoryTbQueueProducer<>(null, "Default Topic"));
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(
            null, "org.thingsboard.server.queue.memory.InMemoryTbQueueProducer");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, new InMemoryTbQueueProducer<>(null, "Default Topic"));
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, null);
  }

  /**
   * Test {@link InMemoryTbQueueProducer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InMemoryTbQueueProducer.equals(Object)",
    "int InMemoryTbQueueProducer.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic");

    // Act and Assert
    assertNotEquals(inMemoryTbQueueProducer, "Different type to InMemoryTbQueueProducer");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InMemoryTbQueueProducer#InMemoryTbQueueProducer(InMemoryStorage, String)}
   *   <li>{@link InMemoryTbQueueProducer#init()}
   *   <li>{@link InMemoryTbQueueProducer#stop()}
   *   <li>{@link InMemoryTbQueueProducer#toString()}
   *   <li>{@link InMemoryTbQueueProducer#getDefaultTopic()}
   *   <li>{@link InMemoryTbQueueProducer#getStorage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InMemoryTbQueueProducer.<init>(InMemoryStorage, String)",
    "String InMemoryTbQueueProducer.getDefaultTopic()",
    "InMemoryStorage InMemoryTbQueueProducer.getStorage()",
    "void InMemoryTbQueueProducer.init()",
    "void InMemoryTbQueueProducer.stop()",
    "String InMemoryTbQueueProducer.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    InMemoryTbQueueProducer<TbQueueMsg> actualInMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(storage, "Default Topic");
    actualInMemoryTbQueueProducer.init();
    actualInMemoryTbQueueProducer.stop();
    actualInMemoryTbQueueProducer.toString();
    String actualDefaultTopic = actualInMemoryTbQueueProducer.getDefaultTopic();
    InMemoryStorage actualStorage = actualInMemoryTbQueueProducer.getStorage();

    // Assert
    assertTrue(actualStorage instanceof DefaultInMemoryStorage);
    assertEquals("Default Topic", actualDefaultTopic);
    assertSame(storage, actualStorage);
  }

  /**
   * Test {@link InMemoryTbQueueProducer#send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)}.
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#send(TopicPartitionInfo, TbQueueMsg,
   * TbQueueCallback)}
   */
  @Test
  @DisplayName("Test send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InMemoryTbQueueProducer.send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)"
  })
  void testSend() throws UnsupportedEncodingException {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TopicPartitionInfo tpi = new TopicPartitionInfo("Topic", tenantId, 1, true);

    DefaultTbQueueMsg msg = mock(DefaultTbQueueMsg.class);
    when(msg.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getKey()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(msg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());

    // Act
    inMemoryTbQueueProducer.send(tpi, new DefaultTbQueueMsg(msg), null);

    // Assert
    verify(msg).getData();
    verify(msg).getHeaders();
    verify(msg).getKey();
    InMemoryStorage storage = inMemoryTbQueueProducer.getStorage();
    assertTrue(storage instanceof DefaultInMemoryStorage);
    assertEquals(1, storage.getLagTotal());
  }

  /**
   * Test {@link InMemoryTbQueueProducer#send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)}.
   *
   * <ul>
   *   <li>When {@link TbMsgCallback} {@link TbMsgCallback#onFailure(RuleEngineException)} does
   *       nothing.
   *   <li>Then calls {@link TbMsgCallback#onFailure(RuleEngineException)}.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#send(TopicPartitionInfo, TbQueueMsg,
   * TbQueueCallback)}
   */
  @Test
  @DisplayName(
      "Test send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback); when TbMsgCallback onFailure(RuleEngineException) does nothing; then calls onFailure(RuleEngineException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InMemoryTbQueueProducer.send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)"
  })
  void testSend_whenTbMsgCallbackOnFailureDoesNothing_thenCallsOnFailure()
      throws UnsupportedEncodingException {
    // Arrange
    InMemoryStorage storage = mock(InMemoryStorage.class);
    when(storage.put(Mockito.<String>any(), Mockito.<TbQueueMsg>any())).thenReturn(false);
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(storage, "Default Topic");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TopicPartitionInfo tpi = new TopicPartitionInfo("Topic", tenantId, 1, true);

    DefaultTbQueueMsg msg = mock(DefaultTbQueueMsg.class);
    when(msg.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getKey()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(msg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());
    DefaultTbQueueMsg defaultTbQueueMsg = new DefaultTbQueueMsg(msg);

    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onFailure(Mockito.<RuleEngineException>any());

    // Act
    inMemoryTbQueueProducer.send(
        tpi, defaultTbQueueMsg, new TbQueueTbMsgCallbackWrapper(tbMsgCallback));

    // Assert
    verify(tbMsgCallback).onFailure(isA(RuleEngineException.class));
    verify(msg).getData();
    verify(msg).getHeaders();
    verify(msg).getKey();
    verify(storage)
        .put(eq("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1"), isA(TbQueueMsg.class));
  }

  /**
   * Test {@link InMemoryTbQueueProducer#send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)}.
   *
   * <ul>
   *   <li>When {@link TbMsgCallback} {@link TbMsgCallback#onSuccess()} does nothing.
   *   <li>Then calls {@link TbMsgCallback#onSuccess()}.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryTbQueueProducer#send(TopicPartitionInfo, TbQueueMsg,
   * TbQueueCallback)}
   */
  @Test
  @DisplayName(
      "Test send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback); when TbMsgCallback onSuccess() does nothing; then calls onSuccess()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InMemoryTbQueueProducer.send(TopicPartitionInfo, TbQueueMsg, TbQueueCallback)"
  })
  void testSend_whenTbMsgCallbackOnSuccessDoesNothing_thenCallsOnSuccess()
      throws UnsupportedEncodingException {
    // Arrange
    InMemoryTbQueueProducer<TbQueueMsg> inMemoryTbQueueProducer =
        new InMemoryTbQueueProducer<>(new DefaultInMemoryStorage(), "Default Topic");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TopicPartitionInfo tpi = new TopicPartitionInfo("Topic", tenantId, 1, true);

    DefaultTbQueueMsg msg = mock(DefaultTbQueueMsg.class);
    when(msg.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getKey()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(msg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());
    DefaultTbQueueMsg defaultTbQueueMsg = new DefaultTbQueueMsg(msg);

    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onSuccess();

    // Act
    inMemoryTbQueueProducer.send(
        tpi, defaultTbQueueMsg, new TbQueueTbMsgCallbackWrapper(tbMsgCallback));

    // Assert
    verify(tbMsgCallback).onSuccess();
    verify(msg).getData();
    verify(msg).getHeaders();
    verify(msg).getKey();
    InMemoryStorage storage = inMemoryTbQueueProducer.getStorage();
    assertTrue(storage instanceof DefaultInMemoryStorage);
    assertEquals(1, storage.getLagTotal());
  }
}
