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

class DeviceProfileUpdateMsgDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfileUpdateMsg#equals(Object)}
   *   <li>{@link DeviceProfileUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();
    DeviceProfileUpdateMsg defaultInstance2 = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfileUpdateMsg#equals(Object)}
   *   <li>{@link DeviceProfileUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceProfileUpdateMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceProfileUpdateMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceProfileUpdateMsg.getDefaultInstance(), "Different type to DeviceProfileUpdateMsg");
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getDefaultQueueName()}
   */
  @Test
  void testGetDefaultQueueName() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getDefaultQueueName());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getDefaultQueueNameBytes()}
   */
  @Test
  void testGetDefaultQueueNameBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualDefaultQueueNameBytes = defaultInstance.getDefaultQueueNameBytes();

    // Assert
    ByteString byteString = actualDefaultQueueNameBytes.EMPTY;
    assertEquals(byteString, actualDefaultQueueNameBytes);
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getDescription()}
   */
  @Test
  void testGetDescription() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getDescription());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getDescriptionBytes()}
   */
  @Test
  void testGetDescriptionBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualDescriptionBytes = defaultInstance.getDescriptionBytes();

    // Assert
    ByteString byteString = actualDescriptionBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, actualDescriptionBytes);
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getEntity()}
   */
  @Test
  void testGetEntity() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getEntity());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getEntityBytes()}
   */
  @Test
  void testGetEntityBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualEntityBytes = defaultInstance.getEntityBytes();

    // Assert
    ByteString byteString = actualEntityBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, actualEntityBytes);
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getMsgType()}
   */
  @Test
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, DeviceProfileUpdateMsg.getDefaultInstance().getMsgType());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getName());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getNameBytes()}
   */
  @Test
  void testGetNameBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, actualNameBytes);
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getProvisionDeviceKey()}
   */
  @Test
  void testGetProvisionDeviceKey() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getProvisionDeviceKey());
  }

  /**
   * Method under test:
   * {@link DeviceProfileUpdateMsg#getProvisionDeviceKeyBytes()}
   */
  @Test
  void testGetProvisionDeviceKeyBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualProvisionDeviceKeyBytes = defaultInstance.getProvisionDeviceKeyBytes();

    // Assert
    ByteString byteString = actualProvisionDeviceKeyBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, actualProvisionDeviceKeyBytes);
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getProvisionType()}
   */
  @Test
  void testGetProvisionType() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getProvisionType());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getProvisionTypeBytes()}
   */
  @Test
  void testGetProvisionTypeBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualProvisionTypeBytes = defaultInstance.getProvisionTypeBytes();

    // Assert
    ByteString byteString = actualProvisionTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, actualProvisionTypeBytes);
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DeviceProfileUpdateMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getTransportType()}
   */
  @Test
  void testGetTransportType() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getTransportType());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getTransportTypeBytes()}
   */
  @Test
  void testGetTransportTypeBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualTransportTypeBytes = defaultInstance.getTransportTypeBytes();

    // Assert
    ByteString byteString = actualTransportTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, actualTransportTypeBytes);
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getType()}
   */
  @Test
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getType());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#getTypeBytes()}
   */
  @Test
  void testGetTypeBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualTypeBytes = defaultInstance.getTypeBytes();

    // Assert
    ByteString byteString = actualTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, actualTypeBytes);
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#hasDefaultDashboardIdLSB()}
   */
  @Test
  void testHasDefaultDashboardIdLSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasDefaultDashboardIdLSB());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#hasDefaultDashboardIdMSB()}
   */
  @Test
  void testHasDefaultDashboardIdMSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasDefaultDashboardIdMSB());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#hasDescription()}
   */
  @Test
  void testHasDescription() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasDescription());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#hasFirmwareIdLSB()}
   */
  @Test
  void testHasFirmwareIdLSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasFirmwareIdLSB());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#hasFirmwareIdMSB()}
   */
  @Test
  void testHasFirmwareIdMSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasFirmwareIdMSB());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#hasImage()}
   */
  @Test
  void testHasImage() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasImage());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#hasProvisionDeviceKey()}
   */
  @Test
  void testHasProvisionDeviceKey() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasProvisionDeviceKey());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#hasProvisionType()}
   */
  @Test
  void testHasProvisionType() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasProvisionType());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#hasSoftwareIdLSB()}
   */
  @Test
  void testHasSoftwareIdLSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasSoftwareIdLSB());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#hasSoftwareIdMSB()}
   */
  @Test
  void testHasSoftwareIdMSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasSoftwareIdMSB());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#hasTransportType()}
   */
  @Test
  void testHasTransportType() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasTransportType());
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DeviceProfileUpdateMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link DeviceProfileUpdateMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testNewInstance() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof DeviceProfileUpdateMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DeviceProfileUpdateMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DeviceProfileUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DeviceProfileUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> DeviceProfileUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DeviceProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> DeviceProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> DeviceProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> DeviceProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DeviceProfileUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link DeviceProfileUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DeviceProfileUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> DeviceProfileUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DeviceProfileUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
