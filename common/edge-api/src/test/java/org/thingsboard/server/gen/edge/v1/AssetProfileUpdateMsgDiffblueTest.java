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

class AssetProfileUpdateMsgDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetProfileUpdateMsg#equals(Object)}
   *   <li>{@link AssetProfileUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetProfileUpdateMsg defaultInstance = AssetProfileUpdateMsg.getDefaultInstance();
    AssetProfileUpdateMsg defaultInstance2 = AssetProfileUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AssetProfileUpdateMsg#equals(Object)}
   *   <li>{@link AssetProfileUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetProfileUpdateMsg defaultInstance = AssetProfileUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetProfileUpdateMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetProfileUpdateMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AssetProfileUpdateMsg.getDefaultInstance(), "Different type to AssetProfileUpdateMsg");
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    AssetProfileUpdateMsg defaultInstance = AssetProfileUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#getDefaultQueueName()}
   */
  @Test
  void testGetDefaultQueueName() {
    // Arrange, Act and Assert
    assertEquals("", AssetProfileUpdateMsg.getDefaultInstance().getDefaultQueueName());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#getDefaultQueueNameBytes()}
   */
  @Test
  void testGetDefaultQueueNameBytes() {
    // Arrange
    AssetProfileUpdateMsg defaultInstance = AssetProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualDefaultQueueNameBytes = defaultInstance.getDefaultQueueNameBytes();

    // Assert
    ByteString byteString = actualDefaultQueueNameBytes.EMPTY;
    assertEquals(byteString, actualDefaultQueueNameBytes);
    assertEquals(byteString, defaultInstance.getDescriptionBytes());
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(AssetProfileUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    assertSame(byteString, fields.get(AssetProfileUpdateMsg.DEFAULTQUEUENAME_FIELD_NUMBER).getDefaultValue());
    assertSame(byteString, defaultInstance.getImage());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#getDescription()}
   */
  @Test
  void testGetDescription() {
    // Arrange, Act and Assert
    assertEquals("", AssetProfileUpdateMsg.getDefaultInstance().getDescription());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#getDescriptionBytes()}
   */
  @Test
  void testGetDescriptionBytes() {
    // Arrange
    AssetProfileUpdateMsg defaultInstance = AssetProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualDescriptionBytes = defaultInstance.getDescriptionBytes();

    // Assert
    ByteString byteString = actualDescriptionBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, actualDescriptionBytes);
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(AssetProfileUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    assertSame(byteString, fields.get(AssetProfileUpdateMsg.DEFAULTQUEUENAME_FIELD_NUMBER).getDefaultValue());
    assertSame(byteString, defaultInstance.getImage());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#getEntity()}
   */
  @Test
  void testGetEntity() {
    // Arrange, Act and Assert
    assertEquals("", AssetProfileUpdateMsg.getDefaultInstance().getEntity());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#getEntityBytes()}
   */
  @Test
  void testGetEntityBytes() {
    // Arrange
    AssetProfileUpdateMsg defaultInstance = AssetProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualEntityBytes = defaultInstance.getEntityBytes();

    // Assert
    ByteString byteString = actualEntityBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, actualEntityBytes);
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(AssetProfileUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    assertSame(byteString, fields.get(AssetProfileUpdateMsg.DEFAULTQUEUENAME_FIELD_NUMBER).getDefaultValue());
    assertSame(byteString, defaultInstance.getImage());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#getMsgType()}
   */
  @Test
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, AssetProfileUpdateMsg.getDefaultInstance().getMsgType());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("", AssetProfileUpdateMsg.getDefaultInstance().getName());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#getNameBytes()}
   */
  @Test
  void testGetNameBytes() {
    // Arrange
    AssetProfileUpdateMsg defaultInstance = AssetProfileUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getDefaultQueueNameBytes());
    assertEquals(byteString, actualNameBytes);
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(AssetProfileUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    assertSame(byteString, fields.get(AssetProfileUpdateMsg.DEFAULTQUEUENAME_FIELD_NUMBER).getDefaultValue());
    assertSame(byteString, defaultInstance.getImage());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AssetProfileUpdateMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#hasDefaultQueueName()}
   */
  @Test
  void testHasDefaultQueueName() {
    // Arrange, Act and Assert
    assertFalse(AssetProfileUpdateMsg.getDefaultInstance().hasDefaultQueueName());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#hasDescription()}
   */
  @Test
  void testHasDescription() {
    // Arrange, Act and Assert
    assertFalse(AssetProfileUpdateMsg.getDefaultInstance().hasDescription());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#hasImage()}
   */
  @Test
  void testHasImage() {
    // Arrange, Act and Assert
    assertFalse(AssetProfileUpdateMsg.getDefaultInstance().hasImage());
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AssetProfileUpdateMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link AssetProfileUpdateMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testNewInstance() {
    // Arrange
    AssetProfileUpdateMsg defaultInstance = AssetProfileUpdateMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof AssetProfileUpdateMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link AssetProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetProfileUpdateMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AssetProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AssetProfileUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AssetProfileUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetProfileUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AssetProfileUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AssetProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AssetProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> AssetProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> AssetProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link AssetProfileUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> AssetProfileUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AssetProfileUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link AssetProfileUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AssetProfileUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetProfileUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> AssetProfileUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link AssetProfileUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AssetProfileUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
