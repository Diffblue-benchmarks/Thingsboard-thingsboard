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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.ProtocolStringList;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TransportApiProtosDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.AttributesMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.AttributesMsg#hashCode()}
   * </ul>
   */
  @Test
  void testAttributesMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.AttributesMsg defaultInstance = TransportApiProtos.AttributesMsg.getDefaultInstance();
    TransportApiProtos.AttributesMsg defaultInstance2 = TransportApiProtos.AttributesMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.AttributesMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.AttributesMsg#hashCode()}
   * </ul>
   */
  @Test
  void testAttributesMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.AttributesMsg defaultInstance = TransportApiProtos.AttributesMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link TransportApiProtos.AttributesMsg#equals(Object)}
   */
  @Test
  void testAttributesMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.AttributesMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link TransportApiProtos.AttributesMsg#equals(Object)}
   */
  @Test
  void testAttributesMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.AttributesMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link TransportApiProtos.AttributesMsg#equals(Object)}
   */
  @Test
  void testAttributesMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.AttributesMsg.getDefaultInstance(), "Different type to AttributesMsg");
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#getDefaultInstanceForType()}
   */
  @Test
  void testAttributesMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.AttributesMsg defaultInstance = TransportApiProtos.AttributesMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link TransportApiProtos.AttributesMsg#getDeviceName()}
   */
  @Test
  void testAttributesMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.AttributesMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#getDeviceNameBytes()}
   */
  @Test
  void testAttributesMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.AttributesMsg defaultInstance = TransportApiProtos.AttributesMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#getSerializedSize()}
   */
  @Test
  void testAttributesMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.AttributesMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link TransportApiProtos.AttributesMsg#hasMsg()}
   */
  @Test
  void testAttributesMsgHasMsg() {
    // Arrange, Act and Assert
    assertFalse(TransportApiProtos.AttributesMsg.getDefaultInstance().hasMsg());
  }

  /**
   * Method under test: {@link TransportApiProtos.AttributesMsg#isInitialized()}
   */
  @Test
  void testAttributesMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.AttributesMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testAttributesMsgNewInstance() {
    // Arrange
    TransportApiProtos.AttributesMsg defaultInstance = TransportApiProtos.AttributesMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.AttributesMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testAttributesMsgParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.AttributesMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testAttributesMsgParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.AttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testAttributesMsgParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.AttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testAttributesMsgParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.AttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testAttributesMsgParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.AttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testAttributesMsgParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.AttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testAttributesMsgParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.AttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testAttributesMsgParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.AttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseFrom(InputStream)}
   */
  @Test
  void testAttributesMsgParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.AttributesMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseFrom(InputStream)}
   */
  @Test
  void testAttributesMsgParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.AttributesMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testAttributesMsgParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.AttributesMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testAttributesMsgParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.AttributesMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.AttributesRequest#equals(Object)}
   *   <li>{@link TransportApiProtos.AttributesRequest#hashCode()}
   * </ul>
   */
  @Test
  void testAttributesRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.AttributesRequest defaultInstance = TransportApiProtos.AttributesRequest.getDefaultInstance();
    TransportApiProtos.AttributesRequest defaultInstance2 = TransportApiProtos.AttributesRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.AttributesRequest#equals(Object)}
   *   <li>{@link TransportApiProtos.AttributesRequest#hashCode()}
   * </ul>
   */
  @Test
  void testAttributesRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.AttributesRequest defaultInstance = TransportApiProtos.AttributesRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#equals(Object)}
   */
  @Test
  void testAttributesRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.AttributesRequest.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#equals(Object)}
   */
  @Test
  void testAttributesRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.AttributesRequest.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#equals(Object)}
   */
  @Test
  void testAttributesRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.AttributesRequest.getDefaultInstance(), "Different type to AttributesRequest");
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#getClientKeys()}
   */
  @Test
  void testAttributesRequestGetClientKeys() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.AttributesRequest.getDefaultInstance().getClientKeys());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#getClientKeysBytes()}
   */
  @Test
  void testAttributesRequestGetClientKeysBytes() {
    // Arrange
    TransportApiProtos.AttributesRequest defaultInstance = TransportApiProtos.AttributesRequest.getDefaultInstance();

    // Act
    ByteString actualClientKeysBytes = defaultInstance.getClientKeysBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualClientKeysBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = fields.get(0).toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType3 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, dependencies.get(0).getOptions().getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(byteString, actualClientKeysBytes);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#getDefaultInstanceForType()}
   */
  @Test
  void testAttributesRequestGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.AttributesRequest defaultInstance = TransportApiProtos.AttributesRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#getSerializedSize()}
   */
  @Test
  void testAttributesRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.AttributesRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#getSharedKeys()}
   */
  @Test
  void testAttributesRequestGetSharedKeys() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.AttributesRequest.getDefaultInstance().getSharedKeys());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#getSharedKeysBytes()}
   */
  @Test
  void testAttributesRequestGetSharedKeysBytes() {
    // Arrange
    TransportApiProtos.AttributesRequest defaultInstance = TransportApiProtos.AttributesRequest.getDefaultInstance();

    // Act
    ByteString actualSharedKeysBytes = defaultInstance.getSharedKeysBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualSharedKeysBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = fields.get(0).toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType3 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, dependencies.get(0).getOptions().getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getClientKeysBytes());
    assertEquals(byteString, actualSharedKeysBytes);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#isInitialized()}
   */
  @Test
  void testAttributesRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.AttributesRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testAttributesRequestNewInstance() {
    // Arrange
    TransportApiProtos.AttributesRequest defaultInstance = TransportApiProtos.AttributesRequest.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.AttributesRequest);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testAttributesRequestParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.AttributesRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testAttributesRequestParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.AttributesRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testAttributesRequestParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.AttributesRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testAttributesRequestParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.AttributesRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testAttributesRequestParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        TransportApiProtos.AttributesRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testAttributesRequestParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.AttributesRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testAttributesRequestParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.AttributesRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testAttributesRequestParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.AttributesRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseFrom(InputStream)}
   */
  @Test
  void testAttributesRequestParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.AttributesRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseFrom(InputStream)}
   */
  @Test
  void testAttributesRequestParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.AttributesRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testAttributesRequestParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.AttributesRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.AttributesRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testAttributesRequestParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.AttributesRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.ClaimDevice#equals(Object)}
   *   <li>{@link TransportApiProtos.ClaimDevice#hashCode()}
   * </ul>
   */
  @Test
  void testClaimDeviceEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.ClaimDevice defaultInstance = TransportApiProtos.ClaimDevice.getDefaultInstance();
    TransportApiProtos.ClaimDevice defaultInstance2 = TransportApiProtos.ClaimDevice.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.ClaimDevice#equals(Object)}
   *   <li>{@link TransportApiProtos.ClaimDevice#hashCode()}
   * </ul>
   */
  @Test
  void testClaimDeviceEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.ClaimDevice defaultInstance = TransportApiProtos.ClaimDevice.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link TransportApiProtos.ClaimDevice#equals(Object)}
   */
  @Test
  void testClaimDeviceEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ClaimDevice.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link TransportApiProtos.ClaimDevice#equals(Object)}
   */
  @Test
  void testClaimDeviceEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ClaimDevice.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link TransportApiProtos.ClaimDevice#equals(Object)}
   */
  @Test
  void testClaimDeviceEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ClaimDevice.getDefaultInstance(), "Different type to ClaimDevice");
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#getDefaultInstanceForType()}
   */
  @Test
  void testClaimDeviceGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.ClaimDevice defaultInstance = TransportApiProtos.ClaimDevice.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link TransportApiProtos.ClaimDevice#getSecretKey()}
   */
  @Test
  void testClaimDeviceGetSecretKey() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.ClaimDevice.getDefaultInstance().getSecretKey());
  }

  /**
   * Method under test: {@link TransportApiProtos.ClaimDevice#getSecretKeyBytes()}
   */
  @Test
  void testClaimDeviceGetSecretKeyBytes() {
    // Arrange
    TransportApiProtos.ClaimDevice defaultInstance = TransportApiProtos.ClaimDevice.getDefaultInstance();

    // Act
    ByteString actualSecretKeyBytes = defaultInstance.getSecretKeyBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualSecretKeyBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = fields.get(0).toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType3 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, dependencies.get(0).getOptions().getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(byteString, actualSecretKeyBytes);
  }

  /**
   * Method under test: {@link TransportApiProtos.ClaimDevice#getSerializedSize()}
   */
  @Test
  void testClaimDeviceGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.ClaimDevice.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link TransportApiProtos.ClaimDevice#isInitialized()}
   */
  @Test
  void testClaimDeviceIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.ClaimDevice.getDefaultInstance().isInitialized());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.ClaimDeviceMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.ClaimDeviceMsg#hashCode()}
   * </ul>
   */
  @Test
  void testClaimDeviceMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.ClaimDeviceMsg defaultInstance = TransportApiProtos.ClaimDeviceMsg.getDefaultInstance();
    TransportApiProtos.ClaimDeviceMsg defaultInstance2 = TransportApiProtos.ClaimDeviceMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.ClaimDeviceMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.ClaimDeviceMsg#hashCode()}
   * </ul>
   */
  @Test
  void testClaimDeviceMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.ClaimDeviceMsg defaultInstance = TransportApiProtos.ClaimDeviceMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link TransportApiProtos.ClaimDeviceMsg#equals(Object)}
   */
  @Test
  void testClaimDeviceMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ClaimDeviceMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link TransportApiProtos.ClaimDeviceMsg#equals(Object)}
   */
  @Test
  void testClaimDeviceMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ClaimDeviceMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link TransportApiProtos.ClaimDeviceMsg#equals(Object)}
   */
  @Test
  void testClaimDeviceMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ClaimDeviceMsg.getDefaultInstance(), "Different type to ClaimDeviceMsg");
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#getDefaultInstanceForType()}
   */
  @Test
  void testClaimDeviceMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.ClaimDeviceMsg defaultInstance = TransportApiProtos.ClaimDeviceMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link TransportApiProtos.ClaimDeviceMsg#getDeviceName()}
   */
  @Test
  void testClaimDeviceMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.ClaimDeviceMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#getDeviceNameBytes()}
   */
  @Test
  void testClaimDeviceMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.ClaimDeviceMsg defaultInstance = TransportApiProtos.ClaimDeviceMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getClaimRequest().getSecretKeyBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#getSerializedSize()}
   */
  @Test
  void testClaimDeviceMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.ClaimDeviceMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#hasClaimRequest()}
   */
  @Test
  void testClaimDeviceMsgHasClaimRequest() {
    // Arrange, Act and Assert
    assertFalse(TransportApiProtos.ClaimDeviceMsg.getDefaultInstance().hasClaimRequest());
  }

  /**
   * Method under test: {@link TransportApiProtos.ClaimDeviceMsg#isInitialized()}
   */
  @Test
  void testClaimDeviceMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.ClaimDeviceMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testClaimDeviceMsgNewInstance() {
    // Arrange
    TransportApiProtos.ClaimDeviceMsg defaultInstance = TransportApiProtos.ClaimDeviceMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.ClaimDeviceMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testClaimDeviceMsgParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testClaimDeviceMsgParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testClaimDeviceMsgParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testClaimDeviceMsgParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testClaimDeviceMsgParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testClaimDeviceMsgParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testClaimDeviceMsgParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testClaimDeviceMsgParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.ClaimDeviceMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseFrom(InputStream)}
   */
  @Test
  void testClaimDeviceMsgParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.ClaimDeviceMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseFrom(InputStream)}
   */
  @Test
  void testClaimDeviceMsgParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.ClaimDeviceMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testClaimDeviceMsgParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.ClaimDeviceMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDeviceMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testClaimDeviceMsgParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.ClaimDeviceMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testClaimDeviceNewInstance() {
    // Arrange
    TransportApiProtos.ClaimDevice defaultInstance = TransportApiProtos.ClaimDevice.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.ClaimDevice);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testClaimDeviceParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.ClaimDevice.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testClaimDeviceParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.ClaimDevice.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testClaimDeviceParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.ClaimDevice.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testClaimDeviceParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.ClaimDevice.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testClaimDeviceParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.ClaimDevice.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testClaimDeviceParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.ClaimDevice.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testClaimDeviceParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.ClaimDevice.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testClaimDeviceParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.ClaimDevice.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseFrom(InputStream)}
   */
  @Test
  void testClaimDeviceParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.ClaimDevice.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseFrom(InputStream)}
   */
  @Test
  void testClaimDeviceParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.ClaimDevice.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testClaimDeviceParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.ClaimDevice.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ClaimDevice#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testClaimDeviceParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.ClaimDevice.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.ConnectMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.ConnectMsg#hashCode()}
   * </ul>
   */
  @Test
  void testConnectMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.ConnectMsg defaultInstance = TransportApiProtos.ConnectMsg.getDefaultInstance();
    TransportApiProtos.ConnectMsg defaultInstance2 = TransportApiProtos.ConnectMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.ConnectMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.ConnectMsg#hashCode()}
   * </ul>
   */
  @Test
  void testConnectMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.ConnectMsg defaultInstance = TransportApiProtos.ConnectMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link TransportApiProtos.ConnectMsg#equals(Object)}
   */
  @Test
  void testConnectMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ConnectMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link TransportApiProtos.ConnectMsg#equals(Object)}
   */
  @Test
  void testConnectMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ConnectMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link TransportApiProtos.ConnectMsg#equals(Object)}
   */
  @Test
  void testConnectMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.ConnectMsg.getDefaultInstance(), "Different type to ConnectMsg");
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#getDefaultInstanceForType()}
   */
  @Test
  void testConnectMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.ConnectMsg defaultInstance = TransportApiProtos.ConnectMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link TransportApiProtos.ConnectMsg#getDeviceName()}
   */
  @Test
  void testConnectMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.ConnectMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Method under test: {@link TransportApiProtos.ConnectMsg#getDeviceNameBytes()}
   */
  @Test
  void testConnectMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.ConnectMsg defaultInstance = TransportApiProtos.ConnectMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = fields.get(0).toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, fields.get(1).toProto().getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType3 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Method under test: {@link TransportApiProtos.ConnectMsg#getDeviceType()}
   */
  @Test
  void testConnectMsgGetDeviceType() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.ConnectMsg.getDefaultInstance().getDeviceType());
  }

  /**
   * Method under test: {@link TransportApiProtos.ConnectMsg#getDeviceTypeBytes()}
   */
  @Test
  void testConnectMsgGetDeviceTypeBytes() {
    // Arrange
    TransportApiProtos.ConnectMsg defaultInstance = TransportApiProtos.ConnectMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceTypeBytes = defaultInstance.getDeviceTypeBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceTypeBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = fields.get(0).toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, fields.get(1).toProto().getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType3 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceTypeBytes);
  }

  /**
   * Method under test: {@link TransportApiProtos.ConnectMsg#getSerializedSize()}
   */
  @Test
  void testConnectMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.ConnectMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link TransportApiProtos.ConnectMsg#isInitialized()}
   */
  @Test
  void testConnectMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.ConnectMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testConnectMsgNewInstance() {
    // Arrange
    TransportApiProtos.ConnectMsg defaultInstance = TransportApiProtos.ConnectMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.ConnectMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testConnectMsgParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.ConnectMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testConnectMsgParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.ConnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testConnectMsgParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.ConnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testConnectMsgParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.ConnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testConnectMsgParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.ConnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testConnectMsgParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.ConnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testConnectMsgParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.ConnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testConnectMsgParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.ConnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseFrom(InputStream)}
   */
  @Test
  void testConnectMsgParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.ConnectMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseFrom(InputStream)}
   */
  @Test
  void testConnectMsgParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.ConnectMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testConnectMsgParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.ConnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.ConnectMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testConnectMsgParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.ConnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.DisconnectMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.DisconnectMsg#hashCode()}
   * </ul>
   */
  @Test
  void testDisconnectMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.DisconnectMsg defaultInstance = TransportApiProtos.DisconnectMsg.getDefaultInstance();
    TransportApiProtos.DisconnectMsg defaultInstance2 = TransportApiProtos.DisconnectMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.DisconnectMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.DisconnectMsg#hashCode()}
   * </ul>
   */
  @Test
  void testDisconnectMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.DisconnectMsg defaultInstance = TransportApiProtos.DisconnectMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link TransportApiProtos.DisconnectMsg#equals(Object)}
   */
  @Test
  void testDisconnectMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.DisconnectMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link TransportApiProtos.DisconnectMsg#equals(Object)}
   */
  @Test
  void testDisconnectMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.DisconnectMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link TransportApiProtos.DisconnectMsg#equals(Object)}
   */
  @Test
  void testDisconnectMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.DisconnectMsg.getDefaultInstance(), "Different type to DisconnectMsg");
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#getDefaultInstanceForType()}
   */
  @Test
  void testDisconnectMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.DisconnectMsg defaultInstance = TransportApiProtos.DisconnectMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link TransportApiProtos.DisconnectMsg#getDeviceName()}
   */
  @Test
  void testDisconnectMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.DisconnectMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#getDeviceNameBytes()}
   */
  @Test
  void testDisconnectMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.DisconnectMsg defaultInstance = TransportApiProtos.DisconnectMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = fields.get(0).toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType3 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    DescriptorProtos.FileOptions options = dependencies.get(0).getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#getSerializedSize()}
   */
  @Test
  void testDisconnectMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.DisconnectMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link TransportApiProtos.DisconnectMsg#isInitialized()}
   */
  @Test
  void testDisconnectMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.DisconnectMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testDisconnectMsgNewInstance() {
    // Arrange
    TransportApiProtos.DisconnectMsg defaultInstance = TransportApiProtos.DisconnectMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.DisconnectMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testDisconnectMsgParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testDisconnectMsgParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testDisconnectMsgParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testDisconnectMsgParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testDisconnectMsgParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testDisconnectMsgParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testDisconnectMsgParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testDisconnectMsgParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.DisconnectMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseFrom(InputStream)}
   */
  @Test
  void testDisconnectMsgParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.DisconnectMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseFrom(InputStream)}
   */
  @Test
  void testDisconnectMsgParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.DisconnectMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testDisconnectMsgParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.DisconnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.DisconnectMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testDisconnectMsgParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.DisconnectMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayAttributeResponseMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayAttributeResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayAttributeResponseMsgEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayAttributeResponseMsg defaultInstance = TransportApiProtos.GatewayAttributeResponseMsg
        .getDefaultInstance();
    TransportApiProtos.GatewayAttributeResponseMsg defaultInstance2 = TransportApiProtos.GatewayAttributeResponseMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayAttributeResponseMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayAttributeResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayAttributeResponseMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayAttributeResponseMsg defaultInstance = TransportApiProtos.GatewayAttributeResponseMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#equals(Object)}
   */
  @Test
  void testGatewayAttributeResponseMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#equals(Object)}
   */
  @Test
  void testGatewayAttributeResponseMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#equals(Object)}
   */
  @Test
  void testGatewayAttributeResponseMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance(),
        "Different type to GatewayAttributeResponseMsg");
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGatewayAttributeResponseMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayAttributeResponseMsg defaultInstance = TransportApiProtos.GatewayAttributeResponseMsg
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#getDeviceName()}
   */
  @Test
  void testGatewayAttributeResponseMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#getDeviceNameBytes()}
   */
  @Test
  void testGatewayAttributeResponseMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.GatewayAttributeResponseMsg defaultInstance = TransportApiProtos.GatewayAttributeResponseMsg
        .getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#getSerializedSize()}
   */
  @Test
  void testGatewayAttributeResponseMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#hasResponseMsg()}
   */
  @Test
  void testGatewayAttributeResponseMsgHasResponseMsg() {
    // Arrange, Act and Assert
    assertFalse(TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance().hasResponseMsg());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#isInitialized()}
   */
  @Test
  void testGatewayAttributeResponseMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayAttributeResponseMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testGatewayAttributeResponseMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayAttributeResponseMsg defaultInstance = TransportApiProtos.GatewayAttributeResponseMsg
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayAttributeResponseMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributeResponseMsgParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayAttributeResponseMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributeResponseMsgParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributeResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributeResponseMsgParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributeResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributeResponseMsgParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.GatewayAttributeResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributeResponseMsgParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayAttributeResponseMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributeResponseMsgParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributeResponseMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributeResponseMsgParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributeResponseMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributeResponseMsgParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.GatewayAttributeResponseMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayAttributeResponseMsgParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributeResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayAttributeResponseMsgParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributeResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributeResponseMsgParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributeResponseMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributeResponseMsgParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributeResponseMsg
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#equals(Object)}
   *   <li>
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg defaultInstance = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#equals(Object)}
   *   <li>
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg defaultInstance = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .getDefaultInstance();
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg defaultInstance2 = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#equals(Object)}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance(), null);
    assertNotEquals(TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance(),
        "Different type to GatewayAttributeUpdateNotificationMsg");
    assertNotEquals(TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg defaultInstance = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#getDeviceName()}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#getDeviceNameBytes()}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg defaultInstance = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#getSerializedSize()}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#hasNotificationMsg()}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgHasNotificationMsg() {
    // Arrange, Act and Assert
    assertFalse(TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance().hasNotificationMsg());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#isInitialized()}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayAttributeUpdateNotificationMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayAttributeUpdateNotificationMsg defaultInstance = TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayAttributeUpdateNotificationMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributeUpdateNotificationMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributeUpdateNotificationMsgParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributeUpdateNotificationMsg
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayAttributesMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayAttributesMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayAttributesMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayAttributesMsg defaultInstance = TransportApiProtos.GatewayAttributesMsg
        .getDefaultInstance();
    TransportApiProtos.GatewayAttributesMsg defaultInstance2 = TransportApiProtos.GatewayAttributesMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayAttributesMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayAttributesMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayAttributesMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayAttributesMsg defaultInstance = TransportApiProtos.GatewayAttributesMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#equals(Object)}
   */
  @Test
  void testGatewayAttributesMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributesMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#equals(Object)}
   */
  @Test
  void testGatewayAttributesMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributesMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#equals(Object)}
   */
  @Test
  void testGatewayAttributesMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributesMsg.getDefaultInstance(),
        "Different type to GatewayAttributesMsg");
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGatewayAttributesMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayAttributesMsg defaultInstance = TransportApiProtos.GatewayAttributesMsg
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#getMsgCount()}
   */
  @Test
  void testGatewayAttributesMsgGetMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayAttributesMsg.getDefaultInstance().getMsgCount());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#getSerializedSize()}
   */
  @Test
  void testGatewayAttributesMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayAttributesMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#isInitialized()}
   */
  @Test
  void testGatewayAttributesMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayAttributesMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testGatewayAttributesMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayAttributesMsg defaultInstance = TransportApiProtos.GatewayAttributesMsg
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayAttributesMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributesMsgParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayAttributesMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributesMsgParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributesMsgParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributesMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributesMsgParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        TransportApiProtos.GatewayAttributesMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributesMsgParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributesMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributesMsgParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributesMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayAttributesMsgParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributesMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayAttributesMsgParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributesMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributesMsgParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.GatewayAttributesMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributesMsgParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributesMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayAttributesRequestMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayAttributesRequestMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayAttributesRequestMsgEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayAttributesRequestMsg defaultInstance = TransportApiProtos.GatewayAttributesRequestMsg
        .getDefaultInstance();
    TransportApiProtos.GatewayAttributesRequestMsg defaultInstance2 = TransportApiProtos.GatewayAttributesRequestMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayAttributesRequestMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayAttributesRequestMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayAttributesRequestMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayAttributesRequestMsg defaultInstance = TransportApiProtos.GatewayAttributesRequestMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#equals(Object)}
   */
  @Test
  void testGatewayAttributesRequestMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#equals(Object)}
   */
  @Test
  void testGatewayAttributesRequestMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#equals(Object)}
   */
  @Test
  void testGatewayAttributesRequestMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance(),
        "Different type to GatewayAttributesRequestMsg");
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGatewayAttributesRequestMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayAttributesRequestMsg defaultInstance = TransportApiProtos.GatewayAttributesRequestMsg
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#getDeviceName()}
   */
  @Test
  void testGatewayAttributesRequestMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#getDeviceNameBytes()}
   */
  @Test
  void testGatewayAttributesRequestMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.GatewayAttributesRequestMsg defaultInstance = TransportApiProtos.GatewayAttributesRequestMsg
        .getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(2).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(3).toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#getKeysCount()}
   */
  @Test
  void testGatewayAttributesRequestMsgGetKeysCount() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance().getKeysCount());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#getKeysList()}
   */
  @Test
  void testGatewayAttributesRequestMsgGetKeysList() {
    // Arrange
    TransportApiProtos.GatewayAttributesRequestMsg defaultInstance = TransportApiProtos.GatewayAttributesRequestMsg
        .getDefaultInstance();

    // Act
    ProtocolStringList actualKeysList = defaultInstance.getKeysList();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    assertTrue(defaultInstance.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.getPublicDependencyList().isEmpty());
    assertTrue(options.getUninterpretedOptionList().isEmpty());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualKeysList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualKeysList).EMPTY;
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals(lazyStringList, defaultInstanceForType2.findInitializationErrors());
    assertEquals(lazyStringList, toProtoResult2.getSourceCodeInfo().findInitializationErrors());
    assertEquals(lazyStringList, options2.getDefaultInstanceForType().findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals(lazyStringList, toProtoResult3.findInitializationErrors());
    assertEquals(lazyStringList, descriptorForType3.toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(lazyStringList, options3.findInitializationErrors());
    assertEquals(lazyStringList, getResult.toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(1).toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(2).toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(3).toProto().findInitializationErrors());
    assertEquals(lazyStringList, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType4.getEnumTypes());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(TransportProtos.ApiUsageStateProto.ALARMEXECSTATE_FIELD_NUMBER, messageTypes.size());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertEquals(lazyStringList, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals(lazyStringList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes
        .get(TransportProtos.ApiUsageStateProto.EMAILEXECSTATE_FIELD_NUMBER);
    assertEquals(lazyStringList, getResult4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = features.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType5.getExtensions());
    Descriptors.Descriptor descriptorForType6 = options2.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType6.getExtensions());
    assertEquals(lazyStringList, descriptorForType4.getExtensions());
    assertEquals(lazyStringList, getResult2.getExtensions());
    assertEquals(lazyStringList, getResult3.getExtensions());
    assertEquals(lazyStringList, getResult4.getExtensions());
    assertEquals(lazyStringList, descriptorForType5.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType6.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType4.getNestedTypes());
    assertEquals(lazyStringList, getResult2.getNestedTypes());
    assertEquals(lazyStringList, getResult3.getNestedTypes());
    assertEquals(lazyStringList, getResult4.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType5.getOneofs());
    assertEquals(lazyStringList, descriptorForType6.getOneofs());
    assertEquals(lazyStringList, descriptorForType4.getOneofs());
    assertEquals(lazyStringList, getResult2.getOneofs());
    assertEquals(lazyStringList, getResult3.getOneofs());
    assertEquals(lazyStringList, getResult4.getOneofs());
    assertEquals(lazyStringList, descriptorForType5.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType6.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType4.getRealOneofs());
    assertEquals(lazyStringList, getResult2.getRealOneofs());
    assertEquals(lazyStringList, getResult3.getRealOneofs());
    assertEquals(lazyStringList, getResult4.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(lazyStringList, file2.getDependencies());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    assertEquals(lazyStringList, getResult5.getDependencies());
    assertEquals(lazyStringList, file2.getExtensions());
    assertEquals(lazyStringList, getResult5.getExtensions());
    assertEquals(lazyStringList, file2.getPublicDependencies());
    assertEquals(lazyStringList, getResult5.getPublicDependencies());
    assertEquals(lazyStringList, file2.getServices());
    assertEquals(lazyStringList, getResult5.getServices());
    assertSame(lazyStringList, defaultInstanceForType.getReservedNameList());
    assertSame(lazyStringList, toProtoResult3.getReservedNameList());
    assertSame(lazyStringList, toProtoResult.getReservedNameList());
    assertSame(lazyStringList, defaultInstanceForType2.getDependencyList());
    assertSame(lazyStringList, actualKeysList);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#getSerializedSize()}
   */
  @Test
  void testGatewayAttributesRequestMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#isInitialized()}
   */
  @Test
  void testGatewayAttributesRequestMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayAttributesRequestMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testGatewayAttributesRequestMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayAttributesRequestMsg defaultInstance = TransportApiProtos.GatewayAttributesRequestMsg
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayAttributesRequestMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributesRequestMsgParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayAttributesRequestMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributesRequestMsgParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributesRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributesRequestMsgParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributesRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayAttributesRequestMsgParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.GatewayAttributesRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributesRequestMsgParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayAttributesRequestMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributesRequestMsgParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributesRequestMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributesRequestMsgParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributesRequestMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributesRequestMsgParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.GatewayAttributesRequestMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayAttributesRequestMsgParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributesRequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayAttributesRequestMsgParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayAttributesRequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributesRequestMsgParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayAttributesRequestMsg.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayAttributesRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayAttributesRequestMsgParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayAttributesRequestMsg
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayClaimMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayClaimMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayClaimMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayClaimMsg defaultInstance = TransportApiProtos.GatewayClaimMsg.getDefaultInstance();
    TransportApiProtos.GatewayClaimMsg defaultInstance2 = TransportApiProtos.GatewayClaimMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayClaimMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayClaimMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayClaimMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayClaimMsg defaultInstance = TransportApiProtos.GatewayClaimMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link TransportApiProtos.GatewayClaimMsg#equals(Object)}
   */
  @Test
  void testGatewayClaimMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayClaimMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link TransportApiProtos.GatewayClaimMsg#equals(Object)}
   */
  @Test
  void testGatewayClaimMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayClaimMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link TransportApiProtos.GatewayClaimMsg#equals(Object)}
   */
  @Test
  void testGatewayClaimMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayClaimMsg.getDefaultInstance(), "Different type to GatewayClaimMsg");
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGatewayClaimMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayClaimMsg defaultInstance = TransportApiProtos.GatewayClaimMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link TransportApiProtos.GatewayClaimMsg#getMsgCount()}
   */
  @Test
  void testGatewayClaimMsgGetMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayClaimMsg.getDefaultInstance().getMsgCount());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#getSerializedSize()}
   */
  @Test
  void testGatewayClaimMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayClaimMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link TransportApiProtos.GatewayClaimMsg#isInitialized()}
   */
  @Test
  void testGatewayClaimMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayClaimMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testGatewayClaimMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayClaimMsg defaultInstance = TransportApiProtos.GatewayClaimMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayClaimMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayClaimMsgParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayClaimMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayClaimMsgParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayClaimMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayClaimMsgParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayClaimMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayClaimMsgParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayClaimMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayClaimMsgParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.GatewayClaimMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayClaimMsgParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayClaimMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayClaimMsgParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayClaimMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayClaimMsgParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayClaimMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayClaimMsgParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.GatewayClaimMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayClaimMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayClaimMsgParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayClaimMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayDeviceRpcRequestMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayDeviceRpcRequestMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayDeviceRpcRequestMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayDeviceRpcRequestMsg defaultInstance = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .getDefaultInstance();
    TransportApiProtos.GatewayDeviceRpcRequestMsg defaultInstance2 = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayDeviceRpcRequestMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayDeviceRpcRequestMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayDeviceRpcRequestMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayDeviceRpcRequestMsg defaultInstance = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#equals(Object)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#equals(Object)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#equals(Object)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance(),
        "Different type to GatewayDeviceRpcRequestMsg");
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayDeviceRpcRequestMsg defaultInstance = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#getDeviceName()}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#getDeviceNameBytes()}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.GatewayDeviceRpcRequestMsg defaultInstance = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#getSerializedSize()}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#hasRpcRequestMsg()}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgHasRpcRequestMsg() {
    // Arrange, Act and Assert
    assertFalse(TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance().hasRpcRequestMsg());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#isInitialized()}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayDeviceRpcRequestMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayDeviceRpcRequestMsg defaultInstance = TransportApiProtos.GatewayDeviceRpcRequestMsg
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayDeviceRpcRequestMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayDeviceRpcRequestMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.GatewayDeviceRpcRequestMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayDeviceRpcRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayDeviceRpcRequestMsgParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayDeviceRpcRequestMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayRpcResponseMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayRpcResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayRpcResponseMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayRpcResponseMsg defaultInstance = TransportApiProtos.GatewayRpcResponseMsg
        .getDefaultInstance();
    TransportApiProtos.GatewayRpcResponseMsg defaultInstance2 = TransportApiProtos.GatewayRpcResponseMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayRpcResponseMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayRpcResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayRpcResponseMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayRpcResponseMsg defaultInstance = TransportApiProtos.GatewayRpcResponseMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#equals(Object)}
   */
  @Test
  void testGatewayRpcResponseMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#equals(Object)}
   */
  @Test
  void testGatewayRpcResponseMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#equals(Object)}
   */
  @Test
  void testGatewayRpcResponseMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance(),
        "Different type to GatewayRpcResponseMsg");
  }

  /**
   * Method under test: {@link TransportApiProtos.GatewayRpcResponseMsg#getData()}
   */
  @Test
  void testGatewayRpcResponseMsgGetData() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance().getData());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#getDataBytes()}
   */
  @Test
  void testGatewayRpcResponseMsgGetDataBytes() {
    // Arrange
    TransportApiProtos.GatewayRpcResponseMsg defaultInstance = TransportApiProtos.GatewayRpcResponseMsg
        .getDefaultInstance();

    // Act
    ByteString actualDataBytes = defaultInstance.getDataBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    ByteString byteString = actualDataBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(2).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType3 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(byteString, actualDataBytes);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGatewayRpcResponseMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayRpcResponseMsg defaultInstance = TransportApiProtos.GatewayRpcResponseMsg
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#getDeviceName()}
   */
  @Test
  void testGatewayRpcResponseMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#getDeviceNameBytes()}
   */
  @Test
  void testGatewayRpcResponseMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.GatewayRpcResponseMsg defaultInstance = TransportApiProtos.GatewayRpcResponseMsg
        .getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(2).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType3 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDataBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#getSerializedSize()}
   */
  @Test
  void testGatewayRpcResponseMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#isInitialized()}
   */
  @Test
  void testGatewayRpcResponseMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayRpcResponseMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testGatewayRpcResponseMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayRpcResponseMsg defaultInstance = TransportApiProtos.GatewayRpcResponseMsg
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayRpcResponseMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayRpcResponseMsgParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayRpcResponseMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayRpcResponseMsgParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayRpcResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayRpcResponseMsgParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayRpcResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayRpcResponseMsgParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.GatewayRpcResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayRpcResponseMsgParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        TransportApiProtos.GatewayRpcResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayRpcResponseMsgParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayRpcResponseMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayRpcResponseMsgParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayRpcResponseMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayRpcResponseMsgParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.GatewayRpcResponseMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayRpcResponseMsgParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayRpcResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayRpcResponseMsgParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayRpcResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayRpcResponseMsgParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.GatewayRpcResponseMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayRpcResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayRpcResponseMsgParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayRpcResponseMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayTelemetryMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayTelemetryMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayTelemetryMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayTelemetryMsg defaultInstance = TransportApiProtos.GatewayTelemetryMsg
        .getDefaultInstance();
    TransportApiProtos.GatewayTelemetryMsg defaultInstance2 = TransportApiProtos.GatewayTelemetryMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.GatewayTelemetryMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.GatewayTelemetryMsg#hashCode()}
   * </ul>
   */
  @Test
  void testGatewayTelemetryMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.GatewayTelemetryMsg defaultInstance = TransportApiProtos.GatewayTelemetryMsg
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#equals(Object)}
   */
  @Test
  void testGatewayTelemetryMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayTelemetryMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#equals(Object)}
   */
  @Test
  void testGatewayTelemetryMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayTelemetryMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#equals(Object)}
   */
  @Test
  void testGatewayTelemetryMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.GatewayTelemetryMsg.getDefaultInstance(),
        "Different type to GatewayTelemetryMsg");
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGatewayTelemetryMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.GatewayTelemetryMsg defaultInstance = TransportApiProtos.GatewayTelemetryMsg
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#getMsgCount()}
   */
  @Test
  void testGatewayTelemetryMsgGetMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayTelemetryMsg.getDefaultInstance().getMsgCount());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#getSerializedSize()}
   */
  @Test
  void testGatewayTelemetryMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.GatewayTelemetryMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#isInitialized()}
   */
  @Test
  void testGatewayTelemetryMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.GatewayTelemetryMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testGatewayTelemetryMsgNewInstance() {
    // Arrange
    TransportApiProtos.GatewayTelemetryMsg defaultInstance = TransportApiProtos.GatewayTelemetryMsg
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.GatewayTelemetryMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayTelemetryMsgParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.GatewayTelemetryMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayTelemetryMsgParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayTelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testGatewayTelemetryMsgParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayTelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayTelemetryMsgParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        TransportApiProtos.GatewayTelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayTelemetryMsgParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayTelemetryMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayTelemetryMsgParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayTelemetryMsg
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayTelemetryMsgParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.GatewayTelemetryMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  void testGatewayTelemetryMsgParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.GatewayTelemetryMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayTelemetryMsgParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.GatewayTelemetryMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.GatewayTelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testGatewayTelemetryMsgParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.GatewayTelemetryMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.RpcRequest#equals(Object)}
   *   <li>{@link TransportApiProtos.RpcRequest#hashCode()}
   * </ul>
   */
  @Test
  void testRpcRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.RpcRequest defaultInstance = TransportApiProtos.RpcRequest.getDefaultInstance();
    TransportApiProtos.RpcRequest defaultInstance2 = TransportApiProtos.RpcRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.RpcRequest#equals(Object)}
   *   <li>{@link TransportApiProtos.RpcRequest#hashCode()}
   * </ul>
   */
  @Test
  void testRpcRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.RpcRequest defaultInstance = TransportApiProtos.RpcRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link TransportApiProtos.RpcRequest#equals(Object)}
   */
  @Test
  void testRpcRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.RpcRequest.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link TransportApiProtos.RpcRequest#equals(Object)}
   */
  @Test
  void testRpcRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.RpcRequest.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link TransportApiProtos.RpcRequest#equals(Object)}
   */
  @Test
  void testRpcRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.RpcRequest.getDefaultInstance(), "Different type to RpcRequest");
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#getDefaultInstanceForType()}
   */
  @Test
  void testRpcRequestGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.RpcRequest defaultInstance = TransportApiProtos.RpcRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link TransportApiProtos.RpcRequest#getMethod()}
   */
  @Test
  void testRpcRequestGetMethod() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.RpcRequest.getDefaultInstance().getMethod());
  }

  /**
   * Method under test: {@link TransportApiProtos.RpcRequest#getMethodBytes()}
   */
  @Test
  void testRpcRequestGetMethodBytes() {
    // Arrange
    TransportApiProtos.RpcRequest defaultInstance = TransportApiProtos.RpcRequest.getDefaultInstance();

    // Act
    ByteString actualMethodBytes = defaultInstance.getMethodBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualMethodBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = fields.get(0).toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, fields.get(1).toProto().getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType3 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(byteString, actualMethodBytes);
  }

  /**
   * Method under test: {@link TransportApiProtos.RpcRequest#getParams()}
   */
  @Test
  void testRpcRequestGetParams() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.RpcRequest.getDefaultInstance().getParams());
  }

  /**
   * Method under test: {@link TransportApiProtos.RpcRequest#getParamsBytes()}
   */
  @Test
  void testRpcRequestGetParamsBytes() {
    // Arrange
    TransportApiProtos.RpcRequest defaultInstance = TransportApiProtos.RpcRequest.getDefaultInstance();

    // Act
    ByteString actualParamsBytes = defaultInstance.getParamsBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualParamsBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = fields.get(0).toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, fields.get(1).toProto().getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType3 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(byteString, actualParamsBytes);
  }

  /**
   * Method under test: {@link TransportApiProtos.RpcRequest#getSerializedSize()}
   */
  @Test
  void testRpcRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.RpcRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link TransportApiProtos.RpcRequest#isInitialized()}
   */
  @Test
  void testRpcRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.RpcRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testRpcRequestNewInstance() {
    // Arrange
    TransportApiProtos.RpcRequest defaultInstance = TransportApiProtos.RpcRequest.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.RpcRequest);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testRpcRequestParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.RpcRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testRpcRequestParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.RpcRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testRpcRequestParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.RpcRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testRpcRequestParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.RpcRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRpcRequestParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.RpcRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRpcRequestParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.RpcRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRpcRequestParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.RpcRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRpcRequestParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.RpcRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseFrom(InputStream)}
   */
  @Test
  void testRpcRequestParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.RpcRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseFrom(InputStream)}
   */
  @Test
  void testRpcRequestParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.RpcRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRpcRequestParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.RpcRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.RpcRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRpcRequestParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.RpcRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.TelemetryMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.TelemetryMsg#hashCode()}
   * </ul>
   */
  @Test
  void testTelemetryMsgEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TransportApiProtos.TelemetryMsg defaultInstance = TransportApiProtos.TelemetryMsg.getDefaultInstance();
    TransportApiProtos.TelemetryMsg defaultInstance2 = TransportApiProtos.TelemetryMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TransportApiProtos.TelemetryMsg#equals(Object)}
   *   <li>{@link TransportApiProtos.TelemetryMsg#hashCode()}
   * </ul>
   */
  @Test
  void testTelemetryMsgEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TransportApiProtos.TelemetryMsg defaultInstance = TransportApiProtos.TelemetryMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link TransportApiProtos.TelemetryMsg#equals(Object)}
   */
  @Test
  void testTelemetryMsgEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.TelemetryMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link TransportApiProtos.TelemetryMsg#equals(Object)}
   */
  @Test
  void testTelemetryMsgEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.TelemetryMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link TransportApiProtos.TelemetryMsg#equals(Object)}
   */
  @Test
  void testTelemetryMsgEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TransportApiProtos.TelemetryMsg.getDefaultInstance(), "Different type to TelemetryMsg");
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#getDefaultInstanceForType()}
   */
  @Test
  void testTelemetryMsgGetDefaultInstanceForType() {
    // Arrange
    TransportApiProtos.TelemetryMsg defaultInstance = TransportApiProtos.TelemetryMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link TransportApiProtos.TelemetryMsg#getDeviceName()}
   */
  @Test
  void testTelemetryMsgGetDeviceName() {
    // Arrange, Act and Assert
    assertEquals("", TransportApiProtos.TelemetryMsg.getDefaultInstance().getDeviceName());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#getDeviceNameBytes()}
   */
  @Test
  void testTelemetryMsgGetDeviceNameBytes() {
    // Arrange
    TransportApiProtos.TelemetryMsg defaultInstance = TransportApiProtos.TelemetryMsg.getDefaultInstance();

    // Act
    ByteString actualDeviceNameBytes = defaultInstance.getDeviceNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualDeviceNameBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType2 = file.getOptions().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, actualDeviceNameBytes);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#getSerializedSize()}
   */
  @Test
  void testTelemetryMsgGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TransportApiProtos.TelemetryMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link TransportApiProtos.TelemetryMsg#hasMsg()}
   */
  @Test
  void testTelemetryMsgHasMsg() {
    // Arrange, Act and Assert
    assertFalse(TransportApiProtos.TelemetryMsg.getDefaultInstance().hasMsg());
  }

  /**
   * Method under test: {@link TransportApiProtos.TelemetryMsg#isInitialized()}
   */
  @Test
  void testTelemetryMsgIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TransportApiProtos.TelemetryMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testTelemetryMsgNewInstance() {
    // Arrange
    TransportApiProtos.TelemetryMsg defaultInstance = TransportApiProtos.TelemetryMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TransportApiProtos.TelemetryMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTelemetryMsgParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTelemetryMsgParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTelemetryMsgParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTelemetryMsgParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTelemetryMsgParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTelemetryMsgParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTelemetryMsgParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTelemetryMsgParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TransportApiProtos.TelemetryMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  void testTelemetryMsgParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TransportApiProtos.TelemetryMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseFrom(InputStream)}
   */
  @Test
  void testTelemetryMsgParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TransportApiProtos.TelemetryMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTelemetryMsgParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TransportApiProtos.TelemetryMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TransportApiProtos.TelemetryMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTelemetryMsgParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TransportApiProtos.TelemetryMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
