package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.rpc.RpcError;
import org.thingsboard.server.common.data.rpc.ToDeviceRpcRequestBody;
import org.thingsboard.server.common.msg.rpc.FromDeviceRpcResponse;
import org.thingsboard.server.common.msg.rpc.ToDeviceRpcRequest;
import org.thingsboard.server.dao.audit.AuditLogService;
import org.thingsboard.server.service.rpc.LocalRequestMetaData;
import org.thingsboard.server.service.security.model.SecurityUser;

@ExtendWith(MockitoExtension.class)
class AbstractRpcControllerDiffblueTest {
  @Mock private AuditLogService auditLogService;

  @InjectMocks private RpcV1Controller rpcV1Controller;

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult AbstractRpcController.handleDeviceRPCRequest(boolean, DeviceId, String, HttpStatus, HttpStatus)"
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

  /**
   * Test {@link AbstractRpcController#reply(LocalRequestMetaData, FromDeviceRpcResponse,
   * HttpStatus, HttpStatus)}.
   *
   * <p>Method under test: {@link AbstractRpcController#reply(LocalRequestMetaData,
   * FromDeviceRpcResponse, HttpStatus, HttpStatus)}
   */
  @Test
  @DisplayName("Test reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractRpcController.reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus)"
  })
  void testReply() {
    // Arrange
    when(auditLogService.logEntityAction(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<UserId>any(),
            Mockito.<String>any(),
            Mockito.<EntityId>any(),
            Mockito.<HasName>any(),
            Mockito.<ActionType>any(),
            Mockito.<Exception>any(),
            isA(Object[].class)))
        .thenThrow(new IllegalArgumentException());
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ToDeviceRpcRequest request =
        new ToDeviceRpcRequest(
            id,
            tenantId,
            null,
            false,
            1L,
            new ToDeviceRpcRequestBody("Method", "Params"),
            true,
            1,
            "Additional Info");
    SecurityUser user = new SecurityUser();

    LocalRequestMetaData rpcRequest =
        new LocalRequestMetaData(request, user, new DeferredResult<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            rpcV1Controller.reply(
                rpcRequest,
                new FromDeviceRpcResponse(
                    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                    "Response",
                    RpcError.NOT_FOUND),
                HttpStatus.CONTINUE,
                HttpStatus.CONTINUE));
    verify(auditLogService)
        .logEntityAction(
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            eq(ActionType.RPC_CALL),
            isNull(),
            isA(Object[].class));
  }

  /**
   * Test {@link AbstractRpcController#reply(LocalRequestMetaData, FromDeviceRpcResponse,
   * HttpStatus, HttpStatus)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link ToDeviceRpcRequest#getDeviceId()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRpcController#reply(LocalRequestMetaData,
   * FromDeviceRpcResponse, HttpStatus, HttpStatus)}
   */
  @Test
  @DisplayName(
      "Test reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus); given IllegalArgumentException(); then calls getDeviceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractRpcController.reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus)"
  })
  void testReply_givenIllegalArgumentException_thenCallsGetDeviceId() {
    // Arrange
    ToDeviceRpcRequest request = mock(ToDeviceRpcRequest.class);
    when(request.getDeviceId()).thenThrow(new IllegalArgumentException());
    SecurityUser user = new SecurityUser();

    LocalRequestMetaData rpcRequest =
        new LocalRequestMetaData(request, user, new DeferredResult<>());

    FromDeviceRpcResponse response = mock(FromDeviceRpcResponse.class);
    Optional<RpcError> emptyResult = Optional.empty();
    when(response.getError()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("42");
    when(response.getResponse()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            rpcV1Controller.reply(rpcRequest, response, HttpStatus.CONTINUE, HttpStatus.CONTINUE));
    verify(response).getError();
    verify(response).getResponse();
    verify(request, atLeast(1)).getDeviceId();
  }

  /**
   * Test {@link AbstractRpcController#reply(LocalRequestMetaData, FromDeviceRpcResponse,
   * HttpStatus, HttpStatus)}.
   *
   * <ul>
   *   <li>Given {@link Optional} with empty string.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRpcController#reply(LocalRequestMetaData,
   * FromDeviceRpcResponse, HttpStatus, HttpStatus)}
   */
  @Test
  @DisplayName(
      "Test reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus); given Optional with empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractRpcController.reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus)"
  })
  void testReply_givenOptionalWithEmptyString() {
    // Arrange
    ToDeviceRpcRequest request = mock(ToDeviceRpcRequest.class);
    when(request.getDeviceId()).thenThrow(new IllegalArgumentException());
    SecurityUser user = new SecurityUser();

    LocalRequestMetaData rpcRequest =
        new LocalRequestMetaData(request, user, new DeferredResult<>());

    FromDeviceRpcResponse response = mock(FromDeviceRpcResponse.class);
    Optional<RpcError> emptyResult = Optional.empty();
    when(response.getError()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("");
    when(response.getResponse()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            rpcV1Controller.reply(rpcRequest, response, HttpStatus.CONTINUE, HttpStatus.CONTINUE));
    verify(response).getError();
    verify(response).getResponse();
    verify(request).getDeviceId();
  }

  /**
   * Test {@link AbstractRpcController#reply(LocalRequestMetaData, FromDeviceRpcResponse,
   * HttpStatus, HttpStatus)}.
   *
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRpcController#reply(LocalRequestMetaData,
   * FromDeviceRpcResponse, HttpStatus, HttpStatus)}
   */
  @Test
  @DisplayName(
      "Test reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus); given TenantId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractRpcController.reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus)"
  })
  void testReply_givenTenantIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    when(auditLogService.logEntityAction(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<UserId>any(),
            Mockito.<String>any(),
            Mockito.<EntityId>any(),
            Mockito.<HasName>any(),
            Mockito.<ActionType>any(),
            Mockito.<Exception>any(),
            isA(Object[].class)))
        .thenThrow(new IllegalArgumentException());

    LocalRequestMetaData rpcRequest = mock(LocalRequestMetaData.class);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ToDeviceRpcRequest toDeviceRpcRequest =
        new ToDeviceRpcRequest(
            id,
            tenantId,
            null,
            true,
            1L,
            new ToDeviceRpcRequestBody("Method", "Params"),
            true,
            1,
            "Additional Info");
    when(rpcRequest.getRequest()).thenReturn(toDeviceRpcRequest);
    when(rpcRequest.getResponseWriter()).thenReturn(new DeferredResult<>());
    when(rpcRequest.getUser()).thenReturn(new SecurityUser());

    FromDeviceRpcResponse response = mock(FromDeviceRpcResponse.class);
    Optional<RpcError> emptyResult = Optional.empty();
    when(response.getError()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("42");
    when(response.getResponse()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            rpcV1Controller.reply(rpcRequest, response, HttpStatus.CONTINUE, HttpStatus.CONTINUE));
    verify(response).getError();
    verify(response).getResponse();
    verify(auditLogService, atLeast(1))
        .logEntityAction(
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            eq(ActionType.RPC_CALL),
            isNull(),
            isA(Object[].class));
    verify(rpcRequest, atLeast(1)).getRequest();
    verify(rpcRequest).getResponseWriter();
    verify(rpcRequest, atLeast(1)).getUser();
  }

  /**
   * Test {@link AbstractRpcController#reply(LocalRequestMetaData, FromDeviceRpcResponse,
   * HttpStatus, HttpStatus)}.
   *
   * <ul>
   *   <li>Given {@link ToDeviceRpcRequest} {@link ToDeviceRpcRequest#getDeviceId()} return {@code
   *       null}.
   *   <li>Then calls {@link ToDeviceRpcRequest#getBody()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRpcController#reply(LocalRequestMetaData,
   * FromDeviceRpcResponse, HttpStatus, HttpStatus)}
   */
  @Test
  @DisplayName(
      "Test reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus); given ToDeviceRpcRequest getDeviceId() return 'null'; then calls getBody()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractRpcController.reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus)"
  })
  void testReply_givenToDeviceRpcRequestGetDeviceIdReturnNull_thenCallsGetBody() {
    // Arrange
    when(auditLogService.logEntityAction(
            Mockito.<TenantId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<UserId>any(),
            Mockito.<String>any(),
            Mockito.<EntityId>any(),
            Mockito.<HasName>any(),
            Mockito.<ActionType>any(),
            Mockito.<Exception>any(),
            isA(Object[].class)))
        .thenThrow(new IllegalArgumentException());

    ToDeviceRpcRequest toDeviceRpcRequest = mock(ToDeviceRpcRequest.class);
    when(toDeviceRpcRequest.getDeviceId()).thenReturn(null);
    when(toDeviceRpcRequest.isOneway()).thenReturn(true);
    when(toDeviceRpcRequest.getBody()).thenReturn(new ToDeviceRpcRequestBody("Method", "Params"));

    LocalRequestMetaData rpcRequest = mock(LocalRequestMetaData.class);
    when(rpcRequest.getRequest()).thenReturn(toDeviceRpcRequest);
    when(rpcRequest.getResponseWriter()).thenReturn(new DeferredResult<>());
    when(rpcRequest.getUser()).thenReturn(new SecurityUser());

    FromDeviceRpcResponse response = mock(FromDeviceRpcResponse.class);
    Optional<RpcError> emptyResult = Optional.empty();
    when(response.getError()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("42");
    when(response.getResponse()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            rpcV1Controller.reply(rpcRequest, response, HttpStatus.CONTINUE, HttpStatus.CONTINUE));
    verify(response).getError();
    verify(response).getResponse();
    verify(toDeviceRpcRequest, atLeast(1)).getBody();
    verify(toDeviceRpcRequest, atLeast(1)).getDeviceId();
    verify(toDeviceRpcRequest, atLeast(1)).isOneway();
    verify(auditLogService, atLeast(1))
        .logEntityAction(
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            eq(ActionType.RPC_CALL),
            isNull(),
            isA(Object[].class));
    verify(rpcRequest, atLeast(1)).getRequest();
    verify(rpcRequest).getResponseWriter();
    verify(rpcRequest, atLeast(1)).getUser();
  }

  /**
   * Test {@link AbstractRpcController#reply(LocalRequestMetaData, FromDeviceRpcResponse,
   * HttpStatus, HttpStatus)}.
   *
   * <ul>
   *   <li>When {@link FromDeviceRpcResponse} {@link FromDeviceRpcResponse#getResponse()} return
   *       empty.
   *   <li>Then calls {@link ToDeviceRpcRequest#getDeviceId()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRpcController#reply(LocalRequestMetaData,
   * FromDeviceRpcResponse, HttpStatus, HttpStatus)}
   */
  @Test
  @DisplayName(
      "Test reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus); when FromDeviceRpcResponse getResponse() return empty; then calls getDeviceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractRpcController.reply(LocalRequestMetaData, FromDeviceRpcResponse, HttpStatus, HttpStatus)"
  })
  void testReply_whenFromDeviceRpcResponseGetResponseReturnEmpty_thenCallsGetDeviceId() {
    // Arrange
    ToDeviceRpcRequest request = mock(ToDeviceRpcRequest.class);
    when(request.getDeviceId()).thenThrow(new IllegalArgumentException());
    SecurityUser user = new SecurityUser();

    LocalRequestMetaData rpcRequest =
        new LocalRequestMetaData(request, user, new DeferredResult<>());

    FromDeviceRpcResponse response = mock(FromDeviceRpcResponse.class);
    Optional<RpcError> emptyResult = Optional.empty();
    when(response.getError()).thenReturn(emptyResult);
    Optional<String> emptyResult2 = Optional.empty();
    when(response.getResponse()).thenReturn(emptyResult2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            rpcV1Controller.reply(rpcRequest, response, HttpStatus.CONTINUE, HttpStatus.CONTINUE));
    verify(response).getError();
    verify(response).getResponse();
    verify(request).getDeviceId();
  }
}
