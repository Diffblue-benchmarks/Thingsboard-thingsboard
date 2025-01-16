package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DownlinkMsgDiffblueTest {
  /**
   * Test {@link DownlinkMsg#equals(Object)}, and {@link DownlinkMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DownlinkMsg#equals(Object)}
   *   <li>{@link DownlinkMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DownlinkMsg defaultInstance = DownlinkMsg.getDefaultInstance();
    DownlinkMsg defaultInstance2 = DownlinkMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link DownlinkMsg#equals(Object)}, and {@link DownlinkMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DownlinkMsg#equals(Object)}
   *   <li>{@link DownlinkMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DownlinkMsg defaultInstance = DownlinkMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link DownlinkMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DownlinkMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DownlinkMsg.getDefaultInstance(), 1);
  }

  /**
   * Test {@link DownlinkMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DownlinkMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DownlinkMsg.getDefaultInstance(), null);
  }

  /**
   * Test {@link DownlinkMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DownlinkMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DownlinkMsg.getDefaultInstance(), "Different type to DownlinkMsg");
  }

  /**
   * Test {@link DownlinkMsg#getAdminSettingsUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getAdminSettingsUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getAdminSettingsUpdateMsgCount()")
  void testGetAdminSettingsUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getAdminSettingsUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getAlarmCommentUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getAlarmCommentUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getAlarmCommentUpdateMsgCount()")
  void testGetAlarmCommentUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getAlarmCommentUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getAlarmUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getAlarmUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getAlarmUpdateMsgCount()")
  void testGetAlarmUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getAlarmUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getAssetProfileUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getAssetProfileUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getAssetProfileUpdateMsgCount()")
  void testGetAssetProfileUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getAssetProfileUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getAssetUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getAssetUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getAssetUpdateMsgCount()")
  void testGetAssetUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getAssetUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getCustomerUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getCustomerUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getCustomerUpdateMsgCount()")
  void testGetCustomerUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getCustomerUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getDashboardUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getDashboardUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getDashboardUpdateMsgCount()")
  void testGetDashboardUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getDashboardUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  void testGetDefaultInstanceForType() {
    // Arrange
    DownlinkMsg defaultInstance = DownlinkMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link DownlinkMsg#getDeviceCredentialsRequestMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getDeviceCredentialsRequestMsgCount()}
   */
  @Test
  @DisplayName("Test getDeviceCredentialsRequestMsgCount()")
  void testGetDeviceCredentialsRequestMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getDeviceCredentialsRequestMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getDeviceCredentialsUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getDeviceCredentialsUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getDeviceCredentialsUpdateMsgCount()")
  void testGetDeviceCredentialsUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getDeviceCredentialsUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getDeviceProfileUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getDeviceProfileUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getDeviceProfileUpdateMsgCount()")
  void testGetDeviceProfileUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getDeviceProfileUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getDeviceRpcCallMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getDeviceRpcCallMsgCount()}
   */
  @Test
  @DisplayName("Test getDeviceRpcCallMsgCount()")
  void testGetDeviceRpcCallMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getDeviceRpcCallMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getDeviceUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getDeviceUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getDeviceUpdateMsgCount()")
  void testGetDeviceUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getDeviceUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getEntityDataCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getEntityDataCount()}
   */
  @Test
  @DisplayName("Test getEntityDataCount()")
  void testGetEntityDataCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getEntityDataCount());
  }

  /**
   * Test {@link DownlinkMsg#getEntityViewUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getEntityViewUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getEntityViewUpdateMsgCount()")
  void testGetEntityViewUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getEntityViewUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getNotificationRuleUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getNotificationRuleUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getNotificationRuleUpdateMsgCount()")
  void testGetNotificationRuleUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getNotificationRuleUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getNotificationTargetUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getNotificationTargetUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getNotificationTargetUpdateMsgCount()")
  void testGetNotificationTargetUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getNotificationTargetUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getNotificationTemplateUpdateMsgCount()}.
   * <p>
   * Method under test:
   * {@link DownlinkMsg#getNotificationTemplateUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getNotificationTemplateUpdateMsgCount()")
  void testGetNotificationTemplateUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getNotificationTemplateUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getOAuth2ClientUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getOAuth2ClientUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getOAuth2ClientUpdateMsgCount()")
  void testGetOAuth2ClientUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getOAuth2ClientUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getOAuth2DomainUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getOAuth2DomainUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getOAuth2DomainUpdateMsgCount()")
  void testGetOAuth2DomainUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getOAuth2DomainUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getOtaPackageUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getOtaPackageUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getOtaPackageUpdateMsgCount()")
  void testGetOtaPackageUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getOtaPackageUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getQueueUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getQueueUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getQueueUpdateMsgCount()")
  void testGetQueueUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getQueueUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getRelationUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getRelationUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getRelationUpdateMsgCount()")
  void testGetRelationUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getRelationUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getResourceUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getResourceUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getResourceUpdateMsgCount()")
  void testGetResourceUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getResourceUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getRuleChainMetadataUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getRuleChainMetadataUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getRuleChainMetadataUpdateMsgCount()")
  void testGetRuleChainMetadataUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getRuleChainMetadataUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getRuleChainUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getRuleChainUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getRuleChainUpdateMsgCount()")
  void testGetRuleChainUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getRuleChainUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link DownlinkMsg#getSyncCompletedMsg()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getSyncCompletedMsg()}
   */
  @Test
  @DisplayName("Test getSyncCompletedMsg()")
  void testGetSyncCompletedMsg() {
    // Arrange and Act
    SyncCompletedMsg actualSyncCompletedMsg = DownlinkMsg.getDefaultInstance().getSyncCompletedMsg();

    // Assert
    Descriptors.Descriptor descriptorForType = actualSyncCompletedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    Descriptors.EnumDescriptor getResult = enumTypes.get(0);
    DescriptorProtos.EnumOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.EnumDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.EnumDescriptor getResult2 = enumTypes.get(1);
    DescriptorProtos.EnumDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    Descriptors.EnumDescriptor getResult3 = enumTypes.get(3);
    DescriptorProtos.EnumDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    Descriptors.EnumDescriptor getResult4 = enumTypes.get(4);
    DescriptorProtos.EnumDescriptorProto toProtoResult8 = getResult4.toProto();
    assertEquals("", toProtoResult8.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    DescriptorProtos.FileOptions options4 = getResult5.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    DescriptorProtos.FileDescriptorProto toProtoResult9 = getResult5.toProto();
    assertEquals("", toProtoResult9.getInitializationErrorString());
    assertEquals("", actualSyncCompletedMsg.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", options4.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", options4.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", options4.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", options4.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", options4.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", options4.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", options4.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    assertEquals("", options4.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    assertEquals("", getResult5.getEditionName());
    assertEquals("DescriptorProto", toProtoResult4.getName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    Descriptors.Descriptor getResult6 = messageTypes.get(57);
    assertEquals("DownlinkMsg", getResult6.getName());
    Descriptors.Descriptor getResult7 = messageTypes.get(56);
    assertEquals("DownlinkResponseMsg", getResult7.getName());
    assertEquals("EdgeEntityType", toProtoResult8.getName());
    assertEquals("EdgeEntityType", getResult4.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("EdgeProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("EdgeProtos", options.getJavaOuterClassname());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    Descriptors.ServiceDescriptor getResult8 = services.get(0);
    assertEquals("EdgeRpcService", getResult8.getName());
    assertEquals("EdgeVersion", toProtoResult5.getName());
    assertEquals("EdgeVersion", getResult.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult9 = messageTypes.get(0);
    assertEquals("RequestMsg", getResult9.getName());
    assertEquals("RequestMsgType", toProtoResult6.getName());
    assertEquals("RequestMsgType", getResult2.getName());
    Descriptors.Descriptor getResult10 = messageTypes.get(1);
    assertEquals("ResponseMsg", getResult10.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("SyncCompletedMsg", nameBytes.toStringUtf8());
    assertEquals("SyncCompletedMsg", toProtoResult.getName());
    assertEquals("SyncCompletedMsg", descriptorForType.getName());
    assertEquals("TransportProtos", options4.getJavaOuterClassname());
    assertEquals("UpdateMsgType", toProtoResult7.getName());
    assertEquals("UpdateMsgType", getResult3.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("edge", packageBytes.toStringUtf8());
    assertEquals("edge", toProtoResult2.getPackage());
    assertEquals("edge", file.getPackage());
    assertEquals("edge.DownlinkMsg", getResult6.getFullName());
    assertEquals("edge.DownlinkResponseMsg", getResult7.getFullName());
    assertEquals("edge.EdgeEntityType", getResult4.getFullName());
    assertEquals("edge.EdgeVersion", getResult.getFullName());
    assertEquals("edge.RequestMsg", getResult9.getFullName());
    assertEquals("edge.RequestMsgType", getResult2.getFullName());
    assertEquals("edge.ResponseMsg", getResult10.getFullName());
    assertEquals("edge.SyncCompletedMsg", descriptorForType.getFullName());
    assertEquals("edge.UpdateMsgType", getResult3.getFullName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("edge.proto", nameBytes2.toStringUtf8());
    assertEquals("edge.proto", toProtoResult2.getName());
    assertEquals("edge.proto", file.getFullName());
    assertEquals("edge.proto", file.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.edge.v1", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.edge.v1", options.getJavaPackage());
    assertEquals("org.thingsboard.server.gen.transport", options4.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("proto3", toProtoResult9.getSyntax());
    assertEquals("queue.proto", toProtoResult9.getName());
    assertEquals("queue.proto", getResult5.getFullName());
    assertEquals("queue.proto", getResult5.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("queue.proto", dependencyList.get(0));
    assertEquals("transport", toProtoResult9.getPackage());
    assertEquals("transport", getResult5.getPackage());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult9.getContainingType());
    assertNull(getResult10.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult.getContainingType());
    assertNull(getResult2.getContainingType());
    assertNull(getResult3.getContainingType());
    assertNull(getResult4.getContainingType());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult4.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult4.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult4.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, toProtoResult.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult4.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult4.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult4.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, toProtoResult5.getReservedNameCount());
    assertEquals(0, toProtoResult6.getReservedNameCount());
    assertEquals(0, toProtoResult7.getReservedNameCount());
    assertEquals(0, toProtoResult8.getReservedNameCount());
    assertEquals(0, toProtoResult5.getReservedRangeCount());
    assertEquals(0, toProtoResult6.getReservedRangeCount());
    assertEquals(0, toProtoResult7.getReservedRangeCount());
    assertEquals(0, toProtoResult8.getReservedRangeCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, toProtoResult9.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, toProtoResult9.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, toProtoResult9.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult9.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, toProtoResult9.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult9.getIndex());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult8.getIndex());
    UnknownFieldSet unknownFields = actualSyncCompletedMsg.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualSyncCompletedMsg.getSerializedSize());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult2.getDependencyCount());
    assertEquals(1, toProtoResult2.getServiceCount());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, getResult10.getIndex());
    assertEquals(1, getResult2.getIndex());
    List<DescriptorProtos.ServiceDescriptorProto> serviceList = toProtoResult2.getServiceList();
    assertEquals(1, serviceList.size());
    assertEquals(1, toProtoResult.getAllFields().size());
    assertEquals(130, toProtoResult5.getSerializedSize());
    assertEquals(17264, toProtoResult2.getSerializedSize());
    assertEquals(180, toProtoResult9.getMessageTypeCount());
    assertEquals(180, getResult5.getMessageTypes().size());
    assertEquals(2, toProtoResult4.getNestedTypeCount());
    assertEquals(2, toProtoResult8.getValueCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(2, getResult4.getValues().size());
    assertEquals(201, toProtoResult7.getSerializedSize());
    assertEquals(3, toProtoResult6.getValueCount());
    assertEquals(3, getResult3.getIndex());
    assertEquals(3, getResult2.getValues().size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(3, allFields.size());
    assertEquals(36059, toProtoResult9.getSerializedSize());
    assertEquals(39, toProtoResult8.getSerializedSize());
    assertEquals(4, getResult4.getIndex());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getEnumTypeCount());
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(5, enumTypeList.size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(55, options4.getSerializedSize());
    assertEquals(56, getResult7.getIndex());
    assertEquals(57, getResult6.getIndex());
    assertEquals(58, toProtoResult2.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(58, messageTypeList.size());
    assertEquals(6, toProtoResult7.getValueCount());
    assertEquals(6, descriptorForType.getIndex());
    assertEquals(6, getResult3.getValues().size());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(8, toProtoResult2.getAllFields().size());
    assertEquals(825, toProtoResult4.getSerializedSize());
    assertEquals(95, toProtoResult6.getSerializedSize());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult9.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult5.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options4.getOptimizeFor());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult5.getSyntax());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(toProtoResult8.hasOptions());
    assertFalse(options3.getAllowAlias());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options3.hasAllowAlias());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options3.hasFeatures());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(toProtoResult9.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(toProtoResult9.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(options4.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(options4.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(options4.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(options4.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(options4.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(options4.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(options4.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(options4.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(options4.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(options4.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(options4.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(options4.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(options4.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(options4.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(options4.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(options4.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(options4.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(options4.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(options4.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(options4.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(options4.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(options4.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(options4.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(options4.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(options4.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(options4.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
    assertFalse(options4.hasSwiftPrefix());
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult9.isExtendable());
    assertFalse(getResult10.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult.isClosed());
    assertFalse(getResult2.isClosed());
    assertFalse(getResult3.isClosed());
    assertFalse(getResult4.isClosed());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult8.hasName());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(toProtoResult8.isInitialized());
    assertTrue(options3.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult9.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult9.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult9.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(toProtoResult9.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(toProtoResult9.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options4.getCcEnableArenas());
    assertTrue(options.getJavaMultipleFiles());
    assertTrue(options.hasJavaMultipleFiles());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options4.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(options4.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = packageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = syntaxBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    ByteString.ByteIterator iteratorResult6 = javaPackageBytes.iterator();
    assertTrue(iteratorResult6.hasNext());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualSyncCompletedMsg.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertTrue(publicDependencyList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType3.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(getResult9.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(getResult9.getExtensions().isEmpty());
    assertTrue(descriptorForType.getFields().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(getResult5.getDependencies().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(getResult5.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(getResult5.getPublicDependencies().isEmpty());
    assertTrue(getResult5.getServices().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualSyncCompletedMsg.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualSyncCompletedMsg.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult8.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult9.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult10.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult10.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult9.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult10.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult9.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult10.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult9.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult10.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(syntaxBytes, toProtoResult9.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options4.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options4.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options4.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options4.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options4.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options4.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options4.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options4.getSwiftPrefixBytes());
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(DownlinkMsg.ASSETUPDATEMSG_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(DownlinkMsg.DASHBOARDUPDATEMSG_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(DownlinkMsg.DASHBOARDUPDATEMSG_FIELD_NUMBER, toProtoResult9.getEnumTypeCount());
    assertEquals(DownlinkMsg.DASHBOARDUPDATEMSG_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(DownlinkMsg.DASHBOARDUPDATEMSG_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(DownlinkMsg.DASHBOARDUPDATEMSG_FIELD_NUMBER, getResult5.getEnumTypes().size());
    assertEquals(DownlinkMsg.RULECHAINMETADATAUPDATEMSG_FIELD_NUMBER, toProtoResult5.getValueCount());
    assertEquals(DownlinkMsg.RULECHAINMETADATAUPDATEMSG_FIELD_NUMBER, getResult.getValues().size());
    assertEquals(DownlinkMsg.WIDGETSBUNDLEUPDATEMSG_FIELD_NUMBER, toProtoResult.getSerializedSize());
    assertEquals(DownlinkMsg.WIDGETTYPEUPDATEMSG_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(EdgeRpcServiceGrpc.SERVICE_NAME, getResult8.getFullName());
    assertEquals('E', iteratorResult5.next().byteValue());
    assertEquals('S', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('e', iteratorResult3.next().byteValue());
    assertEquals('o', iteratorResult6.next().byteValue());
    assertEquals('p', iteratorResult4.next().byteValue());
    assertEquals('y', iteratorResult.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult4.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult3.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult4.getReservedNameList(), toProtoResult4.getReservedNameList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult9.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult9.getWeakDependencyList());
    assertSame(serviceList, toProtoResult2.getServiceOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, toProtoResult9.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult9.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, toProtoResult.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult4.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult4.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult8.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult7.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult8.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult9.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult9.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult9.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult9.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult9.getFile());
    assertSame(file, getResult10.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, toProtoResult4.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, toProtoResult4.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options5, options5);
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType6.getOptions());
    assertSame(options5, descriptorForType5.getOptions());
    assertSame(options5, getResult9.getOptions());
    assertSame(options5, getResult10.getOptions());
    assertSame(options5, getResult7.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult8.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, toProtoResult8.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult5, enumTypeList.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult9.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(actualSyncCompletedMsg, actualSyncCompletedMsg.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, toProtoResult8.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult9.getDependencyList());
  }

  /**
   * Test {@link DownlinkMsg#getTenantProfileUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getTenantProfileUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getTenantProfileUpdateMsgCount()")
  void testGetTenantProfileUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getTenantProfileUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getTenantUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getTenantUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getTenantUpdateMsgCount()")
  void testGetTenantUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getTenantUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getUserCredentialsUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getUserCredentialsUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getUserCredentialsUpdateMsgCount()")
  void testGetUserCredentialsUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getUserCredentialsUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getUserUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getUserUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getUserUpdateMsgCount()")
  void testGetUserUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getUserUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getWidgetTypeUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getWidgetTypeUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getWidgetTypeUpdateMsgCount()")
  void testGetWidgetTypeUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getWidgetTypeUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#getWidgetsBundleUpdateMsgCount()}.
   * <p>
   * Method under test: {@link DownlinkMsg#getWidgetsBundleUpdateMsgCount()}
   */
  @Test
  @DisplayName("Test getWidgetsBundleUpdateMsgCount()")
  void testGetWidgetsBundleUpdateMsgCount() {
    // Arrange, Act and Assert
    assertEquals(0, DownlinkMsg.getDefaultInstance().getWidgetsBundleUpdateMsgCount());
  }

  /**
   * Test {@link DownlinkMsg#hasEdgeConfiguration()}.
   * <p>
   * Method under test: {@link DownlinkMsg#hasEdgeConfiguration()}
   */
  @Test
  @DisplayName("Test hasEdgeConfiguration()")
  void testHasEdgeConfiguration() {
    // Arrange, Act and Assert
    assertFalse(DownlinkMsg.getDefaultInstance().hasEdgeConfiguration());
  }

  /**
   * Test {@link DownlinkMsg#hasSyncCompletedMsg()}.
   * <p>
   * Method under test: {@link DownlinkMsg#hasSyncCompletedMsg()}
   */
  @Test
  @DisplayName("Test hasSyncCompletedMsg()")
  void testHasSyncCompletedMsg() {
    // Arrange, Act and Assert
    assertFalse(DownlinkMsg.getDefaultInstance().hasSyncCompletedMsg());
  }

  /**
   * Test {@link DownlinkMsg#isInitialized()}.
   * <p>
   * Method under test: {@link DownlinkMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(DownlinkMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link DownlinkMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link DownlinkMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test newInstance(UnusedPrivateParameter)")
  void testNewInstance() {
    // Arrange
    DownlinkMsg defaultInstance = DownlinkMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof DownlinkMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test {@link DownlinkMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DownlinkMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'")
  void testParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DownlinkMsg actualParseDelimitedFromResult = DownlinkMsg.parseDelimitedFrom(input);

    // Assert
    DownlinkMsg defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(DownlinkMsg.OAUTH2DOMAINUPDATEMSG_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(DownlinkMsg.OAUTH2DOMAINUPDATEMSG_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType2.getReservedNameList());
    EdgeConfiguration edgeConfiguration = actualParseDelimitedFromResult.getEdgeConfiguration();
    Descriptors.Descriptor descriptorForType2 = edgeConfiguration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    SyncCompletedMsg syncCompletedMsg = actualParseDelimitedFromResult.getSyncCompletedMsg();
    Descriptors.Descriptor descriptorForType3 = syncCompletedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.FieldDescriptor getResult2 = fields.get(DownlinkMsg.NOTIFICATIONTARGETUPDATEMSG_FIELD_NUMBER);
    Descriptors.Descriptor messageType = getResult2.getMessageType();
    assertSame(file, messageType.getFile());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(DownlinkMsg.NOTIFICATIONTEMPLATEUPDATEMSG_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType2.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, messageType.getOptions());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType3, getResult3.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(57));
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, edgeConfiguration.getUnknownFields());
    assertSame(unknownFields, syncCompletedMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(edgeConfiguration, defaultInstanceForType.getEdgeConfiguration());
    assertSame(edgeConfiguration, defaultInstanceForType.getEdgeConfigurationOrBuilder());
    assertSame(edgeConfiguration, actualParseDelimitedFromResult.getEdgeConfigurationOrBuilder());
    assertSame(edgeConfiguration, edgeConfiguration.getDefaultInstanceForType());
    assertSame(syncCompletedMsg, defaultInstanceForType.getSyncCompletedMsg());
    assertSame(syncCompletedMsg, defaultInstanceForType.getSyncCompletedMsgOrBuilder());
    assertSame(syncCompletedMsg, actualParseDelimitedFromResult.getSyncCompletedMsgOrBuilder());
    assertSame(syncCompletedMsg, syncCompletedMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link DownlinkMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link DownlinkMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'")
  void testParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DownlinkMsg actualParseDelimitedFromResult = DownlinkMsg.parseDelimitedFrom(input);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(DownlinkMsg.OAUTH2DOMAINUPDATEMSG_FIELD_NUMBER, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(DownlinkMsg.NOTIFICATIONTEMPLATEUPDATEMSG_FIELD_NUMBER);
    Descriptors.Descriptor messageType = getResult.getMessageType();
    assertEquals("edge.OAuth2DomainUpdateMsg", messageType.getFullName());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(DownlinkMsg.OAUTH2DOMAINUPDATEMSG_FIELD_NUMBER, fieldList.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    EdgeConfiguration edgeConfiguration = actualParseDelimitedFromResult.getEdgeConfiguration();
    Descriptors.Descriptor descriptorForType2 = edgeConfiguration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    SyncCompletedMsg syncCompletedMsg = actualParseDelimitedFromResult.getSyncCompletedMsg();
    Descriptors.Descriptor descriptorForType3 = syncCompletedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult2.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.FieldDescriptor getResult3 = fields.get(DownlinkMsg.NOTIFICATIONTARGETUPDATEMSG_FIELD_NUMBER);
    Descriptors.Descriptor messageType2 = getResult3.getMessageType();
    assertSame(file, messageType2.getFile());
    assertSame(file, messageType.getFile());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, messageType2.getOptions());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult2.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType3, getResult4.getMessageType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(57));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, edgeConfiguration.getUnknownFields());
    assertSame(unknownFields, syncCompletedMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(edgeConfiguration, actualParseDelimitedFromResult.getEdgeConfigurationOrBuilder());
    assertSame(edgeConfiguration, edgeConfiguration.getDefaultInstanceForType());
    assertSame(syncCompletedMsg, actualParseDelimitedFromResult.getSyncCompletedMsgOrBuilder());
    assertSame(syncCompletedMsg, syncCompletedMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link DownlinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link DownlinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DownlinkMsg actualParseDelimitedFromResult = DownlinkMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    DownlinkMsg defaultInstanceForType = actualParseDelimitedFromResult.getDefaultInstanceForType();
    UnknownFieldSet unknownFields = defaultInstanceForType.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(DownlinkMsg.OAUTH2DOMAINUPDATEMSG_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(DownlinkMsg.OAUTH2DOMAINUPDATEMSG_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType2.getReservedNameList());
    EdgeConfiguration edgeConfiguration = actualParseDelimitedFromResult.getEdgeConfiguration();
    Descriptors.Descriptor descriptorForType2 = edgeConfiguration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    SyncCompletedMsg syncCompletedMsg = actualParseDelimitedFromResult.getSyncCompletedMsg();
    Descriptors.Descriptor descriptorForType3 = syncCompletedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.FieldDescriptor getResult2 = fields.get(DownlinkMsg.NOTIFICATIONTARGETUPDATEMSG_FIELD_NUMBER);
    Descriptors.Descriptor messageType = getResult2.getMessageType();
    assertSame(file, messageType.getFile());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(DownlinkMsg.NOTIFICATIONTEMPLATEUPDATEMSG_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType2.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, messageType.getOptions());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType3, getResult3.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(57));
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, edgeConfiguration.getUnknownFields());
    assertSame(unknownFields, syncCompletedMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(edgeConfiguration, defaultInstanceForType.getEdgeConfiguration());
    assertSame(edgeConfiguration, defaultInstanceForType.getEdgeConfigurationOrBuilder());
    assertSame(edgeConfiguration, actualParseDelimitedFromResult.getEdgeConfigurationOrBuilder());
    assertSame(edgeConfiguration, edgeConfiguration.getDefaultInstanceForType());
    assertSame(syncCompletedMsg, defaultInstanceForType.getSyncCompletedMsg());
    assertSame(syncCompletedMsg, defaultInstanceForType.getSyncCompletedMsgOrBuilder());
    assertSame(syncCompletedMsg, actualParseDelimitedFromResult.getSyncCompletedMsgOrBuilder());
    assertSame(syncCompletedMsg, syncCompletedMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link DownlinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link DownlinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    DownlinkMsg actualParseDelimitedFromResult = DownlinkMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(DownlinkMsg.OAUTH2DOMAINUPDATEMSG_FIELD_NUMBER, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(DownlinkMsg.NOTIFICATIONTEMPLATEUPDATEMSG_FIELD_NUMBER);
    Descriptors.Descriptor messageType = getResult.getMessageType();
    assertEquals("edge.OAuth2DomainUpdateMsg", messageType.getFullName());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(DownlinkMsg.OAUTH2DOMAINUPDATEMSG_FIELD_NUMBER, fieldList.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    EdgeConfiguration edgeConfiguration = actualParseDelimitedFromResult.getEdgeConfiguration();
    Descriptors.Descriptor descriptorForType2 = edgeConfiguration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    SyncCompletedMsg syncCompletedMsg = actualParseDelimitedFromResult.getSyncCompletedMsg();
    Descriptors.Descriptor descriptorForType3 = syncCompletedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult2.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.FieldDescriptor getResult3 = fields.get(DownlinkMsg.NOTIFICATIONTARGETUPDATEMSG_FIELD_NUMBER);
    Descriptors.Descriptor messageType2 = getResult3.getMessageType();
    assertSame(file, messageType2.getFile());
    assertSame(file, messageType.getFile());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, messageType2.getOptions());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult2.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult3.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType3, getResult4.getMessageType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, messageTypes.get(57));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, edgeConfiguration.getUnknownFields());
    assertSame(unknownFields, syncCompletedMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(edgeConfiguration, actualParseDelimitedFromResult.getEdgeConfigurationOrBuilder());
    assertSame(edgeConfiguration, edgeConfiguration.getDefaultInstanceForType());
    assertSame(syncCompletedMsg, actualParseDelimitedFromResult.getSyncCompletedMsgOrBuilder());
    assertSame(syncCompletedMsg, syncCompletedMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link DownlinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link DownlinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> DownlinkMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link DownlinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DownlinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DownlinkMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test
   * {@link DownlinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DownlinkMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> DownlinkMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DownlinkMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DownlinkMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> DownlinkMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DownlinkMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DownlinkMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(DownlinkMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link DownlinkMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DownlinkMsg#parseDelimitedFrom(InputStream)}
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
    assertThrows(InvalidProtocolBufferException.class, () -> DownlinkMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link DownlinkMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link DownlinkMsg#parseFrom(InputStream, ExtensionRegistryLite)}
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
        () -> DownlinkMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DownlinkMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DownlinkMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DownlinkMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DownlinkMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DownlinkMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> DownlinkMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DownlinkMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DownlinkMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> DownlinkMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link DownlinkMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty
   * array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DownlinkMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    DownlinkMsg actualParseFromResult = DownlinkMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(DownlinkMsg.OAUTH2DOMAINUPDATEMSG_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(DownlinkMsg.OAUTH2DOMAINUPDATEMSG_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    EdgeConfiguration edgeConfiguration = actualParseFromResult.getEdgeConfiguration();
    Descriptors.Descriptor descriptorForType2 = edgeConfiguration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    SyncCompletedMsg syncCompletedMsg = actualParseFromResult.getSyncCompletedMsg();
    Descriptors.Descriptor descriptorForType3 = syncCompletedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.FieldDescriptor getResult2 = fields.get(DownlinkMsg.NOTIFICATIONTARGETUPDATEMSG_FIELD_NUMBER);
    Descriptors.Descriptor messageType = getResult2.getMessageType();
    assertSame(file, messageType.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(DownlinkMsg.NOTIFICATIONTEMPLATEUPDATEMSG_FIELD_NUMBER);
    assertSame(file, getResult3.getMessageType().getFile());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, messageType.getOptions());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType3, getResult4.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, messageTypes.get(57));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, edgeConfiguration.getUnknownFields());
    assertSame(unknownFields, syncCompletedMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(edgeConfiguration, actualParseFromResult.getEdgeConfigurationOrBuilder());
    assertSame(edgeConfiguration, edgeConfiguration.getDefaultInstanceForType());
    assertSame(syncCompletedMsg, actualParseFromResult.getSyncCompletedMsgOrBuilder());
    assertSame(syncCompletedMsg, syncCompletedMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link DownlinkMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DownlinkMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    DownlinkMsg actualParseFromResult = DownlinkMsg.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(DownlinkMsg.OAUTH2DOMAINUPDATEMSG_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(DownlinkMsg.OAUTH2DOMAINUPDATEMSG_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    EdgeConfiguration edgeConfiguration = actualParseFromResult.getEdgeConfiguration();
    Descriptors.Descriptor descriptorForType2 = edgeConfiguration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    SyncCompletedMsg syncCompletedMsg = actualParseFromResult.getSyncCompletedMsg();
    Descriptors.Descriptor descriptorForType3 = syncCompletedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.FieldDescriptor getResult2 = fields.get(DownlinkMsg.NOTIFICATIONTARGETUPDATEMSG_FIELD_NUMBER);
    Descriptors.Descriptor messageType = getResult2.getMessageType();
    assertSame(file, messageType.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(DownlinkMsg.NOTIFICATIONTEMPLATEUPDATEMSG_FIELD_NUMBER);
    assertSame(file, getResult3.getMessageType().getFile());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, messageType.getOptions());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType3, getResult4.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, messageTypes.get(57));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, edgeConfiguration.getUnknownFields());
    assertSame(unknownFields, syncCompletedMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(edgeConfiguration, actualParseFromResult.getEdgeConfigurationOrBuilder());
    assertSame(edgeConfiguration, edgeConfiguration.getDefaultInstanceForType());
    assertSame(syncCompletedMsg, actualParseFromResult.getSyncCompletedMsgOrBuilder());
    assertSame(syncCompletedMsg, syncCompletedMsg.getDefaultInstanceForType());
  }
}
