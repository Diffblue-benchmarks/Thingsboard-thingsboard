package org.thingsboard.server.queue.common;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.function.Consumer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.msg.queue.RuleEngineException;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.queue.TbQueueCallback;
import org.thingsboard.server.queue.TbQueueMsgMetadata;
import org.thingsboard.server.queue.kafka.KafkaTbQueueMsgMetadata;

class MultipleTbQueueCallbackWrapperDiffblueTest {
  /**
   * Test
   * {@link MultipleTbQueueCallbackWrapper#MultipleTbQueueCallbackWrapper(int, TbQueueCallback)}.
   * <p>
   * Method under test:
   * {@link MultipleTbQueueCallbackWrapper#MultipleTbQueueCallbackWrapper(int, TbQueueCallback)}
   */
  @Test
  @DisplayName("Test new MultipleTbQueueCallbackWrapper(int, TbQueueCallback)")
  void testNewMultipleTbQueueCallbackWrapper() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     MultipleTbQueueCallbackWrapper.callback
    //     MultipleTbQueueCallbackWrapper.tbQueueCallbackCount
    //     TbQueueTbMsgCallbackWrapper.tbMsgCallback

    // Arrange and Act
    new MultipleTbQueueCallbackWrapper(3, new TbQueueTbMsgCallbackWrapper(mock(TbMsgCallback.class)));

  }

  /**
   * Test {@link MultipleTbQueueCallbackWrapper#onSuccess(TbQueueMsgMetadata)}.
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#onSuccess()} does
   * nothing.</li>
   *   <li>Then calls {@link TbMsgCallback#onSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultipleTbQueueCallbackWrapper#onSuccess(TbQueueMsgMetadata)}
   */
  @Test
  @DisplayName("Test onSuccess(TbQueueMsgMetadata); given TbMsgCallback onSuccess() does nothing; then calls onSuccess()")
  void testOnSuccess_givenTbMsgCallbackOnSuccessDoesNothing_thenCallsOnSuccess() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onSuccess();
    MultipleTbQueueCallbackWrapper multipleTbQueueCallbackWrapper = new MultipleTbQueueCallbackWrapper(1,
        new TbQueueTbMsgCallbackWrapper(tbMsgCallback));

    // Act
    multipleTbQueueCallbackWrapper
        .onSuccess(new KafkaTbQueueMsgMetadata(new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3)));

    // Assert
    verify(tbMsgCallback).onSuccess();
  }

  /**
   * Test {@link MultipleTbQueueCallbackWrapper#onFailure(Throwable)}.
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultipleTbQueueCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  @DisplayName("Test onFailure(Throwable); given Consumer accept(Object) does nothing; when Throwable(); then calls accept(Object)")
  void testOnFailure_givenConsumerAcceptDoesNothing_whenThrowable_thenCallsAccept() {
    // Arrange
    Consumer<Throwable> onFailure = mock(Consumer.class);
    doNothing().when(onFailure).accept(Mockito.<Throwable>any());
    MultipleTbQueueCallbackWrapper multipleTbQueueCallbackWrapper = new MultipleTbQueueCallbackWrapper(3,
        new MultipleTbQueueCallbackWrapper(3, new SimpleTbQueueCallback(mock(Consumer.class), onFailure)));

    // Act
    multipleTbQueueCallbackWrapper.onFailure(new Throwable());

    // Assert
    verify(onFailure).accept(isA(Throwable.class));
  }

  /**
   * Test {@link MultipleTbQueueCallbackWrapper#onFailure(Throwable)}.
   * <ul>
   *   <li>Given {@link TbMsgCallback}
   * {@link TbMsgCallback#onFailure(RuleEngineException)} does nothing.</li>
   *   <li>Then calls {@link TbMsgCallback#onFailure(RuleEngineException)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultipleTbQueueCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  @DisplayName("Test onFailure(Throwable); given TbMsgCallback onFailure(RuleEngineException) does nothing; then calls onFailure(RuleEngineException)")
  void testOnFailure_givenTbMsgCallbackOnFailureDoesNothing_thenCallsOnFailure() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onFailure(Mockito.<RuleEngineException>any());
    MultipleTbQueueCallbackWrapper multipleTbQueueCallbackWrapper = new MultipleTbQueueCallbackWrapper(3,
        new TbQueueTbMsgCallbackWrapper(tbMsgCallback));

    // Act
    multipleTbQueueCallbackWrapper.onFailure(new Throwable());

    // Assert
    verify(tbMsgCallback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link MultipleTbQueueCallbackWrapper#onFailure(Throwable)}.
   * <ul>
   *   <li>Given {@link TbMsgCallback}
   * {@link TbMsgCallback#onFailure(RuleEngineException)} does nothing.</li>
   *   <li>Then calls {@link TbMsgCallback#onFailure(RuleEngineException)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MultipleTbQueueCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  @DisplayName("Test onFailure(Throwable); given TbMsgCallback onFailure(RuleEngineException) does nothing; then calls onFailure(RuleEngineException)")
  void testOnFailure_givenTbMsgCallbackOnFailureDoesNothing_thenCallsOnFailure2() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onFailure(Mockito.<RuleEngineException>any());
    MultipleTbQueueCallbackWrapper multipleTbQueueCallbackWrapper = new MultipleTbQueueCallbackWrapper(3,
        new MultipleTbQueueCallbackWrapper(3, new TbQueueTbMsgCallbackWrapper(tbMsgCallback)));

    // Act
    multipleTbQueueCallbackWrapper.onFailure(new Throwable());

    // Assert
    verify(tbMsgCallback).onFailure(isA(RuleEngineException.class));
  }
}
