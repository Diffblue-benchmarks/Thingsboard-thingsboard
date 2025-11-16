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
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.leshan.core.request.WriteRequest;
import org.eclipse.leshan.core.response.WriteResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mUplinkMsgHandler;

class TbLwM2MWriteResponseCallbackDiffblueTest {
  /**
   * Test {@link TbLwM2MWriteResponseCallback#onSuccess(WriteRequest, WriteResponse)} with {@code
   * WriteRequest}, {@code WriteResponse}.
   *
   * <ul>
   *   <li>Then calls {@link LwM2MTelemetryLogService#log(LwM2mClient, String)}.
   * </ul>
   *
   * <p>Method under test: {@link TbLwM2MWriteResponseCallback#onSuccess(WriteRequest,
   * WriteResponse)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(WriteRequest, WriteResponse) with 'WriteRequest', 'WriteResponse'; then calls log(LwM2mClient, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2MWriteResponseCallback.onSuccess(WriteRequest, WriteResponse)"})
  void testOnSuccessWithWriteRequestWriteResponse_thenCallsLog() {
    // Arrange
    LwM2mUplinkMsgHandler handler = mock(LwM2mUplinkMsgHandler.class);
    doNothing()
        .when(handler)
        .onWriteResponseOk(
            Mockito.<LwM2mClient>any(),
            Mockito.<String>any(),
            Mockito.<WriteRequest>any(),
            anyInt());

    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());

    TbLwM2MWriteResponseCallback tbLwM2MWriteResponseCallback =
        new TbLwM2MWriteResponseCallback(
            handler,
            logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"),
            "42");
    WriteRequest request = new WriteRequest(1, 1, 1, 10.0d);

    // Act
    tbLwM2MWriteResponseCallback.onSuccess(request, WriteResponse.methodNotAllowed());

    // Assert
    verify(logService)
        .log(
            isA(LwM2mClient.class),
            eq(
                "[error]: WriteRequest [42] failed to process successful. Result: WriteResponse [code=METHOD_NOT_ALLOWED(405)]"));
    verify(handler)
        .onWriteResponseOk(isA(LwM2mClient.class), eq("42"), isA(WriteRequest.class), eq(405));
  }
}
