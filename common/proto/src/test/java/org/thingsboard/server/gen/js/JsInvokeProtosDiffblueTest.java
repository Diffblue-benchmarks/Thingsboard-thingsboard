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
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal.EnumLiteMap;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.js.JsInvokeProtos.JsCompileRequest;
import org.thingsboard.server.gen.js.JsInvokeProtos.JsCompileResponse;
import org.thingsboard.server.gen.js.JsInvokeProtos.JsInvokeErrorCode;
import org.thingsboard.server.gen.js.JsInvokeProtos.JsInvokeRequest;
import org.thingsboard.server.gen.js.JsInvokeProtos.JsInvokeResponse;
import org.thingsboard.server.gen.js.JsInvokeProtos.JsReleaseRequest;
import org.thingsboard.server.gen.js.JsInvokeProtos.JsReleaseResponse;
import org.thingsboard.server.gen.js.JsInvokeProtos.RemoteJsRequest;
import org.thingsboard.server.gen.js.JsInvokeProtos.RemoteJsResponse;

class JsInvokeProtosDiffblueTest {
  /**
   * Test JsCompileRequest {@link JsCompileRequest#equals(Object)}, and {@link JsCompileRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsCompileRequest#equals(Object)}
   *   <li>{@link JsCompileRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsCompileRequest equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsCompileRequest.equals(Object)", "int JsCompileRequest.hashCode()"})
  void testJsCompileRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsCompileRequest defaultInstance = JsCompileRequest.getDefaultInstance();
    JsCompileRequest defaultInstance2 = JsCompileRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#equals(Object)}, and {@link JsCompileRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsCompileRequest#equals(Object)}
   *   <li>{@link JsCompileRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsCompileRequest equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsCompileRequest.equals(Object)", "int JsCompileRequest.hashCode()"})
  void testJsCompileRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsCompileRequest defaultInstance = JsCompileRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsCompileRequest equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsCompileRequest.equals(Object)", "int JsCompileRequest.hashCode()"})
  void testJsCompileRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsCompileRequest.getDefaultInstance(), 1);
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsCompileRequest equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsCompileRequest.equals(Object)", "int JsCompileRequest.hashCode()"})
  void testJsCompileRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsCompileRequest.getDefaultInstance(), null);
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsCompileRequest equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsCompileRequest.equals(Object)", "int JsCompileRequest.hashCode()"})
  void testJsCompileRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsCompileRequest.getDefaultInstance(), "Different type to JsCompileRequest");
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link JsCompileRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.getDefaultInstanceForType()"})
  void testJsCompileRequestGetDefaultInstanceForType() {
    // Arrange
    JsCompileRequest defaultInstance = JsCompileRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getFunctionName()}.
   * <p>
   * Method under test: {@link JsCompileRequest#getFunctionName()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getFunctionName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JsCompileRequest.getFunctionName()"})
  void testJsCompileRequestGetFunctionName() {
    // Arrange, Act and Assert
    assertEquals("", JsCompileRequest.getDefaultInstance().getFunctionName());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getFunctionNameBytes()}.
   * <p>
   * Method under test: {@link JsCompileRequest#getFunctionNameBytes()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getFunctionNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString JsCompileRequest.getFunctionNameBytes()"})
  void testJsCompileRequestGetFunctionNameBytes() {
    // Arrange
    JsCompileRequest defaultInstance = JsCompileRequest.getDefaultInstance();

    // Act
    ByteString actualFunctionNameBytes = defaultInstance.getFunctionNameBytes();

    // Assert
    ByteString byteString = actualFunctionNameBytes.EMPTY;
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
    assertEquals(byteString, actualFunctionNameBytes);
    assertEquals(byteString, defaultInstance.getScriptBodyBytes());
    assertEquals(byteString, defaultInstance.getScriptHashBytes());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getScriptBody()}.
   * <p>
   * Method under test: {@link JsCompileRequest#getScriptBody()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getScriptBody()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JsCompileRequest.getScriptBody()"})
  void testJsCompileRequestGetScriptBody() {
    // Arrange, Act and Assert
    assertEquals("", JsCompileRequest.getDefaultInstance().getScriptBody());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getScriptBodyBytes()}.
   * <p>
   * Method under test: {@link JsCompileRequest#getScriptBodyBytes()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getScriptBodyBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString JsCompileRequest.getScriptBodyBytes()"})
  void testJsCompileRequestGetScriptBodyBytes() {
    // Arrange
    JsCompileRequest defaultInstance = JsCompileRequest.getDefaultInstance();

    // Act
    ByteString actualScriptBodyBytes = defaultInstance.getScriptBodyBytes();

    // Assert
    ByteString byteString = actualScriptBodyBytes.EMPTY;
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
    assertEquals(byteString, defaultInstance.getFunctionNameBytes());
    assertEquals(byteString, actualScriptBodyBytes);
    assertEquals(byteString, defaultInstance.getScriptHashBytes());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getScriptHash()}.
   * <p>
   * Method under test: {@link JsCompileRequest#getScriptHash()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getScriptHash()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JsCompileRequest.getScriptHash()"})
  void testJsCompileRequestGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsCompileRequest.getDefaultInstance().getScriptHash());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getScriptHashBytes()}.
   * <p>
   * Method under test: {@link JsCompileRequest#getScriptHashBytes()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getScriptHashBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString JsCompileRequest.getScriptHashBytes()"})
  void testJsCompileRequestGetScriptHashBytes() {
    // Arrange
    JsCompileRequest defaultInstance = JsCompileRequest.getDefaultInstance();

    // Act
    ByteString actualScriptHashBytes = defaultInstance.getScriptHashBytes();

    // Assert
    ByteString byteString = actualScriptHashBytes.EMPTY;
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
    assertEquals(byteString, defaultInstance.getFunctionNameBytes());
    assertEquals(byteString, defaultInstance.getScriptBodyBytes());
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getSerializedSize()}.
   * <p>
   * Method under test: {@link JsCompileRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JsCompileRequest.getSerializedSize()"})
  void testJsCompileRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsCompileRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#isInitialized()}.
   * <p>
   * Method under test: {@link JsCompileRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test JsCompileRequest isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsCompileRequest.isInitialized()"})
  void testJsCompileRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsCompileRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseDelimitedFrom(InputStream)"})
  void testJsCompileRequestParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsCompileRequest actualParseDelimitedFromResult = JsCompileRequest.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getFunctionName());
    assertEquals("", actualParseDelimitedFromResult.getScriptBody());
    assertEquals("", actualParseDelimitedFromResult.getScriptHash());
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
   * Test JsCompileRequest {@link JsCompileRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseDelimitedFrom(InputStream)"})
  void testJsCompileRequestParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsCompileRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseDelimitedFrom(InputStream)"})
  void testJsCompileRequestParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsCompileRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileRequestParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsCompileRequest actualParseDelimitedFromResult = JsCompileRequest.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getFunctionName());
    assertEquals("", actualParseDelimitedFromResult.getScriptBody());
    assertEquals("", actualParseDelimitedFromResult.getScriptHash());
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
   * Test JsCompileRequest {@link JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileRequestParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsCompileRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileRequestParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsCompileRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileRequestParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JsCompileRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileRequestParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsCompileRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseDelimitedFrom(InputStream)"})
  void testJsCompileRequestParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsCompileRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseDelimitedFrom(InputStream)"})
  void testJsCompileRequestParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JsCompileRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(byte[])"})
  void testJsCompileRequestParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsCompileRequest actualParseFromResult = JsCompileRequest.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(ByteBuffer)"})
  void testJsCompileRequestParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsCompileRequest actualParseFromResult = JsCompileRequest.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testJsCompileRequestParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    JsCompileRequest actualParseFromResult = JsCompileRequest.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(byte[], ExtensionRegistryLite)"})
  void testJsCompileRequestParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsCompileRequest actualParseFromResult = JsCompileRequest.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(ByteString)"})
  void testJsCompileRequestParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsCompileRequest actualParseFromResult = JsCompileRequest.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getFunctionNameBytes());
    assertEquals(byteString, actualParseFromResult.getScriptBodyBytes());
    assertEquals(byteString, actualParseFromResult.getScriptHashBytes());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testJsCompileRequestParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsCompileRequest actualParseFromResult = JsCompileRequest.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getFunctionNameBytes());
    assertEquals(byteString, actualParseFromResult.getScriptBodyBytes());
    assertEquals(byteString, actualParseFromResult.getScriptHashBytes());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(CodedInputStream)"})
  void testJsCompileRequestParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JsCompileRequest actualParseFromResult = JsCompileRequest.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testJsCompileRequestParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JsCompileRequest actualParseFromResult = JsCompileRequest.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(InputStream)"})
  void testJsCompileRequestParseFromWithInputStream() throws IOException {
    // Arrange and Act
    JsCompileRequest actualParseFromResult = JsCompileRequest.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(InputStream)"})
  void testJsCompileRequestParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsCompileRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileRequestParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    JsCompileRequest actualParseFromResult = JsCompileRequest.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileRequestParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsCompileRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileRequestParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsCompileRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(InputStream)"})
  void testJsCompileRequestParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsCompileRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest JsCompileRequest.parseFrom(InputStream)"})
  void testJsCompileRequestParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JsCompileRequest actualParseFromResult = JsCompileRequest.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#equals(Object)}, and {@link JsCompileResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsCompileResponse#equals(Object)}
   *   <li>{@link JsCompileResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsCompileResponse equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsCompileResponse.equals(Object)", "int JsCompileResponse.hashCode()"})
  void testJsCompileResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsCompileResponse defaultInstance = JsCompileResponse.getDefaultInstance();
    JsCompileResponse defaultInstance2 = JsCompileResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#equals(Object)}, and {@link JsCompileResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsCompileResponse#equals(Object)}
   *   <li>{@link JsCompileResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsCompileResponse equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsCompileResponse.equals(Object)", "int JsCompileResponse.hashCode()"})
  void testJsCompileResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsCompileResponse defaultInstance = JsCompileResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsCompileResponse equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsCompileResponse.equals(Object)", "int JsCompileResponse.hashCode()"})
  void testJsCompileResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsCompileResponse.getDefaultInstance(), 1);
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsCompileResponse equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsCompileResponse.equals(Object)", "int JsCompileResponse.hashCode()"})
  void testJsCompileResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsCompileResponse.getDefaultInstance(), null);
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsCompileResponse equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsCompileResponse.equals(Object)", "int JsCompileResponse.hashCode()"})
  void testJsCompileResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsCompileResponse.getDefaultInstance(), "Different type to JsCompileResponse");
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link JsCompileResponse#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test JsCompileResponse getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.getDefaultInstanceForType()"})
  void testJsCompileResponseGetDefaultInstanceForType() {
    // Arrange
    JsCompileResponse defaultInstance = JsCompileResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#getErrorCode()}.
   * <p>
   * Method under test: {@link JsCompileResponse#getErrorCode()}
   */
  @Test
  @DisplayName("Test JsCompileResponse getErrorCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeErrorCode JsCompileResponse.getErrorCode()"})
  void testJsCompileResponseGetErrorCode() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, JsCompileResponse.getDefaultInstance().getErrorCode());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#getErrorDetails()}.
   * <p>
   * Method under test: {@link JsCompileResponse#getErrorDetails()}
   */
  @Test
  @DisplayName("Test JsCompileResponse getErrorDetails()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JsCompileResponse.getErrorDetails()"})
  void testJsCompileResponseGetErrorDetails() {
    // Arrange, Act and Assert
    assertEquals("", JsCompileResponse.getDefaultInstance().getErrorDetails());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#getErrorDetailsBytes()}.
   * <p>
   * Method under test: {@link JsCompileResponse#getErrorDetailsBytes()}
   */
  @Test
  @DisplayName("Test JsCompileResponse getErrorDetailsBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString JsCompileResponse.getErrorDetailsBytes()"})
  void testJsCompileResponseGetErrorDetailsBytes() {
    // Arrange
    JsCompileResponse defaultInstance = JsCompileResponse.getDefaultInstance();

    // Act
    ByteString actualErrorDetailsBytes = defaultInstance.getErrorDetailsBytes();

    // Assert
    ByteString byteString = actualErrorDetailsBytes.EMPTY;
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
    assertEquals(byteString, actualErrorDetailsBytes);
    assertEquals(byteString, defaultInstance.getScriptHashBytes());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#getScriptHash()}.
   * <p>
   * Method under test: {@link JsCompileResponse#getScriptHash()}
   */
  @Test
  @DisplayName("Test JsCompileResponse getScriptHash()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JsCompileResponse.getScriptHash()"})
  void testJsCompileResponseGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsCompileResponse.getDefaultInstance().getScriptHash());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#getScriptHashBytes()}.
   * <p>
   * Method under test: {@link JsCompileResponse#getScriptHashBytes()}
   */
  @Test
  @DisplayName("Test JsCompileResponse getScriptHashBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString JsCompileResponse.getScriptHashBytes()"})
  void testJsCompileResponseGetScriptHashBytes() {
    // Arrange
    JsCompileResponse defaultInstance = JsCompileResponse.getDefaultInstance();

    // Act
    ByteString actualScriptHashBytes = defaultInstance.getScriptHashBytes();

    // Assert
    ByteString byteString = actualScriptHashBytes.EMPTY;
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
    assertEquals(byteString, defaultInstance.getErrorDetailsBytes());
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#getSerializedSize()}.
   * <p>
   * Method under test: {@link JsCompileResponse#getSerializedSize()}
   */
  @Test
  @DisplayName("Test JsCompileResponse getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JsCompileResponse.getSerializedSize()"})
  void testJsCompileResponseGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsCompileResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#isInitialized()}.
   * <p>
   * Method under test: {@link JsCompileResponse#isInitialized()}
   */
  @Test
  @DisplayName("Test JsCompileResponse isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsCompileResponse.isInitialized()"})
  void testJsCompileResponseIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsCompileResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseDelimitedFrom(InputStream)"})
  void testJsCompileResponseParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsCompileResponse actualParseDelimitedFromResult = JsCompileResponse.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getErrorDetails());
    assertEquals("", actualParseDelimitedFromResult.getScriptHash());
    assertEquals(0, actualParseDelimitedFromResult.getErrorCodeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseDelimitedFromResult.getErrorCode());
    assertFalse(actualParseDelimitedFromResult.getSuccess());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseDelimitedFrom(InputStream)"})
  void testJsCompileResponseParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsCompileResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseDelimitedFrom(InputStream)"})
  void testJsCompileResponseParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsCompileResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileResponseParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsCompileResponse actualParseDelimitedFromResult = JsCompileResponse.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getErrorDetails());
    assertEquals("", actualParseDelimitedFromResult.getScriptHash());
    assertEquals(0, actualParseDelimitedFromResult.getErrorCodeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseDelimitedFromResult.getErrorCode());
    assertFalse(actualParseDelimitedFromResult.getSuccess());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileResponseParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsCompileResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileResponseParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsCompileResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileResponseParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JsCompileResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileResponseParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsCompileResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseDelimitedFrom(InputStream)"})
  void testJsCompileResponseParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsCompileResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseDelimitedFrom(InputStream)"})
  void testJsCompileResponseParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JsCompileResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(byte[])"})
  void testJsCompileResponseParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(ByteBuffer)"})
  void testJsCompileResponseParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testJsCompileResponseParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(byte[], ExtensionRegistryLite)"})
  void testJsCompileResponseParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(ByteString)"})
  void testJsCompileResponseParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getErrorDetailsBytes());
    assertEquals(byteString, actualParseFromResult.getScriptHashBytes());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(ByteString)"})
  void testJsCompileResponseParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getErrorDetailsBytes());
    assertEquals(byteString, actualParseFromResult.getScriptHashBytes());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testJsCompileResponseParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getErrorDetailsBytes());
    assertEquals(byteString, actualParseFromResult.getScriptHashBytes());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testJsCompileResponseParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getErrorDetailsBytes());
    assertEquals(byteString, actualParseFromResult.getScriptHashBytes());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testJsCompileResponseParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testJsCompileResponseParseFromWithCodedInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(CodedInputStream) with 'CodedInputStream'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(CodedInputStream)"})
  void testJsCompileResponseParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(CodedInputStream) with 'CodedInputStream'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(CodedInputStream)"})
  void testJsCompileResponseParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(InputStream)"})
  void testJsCompileResponseParseFromWithInputStream() throws IOException {
    // Arrange and Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(InputStream)"})
  void testJsCompileResponseParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsCompileResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileResponseParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileResponseParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsCompileResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsCompileResponseParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsCompileResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(InputStream)"})
  void testJsCompileResponseParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsCompileResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsCompileResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse JsCompileResponse.parseFrom(InputStream)"})
  void testJsCompileResponseParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JsCompileResponse actualParseFromResult = JsCompileResponse.parseFrom((InputStream) null);

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeErrorCode JsInvokeErrorCode.forNumber(int)"})
  void testJsInvokeErrorCodeForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JsInvokeErrorCode.forNumber(42));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code RUNTIME_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode forNumber(int); when one; then return 'RUNTIME_ERROR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeErrorCode JsInvokeErrorCode.forNumber(int)"})
  void testJsInvokeErrorCodeForNumber_whenOne_thenReturnRuntimeError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeErrorCode.RUNTIME_ERROR, JsInvokeErrorCode.forNumber(1));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code NOT_FOUND_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode forNumber(int); when three; then return 'NOT_FOUND_ERROR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeErrorCode JsInvokeErrorCode.forNumber(int)"})
  void testJsInvokeErrorCodeForNumber_whenThree_thenReturnNotFoundError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeErrorCode.NOT_FOUND_ERROR, JsInvokeErrorCode.forNumber(3));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code TIMEOUT_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode forNumber(int); when two; then return 'TIMEOUT_ERROR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeErrorCode JsInvokeErrorCode.forNumber(int)"})
  void testJsInvokeErrorCodeForNumber_whenTwo_thenReturnTimeoutError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeErrorCode.TIMEOUT_ERROR, JsInvokeErrorCode.forNumber(2));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code COMPILATION_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode forNumber(int); when zero; then return 'COMPILATION_ERROR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeErrorCode JsInvokeErrorCode.forNumber(int)"})
  void testJsInvokeErrorCodeForNumber_whenZero_thenReturnCompilationError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, JsInvokeErrorCode.forNumber(0));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#getDescriptor()}.
   * <p>
   * Method under test: {@link JsInvokeErrorCode#getDescriptor()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode getDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumDescriptor JsInvokeErrorCode.getDescriptor()"})
  void testJsInvokeErrorCodeGetDescriptor() {
    // Arrange and Act
    EnumDescriptor actualDescriptor = JsInvokeErrorCode.getDescriptor();

    // Assert
    assertEquals("JsInvokeErrorCode", actualDescriptor.getName());
    assertEquals("js.JsInvokeErrorCode", actualDescriptor.getFullName());
    assertNull(actualDescriptor.getContainingType());
    assertEquals(0, actualDescriptor.getIndex());
    assertEquals(4, actualDescriptor.getValues().size());
    assertFalse(actualDescriptor.isClosed());
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#getDescriptorForType()}.
   * <p>
   * Method under test: {@link JsInvokeErrorCode#getDescriptorForType()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode getDescriptorForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumDescriptor JsInvokeErrorCode.getDescriptorForType()"})
  void testJsInvokeErrorCodeGetDescriptorForType() {
    // Arrange and Act
    EnumDescriptor actualDescriptorForType = JsInvokeErrorCode.COMPILATION_ERROR.getDescriptorForType();

    // Assert
    assertEquals("JsInvokeErrorCode", actualDescriptorForType.getName());
    assertEquals("js.JsInvokeErrorCode", actualDescriptorForType.getFullName());
    assertNull(actualDescriptorForType.getContainingType());
    assertEquals(0, actualDescriptorForType.getIndex());
    assertEquals(4, actualDescriptorForType.getValues().size());
    assertFalse(actualDescriptorForType.isClosed());
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#getNumber()}.
   * <ul>
   *   <li>Given {@code COMPILATION_ERROR}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#getNumber()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode getNumber(); given 'COMPILATION_ERROR'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JsInvokeErrorCode.getNumber()"})
  void testJsInvokeErrorCodeGetNumber_givenCompilationError_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeErrorCode.COMPILATION_ERROR.getNumber());
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#getNumber()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#getNumber()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode getNumber(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JsInvokeErrorCode.getNumber()"})
  void testJsInvokeErrorCodeGetNumber_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsInvokeErrorCode.UNRECOGNIZED.getNumber());
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#getValueDescriptor()}.
   * <ul>
   *   <li>Then return Name is {@code COMPILATION_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode getValueDescriptor(); then return Name is 'COMPILATION_ERROR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor JsInvokeErrorCode.getValueDescriptor()"})
  void testJsInvokeErrorCodeGetValueDescriptor_thenReturnNameIsCompilationError() {
    // Arrange and Act
    EnumValueDescriptor actualValueDescriptor = JsInvokeErrorCode.COMPILATION_ERROR.getValueDescriptor();

    // Assert
    assertEquals("COMPILATION_ERROR", actualValueDescriptor.getName());
    assertEquals("js.JsInvokeErrorCode.COMPILATION_ERROR", actualValueDescriptor.getFullName());
    assertEquals(0, actualValueDescriptor.getIndex());
    assertEquals(0, actualValueDescriptor.getNumber());
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#getValueDescriptor()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode getValueDescriptor(); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.EnumValueDescriptor JsInvokeErrorCode.getValueDescriptor()"})
  void testJsInvokeErrorCodeGetValueDescriptor_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> JsInvokeErrorCode.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#internalGetValueMap()}.
   * <p>
   * Method under test: {@link JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JsInvokeErrorCode.internalGetValueMap()"})
  void testJsInvokeErrorCodeInternalGetValueMap() {
    // Arrange and Act
    EnumLiteMap<JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeErrorCode.internalGetValueMap();

    // Assert
    assertEquals(JsInvokeErrorCode.RUNTIME_ERROR, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#internalGetValueMap()}.
   * <p>
   * Method under test: {@link JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JsInvokeErrorCode.internalGetValueMap()"})
  void testJsInvokeErrorCodeInternalGetValueMap2() {
    // Arrange and Act
    EnumLiteMap<JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeErrorCode.internalGetValueMap();

    // Assert
    assertEquals(JsInvokeErrorCode.TIMEOUT_ERROR, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#internalGetValueMap()}.
   * <p>
   * Method under test: {@link JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JsInvokeErrorCode.internalGetValueMap()"})
  void testJsInvokeErrorCodeInternalGetValueMap3() {
    // Arrange and Act
    EnumLiteMap<JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeErrorCode.internalGetValueMap();

    // Assert
    assertEquals(JsInvokeErrorCode.NOT_FOUND_ERROR, actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#internalGetValueMap()}.
   * <p>
   * Method under test: {@link JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode internalGetValueMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JsInvokeErrorCode.internalGetValueMap()"})
  void testJsInvokeErrorCodeInternalGetValueMap4() {
    // Arrange and Act
    EnumLiteMap<JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeErrorCode.internalGetValueMap();

    // Assert
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber ten is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode internalGetValueMap(); then return findValueByNumber ten is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Internal.EnumLiteMap JsInvokeErrorCode.internalGetValueMap()"})
  void testJsInvokeErrorCodeInternalGetValueMap_thenReturnFindValueByNumberTenIsNull() {
    // Arrange and Act
    EnumLiteMap<JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeErrorCode.internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(10));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeErrorCode JsInvokeErrorCode.valueOf(int)"})
  void testJsInvokeErrorCodeValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JsInvokeErrorCode.valueOf(42));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code RUNTIME_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode valueOf(int) with 'value'; when one; then return 'RUNTIME_ERROR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeErrorCode JsInvokeErrorCode.valueOf(int)"})
  void testJsInvokeErrorCodeValueOfWithValue_whenOne_thenReturnRuntimeError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeErrorCode.RUNTIME_ERROR, JsInvokeErrorCode.valueOf(1));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code NOT_FOUND_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode valueOf(int) with 'value'; when three; then return 'NOT_FOUND_ERROR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeErrorCode JsInvokeErrorCode.valueOf(int)"})
  void testJsInvokeErrorCodeValueOfWithValue_whenThree_thenReturnNotFoundError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeErrorCode.NOT_FOUND_ERROR, JsInvokeErrorCode.valueOf(3));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code TIMEOUT_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode valueOf(int) with 'value'; when two; then return 'TIMEOUT_ERROR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeErrorCode JsInvokeErrorCode.valueOf(int)"})
  void testJsInvokeErrorCodeValueOfWithValue_whenTwo_thenReturnTimeoutError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeErrorCode.TIMEOUT_ERROR, JsInvokeErrorCode.valueOf(2));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code COMPILATION_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeErrorCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode valueOf(int) with 'value'; when zero; then return 'COMPILATION_ERROR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeErrorCode JsInvokeErrorCode.valueOf(int)"})
  void testJsInvokeErrorCodeValueOfWithValue_whenZero_thenReturnCompilationError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, JsInvokeErrorCode.valueOf(0));
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#equals(Object)}, and {@link JsInvokeRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeRequest#equals(Object)}
   *   <li>{@link JsInvokeRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsInvokeRequest equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsInvokeRequest.equals(Object)", "int JsInvokeRequest.hashCode()"})
  void testJsInvokeRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsInvokeRequest defaultInstance = JsInvokeRequest.getDefaultInstance();
    JsInvokeRequest defaultInstance2 = JsInvokeRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#equals(Object)}, and {@link JsInvokeRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeRequest#equals(Object)}
   *   <li>{@link JsInvokeRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsInvokeRequest equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsInvokeRequest.equals(Object)", "int JsInvokeRequest.hashCode()"})
  void testJsInvokeRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeRequest defaultInstance = JsInvokeRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsInvokeRequest.equals(Object)", "int JsInvokeRequest.hashCode()"})
  void testJsInvokeRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeRequest.getDefaultInstance(), 1);
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsInvokeRequest.equals(Object)", "int JsInvokeRequest.hashCode()"})
  void testJsInvokeRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeRequest.getDefaultInstance(), null);
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsInvokeRequest.equals(Object)", "int JsInvokeRequest.hashCode()"})
  void testJsInvokeRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeRequest.getDefaultInstance(), "Different type to JsInvokeRequest");
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getArgsCount()}.
   * <p>
   * Method under test: {@link JsInvokeRequest#getArgsCount()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getArgsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JsInvokeRequest.getArgsCount()"})
  void testJsInvokeRequestGetArgsCount() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeRequest.getDefaultInstance().getArgsCount());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getArgsList()}.
   * <p>
   * Method under test: {@link JsInvokeRequest#getArgsList()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getArgsList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtocolStringList JsInvokeRequest.getArgsList()"})
  void testJsInvokeRequestGetArgsList() {
    // Arrange
    JsInvokeRequest defaultInstance = JsInvokeRequest.getDefaultInstance();

    // Act
    ProtocolStringList actualArgsList = defaultInstance.getArgsList();

    // Assert
    assertTrue(actualArgsList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualArgsList).EMPTY;
    Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    DescriptorProto toProtoResult = descriptorForType.toProto();
    assertSame(lazyStringList, toProtoResult.getDefaultInstanceForType().getReservedNameList());
    assertSame(lazyStringList, toProtoResult.getReservedNameList());
    assertSame(lazyStringList, descriptorForType.getFile().toProto().getDependencyList());
    assertSame(lazyStringList, actualArgsList);
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link JsInvokeRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.getDefaultInstanceForType()"})
  void testJsInvokeRequestGetDefaultInstanceForType() {
    // Arrange
    JsInvokeRequest defaultInstance = JsInvokeRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getFunctionName()}.
   * <p>
   * Method under test: {@link JsInvokeRequest#getFunctionName()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getFunctionName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JsInvokeRequest.getFunctionName()"})
  void testJsInvokeRequestGetFunctionName() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeRequest.getDefaultInstance().getFunctionName());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getFunctionNameBytes()}.
   * <p>
   * Method under test: {@link JsInvokeRequest#getFunctionNameBytes()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getFunctionNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString JsInvokeRequest.getFunctionNameBytes()"})
  void testJsInvokeRequestGetFunctionNameBytes() {
    // Arrange
    JsInvokeRequest defaultInstance = JsInvokeRequest.getDefaultInstance();

    // Act
    ByteString actualFunctionNameBytes = defaultInstance.getFunctionNameBytes();

    // Assert
    ByteString byteString = actualFunctionNameBytes.EMPTY;
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
    assertEquals(byteString, actualFunctionNameBytes);
    assertEquals(byteString, defaultInstance.getScriptBodyBytes());
    assertEquals(byteString, defaultInstance.getScriptHashBytes());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getScriptBody()}.
   * <p>
   * Method under test: {@link JsInvokeRequest#getScriptBody()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getScriptBody()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JsInvokeRequest.getScriptBody()"})
  void testJsInvokeRequestGetScriptBody() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeRequest.getDefaultInstance().getScriptBody());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getScriptBodyBytes()}.
   * <p>
   * Method under test: {@link JsInvokeRequest#getScriptBodyBytes()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getScriptBodyBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString JsInvokeRequest.getScriptBodyBytes()"})
  void testJsInvokeRequestGetScriptBodyBytes() {
    // Arrange
    JsInvokeRequest defaultInstance = JsInvokeRequest.getDefaultInstance();

    // Act
    ByteString actualScriptBodyBytes = defaultInstance.getScriptBodyBytes();

    // Assert
    ByteString byteString = actualScriptBodyBytes.EMPTY;
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
    assertEquals(byteString, defaultInstance.getFunctionNameBytes());
    assertEquals(byteString, actualScriptBodyBytes);
    assertEquals(byteString, defaultInstance.getScriptHashBytes());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getScriptHash()}.
   * <p>
   * Method under test: {@link JsInvokeRequest#getScriptHash()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getScriptHash()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JsInvokeRequest.getScriptHash()"})
  void testJsInvokeRequestGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeRequest.getDefaultInstance().getScriptHash());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getScriptHashBytes()}.
   * <p>
   * Method under test: {@link JsInvokeRequest#getScriptHashBytes()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getScriptHashBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString JsInvokeRequest.getScriptHashBytes()"})
  void testJsInvokeRequestGetScriptHashBytes() {
    // Arrange
    JsInvokeRequest defaultInstance = JsInvokeRequest.getDefaultInstance();

    // Act
    ByteString actualScriptHashBytes = defaultInstance.getScriptHashBytes();

    // Assert
    ByteString byteString = actualScriptHashBytes.EMPTY;
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
    assertEquals(byteString, defaultInstance.getFunctionNameBytes());
    assertEquals(byteString, defaultInstance.getScriptBodyBytes());
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getSerializedSize()}.
   * <p>
   * Method under test: {@link JsInvokeRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JsInvokeRequest.getSerializedSize()"})
  void testJsInvokeRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#isInitialized()}.
   * <p>
   * Method under test: {@link JsInvokeRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsInvokeRequest.isInitialized()"})
  void testJsInvokeRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseDelimitedFrom(InputStream)"})
  void testJsInvokeRequestParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsInvokeRequest actualParseDelimitedFromResult = JsInvokeRequest.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getFunctionName());
    assertEquals("", actualParseDelimitedFromResult.getScriptBody());
    assertEquals("", actualParseDelimitedFromResult.getScriptHash());
    assertEquals(0, actualParseDelimitedFromResult.getArgsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getTimeout());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getArgsList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseDelimitedFrom(InputStream)"})
  void testJsInvokeRequestParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeRequestParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsInvokeRequest actualParseDelimitedFromResult = JsInvokeRequest.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getFunctionName());
    assertEquals("", actualParseDelimitedFromResult.getScriptBody());
    assertEquals("", actualParseDelimitedFromResult.getScriptHash());
    assertEquals(0, actualParseDelimitedFromResult.getArgsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getTimeout());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getArgsList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeRequestParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeRequestParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeRequestParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JsInvokeRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeRequestParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseDelimitedFrom(InputStream)"})
  void testJsInvokeRequestParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseDelimitedFrom(InputStream)"})
  void testJsInvokeRequestParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseDelimitedFrom(InputStream)"})
  void testJsInvokeRequestParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsInvokeRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(byte[])"})
  void testJsInvokeRequestParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getArgsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTimeout());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getArgsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(ByteBuffer)"})
  void testJsInvokeRequestParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getArgsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTimeout());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getArgsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testJsInvokeRequestParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getArgsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTimeout());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getArgsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(byte[], ExtensionRegistryLite)"})
  void testJsInvokeRequestParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getArgsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTimeout());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getArgsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(ByteString)"})
  void testJsInvokeRequestParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getArgsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTimeout());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getArgsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getFunctionNameBytes());
    assertEquals(byteString, actualParseFromResult.getScriptBodyBytes());
    assertEquals(byteString, actualParseFromResult.getScriptHashBytes());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(ByteString)"})
  void testJsInvokeRequestParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getArgsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTimeout());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getArgsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getFunctionNameBytes());
    assertEquals(byteString, actualParseFromResult.getScriptBodyBytes());
    assertEquals(byteString, actualParseFromResult.getScriptHashBytes());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testJsInvokeRequestParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getArgsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTimeout());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getArgsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getFunctionNameBytes());
    assertEquals(byteString, actualParseFromResult.getScriptBodyBytes());
    assertEquals(byteString, actualParseFromResult.getScriptHashBytes());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testJsInvokeRequestParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getArgsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTimeout());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getArgsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getFunctionNameBytes());
    assertEquals(byteString, actualParseFromResult.getScriptBodyBytes());
    assertEquals(byteString, actualParseFromResult.getScriptHashBytes());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testJsInvokeRequestParseFromWithCodedInputStreamExtensionRegistryLite_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getArgsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTimeout());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getArgsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testJsInvokeRequestParseFromWithCodedInputStreamExtensionRegistryLite_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getArgsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTimeout());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getArgsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(CodedInputStream) with 'CodedInputStream'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(CodedInputStream)"})
  void testJsInvokeRequestParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getArgsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTimeout());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getArgsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(CodedInputStream) with 'CodedInputStream'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(CodedInputStream)"})
  void testJsInvokeRequestParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getArgsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTimeout());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getArgsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(InputStream)"})
  void testJsInvokeRequestParseFromWithInputStream() throws IOException {
    // Arrange and Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(InputStream)"})
  void testJsInvokeRequestParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeRequestParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptBody());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getArgsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTimeout());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getArgsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeRequestParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeRequestParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(InputStream)"})
  void testJsInvokeRequestParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest JsInvokeRequest.parseFrom(InputStream)"})
  void testJsInvokeRequestParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JsInvokeRequest actualParseFromResult = JsInvokeRequest.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#equals(Object)}, and {@link JsInvokeResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeResponse#equals(Object)}
   *   <li>{@link JsInvokeResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsInvokeResponse equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsInvokeResponse.equals(Object)", "int JsInvokeResponse.hashCode()"})
  void testJsInvokeResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsInvokeResponse defaultInstance = JsInvokeResponse.getDefaultInstance();
    JsInvokeResponse defaultInstance2 = JsInvokeResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#equals(Object)}, and {@link JsInvokeResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeResponse#equals(Object)}
   *   <li>{@link JsInvokeResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsInvokeResponse equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsInvokeResponse.equals(Object)", "int JsInvokeResponse.hashCode()"})
  void testJsInvokeResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeResponse defaultInstance = JsInvokeResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsInvokeResponse.equals(Object)", "int JsInvokeResponse.hashCode()"})
  void testJsInvokeResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeResponse.getDefaultInstance(), 1);
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsInvokeResponse.equals(Object)", "int JsInvokeResponse.hashCode()"})
  void testJsInvokeResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeResponse.getDefaultInstance(), null);
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsInvokeResponse.equals(Object)", "int JsInvokeResponse.hashCode()"})
  void testJsInvokeResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeResponse.getDefaultInstance(), "Different type to JsInvokeResponse");
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link JsInvokeResponse#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.getDefaultInstanceForType()"})
  void testJsInvokeResponseGetDefaultInstanceForType() {
    // Arrange
    JsInvokeResponse defaultInstance = JsInvokeResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#getErrorCode()}.
   * <p>
   * Method under test: {@link JsInvokeResponse#getErrorCode()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse getErrorCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeErrorCode JsInvokeResponse.getErrorCode()"})
  void testJsInvokeResponseGetErrorCode() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, JsInvokeResponse.getDefaultInstance().getErrorCode());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#getErrorDetails()}.
   * <p>
   * Method under test: {@link JsInvokeResponse#getErrorDetails()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse getErrorDetails()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JsInvokeResponse.getErrorDetails()"})
  void testJsInvokeResponseGetErrorDetails() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeResponse.getDefaultInstance().getErrorDetails());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#getErrorDetailsBytes()}.
   * <p>
   * Method under test: {@link JsInvokeResponse#getErrorDetailsBytes()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse getErrorDetailsBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString JsInvokeResponse.getErrorDetailsBytes()"})
  void testJsInvokeResponseGetErrorDetailsBytes() {
    // Arrange
    JsInvokeResponse defaultInstance = JsInvokeResponse.getDefaultInstance();

    // Act
    ByteString actualErrorDetailsBytes = defaultInstance.getErrorDetailsBytes();

    // Assert
    ByteString byteString = actualErrorDetailsBytes.EMPTY;
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
    assertEquals(byteString, actualErrorDetailsBytes);
    assertEquals(byteString, defaultInstance.getResultBytes());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#getResult()}.
   * <p>
   * Method under test: {@link JsInvokeResponse#getResult()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse getResult()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JsInvokeResponse.getResult()"})
  void testJsInvokeResponseGetResult() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeResponse.getDefaultInstance().getResult());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#getResultBytes()}.
   * <p>
   * Method under test: {@link JsInvokeResponse#getResultBytes()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse getResultBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString JsInvokeResponse.getResultBytes()"})
  void testJsInvokeResponseGetResultBytes() {
    // Arrange
    JsInvokeResponse defaultInstance = JsInvokeResponse.getDefaultInstance();

    // Act
    ByteString actualResultBytes = defaultInstance.getResultBytes();

    // Assert
    ByteString byteString = actualResultBytes.EMPTY;
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
    assertEquals(byteString, defaultInstance.getErrorDetailsBytes());
    assertEquals(byteString, actualResultBytes);
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#getSerializedSize()}.
   * <p>
   * Method under test: {@link JsInvokeResponse#getSerializedSize()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JsInvokeResponse.getSerializedSize()"})
  void testJsInvokeResponseGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#isInitialized()}.
   * <p>
   * Method under test: {@link JsInvokeResponse#isInitialized()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsInvokeResponse.isInitialized()"})
  void testJsInvokeResponseIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseDelimitedFrom(InputStream)"})
  void testJsInvokeResponseParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsInvokeResponse actualParseDelimitedFromResult = JsInvokeResponse.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getErrorDetails());
    assertEquals("", actualParseDelimitedFromResult.getResult());
    assertEquals(0, actualParseDelimitedFromResult.getErrorCodeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseDelimitedFromResult.getErrorCode());
    assertFalse(actualParseDelimitedFromResult.getSuccess());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseDelimitedFrom(InputStream)"})
  void testJsInvokeResponseParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseDelimitedFrom(InputStream)"})
  void testJsInvokeResponseParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsInvokeResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeResponseParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsInvokeResponse actualParseDelimitedFromResult = JsInvokeResponse.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getErrorDetails());
    assertEquals("", actualParseDelimitedFromResult.getResult());
    assertEquals(0, actualParseDelimitedFromResult.getErrorCodeValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseDelimitedFromResult.getErrorCode());
    assertFalse(actualParseDelimitedFromResult.getSuccess());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeResponseParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeResponseParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeResponseParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JsInvokeResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeResponseParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseDelimitedFrom(InputStream)"})
  void testJsInvokeResponseParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseDelimitedFrom(InputStream)"})
  void testJsInvokeResponseParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(byte[])"})
  void testJsInvokeResponseParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getResult());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(ByteBuffer)"})
  void testJsInvokeResponseParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getResult());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testJsInvokeResponseParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getResult());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(byte[], ExtensionRegistryLite)"})
  void testJsInvokeResponseParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getResult());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(ByteString)"})
  void testJsInvokeResponseParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getResult());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getErrorDetailsBytes());
    assertEquals(byteString, actualParseFromResult.getResultBytes());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(ByteString)"})
  void testJsInvokeResponseParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getResult());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getErrorDetailsBytes());
    assertEquals(byteString, actualParseFromResult.getResultBytes());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testJsInvokeResponseParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getResult());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getErrorDetailsBytes());
    assertEquals(byteString, actualParseFromResult.getResultBytes());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testJsInvokeResponseParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getResult());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getErrorDetailsBytes());
    assertEquals(byteString, actualParseFromResult.getResultBytes());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testJsInvokeResponseParseFromWithCodedInputStreamExtensionRegistryLite_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getResult());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testJsInvokeResponseParseFromWithCodedInputStreamExtensionRegistryLite_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getResult());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(CodedInputStream) with 'CodedInputStream'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(CodedInputStream)"})
  void testJsInvokeResponseParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getResult());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(CodedInputStream) with 'CodedInputStream'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(CodedInputStream)"})
  void testJsInvokeResponseParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getResult());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(InputStream)"})
  void testJsInvokeResponseParseFromWithInputStream() throws IOException {
    // Arrange and Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(InputStream)"})
  void testJsInvokeResponseParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeResponseParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getErrorDetails());
    assertEquals("", actualParseFromResult.getResult());
    assertEquals(0, actualParseFromResult.getErrorCodeValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualParseFromResult.getErrorCode());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeResponseParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsInvokeResponseParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(InputStream)"})
  void testJsInvokeResponseParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse JsInvokeResponse.parseFrom(InputStream)"})
  void testJsInvokeResponseParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JsInvokeResponse actualParseFromResult = JsInvokeResponse.parseFrom((InputStream) null);

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#equals(Object)}, and {@link JsReleaseRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsReleaseRequest#equals(Object)}
   *   <li>{@link JsReleaseRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsReleaseRequest equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsReleaseRequest.equals(Object)", "int JsReleaseRequest.hashCode()"})
  void testJsReleaseRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsReleaseRequest defaultInstance = JsReleaseRequest.getDefaultInstance();
    JsReleaseRequest defaultInstance2 = JsReleaseRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#equals(Object)}, and {@link JsReleaseRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsReleaseRequest#equals(Object)}
   *   <li>{@link JsReleaseRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsReleaseRequest equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsReleaseRequest.equals(Object)", "int JsReleaseRequest.hashCode()"})
  void testJsReleaseRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsReleaseRequest defaultInstance = JsReleaseRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsReleaseRequest.equals(Object)", "int JsReleaseRequest.hashCode()"})
  void testJsReleaseRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsReleaseRequest.getDefaultInstance(), 1);
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsReleaseRequest.equals(Object)", "int JsReleaseRequest.hashCode()"})
  void testJsReleaseRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsReleaseRequest.getDefaultInstance(), null);
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsReleaseRequest.equals(Object)", "int JsReleaseRequest.hashCode()"})
  void testJsReleaseRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsReleaseRequest.getDefaultInstance(), "Different type to JsReleaseRequest");
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link JsReleaseRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test JsReleaseRequest getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.getDefaultInstanceForType()"})
  void testJsReleaseRequestGetDefaultInstanceForType() {
    // Arrange
    JsReleaseRequest defaultInstance = JsReleaseRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#getFunctionName()}.
   * <p>
   * Method under test: {@link JsReleaseRequest#getFunctionName()}
   */
  @Test
  @DisplayName("Test JsReleaseRequest getFunctionName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JsReleaseRequest.getFunctionName()"})
  void testJsReleaseRequestGetFunctionName() {
    // Arrange, Act and Assert
    assertEquals("", JsReleaseRequest.getDefaultInstance().getFunctionName());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#getFunctionNameBytes()}.
   * <p>
   * Method under test: {@link JsReleaseRequest#getFunctionNameBytes()}
   */
  @Test
  @DisplayName("Test JsReleaseRequest getFunctionNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString JsReleaseRequest.getFunctionNameBytes()"})
  void testJsReleaseRequestGetFunctionNameBytes() {
    // Arrange
    JsReleaseRequest defaultInstance = JsReleaseRequest.getDefaultInstance();

    // Act
    ByteString actualFunctionNameBytes = defaultInstance.getFunctionNameBytes();

    // Assert
    ByteString byteString = actualFunctionNameBytes.EMPTY;
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
    assertEquals(byteString, actualFunctionNameBytes);
    assertEquals(byteString, defaultInstance.getScriptHashBytes());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#getScriptHash()}.
   * <p>
   * Method under test: {@link JsReleaseRequest#getScriptHash()}
   */
  @Test
  @DisplayName("Test JsReleaseRequest getScriptHash()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JsReleaseRequest.getScriptHash()"})
  void testJsReleaseRequestGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsReleaseRequest.getDefaultInstance().getScriptHash());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#getScriptHashBytes()}.
   * <p>
   * Method under test: {@link JsReleaseRequest#getScriptHashBytes()}
   */
  @Test
  @DisplayName("Test JsReleaseRequest getScriptHashBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString JsReleaseRequest.getScriptHashBytes()"})
  void testJsReleaseRequestGetScriptHashBytes() {
    // Arrange
    JsReleaseRequest defaultInstance = JsReleaseRequest.getDefaultInstance();

    // Act
    ByteString actualScriptHashBytes = defaultInstance.getScriptHashBytes();

    // Assert
    ByteString byteString = actualScriptHashBytes.EMPTY;
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
    assertEquals(byteString, defaultInstance.getFunctionNameBytes());
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#getSerializedSize()}.
   * <p>
   * Method under test: {@link JsReleaseRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test JsReleaseRequest getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JsReleaseRequest.getSerializedSize()"})
  void testJsReleaseRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsReleaseRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#isInitialized()}.
   * <p>
   * Method under test: {@link JsReleaseRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test JsReleaseRequest isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsReleaseRequest.isInitialized()"})
  void testJsReleaseRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsReleaseRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseDelimitedFrom(InputStream)"})
  void testJsReleaseRequestParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsReleaseRequest actualParseDelimitedFromResult = JsReleaseRequest.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getFunctionName());
    assertEquals("", actualParseDelimitedFromResult.getScriptHash());
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
   * Test JsReleaseRequest {@link JsReleaseRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseDelimitedFrom(InputStream)"})
  void testJsReleaseRequestParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsReleaseRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseDelimitedFrom(InputStream)"})
  void testJsReleaseRequestParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsReleaseRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseRequestParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsReleaseRequest actualParseDelimitedFromResult = JsReleaseRequest.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getFunctionName());
    assertEquals("", actualParseDelimitedFromResult.getScriptHash());
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
   * Test JsReleaseRequest {@link JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseRequestParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsReleaseRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseRequestParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsReleaseRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseRequestParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JsReleaseRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseRequestParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsReleaseRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseDelimitedFrom(InputStream)"})
  void testJsReleaseRequestParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsReleaseRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseDelimitedFrom(InputStream)"})
  void testJsReleaseRequestParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JsReleaseRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(byte[])"})
  void testJsReleaseRequestParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsReleaseRequest actualParseFromResult = JsReleaseRequest.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(ByteBuffer)"})
  void testJsReleaseRequestParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsReleaseRequest actualParseFromResult = JsReleaseRequest.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testJsReleaseRequestParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    JsReleaseRequest actualParseFromResult = JsReleaseRequest.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(byte[], ExtensionRegistryLite)"})
  void testJsReleaseRequestParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsReleaseRequest actualParseFromResult = JsReleaseRequest.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(ByteString)"})
  void testJsReleaseRequestParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsReleaseRequest actualParseFromResult = JsReleaseRequest.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getFunctionNameBytes());
    assertEquals(byteString, actualParseFromResult.getScriptHashBytes());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testJsReleaseRequestParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsReleaseRequest actualParseFromResult = JsReleaseRequest.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getFunctionNameBytes());
    assertEquals(byteString, actualParseFromResult.getScriptHashBytes());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(CodedInputStream)"})
  void testJsReleaseRequestParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JsReleaseRequest actualParseFromResult = JsReleaseRequest.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testJsReleaseRequestParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JsReleaseRequest actualParseFromResult = JsReleaseRequest.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(InputStream)"})
  void testJsReleaseRequestParseFromWithInputStream() throws IOException {
    // Arrange and Act
    JsReleaseRequest actualParseFromResult = JsReleaseRequest.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(InputStream)"})
  void testJsReleaseRequestParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsReleaseRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseRequestParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    JsReleaseRequest actualParseFromResult = JsReleaseRequest.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getFunctionName());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseRequestParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsReleaseRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseRequestParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsReleaseRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(InputStream)"})
  void testJsReleaseRequestParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsReleaseRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest JsReleaseRequest.parseFrom(InputStream)"})
  void testJsReleaseRequestParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JsReleaseRequest actualParseFromResult = JsReleaseRequest.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#equals(Object)}, and {@link JsReleaseResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsReleaseResponse#equals(Object)}
   *   <li>{@link JsReleaseResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsReleaseResponse equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsReleaseResponse.equals(Object)", "int JsReleaseResponse.hashCode()"})
  void testJsReleaseResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsReleaseResponse defaultInstance = JsReleaseResponse.getDefaultInstance();
    JsReleaseResponse defaultInstance2 = JsReleaseResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#equals(Object)}, and {@link JsReleaseResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsReleaseResponse#equals(Object)}
   *   <li>{@link JsReleaseResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsReleaseResponse equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsReleaseResponse.equals(Object)", "int JsReleaseResponse.hashCode()"})
  void testJsReleaseResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsReleaseResponse defaultInstance = JsReleaseResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsReleaseResponse.equals(Object)", "int JsReleaseResponse.hashCode()"})
  void testJsReleaseResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsReleaseResponse.getDefaultInstance(), 1);
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsReleaseResponse.equals(Object)", "int JsReleaseResponse.hashCode()"})
  void testJsReleaseResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsReleaseResponse.getDefaultInstance(), null);
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsReleaseResponse.equals(Object)", "int JsReleaseResponse.hashCode()"})
  void testJsReleaseResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsReleaseResponse.getDefaultInstance(), "Different type to JsReleaseResponse");
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link JsReleaseResponse#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test JsReleaseResponse getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.getDefaultInstanceForType()"})
  void testJsReleaseResponseGetDefaultInstanceForType() {
    // Arrange
    JsReleaseResponse defaultInstance = JsReleaseResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#getScriptHash()}.
   * <p>
   * Method under test: {@link JsReleaseResponse#getScriptHash()}
   */
  @Test
  @DisplayName("Test JsReleaseResponse getScriptHash()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String JsReleaseResponse.getScriptHash()"})
  void testJsReleaseResponseGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsReleaseResponse.getDefaultInstance().getScriptHash());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#getScriptHashBytes()}.
   * <p>
   * Method under test: {@link JsReleaseResponse#getScriptHashBytes()}
   */
  @Test
  @DisplayName("Test JsReleaseResponse getScriptHashBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString JsReleaseResponse.getScriptHashBytes()"})
  void testJsReleaseResponseGetScriptHashBytes() {
    // Arrange
    JsReleaseResponse defaultInstance = JsReleaseResponse.getDefaultInstance();

    // Act
    ByteString actualScriptHashBytes = defaultInstance.getScriptHashBytes();

    // Assert
    ByteString byteString = actualScriptHashBytes.EMPTY;
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
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#getSerializedSize()}.
   * <p>
   * Method under test: {@link JsReleaseResponse#getSerializedSize()}
   */
  @Test
  @DisplayName("Test JsReleaseResponse getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int JsReleaseResponse.getSerializedSize()"})
  void testJsReleaseResponseGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsReleaseResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#isInitialized()}.
   * <p>
   * Method under test: {@link JsReleaseResponse#isInitialized()}
   */
  @Test
  @DisplayName("Test JsReleaseResponse isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JsReleaseResponse.isInitialized()"})
  void testJsReleaseResponseIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsReleaseResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseDelimitedFrom(InputStream)"})
  void testJsReleaseResponseParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsReleaseResponse actualParseDelimitedFromResult = JsReleaseResponse.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getScriptHash());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertFalse(actualParseDelimitedFromResult.getSuccess());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseDelimitedFrom(InputStream)"})
  void testJsReleaseResponseParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsReleaseResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseDelimitedFrom(InputStream)"})
  void testJsReleaseResponseParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsReleaseResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseResponseParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsReleaseResponse actualParseDelimitedFromResult = JsReleaseResponse.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getScriptHash());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertFalse(actualParseDelimitedFromResult.getSuccess());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseResponseParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsReleaseResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseResponseParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsReleaseResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseResponseParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JsReleaseResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseResponseParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsReleaseResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseDelimitedFrom(InputStream)"})
  void testJsReleaseResponseParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsReleaseResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseDelimitedFrom(InputStream)"})
  void testJsReleaseResponseParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> JsReleaseResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(byte[])"})
  void testJsReleaseResponseParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsReleaseResponse actualParseFromResult = JsReleaseResponse.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(ByteBuffer)"})
  void testJsReleaseResponseParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsReleaseResponse actualParseFromResult = JsReleaseResponse.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testJsReleaseResponseParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    JsReleaseResponse actualParseFromResult = JsReleaseResponse.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(byte[], ExtensionRegistryLite)"})
  void testJsReleaseResponseParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    JsReleaseResponse actualParseFromResult = JsReleaseResponse.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(ByteString)"})
  void testJsReleaseResponseParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsReleaseResponse actualParseFromResult = JsReleaseResponse.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedScriptHashBytes = data.EMPTY;
    assertEquals(expectedScriptHashBytes, actualParseFromResult.getScriptHashBytes());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testJsReleaseResponseParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    JsReleaseResponse actualParseFromResult = JsReleaseResponse.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedScriptHashBytes = data.EMPTY;
    assertEquals(expectedScriptHashBytes, actualParseFromResult.getScriptHashBytes());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(CodedInputStream)"})
  void testJsReleaseResponseParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JsReleaseResponse actualParseFromResult = JsReleaseResponse.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testJsReleaseResponseParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    JsReleaseResponse actualParseFromResult = JsReleaseResponse.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(InputStream)"})
  void testJsReleaseResponseParseFromWithInputStream() throws IOException {
    // Arrange and Act
    JsReleaseResponse actualParseFromResult = JsReleaseResponse.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(InputStream)"})
  void testJsReleaseResponseParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsReleaseResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseResponseParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    JsReleaseResponse actualParseFromResult = JsReleaseResponse.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getScriptHash());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getSuccess());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseResponseParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsReleaseResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testJsReleaseResponseParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsReleaseResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(InputStream)"})
  void testJsReleaseResponseParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsReleaseResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsReleaseResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse JsReleaseResponse.parseFrom(InputStream)"})
  void testJsReleaseResponseParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JsReleaseResponse actualParseFromResult = JsReleaseResponse.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#equals(Object)}, and {@link RemoteJsRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RemoteJsRequest#equals(Object)}
   *   <li>{@link RemoteJsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test RemoteJsRequest equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsRequest.equals(Object)", "int RemoteJsRequest.hashCode()"})
  void testRemoteJsRequestEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RemoteJsRequest defaultInstance = RemoteJsRequest.getDefaultInstance();
    RemoteJsRequest defaultInstance2 = RemoteJsRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#equals(Object)}, and {@link RemoteJsRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RemoteJsRequest#equals(Object)}
   *   <li>{@link RemoteJsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test RemoteJsRequest equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsRequest.equals(Object)", "int RemoteJsRequest.hashCode()"})
  void testRemoteJsRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RemoteJsRequest defaultInstance = RemoteJsRequest.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsRequest.equals(Object)", "int RemoteJsRequest.hashCode()"})
  void testRemoteJsRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RemoteJsRequest.getDefaultInstance(), 1);
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsRequest.equals(Object)", "int RemoteJsRequest.hashCode()"})
  void testRemoteJsRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RemoteJsRequest.getDefaultInstance(), null);
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsRequest.equals(Object)", "int RemoteJsRequest.hashCode()"})
  void testRemoteJsRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RemoteJsRequest.getDefaultInstance(), "Different type to RemoteJsRequest");
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#getCompileRequest()}.
   * <p>
   * Method under test: {@link RemoteJsRequest#getCompileRequest()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest getCompileRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileRequest RemoteJsRequest.getCompileRequest()"})
  void testRemoteJsRequestGetCompileRequest() {
    // Arrange and Act
    JsCompileRequest actualCompileRequest = RemoteJsRequest.getDefaultInstance().getCompileRequest();

    // Assert
    assertEquals("", actualCompileRequest.getInitializationErrorString());
    assertEquals("", actualCompileRequest.getFunctionName());
    assertEquals("", actualCompileRequest.getScriptBody());
    assertEquals("", actualCompileRequest.getScriptHash());
    assertEquals(0, actualCompileRequest.getSerializedSize());
    assertTrue(actualCompileRequest.findInitializationErrors().isEmpty());
    assertTrue(actualCompileRequest.getAllFields().isEmpty());
    assertTrue(actualCompileRequest.isInitialized());
    assertSame(actualCompileRequest, actualCompileRequest.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link RemoteJsRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.getDefaultInstanceForType()"})
  void testRemoteJsRequestGetDefaultInstanceForType() {
    // Arrange
    RemoteJsRequest defaultInstance = RemoteJsRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#getInvokeRequest()}.
   * <p>
   * Method under test: {@link RemoteJsRequest#getInvokeRequest()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest getInvokeRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeRequest RemoteJsRequest.getInvokeRequest()"})
  void testRemoteJsRequestGetInvokeRequest() {
    // Arrange and Act
    JsInvokeRequest actualInvokeRequest = RemoteJsRequest.getDefaultInstance().getInvokeRequest();

    // Assert
    assertEquals("", actualInvokeRequest.getInitializationErrorString());
    assertEquals("", actualInvokeRequest.getFunctionName());
    assertEquals("", actualInvokeRequest.getScriptBody());
    assertEquals("", actualInvokeRequest.getScriptHash());
    assertEquals(0, actualInvokeRequest.getArgsCount());
    assertEquals(0, actualInvokeRequest.getSerializedSize());
    assertEquals(0, actualInvokeRequest.getTimeout());
    assertTrue(actualInvokeRequest.findInitializationErrors().isEmpty());
    assertTrue(actualInvokeRequest.getArgsList().isEmpty());
    assertTrue(actualInvokeRequest.getAllFields().isEmpty());
    assertTrue(actualInvokeRequest.isInitialized());
    assertSame(actualInvokeRequest, actualInvokeRequest.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#getReleaseRequest()}.
   * <p>
   * Method under test: {@link RemoteJsRequest#getReleaseRequest()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest getReleaseRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseRequest RemoteJsRequest.getReleaseRequest()"})
  void testRemoteJsRequestGetReleaseRequest() {
    // Arrange and Act
    JsReleaseRequest actualReleaseRequest = RemoteJsRequest.getDefaultInstance().getReleaseRequest();

    // Assert
    assertEquals("", actualReleaseRequest.getInitializationErrorString());
    assertEquals("", actualReleaseRequest.getFunctionName());
    assertEquals("", actualReleaseRequest.getScriptHash());
    assertEquals(0, actualReleaseRequest.getSerializedSize());
    assertTrue(actualReleaseRequest.findInitializationErrors().isEmpty());
    assertTrue(actualReleaseRequest.getAllFields().isEmpty());
    assertTrue(actualReleaseRequest.isInitialized());
    assertSame(actualReleaseRequest, actualReleaseRequest.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#getSerializedSize()}.
   * <p>
   * Method under test: {@link RemoteJsRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RemoteJsRequest.getSerializedSize()"})
  void testRemoteJsRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RemoteJsRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#hasCompileRequest()}.
   * <p>
   * Method under test: {@link RemoteJsRequest#hasCompileRequest()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest hasCompileRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsRequest.hasCompileRequest()"})
  void testRemoteJsRequestHasCompileRequest() {
    // Arrange, Act and Assert
    assertFalse(RemoteJsRequest.getDefaultInstance().hasCompileRequest());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#hasInvokeRequest()}.
   * <p>
   * Method under test: {@link RemoteJsRequest#hasInvokeRequest()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest hasInvokeRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsRequest.hasInvokeRequest()"})
  void testRemoteJsRequestHasInvokeRequest() {
    // Arrange, Act and Assert
    assertFalse(RemoteJsRequest.getDefaultInstance().hasInvokeRequest());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#hasReleaseRequest()}.
   * <p>
   * Method under test: {@link RemoteJsRequest#hasReleaseRequest()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest hasReleaseRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsRequest.hasReleaseRequest()"})
  void testRemoteJsRequestHasReleaseRequest() {
    // Arrange, Act and Assert
    assertFalse(RemoteJsRequest.getDefaultInstance().hasReleaseRequest());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#isInitialized()}.
   * <p>
   * Method under test: {@link RemoteJsRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsRequest.isInitialized()"})
  void testRemoteJsRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RemoteJsRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseDelimitedFrom(InputStream)"})
  void testRemoteJsRequestParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RemoteJsRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsRequestParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        RemoteJsRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsRequestParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RemoteJsRequest actualParseDelimitedFromResult = RemoteJsRequest.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsRequestParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> RemoteJsRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsRequestParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RemoteJsRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsRequestParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RemoteJsRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseDelimitedFrom(InputStream)"})
  void testRemoteJsRequestParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RemoteJsRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseDelimitedFrom(InputStream)"})
  void testRemoteJsRequestParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, RemoteJsRequest.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseDelimitedFrom(InputStream)"})
  void testRemoteJsRequestParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RemoteJsRequest actualParseDelimitedFromResult = RemoteJsRequest.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseDelimitedFrom(InputStream)"})
  void testRemoteJsRequestParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> RemoteJsRequest.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(byte[])"})
  void testRemoteJsRequestParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    RemoteJsRequest actualParseFromResult = RemoteJsRequest.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasCompileRequest());
    assertFalse(actualParseFromResult.hasInvokeRequest());
    assertFalse(actualParseFromResult.hasReleaseRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(ByteBuffer)"})
  void testRemoteJsRequestParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    RemoteJsRequest actualParseFromResult = RemoteJsRequest.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasCompileRequest());
    assertFalse(actualParseFromResult.hasInvokeRequest());
    assertFalse(actualParseFromResult.hasReleaseRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testRemoteJsRequestParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    RemoteJsRequest actualParseFromResult = RemoteJsRequest.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasCompileRequest());
    assertFalse(actualParseFromResult.hasInvokeRequest());
    assertFalse(actualParseFromResult.hasReleaseRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(byte[], ExtensionRegistryLite)"})
  void testRemoteJsRequestParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    RemoteJsRequest actualParseFromResult = RemoteJsRequest.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasCompileRequest());
    assertFalse(actualParseFromResult.hasInvokeRequest());
    assertFalse(actualParseFromResult.hasReleaseRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(ByteString)"})
  void testRemoteJsRequestParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RemoteJsRequest actualParseFromResult = RemoteJsRequest.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasCompileRequest());
    assertFalse(actualParseFromResult.hasInvokeRequest());
    assertFalse(actualParseFromResult.hasReleaseRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(ByteString)"})
  void testRemoteJsRequestParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RemoteJsRequest actualParseFromResult = RemoteJsRequest.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasCompileRequest());
    assertFalse(actualParseFromResult.hasInvokeRequest());
    assertFalse(actualParseFromResult.hasReleaseRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testRemoteJsRequestParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RemoteJsRequest actualParseFromResult = RemoteJsRequest.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasCompileRequest());
    assertFalse(actualParseFromResult.hasInvokeRequest());
    assertFalse(actualParseFromResult.hasReleaseRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testRemoteJsRequestParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    RemoteJsRequest actualParseFromResult = RemoteJsRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasCompileRequest());
    assertFalse(actualParseFromResult.hasInvokeRequest());
    assertFalse(actualParseFromResult.hasReleaseRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(CodedInputStream) with 'CodedInputStream'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(CodedInputStream)"})
  void testRemoteJsRequestParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    RemoteJsRequest actualParseFromResult = RemoteJsRequest.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasCompileRequest());
    assertFalse(actualParseFromResult.hasInvokeRequest());
    assertFalse(actualParseFromResult.hasReleaseRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(CodedInputStream) with 'CodedInputStream'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(CodedInputStream)"})
  void testRemoteJsRequestParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    RemoteJsRequest actualParseFromResult = RemoteJsRequest.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasCompileRequest());
    assertFalse(actualParseFromResult.hasInvokeRequest());
    assertFalse(actualParseFromResult.hasReleaseRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(InputStream)"})
  void testRemoteJsRequestParseFromWithInputStream() throws IOException {
    // Arrange and Act
    RemoteJsRequest actualParseFromResult = RemoteJsRequest.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(InputStream)"})
  void testRemoteJsRequestParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RemoteJsRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsRequestParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    RemoteJsRequest actualParseFromResult = RemoteJsRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasCompileRequest());
    assertFalse(actualParseFromResult.hasInvokeRequest());
    assertFalse(actualParseFromResult.hasReleaseRequest());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsRequestParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RemoteJsRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsRequestParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RemoteJsRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(InputStream)"})
  void testRemoteJsRequestParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RemoteJsRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsRequest RemoteJsRequest.parseFrom(InputStream)"})
  void testRemoteJsRequestParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    RemoteJsRequest actualParseFromResult = RemoteJsRequest.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#equals(Object)}, and {@link RemoteJsResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RemoteJsResponse#equals(Object)}
   *   <li>{@link RemoteJsResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test RemoteJsResponse equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsResponse.equals(Object)", "int RemoteJsResponse.hashCode()"})
  void testRemoteJsResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RemoteJsResponse defaultInstance = RemoteJsResponse.getDefaultInstance();
    RemoteJsResponse defaultInstance2 = RemoteJsResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#equals(Object)}, and {@link RemoteJsResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RemoteJsResponse#equals(Object)}
   *   <li>{@link RemoteJsResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test RemoteJsResponse equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsResponse.equals(Object)", "int RemoteJsResponse.hashCode()"})
  void testRemoteJsResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RemoteJsResponse defaultInstance = RemoteJsResponse.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsResponse.equals(Object)", "int RemoteJsResponse.hashCode()"})
  void testRemoteJsResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RemoteJsResponse.getDefaultInstance(), 1);
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsResponse.equals(Object)", "int RemoteJsResponse.hashCode()"})
  void testRemoteJsResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RemoteJsResponse.getDefaultInstance(), null);
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsResponse.equals(Object)", "int RemoteJsResponse.hashCode()"})
  void testRemoteJsResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RemoteJsResponse.getDefaultInstance(), "Different type to RemoteJsResponse");
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#getCompileResponse()}.
   * <p>
   * Method under test: {@link RemoteJsResponse#getCompileResponse()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse getCompileResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsCompileResponse RemoteJsResponse.getCompileResponse()"})
  void testRemoteJsResponseGetCompileResponse() {
    // Arrange and Act
    JsCompileResponse actualCompileResponse = RemoteJsResponse.getDefaultInstance().getCompileResponse();

    // Assert
    assertEquals("", actualCompileResponse.getInitializationErrorString());
    assertEquals("", actualCompileResponse.getErrorDetails());
    assertEquals("", actualCompileResponse.getScriptHash());
    assertEquals(0, actualCompileResponse.getErrorCodeValue());
    assertEquals(0, actualCompileResponse.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualCompileResponse.getErrorCode());
    assertFalse(actualCompileResponse.getSuccess());
    assertTrue(actualCompileResponse.findInitializationErrors().isEmpty());
    assertTrue(actualCompileResponse.getAllFields().isEmpty());
    assertTrue(actualCompileResponse.isInitialized());
    assertSame(actualCompileResponse, actualCompileResponse.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link RemoteJsResponse#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.getDefaultInstanceForType()"})
  void testRemoteJsResponseGetDefaultInstanceForType() {
    // Arrange
    RemoteJsResponse defaultInstance = RemoteJsResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#getInvokeResponse()}.
   * <p>
   * Method under test: {@link RemoteJsResponse#getInvokeResponse()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse getInvokeResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsInvokeResponse RemoteJsResponse.getInvokeResponse()"})
  void testRemoteJsResponseGetInvokeResponse() {
    // Arrange and Act
    JsInvokeResponse actualInvokeResponse = RemoteJsResponse.getDefaultInstance().getInvokeResponse();

    // Assert
    assertEquals("", actualInvokeResponse.getInitializationErrorString());
    assertEquals("", actualInvokeResponse.getErrorDetails());
    assertEquals("", actualInvokeResponse.getResult());
    assertEquals(0, actualInvokeResponse.getErrorCodeValue());
    assertEquals(0, actualInvokeResponse.getSerializedSize());
    assertEquals(JsInvokeErrorCode.COMPILATION_ERROR, actualInvokeResponse.getErrorCode());
    assertFalse(actualInvokeResponse.getSuccess());
    assertTrue(actualInvokeResponse.findInitializationErrors().isEmpty());
    assertTrue(actualInvokeResponse.getAllFields().isEmpty());
    assertTrue(actualInvokeResponse.isInitialized());
    assertSame(actualInvokeResponse, actualInvokeResponse.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#getReleaseResponse()}.
   * <p>
   * Method under test: {@link RemoteJsResponse#getReleaseResponse()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse getReleaseResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsReleaseResponse RemoteJsResponse.getReleaseResponse()"})
  void testRemoteJsResponseGetReleaseResponse() {
    // Arrange and Act
    JsReleaseResponse actualReleaseResponse = RemoteJsResponse.getDefaultInstance().getReleaseResponse();

    // Assert
    assertEquals("", actualReleaseResponse.getInitializationErrorString());
    assertEquals("", actualReleaseResponse.getScriptHash());
    assertEquals(0, actualReleaseResponse.getSerializedSize());
    assertFalse(actualReleaseResponse.getSuccess());
    assertTrue(actualReleaseResponse.findInitializationErrors().isEmpty());
    assertTrue(actualReleaseResponse.getAllFields().isEmpty());
    assertTrue(actualReleaseResponse.isInitialized());
    assertSame(actualReleaseResponse, actualReleaseResponse.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#getSerializedSize()}.
   * <p>
   * Method under test: {@link RemoteJsResponse#getSerializedSize()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RemoteJsResponse.getSerializedSize()"})
  void testRemoteJsResponseGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RemoteJsResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#hasCompileResponse()}.
   * <p>
   * Method under test: {@link RemoteJsResponse#hasCompileResponse()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse hasCompileResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsResponse.hasCompileResponse()"})
  void testRemoteJsResponseHasCompileResponse() {
    // Arrange, Act and Assert
    assertFalse(RemoteJsResponse.getDefaultInstance().hasCompileResponse());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#hasInvokeResponse()}.
   * <p>
   * Method under test: {@link RemoteJsResponse#hasInvokeResponse()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse hasInvokeResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsResponse.hasInvokeResponse()"})
  void testRemoteJsResponseHasInvokeResponse() {
    // Arrange, Act and Assert
    assertFalse(RemoteJsResponse.getDefaultInstance().hasInvokeResponse());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#hasReleaseResponse()}.
   * <p>
   * Method under test: {@link RemoteJsResponse#hasReleaseResponse()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse hasReleaseResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsResponse.hasReleaseResponse()"})
  void testRemoteJsResponseHasReleaseResponse() {
    // Arrange, Act and Assert
    assertFalse(RemoteJsResponse.getDefaultInstance().hasReleaseResponse());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#isInitialized()}.
   * <p>
   * Method under test: {@link RemoteJsResponse#isInitialized()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RemoteJsResponse.isInitialized()"})
  void testRemoteJsResponseIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RemoteJsResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseDelimitedFrom(InputStream)"})
  void testRemoteJsResponseParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RemoteJsResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsResponseParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        RemoteJsResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsResponseParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RemoteJsResponse actualParseDelimitedFromResult = RemoteJsResponse.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsResponseParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> RemoteJsResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsResponseParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RemoteJsResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsResponseParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RemoteJsResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseDelimitedFrom(InputStream)"})
  void testRemoteJsResponseParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RemoteJsResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseDelimitedFrom(InputStream)"})
  void testRemoteJsResponseParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, RemoteJsResponse.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseDelimitedFrom(InputStream)"})
  void testRemoteJsResponseParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RemoteJsResponse actualParseDelimitedFromResult = RemoteJsResponse.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseDelimitedFrom(InputStream)"})
  void testRemoteJsResponseParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> RemoteJsResponse.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(byte[])"})
  void testRemoteJsResponseParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRequestIdLSB());
    assertEquals(0L, actualParseFromResult.getRequestIdMSB());
    assertFalse(actualParseFromResult.hasCompileResponse());
    assertFalse(actualParseFromResult.hasInvokeResponse());
    assertFalse(actualParseFromResult.hasReleaseResponse());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(ByteBuffer)"})
  void testRemoteJsResponseParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRequestIdLSB());
    assertEquals(0L, actualParseFromResult.getRequestIdMSB());
    assertFalse(actualParseFromResult.hasCompileResponse());
    assertFalse(actualParseFromResult.hasInvokeResponse());
    assertFalse(actualParseFromResult.hasReleaseResponse());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testRemoteJsResponseParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRequestIdLSB());
    assertEquals(0L, actualParseFromResult.getRequestIdMSB());
    assertFalse(actualParseFromResult.hasCompileResponse());
    assertFalse(actualParseFromResult.hasInvokeResponse());
    assertFalse(actualParseFromResult.hasReleaseResponse());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(byte[], ExtensionRegistryLite)"})
  void testRemoteJsResponseParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRequestIdLSB());
    assertEquals(0L, actualParseFromResult.getRequestIdMSB());
    assertFalse(actualParseFromResult.hasCompileResponse());
    assertFalse(actualParseFromResult.hasInvokeResponse());
    assertFalse(actualParseFromResult.hasReleaseResponse());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(ByteString)"})
  void testRemoteJsResponseParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRequestIdLSB());
    assertEquals(0L, actualParseFromResult.getRequestIdMSB());
    assertFalse(actualParseFromResult.hasCompileResponse());
    assertFalse(actualParseFromResult.hasInvokeResponse());
    assertFalse(actualParseFromResult.hasReleaseResponse());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(ByteString)"})
  void testRemoteJsResponseParseFromWithByteString2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRequestIdLSB());
    assertEquals(0L, actualParseFromResult.getRequestIdMSB());
    assertFalse(actualParseFromResult.hasCompileResponse());
    assertFalse(actualParseFromResult.hasInvokeResponse());
    assertFalse(actualParseFromResult.hasReleaseResponse());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testRemoteJsResponseParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRequestIdLSB());
    assertEquals(0L, actualParseFromResult.getRequestIdMSB());
    assertFalse(actualParseFromResult.hasCompileResponse());
    assertFalse(actualParseFromResult.hasInvokeResponse());
    assertFalse(actualParseFromResult.hasReleaseResponse());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testRemoteJsResponseParseFromWithByteStringExtensionRegistryLite2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(4);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRequestIdLSB());
    assertEquals(0L, actualParseFromResult.getRequestIdMSB());
    assertFalse(actualParseFromResult.hasCompileResponse());
    assertFalse(actualParseFromResult.hasInvokeResponse());
    assertFalse(actualParseFromResult.hasReleaseResponse());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testRemoteJsResponseParseFromWithCodedInputStreamExtensionRegistryLite_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRequestIdLSB());
    assertEquals(0L, actualParseFromResult.getRequestIdMSB());
    assertFalse(actualParseFromResult.hasCompileResponse());
    assertFalse(actualParseFromResult.hasInvokeResponse());
    assertFalse(actualParseFromResult.hasReleaseResponse());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testRemoteJsResponseParseFromWithCodedInputStreamExtensionRegistryLite_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRequestIdLSB());
    assertEquals(0L, actualParseFromResult.getRequestIdMSB());
    assertFalse(actualParseFromResult.hasCompileResponse());
    assertFalse(actualParseFromResult.hasInvokeResponse());
    assertFalse(actualParseFromResult.hasReleaseResponse());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given four.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(CodedInputStream) with 'CodedInputStream'; given four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(CodedInputStream)"})
  void testRemoteJsResponseParseFromWithCodedInputStream_givenFour() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(4);

    // Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRequestIdLSB());
    assertEquals(0L, actualParseFromResult.getRequestIdMSB());
    assertFalse(actualParseFromResult.hasCompileResponse());
    assertFalse(actualParseFromResult.hasInvokeResponse());
    assertFalse(actualParseFromResult.hasReleaseResponse());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(CodedInputStream) with 'CodedInputStream'; given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(CodedInputStream)"})
  void testRemoteJsResponseParseFromWithCodedInputStream_givenZero() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRequestIdLSB());
    assertEquals(0L, actualParseFromResult.getRequestIdMSB());
    assertFalse(actualParseFromResult.hasCompileResponse());
    assertFalse(actualParseFromResult.hasInvokeResponse());
    assertFalse(actualParseFromResult.hasReleaseResponse());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(InputStream)"})
  void testRemoteJsResponseParseFromWithInputStream() throws IOException {
    // Arrange and Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    JsCompileResponse compileResponse = actualParseFromResult.getCompileResponse();
    assertSame(unknownFields, compileResponse.getUnknownFields());
    JsInvokeResponse invokeResponse = actualParseFromResult.getInvokeResponse();
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    JsReleaseResponse releaseResponse = actualParseFromResult.getReleaseResponse();
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, actualParseFromResult.getCompileResponseOrBuilder());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, actualParseFromResult.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, actualParseFromResult.getReleaseResponseOrBuilder());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(InputStream)"})
  void testRemoteJsResponseParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RemoteJsResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsResponseParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRequestIdLSB());
    assertEquals(0L, actualParseFromResult.getRequestIdMSB());
    assertFalse(actualParseFromResult.hasCompileResponse());
    assertFalse(actualParseFromResult.hasInvokeResponse());
    assertFalse(actualParseFromResult.hasReleaseResponse());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsResponseParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RemoteJsResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testRemoteJsResponseParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> RemoteJsResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(InputStream)"})
  void testRemoteJsResponseParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RemoteJsResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RemoteJsResponse RemoteJsResponse.parseFrom(InputStream)"})
  void testRemoteJsResponseParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    RemoteJsResponse actualParseFromResult = RemoteJsResponse.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    JsCompileResponse compileResponse = actualParseFromResult.getCompileResponse();
    assertSame(unknownFields, compileResponse.getUnknownFields());
    JsInvokeResponse invokeResponse = actualParseFromResult.getInvokeResponse();
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    JsReleaseResponse releaseResponse = actualParseFromResult.getReleaseResponse();
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, actualParseFromResult.getCompileResponseOrBuilder());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, actualParseFromResult.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, actualParseFromResult.getReleaseResponseOrBuilder());
  }
}
