package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.rpc.RpcError;
import org.thingsboard.server.common.msg.rpc.FromDeviceRpcResponse;
import org.thingsboard.server.common.msg.rpc.ToDeviceRpcRequest;
import org.thingsboard.server.service.rpc.LocalRequestMetaData;
import org.thingsboard.server.service.security.model.SecurityUser;

class AbstractRpcControllerDiffblueTest {
  /**
   * Test
   * {@link AbstractRpcController#handleDeviceRPCRequest(boolean, DeviceId, String, HttpStatus, HttpStatus)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractRpcController#handleDeviceRPCRequest(boolean, DeviceId, String, HttpStatus, HttpStatus)}
   */
  @Test
  @DisplayName("Test handleDeviceRPCRequest(boolean, DeviceId, String, HttpStatus, HttpStatus); when 'null'; then throw ThingsboardException")
  void testHandleDeviceRPCRequest_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> (new RpcV1Controller()).handleDeviceRPCRequest(true, null,
        "Not all who wander are lost", HttpStatus.CONTINUE, HttpStatus.CONTINUE));
  }

  /**
   * Test
   * {@link AbstractRpcController#reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus)}.
   * <ul>
   *   <li>Given {@link Optional} with empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractRpcController#reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus)}
   */
  @Test
  @DisplayName("Test reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus); given Optional with empty string")
  void testReply_givenOptionalWithEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RpcV1Controller rpcV1Controller = new RpcV1Controller();
    new IllegalArgumentException("foo");
    new IllegalArgumentException("foo");
    new IllegalArgumentException("foo");
    ToDeviceRpcRequest toDeviceRpcRequest = mock(ToDeviceRpcRequest.class);
    when(toDeviceRpcRequest.getDeviceId()).thenThrow(new IllegalArgumentException("foo"));
    LocalRequestMetaData rpcRequest = mock(LocalRequestMetaData.class);
    when(rpcRequest.getResponseWriter()).thenReturn(new DeferredResult<>());
    when(rpcRequest.getRequest()).thenReturn(toDeviceRpcRequest);
    when(rpcRequest.getUser()).thenReturn(new SecurityUser());
    FromDeviceRpcResponse response = mock(FromDeviceRpcResponse.class);
    Optional<RpcError> emptyResult = Optional.empty();
    when(response.getError()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("");
    when(response.getResponse()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> rpcV1Controller.reply(rpcRequest, response, HttpStatus.CONTINUE, HttpStatus.CONTINUE));
    verify(response).getError();
    verify(response).getResponse();
    verify(toDeviceRpcRequest).getDeviceId();
    verify(rpcRequest).getRequest();
    verify(rpcRequest).getResponseWriter();
    verify(rpcRequest).getUser();
  }

  /**
   * Test
   * {@link AbstractRpcController#reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractRpcController#reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus)}
   */
  @Test
  @DisplayName("Test reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus); given Optional with 'foo'")
  void testReply_givenOptionalWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RpcV1Controller rpcV1Controller = new RpcV1Controller();
    ToDeviceRpcRequest request = mock(ToDeviceRpcRequest.class);
    when(request.getDeviceId()).thenThrow(new IllegalArgumentException("foo"));
    SecurityUser user = new SecurityUser();
    LocalRequestMetaData rpcRequest = new LocalRequestMetaData(request, user, new DeferredResult<>());

    FromDeviceRpcResponse response = mock(FromDeviceRpcResponse.class);
    Optional<RpcError> emptyResult = Optional.empty();
    when(response.getError()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(response.getResponse()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> rpcV1Controller.reply(rpcRequest, response, HttpStatus.CONTINUE, HttpStatus.CONTINUE));
    verify(response).getError();
    verify(response).getResponse();
    verify(request, atLeast(1)).getDeviceId();
  }

  /**
   * Test
   * {@link AbstractRpcController#reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus)}.
   * <ul>
   *   <li>When {@link FromDeviceRpcResponse}
   * {@link FromDeviceRpcResponse#getResponse()} return empty.</li>
   *   <li>Then calls {@link LocalRequestMetaData#getRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractRpcController#reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus)}
   */
  @Test
  @DisplayName("Test reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus); when FromDeviceRpcResponse getResponse() return empty; then calls getRequest()")
  void testReply_whenFromDeviceRpcResponseGetResponseReturnEmpty_thenCallsGetRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RpcV1Controller rpcV1Controller = new RpcV1Controller();
    new IllegalArgumentException("foo");
    new IllegalArgumentException("foo");
    new IllegalArgumentException("foo");
    ToDeviceRpcRequest toDeviceRpcRequest = mock(ToDeviceRpcRequest.class);
    when(toDeviceRpcRequest.getDeviceId()).thenThrow(new IllegalArgumentException("foo"));
    LocalRequestMetaData rpcRequest = mock(LocalRequestMetaData.class);
    when(rpcRequest.getResponseWriter()).thenReturn(new DeferredResult<>());
    when(rpcRequest.getRequest()).thenReturn(toDeviceRpcRequest);
    when(rpcRequest.getUser()).thenReturn(new SecurityUser());
    FromDeviceRpcResponse response = mock(FromDeviceRpcResponse.class);
    Optional<RpcError> emptyResult = Optional.empty();
    when(response.getError()).thenReturn(emptyResult);
    Optional<String> emptyResult2 = Optional.empty();
    when(response.getResponse()).thenReturn(emptyResult2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> rpcV1Controller.reply(rpcRequest, response, HttpStatus.CONTINUE, HttpStatus.CONTINUE));
    verify(response).getError();
    verify(response).getResponse();
    verify(toDeviceRpcRequest).getDeviceId();
    verify(rpcRequest).getRequest();
    verify(rpcRequest).getResponseWriter();
    verify(rpcRequest).getUser();
  }
}
