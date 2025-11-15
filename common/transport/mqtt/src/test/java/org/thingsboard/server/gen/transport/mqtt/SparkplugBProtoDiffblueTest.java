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
package org.thingsboard.server.gen.transport.mqtt;

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
import com.google.protobuf.Any;
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

class SparkplugBProtoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload#hashCode()}
   * </ul>
   */
  @Test
  void testPayloadEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload defaultInstance = SparkplugBProto.Payload.getDefaultInstance();
    SparkplugBProto.Payload defaultInstance2 = SparkplugBProto.Payload.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload#hashCode()}
   * </ul>
   */
  @Test
  void testPayloadEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload defaultInstance = SparkplugBProto.Payload.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#equals(Object)}
   */
  @Test
  void testPayloadEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#equals(Object)}
   */
  @Test
  void testPayloadEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#equals(Object)}
   */
  @Test
  void testPayloadEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.getDefaultInstance(), "Different type to Payload");
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload#getDefaultInstanceForType()}
   */
  @Test
  void testPayloadGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload defaultInstance = SparkplugBProto.Payload.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#getMetricsCount()}
   */
  @Test
  void testPayloadGetMetricsCount() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.getDefaultInstance().getMetricsCount());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#getSerializedSize()}
   */
  @Test
  void testPayloadGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#getUuid()}
   */
  @Test
  void testPayloadGetUuid() {
    // Arrange, Act and Assert
    assertEquals("", SparkplugBProto.Payload.getDefaultInstance().getUuid());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#getUuidBytes()}
   */
  @Test
  void testPayloadGetUuidBytes() {
    // Arrange
    SparkplugBProto.Payload defaultInstance = SparkplugBProto.Payload.getDefaultInstance();

    // Act
    ByteString actualUuidBytes = defaultInstance.getUuidBytes();

    // Assert
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualUuidBytes.EMPTY;
    assertEquals(byteString, actualUuidBytes);
    assertSame(byteString, defaultInstance.getExtensions().getValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
    assertSame(byteString, defaultInstance.getBody());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#hasBody()}
   */
  @Test
  void testPayloadHasBody() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.getDefaultInstance().hasBody());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#hasExtensions()}
   */
  @Test
  void testPayloadHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.getDefaultInstance().hasExtensions());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#hasSeq()}
   */
  @Test
  void testPayloadHasSeq() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.getDefaultInstance().hasSeq());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#hasTimestamp()}
   */
  @Test
  void testPayloadHasTimestamp() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.getDefaultInstance().hasTimestamp());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#hasUuid()}
   */
  @Test
  void testPayloadHasUuid() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.getDefaultInstance().hasUuid());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#isInitialized()}
   */
  @Test
  void testPayloadIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayloadNewInstance() {
    // Arrange
    SparkplugBProto.Payload defaultInstance = SparkplugBProto.Payload.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayloadParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayloadParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayloadParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayloadParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SparkplugBProto.Payload.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayloadParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayloadParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayloadParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayloadParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SparkplugBProto.Payload.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#parseFrom(InputStream)}
   */
  @Test
  void testPayloadParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload#parseFrom(InputStream)}
   */
  @Test
  void testPayloadParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayloadParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayloadParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.DataSet#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.DataSet#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_DataSetEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.DataSet defaultInstance = SparkplugBProto.Payload.DataSet.getDefaultInstance();
    SparkplugBProto.Payload.DataSet defaultInstance2 = SparkplugBProto.Payload.DataSet.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.DataSet#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.DataSet#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_DataSetEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.DataSet defaultInstance = SparkplugBProto.Payload.DataSet.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.DataSet#equals(Object)}
   */
  @Test
  void testPayload_DataSetEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.DataSet.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.DataSet#equals(Object)}
   */
  @Test
  void testPayload_DataSetEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.DataSet.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.DataSet#equals(Object)}
   */
  @Test
  void testPayload_DataSetEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.DataSet.getDefaultInstance(), "Different type to DataSet");
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.DataSet#getColumnsCount()}
   */
  @Test
  void testPayload_DataSetGetColumnsCount() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.DataSet.getDefaultInstance().getColumnsCount());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.DataSet#getColumnsList()}
   */
  @Test
  void testPayload_DataSetGetColumnsList() {
    // Arrange
    SparkplugBProto.Payload.DataSet defaultInstance = SparkplugBProto.Payload.DataSet.getDefaultInstance();

    // Act
    ProtocolStringList actualColumnsList = defaultInstance.getColumnsList();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.Descriptor> nestedTypes = descriptorForType.getNestedTypes();
    assertEquals(2, nestedTypes.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    Descriptors.Descriptor containingType = descriptorForType.getContainingType();
    List<Descriptors.Descriptor> nestedTypes2 = containingType.getNestedTypes();
    assertEquals(7, nestedTypes2.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = containingType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    Any extensions = defaultInstance.getExtensions();
    assertTrue(extensions.findInitializationErrors().isEmpty());
    assertTrue(defaultInstance.findInitializationErrors().isEmpty());
    assertTrue(containingType.getEnumTypes().isEmpty());
    Descriptors.Descriptor descriptorForType2 = extensions.getDescriptorForType();
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(containingType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(containingType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualColumnsList.isEmpty());
    assertTrue(defaultInstance.getRowsList().isEmpty());
    assertTrue(defaultInstance.getTypesList().isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualColumnsList).EMPTY;
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertEquals(lazyStringList, defaultInstanceForType.findInitializationErrors());
    assertEquals(lazyStringList, options.getFeatures().findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals(lazyStringList, toProtoResult3.findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertEquals(lazyStringList, options2.findInitializationErrors());
    assertEquals(lazyStringList, getResult.toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(1).toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(3).toProto().findInitializationErrors());
    assertEquals(lazyStringList, file.getOptions().findInitializationErrors());
    assertEquals(lazyStringList, file.toProto().findInitializationErrors());
    assertEquals(lazyStringList, options2.getTargetsList());
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor getResult2 = nestedTypes2.get(0);
    assertEquals(lazyStringList, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = nestedTypes2.get(5);
    assertEquals(lazyStringList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = nestedTypes2.get(6);
    assertEquals(lazyStringList, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = nestedTypes.get(0);
    assertEquals(lazyStringList, getResult5.getEnumTypes());
    Descriptors.Descriptor getResult6 = nestedTypes.get(1);
    assertEquals(lazyStringList, getResult6.getEnumTypes());
    assertEquals(lazyStringList, descriptorForType3.getExtensions());
    assertEquals(lazyStringList, descriptorForType4.getExtensions());
    assertEquals(lazyStringList, getResult2.getExtensions());
    assertEquals(lazyStringList, getResult3.getExtensions());
    assertEquals(lazyStringList, getResult4.getExtensions());
    assertEquals(lazyStringList, getResult5.getExtensions());
    assertEquals(lazyStringList, getResult6.getExtensions());
    assertEquals(lazyStringList, descriptorForType3.getNestedTypes());
    assertEquals(lazyStringList, getResult3.getNestedTypes());
    assertEquals(lazyStringList, getResult6.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType3.getOneofs());
    assertEquals(lazyStringList, descriptorForType4.getOneofs());
    assertEquals(lazyStringList, getResult6.getOneofs());
    assertEquals(lazyStringList, descriptorForType3.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType4.getRealOneofs());
    assertEquals(lazyStringList, getResult2.getRealOneofs());
    assertEquals(lazyStringList, getResult3.getRealOneofs());
    assertEquals(lazyStringList, getResult6.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(lazyStringList, file2.getDependencies());
    assertEquals(lazyStringList, file2.getEnumTypes());
    assertEquals(lazyStringList, file2.getExtensions());
    assertEquals(lazyStringList, file2.getPublicDependencies());
    assertEquals(lazyStringList, file2.getServices());
    assertSame(lazyStringList, defaultInstanceForType.getReservedNameList());
    assertSame(lazyStringList, toProtoResult.getReservedNameList());
    assertSame(lazyStringList, toProtoResult3.getReservedNameList());
    assertSame(lazyStringList, toProtoResult2.getReservedNameList());
    assertSame(lazyStringList, actualColumnsList);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#getDefaultInstanceForType()}
   */
  @Test
  void testPayload_DataSetGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload.DataSet defaultInstance = SparkplugBProto.Payload.DataSet.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.DataSet#getRowsCount()}
   */
  @Test
  void testPayload_DataSetGetRowsCount() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.DataSet.getDefaultInstance().getRowsCount());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#getSerializedSize()}
   */
  @Test
  void testPayload_DataSetGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.DataSet.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.DataSet#getTypesCount()}
   */
  @Test
  void testPayload_DataSetGetTypesCount() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.DataSet.getDefaultInstance().getTypesCount());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.DataSet#hasExtensions()}
   */
  @Test
  void testPayload_DataSetHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.DataSet.getDefaultInstance().hasExtensions());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.DataSet#hasNumOfColumns()}
   */
  @Test
  void testPayload_DataSetHasNumOfColumns() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.DataSet.getDefaultInstance().hasNumOfColumns());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.DataSet#isInitialized()}
   */
  @Test
  void testPayload_DataSetIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.DataSet.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayload_DataSetNewInstance() {
    // Arrange
    SparkplugBProto.Payload.DataSet defaultInstance = SparkplugBProto.Payload.DataSet.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload.DataSet);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_DataSetParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.DataSet.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_DataSetParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.DataSet.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_DataSetParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.DataSet.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_DataSetParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SparkplugBProto.Payload.DataSet.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSetParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.DataSet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSetParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.DataSet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSetParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.DataSet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSetParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SparkplugBProto.Payload.DataSet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#parseFrom(InputStream)}
   */
  @Test
  void testPayload_DataSetParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.DataSet.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#parseFrom(InputStream)}
   */
  @Test
  void testPayload_DataSetParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.DataSet.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSetParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.DataSet.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSetParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.DataSet.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.DataSet.DataSetValue#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.DataSet.DataSetValue#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_DataSet_DataSetValueEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.DataSet.DataSetValue defaultInstance = SparkplugBProto.Payload.DataSet.DataSetValue
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.DataSet.DataSetValue#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.DataSet.DataSetValue#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_DataSet_DataSetValueEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    SparkplugBProto.Payload.DataSet.DataSetValue defaultInstance = SparkplugBProto.Payload.DataSet.DataSetValue
        .getDefaultInstance();
    SparkplugBProto.Payload.DataSet.DataSetValue defaultInstance2 = SparkplugBProto.Payload.DataSet.DataSetValue
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#equals(Object)}
   */
  @Test
  void testPayload_DataSet_DataSetValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#equals(Object)}
   */
  @Test
  void testPayload_DataSet_DataSetValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#equals(Object)}
   */
  @Test
  void testPayload_DataSet_DataSetValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance(),
        "Different type to DataSetValue");
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#getBooleanValue()}
   */
  @Test
  void testPayload_DataSet_DataSetValueGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().getBooleanValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#getDefaultInstanceForType()}
   */
  @Test
  void testPayload_DataSet_DataSetValueGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload.DataSet.DataSetValue defaultInstance = SparkplugBProto.Payload.DataSet.DataSetValue
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#getDoubleValue()}
   */
  @Test
  void testPayload_DataSet_DataSetValueGetDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(0.0d, SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().getDoubleValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#getFloatValue()}
   */
  @Test
  void testPayload_DataSet_DataSetValueGetFloatValue() {
    // Arrange, Act and Assert
    assertEquals(0.0f, SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().getFloatValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#getIntValue()}
   */
  @Test
  void testPayload_DataSet_DataSetValueGetIntValue() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().getIntValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#getLongValue()}
   */
  @Test
  void testPayload_DataSet_DataSetValueGetLongValue() {
    // Arrange, Act and Assert
    assertEquals(0L, SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().getLongValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#getSerializedSize()}
   */
  @Test
  void testPayload_DataSet_DataSetValueGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#getStringValue()}
   */
  @Test
  void testPayload_DataSet_DataSetValueGetStringValue() {
    // Arrange, Act and Assert
    assertEquals("", SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().getStringValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#getStringValueBytes()}
   */
  @Test
  void testPayload_DataSet_DataSetValueGetStringValueBytes() {
    // Arrange
    SparkplugBProto.Payload.DataSet.DataSetValue defaultInstance = SparkplugBProto.Payload.DataSet.DataSetValue
        .getDefaultInstance();

    // Act
    ByteString actualStringValueBytes = defaultInstance.getStringValueBytes();

    // Assert
    assertEquals(7, defaultInstance.getDescriptorForType().getFields().size());
    ByteString byteString = actualStringValueBytes.EMPTY;
    assertEquals(byteString, actualStringValueBytes);
    assertSame(byteString, defaultInstance.getExtensionValue().getExtensions().getValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#getValueCase()}
   */
  @Test
  void testPayload_DataSet_DataSetValueGetValueCase() {
    // Arrange, Act and Assert
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.VALUE_NOT_SET,
        SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().getValueCase());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#hasBooleanValue()}
   */
  @Test
  void testPayload_DataSet_DataSetValueHasBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().hasBooleanValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#hasDoubleValue()}
   */
  @Test
  void testPayload_DataSet_DataSetValueHasDoubleValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().hasDoubleValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#hasExtensionValue()}
   */
  @Test
  void testPayload_DataSet_DataSetValueHasExtensionValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().hasExtensionValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#hasFloatValue()}
   */
  @Test
  void testPayload_DataSet_DataSetValueHasFloatValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().hasFloatValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#hasIntValue()}
   */
  @Test
  void testPayload_DataSet_DataSetValueHasIntValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().hasIntValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#hasLongValue()}
   */
  @Test
  void testPayload_DataSet_DataSetValueHasLongValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().hasLongValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#hasStringValue()}
   */
  @Test
  void testPayload_DataSet_DataSetValueHasStringValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().hasStringValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#isInitialized()}
   */
  @Test
  void testPayload_DataSet_DataSetValueIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.DataSet.DataSetValue.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayload_DataSet_DataSetValueNewInstance() {
    // Arrange
    SparkplugBProto.Payload.DataSet.DataSetValue defaultInstance = SparkplugBProto.Payload.DataSet.DataSetValue
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload.DataSet.DataSetValue);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_DataSetValueParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.DataSet.DataSetValue.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_DataSetValueParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.DataSet.DataSetValue.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_DataSetValueParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.DataSet.DataSetValue.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_DataSetValueParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SparkplugBProto.Payload.DataSet.DataSetValue.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_DataSetValueParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.DataSet.DataSetValue.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_DataSetValueParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.DataSet.DataSetValue.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_DataSetValueParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.DataSet.DataSetValue
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_DataSetValueParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SparkplugBProto.Payload.DataSet.DataSetValue
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#parseFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_DataSetValueParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.DataSet.DataSetValue.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#parseFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_DataSetValueParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.DataSet.DataSetValue.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_DataSetValueParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.DataSet.DataSetValue.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_DataSetValueParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.DataSet.DataSetValue.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#equals(Object)}
   *   <li>
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionEqualsAndHashCode() {
    // Arrange
    SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension defaultInstance = SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension
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
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#equals(Object)}
   *   <li>
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionEqualsAndHashCode2() {
    // Arrange
    SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension defaultInstance = SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension
        .getDefaultInstance();
    SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension defaultInstance2 = SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#equals(Object)}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension.getDefaultInstance(), null);
    assertNotEquals(SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension.getDefaultInstance(),
        "Different type to DataSetValueExtension");
    assertNotEquals(SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#getDefaultInstanceForType()}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension defaultInstance = SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#getSerializedSize()}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0,
        SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#hasExtensions()}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(
        SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension.getDefaultInstance().hasExtensions());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#isInitialized()}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionNewInstance() {
    // Arrange
    SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension defaultInstance = SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(input,
            ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension.parseFrom(input,
            ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.forNumber(42));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.VALUE_NOT_SET,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.forNumber(0));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.INT_VALUE,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.forNumber(1));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.LONG_VALUE,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.forNumber(2));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.FLOAT_VALUE,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.forNumber(3));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.DOUBLE_VALUE,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.forNumber(4));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.BOOLEAN_VALUE,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.forNumber(5));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.STRING_VALUE,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.forNumber(6));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.EXTENSION_VALUE,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.forNumber(7));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase#getNumber()}
   */
  @Test
  void testPayload_DataSet_DataSetValue_ValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.valueOf("INT_VALUE").getNumber());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  void testPayload_DataSet_DataSetValue_ValueCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.valueOf(42));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.VALUE_NOT_SET,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.valueOf(0));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.INT_VALUE,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.valueOf(1));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.LONG_VALUE,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.valueOf(2));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.FLOAT_VALUE,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.valueOf(3));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.DOUBLE_VALUE,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.valueOf(4));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.BOOLEAN_VALUE,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.valueOf(5));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.STRING_VALUE,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.valueOf(6));
    assertEquals(SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.EXTENSION_VALUE,
        SparkplugBProto.Payload.DataSet.DataSetValue.ValueCase.valueOf(7));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.DataSet.Row#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.DataSet.Row#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_DataSet_RowEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.DataSet.Row defaultInstance = SparkplugBProto.Payload.DataSet.Row.getDefaultInstance();
    SparkplugBProto.Payload.DataSet.Row defaultInstance2 = SparkplugBProto.Payload.DataSet.Row.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.DataSet.Row#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.DataSet.Row#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_DataSet_RowEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.DataSet.Row defaultInstance = SparkplugBProto.Payload.DataSet.Row.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.DataSet.Row#equals(Object)}
   */
  @Test
  void testPayload_DataSet_RowEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.DataSet.Row.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.DataSet.Row#equals(Object)}
   */
  @Test
  void testPayload_DataSet_RowEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.DataSet.Row.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.DataSet.Row#equals(Object)}
   */
  @Test
  void testPayload_DataSet_RowEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.DataSet.Row.getDefaultInstance(), "Different type to Row");
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#getDefaultInstanceForType()}
   */
  @Test
  void testPayload_DataSet_RowGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload.DataSet.Row defaultInstance = SparkplugBProto.Payload.DataSet.Row.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#getElementsCount()}
   */
  @Test
  void testPayload_DataSet_RowGetElementsCount() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.DataSet.Row.getDefaultInstance().getElementsCount());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#getSerializedSize()}
   */
  @Test
  void testPayload_DataSet_RowGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.DataSet.Row.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#hasExtensions()}
   */
  @Test
  void testPayload_DataSet_RowHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.DataSet.Row.getDefaultInstance().hasExtensions());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#isInitialized()}
   */
  @Test
  void testPayload_DataSet_RowIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.DataSet.Row.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayload_DataSet_RowNewInstance() {
    // Arrange
    SparkplugBProto.Payload.DataSet.Row defaultInstance = SparkplugBProto.Payload.DataSet.Row.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload.DataSet.Row);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_RowParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.DataSet.Row.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_RowParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.DataSet.Row.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_RowParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.DataSet.Row.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_RowParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.DataSet.Row.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_RowParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.DataSet.Row.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_RowParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.DataSet.Row.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#parseFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_RowParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.DataSet.Row.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#parseFrom(InputStream)}
   */
  @Test
  void testPayload_DataSet_RowParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.DataSet.Row.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_RowParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.DataSet.Row.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.DataSet.Row#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_DataSet_RowParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.DataSet.Row.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.MetaData#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.MetaData#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_MetaDataEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.MetaData defaultInstance = SparkplugBProto.Payload.MetaData.getDefaultInstance();
    SparkplugBProto.Payload.MetaData defaultInstance2 = SparkplugBProto.Payload.MetaData.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.MetaData#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.MetaData#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_MetaDataEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.MetaData defaultInstance = SparkplugBProto.Payload.MetaData.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#equals(Object)}
   */
  @Test
  void testPayload_MetaDataEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.MetaData.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#equals(Object)}
   */
  @Test
  void testPayload_MetaDataEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.MetaData.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#equals(Object)}
   */
  @Test
  void testPayload_MetaDataEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.MetaData.getDefaultInstance(), "Different type to MetaData");
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#getContentType()}
   */
  @Test
  void testPayload_MetaDataGetContentType() {
    // Arrange, Act and Assert
    assertEquals("", SparkplugBProto.Payload.MetaData.getDefaultInstance().getContentType());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#getContentTypeBytes()}
   */
  @Test
  void testPayload_MetaDataGetContentTypeBytes() {
    // Arrange
    SparkplugBProto.Payload.MetaData defaultInstance = SparkplugBProto.Payload.MetaData.getDefaultInstance();

    // Act
    ByteString actualContentTypeBytes = defaultInstance.getContentTypeBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getContainingType().getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualContentTypeBytes.EMPTY;
    assertEquals(byteString, actualContentTypeBytes);
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(SparkplugBProto.Payload.MetaData.EXTENSIONS_FIELD_NUMBER, descriptorForType.getFields().size());
    assertSame(byteString, defaultInstance.getExtensions().getValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#getDefaultInstanceForType()}
   */
  @Test
  void testPayload_MetaDataGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload.MetaData defaultInstance = SparkplugBProto.Payload.MetaData.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#getDescription()}
   */
  @Test
  void testPayload_MetaDataGetDescription() {
    // Arrange, Act and Assert
    assertEquals("", SparkplugBProto.Payload.MetaData.getDefaultInstance().getDescription());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#getDescriptionBytes()}
   */
  @Test
  void testPayload_MetaDataGetDescriptionBytes() {
    // Arrange
    SparkplugBProto.Payload.MetaData defaultInstance = SparkplugBProto.Payload.MetaData.getDefaultInstance();

    // Act
    ByteString actualDescriptionBytes = defaultInstance.getDescriptionBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getContainingType().getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualDescriptionBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, actualDescriptionBytes);
    assertEquals(SparkplugBProto.Payload.MetaData.EXTENSIONS_FIELD_NUMBER, descriptorForType.getFields().size());
    assertSame(byteString, defaultInstance.getExtensions().getValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#getFileName()}
   */
  @Test
  void testPayload_MetaDataGetFileName() {
    // Arrange, Act and Assert
    assertEquals("", SparkplugBProto.Payload.MetaData.getDefaultInstance().getFileName());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#getFileNameBytes()}
   */
  @Test
  void testPayload_MetaDataGetFileNameBytes() {
    // Arrange
    SparkplugBProto.Payload.MetaData defaultInstance = SparkplugBProto.Payload.MetaData.getDefaultInstance();

    // Act
    ByteString actualFileNameBytes = defaultInstance.getFileNameBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getContainingType().getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualFileNameBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, actualFileNameBytes);
    assertEquals(SparkplugBProto.Payload.MetaData.EXTENSIONS_FIELD_NUMBER, descriptorForType.getFields().size());
    assertSame(byteString, defaultInstance.getExtensions().getValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#getFileType()}
   */
  @Test
  void testPayload_MetaDataGetFileType() {
    // Arrange, Act and Assert
    assertEquals("", SparkplugBProto.Payload.MetaData.getDefaultInstance().getFileType());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#getFileTypeBytes()}
   */
  @Test
  void testPayload_MetaDataGetFileTypeBytes() {
    // Arrange
    SparkplugBProto.Payload.MetaData defaultInstance = SparkplugBProto.Payload.MetaData.getDefaultInstance();

    // Act
    ByteString actualFileTypeBytes = defaultInstance.getFileTypeBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getContainingType().getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualFileTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, actualFileTypeBytes);
    assertEquals(SparkplugBProto.Payload.MetaData.EXTENSIONS_FIELD_NUMBER, descriptorForType.getFields().size());
    assertSame(byteString, defaultInstance.getExtensions().getValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#getMd5()}
   */
  @Test
  void testPayload_MetaDataGetMd5() {
    // Arrange, Act and Assert
    assertEquals("", SparkplugBProto.Payload.MetaData.getDefaultInstance().getMd5());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#getMd5Bytes()}
   */
  @Test
  void testPayload_MetaDataGetMd5Bytes() {
    // Arrange
    SparkplugBProto.Payload.MetaData defaultInstance = SparkplugBProto.Payload.MetaData.getDefaultInstance();

    // Act
    ByteString actualMd5Bytes = defaultInstance.getMd5Bytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getContainingType().getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualMd5Bytes.EMPTY;
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, actualMd5Bytes);
    assertEquals(SparkplugBProto.Payload.MetaData.EXTENSIONS_FIELD_NUMBER, descriptorForType.getFields().size());
    assertSame(byteString, defaultInstance.getExtensions().getValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#getSerializedSize()}
   */
  @Test
  void testPayload_MetaDataGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.MetaData.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#hasContentType()}
   */
  @Test
  void testPayload_MetaDataHasContentType() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.MetaData.getDefaultInstance().hasContentType());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#hasDescription()}
   */
  @Test
  void testPayload_MetaDataHasDescription() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.MetaData.getDefaultInstance().hasDescription());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#hasExtensions()}
   */
  @Test
  void testPayload_MetaDataHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.MetaData.getDefaultInstance().hasExtensions());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#hasFileName()}
   */
  @Test
  void testPayload_MetaDataHasFileName() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.MetaData.getDefaultInstance().hasFileName());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#hasFileType()}
   */
  @Test
  void testPayload_MetaDataHasFileType() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.MetaData.getDefaultInstance().hasFileType());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#hasIsMultiPart()}
   */
  @Test
  void testPayload_MetaDataHasIsMultiPart() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.MetaData.getDefaultInstance().hasIsMultiPart());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#hasMd5()}
   */
  @Test
  void testPayload_MetaDataHasMd5() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.MetaData.getDefaultInstance().hasMd5());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#hasSeq()}
   */
  @Test
  void testPayload_MetaDataHasSeq() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.MetaData.getDefaultInstance().hasSeq());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#hasSize()}
   */
  @Test
  void testPayload_MetaDataHasSize() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.MetaData.getDefaultInstance().hasSize());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.MetaData#isInitialized()}
   */
  @Test
  void testPayload_MetaDataIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.MetaData.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayload_MetaDataNewInstance() {
    // Arrange
    SparkplugBProto.Payload.MetaData defaultInstance = SparkplugBProto.Payload.MetaData.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload.MetaData);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_MetaDataParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.MetaData.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_MetaDataParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.MetaData.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_MetaDataParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.MetaData.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_MetaDataParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SparkplugBProto.Payload.MetaData.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_MetaDataParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.MetaData.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_MetaDataParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.MetaData.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_MetaDataParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.MetaData.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_MetaDataParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SparkplugBProto.Payload.MetaData.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#parseFrom(InputStream)}
   */
  @Test
  void testPayload_MetaDataParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.MetaData.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#parseFrom(InputStream)}
   */
  @Test
  void testPayload_MetaDataParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.MetaData.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_MetaDataParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.MetaData.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.MetaData#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_MetaDataParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.MetaData.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.Metric#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.Metric#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_MetricEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.Metric defaultInstance = SparkplugBProto.Payload.Metric.getDefaultInstance();
    SparkplugBProto.Payload.Metric defaultInstance2 = SparkplugBProto.Payload.Metric.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.Metric#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.Metric#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_MetricEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.Metric defaultInstance = SparkplugBProto.Payload.Metric.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#equals(Object)}
   */
  @Test
  void testPayload_MetricEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.Metric.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#equals(Object)}
   */
  @Test
  void testPayload_MetricEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.Metric.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#equals(Object)}
   */
  @Test
  void testPayload_MetricEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.Metric.getDefaultInstance(), "Different type to Metric");
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#getBooleanValue()}
   */
  @Test
  void testPayload_MetricGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().getBooleanValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#getBytesValue()}
   */
  @Test
  void testPayload_MetricGetBytesValue() {
    // Arrange
    SparkplugBProto.Payload.Metric defaultInstance = SparkplugBProto.Payload.Metric.getDefaultInstance();

    // Act
    ByteString actualBytesValue = defaultInstance.getBytesValue();

    // Assert
    ByteString byteString = actualBytesValue.EMPTY;
    Any extensions = defaultInstance.getDatasetValue().getExtensions();
    assertEquals(byteString, extensions.getTypeUrlBytes());
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(byteString, file.toProto().getPackageBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertSame(byteString, extensions.getValue());
    assertSame(byteString, actualBytesValue);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#getDefaultInstanceForType()}
   */
  @Test
  void testPayload_MetricGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload.Metric defaultInstance = SparkplugBProto.Payload.Metric.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#getDoubleValue()}
   */
  @Test
  void testPayload_MetricGetDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(0.0d, SparkplugBProto.Payload.Metric.getDefaultInstance().getDoubleValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#getFloatValue()}
   */
  @Test
  void testPayload_MetricGetFloatValue() {
    // Arrange, Act and Assert
    assertEquals(0.0f, SparkplugBProto.Payload.Metric.getDefaultInstance().getFloatValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#getIntValue()}
   */
  @Test
  void testPayload_MetricGetIntValue() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.Metric.getDefaultInstance().getIntValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#getLongValue()}
   */
  @Test
  void testPayload_MetricGetLongValue() {
    // Arrange, Act and Assert
    assertEquals(0L, SparkplugBProto.Payload.Metric.getDefaultInstance().getLongValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#getName()}
   */
  @Test
  void testPayload_MetricGetName() {
    // Arrange, Act and Assert
    assertEquals("", SparkplugBProto.Payload.Metric.getDefaultInstance().getName());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#getNameBytes()}
   */
  @Test
  void testPayload_MetricGetNameBytes() {
    // Arrange
    SparkplugBProto.Payload.Metric defaultInstance = SparkplugBProto.Payload.Metric.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    assertEquals(byteString, actualNameBytes);
    assertSame(byteString, defaultInstance.getDatasetValue().getExtensions().getValue());
    assertSame(byteString, defaultInstance.getBytesValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#getSerializedSize()}
   */
  @Test
  void testPayload_MetricGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.Metric.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#getStringValue()}
   */
  @Test
  void testPayload_MetricGetStringValue() {
    // Arrange, Act and Assert
    assertEquals("", SparkplugBProto.Payload.Metric.getDefaultInstance().getStringValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#getStringValueBytes()}
   */
  @Test
  void testPayload_MetricGetStringValueBytes() {
    // Arrange
    SparkplugBProto.Payload.Metric defaultInstance = SparkplugBProto.Payload.Metric.getDefaultInstance();

    // Act
    ByteString actualStringValueBytes = defaultInstance.getStringValueBytes();

    // Assert
    ByteString byteString = actualStringValueBytes.EMPTY;
    assertEquals(byteString, actualStringValueBytes);
    assertSame(byteString, defaultInstance.getDatasetValue().getExtensions().getValue());
    assertSame(byteString, defaultInstance.getBytesValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#getValueCase()}
   */
  @Test
  void testPayload_MetricGetValueCase() {
    // Arrange, Act and Assert
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.VALUE_NOT_SET,
        SparkplugBProto.Payload.Metric.getDefaultInstance().getValueCase());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasAlias()}
   */
  @Test
  void testPayload_MetricHasAlias() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasAlias());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasBooleanValue()}
   */
  @Test
  void testPayload_MetricHasBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasBooleanValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasBytesValue()}
   */
  @Test
  void testPayload_MetricHasBytesValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasBytesValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasDatasetValue()}
   */
  @Test
  void testPayload_MetricHasDatasetValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasDatasetValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasDatatype()}
   */
  @Test
  void testPayload_MetricHasDatatype() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasDatatype());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasDoubleValue()}
   */
  @Test
  void testPayload_MetricHasDoubleValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasDoubleValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasExtensionValue()}
   */
  @Test
  void testPayload_MetricHasExtensionValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasExtensionValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasFloatValue()}
   */
  @Test
  void testPayload_MetricHasFloatValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasFloatValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasIntValue()}
   */
  @Test
  void testPayload_MetricHasIntValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasIntValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasIsHistorical()}
   */
  @Test
  void testPayload_MetricHasIsHistorical() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasIsHistorical());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasIsNull()}
   */
  @Test
  void testPayload_MetricHasIsNull() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasIsNull());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasIsTransient()}
   */
  @Test
  void testPayload_MetricHasIsTransient() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasIsTransient());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasLongValue()}
   */
  @Test
  void testPayload_MetricHasLongValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasLongValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasMetadata()}
   */
  @Test
  void testPayload_MetricHasMetadata() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasMetadata());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasName()}
   */
  @Test
  void testPayload_MetricHasName() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasName());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasProperties()}
   */
  @Test
  void testPayload_MetricHasProperties() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasProperties());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasStringValue()}
   */
  @Test
  void testPayload_MetricHasStringValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasStringValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasTemplateValue()}
   */
  @Test
  void testPayload_MetricHasTemplateValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasTemplateValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#hasTimestamp()}
   */
  @Test
  void testPayload_MetricHasTimestamp() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.getDefaultInstance().hasTimestamp());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Metric#isInitialized()}
   */
  @Test
  void testPayload_MetricIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.Metric.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayload_MetricNewInstance() {
    // Arrange
    SparkplugBProto.Payload.Metric defaultInstance = SparkplugBProto.Payload.Metric.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload.Metric);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_MetricParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.Metric.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_MetricParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.Metric.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_MetricParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.Metric.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_MetricParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SparkplugBProto.Payload.Metric.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_MetricParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.Metric.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_MetricParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.Metric.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_MetricParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.Metric.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_MetricParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SparkplugBProto.Payload.Metric.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#parseFrom(InputStream)}
   */
  @Test
  void testPayload_MetricParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.Metric.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#parseFrom(InputStream)}
   */
  @Test
  void testPayload_MetricParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.Metric.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_MetricParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.Metric.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_MetricParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.Metric.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.Metric.MetricValueExtension#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_Metric_MetricValueExtensionEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.Metric.MetricValueExtension defaultInstance = SparkplugBProto.Payload.Metric.MetricValueExtension
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
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.Metric.MetricValueExtension#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_Metric_MetricValueExtensionEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    SparkplugBProto.Payload.Metric.MetricValueExtension defaultInstance = SparkplugBProto.Payload.Metric.MetricValueExtension
        .getDefaultInstance();
    SparkplugBProto.Payload.Metric.MetricValueExtension defaultInstance2 = SparkplugBProto.Payload.Metric.MetricValueExtension
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#equals(Object)}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.Metric.MetricValueExtension.getDefaultInstance(),
        "Different type to MetricValueExtension");
    assertNotEquals(SparkplugBProto.Payload.Metric.MetricValueExtension.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#equals(Object)}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.Metric.MetricValueExtension.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#getDefaultInstanceForType()}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload.Metric.MetricValueExtension defaultInstance = SparkplugBProto.Payload.Metric.MetricValueExtension
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#getSerializedSize()}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.Metric.MetricValueExtension.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#hasExtensions()}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Metric.MetricValueExtension.getDefaultInstance().hasExtensions());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#isInitialized()}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.Metric.MetricValueExtension.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionNewInstance() {
    // Arrange
    SparkplugBProto.Payload.Metric.MetricValueExtension defaultInstance = SparkplugBProto.Payload.Metric.MetricValueExtension
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload.Metric.MetricValueExtension);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.Metric.MetricValueExtension.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.Metric.MetricValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.Metric.MetricValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.Metric.MetricValueExtension.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.Metric.MetricValueExtension.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.Metric.MetricValueExtension
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#parseFrom(InputStream)}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.Metric.MetricValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#parseFrom(InputStream)}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.Metric.MetricValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.Metric.MetricValueExtension.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.MetricValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Metric_MetricValueExtensionParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.Metric.MetricValueExtension
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.ValueCase#forNumber(int)}
   */
  @Test
  void testPayload_Metric_ValueCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(SparkplugBProto.Payload.Metric.ValueCase.forNumber(42));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.VALUE_NOT_SET,
        SparkplugBProto.Payload.Metric.ValueCase.forNumber(0));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.INT_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.forNumber(SparkplugBProto.Payload.Metric.INT_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.LONG_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.forNumber(SparkplugBProto.Payload.Metric.LONG_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.FLOAT_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.forNumber(SparkplugBProto.Payload.Metric.FLOAT_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.DOUBLE_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.forNumber(SparkplugBProto.Payload.Metric.DOUBLE_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.BOOLEAN_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.forNumber(SparkplugBProto.Payload.Metric.BOOLEAN_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.STRING_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.forNumber(SparkplugBProto.Payload.Metric.STRING_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.BYTES_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.forNumber(SparkplugBProto.Payload.Metric.BYTES_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.DATASET_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.forNumber(SparkplugBProto.Payload.Metric.DATASET_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.TEMPLATE_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.forNumber(SparkplugBProto.Payload.Metric.TEMPLATE_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.EXTENSION_VALUE, SparkplugBProto.Payload.Metric.ValueCase
        .forNumber(SparkplugBProto.Payload.Metric.EXTENSION_VALUE_FIELD_NUMBER));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.ValueCase#getNumber()}
   */
  @Test
  void testPayload_Metric_ValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(SparkplugBProto.Payload.Metric.INT_VALUE_FIELD_NUMBER,
        SparkplugBProto.Payload.Metric.ValueCase.valueOf("INT_VALUE").getNumber());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Metric.ValueCase#valueOf(int)}
   */
  @Test
  void testPayload_Metric_ValueCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(SparkplugBProto.Payload.Metric.ValueCase.valueOf(42));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.VALUE_NOT_SET,
        SparkplugBProto.Payload.Metric.ValueCase.valueOf(0));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.INT_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.valueOf(SparkplugBProto.Payload.Metric.INT_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.LONG_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.valueOf(SparkplugBProto.Payload.Metric.LONG_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.FLOAT_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.valueOf(SparkplugBProto.Payload.Metric.FLOAT_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.DOUBLE_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.valueOf(SparkplugBProto.Payload.Metric.DOUBLE_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.BOOLEAN_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.valueOf(SparkplugBProto.Payload.Metric.BOOLEAN_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.STRING_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.valueOf(SparkplugBProto.Payload.Metric.STRING_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.BYTES_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.valueOf(SparkplugBProto.Payload.Metric.BYTES_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.DATASET_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.valueOf(SparkplugBProto.Payload.Metric.DATASET_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.TEMPLATE_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.valueOf(SparkplugBProto.Payload.Metric.TEMPLATE_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.Metric.ValueCase.EXTENSION_VALUE,
        SparkplugBProto.Payload.Metric.ValueCase.valueOf(SparkplugBProto.Payload.Metric.EXTENSION_VALUE_FIELD_NUMBER));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.PropertySet#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.PropertySet#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_PropertySetEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.PropertySet defaultInstance = SparkplugBProto.Payload.PropertySet.getDefaultInstance();
    SparkplugBProto.Payload.PropertySet defaultInstance2 = SparkplugBProto.Payload.PropertySet.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.PropertySet#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.PropertySet#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_PropertySetEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.PropertySet defaultInstance = SparkplugBProto.Payload.PropertySet.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.PropertySet#equals(Object)}
   */
  @Test
  void testPayload_PropertySetEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.PropertySet.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.PropertySet#equals(Object)}
   */
  @Test
  void testPayload_PropertySetEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.PropertySet.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.PropertySet#equals(Object)}
   */
  @Test
  void testPayload_PropertySetEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.PropertySet.getDefaultInstance(), "Different type to PropertySet");
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#getDefaultInstanceForType()}
   */
  @Test
  void testPayload_PropertySetGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload.PropertySet defaultInstance = SparkplugBProto.Payload.PropertySet.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.PropertySet#getKeysCount()}
   */
  @Test
  void testPayload_PropertySetGetKeysCount() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.PropertySet.getDefaultInstance().getKeysCount());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.PropertySet#getKeysList()}
   */
  @Test
  void testPayload_PropertySetGetKeysList() {
    // Arrange
    SparkplugBProto.Payload.PropertySet defaultInstance = SparkplugBProto.Payload.PropertySet.getDefaultInstance();

    // Act
    ProtocolStringList actualKeysList = defaultInstance.getKeysList();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    Descriptors.Descriptor containingType = descriptorForType.getContainingType();
    List<Descriptors.Descriptor> nestedTypes = containingType.getNestedTypes();
    assertEquals(7, nestedTypes.size());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertTrue(options.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = containingType.toProto();
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertTrue(options2.findInitializationErrors().isEmpty());
    Any extensions = defaultInstance.getExtensions();
    assertTrue(extensions.findInitializationErrors().isEmpty());
    assertTrue(defaultInstance.findInitializationErrors().isEmpty());
    assertTrue(containingType.getEnumTypes().isEmpty());
    Descriptors.Descriptor descriptorForType2 = extensions.getDescriptorForType();
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(containingType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(containingType.getRealOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(actualKeysList.isEmpty());
    assertTrue(defaultInstance.getValuesList().isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualKeysList).EMPTY;
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertEquals(lazyStringList, defaultInstanceForType.findInitializationErrors());
    assertEquals(lazyStringList, options2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(lazyStringList, options.getFeatures().findInitializationErrors());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals(lazyStringList, toProtoResult3.findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(lazyStringList, options3.findInitializationErrors());
    assertEquals(lazyStringList, getResult.toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertEquals(lazyStringList, getResult2.toProto().findInitializationErrors());
    assertEquals(lazyStringList, fields.get(2).toProto().findInitializationErrors());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    assertEquals(lazyStringList, toProtoResult4.findInitializationErrors());
    assertEquals(lazyStringList, options3.getTargetsList());
    assertEquals(lazyStringList, toProtoResult4.getPublicDependencyList());
    Descriptors.Descriptor messageType = getResult2.getMessageType();
    assertEquals(lazyStringList, messageType.getEnumTypes());
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals(lazyStringList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor getResult3 = nestedTypes.get(0);
    assertEquals(lazyStringList, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = nestedTypes.get(1);
    assertEquals(lazyStringList, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = nestedTypes.get(5);
    assertEquals(lazyStringList, getResult5.getEnumTypes());
    Descriptors.Descriptor getResult6 = nestedTypes.get(6);
    assertEquals(lazyStringList, getResult6.getEnumTypes());
    assertEquals(lazyStringList, messageType.getExtensions());
    assertEquals(lazyStringList, descriptorForType3.getExtensions());
    assertEquals(lazyStringList, descriptorForType4.getExtensions());
    assertEquals(lazyStringList, getResult3.getExtensions());
    assertEquals(lazyStringList, getResult4.getExtensions());
    assertEquals(lazyStringList, getResult5.getExtensions());
    assertEquals(lazyStringList, getResult6.getExtensions());
    assertEquals(lazyStringList, descriptorForType3.getNestedTypes());
    assertEquals(lazyStringList, getResult5.getNestedTypes());
    assertEquals(lazyStringList, descriptorForType3.getOneofs());
    assertEquals(lazyStringList, descriptorForType4.getOneofs());
    assertEquals(lazyStringList, descriptorForType3.getRealOneofs());
    assertEquals(lazyStringList, descriptorForType4.getRealOneofs());
    assertEquals(lazyStringList, getResult3.getRealOneofs());
    assertEquals(lazyStringList, getResult4.getRealOneofs());
    assertEquals(lazyStringList, getResult5.getRealOneofs());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals(lazyStringList, file2.getDependencies());
    assertEquals(lazyStringList, file2.getEnumTypes());
    assertEquals(lazyStringList, file2.getExtensions());
    assertEquals(lazyStringList, file2.getPublicDependencies());
    assertEquals(lazyStringList, file2.getServices());
    assertSame(lazyStringList, defaultInstanceForType.getReservedNameList());
    assertSame(lazyStringList, toProtoResult.getReservedNameList());
    assertSame(lazyStringList, toProtoResult3.getReservedNameList());
    assertSame(lazyStringList, toProtoResult2.getReservedNameList());
    assertSame(lazyStringList, actualKeysList);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#getSerializedSize()}
   */
  @Test
  void testPayload_PropertySetGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.PropertySet.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#getValuesCount()}
   */
  @Test
  void testPayload_PropertySetGetValuesCount() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.PropertySet.getDefaultInstance().getValuesCount());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#hasExtensions()}
   */
  @Test
  void testPayload_PropertySetHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertySet.getDefaultInstance().hasExtensions());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#isInitialized()}
   */
  @Test
  void testPayload_PropertySetIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.PropertySet.getDefaultInstance().isInitialized());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.PropertySetList#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.PropertySetList#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_PropertySetListEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.PropertySetList defaultInstance = SparkplugBProto.Payload.PropertySetList
        .getDefaultInstance();
    SparkplugBProto.Payload.PropertySetList defaultInstance2 = SparkplugBProto.Payload.PropertySetList
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.PropertySetList#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.PropertySetList#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_PropertySetListEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.PropertySetList defaultInstance = SparkplugBProto.Payload.PropertySetList
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#equals(Object)}
   */
  @Test
  void testPayload_PropertySetListEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.PropertySetList.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#equals(Object)}
   */
  @Test
  void testPayload_PropertySetListEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.PropertySetList.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#equals(Object)}
   */
  @Test
  void testPayload_PropertySetListEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.PropertySetList.getDefaultInstance(), "Different type to PropertySetList");
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#getDefaultInstanceForType()}
   */
  @Test
  void testPayload_PropertySetListGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload.PropertySetList defaultInstance = SparkplugBProto.Payload.PropertySetList
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#getPropertysetCount()}
   */
  @Test
  void testPayload_PropertySetListGetPropertysetCount() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.PropertySetList.getDefaultInstance().getPropertysetCount());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#getSerializedSize()}
   */
  @Test
  void testPayload_PropertySetListGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.PropertySetList.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#hasExtensions()}
   */
  @Test
  void testPayload_PropertySetListHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertySetList.getDefaultInstance().hasExtensions());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#isInitialized()}
   */
  @Test
  void testPayload_PropertySetListIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.PropertySetList.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayload_PropertySetListNewInstance() {
    // Arrange
    SparkplugBProto.Payload.PropertySetList defaultInstance = SparkplugBProto.Payload.PropertySetList
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload.PropertySetList);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_PropertySetListParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.PropertySetList.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_PropertySetListParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.PropertySetList.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_PropertySetListParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.PropertySetList.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertySetListParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        SparkplugBProto.Payload.PropertySetList.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertySetListParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.PropertySetList.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertySetListParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.PropertySetList
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#parseFrom(InputStream)}
   */
  @Test
  void testPayload_PropertySetListParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.PropertySetList.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#parseFrom(InputStream)}
   */
  @Test
  void testPayload_PropertySetListParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.PropertySetList.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertySetListParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.PropertySetList.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySetList#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertySetListParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.PropertySetList.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayload_PropertySetNewInstance() {
    // Arrange
    SparkplugBProto.Payload.PropertySet defaultInstance = SparkplugBProto.Payload.PropertySet.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload.PropertySet);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_PropertySetParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.PropertySet.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_PropertySetParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.PropertySet.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_PropertySetParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.PropertySet.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_PropertySetParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SparkplugBProto.Payload.PropertySet.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertySetParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.PropertySet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertySetParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.PropertySet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertySetParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.PropertySet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertySetParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SparkplugBProto.Payload.PropertySet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#parseFrom(InputStream)}
   */
  @Test
  void testPayload_PropertySetParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.PropertySet.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#parseFrom(InputStream)}
   */
  @Test
  void testPayload_PropertySetParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.PropertySet.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertySetParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.PropertySet.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertySet#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertySetParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.PropertySet.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.PropertyValue#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.PropertyValue#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_PropertyValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.PropertyValue defaultInstance = SparkplugBProto.Payload.PropertyValue.getDefaultInstance();
    SparkplugBProto.Payload.PropertyValue defaultInstance2 = SparkplugBProto.Payload.PropertyValue.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.PropertyValue#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.PropertyValue#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_PropertyValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.PropertyValue defaultInstance = SparkplugBProto.Payload.PropertyValue.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#equals(Object)}
   */
  @Test
  void testPayload_PropertyValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.PropertyValue.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#equals(Object)}
   */
  @Test
  void testPayload_PropertyValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.PropertyValue.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#equals(Object)}
   */
  @Test
  void testPayload_PropertyValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.PropertyValue.getDefaultInstance(), "Different type to PropertyValue");
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#getBooleanValue()}
   */
  @Test
  void testPayload_PropertyValueGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertyValue.getDefaultInstance().getBooleanValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#getDefaultInstanceForType()}
   */
  @Test
  void testPayload_PropertyValueGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload.PropertyValue defaultInstance = SparkplugBProto.Payload.PropertyValue.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#getDoubleValue()}
   */
  @Test
  void testPayload_PropertyValueGetDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(0.0d, SparkplugBProto.Payload.PropertyValue.getDefaultInstance().getDoubleValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#getFloatValue()}
   */
  @Test
  void testPayload_PropertyValueGetFloatValue() {
    // Arrange, Act and Assert
    assertEquals(0.0f, SparkplugBProto.Payload.PropertyValue.getDefaultInstance().getFloatValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#getIntValue()}
   */
  @Test
  void testPayload_PropertyValueGetIntValue() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.PropertyValue.getDefaultInstance().getIntValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#getLongValue()}
   */
  @Test
  void testPayload_PropertyValueGetLongValue() {
    // Arrange, Act and Assert
    assertEquals(0L, SparkplugBProto.Payload.PropertyValue.getDefaultInstance().getLongValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#getSerializedSize()}
   */
  @Test
  void testPayload_PropertyValueGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.PropertyValue.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#getStringValue()}
   */
  @Test
  void testPayload_PropertyValueGetStringValue() {
    // Arrange, Act and Assert
    assertEquals("", SparkplugBProto.Payload.PropertyValue.getDefaultInstance().getStringValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#getStringValueBytes()}
   */
  @Test
  void testPayload_PropertyValueGetStringValueBytes() {
    // Arrange
    SparkplugBProto.Payload.PropertyValue defaultInstance = SparkplugBProto.Payload.PropertyValue.getDefaultInstance();

    // Act
    ByteString actualStringValueBytes = defaultInstance.getStringValueBytes();

    // Assert
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getContainingType().getFields();
    assertEquals(6, fields.size());
    ByteString byteString = actualStringValueBytes.EMPTY;
    assertEquals(byteString, actualStringValueBytes);
    assertSame(byteString, defaultInstance.getExtensionValue().getExtensions().getValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#getValueCase()}
   */
  @Test
  void testPayload_PropertyValueGetValueCase() {
    // Arrange, Act and Assert
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.VALUE_NOT_SET,
        SparkplugBProto.Payload.PropertyValue.getDefaultInstance().getValueCase());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#hasBooleanValue()}
   */
  @Test
  void testPayload_PropertyValueHasBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertyValue.getDefaultInstance().hasBooleanValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#hasDoubleValue()}
   */
  @Test
  void testPayload_PropertyValueHasDoubleValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertyValue.getDefaultInstance().hasDoubleValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#hasExtensionValue()}
   */
  @Test
  void testPayload_PropertyValueHasExtensionValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertyValue.getDefaultInstance().hasExtensionValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#hasFloatValue()}
   */
  @Test
  void testPayload_PropertyValueHasFloatValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertyValue.getDefaultInstance().hasFloatValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#hasIntValue()}
   */
  @Test
  void testPayload_PropertyValueHasIntValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertyValue.getDefaultInstance().hasIntValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.PropertyValue#hasIsNull()}
   */
  @Test
  void testPayload_PropertyValueHasIsNull() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertyValue.getDefaultInstance().hasIsNull());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#hasLongValue()}
   */
  @Test
  void testPayload_PropertyValueHasLongValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertyValue.getDefaultInstance().hasLongValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#hasPropertysetValue()}
   */
  @Test
  void testPayload_PropertyValueHasPropertysetValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertyValue.getDefaultInstance().hasPropertysetValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#hasPropertysetsValue()}
   */
  @Test
  void testPayload_PropertyValueHasPropertysetsValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertyValue.getDefaultInstance().hasPropertysetsValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#hasStringValue()}
   */
  @Test
  void testPayload_PropertyValueHasStringValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertyValue.getDefaultInstance().hasStringValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.PropertyValue#hasType()}
   */
  @Test
  void testPayload_PropertyValueHasType() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertyValue.getDefaultInstance().hasType());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#isInitialized()}
   */
  @Test
  void testPayload_PropertyValueIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.PropertyValue.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayload_PropertyValueNewInstance() {
    // Arrange
    SparkplugBProto.Payload.PropertyValue defaultInstance = SparkplugBProto.Payload.PropertyValue.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload.PropertyValue);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_PropertyValueParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.PropertyValue.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_PropertyValueParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.PropertyValue.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_PropertyValueParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.PropertyValue.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_PropertyValueParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SparkplugBProto.Payload.PropertyValue.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertyValueParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        SparkplugBProto.Payload.PropertyValue.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertyValueParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.PropertyValue.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertyValueParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.PropertyValue
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertyValueParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SparkplugBProto.Payload.PropertyValue.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#parseFrom(InputStream)}
   */
  @Test
  void testPayload_PropertyValueParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.PropertyValue.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#parseFrom(InputStream)}
   */
  @Test
  void testPayload_PropertyValueParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.PropertyValue.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertyValueParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.PropertyValue.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertyValueParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.PropertyValue.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#equals(Object)}
   *   <li>
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionEqualsAndHashCode() {
    // Arrange
    SparkplugBProto.Payload.PropertyValue.PropertyValueExtension defaultInstance = SparkplugBProto.Payload.PropertyValue.PropertyValueExtension
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
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#equals(Object)}
   *   <li>
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionEqualsAndHashCode2() {
    // Arrange
    SparkplugBProto.Payload.PropertyValue.PropertyValueExtension defaultInstance = SparkplugBProto.Payload.PropertyValue.PropertyValueExtension
        .getDefaultInstance();
    SparkplugBProto.Payload.PropertyValue.PropertyValueExtension defaultInstance2 = SparkplugBProto.Payload.PropertyValue.PropertyValueExtension
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#equals(Object)}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.getDefaultInstance(), null);
    assertNotEquals(SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.getDefaultInstance(),
        "Different type to PropertyValueExtension");
    assertNotEquals(SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#getDefaultInstanceForType()}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload.PropertyValue.PropertyValueExtension defaultInstance = SparkplugBProto.Payload.PropertyValue.PropertyValueExtension
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#getSerializedSize()}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0,
        SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#hasExtensions()}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.getDefaultInstance().hasExtensions());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#isInitialized()}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionNewInstance() {
    // Arrange
    SparkplugBProto.Payload.PropertyValue.PropertyValueExtension defaultInstance = SparkplugBProto.Payload.PropertyValue.PropertyValueExtension
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload.PropertyValue.PropertyValueExtension);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.PropertyValue.PropertyValueExtension
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.parseDelimitedFrom(input,
            ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#parseFrom(InputStream)}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#parseFrom(InputStream)}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.PropertyValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_PropertyValue_PropertyValueExtensionParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.PropertyValue.PropertyValueExtension.parseFrom(input,
            ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  void testPayload_PropertyValue_ValueCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(SparkplugBProto.Payload.PropertyValue.ValueCase.forNumber(42));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.VALUE_NOT_SET,
        SparkplugBProto.Payload.PropertyValue.ValueCase.forNumber(0));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.INT_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase.forNumber(3));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.LONG_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase.forNumber(4));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.FLOAT_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase.forNumber(5));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.DOUBLE_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase.forNumber(6));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.BOOLEAN_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase.forNumber(7));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.STRING_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase.forNumber(8));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.PROPERTYSET_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase
            .forNumber(SparkplugBProto.Payload.MetaData.EXTENSIONS_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.PROPERTYSETS_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase
            .forNumber(SparkplugBProto.Payload.Metric.INT_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.EXTENSION_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase
            .forNumber(SparkplugBProto.Payload.Metric.LONG_VALUE_FIELD_NUMBER));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.ValueCase#getNumber()}
   */
  @Test
  void testPayload_PropertyValue_ValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(3, SparkplugBProto.Payload.PropertyValue.ValueCase.valueOf("INT_VALUE").getNumber());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  void testPayload_PropertyValue_ValueCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(SparkplugBProto.Payload.PropertyValue.ValueCase.valueOf(42));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.VALUE_NOT_SET,
        SparkplugBProto.Payload.PropertyValue.ValueCase.valueOf(0));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.INT_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase.valueOf(3));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.LONG_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase.valueOf(4));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.FLOAT_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase.valueOf(5));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.DOUBLE_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase.valueOf(6));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.BOOLEAN_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase.valueOf(7));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.STRING_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase.valueOf(8));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.PROPERTYSET_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase
            .valueOf(SparkplugBProto.Payload.MetaData.EXTENSIONS_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.PROPERTYSETS_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase.valueOf(SparkplugBProto.Payload.Metric.INT_VALUE_FIELD_NUMBER));
    assertEquals(SparkplugBProto.Payload.PropertyValue.ValueCase.EXTENSION_VALUE,
        SparkplugBProto.Payload.PropertyValue.ValueCase
            .valueOf(SparkplugBProto.Payload.Metric.LONG_VALUE_FIELD_NUMBER));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.Template#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.Template#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_TemplateEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.Template defaultInstance = SparkplugBProto.Payload.Template.getDefaultInstance();
    SparkplugBProto.Payload.Template defaultInstance2 = SparkplugBProto.Payload.Template.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.Template#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.Template#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_TemplateEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.Template defaultInstance = SparkplugBProto.Payload.Template.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Template#equals(Object)}
   */
  @Test
  void testPayload_TemplateEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.Template.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Template#equals(Object)}
   */
  @Test
  void testPayload_TemplateEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.Template.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Template#equals(Object)}
   */
  @Test
  void testPayload_TemplateEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.Template.getDefaultInstance(), "Different type to Template");
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#getDefaultInstanceForType()}
   */
  @Test
  void testPayload_TemplateGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload.Template defaultInstance = SparkplugBProto.Payload.Template.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Template#getMetricsCount()}
   */
  @Test
  void testPayload_TemplateGetMetricsCount() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.Template.getDefaultInstance().getMetricsCount());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#getParametersCount()}
   */
  @Test
  void testPayload_TemplateGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.Template.getDefaultInstance().getParametersCount());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#getSerializedSize()}
   */
  @Test
  void testPayload_TemplateGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.Template.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Template#getTemplateRef()}
   */
  @Test
  void testPayload_TemplateGetTemplateRef() {
    // Arrange, Act and Assert
    assertEquals("", SparkplugBProto.Payload.Template.getDefaultInstance().getTemplateRef());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#getTemplateRefBytes()}
   */
  @Test
  void testPayload_TemplateGetTemplateRefBytes() {
    // Arrange
    SparkplugBProto.Payload.Template defaultInstance = SparkplugBProto.Payload.Template.getDefaultInstance();

    // Act
    ByteString actualTemplateRefBytes = defaultInstance.getTemplateRefBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getContainingType().getFields();
    assertEquals(6, fields.size());
    assertEquals(6, descriptorForType.getFields().size());
    ByteString byteString = actualTemplateRefBytes.EMPTY;
    assertEquals(byteString, actualTemplateRefBytes);
    assertSame(byteString, defaultInstance.getExtensions().getValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Template#getVersion()}
   */
  @Test
  void testPayload_TemplateGetVersion() {
    // Arrange, Act and Assert
    assertEquals("", SparkplugBProto.Payload.Template.getDefaultInstance().getVersion());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Template#getVersionBytes()}
   */
  @Test
  void testPayload_TemplateGetVersionBytes() {
    // Arrange
    SparkplugBProto.Payload.Template defaultInstance = SparkplugBProto.Payload.Template.getDefaultInstance();

    // Act
    ByteString actualVersionBytes = defaultInstance.getVersionBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getContainingType().getFields();
    assertEquals(6, fields.size());
    assertEquals(6, descriptorForType.getFields().size());
    ByteString byteString = actualVersionBytes.EMPTY;
    assertEquals(byteString, actualVersionBytes);
    assertSame(byteString, defaultInstance.getExtensions().getValue());
    assertSame(byteString, fields.get(4).getDefaultValue());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Template#hasExtensions()}
   */
  @Test
  void testPayload_TemplateHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Template.getDefaultInstance().hasExtensions());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Template#hasIsDefinition()}
   */
  @Test
  void testPayload_TemplateHasIsDefinition() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Template.getDefaultInstance().hasIsDefinition());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Template#hasTemplateRef()}
   */
  @Test
  void testPayload_TemplateHasTemplateRef() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Template.getDefaultInstance().hasTemplateRef());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Template#hasVersion()}
   */
  @Test
  void testPayload_TemplateHasVersion() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Template.getDefaultInstance().hasVersion());
  }

  /**
   * Method under test: {@link SparkplugBProto.Payload.Template#isInitialized()}
   */
  @Test
  void testPayload_TemplateIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.Template.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayload_TemplateNewInstance() {
    // Arrange
    SparkplugBProto.Payload.Template defaultInstance = SparkplugBProto.Payload.Template.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload.Template);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_TemplateParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.Template.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_TemplateParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.Template.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_TemplateParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.Template.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_TemplateParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SparkplugBProto.Payload.Template.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_TemplateParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.Template.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_TemplateParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.Template.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_TemplateParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.Template.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_TemplateParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SparkplugBProto.Payload.Template.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#parseFrom(InputStream)}
   */
  @Test
  void testPayload_TemplateParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.Template.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#parseFrom(InputStream)}
   */
  @Test
  void testPayload_TemplateParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.Template.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_TemplateParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.Template.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_TemplateParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.Template.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.Template.Parameter#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.Template.Parameter#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_Template_ParameterEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.Template.Parameter defaultInstance = SparkplugBProto.Payload.Template.Parameter
        .getDefaultInstance();
    SparkplugBProto.Payload.Template.Parameter defaultInstance2 = SparkplugBProto.Payload.Template.Parameter
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugBProto.Payload.Template.Parameter#equals(Object)}
   *   <li>{@link SparkplugBProto.Payload.Template.Parameter#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_Template_ParameterEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SparkplugBProto.Payload.Template.Parameter defaultInstance = SparkplugBProto.Payload.Template.Parameter
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#equals(Object)}
   */
  @Test
  void testPayload_Template_ParameterEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.Template.Parameter.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#equals(Object)}
   */
  @Test
  void testPayload_Template_ParameterEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.Template.Parameter.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#equals(Object)}
   */
  @Test
  void testPayload_Template_ParameterEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.Template.Parameter.getDefaultInstance(), "Different type to Parameter");
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#getBooleanValue()}
   */
  @Test
  void testPayload_Template_ParameterGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().getBooleanValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#getDefaultInstanceForType()}
   */
  @Test
  void testPayload_Template_ParameterGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload.Template.Parameter defaultInstance = SparkplugBProto.Payload.Template.Parameter
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#getDoubleValue()}
   */
  @Test
  void testPayload_Template_ParameterGetDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(0.0d, SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().getDoubleValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#getFloatValue()}
   */
  @Test
  void testPayload_Template_ParameterGetFloatValue() {
    // Arrange, Act and Assert
    assertEquals(0.0f, SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().getFloatValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#getIntValue()}
   */
  @Test
  void testPayload_Template_ParameterGetIntValue() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().getIntValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#getLongValue()}
   */
  @Test
  void testPayload_Template_ParameterGetLongValue() {
    // Arrange, Act and Assert
    assertEquals(0L, SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().getLongValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#getName()}
   */
  @Test
  void testPayload_Template_ParameterGetName() {
    // Arrange, Act and Assert
    assertEquals("", SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().getName());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#getNameBytes()}
   */
  @Test
  void testPayload_Template_ParameterGetNameBytes() {
    // Arrange
    SparkplugBProto.Payload.Template.Parameter defaultInstance = SparkplugBProto.Payload.Template.Parameter
        .getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    assertEquals(byteString, actualNameBytes);
    assertEquals(SparkplugBProto.Payload.Template.Parameter.EXTENSION_VALUE_FIELD_NUMBER,
        defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getExtensionValue().getExtensions().getValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#getSerializedSize()}
   */
  @Test
  void testPayload_Template_ParameterGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#getStringValue()}
   */
  @Test
  void testPayload_Template_ParameterGetStringValue() {
    // Arrange, Act and Assert
    assertEquals("", SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().getStringValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#getStringValueBytes()}
   */
  @Test
  void testPayload_Template_ParameterGetStringValueBytes() {
    // Arrange
    SparkplugBProto.Payload.Template.Parameter defaultInstance = SparkplugBProto.Payload.Template.Parameter
        .getDefaultInstance();

    // Act
    ByteString actualStringValueBytes = defaultInstance.getStringValueBytes();

    // Assert
    ByteString byteString = actualStringValueBytes.EMPTY;
    assertEquals(byteString, actualStringValueBytes);
    assertEquals(SparkplugBProto.Payload.Template.Parameter.EXTENSION_VALUE_FIELD_NUMBER,
        defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getExtensionValue().getExtensions().getValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#getValueCase()}
   */
  @Test
  void testPayload_Template_ParameterGetValueCase() {
    // Arrange, Act and Assert
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.VALUE_NOT_SET,
        SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().getValueCase());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#hasBooleanValue()}
   */
  @Test
  void testPayload_Template_ParameterHasBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().hasBooleanValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#hasDoubleValue()}
   */
  @Test
  void testPayload_Template_ParameterHasDoubleValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().hasDoubleValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#hasExtensionValue()}
   */
  @Test
  void testPayload_Template_ParameterHasExtensionValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().hasExtensionValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#hasFloatValue()}
   */
  @Test
  void testPayload_Template_ParameterHasFloatValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().hasFloatValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#hasIntValue()}
   */
  @Test
  void testPayload_Template_ParameterHasIntValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().hasIntValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#hasLongValue()}
   */
  @Test
  void testPayload_Template_ParameterHasLongValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().hasLongValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#hasName()}
   */
  @Test
  void testPayload_Template_ParameterHasName() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().hasName());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#hasStringValue()}
   */
  @Test
  void testPayload_Template_ParameterHasStringValue() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().hasStringValue());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#hasType()}
   */
  @Test
  void testPayload_Template_ParameterHasType() {
    // Arrange, Act and Assert
    assertFalse(SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().hasType());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#isInitialized()}
   */
  @Test
  void testPayload_Template_ParameterIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.Template.Parameter.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayload_Template_ParameterNewInstance() {
    // Arrange
    SparkplugBProto.Payload.Template.Parameter defaultInstance = SparkplugBProto.Payload.Template.Parameter
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload.Template.Parameter);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_Template_ParameterParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.Template.Parameter.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_Template_ParameterParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.Template.Parameter.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_Template_ParameterParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.Template.Parameter.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_Template_ParameterParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> SparkplugBProto.Payload.Template.Parameter.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Template_ParameterParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        SparkplugBProto.Payload.Template.Parameter.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Template_ParameterParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.Template.Parameter.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Template_ParameterParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> SparkplugBProto.Payload.Template.Parameter
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Template_ParameterParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SparkplugBProto.Payload.Template.Parameter
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#parseFrom(InputStream)}
   */
  @Test
  void testPayload_Template_ParameterParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.Template.Parameter.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#parseFrom(InputStream)}
   */
  @Test
  void testPayload_Template_ParameterParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.Template.Parameter.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Template_ParameterParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.Template.Parameter.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Template_ParameterParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.Template.Parameter.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#equals(Object)}
   *   <li>
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionEqualsAndHashCode() {
    // Arrange
    SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension defaultInstance = SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension
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
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#equals(Object)}
   *   <li>
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#hashCode()}
   * </ul>
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionEqualsAndHashCode2() {
    // Arrange
    SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension defaultInstance = SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension
        .getDefaultInstance();
    SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension defaultInstance2 = SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#equals(Object)}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension.getDefaultInstance(), null);
    assertNotEquals(SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension.getDefaultInstance(),
        "Different type to ParameterValueExtension");
    assertNotEquals(SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#getDefaultInstanceForType()}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionGetDefaultInstanceForType() {
    // Arrange
    SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension defaultInstance = SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#getSerializedSize()}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0,
        SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#hasExtensions()}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(
        SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension.getDefaultInstance().hasExtensions());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#isInitialized()}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionNewInstance() {
    // Arrange
    SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension defaultInstance = SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension.parseDelimitedFrom(input,
            ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#parseFrom(InputStream)}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#parseFrom(InputStream)}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testPayload_Template_Parameter_ParameterValueExtensionParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension.parseFrom(input,
            ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  void testPayload_Template_Parameter_ValueCaseForNumber() {
    // Arrange, Act and Assert
    assertNull(SparkplugBProto.Payload.Template.Parameter.ValueCase.forNumber(42));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.VALUE_NOT_SET,
        SparkplugBProto.Payload.Template.Parameter.ValueCase.forNumber(0));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.INT_VALUE,
        SparkplugBProto.Payload.Template.Parameter.ValueCase.forNumber(3));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.LONG_VALUE,
        SparkplugBProto.Payload.Template.Parameter.ValueCase.forNumber(4));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.FLOAT_VALUE,
        SparkplugBProto.Payload.Template.Parameter.ValueCase.forNumber(5));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.DOUBLE_VALUE,
        SparkplugBProto.Payload.Template.Parameter.ValueCase.forNumber(6));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.BOOLEAN_VALUE,
        SparkplugBProto.Payload.Template.Parameter.ValueCase.forNumber(7));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.STRING_VALUE,
        SparkplugBProto.Payload.Template.Parameter.ValueCase.forNumber(8));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.EXTENSION_VALUE,
        SparkplugBProto.Payload.Template.Parameter.ValueCase
            .forNumber(SparkplugBProto.Payload.MetaData.EXTENSIONS_FIELD_NUMBER));
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ValueCase#getNumber()}
   */
  @Test
  void testPayload_Template_Parameter_ValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(3, SparkplugBProto.Payload.Template.Parameter.ValueCase.valueOf("INT_VALUE").getNumber());
  }

  /**
   * Method under test:
   * {@link SparkplugBProto.Payload.Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  void testPayload_Template_Parameter_ValueCaseValueOf() {
    // Arrange, Act and Assert
    assertNull(SparkplugBProto.Payload.Template.Parameter.ValueCase.valueOf(42));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.VALUE_NOT_SET,
        SparkplugBProto.Payload.Template.Parameter.ValueCase.valueOf(0));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.INT_VALUE,
        SparkplugBProto.Payload.Template.Parameter.ValueCase.valueOf(3));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.LONG_VALUE,
        SparkplugBProto.Payload.Template.Parameter.ValueCase.valueOf(4));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.FLOAT_VALUE,
        SparkplugBProto.Payload.Template.Parameter.ValueCase.valueOf(5));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.DOUBLE_VALUE,
        SparkplugBProto.Payload.Template.Parameter.ValueCase.valueOf(6));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.BOOLEAN_VALUE,
        SparkplugBProto.Payload.Template.Parameter.ValueCase.valueOf(7));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.STRING_VALUE,
        SparkplugBProto.Payload.Template.Parameter.ValueCase.valueOf(8));
    assertEquals(SparkplugBProto.Payload.Template.Parameter.ValueCase.EXTENSION_VALUE,
        SparkplugBProto.Payload.Template.Parameter.ValueCase
            .valueOf(SparkplugBProto.Payload.MetaData.EXTENSIONS_FIELD_NUMBER));
  }
}
