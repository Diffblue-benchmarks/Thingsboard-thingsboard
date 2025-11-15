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
package org.thingsboard.server.gen.transport;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.TransportApiProtos.AttributesMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.AttributesRequest;
import org.thingsboard.server.gen.transport.TransportApiProtos.ClaimDevice;
import org.thingsboard.server.gen.transport.TransportApiProtos.ClaimDeviceMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.ConnectMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.DisconnectMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayAttributeResponseMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayAttributeUpdateNotificationMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayAttributesMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayAttributesRequestMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayClaimMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayRpcResponseMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.GatewayTelemetryMsg;
import org.thingsboard.server.gen.transport.TransportApiProtos.RpcRequest;
import org.thingsboard.server.gen.transport.TransportApiProtos.TelemetryMsg;
import org.thingsboard.server.gen.transport.TransportProtos.AttributeUpdateNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueProto;
import org.thingsboard.server.gen.transport.TransportProtos.PostAttributeMsg;
import org.thingsboard.server.gen.transport.TransportProtos.PostTelemetryMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvListProto;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvProto;

class TransportApiProtosDiffblueTest {
  /**
   * Test AttributesMsg {@link AttributesMsg#equals(Object)}, and {@link AttributesMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttributesMsg#equals(Object)}
   *   <li>{@link AttributesMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test AttributesMsg equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AttributesMsg.equals(Object)", "int AttributesMsg.hashCode()"})
  void testAttributesMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AttributesMsg defaultInstance = AttributesMsg.getDefaultInstance();
    AttributesMsg defaultInstance2 = AttributesMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#equals(Object)}, and {@link AttributesMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttributesMsg#equals(Object)}
   *   <li>{@link AttributesMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test AttributesMsg equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AttributesMsg.equals(Object)", "int AttributesMsg.hashCode()"})
  void testAttributesMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributesMsg defaultInstance = AttributesMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test AttributesMsg equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AttributesMsg.equals(Object)", "int AttributesMsg.hashCode()"})
  void testAttributesMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AttributesMsg.getDefaultInstance(), 1);
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test AttributesMsg equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AttributesMsg.equals(Object)", "int AttributesMsg.hashCode()"})
  void testAttributesMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AttributesMsg.getDefaultInstance(), null);
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test AttributesMsg equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AttributesMsg.equals(Object)", "int AttributesMsg.hashCode()"})
  void testAttributesMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AttributesMsg.getDefaultInstance(), "Different type to AttributesMsg");
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link AttributesMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test AttributesMsg getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.getDefaultInstanceForType()"})
  void testAttributesMsgGetDefaultInstanceForType() {
    // Arrange
    AttributesMsg defaultInstance = AttributesMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link AttributesMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test AttributesMsg getDeviceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AttributesMsg.getDeviceName()"})
  void testAttributesMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", AttributesMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test: {@link AttributesMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test AttributesMsg getDeviceNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString AttributesMsg.getDeviceNameBytes()"})
  void testAttributesMsgGetDeviceNameBytes() {
    // Arrange
    AttributesMsg defaultInstance = AttributesMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#getMsg()}.
   * <p>
   * Method under test: {@link AttributesMsg#getMsg()}
   */
  @Test
  @DisplayName("Test AttributesMsg getMsg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PostAttributeMsg AttributesMsg.getMsg()"})
  void testAttributesMsgGetMsg() {
    // Arrange and Act
    PostAttributeMsg actualMsg = AttributesMsg.getDefaultInstance().getMsg();

    // Assert
    assertEquals("", actualMsg.getInitializationErrorString());
    assertEquals(0, actualMsg.getKvCount());
    assertEquals(0, actualMsg.getSerializedSize());
    assertFalse(actualMsg.getShared());
    assertTrue(actualMsg.findInitializationErrors().isEmpty());
    List<KeyValueProto> kvList = actualMsg.getKvList();
    assertTrue(kvList.isEmpty());
    assertTrue(actualMsg.getAllFields().isEmpty());
    assertTrue(actualMsg.isInitialized());
    assertSame(actualMsg, actualMsg.getDefaultInstanceForType());
    assertSame(kvList, actualMsg.getKvOrBuilderList());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link AttributesMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test AttributesMsg getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AttributesMsg.getSerializedSize()"})
  void testAttributesMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AttributesMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#hasMsg()}.
   * <p>
   * Method under test: {@link AttributesMsg#hasMsg()}
   */
  @Test
  @DisplayName("Test AttributesMsg hasMsg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AttributesMsg.hasMsg()"})
  void testAttributesMsgHasMsg() {
    // Arrange, Act and Assert
    assertFalse(AttributesMsg.getDefaultInstance().hasMsg());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#isInitialized()}.
   * <p>
   * Method under test: {@link AttributesMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test AttributesMsg isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AttributesMsg.isInitialized()"})
  void testAttributesMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AttributesMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseDelimitedFrom(InputStream)"})
  void testAttributesMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AttributesMsg actualParseDelimitedFromResult = AttributesMsg.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    AttributesMsg defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    PostAttributeMsg msg = actualParseDelimitedFromResult.getMsg();
    assertSame(msg, defaultInstanceForType.getMsg());
    assertSame(msg, defaultInstanceForType.getMsgOrBuilder());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseDelimitedFrom(InputStream)"})
  void testAttributesMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AttributesMsg actualParseDelimitedFromResult = AttributesMsg.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    PostAttributeMsg msg = actualParseDelimitedFromResult.getMsg();
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseDelimitedFrom(InputStream)"})
  void testAttributesMsgParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AttributesMsg actualParseDelimitedFromResult = AttributesMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    AttributesMsg defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    PostAttributeMsg msg = actualParseDelimitedFromResult.getMsg();
    assertSame(msg, defaultInstanceForType.getMsg());
    assertSame(msg, defaultInstanceForType.getMsgOrBuilder());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AttributesMsg actualParseDelimitedFromResult = AttributesMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    PostAttributeMsg msg = actualParseDelimitedFromResult.getMsg();
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesMsgParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> AttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesMsgParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseDelimitedFrom(InputStream)"})
  void testAttributesMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AttributesMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseDelimitedFrom(InputStream)"})
  void testAttributesMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseDelimitedFrom(InputStream)"})
  void testAttributesMsgParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(byte[])"})
  void testAttributesMsgParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    AttributesMsg actualParseFromResult = AttributesMsg.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(ByteBuffer)"})
  void testAttributesMsgParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    AttributesMsg actualParseFromResult = AttributesMsg.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testAttributesMsgParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    AttributesMsg actualParseFromResult = AttributesMsg.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(byte[], ExtensionRegistryLite)"})
  void testAttributesMsgParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    AttributesMsg actualParseFromResult = AttributesMsg.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(ByteString)"})
  void testAttributesMsgParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AttributesMsg actualParseFromResult = AttributesMsg.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testAttributesMsgParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AttributesMsg actualParseFromResult = AttributesMsg.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(CodedInputStream)"})
  void testAttributesMsgParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AttributesMsg actualParseFromResult = AttributesMsg.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testAttributesMsgParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AttributesMsg actualParseFromResult = AttributesMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(InputStream)"})
  void testAttributesMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    AttributesMsg actualParseFromResult = AttributesMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    PostAttributeMsg msg = actualParseFromResult.getMsg();
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(InputStream)"})
  void testAttributesMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AttributesMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    AttributesMsg actualParseFromResult = AttributesMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AttributesMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesMsgParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AttributesMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(InputStream)"})
  void testAttributesMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AttributesMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesMsg {@link AttributesMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesMsg AttributesMsg.parseFrom(InputStream)"})
  void testAttributesMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    AttributesMsg actualParseFromResult = AttributesMsg.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    PostAttributeMsg msg = actualParseFromResult.getMsg();
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#equals(Object)}, and {@link AttributesRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttributesRequest#equals(Object)}
   *   <li>{@link AttributesRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test AttributesRequest equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AttributesRequest.equals(Object)", "int AttributesRequest.hashCode()"})
  void testAttributesRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AttributesRequest defaultInstance = AttributesRequest.getDefaultInstance();
    AttributesRequest defaultInstance2 = AttributesRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#equals(Object)}, and {@link AttributesRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttributesRequest#equals(Object)}
   *   <li>{@link AttributesRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test AttributesRequest equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AttributesRequest.equals(Object)", "int AttributesRequest.hashCode()"})
  void testAttributesRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributesRequest defaultInstance = AttributesRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test AttributesRequest equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AttributesRequest.equals(Object)", "int AttributesRequest.hashCode()"})
  void testAttributesRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AttributesRequest.getDefaultInstance(), 1);
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test AttributesRequest equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AttributesRequest.equals(Object)", "int AttributesRequest.hashCode()"})
  void testAttributesRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AttributesRequest.getDefaultInstance(), null);
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test AttributesRequest equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AttributesRequest.equals(Object)", "int AttributesRequest.hashCode()"})
  void testAttributesRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AttributesRequest.getDefaultInstance(), "Different type to AttributesRequest");
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#getClientKeys()}.
   * <p>
   * Method under test: {@link AttributesRequest#getClientKeys()}
   */
  @Test
  @DisplayName("Test AttributesRequest getClientKeys()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AttributesRequest.getClientKeys()"})
  void testAttributesRequestGetClientKeys() {
    // Arrange, Act and Assert
    assertEquals("", AttributesRequest.getDefaultInstance().getClientKeys());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#getClientKeysBytes()}.
   * <p>
   * Method under test: {@link AttributesRequest#getClientKeysBytes()}
   */
  @Test
  @DisplayName("Test AttributesRequest getClientKeysBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString AttributesRequest.getClientKeysBytes()"})
  void testAttributesRequestGetClientKeysBytes() {
    // Arrange
    AttributesRequest defaultInstance = AttributesRequest.getDefaultInstance();

    // Act
    ByteString actualClientKeysBytes = defaultInstance.getClientKeysBytes();

    // Assert
    ByteString byteString = actualClientKeysBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualClientKeysBytes);
    assertEquals(byteString, defaultInstance.getSharedKeysBytes());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link AttributesRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test AttributesRequest getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.getDefaultInstanceForType()"})
  void testAttributesRequestGetDefaultInstanceForType() {
    // Arrange
    AttributesRequest defaultInstance = AttributesRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#getSerializedSize()}.
   * <p>
   * Method under test: {@link AttributesRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test AttributesRequest getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AttributesRequest.getSerializedSize()"})
  void testAttributesRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AttributesRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#getSharedKeys()}.
   * <p>
   * Method under test: {@link AttributesRequest#getSharedKeys()}
   */
  @Test
  @DisplayName("Test AttributesRequest getSharedKeys()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AttributesRequest.getSharedKeys()"})
  void testAttributesRequestGetSharedKeys() {
    // Arrange, Act and Assert
    assertEquals("", AttributesRequest.getDefaultInstance().getSharedKeys());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#getSharedKeysBytes()}.
   * <p>
   * Method under test: {@link AttributesRequest#getSharedKeysBytes()}
   */
  @Test
  @DisplayName("Test AttributesRequest getSharedKeysBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString AttributesRequest.getSharedKeysBytes()"})
  void testAttributesRequestGetSharedKeysBytes() {
    // Arrange
    AttributesRequest defaultInstance = AttributesRequest.getDefaultInstance();

    // Act
    ByteString actualSharedKeysBytes = defaultInstance.getSharedKeysBytes();

    // Assert
    ByteString byteString = actualSharedKeysBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getClientKeysBytes());
    assertEquals(byteString, actualSharedKeysBytes);
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#isInitialized()}.
   * <p>
   * Method under test: {@link AttributesRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test AttributesRequest isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AttributesRequest.isInitialized()"})
  void testAttributesRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AttributesRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AttributesRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseDelimitedFrom(InputStream)"})
  void testAttributesRequestParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AttributesRequest actualParseDelimitedFromResult = AttributesRequest.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getClientKeys());
    assertEquals("", actualParseDelimitedFromResult.getSharedKeys());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AttributesRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseDelimitedFrom(InputStream)"})
  void testAttributesRequestParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AttributesRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link AttributesRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseDelimitedFrom(InputStream)"})
  void testAttributesRequestParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AttributesRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesRequestParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    AttributesRequest actualParseDelimitedFromResult = AttributesRequest.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getClientKeys());
    assertEquals("", actualParseDelimitedFromResult.getSharedKeys());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesRequestParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AttributesRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesRequestParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AttributesRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesRequestParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> AttributesRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesRequestParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AttributesRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseDelimitedFrom(InputStream)"})
  void testAttributesRequestParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AttributesRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseDelimitedFrom(InputStream)"})
  void testAttributesRequestParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AttributesRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(byte[])"})
  void testAttributesRequestParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    AttributesRequest actualParseFromResult = AttributesRequest.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getClientKeys());
    assertEquals("", actualParseFromResult.getSharedKeys());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(ByteBuffer)"})
  void testAttributesRequestParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    AttributesRequest actualParseFromResult = AttributesRequest.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getClientKeys());
    assertEquals("", actualParseFromResult.getSharedKeys());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testAttributesRequestParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    AttributesRequest actualParseFromResult = AttributesRequest.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getClientKeys());
    assertEquals("", actualParseFromResult.getSharedKeys());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(byte[], ExtensionRegistryLite)"})
  void testAttributesRequestParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    AttributesRequest actualParseFromResult = AttributesRequest.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getClientKeys());
    assertEquals("", actualParseFromResult.getSharedKeys());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(ByteString)"})
  void testAttributesRequestParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AttributesRequest actualParseFromResult = AttributesRequest.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getClientKeys());
    assertEquals("", actualParseFromResult.getSharedKeys());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getClientKeysBytes());
    assertEquals(byteString, actualParseFromResult.getSharedKeysBytes());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testAttributesRequestParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    AttributesRequest actualParseFromResult = AttributesRequest.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getClientKeys());
    assertEquals("", actualParseFromResult.getSharedKeys());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getClientKeysBytes());
    assertEquals(byteString, actualParseFromResult.getSharedKeysBytes());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(CodedInputStream)"})
  void testAttributesRequestParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AttributesRequest actualParseFromResult = AttributesRequest.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getClientKeys());
    assertEquals("", actualParseFromResult.getSharedKeys());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testAttributesRequestParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    AttributesRequest actualParseFromResult = AttributesRequest.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getClientKeys());
    assertEquals("", actualParseFromResult.getSharedKeys());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(InputStream)"})
  void testAttributesRequestParseFromWithInputStream() throws IOException {
    // Arrange and Act
    AttributesRequest actualParseFromResult = AttributesRequest.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(InputStream)"})
  void testAttributesRequestParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AttributesRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesRequestParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    AttributesRequest actualParseFromResult = AttributesRequest.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getClientKeys());
    assertEquals("", actualParseFromResult.getSharedKeys());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesRequestParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AttributesRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testAttributesRequestParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AttributesRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(InputStream)"})
  void testAttributesRequestParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AttributesRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test AttributesRequest {@link AttributesRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributesRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test AttributesRequest parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributesRequest AttributesRequest.parseFrom(InputStream)"})
  void testAttributesRequestParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    AttributesRequest actualParseFromResult = AttributesRequest.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#equals(Object)}, and {@link ClaimDevice#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimDevice#equals(Object)}
   *   <li>{@link ClaimDevice#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ClaimDevice equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClaimDevice.equals(Object)", "int ClaimDevice.hashCode()"})
  void testClaimDeviceEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClaimDevice defaultInstance = ClaimDevice.getDefaultInstance();
    ClaimDevice defaultInstance2 = ClaimDevice.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#equals(Object)}, and {@link ClaimDevice#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimDevice#equals(Object)}
   *   <li>{@link ClaimDevice#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ClaimDevice equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClaimDevice.equals(Object)", "int ClaimDevice.hashCode()"})
  void testClaimDeviceEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClaimDevice defaultInstance = ClaimDevice.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDevice#equals(Object)}
   */
  @Test
  @DisplayName("Test ClaimDevice equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClaimDevice.equals(Object)", "int ClaimDevice.hashCode()"})
  void testClaimDeviceEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ClaimDevice.getDefaultInstance(), 1);
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDevice#equals(Object)}
   */
  @Test
  @DisplayName("Test ClaimDevice equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClaimDevice.equals(Object)", "int ClaimDevice.hashCode()"})
  void testClaimDeviceEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ClaimDevice.getDefaultInstance(), null);
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDevice#equals(Object)}
   */
  @Test
  @DisplayName("Test ClaimDevice equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClaimDevice.equals(Object)", "int ClaimDevice.hashCode()"})
  void testClaimDeviceEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ClaimDevice.getDefaultInstance(), "Different type to ClaimDevice");
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ClaimDevice#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ClaimDevice getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.getDefaultInstanceForType()"})
  void testClaimDeviceGetDefaultInstanceForType() {
    // Arrange
    ClaimDevice defaultInstance = ClaimDevice.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#getSecretKey()}.
   * <p>
   * Method under test: {@link ClaimDevice#getSecretKey()}
   */
  @Test
  @DisplayName("Test ClaimDevice getSecretKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ClaimDevice.getSecretKey()"})
  void testClaimDeviceGetSecretKey() {
    // Arrange, Act and Assert
    assertEquals("", ClaimDevice.getDefaultInstance().getSecretKey());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#getSecretKeyBytes()}.
   * <p>
   * Method under test: {@link ClaimDevice#getSecretKeyBytes()}
   */
  @Test
  @DisplayName("Test ClaimDevice getSecretKeyBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ClaimDevice.getSecretKeyBytes()"})
  void testClaimDeviceGetSecretKeyBytes() {
    // Arrange
    ClaimDevice defaultInstance = ClaimDevice.getDefaultInstance();

    // Act
    ByteString actualSecretKeyBytes = defaultInstance.getSecretKeyBytes();

    // Assert
    ByteString byteString = actualSecretKeyBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualSecretKeyBytes);
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#getSerializedSize()}.
   * <p>
   * Method under test: {@link ClaimDevice#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ClaimDevice getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ClaimDevice.getSerializedSize()"})
  void testClaimDeviceGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ClaimDevice.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#isInitialized()}.
   * <p>
   * Method under test: {@link ClaimDevice#isInitialized()}
   */
  @Test
  @DisplayName("Test ClaimDevice isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClaimDevice.isInitialized()"})
  void testClaimDeviceIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ClaimDevice.getDefaultInstance().isInitialized());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#equals(Object)}, and {@link ClaimDeviceMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimDeviceMsg#equals(Object)}
   *   <li>{@link ClaimDeviceMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClaimDeviceMsg.equals(Object)", "int ClaimDeviceMsg.hashCode()"})
  void testClaimDeviceMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClaimDeviceMsg defaultInstance = ClaimDeviceMsg.getDefaultInstance();
    ClaimDeviceMsg defaultInstance2 = ClaimDeviceMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#equals(Object)}, and {@link ClaimDeviceMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimDeviceMsg#equals(Object)}
   *   <li>{@link ClaimDeviceMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClaimDeviceMsg.equals(Object)", "int ClaimDeviceMsg.hashCode()"})
  void testClaimDeviceMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClaimDeviceMsg defaultInstance = ClaimDeviceMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDeviceMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClaimDeviceMsg.equals(Object)", "int ClaimDeviceMsg.hashCode()"})
  void testClaimDeviceMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ClaimDeviceMsg.getDefaultInstance(), 1);
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDeviceMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClaimDeviceMsg.equals(Object)", "int ClaimDeviceMsg.hashCode()"})
  void testClaimDeviceMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ClaimDeviceMsg.getDefaultInstance(), null);
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDeviceMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClaimDeviceMsg.equals(Object)", "int ClaimDeviceMsg.hashCode()"})
  void testClaimDeviceMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ClaimDeviceMsg.getDefaultInstance(), "Different type to ClaimDeviceMsg");
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#getClaimRequest()}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#getClaimRequest()}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg getClaimRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDeviceMsg.getClaimRequest()"})
  void testClaimDeviceMsgGetClaimRequest() {
    // Arrange and Act
    ClaimDevice actualClaimRequest = ClaimDeviceMsg.getDefaultInstance().getClaimRequest();

    // Assert
    assertEquals("", actualClaimRequest.getInitializationErrorString());
    assertEquals("", actualClaimRequest.getSecretKey());
    assertEquals(0, actualClaimRequest.getSerializedSize());
    assertEquals(0L, actualClaimRequest.getDurationMs());
    assertTrue(actualClaimRequest.findInitializationErrors().isEmpty());
    assertTrue(actualClaimRequest.getAllFields().isEmpty());
    assertTrue(actualClaimRequest.isInitialized());
    assertSame(actualClaimRequest, actualClaimRequest.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.getDefaultInstanceForType()"})
  void testClaimDeviceMsgGetDefaultInstanceForType() {
    // Arrange
    ClaimDeviceMsg defaultInstance = ClaimDeviceMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg getDeviceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ClaimDeviceMsg.getDeviceName()"})
  void testClaimDeviceMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", ClaimDeviceMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg getDeviceNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ClaimDeviceMsg.getDeviceNameBytes()"})
  void testClaimDeviceMsgGetDeviceNameBytes() {
    // Arrange
    ClaimDeviceMsg defaultInstance = ClaimDeviceMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getClaimRequest().getSecretKeyBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ClaimDeviceMsg.getSerializedSize()"})
  void testClaimDeviceMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ClaimDeviceMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#hasClaimRequest()}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#hasClaimRequest()}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg hasClaimRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClaimDeviceMsg.hasClaimRequest()"})
  void testClaimDeviceMsgHasClaimRequest() {
    // Arrange, Act and Assert
    assertFalse(ClaimDeviceMsg.getDefaultInstance().hasClaimRequest());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#isInitialized()}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ClaimDeviceMsg.isInitialized()"})
  void testClaimDeviceMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ClaimDeviceMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseDelimitedFrom(InputStream)"})
  void testClaimDeviceMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ClaimDeviceMsg actualParseDelimitedFromResult = ClaimDeviceMsg.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    ClaimDevice claimRequest = actualParseDelimitedFromResult.getClaimRequest();
    assertSame(claimRequest, claimRequest.getDefaultInstanceForType());
    ClaimDeviceMsg defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(claimRequest, defaultInstanceForType.getClaimRequest());
    assertSame(claimRequest, defaultInstanceForType.getClaimRequestOrBuilder());
    assertSame(claimRequest, actualParseDelimitedFromResult.getClaimRequestOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseDelimitedFrom(InputStream)"})
  void testClaimDeviceMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ClaimDeviceMsg actualParseDelimitedFromResult = ClaimDeviceMsg.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    ClaimDevice claimRequest = actualParseDelimitedFromResult.getClaimRequest();
    assertSame(unknownFields, claimRequest.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(claimRequest, claimRequest.getDefaultInstanceForType());
    assertSame(claimRequest, actualParseDelimitedFromResult.getClaimRequestOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseDelimitedFrom(InputStream)"})
  void testClaimDeviceMsgParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ClaimDeviceMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ClaimDeviceMsg actualParseDelimitedFromResult = ClaimDeviceMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    ClaimDevice claimRequest = actualParseDelimitedFromResult.getClaimRequest();
    assertSame(claimRequest, claimRequest.getDefaultInstanceForType());
    ClaimDeviceMsg defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(claimRequest, defaultInstanceForType.getClaimRequest());
    assertSame(claimRequest, defaultInstanceForType.getClaimRequestOrBuilder());
    assertSame(claimRequest, actualParseDelimitedFromResult.getClaimRequestOrBuilder());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ClaimDeviceMsg actualParseDelimitedFromResult = ClaimDeviceMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    ClaimDevice claimRequest = actualParseDelimitedFromResult.getClaimRequest();
    assertSame(unknownFields, claimRequest.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(claimRequest, claimRequest.getDefaultInstanceForType());
    assertSame(claimRequest, actualParseDelimitedFromResult.getClaimRequestOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ClaimDeviceMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ClaimDeviceMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceMsgParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ClaimDeviceMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceMsgParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ClaimDeviceMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseDelimitedFrom(InputStream)"})
  void testClaimDeviceMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ClaimDeviceMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseDelimitedFrom(InputStream)"})
  void testClaimDeviceMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ClaimDeviceMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseDelimitedFrom(InputStream)"})
  void testClaimDeviceMsgParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClaimDeviceMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(byte[])"})
  void testClaimDeviceMsgParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ClaimDeviceMsg actualParseFromResult = ClaimDeviceMsg.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasClaimRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(ByteBuffer)"})
  void testClaimDeviceMsgParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ClaimDeviceMsg actualParseFromResult = ClaimDeviceMsg.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasClaimRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testClaimDeviceMsgParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ClaimDeviceMsg actualParseFromResult = ClaimDeviceMsg.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasClaimRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(byte[], ExtensionRegistryLite)"})
  void testClaimDeviceMsgParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ClaimDeviceMsg actualParseFromResult = ClaimDeviceMsg.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasClaimRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(ByteString)"})
  void testClaimDeviceMsgParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ClaimDeviceMsg actualParseFromResult = ClaimDeviceMsg.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasClaimRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testClaimDeviceMsgParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ClaimDeviceMsg actualParseFromResult = ClaimDeviceMsg.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasClaimRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(CodedInputStream)"})
  void testClaimDeviceMsgParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ClaimDeviceMsg actualParseFromResult = ClaimDeviceMsg.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasClaimRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testClaimDeviceMsgParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ClaimDeviceMsg actualParseFromResult = ClaimDeviceMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasClaimRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(InputStream)"})
  void testClaimDeviceMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ClaimDeviceMsg actualParseFromResult = ClaimDeviceMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    ClaimDevice claimRequest = actualParseFromResult.getClaimRequest();
    assertSame(unknownFields, claimRequest.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(claimRequest, claimRequest.getDefaultInstanceForType());
    assertSame(claimRequest, actualParseFromResult.getClaimRequestOrBuilder());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(InputStream)"})
  void testClaimDeviceMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ClaimDeviceMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ClaimDeviceMsg actualParseFromResult = ClaimDeviceMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasClaimRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ClaimDeviceMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceMsgParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ClaimDeviceMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(InputStream)"})
  void testClaimDeviceMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ClaimDeviceMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDeviceMsg {@link ClaimDeviceMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDeviceMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDeviceMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDeviceMsg ClaimDeviceMsg.parseFrom(InputStream)"})
  void testClaimDeviceMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ClaimDeviceMsg actualParseFromResult = ClaimDeviceMsg.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    ClaimDevice claimRequest = actualParseFromResult.getClaimRequest();
    assertSame(unknownFields, claimRequest.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(claimRequest, claimRequest.getDefaultInstanceForType());
    assertSame(claimRequest, actualParseFromResult.getClaimRequestOrBuilder());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ClaimDevice#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseDelimitedFrom(InputStream)"})
  void testClaimDeviceParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ClaimDevice actualParseDelimitedFromResult = ClaimDevice.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getSecretKey());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getDurationMs());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ClaimDevice#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseDelimitedFrom(InputStream)"})
  void testClaimDeviceParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ClaimDevice.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ClaimDevice actualParseDelimitedFromResult = ClaimDevice.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getSecretKey());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getDurationMs());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ClaimDevice.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ClaimDevice.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ClaimDevice.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ClaimDevice.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDevice#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseDelimitedFrom(InputStream)"})
  void testClaimDeviceParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ClaimDevice.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDevice#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseDelimitedFrom(InputStream)"})
  void testClaimDeviceParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ClaimDevice.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDevice#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseDelimitedFrom(InputStream)"})
  void testClaimDeviceParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ClaimDevice.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(byte[])"})
  void testClaimDeviceParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ClaimDevice actualParseFromResult = ClaimDevice.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSecretKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getDurationMs());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(ByteBuffer)"})
  void testClaimDeviceParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ClaimDevice actualParseFromResult = ClaimDevice.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSecretKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getDurationMs());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testClaimDeviceParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ClaimDevice actualParseFromResult = ClaimDevice.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSecretKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getDurationMs());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(byte[], ExtensionRegistryLite)"})
  void testClaimDeviceParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ClaimDevice actualParseFromResult = ClaimDevice.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSecretKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getDurationMs());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(ByteString)"})
  void testClaimDeviceParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ClaimDevice actualParseFromResult = ClaimDevice.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSecretKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getDurationMs());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedSecretKeyBytes = data.EMPTY;
    assertEquals(expectedSecretKeyBytes, actualParseFromResult.getSecretKeyBytes());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testClaimDeviceParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ClaimDevice actualParseFromResult = ClaimDevice.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSecretKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getDurationMs());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedSecretKeyBytes = data.EMPTY;
    assertEquals(expectedSecretKeyBytes, actualParseFromResult.getSecretKeyBytes());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(CodedInputStream)"})
  void testClaimDeviceParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ClaimDevice actualParseFromResult = ClaimDevice.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSecretKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getDurationMs());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testClaimDeviceParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ClaimDevice actualParseFromResult = ClaimDevice.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSecretKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getDurationMs());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(InputStream)"})
  void testClaimDeviceParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ClaimDevice actualParseFromResult = ClaimDevice.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ClaimDevice actualParseFromResult = ClaimDevice.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getSecretKey());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getDurationMs());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ClaimDevice.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testClaimDeviceParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ClaimDevice.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(InputStream)"})
  void testClaimDeviceParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ClaimDevice.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(InputStream)"})
  void testClaimDeviceParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ClaimDevice.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ClaimDevice {@link ClaimDevice#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDevice#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ClaimDevice parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ClaimDevice ClaimDevice.parseFrom(InputStream)"})
  void testClaimDeviceParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ClaimDevice actualParseFromResult = ClaimDevice.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#equals(Object)}, and {@link ConnectMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ConnectMsg#equals(Object)}
   *   <li>{@link ConnectMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ConnectMsg equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ConnectMsg.equals(Object)", "int ConnectMsg.hashCode()"})
  void testConnectMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConnectMsg defaultInstance = ConnectMsg.getDefaultInstance();
    ConnectMsg defaultInstance2 = ConnectMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#equals(Object)}, and {@link ConnectMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ConnectMsg#equals(Object)}
   *   <li>{@link ConnectMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ConnectMsg equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ConnectMsg.equals(Object)", "int ConnectMsg.hashCode()"})
  void testConnectMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConnectMsg defaultInstance = ConnectMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test ConnectMsg equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ConnectMsg.equals(Object)", "int ConnectMsg.hashCode()"})
  void testConnectMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ConnectMsg.getDefaultInstance(), 1);
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test ConnectMsg equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ConnectMsg.equals(Object)", "int ConnectMsg.hashCode()"})
  void testConnectMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ConnectMsg.getDefaultInstance(), null);
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test ConnectMsg equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ConnectMsg.equals(Object)", "int ConnectMsg.hashCode()"})
  void testConnectMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ConnectMsg.getDefaultInstance(), "Different type to ConnectMsg");
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ConnectMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ConnectMsg getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.getDefaultInstanceForType()"})
  void testConnectMsgGetDefaultInstanceForType() {
    // Arrange
    ConnectMsg defaultInstance = ConnectMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link ConnectMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test ConnectMsg getDeviceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ConnectMsg.getDeviceName()"})
  void testConnectMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", ConnectMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test: {@link ConnectMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test ConnectMsg getDeviceNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ConnectMsg.getDeviceNameBytes()"})
  void testConnectMsgGetDeviceNameBytes() {
    // Arrange
    ConnectMsg defaultInstance = ConnectMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
    assertEquals(byteString, defaultInstance.getDeviceTypeBytes());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#getDeviceType()}.
   * <p>
   * Method under test: {@link ConnectMsg#getDeviceType()}
   */
  @Test
  @DisplayName("Test ConnectMsg getDeviceType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ConnectMsg.getDeviceType()"})
  void testConnectMsgGetDeviceType() {
    // Arrange, Act and Assert
    assertEquals("", ConnectMsg.getDefaultInstance().getDeviceType());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#getDeviceTypeBytes()}.
   * <p>
   * Method under test: {@link ConnectMsg#getDeviceTypeBytes()}
   */
  @Test
  @DisplayName("Test ConnectMsg getDeviceTypeBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ConnectMsg.getDeviceTypeBytes()"})
  void testConnectMsgGetDeviceTypeBytes() {
    // Arrange
    ConnectMsg defaultInstance = ConnectMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceTypeBytes = defaultInstance.getDeviceTypeBytes();

    // Assert
    ByteString byteString = actualDeviceTypeBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDeviceNameBytes());
    assertEquals(byteString, actualDeviceTypeBytes);
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link ConnectMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ConnectMsg getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ConnectMsg.getSerializedSize()"})
  void testConnectMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ConnectMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#isInitialized()}.
   * <p>
   * Method under test: {@link ConnectMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test ConnectMsg isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ConnectMsg.isInitialized()"})
  void testConnectMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ConnectMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ConnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseDelimitedFrom(InputStream)"})
  void testConnectMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ConnectMsg actualParseDelimitedFromResult = ConnectMsg.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getDeviceName());
    assertEquals("", actualParseDelimitedFromResult.getDeviceType());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ConnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseDelimitedFrom(InputStream)"})
  void testConnectMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ConnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testConnectMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ConnectMsg actualParseDelimitedFromResult = ConnectMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getDeviceName());
    assertEquals("", actualParseDelimitedFromResult.getDeviceType());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testConnectMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ConnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testConnectMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ConnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testConnectMsgParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ConnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testConnectMsgParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ConnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseDelimitedFrom(InputStream)"})
  void testConnectMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ConnectMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseDelimitedFrom(InputStream)"})
  void testConnectMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ConnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseDelimitedFrom(InputStream)"})
  void testConnectMsgParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ConnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(ByteBuffer)"})
  void testConnectMsgParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ConnectMsg actualParseFromResult = ConnectMsg.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals("", actualParseFromResult.getDeviceType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testConnectMsgParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ConnectMsg actualParseFromResult = ConnectMsg.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals("", actualParseFromResult.getDeviceType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(byte[], ExtensionRegistryLite)"})
  void testConnectMsgParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ConnectMsg actualParseFromResult = ConnectMsg.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals("", actualParseFromResult.getDeviceType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(ByteString)"})
  void testConnectMsgParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ConnectMsg actualParseFromResult = ConnectMsg.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals("", actualParseFromResult.getDeviceType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getDeviceNameBytes());
    assertEquals(byteString, actualParseFromResult.getDeviceTypeBytes());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testConnectMsgParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ConnectMsg actualParseFromResult = ConnectMsg.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals("", actualParseFromResult.getDeviceType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getDeviceNameBytes());
    assertEquals(byteString, actualParseFromResult.getDeviceTypeBytes());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(byte[])"})
  void testConnectMsgParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ConnectMsg actualParseFromResult = ConnectMsg.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals("", actualParseFromResult.getDeviceType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(CodedInputStream)"})
  void testConnectMsgParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ConnectMsg actualParseFromResult = ConnectMsg.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals("", actualParseFromResult.getDeviceType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testConnectMsgParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ConnectMsg actualParseFromResult = ConnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals("", actualParseFromResult.getDeviceType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(InputStream)"})
  void testConnectMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ConnectMsg actualParseFromResult = ConnectMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testConnectMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ConnectMsg actualParseFromResult = ConnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals("", actualParseFromResult.getDeviceType());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testConnectMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ConnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testConnectMsgParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ConnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(InputStream)"})
  void testConnectMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ConnectMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(InputStream)"})
  void testConnectMsgParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ConnectMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ConnectMsg {@link ConnectMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ConnectMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConnectMsg ConnectMsg.parseFrom(InputStream)"})
  void testConnectMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ConnectMsg actualParseFromResult = ConnectMsg.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#equals(Object)}, and {@link DisconnectMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DisconnectMsg#equals(Object)}
   *   <li>{@link DisconnectMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test DisconnectMsg equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DisconnectMsg.equals(Object)", "int DisconnectMsg.hashCode()"})
  void testDisconnectMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DisconnectMsg defaultInstance = DisconnectMsg.getDefaultInstance();
    DisconnectMsg defaultInstance2 = DisconnectMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#equals(Object)}, and {@link DisconnectMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DisconnectMsg#equals(Object)}
   *   <li>{@link DisconnectMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test DisconnectMsg equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DisconnectMsg.equals(Object)", "int DisconnectMsg.hashCode()"})
  void testDisconnectMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DisconnectMsg defaultInstance = DisconnectMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DisconnectMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test DisconnectMsg equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DisconnectMsg.equals(Object)", "int DisconnectMsg.hashCode()"})
  void testDisconnectMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DisconnectMsg.getDefaultInstance(), 1);
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DisconnectMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test DisconnectMsg equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DisconnectMsg.equals(Object)", "int DisconnectMsg.hashCode()"})
  void testDisconnectMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DisconnectMsg.getDefaultInstance(), null);
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DisconnectMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test DisconnectMsg equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DisconnectMsg.equals(Object)", "int DisconnectMsg.hashCode()"})
  void testDisconnectMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DisconnectMsg.getDefaultInstance(), "Different type to DisconnectMsg");
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link DisconnectMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test DisconnectMsg getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.getDefaultInstanceForType()"})
  void testDisconnectMsgGetDefaultInstanceForType() {
    // Arrange
    DisconnectMsg defaultInstance = DisconnectMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link DisconnectMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test DisconnectMsg getDeviceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String DisconnectMsg.getDeviceName()"})
  void testDisconnectMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", DisconnectMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test: {@link DisconnectMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test DisconnectMsg getDeviceNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString DisconnectMsg.getDeviceNameBytes()"})
  void testDisconnectMsgGetDeviceNameBytes() {
    // Arrange
    DisconnectMsg defaultInstance = DisconnectMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link DisconnectMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test DisconnectMsg getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DisconnectMsg.getSerializedSize()"})
  void testDisconnectMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DisconnectMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#isInitialized()}.
   * <p>
   * Method under test: {@link DisconnectMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test DisconnectMsg isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DisconnectMsg.isInitialized()"})
  void testDisconnectMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DisconnectMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseDelimitedFrom(InputStream)"})
  void testDisconnectMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DisconnectMsg actualParseDelimitedFromResult = DisconnectMsg.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getDeviceName());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseDelimitedFrom(InputStream)"})
  void testDisconnectMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DisconnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testDisconnectMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DisconnectMsg actualParseDelimitedFromResult = DisconnectMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getDeviceName());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testDisconnectMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> DisconnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testDisconnectMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DisconnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testDisconnectMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> DisconnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testDisconnectMsgParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DisconnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DisconnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseDelimitedFrom(InputStream)"})
  void testDisconnectMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DisconnectMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DisconnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseDelimitedFrom(InputStream)"})
  void testDisconnectMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DisconnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DisconnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseDelimitedFrom(InputStream)"})
  void testDisconnectMsgParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DisconnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(byte[])"})
  void testDisconnectMsgParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    DisconnectMsg actualParseFromResult = DisconnectMsg.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(ByteBuffer)"})
  void testDisconnectMsgParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    DisconnectMsg actualParseFromResult = DisconnectMsg.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testDisconnectMsgParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    DisconnectMsg actualParseFromResult = DisconnectMsg.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(byte[], ExtensionRegistryLite)"})
  void testDisconnectMsgParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    DisconnectMsg actualParseFromResult = DisconnectMsg.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(ByteString)"})
  void testDisconnectMsgParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    DisconnectMsg actualParseFromResult = DisconnectMsg.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testDisconnectMsgParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    DisconnectMsg actualParseFromResult = DisconnectMsg.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(CodedInputStream)"})
  void testDisconnectMsgParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    DisconnectMsg actualParseFromResult = DisconnectMsg.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testDisconnectMsgParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    DisconnectMsg actualParseFromResult = DisconnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(InputStream)"})
  void testDisconnectMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    DisconnectMsg actualParseFromResult = DisconnectMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(InputStream)"})
  void testDisconnectMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DisconnectMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testDisconnectMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    DisconnectMsg actualParseFromResult = DisconnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testDisconnectMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DisconnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testDisconnectMsgParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DisconnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(InputStream)"})
  void testDisconnectMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DisconnectMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test DisconnectMsg {@link DisconnectMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DisconnectMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test DisconnectMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DisconnectMsg DisconnectMsg.parseFrom(InputStream)"})
  void testDisconnectMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    DisconnectMsg actualParseFromResult = DisconnectMsg.parseFrom((InputStream) null);

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#equals(Object)}, and {@link GatewayAttributeResponseMsg#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayAttributeResponseMsg#equals(Object)}
   *   <li>{@link GatewayAttributeResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg equals(Object), and hashCode(); then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributeResponseMsg.equals(Object)",
      "int GatewayAttributeResponseMsg.hashCode()"})
  void testGatewayAttributeResponseMsgEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    GatewayAttributeResponseMsg defaultInstance = GatewayAttributeResponseMsg.getDefaultInstance();
    GatewayAttributeResponseMsg defaultInstance2 = GatewayAttributeResponseMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#equals(Object)}, and {@link GatewayAttributeResponseMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayAttributeResponseMsg#equals(Object)}
   *   <li>{@link GatewayAttributeResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributeResponseMsg.equals(Object)",
      "int GatewayAttributeResponseMsg.hashCode()"})
  void testGatewayAttributeResponseMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GatewayAttributeResponseMsg defaultInstance = GatewayAttributeResponseMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributeResponseMsg.equals(Object)",
      "int GatewayAttributeResponseMsg.hashCode()"})
  void testGatewayAttributeResponseMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayAttributeResponseMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributeResponseMsg.equals(Object)",
      "int GatewayAttributeResponseMsg.hashCode()"})
  void testGatewayAttributeResponseMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayAttributeResponseMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributeResponseMsg.equals(Object)",
      "int GatewayAttributeResponseMsg.hashCode()"})
  void testGatewayAttributeResponseMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayAttributeResponseMsg.getDefaultInstance(), "Different type to GatewayAttributeResponseMsg");
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.getDefaultInstanceForType()"})
  void testGatewayAttributeResponseMsgGetDefaultInstanceForType() {
    // Arrange
    GatewayAttributeResponseMsg defaultInstance = GatewayAttributeResponseMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg getDeviceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String GatewayAttributeResponseMsg.getDeviceName()"})
  void testGatewayAttributeResponseMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", GatewayAttributeResponseMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg getDeviceNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString GatewayAttributeResponseMsg.getDeviceNameBytes()"})
  void testGatewayAttributeResponseMsgGetDeviceNameBytes() {
    // Arrange
    GatewayAttributeResponseMsg defaultInstance = GatewayAttributeResponseMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
    assertEquals(byteString, defaultInstance.getResponseMsg().getErrorBytes());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#getResponseMsg()}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#getResponseMsg()}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg getResponseMsg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetAttributeResponseMsg GatewayAttributeResponseMsg.getResponseMsg()"})
  void testGatewayAttributeResponseMsgGetResponseMsg() {
    // Arrange and Act
    GetAttributeResponseMsg actualResponseMsg = GatewayAttributeResponseMsg.getDefaultInstance().getResponseMsg();

    // Assert
    assertEquals("", actualResponseMsg.getInitializationErrorString());
    assertEquals("", actualResponseMsg.getError());
    assertEquals(0, actualResponseMsg.getClientAttributeListCount());
    assertEquals(0, actualResponseMsg.getRequestId());
    assertEquals(0, actualResponseMsg.getSerializedSize());
    assertEquals(0, actualResponseMsg.getSharedAttributeListCount());
    assertFalse(actualResponseMsg.getIsMultipleAttributesRequest());
    assertFalse(actualResponseMsg.getSharedStateMsg());
    assertTrue(actualResponseMsg.findInitializationErrors().isEmpty());
    List<TsKvProto> clientAttributeListList = actualResponseMsg.getClientAttributeListList();
    assertTrue(clientAttributeListList.isEmpty());
    assertTrue(actualResponseMsg.getAllFields().isEmpty());
    assertTrue(actualResponseMsg.isInitialized());
    assertSame(actualResponseMsg, actualResponseMsg.getDefaultInstanceForType());
    assertSame(clientAttributeListList, actualResponseMsg.getClientAttributeListOrBuilderList());
    assertSame(clientAttributeListList, actualResponseMsg.getSharedAttributeListList());
    assertSame(clientAttributeListList, actualResponseMsg.getSharedAttributeListOrBuilderList());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayAttributeResponseMsg.getSerializedSize()"})
  void testGatewayAttributeResponseMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayAttributeResponseMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#hasResponseMsg()}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#hasResponseMsg()}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg hasResponseMsg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributeResponseMsg.hasResponseMsg()"})
  void testGatewayAttributeResponseMsgHasResponseMsg() {
    // Arrange, Act and Assert
    assertFalse(GatewayAttributeResponseMsg.getDefaultInstance().hasResponseMsg());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#isInitialized()}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributeResponseMsg.isInitialized()"})
  void testGatewayAttributeResponseMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(GatewayAttributeResponseMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayAttributeResponseMsg actualParseDelimitedFromResult = GatewayAttributeResponseMsg.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    GatewayAttributeResponseMsg defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    GetAttributeResponseMsg responseMsg = actualParseDelimitedFromResult.getResponseMsg();
    assertSame(responseMsg, defaultInstanceForType.getResponseMsg());
    assertSame(responseMsg, defaultInstanceForType.getResponseMsgOrBuilder());
    assertSame(responseMsg, actualParseDelimitedFromResult.getResponseMsgOrBuilder());
    assertSame(responseMsg, responseMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayAttributeResponseMsg actualParseDelimitedFromResult = GatewayAttributeResponseMsg.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    GetAttributeResponseMsg responseMsg = actualParseDelimitedFromResult.getResponseMsg();
    assertSame(unknownFields, responseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(responseMsg, actualParseDelimitedFromResult.getResponseMsgOrBuilder());
    assertSame(responseMsg, responseMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayAttributeResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInput4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> GatewayAttributeResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayAttributeResponseMsg actualParseDelimitedFromResult = GatewayAttributeResponseMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    GatewayAttributeResponseMsg defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    GetAttributeResponseMsg responseMsg = actualParseDelimitedFromResult.getResponseMsg();
    assertSame(responseMsg, defaultInstanceForType.getResponseMsg());
    assertSame(responseMsg, defaultInstanceForType.getResponseMsgOrBuilder());
    assertSame(responseMsg, actualParseDelimitedFromResult.getResponseMsgOrBuilder());
    assertSame(responseMsg, responseMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayAttributeResponseMsg actualParseDelimitedFromResult = GatewayAttributeResponseMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    GetAttributeResponseMsg responseMsg = actualParseDelimitedFromResult.getResponseMsg();
    assertSame(unknownFields, responseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(responseMsg, actualParseDelimitedFromResult.getResponseMsgOrBuilder());
    assertSame(responseMsg, responseMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayAttributeResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayAttributeResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayAttributeResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInputExtensionRegistry6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> GatewayAttributeResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayAttributeResponseMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributeResponseMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayAttributeResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(byte[])"})
  void testGatewayAttributeResponseMsgParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayAttributeResponseMsg actualParseFromResult = GatewayAttributeResponseMsg.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasResponseMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(ByteBuffer)"})
  void testGatewayAttributeResponseMsgParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayAttributeResponseMsg actualParseFromResult = GatewayAttributeResponseMsg
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasResponseMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testGatewayAttributeResponseMsgParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    GatewayAttributeResponseMsg actualParseFromResult = GatewayAttributeResponseMsg.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasResponseMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(byte[], ExtensionRegistryLite)"})
  void testGatewayAttributeResponseMsgParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayAttributeResponseMsg actualParseFromResult = GatewayAttributeResponseMsg.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasResponseMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(ByteString)"})
  void testGatewayAttributeResponseMsgParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    GatewayAttributeResponseMsg actualParseFromResult = GatewayAttributeResponseMsg.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasResponseMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testGatewayAttributeResponseMsgParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    GatewayAttributeResponseMsg actualParseFromResult = GatewayAttributeResponseMsg.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasResponseMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(CodedInputStream)"})
  void testGatewayAttributeResponseMsgParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    GatewayAttributeResponseMsg actualParseFromResult = GatewayAttributeResponseMsg.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasResponseMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeResponseMsgParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    GatewayAttributeResponseMsg actualParseFromResult = GatewayAttributeResponseMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasResponseMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(InputStream)"})
  void testGatewayAttributeResponseMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    GatewayAttributeResponseMsg actualParseFromResult = GatewayAttributeResponseMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    GetAttributeResponseMsg responseMsg = actualParseFromResult.getResponseMsg();
    assertSame(unknownFields, responseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(responseMsg, actualParseFromResult.getResponseMsgOrBuilder());
    assertSame(responseMsg, responseMsg.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(InputStream)"})
  void testGatewayAttributeResponseMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayAttributeResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeResponseMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    GatewayAttributeResponseMsg actualParseFromResult = GatewayAttributeResponseMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasResponseMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeResponseMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayAttributeResponseMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeResponseMsgParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayAttributeResponseMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(InputStream)"})
  void testGatewayAttributeResponseMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayAttributeResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeResponseMsg {@link GatewayAttributeResponseMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributeResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeResponseMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeResponseMsg GatewayAttributeResponseMsg.parseFrom(InputStream)"})
  void testGatewayAttributeResponseMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    GatewayAttributeResponseMsg actualParseFromResult = GatewayAttributeResponseMsg.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    GetAttributeResponseMsg responseMsg = actualParseFromResult.getResponseMsg();
    assertSame(unknownFields, responseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(responseMsg, actualParseFromResult.getResponseMsgOrBuilder());
    assertSame(responseMsg, responseMsg.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#equals(Object)}, and {@link GatewayAttributeUpdateNotificationMsg#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayAttributeUpdateNotificationMsg#equals(Object)}
   *   <li>{@link GatewayAttributeUpdateNotificationMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg equals(Object), and hashCode(); then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributeUpdateNotificationMsg.equals(Object)",
      "int GatewayAttributeUpdateNotificationMsg.hashCode()"})
  void testGatewayAttributeUpdateNotificationMsgEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    GatewayAttributeUpdateNotificationMsg defaultInstance = GatewayAttributeUpdateNotificationMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#equals(Object)}, and {@link GatewayAttributeUpdateNotificationMsg#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayAttributeUpdateNotificationMsg#equals(Object)}
   *   <li>{@link GatewayAttributeUpdateNotificationMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg equals(Object), and hashCode(); then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributeUpdateNotificationMsg.equals(Object)",
      "int GatewayAttributeUpdateNotificationMsg.hashCode()"})
  void testGatewayAttributeUpdateNotificationMsgEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    GatewayAttributeUpdateNotificationMsg defaultInstance = GatewayAttributeUpdateNotificationMsg.getDefaultInstance();
    GatewayAttributeUpdateNotificationMsg defaultInstance2 = GatewayAttributeUpdateNotificationMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributeUpdateNotificationMsg.equals(Object)",
      "int GatewayAttributeUpdateNotificationMsg.hashCode()"})
  void testGatewayAttributeUpdateNotificationMsgEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayAttributeUpdateNotificationMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributeUpdateNotificationMsg.equals(Object)",
      "int GatewayAttributeUpdateNotificationMsg.hashCode()"})
  void testGatewayAttributeUpdateNotificationMsgEquals_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayAttributeUpdateNotificationMsg.getDefaultInstance(),
        "Different type to GatewayAttributeUpdateNotificationMsg");
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributeUpdateNotificationMsg.equals(Object)",
      "int GatewayAttributeUpdateNotificationMsg.hashCode()"})
  void testGatewayAttributeUpdateNotificationMsgEquals_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayAttributeUpdateNotificationMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.getDefaultInstanceForType()"})
  void testGatewayAttributeUpdateNotificationMsgGetDefaultInstanceForType() {
    // Arrange
    GatewayAttributeUpdateNotificationMsg defaultInstance = GatewayAttributeUpdateNotificationMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg getDeviceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String GatewayAttributeUpdateNotificationMsg.getDeviceName()"})
  void testGatewayAttributeUpdateNotificationMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", GatewayAttributeUpdateNotificationMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg getDeviceNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString GatewayAttributeUpdateNotificationMsg.getDeviceNameBytes()"})
  void testGatewayAttributeUpdateNotificationMsgGetDeviceNameBytes() {
    // Arrange
    GatewayAttributeUpdateNotificationMsg defaultInstance = GatewayAttributeUpdateNotificationMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#getNotificationMsg()}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#getNotificationMsg()}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg getNotificationMsg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.getNotificationMsg()"})
  void testGatewayAttributeUpdateNotificationMsgGetNotificationMsg() {
    // Arrange and Act
    AttributeUpdateNotificationMsg actualNotificationMsg = GatewayAttributeUpdateNotificationMsg.getDefaultInstance()
        .getNotificationMsg();

    // Assert
    assertEquals("", actualNotificationMsg.getInitializationErrorString());
    assertEquals(0, actualNotificationMsg.getSerializedSize());
    assertEquals(0, actualNotificationMsg.getSharedDeletedCount());
    assertEquals(0, actualNotificationMsg.getSharedUpdatedCount());
    assertTrue(actualNotificationMsg.findInitializationErrors().isEmpty());
    assertTrue(actualNotificationMsg.getSharedDeletedList().isEmpty());
    List<TsKvProto> sharedUpdatedList = actualNotificationMsg.getSharedUpdatedList();
    assertTrue(sharedUpdatedList.isEmpty());
    assertTrue(actualNotificationMsg.getAllFields().isEmpty());
    assertTrue(actualNotificationMsg.isInitialized());
    assertSame(actualNotificationMsg, actualNotificationMsg.getDefaultInstanceForType());
    assertSame(sharedUpdatedList, actualNotificationMsg.getSharedUpdatedOrBuilderList());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayAttributeUpdateNotificationMsg.getSerializedSize()"})
  void testGatewayAttributeUpdateNotificationMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayAttributeUpdateNotificationMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#hasNotificationMsg()}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#hasNotificationMsg()}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg hasNotificationMsg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributeUpdateNotificationMsg.hasNotificationMsg()"})
  void testGatewayAttributeUpdateNotificationMsgHasNotificationMsg() {
    // Arrange, Act and Assert
    assertFalse(GatewayAttributeUpdateNotificationMsg.getDefaultInstance().hasNotificationMsg());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#isInitialized()}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributeUpdateNotificationMsg.isInitialized()"})
  void testGatewayAttributeUpdateNotificationMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(GatewayAttributeUpdateNotificationMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayAttributeUpdateNotificationMsg actualParseDelimitedFromResult = GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    GatewayAttributeUpdateNotificationMsg defaultInstanceForType = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    AttributeUpdateNotificationMsg notificationMsg = actualParseDelimitedFromResult.getNotificationMsg();
    assertSame(notificationMsg, defaultInstanceForType.getNotificationMsg());
    assertSame(notificationMsg, defaultInstanceForType.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, actualParseDelimitedFromResult.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, notificationMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayAttributeUpdateNotificationMsg actualParseDelimitedFromResult = GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    AttributeUpdateNotificationMsg notificationMsg = actualParseDelimitedFromResult.getNotificationMsg();
    assertSame(unknownFields, notificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(notificationMsg, actualParseDelimitedFromResult.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, notificationMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInput4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInput5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInput6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayAttributeUpdateNotificationMsg actualParseDelimitedFromResult = GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    GatewayAttributeUpdateNotificationMsg defaultInstanceForType = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    AttributeUpdateNotificationMsg notificationMsg = actualParseDelimitedFromResult.getNotificationMsg();
    assertSame(notificationMsg, defaultInstanceForType.getNotificationMsg());
    assertSame(notificationMsg, defaultInstanceForType.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, actualParseDelimitedFromResult.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, notificationMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayAttributeUpdateNotificationMsg actualParseDelimitedFromResult = GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    AttributeUpdateNotificationMsg notificationMsg = actualParseDelimitedFromResult.getNotificationMsg();
    assertSame(unknownFields, notificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(notificationMsg, actualParseDelimitedFromResult.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, notificationMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFromWithInputExtensionRegistry6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(byte[])"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayAttributeUpdateNotificationMsg actualParseFromResult = GatewayAttributeUpdateNotificationMsg
        .parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasNotificationMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(ByteBuffer)"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayAttributeUpdateNotificationMsg actualParseFromResult = GatewayAttributeUpdateNotificationMsg
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasNotificationMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    GatewayAttributeUpdateNotificationMsg actualParseFromResult = GatewayAttributeUpdateNotificationMsg.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasNotificationMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(byte[], ExtensionRegistryLite)"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayAttributeUpdateNotificationMsg actualParseFromResult = GatewayAttributeUpdateNotificationMsg
        .parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasNotificationMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(ByteString)"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    GatewayAttributeUpdateNotificationMsg actualParseFromResult = GatewayAttributeUpdateNotificationMsg.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasNotificationMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    GatewayAttributeUpdateNotificationMsg actualParseFromResult = GatewayAttributeUpdateNotificationMsg.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasNotificationMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(CodedInputStream)"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    GatewayAttributeUpdateNotificationMsg actualParseFromResult = GatewayAttributeUpdateNotificationMsg
        .parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasNotificationMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithCodedInputStreamExtensionRegistryLite()
      throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    GatewayAttributeUpdateNotificationMsg actualParseFromResult = GatewayAttributeUpdateNotificationMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasNotificationMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(InputStream)"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    GatewayAttributeUpdateNotificationMsg actualParseFromResult = GatewayAttributeUpdateNotificationMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    AttributeUpdateNotificationMsg notificationMsg = actualParseFromResult.getNotificationMsg();
    assertSame(unknownFields, notificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(notificationMsg, actualParseFromResult.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, notificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(InputStream)"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayAttributeUpdateNotificationMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(InputStream)"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithInputStream3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayAttributeUpdateNotificationMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    GatewayAttributeUpdateNotificationMsg actualParseFromResult = GatewayAttributeUpdateNotificationMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasNotificationMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayAttributeUpdateNotificationMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayAttributeUpdateNotificationMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributeUpdateNotificationMsg {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributeUpdateNotificationMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributeUpdateNotificationMsg GatewayAttributeUpdateNotificationMsg.parseFrom(InputStream)"})
  void testGatewayAttributeUpdateNotificationMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    GatewayAttributeUpdateNotificationMsg actualParseFromResult = GatewayAttributeUpdateNotificationMsg
        .parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    AttributeUpdateNotificationMsg notificationMsg = actualParseFromResult.getNotificationMsg();
    assertSame(unknownFields, notificationMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(notificationMsg, actualParseFromResult.getNotificationMsgOrBuilder());
    assertSame(notificationMsg, notificationMsg.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#equals(Object)}, and {@link GatewayAttributesMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayAttributesMsg#equals(Object)}
   *   <li>{@link GatewayAttributesMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributesMsg.equals(Object)", "int GatewayAttributesMsg.hashCode()"})
  void testGatewayAttributesMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GatewayAttributesMsg defaultInstance = GatewayAttributesMsg.getDefaultInstance();
    GatewayAttributesMsg defaultInstance2 = GatewayAttributesMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#equals(Object)}, and {@link GatewayAttributesMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayAttributesMsg#equals(Object)}
   *   <li>{@link GatewayAttributesMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributesMsg.equals(Object)", "int GatewayAttributesMsg.hashCode()"})
  void testGatewayAttributesMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GatewayAttributesMsg defaultInstance = GatewayAttributesMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributesMsg.equals(Object)", "int GatewayAttributesMsg.hashCode()"})
  void testGatewayAttributesMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayAttributesMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributesMsg.equals(Object)", "int GatewayAttributesMsg.hashCode()"})
  void testGatewayAttributesMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayAttributesMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributesMsg.equals(Object)", "int GatewayAttributesMsg.hashCode()"})
  void testGatewayAttributesMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayAttributesMsg.getDefaultInstance(), "Different type to GatewayAttributesMsg");
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.getDefaultInstanceForType()"})
  void testGatewayAttributesMsgGetDefaultInstanceForType() {
    // Arrange
    GatewayAttributesMsg defaultInstance = GatewayAttributesMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#getMsgCount()}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#getMsgCount()}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg getMsgCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayAttributesMsg.getMsgCount()"})
  void testGatewayAttributesMsgGetMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayAttributesMsg.getDefaultInstance().getMsgCount());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayAttributesMsg.getSerializedSize()"})
  void testGatewayAttributesMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayAttributesMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#isInitialized()}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributesMsg.isInitialized()"})
  void testGatewayAttributesMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(GatewayAttributesMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributesMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayAttributesMsg actualParseDelimitedFromResult = GatewayAttributesMsg.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getMsgCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<AttributesMsg> msgList = actualParseDelimitedFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseDelimitedFromResult.getMsgOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributesMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayAttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesMsg GatewayAttributesMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayAttributesMsg actualParseDelimitedFromResult = GatewayAttributesMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getMsgCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<AttributesMsg> msgList = actualParseDelimitedFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseDelimitedFromResult.getMsgOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesMsg GatewayAttributesMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayAttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesMsg GatewayAttributesMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayAttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesMsg GatewayAttributesMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayAttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributesMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayAttributesMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributesMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayAttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseFrom(byte[])"})
  void testGatewayAttributesMsgParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayAttributesMsg actualParseFromResult = GatewayAttributesMsg.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<AttributesMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseFrom(ByteBuffer)"})
  void testGatewayAttributesMsgParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayAttributesMsg actualParseFromResult = GatewayAttributesMsg.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<AttributesMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testGatewayAttributesMsgParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    GatewayAttributesMsg actualParseFromResult = GatewayAttributesMsg.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<AttributesMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseFrom(byte[], ExtensionRegistryLite)"})
  void testGatewayAttributesMsgParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayAttributesMsg actualParseFromResult = GatewayAttributesMsg.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<AttributesMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseFrom(InputStream)"})
  void testGatewayAttributesMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    GatewayAttributesMsg actualParseFromResult = GatewayAttributesMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseFrom(InputStream)"})
  void testGatewayAttributesMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayAttributesMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    GatewayAttributesMsg actualParseFromResult = GatewayAttributesMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<AttributesMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayAttributesMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesMsgParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayAttributesMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseFrom(InputStream)"})
  void testGatewayAttributesMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayAttributesMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesMsg {@link GatewayAttributesMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesMsg GatewayAttributesMsg.parseFrom(InputStream)"})
  void testGatewayAttributesMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    GatewayAttributesMsg actualParseFromResult = GatewayAttributesMsg.parseFrom((InputStream) null);

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#equals(Object)}, and {@link GatewayAttributesRequestMsg#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayAttributesRequestMsg#equals(Object)}
   *   <li>{@link GatewayAttributesRequestMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg equals(Object), and hashCode(); then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributesRequestMsg.equals(Object)",
      "int GatewayAttributesRequestMsg.hashCode()"})
  void testGatewayAttributesRequestMsgEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    GatewayAttributesRequestMsg defaultInstance = GatewayAttributesRequestMsg.getDefaultInstance();
    GatewayAttributesRequestMsg defaultInstance2 = GatewayAttributesRequestMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#equals(Object)}, and {@link GatewayAttributesRequestMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayAttributesRequestMsg#equals(Object)}
   *   <li>{@link GatewayAttributesRequestMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributesRequestMsg.equals(Object)",
      "int GatewayAttributesRequestMsg.hashCode()"})
  void testGatewayAttributesRequestMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GatewayAttributesRequestMsg defaultInstance = GatewayAttributesRequestMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributesRequestMsg.equals(Object)",
      "int GatewayAttributesRequestMsg.hashCode()"})
  void testGatewayAttributesRequestMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayAttributesRequestMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributesRequestMsg.equals(Object)",
      "int GatewayAttributesRequestMsg.hashCode()"})
  void testGatewayAttributesRequestMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayAttributesRequestMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributesRequestMsg.equals(Object)",
      "int GatewayAttributesRequestMsg.hashCode()"})
  void testGatewayAttributesRequestMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayAttributesRequestMsg.getDefaultInstance(), "Different type to GatewayAttributesRequestMsg");
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.getDefaultInstanceForType()"})
  void testGatewayAttributesRequestMsgGetDefaultInstanceForType() {
    // Arrange
    GatewayAttributesRequestMsg defaultInstance = GatewayAttributesRequestMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg getDeviceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String GatewayAttributesRequestMsg.getDeviceName()"})
  void testGatewayAttributesRequestMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", GatewayAttributesRequestMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg getDeviceNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString GatewayAttributesRequestMsg.getDeviceNameBytes()"})
  void testGatewayAttributesRequestMsgGetDeviceNameBytes() {
    // Arrange
    GatewayAttributesRequestMsg defaultInstance = GatewayAttributesRequestMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#getKeysCount()}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#getKeysCount()}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg getKeysCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayAttributesRequestMsg.getKeysCount()"})
  void testGatewayAttributesRequestMsgGetKeysCount() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayAttributesRequestMsg.getDefaultInstance().getKeysCount());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#getKeysList()}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#getKeysList()}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg getKeysList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtocolStringList GatewayAttributesRequestMsg.getKeysList()"})
  void testGatewayAttributesRequestMsgGetKeysList() {
    // Arrange
    GatewayAttributesRequestMsg defaultInstance = GatewayAttributesRequestMsg.getDefaultInstance();

    // Act
    ProtocolStringList actualKeysList = defaultInstance.getKeysList();

    // Assert
    assertTrue(actualKeysList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualKeysList).EMPTY;
    DescriptorProto toProtoResult = defaultInstance.getDescriptorForType().toProto();
    assertSame(lazyStringList, toProtoResult.getDefaultInstanceForType().getReservedNameList());
    assertSame(lazyStringList, toProtoResult.getReservedNameList());
    assertSame(lazyStringList, actualKeysList);
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayAttributesRequestMsg.getSerializedSize()"})
  void testGatewayAttributesRequestMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayAttributesRequestMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#isInitialized()}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayAttributesRequestMsg.isInitialized()"})
  void testGatewayAttributesRequestMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(GatewayAttributesRequestMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayAttributesRequestMsg actualParseDelimitedFromResult = GatewayAttributesRequestMsg.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getDeviceName());
    assertEquals(0, actualParseDelimitedFromResult.getId());
    assertEquals(0, actualParseDelimitedFromResult.getKeysCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertFalse(actualParseDelimitedFromResult.getClient());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getKeysList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayAttributesRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> GatewayAttributesRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayAttributesRequestMsg actualParseDelimitedFromResult = GatewayAttributesRequestMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getDeviceName());
    assertEquals(0, actualParseDelimitedFromResult.getId());
    assertEquals(0, actualParseDelimitedFromResult.getKeysCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertFalse(actualParseDelimitedFromResult.getClient());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getKeysList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayAttributesRequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayAttributesRequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayAttributesRequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> GatewayAttributesRequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayAttributesRequestMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayAttributesRequestMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayAttributesRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(byte[])"})
  void testGatewayAttributesRequestMsgParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getClient());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(ByteBuffer)"})
  void testGatewayAttributesRequestMsgParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getClient());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testGatewayAttributesRequestMsgParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getClient());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(byte[], ExtensionRegistryLite)"})
  void testGatewayAttributesRequestMsgParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getClient());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(ByteString)"})
  void testGatewayAttributesRequestMsgParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getClient());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(ByteString)"})
  void testGatewayAttributesRequestMsgParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getClient());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testGatewayAttributesRequestMsgParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getClient());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testGatewayAttributesRequestMsgParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getClient());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesRequestMsgParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getClient());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesRequestMsgParseFromWithCodedInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getClient());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(CodedInputStream) with 'CodedInputStream'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(CodedInputStream)"})
  void testGatewayAttributesRequestMsgParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getClient());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(CodedInputStream) with 'CodedInputStream'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(CodedInputStream)"})
  void testGatewayAttributesRequestMsgParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getClient());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(InputStream)"})
  void testGatewayAttributesRequestMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(InputStream)"})
  void testGatewayAttributesRequestMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayAttributesRequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesRequestMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getClient());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesRequestMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayAttributesRequestMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayAttributesRequestMsgParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayAttributesRequestMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(InputStream)"})
  void testGatewayAttributesRequestMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayAttributesRequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayAttributesRequestMsg {@link GatewayAttributesRequestMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayAttributesRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayAttributesRequestMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayAttributesRequestMsg GatewayAttributesRequestMsg.parseFrom(InputStream)"})
  void testGatewayAttributesRequestMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    GatewayAttributesRequestMsg actualParseFromResult = GatewayAttributesRequestMsg.parseFrom((InputStream) null);

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#equals(Object)}, and {@link GatewayClaimMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayClaimMsg#equals(Object)}
   *   <li>{@link GatewayClaimMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayClaimMsg equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayClaimMsg.equals(Object)", "int GatewayClaimMsg.hashCode()"})
  void testGatewayClaimMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GatewayClaimMsg defaultInstance = GatewayClaimMsg.getDefaultInstance();
    GatewayClaimMsg defaultInstance2 = GatewayClaimMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#equals(Object)}, and {@link GatewayClaimMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayClaimMsg#equals(Object)}
   *   <li>{@link GatewayClaimMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayClaimMsg equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayClaimMsg.equals(Object)", "int GatewayClaimMsg.hashCode()"})
  void testGatewayClaimMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GatewayClaimMsg defaultInstance = GatewayClaimMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayClaimMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayClaimMsg.equals(Object)", "int GatewayClaimMsg.hashCode()"})
  void testGatewayClaimMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayClaimMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayClaimMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayClaimMsg.equals(Object)", "int GatewayClaimMsg.hashCode()"})
  void testGatewayClaimMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayClaimMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayClaimMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayClaimMsg.equals(Object)", "int GatewayClaimMsg.hashCode()"})
  void testGatewayClaimMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayClaimMsg.getDefaultInstance(), "Different type to GatewayClaimMsg");
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.getDefaultInstanceForType()"})
  void testGatewayClaimMsgGetDefaultInstanceForType() {
    // Arrange
    GatewayClaimMsg defaultInstance = GatewayClaimMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#getMsgCount()}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#getMsgCount()}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg getMsgCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayClaimMsg.getMsgCount()"})
  void testGatewayClaimMsgGetMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayClaimMsg.getDefaultInstance().getMsgCount());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayClaimMsg.getSerializedSize()"})
  void testGatewayClaimMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayClaimMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#isInitialized()}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayClaimMsg.isInitialized()"})
  void testGatewayClaimMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(GatewayClaimMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayClaimMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayClaimMsg actualParseDelimitedFromResult = GatewayClaimMsg.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getMsgCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<ClaimDeviceMsg> msgList = actualParseDelimitedFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseDelimitedFromResult.getMsgOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayClaimMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayClaimMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayClaimMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayClaimMsg actualParseDelimitedFromResult = GatewayClaimMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getMsgCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<ClaimDeviceMsg> msgList = actualParseDelimitedFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseDelimitedFromResult.getMsgOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayClaimMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayClaimMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayClaimMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayClaimMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayClaimMsgParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayClaimMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayClaimMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayClaimMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayClaimMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayClaimMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseFrom(byte[])"})
  void testGatewayClaimMsgParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayClaimMsg actualParseFromResult = GatewayClaimMsg.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ClaimDeviceMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseFrom(ByteBuffer)"})
  void testGatewayClaimMsgParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayClaimMsg actualParseFromResult = GatewayClaimMsg.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ClaimDeviceMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testGatewayClaimMsgParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    GatewayClaimMsg actualParseFromResult = GatewayClaimMsg.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ClaimDeviceMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseFrom(byte[], ExtensionRegistryLite)"})
  void testGatewayClaimMsgParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayClaimMsg actualParseFromResult = GatewayClaimMsg.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ClaimDeviceMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseFrom(InputStream)"})
  void testGatewayClaimMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    GatewayClaimMsg actualParseFromResult = GatewayClaimMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseFrom(InputStream)"})
  void testGatewayClaimMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayClaimMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayClaimMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    GatewayClaimMsg actualParseFromResult = GatewayClaimMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ClaimDeviceMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayClaimMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayClaimMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayClaimMsgParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayClaimMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseFrom(InputStream)"})
  void testGatewayClaimMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayClaimMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayClaimMsg {@link GatewayClaimMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayClaimMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayClaimMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayClaimMsg GatewayClaimMsg.parseFrom(InputStream)"})
  void testGatewayClaimMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    GatewayClaimMsg actualParseFromResult = GatewayClaimMsg.parseFrom((InputStream) null);

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#equals(Object)}, and {@link GatewayDeviceRpcRequestMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayDeviceRpcRequestMsg#equals(Object)}
   *   <li>{@link GatewayDeviceRpcRequestMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayDeviceRpcRequestMsg.equals(Object)", "int GatewayDeviceRpcRequestMsg.hashCode()"})
  void testGatewayDeviceRpcRequestMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GatewayDeviceRpcRequestMsg defaultInstance = GatewayDeviceRpcRequestMsg.getDefaultInstance();
    GatewayDeviceRpcRequestMsg defaultInstance2 = GatewayDeviceRpcRequestMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#equals(Object)}, and {@link GatewayDeviceRpcRequestMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayDeviceRpcRequestMsg#equals(Object)}
   *   <li>{@link GatewayDeviceRpcRequestMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayDeviceRpcRequestMsg.equals(Object)", "int GatewayDeviceRpcRequestMsg.hashCode()"})
  void testGatewayDeviceRpcRequestMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GatewayDeviceRpcRequestMsg defaultInstance = GatewayDeviceRpcRequestMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayDeviceRpcRequestMsg.equals(Object)", "int GatewayDeviceRpcRequestMsg.hashCode()"})
  void testGatewayDeviceRpcRequestMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayDeviceRpcRequestMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayDeviceRpcRequestMsg.equals(Object)", "int GatewayDeviceRpcRequestMsg.hashCode()"})
  void testGatewayDeviceRpcRequestMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayDeviceRpcRequestMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayDeviceRpcRequestMsg.equals(Object)", "int GatewayDeviceRpcRequestMsg.hashCode()"})
  void testGatewayDeviceRpcRequestMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayDeviceRpcRequestMsg.getDefaultInstance(), "Different type to GatewayDeviceRpcRequestMsg");
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.getDefaultInstanceForType()"})
  void testGatewayDeviceRpcRequestMsgGetDefaultInstanceForType() {
    // Arrange
    GatewayDeviceRpcRequestMsg defaultInstance = GatewayDeviceRpcRequestMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg getDeviceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String GatewayDeviceRpcRequestMsg.getDeviceName()"})
  void testGatewayDeviceRpcRequestMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", GatewayDeviceRpcRequestMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg getDeviceNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString GatewayDeviceRpcRequestMsg.getDeviceNameBytes()"})
  void testGatewayDeviceRpcRequestMsgGetDeviceNameBytes() {
    // Arrange
    GatewayDeviceRpcRequestMsg defaultInstance = GatewayDeviceRpcRequestMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
    ToDeviceRpcRequestMsg rpcRequestMsg = defaultInstance.getRpcRequestMsg();
    assertEquals(byteString, rpcRequestMsg.getMethodNameBytes());
    assertEquals(byteString, rpcRequestMsg.getParamsBytes());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#getRpcRequestMsg()}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#getRpcRequestMsg()}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg getRpcRequestMsg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.getRpcRequestMsg()"})
  void testGatewayDeviceRpcRequestMsgGetRpcRequestMsg() {
    // Arrange and Act
    ToDeviceRpcRequestMsg actualRpcRequestMsg = GatewayDeviceRpcRequestMsg.getDefaultInstance().getRpcRequestMsg();

    // Assert
    assertEquals("", actualRpcRequestMsg.getInitializationErrorString());
    assertEquals("", actualRpcRequestMsg.getMethodName());
    assertEquals("", actualRpcRequestMsg.getParams());
    assertEquals(0, actualRpcRequestMsg.getRequestId());
    assertEquals(0, actualRpcRequestMsg.getSerializedSize());
    assertEquals(0L, actualRpcRequestMsg.getExpirationTime());
    assertEquals(0L, actualRpcRequestMsg.getRequestIdLSB());
    assertEquals(0L, actualRpcRequestMsg.getRequestIdMSB());
    assertFalse(actualRpcRequestMsg.getOneway());
    assertFalse(actualRpcRequestMsg.getPersisted());
    assertTrue(actualRpcRequestMsg.findInitializationErrors().isEmpty());
    assertTrue(actualRpcRequestMsg.getAllFields().isEmpty());
    assertTrue(actualRpcRequestMsg.isInitialized());
    assertSame(actualRpcRequestMsg, actualRpcRequestMsg.getDefaultInstanceForType());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayDeviceRpcRequestMsg.getSerializedSize()"})
  void testGatewayDeviceRpcRequestMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayDeviceRpcRequestMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#hasRpcRequestMsg()}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#hasRpcRequestMsg()}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg hasRpcRequestMsg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayDeviceRpcRequestMsg.hasRpcRequestMsg()"})
  void testGatewayDeviceRpcRequestMsgHasRpcRequestMsg() {
    // Arrange, Act and Assert
    assertFalse(GatewayDeviceRpcRequestMsg.getDefaultInstance().hasRpcRequestMsg());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#isInitialized()}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayDeviceRpcRequestMsg.isInitialized()"})
  void testGatewayDeviceRpcRequestMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(GatewayDeviceRpcRequestMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayDeviceRpcRequestMsg actualParseDelimitedFromResult = GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    GatewayDeviceRpcRequestMsg defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    ToDeviceRpcRequestMsg rpcRequestMsg = actualParseDelimitedFromResult.getRpcRequestMsg();
    assertSame(rpcRequestMsg, defaultInstanceForType.getRpcRequestMsg());
    assertSame(rpcRequestMsg, defaultInstanceForType.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, actualParseDelimitedFromResult.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, rpcRequestMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayDeviceRpcRequestMsg actualParseDelimitedFromResult = GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    ToDeviceRpcRequestMsg rpcRequestMsg = actualParseDelimitedFromResult.getRpcRequestMsg();
    assertSame(unknownFields, rpcRequestMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(rpcRequestMsg, actualParseDelimitedFromResult.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, rpcRequestMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInput4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayDeviceRpcRequestMsg actualParseDelimitedFromResult = GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    GatewayDeviceRpcRequestMsg defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    ToDeviceRpcRequestMsg rpcRequestMsg = actualParseDelimitedFromResult.getRpcRequestMsg();
    assertSame(rpcRequestMsg, defaultInstanceForType.getRpcRequestMsg());
    assertSame(rpcRequestMsg, defaultInstanceForType.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, actualParseDelimitedFromResult.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, rpcRequestMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayDeviceRpcRequestMsg actualParseDelimitedFromResult = GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    ToDeviceRpcRequestMsg rpcRequestMsg = actualParseDelimitedFromResult.getRpcRequestMsg();
    assertSame(unknownFields, rpcRequestMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(rpcRequestMsg, actualParseDelimitedFromResult.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, rpcRequestMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInputExtensionRegistry6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayDeviceRpcRequestMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(byte[])"})
  void testGatewayDeviceRpcRequestMsgParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayDeviceRpcRequestMsg actualParseFromResult = GatewayDeviceRpcRequestMsg.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasRpcRequestMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(ByteBuffer)"})
  void testGatewayDeviceRpcRequestMsgParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayDeviceRpcRequestMsg actualParseFromResult = GatewayDeviceRpcRequestMsg
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasRpcRequestMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testGatewayDeviceRpcRequestMsgParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    GatewayDeviceRpcRequestMsg actualParseFromResult = GatewayDeviceRpcRequestMsg.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasRpcRequestMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(byte[], ExtensionRegistryLite)"})
  void testGatewayDeviceRpcRequestMsgParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayDeviceRpcRequestMsg actualParseFromResult = GatewayDeviceRpcRequestMsg.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasRpcRequestMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(ByteString)"})
  void testGatewayDeviceRpcRequestMsgParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    GatewayDeviceRpcRequestMsg actualParseFromResult = GatewayDeviceRpcRequestMsg.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasRpcRequestMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testGatewayDeviceRpcRequestMsgParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    GatewayDeviceRpcRequestMsg actualParseFromResult = GatewayDeviceRpcRequestMsg.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasRpcRequestMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(CodedInputStream)"})
  void testGatewayDeviceRpcRequestMsgParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    GatewayDeviceRpcRequestMsg actualParseFromResult = GatewayDeviceRpcRequestMsg.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasRpcRequestMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testGatewayDeviceRpcRequestMsgParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    GatewayDeviceRpcRequestMsg actualParseFromResult = GatewayDeviceRpcRequestMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasRpcRequestMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(InputStream)"})
  void testGatewayDeviceRpcRequestMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    GatewayDeviceRpcRequestMsg actualParseFromResult = GatewayDeviceRpcRequestMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    ToDeviceRpcRequestMsg rpcRequestMsg = actualParseFromResult.getRpcRequestMsg();
    assertSame(unknownFields, rpcRequestMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(rpcRequestMsg, actualParseFromResult.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, rpcRequestMsg.getDefaultInstanceForType());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(InputStream)"})
  void testGatewayDeviceRpcRequestMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayDeviceRpcRequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayDeviceRpcRequestMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    GatewayDeviceRpcRequestMsg actualParseFromResult = GatewayDeviceRpcRequestMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasRpcRequestMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayDeviceRpcRequestMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayDeviceRpcRequestMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayDeviceRpcRequestMsgParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayDeviceRpcRequestMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(InputStream)"})
  void testGatewayDeviceRpcRequestMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayDeviceRpcRequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayDeviceRpcRequestMsg {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayDeviceRpcRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayDeviceRpcRequestMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayDeviceRpcRequestMsg GatewayDeviceRpcRequestMsg.parseFrom(InputStream)"})
  void testGatewayDeviceRpcRequestMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    GatewayDeviceRpcRequestMsg actualParseFromResult = GatewayDeviceRpcRequestMsg.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    ToDeviceRpcRequestMsg rpcRequestMsg = actualParseFromResult.getRpcRequestMsg();
    assertSame(unknownFields, rpcRequestMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(rpcRequestMsg, actualParseFromResult.getRpcRequestMsgOrBuilder());
    assertSame(rpcRequestMsg, rpcRequestMsg.getDefaultInstanceForType());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#equals(Object)}, and {@link GatewayRpcResponseMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayRpcResponseMsg#equals(Object)}
   *   <li>{@link GatewayRpcResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayRpcResponseMsg.equals(Object)", "int GatewayRpcResponseMsg.hashCode()"})
  void testGatewayRpcResponseMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GatewayRpcResponseMsg defaultInstance = GatewayRpcResponseMsg.getDefaultInstance();
    GatewayRpcResponseMsg defaultInstance2 = GatewayRpcResponseMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#equals(Object)}, and {@link GatewayRpcResponseMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayRpcResponseMsg#equals(Object)}
   *   <li>{@link GatewayRpcResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayRpcResponseMsg.equals(Object)", "int GatewayRpcResponseMsg.hashCode()"})
  void testGatewayRpcResponseMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GatewayRpcResponseMsg defaultInstance = GatewayRpcResponseMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayRpcResponseMsg.equals(Object)", "int GatewayRpcResponseMsg.hashCode()"})
  void testGatewayRpcResponseMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayRpcResponseMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayRpcResponseMsg.equals(Object)", "int GatewayRpcResponseMsg.hashCode()"})
  void testGatewayRpcResponseMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayRpcResponseMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayRpcResponseMsg.equals(Object)", "int GatewayRpcResponseMsg.hashCode()"})
  void testGatewayRpcResponseMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayRpcResponseMsg.getDefaultInstance(), "Different type to GatewayRpcResponseMsg");
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#getData()}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#getData()}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg getData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String GatewayRpcResponseMsg.getData()"})
  void testGatewayRpcResponseMsgGetData() {
    // Arrange, Act and Assert
    assertEquals("", GatewayRpcResponseMsg.getDefaultInstance().getData());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#getDataBytes()}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#getDataBytes()}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg getDataBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString GatewayRpcResponseMsg.getDataBytes()"})
  void testGatewayRpcResponseMsgGetDataBytes() {
    // Arrange
    GatewayRpcResponseMsg defaultInstance = GatewayRpcResponseMsg.getDefaultInstance();

    // Act
    ByteString actualDataBytes = defaultInstance.getDataBytes();

    // Assert
    ByteString byteString = actualDataBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualDataBytes);
    assertEquals(byteString, defaultInstance.getDeviceNameBytes());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.getDefaultInstanceForType()"})
  void testGatewayRpcResponseMsgGetDefaultInstanceForType() {
    // Arrange
    GatewayRpcResponseMsg defaultInstance = GatewayRpcResponseMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg getDeviceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String GatewayRpcResponseMsg.getDeviceName()"})
  void testGatewayRpcResponseMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", GatewayRpcResponseMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg getDeviceNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString GatewayRpcResponseMsg.getDeviceNameBytes()"})
  void testGatewayRpcResponseMsgGetDeviceNameBytes() {
    // Arrange
    GatewayRpcResponseMsg defaultInstance = GatewayRpcResponseMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDataBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayRpcResponseMsg.getSerializedSize()"})
  void testGatewayRpcResponseMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayRpcResponseMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#isInitialized()}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayRpcResponseMsg.isInitialized()"})
  void testGatewayRpcResponseMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(GatewayRpcResponseMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayRpcResponseMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayRpcResponseMsg actualParseDelimitedFromResult = GatewayRpcResponseMsg.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getData());
    assertEquals("", actualParseDelimitedFromResult.getDeviceName());
    assertEquals(0, actualParseDelimitedFromResult.getId());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayRpcResponseMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayRpcResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayRpcResponseMsgParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> GatewayRpcResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayRpcResponseMsg GatewayRpcResponseMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayRpcResponseMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayRpcResponseMsg actualParseDelimitedFromResult = GatewayRpcResponseMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getData());
    assertEquals("", actualParseDelimitedFromResult.getDeviceName());
    assertEquals(0, actualParseDelimitedFromResult.getId());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayRpcResponseMsg GatewayRpcResponseMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayRpcResponseMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayRpcResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayRpcResponseMsg GatewayRpcResponseMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayRpcResponseMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayRpcResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayRpcResponseMsg GatewayRpcResponseMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayRpcResponseMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayRpcResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "GatewayRpcResponseMsg GatewayRpcResponseMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayRpcResponseMsgParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> GatewayRpcResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayRpcResponseMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayRpcResponseMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayRpcResponseMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayRpcResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(byte[])"})
  void testGatewayRpcResponseMsgParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayRpcResponseMsg actualParseFromResult = GatewayRpcResponseMsg.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(ByteBuffer)"})
  void testGatewayRpcResponseMsgParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayRpcResponseMsg actualParseFromResult = GatewayRpcResponseMsg.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testGatewayRpcResponseMsgParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    GatewayRpcResponseMsg actualParseFromResult = GatewayRpcResponseMsg.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(byte[], ExtensionRegistryLite)"})
  void testGatewayRpcResponseMsgParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayRpcResponseMsg actualParseFromResult = GatewayRpcResponseMsg.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(ByteString)"})
  void testGatewayRpcResponseMsgParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    GatewayRpcResponseMsg actualParseFromResult = GatewayRpcResponseMsg.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getDataBytes());
    assertEquals(byteString, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testGatewayRpcResponseMsgParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    GatewayRpcResponseMsg actualParseFromResult = GatewayRpcResponseMsg.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getDataBytes());
    assertEquals(byteString, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(CodedInputStream)"})
  void testGatewayRpcResponseMsgParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    GatewayRpcResponseMsg actualParseFromResult = GatewayRpcResponseMsg.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testGatewayRpcResponseMsgParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    GatewayRpcResponseMsg actualParseFromResult = GatewayRpcResponseMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(InputStream)"})
  void testGatewayRpcResponseMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    GatewayRpcResponseMsg actualParseFromResult = GatewayRpcResponseMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(InputStream)"})
  void testGatewayRpcResponseMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayRpcResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayRpcResponseMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    GatewayRpcResponseMsg actualParseFromResult = GatewayRpcResponseMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getId());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayRpcResponseMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayRpcResponseMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayRpcResponseMsgParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayRpcResponseMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(InputStream)"})
  void testGatewayRpcResponseMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayRpcResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayRpcResponseMsg {@link GatewayRpcResponseMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayRpcResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayRpcResponseMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayRpcResponseMsg GatewayRpcResponseMsg.parseFrom(InputStream)"})
  void testGatewayRpcResponseMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    GatewayRpcResponseMsg actualParseFromResult = GatewayRpcResponseMsg.parseFrom((InputStream) null);

    // Assert
    assertEquals(3, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#equals(Object)}, and {@link GatewayTelemetryMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayTelemetryMsg#equals(Object)}
   *   <li>{@link GatewayTelemetryMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayTelemetryMsg.equals(Object)", "int GatewayTelemetryMsg.hashCode()"})
  void testGatewayTelemetryMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GatewayTelemetryMsg defaultInstance = GatewayTelemetryMsg.getDefaultInstance();
    GatewayTelemetryMsg defaultInstance2 = GatewayTelemetryMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#equals(Object)}, and {@link GatewayTelemetryMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GatewayTelemetryMsg#equals(Object)}
   *   <li>{@link GatewayTelemetryMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayTelemetryMsg.equals(Object)", "int GatewayTelemetryMsg.hashCode()"})
  void testGatewayTelemetryMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GatewayTelemetryMsg defaultInstance = GatewayTelemetryMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayTelemetryMsg.equals(Object)", "int GatewayTelemetryMsg.hashCode()"})
  void testGatewayTelemetryMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayTelemetryMsg.getDefaultInstance(), 1);
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayTelemetryMsg.equals(Object)", "int GatewayTelemetryMsg.hashCode()"})
  void testGatewayTelemetryMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayTelemetryMsg.getDefaultInstance(), null);
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayTelemetryMsg.equals(Object)", "int GatewayTelemetryMsg.hashCode()"})
  void testGatewayTelemetryMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(GatewayTelemetryMsg.getDefaultInstance(), "Different type to GatewayTelemetryMsg");
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.getDefaultInstanceForType()"})
  void testGatewayTelemetryMsgGetDefaultInstanceForType() {
    // Arrange
    GatewayTelemetryMsg defaultInstance = GatewayTelemetryMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#getMsgCount()}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#getMsgCount()}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg getMsgCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayTelemetryMsg.getMsgCount()"})
  void testGatewayTelemetryMsgGetMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayTelemetryMsg.getDefaultInstance().getMsgCount());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GatewayTelemetryMsg.getSerializedSize()"})
  void testGatewayTelemetryMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, GatewayTelemetryMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#isInitialized()}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GatewayTelemetryMsg.isInitialized()"})
  void testGatewayTelemetryMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(GatewayTelemetryMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayTelemetryMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayTelemetryMsg actualParseDelimitedFromResult = GatewayTelemetryMsg.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getMsgCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<TelemetryMsg> msgList = actualParseDelimitedFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseDelimitedFromResult.getMsgOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayTelemetryMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayTelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayTelemetryMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    GatewayTelemetryMsg actualParseDelimitedFromResult = GatewayTelemetryMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getMsgCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<TelemetryMsg> msgList = actualParseDelimitedFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseDelimitedFromResult.getMsgOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayTelemetryMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayTelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayTelemetryMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayTelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayTelemetryMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayTelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayTelemetryMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(GatewayTelemetryMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseDelimitedFrom(InputStream)"})
  void testGatewayTelemetryMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayTelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseFrom(byte[])"})
  void testGatewayTelemetryMsgParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayTelemetryMsg actualParseFromResult = GatewayTelemetryMsg.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TelemetryMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseFrom(ByteBuffer)"})
  void testGatewayTelemetryMsgParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayTelemetryMsg actualParseFromResult = GatewayTelemetryMsg.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TelemetryMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testGatewayTelemetryMsgParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    GatewayTelemetryMsg actualParseFromResult = GatewayTelemetryMsg.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TelemetryMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseFrom(byte[], ExtensionRegistryLite)"})
  void testGatewayTelemetryMsgParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    GatewayTelemetryMsg actualParseFromResult = GatewayTelemetryMsg.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TelemetryMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseFrom(InputStream)"})
  void testGatewayTelemetryMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    GatewayTelemetryMsg actualParseFromResult = GatewayTelemetryMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseFrom(InputStream)"})
  void testGatewayTelemetryMsgParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> GatewayTelemetryMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayTelemetryMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    GatewayTelemetryMsg actualParseFromResult = GatewayTelemetryMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getMsgCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TelemetryMsg> msgList = actualParseFromResult.getMsgList();
    assertTrue(msgList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(msgList, actualParseFromResult.getMsgOrBuilderList());
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayTelemetryMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> GatewayTelemetryMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testGatewayTelemetryMsgParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> GatewayTelemetryMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseFrom(InputStream)"})
  void testGatewayTelemetryMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> GatewayTelemetryMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test GatewayTelemetryMsg {@link GatewayTelemetryMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewayTelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test GatewayTelemetryMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GatewayTelemetryMsg GatewayTelemetryMsg.parseFrom(InputStream)"})
  void testGatewayTelemetryMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    GatewayTelemetryMsg actualParseFromResult = GatewayTelemetryMsg.parseFrom((InputStream) null);

    // Assert
    assertEquals(1, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test RpcRequest {@link RpcRequest#equals(Object)}, and {@link RpcRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcRequest#equals(Object)}
   *   <li>{@link RpcRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test RpcRequest equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcRequest.equals(Object)", "int RpcRequest.hashCode()"})
  void testRpcRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcRequest defaultInstance = RpcRequest.getDefaultInstance();
    RpcRequest defaultInstance2 = RpcRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test RpcRequest {@link RpcRequest#equals(Object)}, and {@link RpcRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcRequest#equals(Object)}
   *   <li>{@link RpcRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test RpcRequest equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcRequest.equals(Object)", "int RpcRequest.hashCode()"})
  void testRpcRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcRequest defaultInstance = RpcRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test RpcRequest {@link RpcRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test RpcRequest equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcRequest.equals(Object)", "int RpcRequest.hashCode()"})
  void testRpcRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RpcRequest.getDefaultInstance(), 1);
  }

  /**
   * Test RpcRequest {@link RpcRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test RpcRequest equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcRequest.equals(Object)", "int RpcRequest.hashCode()"})
  void testRpcRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RpcRequest.getDefaultInstance(), null);
  }

  /**
   * Test RpcRequest {@link RpcRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test RpcRequest equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcRequest.equals(Object)", "int RpcRequest.hashCode()"})
  void testRpcRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RpcRequest.getDefaultInstance(), "Different type to RpcRequest");
  }

  /**
   * Test RpcRequest {@link RpcRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link RpcRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test RpcRequest getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.getDefaultInstanceForType()"})
  void testRpcRequestGetDefaultInstanceForType() {
    // Arrange
    RpcRequest defaultInstance = RpcRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test RpcRequest {@link RpcRequest#getMethod()}.
   * <p>
   * Method under test: {@link RpcRequest#getMethod()}
   */
  @Test
  @DisplayName("Test RpcRequest getMethod()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String RpcRequest.getMethod()"})
  void testRpcRequestGetMethod() {
    // Arrange, Act and Assert
    assertEquals("", RpcRequest.getDefaultInstance().getMethod());
  }

  /**
   * Test RpcRequest {@link RpcRequest#getMethodBytes()}.
   * <p>
   * Method under test: {@link RpcRequest#getMethodBytes()}
   */
  @Test
  @DisplayName("Test RpcRequest getMethodBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString RpcRequest.getMethodBytes()"})
  void testRpcRequestGetMethodBytes() {
    // Arrange
    RpcRequest defaultInstance = RpcRequest.getDefaultInstance();

    // Act
    ByteString actualMethodBytes = defaultInstance.getMethodBytes();

    // Assert
    ByteString byteString = actualMethodBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualMethodBytes);
    assertEquals(byteString, defaultInstance.getParamsBytes());
  }

  /**
   * Test RpcRequest {@link RpcRequest#getParams()}.
   * <p>
   * Method under test: {@link RpcRequest#getParams()}
   */
  @Test
  @DisplayName("Test RpcRequest getParams()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String RpcRequest.getParams()"})
  void testRpcRequestGetParams() {
    // Arrange, Act and Assert
    assertEquals("", RpcRequest.getDefaultInstance().getParams());
  }

  /**
   * Test RpcRequest {@link RpcRequest#getParamsBytes()}.
   * <p>
   * Method under test: {@link RpcRequest#getParamsBytes()}
   */
  @Test
  @DisplayName("Test RpcRequest getParamsBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString RpcRequest.getParamsBytes()"})
  void testRpcRequestGetParamsBytes() {
    // Arrange
    RpcRequest defaultInstance = RpcRequest.getDefaultInstance();

    // Act
    ByteString actualParamsBytes = defaultInstance.getParamsBytes();

    // Assert
    ByteString byteString = actualParamsBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getMethodBytes());
    assertEquals(byteString, actualParamsBytes);
  }

  /**
   * Test RpcRequest {@link RpcRequest#getSerializedSize()}.
   * <p>
   * Method under test: {@link RpcRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test RpcRequest getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RpcRequest.getSerializedSize()"})
  void testRpcRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RpcRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test RpcRequest {@link RpcRequest#isInitialized()}.
   * <p>
   * Method under test: {@link RpcRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test RpcRequest isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcRequest.isInitialized()"})
  void testRpcRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RpcRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link RpcRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseDelimitedFrom(InputStream)"})
  void testRpcRequestParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RpcRequest actualParseDelimitedFromResult = RpcRequest.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getMethod());
    assertEquals("", actualParseDelimitedFromResult.getParams());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link RpcRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseDelimitedFrom(InputStream)"})
  void testRpcRequestParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RpcRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRpcRequestParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RpcRequest actualParseDelimitedFromResult = RpcRequest.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getMethod());
    assertEquals("", actualParseDelimitedFromResult.getParams());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRpcRequestParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RpcRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRpcRequestParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> RpcRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRpcRequestParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RpcRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRpcRequestParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> RpcRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseDelimitedFrom(InputStream)"})
  void testRpcRequestParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RpcRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseDelimitedFrom(InputStream)"})
  void testRpcRequestParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> RpcRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseDelimitedFrom(InputStream)"})
  void testRpcRequestParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RpcRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(ByteBuffer)"})
  void testRpcRequestParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    RpcRequest actualParseFromResult = RpcRequest.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getMethod());
    assertEquals("", actualParseFromResult.getParams());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testRpcRequestParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    RpcRequest actualParseFromResult = RpcRequest.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getMethod());
    assertEquals("", actualParseFromResult.getParams());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(byte[], ExtensionRegistryLite)"})
  void testRpcRequestParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    RpcRequest actualParseFromResult = RpcRequest.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getMethod());
    assertEquals("", actualParseFromResult.getParams());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(ByteString)"})
  void testRpcRequestParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RpcRequest actualParseFromResult = RpcRequest.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getMethod());
    assertEquals("", actualParseFromResult.getParams());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getMethodBytes());
    assertEquals(byteString, actualParseFromResult.getParamsBytes());
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testRpcRequestParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RpcRequest actualParseFromResult = RpcRequest.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getMethod());
    assertEquals("", actualParseFromResult.getParams());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getMethodBytes());
    assertEquals(byteString, actualParseFromResult.getParamsBytes());
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(byte[])"})
  void testRpcRequestParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    RpcRequest actualParseFromResult = RpcRequest.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getMethod());
    assertEquals("", actualParseFromResult.getParams());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(CodedInputStream)"})
  void testRpcRequestParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    RpcRequest actualParseFromResult = RpcRequest.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getMethod());
    assertEquals("", actualParseFromResult.getParams());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testRpcRequestParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    RpcRequest actualParseFromResult = RpcRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getMethod());
    assertEquals("", actualParseFromResult.getParams());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(InputStream)"})
  void testRpcRequestParseFromWithInputStream() throws IOException {
    // Arrange and Act
    RpcRequest actualParseFromResult = RpcRequest.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testRpcRequestParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    RpcRequest actualParseFromResult = RpcRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getMethod());
    assertEquals("", actualParseFromResult.getParams());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testRpcRequestParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RpcRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testRpcRequestParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RpcRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(InputStream)"})
  void testRpcRequestParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RpcRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(InputStream)"})
  void testRpcRequestParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RpcRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RpcRequest {@link RpcRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RpcRequest parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RpcRequest RpcRequest.parseFrom(InputStream)"})
  void testRpcRequestParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    RpcRequest actualParseFromResult = RpcRequest.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#equals(Object)}, and {@link TelemetryMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryMsg#equals(Object)}
   *   <li>{@link TelemetryMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TelemetryMsg equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMsg.equals(Object)", "int TelemetryMsg.hashCode()"})
  void testTelemetryMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TelemetryMsg defaultInstance = TelemetryMsg.getDefaultInstance();
    TelemetryMsg defaultInstance2 = TelemetryMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#equals(Object)}, and {@link TelemetryMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryMsg#equals(Object)}
   *   <li>{@link TelemetryMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TelemetryMsg equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMsg.equals(Object)", "int TelemetryMsg.hashCode()"})
  void testTelemetryMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TelemetryMsg defaultInstance = TelemetryMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test TelemetryMsg equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMsg.equals(Object)", "int TelemetryMsg.hashCode()"})
  void testTelemetryMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TelemetryMsg.getDefaultInstance(), 1);
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test TelemetryMsg equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMsg.equals(Object)", "int TelemetryMsg.hashCode()"})
  void testTelemetryMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TelemetryMsg.getDefaultInstance(), null);
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test TelemetryMsg equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMsg.equals(Object)", "int TelemetryMsg.hashCode()"})
  void testTelemetryMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TelemetryMsg.getDefaultInstance(), "Different type to TelemetryMsg");
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link TelemetryMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test TelemetryMsg getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.getDefaultInstanceForType()"})
  void testTelemetryMsgGetDefaultInstanceForType() {
    // Arrange
    TelemetryMsg defaultInstance = TelemetryMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#getDeviceName()}.
   * <p>
   * Method under test: {@link TelemetryMsg#getDeviceName()}
   */
  @Test
  @DisplayName("Test TelemetryMsg getDeviceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String TelemetryMsg.getDeviceName()"})
  void testTelemetryMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TelemetryMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#getDeviceNameBytes()}.
   * <p>
   * Method under test: {@link TelemetryMsg#getDeviceNameBytes()}
   */
  @Test
  @DisplayName("Test TelemetryMsg getDeviceNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString TelemetryMsg.getDeviceNameBytes()"})
  void testTelemetryMsgGetDeviceNameBytes() {
    // Arrange
    TelemetryMsg defaultInstance = TelemetryMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#getMsg()}.
   * <p>
   * Method under test: {@link TelemetryMsg#getMsg()}
   */
  @Test
  @DisplayName("Test TelemetryMsg getMsg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PostTelemetryMsg TelemetryMsg.getMsg()"})
  void testTelemetryMsgGetMsg() {
    // Arrange and Act
    PostTelemetryMsg actualMsg = TelemetryMsg.getDefaultInstance().getMsg();

    // Assert
    assertEquals("", actualMsg.getInitializationErrorString());
    assertEquals(0, actualMsg.getSerializedSize());
    assertEquals(0, actualMsg.getTsKvListCount());
    assertTrue(actualMsg.findInitializationErrors().isEmpty());
    List<TsKvListProto> tsKvListList = actualMsg.getTsKvListList();
    assertTrue(tsKvListList.isEmpty());
    assertTrue(actualMsg.getAllFields().isEmpty());
    assertTrue(actualMsg.isInitialized());
    assertSame(actualMsg, actualMsg.getDefaultInstanceForType());
    assertSame(tsKvListList, actualMsg.getTsKvListOrBuilderList());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link TelemetryMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test TelemetryMsg getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TelemetryMsg.getSerializedSize()"})
  void testTelemetryMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TelemetryMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#hasMsg()}.
   * <p>
   * Method under test: {@link TelemetryMsg#hasMsg()}
   */
  @Test
  @DisplayName("Test TelemetryMsg hasMsg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMsg.hasMsg()"})
  void testTelemetryMsgHasMsg() {
    // Arrange, Act and Assert
    assertFalse(TelemetryMsg.getDefaultInstance().hasMsg());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#isInitialized()}.
   * <p>
   * Method under test: {@link TelemetryMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test TelemetryMsg isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMsg.isInitialized()"})
  void testTelemetryMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TelemetryMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseDelimitedFrom(InputStream)"})
  void testTelemetryMsgParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TelemetryMsg actualParseDelimitedFromResult = TelemetryMsg.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    TelemetryMsg defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    PostTelemetryMsg msg = actualParseDelimitedFromResult.getMsg();
    assertSame(msg, defaultInstanceForType.getMsg());
    assertSame(msg, defaultInstanceForType.getMsgOrBuilder());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseDelimitedFrom(InputStream)"})
  void testTelemetryMsgParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TelemetryMsg actualParseDelimitedFromResult = TelemetryMsg.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    PostTelemetryMsg msg = actualParseDelimitedFromResult.getMsg();
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseDelimitedFrom(InputStream)"})
  void testTelemetryMsgParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTelemetryMsgParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TelemetryMsg actualParseDelimitedFromResult = TelemetryMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    TelemetryMsg defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    PostTelemetryMsg msg = actualParseDelimitedFromResult.getMsg();
    assertSame(msg, defaultInstanceForType.getMsg());
    assertSame(msg, defaultInstanceForType.getMsgOrBuilder());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTelemetryMsgParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TelemetryMsg actualParseDelimitedFromResult = TelemetryMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    PostTelemetryMsg msg = actualParseDelimitedFromResult.getMsg();
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseDelimitedFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTelemetryMsgParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTelemetryMsgParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTelemetryMsgParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTelemetryMsgParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseDelimitedFrom(InputStream)"})
  void testTelemetryMsgParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TelemetryMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseDelimitedFrom(InputStream)"})
  void testTelemetryMsgParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseDelimitedFrom(InputStream)"})
  void testTelemetryMsgParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(byte[])"})
  void testTelemetryMsgParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    TelemetryMsg actualParseFromResult = TelemetryMsg.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(ByteBuffer)"})
  void testTelemetryMsgParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    TelemetryMsg actualParseFromResult = TelemetryMsg.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testTelemetryMsgParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    TelemetryMsg actualParseFromResult = TelemetryMsg.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(byte[], ExtensionRegistryLite)"})
  void testTelemetryMsgParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    TelemetryMsg actualParseFromResult = TelemetryMsg.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(ByteString)"})
  void testTelemetryMsgParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TelemetryMsg actualParseFromResult = TelemetryMsg.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testTelemetryMsgParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TelemetryMsg actualParseFromResult = TelemetryMsg.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDeviceNameBytes = data.EMPTY;
    assertEquals(expectedDeviceNameBytes, actualParseFromResult.getDeviceNameBytes());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(CodedInputStream)"})
  void testTelemetryMsgParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TelemetryMsg actualParseFromResult = TelemetryMsg.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testTelemetryMsgParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TelemetryMsg actualParseFromResult = TelemetryMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(InputStream)"})
  void testTelemetryMsgParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TelemetryMsg actualParseFromResult = TelemetryMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    PostTelemetryMsg msg = actualParseFromResult.getMsg();
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTelemetryMsgParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    TelemetryMsg actualParseFromResult = TelemetryMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getDeviceName());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasMsg());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTelemetryMsgParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TelemetryMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTelemetryMsgParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TelemetryMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(InputStream)"})
  void testTelemetryMsgParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TelemetryMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(InputStream)"})
  void testTelemetryMsgParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TelemetryMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TelemetryMsg {@link TelemetryMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TelemetryMsg parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TelemetryMsg TelemetryMsg.parseFrom(InputStream)"})
  void testTelemetryMsgParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TelemetryMsg actualParseFromResult = TelemetryMsg.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    PostTelemetryMsg msg = actualParseFromResult.getMsg();
    assertSame(unknownFields, msg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(msg, actualParseFromResult.getMsgOrBuilder());
    assertSame(msg, msg.getDefaultInstanceForType());
  }
}
