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
import org.eclipse.leshan.core.request.DeleteRequest;
import org.eclipse.leshan.core.response.DeleteResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;

class TbLwM2MTargetedCallbackDiffblueTest {
  /**
   * Method under test: {@link TbLwM2MTargetedCallback#onSuccess(Object, Object)}
   */
  @Test
  void testOnSuccess() {
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
   * Method under test: {@link TbLwM2MTargetedCallback#onSuccess(Object, Object)}
   */
  @Test
  void testOnSuccess2() {
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
   * Method under test: {@link TbLwM2MTargetedCallback#onSuccess(Object, Object)}
   */
  @Test
  void testOnSuccess3() {
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
   * Method under test: {@link TbLwM2MTargetedCallback#onSuccess(Object, Object)}
   */
  @Test
  void testOnSuccess4() {
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
   * Method under test:
   * {@link TbLwM2MTargetedCallback#logForBadResponse(int, String, String)}
   */
  @Test
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
   * Method under test:
   * {@link TbLwM2MTargetedCallback#logForBadResponse(int, String, String)}
   */
  @Test
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
