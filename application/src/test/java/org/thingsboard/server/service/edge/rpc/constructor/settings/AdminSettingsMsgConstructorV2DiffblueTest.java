package org.thingsboard.server.service.edge.rpc.constructor.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.gen.edge.v1.AdminSettingsUpdateMsg;

class AdminSettingsMsgConstructorV2DiffblueTest {
  /**
   * Test
   * {@link AdminSettingsMsgConstructorV2#constructAdminSettingsUpdateMsg(AdminSettings)}.
   * <p>
   * Method under test:
   * {@link AdminSettingsMsgConstructorV2#constructAdminSettingsUpdateMsg(AdminSettings)}
   */
  @Test
  @DisplayName("Test constructAdminSettingsUpdateMsg(AdminSettings)")
  void testConstructAdminSettingsUpdateMsg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsMsgConstructorV2 adminSettingsMsgConstructorV2 = new AdminSettingsMsgConstructorV2();

    // Act
    AdminSettingsUpdateMsg actualConstructAdminSettingsUpdateMsgResult = adminSettingsMsgConstructorV2
        .constructAdminSettingsUpdateMsg(new AdminSettings(new AdminSettings()));

    // Assert
    Descriptors.Descriptor descriptorForType = actualConstructAdminSettingsUpdateMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options = getResult.getOptions();
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldOptions options2 = getResult2.getOptions();
    assertEquals(options, options2);
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldOptions options3 = getResult3.getOptions();
    assertEquals(options, options3);
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList expectedReservedNameList = toProtoResult.getReservedNameList();
    assertSame(expectedReservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult2.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult2.getWeakDependencyList());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options5 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options5.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, options.getFeatures());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldOptions options6 = getResult4.getOptions();
    assertSame(features, options6.getFeatures());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options6.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType2.getFeatures());
    assertSame(features, options4.getFeatures());
    assertSame(features, defaultInstanceForType2.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options5.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.Descriptor getResult7 = messageTypes.get(56);
    assertSame(file, getResult7.getFile());
    Descriptors.Descriptor getResult8 = messageTypes.get(57);
    assertSame(file, getResult8.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options7 = options5.getDescriptorForType().getOptions();
    assertSame(options7, defaultInstanceForType.getOptions());
    assertSame(options7, toProtoResult.getOptions());
    assertSame(options7, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options7, toProtoResult.getOptionsOrBuilder());
    assertSame(options7, options7);
    assertSame(options7, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options7, options4.getDescriptorForType().getOptions());
    assertSame(options7, getResult5.getOptions());
    assertSame(options7, getResult6.getOptions());
    assertSame(options7, getResult7.getOptions());
    assertSame(options7, getResult8.getOptions());
    assertSame(options5, options5.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult2.toProto();
    assertSame(options2, toProtoResult4.getOptions());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options6, options6.getDefaultInstanceForType());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    AdminSettingsUpdateMsg defaultInstanceForType3 = actualConstructAdminSettingsUpdateMsgResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType3.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructAdminSettingsUpdateMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, options6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult4.toProto().getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link AdminSettingsMsgConstructorV2#constructAdminSettingsUpdateMsg(AdminSettings)}.
   * <ul>
   *   <li>Then return SerializedSize is one hundred fourteen.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSettingsMsgConstructorV2#constructAdminSettingsUpdateMsg(AdminSettings)}
   */
  @Test
  @DisplayName("Test constructAdminSettingsUpdateMsg(AdminSettings); then return SerializedSize is one hundred fourteen")
  void testConstructAdminSettingsUpdateMsg_thenReturnSerializedSizeIsOneHundredFourteen() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsMsgConstructorV2 adminSettingsMsgConstructorV2 = new AdminSettingsMsgConstructorV2();

    // Act
    AdminSettingsUpdateMsg actualConstructAdminSettingsUpdateMsgResult = adminSettingsMsgConstructorV2
        .constructAdminSettingsUpdateMsg(new AdminSettings(new AdminSettingsId(UUID.randomUUID())));

    // Assert
    Descriptors.Descriptor descriptorForType = actualConstructAdminSettingsUpdateMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    assertEquals(114, actualConstructAdminSettingsUpdateMsgResult.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options = getResult.getOptions();
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldOptions options2 = getResult2.getOptions();
    assertEquals(options, options2);
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldOptions options3 = getResult3.getOptions();
    assertEquals(options, options3);
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList expectedReservedNameList = toProtoResult.getReservedNameList();
    assertSame(expectedReservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult2.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult2.getWeakDependencyList());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options5 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options5.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, options.getFeatures());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldOptions options6 = getResult4.getOptions();
    assertSame(features, options6.getFeatures());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options6.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType2.getFeatures());
    assertSame(features, options4.getFeatures());
    assertSame(features, defaultInstanceForType2.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options5.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.Descriptor getResult7 = messageTypes.get(56);
    assertSame(file, getResult7.getFile());
    Descriptors.Descriptor getResult8 = messageTypes.get(57);
    assertSame(file, getResult8.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options7 = options5.getDescriptorForType().getOptions();
    assertSame(options7, defaultInstanceForType.getOptions());
    assertSame(options7, toProtoResult.getOptions());
    assertSame(options7, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options7, toProtoResult.getOptionsOrBuilder());
    assertSame(options7, options7);
    assertSame(options7, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options7, options4.getDescriptorForType().getOptions());
    assertSame(options7, getResult5.getOptions());
    assertSame(options7, getResult6.getOptions());
    assertSame(options7, getResult7.getOptions());
    assertSame(options7, getResult8.getOptions());
    assertSame(options5, options5.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult2.toProto();
    assertSame(options2, toProtoResult4.getOptions());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options6, options6.getDefaultInstanceForType());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    AdminSettingsUpdateMsg defaultInstanceForType3 = actualConstructAdminSettingsUpdateMsgResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType3.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructAdminSettingsUpdateMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, options6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult4.toProto().getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link AdminSettingsMsgConstructorV2#constructAdminSettingsUpdateMsg(AdminSettings)}.
   * <ul>
   *   <li>When {@link AdminSettings#AdminSettings()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSettingsMsgConstructorV2#constructAdminSettingsUpdateMsg(AdminSettings)}
   */
  @Test
  @DisplayName("Test constructAdminSettingsUpdateMsg(AdminSettings); when AdminSettings()")
  void testConstructAdminSettingsUpdateMsg_whenAdminSettings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsMsgConstructorV2 adminSettingsMsgConstructorV2 = new AdminSettingsMsgConstructorV2();

    // Act
    AdminSettingsUpdateMsg actualConstructAdminSettingsUpdateMsgResult = adminSettingsMsgConstructorV2
        .constructAdminSettingsUpdateMsg(new AdminSettings());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConstructAdminSettingsUpdateMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options = getResult.getOptions();
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldOptions options2 = getResult2.getOptions();
    assertEquals(options, options2);
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldOptions options3 = getResult3.getOptions();
    assertEquals(options, options3);
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList expectedReservedNameList = toProtoResult.getReservedNameList();
    assertSame(expectedReservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult2.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult2.getWeakDependencyList());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options5 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options5.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, options.getFeatures());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    DescriptorProtos.FieldOptions options6 = getResult4.getOptions();
    assertSame(features, options6.getFeatures());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options6.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType2.getFeatures());
    assertSame(features, options4.getFeatures());
    assertSame(features, defaultInstanceForType2.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options5.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.Descriptor getResult7 = messageTypes.get(56);
    assertSame(file, getResult7.getFile());
    Descriptors.Descriptor getResult8 = messageTypes.get(57);
    assertSame(file, getResult8.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options7 = options5.getDescriptorForType().getOptions();
    assertSame(options7, defaultInstanceForType.getOptions());
    assertSame(options7, toProtoResult.getOptions());
    assertSame(options7, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options7, toProtoResult.getOptionsOrBuilder());
    assertSame(options7, options7);
    assertSame(options7, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options7, options4.getDescriptorForType().getOptions());
    assertSame(options7, getResult5.getOptions());
    assertSame(options7, getResult6.getOptions());
    assertSame(options7, getResult7.getOptions());
    assertSame(options7, getResult8.getOptions());
    assertSame(options5, options5.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options, toProtoResult3.getOptions());
    assertSame(options, toProtoResult3.getOptionsOrBuilder());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult2.toProto();
    assertSame(options2, toProtoResult4.getOptions());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options6, options6.getDefaultInstanceForType());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    AdminSettingsUpdateMsg defaultInstanceForType3 = actualConstructAdminSettingsUpdateMsgResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType3.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructAdminSettingsUpdateMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, options6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult4.toProto().getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
  }
}
