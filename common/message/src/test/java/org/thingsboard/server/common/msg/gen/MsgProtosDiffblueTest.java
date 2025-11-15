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
package org.thingsboard.server.common.msg.gen;

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
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MsgProtosDiffblueTest {
  /**
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#containsData(String)}
   */
  @Test
  void testTbMsgMetaDataProtoContainsData() {
    // Arrange, Act and Assert
    assertFalse(MsgProtos.TbMsgMetaDataProto.getDefaultInstance().containsData("Key"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgMetaDataProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgMetaDataProto#hashCode()}
   * </ul>
   */
  @Test
  void testTbMsgMetaDataProtoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MsgProtos.TbMsgMetaDataProto defaultInstance = MsgProtos.TbMsgMetaDataProto.getDefaultInstance();
    MsgProtos.TbMsgMetaDataProto defaultInstance2 = MsgProtos.TbMsgMetaDataProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgMetaDataProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgMetaDataProto#hashCode()}
   * </ul>
   */
  @Test
  void testTbMsgMetaDataProtoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MsgProtos.TbMsgMetaDataProto defaultInstance = MsgProtos.TbMsgMetaDataProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#equals(Object)}
   */
  @Test
  void testTbMsgMetaDataProtoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgMetaDataProto.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#equals(Object)}
   */
  @Test
  void testTbMsgMetaDataProtoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgMetaDataProto.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#equals(Object)}
   */
  @Test
  void testTbMsgMetaDataProtoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgMetaDataProto.getDefaultInstance(), "Different type to TbMsgMetaDataProto");
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#getData()}
   */
  @Test
  void testTbMsgMetaDataProtoGetData() {
    // Arrange, Act and Assert
    assertTrue(MsgProtos.TbMsgMetaDataProto.getDefaultInstance().getData().isEmpty());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#getDataCount()}
   */
  @Test
  void testTbMsgMetaDataProtoGetDataCount() {
    // Arrange, Act and Assert
    assertEquals(0, MsgProtos.TbMsgMetaDataProto.getDefaultInstance().getDataCount());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#getDataMap()}
   */
  @Test
  void testTbMsgMetaDataProtoGetDataMap() {
    // Arrange, Act and Assert
    assertTrue(MsgProtos.TbMsgMetaDataProto.getDefaultInstance().getDataMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#getDataOrDefault(String, String)}
   */
  @Test
  void testTbMsgMetaDataProtoGetDataOrDefault() {
    // Arrange, Act and Assert
    assertEquals("42", MsgProtos.TbMsgMetaDataProto.getDefaultInstance().getDataOrDefault("Key", "42"));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#getDataOrThrow(String)}
   */
  @Test
  void testTbMsgMetaDataProtoGetDataOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> MsgProtos.TbMsgMetaDataProto.getDefaultInstance().getDataOrThrow("Key"));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#getDefaultInstanceForType()}
   */
  @Test
  void testTbMsgMetaDataProtoGetDefaultInstanceForType() {
    // Arrange
    MsgProtos.TbMsgMetaDataProto defaultInstance = MsgProtos.TbMsgMetaDataProto.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#getSerializedSize()}
   */
  @Test
  void testTbMsgMetaDataProtoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MsgProtos.TbMsgMetaDataProto.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#internalGetMapFieldReflection(int)}
   */
  @Test
  void testTbMsgMetaDataProtoInternalGetMapFieldReflection() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> MsgProtos.TbMsgMetaDataProto.getDefaultInstance()
        .internalGetMapFieldReflection(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#internalGetMapFieldReflection(int)}
   */
  @Test
  void testTbMsgMetaDataProtoInternalGetMapFieldReflection2() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = MsgProtos.TbMsgMetaDataProto
        .getDefaultInstance()
        .internalGetMapFieldReflection(1);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#isInitialized()}
   */
  @Test
  void testTbMsgMetaDataProtoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MsgProtos.TbMsgMetaDataProto.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testTbMsgMetaDataProtoNewInstance() {
    // Arrange
    MsgProtos.TbMsgMetaDataProto defaultInstance = MsgProtos.TbMsgMetaDataProto.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof MsgProtos.TbMsgMetaDataProto);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgMetaDataProtoParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MsgProtos.TbMsgMetaDataProto.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgMetaDataProtoParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> MsgProtos.TbMsgMetaDataProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgMetaDataProtoParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MsgProtos.TbMsgMetaDataProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgMetaDataProtoParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MsgProtos.TbMsgMetaDataProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgMetaDataProtoParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MsgProtos.TbMsgMetaDataProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgMetaDataProtoParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> MsgProtos.TbMsgMetaDataProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgMetaDataProtoParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> MsgProtos.TbMsgMetaDataProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgMetaDataProtoParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MsgProtos.TbMsgMetaDataProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseFrom(InputStream)}
   */
  @Test
  void testTbMsgMetaDataProtoParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MsgProtos.TbMsgMetaDataProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseFrom(InputStream)}
   */
  @Test
  void testTbMsgMetaDataProtoParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MsgProtos.TbMsgMetaDataProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgMetaDataProtoParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MsgProtos.TbMsgMetaDataProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgMetaDataProtoParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MsgProtos.TbMsgMetaDataProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgProcessingCtxProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgProcessingCtxProto#hashCode()}
   * </ul>
   */
  @Test
  void testTbMsgProcessingCtxProtoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MsgProtos.TbMsgProcessingCtxProto defaultInstance = MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance();
    MsgProtos.TbMsgProcessingCtxProto defaultInstance2 = MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgProcessingCtxProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgProcessingCtxProto#hashCode()}
   * </ul>
   */
  @Test
  void testTbMsgProcessingCtxProtoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MsgProtos.TbMsgProcessingCtxProto defaultInstance = MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProcessingCtxProto#equals(Object)}
   */
  @Test
  void testTbMsgProcessingCtxProtoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProcessingCtxProto#equals(Object)}
   */
  @Test
  void testTbMsgProcessingCtxProtoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProcessingCtxProto#equals(Object)}
   */
  @Test
  void testTbMsgProcessingCtxProtoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance(),
        "Different type to TbMsgProcessingCtxProto");
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#getDefaultInstanceForType()}
   */
  @Test
  void testTbMsgProcessingCtxProtoGetDefaultInstanceForType() {
    // Arrange
    MsgProtos.TbMsgProcessingCtxProto defaultInstance = MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#getSerializedSize()}
   */
  @Test
  void testTbMsgProcessingCtxProtoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProcessingCtxProto#getStackCount()}
   */
  @Test
  void testTbMsgProcessingCtxProtoGetStackCount() {
    // Arrange, Act and Assert
    assertEquals(0, MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance().getStackCount());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProcessingCtxProto#isInitialized()}
   */
  @Test
  void testTbMsgProcessingCtxProtoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testTbMsgProcessingCtxProtoNewInstance() {
    // Arrange
    MsgProtos.TbMsgProcessingCtxProto defaultInstance = MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof MsgProtos.TbMsgProcessingCtxProto);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgProcessingCtxProtoParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MsgProtos.TbMsgProcessingCtxProto.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgProcessingCtxProtoParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MsgProtos.TbMsgProcessingCtxProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgProcessingCtxProtoParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MsgProtos.TbMsgProcessingCtxProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingCtxProtoParseDelimitedFrom4() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MsgProtos.TbMsgProcessingCtxProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingCtxProtoParseDelimitedFrom5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> MsgProtos.TbMsgProcessingCtxProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingCtxProtoParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MsgProtos.TbMsgProcessingCtxProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseFrom(InputStream)}
   */
  @Test
  void testTbMsgProcessingCtxProtoParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MsgProtos.TbMsgProcessingCtxProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseFrom(InputStream)}
   */
  @Test
  void testTbMsgProcessingCtxProtoParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MsgProtos.TbMsgProcessingCtxProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingCtxProtoParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MsgProtos.TbMsgProcessingCtxProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingCtxProtoParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MsgProtos.TbMsgProcessingCtxProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgProcessingStackItemProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgProcessingStackItemProto#hashCode()}
   * </ul>
   */
  @Test
  void testTbMsgProcessingStackItemProtoEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    MsgProtos.TbMsgProcessingStackItemProto defaultInstance = MsgProtos.TbMsgProcessingStackItemProto
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgProcessingStackItemProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgProcessingStackItemProto#hashCode()}
   * </ul>
   */
  @Test
  void testTbMsgProcessingStackItemProtoEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    MsgProtos.TbMsgProcessingStackItemProto defaultInstance = MsgProtos.TbMsgProcessingStackItemProto
        .getDefaultInstance();
    MsgProtos.TbMsgProcessingStackItemProto defaultInstance2 = MsgProtos.TbMsgProcessingStackItemProto
        .getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#equals(Object)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance(), 1);
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#equals(Object)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance(), null);
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#equals(Object)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance(),
        "Different type to TbMsgProcessingStackItemProto");
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#getDefaultInstanceForType()}
   */
  @Test
  void testTbMsgProcessingStackItemProtoGetDefaultInstanceForType() {
    // Arrange
    MsgProtos.TbMsgProcessingStackItemProto defaultInstance = MsgProtos.TbMsgProcessingStackItemProto
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#getSerializedSize()}
   */
  @Test
  void testTbMsgProcessingStackItemProtoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#isInitialized()}
   */
  @Test
  void testTbMsgProcessingStackItemProtoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoNewInstance() {
    // Arrange
    MsgProtos.TbMsgProcessingStackItemProto defaultInstance = MsgProtos.TbMsgProcessingStackItemProto
        .getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof MsgProtos.TbMsgProcessingStackItemProto);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseDelimitedFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseDelimitedFrom(input);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult8.getDefaultValue());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult8.getExtendee());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult8.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", toProtoResult8.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("DescriptorProto", toProtoResult4.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MsgProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MsgProtos", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("TbMsgMetaDataProto", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(2);
    assertEquals("TbMsgProcessingCtxProto", getResult6.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("TbMsgProcessingStackItemProto", nameBytes.toStringUtf8());
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult.getName());
    assertEquals("TbMsgProcessingStackItemProto", descriptorForType.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(3);
    assertEquals("TbMsgProto", getResult7.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("msgqueue", packageBytes.toStringUtf8());
    assertEquals("msgqueue", toProtoResult2.getPackage());
    assertEquals("msgqueue", file.getPackage());
    assertEquals("msgqueue.TbMsgMetaDataProto", getResult5.getFullName());
    assertEquals("msgqueue.TbMsgProcessingCtxProto", getResult6.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", descriptorForType.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdLSB", getResult2.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdMSB", getResult.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdLSB", getResult4.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdMSB", getResult3.getFullName());
    assertEquals("msgqueue.TbMsgProto", getResult7.getFullName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.common.msg.gen", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.common.msg.gen", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("ruleChainIdLSB", toProtoResult6.getName());
    assertEquals("ruleChainIdLSB", getResult2.getJsonName());
    assertEquals("ruleChainIdLSB", getResult2.getName());
    assertEquals("ruleChainIdMSB", toProtoResult5.getName());
    assertEquals("ruleChainIdMSB", getResult.getJsonName());
    assertEquals("ruleChainIdMSB", getResult.getName());
    assertEquals("ruleNodeIdLSB", toProtoResult8.getName());
    assertEquals("ruleNodeIdLSB", getResult4.getJsonName());
    assertEquals("ruleNodeIdLSB", getResult4.getName());
    assertEquals("ruleNodeIdMSB", toProtoResult7.getName());
    assertEquals("ruleNodeIdMSB", getResult3.getJsonName());
    assertEquals("ruleNodeIdMSB", getResult3.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("tbmsg.proto", nameBytes2.toStringUtf8());
    assertEquals("tbmsg.proto", toProtoResult2.getName());
    assertEquals("tbmsg.proto", file.getFullName());
    assertEquals("tbmsg.proto", file.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, toProtoResult8.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleNodeIdMSB());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getNumber());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(125, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult4.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult6.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult7.getIndex());
    assertEquals(3, getResult4.getIndex());
    assertEquals(3, getResult3.getNumber());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult8.getNumber());
    assertEquals(4, toProtoResult2.getMessageTypeCount());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(952, toProtoResult2.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult8.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult8.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult8.getProto3Optional());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult8.hasDefaultValue());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult8.hasExtendee());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult8.hasJsonName());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult8.hasOneofIndex());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult8.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(toProtoResult8.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult8.hasLabel());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult8.hasType());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseDelimitedFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
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
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseDelimitedFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult8.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(MsgProtos.TbMsgProto.METADATA_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals('M', iteratorResult5.next().byteValue());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('b', iteratorResult.next().byteValue());
    assertEquals('m', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('t', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseDelimitedFrom2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MsgProtos.TbMsgProcessingStackItemProto.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MsgProtos.TbMsgProcessingStackItemProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MsgProtos.TbMsgProcessingStackItemProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseDelimitedFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult8.getDefaultValue());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult8.getExtendee());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult8.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", toProtoResult8.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("DescriptorProto", toProtoResult4.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MsgProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MsgProtos", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("TbMsgMetaDataProto", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(2);
    assertEquals("TbMsgProcessingCtxProto", getResult6.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("TbMsgProcessingStackItemProto", nameBytes.toStringUtf8());
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult.getName());
    assertEquals("TbMsgProcessingStackItemProto", descriptorForType.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(3);
    assertEquals("TbMsgProto", getResult7.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("msgqueue", packageBytes.toStringUtf8());
    assertEquals("msgqueue", toProtoResult2.getPackage());
    assertEquals("msgqueue", file.getPackage());
    assertEquals("msgqueue.TbMsgMetaDataProto", getResult5.getFullName());
    assertEquals("msgqueue.TbMsgProcessingCtxProto", getResult6.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", descriptorForType.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdLSB", getResult2.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdMSB", getResult.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdLSB", getResult4.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdMSB", getResult3.getFullName());
    assertEquals("msgqueue.TbMsgProto", getResult7.getFullName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.common.msg.gen", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.common.msg.gen", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("ruleChainIdLSB", toProtoResult6.getName());
    assertEquals("ruleChainIdLSB", getResult2.getJsonName());
    assertEquals("ruleChainIdLSB", getResult2.getName());
    assertEquals("ruleChainIdMSB", toProtoResult5.getName());
    assertEquals("ruleChainIdMSB", getResult.getJsonName());
    assertEquals("ruleChainIdMSB", getResult.getName());
    assertEquals("ruleNodeIdLSB", toProtoResult8.getName());
    assertEquals("ruleNodeIdLSB", getResult4.getJsonName());
    assertEquals("ruleNodeIdLSB", getResult4.getName());
    assertEquals("ruleNodeIdMSB", toProtoResult7.getName());
    assertEquals("ruleNodeIdMSB", getResult3.getJsonName());
    assertEquals("ruleNodeIdMSB", getResult3.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("tbmsg.proto", nameBytes2.toStringUtf8());
    assertEquals("tbmsg.proto", toProtoResult2.getName());
    assertEquals("tbmsg.proto", file.getFullName());
    assertEquals("tbmsg.proto", file.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, toProtoResult8.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleNodeIdMSB());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getNumber());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(125, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult4.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult6.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult7.getIndex());
    assertEquals(3, getResult4.getIndex());
    assertEquals(3, getResult3.getNumber());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult8.getNumber());
    assertEquals(4, toProtoResult2.getMessageTypeCount());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(952, toProtoResult2.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult8.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult8.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult8.getProto3Optional());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult8.hasDefaultValue());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult8.hasExtendee());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult8.hasJsonName());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult8.hasOneofIndex());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult8.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(toProtoResult8.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult8.hasLabel());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult8.hasType());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseDelimitedFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
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
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseDelimitedFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult8.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(MsgProtos.TbMsgProto.METADATA_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals('M', iteratorResult5.next().byteValue());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('b', iteratorResult.next().byteValue());
    assertEquals('m', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('t', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseDelimitedFrom6() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        MsgProtos.TbMsgProcessingStackItemProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MsgProtos.TbMsgProcessingStackItemProto.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MsgProtos.TbMsgProcessingStackItemProto
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(ByteString)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult8.getDefaultValue());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult8.getExtendee());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult8.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", toProtoResult8.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("DescriptorProto", toProtoResult4.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MsgProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MsgProtos", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("TbMsgMetaDataProto", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(2);
    assertEquals("TbMsgProcessingCtxProto", getResult6.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("TbMsgProcessingStackItemProto", nameBytes.toStringUtf8());
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult.getName());
    assertEquals("TbMsgProcessingStackItemProto", descriptorForType.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(3);
    assertEquals("TbMsgProto", getResult7.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("msgqueue", packageBytes.toStringUtf8());
    assertEquals("msgqueue", toProtoResult2.getPackage());
    assertEquals("msgqueue", file.getPackage());
    assertEquals("msgqueue.TbMsgMetaDataProto", getResult5.getFullName());
    assertEquals("msgqueue.TbMsgProcessingCtxProto", getResult6.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", descriptorForType.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdLSB", getResult2.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdMSB", getResult.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdLSB", getResult4.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdMSB", getResult3.getFullName());
    assertEquals("msgqueue.TbMsgProto", getResult7.getFullName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.common.msg.gen", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.common.msg.gen", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("ruleChainIdLSB", toProtoResult6.getName());
    assertEquals("ruleChainIdLSB", getResult2.getJsonName());
    assertEquals("ruleChainIdLSB", getResult2.getName());
    assertEquals("ruleChainIdMSB", toProtoResult5.getName());
    assertEquals("ruleChainIdMSB", getResult.getJsonName());
    assertEquals("ruleChainIdMSB", getResult.getName());
    assertEquals("ruleNodeIdLSB", toProtoResult8.getName());
    assertEquals("ruleNodeIdLSB", getResult4.getJsonName());
    assertEquals("ruleNodeIdLSB", getResult4.getName());
    assertEquals("ruleNodeIdMSB", toProtoResult7.getName());
    assertEquals("ruleNodeIdMSB", getResult3.getJsonName());
    assertEquals("ruleNodeIdMSB", getResult3.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("tbmsg.proto", nameBytes2.toStringUtf8());
    assertEquals("tbmsg.proto", toProtoResult2.getName());
    assertEquals("tbmsg.proto", file.getFullName());
    assertEquals("tbmsg.proto", file.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, toProtoResult8.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getNumber());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(125, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult4.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult6.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult7.getIndex());
    assertEquals(3, getResult4.getIndex());
    assertEquals(3, getResult3.getNumber());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult8.getNumber());
    assertEquals(4, toProtoResult2.getMessageTypeCount());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(952, toProtoResult2.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult8.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult8.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult8.getProto3Optional());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult8.hasDefaultValue());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult8.hasExtendee());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult8.hasJsonName());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult8.hasOneofIndex());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult8.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(toProtoResult8.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult8.hasLabel());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult8.hasType());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
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
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, toProtoResult5.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult6.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult7.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult8.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult5.getExtendeeBytes());
    assertEquals(byteString, toProtoResult6.getExtendeeBytes());
    assertEquals(byteString, toProtoResult7.getExtendeeBytes());
    assertEquals(byteString, toProtoResult8.getExtendeeBytes());
    assertEquals(byteString, toProtoResult5.getJsonNameBytes());
    assertEquals(byteString, toProtoResult6.getJsonNameBytes());
    assertEquals(byteString, toProtoResult7.getJsonNameBytes());
    assertEquals(byteString, toProtoResult8.getJsonNameBytes());
    assertEquals(byteString, toProtoResult5.getTypeNameBytes());
    assertEquals(byteString, toProtoResult6.getTypeNameBytes());
    assertEquals(byteString, toProtoResult7.getTypeNameBytes());
    assertEquals(byteString, toProtoResult8.getTypeNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
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
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult8.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(MsgProtos.TbMsgProto.METADATA_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals('M', iteratorResult5.next().byteValue());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('b', iteratorResult.next().byteValue());
    assertEquals('m', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('t', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom2() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult8.getDefaultValue());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult8.getExtendee());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult8.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", toProtoResult8.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("DescriptorProto", toProtoResult4.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MsgProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MsgProtos", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("TbMsgMetaDataProto", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(2);
    assertEquals("TbMsgProcessingCtxProto", getResult6.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("TbMsgProcessingStackItemProto", nameBytes.toStringUtf8());
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult.getName());
    assertEquals("TbMsgProcessingStackItemProto", descriptorForType.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(3);
    assertEquals("TbMsgProto", getResult7.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("msgqueue", packageBytes.toStringUtf8());
    assertEquals("msgqueue", toProtoResult2.getPackage());
    assertEquals("msgqueue", file.getPackage());
    assertEquals("msgqueue.TbMsgMetaDataProto", getResult5.getFullName());
    assertEquals("msgqueue.TbMsgProcessingCtxProto", getResult6.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", descriptorForType.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdLSB", getResult2.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdMSB", getResult.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdLSB", getResult4.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdMSB", getResult3.getFullName());
    assertEquals("msgqueue.TbMsgProto", getResult7.getFullName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.common.msg.gen", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.common.msg.gen", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("ruleChainIdLSB", toProtoResult6.getName());
    assertEquals("ruleChainIdLSB", getResult2.getJsonName());
    assertEquals("ruleChainIdLSB", getResult2.getName());
    assertEquals("ruleChainIdMSB", toProtoResult5.getName());
    assertEquals("ruleChainIdMSB", getResult.getJsonName());
    assertEquals("ruleChainIdMSB", getResult.getName());
    assertEquals("ruleNodeIdLSB", toProtoResult8.getName());
    assertEquals("ruleNodeIdLSB", getResult4.getJsonName());
    assertEquals("ruleNodeIdLSB", getResult4.getName());
    assertEquals("ruleNodeIdMSB", toProtoResult7.getName());
    assertEquals("ruleNodeIdMSB", getResult3.getJsonName());
    assertEquals("ruleNodeIdMSB", getResult3.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("tbmsg.proto", nameBytes2.toStringUtf8());
    assertEquals("tbmsg.proto", toProtoResult2.getName());
    assertEquals("tbmsg.proto", file.getFullName());
    assertEquals("tbmsg.proto", file.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, toProtoResult8.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getNumber());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(125, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult4.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult6.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult7.getIndex());
    assertEquals(3, getResult4.getIndex());
    assertEquals(3, getResult3.getNumber());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult8.getNumber());
    assertEquals(4, toProtoResult2.getMessageTypeCount());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(952, toProtoResult2.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult8.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult8.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult8.getProto3Optional());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult8.hasDefaultValue());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult8.hasExtendee());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult8.hasJsonName());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult8.hasOneofIndex());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult8.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(toProtoResult8.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult8.hasLabel());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult8.hasType());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
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
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, toProtoResult5.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult6.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult7.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult8.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult5.getExtendeeBytes());
    assertEquals(byteString, toProtoResult6.getExtendeeBytes());
    assertEquals(byteString, toProtoResult7.getExtendeeBytes());
    assertEquals(byteString, toProtoResult8.getExtendeeBytes());
    assertEquals(byteString, toProtoResult5.getJsonNameBytes());
    assertEquals(byteString, toProtoResult6.getJsonNameBytes());
    assertEquals(byteString, toProtoResult7.getJsonNameBytes());
    assertEquals(byteString, toProtoResult8.getJsonNameBytes());
    assertEquals(byteString, toProtoResult5.getTypeNameBytes());
    assertEquals(byteString, toProtoResult6.getTypeNameBytes());
    assertEquals(byteString, toProtoResult7.getTypeNameBytes());
    assertEquals(byteString, toProtoResult8.getTypeNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
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
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult8.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(MsgProtos.TbMsgProto.METADATA_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals('M', iteratorResult5.next().byteValue());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('b', iteratorResult.next().byteValue());
    assertEquals('m', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('t', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(CodedInputStream)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom3() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseFrom(input);

    // Assert
    verify(input).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult8.getDefaultValue());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult8.getExtendee());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult8.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", toProtoResult8.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("DescriptorProto", toProtoResult4.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MsgProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MsgProtos", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("TbMsgMetaDataProto", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(2);
    assertEquals("TbMsgProcessingCtxProto", getResult6.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("TbMsgProcessingStackItemProto", nameBytes.toStringUtf8());
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult.getName());
    assertEquals("TbMsgProcessingStackItemProto", descriptorForType.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(3);
    assertEquals("TbMsgProto", getResult7.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("msgqueue", packageBytes.toStringUtf8());
    assertEquals("msgqueue", toProtoResult2.getPackage());
    assertEquals("msgqueue", file.getPackage());
    assertEquals("msgqueue.TbMsgMetaDataProto", getResult5.getFullName());
    assertEquals("msgqueue.TbMsgProcessingCtxProto", getResult6.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", descriptorForType.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdLSB", getResult2.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdMSB", getResult.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdLSB", getResult4.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdMSB", getResult3.getFullName());
    assertEquals("msgqueue.TbMsgProto", getResult7.getFullName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.common.msg.gen", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.common.msg.gen", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("ruleChainIdLSB", toProtoResult6.getName());
    assertEquals("ruleChainIdLSB", getResult2.getJsonName());
    assertEquals("ruleChainIdLSB", getResult2.getName());
    assertEquals("ruleChainIdMSB", toProtoResult5.getName());
    assertEquals("ruleChainIdMSB", getResult.getJsonName());
    assertEquals("ruleChainIdMSB", getResult.getName());
    assertEquals("ruleNodeIdLSB", toProtoResult8.getName());
    assertEquals("ruleNodeIdLSB", getResult4.getJsonName());
    assertEquals("ruleNodeIdLSB", getResult4.getName());
    assertEquals("ruleNodeIdMSB", toProtoResult7.getName());
    assertEquals("ruleNodeIdMSB", getResult3.getJsonName());
    assertEquals("ruleNodeIdMSB", getResult3.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("tbmsg.proto", nameBytes2.toStringUtf8());
    assertEquals("tbmsg.proto", toProtoResult2.getName());
    assertEquals("tbmsg.proto", file.getFullName());
    assertEquals("tbmsg.proto", file.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, toProtoResult8.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getNumber());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(125, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult4.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult6.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult7.getIndex());
    assertEquals(3, getResult4.getIndex());
    assertEquals(3, getResult3.getNumber());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult8.getNumber());
    assertEquals(4, toProtoResult2.getMessageTypeCount());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(952, toProtoResult2.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult8.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult8.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult8.getProto3Optional());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult8.hasDefaultValue());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult8.hasExtendee());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult8.hasJsonName());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult8.hasOneofIndex());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult8.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(toProtoResult8.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult8.hasLabel());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult8.hasType());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
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
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult8.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(MsgProtos.TbMsgProto.METADATA_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals('M', iteratorResult5.next().byteValue());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('b', iteratorResult.next().byteValue());
    assertEquals('m', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('t', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom4() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult8.getDefaultValue());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult8.getExtendee());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult8.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", toProtoResult8.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("DescriptorProto", toProtoResult4.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MsgProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MsgProtos", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("TbMsgMetaDataProto", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(2);
    assertEquals("TbMsgProcessingCtxProto", getResult6.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("TbMsgProcessingStackItemProto", nameBytes.toStringUtf8());
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult.getName());
    assertEquals("TbMsgProcessingStackItemProto", descriptorForType.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(3);
    assertEquals("TbMsgProto", getResult7.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("msgqueue", packageBytes.toStringUtf8());
    assertEquals("msgqueue", toProtoResult2.getPackage());
    assertEquals("msgqueue", file.getPackage());
    assertEquals("msgqueue.TbMsgMetaDataProto", getResult5.getFullName());
    assertEquals("msgqueue.TbMsgProcessingCtxProto", getResult6.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", descriptorForType.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdLSB", getResult2.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdMSB", getResult.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdLSB", getResult4.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdMSB", getResult3.getFullName());
    assertEquals("msgqueue.TbMsgProto", getResult7.getFullName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.common.msg.gen", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.common.msg.gen", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("ruleChainIdLSB", toProtoResult6.getName());
    assertEquals("ruleChainIdLSB", getResult2.getJsonName());
    assertEquals("ruleChainIdLSB", getResult2.getName());
    assertEquals("ruleChainIdMSB", toProtoResult5.getName());
    assertEquals("ruleChainIdMSB", getResult.getJsonName());
    assertEquals("ruleChainIdMSB", getResult.getName());
    assertEquals("ruleNodeIdLSB", toProtoResult8.getName());
    assertEquals("ruleNodeIdLSB", getResult4.getJsonName());
    assertEquals("ruleNodeIdLSB", getResult4.getName());
    assertEquals("ruleNodeIdMSB", toProtoResult7.getName());
    assertEquals("ruleNodeIdMSB", getResult3.getJsonName());
    assertEquals("ruleNodeIdMSB", getResult3.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("tbmsg.proto", nameBytes2.toStringUtf8());
    assertEquals("tbmsg.proto", toProtoResult2.getName());
    assertEquals("tbmsg.proto", file.getFullName());
    assertEquals("tbmsg.proto", file.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, toProtoResult8.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getNumber());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(125, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult4.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult6.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult7.getIndex());
    assertEquals(3, getResult4.getIndex());
    assertEquals(3, getResult3.getNumber());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult8.getNumber());
    assertEquals(4, toProtoResult2.getMessageTypeCount());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(952, toProtoResult2.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult8.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult8.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult8.getProto3Optional());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult8.hasDefaultValue());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult8.hasExtendee());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult8.hasJsonName());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult8.hasOneofIndex());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult8.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(toProtoResult8.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult8.hasLabel());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult8.hasType());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
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
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult8.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(MsgProtos.TbMsgProto.METADATA_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals('M', iteratorResult5.next().byteValue());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('b', iteratorResult.next().byteValue());
    assertEquals('m', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('t', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(InputStream)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom5() throws IOException {
    // Arrange and Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult8.getDefaultValue());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult8.getExtendee());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult8.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", toProtoResult8.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("DescriptorProto", toProtoResult4.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MsgProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MsgProtos", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("TbMsgMetaDataProto", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(2);
    assertEquals("TbMsgProcessingCtxProto", getResult6.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("TbMsgProcessingStackItemProto", nameBytes.toStringUtf8());
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult.getName());
    assertEquals("TbMsgProcessingStackItemProto", descriptorForType.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(3);
    assertEquals("TbMsgProto", getResult7.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("msgqueue", packageBytes.toStringUtf8());
    assertEquals("msgqueue", toProtoResult2.getPackage());
    assertEquals("msgqueue", file.getPackage());
    assertEquals("msgqueue.TbMsgMetaDataProto", getResult5.getFullName());
    assertEquals("msgqueue.TbMsgProcessingCtxProto", getResult6.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", descriptorForType.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdLSB", getResult2.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdMSB", getResult.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdLSB", getResult4.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdMSB", getResult3.getFullName());
    assertEquals("msgqueue.TbMsgProto", getResult7.getFullName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.common.msg.gen", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.common.msg.gen", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("ruleChainIdLSB", toProtoResult6.getName());
    assertEquals("ruleChainIdLSB", getResult2.getJsonName());
    assertEquals("ruleChainIdLSB", getResult2.getName());
    assertEquals("ruleChainIdMSB", toProtoResult5.getName());
    assertEquals("ruleChainIdMSB", getResult.getJsonName());
    assertEquals("ruleChainIdMSB", getResult.getName());
    assertEquals("ruleNodeIdLSB", toProtoResult8.getName());
    assertEquals("ruleNodeIdLSB", getResult4.getJsonName());
    assertEquals("ruleNodeIdLSB", getResult4.getName());
    assertEquals("ruleNodeIdMSB", toProtoResult7.getName());
    assertEquals("ruleNodeIdMSB", getResult3.getJsonName());
    assertEquals("ruleNodeIdMSB", getResult3.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("tbmsg.proto", nameBytes2.toStringUtf8());
    assertEquals("tbmsg.proto", toProtoResult2.getName());
    assertEquals("tbmsg.proto", file.getFullName());
    assertEquals("tbmsg.proto", file.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, toProtoResult8.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getNumber());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(125, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult4.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult6.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult7.getIndex());
    assertEquals(3, getResult4.getIndex());
    assertEquals(3, getResult3.getNumber());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult8.getNumber());
    assertEquals(4, toProtoResult2.getMessageTypeCount());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(952, toProtoResult2.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult8.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult8.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult8.getProto3Optional());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult8.hasDefaultValue());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult8.hasExtendee());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult8.hasJsonName());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult8.hasOneofIndex());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult8.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(toProtoResult8.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult8.hasLabel());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult8.hasType());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
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
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult8.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(MsgProtos.TbMsgProto.METADATA_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals('M', iteratorResult5.next().byteValue());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('b', iteratorResult.next().byteValue());
    assertEquals('m', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('t', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(InputStream)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MsgProtos.TbMsgProcessingStackItemProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(InputStream)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MsgProtos.TbMsgProcessingStackItemProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(InputStream)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom8() throws IOException {
    // Arrange and Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult8.getDefaultValue());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult8.getExtendee());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult8.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", toProtoResult8.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("DescriptorProto", toProtoResult4.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MsgProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MsgProtos", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("TbMsgMetaDataProto", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(2);
    assertEquals("TbMsgProcessingCtxProto", getResult6.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("TbMsgProcessingStackItemProto", nameBytes.toStringUtf8());
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult.getName());
    assertEquals("TbMsgProcessingStackItemProto", descriptorForType.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(3);
    assertEquals("TbMsgProto", getResult7.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("msgqueue", packageBytes.toStringUtf8());
    assertEquals("msgqueue", toProtoResult2.getPackage());
    assertEquals("msgqueue", file.getPackage());
    assertEquals("msgqueue.TbMsgMetaDataProto", getResult5.getFullName());
    assertEquals("msgqueue.TbMsgProcessingCtxProto", getResult6.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", descriptorForType.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdLSB", getResult2.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdMSB", getResult.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdLSB", getResult4.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdMSB", getResult3.getFullName());
    assertEquals("msgqueue.TbMsgProto", getResult7.getFullName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.common.msg.gen", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.common.msg.gen", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("ruleChainIdLSB", toProtoResult6.getName());
    assertEquals("ruleChainIdLSB", getResult2.getJsonName());
    assertEquals("ruleChainIdLSB", getResult2.getName());
    assertEquals("ruleChainIdMSB", toProtoResult5.getName());
    assertEquals("ruleChainIdMSB", getResult.getJsonName());
    assertEquals("ruleChainIdMSB", getResult.getName());
    assertEquals("ruleNodeIdLSB", toProtoResult8.getName());
    assertEquals("ruleNodeIdLSB", getResult4.getJsonName());
    assertEquals("ruleNodeIdLSB", getResult4.getName());
    assertEquals("ruleNodeIdMSB", toProtoResult7.getName());
    assertEquals("ruleNodeIdMSB", getResult3.getJsonName());
    assertEquals("ruleNodeIdMSB", getResult3.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("tbmsg.proto", nameBytes2.toStringUtf8());
    assertEquals("tbmsg.proto", toProtoResult2.getName());
    assertEquals("tbmsg.proto", file.getFullName());
    assertEquals("tbmsg.proto", file.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, toProtoResult8.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getNumber());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(125, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult4.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult6.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult7.getIndex());
    assertEquals(3, getResult4.getIndex());
    assertEquals(3, getResult3.getNumber());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult8.getNumber());
    assertEquals(4, toProtoResult2.getMessageTypeCount());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(952, toProtoResult2.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult8.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult8.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult8.getProto3Optional());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult8.hasDefaultValue());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult8.hasExtendee());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult8.hasJsonName());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult8.hasOneofIndex());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult8.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(toProtoResult8.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult8.hasLabel());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult8.hasType());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
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
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult8.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(MsgProtos.TbMsgProto.METADATA_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals('M', iteratorResult5.next().byteValue());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('b', iteratorResult.next().byteValue());
    assertEquals('m', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('t', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom9() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult8.getDefaultValue());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult8.getExtendee());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult8.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", toProtoResult8.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("DescriptorProto", toProtoResult4.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MsgProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MsgProtos", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("TbMsgMetaDataProto", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(2);
    assertEquals("TbMsgProcessingCtxProto", getResult6.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("TbMsgProcessingStackItemProto", nameBytes.toStringUtf8());
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult.getName());
    assertEquals("TbMsgProcessingStackItemProto", descriptorForType.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(3);
    assertEquals("TbMsgProto", getResult7.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("msgqueue", packageBytes.toStringUtf8());
    assertEquals("msgqueue", toProtoResult2.getPackage());
    assertEquals("msgqueue", file.getPackage());
    assertEquals("msgqueue.TbMsgMetaDataProto", getResult5.getFullName());
    assertEquals("msgqueue.TbMsgProcessingCtxProto", getResult6.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", descriptorForType.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdLSB", getResult2.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdMSB", getResult.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdLSB", getResult4.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdMSB", getResult3.getFullName());
    assertEquals("msgqueue.TbMsgProto", getResult7.getFullName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.common.msg.gen", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.common.msg.gen", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("ruleChainIdLSB", toProtoResult6.getName());
    assertEquals("ruleChainIdLSB", getResult2.getJsonName());
    assertEquals("ruleChainIdLSB", getResult2.getName());
    assertEquals("ruleChainIdMSB", toProtoResult5.getName());
    assertEquals("ruleChainIdMSB", getResult.getJsonName());
    assertEquals("ruleChainIdMSB", getResult.getName());
    assertEquals("ruleNodeIdLSB", toProtoResult8.getName());
    assertEquals("ruleNodeIdLSB", getResult4.getJsonName());
    assertEquals("ruleNodeIdLSB", getResult4.getName());
    assertEquals("ruleNodeIdMSB", toProtoResult7.getName());
    assertEquals("ruleNodeIdMSB", getResult3.getJsonName());
    assertEquals("ruleNodeIdMSB", getResult3.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("tbmsg.proto", nameBytes2.toStringUtf8());
    assertEquals("tbmsg.proto", toProtoResult2.getName());
    assertEquals("tbmsg.proto", file.getFullName());
    assertEquals("tbmsg.proto", file.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, toProtoResult8.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getNumber());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(125, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult4.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult6.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult7.getIndex());
    assertEquals(3, getResult4.getIndex());
    assertEquals(3, getResult3.getNumber());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult8.getNumber());
    assertEquals(4, toProtoResult2.getMessageTypeCount());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(952, toProtoResult2.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult8.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult8.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult8.getProto3Optional());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult8.hasDefaultValue());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult8.hasExtendee());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult8.hasJsonName());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult8.hasOneofIndex());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult8.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(toProtoResult8.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult8.hasLabel());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult8.hasType());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
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
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult8.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(MsgProtos.TbMsgProto.METADATA_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals('M', iteratorResult5.next().byteValue());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('b', iteratorResult.next().byteValue());
    assertEquals('m', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('t', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom10() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MsgProtos.TbMsgProcessingStackItemProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom11() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MsgProtos.TbMsgProcessingStackItemProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(ByteBuffer)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom12() throws InvalidProtocolBufferException {
    // Arrange and Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult8.getDefaultValue());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult8.getExtendee());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult8.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", toProtoResult8.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("DescriptorProto", toProtoResult4.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MsgProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MsgProtos", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("TbMsgMetaDataProto", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(2);
    assertEquals("TbMsgProcessingCtxProto", getResult6.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("TbMsgProcessingStackItemProto", nameBytes.toStringUtf8());
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult.getName());
    assertEquals("TbMsgProcessingStackItemProto", descriptorForType.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(3);
    assertEquals("TbMsgProto", getResult7.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("msgqueue", packageBytes.toStringUtf8());
    assertEquals("msgqueue", toProtoResult2.getPackage());
    assertEquals("msgqueue", file.getPackage());
    assertEquals("msgqueue.TbMsgMetaDataProto", getResult5.getFullName());
    assertEquals("msgqueue.TbMsgProcessingCtxProto", getResult6.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", descriptorForType.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdLSB", getResult2.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdMSB", getResult.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdLSB", getResult4.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdMSB", getResult3.getFullName());
    assertEquals("msgqueue.TbMsgProto", getResult7.getFullName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.common.msg.gen", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.common.msg.gen", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("ruleChainIdLSB", toProtoResult6.getName());
    assertEquals("ruleChainIdLSB", getResult2.getJsonName());
    assertEquals("ruleChainIdLSB", getResult2.getName());
    assertEquals("ruleChainIdMSB", toProtoResult5.getName());
    assertEquals("ruleChainIdMSB", getResult.getJsonName());
    assertEquals("ruleChainIdMSB", getResult.getName());
    assertEquals("ruleNodeIdLSB", toProtoResult8.getName());
    assertEquals("ruleNodeIdLSB", getResult4.getJsonName());
    assertEquals("ruleNodeIdLSB", getResult4.getName());
    assertEquals("ruleNodeIdMSB", toProtoResult7.getName());
    assertEquals("ruleNodeIdMSB", getResult3.getJsonName());
    assertEquals("ruleNodeIdMSB", getResult3.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("tbmsg.proto", nameBytes2.toStringUtf8());
    assertEquals("tbmsg.proto", toProtoResult2.getName());
    assertEquals("tbmsg.proto", file.getFullName());
    assertEquals("tbmsg.proto", file.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, toProtoResult8.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getNumber());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(125, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult4.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult6.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult7.getIndex());
    assertEquals(3, getResult4.getIndex());
    assertEquals(3, getResult3.getNumber());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult8.getNumber());
    assertEquals(4, toProtoResult2.getMessageTypeCount());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(952, toProtoResult2.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult8.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult8.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult8.getProto3Optional());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult8.hasDefaultValue());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult8.hasExtendee());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult8.hasJsonName());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult8.hasOneofIndex());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult8.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(toProtoResult8.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult8.hasLabel());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult8.hasType());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
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
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult8.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(MsgProtos.TbMsgProto.METADATA_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals('M', iteratorResult5.next().byteValue());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('b', iteratorResult.next().byteValue());
    assertEquals('m', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('t', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom13() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult8.getDefaultValue());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult8.getExtendee());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult8.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", toProtoResult8.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("DescriptorProto", toProtoResult4.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MsgProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MsgProtos", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("TbMsgMetaDataProto", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(2);
    assertEquals("TbMsgProcessingCtxProto", getResult6.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("TbMsgProcessingStackItemProto", nameBytes.toStringUtf8());
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult.getName());
    assertEquals("TbMsgProcessingStackItemProto", descriptorForType.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(3);
    assertEquals("TbMsgProto", getResult7.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("msgqueue", packageBytes.toStringUtf8());
    assertEquals("msgqueue", toProtoResult2.getPackage());
    assertEquals("msgqueue", file.getPackage());
    assertEquals("msgqueue.TbMsgMetaDataProto", getResult5.getFullName());
    assertEquals("msgqueue.TbMsgProcessingCtxProto", getResult6.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", descriptorForType.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdLSB", getResult2.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdMSB", getResult.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdLSB", getResult4.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdMSB", getResult3.getFullName());
    assertEquals("msgqueue.TbMsgProto", getResult7.getFullName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.common.msg.gen", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.common.msg.gen", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("ruleChainIdLSB", toProtoResult6.getName());
    assertEquals("ruleChainIdLSB", getResult2.getJsonName());
    assertEquals("ruleChainIdLSB", getResult2.getName());
    assertEquals("ruleChainIdMSB", toProtoResult5.getName());
    assertEquals("ruleChainIdMSB", getResult.getJsonName());
    assertEquals("ruleChainIdMSB", getResult.getName());
    assertEquals("ruleNodeIdLSB", toProtoResult8.getName());
    assertEquals("ruleNodeIdLSB", getResult4.getJsonName());
    assertEquals("ruleNodeIdLSB", getResult4.getName());
    assertEquals("ruleNodeIdMSB", toProtoResult7.getName());
    assertEquals("ruleNodeIdMSB", getResult3.getJsonName());
    assertEquals("ruleNodeIdMSB", getResult3.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("tbmsg.proto", nameBytes2.toStringUtf8());
    assertEquals("tbmsg.proto", toProtoResult2.getName());
    assertEquals("tbmsg.proto", file.getFullName());
    assertEquals("tbmsg.proto", file.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, toProtoResult8.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getNumber());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(125, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult4.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult6.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult7.getIndex());
    assertEquals(3, getResult4.getIndex());
    assertEquals(3, getResult3.getNumber());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult8.getNumber());
    assertEquals(4, toProtoResult2.getMessageTypeCount());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(952, toProtoResult2.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult8.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult8.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult8.getProto3Optional());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult8.hasDefaultValue());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult8.hasExtendee());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult8.hasJsonName());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult8.hasOneofIndex());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult8.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(toProtoResult8.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult8.hasLabel());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult8.hasType());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
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
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult8.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(MsgProtos.TbMsgProto.METADATA_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals('M', iteratorResult5.next().byteValue());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('b', iteratorResult.next().byteValue());
    assertEquals('m', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('t', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(byte[])}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom14() throws InvalidProtocolBufferException {
    // Arrange and Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseFrom(new byte[]{});

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult8.getDefaultValue());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult8.getExtendee());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult8.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", toProtoResult8.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("DescriptorProto", toProtoResult4.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MsgProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MsgProtos", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("TbMsgMetaDataProto", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(2);
    assertEquals("TbMsgProcessingCtxProto", getResult6.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("TbMsgProcessingStackItemProto", nameBytes.toStringUtf8());
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult.getName());
    assertEquals("TbMsgProcessingStackItemProto", descriptorForType.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(3);
    assertEquals("TbMsgProto", getResult7.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("msgqueue", packageBytes.toStringUtf8());
    assertEquals("msgqueue", toProtoResult2.getPackage());
    assertEquals("msgqueue", file.getPackage());
    assertEquals("msgqueue.TbMsgMetaDataProto", getResult5.getFullName());
    assertEquals("msgqueue.TbMsgProcessingCtxProto", getResult6.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", descriptorForType.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdLSB", getResult2.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdMSB", getResult.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdLSB", getResult4.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdMSB", getResult3.getFullName());
    assertEquals("msgqueue.TbMsgProto", getResult7.getFullName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.common.msg.gen", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.common.msg.gen", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("ruleChainIdLSB", toProtoResult6.getName());
    assertEquals("ruleChainIdLSB", getResult2.getJsonName());
    assertEquals("ruleChainIdLSB", getResult2.getName());
    assertEquals("ruleChainIdMSB", toProtoResult5.getName());
    assertEquals("ruleChainIdMSB", getResult.getJsonName());
    assertEquals("ruleChainIdMSB", getResult.getName());
    assertEquals("ruleNodeIdLSB", toProtoResult8.getName());
    assertEquals("ruleNodeIdLSB", getResult4.getJsonName());
    assertEquals("ruleNodeIdLSB", getResult4.getName());
    assertEquals("ruleNodeIdMSB", toProtoResult7.getName());
    assertEquals("ruleNodeIdMSB", getResult3.getJsonName());
    assertEquals("ruleNodeIdMSB", getResult3.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("tbmsg.proto", nameBytes2.toStringUtf8());
    assertEquals("tbmsg.proto", toProtoResult2.getName());
    assertEquals("tbmsg.proto", file.getFullName());
    assertEquals("tbmsg.proto", file.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, toProtoResult8.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getNumber());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(125, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult4.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult6.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult7.getIndex());
    assertEquals(3, getResult4.getIndex());
    assertEquals(3, getResult3.getNumber());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult8.getNumber());
    assertEquals(4, toProtoResult2.getMessageTypeCount());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(952, toProtoResult2.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult8.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult8.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult8.getProto3Optional());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult8.hasDefaultValue());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult8.hasExtendee());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult8.hasJsonName());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult8.hasOneofIndex());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult8.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(toProtoResult8.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult8.hasLabel());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult8.hasType());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
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
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult8.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(MsgProtos.TbMsgProto.METADATA_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals('M', iteratorResult5.next().byteValue());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('b', iteratorResult.next().byteValue());
    assertEquals('m', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('t', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProcessingStackItemProtoParseFrom15() throws InvalidProtocolBufferException {
    // Arrange and Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult8.getDefaultValue());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult8.getExtendee());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult8.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", toProtoResult8.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("DescriptorProto", toProtoResult4.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MsgProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MsgProtos", options.getJavaOuterClassname());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals("TbMsgMetaDataProto", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(2);
    assertEquals("TbMsgProcessingCtxProto", getResult6.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("TbMsgProcessingStackItemProto", nameBytes.toStringUtf8());
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult.getName());
    assertEquals("TbMsgProcessingStackItemProto", descriptorForType.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(3);
    assertEquals("TbMsgProto", getResult7.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("msgqueue", packageBytes.toStringUtf8());
    assertEquals("msgqueue", toProtoResult2.getPackage());
    assertEquals("msgqueue", file.getPackage());
    assertEquals("msgqueue.TbMsgMetaDataProto", getResult5.getFullName());
    assertEquals("msgqueue.TbMsgProcessingCtxProto", getResult6.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", descriptorForType.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdLSB", getResult2.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleChainIdMSB", getResult.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdLSB", getResult4.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto.ruleNodeIdMSB", getResult3.getFullName());
    assertEquals("msgqueue.TbMsgProto", getResult7.getFullName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.common.msg.gen", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.common.msg.gen", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("ruleChainIdLSB", toProtoResult6.getName());
    assertEquals("ruleChainIdLSB", getResult2.getJsonName());
    assertEquals("ruleChainIdLSB", getResult2.getName());
    assertEquals("ruleChainIdMSB", toProtoResult5.getName());
    assertEquals("ruleChainIdMSB", getResult.getJsonName());
    assertEquals("ruleChainIdMSB", getResult.getName());
    assertEquals("ruleNodeIdLSB", toProtoResult8.getName());
    assertEquals("ruleNodeIdLSB", getResult4.getJsonName());
    assertEquals("ruleNodeIdLSB", getResult4.getName());
    assertEquals("ruleNodeIdMSB", toProtoResult7.getName());
    assertEquals("ruleNodeIdMSB", getResult3.getJsonName());
    assertEquals("ruleNodeIdMSB", getResult3.getName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("tbmsg.proto", nameBytes2.toStringUtf8());
    assertEquals("tbmsg.proto", toProtoResult2.getName());
    assertEquals("tbmsg.proto", file.getFullName());
    assertEquals("tbmsg.proto", file.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, toProtoResult8.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult5.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult5.getNumber());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(125, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult4.getNestedTypeCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult6.getIndex());
    assertEquals(2, getResult3.getIndex());
    assertEquals(2, getResult2.getNumber());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, toProtoResult.getAllFields().size());
    assertEquals(2, options.getAllFields().size());
    assertEquals(2, options.getAllFieldsRaw().size());
    assertEquals(3, toProtoResult7.getNumber());
    assertEquals(3, getResult7.getIndex());
    assertEquals(3, getResult4.getIndex());
    assertEquals(3, getResult3.getNumber());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult8.getNumber());
    assertEquals(4, toProtoResult2.getMessageTypeCount());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(952, toProtoResult2.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult8.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult8.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult4.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(WireFormat.FieldType.INT64, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult4.getLiteType());
    assertEquals(WireFormat.JavaType.LONG, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult4.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult8.getProto3Optional());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult8.hasDefaultValue());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult8.hasExtendee());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult8.hasJsonName());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult8.hasOneofIndex());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult8.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(toProtoResult8.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult8.hasLabel());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult8.hasNumber());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult8.hasType());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
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
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult8.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, options3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields, options3.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, toProtoResult8.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(MsgProtos.TbMsgProto.METADATA_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(MsgProtos.TbMsgProto.PARTITION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals('M', iteratorResult5.next().byteValue());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('b', iteratorResult.next().byteValue());
    assertEquals('m', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('t', iteratorResult2.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgProto#hashCode()}
   * </ul>
   */
  @Test
  void testTbMsgProtoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MsgProtos.TbMsgProto defaultInstance = MsgProtos.TbMsgProto.getDefaultInstance();
    MsgProtos.TbMsgProto defaultInstance2 = MsgProtos.TbMsgProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgProto#hashCode()}
   * </ul>
   */
  @Test
  void testTbMsgProtoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MsgProtos.TbMsgProto defaultInstance = MsgProtos.TbMsgProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#equals(Object)}
   */
  @Test
  void testTbMsgProtoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProto.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#equals(Object)}
   */
  @Test
  void testTbMsgProtoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProto.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#equals(Object)}
   */
  @Test
  void testTbMsgProtoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProto.getDefaultInstance(), "Different type to TbMsgProto");
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#getData()}
   */
  @Test
  void testTbMsgProtoGetData() {
    // Arrange, Act and Assert
    assertEquals("", MsgProtos.TbMsgProto.getDefaultInstance().getData());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#getDataBytes()}
   */
  @Test
  void testTbMsgProtoGetDataBytes() {
    // Arrange
    MsgProtos.TbMsgProto defaultInstance = MsgProtos.TbMsgProto.getDefaultInstance();

    // Act
    ByteString actualDataBytes = defaultInstance.getDataBytes();

    // Assert
    ByteString byteString = actualDataBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields
        .get(MsgProtos.TbMsgProto.CORRELATIONIDMSB_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER).toProto();
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
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualDataBytes);
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#getDefaultInstanceForType()}
   */
  @Test
  void testTbMsgProtoGetDefaultInstanceForType() {
    // Arrange
    MsgProtos.TbMsgProto defaultInstance = MsgProtos.TbMsgProto.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#getEntityType()}
   */
  @Test
  void testTbMsgProtoGetEntityType() {
    // Arrange, Act and Assert
    assertEquals("", MsgProtos.TbMsgProto.getDefaultInstance().getEntityType());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#getEntityTypeBytes()}
   */
  @Test
  void testTbMsgProtoGetEntityTypeBytes() {
    // Arrange
    MsgProtos.TbMsgProto defaultInstance = MsgProtos.TbMsgProto.getDefaultInstance();

    // Act
    ByteString actualEntityTypeBytes = defaultInstance.getEntityTypeBytes();

    // Assert
    ByteString byteString = actualEntityTypeBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields
        .get(MsgProtos.TbMsgProto.CORRELATIONIDMSB_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER).toProto();
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
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDataBytes());
    assertEquals(byteString, actualEntityTypeBytes);
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#getId()}
   */
  @Test
  void testTbMsgProtoGetId() {
    // Arrange, Act and Assert
    assertEquals("", MsgProtos.TbMsgProto.getDefaultInstance().getId());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#getIdBytes()}
   */
  @Test
  void testTbMsgProtoGetIdBytes() {
    // Arrange
    MsgProtos.TbMsgProto defaultInstance = MsgProtos.TbMsgProto.getDefaultInstance();

    // Act
    ByteString actualIdBytes = defaultInstance.getIdBytes();

    // Assert
    ByteString byteString = actualIdBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields
        .get(MsgProtos.TbMsgProto.CORRELATIONIDMSB_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER).toProto();
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
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDataBytes());
    assertEquals(byteString, actualIdBytes);
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#getSerializedSize()}
   */
  @Test
  void testTbMsgProtoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MsgProtos.TbMsgProto.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#getType()}
   */
  @Test
  void testTbMsgProtoGetType() {
    // Arrange, Act and Assert
    assertEquals("", MsgProtos.TbMsgProto.getDefaultInstance().getType());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#getTypeBytes()}
   */
  @Test
  void testTbMsgProtoGetTypeBytes() {
    // Arrange
    MsgProtos.TbMsgProto defaultInstance = MsgProtos.TbMsgProto.getDefaultInstance();

    // Act
    ByteString actualTypeBytes = defaultInstance.getTypeBytes();

    // Assert
    ByteString byteString = actualTypeBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields
        .get(MsgProtos.TbMsgProto.CORRELATIONIDMSB_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER).toProto();
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
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDataBytes());
    assertEquals(byteString, actualTypeBytes);
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#hasCtx()}
   */
  @Test
  void testTbMsgProtoHasCtx() {
    // Arrange, Act and Assert
    assertFalse(MsgProtos.TbMsgProto.getDefaultInstance().hasCtx());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#hasMetaData()}
   */
  @Test
  void testTbMsgProtoHasMetaData() {
    // Arrange, Act and Assert
    assertFalse(MsgProtos.TbMsgProto.getDefaultInstance().hasMetaData());
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#isInitialized()}
   */
  @Test
  void testTbMsgProtoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MsgProtos.TbMsgProto.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProto#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testTbMsgProtoNewInstance() {
    // Arrange
    MsgProtos.TbMsgProto defaultInstance = MsgProtos.TbMsgProto.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof MsgProtos.TbMsgProto);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgProtoParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MsgProtos.TbMsgProto.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgProtoParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MsgProtos.TbMsgProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgProtoParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MsgProtos.TbMsgProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testTbMsgProtoParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MsgProtos.TbMsgProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProtoParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MsgProtos.TbMsgProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProtoParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> MsgProtos.TbMsgProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProtoParseDelimitedFrom7() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MsgProtos.TbMsgProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProtoParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> MsgProtos.TbMsgProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#parseFrom(InputStream)}
   */
  @Test
  void testTbMsgProtoParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MsgProtos.TbMsgProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link MsgProtos.TbMsgProto#parseFrom(InputStream)}
   */
  @Test
  void testTbMsgProtoParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MsgProtos.TbMsgProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProtoParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MsgProtos.TbMsgProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testTbMsgProtoParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MsgProtos.TbMsgProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
