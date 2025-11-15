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
package org.thingsboard.server.gen.js;

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
import com.google.protobuf.Internal;
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

class JsInvokeProtosDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsCompileRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsCompileRequest#hashCode()}
   * </ul>
   */
  @Test
  void testJsCompileRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsCompileRequest defaultInstance = JsInvokeProtos.JsCompileRequest.getDefaultInstance();
    JsInvokeProtos.JsCompileRequest defaultInstance2 = JsInvokeProtos.JsCompileRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsCompileRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsCompileRequest#hashCode()}
   * </ul>
   */
  @Test
  void testJsCompileRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsCompileRequest defaultInstance = JsInvokeProtos.JsCompileRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsCompileRequest#equals(Object)}
   */
  @Test
  void testJsCompileRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsCompileRequest.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsCompileRequest#equals(Object)}
   */
  @Test
  void testJsCompileRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsCompileRequest.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsCompileRequest#equals(Object)}
   */
  @Test
  void testJsCompileRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsCompileRequest.getDefaultInstance(), "Different type to JsCompileRequest");
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#getDefaultInstanceForType()}
   */
  @Test
  void testJsCompileRequestGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.JsCompileRequest defaultInstance = JsInvokeProtos.JsCompileRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsCompileRequest#getFunctionName()}
   */
  @Test
  void testJsCompileRequestGetFunctionName() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsCompileRequest.getDefaultInstance().getFunctionName());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#getFunctionNameBytes()}
   */
  @Test
  void testJsCompileRequestGetFunctionNameBytes() {
    // Arrange
    JsInvokeProtos.JsCompileRequest defaultInstance = JsInvokeProtos.JsCompileRequest.getDefaultInstance();

    // Act
    ByteString actualFunctionNameBytes = defaultInstance.getFunctionNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    ByteString byteString = actualFunctionNameBytes.EMPTY;
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
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
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
    assertEquals(byteString, actualFunctionNameBytes);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsCompileRequest#getScriptBody()}
   */
  @Test
  void testJsCompileRequestGetScriptBody() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsCompileRequest.getDefaultInstance().getScriptBody());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#getScriptBodyBytes()}
   */
  @Test
  void testJsCompileRequestGetScriptBodyBytes() {
    // Arrange
    JsInvokeProtos.JsCompileRequest defaultInstance = JsInvokeProtos.JsCompileRequest.getDefaultInstance();

    // Act
    ByteString actualScriptBodyBytes = defaultInstance.getScriptBodyBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    ByteString byteString = actualScriptBodyBytes.EMPTY;
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
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
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
    assertEquals(byteString, actualScriptBodyBytes);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsCompileRequest#getScriptHash()}
   */
  @Test
  void testJsCompileRequestGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsCompileRequest.getDefaultInstance().getScriptHash());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#getScriptHashBytes()}
   */
  @Test
  void testJsCompileRequestGetScriptHashBytes() {
    // Arrange
    JsInvokeProtos.JsCompileRequest defaultInstance = JsInvokeProtos.JsCompileRequest.getDefaultInstance();

    // Act
    ByteString actualScriptHashBytes = defaultInstance.getScriptHashBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    ByteString byteString = actualScriptHashBytes.EMPTY;
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
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
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
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#getSerializedSize()}
   */
  @Test
  void testJsCompileRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsCompileRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsCompileRequest#isInitialized()}
   */
  @Test
  void testJsCompileRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.JsCompileRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testJsCompileRequestNewInstance() {
    // Arrange
    JsInvokeProtos.JsCompileRequest defaultInstance = JsInvokeProtos.JsCompileRequest.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof JsInvokeProtos.JsCompileRequest);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsCompileRequestParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsCompileRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsCompileRequestParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsCompileRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsCompileRequestParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsCompileRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsCompileRequestParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsInvokeProtos.JsCompileRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsCompileRequestParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsCompileRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsCompileRequestParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsCompileRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsCompileRequestParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.JsCompileRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsCompileRequestParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JsInvokeProtos.JsCompileRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseFrom(InputStream)}
   */
  @Test
  void testJsCompileRequestParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsCompileRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseFrom(InputStream)}
   */
  @Test
  void testJsCompileRequestParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsCompileRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsCompileRequestParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsCompileRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsCompileRequestParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.JsCompileRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsCompileResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsCompileResponse#hashCode()}
   * </ul>
   */
  @Test
  void testJsCompileResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsCompileResponse defaultInstance = JsInvokeProtos.JsCompileResponse.getDefaultInstance();
    JsInvokeProtos.JsCompileResponse defaultInstance2 = JsInvokeProtos.JsCompileResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsCompileResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsCompileResponse#hashCode()}
   * </ul>
   */
  @Test
  void testJsCompileResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsCompileResponse defaultInstance = JsInvokeProtos.JsCompileResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsCompileResponse#equals(Object)}
   */
  @Test
  void testJsCompileResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsCompileResponse.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsCompileResponse#equals(Object)}
   */
  @Test
  void testJsCompileResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsCompileResponse.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsCompileResponse#equals(Object)}
   */
  @Test
  void testJsCompileResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsCompileResponse.getDefaultInstance(), "Different type to JsCompileResponse");
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#getDefaultInstanceForType()}
   */
  @Test
  void testJsCompileResponseGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.JsCompileResponse defaultInstance = JsInvokeProtos.JsCompileResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsCompileResponse#getErrorCode()}
   */
  @Test
  void testJsCompileResponseGetErrorCode() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.COMPILATION_ERROR,
        JsInvokeProtos.JsCompileResponse.getDefaultInstance().getErrorCode());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsCompileResponse#getErrorDetails()}
   */
  @Test
  void testJsCompileResponseGetErrorDetails() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsCompileResponse.getDefaultInstance().getErrorDetails());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#getErrorDetailsBytes()}
   */
  @Test
  void testJsCompileResponseGetErrorDetailsBytes() {
    // Arrange
    JsInvokeProtos.JsCompileResponse defaultInstance = JsInvokeProtos.JsCompileResponse.getDefaultInstance();

    // Act
    ByteString actualErrorDetailsBytes = defaultInstance.getErrorDetailsBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualErrorDetailsBytes.EMPTY;
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
    assertEquals(byteString, actualErrorDetailsBytes);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsCompileResponse#getScriptHash()}
   */
  @Test
  void testJsCompileResponseGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsCompileResponse.getDefaultInstance().getScriptHash());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#getScriptHashBytes()}
   */
  @Test
  void testJsCompileResponseGetScriptHashBytes() {
    // Arrange
    JsInvokeProtos.JsCompileResponse defaultInstance = JsInvokeProtos.JsCompileResponse.getDefaultInstance();

    // Act
    ByteString actualScriptHashBytes = defaultInstance.getScriptHashBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualScriptHashBytes.EMPTY;
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
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#getSerializedSize()}
   */
  @Test
  void testJsCompileResponseGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsCompileResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsCompileResponse#isInitialized()}
   */
  @Test
  void testJsCompileResponseIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.JsCompileResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testJsCompileResponseNewInstance() {
    // Arrange
    JsInvokeProtos.JsCompileResponse defaultInstance = JsInvokeProtos.JsCompileResponse.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof JsInvokeProtos.JsCompileResponse);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsCompileResponseParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsCompileResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsCompileResponseParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsCompileResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsCompileResponseParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.JsCompileResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsCompileResponseParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsInvokeProtos.JsCompileResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsCompileResponseParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsCompileResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsCompileResponseParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsCompileResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsCompileResponseParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.JsCompileResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsCompileResponseParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JsInvokeProtos.JsCompileResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseFrom(InputStream)}
   */
  @Test
  void testJsCompileResponseParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsCompileResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseFrom(InputStream)}
   */
  @Test
  void testJsCompileResponseParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsCompileResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsCompileResponseParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsCompileResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsCompileResponseParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.JsCompileResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#forNumber(int)}
   */
  @Test
  void testJsInvokeErrorCodeForNumber() {
    // Arrange, Act and Assert
    assertNull(JsInvokeProtos.JsInvokeErrorCode.forNumber(42));
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.COMPILATION_ERROR, JsInvokeProtos.JsInvokeErrorCode.forNumber(0));
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.RUNTIME_ERROR, JsInvokeProtos.JsInvokeErrorCode.forNumber(1));
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.TIMEOUT_ERROR, JsInvokeProtos.JsInvokeErrorCode.forNumber(2));
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.NOT_FOUND_ERROR, JsInvokeProtos.JsInvokeErrorCode.forNumber(3));
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#getNumber()}
   */
  @Test
  void testJsInvokeErrorCodeGetNumber() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsInvokeErrorCode.COMPILATION_ERROR.getNumber());
    assertThrows(IllegalArgumentException.class, () -> JsInvokeProtos.JsInvokeErrorCode.UNRECOGNIZED.getNumber());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeErrorCode#getValueDescriptor()}
   */
  @Test
  void testJsInvokeErrorCodeGetValueDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> JsInvokeProtos.JsInvokeErrorCode.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  void testJsInvokeErrorCodeInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<JsInvokeProtos.JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeProtos.JsInvokeErrorCode
        .internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(10));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  void testJsInvokeErrorCodeInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<JsInvokeProtos.JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeProtos.JsInvokeErrorCode
        .internalGetValueMap();

    // Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.RUNTIME_ERROR, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  void testJsInvokeErrorCodeInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<JsInvokeProtos.JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeProtos.JsInvokeErrorCode
        .internalGetValueMap();

    // Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.TIMEOUT_ERROR, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  void testJsInvokeErrorCodeInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<JsInvokeProtos.JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeProtos.JsInvokeErrorCode
        .internalGetValueMap();

    // Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.NOT_FOUND_ERROR,
        actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  void testJsInvokeErrorCodeInternalGetValueMap5() {
    // Arrange and Act
    Internal.EnumLiteMap<JsInvokeProtos.JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeProtos.JsInvokeErrorCode
        .internalGetValueMap();

    // Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.COMPILATION_ERROR,
        actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#valueOf(int)}
   */
  @Test
  void testJsInvokeErrorCodeValueOf() {
    // Arrange, Act and Assert
    assertNull(JsInvokeProtos.JsInvokeErrorCode.valueOf(42));
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.COMPILATION_ERROR, JsInvokeProtos.JsInvokeErrorCode.valueOf(0));
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.RUNTIME_ERROR, JsInvokeProtos.JsInvokeErrorCode.valueOf(1));
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.TIMEOUT_ERROR, JsInvokeProtos.JsInvokeErrorCode.valueOf(2));
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.NOT_FOUND_ERROR, JsInvokeProtos.JsInvokeErrorCode.valueOf(3));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsInvokeRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsInvokeRequest#hashCode()}
   * </ul>
   */
  @Test
  void testJsInvokeRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsInvokeRequest defaultInstance = JsInvokeProtos.JsInvokeRequest.getDefaultInstance();
    JsInvokeProtos.JsInvokeRequest defaultInstance2 = JsInvokeProtos.JsInvokeRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsInvokeRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsInvokeRequest#hashCode()}
   * </ul>
   */
  @Test
  void testJsInvokeRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsInvokeRequest defaultInstance = JsInvokeProtos.JsInvokeRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#equals(Object)}
   */
  @Test
  void testJsInvokeRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsInvokeRequest.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#equals(Object)}
   */
  @Test
  void testJsInvokeRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsInvokeRequest.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#equals(Object)}
   */
  @Test
  void testJsInvokeRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsInvokeRequest.getDefaultInstance(), "Different type to JsInvokeRequest");
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#getArgsCount()}
   */
  @Test
  void testJsInvokeRequestGetArgsCount() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsInvokeRequest.getDefaultInstance().getArgsCount());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#getArgsList()}
   */
  @Test
  void testJsInvokeRequestGetArgsList() {
    // Arrange
    JsInvokeProtos.JsInvokeRequest defaultInstance = JsInvokeProtos.JsInvokeRequest.getDefaultInstance();

    // Act
    ProtocolStringList actualArgsList = defaultInstance.getArgsList();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
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
    assertTrue(file.getDependencies().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualArgsList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualArgsList).EMPTY;
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
    assertEquals(lazyStringList, fields.get(3).toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(4).toProto().findInitializationErrors());
    assertEquals(lazyStringList, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertEquals(lazyStringList, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals(lazyStringList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(7);
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
    assertEquals(lazyStringList, file2.getExtensions());
    assertEquals(lazyStringList, file2.getPublicDependencies());
    assertEquals(lazyStringList, file2.getServices());
    assertSame(lazyStringList, defaultInstanceForType.getReservedNameList());
    assertSame(lazyStringList, toProtoResult3.getReservedNameList());
    assertSame(lazyStringList, toProtoResult.getReservedNameList());
    assertSame(lazyStringList, defaultInstanceForType2.getDependencyList());
    assertSame(lazyStringList, toProtoResult2.getDependencyList());
    assertSame(lazyStringList, actualArgsList);
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#getDefaultInstanceForType()}
   */
  @Test
  void testJsInvokeRequestGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.JsInvokeRequest defaultInstance = JsInvokeProtos.JsInvokeRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#getFunctionName()}
   */
  @Test
  void testJsInvokeRequestGetFunctionName() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsInvokeRequest.getDefaultInstance().getFunctionName());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#getFunctionNameBytes()}
   */
  @Test
  void testJsInvokeRequestGetFunctionNameBytes() {
    // Arrange
    JsInvokeProtos.JsInvokeRequest defaultInstance = JsInvokeProtos.JsInvokeRequest.getDefaultInstance();

    // Act
    ByteString actualFunctionNameBytes = defaultInstance.getFunctionNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    ByteString byteString = actualFunctionNameBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(3).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(4).toProto();
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
    assertEquals(byteString, actualFunctionNameBytes);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#getScriptBody()}
   */
  @Test
  void testJsInvokeRequestGetScriptBody() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsInvokeRequest.getDefaultInstance().getScriptBody());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#getScriptBodyBytes()}
   */
  @Test
  void testJsInvokeRequestGetScriptBodyBytes() {
    // Arrange
    JsInvokeProtos.JsInvokeRequest defaultInstance = JsInvokeProtos.JsInvokeRequest.getDefaultInstance();

    // Act
    ByteString actualScriptBodyBytes = defaultInstance.getScriptBodyBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    ByteString byteString = actualScriptBodyBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(3).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(4).toProto();
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
    assertEquals(byteString, actualScriptBodyBytes);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#getScriptHash()}
   */
  @Test
  void testJsInvokeRequestGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsInvokeRequest.getDefaultInstance().getScriptHash());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#getScriptHashBytes()}
   */
  @Test
  void testJsInvokeRequestGetScriptHashBytes() {
    // Arrange
    JsInvokeProtos.JsInvokeRequest defaultInstance = JsInvokeProtos.JsInvokeRequest.getDefaultInstance();

    // Act
    ByteString actualScriptHashBytes = defaultInstance.getScriptHashBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    ByteString byteString = actualScriptHashBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(3).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(4).toProto();
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
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#getSerializedSize()}
   */
  @Test
  void testJsInvokeRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsInvokeRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#isInitialized()}
   */
  @Test
  void testJsInvokeRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.JsInvokeRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testJsInvokeRequestNewInstance() {
    // Arrange
    JsInvokeProtos.JsInvokeRequest defaultInstance = JsInvokeProtos.JsInvokeRequest.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof JsInvokeProtos.JsInvokeRequest);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsInvokeRequestParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsInvokeRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsInvokeRequestParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsInvokeRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsInvokeRequestParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsInvokeRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsInvokeRequestParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsInvokeProtos.JsInvokeRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsInvokeRequestParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsInvokeRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsInvokeRequestParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsInvokeRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsInvokeRequestParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.JsInvokeRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsInvokeRequestParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JsInvokeProtos.JsInvokeRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseFrom(InputStream)}
   */
  @Test
  void testJsInvokeRequestParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsInvokeRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseFrom(InputStream)}
   */
  @Test
  void testJsInvokeRequestParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsInvokeRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsInvokeRequestParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsInvokeRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsInvokeRequestParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.JsInvokeRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsInvokeResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsInvokeResponse#hashCode()}
   * </ul>
   */
  @Test
  void testJsInvokeResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsInvokeResponse defaultInstance = JsInvokeProtos.JsInvokeResponse.getDefaultInstance();
    JsInvokeProtos.JsInvokeResponse defaultInstance2 = JsInvokeProtos.JsInvokeResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsInvokeResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsInvokeResponse#hashCode()}
   * </ul>
   */
  @Test
  void testJsInvokeResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsInvokeResponse defaultInstance = JsInvokeProtos.JsInvokeResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#equals(Object)}
   */
  @Test
  void testJsInvokeResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsInvokeResponse.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#equals(Object)}
   */
  @Test
  void testJsInvokeResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsInvokeResponse.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#equals(Object)}
   */
  @Test
  void testJsInvokeResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsInvokeResponse.getDefaultInstance(), "Different type to JsInvokeResponse");
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#getDefaultInstanceForType()}
   */
  @Test
  void testJsInvokeResponseGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.JsInvokeResponse defaultInstance = JsInvokeProtos.JsInvokeResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#getErrorCode()}
   */
  @Test
  void testJsInvokeResponseGetErrorCode() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.COMPILATION_ERROR,
        JsInvokeProtos.JsInvokeResponse.getDefaultInstance().getErrorCode());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#getErrorDetails()}
   */
  @Test
  void testJsInvokeResponseGetErrorDetails() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsInvokeResponse.getDefaultInstance().getErrorDetails());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#getErrorDetailsBytes()}
   */
  @Test
  void testJsInvokeResponseGetErrorDetailsBytes() {
    // Arrange
    JsInvokeProtos.JsInvokeResponse defaultInstance = JsInvokeProtos.JsInvokeResponse.getDefaultInstance();

    // Act
    ByteString actualErrorDetailsBytes = defaultInstance.getErrorDetailsBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualErrorDetailsBytes.EMPTY;
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
    assertEquals(byteString, actualErrorDetailsBytes);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#getResult()}
   */
  @Test
  void testJsInvokeResponseGetResult() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsInvokeResponse.getDefaultInstance().getResult());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#getResultBytes()}
   */
  @Test
  void testJsInvokeResponseGetResultBytes() {
    // Arrange
    JsInvokeProtos.JsInvokeResponse defaultInstance = JsInvokeProtos.JsInvokeResponse.getDefaultInstance();

    // Act
    ByteString actualResultBytes = defaultInstance.getResultBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualResultBytes.EMPTY;
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
    assertEquals(byteString, actualResultBytes);
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#getSerializedSize()}
   */
  @Test
  void testJsInvokeResponseGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsInvokeResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#isInitialized()}
   */
  @Test
  void testJsInvokeResponseIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.JsInvokeResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testJsInvokeResponseNewInstance() {
    // Arrange
    JsInvokeProtos.JsInvokeResponse defaultInstance = JsInvokeProtos.JsInvokeResponse.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof JsInvokeProtos.JsInvokeResponse);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsInvokeResponseParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsInvokeResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsInvokeResponseParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsInvokeResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsInvokeResponseParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsInvokeResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsInvokeResponseParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsInvokeProtos.JsInvokeResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsInvokeResponseParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsInvokeResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsInvokeResponseParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsInvokeResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsInvokeResponseParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.JsInvokeResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsInvokeResponseParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JsInvokeProtos.JsInvokeResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseFrom(InputStream)}
   */
  @Test
  void testJsInvokeResponseParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsInvokeResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseFrom(InputStream)}
   */
  @Test
  void testJsInvokeResponseParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsInvokeResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsInvokeResponseParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsInvokeResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsInvokeResponseParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.JsInvokeResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsReleaseRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsReleaseRequest#hashCode()}
   * </ul>
   */
  @Test
  void testJsReleaseRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsReleaseRequest defaultInstance = JsInvokeProtos.JsReleaseRequest.getDefaultInstance();
    JsInvokeProtos.JsReleaseRequest defaultInstance2 = JsInvokeProtos.JsReleaseRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsReleaseRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsReleaseRequest#hashCode()}
   * </ul>
   */
  @Test
  void testJsReleaseRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsReleaseRequest defaultInstance = JsInvokeProtos.JsReleaseRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsReleaseRequest#equals(Object)}
   */
  @Test
  void testJsReleaseRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsReleaseRequest.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsReleaseRequest#equals(Object)}
   */
  @Test
  void testJsReleaseRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsReleaseRequest.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsReleaseRequest#equals(Object)}
   */
  @Test
  void testJsReleaseRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsReleaseRequest.getDefaultInstance(), "Different type to JsReleaseRequest");
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#getDefaultInstanceForType()}
   */
  @Test
  void testJsReleaseRequestGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.JsReleaseRequest defaultInstance = JsInvokeProtos.JsReleaseRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsReleaseRequest#getFunctionName()}
   */
  @Test
  void testJsReleaseRequestGetFunctionName() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsReleaseRequest.getDefaultInstance().getFunctionName());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#getFunctionNameBytes()}
   */
  @Test
  void testJsReleaseRequestGetFunctionNameBytes() {
    // Arrange
    JsInvokeProtos.JsReleaseRequest defaultInstance = JsInvokeProtos.JsReleaseRequest.getDefaultInstance();

    // Act
    ByteString actualFunctionNameBytes = defaultInstance.getFunctionNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualFunctionNameBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = fields.get(0).toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
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
    assertEquals(byteString, actualFunctionNameBytes);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsReleaseRequest#getScriptHash()}
   */
  @Test
  void testJsReleaseRequestGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsReleaseRequest.getDefaultInstance().getScriptHash());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#getScriptHashBytes()}
   */
  @Test
  void testJsReleaseRequestGetScriptHashBytes() {
    // Arrange
    JsInvokeProtos.JsReleaseRequest defaultInstance = JsInvokeProtos.JsReleaseRequest.getDefaultInstance();

    // Act
    ByteString actualScriptHashBytes = defaultInstance.getScriptHashBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualScriptHashBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = fields.get(0).toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
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
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#getSerializedSize()}
   */
  @Test
  void testJsReleaseRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsReleaseRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsReleaseRequest#isInitialized()}
   */
  @Test
  void testJsReleaseRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.JsReleaseRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testJsReleaseRequestNewInstance() {
    // Arrange
    JsInvokeProtos.JsReleaseRequest defaultInstance = JsInvokeProtos.JsReleaseRequest.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof JsInvokeProtos.JsReleaseRequest);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsReleaseRequestParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsReleaseRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsReleaseRequestParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsReleaseRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsReleaseRequestParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsReleaseRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsReleaseRequestParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsInvokeProtos.JsReleaseRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsReleaseRequestParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsReleaseRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsReleaseRequestParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsReleaseRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsReleaseRequestParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.JsReleaseRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsReleaseRequestParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JsInvokeProtos.JsReleaseRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseFrom(InputStream)}
   */
  @Test
  void testJsReleaseRequestParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsReleaseRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseFrom(InputStream)}
   */
  @Test
  void testJsReleaseRequestParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsReleaseRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsReleaseRequestParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsReleaseRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsReleaseRequestParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.JsReleaseRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsReleaseResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsReleaseResponse#hashCode()}
   * </ul>
   */
  @Test
  void testJsReleaseResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsReleaseResponse defaultInstance = JsInvokeProtos.JsReleaseResponse.getDefaultInstance();
    JsInvokeProtos.JsReleaseResponse defaultInstance2 = JsInvokeProtos.JsReleaseResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsReleaseResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsReleaseResponse#hashCode()}
   * </ul>
   */
  @Test
  void testJsReleaseResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsReleaseResponse defaultInstance = JsInvokeProtos.JsReleaseResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsReleaseResponse#equals(Object)}
   */
  @Test
  void testJsReleaseResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsReleaseResponse.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsReleaseResponse#equals(Object)}
   */
  @Test
  void testJsReleaseResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsReleaseResponse.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsReleaseResponse#equals(Object)}
   */
  @Test
  void testJsReleaseResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsReleaseResponse.getDefaultInstance(), "Different type to JsReleaseResponse");
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#getDefaultInstanceForType()}
   */
  @Test
  void testJsReleaseResponseGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.JsReleaseResponse defaultInstance = JsInvokeProtos.JsReleaseResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsReleaseResponse#getScriptHash()}
   */
  @Test
  void testJsReleaseResponseGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsReleaseResponse.getDefaultInstance().getScriptHash());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#getScriptHashBytes()}
   */
  @Test
  void testJsReleaseResponseGetScriptHashBytes() {
    // Arrange
    JsInvokeProtos.JsReleaseResponse defaultInstance = JsInvokeProtos.JsReleaseResponse.getDefaultInstance();

    // Act
    ByteString actualScriptHashBytes = defaultInstance.getScriptHashBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualScriptHashBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = fields.get(0).toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
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
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#getSerializedSize()}
   */
  @Test
  void testJsReleaseResponseGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsReleaseResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link JsInvokeProtos.JsReleaseResponse#isInitialized()}
   */
  @Test
  void testJsReleaseResponseIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.JsReleaseResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testJsReleaseResponseNewInstance() {
    // Arrange
    JsInvokeProtos.JsReleaseResponse defaultInstance = JsInvokeProtos.JsReleaseResponse.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof JsInvokeProtos.JsReleaseResponse);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsReleaseResponseParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsReleaseResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsReleaseResponseParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsReleaseResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsReleaseResponseParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.JsReleaseResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testJsReleaseResponseParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsInvokeProtos.JsReleaseResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsReleaseResponseParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsReleaseResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsReleaseResponseParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsReleaseResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsReleaseResponseParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.JsReleaseResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsReleaseResponseParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JsInvokeProtos.JsReleaseResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseFrom(InputStream)}
   */
  @Test
  void testJsReleaseResponseParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsReleaseResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseFrom(InputStream)}
   */
  @Test
  void testJsReleaseResponseParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsReleaseResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsReleaseResponseParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsReleaseResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testJsReleaseResponseParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.JsReleaseResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.RemoteJsRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.RemoteJsRequest#hashCode()}
   * </ul>
   */
  @Test
  void testRemoteJsRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.RemoteJsRequest defaultInstance = JsInvokeProtos.RemoteJsRequest.getDefaultInstance();
    JsInvokeProtos.RemoteJsRequest defaultInstance2 = JsInvokeProtos.RemoteJsRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.RemoteJsRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.RemoteJsRequest#hashCode()}
   * </ul>
   */
  @Test
  void testRemoteJsRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.RemoteJsRequest defaultInstance = JsInvokeProtos.RemoteJsRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#equals(Object)}
   */
  @Test
  void testRemoteJsRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.RemoteJsRequest.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#equals(Object)}
   */
  @Test
  void testRemoteJsRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.RemoteJsRequest.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#equals(Object)}
   */
  @Test
  void testRemoteJsRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.RemoteJsRequest.getDefaultInstance(), "Different type to RemoteJsRequest");
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#getDefaultInstanceForType()}
   */
  @Test
  void testRemoteJsRequestGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.RemoteJsRequest defaultInstance = JsInvokeProtos.RemoteJsRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#getSerializedSize()}
   */
  @Test
  void testRemoteJsRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.RemoteJsRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#hasCompileRequest()}
   */
  @Test
  void testRemoteJsRequestHasCompileRequest() {
    // Arrange, Act and Assert
    assertFalse(JsInvokeProtos.RemoteJsRequest.getDefaultInstance().hasCompileRequest());
  }

  /**
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#hasInvokeRequest()}
   */
  @Test
  void testRemoteJsRequestHasInvokeRequest() {
    // Arrange, Act and Assert
    assertFalse(JsInvokeProtos.RemoteJsRequest.getDefaultInstance().hasInvokeRequest());
  }

  /**
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#hasReleaseRequest()}
   */
  @Test
  void testRemoteJsRequestHasReleaseRequest() {
    // Arrange, Act and Assert
    assertFalse(JsInvokeProtos.RemoteJsRequest.getDefaultInstance().hasReleaseRequest());
  }

  /**
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#isInitialized()}
   */
  @Test
  void testRemoteJsRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.RemoteJsRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testRemoteJsRequestNewInstance() {
    // Arrange
    JsInvokeProtos.RemoteJsRequest defaultInstance = JsInvokeProtos.RemoteJsRequest.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof JsInvokeProtos.RemoteJsRequest);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testRemoteJsRequestParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.RemoteJsRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testRemoteJsRequestParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.RemoteJsRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testRemoteJsRequestParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.RemoteJsRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRemoteJsRequestParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.RemoteJsRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRemoteJsRequestParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.RemoteJsRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRemoteJsRequestParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.RemoteJsRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseFrom(InputStream)}
   */
  @Test
  void testRemoteJsRequestParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.RemoteJsRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseFrom(InputStream)}
   */
  @Test
  void testRemoteJsRequestParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.RemoteJsRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRemoteJsRequestParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.RemoteJsRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRemoteJsRequestParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.RemoteJsRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.RemoteJsResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.RemoteJsResponse#hashCode()}
   * </ul>
   */
  @Test
  void testRemoteJsResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.RemoteJsResponse defaultInstance = JsInvokeProtos.RemoteJsResponse.getDefaultInstance();
    JsInvokeProtos.RemoteJsResponse defaultInstance2 = JsInvokeProtos.RemoteJsResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.RemoteJsResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.RemoteJsResponse#hashCode()}
   * </ul>
   */
  @Test
  void testRemoteJsResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.RemoteJsResponse defaultInstance = JsInvokeProtos.RemoteJsResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link JsInvokeProtos.RemoteJsResponse#equals(Object)}
   */
  @Test
  void testRemoteJsResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.RemoteJsResponse.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link JsInvokeProtos.RemoteJsResponse#equals(Object)}
   */
  @Test
  void testRemoteJsResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.RemoteJsResponse.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link JsInvokeProtos.RemoteJsResponse#equals(Object)}
   */
  @Test
  void testRemoteJsResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.RemoteJsResponse.getDefaultInstance(), "Different type to RemoteJsResponse");
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#getDefaultInstanceForType()}
   */
  @Test
  void testRemoteJsResponseGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.RemoteJsResponse defaultInstance = JsInvokeProtos.RemoteJsResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#getSerializedSize()}
   */
  @Test
  void testRemoteJsResponseGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.RemoteJsResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#hasCompileResponse()}
   */
  @Test
  void testRemoteJsResponseHasCompileResponse() {
    // Arrange, Act and Assert
    assertFalse(JsInvokeProtos.RemoteJsResponse.getDefaultInstance().hasCompileResponse());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#hasInvokeResponse()}
   */
  @Test
  void testRemoteJsResponseHasInvokeResponse() {
    // Arrange, Act and Assert
    assertFalse(JsInvokeProtos.RemoteJsResponse.getDefaultInstance().hasInvokeResponse());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#hasReleaseResponse()}
   */
  @Test
  void testRemoteJsResponseHasReleaseResponse() {
    // Arrange, Act and Assert
    assertFalse(JsInvokeProtos.RemoteJsResponse.getDefaultInstance().hasReleaseResponse());
  }

  /**
   * Method under test: {@link JsInvokeProtos.RemoteJsResponse#isInitialized()}
   */
  @Test
  void testRemoteJsResponseIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.RemoteJsResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testRemoteJsResponseNewInstance() {
    // Arrange
    JsInvokeProtos.RemoteJsResponse defaultInstance = JsInvokeProtos.RemoteJsResponse.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof JsInvokeProtos.RemoteJsResponse);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testRemoteJsResponseParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.RemoteJsResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testRemoteJsResponseParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.RemoteJsResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testRemoteJsResponseParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.RemoteJsResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRemoteJsResponseParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.RemoteJsResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRemoteJsResponseParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.RemoteJsResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRemoteJsResponseParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.RemoteJsResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseFrom(InputStream)}
   */
  @Test
  void testRemoteJsResponseParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.RemoteJsResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseFrom(InputStream)}
   */
  @Test
  void testRemoteJsResponseParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.RemoteJsResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRemoteJsResponseParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.RemoteJsResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testRemoteJsResponseParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.RemoteJsResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
