package org.thingsboard.rule.engine.transform;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.msg.queue.RuleEngineException;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class MultipleTbMsgsCallbackWrapperDiffblueTest {
  /**
   * Test {@link MultipleTbMsgsCallbackWrapper#onSuccess()}.
   *
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#onSuccess()} does nothing.
   *   <li>Then calls {@link TbMsgCallback#onSuccess()}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleTbMsgsCallbackWrapper#onSuccess()}
   */
  @Test
  @DisplayName(
      "Test onSuccess(); given TbMsgCallback onSuccess() does nothing; then calls onSuccess()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultipleTbMsgsCallbackWrapper.onSuccess()"})
  void testOnSuccess_givenTbMsgCallbackOnSuccessDoesNothing_thenCallsOnSuccess() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onSuccess();
    MultipleTbMsgsCallbackWrapper multipleTbMsgsCallbackWrapper =
        new MultipleTbMsgsCallbackWrapper(1, callback);

    // Act
    multipleTbMsgsCallbackWrapper.onSuccess();

    // Assert
    verify(callback).onSuccess();
  }

  /**
   * Test {@link MultipleTbMsgsCallbackWrapper#onFailure(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#onFailure(RuleEngineException)} does
   *       nothing.
   *   <li>Then calls {@link TbMsgCallback#onFailure(RuleEngineException)}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleTbMsgsCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onFailure(Throwable); given TbMsgCallback onFailure(RuleEngineException) does nothing; then calls onFailure(RuleEngineException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultipleTbMsgsCallbackWrapper.onFailure(Throwable)"})
  void testOnFailure_givenTbMsgCallbackOnFailureDoesNothing_thenCallsOnFailure() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());
    MultipleTbMsgsCallbackWrapper multipleTbMsgsCallbackWrapper =
        new MultipleTbMsgsCallbackWrapper(3, callback);

    // Act
    multipleTbMsgsCallbackWrapper.onFailure(new Throwable());

    // Assert
    verify(callback).onFailure(isA(RuleEngineException.class));
  }
}
