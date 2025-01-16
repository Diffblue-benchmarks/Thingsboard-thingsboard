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
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RequestMsgDiffblueTest {
  /**
   * Test {@link RequestMsg#equals(Object)}, and {@link RequestMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RequestMsg#equals(Object)}
   *   <li>{@link RequestMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RequestMsg defaultInstance = RequestMsg.getDefaultInstance();
    RequestMsg defaultInstance2 = RequestMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link RequestMsg#equals(Object)}, and {@link RequestMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RequestMsg#equals(Object)}
   *   <li>{@link RequestMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RequestMsg defaultInstance = RequestMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link RequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RequestMsg.getDefaultInstance(), 1);
  }

  /**
   * Test {@link RequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RequestMsg.getDefaultInstance(), null);
  }

  /**
   * Test {@link RequestMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RequestMsg.getDefaultInstance(), "Different type to RequestMsg");
  }

  /**
   * Test {@link RequestMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link RequestMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  void testGetDefaultInstanceForType() {
    // Arrange
    RequestMsg defaultInstance = RequestMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link RequestMsg#getMsgType()}.
   * <p>
   * Method under test: {@link RequestMsg#getMsgType()}
   */
  @Test
  @DisplayName("Test getMsgType()")
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(RequestMsgType.CONNECT_RPC_MESSAGE, RequestMsg.getDefaultInstance().getMsgType());
  }

  /**
   * Test {@link RequestMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link RequestMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, RequestMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link RequestMsg#getSyncRequestMsg()}.
   * <p>
   * Method under test: {@link RequestMsg#getSyncRequestMsg()}
   */
  @Test
  @DisplayName("Test getSyncRequestMsg()")
  void testGetSyncRequestMsg() {
    // Arrange and Act
    SyncRequestMsg actualSyncRequestMsg = RequestMsg.getDefaultInstance().getSyncRequestMsg();

    // Assert
    Descriptors.Descriptor descriptorForType = actualSyncRequestMsg.getDescriptorForType();
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
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    Descriptors.OneofDescriptor getResult3 = oneofs.get(0);
    DescriptorProtos.OneofOptions options5 = getResult3.getOptions();
    assertEquals("", options5.getInitializationErrorString());
    DescriptorProtos.OneofDescriptorProto toProtoResult7 = getResult3.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", actualSyncRequestMsg.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", defaultInstanceForType2.getSyntax());
    assertEquals("", defaultInstanceForType3.getCsharpNamespace());
    assertEquals("", options.getCsharpNamespace());
    assertEquals("", defaultInstanceForType3.getGoPackage());
    assertEquals("", options.getGoPackage());
    assertEquals("", defaultInstanceForType3.getJavaOuterClassname());
    assertEquals("", defaultInstanceForType3.getJavaPackage());
    assertEquals("", defaultInstanceForType3.getObjcClassPrefix());
    assertEquals("", options.getObjcClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpClassPrefix());
    assertEquals("", options.getPhpClassPrefix());
    assertEquals("", defaultInstanceForType3.getPhpMetadataNamespace());
    assertEquals("", options.getPhpMetadataNamespace());
    assertEquals("", defaultInstanceForType3.getPhpNamespace());
    assertEquals("", options.getPhpNamespace());
    assertEquals("", defaultInstanceForType3.getRubyPackage());
    assertEquals("", options.getRubyPackage());
    assertEquals("", defaultInstanceForType3.getSwiftPrefix());
    assertEquals("", options.getSwiftPrefix());
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult4 = dependencies.get(0);
    assertEquals("", getResult4.getEditionName());
    assertEquals("DescriptorProto", descriptorForType3.getName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    Descriptors.Descriptor getResult5 = messageTypes.get(57);
    assertEquals("DownlinkMsg", getResult5.getName());
    Descriptors.Descriptor getResult6 = messageTypes.get(56);
    assertEquals("DownlinkResponseMsg", getResult6.getName());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    Descriptors.EnumDescriptor getResult7 = enumTypes.get(4);
    assertEquals("EdgeEntityType", getResult7.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("EdgeProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("EdgeProtos", options.getJavaOuterClassname());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    Descriptors.ServiceDescriptor getResult8 = services.get(0);
    assertEquals("EdgeRpcService", getResult8.getName());
    Descriptors.EnumDescriptor getResult9 = enumTypes.get(0);
    assertEquals("EdgeVersion", getResult9.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    Descriptors.Descriptor getResult10 = messageTypes.get(0);
    assertEquals("RequestMsg", getResult10.getName());
    Descriptors.EnumDescriptor getResult11 = enumTypes.get(1);
    assertEquals("RequestMsgType", getResult11.getName());
    Descriptors.Descriptor getResult12 = messageTypes.get(1);
    assertEquals("ResponseMsg", getResult12.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("SyncRequestMsg", nameBytes.toStringUtf8());
    assertEquals("SyncRequestMsg", toProtoResult.getName());
    assertEquals("SyncRequestMsg", descriptorForType.getName());
    Descriptors.EnumDescriptor getResult13 = enumTypes.get(3);
    assertEquals("UpdateMsgType", getResult13.getName());
    assertEquals("_fullSync", toProtoResult7.getName());
    assertEquals("_fullSync", getResult3.getName());
    ByteString packageBytes = toProtoResult2.getPackageBytes();
    assertEquals("edge", packageBytes.toStringUtf8());
    assertEquals("edge", toProtoResult2.getPackage());
    assertEquals("edge", file.getPackage());
    assertEquals("edge.DownlinkMsg", getResult5.getFullName());
    assertEquals("edge.DownlinkResponseMsg", getResult6.getFullName());
    assertEquals("edge.EdgeEntityType", getResult7.getFullName());
    assertEquals("edge.EdgeVersion", getResult9.getFullName());
    assertEquals("edge.RequestMsg", getResult10.getFullName());
    assertEquals("edge.RequestMsgType", getResult11.getFullName());
    assertEquals("edge.ResponseMsg", getResult12.getFullName());
    assertEquals("edge.SyncRequestMsg", descriptorForType.getFullName());
    assertEquals("edge.SyncRequestMsg._fullSync", getResult3.getFullName());
    assertEquals("edge.SyncRequestMsg.fullSync", getResult2.getFullName());
    assertEquals("edge.SyncRequestMsg.syncRequired", getResult.getFullName());
    assertEquals("edge.UpdateMsgType", getResult13.getFullName());
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("edge.proto", nameBytes2.toStringUtf8());
    assertEquals("edge.proto", toProtoResult2.getName());
    assertEquals("edge.proto", file.getFullName());
    assertEquals("edge.proto", file.getName());
    assertEquals("fullSync", toProtoResult6.getName());
    assertEquals("fullSync", getResult2.getJsonName());
    assertEquals("fullSync", getResult2.getName());
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
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("queue.proto", getResult4.getFullName());
    assertEquals("queue.proto", getResult4.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("queue.proto", dependencyList.get(0));
    assertEquals("syncRequired", toProtoResult5.getName());
    assertEquals("syncRequired", getResult.getJsonName());
    assertEquals("syncRequired", getResult.getName());
    assertEquals("transport", getResult4.getPackage());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult10.getContainingType());
    assertNull(getResult12.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(getResult5.getContainingType());
    assertNull(getResult9.getContainingType());
    assertNull(getResult11.getContainingType());
    assertNull(getResult13.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
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
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options4.getEditionDefaultsCount());
    assertEquals(0, options4.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options4.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, options5.getSerializedSize());
    assertEquals(0, options5.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, getResult10.getIndex());
    assertEquals(0, getResult9.getIndex());
    assertEquals(0, getResult.getIndex());
    assertEquals(0, getResult3.getIndex());
    assertEquals(0, getResult8.getIndex());
    UnknownFieldSet unknownFields = actualSyncRequestMsg.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualSyncRequestMsg.getSerializedSize());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult.getOneofDeclCount());
    assertEquals(1, toProtoResult5.getNumber());
    assertEquals(1, toProtoResult2.getDependencyCount());
    assertEquals(1, toProtoResult2.getServiceCount());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, getResult12.getIndex());
    assertEquals(1, getResult11.getIndex());
    assertEquals(1, getResult2.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(1, getResult3.getFieldCount());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<DescriptorProtos.ServiceDescriptorProto> serviceList = toProtoResult2.getServiceList();
    assertEquals(1, serviceList.size());
    List<Descriptors.FieldDescriptor> fields2 = getResult3.getFields();
    assertEquals(1, fields2.size());
    assertEquals(17264, toProtoResult2.getSerializedSize());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, toProtoResult6.getNumber());
    assertEquals(2, options3.getSerializedSize());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult2.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(2, descriptorForType3.getNestedTypes().size());
    assertEquals(3, getResult13.getIndex());
    assertEquals(3, toProtoResult.getAllFields().size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(3, allFields.size());
    assertEquals(4, getResult7.getIndex());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult2.getEnumTypeCount());
    assertEquals(5, descriptorForType.getIndex());
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(5, enumTypeList.size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(56, getResult6.getIndex());
    assertEquals(57, getResult5.getIndex());
    assertEquals(58, toProtoResult2.getMessageTypeCount());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(58, messageTypeList.size());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(78, toProtoResult.getSerializedSize());
    assertEquals(8, toProtoResult2.getAllFields().size());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult4.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options4.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options4.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options4.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult4.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.BOOL, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult2.getLiteJavaType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options4.getDebugRedact());
    assertFalse(options4.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options4.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options4.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options4.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options4.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options4.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options4.hasDebugRedact());
    assertFalse(options4.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options4.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options4.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options4.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options4.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options4.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options4.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(options4.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(defaultInstanceForType2.hasSourceCodeInfo());
    assertFalse(toProtoResult2.hasSourceCodeInfo());
    assertFalse(defaultInstanceForType2.hasSyntax());
    assertFalse(defaultInstanceForType3.getCcGenericServices());
    assertFalse(options.getCcGenericServices());
    assertFalse(defaultInstanceForType3.getDeprecated());
    assertFalse(options.getDeprecated());
    assertFalse(defaultInstanceForType3.getJavaGenerateEqualsAndHash());
    assertFalse(options.getJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.getJavaGenericServices());
    assertFalse(options.getJavaGenericServices());
    assertFalse(defaultInstanceForType3.getJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.getJavaStringCheckUtf8());
    assertFalse(options.getJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.getPhpGenericServices());
    assertFalse(options.getPhpGenericServices());
    assertFalse(defaultInstanceForType3.getPyGenericServices());
    assertFalse(options.getPyGenericServices());
    assertFalse(defaultInstanceForType3.hasCcEnableArenas());
    assertFalse(options.hasCcEnableArenas());
    assertFalse(defaultInstanceForType3.hasCcGenericServices());
    assertFalse(options.hasCcGenericServices());
    assertFalse(defaultInstanceForType3.hasCsharpNamespace());
    assertFalse(options.hasCsharpNamespace());
    assertFalse(defaultInstanceForType3.hasDeprecated());
    assertFalse(options.hasDeprecated());
    assertFalse(defaultInstanceForType3.hasFeatures());
    assertFalse(options.hasFeatures());
    assertFalse(defaultInstanceForType3.hasGoPackage());
    assertFalse(options.hasGoPackage());
    assertFalse(defaultInstanceForType3.hasJavaGenerateEqualsAndHash());
    assertFalse(options.hasJavaGenerateEqualsAndHash());
    assertFalse(defaultInstanceForType3.hasJavaGenericServices());
    assertFalse(options.hasJavaGenericServices());
    assertFalse(defaultInstanceForType3.hasJavaMultipleFiles());
    assertFalse(defaultInstanceForType3.hasJavaOuterClassname());
    assertFalse(defaultInstanceForType3.hasJavaPackage());
    assertFalse(defaultInstanceForType3.hasJavaStringCheckUtf8());
    assertFalse(options.hasJavaStringCheckUtf8());
    assertFalse(defaultInstanceForType3.hasObjcClassPrefix());
    assertFalse(options.hasObjcClassPrefix());
    assertFalse(defaultInstanceForType3.hasOptimizeFor());
    assertFalse(options.hasOptimizeFor());
    assertFalse(defaultInstanceForType3.hasPhpClassPrefix());
    assertFalse(options.hasPhpClassPrefix());
    assertFalse(defaultInstanceForType3.hasPhpGenericServices());
    assertFalse(options.hasPhpGenericServices());
    assertFalse(defaultInstanceForType3.hasPhpMetadataNamespace());
    assertFalse(options.hasPhpMetadataNamespace());
    assertFalse(defaultInstanceForType3.hasPhpNamespace());
    assertFalse(options.hasPhpNamespace());
    assertFalse(defaultInstanceForType3.hasPyGenericServices());
    assertFalse(options.hasPyGenericServices());
    assertFalse(defaultInstanceForType3.hasRubyPackage());
    assertFalse(options.hasRubyPackage());
    assertFalse(defaultInstanceForType3.hasSwiftPrefix());
    assertFalse(options.hasSwiftPrefix());
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
    assertFalse(toProtoResult7.hasOptions());
    assertFalse(options5.hasFeatures());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult10.isExtendable());
    assertFalse(getResult12.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(getResult5.isExtendable());
    assertFalse(getResult9.isClosed());
    assertFalse(getResult11.isClosed());
    assertFalse(getResult13.isClosed());
    assertFalse(getResult7.isClosed());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult.isPackable());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertFalse(actualSyncRequestMsg.getFullSync());
    assertFalse(actualSyncRequestMsg.getSyncRequired());
    assertFalse(actualSyncRequestMsg.hasFullSync());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult6.getProto3Optional());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult6.hasOneofIndex());
    assertTrue(toProtoResult5.hasOptions());
    assertTrue(toProtoResult6.hasProto3Optional());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.getDeprecated());
    assertTrue(options3.hasDeprecated());
    assertTrue(options3.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasPackage());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.getJavaMultipleFiles());
    assertTrue(options.hasJavaMultipleFiles());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(options5.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult2.hasOptionalKeyword());
    assertTrue(getResult2.hasPresence());
    assertTrue(getResult.isOptional());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isSynthetic());
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
    List<String> findInitializationErrorsResult = actualSyncRequestMsg.findInitializationErrors();
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
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType3.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType3.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType3.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualSyncRequestMsg.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualSyncRequestMsg.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, options4.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult10.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult12.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult10.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult12.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult10.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult12.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult10.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult12.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult10.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult12.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult4.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult4.getExtensions());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult4.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult4.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options4.getAllFields());
    assertEquals(allFields2, options5.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options4.getAllFieldsRaw());
    assertEquals(allFields2, options5.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(AlarmUpdateMsg.ENDTS_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(AlarmUpdateMsg.ENDTS_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(AlarmUpdateMsg.STARTTS_FIELD_NUMBER, toProtoResult4.getFieldCount());
    assertEquals(AlarmUpdateMsg.STARTTS_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals(AlarmUpdateMsg.STARTTS_FIELD_NUMBER, descriptorForType3.getFields().size());
    assertEquals(DeviceProfileUpdateMsg.DEFAULTDASHBOARDIDLSB_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(DeviceProfileUpdateMsg.SOFTWAREIDLSB_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(DownlinkMsg.ASSETPROFILEUPDATEMSG_FIELD_NUMBER, toProtoResult5.getSerializedSize());
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(serviceList, toProtoResult2.getServiceOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
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
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options5.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options5.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(file, getResult10.getFile());
    assertSame(file, getResult12.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult9.getFile());
    assertSame(file, getResult11.getFile());
    assertSame(file, getResult13.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options6 = descriptorForType2.getOptions();
    assertSame(options6, defaultInstanceForType.getOptions());
    assertSame(options6, toProtoResult3.getOptions());
    assertSame(options6, toProtoResult.getOptions());
    assertSame(options6, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options6, toProtoResult3.getOptionsOrBuilder());
    assertSame(options6, toProtoResult.getOptionsOrBuilder());
    assertSame(options6, descriptorForType4.getOptions());
    assertSame(options6, options6);
    assertSame(options6, descriptorForType3.getOptions());
    assertSame(options6, descriptorForType6.getOptions());
    assertSame(options6, descriptorForType5.getOptions());
    assertSame(options6, getResult10.getOptions());
    assertSame(options6, getResult12.getOptions());
    assertSame(options6, getResult6.getOptions());
    assertSame(options6, getResult5.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options5, toProtoResult7.getOptions());
    assertSame(options5, toProtoResult7.getOptionsOrBuilder());
    assertSame(options5, options5.getDefaultInstanceForType());
    assertSame(toProtoResult7, oneofDeclList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult2, fields2.get(0));
    assertSame(getResult3, getResult2.getContainingOneof());
    assertSame(actualSyncRequestMsg, actualSyncRequestMsg.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
  }

  /**
   * Test {@link RequestMsg#hasConnectRequestMsg()}.
   * <p>
   * Method under test: {@link RequestMsg#hasConnectRequestMsg()}
   */
  @Test
  @DisplayName("Test hasConnectRequestMsg()")
  void testHasConnectRequestMsg() {
    // Arrange, Act and Assert
    assertFalse(RequestMsg.getDefaultInstance().hasConnectRequestMsg());
  }

  /**
   * Test {@link RequestMsg#hasDownlinkResponseMsg()}.
   * <p>
   * Method under test: {@link RequestMsg#hasDownlinkResponseMsg()}
   */
  @Test
  @DisplayName("Test hasDownlinkResponseMsg()")
  void testHasDownlinkResponseMsg() {
    // Arrange, Act and Assert
    assertFalse(RequestMsg.getDefaultInstance().hasDownlinkResponseMsg());
  }

  /**
   * Test {@link RequestMsg#hasSyncRequestMsg()}.
   * <p>
   * Method under test: {@link RequestMsg#hasSyncRequestMsg()}
   */
  @Test
  @DisplayName("Test hasSyncRequestMsg()")
  void testHasSyncRequestMsg() {
    // Arrange, Act and Assert
    assertFalse(RequestMsg.getDefaultInstance().hasSyncRequestMsg());
  }

  /**
   * Test {@link RequestMsg#hasUplinkMsg()}.
   * <p>
   * Method under test: {@link RequestMsg#hasUplinkMsg()}
   */
  @Test
  @DisplayName("Test hasUplinkMsg()")
  void testHasUplinkMsg() {
    // Arrange, Act and Assert
    assertFalse(RequestMsg.getDefaultInstance().hasUplinkMsg());
  }

  /**
   * Test {@link RequestMsg#isInitialized()}.
   * <p>
   * Method under test: {@link RequestMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(RequestMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link RequestMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link RequestMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test newInstance(UnusedPrivateParameter)")
  void testNewInstance() {
    // Arrange
    RequestMsg defaultInstance = RequestMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof RequestMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test {@link RequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link RequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'")
  void testParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RequestMsg actualParseDelimitedFromResult = RequestMsg.parseDelimitedFrom(input);

    // Assert
    ConnectRequestMsg connectRequestMsg = actualParseDelimitedFromResult.getConnectRequestMsg();
    UnknownFieldSet unknownFields = connectRequestMsg.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = connectRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    DownlinkResponseMsg downlinkResponseMsg = actualParseDelimitedFromResult.getDownlinkResponseMsg();
    Descriptors.Descriptor descriptorForType3 = downlinkResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    SyncRequestMsg syncRequestMsg = actualParseDelimitedFromResult.getSyncRequestMsg();
    Descriptors.Descriptor descriptorForType4 = syncRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    UplinkMsg uplinkMsg = actualParseDelimitedFromResult.getUplinkMsg();
    Descriptors.Descriptor descriptorForType5 = uplinkMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult6 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult6.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult6.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(3);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(3);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(4);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    DescriptorProtos.MessageOptions options3 = options.getDescriptorForType().getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(1));
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options4, getResult8.getOptions());
    assertSame(options2, toProtoResult6.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getMessageType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(56));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    RequestMsg defaultInstanceForType2 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType2, defaultInstanceForType2.getDescriptorForType());
    assertSame(descriptorForType2, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, downlinkResponseMsg.getUnknownFields());
    assertSame(unknownFields, syncRequestMsg.getUnknownFields());
    assertSame(unknownFields, uplinkMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    Descriptors.EnumDescriptor expectedEnumType = enumTypes.get(0);
    assertSame(expectedEnumType, getResult4.getEnumType());
    assertSame(getResult9, getResult5.getContainingOneof());
    assertSame(connectRequestMsg, connectRequestMsg.getDefaultInstanceForType());
    assertSame(connectRequestMsg, defaultInstanceForType2.getConnectRequestMsg());
    assertSame(connectRequestMsg, defaultInstanceForType2.getConnectRequestMsgOrBuilder());
    assertSame(connectRequestMsg, actualParseDelimitedFromResult.getConnectRequestMsgOrBuilder());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(downlinkResponseMsg, downlinkResponseMsg.getDefaultInstanceForType());
    assertSame(downlinkResponseMsg, defaultInstanceForType2.getDownlinkResponseMsg());
    assertSame(downlinkResponseMsg, defaultInstanceForType2.getDownlinkResponseMsgOrBuilder());
    assertSame(downlinkResponseMsg, actualParseDelimitedFromResult.getDownlinkResponseMsgOrBuilder());
    assertSame(syncRequestMsg, defaultInstanceForType2.getSyncRequestMsg());
    assertSame(syncRequestMsg, defaultInstanceForType2.getSyncRequestMsgOrBuilder());
    assertSame(syncRequestMsg, actualParseDelimitedFromResult.getSyncRequestMsgOrBuilder());
    assertSame(syncRequestMsg, syncRequestMsg.getDefaultInstanceForType());
    assertSame(uplinkMsg, defaultInstanceForType2.getUplinkMsg());
    assertSame(uplinkMsg, defaultInstanceForType2.getUplinkMsgOrBuilder());
    assertSame(uplinkMsg, actualParseDelimitedFromResult.getUplinkMsgOrBuilder());
    assertSame(uplinkMsg, uplinkMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link RequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link RequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'")
  void testParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RequestMsg actualParseDelimitedFromResult = RequestMsg.parseDelimitedFrom(input);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options = getResult.getOptions();
    assertEquals(0, options.getEditionDefaultsCount());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    ConnectRequestMsg connectRequestMsg = actualParseDelimitedFromResult.getConnectRequestMsg();
    Descriptors.Descriptor descriptorForType2 = connectRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType2.getOneofs();
    assertEquals(1, oneofs.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(4, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertFalse(options.getDeprecated());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    DownlinkResponseMsg downlinkResponseMsg = actualParseDelimitedFromResult.getDownlinkResponseMsg();
    Descriptors.Descriptor descriptorForType3 = downlinkResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    SyncRequestMsg syncRequestMsg = actualParseDelimitedFromResult.getSyncRequestMsg();
    Descriptors.Descriptor descriptorForType4 = syncRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    UplinkMsg uplinkMsg = actualParseDelimitedFromResult.getUplinkMsg();
    Descriptors.Descriptor descriptorForType5 = uplinkMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult6 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult6.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult6.getWeakDependencyList());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields2.get(2);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(3);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(3);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(1));
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options, getResult2.getOptions());
    assertSame(options, getResult3.getOptions());
    assertSame(options, getResult4.getOptions());
    assertSame(options, getResult5.getOptions());
    assertSame(options, getResult6.getOptions());
    assertSame(options, getResult7.getOptions());
    assertSame(options, getResult8.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult2.getContainingType());
    assertSame(descriptorForType2, getResult3.getContainingType());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getMessageType());
    assertSame(descriptorForType2, getResult9.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(56));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, connectRequestMsg.getUnknownFields());
    assertSame(unknownFields, downlinkResponseMsg.getUnknownFields());
    assertSame(unknownFields, syncRequestMsg.getUnknownFields());
    assertSame(unknownFields, uplinkMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    Descriptors.EnumDescriptor expectedEnumType = enumTypes.get(0);
    assertSame(expectedEnumType, getResult4.getEnumType());
    assertSame(getResult9, getResult5.getContainingOneof());
    assertSame(connectRequestMsg, connectRequestMsg.getDefaultInstanceForType());
    assertSame(connectRequestMsg, actualParseDelimitedFromResult.getConnectRequestMsgOrBuilder());
    assertSame(downlinkResponseMsg, downlinkResponseMsg.getDefaultInstanceForType());
    assertSame(downlinkResponseMsg, actualParseDelimitedFromResult.getDownlinkResponseMsgOrBuilder());
    assertSame(syncRequestMsg, actualParseDelimitedFromResult.getSyncRequestMsgOrBuilder());
    assertSame(syncRequestMsg, syncRequestMsg.getDefaultInstanceForType());
    assertSame(uplinkMsg, actualParseDelimitedFromResult.getUplinkMsgOrBuilder());
    assertSame(uplinkMsg, uplinkMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link RequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link RequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RequestMsg actualParseDelimitedFromResult = RequestMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    ConnectRequestMsg connectRequestMsg = actualParseDelimitedFromResult.getConnectRequestMsg();
    UnknownFieldSet unknownFields = connectRequestMsg.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = connectRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    DownlinkResponseMsg downlinkResponseMsg = actualParseDelimitedFromResult.getDownlinkResponseMsg();
    Descriptors.Descriptor descriptorForType3 = downlinkResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    SyncRequestMsg syncRequestMsg = actualParseDelimitedFromResult.getSyncRequestMsg();
    Descriptors.Descriptor descriptorForType4 = syncRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    UplinkMsg uplinkMsg = actualParseDelimitedFromResult.getUplinkMsg();
    Descriptors.Descriptor descriptorForType5 = uplinkMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult6 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult6.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult6.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(3);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(3);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(4);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    DescriptorProtos.MessageOptions options3 = options.getDescriptorForType().getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(1));
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options4, getResult8.getOptions());
    assertSame(options2, toProtoResult6.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getMessageType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(56));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    RequestMsg defaultInstanceForType2 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType2, defaultInstanceForType2.getDescriptorForType());
    assertSame(descriptorForType2, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, downlinkResponseMsg.getUnknownFields());
    assertSame(unknownFields, syncRequestMsg.getUnknownFields());
    assertSame(unknownFields, uplinkMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    Descriptors.EnumDescriptor expectedEnumType = enumTypes.get(0);
    assertSame(expectedEnumType, getResult4.getEnumType());
    assertSame(getResult9, getResult5.getContainingOneof());
    assertSame(connectRequestMsg, connectRequestMsg.getDefaultInstanceForType());
    assertSame(connectRequestMsg, defaultInstanceForType2.getConnectRequestMsg());
    assertSame(connectRequestMsg, defaultInstanceForType2.getConnectRequestMsgOrBuilder());
    assertSame(connectRequestMsg, actualParseDelimitedFromResult.getConnectRequestMsgOrBuilder());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(downlinkResponseMsg, downlinkResponseMsg.getDefaultInstanceForType());
    assertSame(downlinkResponseMsg, defaultInstanceForType2.getDownlinkResponseMsg());
    assertSame(downlinkResponseMsg, defaultInstanceForType2.getDownlinkResponseMsgOrBuilder());
    assertSame(downlinkResponseMsg, actualParseDelimitedFromResult.getDownlinkResponseMsgOrBuilder());
    assertSame(syncRequestMsg, defaultInstanceForType2.getSyncRequestMsg());
    assertSame(syncRequestMsg, defaultInstanceForType2.getSyncRequestMsgOrBuilder());
    assertSame(syncRequestMsg, actualParseDelimitedFromResult.getSyncRequestMsgOrBuilder());
    assertSame(syncRequestMsg, syncRequestMsg.getDefaultInstanceForType());
    assertSame(uplinkMsg, defaultInstanceForType2.getUplinkMsg());
    assertSame(uplinkMsg, defaultInstanceForType2.getUplinkMsgOrBuilder());
    assertSame(uplinkMsg, actualParseDelimitedFromResult.getUplinkMsgOrBuilder());
    assertSame(uplinkMsg, uplinkMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link RequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link RequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    RequestMsg actualParseDelimitedFromResult = RequestMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options = getResult.getOptions();
    assertEquals(0, options.getEditionDefaultsCount());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    ConnectRequestMsg connectRequestMsg = actualParseDelimitedFromResult.getConnectRequestMsg();
    Descriptors.Descriptor descriptorForType2 = connectRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType2.getOneofs();
    assertEquals(1, oneofs.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(4, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertFalse(options.getDeprecated());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    DownlinkResponseMsg downlinkResponseMsg = actualParseDelimitedFromResult.getDownlinkResponseMsg();
    Descriptors.Descriptor descriptorForType3 = downlinkResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    SyncRequestMsg syncRequestMsg = actualParseDelimitedFromResult.getSyncRequestMsg();
    Descriptors.Descriptor descriptorForType4 = syncRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    UplinkMsg uplinkMsg = actualParseDelimitedFromResult.getUplinkMsg();
    Descriptors.Descriptor descriptorForType5 = uplinkMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult6 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult6.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult6.getWeakDependencyList());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields2.get(2);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(3);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(3);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(4);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(1));
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options, getResult2.getOptions());
    assertSame(options, getResult3.getOptions());
    assertSame(options, getResult4.getOptions());
    assertSame(options, getResult5.getOptions());
    assertSame(options, getResult6.getOptions());
    assertSame(options, getResult7.getOptions());
    assertSame(options, getResult8.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult2.getContainingType());
    assertSame(descriptorForType2, getResult3.getContainingType());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getMessageType());
    assertSame(descriptorForType2, getResult9.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(56));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, connectRequestMsg.getUnknownFields());
    assertSame(unknownFields, downlinkResponseMsg.getUnknownFields());
    assertSame(unknownFields, syncRequestMsg.getUnknownFields());
    assertSame(unknownFields, uplinkMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    Descriptors.EnumDescriptor expectedEnumType = enumTypes.get(0);
    assertSame(expectedEnumType, getResult4.getEnumType());
    assertSame(getResult9, getResult5.getContainingOneof());
    assertSame(connectRequestMsg, connectRequestMsg.getDefaultInstanceForType());
    assertSame(connectRequestMsg, actualParseDelimitedFromResult.getConnectRequestMsgOrBuilder());
    assertSame(downlinkResponseMsg, downlinkResponseMsg.getDefaultInstanceForType());
    assertSame(downlinkResponseMsg, actualParseDelimitedFromResult.getDownlinkResponseMsgOrBuilder());
    assertSame(syncRequestMsg, actualParseDelimitedFromResult.getSyncRequestMsgOrBuilder());
    assertSame(syncRequestMsg, syncRequestMsg.getDefaultInstanceForType());
    assertSame(uplinkMsg, actualParseDelimitedFromResult.getUplinkMsgOrBuilder());
    assertSame(uplinkMsg, uplinkMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link RequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link RequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> RequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link RequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test
   * {@link RequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequestMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> RequestMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> RequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(RequestMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link RequestMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsg#parseDelimitedFrom(InputStream)}
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
    assertThrows(InvalidProtocolBufferException.class, () -> RequestMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link RequestMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link RequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
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
        () -> RequestMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RequestMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequestMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RequestMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RequestMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> RequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RequestMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> RequestMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link RequestMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty
   * array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    RequestMsg actualParseFromResult = RequestMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    ConnectRequestMsg connectRequestMsg = actualParseFromResult.getConnectRequestMsg();
    Descriptors.Descriptor descriptorForType = connectRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.Descriptor descriptorForType2 = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    DownlinkResponseMsg downlinkResponseMsg = actualParseFromResult.getDownlinkResponseMsg();
    Descriptors.Descriptor descriptorForType3 = downlinkResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    SyncRequestMsg syncRequestMsg = actualParseFromResult.getSyncRequestMsg();
    Descriptors.Descriptor descriptorForType4 = syncRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    UplinkMsg uplinkMsg = actualParseFromResult.getUplinkMsg();
    Descriptors.Descriptor descriptorForType5 = uplinkMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult6 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult6.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult6.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(3);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(3);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(4);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    DescriptorProtos.MessageOptions options3 = options.getDescriptorForType().getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(1));
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options4, getResult8.getOptions());
    assertSame(options2, toProtoResult6.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getMessageType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(56));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(0));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, connectRequestMsg.getUnknownFields());
    assertSame(unknownFields, downlinkResponseMsg.getUnknownFields());
    assertSame(unknownFields, syncRequestMsg.getUnknownFields());
    assertSame(unknownFields, uplinkMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    Descriptors.EnumDescriptor expectedEnumType = enumTypes.get(0);
    assertSame(expectedEnumType, getResult4.getEnumType());
    assertSame(getResult9, getResult5.getContainingOneof());
    assertSame(connectRequestMsg, connectRequestMsg.getDefaultInstanceForType());
    assertSame(connectRequestMsg, actualParseFromResult.getConnectRequestMsgOrBuilder());
    assertSame(downlinkResponseMsg, downlinkResponseMsg.getDefaultInstanceForType());
    assertSame(downlinkResponseMsg, actualParseFromResult.getDownlinkResponseMsgOrBuilder());
    assertSame(syncRequestMsg, actualParseFromResult.getSyncRequestMsgOrBuilder());
    assertSame(syncRequestMsg, syncRequestMsg.getDefaultInstanceForType());
    assertSame(uplinkMsg, actualParseFromResult.getUplinkMsgOrBuilder());
    assertSame(uplinkMsg, uplinkMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link RequestMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RequestMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    RequestMsg actualParseFromResult = RequestMsg.parseFrom((InputStream) null);

    // Assert
    ConnectRequestMsg connectRequestMsg = actualParseFromResult.getConnectRequestMsg();
    Descriptors.Descriptor descriptorForType = connectRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.Descriptor descriptorForType2 = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    DownlinkResponseMsg downlinkResponseMsg = actualParseFromResult.getDownlinkResponseMsg();
    Descriptors.Descriptor descriptorForType3 = downlinkResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    SyncRequestMsg syncRequestMsg = actualParseFromResult.getSyncRequestMsg();
    Descriptors.Descriptor descriptorForType4 = syncRequestMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    UplinkMsg uplinkMsg = actualParseFromResult.getUplinkMsg();
    Descriptors.Descriptor descriptorForType5 = uplinkMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult6 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult6.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult6.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(3);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(3);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(4);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    DescriptorProtos.MessageOptions options3 = options.getDescriptorForType().getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(1));
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options4, getResult8.getOptions());
    assertSame(options2, toProtoResult6.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getMessageType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(56));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(0));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, connectRequestMsg.getUnknownFields());
    assertSame(unknownFields, downlinkResponseMsg.getUnknownFields());
    assertSame(unknownFields, syncRequestMsg.getUnknownFields());
    assertSame(unknownFields, uplinkMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    Descriptors.EnumDescriptor expectedEnumType = enumTypes.get(0);
    assertSame(expectedEnumType, getResult4.getEnumType());
    assertSame(getResult9, getResult5.getContainingOneof());
    assertSame(connectRequestMsg, connectRequestMsg.getDefaultInstanceForType());
    assertSame(connectRequestMsg, actualParseFromResult.getConnectRequestMsgOrBuilder());
    assertSame(downlinkResponseMsg, downlinkResponseMsg.getDefaultInstanceForType());
    assertSame(downlinkResponseMsg, actualParseFromResult.getDownlinkResponseMsgOrBuilder());
    assertSame(syncRequestMsg, actualParseFromResult.getSyncRequestMsgOrBuilder());
    assertSame(syncRequestMsg, syncRequestMsg.getDefaultInstanceForType());
    assertSame(uplinkMsg, actualParseFromResult.getUplinkMsgOrBuilder());
    assertSame(uplinkMsg, uplinkMsg.getDefaultInstanceForType());
  }
}
