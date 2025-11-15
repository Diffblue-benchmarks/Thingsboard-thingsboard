package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class AttributeDeleteMsgDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeDeleteMsg#equals(Object)}
   *   <li>{@link AttributeDeleteMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AttributeDeleteMsg defaultInstance = AttributeDeleteMsg.getDefaultInstance();
    AttributeDeleteMsg defaultInstance2 = AttributeDeleteMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeDeleteMsg#equals(Object)}
   *   <li>{@link AttributeDeleteMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributeDeleteMsg defaultInstance = AttributeDeleteMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AttributeDeleteMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AttributeDeleteMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AttributeDeleteMsg.getDefaultInstance(), "Different type to AttributeDeleteMsg");
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#getAttributeNamesCount()}
   */
  @Test
  void testGetAttributeNamesCount() {
    // Arrange, Act and Assert
    assertEquals(0, AttributeDeleteMsg.getDefaultInstance().getAttributeNamesCount());
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#getAttributeNamesList()}
   */
  @Test
  void testGetAttributeNamesList() {
    // Arrange
    AttributeDeleteMsg defaultInstance = AttributeDeleteMsg.getDefaultInstance();

    // Act
    ProtocolStringList actualAttributeNamesList = defaultInstance.getAttributeNamesList();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertTrue(options3.findInitializationErrors().isEmpty());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    assertTrue(toProtoResult3.findInitializationErrors().isEmpty());
    assertTrue(defaultInstance.findInitializationErrors().isEmpty());
    assertTrue(options2.getTargetsList().isEmpty());
    assertTrue(toProtoResult3.getPublicDependencyList().isEmpty());
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
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(actualAttributeNamesList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualAttributeNamesList).EMPTY;
    assertEquals(lazyStringList, toProtoResult2.getDefaultInstanceForType().findInitializationErrors());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertEquals(lazyStringList, defaultInstanceForType2.findInitializationErrors());
    assertEquals(lazyStringList, toProtoResult3.getSourceCodeInfo().findInitializationErrors());
    assertEquals(lazyStringList, options3.getDefaultInstanceForType().findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    assertEquals(lazyStringList, toProtoResult4.findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertEquals(lazyStringList, toProtoResult5.findInitializationErrors());
    assertEquals(lazyStringList, fields.get(1).toProto().findInitializationErrors());
    Descriptors.Descriptor descriptorForType4 = toProtoResult3.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertEquals(lazyStringList, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals(lazyStringList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(56);
    assertEquals(lazyStringList, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(57);
    assertEquals(lazyStringList, getResult5.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = features.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType5.getExtensions());
    Descriptors.Descriptor descriptorForType6 = options2.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType6.getExtensions());
    Descriptors.Descriptor descriptorForType7 = options3.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType7.getExtensions());
    assertEquals(lazyStringList, descriptorForType4.getExtensions());
    assertEquals(lazyStringList, getResult2.getExtensions());
    assertEquals(lazyStringList, getResult3.getExtensions());
    assertEquals(lazyStringList, getResult4.getExtensions());
    assertEquals(lazyStringList, getResult5.getExtensions());
    assertEquals(lazyStringList, descriptorForType5.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType7.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType4.getNestedTypes());
    assertEquals(lazyStringList, getResult2.getNestedTypes());
    assertEquals(lazyStringList, getResult3.getNestedTypes());
    assertEquals(lazyStringList, getResult4.getNestedTypes());
    assertEquals(lazyStringList, getResult5.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType5.getOneofs());
    assertEquals(lazyStringList, descriptorForType6.getOneofs());
    assertEquals(lazyStringList, descriptorForType7.getOneofs());
    assertEquals(lazyStringList, descriptorForType4.getOneofs());
    assertEquals(lazyStringList, getResult2.getOneofs());
    assertEquals(lazyStringList, getResult3.getOneofs());
    assertEquals(lazyStringList, getResult4.getOneofs());
    assertEquals(lazyStringList, getResult5.getOneofs());
    assertEquals(lazyStringList, descriptorForType5.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType6.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType7.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType4.getRealOneofs());
    assertEquals(lazyStringList, getResult2.getRealOneofs());
    assertEquals(lazyStringList, getResult3.getRealOneofs());
    assertEquals(lazyStringList, getResult4.getRealOneofs());
    assertEquals(lazyStringList, getResult5.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(lazyStringList, file2.getDependencies());
    Descriptors.FileDescriptor getResult6 = dependencies.get(0);
    assertEquals(lazyStringList, getResult6.getDependencies());
    assertEquals(lazyStringList, file2.getExtensions());
    assertEquals(lazyStringList, getResult6.getExtensions());
    assertEquals(lazyStringList, file2.getPublicDependencies());
    assertEquals(lazyStringList, getResult6.getPublicDependencies());
    assertEquals(lazyStringList, file2.getServices());
    assertEquals(lazyStringList, getResult6.getServices());
    assertSame(lazyStringList, defaultInstanceForType.getReservedNameList());
    assertSame(lazyStringList, toProtoResult4.getReservedNameList());
    assertSame(lazyStringList, toProtoResult5.getReservedNameList());
    assertSame(lazyStringList, toProtoResult.getReservedNameList());
    assertSame(lazyStringList, defaultInstanceForType2.getDependencyList());
    assertSame(lazyStringList, actualAttributeNamesList);
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    AttributeDeleteMsg defaultInstance = AttributeDeleteMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#getScope()}
   */
  @Test
  void testGetScope() {
    // Arrange, Act and Assert
    assertEquals("", AttributeDeleteMsg.getDefaultInstance().getScope());
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#getScopeBytes()}
   */
  @Test
  void testGetScopeBytes() {
    // Arrange
    AttributeDeleteMsg defaultInstance = AttributeDeleteMsg.getDefaultInstance();

    // Act
    ByteString actualScopeBytes = defaultInstance.getScopeBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    ByteString byteString = actualScopeBytes.EMPTY;
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getDefaultValueBytes());
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
    assertEquals(byteString, actualScopeBytes);
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AttributeDeleteMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AttributeDeleteMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link AttributeDeleteMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testNewInstance() {
    // Arrange
    AttributeDeleteMsg defaultInstance = AttributeDeleteMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof AttributeDeleteMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AttributeDeleteMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AttributeDeleteMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AttributeDeleteMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AttributeDeleteMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AttributeDeleteMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AttributeDeleteMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AttributeDeleteMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AttributeDeleteMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AttributeDeleteMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AttributeDeleteMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AttributeDeleteMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> AttributeDeleteMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AttributeDeleteMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link AttributeDeleteMsg#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AttributeDeleteMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AttributeDeleteMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> AttributeDeleteMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AttributeDeleteMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AttributeDeleteMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
