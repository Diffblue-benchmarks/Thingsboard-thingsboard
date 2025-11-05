package org.thingsboard.server.transport.coap.adaptors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.DynamicMessage.Builder;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.UUID;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.AttributeUpdateNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ClaimDeviceMsg;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToServerRpcResponseMsg;
import org.thingsboard.server.gen.transport.coap.MeasurementsProtos;
import org.thingsboard.server.gen.transport.coap.MeasurementsProtos.ProtoChannel;

@ContextConfiguration(classes = {JsonCoapAdaptor.class})
@ExtendWith(SpringExtension.class)
class JsonCoapAdaptorDiffblueTest {
  @Autowired private JsonCoapAdaptor jsonCoapAdaptor;

  /**
   * Test {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Request} {@link Request#getPayloadString()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, Request, Descriptor); given '42'; when Request getPayloadString() return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonCoapAdaptor.convertToPostTelemetry(UUID, Request, Descriptor)"
  })
  void testConvertToPostTelemetry_given42_whenRequestGetPayloadStringReturn42()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("42");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            jsonCoapAdaptor.convertToPostTelemetry(
                sessionId, inbound, ProtoChannel.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link Request} {@link Request#getPayloadString()} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, Request, Descriptor); given 'foo'; when Request getPayloadString() return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonCoapAdaptor.convertToPostTelemetry(UUID, Request, Descriptor)"
  })
  void testConvertToPostTelemetry_givenFoo_whenRequestGetPayloadStringReturnFoo()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("foo");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            jsonCoapAdaptor.convertToPostTelemetry(
                sessionId, inbound, ProtoChannel.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Request} {@link Request#getPayloadString()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, Request, Descriptor); given 'null'; when Request getPayloadString() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonCoapAdaptor.convertToPostTelemetry(UUID, Request, Descriptor)"
  })
  void testConvertToPostTelemetry_givenNull_whenRequestGetPayloadStringReturnNull()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            jsonCoapAdaptor.convertToPostTelemetry(
                sessionId, inbound, ProtoChannel.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>Given {@code Payload String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(UUID, Request, Descriptor); given 'Payload String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonCoapAdaptor.convertToPostTelemetry(UUID, Request, Descriptor)"
  })
  void testConvertToPostTelemetry_givenPayloadString() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            jsonCoapAdaptor.convertToPostTelemetry(
                sessionId, inbound, ProtoChannel.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>When newDelete.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, Request, Descriptor); when newDelete; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonCoapAdaptor.convertToPostTelemetry(UUID, Request, Descriptor)"
  })
  void testConvertToPostTelemetry_whenNewDelete_thenThrowAdaptorException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            jsonCoapAdaptor.convertToPostTelemetry(
                sessionId, Request.newDelete(), ProtoChannel.getDescriptor()));
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>When newFetch.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPostTelemetry(UUID, Request, Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(UUID, Request, Descriptor); when newFetch; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonCoapAdaptor.convertToPostTelemetry(UUID, Request, Descriptor)"
  })
  void testConvertToPostTelemetry_whenNewFetch_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            jsonCoapAdaptor.convertToPostTelemetry(
                sessionId, Request.newFetch(), ProtoChannel.getDescriptor()));
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Request} {@link Request#getPayloadString()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request,
   * Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, Request, Descriptor); given '42'; when Request getPayloadString() return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonCoapAdaptor.convertToPostAttributes(UUID, Request, Descriptor)"
  })
  void testConvertToPostAttributes_given42_whenRequestGetPayloadStringReturn42()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("42");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            jsonCoapAdaptor.convertToPostAttributes(
                sessionId, inbound, ProtoChannel.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link Request} {@link Request#getPayloadString()} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request,
   * Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, Request, Descriptor); given 'foo'; when Request getPayloadString() return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonCoapAdaptor.convertToPostAttributes(UUID, Request, Descriptor)"
  })
  void testConvertToPostAttributes_givenFoo_whenRequestGetPayloadStringReturnFoo()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("foo");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            jsonCoapAdaptor.convertToPostAttributes(
                sessionId, inbound, ProtoChannel.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Request} {@link Request#getPayloadString()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request,
   * Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, Request, Descriptor); given 'null'; when Request getPayloadString() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonCoapAdaptor.convertToPostAttributes(UUID, Request, Descriptor)"
  })
  void testConvertToPostAttributes_givenNull_whenRequestGetPayloadStringReturnNull()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            jsonCoapAdaptor.convertToPostAttributes(
                sessionId, inbound, ProtoChannel.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>Given {@code Payload String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request,
   * Descriptor)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(UUID, Request, Descriptor); given 'Payload String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonCoapAdaptor.convertToPostAttributes(UUID, Request, Descriptor)"
  })
  void testConvertToPostAttributes_givenPayloadString() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            jsonCoapAdaptor.convertToPostAttributes(
                sessionId, inbound, ProtoChannel.getDescriptor()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>When newDelete.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPostAttributes(UUID, Request,
   * Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(UUID, Request, Descriptor); when newDelete; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonCoapAdaptor.convertToPostAttributes(UUID, Request, Descriptor)"
  })
  void testConvertToPostAttributes_whenNewDelete_thenThrowAdaptorException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            jsonCoapAdaptor.convertToPostAttributes(
                sessionId, Request.newDelete(), ProtoChannel.getDescriptor()));
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToGetAttributes(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()} addUriQuery {@code Argument}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToGetAttributes(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(UUID, Request); given OptionSet() addUriQuery 'Argument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg JsonCoapAdaptor.convertToGetAttributes(UUID, Request)"
  })
  void testConvertToGetAttributes_givenOptionSetAddUriQueryArgument() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    OptionSet optionSet = new OptionSet();
    optionSet.addUriQuery("Argument");

    Request inbound = mock(Request.class);
    when(inbound.getOptions()).thenReturn(optionSet);

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        jsonCoapAdaptor.convertToGetAttributes(sessionId, inbound);

    // Assert
    verify(inbound).getOptions();
    GetAttributeRequestMsg actualDefaultInstanceForType =
        actualConvertToGetAttributesResult.getDefaultInstanceForType();
    assertEquals(actualConvertToGetAttributesResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToGetAttributesResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
    ProtocolStringList expectedSharedAttributeNamesList =
        actualConvertToGetAttributesResult.getClientAttributeNamesList();
    assertSame(
        expectedSharedAttributeNamesList,
        actualConvertToGetAttributesResult.getSharedAttributeNamesList());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToGetAttributes(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()}.
   *   <li>When {@link Request} {@link Request#getOptions()} return {@link OptionSet#OptionSet()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToGetAttributes(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(UUID, Request); given OptionSet(); when Request getOptions() return OptionSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg JsonCoapAdaptor.convertToGetAttributes(UUID, Request)"
  })
  void testConvertToGetAttributes_givenOptionSet_whenRequestGetOptionsReturnOptionSet()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getOptions()).thenReturn(new OptionSet());

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        jsonCoapAdaptor.convertToGetAttributes(sessionId, inbound);

    // Assert
    verify(inbound).getOptions();
    GetAttributeRequestMsg actualDefaultInstanceForType =
        actualConvertToGetAttributesResult.getDefaultInstanceForType();
    assertEquals(actualConvertToGetAttributesResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToGetAttributesResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
    ProtocolStringList expectedSharedAttributeNamesList =
        actualConvertToGetAttributesResult.getClientAttributeNamesList();
    assertSame(
        expectedSharedAttributeNamesList,
        actualConvertToGetAttributesResult.getSharedAttributeNamesList());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToGetAttributes(UUID, Request)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToGetAttributes(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(UUID, Request); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg JsonCoapAdaptor.convertToGetAttributes(UUID, Request)"
  })
  void testConvertToGetAttributes_thenThrowIllegalStateException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getOptions()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonCoapAdaptor.convertToGetAttributes(sessionId, inbound));
    verify(inbound).getOptions();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToGetAttributes(UUID, Request)}.
   *
   * <ul>
   *   <li>When newDelete.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToGetAttributes(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(UUID, Request); when newDelete")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg JsonCoapAdaptor.convertToGetAttributes(UUID, Request)"
  })
  void testConvertToGetAttributes_whenNewDelete() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        jsonCoapAdaptor.convertToGetAttributes(sessionId, Request.newDelete());

    // Assert
    GetAttributeRequestMsg actualDefaultInstanceForType =
        actualConvertToGetAttributesResult.getDefaultInstanceForType();
    assertEquals(actualConvertToGetAttributesResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToGetAttributesResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
    ProtocolStringList expectedSharedAttributeNamesList =
        actualConvertToGetAttributesResult.getClientAttributeNamesList();
    assertSame(
        expectedSharedAttributeNamesList,
        actualConvertToGetAttributesResult.getSharedAttributeNamesList());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToDeviceRpcResponse(UUID, Request,
   * Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToDeviceRpcResponse(UUID, Request, Descriptor); given 'null'; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToDeviceRpcResponseMsg JsonCoapAdaptor.convertToDeviceRpcResponse(UUID, Request, Descriptor)"
  })
  void testConvertToDeviceRpcResponse_givenNull_thenThrowAdaptorException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Uri Path");
    stringList.add("Uri Path");
    stringList.add("Uri Path");
    stringList.add("Uri Path");
    stringList.add("Uri Path");

    OptionSet optionSet = mock(OptionSet.class);
    when(optionSet.getUriPath()).thenReturn(stringList);

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);
    when(inbound.getOptions()).thenReturn(optionSet);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            jsonCoapAdaptor.convertToDeviceRpcResponse(
                sessionId, inbound, ProtoChannel.getDescriptor()));
    verify(inbound).getOptions();
    verify(inbound).getPayloadString();
    verify(optionSet).getUriPath();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToDeviceRpcResponse(UUID, Request,
   * Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToDeviceRpcResponse(UUID, Request, Descriptor); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToDeviceRpcResponseMsg JsonCoapAdaptor.convertToDeviceRpcResponse(UUID, Request, Descriptor)"
  })
  void testConvertToDeviceRpcResponse_thenThrowIllegalStateException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenThrow(new IllegalStateException());
    when(inbound.getOptions()).thenReturn(new OptionSet());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonCoapAdaptor.convertToDeviceRpcResponse(
                sessionId, inbound, ProtoChannel.getDescriptor()));
    verify(inbound).getOptions();
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(UUID, Request); given 'null'; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToServerRpcRequestMsg JsonCoapAdaptor.convertToServerRpcRequest(UUID, Request)"
  })
  void testConvertToServerRpcRequest_givenNull_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Request} {@link Request#getPayloadString()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDevice(UUID, Request, SessionInfoProto); given '42'; when Request getPayloadString() return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_given42_whenRequestGetPayloadStringReturn42()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("42");

    SessionInfoProto sessionInfo = mock(SessionInfoProto.class);
    when(sessionInfo.getDeviceIdLSB()).thenReturn(1L);
    when(sessionInfo.getDeviceIdMSB()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonCoapAdaptor.convertToClaimDevice(sessionId, inbound, sessionInfo));
    verify(inbound).getPayloadString();
    verify(sessionInfo).getDeviceIdLSB();
    verify(sessionInfo).getDeviceIdMSB();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link Request} {@link Request#getPayloadString()} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'foo'; when Request getPayloadString() return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_givenFoo_whenRequestGetPayloadStringReturnFoo()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("foo");

    SessionInfoProto sessionInfo = mock(SessionInfoProto.class);
    when(sessionInfo.getDeviceIdLSB()).thenReturn(1L);
    when(sessionInfo.getDeviceIdMSB()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonCoapAdaptor.convertToClaimDevice(sessionId, inbound, sessionInfo));
    verify(inbound).getPayloadString();
    verify(sessionInfo).getDeviceIdLSB();
    verify(sessionInfo).getDeviceIdMSB();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return DeviceIdLSB is one.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'null'; then return DeviceIdLSB is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_givenNull_thenReturnDeviceIdLSBIsOne() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);

    SessionInfoProto sessionInfo = mock(SessionInfoProto.class);
    when(sessionInfo.getDeviceIdLSB()).thenReturn(1L);
    when(sessionInfo.getDeviceIdMSB()).thenReturn(1L);

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceResult =
        jsonCoapAdaptor.convertToClaimDevice(sessionId, inbound, sessionInfo);

    // Assert
    verify(inbound).getPayloadString();
    verify(sessionInfo).getDeviceIdLSB();
    verify(sessionInfo).getDeviceIdMSB();
    assertEquals(1L, actualConvertToClaimDeviceResult.getDeviceIdLSB());
    assertEquals(1L, actualConvertToClaimDeviceResult.getDeviceIdMSB());
    assertEquals(2, actualConvertToClaimDeviceResult.getAllFields().size());
    assertEquals(4, actualConvertToClaimDeviceResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualConvertToClaimDeviceResult.getUnknownFields();
    ClaimDeviceMsg defaultInstanceForType =
        actualConvertToClaimDeviceResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given {@code Payload String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'Payload String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_givenPayloadString() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            jsonCoapAdaptor.convertToClaimDevice(
                sessionId, inbound, SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given {@code Payload String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'Payload String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_givenPayloadString2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    SessionInfoProto sessionInfo = mock(SessionInfoProto.class);
    when(sessionInfo.getDeviceIdLSB()).thenReturn(1L);
    when(sessionInfo.getDeviceIdMSB()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonCoapAdaptor.convertToClaimDevice(sessionId, inbound, sessionInfo));
    verify(inbound).getPayloadString();
    verify(sessionInfo).getDeviceIdLSB();
    verify(sessionInfo).getDeviceIdMSB();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>When newDelete.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); when newDelete")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_whenNewDelete() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceResult =
        jsonCoapAdaptor.convertToClaimDevice(
            sessionId, Request.newDelete(), SessionInfoProto.getDefaultInstance());

    // Assert
    assertEquals(4, actualConvertToClaimDeviceResult.getDescriptorForType().getFields().size());
    ClaimDeviceMsg actualDefaultInstanceForType =
        actualConvertToClaimDeviceResult.getDefaultInstanceForType();
    assertEquals(actualConvertToClaimDeviceResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToClaimDeviceResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>When newFetch.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); when newFetch")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg JsonCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_whenNewFetch() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceResult =
        jsonCoapAdaptor.convertToClaimDevice(
            sessionId, Request.newFetch(), SessionInfoProto.getDefaultInstance());

    // Assert
    assertEquals(4, actualConvertToClaimDeviceResult.getDescriptorForType().getFields().size());
    ClaimDeviceMsg actualDefaultInstanceForType =
        actualConvertToClaimDeviceResult.getDefaultInstanceForType();
    assertEquals(actualConvertToClaimDeviceResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToClaimDeviceResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)} with {@code
   * AttributeUpdateNotificationMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(AttributeUpdateNotificationMsg)"})
  void testConvertToPublishWithAttributeUpdateNotificationMsg() throws AdaptorException {
    // Arrange
    AttributeUpdateNotificationMsg msg = mock(AttributeUpdateNotificationMsg.class);
    when(msg.getSharedDeletedCount()).thenReturn(0);
    when(msg.getSharedUpdatedCount()).thenReturn(0);

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg).getSharedDeletedCount();
    verify(msg).getSharedUpdatedCount();
    assertEquals("{}", actualConvertToPublishResult.getPayloadString());
    assertEquals(2, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(new byte[] {'{', '}'}, actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)} with {@code
   * AttributeUpdateNotificationMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(AttributeUpdateNotificationMsg)"})
  void testConvertToPublishWithAttributeUpdateNotificationMsg2()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    AttributeUpdateNotificationMsg msg = mock(AttributeUpdateNotificationMsg.class);
    when(msg.getSharedDeletedList()).thenReturn(LazyStringArrayList.emptyList());
    when(msg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(msg.getSharedDeletedCount()).thenReturn(1);
    when(msg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg).getSharedDeletedCount();
    verify(msg).getSharedDeletedList();
    verify(msg).getSharedUpdatedCount();
    verify(msg).getSharedUpdatedList();
    assertEquals("{\"deleted\":[]}", actualConvertToPublishResult.getPayloadString());
    assertEquals(14, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(
        "{\"deleted\":[]}".getBytes("UTF-8"), actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)} with {@code
   * AttributeUpdateNotificationMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(AttributeUpdateNotificationMsg)"})
  void testConvertToPublishWithAttributeUpdateNotificationMsg3() throws AdaptorException {
    // Arrange
    AttributeUpdateNotificationMsg msg = mock(AttributeUpdateNotificationMsg.class);
    when(msg.getSharedUpdatedList()).thenThrow(new IllegalStateException());
    when(msg.getSharedUpdatedCount()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonCoapAdaptor.convertToPublish(msg));
    verify(msg).getSharedUpdatedCount();
    verify(msg).getSharedUpdatedList();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)} with {@code
   * AttributeUpdateNotificationMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(AttributeUpdateNotificationMsg)"})
  void testConvertToPublishWithAttributeUpdateNotificationMsg4() throws AdaptorException {
    // Arrange
    AttributeUpdateNotificationMsg msg = mock(AttributeUpdateNotificationMsg.class);
    when(msg.getSharedDeletedList()).thenThrow(new IllegalStateException());
    when(msg.getSharedDeletedCount()).thenReturn(1);
    when(msg.getSharedUpdatedCount()).thenReturn(0);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonCoapAdaptor.convertToPublish(msg));
    verify(msg).getSharedDeletedCount();
    verify(msg).getSharedDeletedList();
    verify(msg).getSharedUpdatedCount();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)} with {@code
   * AttributeUpdateNotificationMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(AttributeUpdateNotificationMsg)"})
  void testConvertToPublishWithAttributeUpdateNotificationMsg5()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(true);
    when(element.toStringUtf8()).thenReturn("String Utf8");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element);

    AttributeUpdateNotificationMsg msg = mock(AttributeUpdateNotificationMsg.class);
    when(msg.getSharedDeletedList()).thenReturn(lazyStringArrayList);
    when(msg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(msg.getSharedDeletedCount()).thenReturn(1);
    when(msg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(element).isValidUtf8();
    verify(element).toStringUtf8();
    verify(msg).getSharedDeletedCount();
    verify(msg).getSharedDeletedList();
    verify(msg).getSharedUpdatedCount();
    verify(msg).getSharedUpdatedList();
    assertEquals(
        "{\"deleted\":[\"String Utf8\"]}", actualConvertToPublishResult.getPayloadString());
    assertEquals(27, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(
        "{\"deleted\":[\"String Utf8\"]}".getBytes("UTF-8"),
        actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)} with {@code
   * AttributeUpdateNotificationMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(AttributeUpdateNotificationMsg)"})
  void testConvertToPublishWithAttributeUpdateNotificationMsg6() throws AdaptorException {
    // Arrange
    ByteString element = mock(ByteString.class);
    when(element.toStringUtf8()).thenThrow(new IllegalStateException());

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element);

    AttributeUpdateNotificationMsg msg = mock(AttributeUpdateNotificationMsg.class);
    when(msg.getSharedDeletedList()).thenReturn(lazyStringArrayList);
    when(msg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(msg.getSharedDeletedCount()).thenReturn(1);
    when(msg.getSharedUpdatedCount()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonCoapAdaptor.convertToPublish(msg));
    verify(element).toStringUtf8();
    verify(msg).getSharedDeletedCount();
    verify(msg).getSharedDeletedList();
    verify(msg).getSharedUpdatedCount();
    verify(msg).getSharedUpdatedList();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)} with {@code
   * AttributeUpdateNotificationMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(AttributeUpdateNotificationMsg)"})
  void testConvertToPublishWithAttributeUpdateNotificationMsg7()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(false);
    when(element.toStringUtf8()).thenReturn("String Utf8");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element);

    AttributeUpdateNotificationMsg msg = mock(AttributeUpdateNotificationMsg.class);
    when(msg.getSharedDeletedList()).thenReturn(lazyStringArrayList);
    when(msg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(msg.getSharedDeletedCount()).thenReturn(1);
    when(msg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(element).isValidUtf8();
    verify(element).toStringUtf8();
    verify(msg).getSharedDeletedCount();
    verify(msg).getSharedDeletedList();
    verify(msg).getSharedUpdatedCount();
    verify(msg).getSharedUpdatedList();
    assertEquals(
        "{\"deleted\":[\"String Utf8\"]}", actualConvertToPublishResult.getPayloadString());
    assertEquals(27, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(
        "{\"deleted\":[\"String Utf8\"]}".getBytes("UTF-8"),
        actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)} with {@code
   * AttributeUpdateNotificationMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(AttributeUpdateNotificationMsg)"})
  void testConvertToPublishWithAttributeUpdateNotificationMsg8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(true);
    when(element.toStringUtf8()).thenReturn("");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element);

    AttributeUpdateNotificationMsg msg = mock(AttributeUpdateNotificationMsg.class);
    when(msg.getSharedDeletedList()).thenReturn(lazyStringArrayList);
    when(msg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(msg.getSharedDeletedCount()).thenReturn(1);
    when(msg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(element).isValidUtf8();
    verify(element).toStringUtf8();
    verify(msg).getSharedDeletedCount();
    verify(msg).getSharedDeletedList();
    verify(msg).getSharedUpdatedCount();
    verify(msg).getSharedUpdatedList();
    assertEquals("{\"deleted\":[\"\"]}", actualConvertToPublishResult.getPayloadString());
    assertEquals(Short.SIZE, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(
        "{\"deleted\":[\"\"]}".getBytes("UTF-8"), actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)} with {@code
   * AttributeUpdateNotificationMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(AttributeUpdateNotificationMsg)"})
  void testConvertToPublishWithAttributeUpdateNotificationMsg9()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    JsonCoapAdaptor jsonCoapAdaptor = new JsonCoapAdaptor();

    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(true);
    when(element.toStringUtf8()).thenReturn("String Utf8");

    ByteString element2 = mock(ByteString.class);
    when(element2.isValidUtf8()).thenReturn(true);
    when(element2.toStringUtf8()).thenReturn("String Utf8");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element2);
    lazyStringArrayList.add(element);

    AttributeUpdateNotificationMsg msg = mock(AttributeUpdateNotificationMsg.class);
    when(msg.getSharedDeletedList()).thenReturn(lazyStringArrayList);
    when(msg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(msg.getSharedDeletedCount()).thenReturn(1);
    when(msg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(element2).isValidUtf8();
    verify(element).isValidUtf8();
    verify(element2).toStringUtf8();
    verify(element).toStringUtf8();
    verify(msg).getSharedDeletedCount();
    verify(msg).getSharedDeletedList();
    verify(msg).getSharedUpdatedCount();
    verify(msg).getSharedUpdatedList();
    assertEquals(
        "{\"deleted\":[\"String Utf8\",\"String Utf8\"]}",
        actualConvertToPublishResult.getPayloadString());
    assertEquals(41, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(
        "{\"deleted\":[\"String Utf8\",\"String Utf8\"]}".getBytes("UTF-8"),
        actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)} with {@code
   * AttributeUpdateNotificationMsg}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'; when DefaultInstance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(AttributeUpdateNotificationMsg)"})
  void testConvertToPublishWithAttributeUpdateNotificationMsg_whenDefaultInstance()
      throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult =
        jsonCoapAdaptor.convertToPublish(AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    assertEquals("{}", actualConvertToPublishResult.getPayloadString());
    assertEquals(2, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(new byte[] {'{', '}'}, actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg() throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult =
        jsonCoapAdaptor.convertToPublish(GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    assertEquals(132, actualConvertToPublishResult.getRawCode());
    assertEquals(ResponseCode.NOT_FOUND, actualConvertToPublishResult.getCode());
    assertTrue(actualConvertToPublishResult.isClientError());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg2()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    GetAttributeResponseMsg msg = mock(GetAttributeResponseMsg.class);
    when(msg.getClientAttributeListList()).thenReturn(new ArrayList<>());
    when(msg.getSharedAttributeListList()).thenReturn(new ArrayList<>());
    when(msg.getSharedStateMsg()).thenReturn(false);
    when(msg.getClientAttributeListCount()).thenReturn(1);
    when(msg.getSharedAttributeListCount()).thenReturn(1);

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg, atLeast(1)).getClientAttributeListCount();
    verify(msg).getClientAttributeListList();
    verify(msg).getSharedAttributeListCount();
    verify(msg).getSharedAttributeListList();
    verify(msg).getSharedStateMsg();
    assertEquals("{\"client\":{},\"shared\":{}}", actualConvertToPublishResult.getPayloadString());
    assertEquals(25, actualConvertToPublishResult.getPayloadSize());
    assertEquals(69, actualConvertToPublishResult.getRawCode());
    assertEquals(ResponseCode.CONTENT, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.isError());
    assertTrue(actualConvertToPublishResult.isSuccess());
    assertArrayEquals(
        "{\"client\":{},\"shared\":{}}".getBytes("UTF-8"),
        actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg3() throws AdaptorException {
    // Arrange
    GetAttributeResponseMsg msg = mock(GetAttributeResponseMsg.class);
    when(msg.getClientAttributeListList()).thenThrow(new IllegalStateException());
    when(msg.getSharedStateMsg()).thenReturn(false);
    when(msg.getClientAttributeListCount()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonCoapAdaptor.convertToPublish(msg));
    verify(msg, atLeast(1)).getClientAttributeListCount();
    verify(msg).getClientAttributeListList();
    verify(msg).getSharedStateMsg();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg4() throws AdaptorException {
    // Arrange
    GetAttributeResponseMsg msg = mock(GetAttributeResponseMsg.class);
    when(msg.getError()).thenReturn("");
    when(msg.getSharedAttributeListList()).thenReturn(new ArrayList<>());
    when(msg.getSharedStateMsg()).thenReturn(true);

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg).getError();
    verify(msg).getSharedAttributeListList();
    verify(msg).getSharedStateMsg();
    assertEquals("{}", actualConvertToPublishResult.getPayloadString());
    assertEquals(2, actualConvertToPublishResult.getPayloadSize());
    assertEquals(69, actualConvertToPublishResult.getRawCode());
    assertEquals(ResponseCode.CONTENT, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.isError());
    assertTrue(actualConvertToPublishResult.isSuccess());
    assertArrayEquals(new byte[] {'{', '}'}, actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg5() throws AdaptorException {
    // Arrange
    GetAttributeResponseMsg msg = mock(GetAttributeResponseMsg.class);
    when(msg.getError()).thenReturn("An error occurred");
    when(msg.getSharedStateMsg()).thenReturn(true);

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg).getError();
    verify(msg).getSharedStateMsg();
    assertEquals("", actualConvertToPublishResult.getPayloadString());
    assertEquals(0, actualConvertToPublishResult.getPayloadSize());
    assertEquals(160, actualConvertToPublishResult.getRawCode());
    assertEquals(ResponseCode.INTERNAL_SERVER_ERROR, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.isSuccess());
    assertTrue(actualConvertToPublishResult.isError());
    assertTrue(actualConvertToPublishResult.isServerError());
    assertArrayEquals(new byte[] {}, actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg6() throws AdaptorException {
    // Arrange
    GetAttributeResponseMsg msg = mock(GetAttributeResponseMsg.class);
    when(msg.getError()).thenThrow(new IllegalStateException());
    when(msg.getSharedStateMsg()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonCoapAdaptor.convertToPublish(msg));
    verify(msg).getError();
    verify(msg).getSharedStateMsg();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'; given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg_givenEmptyString() throws AdaptorException {
    // Arrange
    GetAttributeResponseMsg msg = mock(GetAttributeResponseMsg.class);
    when(msg.getError()).thenReturn("");
    when(msg.getSharedAttributeListList()).thenThrow(new IllegalStateException());
    when(msg.getSharedStateMsg()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonCoapAdaptor.convertToPublish(msg));
    verify(msg).getError();
    verify(msg).getSharedAttributeListList();
    verify(msg).getSharedStateMsg();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <ul>
   *   <li>Given {@link JsonCoapAdaptor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'; given JsonCoapAdaptor (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg_givenJsonCoapAdaptor()
      throws AdaptorException {
    // Arrange
    JsonCoapAdaptor jsonCoapAdaptor = new JsonCoapAdaptor();

    GetAttributeResponseMsg msg = mock(GetAttributeResponseMsg.class);
    when(msg.getSharedAttributeListList()).thenThrow(new IllegalStateException());
    when(msg.getSharedStateMsg()).thenReturn(false);
    when(msg.getClientAttributeListCount()).thenReturn(-1);
    when(msg.getSharedAttributeListCount()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonCoapAdaptor.convertToPublish(msg));
    verify(msg, atLeast(1)).getClientAttributeListCount();
    verify(msg).getSharedAttributeListCount();
    verify(msg).getSharedAttributeListList();
    verify(msg).getSharedStateMsg();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <ul>
   *   <li>Then return PayloadString is {@code {"client":{}}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'; then return PayloadString is '{\"client\":{}}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg_thenReturnPayloadStringIsClient()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    GetAttributeResponseMsg msg = mock(GetAttributeResponseMsg.class);
    when(msg.getClientAttributeListList()).thenReturn(new ArrayList<>());
    when(msg.getSharedStateMsg()).thenReturn(false);
    when(msg.getClientAttributeListCount()).thenReturn(1);
    when(msg.getSharedAttributeListCount()).thenReturn(0);

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg, atLeast(1)).getClientAttributeListCount();
    verify(msg).getClientAttributeListList();
    verify(msg).getSharedAttributeListCount();
    verify(msg).getSharedStateMsg();
    assertEquals("{\"client\":{}}", actualConvertToPublishResult.getPayloadString());
    assertEquals(13, actualConvertToPublishResult.getPayloadSize());
    assertEquals(69, actualConvertToPublishResult.getRawCode());
    assertEquals(ResponseCode.CONTENT, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.isError());
    assertTrue(actualConvertToPublishResult.isSuccess());
    assertArrayEquals(
        "{\"client\":{}}".getBytes("UTF-8"), actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <ul>
   *   <li>Then return PayloadString is {@code {"shared":{}}}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'; then return PayloadString is '{\"shared\":{}}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response JsonCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg_thenReturnPayloadStringIsShared()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    GetAttributeResponseMsg msg = mock(GetAttributeResponseMsg.class);
    when(msg.getSharedAttributeListList()).thenReturn(new ArrayList<>());
    when(msg.getSharedStateMsg()).thenReturn(false);
    when(msg.getClientAttributeListCount()).thenReturn(0);
    when(msg.getSharedAttributeListCount()).thenReturn(1);

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg, atLeast(1)).getClientAttributeListCount();
    verify(msg, atLeast(1)).getSharedAttributeListCount();
    verify(msg).getSharedAttributeListList();
    verify(msg).getSharedStateMsg();
    assertEquals("{\"shared\":{}}", actualConvertToPublishResult.getPayloadString());
    assertEquals(13, actualConvertToPublishResult.getPayloadSize());
    assertEquals(69, actualConvertToPublishResult.getRawCode());
    assertEquals(ResponseCode.CONTENT, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.isError());
    assertTrue(actualConvertToPublishResult.isSuccess());
    assertArrayEquals(
        "{\"shared\":{}}".getBytes("UTF-8"), actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(ToDeviceRpcRequestMsg, Builder)} with {@code
   * ToDeviceRpcRequestMsg}, {@code Builder}.
   *
   * <p>Method under test: {@link
   * JsonCoapAdaptor#convertToPublish(TransportProtos.ToDeviceRpcRequestMsg, Builder)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(ToDeviceRpcRequestMsg, Builder) with 'ToDeviceRpcRequestMsg', 'Builder'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Response JsonCoapAdaptor.convertToPublish(TransportProtos.ToDeviceRpcRequestMsg, Builder)"
  })
  void testConvertToPublishWithToDeviceRpcRequestMsgBuilder()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult =
        jsonCoapAdaptor.convertToPublish(ToDeviceRpcRequestMsg.getDefaultInstance(), null);

    // Assert
    assertEquals(
        "{\"id\":0,\"method\":\"\",\"params\":null}",
        actualConvertToPublishResult.getPayloadString());
    assertEquals(34, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(
        "{\"id\":0,\"method\":\"\",\"params\":null}".getBytes("UTF-8"),
        actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(ToDeviceRpcRequestMsg, Builder)} with {@code
   * ToDeviceRpcRequestMsg}, {@code Builder}.
   *
   * <p>Method under test: {@link
   * JsonCoapAdaptor#convertToPublish(TransportProtos.ToDeviceRpcRequestMsg, Builder)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(ToDeviceRpcRequestMsg, Builder) with 'ToDeviceRpcRequestMsg', 'Builder'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Response JsonCoapAdaptor.convertToPublish(TransportProtos.ToDeviceRpcRequestMsg, Builder)"
  })
  void testConvertToPublishWithToDeviceRpcRequestMsgBuilder2()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    ToDeviceRpcRequestMsg msg = mock(ToDeviceRpcRequestMsg.class);
    when(msg.getRequestId()).thenReturn(1);
    when(msg.getMethodName()).thenReturn("Method Name");
    when(msg.getParams()).thenReturn("Params");

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg, null);

    // Assert
    verify(msg).getMethodName();
    verify(msg).getParams();
    verify(msg).getRequestId();
    assertEquals(
        "{\"id\":1,\"method\":\"Method Name\",\"params\":\"Params\"}",
        actualConvertToPublishResult.getPayloadString());
    assertEquals(49, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(
        "{\"id\":1,\"method\":\"Method Name\",\"params\":\"Params\"}".getBytes("UTF-8"),
        actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(ToDeviceRpcRequestMsg, Builder)} with {@code
   * ToDeviceRpcRequestMsg}, {@code Builder}.
   *
   * <p>Method under test: {@link
   * JsonCoapAdaptor#convertToPublish(TransportProtos.ToDeviceRpcRequestMsg, Builder)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(ToDeviceRpcRequestMsg, Builder) with 'ToDeviceRpcRequestMsg', 'Builder'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Response JsonCoapAdaptor.convertToPublish(TransportProtos.ToDeviceRpcRequestMsg, Builder)"
  })
  void testConvertToPublishWithToDeviceRpcRequestMsgBuilder3()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    ToDeviceRpcRequestMsg msg = mock(ToDeviceRpcRequestMsg.class);
    when(msg.getRequestId()).thenReturn(1);
    when(msg.getMethodName()).thenReturn("Method Name");
    when(msg.getParams()).thenReturn("id");

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg, null);

    // Assert
    verify(msg).getMethodName();
    verify(msg).getParams();
    verify(msg).getRequestId();
    assertEquals(
        "{\"id\":1,\"method\":\"Method Name\",\"params\":\"id\"}",
        actualConvertToPublishResult.getPayloadString());
    assertEquals(45, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(
        "{\"id\":1,\"method\":\"Method Name\",\"params\":\"id\"}".getBytes("UTF-8"),
        actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(ToDeviceRpcRequestMsg, Builder)} with {@code
   * ToDeviceRpcRequestMsg}, {@code Builder}.
   *
   * <p>Method under test: {@link
   * JsonCoapAdaptor#convertToPublish(TransportProtos.ToDeviceRpcRequestMsg, Builder)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(ToDeviceRpcRequestMsg, Builder) with 'ToDeviceRpcRequestMsg', 'Builder'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Response JsonCoapAdaptor.convertToPublish(TransportProtos.ToDeviceRpcRequestMsg, Builder)"
  })
  void testConvertToPublishWithToDeviceRpcRequestMsgBuilder4()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    ToDeviceRpcRequestMsg msg = mock(ToDeviceRpcRequestMsg.class);
    when(msg.getRequestId()).thenReturn(1);
    when(msg.getMethodName()).thenReturn("Method Name");
    when(msg.getParams()).thenReturn("foo");

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg, null);

    // Assert
    verify(msg).getMethodName();
    verify(msg).getParams();
    verify(msg).getRequestId();
    assertEquals(
        "{\"id\":1,\"method\":\"Method Name\",\"params\":\"foo\"}",
        actualConvertToPublishResult.getPayloadString());
    assertEquals(46, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(
        "{\"id\":1,\"method\":\"Method Name\",\"params\":\"foo\"}".getBytes("UTF-8"),
        actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(ToDeviceRpcRequestMsg, Builder)} with {@code
   * ToDeviceRpcRequestMsg}, {@code Builder}.
   *
   * <p>Method under test: {@link
   * JsonCoapAdaptor#convertToPublish(TransportProtos.ToDeviceRpcRequestMsg, Builder)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(ToDeviceRpcRequestMsg, Builder) with 'ToDeviceRpcRequestMsg', 'Builder'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Response JsonCoapAdaptor.convertToPublish(TransportProtos.ToDeviceRpcRequestMsg, Builder)"
  })
  void testConvertToPublishWithToDeviceRpcRequestMsgBuilder5()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    ToDeviceRpcRequestMsg msg = mock(ToDeviceRpcRequestMsg.class);
    when(msg.getRequestId()).thenReturn(1);
    when(msg.getMethodName()).thenReturn("Method Name");
    when(msg.getParams()).thenReturn("42");

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg, null);

    // Assert
    verify(msg).getMethodName();
    verify(msg).getParams();
    verify(msg).getRequestId();
    assertEquals(
        "{\"id\":1,\"method\":\"Method Name\",\"params\":42}",
        actualConvertToPublishResult.getPayloadString());
    assertEquals(43, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(
        "{\"id\":1,\"method\":\"Method Name\",\"params\":42}".getBytes("UTF-8"),
        actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(ToServerRpcResponseMsg)} with {@code
   * ToServerRpcResponseMsg}.
   *
   * <p>Method under test: {@link
   * JsonCoapAdaptor#convertToPublish(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(ToServerRpcResponseMsg) with 'ToServerRpcResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Response JsonCoapAdaptor.convertToPublish(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testConvertToPublishWithToServerRpcResponseMsg()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    ToServerRpcResponseMsg msg = mock(ToServerRpcResponseMsg.class);
    when(msg.getError()).thenReturn("An error occurred");

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg, atLeast(1)).getError();
    assertEquals(
        "{\"error\":\"An error occurred\"}", actualConvertToPublishResult.getPayloadString());
    assertEquals(29, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(
        "{\"error\":\"An error occurred\"}".getBytes("UTF-8"),
        actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(ToServerRpcResponseMsg)} with {@code
   * ToServerRpcResponseMsg}.
   *
   * <ul>
   *   <li>Then return PayloadString is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonCoapAdaptor#convertToPublish(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(ToServerRpcResponseMsg) with 'ToServerRpcResponseMsg'; then return PayloadString is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Response JsonCoapAdaptor.convertToPublish(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testConvertToPublishWithToServerRpcResponseMsg_thenReturnPayloadStringIs42()
      throws AdaptorException {
    // Arrange
    ToServerRpcResponseMsg msg = mock(ToServerRpcResponseMsg.class);
    when(msg.getError()).thenReturn("");
    when(msg.getPayload()).thenReturn("42");

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg).getError();
    verify(msg).getPayload();
    assertEquals("42", actualConvertToPublishResult.getPayloadString());
    assertEquals(2, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(new byte[] {'4', '2'}, actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(ToServerRpcResponseMsg)} with {@code
   * ToServerRpcResponseMsg}.
   *
   * <ul>
   *   <li>Then return PayloadString is {@code "error"}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonCoapAdaptor#convertToPublish(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(ToServerRpcResponseMsg) with 'ToServerRpcResponseMsg'; then return PayloadString is '\"error\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Response JsonCoapAdaptor.convertToPublish(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testConvertToPublishWithToServerRpcResponseMsg_thenReturnPayloadStringIsError()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    ToServerRpcResponseMsg msg = mock(ToServerRpcResponseMsg.class);
    when(msg.getError()).thenReturn("");
    when(msg.getPayload()).thenReturn("error");

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg).getError();
    verify(msg).getPayload();
    assertEquals("\"error\"", actualConvertToPublishResult.getPayloadString());
    assertEquals(7, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals("\"error\"".getBytes("UTF-8"), actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(ToServerRpcResponseMsg)} with {@code
   * ToServerRpcResponseMsg}.
   *
   * <ul>
   *   <li>Then return PayloadString is {@code "foo"}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonCoapAdaptor#convertToPublish(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(ToServerRpcResponseMsg) with 'ToServerRpcResponseMsg'; then return PayloadString is '\"foo\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Response JsonCoapAdaptor.convertToPublish(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testConvertToPublishWithToServerRpcResponseMsg_thenReturnPayloadStringIsFoo()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    ToServerRpcResponseMsg msg = mock(ToServerRpcResponseMsg.class);
    when(msg.getError()).thenReturn("");
    when(msg.getPayload()).thenReturn("foo");

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg).getError();
    verify(msg).getPayload();
    assertEquals("\"foo\"", actualConvertToPublishResult.getPayloadString());
    assertEquals(5, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals("\"foo\"".getBytes("UTF-8"), actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(ToServerRpcResponseMsg)} with {@code
   * ToServerRpcResponseMsg}.
   *
   * <ul>
   *   <li>Then return PayloadString is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonCoapAdaptor#convertToPublish(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(ToServerRpcResponseMsg) with 'ToServerRpcResponseMsg'; then return PayloadString is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Response JsonCoapAdaptor.convertToPublish(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testConvertToPublishWithToServerRpcResponseMsg_thenReturnPayloadStringIsNull()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult =
        jsonCoapAdaptor.convertToPublish(ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    assertEquals("null", actualConvertToPublishResult.getPayloadString());
    assertEquals(4, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals("null".getBytes("UTF-8"), actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToPublish(ToServerRpcResponseMsg)} with {@code
   * ToServerRpcResponseMsg}.
   *
   * <ul>
   *   <li>Then return PayloadString is {@code "Payload"}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonCoapAdaptor#convertToPublish(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(ToServerRpcResponseMsg) with 'ToServerRpcResponseMsg'; then return PayloadString is '\"Payload\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Response JsonCoapAdaptor.convertToPublish(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testConvertToPublishWithToServerRpcResponseMsg_thenReturnPayloadStringIsPayload()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    ToServerRpcResponseMsg msg = mock(ToServerRpcResponseMsg.class);
    when(msg.getError()).thenReturn("");
    when(msg.getPayload()).thenReturn("Payload");

    // Act
    Response actualConvertToPublishResult = jsonCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg).getError();
    verify(msg).getPayload();
    assertEquals("\"Payload\"", actualConvertToPublishResult.getPayloadString());
    assertEquals(9, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals("\"Payload\"".getBytes("UTF-8"), actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link JsonCoapAdaptor#getContentFormat()}.
   *
   * <p>Method under test: {@link JsonCoapAdaptor#getContentFormat()}
   */
  @Test
  @DisplayName("Test getContentFormat()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsonCoapAdaptor.getContentFormat()"})
  void testGetContentFormat() {
    // Arrange, Act and Assert
    assertEquals(50, jsonCoapAdaptor.getContentFormat());
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Request} {@link Request#getPayloadString()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given '42'; when Request getPayloadString() return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_given42_whenRequestGetPayloadStringReturn42()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("42");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link Request} {@link Request#getPayloadString()} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given 'foo'; when Request getPayloadString() return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenFoo_whenRequestGetPayloadStringReturnFoo()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("foo");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Request} {@link Request#getPayloadString()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given 'null'; when Request getPayloadString() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenNull_whenRequestGetPayloadStringReturnNull()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn(null);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@code Payload String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given 'Payload String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenPayloadString() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayloadString()).thenReturn("Payload String");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayloadString();
  }

  /**
   * Test {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>When newDelete.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); when newDelete; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_whenNewDelete_thenThrowAdaptorException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonCoapAdaptor.convertToProvisionRequestMsg(sessionId, Request.newDelete()));
  }
}
