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
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DeviceUpdateMsgDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceUpdateMsg#equals(Object)}
   *   <li>{@link DeviceUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceUpdateMsg#equals(Object)}
   *   <li>{@link DeviceUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceUpdateMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceUpdateMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceUpdateMsg.getDefaultInstance(), "Different type to DeviceUpdateMsg");
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertEquals("", DeviceUpdateMsg.getDefaultInstance().getAdditionalInfo());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#getAdditionalInfoBytes()}
   */
  @Test
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
   * Method under test: {@link DeviceUpdateMsg#getConflictName()}
   */
  @Test
  void testGetConflictName() {
    // Arrange, Act and Assert
    assertEquals("", DeviceUpdateMsg.getDefaultInstance().getConflictName());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#getConflictNameBytes()}
   */
  @Test
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
   * Method under test: {@link DeviceUpdateMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#getEntity()}
   */
  @Test
  void testGetEntity() {
    // Arrange, Act and Assert
    assertEquals("", DeviceUpdateMsg.getDefaultInstance().getEntity());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#getEntityBytes()}
   */
  @Test
  void testGetEntityBytes() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualEntityBytes = defaultInstance.getEntityBytes();

    // Assert
    ByteString byteString = actualEntityBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualEntityBytes);
    assertEquals(DeviceUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getDeviceDataBytes());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#getLabel()}
   */
  @Test
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("", DeviceUpdateMsg.getDefaultInstance().getLabel());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#getLabelBytes()}
   */
  @Test
  void testGetLabelBytes() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualLabelBytes = defaultInstance.getLabelBytes();

    // Assert
    ByteString byteString = actualLabelBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualLabelBytes);
    assertEquals(DeviceUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getDeviceDataBytes());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#getMsgType()}
   */
  @Test
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, DeviceUpdateMsg.getDefaultInstance().getMsgType());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("", DeviceUpdateMsg.getDefaultInstance().getName());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#getNameBytes()}
   */
  @Test
  void testGetNameBytes() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualNameBytes);
    assertEquals(DeviceUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getDeviceDataBytes());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DeviceUpdateMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#getType()}
   */
  @Test
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("", DeviceUpdateMsg.getDefaultInstance().getType());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#getTypeBytes()}
   */
  @Test
  void testGetTypeBytes() {
    // Arrange
    DeviceUpdateMsg defaultInstance = DeviceUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualTypeBytes = defaultInstance.getTypeBytes();

    // Assert
    ByteString byteString = actualTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualTypeBytes);
    assertEquals(DeviceUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getDeviceDataBytes());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#hasAdditionalInfo()}
   */
  @Test
  void testHasAdditionalInfo() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasAdditionalInfo());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#hasConflictName()}
   */
  @Test
  void testHasConflictName() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasConflictName());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#hasCustomerIdLSB()}
   */
  @Test
  void testHasCustomerIdLSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasCustomerIdLSB());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#hasCustomerIdMSB()}
   */
  @Test
  void testHasCustomerIdMSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasCustomerIdMSB());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#hasDeviceDataBytes()}
   */
  @Test
  void testHasDeviceDataBytes() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasDeviceDataBytes());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#hasDeviceProfileIdLSB()}
   */
  @Test
  void testHasDeviceProfileIdLSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasDeviceProfileIdLSB());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#hasDeviceProfileIdMSB()}
   */
  @Test
  void testHasDeviceProfileIdMSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasDeviceProfileIdMSB());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#hasFirmwareIdLSB()}
   */
  @Test
  void testHasFirmwareIdLSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasFirmwareIdLSB());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#hasFirmwareIdMSB()}
   */
  @Test
  void testHasFirmwareIdMSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasFirmwareIdMSB());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#hasLabel()}
   */
  @Test
  void testHasLabel() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasLabel());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#hasSoftwareIdLSB()}
   */
  @Test
  void testHasSoftwareIdLSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasSoftwareIdLSB());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#hasSoftwareIdMSB()}
   */
  @Test
  void testHasSoftwareIdMSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceUpdateMsg.getDefaultInstance().hasSoftwareIdMSB());
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DeviceUpdateMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link DeviceUpdateMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
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
   * Method under test: {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DeviceUpdateMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
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
   * Method under test: {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
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
   * Method under test: {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
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
   * Method under test:
   * {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DeviceUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
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
   * Method under test:
   * {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> DeviceUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DeviceUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
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
   * Method under test: {@link DeviceUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DeviceUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link DeviceUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DeviceUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link DeviceUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DeviceUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link DeviceUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DeviceUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
