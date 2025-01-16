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

class DeviceUpdateMsgDiffblueTest {
  /**
   * Test {@link DeviceUpdateMsg#equals(Object)}, and
   * {@link DeviceUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceUpdateMsg#equals(Object)}
   *   <li>{@link DeviceUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();
    DeviceUpdateMsg defaultInstance2 = DeviceUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link DeviceUpdateMsg#equals(Object)}, and
   * {@link DeviceUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceUpdateMsg#equals(Object)}
   *   <li>{@link DeviceUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link DeviceUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceUpdateMsg.getDefaultInstance(), 1);
  }

  /**
   * Test {@link DeviceUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceUpdateMsg.getDefaultInstance(), null);
  }

  /**
   * Test {@link DeviceUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceUpdateMsg.getDefaultInstance(), "Different type to DeviceUpdateMsg");
  }

  /**
   * Test {@link DeviceUpdateMsg#getAdditionalInfo()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo()")
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertEquals("", DeviceUpdateMsg.getDefaultInstance().getAdditionalInfo());
  }

  /**
   * Test {@link DeviceUpdateMsg#getAdditionalInfoBytes()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getAdditionalInfoBytes()}
   */
  @Test
  @DisplayName("Test getAdditionalInfoBytes()")
  void testGetAdditionalInfoBytes() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualAdditionalInfoBytes = defaultInstance.getAdditionalInfoBytes();

    // Assert
    ByteString byteString = actualAdditionalInfoBytes.EMPTY;
    assertEquals(byteString, actualAdditionalInfoBytes);
    assertEquals(byteString, defaultInstance.getConflictNameBytes());
    assertEquals(DeviceUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getDeviceDataBytes());
  }

  /**
   * Test {@link DeviceUpdateMsg#getConflictName()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getConflictName()}
   */
  @Test
  @DisplayName("Test getConflictName()")
  void testGetConflictName() {
    // Arrange, Act and Assert
    assertEquals("", DeviceUpdateMsg.getDefaultInstance().getConflictName());
  }

  /**
   * Test {@link DeviceUpdateMsg#getConflictNameBytes()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getConflictNameBytes()}
   */
  @Test
  @DisplayName("Test getConflictNameBytes()")
  void testGetConflictNameBytes() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualConflictNameBytes = defaultInstance.getConflictNameBytes();

    // Assert
    ByteString byteString = actualConflictNameBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualConflictNameBytes);
    assertEquals(DeviceUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getDeviceDataBytes());
  }

  /**
   * Test {@link DeviceUpdateMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  void testGetDefaultInstanceForType() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link DeviceUpdateMsg#getEntity()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  void testGetEntity() {
    // Arrange, Act and Assert
    assertEquals("", DeviceUpdateMsg.getDefaultInstance().getEntity());
  }

  /**
   * Test {@link DeviceUpdateMsg#getEntityBytes()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getEntityBytes()}
   */
  @Test
  @DisplayName("Test getEntityBytes()")
  void testGetEntityBytes() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualEntityBytes = defaultInstance.getEntityBytes();

    // Assert
    ByteString byteString = actualEntityBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getConflictNameBytes());
    assertEquals(byteString, actualEntityBytes);
    assertEquals(DeviceUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getDeviceDataBytes());
  }

  /**
   * Test {@link DeviceUpdateMsg#getLabel()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("", DeviceUpdateMsg.getDefaultInstance().getLabel());
  }

  /**
   * Test {@link DeviceUpdateMsg#getLabelBytes()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getLabelBytes()}
   */
  @Test
  @DisplayName("Test getLabelBytes()")
  void testGetLabelBytes() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualLabelBytes = defaultInstance.getLabelBytes();

    // Assert
    ByteString byteString = actualLabelBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getConflictNameBytes());
    assertEquals(byteString, actualLabelBytes);
    assertEquals(DeviceUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getDeviceDataBytes());
  }

  /**
   * Test {@link DeviceUpdateMsg#getMsgType()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getMsgType()}
   */
  @Test
  @DisplayName("Test getMsgType()")
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, DeviceUpdateMsg.getDefaultInstance().getMsgType());
  }

  /**
   * Test {@link DeviceUpdateMsg#getName()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("", DeviceUpdateMsg.getDefaultInstance().getName());
  }

  /**
   * Test {@link DeviceUpdateMsg#getNameBytes()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getNameBytes()}
   */
  @Test
  @DisplayName("Test getNameBytes()")
  void testGetNameBytes() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getConflictNameBytes());
    assertEquals(byteString, actualNameBytes);
    assertEquals(DeviceUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getDeviceDataBytes());
  }

  /**
   * Test {@link DeviceUpdateMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DeviceUpdateMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link DeviceUpdateMsg#getType()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("", DeviceUpdateMsg.getDefaultInstance().getType());
  }

  /**
   * Test {@link DeviceUpdateMsg#getTypeBytes()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#getTypeBytes()}
   */
  @Test
  @DisplayName("Test getTypeBytes()")
  void testGetTypeBytes() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualTypeBytes = defaultInstance.getTypeBytes();

    // Assert
    ByteString byteString = actualTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getConflictNameBytes());
    assertEquals(byteString, actualTypeBytes);
    assertEquals(DeviceUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getDeviceDataBytes());
  }

  /**
   * Test {@link DeviceUpdateMsg#hasAdditionalInfo()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#hasAdditionalInfo()}
   */
  @Test
  @DisplayName("Test hasAdditionalInfo()")
  void testHasAdditionalInfo() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasAdditionalInfo());
  }

  /**
   * Test {@link DeviceUpdateMsg#hasConflictName()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#hasConflictName()}
   */
  @Test
  @DisplayName("Test hasConflictName()")
  void testHasConflictName() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasConflictName());
  }

  /**
   * Test {@link DeviceUpdateMsg#hasCustomerIdLSB()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#hasCustomerIdLSB()}
   */
  @Test
  @DisplayName("Test hasCustomerIdLSB()")
  void testHasCustomerIdLSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasCustomerIdLSB());
  }

  /**
   * Test {@link DeviceUpdateMsg#hasCustomerIdMSB()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#hasCustomerIdMSB()}
   */
  @Test
  @DisplayName("Test hasCustomerIdMSB()")
  void testHasCustomerIdMSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasCustomerIdMSB());
  }

  /**
   * Test {@link DeviceUpdateMsg#hasDeviceDataBytes()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#hasDeviceDataBytes()}
   */
  @Test
  @DisplayName("Test hasDeviceDataBytes()")
  void testHasDeviceDataBytes() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasDeviceDataBytes());
  }

  /**
   * Test {@link DeviceUpdateMsg#hasDeviceProfileIdLSB()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#hasDeviceProfileIdLSB()}
   */
  @Test
  @DisplayName("Test hasDeviceProfileIdLSB()")
  void testHasDeviceProfileIdLSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasDeviceProfileIdLSB());
  }

  /**
   * Test {@link DeviceUpdateMsg#hasDeviceProfileIdMSB()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#hasDeviceProfileIdMSB()}
   */
  @Test
  @DisplayName("Test hasDeviceProfileIdMSB()")
  void testHasDeviceProfileIdMSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasDeviceProfileIdMSB());
  }

  /**
   * Test {@link DeviceUpdateMsg#hasFirmwareIdLSB()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#hasFirmwareIdLSB()}
   */
  @Test
  @DisplayName("Test hasFirmwareIdLSB()")
  void testHasFirmwareIdLSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasFirmwareIdLSB());
  }

  /**
   * Test {@link DeviceUpdateMsg#hasFirmwareIdMSB()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#hasFirmwareIdMSB()}
   */
  @Test
  @DisplayName("Test hasFirmwareIdMSB()")
  void testHasFirmwareIdMSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasFirmwareIdMSB());
  }

  /**
   * Test {@link DeviceUpdateMsg#hasLabel()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#hasLabel()}
   */
  @Test
  @DisplayName("Test hasLabel()")
  void testHasLabel() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasLabel());
  }

  /**
   * Test {@link DeviceUpdateMsg#hasSoftwareIdLSB()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#hasSoftwareIdLSB()}
   */
  @Test
  @DisplayName("Test hasSoftwareIdLSB()")
  void testHasSoftwareIdLSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasSoftwareIdLSB());
  }

  /**
   * Test {@link DeviceUpdateMsg#hasSoftwareIdMSB()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#hasSoftwareIdMSB()}
   */
  @Test
  @DisplayName("Test hasSoftwareIdMSB()")
  void testHasSoftwareIdMSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasSoftwareIdMSB());
  }

  /**
   * Test {@link DeviceUpdateMsg#isInitialized()}.
   * <p>
   * Method under test: {@link DeviceUpdateMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DeviceUpdateMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link DeviceUpdateMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link DeviceUpdateMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test newInstance(UnusedPrivateParameter)")
  void testNewInstance() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof DeviceUpdateMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test
   * {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> DeviceUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> DeviceUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DeviceUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test
   * {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> DeviceUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DeviceUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DeviceUpdateMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DeviceUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream)}
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
    assertThrows(InvalidProtocolBufferException.class, () -> DeviceUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DeviceUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link DeviceUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
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
        () -> DeviceUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DeviceUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DeviceUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DeviceUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DeviceUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DeviceUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DeviceUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DeviceUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty
   * array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    DeviceUpdateMsg actualParseFromResult = DeviceUpdateMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(DeviceUpdateMsg.CONFLICTNAME_FIELD_NUMBER, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(DeviceUpdateMsg.CONFLICTNAME_FIELD_NUMBER, oneofs.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(DeviceUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(DeviceUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList expectedReservedNameList = toProtoResult.getReservedNameList();
    assertSame(expectedReservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult2.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult2.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(DeviceUpdateMsg.SOFTWAREIDMSB_FIELD_NUMBER);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType2.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType2.getFeaturesOrBuilder());
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
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(DeviceUpdateMsg.SOFTWAREIDLSB_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    Descriptors.OneofDescriptor getResult11 = oneofs.get(DeviceUpdateMsg.ADDITIONALINFO_FIELD_NUMBER);
    assertSame(file, getResult11.getFile());
    Descriptors.OneofDescriptor getResult12 = oneofs.get(DeviceUpdateMsg.LABEL_FIELD_NUMBER);
    assertSame(file, getResult12.getFile());
    DescriptorProtos.MessageOptions options5 = options2.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options5, getResult3.getOptions());
    assertSame(options5, getResult4.getOptions());
    assertSame(options5, getResult5.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult7.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult8.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult2.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    assertSame(descriptorForType, getResult11.getContainingType());
    assertSame(descriptorForType, getResult12.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult11, getResult2.getContainingOneof());
  }

  /**
   * Test {@link DeviceUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    DeviceUpdateMsg actualParseFromResult = DeviceUpdateMsg.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(DeviceUpdateMsg.CONFLICTNAME_FIELD_NUMBER, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(DeviceUpdateMsg.CONFLICTNAME_FIELD_NUMBER, oneofs.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(DeviceUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(DeviceUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList expectedReservedNameList = toProtoResult.getReservedNameList();
    assertSame(expectedReservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult2.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult2.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(DeviceUpdateMsg.SOFTWAREIDMSB_FIELD_NUMBER);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType2.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType2.getFeaturesOrBuilder());
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
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(DeviceUpdateMsg.SOFTWAREIDLSB_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    Descriptors.OneofDescriptor getResult11 = oneofs.get(DeviceUpdateMsg.ADDITIONALINFO_FIELD_NUMBER);
    assertSame(file, getResult11.getFile());
    Descriptors.OneofDescriptor getResult12 = oneofs.get(DeviceUpdateMsg.LABEL_FIELD_NUMBER);
    assertSame(file, getResult12.getFile());
    DescriptorProtos.MessageOptions options5 = options2.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options5, getResult3.getOptions());
    assertSame(options5, getResult4.getOptions());
    assertSame(options5, getResult5.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult7.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult8.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(options, toProtoResult2.getOptions());
    assertSame(options, toProtoResult2.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    assertSame(descriptorForType, getResult11.getContainingType());
    assertSame(descriptorForType, getResult12.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult11, getResult2.getContainingOneof());
  }
}
