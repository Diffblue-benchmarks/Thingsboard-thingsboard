package org.thingsboard.server.service.edge.rpc.constructor.ota;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.gen.edge.v1.OtaPackageUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class OtaPackageMsgConstructorV1DiffblueTest {
  /**
   * Test
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}.
   * <p>
   * Method under test:
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName("Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)")
  void testConstructOtaPackageUpdatedMsg() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(UUID.randomUUID());
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getAdditionalInfo()).thenReturn(null);
    when(otaPackage.getDataSize()).thenReturn(3L);
    when(otaPackage.getChecksum()).thenReturn("Checksum");
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getUrl()).thenReturn("https://example.org/example");
    when(otaPackage.getData()).thenReturn(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    when(otaPackage.getDeviceProfileId()).thenReturn(deviceProfileId);
    when(otaPackage.getChecksumAlgorithm()).thenReturn(ChecksumAlgorithm.MD5);
    when(otaPackage.getTag()).thenReturn("Tag");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getTitle()).thenReturn("Dr");
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getId()).thenReturn(new OtaPackageId(UUID.randomUUID()));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult = otaPackageMsgConstructorV1
        .constructOtaPackageUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    verify(otaPackage, atLeast(1)).getData();
    verify(otaPackage).getAdditionalInfo();
    verify(otaPackage, atLeast(1)).getChecksum();
    verify(otaPackage, atLeast(1)).getChecksumAlgorithm();
    verify(otaPackage, atLeast(1)).getContentType();
    verify(otaPackage, atLeast(1)).getDataSize();
    verify(otaPackage, atLeast(1)).getDeviceProfileId();
    verify(otaPackage, atLeast(1)).getFileName();
    verify(otaPackage, atLeast(1)).getId();
    verify(otaPackage).getTag();
    verify(otaPackage).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getUrl();
    verify(otaPackage).getVersion();
    verify(deviceProfileId, atLeast(1)).getId();
    ByteString additionalInfoBytes = actualConstructOtaPackageUpdatedMsgResult.getAdditionalInfoBytes();
    assertEquals("", additionalInfoBytes.toStringUtf8());
    assertEquals("", actualConstructOtaPackageUpdatedMsgResult.getAdditionalInfo());
    Descriptors.Descriptor descriptorForType = actualConstructOtaPackageUpdatedMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(18, fields.size());
    assertFalse(additionalInfoBytes.iterator().hasNext());
    assertFalse(actualConstructOtaPackageUpdatedMsgResult.hasAdditionalInfo());
    assertTrue(additionalInfoBytes.isEmpty());
    assertEquals(additionalInfoBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(additionalInfoBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(additionalInfoBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(17).toProto();
    assertEquals(additionalInfoBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(Short.SIZE).toProto();
    assertEquals(additionalInfoBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(additionalInfoBytes, toProtoResult.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getGoPackageBytes());
    assertEquals(additionalInfoBytes, options.getGoPackageBytes());
    assertEquals(additionalInfoBytes, options.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, options.getSwiftPrefixBytes());
    OtaPackageUpdateMsg defaultInstanceForType2 = actualConstructOtaPackageUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getAdditionalInfoBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getChecksumAlgorithmBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getChecksumBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getContentTypeBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getData());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getEntityBytes());
    assertEquals(additionalInfoBytes, actualConstructOtaPackageUpdatedMsgResult.getEntityBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getFileNameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getTagBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getTitleBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getTypeBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getUrlBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getVersionBytes());
  }

  /**
   * Test
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}.
   * <p>
   * Method under test:
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName("Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)")
  void testConstructOtaPackageUpdatedMsg2() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(UUID.randomUUID());
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(otaPackage.getDataSize()).thenReturn(3L);
    when(otaPackage.getChecksum()).thenReturn(null);
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getUrl()).thenReturn("https://example.org/example");
    when(otaPackage.getData()).thenReturn(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    when(otaPackage.getDeviceProfileId()).thenReturn(deviceProfileId);
    when(otaPackage.getChecksumAlgorithm()).thenReturn(ChecksumAlgorithm.MD5);
    when(otaPackage.getTag()).thenReturn("Tag");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getTitle()).thenReturn("Dr");
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getId()).thenReturn(new OtaPackageId(UUID.randomUUID()));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult = otaPackageMsgConstructorV1
        .constructOtaPackageUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    verify(otaPackage, atLeast(1)).getData();
    verify(otaPackage, atLeast(1)).getAdditionalInfo();
    verify(otaPackage).getChecksum();
    verify(otaPackage, atLeast(1)).getChecksumAlgorithm();
    verify(otaPackage, atLeast(1)).getContentType();
    verify(otaPackage, atLeast(1)).getDataSize();
    verify(otaPackage, atLeast(1)).getDeviceProfileId();
    verify(otaPackage, atLeast(1)).getFileName();
    verify(otaPackage, atLeast(1)).getId();
    verify(otaPackage).getTag();
    verify(otaPackage).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getUrl();
    verify(otaPackage).getVersion();
    verify(deviceProfileId, atLeast(1)).getId();
    ByteString checksumBytes = actualConstructOtaPackageUpdatedMsgResult.getChecksumBytes();
    assertEquals("", checksumBytes.toStringUtf8());
    assertEquals("", actualConstructOtaPackageUpdatedMsgResult.getChecksum());
    Descriptors.Descriptor descriptorForType = actualConstructOtaPackageUpdatedMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(18, fields.size());
    assertFalse(checksumBytes.iterator().hasNext());
    assertFalse(actualConstructOtaPackageUpdatedMsgResult.hasChecksum());
    assertTrue(checksumBytes.isEmpty());
    assertEquals(checksumBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(checksumBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(checksumBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(17).toProto();
    assertEquals(checksumBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(Short.SIZE).toProto();
    assertEquals(checksumBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(checksumBytes, toProtoResult.getExtendeeBytes());
    assertEquals(checksumBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(checksumBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(checksumBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(checksumBytes, toProtoResult.getJsonNameBytes());
    assertEquals(checksumBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(checksumBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(checksumBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(checksumBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(checksumBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(checksumBytes, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(checksumBytes, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(checksumBytes, options.getCsharpNamespaceBytes());
    assertEquals(checksumBytes, defaultInstanceForType.getGoPackageBytes());
    assertEquals(checksumBytes, options.getGoPackageBytes());
    assertEquals(checksumBytes, options.getObjcClassPrefixBytes());
    assertEquals(checksumBytes, options.getPhpClassPrefixBytes());
    assertEquals(checksumBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(checksumBytes, options.getPhpNamespaceBytes());
    assertEquals(checksumBytes, options.getRubyPackageBytes());
    assertEquals(checksumBytes, options.getSwiftPrefixBytes());
    OtaPackageUpdateMsg defaultInstanceForType2 = actualConstructOtaPackageUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(checksumBytes, defaultInstanceForType2.getAdditionalInfoBytes());
    assertEquals(checksumBytes, defaultInstanceForType2.getChecksumAlgorithmBytes());
    assertEquals(checksumBytes, defaultInstanceForType2.getChecksumBytes());
    assertEquals(checksumBytes, defaultInstanceForType2.getContentTypeBytes());
    assertEquals(checksumBytes, defaultInstanceForType2.getData());
    assertEquals(checksumBytes, defaultInstanceForType2.getEntityBytes());
    assertEquals(checksumBytes, actualConstructOtaPackageUpdatedMsgResult.getEntityBytes());
    assertEquals(checksumBytes, defaultInstanceForType2.getFileNameBytes());
    assertEquals(checksumBytes, defaultInstanceForType2.getTagBytes());
    assertEquals(checksumBytes, defaultInstanceForType2.getTitleBytes());
    assertEquals(checksumBytes, defaultInstanceForType2.getTypeBytes());
    assertEquals(checksumBytes, defaultInstanceForType2.getUrlBytes());
    assertEquals(checksumBytes, defaultInstanceForType2.getVersionBytes());
  }

  /**
   * Test
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}.
   * <p>
   * Method under test:
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName("Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)")
  void testConstructOtaPackageUpdatedMsg3() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(UUID.randomUUID());
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(otaPackage.getDataSize()).thenReturn(3L);
    when(otaPackage.getChecksum()).thenReturn("Checksum");
    when(otaPackage.getContentType()).thenReturn(null);
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getUrl()).thenReturn("https://example.org/example");
    when(otaPackage.getData()).thenReturn(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    when(otaPackage.getDeviceProfileId()).thenReturn(deviceProfileId);
    when(otaPackage.getChecksumAlgorithm()).thenReturn(ChecksumAlgorithm.MD5);
    when(otaPackage.getTag()).thenReturn("Tag");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getTitle()).thenReturn("Dr");
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getId()).thenReturn(new OtaPackageId(UUID.randomUUID()));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult = otaPackageMsgConstructorV1
        .constructOtaPackageUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    verify(otaPackage, atLeast(1)).getData();
    verify(otaPackage, atLeast(1)).getAdditionalInfo();
    verify(otaPackage, atLeast(1)).getChecksum();
    verify(otaPackage, atLeast(1)).getChecksumAlgorithm();
    verify(otaPackage).getContentType();
    verify(otaPackage, atLeast(1)).getDataSize();
    verify(otaPackage, atLeast(1)).getDeviceProfileId();
    verify(otaPackage, atLeast(1)).getFileName();
    verify(otaPackage, atLeast(1)).getId();
    verify(otaPackage).getTag();
    verify(otaPackage).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getUrl();
    verify(otaPackage).getVersion();
    verify(deviceProfileId, atLeast(1)).getId();
    ByteString contentTypeBytes = actualConstructOtaPackageUpdatedMsgResult.getContentTypeBytes();
    assertEquals("", contentTypeBytes.toStringUtf8());
    assertEquals("", actualConstructOtaPackageUpdatedMsgResult.getContentType());
    Descriptors.Descriptor descriptorForType = actualConstructOtaPackageUpdatedMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(18, fields.size());
    assertFalse(contentTypeBytes.iterator().hasNext());
    assertFalse(actualConstructOtaPackageUpdatedMsgResult.hasContentType());
    assertTrue(contentTypeBytes.isEmpty());
    assertEquals(contentTypeBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(contentTypeBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(contentTypeBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(17).toProto();
    assertEquals(contentTypeBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(Short.SIZE).toProto();
    assertEquals(contentTypeBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(contentTypeBytes, toProtoResult.getExtendeeBytes());
    assertEquals(contentTypeBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(contentTypeBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(contentTypeBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(contentTypeBytes, toProtoResult.getJsonNameBytes());
    assertEquals(contentTypeBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(contentTypeBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(contentTypeBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(contentTypeBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(contentTypeBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(contentTypeBytes, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(contentTypeBytes, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(contentTypeBytes, options.getCsharpNamespaceBytes());
    assertEquals(contentTypeBytes, defaultInstanceForType.getGoPackageBytes());
    assertEquals(contentTypeBytes, options.getGoPackageBytes());
    assertEquals(contentTypeBytes, options.getObjcClassPrefixBytes());
    assertEquals(contentTypeBytes, options.getPhpClassPrefixBytes());
    assertEquals(contentTypeBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(contentTypeBytes, options.getPhpNamespaceBytes());
    assertEquals(contentTypeBytes, options.getRubyPackageBytes());
    assertEquals(contentTypeBytes, options.getSwiftPrefixBytes());
    OtaPackageUpdateMsg defaultInstanceForType2 = actualConstructOtaPackageUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(contentTypeBytes, defaultInstanceForType2.getAdditionalInfoBytes());
    assertEquals(contentTypeBytes, defaultInstanceForType2.getChecksumAlgorithmBytes());
    assertEquals(contentTypeBytes, defaultInstanceForType2.getChecksumBytes());
    assertEquals(contentTypeBytes, defaultInstanceForType2.getContentTypeBytes());
    assertEquals(contentTypeBytes, defaultInstanceForType2.getData());
    assertEquals(contentTypeBytes, defaultInstanceForType2.getEntityBytes());
    assertEquals(contentTypeBytes, actualConstructOtaPackageUpdatedMsgResult.getEntityBytes());
    assertEquals(contentTypeBytes, defaultInstanceForType2.getFileNameBytes());
    assertEquals(contentTypeBytes, defaultInstanceForType2.getTagBytes());
    assertEquals(contentTypeBytes, defaultInstanceForType2.getTitleBytes());
    assertEquals(contentTypeBytes, defaultInstanceForType2.getTypeBytes());
    assertEquals(contentTypeBytes, defaultInstanceForType2.getUrlBytes());
    assertEquals(contentTypeBytes, defaultInstanceForType2.getVersionBytes());
  }

  /**
   * Test
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}.
   * <p>
   * Method under test:
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName("Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)")
  void testConstructOtaPackageUpdatedMsg4() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(UUID.randomUUID());
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(otaPackage.getDataSize()).thenReturn(3L);
    when(otaPackage.getChecksum()).thenReturn("Checksum");
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getUrl()).thenReturn("https://example.org/example");
    when(otaPackage.getData()).thenReturn(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    when(otaPackage.getDeviceProfileId()).thenReturn(deviceProfileId);
    when(otaPackage.getChecksumAlgorithm()).thenReturn(null);
    when(otaPackage.getTag()).thenReturn("Tag");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getTitle()).thenReturn("Dr");
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getId()).thenReturn(new OtaPackageId(UUID.randomUUID()));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult = otaPackageMsgConstructorV1
        .constructOtaPackageUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    verify(otaPackage, atLeast(1)).getData();
    verify(otaPackage, atLeast(1)).getAdditionalInfo();
    verify(otaPackage, atLeast(1)).getChecksum();
    verify(otaPackage).getChecksumAlgorithm();
    verify(otaPackage, atLeast(1)).getContentType();
    verify(otaPackage, atLeast(1)).getDataSize();
    verify(otaPackage, atLeast(1)).getDeviceProfileId();
    verify(otaPackage, atLeast(1)).getFileName();
    verify(otaPackage, atLeast(1)).getId();
    verify(otaPackage).getTag();
    verify(otaPackage).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getUrl();
    verify(otaPackage).getVersion();
    verify(deviceProfileId, atLeast(1)).getId();
    ByteString checksumAlgorithmBytes = actualConstructOtaPackageUpdatedMsgResult.getChecksumAlgorithmBytes();
    assertEquals("", checksumAlgorithmBytes.toStringUtf8());
    assertEquals("", actualConstructOtaPackageUpdatedMsgResult.getChecksumAlgorithm());
    Descriptors.Descriptor descriptorForType = actualConstructOtaPackageUpdatedMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(18, fields.size());
    assertFalse(checksumAlgorithmBytes.iterator().hasNext());
    assertFalse(actualConstructOtaPackageUpdatedMsgResult.hasChecksumAlgorithm());
    assertTrue(checksumAlgorithmBytes.isEmpty());
    assertEquals(checksumAlgorithmBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(checksumAlgorithmBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(checksumAlgorithmBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(17).toProto();
    assertEquals(checksumAlgorithmBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(Short.SIZE).toProto();
    assertEquals(checksumAlgorithmBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(checksumAlgorithmBytes, toProtoResult.getExtendeeBytes());
    assertEquals(checksumAlgorithmBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(checksumAlgorithmBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(checksumAlgorithmBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(checksumAlgorithmBytes, toProtoResult.getJsonNameBytes());
    assertEquals(checksumAlgorithmBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(checksumAlgorithmBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(checksumAlgorithmBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(checksumAlgorithmBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(checksumAlgorithmBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(checksumAlgorithmBytes, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(checksumAlgorithmBytes, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(checksumAlgorithmBytes, options.getCsharpNamespaceBytes());
    assertEquals(checksumAlgorithmBytes, defaultInstanceForType.getGoPackageBytes());
    assertEquals(checksumAlgorithmBytes, options.getGoPackageBytes());
    assertEquals(checksumAlgorithmBytes, options.getObjcClassPrefixBytes());
    assertEquals(checksumAlgorithmBytes, options.getPhpClassPrefixBytes());
    assertEquals(checksumAlgorithmBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(checksumAlgorithmBytes, options.getPhpNamespaceBytes());
    assertEquals(checksumAlgorithmBytes, options.getRubyPackageBytes());
    assertEquals(checksumAlgorithmBytes, options.getSwiftPrefixBytes());
    OtaPackageUpdateMsg defaultInstanceForType2 = actualConstructOtaPackageUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(checksumAlgorithmBytes, defaultInstanceForType2.getAdditionalInfoBytes());
    assertEquals(checksumAlgorithmBytes, defaultInstanceForType2.getChecksumAlgorithmBytes());
    assertEquals(checksumAlgorithmBytes, defaultInstanceForType2.getChecksumBytes());
    assertEquals(checksumAlgorithmBytes, defaultInstanceForType2.getContentTypeBytes());
    assertEquals(checksumAlgorithmBytes, defaultInstanceForType2.getData());
    assertEquals(checksumAlgorithmBytes, defaultInstanceForType2.getEntityBytes());
    assertEquals(checksumAlgorithmBytes, actualConstructOtaPackageUpdatedMsgResult.getEntityBytes());
    assertEquals(checksumAlgorithmBytes, defaultInstanceForType2.getFileNameBytes());
    assertEquals(checksumAlgorithmBytes, defaultInstanceForType2.getTagBytes());
    assertEquals(checksumAlgorithmBytes, defaultInstanceForType2.getTitleBytes());
    assertEquals(checksumAlgorithmBytes, defaultInstanceForType2.getTypeBytes());
    assertEquals(checksumAlgorithmBytes, defaultInstanceForType2.getUrlBytes());
    assertEquals(checksumAlgorithmBytes, defaultInstanceForType2.getVersionBytes());
  }

  /**
   * Test
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName("Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  void testConstructOtaPackageUpdatedMsg_givenArrayNodeWithNfIsWithExactBigDecimalsTrue()
      throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(UUID.randomUUID());
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(otaPackage.getDataSize()).thenReturn(3L);
    when(otaPackage.getChecksum()).thenReturn("Checksum");
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getUrl()).thenReturn("https://example.org/example");
    when(otaPackage.getData()).thenReturn(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    when(otaPackage.getDeviceProfileId()).thenReturn(deviceProfileId);
    when(otaPackage.getChecksumAlgorithm()).thenReturn(ChecksumAlgorithm.MD5);
    when(otaPackage.getTag()).thenReturn("Tag");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getTitle()).thenReturn("Dr");
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getId()).thenReturn(new OtaPackageId(UUID.randomUUID()));

    // Act
    otaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    verify(otaPackage, atLeast(1)).getData();
    verify(otaPackage, atLeast(1)).getAdditionalInfo();
    verify(otaPackage, atLeast(1)).getChecksum();
    verify(otaPackage, atLeast(1)).getChecksumAlgorithm();
    verify(otaPackage, atLeast(1)).getContentType();
    verify(otaPackage, atLeast(1)).getDataSize();
    verify(otaPackage, atLeast(1)).getDeviceProfileId();
    verify(otaPackage, atLeast(1)).getFileName();
    verify(otaPackage, atLeast(1)).getId();
    verify(otaPackage).getTag();
    verify(otaPackage).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getUrl();
    verify(otaPackage).getVersion();
    verify(deviceProfileId, atLeast(1)).getId();
  }

  /**
   * Test
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}.
   * <ul>
   *   <li>Given {@link DeviceProfileId#DeviceProfileId(UUID)} with id is
   * randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName("Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); given DeviceProfileId(UUID) with id is randomUUID")
  void testConstructOtaPackageUpdatedMsg_givenDeviceProfileIdWithIdIsRandomUUID() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(otaPackage.getDataSize()).thenReturn(3L);
    when(otaPackage.getChecksum()).thenReturn("Checksum");
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getUrl()).thenReturn("https://example.org/example");
    when(otaPackage.getData()).thenReturn(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    when(otaPackage.getDeviceProfileId()).thenReturn(new DeviceProfileId(UUID.randomUUID()));
    when(otaPackage.getChecksumAlgorithm()).thenReturn(ChecksumAlgorithm.MD5);
    when(otaPackage.getTag()).thenReturn("Tag");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getTitle()).thenReturn("Dr");
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getId()).thenReturn(new OtaPackageId(UUID.randomUUID()));

    // Act
    otaPackageMsgConstructorV1.constructOtaPackageUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    verify(otaPackage, atLeast(1)).getData();
    verify(otaPackage, atLeast(1)).getAdditionalInfo();
    verify(otaPackage, atLeast(1)).getChecksum();
    verify(otaPackage, atLeast(1)).getChecksumAlgorithm();
    verify(otaPackage, atLeast(1)).getContentType();
    verify(otaPackage, atLeast(1)).getDataSize();
    verify(otaPackage, atLeast(1)).getDeviceProfileId();
    verify(otaPackage, atLeast(1)).getFileName();
    verify(otaPackage, atLeast(1)).getId();
    verify(otaPackage).getTag();
    verify(otaPackage).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getUrl();
    verify(otaPackage).getVersion();
  }

  /**
   * Test
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}.
   * <ul>
   *   <li>Then return DataSize is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName("Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); then return DataSize is zero")
  void testConstructOtaPackageUpdatedMsg_thenReturnDataSizeIsZero() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(UUID.randomUUID());
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(otaPackage.getDataSize()).thenReturn(null);
    when(otaPackage.getChecksum()).thenReturn("Checksum");
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getUrl()).thenReturn("https://example.org/example");
    when(otaPackage.getData()).thenReturn(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    when(otaPackage.getDeviceProfileId()).thenReturn(deviceProfileId);
    when(otaPackage.getChecksumAlgorithm()).thenReturn(ChecksumAlgorithm.MD5);
    when(otaPackage.getTag()).thenReturn("Tag");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getTitle()).thenReturn("Dr");
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getId()).thenReturn(new OtaPackageId(UUID.randomUUID()));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult = otaPackageMsgConstructorV1
        .constructOtaPackageUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    verify(otaPackage, atLeast(1)).getData();
    verify(otaPackage, atLeast(1)).getAdditionalInfo();
    verify(otaPackage, atLeast(1)).getChecksum();
    verify(otaPackage, atLeast(1)).getChecksumAlgorithm();
    verify(otaPackage, atLeast(1)).getContentType();
    verify(otaPackage).getDataSize();
    verify(otaPackage, atLeast(1)).getDeviceProfileId();
    verify(otaPackage, atLeast(1)).getFileName();
    verify(otaPackage, atLeast(1)).getId();
    verify(otaPackage).getTag();
    verify(otaPackage).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getUrl();
    verify(otaPackage).getVersion();
    verify(deviceProfileId, atLeast(1)).getId();
    assertEquals(0L, actualConstructOtaPackageUpdatedMsgResult.getDataSize());
    assertFalse(actualConstructOtaPackageUpdatedMsgResult.hasDataSize());
  }

  /**
   * Test
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}.
   * <ul>
   *   <li>Then return Data toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName("Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); then return Data toStringUtf8 is empty string")
  void testConstructOtaPackageUpdatedMsg_thenReturnDataToStringUtf8IsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(UUID.randomUUID());
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(otaPackage.getDataSize()).thenReturn(3L);
    when(otaPackage.getChecksum()).thenReturn("Checksum");
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getUrl()).thenReturn("https://example.org/example");
    when(otaPackage.getData()).thenReturn(null);
    when(otaPackage.getDeviceProfileId()).thenReturn(deviceProfileId);
    when(otaPackage.getChecksumAlgorithm()).thenReturn(ChecksumAlgorithm.MD5);
    when(otaPackage.getTag()).thenReturn("Tag");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getTitle()).thenReturn("Dr");
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getId()).thenReturn(new OtaPackageId(UUID.randomUUID()));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult = otaPackageMsgConstructorV1
        .constructOtaPackageUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    verify(otaPackage).getData();
    verify(otaPackage, atLeast(1)).getAdditionalInfo();
    verify(otaPackage, atLeast(1)).getChecksum();
    verify(otaPackage, atLeast(1)).getChecksumAlgorithm();
    verify(otaPackage, atLeast(1)).getContentType();
    verify(otaPackage, atLeast(1)).getDataSize();
    verify(otaPackage, atLeast(1)).getDeviceProfileId();
    verify(otaPackage, atLeast(1)).getFileName();
    verify(otaPackage, atLeast(1)).getId();
    verify(otaPackage).getTag();
    verify(otaPackage).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getUrl();
    verify(otaPackage).getVersion();
    verify(deviceProfileId, atLeast(1)).getId();
    ByteString data = actualConstructOtaPackageUpdatedMsgResult.getData();
    assertEquals("", data.toStringUtf8());
    Descriptors.Descriptor descriptorForType = actualConstructOtaPackageUpdatedMsgResult.getDescriptorForType();
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getJavaOuterClassname());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(18, fields.size());
    assertFalse(defaultInstanceForType.getJavaMultipleFiles());
    assertFalse(data.iterator().hasNext());
    assertFalse(actualConstructOtaPackageUpdatedMsgResult.hasData());
    assertTrue(data.isEmpty());
    assertEquals(data, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(data, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(data, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(17).toProto();
    assertEquals(data, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(Short.SIZE).toProto();
    assertEquals(data, toProtoResult4.getDefaultValueBytes());
    assertEquals(data, toProtoResult.getExtendeeBytes());
    assertEquals(data, toProtoResult2.getExtendeeBytes());
    assertEquals(data, toProtoResult3.getExtendeeBytes());
    assertEquals(data, toProtoResult4.getExtendeeBytes());
    assertEquals(data, toProtoResult.getJsonNameBytes());
    assertEquals(data, toProtoResult2.getJsonNameBytes());
    assertEquals(data, toProtoResult3.getJsonNameBytes());
    assertEquals(data, toProtoResult4.getJsonNameBytes());
    assertEquals(data, toProtoResult2.getTypeNameBytes());
    assertEquals(data, toProtoResult3.getTypeNameBytes());
    assertEquals(data, toProtoResult4.getTypeNameBytes());
    assertEquals(data, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(data, options.getCsharpNamespaceBytes());
    assertEquals(data, defaultInstanceForType.getGoPackageBytes());
    assertEquals(data, options.getGoPackageBytes());
    assertEquals(data, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(data, options.getObjcClassPrefixBytes());
    assertEquals(data, options.getPhpClassPrefixBytes());
    assertEquals(data, options.getPhpMetadataNamespaceBytes());
    assertEquals(data, options.getPhpNamespaceBytes());
    assertEquals(data, options.getRubyPackageBytes());
    assertEquals(data, options.getSwiftPrefixBytes());
    OtaPackageUpdateMsg defaultInstanceForType2 = actualConstructOtaPackageUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(data, defaultInstanceForType2.getAdditionalInfoBytes());
    assertEquals(data, defaultInstanceForType2.getChecksumAlgorithmBytes());
    assertEquals(data, defaultInstanceForType2.getChecksumBytes());
    assertEquals(data, defaultInstanceForType2.getContentTypeBytes());
    assertEquals(data, defaultInstanceForType2.getEntityBytes());
    assertEquals(data, actualConstructOtaPackageUpdatedMsgResult.getEntityBytes());
    assertEquals(data, defaultInstanceForType2.getFileNameBytes());
    assertEquals(data, defaultInstanceForType2.getTagBytes());
    assertEquals(data, defaultInstanceForType2.getTitleBytes());
    assertEquals(data, defaultInstanceForType2.getTypeBytes());
    assertEquals(data, defaultInstanceForType2.getUrlBytes());
    assertEquals(data, defaultInstanceForType2.getVersionBytes());
    assertSame(data, defaultInstanceForType2.getData());
  }

  /**
   * Test
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}.
   * <ul>
   *   <li>Then return DeviceProfileIdLSB is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName("Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); then return DeviceProfileIdLSB is zero")
  void testConstructOtaPackageUpdatedMsg_thenReturnDeviceProfileIdLSBIsZero() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(otaPackage.getDataSize()).thenReturn(3L);
    when(otaPackage.getChecksum()).thenReturn("Checksum");
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getUrl()).thenReturn("https://example.org/example");
    when(otaPackage.getData()).thenReturn(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    when(otaPackage.getDeviceProfileId()).thenReturn(null);
    when(otaPackage.getChecksumAlgorithm()).thenReturn(ChecksumAlgorithm.MD5);
    when(otaPackage.getTag()).thenReturn("Tag");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getTitle()).thenReturn("Dr");
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getId()).thenReturn(new OtaPackageId(UUID.randomUUID()));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult = otaPackageMsgConstructorV1
        .constructOtaPackageUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    verify(otaPackage, atLeast(1)).getData();
    verify(otaPackage, atLeast(1)).getAdditionalInfo();
    verify(otaPackage, atLeast(1)).getChecksum();
    verify(otaPackage, atLeast(1)).getChecksumAlgorithm();
    verify(otaPackage, atLeast(1)).getContentType();
    verify(otaPackage, atLeast(1)).getDataSize();
    verify(otaPackage).getDeviceProfileId();
    verify(otaPackage, atLeast(1)).getFileName();
    verify(otaPackage, atLeast(1)).getId();
    verify(otaPackage).getTag();
    verify(otaPackage).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getUrl();
    verify(otaPackage).getVersion();
    assertEquals(0L, actualConstructOtaPackageUpdatedMsgResult.getDeviceProfileIdLSB());
    assertEquals(0L, actualConstructOtaPackageUpdatedMsgResult.getDeviceProfileIdMSB());
    assertEquals(14, actualConstructOtaPackageUpdatedMsgResult.getAllFields().size());
  }

  /**
   * Test
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}.
   * <ul>
   *   <li>Then return FileName is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName("Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); then return FileName is empty string")
  void testConstructOtaPackageUpdatedMsg_thenReturnFileNameIsEmptyString() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(UUID.randomUUID());
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(otaPackage.getDataSize()).thenReturn(3L);
    when(otaPackage.getChecksum()).thenReturn("Checksum");
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.getFileName()).thenReturn(null);
    when(otaPackage.getUrl()).thenReturn("https://example.org/example");
    when(otaPackage.getData()).thenReturn(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    when(otaPackage.getDeviceProfileId()).thenReturn(deviceProfileId);
    when(otaPackage.getChecksumAlgorithm()).thenReturn(ChecksumAlgorithm.MD5);
    when(otaPackage.getTag()).thenReturn("Tag");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getTitle()).thenReturn("Dr");
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getId()).thenReturn(new OtaPackageId(UUID.randomUUID()));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult = otaPackageMsgConstructorV1
        .constructOtaPackageUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    verify(otaPackage, atLeast(1)).getData();
    verify(otaPackage, atLeast(1)).getAdditionalInfo();
    verify(otaPackage, atLeast(1)).getChecksum();
    verify(otaPackage, atLeast(1)).getChecksumAlgorithm();
    verify(otaPackage, atLeast(1)).getContentType();
    verify(otaPackage, atLeast(1)).getDataSize();
    verify(otaPackage, atLeast(1)).getDeviceProfileId();
    verify(otaPackage).getFileName();
    verify(otaPackage, atLeast(1)).getId();
    verify(otaPackage).getTag();
    verify(otaPackage).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage, atLeast(1)).getUrl();
    verify(otaPackage).getVersion();
    verify(deviceProfileId, atLeast(1)).getId();
    assertEquals("", actualConstructOtaPackageUpdatedMsgResult.getFileName());
    assertFalse(actualConstructOtaPackageUpdatedMsgResult.hasFileName());
  }

  /**
   * Test
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}.
   * <ul>
   *   <li>Then return Url is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtaPackageMsgConstructorV1#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName("Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); then return Url is empty string")
  void testConstructOtaPackageUpdatedMsg_thenReturnUrlIsEmptyString() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(UUID.randomUUID());
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(otaPackage.getDataSize()).thenReturn(3L);
    when(otaPackage.getChecksum()).thenReturn("Checksum");
    when(otaPackage.getContentType()).thenReturn("text/plain");
    when(otaPackage.getFileName()).thenReturn("foo.txt");
    when(otaPackage.getUrl()).thenReturn(null);
    when(otaPackage.getData()).thenReturn(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    when(otaPackage.getDeviceProfileId()).thenReturn(deviceProfileId);
    when(otaPackage.getChecksumAlgorithm()).thenReturn(ChecksumAlgorithm.MD5);
    when(otaPackage.getTag()).thenReturn("Tag");
    when(otaPackage.getVersion()).thenReturn("1.0.2");
    when(otaPackage.getTitle()).thenReturn("Dr");
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getId()).thenReturn(new OtaPackageId(UUID.randomUUID()));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult = otaPackageMsgConstructorV1
        .constructOtaPackageUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    verify(otaPackage, atLeast(1)).getData();
    verify(otaPackage, atLeast(1)).getAdditionalInfo();
    verify(otaPackage, atLeast(1)).getChecksum();
    verify(otaPackage, atLeast(1)).getChecksumAlgorithm();
    verify(otaPackage, atLeast(1)).getContentType();
    verify(otaPackage, atLeast(1)).getDataSize();
    verify(otaPackage, atLeast(1)).getDeviceProfileId();
    verify(otaPackage, atLeast(1)).getFileName();
    verify(otaPackage, atLeast(1)).getId();
    verify(otaPackage).getTag();
    verify(otaPackage).getTitle();
    verify(otaPackage).getType();
    verify(otaPackage).getUrl();
    verify(otaPackage).getVersion();
    verify(deviceProfileId, atLeast(1)).getId();
    assertEquals("", actualConstructOtaPackageUpdatedMsgResult.getUrl());
    assertFalse(actualConstructOtaPackageUpdatedMsgResult.hasUrl());
  }
}
