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
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TenantProfileUpdateMsgDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileUpdateMsg#equals(Object)}
   *   <li>{@link TenantProfileUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfileUpdateMsg defaultInstance = TenantProfileUpdateMsg.getDefaultInstance();
    TenantProfileUpdateMsg defaultInstance2 = TenantProfileUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileUpdateMsg#equals(Object)}
   *   <li>{@link TenantProfileUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantProfileUpdateMsg defaultInstance = TenantProfileUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantProfileUpdateMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantProfileUpdateMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantProfileUpdateMsg.getDefaultInstance(), "Different type to TenantProfileUpdateMsg");
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    TenantProfileUpdateMsg defaultInstance = TenantProfileUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#getDescription()}
   */
  @Test
  void testGetDescription() {
    // Arrange, Act and Assert
    assertEquals("", TenantProfileUpdateMsg.getDefaultInstance().getDescription());
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#getDescriptionBytes()}
   */
  @Test
  void testGetDescriptionBytes() {
    // Arrange
    TenantProfileUpdateMsg defaultInstance = TenantProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualDescriptionBytes = defaultInstance.getDescriptionBytes();

    // Assert
    ByteString byteString = actualDescriptionBytes.EMPTY;
    assertEquals(byteString, actualDescriptionBytes);
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(TenantProfileUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    assertSame(byteString, fields.get(7).getDefaultValue());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#getEntity()}
   */
  @Test
  void testGetEntity() {
    // Arrange, Act and Assert
    assertEquals("", TenantProfileUpdateMsg.getDefaultInstance().getEntity());
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#getEntityBytes()}
   */
  @Test
  void testGetEntityBytes() {
    // Arrange
    TenantProfileUpdateMsg defaultInstance = TenantProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualEntityBytes = defaultInstance.getEntityBytes();

    // Assert
    ByteString byteString = actualEntityBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(byteString, actualEntityBytes);
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(TenantProfileUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    assertSame(byteString, fields.get(7).getDefaultValue());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#getMsgType()}
   */
  @Test
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, TenantProfileUpdateMsg.getDefaultInstance().getMsgType());
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("", TenantProfileUpdateMsg.getDefaultInstance().getName());
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#getNameBytes()}
   */
  @Test
  void testGetNameBytes() {
    // Arrange
    TenantProfileUpdateMsg defaultInstance = TenantProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    assertEquals(byteString, actualNameBytes);
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(TenantProfileUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    assertSame(byteString, fields.get(7).getDefaultValue());
    assertSame(byteString, defaultInstance.getProfileDataBytes());
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, TenantProfileUpdateMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#hasDescription()}
   */
  @Test
  void testHasDescription() {
    // Arrange, Act and Assert
    assertFalse(TenantProfileUpdateMsg.getDefaultInstance().hasDescription());
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(TenantProfileUpdateMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link TenantProfileUpdateMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testNewInstance() {
    // Arrange
    TenantProfileUpdateMsg defaultInstance = TenantProfileUpdateMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof TenantProfileUpdateMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link TenantProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TenantProfileUpdateMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TenantProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> TenantProfileUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TenantProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TenantProfileUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TenantProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TenantProfileUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TenantProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(TenantProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link TenantProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> TenantProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TenantProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> TenantProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link TenantProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> TenantProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> TenantProfileUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link TenantProfileUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> TenantProfileUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TenantProfileUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> TenantProfileUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link TenantProfileUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> TenantProfileUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
