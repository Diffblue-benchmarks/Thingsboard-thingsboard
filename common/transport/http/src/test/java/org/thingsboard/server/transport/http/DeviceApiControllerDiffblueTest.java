package org.thingsboard.server.transport.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.gson.JsonParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.http.DeviceApiController.DeviceProvisionCallback;

class DeviceApiControllerDiffblueTest {
  /**
   * Test DeviceProvisionCallback
   * {@link DeviceProvisionCallback#onError(Throwable)}.
   * <p>
   * Method under test:
   * {@link DeviceApiController.DeviceProvisionCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test DeviceProvisionCallback onError(Throwable)")
  void testDeviceProvisionCallbackOnError() {
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
   * Test DeviceProvisionCallback
   * {@link DeviceProvisionCallback#onError(Throwable)}.
   * <p>
   * Method under test:
   * {@link DeviceApiController.DeviceProvisionCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test DeviceProvisionCallback onError(Throwable)")
  void testDeviceProvisionCallbackOnError2() {
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
   * Test DeviceProvisionCallback
   * {@link DeviceProvisionCallback#onError(Throwable)}.
   * <ul>
   *   <li>Then calls {@link DeferredResult#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceApiController.DeviceProvisionCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test DeviceProvisionCallback onError(Throwable); then calls setResult(Object)")
  void testDeviceProvisionCallbackOnError_thenCallsSetResult() {
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
   * Test DeviceProvisionCallback
   * {@link DeviceProvisionCallback#onSuccess(ProvisionDeviceResponseMsg)} with
   * {@code ProvisionDeviceResponseMsg}.
   * <p>
   * Method under test:
   * {@link DeviceApiController.DeviceProvisionCallback#onSuccess(TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName("Test DeviceProvisionCallback onSuccess(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'")
  void testDeviceProvisionCallbackOnSuccessWithProvisionDeviceResponseMsg() {
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
   * Test {@link DeviceApiController#getName()}.
   * <p>
   * Method under test: {@link DeviceApiController#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("HTTP", (new DeviceApiController()).getName());
  }
}
