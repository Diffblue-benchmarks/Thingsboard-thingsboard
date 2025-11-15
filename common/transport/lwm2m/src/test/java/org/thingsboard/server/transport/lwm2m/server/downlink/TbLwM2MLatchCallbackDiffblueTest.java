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
package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TbLwM2MLatchCallbackDiffblueTest {
  /**
   * Test {@link TbLwM2MLatchCallback#onSuccess(Object, Object)}.
   * <ul>
   *   <li>Then calls {@link DownlinkRequestCallback#onSuccess(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2MLatchCallback#onSuccess(Object, Object)}
   */
  @Test
  @DisplayName("Test onSuccess(Object, Object); then calls onSuccess(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbLwM2MLatchCallback.onSuccess(Object, Object)"})
  void testOnSuccess_thenCallsOnSuccess() {
    // Arrange
    DownlinkRequestCallback<Object, Object> callback = mock(DownlinkRequestCallback.class);
    doNothing().when(callback).onSuccess(Mockito.<Object>any(), Mockito.<Object>any());
    TbLwM2MLatchCallback<Object, Object> tbLwM2MLatchCallback = new TbLwM2MLatchCallback<>(new CountDownLatch(1),
        callback);

    // Act
    tbLwM2MLatchCallback.onSuccess("Request", "Response");

    // Assert
    verify(callback).onSuccess(isA(Object.class), isA(Object.class));
  }

  /**
   * Test {@link TbLwM2MLatchCallback#onValidationError(String, String)}.
   * <ul>
   *   <li>Then calls {@link DownlinkRequestCallback#onValidationError(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2MLatchCallback#onValidationError(String, String)}
   */
  @Test
  @DisplayName("Test onValidationError(String, String); then calls onValidationError(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbLwM2MLatchCallback.onValidationError(String, String)"})
  void testOnValidationError_thenCallsOnValidationError() {
    // Arrange
    DownlinkRequestCallback<Object, Object> callback = mock(DownlinkRequestCallback.class);
    doNothing().when(callback).onValidationError(Mockito.<String>any(), Mockito.<String>any());
    TbLwM2MLatchCallback<Object, Object> tbLwM2MLatchCallback = new TbLwM2MLatchCallback<>(new CountDownLatch(1),
        callback);

    // Act
    tbLwM2MLatchCallback.onValidationError("Params", "Msg");

    // Assert
    verify(callback).onValidationError(eq("Params"), eq("Msg"));
  }

  /**
   * Test {@link TbLwM2MLatchCallback#onError(String, Exception)}.
   * <ul>
   *   <li>Then calls {@link DownlinkRequestCallback#onError(String, Exception)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2MLatchCallback#onError(String, Exception)}
   */
  @Test
  @DisplayName("Test onError(String, Exception); then calls onError(String, Exception)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbLwM2MLatchCallback.onError(String, Exception)"})
  void testOnError_thenCallsOnError() {
    // Arrange
    DownlinkRequestCallback<Object, Object> callback = mock(DownlinkRequestCallback.class);
    doNothing().when(callback).onError(Mockito.<String>any(), Mockito.<Exception>any());
    TbLwM2MLatchCallback<Object, Object> tbLwM2MLatchCallback = new TbLwM2MLatchCallback<>(new CountDownLatch(1),
        callback);

    // Act
    tbLwM2MLatchCallback.onError("Params", new Exception("foo"));

    // Assert
    verify(callback).onError(eq("Params"), isA(Exception.class));
  }
}
