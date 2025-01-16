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

class DeviceProfileUpdateMsgDiffblueTest {
  /**
   * Test {@link DeviceProfileUpdateMsg#equals(Object)}, and
   * {@link DeviceProfileUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfileUpdateMsg#equals(Object)}
   *   <li>{@link DeviceProfileUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link DeviceProfileUpdateMsg#equals(Object)}, and
   * {@link DeviceProfileUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfileUpdateMsg#equals(Object)}
   *   <li>{@link DeviceProfileUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceProfileUpdateMsg.getDefaultInstance(), 1);
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceProfileUpdateMsg.getDefaultInstance(), null);
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DeviceProfileUpdateMsg.getDefaultInstance(), "Different type to DeviceProfileUpdateMsg");
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  void testGetDefaultInstanceForType() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getDefaultQueueName()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getDefaultQueueName()}
   */
  @Test
  @DisplayName("Test getDefaultQueueName()")
  void testGetDefaultQueueName() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getDefaultQueueName());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getDefaultQueueNameBytes()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getDefaultQueueNameBytes()}
   */
  @Test
  @DisplayName("Test getDefaultQueueNameBytes()")
  void testGetDefaultQueueNameBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualDefaultQueueNameBytes = defaultInstance.getDefaultQueueNameBytes();

    // Assert
    ByteString byteString = actualDefaultQueueNameBytes.EMPTY;
    assertEquals(byteString, actualDefaultQueueNameBytes);
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getDescription()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  void testGetDescription() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getDescription());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getDescriptionBytes()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getDescriptionBytes()}
   */
  @Test
  @DisplayName("Test getDescriptionBytes()")
  void testGetDescriptionBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualDescriptionBytes = defaultInstance.getDescriptionBytes();

    // Assert
    ByteString byteString = actualDescriptionBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, actualDescriptionBytes);
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getEntity()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  void testGetEntity() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getEntity());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getEntityBytes()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getEntityBytes()}
   */
  @Test
  @DisplayName("Test getEntityBytes()")
  void testGetEntityBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualEntityBytes = defaultInstance.getEntityBytes();

    // Assert
    ByteString byteString = actualEntityBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(byteString, actualEntityBytes);
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getMsgType()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getMsgType()}
   */
  @Test
  @DisplayName("Test getMsgType()")
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, DeviceProfileUpdateMsg.getDefaultInstance().getMsgType());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getName()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getName());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getNameBytes()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getNameBytes()}
   */
  @Test
  @DisplayName("Test getNameBytes()")
  void testGetNameBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, actualNameBytes);
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getProvisionDeviceKey()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getProvisionDeviceKey()}
   */
  @Test
  @DisplayName("Test getProvisionDeviceKey()")
  void testGetProvisionDeviceKey() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getProvisionDeviceKey());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getProvisionDeviceKeyBytes()}.
   * <p>
   * Method under test:
   * {@link DeviceProfileUpdateMsg#getProvisionDeviceKeyBytes()}
   */
  @Test
  @DisplayName("Test getProvisionDeviceKeyBytes()")
  void testGetProvisionDeviceKeyBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualProvisionDeviceKeyBytes = defaultInstance.getProvisionDeviceKeyBytes();

    // Assert
    ByteString byteString = actualProvisionDeviceKeyBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, actualProvisionDeviceKeyBytes);
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getProvisionType()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getProvisionType()}
   */
  @Test
  @DisplayName("Test getProvisionType()")
  void testGetProvisionType() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getProvisionType());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getProvisionTypeBytes()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getProvisionTypeBytes()}
   */
  @Test
  @DisplayName("Test getProvisionTypeBytes()")
  void testGetProvisionTypeBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualProvisionTypeBytes = defaultInstance.getProvisionTypeBytes();

    // Assert
    ByteString byteString = actualProvisionTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, actualProvisionTypeBytes);
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DeviceProfileUpdateMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getTransportType()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getTransportType()}
   */
  @Test
  @DisplayName("Test getTransportType()")
  void testGetTransportType() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getTransportType());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getTransportTypeBytes()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getTransportTypeBytes()}
   */
  @Test
  @DisplayName("Test getTransportTypeBytes()")
  void testGetTransportTypeBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualTransportTypeBytes = defaultInstance.getTransportTypeBytes();

    // Assert
    ByteString byteString = actualTransportTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, actualTransportTypeBytes);
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getType()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("", DeviceProfileUpdateMsg.getDefaultInstance().getType());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#getTypeBytes()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#getTypeBytes()}
   */
  @Test
  @DisplayName("Test getTypeBytes()")
  void testGetTypeBytes() {
    // Arrange
    DeviceProfileUpdateMsg defaultInstance = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualTypeBytes = defaultInstance.getTypeBytes();

    // Assert
    ByteString byteString = actualTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, actualTypeBytes);
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getImage());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#hasDefaultDashboardIdLSB()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#hasDefaultDashboardIdLSB()}
   */
  @Test
  @DisplayName("Test hasDefaultDashboardIdLSB()")
  void testHasDefaultDashboardIdLSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasDefaultDashboardIdLSB());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#hasDefaultDashboardIdMSB()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#hasDefaultDashboardIdMSB()}
   */
  @Test
  @DisplayName("Test hasDefaultDashboardIdMSB()")
  void testHasDefaultDashboardIdMSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasDefaultDashboardIdMSB());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#hasDescription()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#hasDescription()}
   */
  @Test
  @DisplayName("Test hasDescription()")
  void testHasDescription() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasDescription());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#hasFirmwareIdLSB()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#hasFirmwareIdLSB()}
   */
  @Test
  @DisplayName("Test hasFirmwareIdLSB()")
  void testHasFirmwareIdLSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasFirmwareIdLSB());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#hasFirmwareIdMSB()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#hasFirmwareIdMSB()}
   */
  @Test
  @DisplayName("Test hasFirmwareIdMSB()")
  void testHasFirmwareIdMSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasFirmwareIdMSB());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#hasImage()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#hasImage()}
   */
  @Test
  @DisplayName("Test hasImage()")
  void testHasImage() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasImage());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#hasProvisionDeviceKey()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#hasProvisionDeviceKey()}
   */
  @Test
  @DisplayName("Test hasProvisionDeviceKey()")
  void testHasProvisionDeviceKey() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasProvisionDeviceKey());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#hasProvisionType()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#hasProvisionType()}
   */
  @Test
  @DisplayName("Test hasProvisionType()")
  void testHasProvisionType() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasProvisionType());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#hasSoftwareIdLSB()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#hasSoftwareIdLSB()}
   */
  @Test
  @DisplayName("Test hasSoftwareIdLSB()")
  void testHasSoftwareIdLSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasSoftwareIdLSB());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#hasSoftwareIdMSB()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#hasSoftwareIdMSB()}
   */
  @Test
  @DisplayName("Test hasSoftwareIdMSB()")
  void testHasSoftwareIdMSB() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasSoftwareIdMSB());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#hasTransportType()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#hasTransportType()}
   */
  @Test
  @DisplayName("Test hasTransportType()")
  void testHasTransportType() {
    // Arrange, Act and Assert
    assertFalse(DeviceProfileUpdateMsg.getDefaultInstance().hasTransportType());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#isInitialized()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DeviceProfileUpdateMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link DeviceProfileUpdateMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test newInstance(UnusedPrivateParameter)")
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
   * Test
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> DeviceProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> DeviceProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DeviceProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> DeviceProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
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
   * Test {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DeviceProfileUpdateMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
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
   * Test {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseDelimitedFrom(InputStream)}
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
    assertThrows(InvalidProtocolBufferException.class, () -> DeviceProfileUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link DeviceProfileUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
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
        () -> DeviceProfileUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test
   * {@link DeviceProfileUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> DeviceProfileUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DeviceProfileUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DeviceProfileUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty
   * array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    DeviceProfileUpdateMsg actualParseFromResult = DeviceProfileUpdateMsg
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

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
    assertEquals(DeviceProfileUpdateMsg.DEFAULTRULECHAINIDLSB_FIELD_NUMBER, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(DeviceProfileUpdateMsg.DEFAULTRULECHAINIDLSB_FIELD_NUMBER, oneofs.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
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
    Descriptors.FieldDescriptor getResult2 = fields.get(DeviceProfileUpdateMsg.DEFAULTDASHBOARDIDMSB_FIELD_NUMBER);
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
    Descriptors.FieldDescriptor getResult8 = fields.get(DeviceProfileUpdateMsg.DEFAULTDASHBOARDIDLSB_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    Descriptors.OneofDescriptor getResult11 = oneofs.get(DeviceProfileUpdateMsg.DEFAULTRULECHAINIDMSB_FIELD_NUMBER);
    assertSame(file, getResult11.getFile());
    Descriptors.OneofDescriptor getResult12 = oneofs.get(DeviceProfileUpdateMsg.PROVISIONTYPE_FIELD_NUMBER);
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
    ByteString expectedProfileDataBytes = actualParseFromResult.getImage();
    assertSame(expectedProfileDataBytes, actualParseFromResult.getProfileDataBytes());
  }

  /**
   * Test {@link DeviceProfileUpdateMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    DeviceProfileUpdateMsg actualParseFromResult = DeviceProfileUpdateMsg.parseFrom((InputStream) null);

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
    assertEquals(DeviceProfileUpdateMsg.DEFAULTRULECHAINIDLSB_FIELD_NUMBER, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(DeviceProfileUpdateMsg.DEFAULTRULECHAINIDLSB_FIELD_NUMBER, oneofs.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(DeviceProfileUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
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
    Descriptors.FieldDescriptor getResult2 = fields.get(DeviceProfileUpdateMsg.DEFAULTDASHBOARDIDMSB_FIELD_NUMBER);
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
    Descriptors.FieldDescriptor getResult8 = fields.get(DeviceProfileUpdateMsg.DEFAULTDASHBOARDIDLSB_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    Descriptors.OneofDescriptor getResult11 = oneofs.get(DeviceProfileUpdateMsg.DEFAULTRULECHAINIDMSB_FIELD_NUMBER);
    assertSame(file, getResult11.getFile());
    Descriptors.OneofDescriptor getResult12 = oneofs.get(DeviceProfileUpdateMsg.PROVISIONTYPE_FIELD_NUMBER);
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
    ByteString expectedProfileDataBytes = actualParseFromResult.getImage();
    assertSame(expectedProfileDataBytes, actualParseFromResult.getProfileDataBytes());
  }
}
