package org.thingsboard.server.gen.edge.v1;

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

class ConnectRequestMsgDiffblueTest {
  /**
   * Test {@link ConnectRequestMsg#equals(Object)}, and
   * {@link ConnectRequestMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ConnectRequestMsg#equals(Object)}
   *   <li>{@link ConnectRequestMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConnectRequestMsg defaultInstance = ConnectRequestMsg.getDefaultInstance();
    ConnectRequestMsg defaultInstance2 = ConnectRequestMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link ConnectRequestMsg#equals(Object)}, and
   * {@link ConnectRequestMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ConnectRequestMsg#equals(Object)}
   *   <li>{@link ConnectRequestMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConnectRequestMsg defaultInstance = ConnectRequestMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link ConnectRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ConnectRequestMsg.getDefaultInstance(), 1);
  }

  /**
   * Test {@link ConnectRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ConnectRequestMsg.getDefaultInstance(), null);
  }

  /**
   * Test {@link ConnectRequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectRequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ConnectRequestMsg.getDefaultInstance(), "Different type to ConnectRequestMsg");
  }

  /**
   * Test {@link ConnectRequestMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ConnectRequestMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  void testGetDefaultInstanceForType() {
    // Arrange
    ConnectRequestMsg defaultInstance = ConnectRequestMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link ConnectRequestMsg#getEdgeRoutingKey()}.
   * <p>
   * Method under test: {@link ConnectRequestMsg#getEdgeRoutingKey()}
   */
  @Test
  @DisplayName("Test getEdgeRoutingKey()")
  void testGetEdgeRoutingKey() {
    // Arrange, Act and Assert
    assertEquals("", ConnectRequestMsg.getDefaultInstance().getEdgeRoutingKey());
  }

  /**
   * Test {@link ConnectRequestMsg#getEdgeRoutingKeyBytes()}.
   * <p>
   * Method under test: {@link ConnectRequestMsg#getEdgeRoutingKeyBytes()}
   */
  @Test
  @DisplayName("Test getEdgeRoutingKeyBytes()")
  void testGetEdgeRoutingKeyBytes() {
    // Arrange
    ConnectRequestMsg defaultInstance = ConnectRequestMsg.getDefaultInstance();

    // Act
    ByteString actualEdgeRoutingKeyBytes = defaultInstance.getEdgeRoutingKeyBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualEdgeRoutingKeyBytes.EMPTY;
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
    assertEquals(byteString, actualEdgeRoutingKeyBytes);
    assertEquals(byteString, defaultInstance.getEdgeSecretBytes());
  }

  /**
   * Test {@link ConnectRequestMsg#getEdgeSecret()}.
   * <p>
   * Method under test: {@link ConnectRequestMsg#getEdgeSecret()}
   */
  @Test
  @DisplayName("Test getEdgeSecret()")
  void testGetEdgeSecret() {
    // Arrange, Act and Assert
    assertEquals("", ConnectRequestMsg.getDefaultInstance().getEdgeSecret());
  }

  /**
   * Test {@link ConnectRequestMsg#getEdgeSecretBytes()}.
   * <p>
   * Method under test: {@link ConnectRequestMsg#getEdgeSecretBytes()}
   */
  @Test
  @DisplayName("Test getEdgeSecretBytes()")
  void testGetEdgeSecretBytes() {
    // Arrange
    ConnectRequestMsg defaultInstance = ConnectRequestMsg.getDefaultInstance();

    // Act
    ByteString actualEdgeSecretBytes = defaultInstance.getEdgeSecretBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualEdgeSecretBytes.EMPTY;
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
    assertEquals(byteString, defaultInstance.getEdgeRoutingKeyBytes());
    assertEquals(byteString, actualEdgeSecretBytes);
  }

  /**
   * Test {@link ConnectRequestMsg#getEdgeVersion()}.
   * <p>
   * Method under test: {@link ConnectRequestMsg#getEdgeVersion()}
   */
  @Test
  @DisplayName("Test getEdgeVersion()")
  void testGetEdgeVersion() {
    // Arrange, Act and Assert
    assertEquals(EdgeVersion.V_3_3_0, ConnectRequestMsg.getDefaultInstance().getEdgeVersion());
  }

  /**
   * Test {@link ConnectRequestMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link ConnectRequestMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ConnectRequestMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link ConnectRequestMsg#hasMaxInboundMessageSize()}.
   * <p>
   * Method under test: {@link ConnectRequestMsg#hasMaxInboundMessageSize()}
   */
  @Test
  @DisplayName("Test hasMaxInboundMessageSize()")
  void testHasMaxInboundMessageSize() {
    // Arrange, Act and Assert
    assertFalse(ConnectRequestMsg.getDefaultInstance().hasMaxInboundMessageSize());
  }

  /**
   * Test {@link ConnectRequestMsg#isInitialized()}.
   * <p>
   * Method under test: {@link ConnectRequestMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ConnectRequestMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link ConnectRequestMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link ConnectRequestMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test newInstance(UnusedPrivateParameter)")
  void testNewInstance() {
    // Arrange
    ConnectRequestMsg defaultInstance = ConnectRequestMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ConnectRequestMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test
   * {@link ConnectRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link ConnectRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ConnectRequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link ConnectRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link ConnectRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ConnectRequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link ConnectRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConnectRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ConnectRequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test
   * {@link ConnectRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConnectRequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ConnectRequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ConnectRequestMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ConnectRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ConnectRequestMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ConnectRequestMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ConnectRequestMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ConnectRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ConnectRequestMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectRequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ConnectRequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ConnectRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link ConnectRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ConnectRequestMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ConnectRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConnectRequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ConnectRequestMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ConnectRequestMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ConnectRequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ConnectRequestMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ConnectRequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ConnectRequestMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty
   * array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    ConnectRequestMsg actualParseFromResult = ConnectRequestMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.ServiceDescriptorProto> serviceList = toProtoResult2.getServiceList();
    assertEquals(1, serviceList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    Descriptors.OneofDescriptor getResult = oneofs.get(0);
    List<Descriptors.FieldDescriptor> fields = getResult.getFields();
    assertEquals(1, fields.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(4, fields2.size());
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(5, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(58, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(serviceList, toProtoResult2.getServiceOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(1);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(56);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(57);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(2);
    Descriptors.EnumDescriptor enumType = getResult7.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(1);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult9 = fields2.get(3);
    assertSame(file, getResult9.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, services.get(0).getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(0));
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult2.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult8.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult9.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult9.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    DescriptorProtos.OneofOptions options5 = getResult.getOptions();
    assertSame(options5, options5.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult9, fields.get(0));
    assertSame(getResult, getResult9.getContainingOneof());
  }

  /**
   * Test {@link ConnectRequestMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectRequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ConnectRequestMsg actualParseFromResult = ConnectRequestMsg.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.ServiceDescriptorProto> serviceList = toProtoResult2.getServiceList();
    assertEquals(1, serviceList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    Descriptors.OneofDescriptor getResult = oneofs.get(0);
    List<Descriptors.FieldDescriptor> fields = getResult.getFields();
    assertEquals(1, fields.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(4, fields2.size());
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(5, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(58, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(serviceList, toProtoResult2.getServiceOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(1);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(56);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(57);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(2);
    Descriptors.EnumDescriptor enumType = getResult7.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(1);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult9 = fields2.get(3);
    assertSame(file, getResult9.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, services.get(0).getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(0));
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult2.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult8.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult9.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult9.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    DescriptorProtos.OneofOptions options5 = getResult.getOptions();
    assertSame(options5, options5.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult9, fields.get(0));
    assertSame(getResult, getResult9.getContainingOneof());
  }
}
