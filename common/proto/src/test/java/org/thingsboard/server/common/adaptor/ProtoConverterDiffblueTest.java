package org.thingsboard.server.common.adaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ApiUsageStateProto;
import org.thingsboard.server.gen.transport.TransportProtos.ClaimDeviceMsg;
import org.thingsboard.server.gen.transport.TransportProtos.CredentialsType;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.PostAttributeMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ProvisionDeviceRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToServerRpcRequestMsg;

class ProtoConverterDiffblueTest {
  /**
   * Test {@link ProtoConverter#convertToTelemetryProto(byte[])}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoConverter#convertToTelemetryProto(byte[])}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(byte[]); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg ProtoConverter.convertToTelemetryProto(byte[])"
  })
  void testConvertToTelemetryProto_thenThrowIllegalArgumentException()
      throws InvalidProtocolBufferException, IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ProtoConverter.convertToTelemetryProto(
                new byte[] {
                  'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', -1,
                  '\b'
                }));
  }

  /**
   * Test {@link ProtoConverter#convertToTelemetryProto(byte[])}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoConverter#convertToTelemetryProto(byte[])}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(byte[]); when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg ProtoConverter.convertToTelemetryProto(byte[])"
  })
  void testConvertToTelemetryProto_whenEmptyArrayOfByte()
      throws InvalidProtocolBufferException, IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ProtoConverter.convertToTelemetryProto(new byte[] {}));
  }

  /**
   * Test {@link ProtoConverter#validatePostTelemetryMsg(byte[])}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoConverter#validatePostTelemetryMsg(byte[])}
   */
  @Test
  @DisplayName("Test validatePostTelemetryMsg(byte[]); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg ProtoConverter.validatePostTelemetryMsg(byte[])"
  })
  void testValidatePostTelemetryMsg_thenThrowIllegalArgumentException()
      throws InvalidProtocolBufferException, IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ProtoConverter.validatePostTelemetryMsg(new byte[] {}));
  }

  /**
   * Test {@link ProtoConverter#validatePostAttributeMsg(PostAttributeMsg)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoConverter#validatePostAttributeMsg(PostAttributeMsg)}
   */
  @Test
  @DisplayName(
      "Test validatePostAttributeMsg(PostAttributeMsg); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PostAttributeMsg ProtoConverter.validatePostAttributeMsg(PostAttributeMsg)"})
  void testValidatePostAttributeMsg_thenThrowIllegalArgumentException()
      throws InvalidProtocolBufferException, IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ProtoConverter.validatePostAttributeMsg(PostAttributeMsg.getDefaultInstance()));
  }

  /**
   * Test {@link ProtoConverter#convertToClaimDeviceProto(DeviceId, byte[])}.
   *
   * <p>Method under test: {@link ProtoConverter#convertToClaimDeviceProto(DeviceId, byte[])}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClaimDeviceMsg ProtoConverter.convertToClaimDeviceProto(DeviceId, byte[])"})
  void testConvertToClaimDeviceProto() throws InvalidProtocolBufferException {
    // Arrange and Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult =
        ProtoConverter.convertToClaimDeviceProto(
            new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null);

    // Assert
    UnknownFieldSet unknownFields = actualConvertToClaimDeviceProtoResult.getUnknownFields();
    ClaimDeviceMsg defaultInstanceForType =
        actualConvertToClaimDeviceProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoConverter#convertToClaimDeviceProto(DeviceId, byte[])}.
   *
   * <p>Method under test: {@link ProtoConverter#convertToClaimDeviceProto(DeviceId, byte[])}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClaimDeviceMsg ProtoConverter.convertToClaimDeviceProto(DeviceId, byte[])"})
  void testConvertToClaimDeviceProto2() throws InvalidProtocolBufferException {
    // Arrange and Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult =
        ProtoConverter.convertToClaimDeviceProto(
            new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), new byte[] {});

    // Assert
    UnknownFieldSet unknownFields = actualConvertToClaimDeviceProtoResult.getUnknownFields();
    ClaimDeviceMsg defaultInstanceForType =
        actualConvertToClaimDeviceProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoConverter#convertToGetAttributeRequestMessage(byte[], int)}.
   *
   * <ul>
   *   <li>Then return RequestId is one.
   * </ul>
   *
   * <p>Method under test: {@link ProtoConverter#convertToGetAttributeRequestMessage(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributeRequestMessage(byte[], int); then return RequestId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg ProtoConverter.convertToGetAttributeRequestMessage(byte[], int)"
  })
  void testConvertToGetAttributeRequestMessage_thenReturnRequestIdIsOne()
      throws InvalidProtocolBufferException, RuntimeException {
    // Arrange and Act
    GetAttributeRequestMsg actualConvertToGetAttributeRequestMessageResult =
        ProtoConverter.convertToGetAttributeRequestMessage(new byte[] {}, 1);

    // Assert
    assertEquals(1, actualConvertToGetAttributeRequestMessageResult.getRequestId());
    UnknownFieldSet unknownFields =
        actualConvertToGetAttributeRequestMessageResult.getUnknownFields();
    GetAttributeRequestMsg defaultInstanceForType =
        actualConvertToGetAttributeRequestMessageResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    ProtocolStringList clientAttributeNamesList =
        actualConvertToGetAttributeRequestMessageResult.getClientAttributeNamesList();
    assertSame(clientAttributeNamesList, defaultInstanceForType.getClientAttributeNamesList());
    assertSame(clientAttributeNamesList, defaultInstanceForType.getSharedAttributeNamesList());
    assertSame(
        clientAttributeNamesList,
        actualConvertToGetAttributeRequestMessageResult.getSharedAttributeNamesList());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoConverter#convertToGetAttributeRequestMessage(byte[], int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return RequestId is two.
   * </ul>
   *
   * <p>Method under test: {@link ProtoConverter#convertToGetAttributeRequestMessage(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributeRequestMessage(byte[], int); when two; then return RequestId is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetAttributeRequestMsg ProtoConverter.convertToGetAttributeRequestMessage(byte[], int)"
  })
  void testConvertToGetAttributeRequestMessage_whenTwo_thenReturnRequestIdIsTwo()
      throws InvalidProtocolBufferException, RuntimeException {
    // Arrange and Act
    GetAttributeRequestMsg actualConvertToGetAttributeRequestMessageResult =
        ProtoConverter.convertToGetAttributeRequestMessage(new byte[] {}, 2);

    // Assert
    assertEquals(2, actualConvertToGetAttributeRequestMessageResult.getRequestId());
    UnknownFieldSet unknownFields =
        actualConvertToGetAttributeRequestMessageResult.getUnknownFields();
    GetAttributeRequestMsg defaultInstanceForType =
        actualConvertToGetAttributeRequestMessageResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    ProtocolStringList clientAttributeNamesList =
        actualConvertToGetAttributeRequestMessageResult.getClientAttributeNamesList();
    assertSame(clientAttributeNamesList, defaultInstanceForType.getClientAttributeNamesList());
    assertSame(clientAttributeNamesList, defaultInstanceForType.getSharedAttributeNamesList());
    assertSame(
        clientAttributeNamesList,
        actualConvertToGetAttributeRequestMessageResult.getSharedAttributeNamesList());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoConverter#convertToServerRpcRequest(byte[], int)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ProtoConverter#convertToServerRpcRequest(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(byte[], int); then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToServerRpcRequestMsg ProtoConverter.convertToServerRpcRequest(byte[], int)"})
  void testConvertToServerRpcRequest_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult =
        ProtoConverter.convertToServerRpcRequest(new byte[] {}, 1);

    // Assert
    assertEquals("", actualConvertToServerRpcRequestResult.getInitializationErrorString());
    assertEquals("", actualConvertToServerRpcRequestResult.getMethodName());
    assertEquals("", actualConvertToServerRpcRequestResult.getParams());
    assertEquals(1, actualConvertToServerRpcRequestResult.getAllFields().size());
    assertEquals(1, actualConvertToServerRpcRequestResult.getRequestId());
    assertEquals(2, actualConvertToServerRpcRequestResult.getSerializedSize());
    assertTrue(actualConvertToServerRpcRequestResult.findInitializationErrors().isEmpty());
  }

  /**
   * Test {@link ProtoConverter#convertToProvisionRequestMsg(byte[])}.
   *
   * <p>Method under test: {@link ProtoConverter#convertToProvisionRequestMsg(byte[])}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProvisionDeviceRequestMsg ProtoConverter.convertToProvisionRequestMsg(byte[])"
  })
  void testConvertToProvisionRequestMsg() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProvisionDeviceRequestMsg actualConvertToProvisionRequestMsgResult =
        ProtoConverter.convertToProvisionRequestMsg(new byte[] {});

    // Assert
    assertEquals("", actualConvertToProvisionRequestMsgResult.getInitializationErrorString());
    assertEquals("", actualConvertToProvisionRequestMsgResult.getDeviceName());
    assertEquals(0, actualConvertToProvisionRequestMsgResult.getCredentialsTypeValue());
    assertEquals(0, actualConvertToProvisionRequestMsgResult.getSerializedSize());
    assertEquals(
        CredentialsType.ACCESS_TOKEN,
        actualConvertToProvisionRequestMsgResult.getCredentialsType());
    assertFalse(actualConvertToProvisionRequestMsgResult.getGateway());
    assertFalse(actualConvertToProvisionRequestMsgResult.hasCredentialsDataProto());
    assertFalse(actualConvertToProvisionRequestMsgResult.hasProvisionDeviceCredentialsMsg());
    assertTrue(actualConvertToProvisionRequestMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConvertToProvisionRequestMsgResult.getAllFields().isEmpty());
    ProvisionDeviceRequestMsg actualDefaultInstanceForType =
        actualConvertToProvisionRequestMsgResult.getDefaultInstanceForType();
    assertEquals(actualConvertToProvisionRequestMsgResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link ProtoConverter#convertToRpcRequest(ToDeviceRpcRequestMsg, Builder)}.
   *
   * <p>Method under test: {@link
   * ProtoConverter#convertToRpcRequest(TransportProtos.ToDeviceRpcRequestMsg, Builder)}
   */
  @Test
  @DisplayName("Test convertToRpcRequest(ToDeviceRpcRequestMsg, Builder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "byte[] ProtoConverter.convertToRpcRequest(TransportProtos.ToDeviceRpcRequestMsg, Builder)"
  })
  void testConvertToRpcRequest() throws AdaptorException {
    // Arrange
    ToDeviceRpcRequestMsg toDeviceRpcRequestMsg = ToDeviceRpcRequestMsg.getDefaultInstance();

    Builder rpcRequestDynamicMessageBuilder = mock(Builder.class);
    when(rpcRequestDynamicMessageBuilder.getDefaultInstanceForType())
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            ProtoConverter.convertToRpcRequest(
                toDeviceRpcRequestMsg, rpcRequestDynamicMessageBuilder));
    verify(rpcRequestDynamicMessageBuilder).getDefaultInstanceForType();
  }

  /**
   * Test {@link ProtoConverter#validateDescriptor(Descriptor)}.
   *
   * <ul>
   *   <li>When Descriptor.
   *   <li>Then return Name is {@code ApiUsageStateProto}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoConverter#validateDescriptor(Descriptors.Descriptor)}
   */
  @Test
  @DisplayName(
      "Test validateDescriptor(Descriptor); when Descriptor; then return Name is 'ApiUsageStateProto'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Descriptors.Descriptor ProtoConverter.validateDescriptor(Descriptors.Descriptor)"
  })
  void testValidateDescriptor_whenDescriptor_thenReturnNameIsApiUsageStateProto()
      throws AdaptorException {
    // Arrange and Act
    Descriptor actualValidateDescriptorResult =
        ProtoConverter.validateDescriptor(ApiUsageStateProto.getDescriptor());

    // Assert
    assertEquals("ApiUsageStateProto", actualValidateDescriptorResult.getName());
    assertEquals("transport.ApiUsageStateProto", actualValidateDescriptorResult.getFullName());
    assertNull(actualValidateDescriptorResult.getContainingType());
    assertEquals(15, actualValidateDescriptorResult.getIndex());
    assertFalse(actualValidateDescriptorResult.isExtendable());
    assertTrue(actualValidateDescriptorResult.getEnumTypes().isEmpty());
    assertTrue(actualValidateDescriptorResult.getExtensions().isEmpty());
    assertTrue(actualValidateDescriptorResult.getNestedTypes().isEmpty());
    assertTrue(actualValidateDescriptorResult.getOneofs().isEmpty());
    assertTrue(actualValidateDescriptorResult.getRealOneofs().isEmpty());
    assertEquals(Short.SIZE, actualValidateDescriptorResult.getFields().size());
  }

  /**
   * Test {@link ProtoConverter#validateDescriptor(Descriptor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoConverter#validateDescriptor(Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test validateDescriptor(Descriptor); when 'null'; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Descriptors.Descriptor ProtoConverter.validateDescriptor(Descriptors.Descriptor)"
  })
  void testValidateDescriptor_whenNull_thenThrowAdaptorException() throws AdaptorException {
    // Arrange, Act and Assert
    assertThrows(AdaptorException.class, () -> ProtoConverter.validateDescriptor(null));
  }
}
