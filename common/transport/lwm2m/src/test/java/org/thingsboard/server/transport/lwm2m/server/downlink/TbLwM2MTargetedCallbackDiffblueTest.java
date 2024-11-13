package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.eclipse.leshan.core.request.DeleteRequest;
import org.eclipse.leshan.core.response.DeleteResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;

class TbLwM2MTargetedCallbackDiffblueTest {
  /**
   * Test {@link TbLwM2MTargetedCallback#onSuccess(Object, Object)}.
   * <p>
   * Method under test: {@link TbLwM2MTargetedCallback#onSuccess(Object, Object)}
   */
  @Test
  @DisplayName("Test onSuccess(Object, Object)")
  void testOnSuccess() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MDeleteCallback tbLwM2MDeleteCallback = new TbLwM2MDeleteCallback(logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null);
    DeleteRequest deleteRequest = new DeleteRequest(1, 1);

    // Act
    tbLwM2MDeleteCallback.onSuccess(deleteRequest, DeleteResponse.methodNotAllowed());

    // Assert
    verify(logService).log(isA(LwM2mClient.class), eq(
        "[error]: DeleteRequest [null] failed to process successful. Result: DeleteResponse [code=METHOD_NOT_ALLOWED(405)]"));
  }

  /**
   * Test {@link TbLwM2MTargetedCallback#onSuccess(Object, Object)}.
   * <p>
   * Method under test: {@link TbLwM2MTargetedCallback#onSuccess(Object, Object)}
   */
  @Test
  @DisplayName("Test onSuccess(Object, Object)")
  void testOnSuccess2() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MDeleteCallback tbLwM2MDeleteCallback = new TbLwM2MDeleteCallback(logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null);
    DeleteRequest deleteRequest = new DeleteRequest(1, 1);

    // Act
    tbLwM2MDeleteCallback.onSuccess(deleteRequest, DeleteResponse.success());

    // Assert
    verify(logService).log(isA(LwM2mClient.class),
        eq("[info]: DeleteRequest [null] successful. Result: DeleteResponse [code=DELETED(202)]"));
  }

  /**
   * Test {@link TbLwM2MTargetedCallback#onSuccess(Object, Object)}.
   * <ul>
   *   <li>Then calls
   * {@link LwM2MTelemetryLogService#log(LwM2mClient, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2MTargetedCallback#onSuccess(Object, Object)}
   */
  @Test
  @DisplayName("Test onSuccess(Object, Object); then calls log(LwM2mClient, String)")
  void testOnSuccess_thenCallsLog() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MDeleteCallback tbLwM2MDeleteCallback = new TbLwM2MDeleteCallback(logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");
    DeleteRequest deleteRequest = new DeleteRequest(1, 1);

    // Act
    tbLwM2MDeleteCallback.onSuccess(deleteRequest, DeleteResponse.methodNotAllowed());

    // Assert
    verify(logService).log(isA(LwM2mClient.class), eq(
        "[error]: DeleteRequest [42] failed to process successful. Result: DeleteResponse [code=METHOD_NOT_ALLOWED(405)]"));
  }

  /**
   * Test {@link TbLwM2MTargetedCallback#onSuccess(Object, Object)}.
   * <ul>
   *   <li>When success.</li>
   *   <li>Then calls
   * {@link LwM2MTelemetryLogService#log(LwM2mClient, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2MTargetedCallback#onSuccess(Object, Object)}
   */
  @Test
  @DisplayName("Test onSuccess(Object, Object); when success; then calls log(LwM2mClient, String)")
  void testOnSuccess_whenSuccess_thenCallsLog() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MDeleteCallback tbLwM2MDeleteCallback = new TbLwM2MDeleteCallback(logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42");
    DeleteRequest deleteRequest = new DeleteRequest(1, 1);

    // Act
    tbLwM2MDeleteCallback.onSuccess(deleteRequest, DeleteResponse.success());

    // Assert
    verify(logService).log(isA(LwM2mClient.class),
        eq("[info]: DeleteRequest [42] successful. Result: DeleteResponse [code=DELETED(202)]"));
  }

  /**
   * Test {@link TbLwM2MTargetedCallback#logForBadResponse(int, String, String)}.
   * <p>
   * Method under test:
   * {@link TbLwM2MTargetedCallback#logForBadResponse(int, String, String)}
   */
  @Test
  @DisplayName("Test logForBadResponse(int, String, String)")
  void testLogForBadResponse() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    (new TbLwM2MDeleteCallback(logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), "42"))
        .logForBadResponse(1, "Response Str", "Request Name");

    // Assert
    verify(logService).log(isA(LwM2mClient.class), eq("[info]: Request Name [42] successful. Result: Response Str"));
  }

  /**
   * Test {@link TbLwM2MTargetedCallback#logForBadResponse(int, String, String)}.
   * <p>
   * Method under test:
   * {@link TbLwM2MTargetedCallback#logForBadResponse(int, String, String)}
   */
  @Test
  @DisplayName("Test logForBadResponse(int, String, String)")
  void testLogForBadResponse2() {
    // Arrange
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    // Act
    (new TbLwM2MDeleteCallback(logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"), null))
        .logForBadResponse(1, "Response Str", "Request Name");

    // Assert
    verify(logService).log(isA(LwM2mClient.class), eq("[info]: Request Name [null] successful. Result: Response Str"));
  }
}
