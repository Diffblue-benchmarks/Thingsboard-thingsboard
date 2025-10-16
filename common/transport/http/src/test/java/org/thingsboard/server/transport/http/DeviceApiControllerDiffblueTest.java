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
package org.thingsboard.server.transport.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.CredentialsType;
import org.thingsboard.server.gen.transport.TransportProtos.ProvisionDeviceResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ResponseStatus;
import org.thingsboard.server.transport.http.DeviceApiController.DeviceProvisionCallback;

class DeviceApiControllerDiffblueTest {
  /**
   * Test DeviceProvisionCallback {@link
   * DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)} with {@code
   * ProvisionDeviceResponseMsg}.
   *
   * <p>Method under test: {@link
   * DeviceProvisionCallback#onSuccess(TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test DeviceProvisionCallback onSuccess(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProvisionCallback.onSuccess(TransportProtos.ProvisionDeviceResponseMsg)"
  })
  void testDeviceProvisionCallbackOnSuccessWithProvisionDeviceResponseMsg() {
    // Arrange
    DeviceProvisionCallback deviceProvisionCallback =
        new DeviceProvisionCallback(new DeferredResult<>());

    ProvisionDeviceResponseMsg msg = mock(ProvisionDeviceResponseMsg.class);
    when(msg.getStatus()).thenReturn(ResponseStatus.NOT_FOUND);

    // Act
    deviceProvisionCallback.onSuccess(msg);

    // Assert
    verify(msg).getStatus();
  }

  /**
   * Test DeviceProvisionCallback {@link
   * DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)} with {@code
   * ProvisionDeviceResponseMsg}.
   *
   * <p>Method under test: {@link
   * DeviceProvisionCallback#onSuccess(TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test DeviceProvisionCallback onSuccess(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProvisionCallback.onSuccess(TransportProtos.ProvisionDeviceResponseMsg)"
  })
  void testDeviceProvisionCallbackOnSuccessWithProvisionDeviceResponseMsg2() {
    // Arrange
    DeviceProvisionCallback deviceProvisionCallback =
        new DeviceProvisionCallback(new DeferredResult<>());

    ProvisionDeviceResponseMsg msg = mock(ProvisionDeviceResponseMsg.class);
    when(msg.getCredentialsType()).thenReturn(CredentialsType.LWM2M_CREDENTIALS);
    when(msg.getStatus()).thenReturn(ResponseStatus.UNKNOWN);

    // Act
    deviceProvisionCallback.onSuccess(msg);

    // Assert
    verify(msg, atLeast(1)).getCredentialsType();
    verify(msg, atLeast(1)).getStatus();
  }

  /**
   * Test DeviceProvisionCallback {@link
   * DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)} with {@code
   * ProvisionDeviceResponseMsg}.
   *
   * <p>Method under test: {@link
   * DeviceProvisionCallback#onSuccess(TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test DeviceProvisionCallback onSuccess(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProvisionCallback.onSuccess(TransportProtos.ProvisionDeviceResponseMsg)"
  })
  void testDeviceProvisionCallbackOnSuccessWithProvisionDeviceResponseMsg3() {
    // Arrange
    DeviceProvisionCallback deviceProvisionCallback =
        new DeviceProvisionCallback(new DeferredResult<>());

    ProvisionDeviceResponseMsg msg = mock(ProvisionDeviceResponseMsg.class);
    when(msg.getCredentialsValue())
        .thenThrow(new HttpMessageNotReadableException("https://example.org/example"));
    when(msg.getCredentialsType()).thenReturn(CredentialsType.ACCESS_TOKEN);
    when(msg.getStatus()).thenReturn(ResponseStatus.UNKNOWN);

    // Act and Assert
    assertThrows(
        HttpMessageNotReadableException.class, () -> deviceProvisionCallback.onSuccess(msg));
    verify(msg).getCredentialsType();
    verify(msg).getCredentialsValue();
    verify(msg, atLeast(1)).getStatus();
  }

  /**
   * Test DeviceProvisionCallback {@link
   * DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)} with {@code
   * ProvisionDeviceResponseMsg}.
   *
   * <p>Method under test: {@link
   * DeviceProvisionCallback#onSuccess(TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test DeviceProvisionCallback onSuccess(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProvisionCallback.onSuccess(TransportProtos.ProvisionDeviceResponseMsg)"
  })
  void testDeviceProvisionCallbackOnSuccessWithProvisionDeviceResponseMsg4() {
    // Arrange
    DeviceProvisionCallback deviceProvisionCallback =
        new DeviceProvisionCallback(new DeferredResult<>());

    ProvisionDeviceResponseMsg msg = mock(ProvisionDeviceResponseMsg.class);
    when(msg.getCredentialsValue())
        .thenThrow(new HttpMessageNotReadableException("https://example.org/example"));
    when(msg.getCredentialsType()).thenReturn(CredentialsType.MQTT_BASIC);
    when(msg.getStatus()).thenReturn(ResponseStatus.UNKNOWN);

    // Act and Assert
    assertThrows(
        HttpMessageNotReadableException.class, () -> deviceProvisionCallback.onSuccess(msg));
    verify(msg).getCredentialsType();
    verify(msg).getCredentialsValue();
    verify(msg, atLeast(1)).getStatus();
  }

  /**
   * Test DeviceProvisionCallback {@link
   * DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)} with {@code
   * ProvisionDeviceResponseMsg}.
   *
   * <ul>
   *   <li>Given {@link TransportProtos.ResponseStatus#FAILURE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceProvisionCallback#onSuccess(TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test DeviceProvisionCallback onSuccess(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'; given FAILURE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProvisionCallback.onSuccess(TransportProtos.ProvisionDeviceResponseMsg)"
  })
  void testDeviceProvisionCallbackOnSuccessWithProvisionDeviceResponseMsg_givenFailure() {
    // Arrange
    DeviceProvisionCallback deviceProvisionCallback =
        new DeviceProvisionCallback(new DeferredResult<>());

    ProvisionDeviceResponseMsg msg = mock(ProvisionDeviceResponseMsg.class);
    when(msg.getStatus()).thenReturn(ResponseStatus.FAILURE);

    // Act
    deviceProvisionCallback.onSuccess(msg);

    // Assert
    verify(msg, atLeast(1)).getStatus();
  }

  /**
   * Test DeviceProvisionCallback {@link
   * DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)} with {@code
   * ProvisionDeviceResponseMsg}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceProvisionCallback#onSuccess(TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test DeviceProvisionCallback onSuccess(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProvisionCallback.onSuccess(TransportProtos.ProvisionDeviceResponseMsg)"
  })
  void testDeviceProvisionCallbackOnSuccessWithProvisionDeviceResponseMsg_givenNull() {
    // Arrange
    DeviceProvisionCallback deviceProvisionCallback =
        new DeviceProvisionCallback(new DeferredResult<>());

    ProvisionDeviceResponseMsg msg = mock(ProvisionDeviceResponseMsg.class);
    when(msg.getCredentialsValue()).thenReturn(null);
    when(msg.getCredentialsType()).thenReturn(CredentialsType.ACCESS_TOKEN);
    when(msg.getStatus()).thenReturn(ResponseStatus.UNKNOWN);

    // Act
    deviceProvisionCallback.onSuccess(msg);

    // Assert
    verify(msg, atLeast(1)).getCredentialsType();
    verify(msg).getCredentialsValue();
    verify(msg, atLeast(1)).getStatus();
  }

  /**
   * Test {@link DeviceApiController#getName()}.
   *
   * <p>Method under test: {@link DeviceApiController#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DeviceApiController.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("HTTP", new DeviceApiController().getName());
  }
}
