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
package org.thingsboard.server.common.adaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Any;
import com.google.protobuf.Any.Builder;
import com.google.protobuf.Api;
import com.google.protobuf.BytesValue;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ClaimDeviceMsg;
import org.thingsboard.server.gen.transport.TransportProtos.CredentialsType;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.PostAttributeMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ProvisionDeviceRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToServerRpcRequestMsg;

class ProtoConverterDiffblueTest {
  /**
   * Test {@link ProtoConverter#convertToTelemetryProto(byte[])}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConverter#convertToTelemetryProto(byte[])}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(byte[]); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.PostTelemetryMsg ProtoConverter.convertToTelemetryProto(byte[])"})
  void testConvertToTelemetryProto_thenThrowIllegalArgumentException()
      throws InvalidProtocolBufferException, IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ProtoConverter.convertToTelemetryProto(
        new byte[]{'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', '\b', 'A', Byte.MIN_VALUE, 'A', '\b'}));
  }

  /**
   * Test {@link ProtoConverter#convertToTelemetryProto(byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConverter#convertToTelemetryProto(byte[])}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(byte[]); when empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.PostTelemetryMsg ProtoConverter.convertToTelemetryProto(byte[])"})
  void testConvertToTelemetryProto_whenEmptyArrayOfByte()
      throws InvalidProtocolBufferException, IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ProtoConverter.convertToTelemetryProto(new byte[]{}));
  }

  /**
   * Test {@link ProtoConverter#validatePostTelemetryMsg(byte[])}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConverter#validatePostTelemetryMsg(byte[])}
   */
  @Test
  @DisplayName("Test validatePostTelemetryMsg(byte[]); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TransportProtos.PostTelemetryMsg ProtoConverter.validatePostTelemetryMsg(byte[])"})
  void testValidatePostTelemetryMsg_thenThrowIllegalArgumentException()
      throws InvalidProtocolBufferException, IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ProtoConverter.validatePostTelemetryMsg(new byte[]{}));
  }

  /**
   * Test {@link ProtoConverter#validatePostAttributeMsg(PostAttributeMsg)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConverter#validatePostAttributeMsg(PostAttributeMsg)}
   */
  @Test
  @DisplayName("Test validatePostAttributeMsg(PostAttributeMsg); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PostAttributeMsg ProtoConverter.validatePostAttributeMsg(PostAttributeMsg)"})
  void testValidatePostAttributeMsg_thenThrowIllegalArgumentException()
      throws InvalidProtocolBufferException, IllegalArgumentException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ProtoConverter.validatePostAttributeMsg(PostAttributeMsg.getDefaultInstance()));
  }

  /**
   * Test {@link ProtoConverter#convertToClaimDeviceProto(DeviceId, byte[])}.
   * <p>
   * Method under test: {@link ProtoConverter#convertToClaimDeviceProto(DeviceId, byte[])}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ProtoConverter.convertToClaimDeviceProto(DeviceId, byte[])"})
  void testConvertToClaimDeviceProto() throws InvalidProtocolBufferException {
    // Arrange and Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult = ProtoConverter
        .convertToClaimDeviceProto(new DeviceId(UUID.randomUUID()), null);

    // Assert
    UnknownFieldSet unknownFields = actualConvertToClaimDeviceProtoResult.getUnknownFields();
    ClaimDeviceMsg defaultInstanceForType = actualConvertToClaimDeviceProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoConverter#convertToClaimDeviceProto(DeviceId, byte[])}.
   * <p>
   * Method under test: {@link ProtoConverter#convertToClaimDeviceProto(DeviceId, byte[])}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ProtoConverter.convertToClaimDeviceProto(DeviceId, byte[])"})
  void testConvertToClaimDeviceProto2() throws InvalidProtocolBufferException {
    // Arrange and Act
    ClaimDeviceMsg actualConvertToClaimDeviceProtoResult = ProtoConverter
        .convertToClaimDeviceProto(new DeviceId(UUID.randomUUID()), new byte[]{});

    // Assert
    UnknownFieldSet unknownFields = actualConvertToClaimDeviceProtoResult.getUnknownFields();
    ClaimDeviceMsg defaultInstanceForType = actualConvertToClaimDeviceProtoResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoConverter#convertToGetAttributeRequestMessage(byte[], int)}.
   * <ul>
   *   <li>Then return RequestId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConverter#convertToGetAttributeRequestMessage(byte[], int)}
   */
  @Test
  @DisplayName("Test convertToGetAttributeRequestMessage(byte[], int); then return RequestId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetAttributeRequestMsg ProtoConverter.convertToGetAttributeRequestMessage(byte[], int)"})
  void testConvertToGetAttributeRequestMessage_thenReturnRequestIdIsOne()
      throws InvalidProtocolBufferException, RuntimeException {
    // Arrange and Act
    GetAttributeRequestMsg actualConvertToGetAttributeRequestMessageResult = ProtoConverter
        .convertToGetAttributeRequestMessage(new byte[]{}, 1);

    // Assert
    assertEquals(1, actualConvertToGetAttributeRequestMessageResult.getRequestId());
    UnknownFieldSet unknownFields = actualConvertToGetAttributeRequestMessageResult.getUnknownFields();
    GetAttributeRequestMsg defaultInstanceForType = actualConvertToGetAttributeRequestMessageResult
        .getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList clientAttributeNamesList = actualConvertToGetAttributeRequestMessageResult
        .getClientAttributeNamesList();
    assertSame(clientAttributeNamesList, defaultInstanceForType.getClientAttributeNamesList());
    assertSame(clientAttributeNamesList, defaultInstanceForType.getSharedAttributeNamesList());
    assertSame(clientAttributeNamesList, actualConvertToGetAttributeRequestMessageResult.getSharedAttributeNamesList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoConverter#convertToGetAttributeRequestMessage(byte[], int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return RequestId is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConverter#convertToGetAttributeRequestMessage(byte[], int)}
   */
  @Test
  @DisplayName("Test convertToGetAttributeRequestMessage(byte[], int); when two; then return RequestId is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetAttributeRequestMsg ProtoConverter.convertToGetAttributeRequestMessage(byte[], int)"})
  void testConvertToGetAttributeRequestMessage_whenTwo_thenReturnRequestIdIsTwo()
      throws InvalidProtocolBufferException, RuntimeException {
    // Arrange and Act
    GetAttributeRequestMsg actualConvertToGetAttributeRequestMessageResult = ProtoConverter
        .convertToGetAttributeRequestMessage(new byte[]{}, 2);

    // Assert
    assertEquals(2, actualConvertToGetAttributeRequestMessageResult.getRequestId());
    UnknownFieldSet unknownFields = actualConvertToGetAttributeRequestMessageResult.getUnknownFields();
    GetAttributeRequestMsg defaultInstanceForType = actualConvertToGetAttributeRequestMessageResult
        .getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList clientAttributeNamesList = actualConvertToGetAttributeRequestMessageResult
        .getClientAttributeNamesList();
    assertSame(clientAttributeNamesList, defaultInstanceForType.getClientAttributeNamesList());
    assertSame(clientAttributeNamesList, defaultInstanceForType.getSharedAttributeNamesList());
    assertSame(clientAttributeNamesList, actualConvertToGetAttributeRequestMessageResult.getSharedAttributeNamesList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoConverter#convertToServerRpcRequest(byte[], int)}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConverter#convertToServerRpcRequest(byte[], int)}
   */
  @Test
  @DisplayName("Test convertToServerRpcRequest(byte[], int); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToServerRpcRequestMsg ProtoConverter.convertToServerRpcRequest(byte[], int)"})
  void testConvertToServerRpcRequest_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ToServerRpcRequestMsg actualConvertToServerRpcRequestResult = ProtoConverter.convertToServerRpcRequest(new byte[]{},
        1);

    // Assert
    assertEquals("", actualConvertToServerRpcRequestResult.getInitializationErrorString());
    assertEquals("", actualConvertToServerRpcRequestResult.getMethodName());
    assertEquals("", actualConvertToServerRpcRequestResult.getParams());
    assertEquals(1, actualConvertToServerRpcRequestResult.getAllFields().size());
    assertEquals(1, actualConvertToServerRpcRequestResult.getRequestId());
    assertEquals(2, actualConvertToServerRpcRequestResult.getSerializedSize());
    assertTrue(actualConvertToServerRpcRequestResult.findInitializationErrors().isEmpty());
    assertTrue(actualConvertToServerRpcRequestResult.isInitialized());
  }

  /**
   * Test {@link ProtoConverter#convertToProvisionRequestMsg(byte[])}.
   * <p>
   * Method under test: {@link ProtoConverter#convertToProvisionRequestMsg(byte[])}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProvisionDeviceRequestMsg ProtoConverter.convertToProvisionRequestMsg(byte[])"})
  void testConvertToProvisionRequestMsg() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProvisionDeviceRequestMsg actualConvertToProvisionRequestMsgResult = ProtoConverter
        .convertToProvisionRequestMsg(new byte[]{});

    // Assert
    assertEquals("", actualConvertToProvisionRequestMsgResult.getInitializationErrorString());
    assertEquals("", actualConvertToProvisionRequestMsgResult.getDeviceName());
    assertEquals(0, actualConvertToProvisionRequestMsgResult.getCredentialsTypeValue());
    assertEquals(0, actualConvertToProvisionRequestMsgResult.getSerializedSize());
    assertEquals(CredentialsType.ACCESS_TOKEN, actualConvertToProvisionRequestMsgResult.getCredentialsType());
    assertFalse(actualConvertToProvisionRequestMsgResult.getGateway());
    assertFalse(actualConvertToProvisionRequestMsgResult.hasCredentialsDataProto());
    assertFalse(actualConvertToProvisionRequestMsgResult.hasProvisionDeviceCredentialsMsg());
    assertTrue(actualConvertToProvisionRequestMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConvertToProvisionRequestMsgResult.getAllFields().isEmpty());
    assertTrue(actualConvertToProvisionRequestMsgResult.isInitialized());
    assertEquals(actualConvertToProvisionRequestMsgResult,
        actualConvertToProvisionRequestMsgResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link ProtoConverter#validateDescriptor(Descriptor)}.
   * <ul>
   *   <li>When Descriptor.</li>
   *   <li>Then return Name is {@code Any}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConverter#validateDescriptor(Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test validateDescriptor(Descriptor); when Descriptor; then return Name is 'Any'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.Descriptor ProtoConverter.validateDescriptor(Descriptors.Descriptor)"})
  void testValidateDescriptor_whenDescriptor_thenReturnNameIsAny() throws AdaptorException {
    // Arrange and Act
    Descriptor actualValidateDescriptorResult = ProtoConverter.validateDescriptor(Any.getDescriptor());

    // Assert
    assertEquals("Any", actualValidateDescriptorResult.getName());
    assertEquals("google.protobuf.Any", actualValidateDescriptorResult.getFullName());
    assertNull(actualValidateDescriptorResult.getContainingType());
    assertEquals(0, actualValidateDescriptorResult.getIndex());
    assertEquals(2, actualValidateDescriptorResult.getFields().size());
    assertFalse(actualValidateDescriptorResult.isExtendable());
    assertTrue(actualValidateDescriptorResult.getEnumTypes().isEmpty());
    assertTrue(actualValidateDescriptorResult.getExtensions().isEmpty());
    assertTrue(actualValidateDescriptorResult.getNestedTypes().isEmpty());
    assertTrue(actualValidateDescriptorResult.getOneofs().isEmpty());
    assertTrue(actualValidateDescriptorResult.getRealOneofs().isEmpty());
  }

  /**
   * Test {@link ProtoConverter#validateDescriptor(Descriptor)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link AdaptorException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConverter#validateDescriptor(Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test validateDescriptor(Descriptor); when 'null'; then throw AdaptorException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.Descriptor ProtoConverter.validateDescriptor(Descriptors.Descriptor)"})
  void testValidateDescriptor_whenNull_thenThrowAdaptorException() throws AdaptorException {
    // Arrange, Act and Assert
    assertThrows(AdaptorException.class, () -> ProtoConverter.validateDescriptor(null));
  }

  /**
   * Test {@link ProtoConverter#dynamicMsgToJson(byte[], Descriptor)}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConverter#dynamicMsgToJson(byte[], Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test dynamicMsgToJson(byte[], Descriptor); then return '{}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConverter.dynamicMsgToJson(byte[], Descriptors.Descriptor)"})
  void testDynamicMsgToJson_thenReturnLeftCurlyBracketRightCurlyBracket() throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals("{}", ProtoConverter.dynamicMsgToJson(new byte[]{}, Any.getDescriptor()));
  }

  /**
   * Test {@link ProtoConverter#dynamicMsgToJson(byte[], Descriptor)}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConverter#dynamicMsgToJson(byte[], Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test dynamicMsgToJson(byte[], Descriptor); then return '{}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConverter.dynamicMsgToJson(byte[], Descriptors.Descriptor)"})
  void testDynamicMsgToJson_thenReturnLeftCurlyBracketRightCurlyBracket2() throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals("{}", ProtoConverter.dynamicMsgToJson(new byte[]{}, Builder.getDescriptor()));
  }

  /**
   * Test {@link ProtoConverter#dynamicMsgToJson(byte[], Descriptor)}.
   * <ul>
   *   <li>Then return {@code { "name": "", "methods": [], "options": [], "version": "", "mixins": [], "syntax": "SYNTAX_PROTO2" }}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConverter#dynamicMsgToJson(byte[], Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test dynamicMsgToJson(byte[], Descriptor); then return '{ \"name\": \"\", \"methods\": [], \"options\": [], \"version\": \"\", \"mixins\": [], \"syntax\": \"SYNTAX_PROTO2\" }'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConverter.dynamicMsgToJson(byte[], Descriptors.Descriptor)"})
  void testDynamicMsgToJson_thenReturnNameMethodsOptionsVersionMixinsSyntaxSyntaxProto2()
      throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals(
        "{\n" + "  \"name\": \"\",\n" + "  \"methods\": [],\n" + "  \"options\": [],\n" + "  \"version\": \"\",\n"
            + "  \"mixins\": [],\n" + "  \"syntax\": \"SYNTAX_PROTO2\"\n" + "}",
        ProtoConverter.dynamicMsgToJson(new byte[]{}, Api.getDescriptor()));
  }

  /**
   * Test {@link ProtoConverter#dynamicMsgToJson(byte[], Descriptor)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code ""}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoConverter#dynamicMsgToJson(byte[], Descriptors.Descriptor)}
   */
  @Test
  @DisplayName("Test dynamicMsgToJson(byte[], Descriptor); when empty array of byte; then return '\"\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoConverter.dynamicMsgToJson(byte[], Descriptors.Descriptor)"})
  void testDynamicMsgToJson_whenEmptyArrayOfByte_thenReturnQuotationMarkQuotationMark()
      throws InvalidProtocolBufferException {
    // Arrange, Act and Assert
    assertEquals("\"\"", ProtoConverter.dynamicMsgToJson(new byte[]{}, BytesValue.getDescriptor()));
  }
}
