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

@ContextConfiguration(classes = {ProtoCoapAdaptor.class})
@ExtendWith(SpringExtension.class)
class ProtoCoapAdaptorDiffblueTest {
  @Autowired
  private ProtoCoapAdaptor protoCoapAdaptor;

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostTelemetry() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostTelemetry2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostTelemetry3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToPostTelemetry(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostAttributes() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostAttributes2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToPostAttributes3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToPostAttributes(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToDeviceRpcResponse() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = Request.newDelete();

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToDeviceRpcResponse(sessionId, inbound, Any.getDescriptor()));
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptors.Descriptor)}
   */
  @Test
  void testConvertToDeviceRpcResponse2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getOptions()).thenReturn(new OptionSet());

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> protoCoapAdaptor.convertToDeviceRpcResponse(sessionId, inbound, Any.getDescriptor()));
    verify(inbound).getOptions();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  void testConvertToServerRpcRequest() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  void testConvertToServerRpcRequest2() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("\nXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  void testConvertToServerRpcRequest3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  void testConvertToServerRpcRequest4() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("XXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  void testConvertToServerRpcRequest5() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  void testConvertToServerRpcRequest6() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  void testConvertToServerRpcRequest7() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{'X', 'X', 1, 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testConvertToClaimDevice() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testConvertToClaimDevice2() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("\nXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testConvertToClaimDevice3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testConvertToClaimDevice4() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("XXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testConvertToClaimDevice5() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testConvertToClaimDevice6() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testConvertToClaimDevice7() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{'X', 'X', 1, 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToClaimDevice(sessionId, inbound,
        TransportProtos.SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg3() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("\nXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg4() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg5() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("XXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg6() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg7() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg8() throws AdaptorException {
    // Arrange
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(null, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg9() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{26, 2, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  void testConvertToProvisionRequestMsg10() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[]{26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(AdaptorException.class, () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPublish(TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToPublish() throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult = protoCoapAdaptor
        .convertToPublish(TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

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
  }

  /**
   * Method under test:
   * {@link ProtoCoapAdaptor#convertToPublish(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToPublish2() throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult = protoCoapAdaptor
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
   * {@link ProtoCoapAdaptor#convertToPublish(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  void testConvertToPublish3() throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult = protoCoapAdaptor
        .convertToPublish(TransportProtos.ToServerRpcResponseMsg.getDefaultInstance());

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
  }

  /**
   * Method under test: {@link ProtoCoapAdaptor#getContentFormat()}
   */
  @Test
  void testGetContentFormat() {
    // Arrange, Act and Assert
    assertEquals(42, protoCoapAdaptor.getContentFormat());
  }
}
