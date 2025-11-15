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
package org.thingsboard.server.transport.coap.adaptors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.Any;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DynamicMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MessageObserver;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.gen.transport.TransportProtos;

@ContextConfiguration(classes = {JsonCoapAdaptor.class})
@ExtendWith(SpringExtension.class)
class JsonCoapAdaptorDiffblueTest {
  @Autowired
  private JsonCoapAdaptor jsonCoapAdaptor;

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostTelemetry() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = Request.newDelete();

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostTelemetry2() throws AdaptorException {
    // Arrange
    Request inbound = Request.newDelete();

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostTelemetry(null, inbound, Any.getDescriptor()));
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostTelemetry3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostTelemetry4() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("foo");

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostTelemetry5() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostTelemetry6() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("42");

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostAttributes() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = Request.newDelete();

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostAttributes2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostAttributes3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("foo");

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostAttributes4() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostAttributes5() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("42");

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToDeviceRpcResponse() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);
    when(inbound.getOptions()).thenReturn(new OptionSet());

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToDeviceRpcResponse(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getOptions();
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  void testConvertToServerRpcRequest() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testConvertToClaimDevice() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testConvertToClaimDevice2() throws AdaptorException {
    // Arrange
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToClaimDevice(null, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testConvertToClaimDevice3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("foo");

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testConvertToClaimDevice4() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("42");

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPublish(TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToPublish() throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult = jsonCoapAdaptor
        .convertToPublish(TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    OptionSet options = actualConvertToPublishResult.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("", options.getUriPathString());
    assertEquals("", options.getUriQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals("/", options.getUriString());
    assertEquals("null", actualConvertToPublishResult.getTokenString());
    assertEquals("{}", actualConvertToPublishResult.getPayloadString());
    assertNull(actualConvertToPublishResult.getBytes());
    assertNull(actualConvertToPublishResult.getTokenBytes());
    assertNull(options.getOscore());
    assertNull(options.getObserve());
    assertNull(options.getSize1());
    assertNull(options.getSize2());
    assertNull(options.getUriPort());
    assertNull(actualConvertToPublishResult.getApplicationRttNanos());
    assertNull(actualConvertToPublishResult.getTransmissionRttNanos());
    assertNull(options.getProxyScheme());
    assertNull(options.getProxyUri());
    assertNull(options.getUriHost());
    assertNull(actualConvertToPublishResult.getSendError());
    assertNull(actualConvertToPublishResult.getLocalAddress());
    assertNull(options.getBlock1());
    assertNull(options.getBlock2());
    assertNull(actualConvertToPublishResult.getType());
    assertNull(actualConvertToPublishResult.getOffloadMode());
    assertNull(options.getNoResponse());
    assertNull(actualConvertToPublishResult.getToken());
    assertNull(actualConvertToPublishResult.getReliabilityLayerParameters());
    assertNull(actualConvertToPublishResult.getDestinationContext());
    assertNull(actualConvertToPublishResult.getEffectiveDestinationContext());
    assertNull(actualConvertToPublishResult.getSourceContext());
    assertEquals(-1, actualConvertToPublishResult.getMID());
    assertEquals(-1, options.getAccept());
    assertEquals(-1, options.getContentFormat());
    assertEquals(0, actualConvertToPublishResult.getMaxResourceBodySize());
    assertEquals(0, actualConvertToPublishResult.getMessageSize());
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getIfMatchCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(0, options.getURIPathCount());
    assertEquals(0, options.getURIQueryCount());
    assertEquals(0, options.getUriQueryParameter().size());
    assertEquals(0L, actualConvertToPublishResult.getNanoTimestamp());
    assertEquals(2, actualConvertToPublishResult.getPayloadSize());
    assertEquals(60L, options.getMaxAge().longValue());
    assertEquals(69, actualConvertToPublishResult.getRawCode());
    assertEquals(CoAP.ResponseCode.CONTENT, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.hasMID());
    assertFalse(actualConvertToPublishResult.isAcknowledged());
    assertFalse(actualConvertToPublishResult.isCanceled());
    assertFalse(actualConvertToPublishResult.isConfirmable());
    assertFalse(actualConvertToPublishResult.isDuplicate());
    assertFalse(actualConvertToPublishResult.isRejected());
    assertFalse(actualConvertToPublishResult.isSent());
    assertFalse(actualConvertToPublishResult.isTimedOut());
    assertFalse(actualConvertToPublishResult.isUnintendedPayload());
    assertFalse(options.hasAccept());
    assertFalse(options.hasBlock1());
    assertFalse(options.hasBlock2());
    assertFalse(options.hasContentFormat());
    assertFalse(options.hasIfNoneMatch());
    assertFalse(options.hasMaxAge());
    assertFalse(options.hasNoResponse());
    assertFalse(options.hasObserve());
    assertFalse(options.hasOscore());
    assertFalse(options.hasProxyScheme());
    assertFalse(options.hasProxyUri());
    assertFalse(options.hasSize1());
    assertFalse(options.hasSize2());
    assertFalse(options.hasUriHost());
    assertFalse(options.hasUriPort());
    assertFalse(actualConvertToPublishResult.hasBlockOption());
    assertFalse(actualConvertToPublishResult.isClientError());
    assertFalse(actualConvertToPublishResult.isError());
    assertFalse(actualConvertToPublishResult.isInternal());
    assertFalse(actualConvertToPublishResult.isNotification());
    assertFalse(actualConvertToPublishResult.isServerError());
    List<MessageObserver> messageObservers = actualConvertToPublishResult.getMessageObservers();
    assertTrue(messageObservers.isEmpty());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getIfMatch().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(options.getUriPath().isEmpty());
    assertTrue(options.getUriQuery().isEmpty());
    assertTrue(actualConvertToPublishResult.hasEmptyToken());
    assertTrue(actualConvertToPublishResult.isIntendedPayload());
    assertTrue(actualConvertToPublishResult.isSuccess());
    assertSame(messageObservers, options.getOthers());
    assertArrayEquals(new byte[]{'{', '}'}, actualConvertToPublishResult.getPayload());
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPublish(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToPublish2() throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult = jsonCoapAdaptor
        .convertToPublish(TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    assertEquals("", actualConvertToPublishResult.getPayloadString());
    OptionSet options = actualConvertToPublishResult.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("", options.getUriPathString());
    assertEquals("", options.getUriQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals("/", options.getUriString());
    assertEquals("null", actualConvertToPublishResult.getTokenString());
    assertNull(actualConvertToPublishResult.getBytes());
    assertNull(actualConvertToPublishResult.getTokenBytes());
    assertNull(options.getOscore());
    assertNull(options.getObserve());
    assertNull(options.getSize1());
    assertNull(options.getSize2());
    assertNull(options.getUriPort());
    assertNull(actualConvertToPublishResult.getApplicationRttNanos());
    assertNull(actualConvertToPublishResult.getTransmissionRttNanos());
    assertNull(options.getProxyScheme());
    assertNull(options.getProxyUri());
    assertNull(options.getUriHost());
    assertNull(actualConvertToPublishResult.getSendError());
    assertNull(actualConvertToPublishResult.getLocalAddress());
    assertNull(options.getBlock1());
    assertNull(options.getBlock2());
    assertNull(actualConvertToPublishResult.getType());
    assertNull(actualConvertToPublishResult.getOffloadMode());
    assertNull(options.getNoResponse());
    assertNull(actualConvertToPublishResult.getToken());
    assertNull(actualConvertToPublishResult.getReliabilityLayerParameters());
    assertNull(actualConvertToPublishResult.getDestinationContext());
    assertNull(actualConvertToPublishResult.getEffectiveDestinationContext());
    assertNull(actualConvertToPublishResult.getSourceContext());
    assertEquals(-1, actualConvertToPublishResult.getMID());
    assertEquals(-1, options.getAccept());
    assertEquals(-1, options.getContentFormat());
    assertEquals(0, actualConvertToPublishResult.getMaxResourceBodySize());
    assertEquals(0, actualConvertToPublishResult.getMessageSize());
    assertEquals(0, actualConvertToPublishResult.getPayloadSize());
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getIfMatchCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(0, options.getURIPathCount());
    assertEquals(0, options.getURIQueryCount());
    assertEquals(0, options.getUriQueryParameter().size());
    assertEquals(0, actualConvertToPublishResult.getPayload().length);
    assertEquals(0L, actualConvertToPublishResult.getNanoTimestamp());
    assertEquals(132, actualConvertToPublishResult.getRawCode());
    assertEquals(60L, options.getMaxAge().longValue());
    assertEquals(CoAP.ResponseCode.NOT_FOUND, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.hasMID());
    assertFalse(actualConvertToPublishResult.isAcknowledged());
    assertFalse(actualConvertToPublishResult.isCanceled());
    assertFalse(actualConvertToPublishResult.isConfirmable());
    assertFalse(actualConvertToPublishResult.isDuplicate());
    assertFalse(actualConvertToPublishResult.isRejected());
    assertFalse(actualConvertToPublishResult.isSent());
    assertFalse(actualConvertToPublishResult.isTimedOut());
    assertFalse(actualConvertToPublishResult.isUnintendedPayload());
    assertFalse(options.hasAccept());
    assertFalse(options.hasBlock1());
    assertFalse(options.hasBlock2());
    assertFalse(options.hasContentFormat());
    assertFalse(options.hasIfNoneMatch());
    assertFalse(options.hasMaxAge());
    assertFalse(options.hasNoResponse());
    assertFalse(options.hasObserve());
    assertFalse(options.hasOscore());
    assertFalse(options.hasProxyScheme());
    assertFalse(options.hasProxyUri());
    assertFalse(options.hasSize1());
    assertFalse(options.hasSize2());
    assertFalse(options.hasUriHost());
    assertFalse(options.hasUriPort());
    assertFalse(actualConvertToPublishResult.hasBlockOption());
    assertFalse(actualConvertToPublishResult.isInternal());
    assertFalse(actualConvertToPublishResult.isNotification());
    assertFalse(actualConvertToPublishResult.isServerError());
    assertFalse(actualConvertToPublishResult.isSuccess());
    List<MessageObserver> messageObservers = actualConvertToPublishResult.getMessageObservers();
    assertTrue(messageObservers.isEmpty());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getIfMatch().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(options.getUriPath().isEmpty());
    assertTrue(options.getUriQuery().isEmpty());
    assertTrue(actualConvertToPublishResult.hasEmptyToken());
    assertTrue(actualConvertToPublishResult.isIntendedPayload());
    assertTrue(actualConvertToPublishResult.isClientError());
    assertTrue(actualConvertToPublishResult.isError());
    assertSame(messageObservers, options.getOthers());
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPublish(TransportProtos.ToDeviceRpcRequestMsg, DynamicMessage.Builder)}
   */
  @Test
  void testConvertToPublish3() throws UnsupportedEncodingException, AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult = jsonCoapAdaptor
        .convertToPublish(TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), null);

    // Assert
    OptionSet options = actualConvertToPublishResult.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("", options.getUriPathString());
    assertEquals("", options.getUriQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals("/", options.getUriString());
    assertEquals("null", actualConvertToPublishResult.getTokenString());
    assertEquals("{\"id\":0,\"method\":\"\",\"params\":null}", actualConvertToPublishResult.getPayloadString());
    assertNull(actualConvertToPublishResult.getBytes());
    assertNull(actualConvertToPublishResult.getTokenBytes());
    assertNull(options.getOscore());
    assertNull(options.getObserve());
    assertNull(options.getSize1());
    assertNull(options.getSize2());
    assertNull(options.getUriPort());
    assertNull(actualConvertToPublishResult.getApplicationRttNanos());
    assertNull(actualConvertToPublishResult.getTransmissionRttNanos());
    assertNull(options.getProxyScheme());
    assertNull(options.getProxyUri());
    assertNull(options.getUriHost());
    assertNull(actualConvertToPublishResult.getSendError());
    assertNull(actualConvertToPublishResult.getLocalAddress());
    assertNull(options.getBlock1());
    assertNull(options.getBlock2());
    assertNull(actualConvertToPublishResult.getType());
    assertNull(actualConvertToPublishResult.getOffloadMode());
    assertNull(options.getNoResponse());
    assertNull(actualConvertToPublishResult.getToken());
    assertNull(actualConvertToPublishResult.getReliabilityLayerParameters());
    assertNull(actualConvertToPublishResult.getDestinationContext());
    assertNull(actualConvertToPublishResult.getEffectiveDestinationContext());
    assertNull(actualConvertToPublishResult.getSourceContext());
    assertEquals(-1, actualConvertToPublishResult.getMID());
    assertEquals(-1, options.getAccept());
    assertEquals(-1, options.getContentFormat());
    assertEquals(0, actualConvertToPublishResult.getMaxResourceBodySize());
    assertEquals(0, actualConvertToPublishResult.getMessageSize());
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getIfMatchCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(0, options.getURIPathCount());
    assertEquals(0, options.getURIQueryCount());
    assertEquals(0, options.getUriQueryParameter().size());
    assertEquals(0L, actualConvertToPublishResult.getNanoTimestamp());
    assertEquals(34, actualConvertToPublishResult.getPayloadSize());
    assertEquals(60L, options.getMaxAge().longValue());
    assertEquals(69, actualConvertToPublishResult.getRawCode());
    assertEquals(CoAP.ResponseCode.CONTENT, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.hasMID());
    assertFalse(actualConvertToPublishResult.isAcknowledged());
    assertFalse(actualConvertToPublishResult.isCanceled());
    assertFalse(actualConvertToPublishResult.isConfirmable());
    assertFalse(actualConvertToPublishResult.isDuplicate());
    assertFalse(actualConvertToPublishResult.isRejected());
    assertFalse(actualConvertToPublishResult.isSent());
    assertFalse(actualConvertToPublishResult.isTimedOut());
    assertFalse(actualConvertToPublishResult.isUnintendedPayload());
    assertFalse(options.hasAccept());
    assertFalse(options.hasBlock1());
    assertFalse(options.hasBlock2());
    assertFalse(options.hasContentFormat());
    assertFalse(options.hasIfNoneMatch());
    assertFalse(options.hasMaxAge());
    assertFalse(options.hasNoResponse());
    assertFalse(options.hasObserve());
    assertFalse(options.hasOscore());
    assertFalse(options.hasProxyScheme());
    assertFalse(options.hasProxyUri());
    assertFalse(options.hasSize1());
    assertFalse(options.hasSize2());
    assertFalse(options.hasUriHost());
    assertFalse(options.hasUriPort());
    assertFalse(actualConvertToPublishResult.hasBlockOption());
    assertFalse(actualConvertToPublishResult.isClientError());
    assertFalse(actualConvertToPublishResult.isError());
    assertFalse(actualConvertToPublishResult.isInternal());
    assertFalse(actualConvertToPublishResult.isNotification());
    assertFalse(actualConvertToPublishResult.isServerError());
    List<MessageObserver> messageObservers = actualConvertToPublishResult.getMessageObservers();
    assertTrue(messageObservers.isEmpty());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getIfMatch().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(options.getUriPath().isEmpty());
    assertTrue(options.getUriQuery().isEmpty());
    assertTrue(actualConvertToPublishResult.hasEmptyToken());
    assertTrue(actualConvertToPublishResult.isIntendedPayload());
    assertTrue(actualConvertToPublishResult.isSuccess());
    assertSame(messageObservers, options.getOthers());
    byte[] expectedPayload = "{\"id\":0,\"method\":\"\",\"params\":null}".getBytes("UTF-8");
    assertArrayEquals(expectedPayload, actualConvertToPublishResult.getPayload());
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToPublish(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  void testConvertToPublish4() throws UnsupportedEncodingException, AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult = jsonCoapAdaptor
        .convertToPublish(TransportProtos.ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    OptionSet options = actualConvertToPublishResult.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("", options.getUriPathString());
    assertEquals("", options.getUriQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals("/", options.getUriString());
    assertEquals("null", actualConvertToPublishResult.getPayloadString());
    assertEquals("null", actualConvertToPublishResult.getTokenString());
    assertNull(actualConvertToPublishResult.getBytes());
    assertNull(actualConvertToPublishResult.getTokenBytes());
    assertNull(options.getOscore());
    assertNull(options.getObserve());
    assertNull(options.getSize1());
    assertNull(options.getSize2());
    assertNull(options.getUriPort());
    assertNull(actualConvertToPublishResult.getApplicationRttNanos());
    assertNull(actualConvertToPublishResult.getTransmissionRttNanos());
    assertNull(options.getProxyScheme());
    assertNull(options.getProxyUri());
    assertNull(options.getUriHost());
    assertNull(actualConvertToPublishResult.getSendError());
    assertNull(actualConvertToPublishResult.getLocalAddress());
    assertNull(options.getBlock1());
    assertNull(options.getBlock2());
    assertNull(actualConvertToPublishResult.getType());
    assertNull(actualConvertToPublishResult.getOffloadMode());
    assertNull(options.getNoResponse());
    assertNull(actualConvertToPublishResult.getToken());
    assertNull(actualConvertToPublishResult.getReliabilityLayerParameters());
    assertNull(actualConvertToPublishResult.getDestinationContext());
    assertNull(actualConvertToPublishResult.getEffectiveDestinationContext());
    assertNull(actualConvertToPublishResult.getSourceContext());
    assertEquals(-1, actualConvertToPublishResult.getMID());
    assertEquals(-1, options.getAccept());
    assertEquals(-1, options.getContentFormat());
    assertEquals(0, actualConvertToPublishResult.getMaxResourceBodySize());
    assertEquals(0, actualConvertToPublishResult.getMessageSize());
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getIfMatchCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(0, options.getURIPathCount());
    assertEquals(0, options.getURIQueryCount());
    assertEquals(0, options.getUriQueryParameter().size());
    assertEquals(0L, actualConvertToPublishResult.getNanoTimestamp());
    assertEquals(4, actualConvertToPublishResult.getPayloadSize());
    assertEquals(60L, options.getMaxAge().longValue());
    assertEquals(69, actualConvertToPublishResult.getRawCode());
    assertEquals(CoAP.ResponseCode.CONTENT, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.hasMID());
    assertFalse(actualConvertToPublishResult.isAcknowledged());
    assertFalse(actualConvertToPublishResult.isCanceled());
    assertFalse(actualConvertToPublishResult.isConfirmable());
    assertFalse(actualConvertToPublishResult.isDuplicate());
    assertFalse(actualConvertToPublishResult.isRejected());
    assertFalse(actualConvertToPublishResult.isSent());
    assertFalse(actualConvertToPublishResult.isTimedOut());
    assertFalse(actualConvertToPublishResult.isUnintendedPayload());
    assertFalse(options.hasAccept());
    assertFalse(options.hasBlock1());
    assertFalse(options.hasBlock2());
    assertFalse(options.hasContentFormat());
    assertFalse(options.hasIfNoneMatch());
    assertFalse(options.hasMaxAge());
    assertFalse(options.hasNoResponse());
    assertFalse(options.hasObserve());
    assertFalse(options.hasOscore());
    assertFalse(options.hasProxyScheme());
    assertFalse(options.hasProxyUri());
    assertFalse(options.hasSize1());
    assertFalse(options.hasSize2());
    assertFalse(options.hasUriHost());
    assertFalse(options.hasUriPort());
    assertFalse(actualConvertToPublishResult.hasBlockOption());
    assertFalse(actualConvertToPublishResult.isClientError());
    assertFalse(actualConvertToPublishResult.isError());
    assertFalse(actualConvertToPublishResult.isInternal());
    assertFalse(actualConvertToPublishResult.isNotification());
    assertFalse(actualConvertToPublishResult.isServerError());
    List<MessageObserver> messageObservers = actualConvertToPublishResult.getMessageObservers();
    assertTrue(messageObservers.isEmpty());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getIfMatch().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(options.getUriPath().isEmpty());
    assertTrue(options.getUriQuery().isEmpty());
    assertTrue(actualConvertToPublishResult.hasEmptyToken());
    assertTrue(actualConvertToPublishResult.isIntendedPayload());
    assertTrue(actualConvertToPublishResult.isSuccess());
    assertSame(messageObservers, options.getOthers());
    byte[] expectedPayload = "null".getBytes("UTF-8");
    assertArrayEquals(expectedPayload, actualConvertToPublishResult.getPayload());
  }

  /**
   * Method under test: {@link JsonCoapAdaptor#getContentFormat()}
   */
  @Test
  void testGetContentFormat() {
    // Arrange, Act and Assert
    assertEquals(50, jsonCoapAdaptor.getContentFormat());
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, Request.newDelete()));
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("foo");

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg4() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayloadString();
  }

  /**
   * Method under test:
   * {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg5() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("42");

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayloadString();
  }
}
