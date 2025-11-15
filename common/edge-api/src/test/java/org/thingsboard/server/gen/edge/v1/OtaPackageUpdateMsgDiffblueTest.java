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

class OtaPackageUpdateMsgDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageUpdateMsg#equals(Object)}
   *   <li>{@link OtaPackageUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();
    OtaPackageUpdateMsg defaultInstance2 = OtaPackageUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageUpdateMsg#equals(Object)}
   *   <li>{@link OtaPackageUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OtaPackageUpdateMsg.getDefaultInstance(), 1);
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OtaPackageUpdateMsg.getDefaultInstance(), null);
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OtaPackageUpdateMsg.getDefaultInstance(), "Different type to OtaPackageUpdateMsg");
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getAdditionalInfo());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getAdditionalInfoBytes()}
   */
  @Test
  void testGetAdditionalInfoBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualAdditionalInfoBytes = defaultInstance.getAdditionalInfoBytes();

    // Assert
    ByteString byteString = actualAdditionalInfoBytes.EMPTY;
    assertEquals(byteString, actualAdditionalInfoBytes);
    assertEquals(byteString, defaultInstance.getChecksumAlgorithmBytes());
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getChecksum()}
   */
  @Test
  void testGetChecksum() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getChecksum());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getChecksumAlgorithm()}
   */
  @Test
  void testGetChecksumAlgorithm() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getChecksumAlgorithm());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getChecksumAlgorithmBytes()}
   */
  @Test
  void testGetChecksumAlgorithmBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualChecksumAlgorithmBytes = defaultInstance.getChecksumAlgorithmBytes();

    // Assert
    ByteString byteString = actualChecksumAlgorithmBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualChecksumAlgorithmBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getChecksumBytes()}
   */
  @Test
  void testGetChecksumBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualChecksumBytes = defaultInstance.getChecksumBytes();

    // Assert
    ByteString byteString = actualChecksumBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualChecksumBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getContentType()}
   */
  @Test
  void testGetContentType() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getContentType());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getContentTypeBytes()}
   */
  @Test
  void testGetContentTypeBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualContentTypeBytes = defaultInstance.getContentTypeBytes();

    // Assert
    ByteString byteString = actualContentTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualContentTypeBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getDefaultInstanceForType()}
   */
  @Test
  void testGetDefaultInstanceForType() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getEntity()}
   */
  @Test
  void testGetEntity() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getEntity());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getEntityBytes()}
   */
  @Test
  void testGetEntityBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualEntityBytes = defaultInstance.getEntityBytes();

    // Assert
    ByteString byteString = actualEntityBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualEntityBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getFileName()}
   */
  @Test
  void testGetFileName() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getFileName());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getFileNameBytes()}
   */
  @Test
  void testGetFileNameBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualFileNameBytes = defaultInstance.getFileNameBytes();

    // Assert
    ByteString byteString = actualFileNameBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualFileNameBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getMsgType()}
   */
  @Test
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, OtaPackageUpdateMsg.getDefaultInstance().getMsgType());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getSerializedSize()}
   */
  @Test
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, OtaPackageUpdateMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getTag()}
   */
  @Test
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getTag());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getTagBytes()}
   */
  @Test
  void testGetTagBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualTagBytes = defaultInstance.getTagBytes();

    // Assert
    ByteString byteString = actualTagBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualTagBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getTitle()}
   */
  @Test
  void testGetTitle() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getTitle());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getTitleBytes()}
   */
  @Test
  void testGetTitleBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualTitleBytes = defaultInstance.getTitleBytes();

    // Assert
    ByteString byteString = actualTitleBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualTitleBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getType()}
   */
  @Test
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getType());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getTypeBytes()}
   */
  @Test
  void testGetTypeBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualTypeBytes = defaultInstance.getTypeBytes();

    // Assert
    ByteString byteString = actualTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualTypeBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getUrl()}
   */
  @Test
  void testGetUrl() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getUrl());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getUrlBytes()}
   */
  @Test
  void testGetUrlBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualUrlBytes = defaultInstance.getUrlBytes();

    // Assert
    ByteString byteString = actualUrlBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualUrlBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getVersion()}
   */
  @Test
  void testGetVersion() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getVersion());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#getVersionBytes()}
   */
  @Test
  void testGetVersionBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualVersionBytes = defaultInstance.getVersionBytes();

    // Assert
    ByteString byteString = actualVersionBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualVersionBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#hasAdditionalInfo()}
   */
  @Test
  void testHasAdditionalInfo() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasAdditionalInfo());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#hasChecksum()}
   */
  @Test
  void testHasChecksum() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasChecksum());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#hasChecksumAlgorithm()}
   */
  @Test
  void testHasChecksumAlgorithm() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasChecksumAlgorithm());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#hasContentType()}
   */
  @Test
  void testHasContentType() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasContentType());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#hasData()}
   */
  @Test
  void testHasData() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasData());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#hasDataSize()}
   */
  @Test
  void testHasDataSize() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasDataSize());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#hasFileName()}
   */
  @Test
  void testHasFileName() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasFileName());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#hasUrl()}
   */
  @Test
  void testHasUrl() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasUrl());
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#isInitialized()}
   */
  @Test
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(OtaPackageUpdateMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Method under test:
   * {@link OtaPackageUpdateMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  void testNewInstance() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof OtaPackageUpdateMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(OtaPackageUpdateMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> OtaPackageUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> OtaPackageUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  void testParseDelimitedFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> OtaPackageUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom5() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(OtaPackageUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom6() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> OtaPackageUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> OtaPackageUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseDelimitedFrom8() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> OtaPackageUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> OtaPackageUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test: {@link OtaPackageUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  void testParseFrom2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> OtaPackageUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> OtaPackageUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  void testParseFrom4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> OtaPackageUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }
}
