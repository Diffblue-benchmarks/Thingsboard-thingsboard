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
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
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
   * Test JsCompileRequest {@link JsCompileRequest#equals(Object)}, and
   * {@link JsCompileRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsCompileRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsCompileRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsCompileRequest equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test JsCompileRequest {@link JsCompileRequest#equals(Object)}, and
   * {@link JsCompileRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsCompileRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsCompileRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsCompileRequest equals(Object), and hashCode(); when other is same; then return equal")
  void testJsCompileRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsCompileRequest defaultInstance = JsInvokeProtos.JsCompileRequest.getDefaultInstance();

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
   * Method under test: {@link JsInvokeProtos.JsCompileRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsCompileRequest equals(Object); when other is different; then return not equal")
  void testJsCompileRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsCompileRequest.getDefaultInstance(), 1);
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsCompileRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsCompileRequest equals(Object); when other is 'null'; then return not equal")
  void testJsCompileRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsCompileRequest.getDefaultInstance(), null);
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsCompileRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsCompileRequest equals(Object); when other is wrong type; then return not equal")
  void testJsCompileRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsCompileRequest.getDefaultInstance(), "Different type to JsCompileRequest");
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getDefaultInstanceForType()")
  void testJsCompileRequestGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.JsCompileRequest defaultInstance = JsInvokeProtos.JsCompileRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getFunctionName()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsCompileRequest#getFunctionName()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getFunctionName()")
  void testJsCompileRequestGetFunctionName() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsCompileRequest.getDefaultInstance().getFunctionName());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getFunctionNameBytes()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#getFunctionNameBytes()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getFunctionNameBytes()")
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
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
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
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
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
    assertEquals(byteString, actualFunctionNameBytes);
    assertEquals(byteString, defaultInstance.getScriptBodyBytes());
    assertEquals(byteString, defaultInstance.getScriptHashBytes());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getScriptBody()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsCompileRequest#getScriptBody()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getScriptBody()")
  void testJsCompileRequestGetScriptBody() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsCompileRequest.getDefaultInstance().getScriptBody());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getScriptBodyBytes()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#getScriptBodyBytes()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getScriptBodyBytes()")
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
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
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
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
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
    assertEquals(byteString, defaultInstance.getFunctionNameBytes());
    assertEquals(byteString, actualScriptBodyBytes);
    assertEquals(byteString, defaultInstance.getScriptHashBytes());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getScriptHash()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsCompileRequest#getScriptHash()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getScriptHash()")
  void testJsCompileRequestGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsCompileRequest.getDefaultInstance().getScriptHash());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getScriptHashBytes()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#getScriptHashBytes()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getScriptHashBytes()")
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
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
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
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
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
    assertEquals(byteString, defaultInstance.getFunctionNameBytes());
    assertEquals(byteString, defaultInstance.getScriptBodyBytes());
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test JsCompileRequest getSerializedSize()")
  void testJsCompileRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsCompileRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#isInitialized()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsCompileRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test JsCompileRequest isInitialized()")
  void testJsCompileRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.JsCompileRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test JsCompileRequest
   * {@link JsCompileRequest#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test JsCompileRequest newInstance(UnusedPrivateParameter)")
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
   * Test JsCompileRequest
   * {@link JsCompileRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream) with 'input'")
  void testJsCompileRequestParseDelimitedFromWithInput() throws IOException {
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
   * Test JsCompileRequest
   * {@link JsCompileRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream) with 'input'")
  void testJsCompileRequestParseDelimitedFromWithInput2() throws IOException {
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
   * Test JsCompileRequest
   * {@link JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsCompileRequestParseDelimitedFromWithInputExtensionRegistry() throws IOException {
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
   * Test JsCompileRequest
   * {@link JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsCompileRequestParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
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
   * Test JsCompileRequest
   * {@link JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsCompileRequestParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
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
   * Test JsCompileRequest
   * {@link JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testJsCompileRequestParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsCompileRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsCompileRequest
   * {@link JsCompileRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testJsCompileRequestParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsCompileRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsCompileRequest
   * {@link JsCompileRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testJsCompileRequestParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
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
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(InputStream) with 'InputStream'")
  void testJsCompileRequestParseFromWithInputStream() throws IOException {
    // Arrange and Act
    JsInvokeProtos.JsCompileRequest actualParseFromResult = JsInvokeProtos.JsCompileRequest
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(1, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(8, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(6);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(7);
    assertSame(file, getResult4.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(2);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    assertSame(options4, options4.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, getResult7.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(InputStream) with 'InputStream'")
  void testJsCompileRequestParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsCompileRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsCompileRequest
   * {@link JsCompileRequest#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testJsCompileRequestParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsCompileRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsCompileRequest
   * {@link JsCompileRequest#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testJsCompileRequestParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
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
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testJsCompileRequestParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsCompileRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsCompileRequest {@link JsCompileRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileRequest parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testJsCompileRequestParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JsInvokeProtos.JsCompileRequest actualParseFromResult = JsInvokeProtos.JsCompileRequest
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(1, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(8, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(6);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(7);
    assertSame(file, getResult4.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(2);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    assertSame(options4, options4.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, getResult7.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#equals(Object)}, and
   * {@link JsCompileResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsCompileResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsCompileResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsCompileResponse equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test JsCompileResponse {@link JsCompileResponse#equals(Object)}, and
   * {@link JsCompileResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsCompileResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsCompileResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsCompileResponse equals(Object), and hashCode(); when other is same; then return equal")
  void testJsCompileResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsCompileResponse defaultInstance = JsInvokeProtos.JsCompileResponse.getDefaultInstance();

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
   * Method under test: {@link JsInvokeProtos.JsCompileResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsCompileResponse equals(Object); when other is different; then return not equal")
  void testJsCompileResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsCompileResponse.getDefaultInstance(), 1);
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsCompileResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsCompileResponse equals(Object); when other is 'null'; then return not equal")
  void testJsCompileResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsCompileResponse.getDefaultInstance(), null);
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsCompileResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsCompileResponse equals(Object); when other is wrong type; then return not equal")
  void testJsCompileResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsCompileResponse.getDefaultInstance(), "Different type to JsCompileResponse");
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test JsCompileResponse getDefaultInstanceForType()")
  void testJsCompileResponseGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.JsCompileResponse defaultInstance = JsInvokeProtos.JsCompileResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#getErrorCode()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsCompileResponse#getErrorCode()}
   */
  @Test
  @DisplayName("Test JsCompileResponse getErrorCode()")
  void testJsCompileResponseGetErrorCode() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.COMPILATION_ERROR,
        JsInvokeProtos.JsCompileResponse.getDefaultInstance().getErrorCode());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#getErrorDetails()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsCompileResponse#getErrorDetails()}
   */
  @Test
  @DisplayName("Test JsCompileResponse getErrorDetails()")
  void testJsCompileResponseGetErrorDetails() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsCompileResponse.getDefaultInstance().getErrorDetails());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#getErrorDetailsBytes()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#getErrorDetailsBytes()}
   */
  @Test
  @DisplayName("Test JsCompileResponse getErrorDetailsBytes()")
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
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
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
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualErrorDetailsBytes);
    assertEquals(byteString, defaultInstance.getScriptHashBytes());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#getScriptHash()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsCompileResponse#getScriptHash()}
   */
  @Test
  @DisplayName("Test JsCompileResponse getScriptHash()")
  void testJsCompileResponseGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsCompileResponse.getDefaultInstance().getScriptHash());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#getScriptHashBytes()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#getScriptHashBytes()}
   */
  @Test
  @DisplayName("Test JsCompileResponse getScriptHashBytes()")
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
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
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
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getErrorDetailsBytes());
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#getSerializedSize()}
   */
  @Test
  @DisplayName("Test JsCompileResponse getSerializedSize()")
  void testJsCompileResponseGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsCompileResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#isInitialized()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsCompileResponse#isInitialized()}
   */
  @Test
  @DisplayName("Test JsCompileResponse isInitialized()")
  void testJsCompileResponseIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.JsCompileResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Test JsCompileResponse
   * {@link JsCompileResponse#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test JsCompileResponse newInstance(UnusedPrivateParameter)")
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
   * Test JsCompileResponse
   * {@link JsCompileResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream) with 'input'")
  void testJsCompileResponseParseDelimitedFromWithInput() throws IOException {
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
   * Test JsCompileResponse
   * {@link JsCompileResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream) with 'input'")
  void testJsCompileResponseParseDelimitedFromWithInput2() throws IOException {
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
   * Test JsCompileResponse
   * {@link JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsCompileResponseParseDelimitedFromWithInputExtensionRegistry() throws IOException {
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
   * Test JsCompileResponse
   * {@link JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsCompileResponseParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
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
   * Test JsCompileResponse
   * {@link JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsCompileResponseParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
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
   * Test JsCompileResponse
   * {@link JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testJsCompileResponseParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsCompileResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsCompileResponse
   * {@link JsCompileResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testJsCompileResponseParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsCompileResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsCompileResponse
   * {@link JsCompileResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testJsCompileResponseParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
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
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(InputStream) with 'InputStream'")
  void testJsCompileResponseParseFromWithInputStream() throws IOException {
    // Arrange and Act
    JsInvokeProtos.JsCompileResponse actualParseFromResult = JsInvokeProtos.JsCompileResponse
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(1, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(8, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(6);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(7);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    Descriptors.EnumDescriptor enumType = getResult5.getEnumType();
    assertSame(file, enumType.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(0);
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(2);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(3);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType2.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(0));
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult6.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult7.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult8.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options4, getResult8.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(InputStream) with 'InputStream'")
  void testJsCompileResponseParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsCompileResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsCompileResponse
   * {@link JsCompileResponse#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testJsCompileResponseParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsCompileResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsCompileResponse
   * {@link JsCompileResponse#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testJsCompileResponseParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
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
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testJsCompileResponseParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsCompileResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsCompileResponse {@link JsCompileResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsCompileResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsCompileResponse parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testJsCompileResponseParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JsInvokeProtos.JsCompileResponse actualParseFromResult = JsInvokeProtos.JsCompileResponse
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(1, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(8, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(6);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(7);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    Descriptors.EnumDescriptor enumType = getResult5.getEnumType();
    assertSame(file, enumType.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(0);
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(2);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(3);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType2.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(0));
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult6.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult7.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult8.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options4, getResult8.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode forNumber(int); when forty-two; then return 'null'")
  void testJsInvokeErrorCodeForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JsInvokeProtos.JsInvokeErrorCode.forNumber(42));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code RUNTIME_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode forNumber(int); when one; then return 'RUNTIME_ERROR'")
  void testJsInvokeErrorCodeForNumber_whenOne_thenReturnRuntimeError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.RUNTIME_ERROR, JsInvokeProtos.JsInvokeErrorCode.forNumber(1));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code NOT_FOUND_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode forNumber(int); when three; then return 'NOT_FOUND_ERROR'")
  void testJsInvokeErrorCodeForNumber_whenThree_thenReturnNotFoundError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.NOT_FOUND_ERROR, JsInvokeProtos.JsInvokeErrorCode.forNumber(3));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code TIMEOUT_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode forNumber(int); when two; then return 'TIMEOUT_ERROR'")
  void testJsInvokeErrorCodeForNumber_whenTwo_thenReturnTimeoutError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.TIMEOUT_ERROR, JsInvokeProtos.JsInvokeErrorCode.forNumber(2));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code COMPILATION_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#forNumber(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode forNumber(int); when zero; then return 'COMPILATION_ERROR'")
  void testJsInvokeErrorCodeForNumber_whenZero_thenReturnCompilationError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.COMPILATION_ERROR, JsInvokeProtos.JsInvokeErrorCode.forNumber(0));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#getNumber()}.
   * <ul>
   *   <li>Given {@code COMPILATION_ERROR}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#getNumber()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode getNumber(); given 'COMPILATION_ERROR'; then return zero")
  void testJsInvokeErrorCodeGetNumber_givenCompilationError_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsInvokeErrorCode.COMPILATION_ERROR.getNumber());
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#getNumber()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#getNumber()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode getNumber(); then throw IllegalArgumentException")
  void testJsInvokeErrorCodeGetNumber_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsInvokeProtos.JsInvokeErrorCode.UNRECOGNIZED.getNumber());
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#getValueDescriptor()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeErrorCode#getValueDescriptor()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode getValueDescriptor(); then throw IllegalStateException")
  void testJsInvokeErrorCodeGetValueDescriptor_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> JsInvokeProtos.JsInvokeErrorCode.UNRECOGNIZED.getValueDescriptor());
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode internalGetValueMap()")
  void testJsInvokeErrorCodeInternalGetValueMap() {
    // Arrange and Act
    Internal.EnumLiteMap<JsInvokeProtos.JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeProtos.JsInvokeErrorCode
        .internalGetValueMap();

    // Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.RUNTIME_ERROR, actualInternalGetValueMapResult.findValueByNumber(1));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode internalGetValueMap()")
  void testJsInvokeErrorCodeInternalGetValueMap2() {
    // Arrange and Act
    Internal.EnumLiteMap<JsInvokeProtos.JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeProtos.JsInvokeErrorCode
        .internalGetValueMap();

    // Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.TIMEOUT_ERROR, actualInternalGetValueMapResult.findValueByNumber(2));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode internalGetValueMap()")
  void testJsInvokeErrorCodeInternalGetValueMap3() {
    // Arrange and Act
    Internal.EnumLiteMap<JsInvokeProtos.JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeProtos.JsInvokeErrorCode
        .internalGetValueMap();

    // Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.NOT_FOUND_ERROR,
        actualInternalGetValueMapResult.findValueByNumber(3));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#internalGetValueMap()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode internalGetValueMap()")
  void testJsInvokeErrorCodeInternalGetValueMap4() {
    // Arrange and Act
    Internal.EnumLiteMap<JsInvokeProtos.JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeProtos.JsInvokeErrorCode
        .internalGetValueMap();

    // Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.COMPILATION_ERROR,
        actualInternalGetValueMapResult.findValueByNumber(0));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#internalGetValueMap()}.
   * <ul>
   *   <li>Then return findValueByNumber ten is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeErrorCode#internalGetValueMap()}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode internalGetValueMap(); then return findValueByNumber ten is 'null'")
  void testJsInvokeErrorCodeInternalGetValueMap_thenReturnFindValueByNumberTenIsNull() {
    // Arrange and Act
    Internal.EnumLiteMap<JsInvokeProtos.JsInvokeErrorCode> actualInternalGetValueMapResult = JsInvokeProtos.JsInvokeErrorCode
        .internalGetValueMap();

    // Assert
    assertNull(actualInternalGetValueMapResult.findValueByNumber(10));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#valueOf(int)} with
   * {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode valueOf(int) with 'value'; when forty-two; then return 'null'")
  void testJsInvokeErrorCodeValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JsInvokeProtos.JsInvokeErrorCode.valueOf(42));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#valueOf(int)} with
   * {@code value}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code RUNTIME_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode valueOf(int) with 'value'; when one; then return 'RUNTIME_ERROR'")
  void testJsInvokeErrorCodeValueOfWithValue_whenOne_thenReturnRuntimeError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.RUNTIME_ERROR, JsInvokeProtos.JsInvokeErrorCode.valueOf(1));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#valueOf(int)} with
   * {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code NOT_FOUND_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode valueOf(int) with 'value'; when three; then return 'NOT_FOUND_ERROR'")
  void testJsInvokeErrorCodeValueOfWithValue_whenThree_thenReturnNotFoundError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.NOT_FOUND_ERROR, JsInvokeProtos.JsInvokeErrorCode.valueOf(3));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#valueOf(int)} with
   * {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code TIMEOUT_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode valueOf(int) with 'value'; when two; then return 'TIMEOUT_ERROR'")
  void testJsInvokeErrorCodeValueOfWithValue_whenTwo_thenReturnTimeoutError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.TIMEOUT_ERROR, JsInvokeProtos.JsInvokeErrorCode.valueOf(2));
  }

  /**
   * Test JsInvokeErrorCode {@link JsInvokeErrorCode#valueOf(int)} with
   * {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code COMPILATION_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeErrorCode#valueOf(int)}
   */
  @Test
  @DisplayName("Test JsInvokeErrorCode valueOf(int) with 'value'; when zero; then return 'COMPILATION_ERROR'")
  void testJsInvokeErrorCodeValueOfWithValue_whenZero_thenReturnCompilationError() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.COMPILATION_ERROR, JsInvokeProtos.JsInvokeErrorCode.valueOf(0));
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#equals(Object)}, and
   * {@link JsInvokeRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsInvokeRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsInvokeRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsInvokeRequest equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test JsInvokeRequest {@link JsInvokeRequest#equals(Object)}, and
   * {@link JsInvokeRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsInvokeRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsInvokeRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsInvokeRequest equals(Object), and hashCode(); when other is same; then return equal")
  void testJsInvokeRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsInvokeRequest defaultInstance = JsInvokeProtos.JsInvokeRequest.getDefaultInstance();

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
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest equals(Object); when other is different; then return not equal")
  void testJsInvokeRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsInvokeRequest.getDefaultInstance(), 1);
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest equals(Object); when other is 'null'; then return not equal")
  void testJsInvokeRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsInvokeRequest.getDefaultInstance(), null);
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest equals(Object); when other is wrong type; then return not equal")
  void testJsInvokeRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsInvokeRequest.getDefaultInstance(), "Different type to JsInvokeRequest");
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getArgsCount()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#getArgsCount()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getArgsCount()")
  void testJsInvokeRequestGetArgsCount() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsInvokeRequest.getDefaultInstance().getArgsCount());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getArgsList()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#getArgsList()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getArgsList()")
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
    assertTrue(actualArgsList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualArgsList).EMPTY;
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(lazyStringList, defaultInstanceForType.findInitializationErrors());
    assertEquals(lazyStringList, toProtoResult.getSourceCodeInfo().findInitializationErrors());
    DescriptorProtos.FileOptions options = file.getOptions();
    assertEquals(lazyStringList, options.getDefaultInstanceForType().findInitializationErrors());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertEquals(lazyStringList, toProtoResult2.findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    assertEquals(lazyStringList, toProtoResult3.getDescriptorForType().toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(lazyStringList, options3.findInitializationErrors());
    assertEquals(lazyStringList, getResult.toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(1).toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(3).toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(4).toProto().findInitializationErrors());
    assertEquals(lazyStringList, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertEquals(lazyStringList, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals(lazyStringList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(7);
    assertEquals(lazyStringList, getResult4.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = options2.getFeatures().getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType4.getExtensions());
    Descriptors.Descriptor descriptorForType5 = options.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType5.getExtensions());
    assertEquals(lazyStringList, descriptorForType3.getExtensions());
    assertEquals(lazyStringList, getResult2.getExtensions());
    assertEquals(lazyStringList, getResult3.getExtensions());
    assertEquals(lazyStringList, getResult4.getExtensions());
    assertEquals(lazyStringList, descriptorForType4.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType5.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType3.getNestedTypes());
    assertEquals(lazyStringList, getResult2.getNestedTypes());
    assertEquals(lazyStringList, getResult3.getNestedTypes());
    assertEquals(lazyStringList, getResult4.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType4.getOneofs());
    assertEquals(lazyStringList, descriptorForType5.getOneofs());
    assertEquals(lazyStringList, descriptorForType3.getOneofs());
    assertEquals(lazyStringList, getResult2.getOneofs());
    assertEquals(lazyStringList, getResult3.getOneofs());
    assertEquals(lazyStringList, getResult4.getOneofs());
    assertEquals(lazyStringList, descriptorForType4.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType5.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType3.getRealOneofs());
    assertEquals(lazyStringList, getResult2.getRealOneofs());
    assertEquals(lazyStringList, getResult3.getRealOneofs());
    assertEquals(lazyStringList, getResult4.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(lazyStringList, file2.getDependencies());
    assertEquals(lazyStringList, file2.getExtensions());
    assertEquals(lazyStringList, file2.getPublicDependencies());
    assertEquals(lazyStringList, file2.getServices());
    assertSame(lazyStringList, toProtoResult3.getDefaultInstanceForType().getReservedNameList());
    assertSame(lazyStringList, toProtoResult2.getReservedNameList());
    assertSame(lazyStringList, toProtoResult3.getReservedNameList());
    assertSame(lazyStringList, defaultInstanceForType.getDependencyList());
    assertSame(lazyStringList, toProtoResult.getDependencyList());
    assertSame(lazyStringList, actualArgsList);
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getDefaultInstanceForType()")
  void testJsInvokeRequestGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.JsInvokeRequest defaultInstance = JsInvokeProtos.JsInvokeRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getFunctionName()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#getFunctionName()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getFunctionName()")
  void testJsInvokeRequestGetFunctionName() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsInvokeRequest.getDefaultInstance().getFunctionName());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getFunctionNameBytes()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#getFunctionNameBytes()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getFunctionNameBytes()")
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
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
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
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualFunctionNameBytes);
    assertEquals(byteString, defaultInstance.getScriptBodyBytes());
    assertEquals(byteString, defaultInstance.getScriptHashBytes());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getScriptBody()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#getScriptBody()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getScriptBody()")
  void testJsInvokeRequestGetScriptBody() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsInvokeRequest.getDefaultInstance().getScriptBody());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getScriptBodyBytes()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#getScriptBodyBytes()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getScriptBodyBytes()")
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
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
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
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getFunctionNameBytes());
    assertEquals(byteString, actualScriptBodyBytes);
    assertEquals(byteString, defaultInstance.getScriptHashBytes());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getScriptHash()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#getScriptHash()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getScriptHash()")
  void testJsInvokeRequestGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsInvokeRequest.getDefaultInstance().getScriptHash());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getScriptHashBytes()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#getScriptHashBytes()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getScriptHashBytes()")
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
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
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
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getFunctionNameBytes());
    assertEquals(byteString, defaultInstance.getScriptBodyBytes());
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#getSerializedSize()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest getSerializedSize()")
  void testJsInvokeRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsInvokeRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#isInitialized()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test JsInvokeRequest isInitialized()")
  void testJsInvokeRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.JsInvokeRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test JsInvokeRequest
   * {@link JsInvokeRequest#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest newInstance(UnusedPrivateParameter)")
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
   * Test JsInvokeRequest {@link JsInvokeRequest#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream) with 'input'")
  void testJsInvokeRequestParseDelimitedFromWithInput() throws IOException {
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
   * Test JsInvokeRequest
   * {@link JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsInvokeRequestParseDelimitedFromWithInputExtensionRegistry() throws IOException {
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
   * Test JsInvokeRequest
   * {@link JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsInvokeRequestParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
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
   * Test JsInvokeRequest
   * {@link JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsInvokeRequestParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
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
   * Test JsInvokeRequest
   * {@link JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testJsInvokeRequestParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsInvokeRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testJsInvokeRequestParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsInvokeRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testJsInvokeRequestParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
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
   * Test JsInvokeRequest {@link JsInvokeRequest#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testJsInvokeRequestParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
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
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(InputStream) with 'InputStream'")
  void testJsInvokeRequestParseFromWithInputStream() throws IOException {
    // Arrange and Act
    JsInvokeProtos.JsInvokeRequest actualParseFromResult = JsInvokeProtos.JsInvokeRequest
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(1, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(5, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(8, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(7);
    assertSame(file, getResult3.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(3);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(4);
    assertSame(file, getResult7.getFile());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.MessageOptions options3 = descriptorForType2.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, options.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult4.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, messageTypes.get(6));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList argsList = actualParseFromResult.getArgsList();
    assertSame(argsList, defaultInstanceForType.getReservedNameList());
    assertSame(argsList, toProtoResult3.getReservedNameList());
    assertSame(argsList, toProtoResult2.getReservedNameList());
    assertSame(argsList, defaultInstanceForType2.getDependencyList());
    assertSame(argsList, toProtoResult.getDependencyList());
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(InputStream) with 'InputStream'")
  void testJsInvokeRequestParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsInvokeRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsInvokeRequest
   * {@link JsInvokeRequest#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testJsInvokeRequestParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsInvokeRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsInvokeRequest
   * {@link JsInvokeRequest#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testJsInvokeRequestParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
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
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testJsInvokeRequestParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsInvokeRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsInvokeRequest {@link JsInvokeRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeRequest parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testJsInvokeRequestParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JsInvokeProtos.JsInvokeRequest actualParseFromResult = JsInvokeProtos.JsInvokeRequest.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(1, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(5, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(8, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(7);
    assertSame(file, getResult3.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(3);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(4);
    assertSame(file, getResult7.getFile());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.MessageOptions options3 = descriptorForType2.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, options.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult4.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult4.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult6.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, messageTypes.get(6));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList argsList = actualParseFromResult.getArgsList();
    assertSame(argsList, defaultInstanceForType.getReservedNameList());
    assertSame(argsList, toProtoResult3.getReservedNameList());
    assertSame(argsList, toProtoResult2.getReservedNameList());
    assertSame(argsList, defaultInstanceForType2.getDependencyList());
    assertSame(argsList, toProtoResult.getDependencyList());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#equals(Object)}, and
   * {@link JsInvokeResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsInvokeResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsInvokeResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsInvokeResponse equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test JsInvokeResponse {@link JsInvokeResponse#equals(Object)}, and
   * {@link JsInvokeResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsInvokeResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsInvokeResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsInvokeResponse equals(Object), and hashCode(); when other is same; then return equal")
  void testJsInvokeResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsInvokeResponse defaultInstance = JsInvokeProtos.JsInvokeResponse.getDefaultInstance();

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
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse equals(Object); when other is different; then return not equal")
  void testJsInvokeResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsInvokeResponse.getDefaultInstance(), 1);
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse equals(Object); when other is 'null'; then return not equal")
  void testJsInvokeResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsInvokeResponse.getDefaultInstance(), null);
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse equals(Object); when other is wrong type; then return not equal")
  void testJsInvokeResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsInvokeResponse.getDefaultInstance(), "Different type to JsInvokeResponse");
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse getDefaultInstanceForType()")
  void testJsInvokeResponseGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.JsInvokeResponse defaultInstance = JsInvokeProtos.JsInvokeResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#getErrorCode()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#getErrorCode()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse getErrorCode()")
  void testJsInvokeResponseGetErrorCode() {
    // Arrange, Act and Assert
    assertEquals(JsInvokeProtos.JsInvokeErrorCode.COMPILATION_ERROR,
        JsInvokeProtos.JsInvokeResponse.getDefaultInstance().getErrorCode());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#getErrorDetails()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#getErrorDetails()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse getErrorDetails()")
  void testJsInvokeResponseGetErrorDetails() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsInvokeResponse.getDefaultInstance().getErrorDetails());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#getErrorDetailsBytes()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#getErrorDetailsBytes()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse getErrorDetailsBytes()")
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
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
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
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualErrorDetailsBytes);
    assertEquals(byteString, defaultInstance.getResultBytes());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#getResult()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#getResult()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse getResult()")
  void testJsInvokeResponseGetResult() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsInvokeResponse.getDefaultInstance().getResult());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#getResultBytes()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#getResultBytes()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse getResultBytes()")
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
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
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
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getErrorDetailsBytes());
    assertEquals(byteString, actualResultBytes);
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#getSerializedSize()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse getSerializedSize()")
  void testJsInvokeResponseGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsInvokeResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#isInitialized()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsInvokeResponse#isInitialized()}
   */
  @Test
  @DisplayName("Test JsInvokeResponse isInitialized()")
  void testJsInvokeResponseIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.JsInvokeResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Test JsInvokeResponse
   * {@link JsInvokeResponse#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse newInstance(UnusedPrivateParameter)")
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
   * Test JsInvokeResponse
   * {@link JsInvokeResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream) with 'input'")
  void testJsInvokeResponseParseDelimitedFromWithInput() throws IOException {
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
   * Test JsInvokeResponse
   * {@link JsInvokeResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream) with 'input'")
  void testJsInvokeResponseParseDelimitedFromWithInput2() throws IOException {
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
   * Test JsInvokeResponse
   * {@link JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsInvokeResponseParseDelimitedFromWithInputExtensionRegistry() throws IOException {
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
   * Test JsInvokeResponse
   * {@link JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsInvokeResponseParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
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
   * Test JsInvokeResponse
   * {@link JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsInvokeResponseParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
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
   * Test JsInvokeResponse
   * {@link JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testJsInvokeResponseParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsInvokeResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsInvokeResponse
   * {@link JsInvokeResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testJsInvokeResponseParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsInvokeResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsInvokeResponse
   * {@link JsInvokeResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testJsInvokeResponseParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
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
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(InputStream) with 'InputStream'")
  void testJsInvokeResponseParseFromWithInputStream() throws IOException {
    // Arrange and Act
    JsInvokeProtos.JsInvokeResponse actualParseFromResult = JsInvokeProtos.JsInvokeResponse
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(1, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(8, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(6);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    Descriptors.EnumDescriptor enumType = getResult4.getEnumType();
    assertSame(file, enumType.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(3);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType2.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(0));
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult5.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult6.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, messageTypes.get(7));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(InputStream) with 'InputStream'")
  void testJsInvokeResponseParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsInvokeResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsInvokeResponse
   * {@link JsInvokeResponse#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testJsInvokeResponseParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsInvokeResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsInvokeResponse
   * {@link JsInvokeResponse#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testJsInvokeResponseParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
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
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testJsInvokeResponseParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsInvokeResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsInvokeResponse {@link JsInvokeResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsInvokeResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsInvokeResponse parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testJsInvokeResponseParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JsInvokeProtos.JsInvokeResponse actualParseFromResult = JsInvokeProtos.JsInvokeResponse
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(1, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(8, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(6);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    Descriptors.EnumDescriptor enumType = getResult4.getEnumType();
    assertSame(file, enumType.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(3);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType2.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(0));
    DescriptorProtos.FieldOptions options4 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult5.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult6.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, messageTypes.get(7));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#equals(Object)}, and
   * {@link JsReleaseRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsReleaseRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsReleaseRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsReleaseRequest equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test JsReleaseRequest {@link JsReleaseRequest#equals(Object)}, and
   * {@link JsReleaseRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsReleaseRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsReleaseRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsReleaseRequest equals(Object), and hashCode(); when other is same; then return equal")
  void testJsReleaseRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsReleaseRequest defaultInstance = JsInvokeProtos.JsReleaseRequest.getDefaultInstance();

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
   * Method under test: {@link JsInvokeProtos.JsReleaseRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest equals(Object); when other is different; then return not equal")
  void testJsReleaseRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsReleaseRequest.getDefaultInstance(), 1);
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsReleaseRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest equals(Object); when other is 'null'; then return not equal")
  void testJsReleaseRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsReleaseRequest.getDefaultInstance(), null);
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsReleaseRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest equals(Object); when other is wrong type; then return not equal")
  void testJsReleaseRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsReleaseRequest.getDefaultInstance(), "Different type to JsReleaseRequest");
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test JsReleaseRequest getDefaultInstanceForType()")
  void testJsReleaseRequestGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.JsReleaseRequest defaultInstance = JsInvokeProtos.JsReleaseRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#getFunctionName()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsReleaseRequest#getFunctionName()}
   */
  @Test
  @DisplayName("Test JsReleaseRequest getFunctionName()")
  void testJsReleaseRequestGetFunctionName() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsReleaseRequest.getDefaultInstance().getFunctionName());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#getFunctionNameBytes()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#getFunctionNameBytes()}
   */
  @Test
  @DisplayName("Test JsReleaseRequest getFunctionNameBytes()")
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
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
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
    assertEquals(byteString, actualFunctionNameBytes);
    assertEquals(byteString, defaultInstance.getScriptHashBytes());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#getScriptHash()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsReleaseRequest#getScriptHash()}
   */
  @Test
  @DisplayName("Test JsReleaseRequest getScriptHash()")
  void testJsReleaseRequestGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsReleaseRequest.getDefaultInstance().getScriptHash());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#getScriptHashBytes()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#getScriptHashBytes()}
   */
  @Test
  @DisplayName("Test JsReleaseRequest getScriptHashBytes()")
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
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
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
    assertEquals(byteString, defaultInstance.getFunctionNameBytes());
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test JsReleaseRequest getSerializedSize()")
  void testJsReleaseRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsReleaseRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#isInitialized()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsReleaseRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test JsReleaseRequest isInitialized()")
  void testJsReleaseRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.JsReleaseRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test JsReleaseRequest
   * {@link JsReleaseRequest#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest newInstance(UnusedPrivateParameter)")
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
   * Test JsReleaseRequest
   * {@link JsReleaseRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream) with 'input'")
  void testJsReleaseRequestParseDelimitedFromWithInput() throws IOException {
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
   * Test JsReleaseRequest
   * {@link JsReleaseRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream) with 'input'")
  void testJsReleaseRequestParseDelimitedFromWithInput2() throws IOException {
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
   * Test JsReleaseRequest
   * {@link JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsReleaseRequestParseDelimitedFromWithInputExtensionRegistry() throws IOException {
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
   * Test JsReleaseRequest
   * {@link JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsReleaseRequestParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
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
   * Test JsReleaseRequest
   * {@link JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsReleaseRequestParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
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
   * Test JsReleaseRequest
   * {@link JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testJsReleaseRequestParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsReleaseRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsReleaseRequest
   * {@link JsReleaseRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testJsReleaseRequestParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsReleaseRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsReleaseRequest
   * {@link JsReleaseRequest#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testJsReleaseRequestParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
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
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(InputStream) with 'InputStream'")
  void testJsReleaseRequestParseFromWithInputStream() throws IOException {
    // Arrange and Act
    JsInvokeProtos.JsReleaseRequest actualParseFromResult = JsInvokeProtos.JsReleaseRequest
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(1, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(8, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(6);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(7);
    assertSame(file, getResult5.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(InputStream) with 'InputStream'")
  void testJsReleaseRequestParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsReleaseRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsReleaseRequest
   * {@link JsReleaseRequest#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testJsReleaseRequestParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsReleaseRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsReleaseRequest
   * {@link JsReleaseRequest#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testJsReleaseRequestParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
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
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testJsReleaseRequestParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsReleaseRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsReleaseRequest {@link JsReleaseRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseRequest parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testJsReleaseRequestParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JsInvokeProtos.JsReleaseRequest actualParseFromResult = JsInvokeProtos.JsReleaseRequest
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(1, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(8, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(6);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(7);
    assertSame(file, getResult5.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#equals(Object)}, and
   * {@link JsReleaseResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsReleaseResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsReleaseResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsReleaseResponse equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test JsReleaseResponse {@link JsReleaseResponse#equals(Object)}, and
   * {@link JsReleaseResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.JsReleaseResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.JsReleaseResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test JsReleaseResponse equals(Object), and hashCode(); when other is same; then return equal")
  void testJsReleaseResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.JsReleaseResponse defaultInstance = JsInvokeProtos.JsReleaseResponse.getDefaultInstance();

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
   * Method under test: {@link JsInvokeProtos.JsReleaseResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse equals(Object); when other is different; then return not equal")
  void testJsReleaseResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsReleaseResponse.getDefaultInstance(), 1);
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsReleaseResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse equals(Object); when other is 'null'; then return not equal")
  void testJsReleaseResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsReleaseResponse.getDefaultInstance(), null);
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.JsReleaseResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse equals(Object); when other is wrong type; then return not equal")
  void testJsReleaseResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.JsReleaseResponse.getDefaultInstance(), "Different type to JsReleaseResponse");
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test JsReleaseResponse getDefaultInstanceForType()")
  void testJsReleaseResponseGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.JsReleaseResponse defaultInstance = JsInvokeProtos.JsReleaseResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#getScriptHash()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsReleaseResponse#getScriptHash()}
   */
  @Test
  @DisplayName("Test JsReleaseResponse getScriptHash()")
  void testJsReleaseResponseGetScriptHash() {
    // Arrange, Act and Assert
    assertEquals("", JsInvokeProtos.JsReleaseResponse.getDefaultInstance().getScriptHash());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#getScriptHashBytes()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#getScriptHashBytes()}
   */
  @Test
  @DisplayName("Test JsReleaseResponse getScriptHashBytes()")
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
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    assertEquals(byteString, defaultInstanceForType.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, defaultInstanceForType.getJsonNameBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getTypeNameBytes());
    assertEquals(byteString, toProtoResult.getTypeNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
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
    assertEquals(byteString, actualScriptHashBytes);
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#getSerializedSize()}
   */
  @Test
  @DisplayName("Test JsReleaseResponse getSerializedSize()")
  void testJsReleaseResponseGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.JsReleaseResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#isInitialized()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.JsReleaseResponse#isInitialized()}
   */
  @Test
  @DisplayName("Test JsReleaseResponse isInitialized()")
  void testJsReleaseResponseIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.JsReleaseResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Test JsReleaseResponse
   * {@link JsReleaseResponse#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse newInstance(UnusedPrivateParameter)")
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
   * Test JsReleaseResponse
   * {@link JsReleaseResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream) with 'input'")
  void testJsReleaseResponseParseDelimitedFromWithInput() throws IOException {
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
   * Test JsReleaseResponse
   * {@link JsReleaseResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream) with 'input'")
  void testJsReleaseResponseParseDelimitedFromWithInput2() throws IOException {
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
   * Test JsReleaseResponse
   * {@link JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsReleaseResponseParseDelimitedFromWithInputExtensionRegistry() throws IOException {
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
   * Test JsReleaseResponse
   * {@link JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsReleaseResponseParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
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
   * Test JsReleaseResponse
   * {@link JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testJsReleaseResponseParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
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
   * Test JsReleaseResponse
   * {@link JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testJsReleaseResponseParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsReleaseResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsReleaseResponse
   * {@link JsReleaseResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testJsReleaseResponseParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.JsReleaseResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test JsReleaseResponse
   * {@link JsReleaseResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testJsReleaseResponseParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
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
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(InputStream) with 'InputStream'")
  void testJsReleaseResponseParseFromWithInputStream() throws IOException {
    // Arrange and Act
    JsInvokeProtos.JsReleaseResponse actualParseFromResult = JsInvokeProtos.JsReleaseResponse
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(1, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(8, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(6);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(7);
    assertSame(file, getResult5.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(InputStream) with 'InputStream'")
  void testJsReleaseResponseParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.JsReleaseResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsReleaseResponse
   * {@link JsReleaseResponse#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testJsReleaseResponseParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.JsReleaseResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsReleaseResponse
   * {@link JsReleaseResponse#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testJsReleaseResponseParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
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
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testJsReleaseResponseParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.JsReleaseResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test JsReleaseResponse {@link JsReleaseResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.JsReleaseResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test JsReleaseResponse parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testJsReleaseResponseParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JsInvokeProtos.JsReleaseResponse actualParseFromResult = JsInvokeProtos.JsReleaseResponse
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(1, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(8, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(6);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(7);
    assertSame(file, getResult5.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#equals(Object)}, and
   * {@link RemoteJsRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.RemoteJsRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.RemoteJsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test RemoteJsRequest equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test RemoteJsRequest {@link RemoteJsRequest#equals(Object)}, and
   * {@link RemoteJsRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.RemoteJsRequest#equals(Object)}
   *   <li>{@link JsInvokeProtos.RemoteJsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test RemoteJsRequest equals(Object), and hashCode(); when other is same; then return equal")
  void testRemoteJsRequestEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.RemoteJsRequest defaultInstance = JsInvokeProtos.RemoteJsRequest.getDefaultInstance();

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
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest equals(Object); when other is different; then return not equal")
  void testRemoteJsRequestEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.RemoteJsRequest.getDefaultInstance(), 1);
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest equals(Object); when other is 'null'; then return not equal")
  void testRemoteJsRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.RemoteJsRequest.getDefaultInstance(), null);
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest equals(Object); when other is wrong type; then return not equal")
  void testRemoteJsRequestEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.RemoteJsRequest.getDefaultInstance(), "Different type to RemoteJsRequest");
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest getDefaultInstanceForType()")
  void testRemoteJsRequestGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.RemoteJsRequest defaultInstance = JsInvokeProtos.RemoteJsRequest.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#getSerializedSize()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#getSerializedSize()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest getSerializedSize()")
  void testRemoteJsRequestGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.RemoteJsRequest.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#hasCompileRequest()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#hasCompileRequest()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest hasCompileRequest()")
  void testRemoteJsRequestHasCompileRequest() {
    // Arrange, Act and Assert
    assertFalse(JsInvokeProtos.RemoteJsRequest.getDefaultInstance().hasCompileRequest());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#hasInvokeRequest()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#hasInvokeRequest()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest hasInvokeRequest()")
  void testRemoteJsRequestHasInvokeRequest() {
    // Arrange, Act and Assert
    assertFalse(JsInvokeProtos.RemoteJsRequest.getDefaultInstance().hasInvokeRequest());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#hasReleaseRequest()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#hasReleaseRequest()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest hasReleaseRequest()")
  void testRemoteJsRequestHasReleaseRequest() {
    // Arrange, Act and Assert
    assertFalse(JsInvokeProtos.RemoteJsRequest.getDefaultInstance().hasReleaseRequest());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#isInitialized()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.RemoteJsRequest#isInitialized()}
   */
  @Test
  @DisplayName("Test RemoteJsRequest isInitialized()")
  void testRemoteJsRequestIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.RemoteJsRequest.getDefaultInstance().isInitialized());
  }

  /**
   * Test RemoteJsRequest
   * {@link RemoteJsRequest#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest newInstance(UnusedPrivateParameter)")
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
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream) with 'input'")
  void testRemoteJsRequestParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsInvokeProtos.RemoteJsRequest actualParseDelimitedFromResult = JsInvokeProtos.RemoteJsRequest
        .parseDelimitedFrom(input);

    // Assert
    JsInvokeProtos.JsCompileRequest compileRequest = actualParseDelimitedFromResult.getCompileRequest();
    UnknownFieldSet unknownFields = compileRequest.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = compileRequest.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(3, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(3, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(3, fields2.size());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult3.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult3.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType2.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    JsInvokeProtos.JsInvokeRequest invokeRequest = actualParseDelimitedFromResult.getInvokeRequest();
    Descriptors.Descriptor descriptorForType3 = invokeRequest.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    JsInvokeProtos.JsReleaseRequest releaseRequest = actualParseDelimitedFromResult.getReleaseRequest();
    Descriptors.Descriptor descriptorForType4 = releaseRequest.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(7);
    assertSame(file, getResult3.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(2);
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(2);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType4.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult8.toProto();
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult.getMessageType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(6));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    JsInvokeProtos.RemoteJsRequest defaultInstanceForType3 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType3.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, invokeRequest.getUnknownFields());
    assertSame(unknownFields, releaseRequest.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    ProtocolStringList argsList = invokeRequest.getArgsList();
    assertSame(argsList, defaultInstanceForType.getReservedNameList());
    assertSame(argsList, toProtoResult.getReservedNameList());
    assertSame(argsList, toProtoResult4.getReservedNameList());
    assertSame(argsList, toProtoResult5.getReservedNameList());
    assertSame(argsList, toProtoResult2.getReservedNameList());
    assertSame(argsList, toProtoResult3.getDependencyList());
    assertSame(compileRequest, compileRequest.getDefaultInstanceForType());
    assertSame(compileRequest, defaultInstanceForType3.getCompileRequest());
    assertSame(compileRequest, defaultInstanceForType3.getCompileRequestOrBuilder());
    assertSame(compileRequest, actualParseDelimitedFromResult.getCompileRequestOrBuilder());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(invokeRequest, invokeRequest.getDefaultInstanceForType());
    assertSame(invokeRequest, defaultInstanceForType3.getInvokeRequest());
    assertSame(invokeRequest, defaultInstanceForType3.getInvokeRequestOrBuilder());
    assertSame(invokeRequest, actualParseDelimitedFromResult.getInvokeRequestOrBuilder());
    assertSame(releaseRequest, releaseRequest.getDefaultInstanceForType());
    assertSame(releaseRequest, defaultInstanceForType3.getReleaseRequest());
    assertSame(releaseRequest, defaultInstanceForType3.getReleaseRequestOrBuilder());
    assertSame(releaseRequest, actualParseDelimitedFromResult.getReleaseRequestOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream) with 'input'")
  void testRemoteJsRequestParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsInvokeProtos.RemoteJsRequest actualParseDelimitedFromResult = JsInvokeProtos.RemoteJsRequest
        .parseDelimitedFrom(input);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals("", defaultInstanceForType.getJavaOuterClassname());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    JsInvokeProtos.JsCompileRequest compileRequest = actualParseDelimitedFromResult.getCompileRequest();
    Descriptors.Descriptor descriptorForType2 = compileRequest.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(3, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(3, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(3, fields2.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertFalse(defaultInstanceForType.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType.getJavaGenericServices());
    assertFalse(defaultInstanceForType.getJavaMultipleFiles());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult3.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    JsInvokeProtos.JsInvokeRequest invokeRequest = actualParseDelimitedFromResult.getInvokeRequest();
    Descriptors.Descriptor descriptorForType3 = invokeRequest.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    JsInvokeProtos.JsReleaseRequest releaseRequest = actualParseDelimitedFromResult.getReleaseRequest();
    Descriptors.Descriptor descriptorForType4 = releaseRequest.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(7);
    assertSame(file, getResult3.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(2);
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(2);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType2.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType4.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult8.toProto();
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult.getMessageType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(6));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, compileRequest.getUnknownFields());
    assertSame(unknownFields, invokeRequest.getUnknownFields());
    assertSame(unknownFields, releaseRequest.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList argsList = invokeRequest.getArgsList();
    assertSame(argsList, defaultInstanceForType2.getReservedNameList());
    assertSame(argsList, toProtoResult.getReservedNameList());
    assertSame(argsList, toProtoResult4.getReservedNameList());
    assertSame(argsList, toProtoResult5.getReservedNameList());
    assertSame(argsList, toProtoResult2.getReservedNameList());
    assertSame(argsList, toProtoResult3.getDependencyList());
    assertSame(compileRequest, compileRequest.getDefaultInstanceForType());
    assertSame(compileRequest, actualParseDelimitedFromResult.getCompileRequestOrBuilder());
    assertSame(invokeRequest, invokeRequest.getDefaultInstanceForType());
    assertSame(invokeRequest, actualParseDelimitedFromResult.getInvokeRequestOrBuilder());
    assertSame(releaseRequest, releaseRequest.getDefaultInstanceForType());
    assertSame(releaseRequest, actualParseDelimitedFromResult.getReleaseRequestOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream) with 'input'")
  void testRemoteJsRequestParseDelimitedFromWithInput3() throws IOException {
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
   * Test RemoteJsRequest
   * {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testRemoteJsRequestParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsInvokeProtos.RemoteJsRequest actualParseDelimitedFromResult = JsInvokeProtos.RemoteJsRequest
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    JsInvokeProtos.JsCompileRequest compileRequest = actualParseDelimitedFromResult.getCompileRequest();
    UnknownFieldSet unknownFields = compileRequest.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = compileRequest.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(3, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(3, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(3, fields2.size());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult3.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult3.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType2.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    JsInvokeProtos.JsInvokeRequest invokeRequest = actualParseDelimitedFromResult.getInvokeRequest();
    Descriptors.Descriptor descriptorForType3 = invokeRequest.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    JsInvokeProtos.JsReleaseRequest releaseRequest = actualParseDelimitedFromResult.getReleaseRequest();
    Descriptors.Descriptor descriptorForType4 = releaseRequest.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(7);
    assertSame(file, getResult3.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(2);
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(2);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType4.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult8.toProto();
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult.getMessageType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(6));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    JsInvokeProtos.RemoteJsRequest defaultInstanceForType3 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType3.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, invokeRequest.getUnknownFields());
    assertSame(unknownFields, releaseRequest.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    ProtocolStringList argsList = invokeRequest.getArgsList();
    assertSame(argsList, defaultInstanceForType.getReservedNameList());
    assertSame(argsList, toProtoResult.getReservedNameList());
    assertSame(argsList, toProtoResult4.getReservedNameList());
    assertSame(argsList, toProtoResult5.getReservedNameList());
    assertSame(argsList, toProtoResult2.getReservedNameList());
    assertSame(argsList, toProtoResult3.getDependencyList());
    assertSame(compileRequest, compileRequest.getDefaultInstanceForType());
    assertSame(compileRequest, defaultInstanceForType3.getCompileRequest());
    assertSame(compileRequest, defaultInstanceForType3.getCompileRequestOrBuilder());
    assertSame(compileRequest, actualParseDelimitedFromResult.getCompileRequestOrBuilder());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(invokeRequest, invokeRequest.getDefaultInstanceForType());
    assertSame(invokeRequest, defaultInstanceForType3.getInvokeRequest());
    assertSame(invokeRequest, defaultInstanceForType3.getInvokeRequestOrBuilder());
    assertSame(invokeRequest, actualParseDelimitedFromResult.getInvokeRequestOrBuilder());
    assertSame(releaseRequest, releaseRequest.getDefaultInstanceForType());
    assertSame(releaseRequest, defaultInstanceForType3.getReleaseRequest());
    assertSame(releaseRequest, defaultInstanceForType3.getReleaseRequestOrBuilder());
    assertSame(releaseRequest, actualParseDelimitedFromResult.getReleaseRequestOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsRequest
   * {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testRemoteJsRequestParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsInvokeProtos.RemoteJsRequest actualParseDelimitedFromResult = JsInvokeProtos.RemoteJsRequest
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals("", defaultInstanceForType.getJavaOuterClassname());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    JsInvokeProtos.JsCompileRequest compileRequest = actualParseDelimitedFromResult.getCompileRequest();
    Descriptors.Descriptor descriptorForType2 = compileRequest.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(3, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(3, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(3, fields2.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertFalse(defaultInstanceForType.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType.getJavaGenericServices());
    assertFalse(defaultInstanceForType.getJavaMultipleFiles());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult3.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult3.getWeakDependencyList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    JsInvokeProtos.JsInvokeRequest invokeRequest = actualParseDelimitedFromResult.getInvokeRequest();
    Descriptors.Descriptor descriptorForType3 = invokeRequest.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    JsInvokeProtos.JsReleaseRequest releaseRequest = actualParseDelimitedFromResult.getReleaseRequest();
    Descriptors.Descriptor descriptorForType4 = releaseRequest.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(7);
    assertSame(file, getResult3.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(2);
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(2);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType2.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType4.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult8.toProto();
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult.getMessageType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(6));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, compileRequest.getUnknownFields());
    assertSame(unknownFields, invokeRequest.getUnknownFields());
    assertSame(unknownFields, releaseRequest.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList argsList = invokeRequest.getArgsList();
    assertSame(argsList, defaultInstanceForType2.getReservedNameList());
    assertSame(argsList, toProtoResult.getReservedNameList());
    assertSame(argsList, toProtoResult4.getReservedNameList());
    assertSame(argsList, toProtoResult5.getReservedNameList());
    assertSame(argsList, toProtoResult2.getReservedNameList());
    assertSame(argsList, toProtoResult3.getDependencyList());
    assertSame(compileRequest, compileRequest.getDefaultInstanceForType());
    assertSame(compileRequest, actualParseDelimitedFromResult.getCompileRequestOrBuilder());
    assertSame(invokeRequest, invokeRequest.getDefaultInstanceForType());
    assertSame(invokeRequest, actualParseDelimitedFromResult.getInvokeRequestOrBuilder());
    assertSame(releaseRequest, releaseRequest.getDefaultInstanceForType());
    assertSame(releaseRequest, actualParseDelimitedFromResult.getReleaseRequestOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsRequest
   * {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testRemoteJsRequestParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
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
   * Test RemoteJsRequest
   * {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testRemoteJsRequestParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
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
   * Test RemoteJsRequest
   * {@link RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testRemoteJsRequestParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.RemoteJsRequest.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testRemoteJsRequestParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.RemoteJsRequest.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseDelimitedFrom(InputStream)}
   * with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testRemoteJsRequestParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
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
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(InputStream) with 'InputStream'")
  void testRemoteJsRequestParseFromWithInputStream() throws IOException {
    // Arrange and Act
    JsInvokeProtos.RemoteJsRequest actualParseFromResult = JsInvokeProtos.RemoteJsRequest
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    JsInvokeProtos.JsCompileRequest compileRequest = actualParseFromResult.getCompileRequest();
    Descriptors.Descriptor descriptorForType2 = compileRequest.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(3, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(3, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(3, fields2.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult3.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult3.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType2.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    JsInvokeProtos.JsInvokeRequest invokeRequest = actualParseFromResult.getInvokeRequest();
    Descriptors.Descriptor descriptorForType3 = invokeRequest.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    JsInvokeProtos.JsReleaseRequest releaseRequest = actualParseFromResult.getReleaseRequest();
    Descriptors.Descriptor descriptorForType4 = releaseRequest.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(7);
    assertSame(file, getResult3.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(2);
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(2);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType4.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult8.toProto();
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult.getMessageType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(6));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, compileRequest.getUnknownFields());
    assertSame(unknownFields, invokeRequest.getUnknownFields());
    assertSame(unknownFields, releaseRequest.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList argsList = invokeRequest.getArgsList();
    assertSame(argsList, defaultInstanceForType.getReservedNameList());
    assertSame(argsList, toProtoResult.getReservedNameList());
    assertSame(argsList, toProtoResult4.getReservedNameList());
    assertSame(argsList, toProtoResult5.getReservedNameList());
    assertSame(argsList, toProtoResult2.getReservedNameList());
    assertSame(argsList, toProtoResult3.getDependencyList());
    assertSame(compileRequest, compileRequest.getDefaultInstanceForType());
    assertSame(compileRequest, actualParseFromResult.getCompileRequestOrBuilder());
    assertSame(invokeRequest, invokeRequest.getDefaultInstanceForType());
    assertSame(invokeRequest, actualParseFromResult.getInvokeRequestOrBuilder());
    assertSame(releaseRequest, releaseRequest.getDefaultInstanceForType());
    assertSame(releaseRequest, actualParseFromResult.getReleaseRequestOrBuilder());
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(InputStream) with 'InputStream'")
  void testRemoteJsRequestParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.RemoteJsRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsRequest
   * {@link RemoteJsRequest#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testRemoteJsRequestParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.RemoteJsRequest.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsRequest
   * {@link RemoteJsRequest#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testRemoteJsRequestParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
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
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testRemoteJsRequestParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.RemoteJsRequest.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsRequest {@link RemoteJsRequest#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsRequest#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsRequest parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testRemoteJsRequestParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JsInvokeProtos.RemoteJsRequest actualParseFromResult = JsInvokeProtos.RemoteJsRequest.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(1, enumTypes.size());
    JsInvokeProtos.JsCompileRequest compileRequest = actualParseFromResult.getCompileRequest();
    Descriptors.Descriptor descriptorForType2 = compileRequest.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(3, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(3, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(3, fields2.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult3.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult3.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType2.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    JsInvokeProtos.JsInvokeRequest invokeRequest = actualParseFromResult.getInvokeRequest();
    Descriptors.Descriptor descriptorForType3 = invokeRequest.getDescriptorForType();
    assertSame(file, descriptorForType3.getFile());
    JsInvokeProtos.JsReleaseRequest releaseRequest = actualParseFromResult.getReleaseRequest();
    Descriptors.Descriptor descriptorForType4 = releaseRequest.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(7);
    assertSame(file, getResult3.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(2);
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(2);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType4.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult7.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult8.toProto();
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult.getMessageType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(6));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, compileRequest.getUnknownFields());
    assertSame(unknownFields, invokeRequest.getUnknownFields());
    assertSame(unknownFields, releaseRequest.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList argsList = invokeRequest.getArgsList();
    assertSame(argsList, defaultInstanceForType.getReservedNameList());
    assertSame(argsList, toProtoResult.getReservedNameList());
    assertSame(argsList, toProtoResult4.getReservedNameList());
    assertSame(argsList, toProtoResult5.getReservedNameList());
    assertSame(argsList, toProtoResult2.getReservedNameList());
    assertSame(argsList, toProtoResult3.getDependencyList());
    assertSame(compileRequest, compileRequest.getDefaultInstanceForType());
    assertSame(compileRequest, actualParseFromResult.getCompileRequestOrBuilder());
    assertSame(invokeRequest, invokeRequest.getDefaultInstanceForType());
    assertSame(invokeRequest, actualParseFromResult.getInvokeRequestOrBuilder());
    assertSame(releaseRequest, releaseRequest.getDefaultInstanceForType());
    assertSame(releaseRequest, actualParseFromResult.getReleaseRequestOrBuilder());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#equals(Object)}, and
   * {@link RemoteJsResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.RemoteJsResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.RemoteJsResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test RemoteJsResponse equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test RemoteJsResponse {@link RemoteJsResponse#equals(Object)}, and
   * {@link RemoteJsResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsInvokeProtos.RemoteJsResponse#equals(Object)}
   *   <li>{@link JsInvokeProtos.RemoteJsResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test RemoteJsResponse equals(Object), and hashCode(); when other is same; then return equal")
  void testRemoteJsResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsInvokeProtos.RemoteJsResponse defaultInstance = JsInvokeProtos.RemoteJsResponse.getDefaultInstance();

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
   * Method under test: {@link JsInvokeProtos.RemoteJsResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse equals(Object); when other is different; then return not equal")
  void testRemoteJsResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.RemoteJsResponse.getDefaultInstance(), 1);
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.RemoteJsResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse equals(Object); when other is 'null'; then return not equal")
  void testRemoteJsResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.RemoteJsResponse.getDefaultInstance(), null);
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsInvokeProtos.RemoteJsResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse equals(Object); when other is wrong type; then return not equal")
  void testRemoteJsResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JsInvokeProtos.RemoteJsResponse.getDefaultInstance(), "Different type to RemoteJsResponse");
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse getDefaultInstanceForType()")
  void testRemoteJsResponseGetDefaultInstanceForType() {
    // Arrange
    JsInvokeProtos.RemoteJsResponse defaultInstance = JsInvokeProtos.RemoteJsResponse.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#getSerializedSize()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse getSerializedSize()")
  void testRemoteJsResponseGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, JsInvokeProtos.RemoteJsResponse.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#hasCompileResponse()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#hasCompileResponse()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse hasCompileResponse()")
  void testRemoteJsResponseHasCompileResponse() {
    // Arrange, Act and Assert
    assertFalse(JsInvokeProtos.RemoteJsResponse.getDefaultInstance().hasCompileResponse());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#hasInvokeResponse()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#hasInvokeResponse()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse hasInvokeResponse()")
  void testRemoteJsResponseHasInvokeResponse() {
    // Arrange, Act and Assert
    assertFalse(JsInvokeProtos.RemoteJsResponse.getDefaultInstance().hasInvokeResponse());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#hasReleaseResponse()}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#hasReleaseResponse()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse hasReleaseResponse()")
  void testRemoteJsResponseHasReleaseResponse() {
    // Arrange, Act and Assert
    assertFalse(JsInvokeProtos.RemoteJsResponse.getDefaultInstance().hasReleaseResponse());
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#isInitialized()}.
   * <p>
   * Method under test: {@link JsInvokeProtos.RemoteJsResponse#isInitialized()}
   */
  @Test
  @DisplayName("Test RemoteJsResponse isInitialized()")
  void testRemoteJsResponseIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(JsInvokeProtos.RemoteJsResponse.getDefaultInstance().isInitialized());
  }

  /**
   * Test RemoteJsResponse
   * {@link RemoteJsResponse#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse newInstance(UnusedPrivateParameter)")
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
   * Test RemoteJsResponse
   * {@link RemoteJsResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream) with 'input'")
  void testRemoteJsResponseParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsInvokeProtos.RemoteJsResponse actualParseDelimitedFromResult = JsInvokeProtos.RemoteJsResponse
        .parseDelimitedFrom(input);

    // Assert
    JsInvokeProtos.JsCompileResponse compileResponse = actualParseDelimitedFromResult.getCompileResponse();
    UnknownFieldSet unknownFields = compileResponse.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType = compileResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    JsInvokeProtos.JsInvokeResponse invokeResponse = actualParseDelimitedFromResult.getInvokeResponse();
    Descriptors.Descriptor descriptorForType3 = invokeResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    JsInvokeProtos.JsReleaseResponse releaseResponse = actualParseDelimitedFromResult.getReleaseResponse();
    Descriptors.Descriptor descriptorForType4 = releaseResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file.toProto();
    assertSame(reservedNameList, toProtoResult5.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult5.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult5.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(3);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(3);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(4);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options2, toProtoResult8.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, toProtoResult8.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(7));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    JsInvokeProtos.RemoteJsResponse defaultInstanceForType2 = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType2, defaultInstanceForType2.getDescriptorForType());
    assertSame(descriptorForType2, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, defaultInstanceForType2.getCompileResponse());
    assertSame(compileResponse, defaultInstanceForType2.getCompileResponseOrBuilder());
    assertSame(compileResponse, actualParseDelimitedFromResult.getCompileResponseOrBuilder());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, defaultInstanceForType2.getInvokeResponse());
    assertSame(invokeResponse, defaultInstanceForType2.getInvokeResponseOrBuilder());
    assertSame(invokeResponse, actualParseDelimitedFromResult.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, defaultInstanceForType2.getReleaseResponse());
    assertSame(releaseResponse, defaultInstanceForType2.getReleaseResponseOrBuilder());
    assertSame(releaseResponse, actualParseDelimitedFromResult.getReleaseResponseOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsResponse
   * {@link RemoteJsResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream) with 'input'")
  void testRemoteJsResponseParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsInvokeProtos.RemoteJsResponse actualParseDelimitedFromResult = JsInvokeProtos.RemoteJsResponse
        .parseDelimitedFrom(input);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(4);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", toProtoResult.getExtendee());
    assertEquals("", toProtoResult.getJsonName());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    JsInvokeProtos.JsCompileResponse compileResponse = actualParseDelimitedFromResult.getCompileResponse();
    Descriptors.Descriptor descriptorForType2 = compileResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(4, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult3.getFieldList();
    assertEquals(5, fieldList2.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult3.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult3.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    JsInvokeProtos.JsInvokeResponse invokeResponse = actualParseDelimitedFromResult.getInvokeResponse();
    Descriptors.Descriptor descriptorForType3 = invokeResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    JsInvokeProtos.JsReleaseResponse releaseResponse = actualParseDelimitedFromResult.getReleaseResponse();
    Descriptors.Descriptor descriptorForType4 = releaseResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult6 = file.toProto();
    assertSame(reservedNameList, toProtoResult6.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult6.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult6.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult2.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields2.get(1);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(2);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(3);
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(3);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options2, toProtoResult8.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult9 = getResult8.toProto();
    assertSame(options2, toProtoResult9.getOptions());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, toProtoResult8.getOptionsOrBuilder());
    assertSame(options2, toProtoResult9.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options2, getResult.getOptions());
    assertSame(toProtoResult7, fieldList2.get(0));
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult3.getContainingType());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType3, getResult8.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(7));
    assertSame(descriptorForType4, getResult.getMessageType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, toProtoResult9.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, compileResponse.getUnknownFields());
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, actualParseDelimitedFromResult.getCompileResponseOrBuilder());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, actualParseDelimitedFromResult.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, actualParseDelimitedFromResult.getReleaseResponseOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsResponse
   * {@link RemoteJsResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream) with 'input'")
  void testRemoteJsResponseParseDelimitedFromWithInput3() throws IOException {
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
   * Test RemoteJsResponse
   * {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testRemoteJsResponseParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsInvokeProtos.RemoteJsResponse actualParseDelimitedFromResult = JsInvokeProtos.RemoteJsResponse
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    JsInvokeProtos.JsCompileResponse compileResponse = actualParseDelimitedFromResult.getCompileResponse();
    UnknownFieldSet unknownFields = compileResponse.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType = compileResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    JsInvokeProtos.JsInvokeResponse invokeResponse = actualParseDelimitedFromResult.getInvokeResponse();
    Descriptors.Descriptor descriptorForType3 = invokeResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    JsInvokeProtos.JsReleaseResponse releaseResponse = actualParseDelimitedFromResult.getReleaseResponse();
    Descriptors.Descriptor descriptorForType4 = releaseResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file.toProto();
    assertSame(reservedNameList, toProtoResult5.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult5.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult5.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(3);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(3);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(4);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options2, toProtoResult8.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, toProtoResult8.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(7));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    JsInvokeProtos.RemoteJsResponse defaultInstanceForType2 = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType2, defaultInstanceForType2.getDescriptorForType());
    assertSame(descriptorForType2, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, defaultInstanceForType2.getCompileResponse());
    assertSame(compileResponse, defaultInstanceForType2.getCompileResponseOrBuilder());
    assertSame(compileResponse, actualParseDelimitedFromResult.getCompileResponseOrBuilder());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, defaultInstanceForType2.getInvokeResponse());
    assertSame(invokeResponse, defaultInstanceForType2.getInvokeResponseOrBuilder());
    assertSame(invokeResponse, actualParseDelimitedFromResult.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, defaultInstanceForType2.getReleaseResponse());
    assertSame(releaseResponse, defaultInstanceForType2.getReleaseResponseOrBuilder());
    assertSame(releaseResponse, actualParseDelimitedFromResult.getReleaseResponseOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsResponse
   * {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testRemoteJsResponseParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    JsInvokeProtos.RemoteJsResponse actualParseDelimitedFromResult = JsInvokeProtos.RemoteJsResponse
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(4);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", toProtoResult.getExtendee());
    assertEquals("", toProtoResult.getJsonName());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    JsInvokeProtos.JsCompileResponse compileResponse = actualParseDelimitedFromResult.getCompileResponse();
    Descriptors.Descriptor descriptorForType2 = compileResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(4, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult3.getFieldList();
    assertEquals(5, fieldList2.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult3.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult3.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    JsInvokeProtos.JsInvokeResponse invokeResponse = actualParseDelimitedFromResult.getInvokeResponse();
    Descriptors.Descriptor descriptorForType3 = invokeResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    JsInvokeProtos.JsReleaseResponse releaseResponse = actualParseDelimitedFromResult.getReleaseResponse();
    Descriptors.Descriptor descriptorForType4 = releaseResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult6 = file.toProto();
    assertSame(reservedNameList, toProtoResult6.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult6.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult6.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult2.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields2.get(1);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(2);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(3);
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(3);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options2, toProtoResult8.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult9 = getResult8.toProto();
    assertSame(options2, toProtoResult9.getOptions());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, toProtoResult8.getOptionsOrBuilder());
    assertSame(options2, toProtoResult9.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options2, getResult.getOptions());
    assertSame(toProtoResult7, fieldList2.get(0));
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult3.getContainingType());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType3, getResult8.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(7));
    assertSame(descriptorForType4, getResult.getMessageType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, toProtoResult9.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, compileResponse.getUnknownFields());
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, actualParseDelimitedFromResult.getCompileResponseOrBuilder());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, actualParseDelimitedFromResult.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, actualParseDelimitedFromResult.getReleaseResponseOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test RemoteJsResponse
   * {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testRemoteJsResponseParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
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
   * Test RemoteJsResponse
   * {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testRemoteJsResponseParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
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
   * Test RemoteJsResponse
   * {@link RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testRemoteJsResponseParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.RemoteJsResponse.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test RemoteJsResponse
   * {@link RemoteJsResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testRemoteJsResponseParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(JsInvokeProtos.RemoteJsResponse.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test RemoteJsResponse
   * {@link RemoteJsResponse#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testRemoteJsResponseParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
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
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(InputStream) with 'InputStream'")
  void testRemoteJsResponseParseFromWithInputStream() throws IOException {
    // Arrange and Act
    JsInvokeProtos.RemoteJsResponse actualParseFromResult = JsInvokeProtos.RemoteJsResponse
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    JsInvokeProtos.JsCompileResponse compileResponse = actualParseFromResult.getCompileResponse();
    Descriptors.Descriptor descriptorForType = compileResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.Descriptor descriptorForType2 = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    JsInvokeProtos.JsInvokeResponse invokeResponse = actualParseFromResult.getInvokeResponse();
    Descriptors.Descriptor descriptorForType3 = invokeResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    JsInvokeProtos.JsReleaseResponse releaseResponse = actualParseFromResult.getReleaseResponse();
    Descriptors.Descriptor descriptorForType4 = releaseResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file.toProto();
    assertSame(reservedNameList, toProtoResult5.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult5.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult5.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(3);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(3);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(4);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options2, toProtoResult8.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, toProtoResult8.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(7));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(1));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, compileResponse.getUnknownFields());
    assertSame(unknownFields, invokeResponse.getUnknownFields());
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
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(InputStream) with 'InputStream'")
  void testRemoteJsResponseParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> JsInvokeProtos.RemoteJsResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsResponse
   * {@link RemoteJsResponse#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testRemoteJsResponseParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> JsInvokeProtos.RemoteJsResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsResponse
   * {@link RemoteJsResponse#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testRemoteJsResponseParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> JsInvokeProtos.RemoteJsResponse.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testRemoteJsResponseParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> JsInvokeProtos.RemoteJsResponse.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test RemoteJsResponse {@link RemoteJsResponse#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsInvokeProtos.RemoteJsResponse#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test RemoteJsResponse parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testRemoteJsResponseParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    JsInvokeProtos.RemoteJsResponse actualParseFromResult = JsInvokeProtos.RemoteJsResponse
        .parseFrom((InputStream) null);

    // Assert
    JsInvokeProtos.JsCompileResponse compileResponse = actualParseFromResult.getCompileResponse();
    Descriptors.Descriptor descriptorForType = compileResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.Descriptor descriptorForType2 = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    JsInvokeProtos.JsInvokeResponse invokeResponse = actualParseFromResult.getInvokeResponse();
    Descriptors.Descriptor descriptorForType3 = invokeResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    JsInvokeProtos.JsReleaseResponse releaseResponse = actualParseFromResult.getReleaseResponse();
    Descriptors.Descriptor descriptorForType4 = releaseResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file.toProto();
    assertSame(reservedNameList, toProtoResult5.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult5.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult5.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(3);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(3);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(4);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options2, toProtoResult8.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, toProtoResult8.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(7));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(1));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, compileResponse.getUnknownFields());
    assertSame(unknownFields, invokeResponse.getUnknownFields());
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
