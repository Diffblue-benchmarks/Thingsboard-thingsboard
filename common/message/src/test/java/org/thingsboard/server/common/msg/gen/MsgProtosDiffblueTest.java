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
import com.google.protobuf.Parser;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.msg.gen.MsgProtos.TbMsgMetaDataProto;
import org.thingsboard.server.common.msg.gen.MsgProtos.TbMsgProcessingCtxProto;
import org.thingsboard.server.common.msg.gen.MsgProtos.TbMsgProcessingStackItemProto;
import org.thingsboard.server.common.msg.gen.MsgProtos.TbMsgProto;

class MsgProtosDiffblueTest {
  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#containsData(String)}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#containsData(String)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto containsData(String)")
  void testTbMsgMetaDataProtoContainsData() {
    // Arrange, Act and Assert
    assertFalse(MsgProtos.TbMsgMetaDataProto.getDefaultInstance().containsData("Key"));
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#equals(Object)}, and
   * {@link TbMsgMetaDataProto#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgMetaDataProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgMetaDataProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#equals(Object)}, and
   * {@link TbMsgMetaDataProto#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgMetaDataProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgMetaDataProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto equals(Object), and hashCode(); when other is same; then return equal")
  void testTbMsgMetaDataProtoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MsgProtos.TbMsgMetaDataProto defaultInstance = MsgProtos.TbMsgMetaDataProto.getDefaultInstance();

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
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto equals(Object); when other is different; then return not equal")
  void testTbMsgMetaDataProtoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgMetaDataProto.getDefaultInstance(), 1);
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto equals(Object); when other is 'null'; then return not equal")
  void testTbMsgMetaDataProtoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgMetaDataProto.getDefaultInstance(), null);
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto equals(Object); when other is wrong type; then return not equal")
  void testTbMsgMetaDataProtoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgMetaDataProto.getDefaultInstance(), "Different type to TbMsgMetaDataProto");
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#getData()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#getData()}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto getData()")
  void testTbMsgMetaDataProtoGetData() {
    // Arrange, Act and Assert
    assertTrue(MsgProtos.TbMsgMetaDataProto.getDefaultInstance().getData().isEmpty());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#getDataCount()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#getDataCount()}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto getDataCount()")
  void testTbMsgMetaDataProtoGetDataCount() {
    // Arrange, Act and Assert
    assertEquals(0, MsgProtos.TbMsgMetaDataProto.getDefaultInstance().getDataCount());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#getDataMap()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#getDataMap()}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto getDataMap()")
  void testTbMsgMetaDataProtoGetDataMap() {
    // Arrange, Act and Assert
    assertTrue(MsgProtos.TbMsgMetaDataProto.getDefaultInstance().getDataMap().isEmpty());
  }

  /**
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#getDataOrDefault(String, String)}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#getDataOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto getDataOrDefault(String, String)")
  void testTbMsgMetaDataProtoGetDataOrDefault() {
    // Arrange, Act and Assert
    assertEquals("42", MsgProtos.TbMsgMetaDataProto.getDefaultInstance().getDataOrDefault("Key", "42"));
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#getDataOrThrow(String)}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#getDataOrThrow(String)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto getDataOrThrow(String)")
  void testTbMsgMetaDataProtoGetDataOrThrow() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> MsgProtos.TbMsgMetaDataProto.getDefaultInstance().getDataOrThrow("Key"));
  }

  /**
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto getDefaultInstanceForType()")
  void testTbMsgMetaDataProtoGetDefaultInstanceForType() {
    // Arrange
    MsgProtos.TbMsgMetaDataProto defaultInstance = MsgProtos.TbMsgMetaDataProto.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#getSerializedSize()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#getSerializedSize()}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto getSerializedSize()")
  void testTbMsgMetaDataProtoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MsgProtos.TbMsgMetaDataProto.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto internalGetMapFieldReflection(int); then throw RuntimeException")
  void testTbMsgMetaDataProtoInternalGetMapFieldReflection_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> MsgProtos.TbMsgMetaDataProto.getDefaultInstance()
        .internalGetMapFieldReflection(MsgProtos.TbMsgProto.CLUSTERPARTITION_FIELD_NUMBER));
  }

  /**
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#internalGetMapFieldReflection(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@link MapField}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#internalGetMapFieldReflection(int)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto internalGetMapFieldReflection(int); when one; then return MapField")
  void testTbMsgMetaDataProtoInternalGetMapFieldReflection_whenOne_thenReturnMapField() {
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
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#isInitialized()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgMetaDataProto#isInitialized()}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto isInitialized()")
  void testTbMsgMetaDataProtoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MsgProtos.TbMsgMetaDataProto.getDefaultInstance().isInitialized());
  }

  /**
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto newInstance(UnusedPrivateParameter)")
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
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream) with 'input'")
  void testTbMsgMetaDataProtoParseDelimitedFromWithInput() throws IOException {
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
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgMetaDataProtoParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MsgProtos.TbMsgMetaDataProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgMetaDataProtoParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
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
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgMetaDataProtoParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
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
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgMetaDataProtoParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
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
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testTbMsgMetaDataProtoParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MsgProtos.TbMsgMetaDataProto.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testTbMsgMetaDataProtoParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
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
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseDelimitedFrom(InputStream) with 'input'; then throw RuntimeException")
  void testTbMsgMetaDataProtoParseDelimitedFromWithInput_thenThrowRuntimeException() throws IOException {
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
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(InputStream)}
   * with {@code InputStream}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(InputStream) with 'InputStream'")
  void testTbMsgMetaDataProtoParseFromWithInputStream() throws IOException {
    // Arrange and Act
    MsgProtos.TbMsgMetaDataProto actualParseFromResult = MsgProtos.TbMsgMetaDataProto
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<DescriptorProtos.DescriptorProto> nestedTypeList = toProtoResult.getNestedTypeList();
    assertEquals(1, nestedTypeList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    List<Descriptors.Descriptor> nestedTypes = descriptorForType.getNestedTypes();
    assertEquals(1, nestedTypes.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    Descriptors.Descriptor getResult = nestedTypes.get(0);
    DescriptorProtos.DescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(defaultInstanceForType2, toProtoResult5.getDefaultInstanceForType());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(defaultInstanceForType2, getResult2.toProto().getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(nestedTypeList, toProtoResult.getNestedTypeOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    Descriptors.FieldDescriptor getResult3 = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(2);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(3);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult3.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    DescriptorProtos.MessageOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options5 = getResult3.getOptions();
    assertSame(options3, options5.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult6.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options5, options5.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult, getResult3.getMessageType());
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(InputStream)}
   * with {@code InputStream}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(InputStream) with 'InputStream'")
  void testTbMsgMetaDataProtoParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MsgProtos.TbMsgMetaDataProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testTbMsgMetaDataProtoParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MsgProtos.TbMsgMetaDataProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgMetaDataProto
   * {@link TbMsgMetaDataProto#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testTbMsgMetaDataProtoParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
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
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(InputStream)}
   * with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testTbMsgMetaDataProtoParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MsgProtos.TbMsgMetaDataProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgMetaDataProto {@link TbMsgMetaDataProto#parseFrom(InputStream)}
   * with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgMetaDataProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgMetaDataProto parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testTbMsgMetaDataProtoParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    MsgProtos.TbMsgMetaDataProto actualParseFromResult = MsgProtos.TbMsgMetaDataProto.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<DescriptorProtos.DescriptorProto> nestedTypeList = toProtoResult.getNestedTypeList();
    assertEquals(1, nestedTypeList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    List<Descriptors.Descriptor> nestedTypes = descriptorForType.getNestedTypes();
    assertEquals(1, nestedTypes.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    Descriptors.Descriptor getResult = nestedTypes.get(0);
    DescriptorProtos.DescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(defaultInstanceForType2, toProtoResult5.getDefaultInstanceForType());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(defaultInstanceForType2, getResult2.toProto().getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(nestedTypeList, toProtoResult.getNestedTypeOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    Descriptors.FieldDescriptor getResult3 = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(2);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(3);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult3.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    DescriptorProtos.MessageOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options5 = getResult3.getOptions();
    assertSame(options3, options5.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult6.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options5, options5.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult, getResult3.getMessageType());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#equals(Object)},
   * and {@link TbMsgProcessingCtxProto#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgProcessingCtxProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgProcessingCtxProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#equals(Object)},
   * and {@link TbMsgProcessingCtxProto#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgProcessingCtxProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgProcessingCtxProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto equals(Object), and hashCode(); when other is same; then return equal")
  void testTbMsgProcessingCtxProtoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MsgProtos.TbMsgProcessingCtxProto defaultInstance = MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance();

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
   * Method under test: {@link MsgProtos.TbMsgProcessingCtxProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto equals(Object); when other is different; then return not equal")
  void testTbMsgProcessingCtxProtoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance(), 1);
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProcessingCtxProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto equals(Object); when other is 'null'; then return not equal")
  void testTbMsgProcessingCtxProtoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance(), null);
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProcessingCtxProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto equals(Object); when other is wrong type; then return not equal")
  void testTbMsgProcessingCtxProtoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance(),
        "Different type to TbMsgProcessingCtxProto");
  }

  /**
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto getDefaultInstanceForType()")
  void testTbMsgProcessingCtxProtoGetDefaultInstanceForType() {
    // Arrange
    MsgProtos.TbMsgProcessingCtxProto defaultInstance = MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#getSerializedSize()}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto getSerializedSize()")
  void testTbMsgProcessingCtxProtoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#getStackCount()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProcessingCtxProto#getStackCount()}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto getStackCount()")
  void testTbMsgProcessingCtxProtoGetStackCount() {
    // Arrange, Act and Assert
    assertEquals(0, MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance().getStackCount());
  }

  /**
   * Test TbMsgProcessingCtxProto {@link TbMsgProcessingCtxProto#isInitialized()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProcessingCtxProto#isInitialized()}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto isInitialized()")
  void testTbMsgProcessingCtxProtoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MsgProtos.TbMsgProcessingCtxProto.getDefaultInstance().isInitialized());
  }

  /**
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto newInstance(UnusedPrivateParameter)")
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
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream) with 'input'")
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MsgProtos.TbMsgProcessingCtxProto actualParseDelimitedFromResult = MsgProtos.TbMsgProcessingCtxProto
        .parseDelimitedFrom(input);

    // Assert
    MsgProtos.TbMsgProcessingCtxProto defaultInstanceForType = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    Descriptors.FieldDescriptor getResult = fields.get(1);
    Descriptors.Descriptor messageType = getResult.getMessageType();
    assertSame(defaultInstanceForType3, messageType.toProto().getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType3, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType2.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType2.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType4 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType4.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult2.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType6 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType6.getDefaultInstanceForType(),
        defaultInstanceForType6.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, messageType.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(3);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, messageType.getOptions());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(messageType, messageTypes.get(1));
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(2));
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType6.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream) with 'input'")
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MsgProtos.TbMsgProcessingCtxProto actualParseDelimitedFromResult = MsgProtos.TbMsgProcessingCtxProto
        .parseDelimitedFrom(input);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(1);
    Descriptors.Descriptor messageType = getResult.getMessageType();
    DescriptorProtos.DescriptorProto toProtoResult = messageType.toProto();
    assertEquals(0, toProtoResult.getOneofDeclCount());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(2, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, toProtoResult.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult5.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult4.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult4.getReservedNameList(), toProtoResult4.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, messageType.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(3);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, messageType.getOptions());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult6.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(messageType, messageTypes.get(1));
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(2));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, getResult.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream) with 'input'")
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInput3() throws IOException {
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
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MsgProtos.TbMsgProcessingCtxProto actualParseDelimitedFromResult = MsgProtos.TbMsgProcessingCtxProto
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    MsgProtos.TbMsgProcessingCtxProto defaultInstanceForType = actualParseDelimitedFromResult
        .getDefaultInstanceForType();
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    Descriptors.FieldDescriptor getResult = fields.get(1);
    Descriptors.Descriptor messageType = getResult.getMessageType();
    assertSame(defaultInstanceForType3, messageType.toProto().getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType3, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3, defaultInstanceForType3);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType2.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType2.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType4 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType4.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult2.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType4.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType6 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType6.getDefaultInstanceForType(),
        defaultInstanceForType6.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, messageType.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(3);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType2.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, messageType.getOptions());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult5.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(messageType, messageTypes.get(1));
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(2));
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType6.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MsgProtos.TbMsgProcessingCtxProto actualParseDelimitedFromResult = MsgProtos.TbMsgProcessingCtxProto
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(1);
    Descriptors.Descriptor messageType = getResult.getMessageType();
    DescriptorProtos.DescriptorProto toProtoResult = messageType.toProto();
    assertEquals(0, toProtoResult.getOneofDeclCount());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(2, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult3.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2, toProtoResult.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult5.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult4.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult4.getReservedNameList(), toProtoResult4.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult3.getDependencyList());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult3.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, messageType.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(3);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, messageType.getOptions());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult6.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(messageType, messageTypes.get(1));
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(2));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, getResult.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MsgProtos.TbMsgProcessingCtxProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
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
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInputExtensionRegistry5() throws IOException {
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
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MsgProtos.TbMsgProcessingCtxProto.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testTbMsgProcessingCtxProtoParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
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
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(InputStream) with 'InputStream'")
  void testTbMsgProcessingCtxProtoParseFromWithInputStream() throws IOException {
    // Arrange and Act
    MsgProtos.TbMsgProcessingCtxProto actualParseFromResult = MsgProtos.TbMsgProcessingCtxProto
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    Descriptors.FieldDescriptor getResult = fields.get(1);
    Descriptors.Descriptor messageType = getResult.getMessageType();
    DescriptorProtos.DescriptorProto toProtoResult4 = messageType.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult5.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, messageType.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(3);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, messageType.getOptions());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult6.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(messageType, messageTypes.get(1));
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(2));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, getResult.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(InputStream) with 'InputStream'")
  void testTbMsgProcessingCtxProtoParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MsgProtos.TbMsgProcessingCtxProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testTbMsgProcessingCtxProtoParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MsgProtos.TbMsgProcessingCtxProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testTbMsgProcessingCtxProtoParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
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
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testTbMsgProcessingCtxProtoParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MsgProtos.TbMsgProcessingCtxProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProcessingCtxProto
   * {@link TbMsgProcessingCtxProto#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingCtxProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingCtxProto parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testTbMsgProcessingCtxProtoParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    MsgProtos.TbMsgProcessingCtxProto actualParseFromResult = MsgProtos.TbMsgProcessingCtxProto
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    Descriptors.FieldDescriptor getResult = fields.get(1);
    Descriptors.Descriptor messageType = getResult.getMessageType();
    DescriptorProtos.DescriptorProto toProtoResult4 = messageType.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult5.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, messageType.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(3);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, messageType.getOptions());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult6.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(messageType, messageTypes.get(1));
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(2));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, getResult.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#equals(Object)}, and
   * {@link TbMsgProcessingStackItemProto#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgProcessingStackItemProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgProcessingStackItemProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto equals(Object), and hashCode(); then return equal")
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#equals(Object)}, and
   * {@link TbMsgProcessingStackItemProto#hashCode()}.
   * <ul>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgProcessingStackItemProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgProcessingStackItemProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto equals(Object), and hashCode(); then return equal")
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto equals(Object); when other is different; then return not equal")
  void testTbMsgProcessingStackItemProtoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance(), 1);
  }

  /**
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto equals(Object); when other is 'null'; then return not equal")
  void testTbMsgProcessingStackItemProtoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance(), null);
  }

  /**
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto equals(Object); when other is wrong type; then return not equal")
  void testTbMsgProcessingStackItemProtoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance(),
        "Different type to TbMsgProcessingStackItemProto");
  }

  /**
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto getDefaultInstanceForType()")
  void testTbMsgProcessingStackItemProtoGetDefaultInstanceForType() {
    // Arrange
    MsgProtos.TbMsgProcessingStackItemProto defaultInstance = MsgProtos.TbMsgProcessingStackItemProto
        .getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#getSerializedSize()}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto getSerializedSize()")
  void testTbMsgProcessingStackItemProtoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#isInitialized()}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#isInitialized()}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto isInitialized()")
  void testTbMsgProcessingStackItemProtoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MsgProtos.TbMsgProcessingStackItemProto.getDefaultInstance().isInitialized());
  }

  /**
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto newInstance(UnusedPrivateParameter)")
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream) with 'input'")
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInput() throws IOException {
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
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
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
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseDelimitedFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
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
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream) with 'input'")
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInput2() throws IOException {
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream) with 'input'")
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInput3() throws IOException {
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInputExtensionRegistry() throws IOException {
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
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
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
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseDelimitedFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
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
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        MsgProtos.TbMsgProcessingStackItemProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testTbMsgProcessingStackItemProtoParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MsgProtos.TbMsgProcessingStackItemProto.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(byte[])} with {@code byte[]}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(byte[]) with 'byte[]'")
  void testTbMsgProcessingStackItemProtoParseFromWithByte() throws InvalidProtocolBufferException {
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
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
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
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
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
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(ByteBuffer)} with
   * {@code ByteBuffer}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(ByteBuffer) with 'ByteBuffer'")
  void testTbMsgProcessingStackItemProtoParseFromWithByteBuffer() throws InvalidProtocolBufferException {
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
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
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
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
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
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   * with {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  void testTbMsgProcessingStackItemProtoParseFromWithByteBufferExtensionRegistryLite()
      throws InvalidProtocolBufferException {
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
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
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
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
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
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(byte[], ExtensionRegistryLite)}
   * with {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  void testTbMsgProcessingStackItemProtoParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
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
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
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
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
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
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(ByteString)} with
   * {@code ByteString}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(ByteString) with 'ByteString'")
  void testTbMsgProcessingStackItemProtoParseFromWithByteString() throws IOException {
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
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
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
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
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
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(ByteString, ExtensionRegistryLite)}
   * with {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  void testTbMsgProcessingStackItemProtoParseFromWithByteStringExtensionRegistryLite() throws IOException {
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
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
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
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
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
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(CodedInputStream)} with
   * {@code CodedInputStream}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(CodedInputStream) with 'CodedInputStream'")
  void testTbMsgProcessingStackItemProtoParseFromWithCodedInputStream() throws IOException {
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
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
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
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
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
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   * with {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  void testTbMsgProcessingStackItemProtoParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
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
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
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
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
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
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(InputStream) with 'InputStream'")
  void testTbMsgProcessingStackItemProtoParseFromWithInputStream() throws IOException {
    // Arrange and Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = descriptorForType2.toProto().getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(2);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(3);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(2);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(3);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
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
    assertSame(descriptorForType, messageTypes.get(1));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(InputStream) with 'InputStream'")
  void testTbMsgProcessingStackItemProtoParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MsgProtos.TbMsgProcessingStackItemProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testTbMsgProcessingStackItemProtoParseFromWithInputStreamExtensionRegistryLite() throws IOException {
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
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
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
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
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
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testTbMsgProcessingStackItemProtoParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MsgProtos.TbMsgProcessingStackItemProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testTbMsgProcessingStackItemProtoParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
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
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testTbMsgProcessingStackItemProtoParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MsgProtos.TbMsgProcessingStackItemProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProcessingStackItemProto
   * {@link TbMsgProcessingStackItemProto#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProcessingStackItemProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProcessingStackItemProto parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testTbMsgProcessingStackItemProtoParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    MsgProtos.TbMsgProcessingStackItemProto actualParseFromResult = MsgProtos.TbMsgProcessingStackItemProto
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(4, messageTypeList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = descriptorForType2.toProto().getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(2);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(3);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(2);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(3);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
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
    assertSame(descriptorForType, messageTypes.get(1));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#equals(Object)}, and
   * {@link TbMsgProto#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgProto equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test TbMsgProto {@link TbMsgProto#equals(Object)}, and
   * {@link TbMsgProto#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MsgProtos.TbMsgProto#equals(Object)}
   *   <li>{@link MsgProtos.TbMsgProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test TbMsgProto equals(Object), and hashCode(); when other is same; then return equal")
  void testTbMsgProtoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MsgProtos.TbMsgProto defaultInstance = MsgProtos.TbMsgProto.getDefaultInstance();

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
   * Method under test: {@link MsgProtos.TbMsgProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProto equals(Object); when other is different; then return not equal")
  void testTbMsgProtoEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProto.getDefaultInstance(), 1);
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProto equals(Object); when other is 'null'; then return not equal")
  void testTbMsgProtoEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProto.getDefaultInstance(), null);
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#equals(Object)}
   */
  @Test
  @DisplayName("Test TbMsgProto equals(Object); when other is wrong type; then return not equal")
  void testTbMsgProtoEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MsgProtos.TbMsgProto.getDefaultInstance(), "Different type to TbMsgProto");
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getData()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#getData()}
   */
  @Test
  @DisplayName("Test TbMsgProto getData()")
  void testTbMsgProtoGetData() {
    // Arrange, Act and Assert
    assertEquals("", MsgProtos.TbMsgProto.getDefaultInstance().getData());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getDataBytes()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#getDataBytes()}
   */
  @Test
  @DisplayName("Test TbMsgProto getDataBytes()")
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
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualDataBytes);
    assertEquals(byteString, defaultInstance.getEntityTypeBytes());
    assertEquals(byteString, defaultInstance.getIdBytes());
    assertEquals(byteString, defaultInstance.getTypeBytes());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test TbMsgProto getDefaultInstanceForType()")
  void testTbMsgProtoGetDefaultInstanceForType() {
    // Arrange
    MsgProtos.TbMsgProto defaultInstance = MsgProtos.TbMsgProto.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getEntityType()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#getEntityType()}
   */
  @Test
  @DisplayName("Test TbMsgProto getEntityType()")
  void testTbMsgProtoGetEntityType() {
    // Arrange, Act and Assert
    assertEquals("", MsgProtos.TbMsgProto.getDefaultInstance().getEntityType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getEntityTypeBytes()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#getEntityTypeBytes()}
   */
  @Test
  @DisplayName("Test TbMsgProto getEntityTypeBytes()")
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
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDataBytes());
    assertEquals(byteString, actualEntityTypeBytes);
    assertEquals(byteString, defaultInstance.getIdBytes());
    assertEquals(byteString, defaultInstance.getTypeBytes());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getId()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#getId()}
   */
  @Test
  @DisplayName("Test TbMsgProto getId()")
  void testTbMsgProtoGetId() {
    // Arrange, Act and Assert
    assertEquals("", MsgProtos.TbMsgProto.getDefaultInstance().getId());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getIdBytes()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#getIdBytes()}
   */
  @Test
  @DisplayName("Test TbMsgProto getIdBytes()")
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
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDataBytes());
    assertEquals(byteString, defaultInstance.getEntityTypeBytes());
    assertEquals(byteString, actualIdBytes);
    assertEquals(byteString, defaultInstance.getTypeBytes());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getSerializedSize()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#getSerializedSize()}
   */
  @Test
  @DisplayName("Test TbMsgProto getSerializedSize()")
  void testTbMsgProtoGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MsgProtos.TbMsgProto.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getType()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#getType()}
   */
  @Test
  @DisplayName("Test TbMsgProto getType()")
  void testTbMsgProtoGetType() {
    // Arrange, Act and Assert
    assertEquals("", MsgProtos.TbMsgProto.getDefaultInstance().getType());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#getTypeBytes()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#getTypeBytes()}
   */
  @Test
  @DisplayName("Test TbMsgProto getTypeBytes()")
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
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDataBytes());
    assertEquals(byteString, defaultInstance.getEntityTypeBytes());
    assertEquals(byteString, defaultInstance.getIdBytes());
    assertEquals(byteString, actualTypeBytes);
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#hasCtx()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#hasCtx()}
   */
  @Test
  @DisplayName("Test TbMsgProto hasCtx()")
  void testTbMsgProtoHasCtx() {
    // Arrange, Act and Assert
    assertFalse(MsgProtos.TbMsgProto.getDefaultInstance().hasCtx());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#hasMetaData()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#hasMetaData()}
   */
  @Test
  @DisplayName("Test TbMsgProto hasMetaData()")
  void testTbMsgProtoHasMetaData() {
    // Arrange, Act and Assert
    assertFalse(MsgProtos.TbMsgProto.getDefaultInstance().hasMetaData());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#isInitialized()}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#isInitialized()}
   */
  @Test
  @DisplayName("Test TbMsgProto isInitialized()")
  void testTbMsgProtoIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MsgProtos.TbMsgProto.getDefaultInstance().isInitialized());
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test TbMsgProto newInstance(UnusedPrivateParameter)")
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
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream) with 'input'")
  void testTbMsgProtoParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MsgProtos.TbMsgProto actualParseDelimitedFromResult = MsgProtos.TbMsgProto.parseDelimitedFrom(input);

    // Assert
    MsgProtos.TbMsgProcessingCtxProto ctx = actualParseDelimitedFromResult.getCtx();
    UnknownFieldSet unknownFields = ctx.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    Descriptors.Descriptor descriptorForType = ctx.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    MsgProtos.TbMsgMetaDataProto metaData = actualParseDelimitedFromResult.getMetaData();
    Descriptors.Descriptor descriptorForType3 = metaData.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    assertSame(reservedNameList, toProtoResult4.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType2.getOptions();
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
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(MsgProtos.TbMsgProto.CORRELATIONIDMSB_FIELD_NUMBER);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList2.get(0));
    assertSame(options, toProtoResult4.getOptions());
    assertSame(options, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(2));
    assertSame(descriptorForType3, messageTypes.get(0));
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    MsgProtos.TbMsgProto defaultInstanceForType3 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType2, defaultInstanceForType3.getDescriptorForType());
    assertSame(descriptorForType2, messageTypes.get(3));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, metaData.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(ctx, ctx.getDefaultInstanceForType());
    assertSame(ctx, defaultInstanceForType3.getCtx());
    assertSame(ctx, defaultInstanceForType3.getCtxOrBuilder());
    assertSame(ctx, actualParseDelimitedFromResult.getCtxOrBuilder());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(metaData, metaData.getDefaultInstanceForType());
    assertSame(metaData, defaultInstanceForType3.getMetaData());
    assertSame(metaData, defaultInstanceForType3.getMetaDataOrBuilder());
    assertSame(metaData, actualParseDelimitedFromResult.getMetaDataOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream) with 'input'")
  void testTbMsgProtoParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MsgProtos.TbMsgProto actualParseDelimitedFromResult = MsgProtos.TbMsgProto.parseDelimitedFrom(input);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(0, defaultInstanceForType.getUninterpretedOptionCount());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    MsgProtos.TbMsgProcessingCtxProto ctx = actualParseDelimitedFromResult.getCtx();
    Descriptors.Descriptor descriptorForType2 = ctx.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType2.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    MsgProtos.TbMsgMetaDataProto metaData = actualParseDelimitedFromResult.getMetaData();
    Descriptors.Descriptor descriptorForType3 = metaData.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    assertSame(reservedNameList, toProtoResult4.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
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
    assertSame(file, descriptorForType3.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(MsgProtos.TbMsgProto.CORRELATIONIDMSB_FIELD_NUMBER);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType2.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList2.get(0));
    assertSame(options, toProtoResult4.getOptions());
    assertSame(options, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult3.getContainingType());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(2));
    assertSame(descriptorForType3, messageTypes.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, messageTypes.get(3));
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, ctx.getUnknownFields());
    assertSame(unknownFields, metaData.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(ctx, ctx.getDefaultInstanceForType());
    assertSame(ctx, actualParseDelimitedFromResult.getCtxOrBuilder());
    assertSame(metaData, metaData.getDefaultInstanceForType());
    assertSame(metaData, actualParseDelimitedFromResult.getMetaDataOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream) with 'input'")
  void testTbMsgProtoParseDelimitedFromWithInput3() throws IOException {
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
   * Test TbMsgProto
   * {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgProtoParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MsgProtos.TbMsgProto actualParseDelimitedFromResult = MsgProtos.TbMsgProto.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    MsgProtos.TbMsgProcessingCtxProto ctx = actualParseDelimitedFromResult.getCtx();
    UnknownFieldSet unknownFields = ctx.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    Descriptors.Descriptor descriptorForType = ctx.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    MsgProtos.TbMsgMetaDataProto metaData = actualParseDelimitedFromResult.getMetaData();
    Descriptors.Descriptor descriptorForType3 = metaData.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    assertSame(reservedNameList, toProtoResult4.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType2.getOptions();
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
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(MsgProtos.TbMsgProto.CORRELATIONIDMSB_FIELD_NUMBER);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList2.get(0));
    assertSame(options, toProtoResult4.getOptions());
    assertSame(options, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(2));
    assertSame(descriptorForType3, messageTypes.get(0));
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    MsgProtos.TbMsgProto defaultInstanceForType3 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType2, defaultInstanceForType3.getDescriptorForType());
    assertSame(descriptorForType2, messageTypes.get(3));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, metaData.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(ctx, ctx.getDefaultInstanceForType());
    assertSame(ctx, defaultInstanceForType3.getCtx());
    assertSame(ctx, defaultInstanceForType3.getCtxOrBuilder());
    assertSame(ctx, actualParseDelimitedFromResult.getCtxOrBuilder());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(metaData, metaData.getDefaultInstanceForType());
    assertSame(metaData, defaultInstanceForType3.getMetaData());
    assertSame(metaData, defaultInstanceForType3.getMetaDataOrBuilder());
    assertSame(metaData, actualParseDelimitedFromResult.getMetaDataOrBuilder());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProto
   * {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgProtoParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MsgProtos.TbMsgProto actualParseDelimitedFromResult = MsgProtos.TbMsgProto.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(0, defaultInstanceForType.getUninterpretedOptionCount());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    MsgProtos.TbMsgProcessingCtxProto ctx = actualParseDelimitedFromResult.getCtx();
    Descriptors.Descriptor descriptorForType2 = ctx.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType.getFields();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType2.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    MsgProtos.TbMsgMetaDataProto metaData = actualParseDelimitedFromResult.getMetaData();
    Descriptors.Descriptor descriptorForType3 = metaData.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    assertSame(reservedNameList, toProtoResult4.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
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
    assertSame(file, descriptorForType3.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(MsgProtos.TbMsgProto.CORRELATIONIDMSB_FIELD_NUMBER);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType2.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList2.get(0));
    assertSame(options, toProtoResult4.getOptions());
    assertSame(options, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult3.getContainingType());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(2));
    assertSame(descriptorForType3, messageTypes.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, messageTypes.get(3));
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, ctx.getUnknownFields());
    assertSame(unknownFields, metaData.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(ctx, ctx.getDefaultInstanceForType());
    assertSame(ctx, actualParseDelimitedFromResult.getCtxOrBuilder());
    assertSame(metaData, metaData.getDefaultInstanceForType());
    assertSame(metaData, actualParseDelimitedFromResult.getMetaDataOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test TbMsgProto
   * {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgProtoParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
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
   * Test TbMsgProto
   * {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testTbMsgProtoParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
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
   * Test TbMsgProto
   * {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testTbMsgProtoParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MsgProtos.TbMsgProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgProto
   * {@link TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  void testTbMsgProtoParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
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
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testTbMsgProtoParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MsgProtos.TbMsgProto.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testTbMsgProtoParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
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
   * Test TbMsgProto {@link TbMsgProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testTbMsgProtoParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
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
   * Test TbMsgProto {@link TbMsgProto#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(InputStream) with 'InputStream'")
  void testTbMsgProtoParseFromWithInputStream() throws IOException {
    // Arrange and Act
    MsgProtos.TbMsgProto actualParseFromResult = MsgProtos.TbMsgProto.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    MsgProtos.TbMsgProcessingCtxProto ctx = actualParseFromResult.getCtx();
    Descriptors.Descriptor descriptorForType = ctx.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.Descriptor descriptorForType2 = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    MsgProtos.TbMsgMetaDataProto metaData = actualParseFromResult.getMetaData();
    Descriptors.Descriptor descriptorForType3 = metaData.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    assertSame(reservedNameList, toProtoResult4.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType2.getOptions();
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
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(MsgProtos.TbMsgProto.CORRELATIONIDMSB_FIELD_NUMBER);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList2.get(0));
    assertSame(options, toProtoResult4.getOptions());
    assertSame(options, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(2));
    assertSame(descriptorForType3, messageTypes.get(0));
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(3));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, ctx.getUnknownFields());
    assertSame(unknownFields, metaData.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(ctx, ctx.getDefaultInstanceForType());
    assertSame(ctx, actualParseFromResult.getCtxOrBuilder());
    assertSame(metaData, metaData.getDefaultInstanceForType());
    assertSame(metaData, actualParseFromResult.getMetaDataOrBuilder());
  }

  /**
   * Test TbMsgProto
   * {@link TbMsgProto#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testTbMsgProtoParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MsgProtos.TbMsgProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProto
   * {@link TbMsgProto#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MsgProtos.TbMsgProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testTbMsgProtoParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MsgProtos.TbMsgProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testTbMsgProtoParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MsgProtos.TbMsgProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testTbMsgProtoParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MsgProtos.TbMsgProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test TbMsgProto {@link TbMsgProto#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MsgProtos.TbMsgProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test TbMsgProto parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testTbMsgProtoParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    MsgProtos.TbMsgProto actualParseFromResult = MsgProtos.TbMsgProto.parseFrom((InputStream) null);

    // Assert
    MsgProtos.TbMsgProcessingCtxProto ctx = actualParseFromResult.getCtx();
    Descriptors.Descriptor descriptorForType = ctx.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.Descriptor descriptorForType2 = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(MsgProtos.TbMsgProto.CORRELATIONIDLSB_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    MsgProtos.TbMsgMetaDataProto metaData = actualParseFromResult.getMetaData();
    Descriptors.Descriptor descriptorForType3 = metaData.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    assertSame(reservedNameList, toProtoResult4.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType2.getOptions();
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
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(MsgProtos.TbMsgProto.CORRELATIONIDMSB_FIELD_NUMBER);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(MsgProtos.TbMsgProto.CTX_FIELD_NUMBER);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(toProtoResult5, fieldList2.get(0));
    assertSame(options, toProtoResult4.getOptions());
    assertSame(options, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(2));
    assertSame(descriptorForType3, messageTypes.get(0));
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(3));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, ctx.getUnknownFields());
    assertSame(unknownFields, metaData.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(ctx, ctx.getDefaultInstanceForType());
    assertSame(ctx, actualParseFromResult.getCtxOrBuilder());
    assertSame(metaData, metaData.getDefaultInstanceForType());
    assertSame(metaData, actualParseFromResult.getMetaDataOrBuilder());
  }
}
