package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TbLwM2MLatchCallbackDiffblueTest {
  /**
   * Test {@link TbLwM2MLatchCallback#onSuccess(Object, Object)}.
   *
   * <ul>
   *   <li>Then calls {@link DownlinkRequestCallback#onSuccess(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MLatchCallback#onSuccess(Object, Object)}
   */
  @Test
  @DisplayName("Test onSuccess(Object, Object); then calls onSuccess(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2MLatchCallback.onSuccess(Object, Object)"})
  void testOnSuccess_thenCallsOnSuccess() {
    // Arrange
    DownlinkRequestCallback<Object, Object> callback = mock(DownlinkRequestCallback.class);
    doNothing().when(callback).onSuccess(Mockito.<Object>any(), Mockito.<Object>any());
    TbLwM2MLatchCallback<Object, Object> tbLwM2MLatchCallback =
        new TbLwM2MLatchCallback<>(new CountDownLatch(3), callback);

    // Act
    tbLwM2MLatchCallback.onSuccess("Request", "Response");

    // Assert
    verify(callback).onSuccess(isA(Object.class), isA(Object.class));
  }

  /**
   * Test {@link TbLwM2MLatchCallback#onValidationError(String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link DownlinkRequestCallback#onValidationError(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MLatchCallback#onValidationError(String, String)}
   */
  @Test
  @DisplayName(
      "Test onValidationError(String, String); then calls onValidationError(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2MLatchCallback.onValidationError(String, String)"})
  void testOnValidationError_thenCallsOnValidationError() {
    // Arrange
    DownlinkRequestCallback<Object, Object> callback = mock(DownlinkRequestCallback.class);
    doNothing().when(callback).onValidationError(Mockito.<String>any(), Mockito.<String>any());
    TbLwM2MLatchCallback<Object, Object> tbLwM2MLatchCallback =
        new TbLwM2MLatchCallback<>(new CountDownLatch(3), callback);

    // Act
    tbLwM2MLatchCallback.onValidationError("Params", "Msg");

    // Assert
    verify(callback).onValidationError("Params", "Msg");
  }

  /**
   * Test {@link TbLwM2MLatchCallback#onError(String, Exception)}.
   *
   * <ul>
   *   <li>Then calls {@link DownlinkRequestCallback#onError(String, Exception)}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MLatchCallback#onError(String, Exception)}
   */
  @Test
  @DisplayName("Test onError(String, Exception); then calls onError(String, Exception)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2MLatchCallback.onError(String, Exception)"})
  void testOnError_thenCallsOnError() {
    // Arrange
    DownlinkRequestCallback<Object, Object> callback = mock(DownlinkRequestCallback.class);
    doNothing().when(callback).onError(Mockito.<String>any(), Mockito.<Exception>any());
    TbLwM2MLatchCallback<Object, Object> tbLwM2MLatchCallback =
        new TbLwM2MLatchCallback<>(new CountDownLatch(3), callback);

    // Act
    tbLwM2MLatchCallback.onError("Params", new Exception());

    // Assert
    verify(callback).onError(eq("Params"), isA(Exception.class));
  }
}
