package org.thingsboard.server.queue.common;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
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

class TbQueueTbMsgCallbackWrapperDiffblueTest {
  /**
   * Test {@link TbQueueTbMsgCallbackWrapper#onSuccess(TbQueueMsgMetadata)}.
   *
   * <p>Method under test: {@link TbQueueTbMsgCallbackWrapper#onSuccess(TbQueueMsgMetadata)}
   */
  @Test
  @DisplayName("Test onSuccess(TbQueueMsgMetadata)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbQueueTbMsgCallbackWrapper.onSuccess(TbQueueMsgMetadata)"})
  void testOnSuccess() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onSuccess();
    TbQueueTbMsgCallbackWrapper tbQueueTbMsgCallbackWrapper =
        new TbQueueTbMsgCallbackWrapper(tbMsgCallback);
    RecordMetadata metadata = new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3);

    // Act
    tbQueueTbMsgCallbackWrapper.onSuccess(new KafkaTbQueueMsgMetadata(metadata));

    // Assert
    verify(tbMsgCallback).onSuccess();
  }

  /**
   * Test {@link TbQueueTbMsgCallbackWrapper#onFailure(Throwable)}.
   *
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code An error occurred}.
   *   <li>Then calls {@link TbMsgCallback#onFailure(RuleEngineException)}.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueTbMsgCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onFailure(Throwable); when IOException(String) with 'An error occurred'; then calls onFailure(RuleEngineException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbQueueTbMsgCallbackWrapper.onFailure(Throwable)"})
  void testOnFailure_whenIOExceptionWithAnErrorOccurred_thenCallsOnFailure() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onFailure(Mockito.<RuleEngineException>any());
    TbQueueTbMsgCallbackWrapper tbQueueTbMsgCallbackWrapper =
        new TbQueueTbMsgCallbackWrapper(tbMsgCallback);

    // Act
    tbQueueTbMsgCallbackWrapper.onFailure(new IOException("An error occurred"));

    // Assert
    verify(tbMsgCallback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link TbQueueTbMsgCallbackWrapper#onFailure(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then calls {@link TbMsgCallback#onFailure(RuleEngineException)}.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueTbMsgCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onFailure(Throwable); when Throwable(); then calls onFailure(RuleEngineException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbQueueTbMsgCallbackWrapper.onFailure(Throwable)"})
  void testOnFailure_whenThrowable_thenCallsOnFailure() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onFailure(Mockito.<RuleEngineException>any());
    TbQueueTbMsgCallbackWrapper tbQueueTbMsgCallbackWrapper =
        new TbQueueTbMsgCallbackWrapper(tbMsgCallback);

    // Act
    tbQueueTbMsgCallbackWrapper.onFailure(new Throwable());

    // Assert
    verify(tbMsgCallback).onFailure(isA(RuleEngineException.class));
  }
}
