package org.thingsboard.server.transport.coap.adaptors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors.Descriptor;
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
import org.thingsboard.server.gen.transport.TransportProtos.CredentialsDataProto;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ProvisionDeviceCredentialsMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ProvisionDeviceRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.ToServerRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToServerRpcResponseMsg;
import org.thingsboard.server.gen.transport.coap.MeasurementsProtos;
import org.thingsboard.server.gen.transport.coap.MeasurementsProtos.ProtoChannel;

@ContextConfiguration(classes = {ProtoCoapAdaptor.class})
@ExtendWith(SpringExtension.class)
class ProtoCoapAdaptorDiffblueTest {
  @Autowired private ProtoCoapAdaptor protoCoapAdaptor;

  /**
   * Test {@link ProtoCoapAdaptor#convertToGetAttributes(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()} addUriQuery {@code Argument}.
   *   <li>Then calls {@link Request#getOptions()}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToGetAttributes(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(UUID, Request); given OptionSet() addUriQuery 'Argument'; then calls getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg ProtoCoapAdaptor.convertToGetAttributes(UUID, Request)"
  })
  void testConvertToGetAttributes_givenOptionSetAddUriQueryArgument_thenCallsGetOptions()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    OptionSet optionSet = new OptionSet();
    optionSet.addUriQuery("Argument");

    Request inbound = mock(Request.class);
    when(inbound.getOptions()).thenReturn(optionSet);

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        protoCoapAdaptor.convertToGetAttributes(sessionId, inbound);

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
   * Test {@link ProtoCoapAdaptor#convertToGetAttributes(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()}.
   *   <li>Then calls {@link Request#getOptions()}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToGetAttributes(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(UUID, Request); given OptionSet(); then calls getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg ProtoCoapAdaptor.convertToGetAttributes(UUID, Request)"
  })
  void testConvertToGetAttributes_givenOptionSet_thenCallsGetOptions() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getOptions()).thenReturn(new OptionSet());

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        protoCoapAdaptor.convertToGetAttributes(sessionId, inbound);

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
   * Test {@link ProtoCoapAdaptor#convertToGetAttributes(UUID, Request)}.
   *
   * <ul>
   *   <li>When newDelete.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToGetAttributes(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(UUID, Request); when newDelete")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg ProtoCoapAdaptor.convertToGetAttributes(UUID, Request)"
  })
  void testConvertToGetAttributes_whenNewDelete() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    GetAttributeRequestMsg actualConvertToGetAttributesResult =
        protoCoapAdaptor.convertToGetAttributes(sessionId, Request.newDelete());

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
   * Test {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Uri Path}.
   *   <li>Then calls {@link OptionSet#getUriPath()}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request,
   * Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToDeviceRpcResponse(UUID, Request, Descriptor); given ArrayList() add 'Uri Path'; then calls getUriPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToDeviceRpcResponseMsg ProtoCoapAdaptor.convertToDeviceRpcResponse(UUID, Request, Descriptor)"
  })
  void testConvertToDeviceRpcResponse_givenArrayListAddUriPath_thenCallsGetUriPath()
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
    when(inbound.getOptions()).thenReturn(optionSet);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            protoCoapAdaptor.convertToDeviceRpcResponse(
                sessionId, inbound, ProtoChannel.getDescriptor()));
    verify(inbound).getOptions();
    verify(optionSet).getUriPath();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Uri Path}.
   *   <li>Then calls {@link OptionSet#getUriPath()}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request,
   * Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToDeviceRpcResponse(UUID, Request, Descriptor); given ArrayList() add 'Uri Path'; then calls getUriPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToDeviceRpcResponseMsg ProtoCoapAdaptor.convertToDeviceRpcResponse(UUID, Request, Descriptor)"
  })
  void testConvertToDeviceRpcResponse_givenArrayListAddUriPath_thenCallsGetUriPath2()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Uri Path");
    stringList.add("Uri Path");
    stringList.add("Uri Path");
    stringList.add("Uri Path");

    OptionSet optionSet = mock(OptionSet.class);
    when(optionSet.getUriPath()).thenReturn(stringList);

    Request inbound = mock(Request.class);
    when(inbound.getOptions()).thenReturn(optionSet);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            protoCoapAdaptor.convertToDeviceRpcResponse(
                sessionId, inbound, ProtoChannel.getDescriptor()));
    verify(inbound).getOptions();
    verify(optionSet).getUriPath();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request,
   * Descriptor)}
   */
  @Test
  @DisplayName("Test convertToDeviceRpcResponse(UUID, Request, Descriptor); given OptionSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToDeviceRpcResponseMsg ProtoCoapAdaptor.convertToDeviceRpcResponse(UUID, Request, Descriptor)"
  })
  void testConvertToDeviceRpcResponse_givenOptionSet() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getOptions()).thenReturn(new OptionSet());

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            protoCoapAdaptor.convertToDeviceRpcResponse(
                sessionId, inbound, ProtoChannel.getDescriptor()));
    verify(inbound).getOptions();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request,
   * Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToDeviceRpcResponse(UUID, Request, Descriptor); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToDeviceRpcResponseMsg ProtoCoapAdaptor.convertToDeviceRpcResponse(UUID, Request, Descriptor)"
  })
  void testConvertToDeviceRpcResponse_givenRuntimeException_thenThrowRuntimeException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getOptions()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            protoCoapAdaptor.convertToDeviceRpcResponse(
                sessionId, inbound, ProtoChannel.getDescriptor()));
    verify(inbound).getOptions();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request, Descriptor)}.
   *
   * <ul>
   *   <li>When newDelete.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToDeviceRpcResponse(UUID, Request,
   * Descriptor)}
   */
  @Test
  @DisplayName(
      "Test convertToDeviceRpcResponse(UUID, Request, Descriptor); when newDelete; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToDeviceRpcResponseMsg ProtoCoapAdaptor.convertToDeviceRpcResponse(UUID, Request, Descriptor)"
  })
  void testConvertToDeviceRpcResponse_whenNewDelete_thenThrowAdaptorException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            protoCoapAdaptor.convertToDeviceRpcResponse(
                sessionId, Request.newDelete(), ProtoChannel.getDescriptor()));
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@code A A A A A A A A} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(UUID, Request); given 'A A A A A A A A' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg ProtoCoapAdaptor.convertToServerRpcRequest(UUID, Request)"
  })
  void testConvertToServerRpcRequest_givenAAAAAAAABytesIsUtf8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(UUID, Request); given array of byte with minus one and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg ProtoCoapAdaptor.convertToServerRpcRequest(UUID, Request)"
  })
  void testConvertToServerRpcRequest_givenArrayOfByteWithMinusOneAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(UUID, Request); given array of byte with zero and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg ProtoCoapAdaptor.convertToServerRpcRequest(UUID, Request)"
  })
  void testConvertToServerRpcRequest_givenArrayOfByteWithZeroAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg ProtoCoapAdaptor.convertToServerRpcRequest(UUID, Request)"
  })
  void testConvertToServerRpcRequest_givenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   *
   * <ul>
   *   <li>Given lf.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); given lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg ProtoCoapAdaptor.convertToServerRpcRequest(UUID, Request)"
  })
  void testConvertToServerRpcRequest_givenLf() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload())
        .thenReturn(
            new byte[] {
              'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', 1, 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); given 'XAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg ProtoCoapAdaptor.convertToServerRpcRequest(UUID, Request)"
  })
  void testConvertToServerRpcRequest_givenXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("\nXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@code XXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); given 'XXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg ProtoCoapAdaptor.convertToServerRpcRequest(UUID, Request)"
  })
  void testConvertToServerRpcRequest_givenXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("XXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToServerRpcRequest(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   *
   * <ul>
   *   <li>When newDelete.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); when newDelete")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg ProtoCoapAdaptor.convertToServerRpcRequest(UUID, Request)"
  })
  void testConvertToServerRpcRequest_whenNewDelete() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        protoCoapAdaptor.convertToServerRpcRequest(sessionId, Request.newDelete());

    // Assert
    assertEquals(
        3, actualConvertToServerRpcRequestResult.getDescriptorForType().getFields().size());
    ToServerRpcRequestMsg actualDefaultInstanceForType =
        actualConvertToServerRpcRequestResult.getDefaultInstanceForType();
    assertEquals(actualConvertToServerRpcRequestResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToServerRpcRequestResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}.
   *
   * <ul>
   *   <li>When newFetch.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToServerRpcRequest(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(UUID, Request); when newFetch")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ToServerRpcRequestMsg ProtoCoapAdaptor.convertToServerRpcRequest(UUID, Request)"
  })
  void testConvertToServerRpcRequest_whenNewFetch() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        protoCoapAdaptor.convertToServerRpcRequest(sessionId, Request.newFetch());

    // Assert
    assertEquals(
        3, actualConvertToServerRpcRequestResult.getDescriptorForType().getFields().size());
    ToServerRpcRequestMsg actualDefaultInstanceForType =
        actualConvertToServerRpcRequestResult.getDefaultInstanceForType();
    assertEquals(actualConvertToServerRpcRequestResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToServerRpcRequestResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given {@code A A A A A A A A} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'A A A A A A A A' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg ProtoCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_givenAAAAAAAABytesIsUtf8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("A\nA\nA\nA\nA\nA\nA\nA\n".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            protoCoapAdaptor.convertToClaimDevice(
                sessionId, inbound, SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDevice(UUID, Request, SessionInfoProto); given array of byte with minus one and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg ProtoCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_givenArrayOfByteWithMinusOneAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            protoCoapAdaptor.convertToClaimDevice(
                sessionId, inbound, SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with zero and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDevice(UUID, Request, SessionInfoProto); given array of byte with zero and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg ProtoCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_givenArrayOfByteWithZeroAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            protoCoapAdaptor.convertToClaimDevice(
                sessionId, inbound, SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg ProtoCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_givenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            protoCoapAdaptor.convertToClaimDevice(
                sessionId, inbound, SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given lf.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); given lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg ProtoCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_givenLf() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload())
        .thenReturn(
            new byte[] {
              'A', '\n', 'A', '\n', 'A', '\n', 'A', '\n', 'A', 1, 'A', '\n', 'A', '\n', 'A', '\n'
            });

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            protoCoapAdaptor.convertToClaimDevice(
                sessionId, inbound, SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'XAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg ProtoCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_givenXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("\nXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            protoCoapAdaptor.convertToClaimDevice(
                sessionId, inbound, SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>Given {@code XXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDevice(UUID, Request, SessionInfoProto); given 'XXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg ProtoCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_givenXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("XXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () ->
            protoCoapAdaptor.convertToClaimDevice(
                sessionId, inbound, SessionInfoProto.getDefaultInstance()));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>Then return DescriptorForType Fields size is four.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDevice(UUID, Request, SessionInfoProto); then return DescriptorForType Fields size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg ProtoCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_thenReturnDescriptorForTypeFieldsSizeIsFour()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceResult =
        protoCoapAdaptor.convertToClaimDevice(
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
   * Test {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request, SessionInfoProto)}.
   *
   * <ul>
   *   <li>When newFetch.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToClaimDevice(UUID, Request,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(UUID, Request, SessionInfoProto); when newFetch")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ClaimDeviceMsg ProtoCoapAdaptor.convertToClaimDevice(UUID, Request, TransportProtos.SessionInfoProto)"
  })
  void testConvertToClaimDevice_whenNewFetch() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    ClaimDeviceMsg actualConvertToClaimDeviceResult =
        protoCoapAdaptor.convertToClaimDevice(
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
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and two.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given array of byte with 'A' and two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithAAndTwo() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload())
        .thenReturn(new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with lf and two.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given array of byte with lf and two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithLfAndTwo() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload())
        .thenReturn(new byte[] {'\n', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with minus one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given array of byte with minus one and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithMinusOneAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@code "} and two.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given array of byte with '\"' and two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithQuotationMarkAndTwo()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload())
        .thenReturn(new byte[] {'"', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@code "} and zero.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given array of byte with '\"' and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithQuotationMarkAndZero()
      throws AdaptorException {
    // Arrange
    ProtoCoapAdaptor protoCoapAdaptor = new ProtoCoapAdaptor();
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[] {'"', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with sixteen and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given array of byte with sixteen and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithSixteenAndX() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[] {16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with twenty-six and two.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given array of byte with twenty-six and two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithTwentySixAndTwo()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload())
        .thenReturn(new byte[] {26, 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with twenty-six and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given array of byte with twenty-six and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithTwentySixAndX()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[] {26, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with twenty-six and zero.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given array of byte with twenty-six and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenArrayOfByteWithTwentySixAndZero()
      throws AdaptorException {
    // Arrange
    ProtoCoapAdaptor protoCoapAdaptor = new ProtoCoapAdaptor();
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn(new byte[] {26, 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); given 'XAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("\nXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@code "XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given '\"XAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenXaxaxaxBytesIsUtf82()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("\"XAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@code (XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given '(XAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenXaxaxaxBytesIsUtf83()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("(XAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>Given {@code XXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(UUID, Request); given 'XXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_givenXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    Request inbound = mock(Request.class);
    when(inbound.getPayload()).thenReturn("XXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, inbound));
    verify(inbound).getPayload();
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>When newDelete.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); when newDelete")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_whenNewDelete() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    ProvisionDeviceRequestMsg actualConvertToProvisionRequestMsgResult =
        protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, Request.newDelete());

    // Assert
    ProvisionDeviceRequestMsg actualDefaultInstanceForType =
        actualConvertToProvisionRequestMsgResult.getDefaultInstanceForType();
    assertEquals(actualConvertToProvisionRequestMsgResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToProvisionRequestMsgResult.getUnknownFields();
    CredentialsDataProto credentialsDataProto =
        actualConvertToProvisionRequestMsgResult.getCredentialsDataProto();
    assertSame(unknownFields, credentialsDataProto.getUnknownFields());
    ProvisionDeviceCredentialsMsg provisionDeviceCredentialsMsg =
        actualConvertToProvisionRequestMsgResult.getProvisionDeviceCredentialsMsg();
    assertSame(unknownFields, provisionDeviceCredentialsMsg.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
    CredentialsDataProto actualDefaultInstanceForType3 =
        credentialsDataProto.getDefaultInstanceForType();
    assertSame(credentialsDataProto, actualDefaultInstanceForType3);
    assertSame(
        credentialsDataProto,
        actualConvertToProvisionRequestMsgResult.getCredentialsDataProtoOrBuilder());
    ProvisionDeviceCredentialsMsg actualDefaultInstanceForType4 =
        provisionDeviceCredentialsMsg.getDefaultInstanceForType();
    assertSame(provisionDeviceCredentialsMsg, actualDefaultInstanceForType4);
    assertSame(
        provisionDeviceCredentialsMsg,
        actualConvertToProvisionRequestMsgResult.getProvisionDeviceCredentialsMsgOrBuilder());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}.
   *
   * <ul>
   *   <li>When newFetch.
   * </ul>
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToProvisionRequestMsg(UUID, Request)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(UUID, Request); when newFetch")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoCoapAdaptor.convertToProvisionRequestMsg(UUID, Request)"
  })
  void testConvertToProvisionRequestMsg_whenNewFetch() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    ProvisionDeviceRequestMsg actualConvertToProvisionRequestMsgResult =
        protoCoapAdaptor.convertToProvisionRequestMsg(sessionId, Request.newFetch());

    // Assert
    ProvisionDeviceRequestMsg actualDefaultInstanceForType =
        actualConvertToProvisionRequestMsgResult.getDefaultInstanceForType();
    assertEquals(actualConvertToProvisionRequestMsgResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualConvertToProvisionRequestMsgResult.getUnknownFields();
    CredentialsDataProto credentialsDataProto =
        actualConvertToProvisionRequestMsgResult.getCredentialsDataProto();
    assertSame(unknownFields, credentialsDataProto.getUnknownFields());
    ProvisionDeviceCredentialsMsg provisionDeviceCredentialsMsg =
        actualConvertToProvisionRequestMsgResult.getProvisionDeviceCredentialsMsg();
    assertSame(unknownFields, provisionDeviceCredentialsMsg.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
    CredentialsDataProto actualDefaultInstanceForType3 =
        credentialsDataProto.getDefaultInstanceForType();
    assertSame(credentialsDataProto, actualDefaultInstanceForType3);
    assertSame(
        credentialsDataProto,
        actualConvertToProvisionRequestMsgResult.getCredentialsDataProtoOrBuilder());
    ProvisionDeviceCredentialsMsg actualDefaultInstanceForType4 =
        provisionDeviceCredentialsMsg.getDefaultInstanceForType();
    assertSame(provisionDeviceCredentialsMsg, actualDefaultInstanceForType4);
    assertSame(
        provisionDeviceCredentialsMsg,
        actualConvertToProvisionRequestMsgResult.getProvisionDeviceCredentialsMsgOrBuilder());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)} with {@code
   * AttributeUpdateNotificationMsg}.
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response ProtoCoapAdaptor.convertToPublish(AttributeUpdateNotificationMsg)"})
  void testConvertToPublishWithAttributeUpdateNotificationMsg() throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult =
        protoCoapAdaptor.convertToPublish(AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    assertEquals("", actualConvertToPublishResult.getPayloadString());
    assertEquals(0, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(new byte[] {}, actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)} with {@code
   * AttributeUpdateNotificationMsg}.
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToPublish(AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response ProtoCoapAdaptor.convertToPublish(AttributeUpdateNotificationMsg)"})
  void testConvertToPublishWithAttributeUpdateNotificationMsg2()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    AttributeUpdateNotificationMsg msg = mock(AttributeUpdateNotificationMsg.class);
    when(msg.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Response actualConvertToPublishResult = protoCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg).toByteArray();
    assertEquals("AXAXAXAX", actualConvertToPublishResult.getPayloadString());
    assertEquals(8, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response ProtoCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg() throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult =
        protoCoapAdaptor.convertToPublish(GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    assertEquals(132, actualConvertToPublishResult.getRawCode());
    assertEquals(ResponseCode.NOT_FOUND, actualConvertToPublishResult.getCode());
    assertTrue(actualConvertToPublishResult.isClientError());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response ProtoCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg2() throws AdaptorException {
    // Arrange
    GetAttributeResponseMsg msg = mock(GetAttributeResponseMsg.class);
    when(msg.getError()).thenReturn("");
    when(msg.getSharedAttributeListList()).thenReturn(new ArrayList<>());
    when(msg.getSharedStateMsg()).thenReturn(true);

    // Act
    Response actualConvertToPublishResult = protoCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg).getError();
    verify(msg).getSharedAttributeListList();
    verify(msg).getSharedStateMsg();
    assertEquals("", actualConvertToPublishResult.getPayloadString());
    assertEquals(0, actualConvertToPublishResult.getPayloadSize());
    assertEquals(69, actualConvertToPublishResult.getRawCode());
    assertEquals(ResponseCode.CONTENT, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.isError());
    assertTrue(actualConvertToPublishResult.isSuccess());
    assertArrayEquals(new byte[] {}, actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response ProtoCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg3() throws AdaptorException {
    // Arrange
    GetAttributeResponseMsg msg = mock(GetAttributeResponseMsg.class);
    when(msg.getError()).thenReturn("An error occurred");
    when(msg.getSharedStateMsg()).thenReturn(true);

    // Act
    Response actualConvertToPublishResult = protoCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg).getError();
    verify(msg).getSharedStateMsg();
    assertEquals(160, actualConvertToPublishResult.getRawCode());
    assertEquals(ResponseCode.INTERNAL_SERVER_ERROR, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.isSuccess());
    assertTrue(actualConvertToPublishResult.isError());
    assertTrue(actualConvertToPublishResult.isServerError());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response ProtoCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg4()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    GetAttributeResponseMsg msg = mock(GetAttributeResponseMsg.class);
    when(msg.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getSharedStateMsg()).thenReturn(false);
    when(msg.getClientAttributeListCount()).thenReturn(3);

    // Act
    Response actualConvertToPublishResult = protoCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg).toByteArray();
    verify(msg).getClientAttributeListCount();
    verify(msg).getSharedStateMsg();
    assertEquals("AXAXAXAX", actualConvertToPublishResult.getPayloadString());
    assertEquals(69, actualConvertToPublishResult.getRawCode());
    assertEquals(8, actualConvertToPublishResult.getPayloadSize());
    assertEquals(ResponseCode.CONTENT, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.isError());
    assertTrue(actualConvertToPublishResult.isSuccess());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToPublish(GetAttributeResponseMsg)} with {@code
   * GetAttributeResponseMsg}.
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#convertToPublish(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response ProtoCoapAdaptor.convertToPublish(GetAttributeResponseMsg)"})
  void testConvertToPublishWithGetAttributeResponseMsg5()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    GetAttributeResponseMsg msg = mock(GetAttributeResponseMsg.class);
    when(msg.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getSharedStateMsg()).thenReturn(false);
    when(msg.getClientAttributeListCount()).thenReturn(0);
    when(msg.getSharedAttributeListCount()).thenReturn(3);

    // Act
    Response actualConvertToPublishResult = protoCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg).toByteArray();
    verify(msg).getClientAttributeListCount();
    verify(msg).getSharedAttributeListCount();
    verify(msg).getSharedStateMsg();
    assertEquals("AXAXAXAX", actualConvertToPublishResult.getPayloadString());
    assertEquals(69, actualConvertToPublishResult.getRawCode());
    assertEquals(8, actualConvertToPublishResult.getPayloadSize());
    assertEquals(ResponseCode.CONTENT, actualConvertToPublishResult.getCode());
    assertFalse(actualConvertToPublishResult.isError());
    assertTrue(actualConvertToPublishResult.isSuccess());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToPublish(ToServerRpcResponseMsg)} with {@code
   * ToServerRpcResponseMsg}.
   *
   * <p>Method under test: {@link
   * ProtoCoapAdaptor#convertToPublish(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName("Test convertToPublish(ToServerRpcResponseMsg) with 'ToServerRpcResponseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Response ProtoCoapAdaptor.convertToPublish(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testConvertToPublishWithToServerRpcResponseMsg() throws AdaptorException {
    // Arrange and Act
    Response actualConvertToPublishResult =
        protoCoapAdaptor.convertToPublish(ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    assertEquals("", actualConvertToPublishResult.getPayloadString());
    assertEquals(0, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals(new byte[] {}, actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link ProtoCoapAdaptor#convertToPublish(ToServerRpcResponseMsg)} with {@code
   * ToServerRpcResponseMsg}.
   *
   * <ul>
   *   <li>Then return PayloadString is {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoCoapAdaptor#convertToPublish(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(ToServerRpcResponseMsg) with 'ToServerRpcResponseMsg'; then return PayloadString is 'AXAXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Response ProtoCoapAdaptor.convertToPublish(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testConvertToPublishWithToServerRpcResponseMsg_thenReturnPayloadStringIsAxaxaxax()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    ToServerRpcResponseMsg msg = mock(ToServerRpcResponseMsg.class);
    when(msg.toByteArray()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Response actualConvertToPublishResult = protoCoapAdaptor.convertToPublish(msg);

    // Assert
    verify(msg).toByteArray();
    assertEquals("AXAXAXAX", actualConvertToPublishResult.getPayloadString());
    assertEquals(8, actualConvertToPublishResult.getPayloadSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualConvertToPublishResult.getPayload());
  }

  /**
   * Test {@link ProtoCoapAdaptor#getContentFormat()}.
   *
   * <p>Method under test: {@link ProtoCoapAdaptor#getContentFormat()}
   */
  @Test
  @DisplayName("Test getContentFormat()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ProtoCoapAdaptor.getContentFormat()"})
  void testGetContentFormat() {
    // Arrange, Act and Assert
    assertEquals(42, protoCoapAdaptor.getContentFormat());
  }
}
