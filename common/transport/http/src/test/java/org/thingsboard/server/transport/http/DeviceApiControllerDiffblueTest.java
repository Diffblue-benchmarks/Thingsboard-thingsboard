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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.gson.JsonParseException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.server.gen.transport.TransportProtos;

class DeviceApiControllerDiffblueTest {
  /**
   * Method under test:
   * {@link DeviceApiController.DeviceProvisionCallback#onError(Throwable)}
   */
  @Test
  void testDeviceProvisionCallbackOnError() {
    // Arrange
    DeferredResult<ResponseEntity> responseWriter = mock(DeferredResult.class);
    when(responseWriter.setResult(Mockito.<ResponseEntity<Object>>any())).thenReturn(true);
    DeviceApiController.DeviceProvisionCallback deviceProvisionCallback = new DeviceApiController.DeviceProvisionCallback(
        responseWriter);

    // Act
    deviceProvisionCallback.onError(new Throwable());

    // Assert
    verify(responseWriter).setResult(isA(ResponseEntity.class));
  }

  /**
   * Method under test:
   * {@link DeviceApiController.DeviceProvisionCallback#onError(Throwable)}
   */
  @Test
  void testDeviceProvisionCallbackOnError2() {
    // Arrange
    DeferredResult<ResponseEntity> responseWriter = mock(DeferredResult.class);
    when(responseWriter.setResult(Mockito.<ResponseEntity<Object>>any())).thenReturn(true);
    DeviceApiController.DeviceProvisionCallback deviceProvisionCallback = new DeviceApiController.DeviceProvisionCallback(
        responseWriter);

    // Act
    deviceProvisionCallback.onError(new HttpMessageNotReadableException("https://example.org/example"));

    // Assert
    verify(responseWriter).setResult(isA(ResponseEntity.class));
  }

  /**
   * Method under test:
   * {@link DeviceApiController.DeviceProvisionCallback#onError(Throwable)}
   */
  @Test
  void testDeviceProvisionCallbackOnError3() {
    // Arrange
    DeferredResult<ResponseEntity> responseWriter = mock(DeferredResult.class);
    when(responseWriter.setResult(Mockito.<ResponseEntity<Object>>any())).thenReturn(true);
    DeviceApiController.DeviceProvisionCallback deviceProvisionCallback = new DeviceApiController.DeviceProvisionCallback(
        responseWriter);

    // Act
    deviceProvisionCallback.onError(new JsonParseException("Failed to process request in DeviceProvisionCallback"));

    // Assert
    verify(responseWriter).setResult(isA(ResponseEntity.class));
  }

  /**
   * Method under test:
   * {@link DeviceApiController.DeviceProvisionCallback#onSuccess(TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testDeviceProvisionCallbackOnSuccess() {
    // Arrange
    DeferredResult<ResponseEntity> responseWriter = mock(DeferredResult.class);
    when(responseWriter.setResult(Mockito.<ResponseEntity<Object>>any())).thenReturn(true);
    DeviceApiController.DeviceProvisionCallback deviceProvisionCallback = new DeviceApiController.DeviceProvisionCallback(
        responseWriter);

    // Act
    deviceProvisionCallback.onSuccess(TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    verify(responseWriter).setResult(isA(ResponseEntity.class));
  }

  /**
   * Method under test: {@link DeviceApiController#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("HTTP", (new DeviceApiController()).getName());
  }
}
