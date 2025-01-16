package org.thingsboard.rule.engine.transform;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.msg.queue.RuleEngineException;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class MultipleTbMsgsCallbackWrapperDiffblueTest {
  /**
   * Test {@link MultipleTbMsgsCallbackWrapper#onSuccess()}.
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#onSuccess()} does
   * nothing.</li>
   *   <li>Then calls {@link TbMsgCallback#onSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultipleTbMsgsCallbackWrapper#onSuccess()}
   */
  @Test
  @DisplayName("Test onSuccess(); given TbMsgCallback onSuccess() does nothing; then calls onSuccess()")
  void testOnSuccess_givenTbMsgCallbackOnSuccessDoesNothing_thenCallsOnSuccess() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onSuccess();

    // Act
    (new MultipleTbMsgsCallbackWrapper(1, callback)).onSuccess();

    // Assert
    verify(callback).onSuccess();
  }

  /**
   * Test {@link MultipleTbMsgsCallbackWrapper#onFailure(Throwable)}.
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code Unknown}.</li>
   *   <li>Then calls {@link TbMsgCallback#onFailure(RuleEngineException)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultipleTbMsgsCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  @DisplayName("Test onFailure(Throwable); when IOException(String) with 'Unknown'; then calls onFailure(RuleEngineException)")
  void testOnFailure_whenIOExceptionWithUnknown_thenCallsOnFailure() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());
    MultipleTbMsgsCallbackWrapper multipleTbMsgsCallbackWrapper = new MultipleTbMsgsCallbackWrapper(3, callback);

    // Act
    multipleTbMsgsCallbackWrapper.onFailure(new IOException("Unknown"));

    // Assert
    verify(callback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link MultipleTbMsgsCallbackWrapper#onFailure(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then calls {@link TbMsgCallback#onFailure(RuleEngineException)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MultipleTbMsgsCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  @DisplayName("Test onFailure(Throwable); when Throwable(); then calls onFailure(RuleEngineException)")
  void testOnFailure_whenThrowable_thenCallsOnFailure() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());
    MultipleTbMsgsCallbackWrapper multipleTbMsgsCallbackWrapper = new MultipleTbMsgsCallbackWrapper(3, callback);

    // Act
    multipleTbMsgsCallbackWrapper.onFailure(new Throwable());

    // Assert
    verify(callback).onFailure(isA(RuleEngineException.class));
  }
}
