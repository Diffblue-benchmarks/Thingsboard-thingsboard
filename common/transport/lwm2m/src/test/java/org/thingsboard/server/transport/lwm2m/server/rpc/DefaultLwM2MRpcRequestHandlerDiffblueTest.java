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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.downlink.LwM2mDownlinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mUplinkMsgHandler;

class DefaultLwM2MRpcRequestHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testOnToDeviceRpcRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    DefaultLwM2MRpcRequestHandler defaultLwM2MRpcRequestHandler = new DefaultLwM2MRpcRequestHandler(transportService,
        mock(LwM2mClientContext.class), mock(LwM2mUplinkMsgHandler.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));
    TransportProtos.ToDeviceRpcRequestMsg rpcRequest = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();

    // Act
    defaultLwM2MRpcRequestHandler.onToDeviceRpcRequest(rpcRequest,
        TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testOnToDeviceRpcRequest2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doThrow(new IllegalArgumentException("Received params: {}")).when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    DefaultLwM2MRpcRequestHandler defaultLwM2MRpcRequestHandler = new DefaultLwM2MRpcRequestHandler(transportService,
        mock(LwM2mClientContext.class), mock(LwM2mUplinkMsgHandler.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));
    TransportProtos.ToDeviceRpcRequestMsg rpcRequest = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultLwM2MRpcRequestHandler.onToDeviceRpcRequest(rpcRequest,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(transportService, atLeast(1)).process(isA(TransportProtos.SessionInfoProto.class),
        Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(), (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testOnToDeviceRpcRequest3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doThrow(new IllegalArgumentException("Read")).when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    DefaultLwM2MRpcRequestHandler defaultLwM2MRpcRequestHandler = new DefaultLwM2MRpcRequestHandler(transportService,
        mock(LwM2mClientContext.class), mock(LwM2mUplinkMsgHandler.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));
    TransportProtos.ToDeviceRpcRequestMsg rpcRequest = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultLwM2MRpcRequestHandler.onToDeviceRpcRequest(rpcRequest,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(transportService, atLeast(1)).process(isA(TransportProtos.SessionInfoProto.class),
        Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(), (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcResponse(TransportProtos.ToDeviceRpcResponseMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testOnToDeviceRpcResponse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    DefaultLwM2MRpcRequestHandler defaultLwM2MRpcRequestHandler = new DefaultLwM2MRpcRequestHandler(transportService,
        mock(LwM2mClientContext.class), mock(LwM2mUplinkMsgHandler.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));
    TransportProtos.ToDeviceRpcResponseMsg toDeviceResponse = TransportProtos.ToDeviceRpcResponseMsg
        .getDefaultInstance();

    // Act
    defaultLwM2MRpcRequestHandler.onToDeviceRpcResponse(toDeviceResponse,
        TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcResponse(TransportProtos.ToDeviceRpcResponseMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testOnToDeviceRpcResponse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doThrow(new IllegalArgumentException("OnToDeviceRpcResponse: [{}], sessionUUID: [{}]")).when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    DefaultLwM2MRpcRequestHandler defaultLwM2MRpcRequestHandler = new DefaultLwM2MRpcRequestHandler(transportService,
        mock(LwM2mClientContext.class), mock(LwM2mUplinkMsgHandler.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));
    TransportProtos.ToDeviceRpcResponseMsg toDeviceResponse = TransportProtos.ToDeviceRpcResponseMsg
        .getDefaultInstance();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultLwM2MRpcRequestHandler
        .onToDeviceRpcResponse(toDeviceResponse, TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
  }
}
