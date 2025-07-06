package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.DeviceId;

class AbstractRpcControllerDiffblueTest {
  /**
   * Test {@link AbstractRpcController#handleDeviceRPCRequest(boolean, DeviceId, String, HttpStatus,
   * HttpStatus)}.
   *
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRpcController#handleDeviceRPCRequest(boolean, DeviceId,
   * String, HttpStatus, HttpStatus)}
   */
  @Test
  @DisplayName(
      "Test handleDeviceRPCRequest(boolean, DeviceId, String, HttpStatus, HttpStatus); then throw ThingsboardException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult AbstractRpcController.handleDeviceRPCRequest(boolean, DeviceId, String, HttpStatus, HttpStatus)"
  })
  void testHandleDeviceRPCRequest_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new RpcV1Controller()
                .handleDeviceRPCRequest(
                    true,
                    null,
                    "Not all who wander are lost",
                    HttpStatus.CONTINUE,
                    HttpStatus.CONTINUE));
  }
}
