package org.thingsboard.server.service.edge.rpc.constructor.tenant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.gen.edge.v1.TenantUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class TenantMsgConstructorV2DiffblueTest {
  /**
   * Test
   * {@link TenantMsgConstructorV2#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   * <ul>
   *   <li>Then return MsgTypeValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantMsgConstructorV2#constructTenantUpdateMsg(UpdateMsgType, Tenant)}
   */
  @Test
  @DisplayName("Test constructTenantUpdateMsg(UpdateMsgType, Tenant); then return MsgTypeValue is one")
  void testConstructTenantUpdateMsg_thenReturnMsgTypeValueIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantMsgConstructorV2 tenantMsgConstructorV2 = new TenantMsgConstructorV2();

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult = tenantMsgConstructorV2
        .constructTenantUpdateMsg(UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, new Tenant());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConstructTenantUpdateMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    assertEquals(1, actualConstructTenantUpdateMsgResult.getMsgTypeValue());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(17, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(17, fields.size());
    assertEquals(2, actualConstructTenantUpdateMsgResult.getAllFields().size());
    assertEquals(240, actualConstructTenantUpdateMsgResult.getSerializedSize());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(9, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(9, oneofs.size());
    assertEquals(UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, actualConstructTenantUpdateMsgResult.getMsgType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList expectedReservedNameList = toProtoResult.getReservedNameList();
    assertSame(expectedReservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult2.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult2.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options3.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, messageTypes.get(56).getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(15);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(Short.SIZE);
    assertSame(file, getResult6.getFile());
    Descriptors.OneofDescriptor getResult7 = oneofs.get(0);
    assertSame(file, getResult7.getFile());
    Descriptors.OneofDescriptor getResult8 = oneofs.get(1);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(7);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(8);
    assertSame(file, getResult10.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options5, getResult3.getOptions());
    assertSame(options5, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options2, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult6.toProto();
    assertSame(options2, toProtoResult4.getOptions());
    assertSame(options2, toProtoResult3.getOptionsOrBuilder());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, options3.getDefaultInstanceForType());
    assertSame(options2, getResult6.getOptions());
    DescriptorProtos.FieldOptions options6 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(options6, toProtoResult5.getOptions());
    assertSame(options6, toProtoResult5.getOptionsOrBuilder());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    TenantUpdateMsg defaultInstanceForType2 = actualConstructTenantUpdateMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructTenantUpdateMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult10, getResult5.getContainingOneof());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link TenantMsgConstructorV2#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   * <ul>
   *   <li>When {@link Tenant#Tenant()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantMsgConstructorV2#constructTenantUpdateMsg(UpdateMsgType, Tenant)}
   */
  @Test
  @DisplayName("Test constructTenantUpdateMsg(UpdateMsgType, Tenant); when Tenant()")
  void testConstructTenantUpdateMsg_whenTenant() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantMsgConstructorV2 tenantMsgConstructorV2 = new TenantMsgConstructorV2();

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult = tenantMsgConstructorV2
        .constructTenantUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, new Tenant());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConstructTenantUpdateMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(17, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(17, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(9, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(9, oneofs.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList expectedReservedNameList = toProtoResult.getReservedNameList();
    assertSame(expectedReservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult2.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult2.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options3.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, messageTypes.get(56).getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(15);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(Short.SIZE);
    assertSame(file, getResult6.getFile());
    Descriptors.OneofDescriptor getResult7 = oneofs.get(0);
    assertSame(file, getResult7.getFile());
    Descriptors.OneofDescriptor getResult8 = oneofs.get(1);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(7);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(8);
    assertSame(file, getResult10.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options5, getResult3.getOptions());
    assertSame(options5, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options2, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult6.toProto();
    assertSame(options2, toProtoResult4.getOptions());
    assertSame(options2, toProtoResult3.getOptionsOrBuilder());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, options3.getDefaultInstanceForType());
    assertSame(options2, getResult6.getOptions());
    DescriptorProtos.FieldOptions options6 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(options6, toProtoResult5.getOptions());
    assertSame(options6, toProtoResult5.getOptionsOrBuilder());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    TenantUpdateMsg defaultInstanceForType2 = actualConstructTenantUpdateMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructTenantUpdateMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult10, getResult5.getContainingOneof());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link TenantMsgConstructorV2#constructTenantUpdateMsg(UpdateMsgType, Tenant)}.
   * <ul>
   *   <li>When {@link Tenant#Tenant(Tenant)} with tenant is
   * {@link Tenant#Tenant()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantMsgConstructorV2#constructTenantUpdateMsg(UpdateMsgType, Tenant)}
   */
  @Test
  @DisplayName("Test constructTenantUpdateMsg(UpdateMsgType, Tenant); when Tenant(Tenant) with tenant is Tenant()")
  void testConstructTenantUpdateMsg_whenTenantWithTenantIsTenant() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantMsgConstructorV2 tenantMsgConstructorV2 = new TenantMsgConstructorV2();

    // Act
    TenantUpdateMsg actualConstructTenantUpdateMsgResult = tenantMsgConstructorV2
        .constructTenantUpdateMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, new Tenant(new Tenant()));

    // Assert
    Descriptors.Descriptor descriptorForType = actualConstructTenantUpdateMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(17, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(17, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(9, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(9, oneofs.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList expectedReservedNameList = toProtoResult.getReservedNameList();
    assertSame(expectedReservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult2.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult2.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options3.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, messageTypes.get(56).getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(15);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(Short.SIZE);
    assertSame(file, getResult6.getFile());
    Descriptors.OneofDescriptor getResult7 = oneofs.get(0);
    assertSame(file, getResult7.getFile());
    Descriptors.OneofDescriptor getResult8 = oneofs.get(1);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(7);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(8);
    assertSame(file, getResult10.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options5, getResult3.getOptions());
    assertSame(options5, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options2, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult6.toProto();
    assertSame(options2, toProtoResult4.getOptions());
    assertSame(options2, toProtoResult3.getOptionsOrBuilder());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, options3.getDefaultInstanceForType());
    assertSame(options2, getResult6.getOptions());
    DescriptorProtos.FieldOptions options6 = getResult5.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult5.toProto();
    assertSame(options6, toProtoResult5.getOptions());
    assertSame(options6, toProtoResult5.getOptionsOrBuilder());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    TenantUpdateMsg defaultInstanceForType2 = actualConstructTenantUpdateMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructTenantUpdateMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult10, getResult5.getContainingOneof());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
  }
}
