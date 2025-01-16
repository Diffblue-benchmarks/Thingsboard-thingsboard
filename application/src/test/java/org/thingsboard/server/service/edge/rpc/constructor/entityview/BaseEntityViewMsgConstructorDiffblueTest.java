package org.thingsboard.server.service.edge.rpc.constructor.entityview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.gen.edge.v1.EntityViewUpdateMsg;

class BaseEntityViewMsgConstructorDiffblueTest {
  /**
   * Test
   * {@link BaseEntityViewMsgConstructor#constructEntityViewDeleteMsg(EntityViewId)}.
   * <ul>
   *   <li>Given randomUUID.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityViewMsgConstructor#constructEntityViewDeleteMsg(EntityViewId)}
   */
  @Test
  @DisplayName("Test constructEntityViewDeleteMsg(EntityViewId); given randomUUID; then calls getId()")
  void testConstructEntityViewDeleteMsg_givenRandomUUID_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewMsgConstructorV1 entityViewMsgConstructorV1 = new EntityViewMsgConstructorV1();
    EntityViewId entityViewId = mock(EntityViewId.class);
    when(entityViewId.getId()).thenReturn(UUID.randomUUID());

    // Act
    EntityViewUpdateMsg actualConstructEntityViewDeleteMsgResult = entityViewMsgConstructorV1
        .constructEntityViewDeleteMsg(entityViewId);

    // Assert
    verify(entityViewId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructEntityViewDeleteMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(12, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(3, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(3, oneofs.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
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
    Descriptors.FieldDescriptor getResult2 = fields.get(10);
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
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(11);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    Descriptors.OneofDescriptor getResult11 = oneofs.get(2);
    assertSame(file, getResult11.getFile());
    assertSame(file, services.get(0).getFile());
    DescriptorProtos.MessageOptions options5 = options2.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options5, options.getDescriptorForType().getOptions());
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
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    assertSame(descriptorForType, getResult11.getContainingType());
    EntityViewUpdateMsg defaultInstanceForType3 = actualConstructEntityViewDeleteMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType3.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityViewDeleteMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult11, getResult2.getContainingOneof());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link BaseEntityViewMsgConstructor#constructEntityViewDeleteMsg(EntityViewId)}.
   * <ul>
   *   <li>When {@link EntityViewId#EntityViewId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityViewMsgConstructor#constructEntityViewDeleteMsg(EntityViewId)}
   */
  @Test
  @DisplayName("Test constructEntityViewDeleteMsg(EntityViewId); when EntityViewId(UUID) with id is randomUUID")
  void testConstructEntityViewDeleteMsg_whenEntityViewIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewMsgConstructorV1 entityViewMsgConstructorV1 = new EntityViewMsgConstructorV1();

    // Act
    EntityViewUpdateMsg actualConstructEntityViewDeleteMsgResult = entityViewMsgConstructorV1
        .constructEntityViewDeleteMsg(new EntityViewId(UUID.randomUUID()));

    // Assert
    Descriptors.Descriptor descriptorForType = actualConstructEntityViewDeleteMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(12, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(12, fields.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(3, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(3, oneofs.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
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
    Descriptors.FieldDescriptor getResult2 = fields.get(10);
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
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(11);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    Descriptors.OneofDescriptor getResult11 = oneofs.get(2);
    assertSame(file, getResult11.getFile());
    assertSame(file, services.get(0).getFile());
    DescriptorProtos.MessageOptions options5 = options2.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options5, options.getDescriptorForType().getOptions());
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
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    assertSame(descriptorForType, getResult11.getContainingType());
    EntityViewUpdateMsg defaultInstanceForType3 = actualConstructEntityViewDeleteMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType3.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructEntityViewDeleteMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult11, getResult2.getContainingOneof());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
  }
}
