package org.thingsboard.server.service.edge.rpc.constructor.ota;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.nio.ByteBuffer;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.gen.edge.v1.OtaPackageUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class OtaPackageMsgConstructorV1DiffblueTest {
  /**
   * Test {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType,
   * OtaPackage)}.
   *
   * <p>Method under test: {@link
   * OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName("Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "OtaPackageUpdateMsg OtaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)"
  })
  void testConstructOtaPackageUpdatedMsg() {
    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();

    OtaPackage otaPackage = new OtaPackage();
    otaPackage.setUrl("https://example.org/example");
    otaPackage.setTag("Tag");
    otaPackage.setVersion("Version");
    otaPackage.setTitle("Dr");
    otaPackage.setType(OtaPackageType.SOFTWARE);
    otaPackage.setId(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult =
        otaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    ByteString urlBytes = actualConstructOtaPackageUpdatedMsgResult.getUrlBytes();
    assertEquals("https://example.org/example", urlBytes.toStringUtf8());
    assertEquals("https://example.org/example", actualConstructOtaPackageUpdatedMsgResult.getUrl());
    assertEquals(78, actualConstructOtaPackageUpdatedMsgResult.getSerializedSize());
    assertFalse(urlBytes.isEmpty());
    ByteIterator iteratorResult = urlBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(actualConstructOtaPackageUpdatedMsgResult.hasUrl());
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('t', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType,
   * OtaPackage)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return not Data Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName(
      "Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); given 'A'; then return not Data Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "OtaPackageUpdateMsg OtaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)"
  })
  void testConstructOtaPackageUpdatedMsg_givenA_thenReturnNotDataEmpty() {
    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();

    OtaPackage otaPackage = new OtaPackage();
    otaPackage.setData(ByteBuffer.wrap(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}));
    otaPackage.setTag("Tag");
    otaPackage.setVersion("Version");
    otaPackage.setTitle("Dr");
    otaPackage.setType(OtaPackageType.SOFTWARE);
    otaPackage.setId(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult =
        otaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    ByteString data = actualConstructOtaPackageUpdatedMsgResult.getData();
    assertFalse(data.isEmpty());
    ByteIterator iteratorResult = data.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals((byte) 1, iteratorResult.next().byteValue());
    assertEquals('A', iteratorResult.next().byteValue());
    assertEquals("A\u0001A\u0001A\u0001A\u0001", data.toStringUtf8());
    assertEquals(60, actualConstructOtaPackageUpdatedMsgResult.getSerializedSize());
    assertTrue(actualConstructOtaPackageUpdatedMsgResult.hasData());
  }

  /**
   * Test {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType,
   * OtaPackage)}.
   *
   * <ul>
   *   <li>Given {@code Checksum}.
   *   <li>Then return {@code Checksum}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName(
      "Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); given 'Checksum'; then return 'Checksum'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "OtaPackageUpdateMsg OtaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)"
  })
  void testConstructOtaPackageUpdatedMsg_givenChecksum_thenReturnChecksum() {
    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();

    OtaPackage otaPackage = new OtaPackage();
    otaPackage.setChecksum("Checksum");
    otaPackage.setTag("Tag");
    otaPackage.setVersion("Version");
    otaPackage.setTitle("Dr");
    otaPackage.setType(OtaPackageType.SOFTWARE);
    otaPackage.setId(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult =
        otaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    assertEquals("Checksum", actualConstructOtaPackageUpdatedMsgResult.getChecksum());
    ByteString checksumBytes = actualConstructOtaPackageUpdatedMsgResult.getChecksumBytes();
    assertFalse(checksumBytes.isEmpty());
    ByteIterator iteratorResult = checksumBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('C', iteratorResult.next().byteValue());
    assertEquals('h', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult.next().byteValue());
    assertEquals("Checksum", checksumBytes.toStringUtf8());
    assertEquals(59, actualConstructOtaPackageUpdatedMsgResult.getSerializedSize());
    assertTrue(actualConstructOtaPackageUpdatedMsgResult.hasChecksum());
  }

  /**
   * Test {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType,
   * OtaPackage)}.
   *
   * <ul>
   *   <li>Given {@code MD5}.
   *   <li>Then return ChecksumAlgorithm is {@code MD5}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName(
      "Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); given 'MD5'; then return ChecksumAlgorithm is 'MD5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "OtaPackageUpdateMsg OtaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)"
  })
  void testConstructOtaPackageUpdatedMsg_givenMd5_thenReturnChecksumAlgorithmIsMd5() {
    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();

    OtaPackage otaPackage = new OtaPackage();
    otaPackage.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackage.setTag("Tag");
    otaPackage.setVersion("Version");
    otaPackage.setTitle("Dr");
    otaPackage.setType(OtaPackageType.SOFTWARE);
    otaPackage.setId(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult =
        otaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    assertEquals("MD5", actualConstructOtaPackageUpdatedMsgResult.getChecksumAlgorithm());
    ByteString checksumAlgorithmBytes =
        actualConstructOtaPackageUpdatedMsgResult.getChecksumAlgorithmBytes();
    assertFalse(checksumAlgorithmBytes.isEmpty());
    ByteIterator iteratorResult = checksumAlgorithmBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    Byte nextResult3 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('M', nextResult.byteValue());
    assertEquals('D', nextResult2.byteValue());
    assertEquals('5', nextResult3.byteValue());
    assertEquals("MD5", checksumAlgorithmBytes.toStringUtf8());
    assertEquals(54, actualConstructOtaPackageUpdatedMsgResult.getSerializedSize());
    assertTrue(actualConstructOtaPackageUpdatedMsgResult.hasChecksumAlgorithm());
  }

  /**
   * Test {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType,
   * OtaPackage)}.
   *
   * <ul>
   *   <li>Given {@code Tag}.
   *   <li>Then return DataSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName(
      "Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); given 'Tag'; then return DataSize is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "OtaPackageUpdateMsg OtaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)"
  })
  void testConstructOtaPackageUpdatedMsg_givenTag_thenReturnDataSizeIsZero() {
    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();

    OtaPackage otaPackage = new OtaPackage();
    otaPackage.setTag("Tag");
    otaPackage.setVersion("Version");
    otaPackage.setTitle("Dr");
    otaPackage.setType(OtaPackageType.SOFTWARE);
    otaPackage.setId(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult =
        otaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    assertEquals(0L, actualConstructOtaPackageUpdatedMsgResult.getDataSize());
    assertEquals(49, actualConstructOtaPackageUpdatedMsgResult.getSerializedSize());
    assertEquals(6, actualConstructOtaPackageUpdatedMsgResult.getAllFields().size());
    assertFalse(actualConstructOtaPackageUpdatedMsgResult.hasDataSize());
  }

  /**
   * Test {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType,
   * OtaPackage)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return DataSize is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName(
      "Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); given three; then return DataSize is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "OtaPackageUpdateMsg OtaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)"
  })
  void testConstructOtaPackageUpdatedMsg_givenThree_thenReturnDataSizeIsThree() {
    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();

    OtaPackage otaPackage = new OtaPackage();
    otaPackage.setDataSize(3L);
    otaPackage.setTag("Tag");
    otaPackage.setVersion("Version");
    otaPackage.setTitle("Dr");
    otaPackage.setType(OtaPackageType.SOFTWARE);
    otaPackage.setId(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult =
        otaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    assertEquals(3L, actualConstructOtaPackageUpdatedMsgResult.getDataSize());
    assertEquals(51, actualConstructOtaPackageUpdatedMsgResult.getSerializedSize());
    assertEquals(7, actualConstructOtaPackageUpdatedMsgResult.getAllFields().size());
    assertTrue(actualConstructOtaPackageUpdatedMsgResult.hasDataSize());
  }

  /**
   * Test {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType,
   * OtaPackage)}.
   *
   * <ul>
   *   <li>Then return ContentType is {@code text/plain}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName(
      "Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); then return ContentType is 'text/plain'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "OtaPackageUpdateMsg OtaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)"
  })
  void testConstructOtaPackageUpdatedMsg_thenReturnContentTypeIsTextPlain() {
    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();

    OtaPackage otaPackage = new OtaPackage();
    otaPackage.setContentType("text/plain");
    otaPackage.setTag("Tag");
    otaPackage.setVersion("Version");
    otaPackage.setTitle("Dr");
    otaPackage.setType(OtaPackageType.SOFTWARE);
    otaPackage.setId(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult =
        otaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    assertEquals("text/plain", actualConstructOtaPackageUpdatedMsgResult.getContentType());
    ByteString contentTypeBytes = actualConstructOtaPackageUpdatedMsgResult.getContentTypeBytes();
    assertFalse(contentTypeBytes.isEmpty());
    ByteIterator iteratorResult = contentTypeBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('t', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult.next().byteValue());
    assertEquals('x', iteratorResult.next().byteValue());
    assertEquals("text/plain", contentTypeBytes.toStringUtf8());
    assertEquals(61, actualConstructOtaPackageUpdatedMsgResult.getSerializedSize());
    assertTrue(actualConstructOtaPackageUpdatedMsgResult.hasContentType());
  }

  /**
   * Test {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType,
   * OtaPackage)}.
   *
   * <ul>
   *   <li>Then return FileNameBytes toStringUtf8 is {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName(
      "Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); then return FileNameBytes toStringUtf8 is 'foo.txt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "OtaPackageUpdateMsg OtaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)"
  })
  void testConstructOtaPackageUpdatedMsg_thenReturnFileNameBytesToStringUtf8IsFooTxt() {
    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();

    OtaPackage otaPackage = new OtaPackage();
    otaPackage.setFileName("foo.txt");
    otaPackage.setTag("Tag");
    otaPackage.setVersion("Version");
    otaPackage.setTitle("Dr");
    otaPackage.setType(OtaPackageType.SOFTWARE);
    otaPackage.setId(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult =
        otaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    ByteString fileNameBytes = actualConstructOtaPackageUpdatedMsgResult.getFileNameBytes();
    assertEquals("foo.txt", fileNameBytes.toStringUtf8());
    assertEquals("foo.txt", actualConstructOtaPackageUpdatedMsgResult.getFileName());
    assertEquals(58, actualConstructOtaPackageUpdatedMsgResult.getSerializedSize());
    assertFalse(fileNameBytes.isEmpty());
    ByteIterator iteratorResult = fileNameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(actualConstructOtaPackageUpdatedMsgResult.hasFileName());
    assertEquals('f', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
  }
}
