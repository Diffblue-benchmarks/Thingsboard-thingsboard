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
package org.thingsboard.server.gen.transport.coap;

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
import com.google.protobuf.DescriptorProtos.FieldOptions;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.coap.ConfigProtos.ProtoConfig;
import org.thingsboard.server.gen.transport.coap.MeasurementTypeProtos.MeasurementType;
import org.thingsboard.server.gen.transport.coap.MeasurementsProtos.ProtoChannel;
import org.thingsboard.server.gen.transport.coap.MeasurementsProtos.ProtoMeasurements;

class MeasurementsProtosDiffblueTest {
  /**
   * Test ProtoChannel {@link ProtoChannel#equals(Object)}, and {@link ProtoChannel#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoChannel#equals(Object)}
   *   <li>{@link ProtoChannel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoChannel equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoChannel.equals(Object)", "int ProtoChannel.hashCode()"})
  void testProtoChannelEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProtoChannel defaultInstance = ProtoChannel.getDefaultInstance();
    ProtoChannel defaultInstance2 = ProtoChannel.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#equals(Object)}, and {@link ProtoChannel#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoChannel#equals(Object)}
   *   <li>{@link ProtoChannel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoChannel equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoChannel.equals(Object)", "int ProtoChannel.hashCode()"})
  void testProtoChannelEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProtoChannel defaultInstance = ProtoChannel.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoChannel#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoChannel equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoChannel.equals(Object)", "int ProtoChannel.hashCode()"})
  void testProtoChannelEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoChannel.getDefaultInstance(), 1);
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoChannel#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoChannel equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoChannel.equals(Object)", "int ProtoChannel.hashCode()"})
  void testProtoChannelEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoChannel.getDefaultInstance(), null);
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoChannel#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoChannel equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoChannel.equals(Object)", "int ProtoChannel.hashCode()"})
  void testProtoChannelEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoChannel.getDefaultInstance(), "Different type to ProtoChannel");
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ProtoChannel#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ProtoChannel getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.getDefaultInstanceForType()"})
  void testProtoChannelGetDefaultInstanceForType() {
    // Arrange
    ProtoChannel defaultInstance = ProtoChannel.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#getSampleOffsetsCount()}.
   * <p>
   * Method under test: {@link ProtoChannel#getSampleOffsetsCount()}
   */
  @Test
  @DisplayName("Test ProtoChannel getSampleOffsetsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoChannel.getSampleOffsetsCount()"})
  void testProtoChannelGetSampleOffsetsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoChannel.getDefaultInstance().getSampleOffsetsCount());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#getSerializedSize()}.
   * <p>
   * Method under test: {@link ProtoChannel#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ProtoChannel getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoChannel.getSerializedSize()"})
  void testProtoChannelGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoChannel.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#getType()}.
   * <p>
   * Method under test: {@link ProtoChannel#getType()}
   */
  @Test
  @DisplayName("Test ProtoChannel getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MeasurementType ProtoChannel.getType()"})
  void testProtoChannelGetType() {
    // Arrange, Act and Assert
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, ProtoChannel.getDefaultInstance().getType());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#isInitialized()}.
   * <p>
   * Method under test: {@link ProtoChannel#isInitialized()}
   */
  @Test
  @DisplayName("Test ProtoChannel isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoChannel.isInitialized()"})
  void testProtoChannelIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProtoChannel.getDefaultInstance().isInitialized());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoChannel#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseDelimitedFrom(InputStream)"})
  void testProtoChannelParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoChannel actualParseDelimitedFromResult = ProtoChannel.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getStartPoint());
    assertEquals(0, actualParseDelimitedFromResult.getTimestamp());
    assertEquals(0, actualParseDelimitedFromResult.getTypeValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseDelimitedFromResult.getType());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getSampleOffsetsList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoChannel#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseDelimitedFrom(InputStream)"})
  void testProtoChannelParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoChannel.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoChannelParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoChannel actualParseDelimitedFromResult = ProtoChannel.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getStartPoint());
    assertEquals(0, actualParseDelimitedFromResult.getTimestamp());
    assertEquals(0, actualParseDelimitedFromResult.getTypeValue());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseDelimitedFromResult.getType());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getSampleOffsetsList().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoChannelParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoChannel.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoChannelParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoChannel.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoChannelParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoChannel.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoChannel#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseDelimitedFrom(InputStream)"})
  void testProtoChannelParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoChannel.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoChannel#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseDelimitedFrom(InputStream)"})
  void testProtoChannelParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoChannel.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ProtoChannel#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseFrom(ByteBuffer)"})
  void testProtoChannelParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoChannel actualParseFromResult = ProtoChannel.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getSampleOffsetsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoChannel#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testProtoChannelParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ProtoChannel actualParseFromResult = ProtoChannel.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getSampleOffsetsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoChannel#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseFrom(byte[], ExtensionRegistryLite)"})
  void testProtoChannelParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoChannel actualParseFromResult = ProtoChannel.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getSampleOffsetsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link ProtoChannel#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseFrom(ByteString)"})
  void testProtoChannelParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoChannel actualParseFromResult = ProtoChannel.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getSampleOffsetsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoChannel#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testProtoChannelParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    ProtoChannel actualParseFromResult = ProtoChannel.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getSampleOffsetsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link ProtoChannel#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseFrom(CodedInputStream)"})
  void testProtoChannelParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoChannel actualParseFromResult = ProtoChannel.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getSampleOffsetsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoChannel#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testProtoChannelParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    ProtoChannel actualParseFromResult = ProtoChannel.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getSampleOffsetsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoChannel#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseFrom(InputStream)"})
  void testProtoChannelParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ProtoChannel actualParseFromResult = ProtoChannel.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoChannel#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoChannelParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ProtoChannel actualParseFromResult = ProtoChannel.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getSampleOffsetsList().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoChannel#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoChannelParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoChannel.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoChannel#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoChannelParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoChannel.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoChannel#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseFrom(InputStream)"})
  void testProtoChannelParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoChannel.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoChannel#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseFrom(InputStream)"})
  void testProtoChannelParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoChannel.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoChannel#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoChannel ProtoChannel.parseFrom(InputStream)"})
  void testProtoChannelParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ProtoChannel actualParseFromResult = ProtoChannel.parseFrom((InputStream) null);

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#equals(Object)}, and {@link ProtoMeasurements#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoMeasurements#equals(Object)}
   *   <li>{@link ProtoMeasurements#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoMeasurements equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoMeasurements.equals(Object)", "int ProtoMeasurements.hashCode()"})
  void testProtoMeasurementsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProtoMeasurements defaultInstance = ProtoMeasurements.getDefaultInstance();
    ProtoMeasurements defaultInstance2 = ProtoMeasurements.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#equals(Object)}, and {@link ProtoMeasurements#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoMeasurements#equals(Object)}
   *   <li>{@link ProtoMeasurements#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoMeasurements equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoMeasurements.equals(Object)", "int ProtoMeasurements.hashCode()"})
  void testProtoMeasurementsEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProtoMeasurements defaultInstance = ProtoMeasurements.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoMeasurements#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoMeasurements.equals(Object)", "int ProtoMeasurements.hashCode()"})
  void testProtoMeasurementsEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoMeasurements.getDefaultInstance(), 1);
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoMeasurements#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoMeasurements.equals(Object)", "int ProtoMeasurements.hashCode()"})
  void testProtoMeasurementsEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoMeasurements.getDefaultInstance(), null);
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoMeasurements#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoMeasurements.equals(Object)", "int ProtoMeasurements.hashCode()"})
  void testProtoMeasurementsEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProtoMeasurements.getDefaultInstance(), "Different type to ProtoMeasurements");
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#getChannelsCount()}.
   * <p>
   * Method under test: {@link ProtoMeasurements#getChannelsCount()}
   */
  @Test
  @DisplayName("Test ProtoMeasurements getChannelsCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoMeasurements.getChannelsCount()"})
  void testProtoMeasurementsGetChannelsCount() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoMeasurements.getDefaultInstance().getChannelsCount());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#getCloudToken()}.
   * <p>
   * Method under test: {@link ProtoMeasurements#getCloudToken()}
   */
  @Test
  @DisplayName("Test ProtoMeasurements getCloudToken()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ProtoMeasurements.getCloudToken()"})
  void testProtoMeasurementsGetCloudToken() {
    // Arrange, Act and Assert
    assertEquals("", ProtoMeasurements.getDefaultInstance().getCloudToken());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#getCloudTokenBytes()}.
   * <p>
   * Method under test: {@link ProtoMeasurements#getCloudTokenBytes()}
   */
  @Test
  @DisplayName("Test ProtoMeasurements getCloudTokenBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString ProtoMeasurements.getCloudTokenBytes()"})
  void testProtoMeasurementsGetCloudTokenBytes() {
    // Arrange
    ProtoMeasurements defaultInstance = ProtoMeasurements.getDefaultInstance();

    // Act
    ByteString actualCloudTokenBytes = defaultInstance.getCloudTokenBytes();

    // Assert
    ByteString byteString = actualCloudTokenBytes.EMPTY;
    assertEquals(byteString, actualCloudTokenBytes);
    List<FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, fields.size());
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, defaultInstance.getSerialNum());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ProtoMeasurements#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ProtoMeasurements getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.getDefaultInstanceForType()"})
  void testProtoMeasurementsGetDefaultInstanceForType() {
    // Arrange
    ProtoMeasurements defaultInstance = ProtoMeasurements.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#getSerializedSize()}.
   * <p>
   * Method under test: {@link ProtoMeasurements#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ProtoMeasurements getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProtoMeasurements.getSerializedSize()"})
  void testProtoMeasurementsGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ProtoMeasurements.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#isInitialized()}.
   * <p>
   * Method under test: {@link ProtoMeasurements#isInitialized()}
   */
  @Test
  @DisplayName("Test ProtoMeasurements isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProtoMeasurements.isInitialized()"})
  void testProtoMeasurementsIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ProtoMeasurements.getDefaultInstance().isInitialized());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseDelimitedFrom(InputStream)"})
  void testProtoMeasurementsParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoMeasurements actualParseDelimitedFromResult = ProtoMeasurements.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getCloudToken());
    assertEquals(0, actualParseDelimitedFromResult.getChannelsCount());
    assertEquals(0, actualParseDelimitedFromResult.getHash());
    assertEquals(0, actualParseDelimitedFromResult.getMeasurementPeriodBase());
    assertEquals(0, actualParseDelimitedFromResult.getMeasurementPeriodFactor());
    assertEquals(0, actualParseDelimitedFromResult.getNextTransmissionAt());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSignal());
    assertEquals(0, actualParseDelimitedFromResult.getTransferReason());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertFalse(actualParseDelimitedFromResult.getBatteryStatus());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<ProtoChannel> channelsList = actualParseDelimitedFromResult.getChannelsList();
    assertTrue(channelsList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(channelsList, actualParseDelimitedFromResult.getChannelsOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseDelimitedFrom(InputStream)"})
  void testProtoMeasurementsParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoMeasurements.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseDelimitedFrom(InputStream)"})
  void testProtoMeasurementsParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ProtoMeasurements.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoMeasurementsParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ProtoMeasurements actualParseDelimitedFromResult = ProtoMeasurements.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getCloudToken());
    assertEquals(0, actualParseDelimitedFromResult.getChannelsCount());
    assertEquals(0, actualParseDelimitedFromResult.getHash());
    assertEquals(0, actualParseDelimitedFromResult.getMeasurementPeriodBase());
    assertEquals(0, actualParseDelimitedFromResult.getMeasurementPeriodFactor());
    assertEquals(0, actualParseDelimitedFromResult.getNextTransmissionAt());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSignal());
    assertEquals(0, actualParseDelimitedFromResult.getTransferReason());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertFalse(actualParseDelimitedFromResult.getBatteryStatus());
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    List<ProtoChannel> channelsList = actualParseDelimitedFromResult.getChannelsList();
    assertTrue(channelsList.isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(channelsList, actualParseDelimitedFromResult.getChannelsOrBuilderList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoMeasurementsParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> ProtoMeasurements.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoMeasurementsParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoMeasurements.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoMeasurementsParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ProtoMeasurements.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoMeasurementsParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoMeasurements.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoMeasurements#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseDelimitedFrom(InputStream)"})
  void testProtoMeasurementsParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ProtoMeasurements.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoMeasurements#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseDelimitedFrom(InputStream)"})
  void testProtoMeasurementsParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoMeasurements.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseFrom(byte[])"})
  void testProtoMeasurementsParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoMeasurements actualParseFromResult = ProtoMeasurements.parseFrom(new byte[]{});

    // Assert
    Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    assertEquals(0, descriptorForType.toProto().getDescriptorForType().toProto().getExtensionRangeCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    Map<FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    FileDescriptor file = descriptorForType.getFile();
    FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(allFields, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(allFields, toProtoResult.getSourceCodeInfo().getAllFields());
    FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, fields.size());
    FieldDescriptor getResult = fields.get(0);
    FieldOptions options = getResult.getOptions();
    assertEquals(allFields, options.getAllFields());
    assertEquals(allFields, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDefaultValue = actualParseFromResult.getSerialNum();
    assertSame(expectedDefaultValue, getResult.getDefaultValue());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseFrom(ByteBuffer)"})
  void testProtoMeasurementsParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoMeasurements actualParseFromResult = ProtoMeasurements.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals(0, actualParseFromResult.getChannelsCount());
    assertEquals(0, actualParseFromResult.getHash());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodBase());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodFactor());
    assertEquals(0, actualParseFromResult.getNextTransmissionAt());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSignal());
    assertEquals(0, actualParseFromResult.getTransferReason());
    assertFalse(actualParseFromResult.getBatteryStatus());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ProtoChannel> channelsList = actualParseFromResult.getChannelsList();
    assertTrue(channelsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(channelsList, actualParseFromResult.getChannelsOrBuilderList());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testProtoMeasurementsParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    ProtoMeasurements actualParseFromResult = ProtoMeasurements.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals(0, actualParseFromResult.getChannelsCount());
    assertEquals(0, actualParseFromResult.getHash());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodBase());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodFactor());
    assertEquals(0, actualParseFromResult.getNextTransmissionAt());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSignal());
    assertEquals(0, actualParseFromResult.getTransferReason());
    assertFalse(actualParseFromResult.getBatteryStatus());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ProtoChannel> channelsList = actualParseFromResult.getChannelsList();
    assertTrue(channelsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(channelsList, actualParseFromResult.getChannelsOrBuilderList());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseFrom(byte[], ExtensionRegistryLite)"})
  void testProtoMeasurementsParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoMeasurements actualParseFromResult = ProtoMeasurements.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    assertEquals(0, descriptorForType.toProto().getDescriptorForType().toProto().getExtensionRangeCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    Map<FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    FileDescriptor file = descriptorForType.getFile();
    FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(allFields, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(allFields, toProtoResult.getSourceCodeInfo().getAllFields());
    FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, fields.size());
    FieldDescriptor getResult = fields.get(0);
    FieldOptions options = getResult.getOptions();
    assertEquals(allFields, options.getAllFields());
    assertEquals(allFields, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString expectedDefaultValue = actualParseFromResult.getSerialNum();
    assertSame(expectedDefaultValue, getResult.getDefaultValue());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseFrom(byte[], ExtensionRegistryLite)"})
  void testProtoMeasurementsParseFromWithByteExtensionRegistryLite2() throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoMeasurements actualParseFromResult = ProtoMeasurements
        .parseFrom(new byte[]{'\n', 6, 'A', 'X', 'A', 'X', 'A', 'X'}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    ByteString serialNum = actualParseFromResult.getSerialNum();
    assertEquals("AXAXAX", serialNum.toStringUtf8());
    assertEquals(1, actualParseFromResult.getAllFields().size());
    assertEquals(8, actualParseFromResult.getSerializedSize());
    assertFalse(serialNum.isEmpty());
    assertTrue(serialNum.iterator().hasNext());
    assertSame(actualParseFromResult.getDefaultInstanceForType().getDefaultInstanceForType(),
        actualParseFromResult.getDefaultInstanceForType().getDefaultInstanceForType());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return SerialNum toStringUtf8 is {@code AXAXAX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoMeasurements#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(byte[]) with 'byte[]'; then return SerialNum toStringUtf8 is 'AXAXAX'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseFrom(byte[])"})
  void testProtoMeasurementsParseFromWithByte_thenReturnSerialNumToStringUtf8IsAxaxax()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    ProtoMeasurements actualParseFromResult = ProtoMeasurements
        .parseFrom(new byte[]{'\n', 6, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    ByteString serialNum = actualParseFromResult.getSerialNum();
    assertEquals("AXAXAX", serialNum.toStringUtf8());
    assertEquals(1, actualParseFromResult.getAllFields().size());
    assertEquals(8, actualParseFromResult.getSerializedSize());
    assertFalse(serialNum.isEmpty());
    assertTrue(serialNum.iterator().hasNext());
    assertSame(actualParseFromResult.getDefaultInstanceForType().getDefaultInstanceForType(),
        actualParseFromResult.getDefaultInstanceForType().getDefaultInstanceForType());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseFrom(InputStream)"})
  void testProtoMeasurementsParseFromWithInputStream() throws IOException {
    // Arrange and Act
    ProtoMeasurements actualParseFromResult = ProtoMeasurements.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseFrom(InputStream)"})
  void testProtoMeasurementsParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ProtoMeasurements.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoMeasurementsParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    ProtoMeasurements actualParseFromResult = ProtoMeasurements.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getCloudToken());
    assertEquals(0, actualParseFromResult.getChannelsCount());
    assertEquals(0, actualParseFromResult.getHash());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodBase());
    assertEquals(0, actualParseFromResult.getMeasurementPeriodFactor());
    assertEquals(0, actualParseFromResult.getNextTransmissionAt());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getSignal());
    assertEquals(0, actualParseFromResult.getTransferReason());
    assertFalse(actualParseFromResult.getBatteryStatus());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<ProtoChannel> channelsList = actualParseFromResult.getChannelsList();
    assertTrue(channelsList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(channelsList, actualParseFromResult.getChannelsOrBuilderList());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoMeasurementsParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoMeasurements.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link ProtoMeasurements#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testProtoMeasurementsParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> ProtoMeasurements.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoMeasurements#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseFrom(InputStream)"})
  void testProtoMeasurementsParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ProtoMeasurements.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoMeasurements#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProtoMeasurements ProtoMeasurements.parseFrom(InputStream)"})
  void testProtoMeasurementsParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ProtoMeasurements actualParseFromResult = ProtoMeasurements.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }
}
