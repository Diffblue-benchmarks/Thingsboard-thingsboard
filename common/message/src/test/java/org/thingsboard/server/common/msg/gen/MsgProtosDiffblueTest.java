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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
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
import org.thingsboard.server.common.msg.gen.MsgProtos.TbMsgMetaDataProto;
import org.thingsboard.server.common.msg.gen.MsgProtos.TbMsgProcessingCtxProto;
import org.thingsboard.server.common.msg.gen.MsgProtos.TbMsgProcessingStackItemProto;
import org.thingsboard.server.common.msg.gen.MsgProtos.TbMsgProto;

class MsgProtosDiffblueTest {
  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#containsData(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#containsData(String)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto containsData(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgMetaDataProto.containsData(String)"})
  void testTbMsgMetaDataProtoContainsData_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(TbMsgMetaDataProto.getDefaultInstance().containsData("Key"));
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#equals(Object)}, and {@link TbMsgMetaDataProto#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgMetaDataProto#equals(Object)}
   *   <li>{@link TbMsgMetaDataProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgMetaDataProto.equals(Object)", "int TbMsgMetaDataProto.hashCode()"})
  void testTbMsgMetaDataProtoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgMetaDataProto defaultInstance = TbMsgMetaDataProto.getDefaultInstance();
    TbMsgMetaDataProto defaultInstance2 = TbMsgMetaDataProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#equals(Object)}, and {@link TbMsgMetaDataProto#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgMetaDataProto#equals(Object)}
   *   <li>{@link TbMsgMetaDataProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgMetaDataProto.equals(Object)", "int TbMsgMetaDataProto.hashCode()"})
  void testTbMsgMetaDataProtoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgMetaDataProto defaultInstance = TbMsgMetaDataProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgMetaDataProto.equals(Object)", "int TbMsgMetaDataProto.hashCode()"})
  void testTbMsgMetaDataProtoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgMetaDataProto.getDefaultInstance(), 1);
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgMetaDataProto.equals(Object)", "int TbMsgMetaDataProto.hashCode()"})
  void testTbMsgMetaDataProtoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgMetaDataProto.getDefaultInstance(), null);
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgMetaDataProto.equals(Object)", "int TbMsgMetaDataProto.hashCode()"})
  void testTbMsgMetaDataProtoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgMetaDataProto.getDefaultInstance(), "Different type to TbMsgMetaDataProto");
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#getData()}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#getData()}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto getData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map TbMsgMetaDataProto.getData()"})
  void testTbMsgMetaDataProtoGetData() {
    // Arrange, Act and Assert
    assertTrue(TbMsgMetaDataProto.getDefaultInstance().getData().isEmpty());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#getDataCount()}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#getDataCount()}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto getDataCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TbMsgMetaDataProto.getDataCount()"})
  void testTbMsgMetaDataProtoGetDataCount() {
    // Arrange, Act and Assert
    assertEquals(0, TbMsgMetaDataProto.getDefaultInstance().getDataCount());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#getDataMap()}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#getDataMap()}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto getDataMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map TbMsgMetaDataProto.getDataMap()"})
  void testTbMsgMetaDataProtoGetDataMap() {
    // Arrange, Act and Assert
    assertTrue(TbMsgMetaDataProto.getDefaultInstance().getDataMap().isEmpty());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#getDataOrDefault(String, String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#getDataOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto getDataOrDefault(String, String); when 'Key'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbMsgMetaDataProto.getDataOrDefault(String, String)"})
  void testTbMsgMetaDataProtoGetDataOrDefault_whenKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", TbMsgMetaDataProto.getDefaultInstance().getDataOrDefault("Key", "42"));
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#getDataOrThrow(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#getDataOrThrow(String)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto getDataOrThrow(String); when 'Key'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbMsgMetaDataProto.getDataOrThrow(String)"})
  void testTbMsgMetaDataProtoGetDataOrThrow_whenKey_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbMsgMetaDataProto.getDefaultInstance().getDataOrThrow("Key"));
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.getDefaultInstanceForType()"})
  void testTbMsgMetaDataProtoGetDefaultInstanceForType() {
    // Arrange
    TbMsgMetaDataProto defaultInstance = TbMsgMetaDataProto.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#getSerializedSize()}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#getSerializedSize()}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TbMsgMetaDataProto.getSerializedSize()"})
  void testTbMsgMetaDataProtoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TbMsgMetaDataProto.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto internalGetMapFieldReflection(int); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor TbMsgMetaDataProto.internalGetMapFieldReflection(int)"})
  void testTbMsgMetaDataProtoInternalGetMapFieldReflection_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> TbMsgMetaDataProto.getDefaultInstance()
        .internalGetMapFieldReflection(TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER));
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto internalGetMapFieldReflection(int); when one; then return MapField")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MapFieldReflectionAccessor TbMsgMetaDataProto.internalGetMapFieldReflection(int)"})
  void testTbMsgMetaDataProtoInternalGetMapFieldReflection_whenOne_thenReturnMapField() {
    // Arrange and Act
    MapFieldReflectionAccessor actualInternalGetMapFieldReflectionResult = TbMsgMetaDataProto.getDefaultInstance()
        .internalGetMapFieldReflection(1);

    // Assert
    assertTrue(actualInternalGetMapFieldReflectionResult instanceof MapField);
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).isMutable());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMap().isEmpty());
    assertTrue(((MapField<Object, Object>) actualInternalGetMapFieldReflectionResult).getMutableMap().isEmpty());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#isInitialized()}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#isInitialized()}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgMetaDataProto.isInitialized()"})
  void testTbMsgMetaDataProtoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TbMsgMetaDataProto.getDefaultInstance().isInitialized());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgMetaDataProtoParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TbMsgMetaDataProto actualParseDelimitedFromResult = TbMsgMetaDataProto.parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getDataCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getData().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getDataMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgMetaDataProtoParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TbMsgMetaDataProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgMetaDataProtoParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TbMsgMetaDataProto actualParseDelimitedFromResult = TbMsgMetaDataProto.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getDataCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getData().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getDataMap().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgMetaDataProtoParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TbMsgMetaDataProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgMetaDataProtoParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> TbMsgMetaDataProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgMetaDataProtoParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TbMsgMetaDataProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgMetaDataProtoParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TbMsgMetaDataProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgMetaDataProtoParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TbMsgMetaDataProto.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgMetaDataProtoParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TbMsgMetaDataProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgMetaDataProtoParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new RuntimeException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> TbMsgMetaDataProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseFrom(byte[])"})
  void testTbMsgMetaDataProtoParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    TbMsgMetaDataProto actualParseFromResult = TbMsgMetaDataProto.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getDataCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getData().isEmpty());
    assertTrue(actualParseFromResult.getDataMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseFrom(ByteBuffer)"})
  void testTbMsgMetaDataProtoParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    TbMsgMetaDataProto actualParseFromResult = TbMsgMetaDataProto.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getDataCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getData().isEmpty());
    assertTrue(actualParseFromResult.getDataMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testTbMsgMetaDataProtoParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    TbMsgMetaDataProto actualParseFromResult = TbMsgMetaDataProto.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getDataCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getData().isEmpty());
    assertTrue(actualParseFromResult.getDataMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseFrom(byte[], ExtensionRegistryLite)"})
  void testTbMsgMetaDataProtoParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    TbMsgMetaDataProto actualParseFromResult = TbMsgMetaDataProto.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getDataCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getData().isEmpty());
    assertTrue(actualParseFromResult.getDataMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseFrom(InputStream)"})
  void testTbMsgMetaDataProtoParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TbMsgMetaDataProto actualParseFromResult = TbMsgMetaDataProto.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getFields().size());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseFrom(InputStream)"})
  void testTbMsgMetaDataProtoParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TbMsgMetaDataProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgMetaDataProtoParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    TbMsgMetaDataProto actualParseFromResult = TbMsgMetaDataProto.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getDataCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.getData().isEmpty());
    assertTrue(actualParseFromResult.getDataMap().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgMetaDataProtoParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TbMsgMetaDataProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgMetaDataProtoParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TbMsgMetaDataProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseFrom(InputStream)"})
  void testTbMsgMetaDataProtoParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TbMsgMetaDataProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgMetaDataProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgMetaDataProto.parseFrom(InputStream)"})
  void testTbMsgMetaDataProtoParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TbMsgMetaDataProto actualParseFromResult = TbMsgMetaDataProto.parseFrom((InputStream) null);

    // Assert
    Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    assertEquals(1, descriptorForType.getFields().size());
    assertEquals(1, descriptorForType.getNestedTypes().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#equals(Object)}, and {@link TbMsgProcessingCtxProto#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgProcessingCtxProto#equals(Object)}
   *   <li>{@link TbMsgProcessingCtxProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProcessingCtxProto.equals(Object)", "int TbMsgProcessingCtxProto.hashCode()"})
  void testTbMsgProcessingCtxProtoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgProcessingCtxProto defaultInstance = TbMsgProcessingCtxProto.getDefaultInstance();
    TbMsgProcessingCtxProto defaultInstance2 = TbMsgProcessingCtxProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#equals(Object)}, and {@link TbMsgProcessingCtxProto#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgProcessingCtxProto#equals(Object)}
   *   <li>{@link TbMsgProcessingCtxProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProcessingCtxProto.equals(Object)", "int TbMsgProcessingCtxProto.hashCode()"})
  void testTbMsgProcessingCtxProtoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgProcessingCtxProto defaultInstance = TbMsgProcessingCtxProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProcessingCtxProto.equals(Object)", "int TbMsgProcessingCtxProto.hashCode()"})
  void testTbMsgProcessingCtxProtoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgProcessingCtxProto.getDefaultInstance(), 1);
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProcessingCtxProto.equals(Object)", "int TbMsgProcessingCtxProto.hashCode()"})
  void testTbMsgProcessingCtxProtoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgProcessingCtxProto.getDefaultInstance(), null);
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProcessingCtxProto.equals(Object)", "int TbMsgProcessingCtxProto.hashCode()"})
  void testTbMsgProcessingCtxProtoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgProcessingCtxProto.getDefaultInstance(), "Different type to TbMsgProcessingCtxProto");
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.getDefaultInstanceForType()"})
  void testTbMsgProcessingCtxProtoGetDefaultInstanceForType() {
    // Arrange
    TbMsgProcessingCtxProto defaultInstance = TbMsgProcessingCtxProto.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#getSerializedSize()}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#getSerializedSize()}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TbMsgProcessingCtxProto.getSerializedSize()"})
  void testTbMsgProcessingCtxProtoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TbMsgProcessingCtxProto.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#getStackCount()}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#getStackCount()}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto getStackCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TbMsgProcessingCtxProto.getStackCount()"})
  void testTbMsgProcessingCtxProtoGetStackCount() {
    // Arrange, Act and Assert
    assertEquals(0, TbMsgProcessingCtxProto.getDefaultInstance().getStackCount());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#isInitialized()}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#isInitialized()}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProcessingCtxProto.isInitialized()"})
  void testTbMsgProcessingCtxProtoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TbMsgProcessingCtxProto.getDefaultInstance().isInitialized());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TbMsgProcessingCtxProto actualParseDelimitedFromResult = TbMsgProcessingCtxProto.parseDelimitedFrom(input);

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertSame(actualParseDelimitedFromResult.getDefaultInstanceForType().getDefaultInstanceForType(),
        actualParseDelimitedFromResult.getDefaultInstanceForType().getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TbMsgProcessingCtxProto actualParseDelimitedFromResult = TbMsgProcessingCtxProto.parseDelimitedFrom(input);

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TbMsgProcessingCtxProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TbMsgProcessingCtxProto actualParseDelimitedFromResult = TbMsgProcessingCtxProto.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(2, actualParseDelimitedFromResult.getUnknownFields().getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertSame(actualParseDelimitedFromResult.getDefaultInstanceForType().getDefaultInstanceForType(),
        actualParseDelimitedFromResult.getDefaultInstanceForType().getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TbMsgProcessingCtxProto actualParseDelimitedFromResult = TbMsgProcessingCtxProto.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TbMsgProcessingCtxProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TbMsgProcessingCtxProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TbMsgProcessingCtxProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TbMsgProcessingCtxProto.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TbMsgProcessingCtxProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseFrom(byte[])"})
  void testTbMsgProcessingCtxProtoParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    TbMsgProcessingCtxProto actualParseFromResult = TbMsgProcessingCtxProto.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getRuleNodeExecCounter());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStackCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TbMsgProcessingStackItemProto> stackList = actualParseFromResult.getStackList();
    assertTrue(stackList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(stackList, actualParseFromResult.getStackOrBuilderList());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseFrom(ByteBuffer)"})
  void testTbMsgProcessingCtxProtoParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    TbMsgProcessingCtxProto actualParseFromResult = TbMsgProcessingCtxProto.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getRuleNodeExecCounter());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStackCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TbMsgProcessingStackItemProto> stackList = actualParseFromResult.getStackList();
    assertTrue(stackList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(stackList, actualParseFromResult.getStackOrBuilderList());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testTbMsgProcessingCtxProtoParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    TbMsgProcessingCtxProto actualParseFromResult = TbMsgProcessingCtxProto.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getRuleNodeExecCounter());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStackCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TbMsgProcessingStackItemProto> stackList = actualParseFromResult.getStackList();
    assertTrue(stackList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(stackList, actualParseFromResult.getStackOrBuilderList());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseFrom(byte[], ExtensionRegistryLite)"})
  void testTbMsgProcessingCtxProtoParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    TbMsgProcessingCtxProto actualParseFromResult = TbMsgProcessingCtxProto.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getRuleNodeExecCounter());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStackCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TbMsgProcessingStackItemProto> stackList = actualParseFromResult.getStackList();
    assertTrue(stackList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(stackList, actualParseFromResult.getStackOrBuilderList());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseFrom(InputStream)"})
  void testTbMsgProcessingCtxProtoParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TbMsgProcessingCtxProto actualParseFromResult = TbMsgProcessingCtxProto
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseFrom(InputStream)"})
  void testTbMsgProcessingCtxProtoParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TbMsgProcessingCtxProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingCtxProtoParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    TbMsgProcessingCtxProto actualParseFromResult = TbMsgProcessingCtxProto.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getRuleNodeExecCounter());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStackCount());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    List<TbMsgProcessingStackItemProto> stackList = actualParseFromResult.getStackList();
    assertTrue(stackList.isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertSame(stackList, actualParseFromResult.getStackOrBuilderList());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingCtxProtoParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TbMsgProcessingCtxProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingCtxProtoParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TbMsgProcessingCtxProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseFrom(InputStream)"})
  void testTbMsgProcessingCtxProtoParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TbMsgProcessingCtxProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingCtxProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProcessingCtxProto.parseFrom(InputStream)"})
  void testTbMsgProcessingCtxProtoParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TbMsgProcessingCtxProto actualParseFromResult = TbMsgProcessingCtxProto.parseFrom((InputStream) null);

    // Assert
    assertEquals(2, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#equals(Object)}, and {@link TbMsgProcessingStackItemProto#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgProcessingStackItemProto#equals(Object)}
   *   <li>{@link TbMsgProcessingStackItemProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto equals(Object), and hashCode(); then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProcessingStackItemProto.equals(Object)",
      "int TbMsgProcessingStackItemProto.hashCode()"})
  void testTbMsgProcessingStackItemProtoEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    TbMsgProcessingStackItemProto defaultInstance = TbMsgProcessingStackItemProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#equals(Object)}, and {@link TbMsgProcessingStackItemProto#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgProcessingStackItemProto#equals(Object)}
   *   <li>{@link TbMsgProcessingStackItemProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto equals(Object), and hashCode(); then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProcessingStackItemProto.equals(Object)",
      "int TbMsgProcessingStackItemProto.hashCode()"})
  void testTbMsgProcessingStackItemProtoEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    TbMsgProcessingStackItemProto defaultInstance = TbMsgProcessingStackItemProto.getDefaultInstance();
    TbMsgProcessingStackItemProto defaultInstance2 = TbMsgProcessingStackItemProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProcessingStackItemProto.equals(Object)",
      "int TbMsgProcessingStackItemProto.hashCode()"})
  void testTbMsgProcessingStackItemProtoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgProcessingStackItemProto.getDefaultInstance(), 1);
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProcessingStackItemProto.equals(Object)",
      "int TbMsgProcessingStackItemProto.hashCode()"})
  void testTbMsgProcessingStackItemProtoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgProcessingStackItemProto.getDefaultInstance(), null);
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProcessingStackItemProto.equals(Object)",
      "int TbMsgProcessingStackItemProto.hashCode()"})
  void testTbMsgProcessingStackItemProtoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgProcessingStackItemProto.getDefaultInstance(),
        "Different type to TbMsgProcessingStackItemProto");
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.getDefaultInstanceForType()"})
  void testTbMsgProcessingStackItemProtoGetDefaultInstanceForType() {
    // Arrange
    TbMsgProcessingStackItemProto defaultInstance = TbMsgProcessingStackItemProto.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#getSerializedSize()}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#getSerializedSize()}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TbMsgProcessingStackItemProto.getSerializedSize()"})
  void testTbMsgProcessingStackItemProtoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TbMsgProcessingStackItemProto.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#isInitialized()}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#isInitialized()}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProcessingStackItemProto.isInitialized()"})
  void testTbMsgProcessingStackItemProtoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TbMsgProcessingStackItemProto.getDefaultInstance().isInitialized());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TbMsgProcessingStackItemProto actualParseDelimitedFromResult = TbMsgProcessingStackItemProto
        .parseDelimitedFrom(input);

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleNodeIdMSB());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TbMsgProcessingStackItemProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInput3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TbMsgProcessingStackItemProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TbMsgProcessingStackItemProto actualParseDelimitedFromResult = TbMsgProcessingStackItemProto
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseDelimitedFromResult.getRuleNodeIdMSB());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertTrue(actualParseDelimitedFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseDelimitedFromResult.getAllFields().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TbMsgProcessingStackItemProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TbMsgProcessingStackItemProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TbMsgProcessingStackItemProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TbMsgProcessingStackItemProto.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(byte[])"})
  void testTbMsgProcessingStackItemProtoParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    TbMsgProcessingStackItemProto actualParseFromResult = TbMsgProcessingStackItemProto.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(ByteBuffer)"})
  void testTbMsgProcessingStackItemProtoParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    TbMsgProcessingStackItemProto actualParseFromResult = TbMsgProcessingStackItemProto
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testTbMsgProcessingStackItemProtoParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    TbMsgProcessingStackItemProto actualParseFromResult = TbMsgProcessingStackItemProto.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(byte[], ExtensionRegistryLite)"})
  void testTbMsgProcessingStackItemProtoParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    TbMsgProcessingStackItemProto actualParseFromResult = TbMsgProcessingStackItemProto.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(ByteString)"})
  void testTbMsgProcessingStackItemProtoParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TbMsgProcessingStackItemProto actualParseFromResult = TbMsgProcessingStackItemProto.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testTbMsgProcessingStackItemProtoParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TbMsgProcessingStackItemProto actualParseFromResult = TbMsgProcessingStackItemProto.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(CodedInputStream)"})
  void testTbMsgProcessingStackItemProtoParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TbMsgProcessingStackItemProto actualParseFromResult = TbMsgProcessingStackItemProto.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingStackItemProtoParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TbMsgProcessingStackItemProto actualParseFromResult = TbMsgProcessingStackItemProto.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(InputStream)"})
  void testTbMsgProcessingStackItemProtoParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TbMsgProcessingStackItemProto actualParseFromResult = TbMsgProcessingStackItemProto
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(InputStream)"})
  void testTbMsgProcessingStackItemProtoParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TbMsgProcessingStackItemProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingStackItemProtoParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    TbMsgProcessingStackItemProto actualParseFromResult = TbMsgProcessingStackItemProto.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingStackItemProtoParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TbMsgProcessingStackItemProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProcessingStackItemProtoParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TbMsgProcessingStackItemProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(InputStream)"})
  void testTbMsgProcessingStackItemProtoParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TbMsgProcessingStackItemProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProcessingStackItemProto {@link TbMsgProcessingStackItemProto#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingStackItemProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingStackItemProto TbMsgProcessingStackItemProto.parseFrom(InputStream)"})
  void testTbMsgProcessingStackItemProtoParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TbMsgProcessingStackItemProto actualParseFromResult = TbMsgProcessingStackItemProto.parseFrom((InputStream) null);

    // Assert
    assertEquals(4, actualParseFromResult.getDescriptorForType().getFields().size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#equals(Object)}, and {@link TbMsgProto#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgProto#equals(Object)}
   *   <li>{@link TbMsgProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgProto equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProto.equals(Object)", "int TbMsgProto.hashCode()"})
  void testTbMsgProtoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgProto defaultInstance = TbMsgProto.getDefaultInstance();
    TbMsgProto defaultInstance2 = TbMsgProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#equals(Object)}, and {@link TbMsgProto#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgProto#equals(Object)}
   *   <li>{@link TbMsgProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgProto equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProto.equals(Object)", "int TbMsgProto.hashCode()"})
  void testTbMsgProtoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgProto defaultInstance = TbMsgProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProto equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProto.equals(Object)", "int TbMsgProto.hashCode()"})
  void testTbMsgProtoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgProto.getDefaultInstance(), 1);
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProto equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProto.equals(Object)", "int TbMsgProto.hashCode()"})
  void testTbMsgProtoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgProto.getDefaultInstance(), null);
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProto equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProto.equals(Object)", "int TbMsgProto.hashCode()"})
  void testTbMsgProtoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TbMsgProto.getDefaultInstance(), "Different type to TbMsgProto");
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getCtx()}.
   * <p>
   * Method under test: {@link TbMsgProto#getCtx()}
   */
  @Test
  @DisplayName("Test TbMsgProto getCtx()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProcessingCtxProto TbMsgProto.getCtx()"})
  void testTbMsgProtoGetCtx() {
    // Arrange and Act
    TbMsgProcessingCtxProto actualCtx = TbMsgProto.getDefaultInstance().getCtx();

    // Assert
    assertEquals("", actualCtx.getInitializationErrorString());
    assertEquals(0, actualCtx.getRuleNodeExecCounter());
    assertEquals(0, actualCtx.getSerializedSize());
    assertEquals(0, actualCtx.getStackCount());
    assertTrue(actualCtx.findInitializationErrors().isEmpty());
    List<TbMsgProcessingStackItemProto> stackList = actualCtx.getStackList();
    assertTrue(stackList.isEmpty());
    assertTrue(actualCtx.getAllFields().isEmpty());
    assertTrue(actualCtx.isInitialized());
    assertSame(stackList, actualCtx.getStackOrBuilderList());
    assertSame(actualCtx, actualCtx.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getData()}.
   * <p>
   * Method under test: {@link TbMsgProto#getData()}
   */
  @Test
  @DisplayName("Test TbMsgProto getData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbMsgProto.getData()"})
  void testTbMsgProtoGetData() {
    // Arrange, Act and Assert
    assertEquals("", TbMsgProto.getDefaultInstance().getData());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getDataBytes()}.
   * <p>
   * Method under test: {@link TbMsgProto#getDataBytes()}
   */
  @Test
  @DisplayName("Test TbMsgProto getDataBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString TbMsgProto.getDataBytes()"})
  void testTbMsgProtoGetDataBytes() {
    // Arrange
    TbMsgProto defaultInstance = TbMsgProto.getDefaultInstance();

    // Act
    ByteString actualDataBytes = defaultInstance.getDataBytes();

    // Assert
    ByteString byteString = actualDataBytes.EMPTY;
    assertEquals(byteString, actualDataBytes);
    assertEquals(byteString, defaultInstance.getEntityTypeBytes());
    assertEquals(byteString, defaultInstance.getIdBytes());
    assertEquals(byteString, defaultInstance.getTypeBytes());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link TbMsgProto#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test TbMsgProto getDefaultInstanceForType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.getDefaultInstanceForType()"})
  void testTbMsgProtoGetDefaultInstanceForType() {
    // Arrange
    TbMsgProto defaultInstance = TbMsgProto.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getEntityType()}.
   * <p>
   * Method under test: {@link TbMsgProto#getEntityType()}
   */
  @Test
  @DisplayName("Test TbMsgProto getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbMsgProto.getEntityType()"})
  void testTbMsgProtoGetEntityType() {
    // Arrange, Act and Assert
    assertEquals("", TbMsgProto.getDefaultInstance().getEntityType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getEntityTypeBytes()}.
   * <p>
   * Method under test: {@link TbMsgProto#getEntityTypeBytes()}
   */
  @Test
  @DisplayName("Test TbMsgProto getEntityTypeBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString TbMsgProto.getEntityTypeBytes()"})
  void testTbMsgProtoGetEntityTypeBytes() {
    // Arrange
    TbMsgProto defaultInstance = TbMsgProto.getDefaultInstance();

    // Act
    ByteString actualEntityTypeBytes = defaultInstance.getEntityTypeBytes();

    // Assert
    ByteString byteString = actualEntityTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDataBytes());
    assertEquals(byteString, actualEntityTypeBytes);
    assertEquals(byteString, defaultInstance.getIdBytes());
    assertEquals(byteString, defaultInstance.getTypeBytes());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getId()}.
   * <p>
   * Method under test: {@link TbMsgProto#getId()}
   */
  @Test
  @DisplayName("Test TbMsgProto getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbMsgProto.getId()"})
  void testTbMsgProtoGetId() {
    // Arrange, Act and Assert
    assertEquals("", TbMsgProto.getDefaultInstance().getId());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getIdBytes()}.
   * <p>
   * Method under test: {@link TbMsgProto#getIdBytes()}
   */
  @Test
  @DisplayName("Test TbMsgProto getIdBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString TbMsgProto.getIdBytes()"})
  void testTbMsgProtoGetIdBytes() {
    // Arrange
    TbMsgProto defaultInstance = TbMsgProto.getDefaultInstance();

    // Act
    ByteString actualIdBytes = defaultInstance.getIdBytes();

    // Assert
    ByteString byteString = actualIdBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDataBytes());
    assertEquals(byteString, defaultInstance.getEntityTypeBytes());
    assertEquals(byteString, actualIdBytes);
    assertEquals(byteString, defaultInstance.getTypeBytes());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getMetaData()}.
   * <p>
   * Method under test: {@link TbMsgProto#getMetaData()}
   */
  @Test
  @DisplayName("Test TbMsgProto getMetaData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgMetaDataProto TbMsgProto.getMetaData()"})
  void testTbMsgProtoGetMetaData() {
    // Arrange and Act
    TbMsgMetaDataProto actualMetaData = TbMsgProto.getDefaultInstance().getMetaData();

    // Assert
    assertEquals("", actualMetaData.getInitializationErrorString());
    assertEquals(0, actualMetaData.getDataCount());
    assertEquals(0, actualMetaData.getSerializedSize());
    assertTrue(actualMetaData.findInitializationErrors().isEmpty());
    assertTrue(actualMetaData.getAllFields().isEmpty());
    assertTrue(actualMetaData.getData().isEmpty());
    assertTrue(actualMetaData.getDataMap().isEmpty());
    assertTrue(actualMetaData.isInitialized());
    assertSame(actualMetaData, actualMetaData.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getSerializedSize()}.
   * <p>
   * Method under test: {@link TbMsgProto#getSerializedSize()}
   */
  @Test
  @DisplayName("Test TbMsgProto getSerializedSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TbMsgProto.getSerializedSize()"})
  void testTbMsgProtoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TbMsgProto.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getType()}.
   * <p>
   * Method under test: {@link TbMsgProto#getType()}
   */
  @Test
  @DisplayName("Test TbMsgProto getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbMsgProto.getType()"})
  void testTbMsgProtoGetType() {
    // Arrange, Act and Assert
    assertEquals("", TbMsgProto.getDefaultInstance().getType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getTypeBytes()}.
   * <p>
   * Method under test: {@link TbMsgProto#getTypeBytes()}
   */
  @Test
  @DisplayName("Test TbMsgProto getTypeBytes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteString TbMsgProto.getTypeBytes()"})
  void testTbMsgProtoGetTypeBytes() {
    // Arrange
    TbMsgProto defaultInstance = TbMsgProto.getDefaultInstance();

    // Act
    ByteString actualTypeBytes = defaultInstance.getTypeBytes();

    // Assert
    ByteString byteString = actualTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDataBytes());
    assertEquals(byteString, defaultInstance.getEntityTypeBytes());
    assertEquals(byteString, defaultInstance.getIdBytes());
    assertEquals(byteString, actualTypeBytes);
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#hasCtx()}.
   * <p>
   * Method under test: {@link TbMsgProto#hasCtx()}
   */
  @Test
  @DisplayName("Test TbMsgProto hasCtx()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProto.hasCtx()"})
  void testTbMsgProtoHasCtx() {
    // Arrange, Act and Assert
    assertFalse(TbMsgProto.getDefaultInstance().hasCtx());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#hasMetaData()}.
   * <p>
   * Method under test: {@link TbMsgProto#hasMetaData()}
   */
  @Test
  @DisplayName("Test TbMsgProto hasMetaData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProto.hasMetaData()"})
  void testTbMsgProtoHasMetaData() {
    // Arrange, Act and Assert
    assertFalse(TbMsgProto.getDefaultInstance().hasMetaData());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#isInitialized()}.
   * <p>
   * Method under test: {@link TbMsgProto#isInitialized()}
   */
  @Test
  @DisplayName("Test TbMsgProto isInitialized()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbMsgProto.isInitialized()"})
  void testTbMsgProtoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TbMsgProto.getDefaultInstance().isInitialized());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream) with 'input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProtoParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TbMsgProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProtoParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, TbMsgProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProtoParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TbMsgProto actualParseDelimitedFromResult = TbMsgProto.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProtoParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TbMsgProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test: {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProtoParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TbMsgProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProtoParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TbMsgProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)} with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseDelimitedFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProtoParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TbMsgProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProtoParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TbMsgProto.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProtoParseDelimitedFromWithInput_thenReturnSerializedSizeIsTwo() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(2, TbMsgProto.parseDelimitedFrom(input).getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProtoParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    TbMsgProto actualParseDelimitedFromResult = TbMsgProto.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProtoParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TbMsgProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseDelimitedFrom(InputStream)"})
  void testTbMsgProtoParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbMsgProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(ByteBuffer)} with {@code ByteBuffer}.
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(ByteBuffer) with 'ByteBuffer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(ByteBuffer)"})
  void testTbMsgProtoParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    TbMsgProto actualParseFromResult = TbMsgProto.parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getEntityType());
    assertEquals("", actualParseFromResult.getId());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getDataType());
    assertEquals(0, actualParseFromResult.getPartition());
    assertEquals(0, actualParseFromResult.getRuleNodeExecCounter());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getClusterPartition());
    assertEquals(0L, actualParseFromResult.getCorrelationIdLSB());
    assertEquals(0L, actualParseFromResult.getCorrelationIdMSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdLSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdMSB());
    assertEquals(0L, actualParseFromResult.getEntityIdLSB());
    assertEquals(0L, actualParseFromResult.getEntityIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(0L, actualParseFromResult.getTs());
    assertFalse(actualParseFromResult.hasCtx());
    assertFalse(actualParseFromResult.hasMetaData());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(ByteBuffer, ExtensionRegistryLite)} with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(ByteBuffer, ExtensionRegistryLite)"})
  void testTbMsgProtoParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    TbMsgProto actualParseFromResult = TbMsgProto.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getEntityType());
    assertEquals("", actualParseFromResult.getId());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getDataType());
    assertEquals(0, actualParseFromResult.getPartition());
    assertEquals(0, actualParseFromResult.getRuleNodeExecCounter());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getClusterPartition());
    assertEquals(0L, actualParseFromResult.getCorrelationIdLSB());
    assertEquals(0L, actualParseFromResult.getCorrelationIdMSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdLSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdMSB());
    assertEquals(0L, actualParseFromResult.getEntityIdLSB());
    assertEquals(0L, actualParseFromResult.getEntityIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(0L, actualParseFromResult.getTs());
    assertFalse(actualParseFromResult.hasCtx());
    assertFalse(actualParseFromResult.hasMetaData());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(byte[], ExtensionRegistryLite)} with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(byte[], ExtensionRegistryLite)"})
  void testTbMsgProtoParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    TbMsgProto actualParseFromResult = TbMsgProto.parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getEntityType());
    assertEquals("", actualParseFromResult.getId());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getDataType());
    assertEquals(0, actualParseFromResult.getPartition());
    assertEquals(0, actualParseFromResult.getRuleNodeExecCounter());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getClusterPartition());
    assertEquals(0L, actualParseFromResult.getCorrelationIdLSB());
    assertEquals(0L, actualParseFromResult.getCorrelationIdMSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdLSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdMSB());
    assertEquals(0L, actualParseFromResult.getEntityIdLSB());
    assertEquals(0L, actualParseFromResult.getEntityIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(0L, actualParseFromResult.getTs());
    assertFalse(actualParseFromResult.hasCtx());
    assertFalse(actualParseFromResult.hasMetaData());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(ByteString)} with {@code ByteString}.
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(ByteString) with 'ByteString'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(ByteString)"})
  void testTbMsgProtoParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TbMsgProto actualParseFromResult = TbMsgProto.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getEntityType());
    assertEquals("", actualParseFromResult.getId());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getDataType());
    assertEquals(0, actualParseFromResult.getPartition());
    assertEquals(0, actualParseFromResult.getRuleNodeExecCounter());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getClusterPartition());
    assertEquals(0L, actualParseFromResult.getCorrelationIdLSB());
    assertEquals(0L, actualParseFromResult.getCorrelationIdMSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdLSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdMSB());
    assertEquals(0L, actualParseFromResult.getEntityIdLSB());
    assertEquals(0L, actualParseFromResult.getEntityIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(0L, actualParseFromResult.getTs());
    assertFalse(actualParseFromResult.hasCtx());
    assertFalse(actualParseFromResult.hasMetaData());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getDataBytes());
    assertEquals(byteString, actualParseFromResult.getEntityTypeBytes());
    assertEquals(byteString, actualParseFromResult.getIdBytes());
    assertEquals(byteString, actualParseFromResult.getTypeBytes());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(ByteString, ExtensionRegistryLite)} with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(ByteString, ExtensionRegistryLite)"})
  void testTbMsgProtoParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    TbMsgProto actualParseFromResult = TbMsgProto.parseFrom(data, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getEntityType());
    assertEquals("", actualParseFromResult.getId());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getDataType());
    assertEquals(0, actualParseFromResult.getPartition());
    assertEquals(0, actualParseFromResult.getRuleNodeExecCounter());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getClusterPartition());
    assertEquals(0L, actualParseFromResult.getCorrelationIdLSB());
    assertEquals(0L, actualParseFromResult.getCorrelationIdMSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdLSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdMSB());
    assertEquals(0L, actualParseFromResult.getEntityIdLSB());
    assertEquals(0L, actualParseFromResult.getEntityIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(0L, actualParseFromResult.getTs());
    assertFalse(actualParseFromResult.hasCtx());
    assertFalse(actualParseFromResult.hasMetaData());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, actualParseFromResult.getDataBytes());
    assertEquals(byteString, actualParseFromResult.getEntityTypeBytes());
    assertEquals(byteString, actualParseFromResult.getIdBytes());
    assertEquals(byteString, actualParseFromResult.getTypeBytes());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(byte[]) with 'byte[]'; then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(byte[])"})
  void testTbMsgProtoParseFromWithByte_thenReturnInitializationErrorStringIsEmptyString()
      throws InvalidProtocolBufferException {
    // Arrange and Act
    TbMsgProto actualParseFromResult = TbMsgProto.parseFrom(new byte[]{});

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getEntityType());
    assertEquals("", actualParseFromResult.getId());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getDataType());
    assertEquals(0, actualParseFromResult.getPartition());
    assertEquals(0, actualParseFromResult.getRuleNodeExecCounter());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getClusterPartition());
    assertEquals(0L, actualParseFromResult.getCorrelationIdLSB());
    assertEquals(0L, actualParseFromResult.getCorrelationIdMSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdLSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdMSB());
    assertEquals(0L, actualParseFromResult.getEntityIdLSB());
    assertEquals(0L, actualParseFromResult.getEntityIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(0L, actualParseFromResult.getTs());
    assertFalse(actualParseFromResult.hasCtx());
    assertFalse(actualParseFromResult.hasMetaData());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(CodedInputStream)} with {@code CodedInputStream}.
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(CodedInputStream) with 'CodedInputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(CodedInputStream)"})
  void testTbMsgProtoParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TbMsgProto actualParseFromResult = TbMsgProto.parseFrom(input);

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getEntityType());
    assertEquals("", actualParseFromResult.getId());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getDataType());
    assertEquals(0, actualParseFromResult.getPartition());
    assertEquals(0, actualParseFromResult.getRuleNodeExecCounter());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getClusterPartition());
    assertEquals(0L, actualParseFromResult.getCorrelationIdLSB());
    assertEquals(0L, actualParseFromResult.getCorrelationIdMSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdLSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdMSB());
    assertEquals(0L, actualParseFromResult.getEntityIdLSB());
    assertEquals(0L, actualParseFromResult.getEntityIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(0L, actualParseFromResult.getTs());
    assertFalse(actualParseFromResult.hasCtx());
    assertFalse(actualParseFromResult.hasMetaData());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(CodedInputStream, ExtensionRegistryLite)} with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(CodedInputStream, ExtensionRegistryLite)"})
  void testTbMsgProtoParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    TbMsgProto actualParseFromResult = TbMsgProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getEntityType());
    assertEquals("", actualParseFromResult.getId());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getDataType());
    assertEquals(0, actualParseFromResult.getPartition());
    assertEquals(0, actualParseFromResult.getRuleNodeExecCounter());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getClusterPartition());
    assertEquals(0L, actualParseFromResult.getCorrelationIdLSB());
    assertEquals(0L, actualParseFromResult.getCorrelationIdMSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdLSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdMSB());
    assertEquals(0L, actualParseFromResult.getEntityIdLSB());
    assertEquals(0L, actualParseFromResult.getEntityIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(0L, actualParseFromResult.getTs());
    assertFalse(actualParseFromResult.hasCtx());
    assertFalse(actualParseFromResult.hasMetaData());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(InputStream)} with {@code InputStream}.
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(InputStream) with 'InputStream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(InputStream)"})
  void testTbMsgProtoParseFromWithInputStream() throws IOException {
    // Arrange and Act
    TbMsgProto actualParseFromResult = TbMsgProto.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    TbMsgProcessingCtxProto ctx = actualParseFromResult.getCtx();
    assertSame(unknownFields, ctx.getUnknownFields());
    TbMsgMetaDataProto metaData = actualParseFromResult.getMetaData();
    assertSame(unknownFields, metaData.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(ctx, ctx.getDefaultInstanceForType());
    assertSame(ctx, actualParseFromResult.getCtxOrBuilder());
    assertSame(metaData, metaData.getDefaultInstanceForType());
    assertSame(metaData, actualParseFromResult.getMetaDataOrBuilder());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProtoParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    TbMsgProto actualParseFromResult = TbMsgProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getData());
    assertEquals("", actualParseFromResult.getEntityType());
    assertEquals("", actualParseFromResult.getId());
    assertEquals("", actualParseFromResult.getType());
    assertEquals(0, actualParseFromResult.getDataType());
    assertEquals(0, actualParseFromResult.getPartition());
    assertEquals(0, actualParseFromResult.getRuleNodeExecCounter());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0L, actualParseFromResult.getClusterPartition());
    assertEquals(0L, actualParseFromResult.getCorrelationIdLSB());
    assertEquals(0L, actualParseFromResult.getCorrelationIdMSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdLSB());
    assertEquals(0L, actualParseFromResult.getCustomerIdMSB());
    assertEquals(0L, actualParseFromResult.getEntityIdLSB());
    assertEquals(0L, actualParseFromResult.getEntityIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleChainIdMSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdLSB());
    assertEquals(0L, actualParseFromResult.getRuleNodeIdMSB());
    assertEquals(0L, actualParseFromResult.getTs());
    assertFalse(actualParseFromResult.hasCtx());
    assertFalse(actualParseFromResult.hasMetaData());
    assertTrue(actualParseFromResult.findInitializationErrors().isEmpty());
    assertTrue(actualParseFromResult.getAllFields().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProtoParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TbMsgProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(InputStream, ExtensionRegistryLite)} with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(InputStream, ExtensionRegistryLite)"})
  void testTbMsgProtoParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TbMsgProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(InputStream) with 'InputStream'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(InputStream)"})
  void testTbMsgProtoParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TbMsgProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(InputStream)"})
  void testTbMsgProtoParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TbMsgProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(InputStream) with 'InputStream'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsgProto TbMsgProto.parseFrom(InputStream)"})
  void testTbMsgProtoParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    TbMsgProto actualParseFromResult = TbMsgProto.parseFrom((InputStream) null);

    // Assert
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    TbMsgProcessingCtxProto ctx = actualParseFromResult.getCtx();
    assertSame(unknownFields, ctx.getUnknownFields());
    TbMsgMetaDataProto metaData = actualParseFromResult.getMetaData();
    assertSame(unknownFields, metaData.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(ctx, ctx.getDefaultInstanceForType());
    assertSame(ctx, actualParseFromResult.getCtxOrBuilder());
    assertSame(metaData, metaData.getDefaultInstanceForType());
    assertSame(metaData, actualParseFromResult.getMetaDataOrBuilder());
  }
}
