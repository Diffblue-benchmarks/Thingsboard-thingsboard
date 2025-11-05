package org.thingsboard.server.queue.common;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Consumer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.msg.queue.RuleEngineException;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.queue.TbQueueMsgMetadata;
import org.thingsboard.server.queue.kafka.KafkaTbQueueMsgMetadata;

class MultipleTbQueueCallbackWrapperDiffblueTest {
  /**
   * Test {@link MultipleTbQueueCallbackWrapper#onSuccess(TbQueueMsgMetadata)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#onSuccess()} does nothing.
   *   <li>Then calls {@link TbMsgCallback#onSuccess()}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleTbQueueCallbackWrapper#onSuccess(TbQueueMsgMetadata)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(TbQueueMsgMetadata); given TbMsgCallback onSuccess() does nothing; then calls onSuccess()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultipleTbQueueCallbackWrapper.onSuccess(TbQueueMsgMetadata)"})
  void testOnSuccess_givenTbMsgCallbackOnSuccessDoesNothing_thenCallsOnSuccess() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onSuccess();
    TbQueueTbMsgCallbackWrapper callback = new TbQueueTbMsgCallbackWrapper(tbMsgCallback);
    MultipleTbQueueCallbackWrapper multipleTbQueueCallbackWrapper =
        new MultipleTbQueueCallbackWrapper(1, callback);
    RecordMetadata metadata = new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3);

    // Act
    multipleTbQueueCallbackWrapper.onSuccess(new KafkaTbQueueMsgMetadata(metadata));

    // Assert
    verify(tbMsgCallback).onSuccess();
  }

  /**
   * Test {@link MultipleTbQueueCallbackWrapper#onFailure(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleTbQueueCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onFailure(Throwable); given Consumer accept(Object) does nothing; when Throwable(); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultipleTbQueueCallbackWrapper.onFailure(Throwable)"})
  void testOnFailure_givenConsumerAcceptDoesNothing_whenThrowable_thenCallsAccept() {
    // Arrange
    Consumer<Throwable> onFailure = mock(Consumer.class);
    doNothing().when(onFailure).accept(Mockito.<Throwable>any());
    SimpleTbQueueCallback callback = new SimpleTbQueueCallback(mock(Consumer.class), onFailure);
    MultipleTbQueueCallbackWrapper callback2 = new MultipleTbQueueCallbackWrapper(3, callback);
    MultipleTbQueueCallbackWrapper multipleTbQueueCallbackWrapper =
        new MultipleTbQueueCallbackWrapper(3, callback2);

    // Act
    multipleTbQueueCallbackWrapper.onFailure(new Throwable());

    // Assert
    verify(onFailure).accept(isA(Throwable.class));
  }

  /**
   * Test {@link MultipleTbQueueCallbackWrapper#onFailure(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#onFailure(RuleEngineException)} does
   *       nothing.
   *   <li>Then calls {@link TbMsgCallback#onFailure(RuleEngineException)}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleTbQueueCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onFailure(Throwable); given TbMsgCallback onFailure(RuleEngineException) does nothing; then calls onFailure(RuleEngineException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultipleTbQueueCallbackWrapper.onFailure(Throwable)"})
  void testOnFailure_givenTbMsgCallbackOnFailureDoesNothing_thenCallsOnFailure() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onFailure(Mockito.<RuleEngineException>any());
    TbQueueTbMsgCallbackWrapper callback = new TbQueueTbMsgCallbackWrapper(tbMsgCallback);
    MultipleTbQueueCallbackWrapper multipleTbQueueCallbackWrapper =
        new MultipleTbQueueCallbackWrapper(3, callback);

    // Act
    multipleTbQueueCallbackWrapper.onFailure(new Throwable());

    // Assert
    verify(tbMsgCallback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link MultipleTbQueueCallbackWrapper#onFailure(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#onFailure(RuleEngineException)} does
   *       nothing.
   *   <li>Then calls {@link TbMsgCallback#onFailure(RuleEngineException)}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleTbQueueCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onFailure(Throwable); given TbMsgCallback onFailure(RuleEngineException) does nothing; then calls onFailure(RuleEngineException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultipleTbQueueCallbackWrapper.onFailure(Throwable)"})
  void testOnFailure_givenTbMsgCallbackOnFailureDoesNothing_thenCallsOnFailure2() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onFailure(Mockito.<RuleEngineException>any());
    TbQueueTbMsgCallbackWrapper callback = new TbQueueTbMsgCallbackWrapper(tbMsgCallback);
    MultipleTbQueueCallbackWrapper callback2 = new MultipleTbQueueCallbackWrapper(3, callback);
    MultipleTbQueueCallbackWrapper multipleTbQueueCallbackWrapper =
        new MultipleTbQueueCallbackWrapper(3, callback2);

    // Act
    multipleTbQueueCallbackWrapper.onFailure(new Throwable());

    // Assert
    verify(tbMsgCallback).onFailure(isA(RuleEngineException.class));
  }
}
