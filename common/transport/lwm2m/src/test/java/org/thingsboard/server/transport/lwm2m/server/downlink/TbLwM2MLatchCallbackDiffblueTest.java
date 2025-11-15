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
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.rpc.RpcStatus;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.rpc.RpcLinkSetCallback;

class TbLwM2MLatchCallbackDiffblueTest {
  /**
   * Method under test: {@link TbLwM2MLatchCallback#onSuccess(Object, Object)}
   */
  @Test
  void testOnSuccess() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcRequestMsg>any(),
            Mockito.<RpcStatus>any(), anyBoolean(), Mockito.<TransportServiceCallback<Void>>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    RpcLinkSetCallback<Object, Object> callback = new RpcLinkSetCallback<>(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), null);

    TbLwM2MLatchCallback<Object, Object> tbLwM2MLatchCallback = new TbLwM2MLatchCallback<>(new CountDownLatch(1),
        callback);

    // Act
    tbLwM2MLatchCallback.onSuccess("Request", "Response");

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcRequestMsg.class), eq(RpcStatus.DELIVERED), eq(true),
        isA(TransportServiceCallback.class));
  }

  /**
   * Method under test: {@link TbLwM2MLatchCallback#onSuccess(Object, Object)}
   */
  @Test
  void testOnSuccess2() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcRequestMsg>any(),
            Mockito.<RpcStatus>any(), anyBoolean(), Mockito.<TransportServiceCallback<Void>>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    DefaultTransportService transportService2 = mock(DefaultTransportService.class);
    doNothing().when(transportService2)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcRequestMsg>any(),
            Mockito.<RpcStatus>any(), anyBoolean(), Mockito.<TransportServiceCallback<Void>>any());
    doNothing().when(transportService2)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    RpcLinkSetCallback<Object, Object> callback = new RpcLinkSetCallback<>(transportService2, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), null);

    TbLwM2MLatchCallback<Object, Object> callback2 = new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback);

    LwM2mClient client2 = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    RpcLinkSetCallback<Object, Object> callback3 = new RpcLinkSetCallback<>(transportService, client2,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback2);

    TbLwM2MLatchCallback<Object, Object> tbLwM2MLatchCallback = new TbLwM2MLatchCallback<>(new CountDownLatch(1),
        callback3);

    // Act
    tbLwM2MLatchCallback.onSuccess("Request", "Response");

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(transportService2).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcRequestMsg.class), eq(RpcStatus.DELIVERED), eq(true),
        isA(TransportServiceCallback.class));
    verify(transportService2).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcRequestMsg.class), eq(RpcStatus.DELIVERED), eq(true),
        isA(TransportServiceCallback.class));
  }

  /**
   * Method under test:
   * {@link TbLwM2MLatchCallback#onValidationError(String, String)}
   */
  @Test
  void testOnValidationError() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    RpcLinkSetCallback<Object, Object> callback = new RpcLinkSetCallback<>(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), null);

    TbLwM2MLatchCallback<Object, Object> tbLwM2MLatchCallback = new TbLwM2MLatchCallback<>(new CountDownLatch(1),
        callback);

    // Act
    tbLwM2MLatchCallback.onValidationError("Params", "Msg");

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Method under test:
   * {@link TbLwM2MLatchCallback#onValidationError(String, String)}
   */
  @Test
  void testOnValidationError2() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    DefaultTransportService transportService2 = mock(DefaultTransportService.class);
    doNothing().when(transportService2)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    RpcLinkSetCallback<Object, Object> callback = new RpcLinkSetCallback<>(transportService2, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), null);

    TbLwM2MLatchCallback<Object, Object> callback2 = new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback);

    LwM2mClient client2 = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    RpcLinkSetCallback<Object, Object> callback3 = new RpcLinkSetCallback<>(transportService, client2,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback2);

    TbLwM2MLatchCallback<Object, Object> tbLwM2MLatchCallback = new TbLwM2MLatchCallback<>(new CountDownLatch(1),
        callback3);

    // Act
    tbLwM2MLatchCallback.onValidationError("Params", "Msg");

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(transportService2).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Method under test: {@link TbLwM2MLatchCallback#onError(String, Exception)}
   */
  @Test
  void testOnError() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    RpcLinkSetCallback<Object, Object> callback = new RpcLinkSetCallback<>(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), null);

    TbLwM2MLatchCallback<Object, Object> tbLwM2MLatchCallback = new TbLwM2MLatchCallback<>(new CountDownLatch(1),
        callback);

    // Act
    tbLwM2MLatchCallback.onError("Params", new Exception("foo"));

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Method under test: {@link TbLwM2MLatchCallback#onError(String, Exception)}
   */
  @Test
  void testOnError2() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    TransportService transportService2 = mock(TransportService.class);
    doNothing().when(transportService2)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    RpcLinkSetCallback<Object, Object> callback = new RpcLinkSetCallback<>(transportService2, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), null);

    TbLwM2MLatchCallback<Object, Object> callback2 = new TbLwM2MLatchCallback<>(new CountDownLatch(1), callback);

    LwM2mClient client2 = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    RpcLinkSetCallback<Object, Object> callback3 = new RpcLinkSetCallback<>(transportService, client2,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback2);

    TbLwM2MLatchCallback<Object, Object> tbLwM2MLatchCallback = new TbLwM2MLatchCallback<>(new CountDownLatch(1),
        callback3);

    // Act
    tbLwM2MLatchCallback.onError("Params", new Exception("foo"));

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(transportService2).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
  }
}
