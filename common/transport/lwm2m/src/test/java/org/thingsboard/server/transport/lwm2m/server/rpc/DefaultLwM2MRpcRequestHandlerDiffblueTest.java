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
import org.junit.jupiter.api.DisplayName;
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
   * Test
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(ToDeviceRpcRequestMsg, SessionInfoProto)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test onToDeviceRpcRequest(ToDeviceRpcRequestMsg, SessionInfoProto)")
  void testOnToDeviceRpcRequest() {
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
   * Test
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(ToDeviceRpcRequestMsg, SessionInfoProto)}.
   * <p>
   * Method under test:
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test onToDeviceRpcRequest(ToDeviceRpcRequestMsg, SessionInfoProto)")
  void testOnToDeviceRpcRequest2() {
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
   * Test
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(ToDeviceRpcRequestMsg, SessionInfoProto)}.
   * <ul>
   *   <li>Given {@link TransportService}
   * {@link TransportService#process(SessionInfoProto, ToDeviceRpcResponseMsg, TransportServiceCallback)}
   * does nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcRequest(TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test onToDeviceRpcRequest(ToDeviceRpcRequestMsg, SessionInfoProto); given TransportService process(SessionInfoProto, ToDeviceRpcResponseMsg, TransportServiceCallback) does nothing")
  void testOnToDeviceRpcRequest_givenTransportServiceProcessDoesNothing() {
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
   * Test
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcResponse(ToDeviceRpcResponseMsg, SessionInfoProto)}.
   * <ul>
   *   <li>Then calls
   * {@link TransportService#process(SessionInfoProto, ToDeviceRpcResponseMsg, TransportServiceCallback)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcResponse(TransportProtos.ToDeviceRpcResponseMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test onToDeviceRpcResponse(ToDeviceRpcResponseMsg, SessionInfoProto); then calls process(SessionInfoProto, ToDeviceRpcResponseMsg, TransportServiceCallback)")
  void testOnToDeviceRpcResponse_thenCallsProcess() {
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
   * Test
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcResponse(ToDeviceRpcResponseMsg, SessionInfoProto)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2MRpcRequestHandler#onToDeviceRpcResponse(TransportProtos.ToDeviceRpcResponseMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test onToDeviceRpcResponse(ToDeviceRpcResponseMsg, SessionInfoProto); then throw IllegalArgumentException")
  void testOnToDeviceRpcResponse_thenThrowIllegalArgumentException() {
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
