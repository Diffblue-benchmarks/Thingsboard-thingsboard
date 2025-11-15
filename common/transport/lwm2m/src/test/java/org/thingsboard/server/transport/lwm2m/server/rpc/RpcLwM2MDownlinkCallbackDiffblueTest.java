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
package org.thingsboard.server.transport.lwm2m.server.rpc;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.concurrent.CountDownLatch;
import org.eclipse.leshan.core.request.LwM2mRequest;
import org.eclipse.leshan.core.response.CreateResponse;
import org.eclipse.leshan.core.response.LwM2mResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MLatchCallback;

class RpcLwM2MDownlinkCallbackDiffblueTest {
  /**
   * Method under test:
   * {@link RpcLwM2MDownlinkCallback#sendRpcReplyOnSuccess(LwM2mResponse)}
   */
  @Test
  void testSendRpcReplyOnSuccess() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TransportProtos.ToDeviceRpcRequestMsg requestMsg = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();
    RpcCreateResponseCallback<LwM2mRequest<CreateResponse>, CreateResponse> rpcCreateResponseCallback = new RpcCreateResponseCallback<>(
        transportService, client, requestMsg, new TbLwM2MLatchCallback<>(new CountDownLatch(1), null));

    // Act
    rpcCreateResponseCallback.sendRpcReplyOnSuccess(CreateResponse.methodNotAllowed());

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Method under test:
   * {@link RpcLwM2MDownlinkCallback#sendRpcReplyOnSuccess(LwM2mResponse)}
   */
  @Test
  void testSendRpcReplyOnSuccess2() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TransportProtos.ToDeviceRpcRequestMsg requestMsg = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();
    RpcCreateResponseCallback<LwM2mRequest<CreateResponse>, CreateResponse> rpcCreateResponseCallback = new RpcCreateResponseCallback<>(
        transportService, client, requestMsg, new TbLwM2MLatchCallback<>(new CountDownLatch(1), null));

    // Act
    rpcCreateResponseCallback.sendRpcReplyOnSuccess(CreateResponse.success());

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
  }
}
