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

class OtaPackageUpdateMsgDiffblueTest {
  /**
   * Test {@link OtaPackageUpdateMsg#equals(Object)}, and
   * {@link OtaPackageUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageUpdateMsg#equals(Object)}
   *   <li>{@link OtaPackageUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link OtaPackageUpdateMsg#equals(Object)}, and
   * {@link OtaPackageUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageUpdateMsg#equals(Object)}
   *   <li>{@link OtaPackageUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OtaPackageUpdateMsg.getDefaultInstance(), 1);
  }

  /**
   * Test {@link OtaPackageUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OtaPackageUpdateMsg.getDefaultInstance(), null);
  }

  /**
   * Test {@link OtaPackageUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OtaPackageUpdateMsg.getDefaultInstance(), "Different type to OtaPackageUpdateMsg");
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getAdditionalInfo()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo()")
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getAdditionalInfo());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getAdditionalInfoBytes()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getAdditionalInfoBytes()}
   */
  @Test
  @DisplayName("Test getAdditionalInfoBytes()")
  void testGetAdditionalInfoBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualAdditionalInfoBytes = defaultInstance.getAdditionalInfoBytes();

    // Assert
    ByteString byteString = actualAdditionalInfoBytes.EMPTY;
    assertEquals(byteString, actualAdditionalInfoBytes);
    assertEquals(byteString, defaultInstance.getChecksumAlgorithmBytes());
    assertEquals(byteString, defaultInstance.getChecksumBytes());
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getChecksum()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getChecksum()}
   */
  @Test
  @DisplayName("Test getChecksum()")
  void testGetChecksum() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getChecksum());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getChecksumAlgorithm()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getChecksumAlgorithm()}
   */
  @Test
  @DisplayName("Test getChecksumAlgorithm()")
  void testGetChecksumAlgorithm() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getChecksumAlgorithm());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getChecksumAlgorithmBytes()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getChecksumAlgorithmBytes()}
   */
  @Test
  @DisplayName("Test getChecksumAlgorithmBytes()")
  void testGetChecksumAlgorithmBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualChecksumAlgorithmBytes = defaultInstance.getChecksumAlgorithmBytes();

    // Assert
    ByteString byteString = actualChecksumAlgorithmBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualChecksumAlgorithmBytes);
    assertEquals(byteString, defaultInstance.getChecksumBytes());
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getChecksumBytes()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getChecksumBytes()}
   */
  @Test
  @DisplayName("Test getChecksumBytes()")
  void testGetChecksumBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualChecksumBytes = defaultInstance.getChecksumBytes();

    // Assert
    ByteString byteString = actualChecksumBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getChecksumAlgorithmBytes());
    assertEquals(byteString, actualChecksumBytes);
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getContentType()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getContentType()}
   */
  @Test
  @DisplayName("Test getContentType()")
  void testGetContentType() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getContentType());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getContentTypeBytes()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getContentTypeBytes()}
   */
  @Test
  @DisplayName("Test getContentTypeBytes()")
  void testGetContentTypeBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualContentTypeBytes = defaultInstance.getContentTypeBytes();

    // Assert
    ByteString byteString = actualContentTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getChecksumAlgorithmBytes());
    assertEquals(byteString, defaultInstance.getChecksumBytes());
    assertEquals(byteString, actualContentTypeBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  void testGetDefaultInstanceForType() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getEntity()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  void testGetEntity() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getEntity());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getEntityBytes()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getEntityBytes()}
   */
  @Test
  @DisplayName("Test getEntityBytes()")
  void testGetEntityBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualEntityBytes = defaultInstance.getEntityBytes();

    // Assert
    ByteString byteString = actualEntityBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getChecksumAlgorithmBytes());
    assertEquals(byteString, defaultInstance.getChecksumBytes());
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, actualEntityBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getFileName()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getFileName()}
   */
  @Test
  @DisplayName("Test getFileName()")
  void testGetFileName() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getFileName());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getFileNameBytes()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getFileNameBytes()}
   */
  @Test
  @DisplayName("Test getFileNameBytes()")
  void testGetFileNameBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualFileNameBytes = defaultInstance.getFileNameBytes();

    // Assert
    ByteString byteString = actualFileNameBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getChecksumAlgorithmBytes());
    assertEquals(byteString, defaultInstance.getChecksumBytes());
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, actualFileNameBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getMsgType()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getMsgType()}
   */
  @Test
  @DisplayName("Test getMsgType()")
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, OtaPackageUpdateMsg.getDefaultInstance().getMsgType());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, OtaPackageUpdateMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getTag()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getTag());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getTagBytes()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getTagBytes()}
   */
  @Test
  @DisplayName("Test getTagBytes()")
  void testGetTagBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualTagBytes = defaultInstance.getTagBytes();

    // Assert
    ByteString byteString = actualTagBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getChecksumAlgorithmBytes());
    assertEquals(byteString, defaultInstance.getChecksumBytes());
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, actualTagBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getTitle()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle()")
  void testGetTitle() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getTitle());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getTitleBytes()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getTitleBytes()}
   */
  @Test
  @DisplayName("Test getTitleBytes()")
  void testGetTitleBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualTitleBytes = defaultInstance.getTitleBytes();

    // Assert
    ByteString byteString = actualTitleBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getChecksumAlgorithmBytes());
    assertEquals(byteString, defaultInstance.getChecksumBytes());
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, actualTitleBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getType()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getType());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getTypeBytes()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getTypeBytes()}
   */
  @Test
  @DisplayName("Test getTypeBytes()")
  void testGetTypeBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualTypeBytes = defaultInstance.getTypeBytes();

    // Assert
    ByteString byteString = actualTypeBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getChecksumAlgorithmBytes());
    assertEquals(byteString, defaultInstance.getChecksumBytes());
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, actualTypeBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getUrl()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getUrl()}
   */
  @Test
  @DisplayName("Test getUrl()")
  void testGetUrl() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getUrl());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getUrlBytes()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getUrlBytes()}
   */
  @Test
  @DisplayName("Test getUrlBytes()")
  void testGetUrlBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualUrlBytes = defaultInstance.getUrlBytes();

    // Assert
    ByteString byteString = actualUrlBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getChecksumAlgorithmBytes());
    assertEquals(byteString, defaultInstance.getChecksumBytes());
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, actualUrlBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getVersion()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getVersion()}
   */
  @Test
  @DisplayName("Test getVersion()")
  void testGetVersion() {
    // Arrange, Act and Assert
    assertEquals("", OtaPackageUpdateMsg.getDefaultInstance().getVersion());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#getVersionBytes()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#getVersionBytes()}
   */
  @Test
  @DisplayName("Test getVersionBytes()")
  void testGetVersionBytes() {
    // Arrange
    OtaPackageUpdateMsg defaultInstance = OtaPackageUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualVersionBytes = defaultInstance.getVersionBytes();

    // Assert
    ByteString byteString = actualVersionBytes.EMPTY;
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getChecksumAlgorithmBytes());
    assertEquals(byteString, defaultInstance.getChecksumBytes());
    assertEquals(byteString, defaultInstance.getContentTypeBytes());
    assertEquals(byteString, actualVersionBytes);
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, defaultInstance.getDescriptorForType().getFields().size());
    assertSame(byteString, defaultInstance.getData());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#hasAdditionalInfo()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#hasAdditionalInfo()}
   */
  @Test
  @DisplayName("Test hasAdditionalInfo()")
  void testHasAdditionalInfo() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasAdditionalInfo());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#hasChecksum()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#hasChecksum()}
   */
  @Test
  @DisplayName("Test hasChecksum()")
  void testHasChecksum() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasChecksum());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#hasChecksumAlgorithm()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#hasChecksumAlgorithm()}
   */
  @Test
  @DisplayName("Test hasChecksumAlgorithm()")
  void testHasChecksumAlgorithm() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasChecksumAlgorithm());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#hasContentType()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#hasContentType()}
   */
  @Test
  @DisplayName("Test hasContentType()")
  void testHasContentType() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasContentType());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#hasData()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#hasData()}
   */
  @Test
  @DisplayName("Test hasData()")
  void testHasData() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasData());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#hasDataSize()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#hasDataSize()}
   */
  @Test
  @DisplayName("Test hasDataSize()")
  void testHasDataSize() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasDataSize());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#hasFileName()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#hasFileName()}
   */
  @Test
  @DisplayName("Test hasFileName()")
  void testHasFileName() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasFileName());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#hasUrl()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#hasUrl()}
   */
  @Test
  @DisplayName("Test hasUrl()")
  void testHasUrl() {
    // Arrange, Act and Assert
    assertFalse(OtaPackageUpdateMsg.getDefaultInstance().hasUrl());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#isInitialized()}.
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(OtaPackageUpdateMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link OtaPackageUpdateMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test newInstance(UnusedPrivateParameter)")
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
   * Test
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> OtaPackageUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> OtaPackageUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(OtaPackageUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> OtaPackageUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
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
   * Test {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(OtaPackageUpdateMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
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
   * Test {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseDelimitedFrom(InputStream)}
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
    assertThrows(InvalidProtocolBufferException.class, () -> OtaPackageUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link OtaPackageUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
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
        () -> OtaPackageUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test
   * {@link OtaPackageUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> OtaPackageUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link OtaPackageUpdateMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> OtaPackageUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link OtaPackageUpdateMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> OtaPackageUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link OtaPackageUpdateMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty
   * array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    OtaPackageUpdateMsg actualParseFromResult = OtaPackageUpdateMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(8, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(8, oneofs.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
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
    Descriptors.FieldDescriptor getResult2 = fields.get(OtaPackageUpdateMsg.DATA_FIELD_NUMBER);
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
    Descriptors.FieldDescriptor getResult8 = fields.get(OtaPackageUpdateMsg.ADDITIONALINFO_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    Descriptors.OneofDescriptor getResult11 = oneofs.get(6);
    assertSame(file, getResult11.getFile());
    Descriptors.OneofDescriptor getResult12 = oneofs.get(7);
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
    assertSame(getResult12, getResult2.getContainingOneof());
  }

  /**
   * Test {@link OtaPackageUpdateMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    OtaPackageUpdateMsg actualParseFromResult = OtaPackageUpdateMsg.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(8, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(8, oneofs.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(OtaPackageUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
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
    Descriptors.FieldDescriptor getResult2 = fields.get(OtaPackageUpdateMsg.DATA_FIELD_NUMBER);
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
    Descriptors.FieldDescriptor getResult8 = fields.get(OtaPackageUpdateMsg.ADDITIONALINFO_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    Descriptors.OneofDescriptor getResult11 = oneofs.get(6);
    assertSame(file, getResult11.getFile());
    Descriptors.OneofDescriptor getResult12 = oneofs.get(7);
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
    assertSame(getResult12, getResult2.getContainingOneof());
  }
}
