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
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcResponseMsg;

@ExtendWith(MockitoExtension.class)
class DefaultLwM2MRpcRequestHandlerDiffblueTest {
  @InjectMocks private DefaultLwM2MRpcRequestHandler defaultLwM2MRpcRequestHandler;

  @Mock private TransportService transportService;

  /**
   * Test {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(ToDeviceRpcRequestMsg,
   * SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given {@link TransportService} {@link TransportService#process(SessionInfoProto,
   *       ToDeviceRpcResponseMsg, TransportServiceCallback)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(TransportProtos.ToDeviceRpcRequestMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onToDeviceRpcRequest(ToDeviceRpcRequestMsg, SessionInfoProto); given TransportService process(SessionInfoProto, ToDeviceRpcResponseMsg, TransportServiceCallback) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MRpcRequestHandler.onToDeviceRpcRequest(TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnToDeviceRpcRequest_givenTransportServiceProcessDoesNothing() {
    // Arrange
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    // Act
    defaultLwM2MRpcRequestHandler.onToDeviceRpcRequest(
        ToDeviceRpcRequestMsg.getDefaultInstance(), SessionInfoProto.getDefaultInstance());

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(ToDeviceRpcResponseMsg.class),
            (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Test {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(ToDeviceRpcRequestMsg,
   * SessionInfoProto)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(TransportProtos.ToDeviceRpcRequestMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onToDeviceRpcRequest(ToDeviceRpcRequestMsg, SessionInfoProto); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MRpcRequestHandler.onToDeviceRpcRequest(TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnToDeviceRpcRequest_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultLwM2MRpcRequestHandler.onToDeviceRpcRequest(
                ToDeviceRpcRequestMsg.getDefaultInstance(), SessionInfoProto.getDefaultInstance()));
    verify(transportService, atLeast(1))
        .process(
            isA(SessionInfoProto.class),
            Mockito.<ToDeviceRpcResponseMsg>any(),
            (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Test {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(ToDeviceRpcRequestMsg,
   * SessionInfoProto)}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(TransportProtos.ToDeviceRpcRequestMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onToDeviceRpcRequest(ToDeviceRpcRequestMsg, SessionInfoProto); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MRpcRequestHandler.onToDeviceRpcRequest(TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnToDeviceRpcRequest_thenThrowNumberFormatException() {
    // Arrange
    doThrow(new NumberFormatException())
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () ->
            defaultLwM2MRpcRequestHandler.onToDeviceRpcRequest(
                ToDeviceRpcRequestMsg.getDefaultInstance(), SessionInfoProto.getDefaultInstance()));
    verify(transportService, atLeast(1))
        .process(
            isA(SessionInfoProto.class),
            Mockito.<ToDeviceRpcResponseMsg>any(),
            (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Test {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcResponse(ToDeviceRpcResponseMsg,
   * SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link TransportProtos.SessionInfoProto#getSessionIdLSB()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MRpcRequestHandler#onToDeviceRpcResponse(ToDeviceRpcResponseMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onToDeviceRpcResponse(ToDeviceRpcResponseMsg, SessionInfoProto); given one; then calls getSessionIdLSB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MRpcRequestHandler.onToDeviceRpcResponse(ToDeviceRpcResponseMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnToDeviceRpcResponse_givenOne_thenCallsGetSessionIdLSB() {
    // Arrange
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    ToDeviceRpcResponseMsg toDeviceResponse = ToDeviceRpcResponseMsg.getDefaultInstance();

    SessionInfoProto sessionInfo = mock(SessionInfoProto.class);
    when(sessionInfo.getSessionIdLSB()).thenReturn(1L);
    when(sessionInfo.getSessionIdMSB()).thenReturn(1L);

    // Act
    defaultLwM2MRpcRequestHandler.onToDeviceRpcResponse(toDeviceResponse, sessionInfo);

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(ToDeviceRpcResponseMsg.class),
            (TransportServiceCallback<Void>) isNull());
    verify(sessionInfo).getSessionIdLSB();
    verify(sessionInfo).getSessionIdMSB();
  }

  /**
   * Test {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcResponse(ToDeviceRpcResponseMsg,
   * SessionInfoProto)}.
   *
   * <ul>
   *   <li>Then calls {@link TransportService#process(SessionInfoProto, ToDeviceRpcResponseMsg,
   *       TransportServiceCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MRpcRequestHandler#onToDeviceRpcResponse(ToDeviceRpcResponseMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onToDeviceRpcResponse(ToDeviceRpcResponseMsg, SessionInfoProto); then calls process(SessionInfoProto, ToDeviceRpcResponseMsg, TransportServiceCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MRpcRequestHandler.onToDeviceRpcResponse(ToDeviceRpcResponseMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnToDeviceRpcResponse_thenCallsProcess() {
    // Arrange
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    // Act
    defaultLwM2MRpcRequestHandler.onToDeviceRpcResponse(
        ToDeviceRpcResponseMsg.getDefaultInstance(), SessionInfoProto.getDefaultInstance());

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(ToDeviceRpcResponseMsg.class),
            (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Test {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcResponse(ToDeviceRpcResponseMsg,
   * SessionInfoProto)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MRpcRequestHandler#onToDeviceRpcResponse(ToDeviceRpcResponseMsg,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test onToDeviceRpcResponse(ToDeviceRpcResponseMsg, SessionInfoProto); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MRpcRequestHandler.onToDeviceRpcResponse(ToDeviceRpcResponseMsg, TransportProtos.SessionInfoProto)"
  })
  void testOnToDeviceRpcResponse_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultLwM2MRpcRequestHandler.onToDeviceRpcResponse(
                ToDeviceRpcResponseMsg.getDefaultInstance(),
                SessionInfoProto.getDefaultInstance()));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(ToDeviceRpcResponseMsg.class),
            (TransportServiceCallback<Void>) isNull());
  }
}
