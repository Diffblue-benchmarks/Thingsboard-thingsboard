package org.thingsboard.server.service.edge.rpc.constructor.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.gen.edge.v1.DeviceCredentialsUpdateMsg;

class DeviceMsgConstructorV1DiffblueTest {
  /**
   * Test
   * {@link DeviceMsgConstructorV1#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceMsgConstructorV1#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test constructDeviceCredentialsUpdatedMsg(DeviceCredentials)")
  void testConstructDeviceCredentialsUpdatedMsg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceMsgConstructorV1 deviceMsgConstructorV1 = new DeviceMsgConstructorV1();
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenReturn("42");
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);
    when(deviceCredentials.getDeviceId()).thenReturn(new DeviceId(UUID.randomUUID()));

    // Act
    DeviceCredentialsUpdateMsg actualConstructDeviceCredentialsUpdatedMsgResult = deviceMsgConstructorV1
        .constructDeviceCredentialsUpdatedMsg(deviceCredentials);

    // Assert
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials, atLeast(1)).getCredentialsValue();
    verify(deviceCredentials, atLeast(1)).getDeviceId();
    ByteString entityBytes = actualConstructDeviceCredentialsUpdatedMsgResult.getEntityBytes();
    assertEquals("", entityBytes.toStringUtf8());
    assertEquals(5, actualConstructDeviceCredentialsUpdatedMsgResult.getAllFields().size());
    Descriptors.Descriptor descriptorForType = actualConstructDeviceCredentialsUpdatedMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertFalse(entityBytes.iterator().hasNext());
    assertTrue(entityBytes.isEmpty());
    assertEquals(entityBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(entityBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(entityBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(4).toProto();
    assertEquals(entityBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(5).toProto();
    assertEquals(entityBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(entityBytes, toProtoResult.getExtendeeBytes());
    assertEquals(entityBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(entityBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(entityBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(entityBytes, toProtoResult.getJsonNameBytes());
    assertEquals(entityBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(entityBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(entityBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(entityBytes, toProtoResult.getTypeNameBytes());
    assertEquals(entityBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(entityBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(entityBytes, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(entityBytes, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(entityBytes, options.getCsharpNamespaceBytes());
    assertEquals(entityBytes, defaultInstanceForType.getGoPackageBytes());
    assertEquals(entityBytes, options.getGoPackageBytes());
    assertEquals(entityBytes, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(entityBytes, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(entityBytes, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(entityBytes, options.getObjcClassPrefixBytes());
    assertEquals(entityBytes, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(entityBytes, options.getPhpClassPrefixBytes());
    assertEquals(entityBytes, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(entityBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(entityBytes, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(entityBytes, options.getPhpNamespaceBytes());
    assertEquals(entityBytes, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(entityBytes, options.getRubyPackageBytes());
    assertEquals(entityBytes, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(entityBytes, options.getSwiftPrefixBytes());
    DeviceCredentialsUpdateMsg defaultInstanceForType2 = actualConstructDeviceCredentialsUpdatedMsgResult
        .getDefaultInstanceForType();
    assertEquals(entityBytes, defaultInstanceForType2.getCredentialsIdBytes());
    assertEquals(entityBytes, defaultInstanceForType2.getCredentialsTypeBytes());
    assertEquals(entityBytes, defaultInstanceForType2.getCredentialsValueBytes());
    assertEquals(entityBytes, defaultInstanceForType2.getEntityBytes());
  }

  /**
   * Test
   * {@link DeviceMsgConstructorV1#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceMsgConstructorV1#constructDeviceCredentialsUpdatedMsg(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test constructDeviceCredentialsUpdatedMsg(DeviceCredentials)")
  void testConstructDeviceCredentialsUpdatedMsg2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceMsgConstructorV1 deviceMsgConstructorV1 = new DeviceMsgConstructorV1();
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenReturn("42");
    when(deviceCredentials.getCredentialsValue()).thenReturn(null);
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);
    when(deviceCredentials.getDeviceId()).thenReturn(new DeviceId(UUID.randomUUID()));

    // Act
    DeviceCredentialsUpdateMsg actualConstructDeviceCredentialsUpdatedMsgResult = deviceMsgConstructorV1
        .constructDeviceCredentialsUpdatedMsg(deviceCredentials);

    // Assert
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials, atLeast(1)).getDeviceId();
    ByteString credentialsValueBytes = actualConstructDeviceCredentialsUpdatedMsgResult.getCredentialsValueBytes();
    assertEquals("", credentialsValueBytes.toStringUtf8());
    assertEquals("", actualConstructDeviceCredentialsUpdatedMsgResult.getCredentialsValue());
    assertEquals(4, actualConstructDeviceCredentialsUpdatedMsgResult.getAllFields().size());
    Descriptors.Descriptor descriptorForType = actualConstructDeviceCredentialsUpdatedMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(6, fields.size());
    assertFalse(credentialsValueBytes.iterator().hasNext());
    assertFalse(actualConstructDeviceCredentialsUpdatedMsgResult.hasCredentialsValue());
    assertTrue(credentialsValueBytes.isEmpty());
    assertEquals(credentialsValueBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(credentialsValueBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(credentialsValueBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(4).toProto();
    assertEquals(credentialsValueBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(5).toProto();
    assertEquals(credentialsValueBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(credentialsValueBytes, toProtoResult.getExtendeeBytes());
    assertEquals(credentialsValueBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(credentialsValueBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(credentialsValueBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(credentialsValueBytes, toProtoResult.getJsonNameBytes());
    assertEquals(credentialsValueBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(credentialsValueBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(credentialsValueBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(credentialsValueBytes, toProtoResult.getTypeNameBytes());
    assertEquals(credentialsValueBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(credentialsValueBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(credentialsValueBytes, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(credentialsValueBytes, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(credentialsValueBytes, options.getCsharpNamespaceBytes());
    assertEquals(credentialsValueBytes, defaultInstanceForType.getGoPackageBytes());
    assertEquals(credentialsValueBytes, options.getGoPackageBytes());
    assertEquals(credentialsValueBytes, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(credentialsValueBytes, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(credentialsValueBytes, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(credentialsValueBytes, options.getObjcClassPrefixBytes());
    assertEquals(credentialsValueBytes, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(credentialsValueBytes, options.getPhpClassPrefixBytes());
    assertEquals(credentialsValueBytes, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(credentialsValueBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(credentialsValueBytes, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(credentialsValueBytes, options.getPhpNamespaceBytes());
    assertEquals(credentialsValueBytes, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(credentialsValueBytes, options.getRubyPackageBytes());
    assertEquals(credentialsValueBytes, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(credentialsValueBytes, options.getSwiftPrefixBytes());
    DeviceCredentialsUpdateMsg defaultInstanceForType2 = actualConstructDeviceCredentialsUpdatedMsgResult
        .getDefaultInstanceForType();
    assertEquals(credentialsValueBytes, defaultInstanceForType2.getCredentialsIdBytes());
    assertEquals(credentialsValueBytes, defaultInstanceForType2.getCredentialsTypeBytes());
    assertEquals(credentialsValueBytes, defaultInstanceForType2.getCredentialsValueBytes());
    assertEquals(credentialsValueBytes, defaultInstanceForType2.getEntityBytes());
    assertEquals(credentialsValueBytes, actualConstructDeviceCredentialsUpdatedMsgResult.getEntityBytes());
  }
}
