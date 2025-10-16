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
package org.thingsboard.server.transport.coap.client;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.Code;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.elements.AddressEndpointContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.coapserver.CoapServerContext;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.device.profile.CoapDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.transport.TransportDeviceProfileCache;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SessionEventMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.SubscribeToAttributeUpdatesMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SubscribeToRPCMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcResponseMsg;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.transport.coap.CoapTransportContext;
import org.thingsboard.server.transport.coap.client.DefaultCoapClientContext.CoapSessionListener;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultCoapClientContextDiffblueTest {
  @Mock private CoapTransportContext coapTransportContext;

  @InjectMocks private DefaultCoapClientContext defaultCoapClientContext;

  @Mock private TransportDeviceProfileCache transportDeviceProfileCache;

  @Mock private TransportService transportService;

  /**
   * Test CoapSessionListener {@link CoapSessionListener#onToDeviceRpcRequest(UUID,
   * ToDeviceRpcRequestMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultTransportService#process(SessionInfoProto,
   *       ToDeviceRpcResponseMsg, TransportServiceCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link CoapSessionListener#onToDeviceRpcRequest(UUID,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test CoapSessionListener onToDeviceRpcRequest(UUID, ToDeviceRpcRequestMsg); then calls process(SessionInfoProto, ToDeviceRpcResponseMsg, TransportServiceCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CoapSessionListener.onToDeviceRpcRequest(UUID, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testCoapSessionListenerOnToDeviceRpcRequest_thenCallsProcess() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    DefaultCoapClientContext defaultCoapClientContext =
        new DefaultCoapClientContext(
            config, transportContext, transportService, profileCache, partitionService);
    CoapSessionListener coapSessionListener =
        defaultCoapClientContext.new CoapSessionListener(new TbCoapClientState(null));

    // Act
    coapSessionListener.onToDeviceRpcRequest(
        UUID.randomUUID(), ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    verify(transportService)
        .process(
            (SessionInfoProto) isNull(),
            isA(ToDeviceRpcResponseMsg.class),
            isA(TransportServiceCallback.class));
  }

  /**
   * Test CoapSessionListener {@link CoapSessionListener#onToDeviceRpcRequest(UUID,
   * ToDeviceRpcRequestMsg)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CoapSessionListener#onToDeviceRpcRequest(UUID,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test CoapSessionListener onToDeviceRpcRequest(UUID, ToDeviceRpcRequestMsg); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CoapSessionListener.onToDeviceRpcRequest(UUID, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testCoapSessionListenerOnToDeviceRpcRequest_thenThrowRuntimeException() {
    // Arrange
    DefaultCoapClientContext defaultCoapClientContext = mock(DefaultCoapClientContext.class);
    when(defaultCoapClientContext.getNextMsgId()).thenThrow(new RuntimeException());
    CoapSessionListener coapSessionListener =
        defaultCoapClientContext.new CoapSessionListener(new TbCoapClientState(null));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            coapSessionListener.onToDeviceRpcRequest(
                UUID.randomUUID(), ToDeviceRpcRequestMsg.getDefaultInstance()));
    verify(defaultCoapClientContext).getNextMsgId();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation() {
    // Arrange
    TbCoapClientState clientState = new TbCoapClientState(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange2 = new CoapExchange(exchange);
    clientState.setAttrs(new TbCoapObservationState(exchange2, "ABC123"));
    clientState.setRpc(null);
    clientState.setSession(null);
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    boolean actualRegisterAttributeObservationResult =
        defaultCoapClientContext.registerAttributeObservation(
            clientState, "ABC123", new CoapExchange(exchange3));

    // Assert
    TbCoapObservationState attrs = clientState.getAttrs();
    assertEquals("ABC123", attrs.getToken());
    assertNull(attrs.getObserveRelation());
    assertEquals(0, attrs.getObserveCounter().get());
    assertFalse(actualRegisterAttributeObservationResult);
    assertSame(exchange2, attrs.getExchange());
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation2() {
    // Arrange
    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getToken()).thenThrow(new IllegalArgumentException());

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(null);
    clientState.setSession(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange)));
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation3() {
    // Arrange
    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenThrow(new IllegalArgumentException());
    when(attrs.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(null);
    clientState.setSession(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange)));
    verify(attrs).getExchange();
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation4() {
    // Arrange
    Exchange exchange = mock(Exchange.class);
    when(exchange.getCurrentRequest()).thenThrow(new IllegalArgumentException());

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenReturn(new CoapExchange(exchange));
    when(attrs.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(null);
    clientState.setSession(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange2)));
    verify(exchange).getCurrentRequest();
    verify(attrs).getExchange();
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation5() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    CoapExchange coapExchange = mock(CoapExchange.class);
    doNothing().when(coapExchange).respond(Mockito.<ResponseCode>any());

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenReturn(coapExchange);
    when(attrs.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    clientState.setRpc(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange2)));
    verify(coapExchange).respond(ResponseCode.DELETED);
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
    verify(attrs).getExchange();
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link TbCoapObservationState} {@link TbCoapObservationState#getToken()} return
   *       {@code ABC123}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerAttributeObservation(TbCoapClientState, String, CoapExchange); given TbCoapObservationState getToken() return 'ABC123'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation_givenTbCoapObservationStateGetTokenReturnAbc123() {
    // Arrange
    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getToken()).thenReturn("ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(null);
    clientState.setSession(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    boolean actualRegisterAttributeObservationResult =
        defaultCoapClientContext.registerAttributeObservation(
            clientState, "ABC123", new CoapExchange(exchange));

    // Assert
    verify(attrs).getToken();
    assertFalse(actualRegisterAttributeObservationResult);
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link Request#getOptions()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerAttributeObservation(TbCoapClientState, String, CoapExchange); then calls getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation_thenCallsGetOptions() {
    // Arrange
    Request request = mock(Request.class);
    when(request.isMulticast()).thenThrow(new IllegalArgumentException());
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());
    when(request.getSourceContext()).thenReturn(new AddressEndpointContext("42", 8080));
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenReturn(new CoapExchange(exchange));
    when(attrs.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(null);
    clientState.setSession(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange2)));
    verify(request).getOptions();
    verify(request).getSourceContext();
    verify(request).isMulticast();
    verify(request).isObserve();
    verify(attrs).getExchange();
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link AddressEndpointContext#getPeerAddress()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerAttributeObservation(TbCoapClientState, String, CoapExchange); then calls getPeerAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation_thenCallsGetPeerAddress() {
    // Arrange
    AddressEndpointContext addressEndpointContext = mock(AddressEndpointContext.class);
    when(addressEndpointContext.getPeerAddress()).thenThrow(new IllegalArgumentException());

    Request request = mock(Request.class);
    when(request.isObserve()).thenReturn(true);
    when(request.getSourceContext()).thenReturn(addressEndpointContext);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenReturn(new CoapExchange(exchange));
    when(attrs.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(null);
    clientState.setSession(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange2)));
    verify(request).getSourceContext();
    verify(request).isObserve();
    verify(addressEndpointContext).getPeerAddress();
    verify(attrs).getExchange();
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link CoapExchange#respond(ResponseCode)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerAttributeObservation(TbCoapClientState, String, CoapExchange); then calls respond(ResponseCode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation_thenCallsRespond() {
    // Arrange
    when(coapTransportContext.getNodeId()).thenThrow(new IllegalArgumentException());

    CoapExchange coapExchange = mock(CoapExchange.class);
    doNothing().when(coapExchange).respond(Mockito.<ResponseCode>any());

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenReturn(coapExchange);
    when(attrs.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    clientState.setRpc(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    clientState.setSession(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange2)));
    verify(coapExchange).respond(ResponseCode.DELETED);
    verify(coapTransportContext).getNodeId();
    verify(attrs).getExchange();
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link Exchange#sendResponse(Response)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerAttributeObservation(TbCoapClientState, String, CoapExchange); then calls sendResponse(Response)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation_thenCallsSendResponse() {
    // Arrange
    when(coapTransportContext.getNodeId()).thenThrow(new IllegalArgumentException());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenReturn(new CoapExchange(exchange));
    when(attrs.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(null);
    clientState.setSession(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange2)));
    verify(exchange).getCurrentRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(coapTransportContext).getNodeId();
    verify(attrs).getExchange();
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerAttributeObservation(TbCoapClientState, String, CoapExchange); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation_thenReturnTrue() {
    // Arrange
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<GetAttributeRequestMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    CoapExchange coapExchange = mock(CoapExchange.class);
    doNothing().when(coapExchange).respond(Mockito.<ResponseCode>any());

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenReturn(coapExchange);
    when(attrs.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    clientState.setRpc(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange3 = new CoapExchange(exchange2);

    // Act
    boolean actualRegisterAttributeObservationResult =
        defaultCoapClientContext.registerAttributeObservation(clientState, "ABC123", exchange3);

    // Assert
    verify(coapExchange).respond(ResponseCode.DELETED);
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(GetAttributeRequestMsg.class),
            isA(TransportServiceCallback.class));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
    verify(attrs).getExchange();
    verify(attrs).getToken();
    TbCoapObservationState attrs2 = clientState.getAttrs();
    assertEquals("ABC123", attrs2.getToken());
    assertNull(attrs2.getObserveRelation());
    assertEquals(0, attrs2.getObserveCounter().get());
    assertTrue(actualRegisterAttributeObservationResult);
    assertSame(exchange3, attrs2.getExchange());
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerAttributeObservation(TbCoapClientState, String, CoapExchange); when TbCoapClientState(DeviceId) with deviceId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation_whenTbCoapClientStateWithDeviceIdIsNull() {
    // Arrange
    when(coapTransportContext.getNodeId()).thenThrow(new IllegalArgumentException());
    TbCoapClientState clientState = new TbCoapClientState(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange)));
    verify(coapTransportContext).getNodeId();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation() {
    // Arrange
    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange2 = new CoapExchange(exchange);
    clientState.setRpc(new TbCoapObservationState(exchange2, "ABC123"));
    clientState.setSession(null);
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    boolean actualRegisterRpcObservationResult =
        defaultCoapClientContext.registerRpcObservation(
            clientState, "ABC123", new CoapExchange(exchange3));

    // Assert
    TbCoapObservationState rpc = clientState.getRpc();
    assertEquals("ABC123", rpc.getToken());
    assertNull(rpc.getObserveRelation());
    assertEquals(0, rpc.getObserveCounter().get());
    assertFalse(actualRegisterRpcObservationResult);
    assertSame(exchange2, rpc.getExchange());
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation2() {
    // Arrange
    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getToken()).thenThrow(new IllegalArgumentException());

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    clientState.setRpc(rpc);
    clientState.setSession(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerRpcObservation(
                clientState, "ABC123", new CoapExchange(exchange)));
    verify(rpc).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation3() {
    // Arrange
    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getExchange()).thenThrow(new IllegalArgumentException());
    when(rpc.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    clientState.setRpc(rpc);
    clientState.setSession(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerRpcObservation(
                clientState, "ABC123", new CoapExchange(exchange)));
    verify(rpc).getExchange();
    verify(rpc).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation4() {
    // Arrange
    Exchange exchange = mock(Exchange.class);
    when(exchange.getCurrentRequest()).thenThrow(new IllegalArgumentException());

    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getExchange()).thenReturn(new CoapExchange(exchange));
    when(rpc.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    clientState.setRpc(rpc);
    clientState.setSession(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerRpcObservation(
                clientState, "ABC123", new CoapExchange(exchange2)));
    verify(exchange).getCurrentRequest();
    verify(rpc).getExchange();
    verify(rpc).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation5() {
    // Arrange
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    CoapExchange coapExchange = mock(CoapExchange.class);
    doNothing().when(coapExchange).respond(Mockito.<ResponseCode>any());

    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getExchange()).thenReturn(coapExchange);
    when(rpc.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    clientState.setAttrs(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    clientState.setRpc(rpc);
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange3 = new CoapExchange(exchange2);

    // Act
    boolean actualRegisterRpcObservationResult =
        defaultCoapClientContext.registerRpcObservation(clientState, "ABC123", exchange3);

    // Assert
    verify(coapExchange).respond(ResponseCode.DELETED);
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToRPCMsg.class),
            isA(TransportServiceCallback.class));
    verify(rpc).getExchange();
    verify(rpc).getToken();
    TbCoapObservationState rpc2 = clientState.getRpc();
    assertEquals("ABC123", rpc2.getToken());
    assertNull(rpc2.getObserveRelation());
    assertEquals(1, rpc2.getObserveCounter().get());
    assertTrue(actualRegisterRpcObservationResult);
    assertSame(exchange3, rpc2.getExchange());
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation6() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    CoapExchange coapExchange = mock(CoapExchange.class);
    doNothing().when(coapExchange).respond(Mockito.<ResponseCode>any());

    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getExchange()).thenReturn(coapExchange);
    when(rpc.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    clientState.setAttrs(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    clientState.setRpc(rpc);
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerRpcObservation(
                clientState, "ABC123", new CoapExchange(exchange2)));
    verify(coapExchange).respond(ResponseCode.DELETED);
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToRPCMsg.class),
            isA(TransportServiceCallback.class));
    verify(rpc).getExchange();
    verify(rpc).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange} {@link CoapExchange#respond(ResponseCode)} does nothing.
   *   <li>Then calls {@link CoapExchange#respond(ResponseCode)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerRpcObservation(TbCoapClientState, String, CoapExchange); given CoapExchange respond(ResponseCode) does nothing; then calls respond(ResponseCode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation_givenCoapExchangeRespondDoesNothing_thenCallsRespond() {
    // Arrange
    when(coapTransportContext.getNodeId()).thenThrow(new IllegalArgumentException());

    CoapExchange coapExchange = mock(CoapExchange.class);
    doNothing().when(coapExchange).respond(Mockito.<ResponseCode>any());

    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getExchange()).thenReturn(coapExchange);
    when(rpc.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    clientState.setAttrs(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    clientState.setRpc(rpc);
    clientState.setSession(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerRpcObservation(
                clientState, "ABC123", new CoapExchange(exchange2)));
    verify(coapExchange).respond(ResponseCode.DELETED);
    verify(coapTransportContext).getNodeId();
    verify(rpc).getExchange();
    verify(rpc).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link TbCoapObservationState} {@link TbCoapObservationState#getToken()} return
   *       {@code ABC123}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerRpcObservation(TbCoapClientState, String, CoapExchange); given TbCoapObservationState getToken() return 'ABC123'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation_givenTbCoapObservationStateGetTokenReturnAbc123() {
    // Arrange
    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getToken()).thenReturn("ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    clientState.setRpc(rpc);
    clientState.setSession(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    boolean actualRegisterRpcObservationResult =
        defaultCoapClientContext.registerRpcObservation(
            clientState, "ABC123", new CoapExchange(exchange));

    // Assert
    verify(rpc).getToken();
    assertFalse(actualRegisterRpcObservationResult);
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link Request#getOptions()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerRpcObservation(TbCoapClientState, String, CoapExchange); then calls getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation_thenCallsGetOptions() {
    // Arrange
    Request request = mock(Request.class);
    when(request.isMulticast()).thenThrow(new IllegalArgumentException());
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());
    when(request.getSourceContext()).thenReturn(new AddressEndpointContext("42", 8080));
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getExchange()).thenReturn(new CoapExchange(exchange));
    when(rpc.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    clientState.setRpc(rpc);
    clientState.setSession(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerRpcObservation(
                clientState, "ABC123", new CoapExchange(exchange2)));
    verify(request).getOptions();
    verify(request).getSourceContext();
    verify(request).isMulticast();
    verify(request).isObserve();
    verify(rpc).getExchange();
    verify(rpc).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link AddressEndpointContext#getPeerAddress()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerRpcObservation(TbCoapClientState, String, CoapExchange); then calls getPeerAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation_thenCallsGetPeerAddress() {
    // Arrange
    AddressEndpointContext addressEndpointContext = mock(AddressEndpointContext.class);
    when(addressEndpointContext.getPeerAddress()).thenThrow(new IllegalArgumentException());

    Request request = mock(Request.class);
    when(request.isObserve()).thenReturn(true);
    when(request.getSourceContext()).thenReturn(addressEndpointContext);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getExchange()).thenReturn(new CoapExchange(exchange));
    when(rpc.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    clientState.setRpc(rpc);
    clientState.setSession(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerRpcObservation(
                clientState, "ABC123", new CoapExchange(exchange2)));
    verify(request).getSourceContext();
    verify(request).isObserve();
    verify(addressEndpointContext).getPeerAddress();
    verify(rpc).getExchange();
    verify(rpc).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link Exchange#sendResponse(Response)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerRpcObservation(TbCoapClientState, String, CoapExchange); then calls sendResponse(Response)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation_thenCallsSendResponse() {
    // Arrange
    when(coapTransportContext.getNodeId()).thenThrow(new IllegalArgumentException());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());

    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getExchange()).thenReturn(new CoapExchange(exchange));
    when(rpc.getToken()).thenReturn("foo");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    clientState.setRpc(rpc);
    clientState.setSession(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerRpcObservation(
                clientState, "ABC123", new CoapExchange(exchange2)));
    verify(exchange).getCurrentRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(coapTransportContext).getNodeId();
    verify(rpc).getExchange();
    verify(rpc).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#registerRpcObservation(TbCoapClientState,
   * String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerRpcObservation(TbCoapClientState, String, CoapExchange); when TbCoapClientState(DeviceId) with deviceId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterRpcObservation_whenTbCoapClientStateWithDeviceIdIsNull() {
    // Arrange
    when(coapTransportContext.getNodeId()).thenThrow(new IllegalArgumentException());
    TbCoapClientState clientState = new TbCoapClientState(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerRpcObservation(
                clientState, "ABC123", new CoapExchange(exchange)));
    verify(coapTransportContext).getNodeId();
  }

  /**
   * Test {@link DefaultCoapClientContext#getNotificationCounterByToken(String)}.
   *
   * <ul>
   *   <li>When {@code ABC123}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#getNotificationCounterByToken(String)}
   */
  @Test
  @DisplayName("Test getNotificationCounterByToken(String); when 'ABC123'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.concurrent.atomic.AtomicInteger DefaultCoapClientContext.getNotificationCounterByToken(String)"
  })
  void testGetNotificationCounterByToken_whenAbc123_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(defaultCoapClientContext.getNotificationCounterByToken("ABC123"));
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    SessionInfoProto session = SessionInfoProto.getDefaultInstance();
    state.setSession(session);
    state.setAttrs(null);
    state.setRpc(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    defaultCoapClientContext.deregisterAttributeObservation(
        state, "ABC123", new CoapExchange(exchange));

    // Assert that nothing has changed
    assertSame(session, state.getSession());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation2() {
    // Arrange
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SessionEventMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setAttrs(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    state.setRpc(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange3 = new CoapExchange(exchange2);

    // Act
    defaultCoapClientContext.deregisterAttributeObservation(state, "ABC123", exchange3);

    // Assert
    verify(transportService).deregisterSession(isA(SessionInfoProto.class));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SessionEventMsg.class),
            (TransportServiceCallback<Void>) isNull());
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
    assertEquals("", exchange3.getRequestText());
    assertNull(state.getSession());
    assertEquals(0, exchange3.getRequestPayloadSize());
    assertEquals(Code.DELETE, exchange3.getRequestCode());
    assertFalse(exchange3.isMulticastRequest());
    assertArrayEquals(new byte[] {}, exchange3.getRequestPayload());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation3() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setAttrs(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    state.setRpc(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.deregisterAttributeObservation(
                state, "ABC123", new CoapExchange(exchange2)));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation4() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    SessionInfoProto session = SessionInfoProto.getDefaultInstance();
    state.setSession(session);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    TbCoapObservationState attrs = new TbCoapObservationState(new CoapExchange(exchange), "Token");
    state.setAttrs(attrs);
    state.setRpc(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    defaultCoapClientContext.deregisterAttributeObservation(
        state, "ABC123", new CoapExchange(exchange2));

    // Assert that nothing has changed
    assertSame(attrs, state.getAttrs());
    assertSame(session, state.getSession());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation5() {
    // Arrange
    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getToken()).thenThrow(new IllegalArgumentException());

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setAttrs(attrs);
    state.setRpc(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.deregisterAttributeObservation(
                state, "ABC123", new CoapExchange(exchange)));
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation6() {
    // Arrange
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SessionEventMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(attrs.getExchange()).thenReturn(new CoapExchange(exchange));
    when(attrs.getToken()).thenReturn("ABC123");

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setAttrs(attrs);
    state.setRpc(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange3 = new CoapExchange(exchange2);

    // Act
    defaultCoapClientContext.deregisterAttributeObservation(state, "ABC123", exchange3);

    // Assert
    verify(transportService).deregisterSession(isA(SessionInfoProto.class));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SessionEventMsg.class),
            (TransportServiceCallback<Void>) isNull());
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
    verify(attrs).getExchange();
    verify(attrs, atLeast(1)).getToken();
    assertEquals("", exchange3.getRequestText());
    assertNull(state.getSession());
    assertEquals(0, exchange3.getRequestPayloadSize());
    assertEquals(Code.DELETE, exchange3.getRequestCode());
    assertFalse(exchange3.isMulticastRequest());
    assertArrayEquals(new byte[] {}, exchange3.getRequestPayload());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation7() {
    // Arrange
    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenThrow(new IllegalArgumentException());
    when(attrs.getToken()).thenReturn("ABC123");

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setAttrs(attrs);
    state.setRpc(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.deregisterAttributeObservation(
                state, "ABC123", new CoapExchange(exchange)));
    verify(attrs).getExchange();
    verify(attrs, atLeast(1)).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation8() {
    // Arrange
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(attrs.getExchange()).thenReturn(new CoapExchange(exchange));
    when(attrs.getToken()).thenReturn("ABC123");

    TbCoapClientState state = new TbCoapClientState(null);
    SessionInfoProto session = SessionInfoProto.getDefaultInstance();
    state.setSession(session);
    state.setAttrs(attrs);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setRpc(new TbCoapObservationState(new CoapExchange(exchange2), "ABC123"));
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    defaultCoapClientContext.deregisterAttributeObservation(
        state, "ABC123", new CoapExchange(exchange3));

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
    verify(attrs).getExchange();
    verify(attrs, atLeast(1)).getToken();
    assertNull(state.getAttrs());
    assertSame(session, state.getSession());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link TbCoapClientState#getDeviceId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange); then calls getDeviceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation_thenCallsGetDeviceId() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getSession()).thenReturn(null);
    when(state.getDeviceId()).thenReturn(null);
    doNothing().when(state).lock();
    doNothing().when(state).unlock();
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange2 = new CoapExchange(exchange);

    // Act
    defaultCoapClientContext.deregisterAttributeObservation(state, "ABC123", exchange2);

    // Assert that nothing has changed
    verify(state).getDeviceId();
    verify(state).getSession();
    verify(state).lock();
    verify(state).unlock();
    assertEquals("", exchange2.getRequestText());
    assertEquals(0, exchange2.getRequestPayloadSize());
    assertEquals(Code.DELETE, exchange2.getRequestCode());
    assertFalse(exchange2.isMulticastRequest());
    assertArrayEquals(new byte[] {}, exchange2.getRequestPayload());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange); when TbCoapClientState(DeviceId) with deviceId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation_whenTbCoapClientStateWithDeviceIdIsNull() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange2 = new CoapExchange(exchange);

    // Act
    defaultCoapClientContext.deregisterAttributeObservation(state, "ABC123", exchange2);

    // Assert that nothing has changed
    assertEquals("", exchange2.getRequestText());
    assertEquals(0, exchange2.getRequestPayloadSize());
    assertEquals(Code.DELETE, exchange2.getRequestCode());
    assertFalse(exchange2.isMulticastRequest());
    assertArrayEquals(new byte[] {}, exchange2.getRequestPayload());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation() {
    // Arrange
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SessionEventMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setRpc(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    state.setAttrs(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange3 = new CoapExchange(exchange2);

    // Act
    defaultCoapClientContext.deregisterRpcObservation(state, "ABC123", exchange3);

    // Assert
    verify(transportService).deregisterSession(isA(SessionInfoProto.class));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SessionEventMsg.class),
            (TransportServiceCallback<Void>) isNull());
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToRPCMsg.class),
            isA(TransportServiceCallback.class));
    assertEquals("", exchange3.getRequestText());
    assertNull(state.getSession());
    assertEquals(0, exchange3.getRequestPayloadSize());
    assertEquals(Code.DELETE, exchange3.getRequestCode());
    assertFalse(exchange3.isMulticastRequest());
    assertArrayEquals(new byte[] {}, exchange3.getRequestPayload());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation2() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setRpc(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    state.setAttrs(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.deregisterRpcObservation(
                state, "ABC123", new CoapExchange(exchange2)));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToRPCMsg.class),
            isA(TransportServiceCallback.class));
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation3() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    SessionInfoProto session = SessionInfoProto.getDefaultInstance();
    state.setSession(session);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    TbCoapObservationState rpc = new TbCoapObservationState(new CoapExchange(exchange), "Token");
    state.setRpc(rpc);
    state.setAttrs(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    defaultCoapClientContext.deregisterRpcObservation(state, "ABC123", new CoapExchange(exchange2));

    // Assert that nothing has changed
    assertSame(rpc, state.getRpc());
    assertSame(session, state.getSession());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation4() {
    // Arrange
    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getToken()).thenThrow(new IllegalArgumentException());

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setRpc(rpc);
    state.setAttrs(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.deregisterRpcObservation(
                state, "ABC123", new CoapExchange(exchange)));
    verify(rpc).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation5() {
    // Arrange
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SessionEventMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(rpc.getExchange()).thenReturn(new CoapExchange(exchange));
    when(rpc.getToken()).thenReturn("ABC123");

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setRpc(rpc);
    state.setAttrs(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange3 = new CoapExchange(exchange2);

    // Act
    defaultCoapClientContext.deregisterRpcObservation(state, "ABC123", exchange3);

    // Assert
    verify(transportService).deregisterSession(isA(SessionInfoProto.class));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SessionEventMsg.class),
            (TransportServiceCallback<Void>) isNull());
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToRPCMsg.class),
            isA(TransportServiceCallback.class));
    verify(rpc).getExchange();
    verify(rpc, atLeast(1)).getToken();
    assertEquals("", exchange3.getRequestText());
    assertNull(state.getSession());
    assertEquals(0, exchange3.getRequestPayloadSize());
    assertEquals(Code.DELETE, exchange3.getRequestCode());
    assertFalse(exchange3.isMulticastRequest());
    assertArrayEquals(new byte[] {}, exchange3.getRequestPayload());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation6() {
    // Arrange
    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getExchange()).thenThrow(new IllegalArgumentException());
    when(rpc.getToken()).thenReturn("ABC123");

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setRpc(rpc);
    state.setAttrs(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.deregisterRpcObservation(
                state, "ABC123", new CoapExchange(exchange)));
    verify(rpc).getExchange();
    verify(rpc, atLeast(1)).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link TbCoapClientState#getDeviceId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange); then calls getDeviceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation_thenCallsGetDeviceId() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getSession()).thenReturn(null);
    when(state.getDeviceId()).thenReturn(null);
    doNothing().when(state).lock();
    doNothing().when(state).unlock();
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange2 = new CoapExchange(exchange);

    // Act
    defaultCoapClientContext.deregisterRpcObservation(state, "ABC123", exchange2);

    // Assert that nothing has changed
    verify(state).getDeviceId();
    verify(state).getSession();
    verify(state).lock();
    verify(state).unlock();
    assertEquals("", exchange2.getRequestText());
    assertEquals(0, exchange2.getRequestPayloadSize());
    assertEquals(Code.DELETE, exchange2.getRequestCode());
    assertFalse(exchange2.isMulticastRequest());
    assertArrayEquals(new byte[] {}, exchange2.getRequestPayload());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}
   *       Rpc is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange); then TbCoapClientState(DeviceId) with deviceId is 'null' Rpc is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation_thenTbCoapClientStateWithDeviceIdIsNullRpcIsNull() {
    // Arrange
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(rpc.getExchange()).thenReturn(new CoapExchange(exchange));
    when(rpc.getToken()).thenReturn("ABC123");

    TbCoapClientState state = new TbCoapClientState(null);
    SessionInfoProto session = SessionInfoProto.getDefaultInstance();
    state.setSession(session);
    state.setRpc(rpc);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setAttrs(new TbCoapObservationState(new CoapExchange(exchange2), "ABC123"));
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    defaultCoapClientContext.deregisterRpcObservation(state, "ABC123", new CoapExchange(exchange3));

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToRPCMsg.class),
            isA(TransportServiceCallback.class));
    verify(rpc).getExchange();
    verify(rpc, atLeast(1)).getToken();
    assertNull(state.getRpc());
    assertSame(session, state.getSession());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange); when TbCoapClientState(DeviceId) with deviceId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation_whenTbCoapClientStateWithDeviceIdIsNull() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange2 = new CoapExchange(exchange);

    // Act
    defaultCoapClientContext.deregisterRpcObservation(state, "ABC123", exchange2);

    // Assert that nothing has changed
    assertEquals("", exchange2.getRequestText());
    assertEquals(0, exchange2.getRequestPayloadSize());
    assertEquals(Code.DELETE, exchange2.getRequestCode());
    assertFalse(exchange2.isMulticastRequest());
    assertArrayEquals(new byte[] {}, exchange2.getRequestPayload());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}
   *       Rpc is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange); when TbCoapClientState(DeviceId) with deviceId is 'null' Rpc is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation_whenTbCoapClientStateWithDeviceIdIsNullRpcIsNull() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    SessionInfoProto session = SessionInfoProto.getDefaultInstance();
    state.setSession(session);
    state.setRpc(null);
    state.setAttrs(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    defaultCoapClientContext.deregisterRpcObservation(state, "ABC123", new CoapExchange(exchange));

    // Assert that nothing has changed
    assertSame(session, state.getSession());
  }

  /**
   * Test {@link DefaultCoapClientContext#getNewSyncSession(TbCoapClientState)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#getNewSyncSession(TbCoapClientState)}
   */
  @Test
  @DisplayName("Test getNewSyncSession(TbCoapClientState); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.SessionInfoProto DefaultCoapClientContext.getNewSyncSession(TbCoapClientState)"
  })
  void testGetNewSyncSession_thenThrowIllegalArgumentException() {
    // Arrange
    when(coapTransportContext.getNodeId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultCoapClientContext.getNewSyncSession(new TbCoapClientState(null)));
    verify(coapTransportContext).getNodeId();
  }

  /**
   * Test {@link DefaultCoapClientContext#awake(TbCoapClientState)} with {@code client}.
   *
   * <p>Method under test: {@link DefaultCoapClientContext#awake(TbCoapClientState)}
   */
  @Test
  @DisplayName("Test awake(TbCoapClientState) with 'client'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultCoapClientContext.awake(TbCoapClientState)"})
  void testAwakeWithClient() {
    // Arrange
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any()))
        .thenThrow(new IllegalArgumentException());

    TbCoapClientState client = mock(TbCoapClientState.class);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getProfileId()).thenReturn(new DeviceProfileId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCoapClientContext.awake(client));
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
  }

  /**
   * Test {@link DefaultCoapClientContext#awake(TbCoapClientState)} with {@code client}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfile} {@link DeviceProfile#getTransportType()} return {@code MQTT}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#awake(TbCoapClientState)}
   */
  @Test
  @DisplayName(
      "Test awake(TbCoapClientState) with 'client'; given DeviceProfile getTransportType() return 'MQTT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultCoapClientContext.awake(TbCoapClientState)"})
  void testAwakeWithClient_givenDeviceProfileGetTransportTypeReturnMqtt() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.MQTT);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    TbCoapClientState client = mock(TbCoapClientState.class);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getProfileId()).thenReturn(new DeviceProfileId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCoapClientContext.awake(client));
    verify(deviceProfile, atLeast(1)).getTransportType();
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
  }

  /**
   * Test {@link DefaultCoapClientContext#awake(TbCoapClientState)} with {@code client}.
   *
   * <ul>
   *   <li>Given {@code PSM}.
   *   <li>When {@link TbCoapClientState} {@link TbCoapClientState#getPowerMode()} return {@code
   *       PSM}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#awake(TbCoapClientState)}
   */
  @Test
  @DisplayName(
      "Test awake(TbCoapClientState) with 'client'; given 'PSM'; when TbCoapClientState getPowerMode() return 'PSM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultCoapClientContext.awake(TbCoapClientState)"})
  void testAwakeWithClient_givenPsm_whenTbCoapClientStateGetPowerModeReturnPsm() {
    // Arrange
    TbCoapClientState client = mock(TbCoapClientState.class);
    doThrow(new IllegalArgumentException()).when(client).lock();
    when(client.getPowerMode()).thenReturn(PowerMode.PSM);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCoapClientContext.awake(client));
    verify(client).getPowerMode();
    verify(client).lock();
  }

  /**
   * Test {@link DefaultCoapClientContext#awake(TbCoapClientState)} with {@code client}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getProfileData()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#awake(TbCoapClientState)}
   */
  @Test
  @DisplayName("Test awake(TbCoapClientState) with 'client'; then calls getProfileData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultCoapClientContext.awake(TbCoapClientState)"})
  void testAwakeWithClient_thenCallsGetProfileData() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenThrow(new IllegalArgumentException());
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.COAP);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    TbCoapClientState client = mock(TbCoapClientState.class);
    when(client.getPowerMode()).thenReturn(null);
    when(client.getProfileId()).thenReturn(new DeviceProfileId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCoapClientContext.awake(client));
    verify(deviceProfile).getProfileData();
    verify(deviceProfile).getTransportType();
    verify(transportDeviceProfileCache).get(isA(DeviceProfileId.class));
    verify(client).getPowerMode();
    verify(client, atLeast(1)).getProfileId();
  }

  /**
   * Test {@link DefaultCoapClientContext#awake(TbCoapClientState)} with {@code client}.
   *
   * <ul>
   *   <li>When {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#awake(TbCoapClientState)}
   */
  @Test
  @DisplayName(
      "Test awake(TbCoapClientState) with 'client'; when TbCoapClientState(DeviceId) with deviceId is 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultCoapClientContext.awake(TbCoapClientState)"})
  void testAwakeWithClient_whenTbCoapClientStateWithDeviceIdIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(defaultCoapClientContext.awake(new TbCoapClientState(null)));
  }

  /**
   * Test {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfile} {@link DeviceProfile#getTransportType()} return {@code MQTT}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}
   */
  @Test
  @DisplayName(
      "Test getProfile(DeviceProfileId); given DeviceProfile getTransportType() return 'MQTT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DefaultCoapClientContext.getProfile(DeviceProfileId)"})
  void testGetProfile_givenDeviceProfileGetTransportTypeReturnMqtt() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.MQTT);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCoapClientContext.getProfile(null));
    verify(deviceProfile, atLeast(1)).getTransportType();
    verify(transportDeviceProfileCache).get(isNull());
  }

  /**
   * Test {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link TransportDeviceProfileCache} {@link
   *       TransportDeviceProfileCache#get(DeviceProfileId)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}
   */
  @Test
  @DisplayName(
      "Test getProfile(DeviceProfileId); given TransportDeviceProfileCache get(DeviceProfileId) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DefaultCoapClientContext.getProfile(DeviceProfileId)"})
  void testGetProfile_givenTransportDeviceProfileCacheGetThrowIllegalArgumentException() {
    // Arrange
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCoapClientContext.getProfile(null));
    verify(transportDeviceProfileCache).get(isNull());
  }

  /**
   * Test {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getProfileData()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}
   */
  @Test
  @DisplayName("Test getProfile(DeviceProfileId); then calls getProfileData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DefaultCoapClientContext.getProfile(DeviceProfileId)"})
  void testGetProfile_thenCallsGetProfileData() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenThrow(new IllegalArgumentException());
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.COAP);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCoapClientContext.getProfile(null));
    verify(deviceProfile).getProfileData();
    verify(deviceProfile).getTransportType();
    verify(transportDeviceProfileCache).get(isNull());
  }

  /**
   * Test {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}
   */
  @Test
  @DisplayName("Test getProfile(DeviceProfileId); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DefaultCoapClientContext.getProfile(DeviceProfileId)"})
  void testGetProfile_thenReturnNotPresent() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    // Act
    Optional<CoapDeviceProfileTransportConfiguration> actualProfile =
        defaultCoapClientContext.getProfile(null);

    // Assert
    verify(deviceProfile, atLeast(1)).getTransportType();
    verify(transportDeviceProfileCache).get(isNull());
    assertFalse(actualProfile.isPresent());
  }
}
