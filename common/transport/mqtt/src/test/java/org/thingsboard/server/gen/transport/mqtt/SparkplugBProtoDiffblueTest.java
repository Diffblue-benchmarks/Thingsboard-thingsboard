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
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
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
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.DataSet;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.DataSet.DataSetValue;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.DataSet.DataSetValue.DataSetValueExtension;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.DataSet.Row;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.MetaData;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.Metric;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.Metric.MetricValueExtension;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.Metric.ValueCase;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.PropertySet;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.PropertySetList;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.PropertyValue;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.PropertyValue.PropertyValueExtension;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.Template;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.Template.Parameter;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.Template.Parameter.ParameterValueExtension;

class SparkplugBProtoDiffblueTest {
  /**
   * Test Payload {@link Payload#equals(Object)}, and {@link Payload#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Payload#equals(Object)}
   *   <li>{@link Payload#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Payload.equals(Object)", "int Payload.hashCode()"})
  void testPayloadEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Payload defaultInstance = Payload.getDefaultInstance();
    Payload defaultInstance2 = Payload.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload {@link Payload#equals(Object)}, and {@link Payload#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Payload#equals(Object)}
   *   <li>{@link Payload#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Payload.equals(Object)", "int Payload.hashCode()"})
  void testPayloadEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Payload defaultInstance = Payload.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload {@link Payload#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Payload.equals(Object)", "int Payload.hashCode()"})
  void testPayloadEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Payload.getDefaultInstance(), 1);
  }

  /**
   * Test Payload {@link Payload#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Payload.equals(Object)", "int Payload.hashCode()"})
  void testPayloadEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Payload.getDefaultInstance(), null);
  }

  /**
   * Test Payload {@link Payload#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Payload.equals(Object)", "int Payload.hashCode()"})
  void testPayloadEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Payload.getDefaultInstance(), "Different type to Payload");
  }

  /**
   * Test Payload {@link Payload#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link Payload#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.getDefaultInstanceForType()"})
  void testPayloadGetDefaultInstanceForType() {
    // Arrange
    Payload defaultInstance = Payload.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload {@link Payload#getExtensions()}.
   * <p>
   * Method under test: {@link Payload#getExtensions()}
   */
  @Test
  @DisplayName("Test Payload getExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Any Payload.getExtensions()"})
  void testPayloadGetExtensions() {
    // Arrange and Act
    Any actualExtensions = Payload.getDefaultInstance().getExtensions();

    // Assert
    assertEquals("", actualExtensions.getInitializationErrorString());
    assertEquals("", actualExtensions.getTypeUrl());
    assertEquals(0, actualExtensions.getSerializedSize());
    assertTrue(actualExtensions.isInitialized());
    assertTrue(actualExtensions.findInitializationErrors().isEmpty());
    assertTrue(actualExtensions.getAllFields().isEmpty());
    assertSame(actualExtensions, actualExtensions.getDefaultInstanceForType());
  }

  /**
   * Test Payload {@link Payload#getMetricsCount()}.
   * <p>
   * Method under test: {@link Payload#getMetricsCount()}
   */
  @Test
  @DisplayName("Test Payload getMetricsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Payload.getMetricsCount()"})
  void testPayloadGetMetricsCount() {
    // Arrange, Act and Assert
    assertEquals(0, Payload.getDefaultInstance().getMetricsCount());
  }

  /**
   * Test Payload {@link Payload#getSerializedSize()}.
   * <p>
   * Method under test: {@link Payload#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Payload.getSerializedSize()"})
  void testPayloadGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Payload.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload {@link Payload#getUuid()}.
   * <p>
   * Method under test: {@link Payload#getUuid()}
   */
  @Test
  @DisplayName("Test Payload getUuid()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String Payload.getUuid()"})
  void testPayloadGetUuid() {
    // Arrange, Act and Assert
    assertEquals("", Payload.getDefaultInstance().getUuid());
  }

  /**
   * Test Payload {@link Payload#getUuidBytes()}.
   * <p>
   * Method under test: {@link Payload#getUuidBytes()}
   */
  @Test
  @DisplayName("Test Payload getUuidBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString Payload.getUuidBytes()"})
  void testPayloadGetUuidBytes() {
    // Arrange
    Payload defaultInstance = Payload.getDefaultInstance();

    // Act
    ByteString actualUuidBytes = defaultInstance.getUuidBytes();

    // Assert
    ByteString byteString = actualUuidBytes.EMPTY;
    assertEquals(byteString, actualUuidBytes);
    assertSame(byteString, defaultInstance.getExtensions().getValue());
    assertSame(byteString, defaultInstance.getBody());
  }

  /**
   * Test Payload {@link Payload#hasBody()}.
   * <p>
   * Method under test: {@link Payload#hasBody()}
   */
  @Test
  @DisplayName("Test Payload hasBody()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Payload.hasBody()"})
  void testPayloadHasBody() {
    // Arrange, Act and Assert
    assertFalse(Payload.getDefaultInstance().hasBody());
  }

  /**
   * Test Payload {@link Payload#hasExtensions()}.
   * <p>
   * Method under test: {@link Payload#hasExtensions()}
   */
  @Test
  @DisplayName("Test Payload hasExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Payload.hasExtensions()"})
  void testPayloadHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(Payload.getDefaultInstance().hasExtensions());
  }

  /**
   * Test Payload {@link Payload#hasSeq()}.
   * <p>
   * Method under test: {@link Payload#hasSeq()}
   */
  @Test
  @DisplayName("Test Payload hasSeq()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Payload.hasSeq()"})
  void testPayloadHasSeq() {
    // Arrange, Act and Assert
    assertFalse(Payload.getDefaultInstance().hasSeq());
  }

  /**
   * Test Payload {@link Payload#hasTimestamp()}.
   * <p>
   * Method under test: {@link Payload#hasTimestamp()}
   */
  @Test
  @DisplayName("Test Payload hasTimestamp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Payload.hasTimestamp()"})
  void testPayloadHasTimestamp() {
    // Arrange, Act and Assert
    assertFalse(Payload.getDefaultInstance().hasTimestamp());
  }

  /**
   * Test Payload {@link Payload#hasUuid()}.
   * <p>
   * Method under test: {@link Payload#hasUuid()}
   */
  @Test
  @DisplayName("Test Payload hasUuid()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Payload.hasUuid()"})
  void testPayloadHasUuid() {
    // Arrange, Act and Assert
    assertFalse(Payload.getDefaultInstance().hasUuid());
  }

  /**
   * Test Payload {@link Payload#isInitialized()}.
   * <p>
   * Method under test: {@link Payload#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Payload.isInitialized()"})
  void testPayloadIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Payload.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload {@link Payload#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link Payload#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseDelimitedFrom(InputStream)"})
  void testPayloadParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Payload actualParseDelimitedFromResult = Payload.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    assertEquals(4, descriptorForType.getOneofs().size());
    assertEquals(6, descriptorForType.getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(7, descriptorForType.getNestedTypes().size());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload {@link Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayloadParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, Payload.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload {@link Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayloadParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Payload actualParseDelimitedFromResult = Payload.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    assertEquals(4, descriptorForType.getOneofs().size());
    assertEquals(6, descriptorForType.getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(7, descriptorForType.getNestedTypes().size());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload {@link Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayloadParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Payload.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload {@link Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayloadParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Payload.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload {@link Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayloadParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Payload.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload {@link Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayloadParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Payload.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload {@link Payload#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseDelimitedFrom(InputStream)"})
  void testPayloadParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Payload.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload {@link Payload#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseDelimitedFrom(InputStream)"})
  void testPayloadParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, Payload.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload {@link Payload#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseDelimitedFrom(InputStream)"})
  void testPayloadParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Payload.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload {@link Payload#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseDelimitedFrom(InputStream)"})
  void testPayloadParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Payload.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload {@link Payload#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseDelimitedFrom(InputStream)"})
  void testPayloadParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Payload.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload {@link Payload#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link Payload#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseFrom(ByteBuffer)"})
  void testPayloadParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    Payload actualParseFromResult = Payload.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getUuid());
    assertEquals(0, actualParseFromResult.getMetricsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getSeq());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertFalse(actualParseFromResult.hasBody());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasSeq());
    assertFalse(actualParseFromResult.hasTimestamp());
    assertFalse(actualParseFromResult.hasUuid());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Metric> metricsList = actualParseFromResult.getMetricsList();
    assertTrue(metricsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(metricsList, actualParseFromResult.getMetricsOrBuilderList());
  }

  /**
   * Test Payload {@link Payload#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Payload#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayloadParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Payload actualParseFromResult = Payload.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getUuid());
    assertEquals(0, actualParseFromResult.getMetricsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getSeq());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertFalse(actualParseFromResult.hasBody());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasSeq());
    assertFalse(actualParseFromResult.hasTimestamp());
    assertFalse(actualParseFromResult.hasUuid());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Metric> metricsList = actualParseFromResult.getMetricsList();
    assertTrue(metricsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(metricsList, actualParseFromResult.getMetricsOrBuilderList());
  }

  /**
   * Test Payload {@link Payload#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Payload#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayloadParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    Payload actualParseFromResult = Payload.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getUuid());
    assertEquals(0, actualParseFromResult.getMetricsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getSeq());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertFalse(actualParseFromResult.hasBody());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasSeq());
    assertFalse(actualParseFromResult.hasTimestamp());
    assertFalse(actualParseFromResult.hasUuid());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Metric> metricsList = actualParseFromResult.getMetricsList();
    assertTrue(metricsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(metricsList, actualParseFromResult.getMetricsOrBuilderList());
  }

  /**
   * Test Payload {@link Payload#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseFrom(byte[])"})
  void testPayloadParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    Payload actualParseFromResult = Payload.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getUuid());
    assertEquals(0, actualParseFromResult.getMetricsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getSeq());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertFalse(actualParseFromResult.hasBody());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasSeq());
    assertFalse(actualParseFromResult.hasTimestamp());
    assertFalse(actualParseFromResult.hasUuid());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Metric> metricsList = actualParseFromResult.getMetricsList();
    assertTrue(metricsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(metricsList, actualParseFromResult.getMetricsOrBuilderList());
  }

  /**
   * Test Payload {@link Payload#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Payload#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayloadParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Payload actualParseFromResult = Payload.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getUuid());
    assertEquals(0, actualParseFromResult.getMetricsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getSeq());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertFalse(actualParseFromResult.hasBody());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasSeq());
    assertFalse(actualParseFromResult.hasTimestamp());
    assertFalse(actualParseFromResult.hasUuid());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Metric> metricsList = actualParseFromResult.getMetricsList();
    assertTrue(metricsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(metricsList, actualParseFromResult.getMetricsOrBuilderList());
  }

  /**
   * Test Payload {@link Payload#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Payload#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayloadParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Payload.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload {@link Payload#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayloadParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Payload.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload {@link Payload#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseFrom(InputStream)"})
  void testPayloadParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Payload.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload {@link Payload#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseFrom(InputStream)"})
  void testPayloadParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Payload.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload {@link Payload#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseFrom(InputStream)"})
  void testPayloadParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    Payload actualParseFromResult = Payload.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload {@link Payload#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Payload#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Payload Payload.parseFrom(InputStream)"})
  void testPayloadParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    Payload actualParseFromResult = Payload.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_DataSet {@link DataSet#equals(Object)}, and {@link DataSet#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataSet#equals(Object)}
   *   <li>{@link DataSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_DataSet equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
  void testPayload_DataSetEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DataSet defaultInstance = DataSet.getDefaultInstance();
    DataSet defaultInstance2 = DataSet.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload_DataSet {@link DataSet#equals(Object)}, and {@link DataSet#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataSet#equals(Object)}
   *   <li>{@link DataSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_DataSet equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
  void testPayload_DataSetEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DataSet defaultInstance = DataSet.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload_DataSet {@link DataSet#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_DataSet equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
  void testPayload_DataSetEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataSet.getDefaultInstance(), 1);
  }

  /**
   * Test Payload_DataSet {@link DataSet#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_DataSet equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
  void testPayload_DataSetEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataSet.getDefaultInstance(), null);
  }

  /**
   * Test Payload_DataSet {@link DataSet#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_DataSet equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
  void testPayload_DataSetEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataSet.getDefaultInstance(), "Different type to DataSet");
  }

  /**
   * Test Payload_DataSet {@link DataSet#getColumnsCount()}.
   * <p>
   * Method under test: {@link DataSet#getColumnsCount()}
   */
  @Test
  @DisplayName("Test Payload_DataSet getColumnsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataSet.getColumnsCount()"})
  void testPayload_DataSetGetColumnsCount() {
    // Arrange, Act and Assert
    assertEquals(0, DataSet.getDefaultInstance().getColumnsCount());
  }

  /**
   * Test Payload_DataSet {@link DataSet#getColumnsList()}.
   * <p>
   * Method under test: {@link DataSet#getColumnsList()}
   */
  @Test
  @DisplayName("Test Payload_DataSet getColumnsList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtocolStringList DataSet.getColumnsList()"})
  void testPayload_DataSetGetColumnsList() {
    // Arrange
    DataSet defaultInstance = DataSet.getDefaultInstance();

    // Act
    ProtocolStringList actualColumnsList = defaultInstance.getColumnsList();

    // Assert
    assertTrue(actualColumnsList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualColumnsList).EMPTY;
    assertSame(lazyStringList, defaultInstance.getDescriptorForType().toProto().getReservedNameList());
    assertSame(lazyStringList, actualColumnsList);
  }

  /**
   * Test Payload_DataSet {@link DataSet#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link DataSet#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload_DataSet getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.getDefaultInstanceForType()"})
  void testPayload_DataSetGetDefaultInstanceForType() {
    // Arrange
    DataSet defaultInstance = DataSet.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet {@link DataSet#getExtensions()}.
   * <p>
   * Method under test: {@link DataSet#getExtensions()}
   */
  @Test
  @DisplayName("Test Payload_DataSet getExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Any DataSet.getExtensions()"})
  void testPayload_DataSetGetExtensions() {
    // Arrange and Act
    Any actualExtensions = DataSet.getDefaultInstance().getExtensions();

    // Assert
    assertEquals("", actualExtensions.getInitializationErrorString());
    assertEquals("", actualExtensions.getTypeUrl());
    assertEquals(0, actualExtensions.getSerializedSize());
    assertTrue(actualExtensions.isInitialized());
    assertTrue(actualExtensions.findInitializationErrors().isEmpty());
    assertTrue(actualExtensions.getAllFields().isEmpty());
    assertSame(actualExtensions, actualExtensions.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet {@link DataSet#getRowsCount()}.
   * <p>
   * Method under test: {@link DataSet#getRowsCount()}
   */
  @Test
  @DisplayName("Test Payload_DataSet getRowsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataSet.getRowsCount()"})
  void testPayload_DataSetGetRowsCount() {
    // Arrange, Act and Assert
    assertEquals(0, DataSet.getDefaultInstance().getRowsCount());
  }

  /**
   * Test Payload_DataSet {@link DataSet#getSerializedSize()}.
   * <p>
   * Method under test: {@link DataSet#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload_DataSet getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataSet.getSerializedSize()"})
  void testPayload_DataSetGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DataSet.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload_DataSet {@link DataSet#getTypesCount()}.
   * <p>
   * Method under test: {@link DataSet#getTypesCount()}
   */
  @Test
  @DisplayName("Test Payload_DataSet getTypesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataSet.getTypesCount()"})
  void testPayload_DataSetGetTypesCount() {
    // Arrange, Act and Assert
    assertEquals(0, DataSet.getDefaultInstance().getTypesCount());
  }

  /**
   * Test Payload_DataSet {@link DataSet#hasExtensions()}.
   * <p>
   * Method under test: {@link DataSet#hasExtensions()}
   */
  @Test
  @DisplayName("Test Payload_DataSet hasExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.hasExtensions()"})
  void testPayload_DataSetHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(DataSet.getDefaultInstance().hasExtensions());
  }

  /**
   * Test Payload_DataSet {@link DataSet#hasNumOfColumns()}.
   * <p>
   * Method under test: {@link DataSet#hasNumOfColumns()}
   */
  @Test
  @DisplayName("Test Payload_DataSet hasNumOfColumns()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.hasNumOfColumns()"})
  void testPayload_DataSetHasNumOfColumns() {
    // Arrange, Act and Assert
    assertFalse(DataSet.getDefaultInstance().hasNumOfColumns());
  }

  /**
   * Test Payload_DataSet {@link DataSet#isInitialized()}.
   * <p>
   * Method under test: {@link DataSet#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload_DataSet isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.isInitialized()"})
  void testPayload_DataSetIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DataSet.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DataSet#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSetParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DataSet actualParseDelimitedFromResult = DataSet.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getOneofs().size());
    assertEquals(2, descriptorForType.getNestedTypes().size());
    assertEquals(5, descriptorForType.getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DataSet#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSetParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataSet.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSetParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, DataSet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSetParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DataSet actualParseDelimitedFromResult = DataSet.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getOneofs().size());
    assertEquals(2, descriptorForType.getNestedTypes().size());
    assertEquals(5, descriptorForType.getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSetParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DataSet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSetParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataSet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSetParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> DataSet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSetParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataSet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSetParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataSet.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSetParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, DataSet.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSetParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DataSet.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSetParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DataSet.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link DataSet#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(byte[])"})
  void testPayload_DataSetParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    DataSet actualParseFromResult = DataSet.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getColumnsCount());
    assertEquals(0, actualParseFromResult.getRowsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypesCount());
    assertEquals(0L, actualParseFromResult.getNumOfColumns());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasNumOfColumns());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getColumnsList().isEmpty());
    List<Row> rowsList = actualParseFromResult.getRowsList();
    assertTrue(rowsList.isEmpty());
    assertTrue(actualParseFromResult.getTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(rowsList, actualParseFromResult.getRowsOrBuilderList());
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link DataSet#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(ByteBuffer)"})
  void testPayload_DataSetParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    DataSet actualParseFromResult = DataSet.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getColumnsCount());
    assertEquals(0, actualParseFromResult.getRowsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypesCount());
    assertEquals(0L, actualParseFromResult.getNumOfColumns());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasNumOfColumns());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getColumnsList().isEmpty());
    List<Row> rowsList = actualParseFromResult.getRowsList();
    assertTrue(rowsList.isEmpty());
    assertTrue(actualParseFromResult.getTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(rowsList, actualParseFromResult.getRowsOrBuilderList());
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayload_DataSetParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    DataSet actualParseFromResult = DataSet.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getColumnsCount());
    assertEquals(0, actualParseFromResult.getRowsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypesCount());
    assertEquals(0L, actualParseFromResult.getNumOfColumns());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasNumOfColumns());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getColumnsList().isEmpty());
    List<Row> rowsList = actualParseFromResult.getRowsList();
    assertTrue(rowsList.isEmpty());
    assertTrue(actualParseFromResult.getTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(rowsList, actualParseFromResult.getRowsOrBuilderList());
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayload_DataSetParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    DataSet actualParseFromResult = DataSet.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getColumnsCount());
    assertEquals(0, actualParseFromResult.getRowsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypesCount());
    assertEquals(0L, actualParseFromResult.getNumOfColumns());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasNumOfColumns());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getColumnsList().isEmpty());
    List<Row> rowsList = actualParseFromResult.getRowsList();
    assertTrue(rowsList.isEmpty());
    assertTrue(actualParseFromResult.getTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(rowsList, actualParseFromResult.getRowsOrBuilderList());
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link DataSet#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(ByteString)"})
  void testPayload_DataSetParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    DataSet actualParseFromResult = DataSet.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getColumnsCount());
    assertEquals(0, actualParseFromResult.getRowsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypesCount());
    assertEquals(0L, actualParseFromResult.getNumOfColumns());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasNumOfColumns());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getColumnsList().isEmpty());
    List<Row> rowsList = actualParseFromResult.getRowsList();
    assertTrue(rowsList.isEmpty());
    assertTrue(actualParseFromResult.getTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(rowsList, actualParseFromResult.getRowsOrBuilderList());
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testPayload_DataSetParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    DataSet actualParseFromResult = DataSet.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getColumnsCount());
    assertEquals(0, actualParseFromResult.getRowsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypesCount());
    assertEquals(0L, actualParseFromResult.getNumOfColumns());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasNumOfColumns());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getColumnsList().isEmpty());
    List<Row> rowsList = actualParseFromResult.getRowsList();
    assertTrue(rowsList.isEmpty());
    assertTrue(actualParseFromResult.getTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(rowsList, actualParseFromResult.getRowsOrBuilderList());
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link DataSet#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(CodedInputStream)"})
  void testPayload_DataSetParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    DataSet actualParseFromResult = DataSet.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getColumnsCount());
    assertEquals(0, actualParseFromResult.getRowsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypesCount());
    assertEquals(0L, actualParseFromResult.getNumOfColumns());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasNumOfColumns());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getColumnsList().isEmpty());
    List<Row> rowsList = actualParseFromResult.getRowsList();
    assertTrue(rowsList.isEmpty());
    assertTrue(actualParseFromResult.getTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(rowsList, actualParseFromResult.getRowsOrBuilderList());
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testPayload_DataSetParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    DataSet actualParseFromResult = DataSet.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getColumnsCount());
    assertEquals(0, actualParseFromResult.getRowsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypesCount());
    assertEquals(0L, actualParseFromResult.getNumOfColumns());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasNumOfColumns());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getColumnsList().isEmpty());
    List<Row> rowsList = actualParseFromResult.getRowsList();
    assertTrue(rowsList.isEmpty());
    assertTrue(actualParseFromResult.getTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(rowsList, actualParseFromResult.getRowsOrBuilderList());
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link DataSet#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(InputStream)"})
  void testPayload_DataSetParseFromWithInputStream() throws IOException {
    // Arrange and Act
    DataSet actualParseFromResult = DataSet.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link DataSet#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(InputStream)"})
  void testPayload_DataSetParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataSet.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSetParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    DataSet actualParseFromResult = DataSet.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getColumnsCount());
    assertEquals(0, actualParseFromResult.getRowsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getTypesCount());
    assertEquals(0L, actualParseFromResult.getNumOfColumns());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasNumOfColumns());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getColumnsList().isEmpty());
    List<Row> rowsList = actualParseFromResult.getRowsList();
    assertTrue(rowsList.isEmpty());
    assertTrue(actualParseFromResult.getTypesList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(rowsList, actualParseFromResult.getRowsOrBuilderList());
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSetParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataSet.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSetParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataSet.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(InputStream)"})
  void testPayload_DataSetParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataSet.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet {@link DataSet#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet DataSet.parseFrom(InputStream)"})
  void testPayload_DataSetParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    DataSet actualParseFromResult = DataSet.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#equals(Object)}, and {@link DataSet.DataSetValue#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataSet.DataSetValue#equals(Object)}
   *   <li>{@link DataSet.DataSetValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue equals(Object), and hashCode(); then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.equals(Object)", "int DataSet.DataSetValue.hashCode()"})
  void testPayload_DataSet_DataSetValueEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    DataSetValue defaultInstance = DataSetValue.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#equals(Object)}, and {@link DataSet.DataSetValue#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataSet.DataSetValue#equals(Object)}
   *   <li>{@link DataSet.DataSetValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue equals(Object), and hashCode(); then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.equals(Object)", "int DataSet.DataSetValue.hashCode()"})
  void testPayload_DataSet_DataSetValueEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    DataSetValue defaultInstance = DataSetValue.getDefaultInstance();
    DataSetValue defaultInstance2 = DataSetValue.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.equals(Object)", "int DataSet.DataSetValue.hashCode()"})
  void testPayload_DataSet_DataSetValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataSetValue.getDefaultInstance(), 1);
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.equals(Object)", "int DataSet.DataSetValue.hashCode()"})
  void testPayload_DataSet_DataSetValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataSetValue.getDefaultInstance(), null);
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.equals(Object)", "int DataSet.DataSetValue.hashCode()"})
  void testPayload_DataSet_DataSetValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataSetValue.getDefaultInstance(), "Different type to DataSetValue");
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#getBooleanValue()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#getBooleanValue()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue getBooleanValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.getBooleanValue()"})
  void testPayload_DataSet_DataSetValueGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(DataSetValue.getDefaultInstance().getBooleanValue());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.getDefaultInstanceForType()"})
  void testPayload_DataSet_DataSetValueGetDefaultInstanceForType() {
    // Arrange
    DataSetValue defaultInstance = DataSetValue.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#getDoubleValue()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#getDoubleValue()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue getDoubleValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double DataSet.DataSetValue.getDoubleValue()"})
  void testPayload_DataSet_DataSetValueGetDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(0.0d, DataSetValue.getDefaultInstance().getDoubleValue());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#getExtensionValue()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#getExtensionValue()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue getExtensionValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.getExtensionValue()"})
  void testPayload_DataSet_DataSetValueGetExtensionValue() {
    // Arrange and Act
    DataSetValueExtension actualExtensionValue = DataSetValue.getDefaultInstance().getExtensionValue();

    // Assert
    assertEquals("", actualExtensionValue.getInitializationErrorString());
    assertEquals(0, actualExtensionValue.getSerializedSize());
    assertFalse(actualExtensionValue.hasExtensions());
    assertTrue(actualExtensionValue.findInitializationErrors().isEmpty());
    assertTrue(actualExtensionValue.getAllFields().isEmpty());
    assertTrue(actualExtensionValue.isInitialized());
    assertSame(actualExtensionValue, actualExtensionValue.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#getFloatValue()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#getFloatValue()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue getFloatValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float DataSet.DataSetValue.getFloatValue()"})
  void testPayload_DataSet_DataSetValueGetFloatValue() {
    // Arrange, Act and Assert
    assertEquals(0.0f, DataSetValue.getDefaultInstance().getFloatValue());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#getIntValue()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#getIntValue()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue getIntValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataSet.DataSetValue.getIntValue()"})
  void testPayload_DataSet_DataSetValueGetIntValue() {
    // Arrange, Act and Assert
    assertEquals(0, DataSetValue.getDefaultInstance().getIntValue());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#getLongValue()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#getLongValue()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue getLongValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long DataSet.DataSetValue.getLongValue()"})
  void testPayload_DataSet_DataSetValueGetLongValue() {
    // Arrange, Act and Assert
    assertEquals(0L, DataSetValue.getDefaultInstance().getLongValue());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#getSerializedSize()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataSet.DataSetValue.getSerializedSize()"})
  void testPayload_DataSet_DataSetValueGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DataSetValue.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#getStringValue()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#getStringValue()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue getStringValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String DataSet.DataSetValue.getStringValue()"})
  void testPayload_DataSet_DataSetValueGetStringValue() {
    // Arrange, Act and Assert
    assertEquals("", DataSetValue.getDefaultInstance().getStringValue());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#getStringValueBytes()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#getStringValueBytes()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue getStringValueBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString DataSet.DataSetValue.getStringValueBytes()"})
  void testPayload_DataSet_DataSetValueGetStringValueBytes() {
    // Arrange
    DataSetValue defaultInstance = DataSetValue.getDefaultInstance();

    // Act
    ByteString actualStringValueBytes = defaultInstance.getStringValueBytes();

    // Assert
    ByteString byteString = actualStringValueBytes.EMPTY;
    Any extensions = defaultInstance.getExtensionValue().getExtensions();
    assertEquals(byteString, extensions.getTypeUrlBytes());
    assertEquals(byteString, actualStringValueBytes);
    assertSame(byteString, extensions.getValue());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#getValueCase()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#getValueCase()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue getValueCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.getValueCase()"})
  void testPayload_DataSet_DataSetValueGetValueCase() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, DataSetValue.getDefaultInstance().getValueCase());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#hasBooleanValue()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#hasBooleanValue()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue hasBooleanValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.hasBooleanValue()"})
  void testPayload_DataSet_DataSetValueHasBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(DataSetValue.getDefaultInstance().hasBooleanValue());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#hasDoubleValue()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#hasDoubleValue()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue hasDoubleValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.hasDoubleValue()"})
  void testPayload_DataSet_DataSetValueHasDoubleValue() {
    // Arrange, Act and Assert
    assertFalse(DataSetValue.getDefaultInstance().hasDoubleValue());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#hasExtensionValue()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#hasExtensionValue()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue hasExtensionValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.hasExtensionValue()"})
  void testPayload_DataSet_DataSetValueHasExtensionValue() {
    // Arrange, Act and Assert
    assertFalse(DataSetValue.getDefaultInstance().hasExtensionValue());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#hasFloatValue()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#hasFloatValue()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue hasFloatValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.hasFloatValue()"})
  void testPayload_DataSet_DataSetValueHasFloatValue() {
    // Arrange, Act and Assert
    assertFalse(DataSetValue.getDefaultInstance().hasFloatValue());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#hasIntValue()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#hasIntValue()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue hasIntValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.hasIntValue()"})
  void testPayload_DataSet_DataSetValueHasIntValue() {
    // Arrange, Act and Assert
    assertFalse(DataSetValue.getDefaultInstance().hasIntValue());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#hasLongValue()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#hasLongValue()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue hasLongValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.hasLongValue()"})
  void testPayload_DataSet_DataSetValueHasLongValue() {
    // Arrange, Act and Assert
    assertFalse(DataSetValue.getDefaultInstance().hasLongValue());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#hasStringValue()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#hasStringValue()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue hasStringValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.hasStringValue()"})
  void testPayload_DataSet_DataSetValueHasStringValue() {
    // Arrange, Act and Assert
    assertFalse(DataSetValue.getDefaultInstance().hasStringValue());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#isInitialized()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.isInitialized()"})
  void testPayload_DataSet_DataSetValueIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DataSetValue.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_DataSetValueParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DataSetValue actualParseDelimitedFromResult = DataSetValue.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getStringValue());
    assertEquals(0, actualParseDelimitedFromResult.getIntValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseDelimitedFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseDelimitedFromResult.getFloatValue());
    assertEquals(0L, actualParseDelimitedFromResult.getLongValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, actualParseDelimitedFromResult.getValueCase());
    assertFalse(actualParseDelimitedFromResult.getBooleanValue());
    assertFalse(actualParseDelimitedFromResult.hasBooleanValue());
    assertFalse(actualParseDelimitedFromResult.hasDoubleValue());
    assertFalse(actualParseDelimitedFromResult.hasExtensionValue());
    assertFalse(actualParseDelimitedFromResult.hasFloatValue());
    assertFalse(actualParseDelimitedFromResult.hasIntValue());
    assertFalse(actualParseDelimitedFromResult.hasLongValue());
    assertFalse(actualParseDelimitedFromResult.hasStringValue());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_DataSetValueParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataSetValue.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_DataSetValueParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DataSetValue.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue DataSet.DataSetValue.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValueParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DataSetValue actualParseDelimitedFromResult = DataSetValue.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getStringValue());
    assertEquals(0, actualParseDelimitedFromResult.getIntValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseDelimitedFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseDelimitedFromResult.getFloatValue());
    assertEquals(0L, actualParseDelimitedFromResult.getLongValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, actualParseDelimitedFromResult.getValueCase());
    assertFalse(actualParseDelimitedFromResult.getBooleanValue());
    assertFalse(actualParseDelimitedFromResult.hasBooleanValue());
    assertFalse(actualParseDelimitedFromResult.hasDoubleValue());
    assertFalse(actualParseDelimitedFromResult.hasExtensionValue());
    assertFalse(actualParseDelimitedFromResult.hasFloatValue());
    assertFalse(actualParseDelimitedFromResult.hasIntValue());
    assertFalse(actualParseDelimitedFromResult.hasLongValue());
    assertFalse(actualParseDelimitedFromResult.hasStringValue());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue DataSet.DataSetValue.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValueParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataSetValue.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue DataSet.DataSetValue.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValueParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> DataSetValue.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue DataSet.DataSetValue.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValueParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataSetValue.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue DataSet.DataSetValue.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValueParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> DataSetValue.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_DataSetValueParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataSetValue.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_DataSetValueParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DataSetValue.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(byte[])"})
  void testPayload_DataSet_DataSetValueParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    DataSetValue actualParseFromResult = DataSetValue.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(ByteBuffer)"})
  void testPayload_DataSet_DataSetValueParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    DataSetValue actualParseFromResult = DataSetValue.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValueParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    DataSetValue actualParseFromResult = DataSetValue.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValueParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    DataSetValue actualParseFromResult = DataSetValue.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(ByteString)"})
  void testPayload_DataSet_DataSetValueParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    DataSetValue actualParseFromResult = DataSetValue.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedStringValueBytes = data.EMPTY;
    assertEquals(expectedStringValueBytes, actualParseFromResult.getStringValueBytes());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValueParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    DataSetValue actualParseFromResult = DataSetValue.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedStringValueBytes = data.EMPTY;
    assertEquals(expectedStringValueBytes, actualParseFromResult.getStringValueBytes());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(CodedInputStream)"})
  void testPayload_DataSet_DataSetValueParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    DataSetValue actualParseFromResult = DataSetValue.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValueParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    DataSetValue actualParseFromResult = DataSetValue.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(InputStream)"})
  void testPayload_DataSet_DataSetValueParseFromWithInputStream() throws IOException {
    // Arrange and Act
    DataSetValue actualParseFromResult = DataSetValue.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    DataSetValueExtension extensionValue = actualParseFromResult.getExtensionValue();
    assertSame(unknownFields, extensionValue.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensionValue, actualParseFromResult.getExtensionValueOrBuilder());
    assertSame(extensionValue, extensionValue.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(InputStream)"})
  void testPayload_DataSet_DataSetValueParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataSetValue.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValueParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    DataSetValue actualParseFromResult = DataSetValue.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValueParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataSetValue.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValueParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataSetValue.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(InputStream)"})
  void testPayload_DataSet_DataSetValueParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataSetValue.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet_DataSetValue {@link DataSet.DataSetValue#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue DataSet.DataSetValue.parseFrom(InputStream)"})
  void testPayload_DataSet_DataSetValueParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    DataSetValue actualParseFromResult = DataSetValue.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    DataSetValueExtension extensionValue = actualParseFromResult.getExtensionValue();
    assertSame(unknownFields, extensionValue.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensionValue, actualParseFromResult.getExtensionValueOrBuilder());
    assertSame(extensionValue, extensionValue.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#equals(Object)}, and {@link DataSet.DataSetValue.DataSetValueExtension#hashCode()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataSet.DataSetValue.DataSetValueExtension#equals(Object)}
   *   <li>{@link DataSet.DataSetValue.DataSetValueExtension#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension equals(Object), and hashCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.DataSetValueExtension.equals(Object)",
      "int DataSet.DataSetValue.DataSetValueExtension.hashCode()"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionEqualsAndHashCode() {
    // Arrange
    DataSetValueExtension defaultInstance = DataSetValueExtension.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#equals(Object)}, and {@link DataSet.DataSetValue.DataSetValueExtension#hashCode()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataSet.DataSetValue.DataSetValueExtension#equals(Object)}
   *   <li>{@link DataSet.DataSetValue.DataSetValueExtension#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension equals(Object), and hashCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.DataSetValueExtension.equals(Object)",
      "int DataSet.DataSetValue.DataSetValueExtension.hashCode()"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionEqualsAndHashCode2() {
    // Arrange
    DataSetValueExtension defaultInstance = DataSetValueExtension.getDefaultInstance();
    DataSetValueExtension defaultInstance2 = DataSetValueExtension.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.DataSetValueExtension.equals(Object)",
      "int DataSet.DataSetValue.DataSetValueExtension.hashCode()"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DataSetValueExtension.getDefaultInstance(), null);
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.DataSetValueExtension.equals(Object)",
      "int DataSet.DataSetValue.DataSetValueExtension.hashCode()"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionEquals_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(DataSetValueExtension.getDefaultInstance(), "Different type to DataSetValueExtension");
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.DataSetValueExtension.equals(Object)",
      "int DataSet.DataSetValue.DataSetValueExtension.hashCode()"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionEquals_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(DataSetValueExtension.getDefaultInstance(), 1);
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.getDefaultInstanceForType()"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionGetDefaultInstanceForType() {
    // Arrange
    DataSetValueExtension defaultInstance = DataSetValueExtension.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#getExtensions()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#getExtensions()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension getExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Any DataSet.DataSetValue.DataSetValueExtension.getExtensions()"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionGetExtensions() {
    // Arrange and Act
    Any actualExtensions = DataSetValueExtension.getDefaultInstance().getExtensions();

    // Assert
    assertEquals("", actualExtensions.getInitializationErrorString());
    assertEquals("", actualExtensions.getTypeUrl());
    assertEquals(0, actualExtensions.getSerializedSize());
    assertTrue(actualExtensions.isInitialized());
    assertTrue(actualExtensions.findInitializationErrors().isEmpty());
    assertTrue(actualExtensions.getAllFields().isEmpty());
    assertSame(actualExtensions, actualExtensions.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#getSerializedSize()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataSet.DataSetValue.DataSetValueExtension.getSerializedSize()"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DataSetValueExtension.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#hasExtensions()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#hasExtensions()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension hasExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.DataSetValueExtension.hasExtensions()"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(DataSetValueExtension.getDefaultInstance().hasExtensions());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#isInitialized()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.DataSetValue.DataSetValueExtension.isInitialized()"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DataSetValueExtension.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DataSetValueExtension actualParseDelimitedFromResult = DataSetValueExtension.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    DataSetValueExtension defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, defaultInstanceForType.getExtensions());
    assertSame(extensions, defaultInstanceForType.getExtensionsOrBuilder());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DataSetValueExtension actualParseDelimitedFromResult = DataSetValueExtension.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataSetValueExtension.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFromWithInput4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DataSetValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFromWithInput5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataSetValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFromWithInputExtensionRegistry()
      throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DataSetValueExtension actualParseDelimitedFromResult = DataSetValueExtension.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    DataSetValueExtension defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, defaultInstanceForType.getExtensions());
    assertSame(extensions, defaultInstanceForType.getExtensionsOrBuilder());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFromWithInputExtensionRegistry2()
      throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DataSetValueExtension actualParseDelimitedFromResult = DataSetValueExtension.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFromWithInputExtensionRegistry3()
      throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DataSetValueExtension.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFromWithInputExtensionRegistry4()
      throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> DataSetValueExtension.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseDelimitedFromWithInputExtensionRegistry5()
      throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataSetValueExtension.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(byte[])"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    DataSetValueExtension actualParseFromResult = DataSetValueExtension.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(ByteBuffer)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithByteBuffer()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    DataSetValueExtension actualParseFromResult = DataSetValueExtension.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    DataSetValueExtension actualParseFromResult = DataSetValueExtension.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    DataSetValueExtension actualParseFromResult = DataSetValueExtension.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(ByteString)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    DataSetValueExtension actualParseFromResult = DataSetValueExtension.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithByteStringExtensionRegistryLite()
      throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    DataSetValueExtension actualParseFromResult = DataSetValueExtension.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(CodedInputStream)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    DataSetValueExtension actualParseFromResult = DataSetValueExtension.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithCodedInputStreamExtensionRegistryLite()
      throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    DataSetValueExtension actualParseFromResult = DataSetValueExtension.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(InputStream)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithInputStream() throws IOException {
    // Arrange and Act
    DataSetValueExtension actualParseFromResult = DataSetValueExtension
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(InputStream)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DataSetValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(InputStream)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithInputStream3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DataSetValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(InputStream)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithInputStream4() throws IOException {
    // Arrange and Act
    DataSetValueExtension actualParseFromResult = DataSetValueExtension.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithInputStreamExtensionRegistryLite()
      throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    DataSetValueExtension actualParseFromResult = DataSetValueExtension.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithInputStreamExtensionRegistryLite2()
      throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> DataSetValueExtension.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet_DataSetValue_DataSetValueExtension {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.DataSetValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_DataSetValueExtension parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DataSet.DataSetValue.DataSetValueExtension DataSet.DataSetValue.DataSetValueExtension.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_DataSetValue_DataSetValueExtensionParseFromWithInputStreamExtensionRegistryLite3()
      throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DataSetValueExtension.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code BOOLEAN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); then return 'BOOLEAN_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_thenReturnBooleanValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.BOOLEAN_VALUE, DataSetValue.ValueCase.forNumber(5));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code DOUBLE_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); then return 'DOUBLE_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.DOUBLE_VALUE, DataSetValue.ValueCase.forNumber(4));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code EXTENSION_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); then return 'EXTENSION_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_thenReturnExtensionValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.EXTENSION_VALUE, DataSetValue.ValueCase.forNumber(7));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code FLOAT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); then return 'FLOAT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.FLOAT_VALUE, DataSetValue.ValueCase.forNumber(3));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code STRING_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); then return 'STRING_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.STRING_VALUE, DataSetValue.ValueCase.forNumber(6));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code VALUE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); then return 'VALUE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, DataSetValue.ValueCase.forNumber(0));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DataSetValue.ValueCase.forNumber(42));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code INT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); when one; then return 'INT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_whenOne_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.INT_VALUE, DataSetValue.ValueCase.forNumber(1));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code LONG_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase forNumber(int); when two; then return 'LONG_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.forNumber(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseForNumber_whenTwo_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.LONG_VALUE, DataSetValue.ValueCase.forNumber(2));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#getNumber()}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#getNumber()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataSet.DataSetValue.ValueCase.getNumber()"})
  void testPayload_DataSet_DataSetValue_ValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(1, DataSetValue.ValueCase.valueOf("INT_VALUE").getNumber());
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)} with {@code value}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.BOOLEAN_VALUE, DataSetValue.ValueCase.valueOf(5));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)} with {@code value}.
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue2() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.EXTENSION_VALUE, DataSetValue.ValueCase.valueOf(7));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code DOUBLE_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'; then return 'DOUBLE_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.DOUBLE_VALUE, DataSetValue.ValueCase.valueOf(4));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code FLOAT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'; then return 'FLOAT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.FLOAT_VALUE, DataSetValue.ValueCase.valueOf(3));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code INT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'; then return 'INT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.INT_VALUE, DataSetValue.ValueCase.valueOf(1));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code LONG_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'; then return 'LONG_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.LONG_VALUE, DataSetValue.ValueCase.valueOf(2));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DataSetValue.ValueCase.valueOf(42));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code STRING_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'; then return 'STRING_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.STRING_VALUE, DataSetValue.ValueCase.valueOf(6));
  }

  /**
   * Test Payload_DataSet_DataSetValue_ValueCase {@link DataSet.DataSetValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code VALUE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.DataSetValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_DataSetValue_ValueCase valueOf(int) with 'value'; then return 'VALUE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.DataSetValue.ValueCase DataSet.DataSetValue.ValueCase.valueOf(int)"})
  void testPayload_DataSet_DataSetValue_ValueCaseValueOfWithValue_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(DataSetValue.ValueCase.VALUE_NOT_SET, DataSetValue.ValueCase.valueOf(0));
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#equals(Object)}, and {@link DataSet.Row#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataSet.Row#equals(Object)}
   *   <li>{@link DataSet.Row#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.Row.equals(Object)", "int DataSet.Row.hashCode()"})
  void testPayload_DataSet_RowEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Row defaultInstance = Row.getDefaultInstance();
    Row defaultInstance2 = Row.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#equals(Object)}, and {@link DataSet.Row#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DataSet.Row#equals(Object)}
   *   <li>{@link DataSet.Row#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.Row.equals(Object)", "int DataSet.Row.hashCode()"})
  void testPayload_DataSet_RowEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Row defaultInstance = Row.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.Row#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.Row.equals(Object)", "int DataSet.Row.hashCode()"})
  void testPayload_DataSet_RowEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Row.getDefaultInstance(), 1);
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.Row#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.Row.equals(Object)", "int DataSet.Row.hashCode()"})
  void testPayload_DataSet_RowEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Row.getDefaultInstance(), null);
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.Row#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.Row.equals(Object)", "int DataSet.Row.hashCode()"})
  void testPayload_DataSet_RowEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Row.getDefaultInstance(), "Different type to Row");
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link DataSet.Row#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.getDefaultInstanceForType()"})
  void testPayload_DataSet_RowGetDefaultInstanceForType() {
    // Arrange
    Row defaultInstance = Row.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#getElementsCount()}.
   * <p>
   * Method under test: {@link DataSet.Row#getElementsCount()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row getElementsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataSet.Row.getElementsCount()"})
  void testPayload_DataSet_RowGetElementsCount() {
    // Arrange, Act and Assert
    assertEquals(0, Row.getDefaultInstance().getElementsCount());
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#getExtensions()}.
   * <p>
   * Method under test: {@link DataSet.Row#getExtensions()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row getExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Any DataSet.Row.getExtensions()"})
  void testPayload_DataSet_RowGetExtensions() {
    // Arrange and Act
    Any actualExtensions = Row.getDefaultInstance().getExtensions();

    // Assert
    assertEquals("", actualExtensions.getInitializationErrorString());
    assertEquals("", actualExtensions.getTypeUrl());
    assertEquals(0, actualExtensions.getSerializedSize());
    assertTrue(actualExtensions.isInitialized());
    assertTrue(actualExtensions.findInitializationErrors().isEmpty());
    assertTrue(actualExtensions.getAllFields().isEmpty());
    assertSame(actualExtensions, actualExtensions.getDefaultInstanceForType());
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#getSerializedSize()}.
   * <p>
   * Method under test: {@link DataSet.Row#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataSet.Row.getSerializedSize()"})
  void testPayload_DataSet_RowGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Row.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#hasExtensions()}.
   * <p>
   * Method under test: {@link DataSet.Row#hasExtensions()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row hasExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.Row.hasExtensions()"})
  void testPayload_DataSet_RowHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(Row.getDefaultInstance().hasExtensions());
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#isInitialized()}.
   * <p>
   * Method under test: {@link DataSet.Row#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataSet.Row.isInitialized()"})
  void testPayload_DataSet_RowIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Row.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DataSet.Row#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_RowParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Row actualParseDelimitedFromResult = Row.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    Row defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, defaultInstanceForType.getExtensions());
    assertSame(extensions, defaultInstanceForType.getExtensionsOrBuilder());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DataSet.Row#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_RowParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Row actualParseDelimitedFromResult = Row.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DataSet.Row#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_RowParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Row.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.Row#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_RowParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Row actualParseDelimitedFromResult = Row.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    Row defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, defaultInstanceForType.getExtensions());
    assertSame(extensions, defaultInstanceForType.getExtensionsOrBuilder());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.Row#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_RowParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Row actualParseDelimitedFromResult = Row.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.Row#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_RowParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Row.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.Row#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_RowParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Row.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link DataSet.Row#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_RowParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Row.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.Row#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_RowParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Row.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.Row#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseDelimitedFrom(InputStream)"})
  void testPayload_DataSet_RowParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Row.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link DataSet.Row#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseFrom(byte[])"})
  void testPayload_DataSet_RowParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    Row actualParseFromResult = Row.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getElementsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<DataSetValue> elementsList = actualParseFromResult.getElementsList();
    assertTrue(elementsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(elementsList, actualParseFromResult.getElementsOrBuilderList());
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link DataSet.Row#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseFrom(ByteBuffer)"})
  void testPayload_DataSet_RowParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    Row actualParseFromResult = Row.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getElementsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<DataSetValue> elementsList = actualParseFromResult.getElementsList();
    assertTrue(elementsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(elementsList, actualParseFromResult.getElementsOrBuilderList());
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.Row#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayload_DataSet_RowParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Row actualParseFromResult = Row.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getElementsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<DataSetValue> elementsList = actualParseFromResult.getElementsList();
    assertTrue(elementsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(elementsList, actualParseFromResult.getElementsOrBuilderList());
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.Row#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayload_DataSet_RowParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    Row actualParseFromResult = Row.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getElementsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<DataSetValue> elementsList = actualParseFromResult.getElementsList();
    assertTrue(elementsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(elementsList, actualParseFromResult.getElementsOrBuilderList());
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link DataSet.Row#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseFrom(InputStream)"})
  void testPayload_DataSet_RowParseFromWithInputStream() throws IOException {
    // Arrange and Act
    Row actualParseFromResult = Row.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link DataSet.Row#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseFrom(InputStream)"})
  void testPayload_DataSet_RowParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Row.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.Row#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_RowParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Row actualParseFromResult = Row.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getElementsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<DataSetValue> elementsList = actualParseFromResult.getElementsList();
    assertTrue(elementsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(elementsList, actualParseFromResult.getElementsOrBuilderList());
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.Row#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_RowParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Row.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link DataSet.Row#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_DataSet_RowParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Row.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.Row#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseFrom(InputStream)"})
  void testPayload_DataSet_RowParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Row.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_DataSet_Row {@link DataSet.Row#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet.Row#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_DataSet_Row parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet.Row DataSet.Row.parseFrom(InputStream)"})
  void testPayload_DataSet_RowParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    Row actualParseFromResult = Row.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_MetaData {@link MetaData#equals(Object)}, and {@link MetaData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MetaData#equals(Object)}
   *   <li>{@link MetaData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_MetaData equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.equals(Object)", "int MetaData.hashCode()"})
  void testPayload_MetaDataEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MetaData defaultInstance = MetaData.getDefaultInstance();
    MetaData defaultInstance2 = MetaData.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload_MetaData {@link MetaData#equals(Object)}, and {@link MetaData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MetaData#equals(Object)}
   *   <li>{@link MetaData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_MetaData equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.equals(Object)", "int MetaData.hashCode()"})
  void testPayload_MetaDataEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MetaData defaultInstance = MetaData.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload_MetaData {@link MetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_MetaData equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.equals(Object)", "int MetaData.hashCode()"})
  void testPayload_MetaDataEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetaData.getDefaultInstance(), 1);
  }

  /**
   * Test Payload_MetaData {@link MetaData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_MetaData equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.equals(Object)", "int MetaData.hashCode()"})
  void testPayload_MetaDataEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetaData.getDefaultInstance(), null);
  }

  /**
   * Test Payload_MetaData {@link MetaData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_MetaData equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.equals(Object)", "int MetaData.hashCode()"})
  void testPayload_MetaDataEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetaData.getDefaultInstance(), "Different type to MetaData");
  }

  /**
   * Test Payload_MetaData {@link MetaData#getContentType()}.
   * <p>
   * Method under test: {@link MetaData#getContentType()}
   */
  @Test
  @DisplayName("Test Payload_MetaData getContentType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MetaData.getContentType()"})
  void testPayload_MetaDataGetContentType() {
    // Arrange, Act and Assert
    assertEquals("", MetaData.getDefaultInstance().getContentType());
  }

  /**
   * Test Payload_MetaData {@link MetaData#getContentTypeBytes()}.
   * <p>
   * Method under test: {@link MetaData#getContentTypeBytes()}
   */
  @Test
  @DisplayName("Test Payload_MetaData getContentTypeBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString MetaData.getContentTypeBytes()"})
  void testPayload_MetaDataGetContentTypeBytes() {
    // Arrange
    MetaData defaultInstance = MetaData.getDefaultInstance();

    // Act
    ByteString actualContentTypeBytes = defaultInstance.getContentTypeBytes();

    // Assert
    ByteString byteString = actualContentTypeBytes.EMPTY;
    Any extensions = defaultInstance.getExtensions();
    assertEquals(byteString, extensions.getTypeUrlBytes());
    assertEquals(byteString, actualContentTypeBytes);
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(byteString, defaultInstance.getFileNameBytes());
    assertEquals(byteString, defaultInstance.getFileTypeBytes());
    assertEquals(byteString, defaultInstance.getMd5Bytes());
    assertSame(byteString, extensions.getValue());
  }

  /**
   * Test Payload_MetaData {@link MetaData#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link MetaData#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload_MetaData getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.getDefaultInstanceForType()"})
  void testPayload_MetaDataGetDefaultInstanceForType() {
    // Arrange
    MetaData defaultInstance = MetaData.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload_MetaData {@link MetaData#getDescription()}.
   * <p>
   * Method under test: {@link MetaData#getDescription()}
   */
  @Test
  @DisplayName("Test Payload_MetaData getDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MetaData.getDescription()"})
  void testPayload_MetaDataGetDescription() {
    // Arrange, Act and Assert
    assertEquals("", MetaData.getDefaultInstance().getDescription());
  }

  /**
   * Test Payload_MetaData {@link MetaData#getDescriptionBytes()}.
   * <p>
   * Method under test: {@link MetaData#getDescriptionBytes()}
   */
  @Test
  @DisplayName("Test Payload_MetaData getDescriptionBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString MetaData.getDescriptionBytes()"})
  void testPayload_MetaDataGetDescriptionBytes() {
    // Arrange
    MetaData defaultInstance = MetaData.getDefaultInstance();

    // Act
    ByteString actualDescriptionBytes = defaultInstance.getDescriptionBytes();

    // Assert
    ByteString byteString = actualDescriptionBytes.EMPTY;
    Any extensions = defaultInstance.getExtensions();
    assertEquals(byteString, extensions.getTypeUrlBytes());
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, actualDescriptionBytes);
    assertEquals(byteString, defaultInstance.getFileNameBytes());
    assertEquals(byteString, defaultInstance.getFileTypeBytes());
    assertEquals(byteString, defaultInstance.getMd5Bytes());
    assertSame(byteString, extensions.getValue());
  }

  /**
   * Test Payload_MetaData {@link MetaData#getExtensions()}.
   * <p>
   * Method under test: {@link MetaData#getExtensions()}
   */
  @Test
  @DisplayName("Test Payload_MetaData getExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Any MetaData.getExtensions()"})
  void testPayload_MetaDataGetExtensions() {
    // Arrange and Act
    Any actualExtensions = MetaData.getDefaultInstance().getExtensions();

    // Assert
    assertEquals("", actualExtensions.getInitializationErrorString());
    assertEquals("", actualExtensions.getTypeUrl());
    assertEquals(0, actualExtensions.getSerializedSize());
    assertTrue(actualExtensions.isInitialized());
    assertTrue(actualExtensions.findInitializationErrors().isEmpty());
    assertTrue(actualExtensions.getAllFields().isEmpty());
    assertSame(actualExtensions, actualExtensions.getDefaultInstanceForType());
  }

  /**
   * Test Payload_MetaData {@link MetaData#getFileName()}.
   * <p>
   * Method under test: {@link MetaData#getFileName()}
   */
  @Test
  @DisplayName("Test Payload_MetaData getFileName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MetaData.getFileName()"})
  void testPayload_MetaDataGetFileName() {
    // Arrange, Act and Assert
    assertEquals("", MetaData.getDefaultInstance().getFileName());
  }

  /**
   * Test Payload_MetaData {@link MetaData#getFileNameBytes()}.
   * <p>
   * Method under test: {@link MetaData#getFileNameBytes()}
   */
  @Test
  @DisplayName("Test Payload_MetaData getFileNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString MetaData.getFileNameBytes()"})
  void testPayload_MetaDataGetFileNameBytes() {
    // Arrange
    MetaData defaultInstance = MetaData.getDefaultInstance();

    // Act
    ByteString actualFileNameBytes = defaultInstance.getFileNameBytes();

    // Assert
    ByteString byteString = actualFileNameBytes.EMPTY;
    Any extensions = defaultInstance.getExtensions();
    assertEquals(byteString, extensions.getTypeUrlBytes());
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(byteString, actualFileNameBytes);
    assertEquals(byteString, defaultInstance.getFileTypeBytes());
    assertEquals(byteString, defaultInstance.getMd5Bytes());
    assertSame(byteString, extensions.getValue());
  }

  /**
   * Test Payload_MetaData {@link MetaData#getFileType()}.
   * <p>
   * Method under test: {@link MetaData#getFileType()}
   */
  @Test
  @DisplayName("Test Payload_MetaData getFileType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MetaData.getFileType()"})
  void testPayload_MetaDataGetFileType() {
    // Arrange, Act and Assert
    assertEquals("", MetaData.getDefaultInstance().getFileType());
  }

  /**
   * Test Payload_MetaData {@link MetaData#getFileTypeBytes()}.
   * <p>
   * Method under test: {@link MetaData#getFileTypeBytes()}
   */
  @Test
  @DisplayName("Test Payload_MetaData getFileTypeBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString MetaData.getFileTypeBytes()"})
  void testPayload_MetaDataGetFileTypeBytes() {
    // Arrange
    MetaData defaultInstance = MetaData.getDefaultInstance();

    // Act
    ByteString actualFileTypeBytes = defaultInstance.getFileTypeBytes();

    // Assert
    ByteString byteString = actualFileTypeBytes.EMPTY;
    Any extensions = defaultInstance.getExtensions();
    assertEquals(byteString, extensions.getTypeUrlBytes());
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(byteString, defaultInstance.getFileNameBytes());
    assertEquals(byteString, actualFileTypeBytes);
    assertEquals(byteString, defaultInstance.getMd5Bytes());
    assertSame(byteString, extensions.getValue());
  }

  /**
   * Test Payload_MetaData {@link MetaData#getMd5()}.
   * <p>
   * Method under test: {@link MetaData#getMd5()}
   */
  @Test
  @DisplayName("Test Payload_MetaData getMd5()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MetaData.getMd5()"})
  void testPayload_MetaDataGetMd5() {
    // Arrange, Act and Assert
    assertEquals("", MetaData.getDefaultInstance().getMd5());
  }

  /**
   * Test Payload_MetaData {@link MetaData#getMd5Bytes()}.
   * <p>
   * Method under test: {@link MetaData#getMd5Bytes()}
   */
  @Test
  @DisplayName("Test Payload_MetaData getMd5Bytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString MetaData.getMd5Bytes()"})
  void testPayload_MetaDataGetMd5Bytes() {
    // Arrange
    MetaData defaultInstance = MetaData.getDefaultInstance();

    // Act
    ByteString actualMd5Bytes = defaultInstance.getMd5Bytes();

    // Assert
    ByteString byteString = actualMd5Bytes.EMPTY;
    Any extensions = defaultInstance.getExtensions();
    assertEquals(byteString, extensions.getTypeUrlBytes());
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(byteString, defaultInstance.getFileNameBytes());
    assertEquals(byteString, defaultInstance.getFileTypeBytes());
    assertEquals(byteString, actualMd5Bytes);
    assertSame(byteString, extensions.getValue());
  }

  /**
   * Test Payload_MetaData {@link MetaData#getSerializedSize()}.
   * <p>
   * Method under test: {@link MetaData#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload_MetaData getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MetaData.getSerializedSize()"})
  void testPayload_MetaDataGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MetaData.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload_MetaData {@link MetaData#hasContentType()}.
   * <p>
   * Method under test: {@link MetaData#hasContentType()}
   */
  @Test
  @DisplayName("Test Payload_MetaData hasContentType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.hasContentType()"})
  void testPayload_MetaDataHasContentType() {
    // Arrange, Act and Assert
    assertFalse(MetaData.getDefaultInstance().hasContentType());
  }

  /**
   * Test Payload_MetaData {@link MetaData#hasDescription()}.
   * <p>
   * Method under test: {@link MetaData#hasDescription()}
   */
  @Test
  @DisplayName("Test Payload_MetaData hasDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.hasDescription()"})
  void testPayload_MetaDataHasDescription() {
    // Arrange, Act and Assert
    assertFalse(MetaData.getDefaultInstance().hasDescription());
  }

  /**
   * Test Payload_MetaData {@link MetaData#hasExtensions()}.
   * <p>
   * Method under test: {@link MetaData#hasExtensions()}
   */
  @Test
  @DisplayName("Test Payload_MetaData hasExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.hasExtensions()"})
  void testPayload_MetaDataHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(MetaData.getDefaultInstance().hasExtensions());
  }

  /**
   * Test Payload_MetaData {@link MetaData#hasFileName()}.
   * <p>
   * Method under test: {@link MetaData#hasFileName()}
   */
  @Test
  @DisplayName("Test Payload_MetaData hasFileName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.hasFileName()"})
  void testPayload_MetaDataHasFileName() {
    // Arrange, Act and Assert
    assertFalse(MetaData.getDefaultInstance().hasFileName());
  }

  /**
   * Test Payload_MetaData {@link MetaData#hasFileType()}.
   * <p>
   * Method under test: {@link MetaData#hasFileType()}
   */
  @Test
  @DisplayName("Test Payload_MetaData hasFileType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.hasFileType()"})
  void testPayload_MetaDataHasFileType() {
    // Arrange, Act and Assert
    assertFalse(MetaData.getDefaultInstance().hasFileType());
  }

  /**
   * Test Payload_MetaData {@link MetaData#hasIsMultiPart()}.
   * <p>
   * Method under test: {@link MetaData#hasIsMultiPart()}
   */
  @Test
  @DisplayName("Test Payload_MetaData hasIsMultiPart()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.hasIsMultiPart()"})
  void testPayload_MetaDataHasIsMultiPart() {
    // Arrange, Act and Assert
    assertFalse(MetaData.getDefaultInstance().hasIsMultiPart());
  }

  /**
   * Test Payload_MetaData {@link MetaData#hasMd5()}.
   * <p>
   * Method under test: {@link MetaData#hasMd5()}
   */
  @Test
  @DisplayName("Test Payload_MetaData hasMd5()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.hasMd5()"})
  void testPayload_MetaDataHasMd5() {
    // Arrange, Act and Assert
    assertFalse(MetaData.getDefaultInstance().hasMd5());
  }

  /**
   * Test Payload_MetaData {@link MetaData#hasSeq()}.
   * <p>
   * Method under test: {@link MetaData#hasSeq()}
   */
  @Test
  @DisplayName("Test Payload_MetaData hasSeq()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.hasSeq()"})
  void testPayload_MetaDataHasSeq() {
    // Arrange, Act and Assert
    assertFalse(MetaData.getDefaultInstance().hasSeq());
  }

  /**
   * Test Payload_MetaData {@link MetaData#hasSize()}.
   * <p>
   * Method under test: {@link MetaData#hasSize()}
   */
  @Test
  @DisplayName("Test Payload_MetaData hasSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.hasSize()"})
  void testPayload_MetaDataHasSize() {
    // Arrange, Act and Assert
    assertFalse(MetaData.getDefaultInstance().hasSize());
  }

  /**
   * Test Payload_MetaData {@link MetaData#isInitialized()}.
   * <p>
   * Method under test: {@link MetaData#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload_MetaData isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetaData.isInitialized()"})
  void testPayload_MetaDataIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MetaData.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link MetaData#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseDelimitedFrom(InputStream)"})
  void testPayload_MetaDataParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetaData.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link MetaData#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseDelimitedFrom(InputStream)"})
  void testPayload_MetaDataParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MetaData.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetaDataParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, MetaData.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetaDataParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MetaData actualParseDelimitedFromResult = MetaData.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetaDataParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MetaData.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetaDataParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MetaData.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetaDataParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> MetaData.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetaData#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetaDataParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetaData.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetaData#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseDelimitedFrom(InputStream)"})
  void testPayload_MetaDataParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetaData.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetaData#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseDelimitedFrom(InputStream)"})
  void testPayload_MetaDataParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, MetaData.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetaData#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseDelimitedFrom(InputStream)"})
  void testPayload_MetaDataParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MetaData actualParseDelimitedFromResult = MetaData.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetaData#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseDelimitedFrom(InputStream)"})
  void testPayload_MetaDataParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MetaData.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link MetaData#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(byte[])"})
  void testPayload_MetaDataParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    MetaData actualParseFromResult = MetaData.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getContentType());
    assertEquals("", actualParseFromResult.getDescription());
    assertEquals("", actualParseFromResult.getFileName());
    assertEquals("", actualParseFromResult.getFileType());
    assertEquals("", actualParseFromResult.getMd5());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getSeq());
    assertEquals(0L, actualParseFromResult.getSize());
    assertFalse(actualParseFromResult.getIsMultiPart());
    assertFalse(actualParseFromResult.hasContentType());
    assertFalse(actualParseFromResult.hasDescription());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasFileName());
    assertFalse(actualParseFromResult.hasFileType());
    assertFalse(actualParseFromResult.hasIsMultiPart());
    assertFalse(actualParseFromResult.hasMd5());
    assertFalse(actualParseFromResult.hasSeq());
    assertFalse(actualParseFromResult.hasSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link MetaData#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(ByteBuffer)"})
  void testPayload_MetaDataParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    MetaData actualParseFromResult = MetaData.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getContentType());
    assertEquals("", actualParseFromResult.getDescription());
    assertEquals("", actualParseFromResult.getFileName());
    assertEquals("", actualParseFromResult.getFileType());
    assertEquals("", actualParseFromResult.getMd5());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getSeq());
    assertEquals(0L, actualParseFromResult.getSize());
    assertFalse(actualParseFromResult.getIsMultiPart());
    assertFalse(actualParseFromResult.hasContentType());
    assertFalse(actualParseFromResult.hasDescription());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasFileName());
    assertFalse(actualParseFromResult.hasFileType());
    assertFalse(actualParseFromResult.hasIsMultiPart());
    assertFalse(actualParseFromResult.hasMd5());
    assertFalse(actualParseFromResult.hasSeq());
    assertFalse(actualParseFromResult.hasSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetaData#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayload_MetaDataParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    MetaData actualParseFromResult = MetaData.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getContentType());
    assertEquals("", actualParseFromResult.getDescription());
    assertEquals("", actualParseFromResult.getFileName());
    assertEquals("", actualParseFromResult.getFileType());
    assertEquals("", actualParseFromResult.getMd5());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getSeq());
    assertEquals(0L, actualParseFromResult.getSize());
    assertFalse(actualParseFromResult.getIsMultiPart());
    assertFalse(actualParseFromResult.hasContentType());
    assertFalse(actualParseFromResult.hasDescription());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasFileName());
    assertFalse(actualParseFromResult.hasFileType());
    assertFalse(actualParseFromResult.hasIsMultiPart());
    assertFalse(actualParseFromResult.hasMd5());
    assertFalse(actualParseFromResult.hasSeq());
    assertFalse(actualParseFromResult.hasSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetaData#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayload_MetaDataParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    MetaData actualParseFromResult = MetaData.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getContentType());
    assertEquals("", actualParseFromResult.getDescription());
    assertEquals("", actualParseFromResult.getFileName());
    assertEquals("", actualParseFromResult.getFileType());
    assertEquals("", actualParseFromResult.getMd5());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getSeq());
    assertEquals(0L, actualParseFromResult.getSize());
    assertFalse(actualParseFromResult.getIsMultiPart());
    assertFalse(actualParseFromResult.hasContentType());
    assertFalse(actualParseFromResult.hasDescription());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasFileName());
    assertFalse(actualParseFromResult.hasFileType());
    assertFalse(actualParseFromResult.hasIsMultiPart());
    assertFalse(actualParseFromResult.hasMd5());
    assertFalse(actualParseFromResult.hasSeq());
    assertFalse(actualParseFromResult.hasSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link MetaData#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(ByteString)"})
  void testPayload_MetaDataParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    MetaData actualParseFromResult = MetaData.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getContentType());
    assertEquals("", actualParseFromResult.getDescription());
    assertEquals("", actualParseFromResult.getFileName());
    assertEquals("", actualParseFromResult.getFileType());
    assertEquals("", actualParseFromResult.getMd5());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getSeq());
    assertEquals(0L, actualParseFromResult.getSize());
    assertFalse(actualParseFromResult.getIsMultiPart());
    assertFalse(actualParseFromResult.hasContentType());
    assertFalse(actualParseFromResult.hasDescription());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasFileName());
    assertFalse(actualParseFromResult.hasFileType());
    assertFalse(actualParseFromResult.hasIsMultiPart());
    assertFalse(actualParseFromResult.hasMd5());
    assertFalse(actualParseFromResult.hasSeq());
    assertFalse(actualParseFromResult.hasSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getContentTypeBytes());
    assertEquals(byteString, actualParseFromResult.getDescriptionBytes());
    assertEquals(byteString, actualParseFromResult.getFileNameBytes());
    assertEquals(byteString, actualParseFromResult.getFileTypeBytes());
    assertEquals(byteString, actualParseFromResult.getMd5Bytes());
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetaData#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testPayload_MetaDataParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    MetaData actualParseFromResult = MetaData.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getContentType());
    assertEquals("", actualParseFromResult.getDescription());
    assertEquals("", actualParseFromResult.getFileName());
    assertEquals("", actualParseFromResult.getFileType());
    assertEquals("", actualParseFromResult.getMd5());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getSeq());
    assertEquals(0L, actualParseFromResult.getSize());
    assertFalse(actualParseFromResult.getIsMultiPart());
    assertFalse(actualParseFromResult.hasContentType());
    assertFalse(actualParseFromResult.hasDescription());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasFileName());
    assertFalse(actualParseFromResult.hasFileType());
    assertFalse(actualParseFromResult.hasIsMultiPart());
    assertFalse(actualParseFromResult.hasMd5());
    assertFalse(actualParseFromResult.hasSeq());
    assertFalse(actualParseFromResult.hasSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getContentTypeBytes());
    assertEquals(byteString, actualParseFromResult.getDescriptionBytes());
    assertEquals(byteString, actualParseFromResult.getFileNameBytes());
    assertEquals(byteString, actualParseFromResult.getFileTypeBytes());
    assertEquals(byteString, actualParseFromResult.getMd5Bytes());
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link MetaData#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(CodedInputStream)"})
  void testPayload_MetaDataParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    MetaData actualParseFromResult = MetaData.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getContentType());
    assertEquals("", actualParseFromResult.getDescription());
    assertEquals("", actualParseFromResult.getFileName());
    assertEquals("", actualParseFromResult.getFileType());
    assertEquals("", actualParseFromResult.getMd5());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getSeq());
    assertEquals(0L, actualParseFromResult.getSize());
    assertFalse(actualParseFromResult.getIsMultiPart());
    assertFalse(actualParseFromResult.hasContentType());
    assertFalse(actualParseFromResult.hasDescription());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasFileName());
    assertFalse(actualParseFromResult.hasFileType());
    assertFalse(actualParseFromResult.hasIsMultiPart());
    assertFalse(actualParseFromResult.hasMd5());
    assertFalse(actualParseFromResult.hasSeq());
    assertFalse(actualParseFromResult.hasSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetaData#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testPayload_MetaDataParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    MetaData actualParseFromResult = MetaData.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getContentType());
    assertEquals("", actualParseFromResult.getDescription());
    assertEquals("", actualParseFromResult.getFileName());
    assertEquals("", actualParseFromResult.getFileType());
    assertEquals("", actualParseFromResult.getMd5());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getSeq());
    assertEquals(0L, actualParseFromResult.getSize());
    assertFalse(actualParseFromResult.getIsMultiPart());
    assertFalse(actualParseFromResult.hasContentType());
    assertFalse(actualParseFromResult.hasDescription());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasFileName());
    assertFalse(actualParseFromResult.hasFileType());
    assertFalse(actualParseFromResult.hasIsMultiPart());
    assertFalse(actualParseFromResult.hasMd5());
    assertFalse(actualParseFromResult.hasSeq());
    assertFalse(actualParseFromResult.hasSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link MetaData#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(InputStream)"})
  void testPayload_MetaDataParseFromWithInputStream() throws IOException {
    // Arrange and Act
    MetaData actualParseFromResult = MetaData.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link MetaData#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(InputStream)"})
  void testPayload_MetaDataParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetaData.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetaData#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetaDataParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    MetaData actualParseFromResult = MetaData.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getContentType());
    assertEquals("", actualParseFromResult.getDescription());
    assertEquals("", actualParseFromResult.getFileName());
    assertEquals("", actualParseFromResult.getFileType());
    assertEquals("", actualParseFromResult.getMd5());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getSeq());
    assertEquals(0L, actualParseFromResult.getSize());
    assertFalse(actualParseFromResult.getIsMultiPart());
    assertFalse(actualParseFromResult.hasContentType());
    assertFalse(actualParseFromResult.hasDescription());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasFileName());
    assertFalse(actualParseFromResult.hasFileType());
    assertFalse(actualParseFromResult.hasIsMultiPart());
    assertFalse(actualParseFromResult.hasMd5());
    assertFalse(actualParseFromResult.hasSeq());
    assertFalse(actualParseFromResult.hasSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetaData#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetaDataParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MetaData.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetaData#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetaDataParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MetaData.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetaData#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(InputStream)"})
  void testPayload_MetaDataParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MetaData.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_MetaData {@link MetaData#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetaData#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_MetaData parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData MetaData.parseFrom(InputStream)"})
  void testPayload_MetaDataParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    MetaData actualParseFromResult = MetaData.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_Metric {@link Metric#equals(Object)}, and {@link Metric#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Metric#equals(Object)}
   *   <li>{@link Metric#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_Metric equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.equals(Object)", "int Metric.hashCode()"})
  void testPayload_MetricEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Metric defaultInstance = Metric.getDefaultInstance();
    Metric defaultInstance2 = Metric.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload_Metric {@link Metric#equals(Object)}, and {@link Metric#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Metric#equals(Object)}
   *   <li>{@link Metric#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_Metric equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.equals(Object)", "int Metric.hashCode()"})
  void testPayload_MetricEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Metric defaultInstance = Metric.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload_Metric {@link Metric#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metric#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Metric equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.equals(Object)", "int Metric.hashCode()"})
  void testPayload_MetricEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Metric.getDefaultInstance(), 1);
  }

  /**
   * Test Payload_Metric {@link Metric#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metric#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Metric equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.equals(Object)", "int Metric.hashCode()"})
  void testPayload_MetricEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Metric.getDefaultInstance(), null);
  }

  /**
   * Test Payload_Metric {@link Metric#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metric#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Metric equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.equals(Object)", "int Metric.hashCode()"})
  void testPayload_MetricEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Metric.getDefaultInstance(), "Different type to Metric");
  }

  /**
   * Test Payload_Metric {@link Metric#getBooleanValue()}.
   * <p>
   * Method under test: {@link Metric#getBooleanValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric getBooleanValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.getBooleanValue()"})
  void testPayload_MetricGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().getBooleanValue());
  }

  /**
   * Test Payload_Metric {@link Metric#getBytesValue()}.
   * <p>
   * Method under test: {@link Metric#getBytesValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric getBytesValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString Metric.getBytesValue()"})
  void testPayload_MetricGetBytesValue() {
    // Arrange
    Metric defaultInstance = Metric.getDefaultInstance();

    // Act
    ByteString actualBytesValue = defaultInstance.getBytesValue();

    // Assert
    ByteString byteString = actualBytesValue.EMPTY;
    MetaData metadata = defaultInstance.getMetadata();
    assertEquals(byteString, metadata.getContentTypeBytes());
    assertEquals(byteString, metadata.getDescriptionBytes());
    assertEquals(byteString, metadata.getFileNameBytes());
    assertEquals(byteString, metadata.getFileTypeBytes());
    assertEquals(byteString, metadata.getMd5Bytes());
    assertEquals(byteString, defaultInstance.getNameBytes());
    assertEquals(byteString, defaultInstance.getStringValueBytes());
    Template templateValue = defaultInstance.getTemplateValue();
    assertEquals(byteString, templateValue.getTemplateRefBytes());
    assertEquals(byteString, templateValue.getVersionBytes());
    assertSame(byteString, actualBytesValue);
  }

  /**
   * Test Payload_Metric {@link Metric#getDatasetValue()}.
   * <p>
   * Method under test: {@link Metric#getDatasetValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric getDatasetValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DataSet Metric.getDatasetValue()"})
  void testPayload_MetricGetDatasetValue() {
    // Arrange and Act
    DataSet actualDatasetValue = Metric.getDefaultInstance().getDatasetValue();

    // Assert
    assertEquals("", actualDatasetValue.getInitializationErrorString());
    assertEquals(0, actualDatasetValue.getColumnsCount());
    assertEquals(0, actualDatasetValue.getRowsCount());
    assertEquals(0, actualDatasetValue.getSerializedSize());
    assertEquals(0, actualDatasetValue.getTypesCount());
    assertEquals(0L, actualDatasetValue.getNumOfColumns());
    assertFalse(actualDatasetValue.hasExtensions());
    assertFalse(actualDatasetValue.hasNumOfColumns());
    assertTrue(actualDatasetValue.findInitializationErrors().isEmpty());
    assertTrue(actualDatasetValue.getColumnsList().isEmpty());
    List<Row> rowsList = actualDatasetValue.getRowsList();
    assertTrue(rowsList.isEmpty());
    assertTrue(actualDatasetValue.getTypesList().isEmpty());
    assertTrue(actualDatasetValue.getAllFields().isEmpty());
    assertTrue(actualDatasetValue.isInitialized());
    assertSame(rowsList, actualDatasetValue.getRowsOrBuilderList());
    assertSame(actualDatasetValue, actualDatasetValue.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric {@link Metric#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link Metric#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload_Metric getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.getDefaultInstanceForType()"})
  void testPayload_MetricGetDefaultInstanceForType() {
    // Arrange
    Metric defaultInstance = Metric.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric {@link Metric#getDoubleValue()}.
   * <p>
   * Method under test: {@link Metric#getDoubleValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric getDoubleValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Metric.getDoubleValue()"})
  void testPayload_MetricGetDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(0.0d, Metric.getDefaultInstance().getDoubleValue());
  }

  /**
   * Test Payload_Metric {@link Metric#getExtensionValue()}.
   * <p>
   * Method under test: {@link Metric#getExtensionValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric getExtensionValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension Metric.getExtensionValue()"})
  void testPayload_MetricGetExtensionValue() {
    // Arrange and Act
    MetricValueExtension actualExtensionValue = Metric.getDefaultInstance().getExtensionValue();

    // Assert
    assertEquals("", actualExtensionValue.getInitializationErrorString());
    assertEquals(0, actualExtensionValue.getSerializedSize());
    assertFalse(actualExtensionValue.hasExtensions());
    assertTrue(actualExtensionValue.findInitializationErrors().isEmpty());
    assertTrue(actualExtensionValue.getAllFields().isEmpty());
    assertTrue(actualExtensionValue.isInitialized());
    assertSame(actualExtensionValue, actualExtensionValue.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric {@link Metric#getFloatValue()}.
   * <p>
   * Method under test: {@link Metric#getFloatValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric getFloatValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float Metric.getFloatValue()"})
  void testPayload_MetricGetFloatValue() {
    // Arrange, Act and Assert
    assertEquals(0.0f, Metric.getDefaultInstance().getFloatValue());
  }

  /**
   * Test Payload_Metric {@link Metric#getIntValue()}.
   * <p>
   * Method under test: {@link Metric#getIntValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric getIntValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Metric.getIntValue()"})
  void testPayload_MetricGetIntValue() {
    // Arrange, Act and Assert
    assertEquals(0, Metric.getDefaultInstance().getIntValue());
  }

  /**
   * Test Payload_Metric {@link Metric#getLongValue()}.
   * <p>
   * Method under test: {@link Metric#getLongValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric getLongValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Metric.getLongValue()"})
  void testPayload_MetricGetLongValue() {
    // Arrange, Act and Assert
    assertEquals(0L, Metric.getDefaultInstance().getLongValue());
  }

  /**
   * Test Payload_Metric {@link Metric#getMetadata()}.
   * <p>
   * Method under test: {@link Metric#getMetadata()}
   */
  @Test
  @DisplayName("Test Payload_Metric getMetadata()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetaData Metric.getMetadata()"})
  void testPayload_MetricGetMetadata() {
    // Arrange and Act
    MetaData actualMetadata = Metric.getDefaultInstance().getMetadata();

    // Assert
    assertEquals("", actualMetadata.getInitializationErrorString());
    assertEquals("", actualMetadata.getContentType());
    assertEquals("", actualMetadata.getDescription());
    assertEquals("", actualMetadata.getFileName());
    assertEquals("", actualMetadata.getFileType());
    assertEquals("", actualMetadata.getMd5());
    assertEquals(0, actualMetadata.getSerializedSize());
    assertEquals(0L, actualMetadata.getSeq());
    assertEquals(0L, actualMetadata.getSize());
    assertFalse(actualMetadata.getIsMultiPart());
    assertFalse(actualMetadata.hasContentType());
    assertFalse(actualMetadata.hasDescription());
    assertFalse(actualMetadata.hasExtensions());
    assertFalse(actualMetadata.hasFileName());
    assertFalse(actualMetadata.hasFileType());
    assertFalse(actualMetadata.hasIsMultiPart());
    assertFalse(actualMetadata.hasMd5());
    assertFalse(actualMetadata.hasSeq());
    assertFalse(actualMetadata.hasSize());
    assertTrue(actualMetadata.findInitializationErrors().isEmpty());
    assertTrue(actualMetadata.getAllFields().isEmpty());
    assertTrue(actualMetadata.isInitialized());
    assertSame(actualMetadata, actualMetadata.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric {@link Metric#getName()}.
   * <p>
   * Method under test: {@link Metric#getName()}
   */
  @Test
  @DisplayName("Test Payload_Metric getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String Metric.getName()"})
  void testPayload_MetricGetName() {
    // Arrange, Act and Assert
    assertEquals("", Metric.getDefaultInstance().getName());
  }

  /**
   * Test Payload_Metric {@link Metric#getNameBytes()}.
   * <p>
   * Method under test: {@link Metric#getNameBytes()}
   */
  @Test
  @DisplayName("Test Payload_Metric getNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString Metric.getNameBytes()"})
  void testPayload_MetricGetNameBytes() {
    // Arrange
    Metric defaultInstance = Metric.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    assertEquals(byteString, actualNameBytes);
    assertSame(byteString, defaultInstance.getBytesValue());
  }

  /**
   * Test Payload_Metric {@link Metric#getProperties()}.
   * <p>
   * Method under test: {@link Metric#getProperties()}
   */
  @Test
  @DisplayName("Test Payload_Metric getProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet Metric.getProperties()"})
  void testPayload_MetricGetProperties() {
    // Arrange and Act
    PropertySet actualProperties = Metric.getDefaultInstance().getProperties();

    // Assert
    assertEquals("", actualProperties.getInitializationErrorString());
    assertEquals(0, actualProperties.getKeysCount());
    assertEquals(0, actualProperties.getSerializedSize());
    assertEquals(0, actualProperties.getValuesCount());
    assertFalse(actualProperties.hasExtensions());
    assertTrue(actualProperties.findInitializationErrors().isEmpty());
    assertTrue(actualProperties.getKeysList().isEmpty());
    List<PropertyValue> valuesList = actualProperties.getValuesList();
    assertTrue(valuesList.isEmpty());
    assertTrue(actualProperties.getAllFields().isEmpty());
    assertTrue(actualProperties.isInitialized());
    assertSame(actualProperties, actualProperties.getDefaultInstanceForType());
    assertSame(valuesList, actualProperties.getValuesOrBuilderList());
  }

  /**
   * Test Payload_Metric {@link Metric#getSerializedSize()}.
   * <p>
   * Method under test: {@link Metric#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload_Metric getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Metric.getSerializedSize()"})
  void testPayload_MetricGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Metric.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload_Metric {@link Metric#getStringValue()}.
   * <p>
   * Method under test: {@link Metric#getStringValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric getStringValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String Metric.getStringValue()"})
  void testPayload_MetricGetStringValue() {
    // Arrange, Act and Assert
    assertEquals("", Metric.getDefaultInstance().getStringValue());
  }

  /**
   * Test Payload_Metric {@link Metric#getStringValueBytes()}.
   * <p>
   * Method under test: {@link Metric#getStringValueBytes()}
   */
  @Test
  @DisplayName("Test Payload_Metric getStringValueBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString Metric.getStringValueBytes()"})
  void testPayload_MetricGetStringValueBytes() {
    // Arrange
    Metric defaultInstance = Metric.getDefaultInstance();

    // Act
    ByteString actualStringValueBytes = defaultInstance.getStringValueBytes();

    // Assert
    ByteString byteString = actualStringValueBytes.EMPTY;
    assertEquals(byteString, actualStringValueBytes);
    assertSame(byteString, defaultInstance.getBytesValue());
  }

  /**
   * Test Payload_Metric {@link Metric#getTemplateValue()}.
   * <p>
   * Method under test: {@link Metric#getTemplateValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric getTemplateValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Metric.getTemplateValue()"})
  void testPayload_MetricGetTemplateValue() {
    // Arrange and Act
    Template actualTemplateValue = Metric.getDefaultInstance().getTemplateValue();

    // Assert
    assertEquals("", actualTemplateValue.getInitializationErrorString());
    assertEquals("", actualTemplateValue.getTemplateRef());
    assertEquals("", actualTemplateValue.getVersion());
    assertEquals(0, actualTemplateValue.getMetricsCount());
    assertEquals(0, actualTemplateValue.getParametersCount());
    assertEquals(0, actualTemplateValue.getSerializedSize());
    assertFalse(actualTemplateValue.getIsDefinition());
    assertFalse(actualTemplateValue.hasExtensions());
    assertFalse(actualTemplateValue.hasIsDefinition());
    assertFalse(actualTemplateValue.hasTemplateRef());
    assertFalse(actualTemplateValue.hasVersion());
    assertTrue(actualTemplateValue.findInitializationErrors().isEmpty());
    List<Metric> metricsList = actualTemplateValue.getMetricsList();
    assertTrue(metricsList.isEmpty());
    assertTrue(actualTemplateValue.getAllFields().isEmpty());
    assertTrue(actualTemplateValue.isInitialized());
    assertSame(actualTemplateValue, actualTemplateValue.getDefaultInstanceForType());
    assertSame(metricsList, actualTemplateValue.getMetricsOrBuilderList());
    assertSame(metricsList, actualTemplateValue.getParametersList());
    assertSame(metricsList, actualTemplateValue.getParametersOrBuilderList());
  }

  /**
   * Test Payload_Metric {@link Metric#getValueCase()}.
   * <p>
   * Method under test: {@link Metric#getValueCase()}
   */
  @Test
  @DisplayName("Test Payload_Metric getValueCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase Metric.getValueCase()"})
  void testPayload_MetricGetValueCase() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.VALUE_NOT_SET, Metric.getDefaultInstance().getValueCase());
  }

  /**
   * Test Payload_Metric {@link Metric#hasAlias()}.
   * <p>
   * Method under test: {@link Metric#hasAlias()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasAlias()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasAlias()"})
  void testPayload_MetricHasAlias() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasAlias());
  }

  /**
   * Test Payload_Metric {@link Metric#hasBooleanValue()}.
   * <p>
   * Method under test: {@link Metric#hasBooleanValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasBooleanValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasBooleanValue()"})
  void testPayload_MetricHasBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasBooleanValue());
  }

  /**
   * Test Payload_Metric {@link Metric#hasBytesValue()}.
   * <p>
   * Method under test: {@link Metric#hasBytesValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasBytesValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasBytesValue()"})
  void testPayload_MetricHasBytesValue() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasBytesValue());
  }

  /**
   * Test Payload_Metric {@link Metric#hasDatasetValue()}.
   * <p>
   * Method under test: {@link Metric#hasDatasetValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasDatasetValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasDatasetValue()"})
  void testPayload_MetricHasDatasetValue() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasDatasetValue());
  }

  /**
   * Test Payload_Metric {@link Metric#hasDatatype()}.
   * <p>
   * Method under test: {@link Metric#hasDatatype()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasDatatype()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasDatatype()"})
  void testPayload_MetricHasDatatype() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasDatatype());
  }

  /**
   * Test Payload_Metric {@link Metric#hasDoubleValue()}.
   * <p>
   * Method under test: {@link Metric#hasDoubleValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasDoubleValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasDoubleValue()"})
  void testPayload_MetricHasDoubleValue() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasDoubleValue());
  }

  /**
   * Test Payload_Metric {@link Metric#hasExtensionValue()}.
   * <p>
   * Method under test: {@link Metric#hasExtensionValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasExtensionValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasExtensionValue()"})
  void testPayload_MetricHasExtensionValue() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasExtensionValue());
  }

  /**
   * Test Payload_Metric {@link Metric#hasFloatValue()}.
   * <p>
   * Method under test: {@link Metric#hasFloatValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasFloatValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasFloatValue()"})
  void testPayload_MetricHasFloatValue() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasFloatValue());
  }

  /**
   * Test Payload_Metric {@link Metric#hasIntValue()}.
   * <p>
   * Method under test: {@link Metric#hasIntValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasIntValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasIntValue()"})
  void testPayload_MetricHasIntValue() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasIntValue());
  }

  /**
   * Test Payload_Metric {@link Metric#hasIsHistorical()}.
   * <p>
   * Method under test: {@link Metric#hasIsHistorical()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasIsHistorical()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasIsHistorical()"})
  void testPayload_MetricHasIsHistorical() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasIsHistorical());
  }

  /**
   * Test Payload_Metric {@link Metric#hasIsNull()}.
   * <p>
   * Method under test: {@link Metric#hasIsNull()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasIsNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasIsNull()"})
  void testPayload_MetricHasIsNull() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasIsNull());
  }

  /**
   * Test Payload_Metric {@link Metric#hasIsTransient()}.
   * <p>
   * Method under test: {@link Metric#hasIsTransient()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasIsTransient()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasIsTransient()"})
  void testPayload_MetricHasIsTransient() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasIsTransient());
  }

  /**
   * Test Payload_Metric {@link Metric#hasLongValue()}.
   * <p>
   * Method under test: {@link Metric#hasLongValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasLongValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasLongValue()"})
  void testPayload_MetricHasLongValue() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasLongValue());
  }

  /**
   * Test Payload_Metric {@link Metric#hasMetadata()}.
   * <p>
   * Method under test: {@link Metric#hasMetadata()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasMetadata()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasMetadata()"})
  void testPayload_MetricHasMetadata() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasMetadata());
  }

  /**
   * Test Payload_Metric {@link Metric#hasName()}.
   * <p>
   * Method under test: {@link Metric#hasName()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasName()"})
  void testPayload_MetricHasName() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasName());
  }

  /**
   * Test Payload_Metric {@link Metric#hasProperties()}.
   * <p>
   * Method under test: {@link Metric#hasProperties()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasProperties()"})
  void testPayload_MetricHasProperties() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasProperties());
  }

  /**
   * Test Payload_Metric {@link Metric#hasStringValue()}.
   * <p>
   * Method under test: {@link Metric#hasStringValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasStringValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasStringValue()"})
  void testPayload_MetricHasStringValue() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasStringValue());
  }

  /**
   * Test Payload_Metric {@link Metric#hasTemplateValue()}.
   * <p>
   * Method under test: {@link Metric#hasTemplateValue()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasTemplateValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasTemplateValue()"})
  void testPayload_MetricHasTemplateValue() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasTemplateValue());
  }

  /**
   * Test Payload_Metric {@link Metric#hasTimestamp()}.
   * <p>
   * Method under test: {@link Metric#hasTimestamp()}
   */
  @Test
  @DisplayName("Test Payload_Metric hasTimestamp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.hasTimestamp()"})
  void testPayload_MetricHasTimestamp() {
    // Arrange, Act and Assert
    assertFalse(Metric.getDefaultInstance().hasTimestamp());
  }

  /**
   * Test Payload_Metric {@link Metric#isInitialized()}.
   * <p>
   * Method under test: {@link Metric#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload_Metric isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Metric.isInitialized()"})
  void testPayload_MetricIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Metric.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload_Metric {@link Metric#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link Metric#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseDelimitedFrom(InputStream)"})
  void testPayload_MetricParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Metric actualParseDelimitedFromResult = Metric.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getName());
    assertEquals("", actualParseDelimitedFromResult.getStringValue());
    assertEquals(0, actualParseDelimitedFromResult.getDatatype());
    assertEquals(0, actualParseDelimitedFromResult.getIntValue());
    assertEquals(0.0d, actualParseDelimitedFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseDelimitedFromResult.getFloatValue());
    assertEquals(0L, actualParseDelimitedFromResult.getAlias());
    assertEquals(0L, actualParseDelimitedFromResult.getTimestamp());
    assertEquals(1, actualParseDelimitedFromResult.getAllFields().size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertEquals(65L, actualParseDelimitedFromResult.getLongValue());
    assertEquals(ValueCase.LONG_VALUE, actualParseDelimitedFromResult.getValueCase());
    assertFalse(actualParseDelimitedFromResult.getBooleanValue());
    assertFalse(actualParseDelimitedFromResult.getIsHistorical());
    assertFalse(actualParseDelimitedFromResult.getIsNull());
    assertFalse(actualParseDelimitedFromResult.getIsTransient());
    assertFalse(actualParseDelimitedFromResult.hasAlias());
    assertFalse(actualParseDelimitedFromResult.hasBooleanValue());
    assertFalse(actualParseDelimitedFromResult.hasBytesValue());
    assertFalse(actualParseDelimitedFromResult.hasDatasetValue());
    assertFalse(actualParseDelimitedFromResult.hasDatatype());
    assertFalse(actualParseDelimitedFromResult.hasDoubleValue());
    assertFalse(actualParseDelimitedFromResult.hasExtensionValue());
    assertFalse(actualParseDelimitedFromResult.hasFloatValue());
    assertFalse(actualParseDelimitedFromResult.hasIntValue());
    assertFalse(actualParseDelimitedFromResult.hasIsHistorical());
    assertFalse(actualParseDelimitedFromResult.hasIsNull());
    assertFalse(actualParseDelimitedFromResult.hasIsTransient());
    assertFalse(actualParseDelimitedFromResult.hasMetadata());
    assertFalse(actualParseDelimitedFromResult.hasName());
    assertFalse(actualParseDelimitedFromResult.hasProperties());
    assertFalse(actualParseDelimitedFromResult.hasStringValue());
    assertFalse(actualParseDelimitedFromResult.hasTemplateValue());
    assertFalse(actualParseDelimitedFromResult.hasTimestamp());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.hasLongValue());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Metric {@link Metric#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link Metric#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseDelimitedFrom(InputStream)"})
  void testPayload_MetricParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Metric.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Metric {@link Metric#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Metric#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetricParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Metric actualParseDelimitedFromResult = Metric.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getName());
    assertEquals("", actualParseDelimitedFromResult.getStringValue());
    assertEquals(0, actualParseDelimitedFromResult.getDatatype());
    assertEquals(0, actualParseDelimitedFromResult.getIntValue());
    assertEquals(0.0d, actualParseDelimitedFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseDelimitedFromResult.getFloatValue());
    assertEquals(0L, actualParseDelimitedFromResult.getAlias());
    assertEquals(0L, actualParseDelimitedFromResult.getTimestamp());
    assertEquals(1, actualParseDelimitedFromResult.getAllFields().size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertEquals(65L, actualParseDelimitedFromResult.getLongValue());
    assertEquals(ValueCase.LONG_VALUE, actualParseDelimitedFromResult.getValueCase());
    assertFalse(actualParseDelimitedFromResult.getBooleanValue());
    assertFalse(actualParseDelimitedFromResult.getIsHistorical());
    assertFalse(actualParseDelimitedFromResult.getIsNull());
    assertFalse(actualParseDelimitedFromResult.getIsTransient());
    assertFalse(actualParseDelimitedFromResult.hasAlias());
    assertFalse(actualParseDelimitedFromResult.hasBooleanValue());
    assertFalse(actualParseDelimitedFromResult.hasBytesValue());
    assertFalse(actualParseDelimitedFromResult.hasDatasetValue());
    assertFalse(actualParseDelimitedFromResult.hasDatatype());
    assertFalse(actualParseDelimitedFromResult.hasDoubleValue());
    assertFalse(actualParseDelimitedFromResult.hasExtensionValue());
    assertFalse(actualParseDelimitedFromResult.hasFloatValue());
    assertFalse(actualParseDelimitedFromResult.hasIntValue());
    assertFalse(actualParseDelimitedFromResult.hasIsHistorical());
    assertFalse(actualParseDelimitedFromResult.hasIsNull());
    assertFalse(actualParseDelimitedFromResult.hasIsTransient());
    assertFalse(actualParseDelimitedFromResult.hasMetadata());
    assertFalse(actualParseDelimitedFromResult.hasName());
    assertFalse(actualParseDelimitedFromResult.hasProperties());
    assertFalse(actualParseDelimitedFromResult.hasStringValue());
    assertFalse(actualParseDelimitedFromResult.hasTemplateValue());
    assertFalse(actualParseDelimitedFromResult.hasTimestamp());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.hasLongValue());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Metric {@link Metric#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Metric#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetricParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Metric.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Metric {@link Metric#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Metric#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetricParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Metric.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Metric {@link Metric#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Metric#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetricParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Metric.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Metric {@link Metric#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metric#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetricParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Metric.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_Metric {@link Metric#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metric#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseDelimitedFrom(InputStream)"})
  void testPayload_MetricParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Metric.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_Metric {@link Metric#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metric#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseDelimitedFrom(InputStream)"})
  void testPayload_MetricParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Metric.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Metric {@link Metric#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metric#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseDelimitedFrom(InputStream)"})
  void testPayload_MetricParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Metric.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link Metric#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(byte[])"})
  void testPayload_MetricParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    Metric actualParseFromResult = Metric.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getDatatype());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getAlias());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsHistorical());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.getIsTransient());
    assertFalse(actualParseFromResult.hasAlias());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasBytesValue());
    assertFalse(actualParseFromResult.hasDatasetValue());
    assertFalse(actualParseFromResult.hasDatatype());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsHistorical());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasIsTransient());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasMetadata());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasProperties());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasTemplateValue());
    assertFalse(actualParseFromResult.hasTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link Metric#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(ByteBuffer)"})
  void testPayload_MetricParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    Metric actualParseFromResult = Metric.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getDatatype());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getAlias());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsHistorical());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.getIsTransient());
    assertFalse(actualParseFromResult.hasAlias());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasBytesValue());
    assertFalse(actualParseFromResult.hasDatasetValue());
    assertFalse(actualParseFromResult.hasDatatype());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsHistorical());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasIsTransient());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasMetadata());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasProperties());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasTemplateValue());
    assertFalse(actualParseFromResult.hasTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Metric#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayload_MetricParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Metric actualParseFromResult = Metric.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getDatatype());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getAlias());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsHistorical());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.getIsTransient());
    assertFalse(actualParseFromResult.hasAlias());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasBytesValue());
    assertFalse(actualParseFromResult.hasDatasetValue());
    assertFalse(actualParseFromResult.hasDatatype());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsHistorical());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasIsTransient());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasMetadata());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasProperties());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasTemplateValue());
    assertFalse(actualParseFromResult.hasTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Metric#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayload_MetricParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    Metric actualParseFromResult = Metric.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getDatatype());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getAlias());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsHistorical());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.getIsTransient());
    assertFalse(actualParseFromResult.hasAlias());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasBytesValue());
    assertFalse(actualParseFromResult.hasDatasetValue());
    assertFalse(actualParseFromResult.hasDatatype());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsHistorical());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasIsTransient());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasMetadata());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasProperties());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasTemplateValue());
    assertFalse(actualParseFromResult.hasTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link Metric#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(ByteString)"})
  void testPayload_MetricParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Metric actualParseFromResult = Metric.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getDatatype());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getAlias());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsHistorical());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.getIsTransient());
    assertFalse(actualParseFromResult.hasAlias());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasBytesValue());
    assertFalse(actualParseFromResult.hasDatasetValue());
    assertFalse(actualParseFromResult.hasDatatype());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsHistorical());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasIsTransient());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasMetadata());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasProperties());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasTemplateValue());
    assertFalse(actualParseFromResult.hasTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedBytesValue = data.EMPTY;
    assertSame(expectedBytesValue, actualParseFromResult.getBytesValue());
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Metric#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testPayload_MetricParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Metric actualParseFromResult = Metric.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getDatatype());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getAlias());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsHistorical());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.getIsTransient());
    assertFalse(actualParseFromResult.hasAlias());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasBytesValue());
    assertFalse(actualParseFromResult.hasDatasetValue());
    assertFalse(actualParseFromResult.hasDatatype());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsHistorical());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasIsTransient());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasMetadata());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasProperties());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasTemplateValue());
    assertFalse(actualParseFromResult.hasTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedBytesValue = data.EMPTY;
    assertSame(expectedBytesValue, actualParseFromResult.getBytesValue());
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link Metric#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(CodedInputStream)"})
  void testPayload_MetricParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Metric actualParseFromResult = Metric.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getDatatype());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getAlias());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsHistorical());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.getIsTransient());
    assertFalse(actualParseFromResult.hasAlias());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasBytesValue());
    assertFalse(actualParseFromResult.hasDatasetValue());
    assertFalse(actualParseFromResult.hasDatatype());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsHistorical());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasIsTransient());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasMetadata());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasProperties());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasTemplateValue());
    assertFalse(actualParseFromResult.hasTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Metric#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testPayload_MetricParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Metric actualParseFromResult = Metric.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getDatatype());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getAlias());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsHistorical());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.getIsTransient());
    assertFalse(actualParseFromResult.hasAlias());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasBytesValue());
    assertFalse(actualParseFromResult.hasDatasetValue());
    assertFalse(actualParseFromResult.hasDatatype());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsHistorical());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasIsTransient());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasMetadata());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasProperties());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasTemplateValue());
    assertFalse(actualParseFromResult.hasTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link Metric#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(InputStream)"})
  void testPayload_MetricParseFromWithInputStream() throws IOException {
    // Arrange and Act
    Metric actualParseFromResult = Metric.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link Metric#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(InputStream)"})
  void testPayload_MetricParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Metric.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Metric#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetricParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Metric actualParseFromResult = Metric.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getDatatype());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getAlias());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(0L, actualParseFromResult.getTimestamp());
    assertEquals(ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsHistorical());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.getIsTransient());
    assertFalse(actualParseFromResult.hasAlias());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasBytesValue());
    assertFalse(actualParseFromResult.hasDatasetValue());
    assertFalse(actualParseFromResult.hasDatatype());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsHistorical());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasIsTransient());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasMetadata());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasProperties());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasTemplateValue());
    assertFalse(actualParseFromResult.hasTimestamp());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Metric#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetricParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Metric.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Metric#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_MetricParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Metric.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metric#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(InputStream)"})
  void testPayload_MetricParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Metric.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Metric {@link Metric#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Metric#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Metric Metric.parseFrom(InputStream)"})
  void testPayload_MetricParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    Metric actualParseFromResult = Metric.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#equals(Object)}, and {@link MetricValueExtension#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MetricValueExtension#equals(Object)}
   *   <li>{@link MetricValueExtension#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension equals(Object), and hashCode(); then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetricValueExtension.equals(Object)", "int MetricValueExtension.hashCode()"})
  void testPayload_Metric_MetricValueExtensionEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    MetricValueExtension defaultInstance = MetricValueExtension.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#equals(Object)}, and {@link MetricValueExtension#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MetricValueExtension#equals(Object)}
   *   <li>{@link MetricValueExtension#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension equals(Object), and hashCode(); then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetricValueExtension.equals(Object)", "int MetricValueExtension.hashCode()"})
  void testPayload_Metric_MetricValueExtensionEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    MetricValueExtension defaultInstance = MetricValueExtension.getDefaultInstance();
    MetricValueExtension defaultInstance2 = MetricValueExtension.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricValueExtension#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetricValueExtension.equals(Object)", "int MetricValueExtension.hashCode()"})
  void testPayload_Metric_MetricValueExtensionEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetricValueExtension.getDefaultInstance(), "Different type to MetricValueExtension");
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricValueExtension#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetricValueExtension.equals(Object)", "int MetricValueExtension.hashCode()"})
  void testPayload_Metric_MetricValueExtensionEquals_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(MetricValueExtension.getDefaultInstance(), 1);
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricValueExtension#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetricValueExtension.equals(Object)", "int MetricValueExtension.hashCode()"})
  void testPayload_Metric_MetricValueExtensionEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MetricValueExtension.getDefaultInstance(), null);
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link MetricValueExtension#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.getDefaultInstanceForType()"})
  void testPayload_Metric_MetricValueExtensionGetDefaultInstanceForType() {
    // Arrange
    MetricValueExtension defaultInstance = MetricValueExtension.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#getExtensions()}.
   * <p>
   * Method under test: {@link MetricValueExtension#getExtensions()}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension getExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Any MetricValueExtension.getExtensions()"})
  void testPayload_Metric_MetricValueExtensionGetExtensions() {
    // Arrange and Act
    Any actualExtensions = MetricValueExtension.getDefaultInstance().getExtensions();

    // Assert
    assertEquals("", actualExtensions.getInitializationErrorString());
    assertEquals("", actualExtensions.getTypeUrl());
    assertEquals(0, actualExtensions.getSerializedSize());
    assertTrue(actualExtensions.isInitialized());
    assertTrue(actualExtensions.findInitializationErrors().isEmpty());
    assertTrue(actualExtensions.getAllFields().isEmpty());
    assertSame(actualExtensions, actualExtensions.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#getSerializedSize()}.
   * <p>
   * Method under test: {@link MetricValueExtension#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int MetricValueExtension.getSerializedSize()"})
  void testPayload_Metric_MetricValueExtensionGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MetricValueExtension.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#hasExtensions()}.
   * <p>
   * Method under test: {@link MetricValueExtension#hasExtensions()}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension hasExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetricValueExtension.hasExtensions()"})
  void testPayload_Metric_MetricValueExtensionHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(MetricValueExtension.getDefaultInstance().hasExtensions());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#isInitialized()}.
   * <p>
   * Method under test: {@link MetricValueExtension#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MetricValueExtension.isInitialized()"})
  void testPayload_Metric_MetricValueExtensionIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MetricValueExtension.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_Metric_MetricValueExtensionParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MetricValueExtension actualParseDelimitedFromResult = MetricValueExtension.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    MetricValueExtension defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, defaultInstanceForType.getExtensions());
    assertSame(extensions, defaultInstanceForType.getExtensionsOrBuilder());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_Metric_MetricValueExtensionParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MetricValueExtension actualParseDelimitedFromResult = MetricValueExtension.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_Metric_MetricValueExtensionParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetricValueExtension.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_Metric_MetricValueExtensionParseDelimitedFromWithInput4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MetricValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_Metric_MetricValueExtensionParseDelimitedFromWithInput5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetricValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetricValueExtension MetricValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Metric_MetricValueExtensionParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MetricValueExtension actualParseDelimitedFromResult = MetricValueExtension.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    MetricValueExtension defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, defaultInstanceForType.getExtensions());
    assertSame(extensions, defaultInstanceForType.getExtensionsOrBuilder());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetricValueExtension MetricValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Metric_MetricValueExtensionParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MetricValueExtension actualParseDelimitedFromResult = MetricValueExtension.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetricValueExtension MetricValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Metric_MetricValueExtensionParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MetricValueExtension.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetricValueExtension MetricValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Metric_MetricValueExtensionParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> MetricValueExtension.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MetricValueExtension MetricValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Metric_MetricValueExtensionParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MetricValueExtension.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(byte[])"})
  void testPayload_Metric_MetricValueExtensionParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    MetricValueExtension actualParseFromResult = MetricValueExtension.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(ByteBuffer)"})
  void testPayload_Metric_MetricValueExtensionParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    MetricValueExtension actualParseFromResult = MetricValueExtension.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayload_Metric_MetricValueExtensionParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    MetricValueExtension actualParseFromResult = MetricValueExtension.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayload_Metric_MetricValueExtensionParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    MetricValueExtension actualParseFromResult = MetricValueExtension.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(ByteString)"})
  void testPayload_Metric_MetricValueExtensionParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    MetricValueExtension actualParseFromResult = MetricValueExtension.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testPayload_Metric_MetricValueExtensionParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    MetricValueExtension actualParseFromResult = MetricValueExtension.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(CodedInputStream)"})
  void testPayload_Metric_MetricValueExtensionParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    MetricValueExtension actualParseFromResult = MetricValueExtension.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testPayload_Metric_MetricValueExtensionParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    MetricValueExtension actualParseFromResult = MetricValueExtension.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(InputStream)"})
  void testPayload_Metric_MetricValueExtensionParseFromWithInputStream() throws IOException {
    // Arrange and Act
    MetricValueExtension actualParseFromResult = MetricValueExtension.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(InputStream)"})
  void testPayload_Metric_MetricValueExtensionParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MetricValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(InputStream)"})
  void testPayload_Metric_MetricValueExtensionParseFromWithInputStream3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MetricValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Metric_MetricValueExtensionParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    MetricValueExtension actualParseFromResult = MetricValueExtension.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Metric_MetricValueExtensionParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MetricValueExtension.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Metric_MetricValueExtensionParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MetricValueExtension.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Metric_MetricValueExtension {@link MetricValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Metric_MetricValueExtension parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MetricValueExtension MetricValueExtension.parseFrom(InputStream)"})
  void testPayload_Metric_MetricValueExtensionParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    MetricValueExtension actualParseFromResult = MetricValueExtension.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code BOOLEAN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'BOOLEAN_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnBooleanValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.BOOLEAN_VALUE, ValueCase.forNumber(Metric.BOOLEAN_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code BYTES_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'BYTES_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnBytesValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.BYTES_VALUE, ValueCase.forNumber(Metric.BYTES_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code DATASET_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'DATASET_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnDatasetValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DATASET_VALUE, ValueCase.forNumber(Metric.DATASET_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code DOUBLE_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'DOUBLE_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DOUBLE_VALUE, ValueCase.forNumber(Metric.DOUBLE_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code EXTENSION_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'EXTENSION_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnExtensionValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.EXTENSION_VALUE, ValueCase.forNumber(Metric.EXTENSION_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code FLOAT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'FLOAT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.FLOAT_VALUE, ValueCase.forNumber(Metric.FLOAT_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code INT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'INT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.INT_VALUE, ValueCase.forNumber(Metric.INT_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code LONG_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'LONG_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.LONG_VALUE, ValueCase.forNumber(Metric.LONG_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code STRING_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'STRING_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.STRING_VALUE, ValueCase.forNumber(Metric.STRING_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code TEMPLATE_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); then return 'TEMPLATE_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_thenReturnTemplateValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.TEMPLATE_VALUE, ValueCase.forNumber(Metric.TEMPLATE_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ValueCase.forNumber(42));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code VALUE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase forNumber(int); when zero; then return 'VALUE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.forNumber(int)"})
  void testPayload_Metric_ValueCaseForNumber_whenZero_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.VALUE_NOT_SET, ValueCase.forNumber(0));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#getNumber()}.
   * <p>
   * Method under test: {@link ValueCase#getNumber()}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ValueCase.getNumber()"})
  void testPayload_Metric_ValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(Metric.INT_VALUE_FIELD_NUMBER, ValueCase.valueOf("INT_VALUE").getNumber());
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code BOOLEAN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'BOOLEAN_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnBooleanValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.BOOLEAN_VALUE, ValueCase.valueOf(Metric.BOOLEAN_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code BYTES_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'BYTES_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnBytesValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.BYTES_VALUE, ValueCase.valueOf(Metric.BYTES_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code DATASET_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'DATASET_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnDatasetValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DATASET_VALUE, ValueCase.valueOf(Metric.DATASET_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code DOUBLE_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'DOUBLE_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.DOUBLE_VALUE, ValueCase.valueOf(Metric.DOUBLE_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code EXTENSION_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'EXTENSION_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnExtensionValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.EXTENSION_VALUE, ValueCase.valueOf(Metric.EXTENSION_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code FLOAT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'FLOAT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.FLOAT_VALUE, ValueCase.valueOf(Metric.FLOAT_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code INT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'INT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.INT_VALUE, ValueCase.valueOf(Metric.INT_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code LONG_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'LONG_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.LONG_VALUE, ValueCase.valueOf(Metric.LONG_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code STRING_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'STRING_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.STRING_VALUE, ValueCase.valueOf(Metric.STRING_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code TEMPLATE_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; then return 'TEMPLATE_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_thenReturnTemplateValue() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.TEMPLATE_VALUE, ValueCase.valueOf(Metric.TEMPLATE_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ValueCase.valueOf(42));
  }

  /**
   * Test Payload_Metric_ValueCase {@link ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code VALUE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Metric_ValueCase valueOf(int) with 'value'; when zero; then return 'VALUE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValueCase ValueCase.valueOf(int)"})
  void testPayload_Metric_ValueCaseValueOfWithValue_whenZero_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(ValueCase.VALUE_NOT_SET, ValueCase.valueOf(0));
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#equals(Object)}, and {@link PropertySet#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertySet#equals(Object)}
   *   <li>{@link PropertySet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_PropertySet equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertySet.equals(Object)", "int PropertySet.hashCode()"})
  void testPayload_PropertySetEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PropertySet defaultInstance = PropertySet.getDefaultInstance();
    PropertySet defaultInstance2 = PropertySet.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#equals(Object)}, and {@link PropertySet#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertySet#equals(Object)}
   *   <li>{@link PropertySet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_PropertySet equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertySet.equals(Object)", "int PropertySet.hashCode()"})
  void testPayload_PropertySetEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PropertySet defaultInstance = PropertySet.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySet#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertySet.equals(Object)", "int PropertySet.hashCode()"})
  void testPayload_PropertySetEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PropertySet.getDefaultInstance(), 1);
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySet#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertySet.equals(Object)", "int PropertySet.hashCode()"})
  void testPayload_PropertySetEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PropertySet.getDefaultInstance(), null);
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySet#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertySet.equals(Object)", "int PropertySet.hashCode()"})
  void testPayload_PropertySetEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PropertySet.getDefaultInstance(), "Different type to PropertySet");
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link PropertySet#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload_PropertySet getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.getDefaultInstanceForType()"})
  void testPayload_PropertySetGetDefaultInstanceForType() {
    // Arrange
    PropertySet defaultInstance = PropertySet.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#getExtensions()}.
   * <p>
   * Method under test: {@link PropertySet#getExtensions()}
   */
  @Test
  @DisplayName("Test Payload_PropertySet getExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Any PropertySet.getExtensions()"})
  void testPayload_PropertySetGetExtensions() {
    // Arrange and Act
    Any actualExtensions = PropertySet.getDefaultInstance().getExtensions();

    // Assert
    assertEquals("", actualExtensions.getInitializationErrorString());
    assertEquals("", actualExtensions.getTypeUrl());
    assertEquals(0, actualExtensions.getSerializedSize());
    assertTrue(actualExtensions.isInitialized());
    assertTrue(actualExtensions.findInitializationErrors().isEmpty());
    assertTrue(actualExtensions.getAllFields().isEmpty());
    assertSame(actualExtensions, actualExtensions.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#getKeysCount()}.
   * <p>
   * Method under test: {@link PropertySet#getKeysCount()}
   */
  @Test
  @DisplayName("Test Payload_PropertySet getKeysCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PropertySet.getKeysCount()"})
  void testPayload_PropertySetGetKeysCount() {
    // Arrange, Act and Assert
    assertEquals(0, PropertySet.getDefaultInstance().getKeysCount());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#getKeysList()}.
   * <p>
   * Method under test: {@link PropertySet#getKeysList()}
   */
  @Test
  @DisplayName("Test Payload_PropertySet getKeysList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtocolStringList PropertySet.getKeysList()"})
  void testPayload_PropertySetGetKeysList() {
    // Arrange
    PropertySet defaultInstance = PropertySet.getDefaultInstance();

    // Act
    ProtocolStringList actualKeysList = defaultInstance.getKeysList();

    // Assert
    assertTrue(actualKeysList.isEmpty());
    LazyStringList lazyStringList = ((LazyStringArrayList) actualKeysList).EMPTY;
    assertSame(lazyStringList, defaultInstance.getDescriptorForType().toProto().getReservedNameList());
    assertSame(lazyStringList, actualKeysList);
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#getSerializedSize()}.
   * <p>
   * Method under test: {@link PropertySet#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload_PropertySet getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PropertySet.getSerializedSize()"})
  void testPayload_PropertySetGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, PropertySet.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#getValuesCount()}.
   * <p>
   * Method under test: {@link PropertySet#getValuesCount()}
   */
  @Test
  @DisplayName("Test Payload_PropertySet getValuesCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PropertySet.getValuesCount()"})
  void testPayload_PropertySetGetValuesCount() {
    // Arrange, Act and Assert
    assertEquals(0, PropertySet.getDefaultInstance().getValuesCount());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#hasExtensions()}.
   * <p>
   * Method under test: {@link PropertySet#hasExtensions()}
   */
  @Test
  @DisplayName("Test Payload_PropertySet hasExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertySet.hasExtensions()"})
  void testPayload_PropertySetHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(PropertySet.getDefaultInstance().hasExtensions());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#isInitialized()}.
   * <p>
   * Method under test: {@link PropertySet#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload_PropertySet isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertySet.isInitialized()"})
  void testPayload_PropertySetIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(PropertySet.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#equals(Object)}, and {@link PropertySetList#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertySetList#equals(Object)}
   *   <li>{@link PropertySetList#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_PropertySetList equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertySetList.equals(Object)", "int PropertySetList.hashCode()"})
  void testPayload_PropertySetListEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PropertySetList defaultInstance = PropertySetList.getDefaultInstance();
    PropertySetList defaultInstance2 = PropertySetList.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#equals(Object)}, and {@link PropertySetList#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertySetList#equals(Object)}
   *   <li>{@link PropertySetList#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_PropertySetList equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertySetList.equals(Object)", "int PropertySetList.hashCode()"})
  void testPayload_PropertySetListEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PropertySetList defaultInstance = PropertySetList.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySetList#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertySetList.equals(Object)", "int PropertySetList.hashCode()"})
  void testPayload_PropertySetListEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PropertySetList.getDefaultInstance(), 1);
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySetList#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertySetList.equals(Object)", "int PropertySetList.hashCode()"})
  void testPayload_PropertySetListEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PropertySetList.getDefaultInstance(), null);
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySetList#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertySetList.equals(Object)", "int PropertySetList.hashCode()"})
  void testPayload_PropertySetListEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PropertySetList.getDefaultInstance(), "Different type to PropertySetList");
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link PropertySetList#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.getDefaultInstanceForType()"})
  void testPayload_PropertySetListGetDefaultInstanceForType() {
    // Arrange
    PropertySetList defaultInstance = PropertySetList.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#getExtensions()}.
   * <p>
   * Method under test: {@link PropertySetList#getExtensions()}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList getExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Any PropertySetList.getExtensions()"})
  void testPayload_PropertySetListGetExtensions() {
    // Arrange and Act
    Any actualExtensions = PropertySetList.getDefaultInstance().getExtensions();

    // Assert
    assertEquals("", actualExtensions.getInitializationErrorString());
    assertEquals("", actualExtensions.getTypeUrl());
    assertEquals(0, actualExtensions.getSerializedSize());
    assertTrue(actualExtensions.isInitialized());
    assertTrue(actualExtensions.findInitializationErrors().isEmpty());
    assertTrue(actualExtensions.getAllFields().isEmpty());
    assertSame(actualExtensions, actualExtensions.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#getPropertysetCount()}.
   * <p>
   * Method under test: {@link PropertySetList#getPropertysetCount()}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList getPropertysetCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PropertySetList.getPropertysetCount()"})
  void testPayload_PropertySetListGetPropertysetCount() {
    // Arrange, Act and Assert
    assertEquals(0, PropertySetList.getDefaultInstance().getPropertysetCount());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#getSerializedSize()}.
   * <p>
   * Method under test: {@link PropertySetList#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PropertySetList.getSerializedSize()"})
  void testPayload_PropertySetListGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, PropertySetList.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#hasExtensions()}.
   * <p>
   * Method under test: {@link PropertySetList#hasExtensions()}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList hasExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertySetList.hasExtensions()"})
  void testPayload_PropertySetListHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(PropertySetList.getDefaultInstance().hasExtensions());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#isInitialized()}.
   * <p>
   * Method under test: {@link PropertySetList#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertySetList.isInitialized()"})
  void testPayload_PropertySetListIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(PropertySetList.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PropertySetList#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertySetListParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PropertySetList actualParseDelimitedFromResult = PropertySetList.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    PropertySetList defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, defaultInstanceForType.getExtensions());
    assertSame(extensions, defaultInstanceForType.getExtensionsOrBuilder());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PropertySetList#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertySetListParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PropertySetList actualParseDelimitedFromResult = PropertySetList.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PropertySetList#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertySetListParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PropertySetList.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertySetList#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetListParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PropertySetList actualParseDelimitedFromResult = PropertySetList.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    PropertySetList defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, defaultInstanceForType.getExtensions());
    assertSame(extensions, defaultInstanceForType.getExtensionsOrBuilder());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertySetList#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetListParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PropertySetList actualParseDelimitedFromResult = PropertySetList.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertySetList#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetListParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PropertySetList.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertySetList#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetListParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> PropertySetList.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertySetList#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetListParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PropertySetList.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySetList#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertySetListParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PropertySetList.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySetList#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertySetListParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> PropertySetList.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link PropertySetList#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseFrom(byte[])"})
  void testPayload_PropertySetListParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    PropertySetList actualParseFromResult = PropertySetList.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPropertysetCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PropertySet> propertysetList = actualParseFromResult.getPropertysetList();
    assertTrue(propertysetList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(propertysetList, actualParseFromResult.getPropertysetOrBuilderList());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link PropertySetList#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseFrom(ByteBuffer)"})
  void testPayload_PropertySetListParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    PropertySetList actualParseFromResult = PropertySetList.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPropertysetCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PropertySet> propertysetList = actualParseFromResult.getPropertysetList();
    assertTrue(propertysetList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(propertysetList, actualParseFromResult.getPropertysetOrBuilderList());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertySetList#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayload_PropertySetListParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    PropertySetList actualParseFromResult = PropertySetList.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPropertysetCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PropertySet> propertysetList = actualParseFromResult.getPropertysetList();
    assertTrue(propertysetList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(propertysetList, actualParseFromResult.getPropertysetOrBuilderList());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertySetList#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayload_PropertySetListParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    PropertySetList actualParseFromResult = PropertySetList.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPropertysetCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PropertySet> propertysetList = actualParseFromResult.getPropertysetList();
    assertTrue(propertysetList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(propertysetList, actualParseFromResult.getPropertysetOrBuilderList());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link PropertySetList#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseFrom(InputStream)"})
  void testPayload_PropertySetListParseFromWithInputStream() throws IOException {
    // Arrange and Act
    PropertySetList actualParseFromResult = PropertySetList.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link PropertySetList#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseFrom(InputStream)"})
  void testPayload_PropertySetListParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PropertySetList.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertySetList#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetListParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    PropertySetList actualParseFromResult = PropertySetList.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getPropertysetCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<PropertySet> propertysetList = actualParseFromResult.getPropertysetList();
    assertTrue(propertysetList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(propertysetList, actualParseFromResult.getPropertysetOrBuilderList());
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertySetList#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetListParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PropertySetList.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertySetList#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetListParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PropertySetList.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySetList#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseFrom(InputStream)"})
  void testPayload_PropertySetListParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PropertySetList.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertySetList {@link PropertySetList#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySetList#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySetList parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertySetList.parseFrom(InputStream)"})
  void testPayload_PropertySetListParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    PropertySetList actualParseFromResult = PropertySetList.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PropertySet#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertySetParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PropertySet actualParseDelimitedFromResult = PropertySet.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(3, actualParseDelimitedFromResult.getDescriptorForType().getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PropertySet#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertySetParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PropertySet.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PropertySet#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertySetParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PropertySet.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2,
        PropertySet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PropertySet actualParseDelimitedFromResult = PropertySet.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(3, actualParseDelimitedFromResult.getDescriptorForType().getFields().size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PropertySet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> PropertySet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PropertySet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertySet#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetParseDelimitedFromWithInputExtensionRegistry6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PropertySet.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySet#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertySetParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PropertySet.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySet#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertySetParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, PropertySet.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySet#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertySetParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> PropertySet.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link PropertySet#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseFrom(byte[])"})
  void testPayload_PropertySetParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    PropertySet actualParseFromResult = PropertySet.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValuesCount());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    List<PropertyValue> valuesList = actualParseFromResult.getValuesList();
    assertTrue(valuesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(valuesList, actualParseFromResult.getValuesOrBuilderList());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link PropertySet#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseFrom(ByteBuffer)"})
  void testPayload_PropertySetParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    PropertySet actualParseFromResult = PropertySet.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValuesCount());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    List<PropertyValue> valuesList = actualParseFromResult.getValuesList();
    assertTrue(valuesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(valuesList, actualParseFromResult.getValuesOrBuilderList());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertySet#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayload_PropertySetParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    PropertySet actualParseFromResult = PropertySet.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValuesCount());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    List<PropertyValue> valuesList = actualParseFromResult.getValuesList();
    assertTrue(valuesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(valuesList, actualParseFromResult.getValuesOrBuilderList());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertySet#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayload_PropertySetParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    PropertySet actualParseFromResult = PropertySet.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValuesCount());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    List<PropertyValue> valuesList = actualParseFromResult.getValuesList();
    assertTrue(valuesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(valuesList, actualParseFromResult.getValuesOrBuilderList());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link PropertySet#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseFrom(InputStream)"})
  void testPayload_PropertySetParseFromWithInputStream() throws IOException {
    // Arrange and Act
    PropertySet actualParseFromResult = PropertySet.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link PropertySet#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseFrom(InputStream)"})
  void testPayload_PropertySetParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PropertySet.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertySet#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    PropertySet actualParseFromResult = PropertySet.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getKeysCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getValuesCount());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getKeysList().isEmpty());
    List<PropertyValue> valuesList = actualParseFromResult.getValuesList();
    assertTrue(valuesList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(valuesList, actualParseFromResult.getValuesOrBuilderList());
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertySet#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PropertySet.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertySet#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertySetParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PropertySet.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySet#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseFrom(InputStream)"})
  void testPayload_PropertySetParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PropertySet.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertySet {@link PropertySet#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertySet#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertySet parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertySet.parseFrom(InputStream)"})
  void testPayload_PropertySetParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    PropertySet actualParseFromResult = PropertySet.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#equals(Object)}, and {@link PropertyValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertyValue#equals(Object)}
   *   <li>{@link PropertyValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_PropertyValue equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.equals(Object)", "int PropertyValue.hashCode()"})
  void testPayload_PropertyValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PropertyValue defaultInstance = PropertyValue.getDefaultInstance();
    PropertyValue defaultInstance2 = PropertyValue.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#equals(Object)}, and {@link PropertyValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertyValue#equals(Object)}
   *   <li>{@link PropertyValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_PropertyValue equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.equals(Object)", "int PropertyValue.hashCode()"})
  void testPayload_PropertyValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PropertyValue defaultInstance = PropertyValue.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.equals(Object)", "int PropertyValue.hashCode()"})
  void testPayload_PropertyValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PropertyValue.getDefaultInstance(), 1);
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.equals(Object)", "int PropertyValue.hashCode()"})
  void testPayload_PropertyValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PropertyValue.getDefaultInstance(), null);
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.equals(Object)", "int PropertyValue.hashCode()"})
  void testPayload_PropertyValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PropertyValue.getDefaultInstance(), "Different type to PropertyValue");
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#getBooleanValue()}.
   * <p>
   * Method under test: {@link PropertyValue#getBooleanValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue getBooleanValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.getBooleanValue()"})
  void testPayload_PropertyValueGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(PropertyValue.getDefaultInstance().getBooleanValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link PropertyValue#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.getDefaultInstanceForType()"})
  void testPayload_PropertyValueGetDefaultInstanceForType() {
    // Arrange
    PropertyValue defaultInstance = PropertyValue.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#getDoubleValue()}.
   * <p>
   * Method under test: {@link PropertyValue#getDoubleValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue getDoubleValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double PropertyValue.getDoubleValue()"})
  void testPayload_PropertyValueGetDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(0.0d, PropertyValue.getDefaultInstance().getDoubleValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#getExtensionValue()}.
   * <p>
   * Method under test: {@link PropertyValue#getExtensionValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue getExtensionValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValue.getExtensionValue()"})
  void testPayload_PropertyValueGetExtensionValue() {
    // Arrange and Act
    PropertyValueExtension actualExtensionValue = PropertyValue.getDefaultInstance().getExtensionValue();

    // Assert
    assertEquals("", actualExtensionValue.getInitializationErrorString());
    assertEquals(0, actualExtensionValue.getSerializedSize());
    assertFalse(actualExtensionValue.hasExtensions());
    assertTrue(actualExtensionValue.findInitializationErrors().isEmpty());
    assertTrue(actualExtensionValue.getAllFields().isEmpty());
    assertTrue(actualExtensionValue.isInitialized());
    assertSame(actualExtensionValue, actualExtensionValue.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#getFloatValue()}.
   * <p>
   * Method under test: {@link PropertyValue#getFloatValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue getFloatValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PropertyValue.getFloatValue()"})
  void testPayload_PropertyValueGetFloatValue() {
    // Arrange, Act and Assert
    assertEquals(0.0f, PropertyValue.getDefaultInstance().getFloatValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#getIntValue()}.
   * <p>
   * Method under test: {@link PropertyValue#getIntValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue getIntValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PropertyValue.getIntValue()"})
  void testPayload_PropertyValueGetIntValue() {
    // Arrange, Act and Assert
    assertEquals(0, PropertyValue.getDefaultInstance().getIntValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#getLongValue()}.
   * <p>
   * Method under test: {@link PropertyValue#getLongValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue getLongValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long PropertyValue.getLongValue()"})
  void testPayload_PropertyValueGetLongValue() {
    // Arrange, Act and Assert
    assertEquals(0L, PropertyValue.getDefaultInstance().getLongValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#getPropertysetValue()}.
   * <p>
   * Method under test: {@link PropertyValue#getPropertysetValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue getPropertysetValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySet PropertyValue.getPropertysetValue()"})
  void testPayload_PropertyValueGetPropertysetValue() {
    // Arrange and Act
    PropertySet actualPropertysetValue = PropertyValue.getDefaultInstance().getPropertysetValue();

    // Assert
    assertEquals("", actualPropertysetValue.getInitializationErrorString());
    assertEquals(0, actualPropertysetValue.getKeysCount());
    assertEquals(0, actualPropertysetValue.getSerializedSize());
    assertEquals(0, actualPropertysetValue.getValuesCount());
    assertFalse(actualPropertysetValue.hasExtensions());
    assertTrue(actualPropertysetValue.findInitializationErrors().isEmpty());
    assertTrue(actualPropertysetValue.getKeysList().isEmpty());
    List<PropertyValue> valuesList = actualPropertysetValue.getValuesList();
    assertTrue(valuesList.isEmpty());
    assertTrue(actualPropertysetValue.getAllFields().isEmpty());
    assertTrue(actualPropertysetValue.isInitialized());
    assertSame(valuesList, actualPropertysetValue.getValuesOrBuilderList());
    assertSame(actualPropertysetValue, actualPropertysetValue.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#getPropertysetsValue()}.
   * <p>
   * Method under test: {@link PropertyValue#getPropertysetsValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue getPropertysetsValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertySetList PropertyValue.getPropertysetsValue()"})
  void testPayload_PropertyValueGetPropertysetsValue() {
    // Arrange and Act
    PropertySetList actualPropertysetsValue = PropertyValue.getDefaultInstance().getPropertysetsValue();

    // Assert
    assertEquals("", actualPropertysetsValue.getInitializationErrorString());
    assertEquals(0, actualPropertysetsValue.getPropertysetCount());
    assertEquals(0, actualPropertysetsValue.getSerializedSize());
    assertFalse(actualPropertysetsValue.hasExtensions());
    assertTrue(actualPropertysetsValue.findInitializationErrors().isEmpty());
    List<PropertySet> propertysetList = actualPropertysetsValue.getPropertysetList();
    assertTrue(propertysetList.isEmpty());
    assertTrue(actualPropertysetsValue.getAllFields().isEmpty());
    assertTrue(actualPropertysetsValue.isInitialized());
    assertSame(propertysetList, actualPropertysetsValue.getPropertysetOrBuilderList());
    assertSame(actualPropertysetsValue, actualPropertysetsValue.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#getSerializedSize()}.
   * <p>
   * Method under test: {@link PropertyValue#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PropertyValue.getSerializedSize()"})
  void testPayload_PropertyValueGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, PropertyValue.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#getStringValue()}.
   * <p>
   * Method under test: {@link PropertyValue#getStringValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue getStringValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PropertyValue.getStringValue()"})
  void testPayload_PropertyValueGetStringValue() {
    // Arrange, Act and Assert
    assertEquals("", PropertyValue.getDefaultInstance().getStringValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#getStringValueBytes()}.
   * <p>
   * Method under test: {@link PropertyValue#getStringValueBytes()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue getStringValueBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString PropertyValue.getStringValueBytes()"})
  void testPayload_PropertyValueGetStringValueBytes() {
    // Arrange
    PropertyValue defaultInstance = PropertyValue.getDefaultInstance();

    // Act
    ByteString actualStringValueBytes = defaultInstance.getStringValueBytes();

    // Assert
    ByteString byteString = actualStringValueBytes.EMPTY;
    Any extensions = defaultInstance.getExtensionValue().getExtensions();
    assertEquals(byteString, extensions.getTypeUrlBytes());
    assertEquals(byteString, actualStringValueBytes);
    assertSame(byteString, extensions.getValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#getValueCase()}.
   * <p>
   * Method under test: {@link PropertyValue#getValueCase()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue getValueCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.getValueCase()"})
  void testPayload_PropertyValueGetValueCase() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, PropertyValue.getDefaultInstance().getValueCase());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#hasBooleanValue()}.
   * <p>
   * Method under test: {@link PropertyValue#hasBooleanValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue hasBooleanValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.hasBooleanValue()"})
  void testPayload_PropertyValueHasBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(PropertyValue.getDefaultInstance().hasBooleanValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#hasDoubleValue()}.
   * <p>
   * Method under test: {@link PropertyValue#hasDoubleValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue hasDoubleValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.hasDoubleValue()"})
  void testPayload_PropertyValueHasDoubleValue() {
    // Arrange, Act and Assert
    assertFalse(PropertyValue.getDefaultInstance().hasDoubleValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#hasExtensionValue()}.
   * <p>
   * Method under test: {@link PropertyValue#hasExtensionValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue hasExtensionValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.hasExtensionValue()"})
  void testPayload_PropertyValueHasExtensionValue() {
    // Arrange, Act and Assert
    assertFalse(PropertyValue.getDefaultInstance().hasExtensionValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#hasFloatValue()}.
   * <p>
   * Method under test: {@link PropertyValue#hasFloatValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue hasFloatValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.hasFloatValue()"})
  void testPayload_PropertyValueHasFloatValue() {
    // Arrange, Act and Assert
    assertFalse(PropertyValue.getDefaultInstance().hasFloatValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#hasIntValue()}.
   * <p>
   * Method under test: {@link PropertyValue#hasIntValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue hasIntValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.hasIntValue()"})
  void testPayload_PropertyValueHasIntValue() {
    // Arrange, Act and Assert
    assertFalse(PropertyValue.getDefaultInstance().hasIntValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#hasIsNull()}.
   * <p>
   * Method under test: {@link PropertyValue#hasIsNull()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue hasIsNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.hasIsNull()"})
  void testPayload_PropertyValueHasIsNull() {
    // Arrange, Act and Assert
    assertFalse(PropertyValue.getDefaultInstance().hasIsNull());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#hasLongValue()}.
   * <p>
   * Method under test: {@link PropertyValue#hasLongValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue hasLongValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.hasLongValue()"})
  void testPayload_PropertyValueHasLongValue() {
    // Arrange, Act and Assert
    assertFalse(PropertyValue.getDefaultInstance().hasLongValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#hasPropertysetValue()}.
   * <p>
   * Method under test: {@link PropertyValue#hasPropertysetValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue hasPropertysetValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.hasPropertysetValue()"})
  void testPayload_PropertyValueHasPropertysetValue() {
    // Arrange, Act and Assert
    assertFalse(PropertyValue.getDefaultInstance().hasPropertysetValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#hasPropertysetsValue()}.
   * <p>
   * Method under test: {@link PropertyValue#hasPropertysetsValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue hasPropertysetsValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.hasPropertysetsValue()"})
  void testPayload_PropertyValueHasPropertysetsValue() {
    // Arrange, Act and Assert
    assertFalse(PropertyValue.getDefaultInstance().hasPropertysetsValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#hasStringValue()}.
   * <p>
   * Method under test: {@link PropertyValue#hasStringValue()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue hasStringValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.hasStringValue()"})
  void testPayload_PropertyValueHasStringValue() {
    // Arrange, Act and Assert
    assertFalse(PropertyValue.getDefaultInstance().hasStringValue());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#hasType()}.
   * <p>
   * Method under test: {@link PropertyValue#hasType()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue hasType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.hasType()"})
  void testPayload_PropertyValueHasType() {
    // Arrange, Act and Assert
    assertFalse(PropertyValue.getDefaultInstance().hasType());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#isInitialized()}.
   * <p>
   * Method under test: {@link PropertyValue#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValue.isInitialized()"})
  void testPayload_PropertyValueIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(PropertyValue.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PropertyValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertyValueParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PropertyValue actualParseDelimitedFromResult = PropertyValue.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getStringValue());
    assertEquals(0, actualParseDelimitedFromResult.getIntValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getType());
    assertEquals(0.0d, actualParseDelimitedFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseDelimitedFromResult.getFloatValue());
    assertEquals(0L, actualParseDelimitedFromResult.getLongValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, actualParseDelimitedFromResult.getValueCase());
    assertFalse(actualParseDelimitedFromResult.getBooleanValue());
    assertFalse(actualParseDelimitedFromResult.getIsNull());
    assertFalse(actualParseDelimitedFromResult.hasBooleanValue());
    assertFalse(actualParseDelimitedFromResult.hasDoubleValue());
    assertFalse(actualParseDelimitedFromResult.hasExtensionValue());
    assertFalse(actualParseDelimitedFromResult.hasFloatValue());
    assertFalse(actualParseDelimitedFromResult.hasIntValue());
    assertFalse(actualParseDelimitedFromResult.hasIsNull());
    assertFalse(actualParseDelimitedFromResult.hasLongValue());
    assertFalse(actualParseDelimitedFromResult.hasPropertysetValue());
    assertFalse(actualParseDelimitedFromResult.hasPropertysetsValue());
    assertFalse(actualParseDelimitedFromResult.hasStringValue());
    assertFalse(actualParseDelimitedFromResult.hasType());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PropertyValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertyValueParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PropertyValue.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PropertyValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertyValueParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PropertyValue.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertyValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValueParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PropertyValue actualParseDelimitedFromResult = PropertyValue.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getStringValue());
    assertEquals(0, actualParseDelimitedFromResult.getIntValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getType());
    assertEquals(0.0d, actualParseDelimitedFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseDelimitedFromResult.getFloatValue());
    assertEquals(0L, actualParseDelimitedFromResult.getLongValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, actualParseDelimitedFromResult.getValueCase());
    assertFalse(actualParseDelimitedFromResult.getBooleanValue());
    assertFalse(actualParseDelimitedFromResult.getIsNull());
    assertFalse(actualParseDelimitedFromResult.hasBooleanValue());
    assertFalse(actualParseDelimitedFromResult.hasDoubleValue());
    assertFalse(actualParseDelimitedFromResult.hasExtensionValue());
    assertFalse(actualParseDelimitedFromResult.hasFloatValue());
    assertFalse(actualParseDelimitedFromResult.hasIntValue());
    assertFalse(actualParseDelimitedFromResult.hasIsNull());
    assertFalse(actualParseDelimitedFromResult.hasLongValue());
    assertFalse(actualParseDelimitedFromResult.hasPropertysetValue());
    assertFalse(actualParseDelimitedFromResult.hasPropertysetsValue());
    assertFalse(actualParseDelimitedFromResult.hasStringValue());
    assertFalse(actualParseDelimitedFromResult.hasType());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertyValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValueParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PropertyValue.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertyValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValueParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> PropertyValue.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertyValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValueParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PropertyValue.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertyValue#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValueParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PropertyValue.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertyValueParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PropertyValue.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertyValueParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> PropertyValue.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(byte[])"})
  void testPayload_PropertyValueParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    PropertyValue actualParseFromResult = PropertyValue.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasPropertysetValue());
    assertFalse(actualParseFromResult.hasPropertysetsValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(ByteBuffer)"})
  void testPayload_PropertyValueParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    PropertyValue actualParseFromResult = PropertyValue.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasPropertysetValue());
    assertFalse(actualParseFromResult.hasPropertysetsValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayload_PropertyValueParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    PropertyValue actualParseFromResult = PropertyValue.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasPropertysetValue());
    assertFalse(actualParseFromResult.hasPropertysetsValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayload_PropertyValueParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    PropertyValue actualParseFromResult = PropertyValue.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasPropertysetValue());
    assertFalse(actualParseFromResult.hasPropertysetsValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(ByteString)"})
  void testPayload_PropertyValueParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    PropertyValue actualParseFromResult = PropertyValue.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasPropertysetValue());
    assertFalse(actualParseFromResult.hasPropertysetsValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedStringValueBytes = data.EMPTY;
    assertEquals(expectedStringValueBytes, actualParseFromResult.getStringValueBytes());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testPayload_PropertyValueParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    PropertyValue actualParseFromResult = PropertyValue.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasPropertysetValue());
    assertFalse(actualParseFromResult.hasPropertysetsValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedStringValueBytes = data.EMPTY;
    assertEquals(expectedStringValueBytes, actualParseFromResult.getStringValueBytes());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(CodedInputStream)"})
  void testPayload_PropertyValueParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    PropertyValue actualParseFromResult = PropertyValue.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasPropertysetValue());
    assertFalse(actualParseFromResult.hasPropertysetsValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValueParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    PropertyValue actualParseFromResult = PropertyValue.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasPropertysetValue());
    assertFalse(actualParseFromResult.hasPropertysetsValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(InputStream)"})
  void testPayload_PropertyValueParseFromWithInputStream() throws IOException {
    // Arrange and Act
    PropertyValue actualParseFromResult = PropertyValue.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(InputStream)"})
  void testPayload_PropertyValueParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PropertyValue.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValueParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    PropertyValue actualParseFromResult = PropertyValue.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.getIsNull());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasIsNull());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasPropertysetValue());
    assertFalse(actualParseFromResult.hasPropertysetsValue());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValueParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PropertyValue.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValueParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PropertyValue.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(InputStream)"})
  void testPayload_PropertyValueParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PropertyValue.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertyValue {@link PropertyValue#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue PropertyValue.parseFrom(InputStream)"})
  void testPayload_PropertyValueParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    PropertyValue actualParseFromResult = PropertyValue.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#equals(Object)}, and {@link PropertyValueExtension#hashCode()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertyValueExtension#equals(Object)}
   *   <li>{@link PropertyValueExtension#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension equals(Object), and hashCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValueExtension.equals(Object)", "int PropertyValueExtension.hashCode()"})
  void testPayload_PropertyValue_PropertyValueExtensionEqualsAndHashCode() {
    // Arrange
    PropertyValueExtension defaultInstance = PropertyValueExtension.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#equals(Object)}, and {@link PropertyValueExtension#hashCode()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PropertyValueExtension#equals(Object)}
   *   <li>{@link PropertyValueExtension#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension equals(Object), and hashCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValueExtension.equals(Object)", "int PropertyValueExtension.hashCode()"})
  void testPayload_PropertyValue_PropertyValueExtensionEqualsAndHashCode2() {
    // Arrange
    PropertyValueExtension defaultInstance = PropertyValueExtension.getDefaultInstance();
    PropertyValueExtension defaultInstance2 = PropertyValueExtension.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValueExtension#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValueExtension.equals(Object)", "int PropertyValueExtension.hashCode()"})
  void testPayload_PropertyValue_PropertyValueExtensionEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PropertyValueExtension.getDefaultInstance(), null);
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValueExtension#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValueExtension.equals(Object)", "int PropertyValueExtension.hashCode()"})
  void testPayload_PropertyValue_PropertyValueExtensionEquals_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(PropertyValueExtension.getDefaultInstance(), "Different type to PropertyValueExtension");
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValueExtension#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValueExtension.equals(Object)", "int PropertyValueExtension.hashCode()"})
  void testPayload_PropertyValue_PropertyValueExtensionEquals_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(PropertyValueExtension.getDefaultInstance(), 1);
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link PropertyValueExtension#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.getDefaultInstanceForType()"})
  void testPayload_PropertyValue_PropertyValueExtensionGetDefaultInstanceForType() {
    // Arrange
    PropertyValueExtension defaultInstance = PropertyValueExtension.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#getExtensions()}.
   * <p>
   * Method under test: {@link PropertyValueExtension#getExtensions()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension getExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Any PropertyValueExtension.getExtensions()"})
  void testPayload_PropertyValue_PropertyValueExtensionGetExtensions() {
    // Arrange and Act
    Any actualExtensions = PropertyValueExtension.getDefaultInstance().getExtensions();

    // Assert
    assertEquals("", actualExtensions.getInitializationErrorString());
    assertEquals("", actualExtensions.getTypeUrl());
    assertEquals(0, actualExtensions.getSerializedSize());
    assertTrue(actualExtensions.isInitialized());
    assertTrue(actualExtensions.findInitializationErrors().isEmpty());
    assertTrue(actualExtensions.getAllFields().isEmpty());
    assertSame(actualExtensions, actualExtensions.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#getSerializedSize()}.
   * <p>
   * Method under test: {@link PropertyValueExtension#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PropertyValueExtension.getSerializedSize()"})
  void testPayload_PropertyValue_PropertyValueExtensionGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, PropertyValueExtension.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#hasExtensions()}.
   * <p>
   * Method under test: {@link PropertyValueExtension#hasExtensions()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension hasExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValueExtension.hasExtensions()"})
  void testPayload_PropertyValue_PropertyValueExtensionHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(PropertyValueExtension.getDefaultInstance().hasExtensions());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#isInitialized()}.
   * <p>
   * Method under test: {@link PropertyValueExtension#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PropertyValueExtension.isInitialized()"})
  void testPayload_PropertyValue_PropertyValueExtensionIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(PropertyValueExtension.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PropertyValueExtension actualParseDelimitedFromResult = PropertyValueExtension.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    PropertyValueExtension defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, defaultInstanceForType.getExtensions());
    assertSame(extensions, defaultInstanceForType.getExtensionsOrBuilder());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PropertyValueExtension actualParseDelimitedFromResult = PropertyValueExtension.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PropertyValueExtension.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFromWithInput4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> PropertyValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFromWithInput5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PropertyValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PropertyValueExtension PropertyValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFromWithInputExtensionRegistry()
      throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PropertyValueExtension actualParseDelimitedFromResult = PropertyValueExtension.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    PropertyValueExtension defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, defaultInstanceForType.getExtensions());
    assertSame(extensions, defaultInstanceForType.getExtensionsOrBuilder());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PropertyValueExtension PropertyValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFromWithInputExtensionRegistry2()
      throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    PropertyValueExtension actualParseDelimitedFromResult = PropertyValueExtension.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PropertyValueExtension PropertyValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFromWithInputExtensionRegistry3()
      throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(PropertyValueExtension.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PropertyValueExtension PropertyValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFromWithInputExtensionRegistry4()
      throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> PropertyValueExtension.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PropertyValueExtension PropertyValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseDelimitedFromWithInputExtensionRegistry5()
      throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PropertyValueExtension.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseFrom(byte[])"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    PropertyValueExtension actualParseFromResult = PropertyValueExtension.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseFrom(ByteBuffer)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    PropertyValueExtension actualParseFromResult = PropertyValueExtension.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    PropertyValueExtension actualParseFromResult = PropertyValueExtension.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    PropertyValueExtension actualParseFromResult = PropertyValueExtension.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseFrom(ByteString)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    PropertyValueExtension actualParseFromResult = PropertyValueExtension.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithByteStringExtensionRegistryLite()
      throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    PropertyValueExtension actualParseFromResult = PropertyValueExtension.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseFrom(CodedInputStream)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    PropertyValueExtension actualParseFromResult = PropertyValueExtension.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PropertyValueExtension PropertyValueExtension.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithCodedInputStreamExtensionRegistryLite()
      throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    PropertyValueExtension actualParseFromResult = PropertyValueExtension.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseFrom(InputStream)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithInputStream() throws IOException {
    // Arrange and Act
    PropertyValueExtension actualParseFromResult = PropertyValueExtension
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseFrom(InputStream)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> PropertyValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseFrom(InputStream)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithInputStream3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> PropertyValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseFrom(InputStream)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithInputStream4() throws IOException {
    // Arrange and Act
    PropertyValueExtension actualParseFromResult = PropertyValueExtension.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithInputStreamExtensionRegistryLite()
      throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    PropertyValueExtension actualParseFromResult = PropertyValueExtension.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithInputStreamExtensionRegistryLite2()
      throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> PropertyValueExtension.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertyValue_PropertyValueExtension {@link PropertyValueExtension#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link PropertyValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_PropertyValueExtension parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValueExtension PropertyValueExtension.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_PropertyValue_PropertyValueExtensionParseFromWithInputStreamExtensionRegistryLite3()
      throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> PropertyValueExtension.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code EXTENSION_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase forNumber(int); then return 'EXTENSION_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_thenReturnExtensionValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.EXTENSION_VALUE,
        PropertyValue.ValueCase.forNumber(Metric.LONG_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code PROPERTYSET_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase forNumber(int); then return 'PROPERTYSET_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_thenReturnPropertysetValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.PROPERTYSET_VALUE,
        PropertyValue.ValueCase.forNumber(MetaData.EXTENSIONS_FIELD_NUMBER));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code PROPERTYSETS_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase forNumber(int); then return 'PROPERTYSETS_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_thenReturnPropertysetsValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.PROPERTYSETS_VALUE,
        PropertyValue.ValueCase.forNumber(Metric.INT_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code STRING_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase forNumber(int); when eight; then return 'STRING_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenEight_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.STRING_VALUE, PropertyValue.ValueCase.forNumber(8));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code FLOAT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase forNumber(int); when five; then return 'FLOAT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenFive_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.FLOAT_VALUE, PropertyValue.ValueCase.forNumber(5));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PropertyValue.ValueCase.forNumber(42));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code LONG_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase forNumber(int); when four; then return 'LONG_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenFour_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.LONG_VALUE, PropertyValue.ValueCase.forNumber(4));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code BOOLEAN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase forNumber(int); when seven; then return 'BOOLEAN_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenSeven_thenReturnBooleanValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.BOOLEAN_VALUE, PropertyValue.ValueCase.forNumber(7));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code DOUBLE_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase forNumber(int); when six; then return 'DOUBLE_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenSix_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.DOUBLE_VALUE, PropertyValue.ValueCase.forNumber(6));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code INT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase forNumber(int); when three; then return 'INT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenThree_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.INT_VALUE, PropertyValue.ValueCase.forNumber(3));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code VALUE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase forNumber(int); when zero; then return 'VALUE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.forNumber(int)"})
  void testPayload_PropertyValue_ValueCaseForNumber_whenZero_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, PropertyValue.ValueCase.forNumber(0));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#getNumber()}.
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#getNumber()}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PropertyValue.ValueCase.getNumber()"})
  void testPayload_PropertyValue_ValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(3, PropertyValue.ValueCase.valueOf("INT_VALUE").getNumber());
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code BOOLEAN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'BOOLEAN_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnBooleanValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.BOOLEAN_VALUE, PropertyValue.ValueCase.valueOf(7));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code DOUBLE_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'DOUBLE_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.DOUBLE_VALUE, PropertyValue.ValueCase.valueOf(6));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code EXTENSION_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'EXTENSION_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnExtensionValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.EXTENSION_VALUE,
        PropertyValue.ValueCase.valueOf(Metric.LONG_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code FLOAT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'FLOAT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.FLOAT_VALUE, PropertyValue.ValueCase.valueOf(5));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code PROPERTYSET_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'PROPERTYSET_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnPropertysetValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.PROPERTYSET_VALUE,
        PropertyValue.ValueCase.valueOf(MetaData.EXTENSIONS_FIELD_NUMBER));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code PROPERTYSETS_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'PROPERTYSETS_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnPropertysetsValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.PROPERTYSETS_VALUE,
        PropertyValue.ValueCase.valueOf(Metric.INT_VALUE_FIELD_NUMBER));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code STRING_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'STRING_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.STRING_VALUE, PropertyValue.ValueCase.valueOf(8));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code VALUE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; then return 'VALUE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.VALUE_NOT_SET, PropertyValue.ValueCase.valueOf(0));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PropertyValue.ValueCase.valueOf(42));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code LONG_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; when four; then return 'LONG_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_whenFour_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.LONG_VALUE, PropertyValue.ValueCase.valueOf(4));
  }

  /**
   * Test Payload_PropertyValue_ValueCase {@link PropertyValue.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code INT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PropertyValue.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_PropertyValue_ValueCase valueOf(int) with 'value'; when three; then return 'INT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PropertyValue.ValueCase PropertyValue.ValueCase.valueOf(int)"})
  void testPayload_PropertyValue_ValueCaseValueOfWithValue_whenThree_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(PropertyValue.ValueCase.INT_VALUE, PropertyValue.ValueCase.valueOf(3));
  }

  /**
   * Test Payload_Template {@link Template#equals(Object)}, and {@link Template#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Template#equals(Object)}
   *   <li>{@link Template#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_Template equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.equals(Object)", "int Template.hashCode()"})
  void testPayload_TemplateEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Template defaultInstance = Template.getDefaultInstance();
    Template defaultInstance2 = Template.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload_Template {@link Template#equals(Object)}, and {@link Template#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Template#equals(Object)}
   *   <li>{@link Template#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_Template equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.equals(Object)", "int Template.hashCode()"})
  void testPayload_TemplateEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Template defaultInstance = Template.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload_Template {@link Template#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Template equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.equals(Object)", "int Template.hashCode()"})
  void testPayload_TemplateEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Template.getDefaultInstance(), 1);
  }

  /**
   * Test Payload_Template {@link Template#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Template equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.equals(Object)", "int Template.hashCode()"})
  void testPayload_TemplateEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Template.getDefaultInstance(), null);
  }

  /**
   * Test Payload_Template {@link Template#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Template equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.equals(Object)", "int Template.hashCode()"})
  void testPayload_TemplateEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Template.getDefaultInstance(), "Different type to Template");
  }

  /**
   * Test Payload_Template {@link Template#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link Template#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload_Template getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.getDefaultInstanceForType()"})
  void testPayload_TemplateGetDefaultInstanceForType() {
    // Arrange
    Template defaultInstance = Template.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template {@link Template#getExtensions()}.
   * <p>
   * Method under test: {@link Template#getExtensions()}
   */
  @Test
  @DisplayName("Test Payload_Template getExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Any Template.getExtensions()"})
  void testPayload_TemplateGetExtensions() {
    // Arrange and Act
    Any actualExtensions = Template.getDefaultInstance().getExtensions();

    // Assert
    assertEquals("", actualExtensions.getInitializationErrorString());
    assertEquals("", actualExtensions.getTypeUrl());
    assertEquals(0, actualExtensions.getSerializedSize());
    assertTrue(actualExtensions.isInitialized());
    assertTrue(actualExtensions.findInitializationErrors().isEmpty());
    assertTrue(actualExtensions.getAllFields().isEmpty());
    assertSame(actualExtensions, actualExtensions.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template {@link Template#getMetricsCount()}.
   * <p>
   * Method under test: {@link Template#getMetricsCount()}
   */
  @Test
  @DisplayName("Test Payload_Template getMetricsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Template.getMetricsCount()"})
  void testPayload_TemplateGetMetricsCount() {
    // Arrange, Act and Assert
    assertEquals(0, Template.getDefaultInstance().getMetricsCount());
  }

  /**
   * Test Payload_Template {@link Template#getParametersCount()}.
   * <p>
   * Method under test: {@link Template#getParametersCount()}
   */
  @Test
  @DisplayName("Test Payload_Template getParametersCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Template.getParametersCount()"})
  void testPayload_TemplateGetParametersCount() {
    // Arrange, Act and Assert
    assertEquals(0, Template.getDefaultInstance().getParametersCount());
  }

  /**
   * Test Payload_Template {@link Template#getSerializedSize()}.
   * <p>
   * Method under test: {@link Template#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload_Template getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Template.getSerializedSize()"})
  void testPayload_TemplateGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Template.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload_Template {@link Template#getTemplateRef()}.
   * <p>
   * Method under test: {@link Template#getTemplateRef()}
   */
  @Test
  @DisplayName("Test Payload_Template getTemplateRef()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String Template.getTemplateRef()"})
  void testPayload_TemplateGetTemplateRef() {
    // Arrange, Act and Assert
    assertEquals("", Template.getDefaultInstance().getTemplateRef());
  }

  /**
   * Test Payload_Template {@link Template#getTemplateRefBytes()}.
   * <p>
   * Method under test: {@link Template#getTemplateRefBytes()}
   */
  @Test
  @DisplayName("Test Payload_Template getTemplateRefBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString Template.getTemplateRefBytes()"})
  void testPayload_TemplateGetTemplateRefBytes() {
    // Arrange
    Template defaultInstance = Template.getDefaultInstance();

    // Act
    ByteString actualTemplateRefBytes = defaultInstance.getTemplateRefBytes();

    // Assert
    ByteString byteString = actualTemplateRefBytes.EMPTY;
    Any extensions = defaultInstance.getExtensions();
    assertEquals(byteString, extensions.getTypeUrlBytes());
    assertEquals(byteString, actualTemplateRefBytes);
    assertEquals(byteString, defaultInstance.getVersionBytes());
    assertSame(byteString, extensions.getValue());
  }

  /**
   * Test Payload_Template {@link Template#getVersion()}.
   * <p>
   * Method under test: {@link Template#getVersion()}
   */
  @Test
  @DisplayName("Test Payload_Template getVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String Template.getVersion()"})
  void testPayload_TemplateGetVersion() {
    // Arrange, Act and Assert
    assertEquals("", Template.getDefaultInstance().getVersion());
  }

  /**
   * Test Payload_Template {@link Template#getVersionBytes()}.
   * <p>
   * Method under test: {@link Template#getVersionBytes()}
   */
  @Test
  @DisplayName("Test Payload_Template getVersionBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString Template.getVersionBytes()"})
  void testPayload_TemplateGetVersionBytes() {
    // Arrange
    Template defaultInstance = Template.getDefaultInstance();

    // Act
    ByteString actualVersionBytes = defaultInstance.getVersionBytes();

    // Assert
    ByteString byteString = actualVersionBytes.EMPTY;
    Any extensions = defaultInstance.getExtensions();
    assertEquals(byteString, extensions.getTypeUrlBytes());
    assertEquals(byteString, defaultInstance.getTemplateRefBytes());
    assertEquals(byteString, actualVersionBytes);
    assertSame(byteString, extensions.getValue());
  }

  /**
   * Test Payload_Template {@link Template#hasExtensions()}.
   * <p>
   * Method under test: {@link Template#hasExtensions()}
   */
  @Test
  @DisplayName("Test Payload_Template hasExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.hasExtensions()"})
  void testPayload_TemplateHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(Template.getDefaultInstance().hasExtensions());
  }

  /**
   * Test Payload_Template {@link Template#hasIsDefinition()}.
   * <p>
   * Method under test: {@link Template#hasIsDefinition()}
   */
  @Test
  @DisplayName("Test Payload_Template hasIsDefinition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.hasIsDefinition()"})
  void testPayload_TemplateHasIsDefinition() {
    // Arrange, Act and Assert
    assertFalse(Template.getDefaultInstance().hasIsDefinition());
  }

  /**
   * Test Payload_Template {@link Template#hasTemplateRef()}.
   * <p>
   * Method under test: {@link Template#hasTemplateRef()}
   */
  @Test
  @DisplayName("Test Payload_Template hasTemplateRef()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.hasTemplateRef()"})
  void testPayload_TemplateHasTemplateRef() {
    // Arrange, Act and Assert
    assertFalse(Template.getDefaultInstance().hasTemplateRef());
  }

  /**
   * Test Payload_Template {@link Template#hasVersion()}.
   * <p>
   * Method under test: {@link Template#hasVersion()}
   */
  @Test
  @DisplayName("Test Payload_Template hasVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.hasVersion()"})
  void testPayload_TemplateHasVersion() {
    // Arrange, Act and Assert
    assertFalse(Template.getDefaultInstance().hasVersion());
  }

  /**
   * Test Payload_Template {@link Template#isInitialized()}.
   * <p>
   * Method under test: {@link Template#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload_Template isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.isInitialized()"})
  void testPayload_TemplateIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Template.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload_Template {@link Template#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link Template#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseDelimitedFrom(InputStream)"})
  void testPayload_TemplateParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Template.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template {@link Template#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link Template#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseDelimitedFrom(InputStream)"})
  void testPayload_TemplateParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Template.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template {@link Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_TemplateParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, Template.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Template {@link Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_TemplateParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Template actualParseDelimitedFromResult = Template.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Template {@link Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_TemplateParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Template.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template {@link Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_TemplateParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Template.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template {@link Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_TemplateParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Template.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template {@link Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_TemplateParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Template.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_Template {@link Template#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseDelimitedFrom(InputStream)"})
  void testPayload_TemplateParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Template.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_Template {@link Template#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseDelimitedFrom(InputStream)"})
  void testPayload_TemplateParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, Template.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Template {@link Template#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseDelimitedFrom(InputStream)"})
  void testPayload_TemplateParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Template actualParseDelimitedFromResult = Template.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Template {@link Template#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseDelimitedFrom(InputStream)"})
  void testPayload_TemplateParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Template.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template {@link Template#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link Template#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload_Template parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseFrom(byte[])"})
  void testPayload_TemplateParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    Template actualParseFromResult = Template.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTemplateRef());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getMetricsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getIsDefinition());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasIsDefinition());
    assertFalse(actualParseFromResult.hasTemplateRef());
    assertFalse(actualParseFromResult.hasVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Metric> metricsList = actualParseFromResult.getMetricsList();
    assertTrue(metricsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(metricsList, actualParseFromResult.getMetricsOrBuilderList());
    assertSame(metricsList, actualParseFromResult.getParametersList());
    assertSame(metricsList, actualParseFromResult.getParametersOrBuilderList());
  }

  /**
   * Test Payload_Template {@link Template#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link Template#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload_Template parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseFrom(ByteBuffer)"})
  void testPayload_TemplateParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    Template actualParseFromResult = Template.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTemplateRef());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getMetricsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getIsDefinition());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasIsDefinition());
    assertFalse(actualParseFromResult.hasTemplateRef());
    assertFalse(actualParseFromResult.hasVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Metric> metricsList = actualParseFromResult.getMetricsList();
    assertTrue(metricsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(metricsList, actualParseFromResult.getMetricsOrBuilderList());
    assertSame(metricsList, actualParseFromResult.getParametersList());
    assertSame(metricsList, actualParseFromResult.getParametersOrBuilderList());
  }

  /**
   * Test Payload_Template {@link Template#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Template#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayload_TemplateParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Template actualParseFromResult = Template.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTemplateRef());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getMetricsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getIsDefinition());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasIsDefinition());
    assertFalse(actualParseFromResult.hasTemplateRef());
    assertFalse(actualParseFromResult.hasVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Metric> metricsList = actualParseFromResult.getMetricsList();
    assertTrue(metricsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(metricsList, actualParseFromResult.getMetricsOrBuilderList());
    assertSame(metricsList, actualParseFromResult.getParametersList());
    assertSame(metricsList, actualParseFromResult.getParametersOrBuilderList());
  }

  /**
   * Test Payload_Template {@link Template#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Template#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayload_TemplateParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    Template actualParseFromResult = Template.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTemplateRef());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getMetricsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getIsDefinition());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasIsDefinition());
    assertFalse(actualParseFromResult.hasTemplateRef());
    assertFalse(actualParseFromResult.hasVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Metric> metricsList = actualParseFromResult.getMetricsList();
    assertTrue(metricsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(metricsList, actualParseFromResult.getMetricsOrBuilderList());
    assertSame(metricsList, actualParseFromResult.getParametersList());
    assertSame(metricsList, actualParseFromResult.getParametersOrBuilderList());
  }

  /**
   * Test Payload_Template {@link Template#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link Template#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseFrom(InputStream)"})
  void testPayload_TemplateParseFromWithInputStream() throws IOException {
    // Arrange and Act
    Template actualParseFromResult = Template.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_Template {@link Template#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link Template#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseFrom(InputStream)"})
  void testPayload_TemplateParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Template.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Template {@link Template#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Template#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_TemplateParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Template actualParseFromResult = Template.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getTemplateRef());
    assertEquals("", actualParseFromResult.getVersion());
    assertEquals(0, actualParseFromResult.getMetricsCount());
    assertEquals(0, actualParseFromResult.getParametersCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.getIsDefinition());
    assertFalse(actualParseFromResult.hasExtensions());
    assertFalse(actualParseFromResult.hasIsDefinition());
    assertFalse(actualParseFromResult.hasTemplateRef());
    assertFalse(actualParseFromResult.hasVersion());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<Metric> metricsList = actualParseFromResult.getMetricsList();
    assertTrue(metricsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(metricsList, actualParseFromResult.getMetricsOrBuilderList());
    assertSame(metricsList, actualParseFromResult.getParametersList());
    assertSame(metricsList, actualParseFromResult.getParametersOrBuilderList());
  }

  /**
   * Test Payload_Template {@link Template#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Template#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_TemplateParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Template.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Template {@link Template#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Template#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_TemplateParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Template.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Template {@link Template#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseFrom(InputStream)"})
  void testPayload_TemplateParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Template.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Template {@link Template#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template Template.parseFrom(InputStream)"})
  void testPayload_TemplateParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    Template actualParseFromResult = Template.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#equals(Object)}, and {@link Template.Parameter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Template.Parameter#equals(Object)}
   *   <li>{@link Template.Parameter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.equals(Object)", "int Template.Parameter.hashCode()"})
  void testPayload_Template_ParameterEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Parameter defaultInstance = Parameter.getDefaultInstance();
    Parameter defaultInstance2 = Parameter.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#equals(Object)}, and {@link Template.Parameter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Template.Parameter#equals(Object)}
   *   <li>{@link Template.Parameter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.equals(Object)", "int Template.Parameter.hashCode()"})
  void testPayload_Template_ParameterEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Parameter defaultInstance = Parameter.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.equals(Object)", "int Template.Parameter.hashCode()"})
  void testPayload_Template_ParameterEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Parameter.getDefaultInstance(), 1);
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.equals(Object)", "int Template.Parameter.hashCode()"})
  void testPayload_Template_ParameterEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Parameter.getDefaultInstance(), null);
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.equals(Object)", "int Template.Parameter.hashCode()"})
  void testPayload_Template_ParameterEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Parameter.getDefaultInstance(), "Different type to Parameter");
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#getBooleanValue()}.
   * <p>
   * Method under test: {@link Template.Parameter#getBooleanValue()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter getBooleanValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.getBooleanValue()"})
  void testPayload_Template_ParameterGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(Parameter.getDefaultInstance().getBooleanValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link Template.Parameter#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.getDefaultInstanceForType()"})
  void testPayload_Template_ParameterGetDefaultInstanceForType() {
    // Arrange
    Parameter defaultInstance = Parameter.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#getDoubleValue()}.
   * <p>
   * Method under test: {@link Template.Parameter#getDoubleValue()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter getDoubleValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Template.Parameter.getDoubleValue()"})
  void testPayload_Template_ParameterGetDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(0.0d, Parameter.getDefaultInstance().getDoubleValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#getExtensionValue()}.
   * <p>
   * Method under test: {@link Template.Parameter#getExtensionValue()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter getExtensionValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension Template.Parameter.getExtensionValue()"})
  void testPayload_Template_ParameterGetExtensionValue() {
    // Arrange and Act
    ParameterValueExtension actualExtensionValue = Parameter.getDefaultInstance().getExtensionValue();

    // Assert
    assertEquals("", actualExtensionValue.getInitializationErrorString());
    assertEquals(0, actualExtensionValue.getSerializedSize());
    assertFalse(actualExtensionValue.hasExtensions());
    assertTrue(actualExtensionValue.findInitializationErrors().isEmpty());
    assertTrue(actualExtensionValue.getAllFields().isEmpty());
    assertTrue(actualExtensionValue.isInitialized());
    assertSame(actualExtensionValue, actualExtensionValue.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#getFloatValue()}.
   * <p>
   * Method under test: {@link Template.Parameter#getFloatValue()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter getFloatValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float Template.Parameter.getFloatValue()"})
  void testPayload_Template_ParameterGetFloatValue() {
    // Arrange, Act and Assert
    assertEquals(0.0f, Parameter.getDefaultInstance().getFloatValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#getIntValue()}.
   * <p>
   * Method under test: {@link Template.Parameter#getIntValue()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter getIntValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Template.Parameter.getIntValue()"})
  void testPayload_Template_ParameterGetIntValue() {
    // Arrange, Act and Assert
    assertEquals(0, Parameter.getDefaultInstance().getIntValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#getLongValue()}.
   * <p>
   * Method under test: {@link Template.Parameter#getLongValue()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter getLongValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Template.Parameter.getLongValue()"})
  void testPayload_Template_ParameterGetLongValue() {
    // Arrange, Act and Assert
    assertEquals(0L, Parameter.getDefaultInstance().getLongValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#getName()}.
   * <p>
   * Method under test: {@link Template.Parameter#getName()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String Template.Parameter.getName()"})
  void testPayload_Template_ParameterGetName() {
    // Arrange, Act and Assert
    assertEquals("", Parameter.getDefaultInstance().getName());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#getNameBytes()}.
   * <p>
   * Method under test: {@link Template.Parameter#getNameBytes()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter getNameBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString Template.Parameter.getNameBytes()"})
  void testPayload_Template_ParameterGetNameBytes() {
    // Arrange
    Parameter defaultInstance = Parameter.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    Any extensions = defaultInstance.getExtensionValue().getExtensions();
    assertEquals(byteString, extensions.getTypeUrlBytes());
    assertEquals(byteString, actualNameBytes);
    assertEquals(byteString, defaultInstance.getStringValueBytes());
    assertSame(byteString, extensions.getValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#getSerializedSize()}.
   * <p>
   * Method under test: {@link Template.Parameter#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Template.Parameter.getSerializedSize()"})
  void testPayload_Template_ParameterGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, Parameter.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#getStringValue()}.
   * <p>
   * Method under test: {@link Template.Parameter#getStringValue()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter getStringValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String Template.Parameter.getStringValue()"})
  void testPayload_Template_ParameterGetStringValue() {
    // Arrange, Act and Assert
    assertEquals("", Parameter.getDefaultInstance().getStringValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#getStringValueBytes()}.
   * <p>
   * Method under test: {@link Template.Parameter#getStringValueBytes()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter getStringValueBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString Template.Parameter.getStringValueBytes()"})
  void testPayload_Template_ParameterGetStringValueBytes() {
    // Arrange
    Parameter defaultInstance = Parameter.getDefaultInstance();

    // Act
    ByteString actualStringValueBytes = defaultInstance.getStringValueBytes();

    // Assert
    ByteString byteString = actualStringValueBytes.EMPTY;
    Any extensions = defaultInstance.getExtensionValue().getExtensions();
    assertEquals(byteString, extensions.getTypeUrlBytes());
    assertEquals(byteString, defaultInstance.getNameBytes());
    assertEquals(byteString, actualStringValueBytes);
    assertSame(byteString, extensions.getValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#getValueCase()}.
   * <p>
   * Method under test: {@link Template.Parameter#getValueCase()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter getValueCase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.getValueCase()"})
  void testPayload_Template_ParameterGetValueCase() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, Parameter.getDefaultInstance().getValueCase());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#hasBooleanValue()}.
   * <p>
   * Method under test: {@link Template.Parameter#hasBooleanValue()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter hasBooleanValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.hasBooleanValue()"})
  void testPayload_Template_ParameterHasBooleanValue() {
    // Arrange, Act and Assert
    assertFalse(Parameter.getDefaultInstance().hasBooleanValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#hasDoubleValue()}.
   * <p>
   * Method under test: {@link Template.Parameter#hasDoubleValue()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter hasDoubleValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.hasDoubleValue()"})
  void testPayload_Template_ParameterHasDoubleValue() {
    // Arrange, Act and Assert
    assertFalse(Parameter.getDefaultInstance().hasDoubleValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#hasExtensionValue()}.
   * <p>
   * Method under test: {@link Template.Parameter#hasExtensionValue()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter hasExtensionValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.hasExtensionValue()"})
  void testPayload_Template_ParameterHasExtensionValue() {
    // Arrange, Act and Assert
    assertFalse(Parameter.getDefaultInstance().hasExtensionValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#hasFloatValue()}.
   * <p>
   * Method under test: {@link Template.Parameter#hasFloatValue()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter hasFloatValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.hasFloatValue()"})
  void testPayload_Template_ParameterHasFloatValue() {
    // Arrange, Act and Assert
    assertFalse(Parameter.getDefaultInstance().hasFloatValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#hasIntValue()}.
   * <p>
   * Method under test: {@link Template.Parameter#hasIntValue()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter hasIntValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.hasIntValue()"})
  void testPayload_Template_ParameterHasIntValue() {
    // Arrange, Act and Assert
    assertFalse(Parameter.getDefaultInstance().hasIntValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#hasLongValue()}.
   * <p>
   * Method under test: {@link Template.Parameter#hasLongValue()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter hasLongValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.hasLongValue()"})
  void testPayload_Template_ParameterHasLongValue() {
    // Arrange, Act and Assert
    assertFalse(Parameter.getDefaultInstance().hasLongValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#hasName()}.
   * <p>
   * Method under test: {@link Template.Parameter#hasName()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter hasName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.hasName()"})
  void testPayload_Template_ParameterHasName() {
    // Arrange, Act and Assert
    assertFalse(Parameter.getDefaultInstance().hasName());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#hasStringValue()}.
   * <p>
   * Method under test: {@link Template.Parameter#hasStringValue()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter hasStringValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.hasStringValue()"})
  void testPayload_Template_ParameterHasStringValue() {
    // Arrange, Act and Assert
    assertFalse(Parameter.getDefaultInstance().hasStringValue());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#hasType()}.
   * <p>
   * Method under test: {@link Template.Parameter#hasType()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter hasType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.hasType()"})
  void testPayload_Template_ParameterHasType() {
    // Arrange, Act and Assert
    assertFalse(Parameter.getDefaultInstance().hasType());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#isInitialized()}.
   * <p>
   * Method under test: {@link Template.Parameter#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Template.Parameter.isInitialized()"})
  void testPayload_Template_ParameterIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(Parameter.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link Template.Parameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseDelimitedFrom(InputStream)"})
  void testPayload_Template_ParameterParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Parameter actualParseDelimitedFromResult = Parameter.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getName());
    assertEquals("", actualParseDelimitedFromResult.getStringValue());
    assertEquals(0, actualParseDelimitedFromResult.getIntValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getType());
    assertEquals(0.0d, actualParseDelimitedFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseDelimitedFromResult.getFloatValue());
    assertEquals(0L, actualParseDelimitedFromResult.getLongValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, actualParseDelimitedFromResult.getValueCase());
    assertFalse(actualParseDelimitedFromResult.getBooleanValue());
    assertFalse(actualParseDelimitedFromResult.hasBooleanValue());
    assertFalse(actualParseDelimitedFromResult.hasDoubleValue());
    assertFalse(actualParseDelimitedFromResult.hasExtensionValue());
    assertFalse(actualParseDelimitedFromResult.hasFloatValue());
    assertFalse(actualParseDelimitedFromResult.hasIntValue());
    assertFalse(actualParseDelimitedFromResult.hasLongValue());
    assertFalse(actualParseDelimitedFromResult.hasName());
    assertFalse(actualParseDelimitedFromResult.hasStringValue());
    assertFalse(actualParseDelimitedFromResult.hasType());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link Template.Parameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseDelimitedFrom(InputStream)"})
  void testPayload_Template_ParameterParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Parameter.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link Template.Parameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseDelimitedFrom(InputStream)"})
  void testPayload_Template_ParameterParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Parameter.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Template.Parameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_ParameterParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    Parameter actualParseDelimitedFromResult = Parameter.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getName());
    assertEquals("", actualParseDelimitedFromResult.getStringValue());
    assertEquals(0, actualParseDelimitedFromResult.getIntValue());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getType());
    assertEquals(0.0d, actualParseDelimitedFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseDelimitedFromResult.getFloatValue());
    assertEquals(0L, actualParseDelimitedFromResult.getLongValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, actualParseDelimitedFromResult.getValueCase());
    assertFalse(actualParseDelimitedFromResult.getBooleanValue());
    assertFalse(actualParseDelimitedFromResult.hasBooleanValue());
    assertFalse(actualParseDelimitedFromResult.hasDoubleValue());
    assertFalse(actualParseDelimitedFromResult.hasExtensionValue());
    assertFalse(actualParseDelimitedFromResult.hasFloatValue());
    assertFalse(actualParseDelimitedFromResult.hasIntValue());
    assertFalse(actualParseDelimitedFromResult.hasLongValue());
    assertFalse(actualParseDelimitedFromResult.hasName());
    assertFalse(actualParseDelimitedFromResult.hasStringValue());
    assertFalse(actualParseDelimitedFromResult.hasType());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Template.Parameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_ParameterParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Parameter.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Template.Parameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_ParameterParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> Parameter.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Template.Parameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_ParameterParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Parameter.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link Template.Parameter#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_ParameterParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Parameter.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseDelimitedFrom(InputStream)"})
  void testPayload_Template_ParameterParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(Parameter.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseDelimitedFrom(InputStream)"})
  void testPayload_Template_ParameterParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> Parameter.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(byte[])"})
  void testPayload_Template_ParameterParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    Parameter actualParseFromResult = Parameter.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(ByteBuffer)"})
  void testPayload_Template_ParameterParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    Parameter actualParseFromResult = Parameter.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayload_Template_ParameterParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    Parameter actualParseFromResult = Parameter.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayload_Template_ParameterParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    Parameter actualParseFromResult = Parameter.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(ByteString)"})
  void testPayload_Template_ParameterParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Parameter actualParseFromResult = Parameter.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getNameBytes());
    assertEquals(byteString, actualParseFromResult.getStringValueBytes());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testPayload_Template_ParameterParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    Parameter actualParseFromResult = Parameter.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getNameBytes());
    assertEquals(byteString, actualParseFromResult.getStringValueBytes());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(CodedInputStream)"})
  void testPayload_Template_ParameterParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Parameter actualParseFromResult = Parameter.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testPayload_Template_ParameterParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    Parameter actualParseFromResult = Parameter.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(InputStream)"})
  void testPayload_Template_ParameterParseFromWithInputStream() throws IOException {
    // Arrange and Act
    Parameter actualParseFromResult = Parameter.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    ParameterValueExtension extensionValue = actualParseFromResult.getExtensionValue();
    assertSame(unknownFields, extensionValue.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensionValue, actualParseFromResult.getExtensionValueOrBuilder());
    assertSame(extensionValue, extensionValue.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(InputStream)"})
  void testPayload_Template_ParameterParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> Parameter.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_ParameterParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    Parameter actualParseFromResult = Parameter.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getName());
    assertEquals("", actualParseFromResult.getStringValue());
    assertEquals(0, actualParseFromResult.getIntValue());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getType());
    assertEquals(0.0d, actualParseFromResult.getDoubleValue());
    assertEquals(0.0f, actualParseFromResult.getFloatValue());
    assertEquals(0L, actualParseFromResult.getLongValue());
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, actualParseFromResult.getValueCase());
    assertFalse(actualParseFromResult.getBooleanValue());
    assertFalse(actualParseFromResult.hasBooleanValue());
    assertFalse(actualParseFromResult.hasDoubleValue());
    assertFalse(actualParseFromResult.hasExtensionValue());
    assertFalse(actualParseFromResult.hasFloatValue());
    assertFalse(actualParseFromResult.hasIntValue());
    assertFalse(actualParseFromResult.hasLongValue());
    assertFalse(actualParseFromResult.hasName());
    assertFalse(actualParseFromResult.hasStringValue());
    assertFalse(actualParseFromResult.hasType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_ParameterParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Parameter.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_ParameterParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> Parameter.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(InputStream)"})
  void testPayload_Template_ParameterParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> Parameter.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Template_Parameter {@link Template.Parameter#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter Template.Parameter.parseFrom(InputStream)"})
  void testPayload_Template_ParameterParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    Parameter actualParseFromResult = Parameter.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    ParameterValueExtension extensionValue = actualParseFromResult.getExtensionValue();
    assertSame(unknownFields, extensionValue.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensionValue, actualParseFromResult.getExtensionValueOrBuilder());
    assertSame(extensionValue, extensionValue.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#equals(Object)}, and {@link ParameterValueExtension#hashCode()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ParameterValueExtension#equals(Object)}
   *   <li>{@link ParameterValueExtension#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension equals(Object), and hashCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParameterValueExtension.equals(Object)", "int ParameterValueExtension.hashCode()"})
  void testPayload_Template_Parameter_ParameterValueExtensionEqualsAndHashCode() {
    // Arrange
    ParameterValueExtension defaultInstance = ParameterValueExtension.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#equals(Object)}, and {@link ParameterValueExtension#hashCode()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ParameterValueExtension#equals(Object)}
   *   <li>{@link ParameterValueExtension#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension equals(Object), and hashCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParameterValueExtension.equals(Object)", "int ParameterValueExtension.hashCode()"})
  void testPayload_Template_Parameter_ParameterValueExtensionEqualsAndHashCode2() {
    // Arrange
    ParameterValueExtension defaultInstance = ParameterValueExtension.getDefaultInstance();
    ParameterValueExtension defaultInstance2 = ParameterValueExtension.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParameterValueExtension#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParameterValueExtension.equals(Object)", "int ParameterValueExtension.hashCode()"})
  void testPayload_Template_Parameter_ParameterValueExtensionEquals_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ParameterValueExtension.getDefaultInstance(), null);
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParameterValueExtension#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParameterValueExtension.equals(Object)", "int ParameterValueExtension.hashCode()"})
  void testPayload_Template_Parameter_ParameterValueExtensionEquals_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(ParameterValueExtension.getDefaultInstance(), "Different type to ParameterValueExtension");
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#equals(Object)}.
   * <ul>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParameterValueExtension#equals(Object)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension equals(Object); then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParameterValueExtension.equals(Object)", "int ParameterValueExtension.hashCode()"})
  void testPayload_Template_Parameter_ParameterValueExtensionEquals_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(ParameterValueExtension.getDefaultInstance(), 1);
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ParameterValueExtension#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.getDefaultInstanceForType()"})
  void testPayload_Template_Parameter_ParameterValueExtensionGetDefaultInstanceForType() {
    // Arrange
    ParameterValueExtension defaultInstance = ParameterValueExtension.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#getExtensions()}.
   * <p>
   * Method under test: {@link ParameterValueExtension#getExtensions()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension getExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Any ParameterValueExtension.getExtensions()"})
  void testPayload_Template_Parameter_ParameterValueExtensionGetExtensions() {
    // Arrange and Act
    Any actualExtensions = ParameterValueExtension.getDefaultInstance().getExtensions();

    // Assert
    assertEquals("", actualExtensions.getInitializationErrorString());
    assertEquals("", actualExtensions.getTypeUrl());
    assertEquals(0, actualExtensions.getSerializedSize());
    assertTrue(actualExtensions.isInitialized());
    assertTrue(actualExtensions.findInitializationErrors().isEmpty());
    assertTrue(actualExtensions.getAllFields().isEmpty());
    assertSame(actualExtensions, actualExtensions.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#getSerializedSize()}.
   * <p>
   * Method under test: {@link ParameterValueExtension#getSerializedSize()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ParameterValueExtension.getSerializedSize()"})
  void testPayload_Template_Parameter_ParameterValueExtensionGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ParameterValueExtension.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#hasExtensions()}.
   * <p>
   * Method under test: {@link ParameterValueExtension#hasExtensions()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension hasExtensions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParameterValueExtension.hasExtensions()"})
  void testPayload_Template_Parameter_ParameterValueExtensionHasExtensions() {
    // Arrange, Act and Assert
    assertFalse(ParameterValueExtension.getDefaultInstance().hasExtensions());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#isInitialized()}.
   * <p>
   * Method under test: {@link ParameterValueExtension#isInitialized()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParameterValueExtension.isInitialized()"})
  void testPayload_Template_Parameter_ParameterValueExtensionIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ParameterValueExtension.getDefaultInstance().isInitialized());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ParameterValueExtension actualParseDelimitedFromResult = ParameterValueExtension.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    ParameterValueExtension defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, defaultInstanceForType.getExtensions());
    assertSame(extensions, defaultInstanceForType.getExtensionsOrBuilder());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ParameterValueExtension actualParseDelimitedFromResult = ParameterValueExtension.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ParameterValueExtension.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFromWithInput4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ParameterValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseDelimitedFrom(InputStream)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFromWithInput5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ParameterValueExtension.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ParameterValueExtension ParameterValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFromWithInputExtensionRegistry()
      throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ParameterValueExtension actualParseDelimitedFromResult = ParameterValueExtension.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    ParameterValueExtension defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, defaultInstanceForType.getExtensions());
    assertSame(extensions, defaultInstanceForType.getExtensionsOrBuilder());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ParameterValueExtension ParameterValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFromWithInputExtensionRegistry2()
      throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ParameterValueExtension actualParseDelimitedFromResult = ParameterValueExtension.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    Any extensions = actualParseDelimitedFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseDelimitedFromResult.getExtensionsOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ParameterValueExtension ParameterValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFromWithInputExtensionRegistry3()
      throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ParameterValueExtension.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ParameterValueExtension ParameterValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFromWithInputExtensionRegistry4()
      throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ParameterValueExtension.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ParameterValueExtension ParameterValueExtension.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseDelimitedFromWithInputExtensionRegistry5()
      throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ParameterValueExtension.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseFrom(byte[])"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ParameterValueExtension actualParseFromResult = ParameterValueExtension.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseFrom(ByteBuffer)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithByteBuffer()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ParameterValueExtension actualParseFromResult = ParameterValueExtension.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ParameterValueExtension actualParseFromResult = ParameterValueExtension.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseFrom(byte[], ExtensionRegistryLite)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithByteExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ParameterValueExtension actualParseFromResult = ParameterValueExtension.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseFrom(ByteString)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ParameterValueExtension actualParseFromResult = ParameterValueExtension.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithByteStringExtensionRegistryLite()
      throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ParameterValueExtension actualParseFromResult = ParameterValueExtension.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseFrom(CodedInputStream)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ParameterValueExtension actualParseFromResult = ParameterValueExtension.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ParameterValueExtension ParameterValueExtension.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithCodedInputStreamExtensionRegistryLite()
      throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ParameterValueExtension actualParseFromResult = ParameterValueExtension.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseFrom(InputStream)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ParameterValueExtension actualParseFromResult = ParameterValueExtension
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseFrom(InputStream)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ParameterValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseFrom(InputStream)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithInputStream3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ParameterValueExtension.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseFrom(InputStream)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithInputStream4() throws IOException {
    // Arrange and Act
    ParameterValueExtension actualParseFromResult = ParameterValueExtension.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    Any extensions = actualParseFromResult.getExtensions();
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, actualParseFromResult.getExtensionsOrBuilder());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithInputStreamExtensionRegistryLite()
      throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ParameterValueExtension actualParseFromResult = ParameterValueExtension.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertFalse(actualParseFromResult.hasExtensions());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithInputStreamExtensionRegistryLite2()
      throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ParameterValueExtension.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Template_Parameter_ParameterValueExtension {@link ParameterValueExtension#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ParameterValueExtension#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ParameterValueExtension parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ParameterValueExtension ParameterValueExtension.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testPayload_Template_Parameter_ParameterValueExtensionParseFromWithInputStreamExtensionRegistryLite3()
      throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ParameterValueExtension.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code BOOLEAN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase forNumber(int); then return 'BOOLEAN_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_thenReturnBooleanValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.BOOLEAN_VALUE, Parameter.ValueCase.forNumber(7));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code EXTENSION_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase forNumber(int); then return 'EXTENSION_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_thenReturnExtensionValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.EXTENSION_VALUE, Parameter.ValueCase.forNumber(MetaData.EXTENSIONS_FIELD_NUMBER));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>Then return {@code STRING_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase forNumber(int); then return 'STRING_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.STRING_VALUE, Parameter.ValueCase.forNumber(8));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code FLOAT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase forNumber(int); when five; then return 'FLOAT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_whenFive_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.FLOAT_VALUE, Parameter.ValueCase.forNumber(5));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase forNumber(int); when forty-two; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_whenFortyTwo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Parameter.ValueCase.forNumber(42));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code LONG_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase forNumber(int); when four; then return 'LONG_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_whenFour_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.LONG_VALUE, Parameter.ValueCase.forNumber(4));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code DOUBLE_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase forNumber(int); when six; then return 'DOUBLE_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_whenSix_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.DOUBLE_VALUE, Parameter.ValueCase.forNumber(6));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code INT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase forNumber(int); when three; then return 'INT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_whenThree_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.INT_VALUE, Parameter.ValueCase.forNumber(3));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#forNumber(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code VALUE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#forNumber(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase forNumber(int); when zero; then return 'VALUE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.forNumber(int)"})
  void testPayload_Template_Parameter_ValueCaseForNumber_whenZero_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, Parameter.ValueCase.forNumber(0));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#getNumber()}.
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#getNumber()}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase getNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Template.Parameter.ValueCase.getNumber()"})
  void testPayload_Template_Parameter_ValueCaseGetNumber() {
    // Arrange, Act and Assert
    assertEquals(3, Parameter.ValueCase.valueOf("INT_VALUE").getNumber());
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)} with {@code value}.
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.EXTENSION_VALUE, Parameter.ValueCase.valueOf(MetaData.EXTENSIONS_FIELD_NUMBER));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code BOOLEAN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'BOOLEAN_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnBooleanValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.BOOLEAN_VALUE, Parameter.ValueCase.valueOf(7));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code DOUBLE_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'DOUBLE_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.DOUBLE_VALUE, Parameter.ValueCase.valueOf(6));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code FLOAT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'FLOAT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnFloatValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.FLOAT_VALUE, Parameter.ValueCase.valueOf(5));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code INT_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'INT_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnIntValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.INT_VALUE, Parameter.ValueCase.valueOf(3));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code LONG_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'LONG_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnLongValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.LONG_VALUE, Parameter.ValueCase.valueOf(4));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Parameter.ValueCase.valueOf(42));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code STRING_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'STRING_VALUE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnStringValue() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.STRING_VALUE, Parameter.ValueCase.valueOf(8));
  }

  /**
   * Test Payload_Template_Parameter_ValueCase {@link Template.Parameter.ValueCase#valueOf(int)} with {@code value}.
   * <ul>
   *   <li>Then return {@code VALUE_NOT_SET}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Template.Parameter.ValueCase#valueOf(int)}
   */
  @Test
  @DisplayName("Test Payload_Template_Parameter_ValueCase valueOf(int) with 'value'; then return 'VALUE_NOT_SET'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Template.Parameter.ValueCase Template.Parameter.ValueCase.valueOf(int)"})
  void testPayload_Template_Parameter_ValueCaseValueOfWithValue_thenReturnValueNotSet() {
    // Arrange, Act and Assert
    assertEquals(Parameter.ValueCase.VALUE_NOT_SET, Parameter.ValueCase.valueOf(0));
  }
}
