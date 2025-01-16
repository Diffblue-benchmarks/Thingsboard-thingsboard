package org.thingsboard.server.service.edge.rpc.constructor.relation;

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
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.gen.edge.v1.RelationUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class RelationMsgConstructorV1DiffblueTest {
  /**
   * Test
   * {@link RelationMsgConstructorV1#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}.
   * <p>
   * Method under test:
   * {@link RelationMsgConstructorV1#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}
   */
  @Test
  @DisplayName("Test constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)")
  void testConstructRelationUpdatedMsg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelationMsgConstructorV1 relationMsgConstructorV1 = new RelationMsgConstructorV1();
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getTo()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(entityRelation.getFrom()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    RelationUpdateMsg actualConstructRelationUpdatedMsgResult = relationMsgConstructorV1
        .constructRelationUpdatedMsg(UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, entityRelation);

    // Assert
    verify(entityRelation, atLeast(1)).getAdditionalInfo();
    verify(entityRelation, atLeast(1)).getFrom();
    verify(entityRelation, atLeast(1)).getTo();
    verify(entityRelation).getType();
    verify(entityRelation, atLeast(1)).getTypeGroup();
    Descriptors.Descriptor descriptorForType = actualConstructRelationUpdatedMsgResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    assertEquals(1, actualConstructRelationUpdatedMsgResult.getMsgTypeValue());
    assertEquals(10, actualConstructRelationUpdatedMsgResult.getAllFields().size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(11, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(11, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, actualConstructRelationUpdatedMsgResult.getMsgType());
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
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
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
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(10);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(9);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
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
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    DescriptorProtos.FieldOptions options6 = getResult8.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult8.toProto();
    assertSame(options6, toProtoResult5.getOptions());
    assertSame(options6, toProtoResult5.getOptionsOrBuilder());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    RelationUpdateMsg defaultInstanceForType3 = actualConstructRelationUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType3.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructRelationUpdatedMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link RelationMsgConstructorV1#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}.
   * <p>
   * Method under test:
   * {@link RelationMsgConstructorV1#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}
   */
  @Test
  @DisplayName("Test constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)")
  void testConstructRelationUpdatedMsg2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelationMsgConstructorV1 relationMsgConstructorV1 = new RelationMsgConstructorV1();
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getAdditionalInfo()).thenReturn(null);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getTo()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(entityRelation.getFrom()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    RelationUpdateMsg actualConstructRelationUpdatedMsgResult = relationMsgConstructorV1
        .constructRelationUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, entityRelation);

    // Assert
    verify(entityRelation).getAdditionalInfo();
    verify(entityRelation, atLeast(1)).getFrom();
    verify(entityRelation, atLeast(1)).getTo();
    verify(entityRelation).getType();
    verify(entityRelation, atLeast(1)).getTypeGroup();
    ByteString additionalInfoBytes = actualConstructRelationUpdatedMsgResult.getAdditionalInfoBytes();
    assertEquals("", additionalInfoBytes.toStringUtf8());
    assertEquals("", actualConstructRelationUpdatedMsgResult.getAdditionalInfo());
    Descriptors.Descriptor descriptorForType = actualConstructRelationUpdatedMsgResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(11, fields.size());
    assertFalse(additionalInfoBytes.iterator().hasNext());
    assertTrue(additionalInfoBytes.isEmpty());
    assertEquals(additionalInfoBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(additionalInfoBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(additionalInfoBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(10).toProto();
    assertEquals(additionalInfoBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(9).toProto();
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
    assertEquals(additionalInfoBytes, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, options.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(additionalInfoBytes, options.getSwiftPrefixBytes());
    RelationUpdateMsg defaultInstanceForType2 = actualConstructRelationUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getAdditionalInfoBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getEntityBytes());
    assertEquals(additionalInfoBytes, actualConstructRelationUpdatedMsgResult.getEntityBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getFromEntityTypeBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getToEntityTypeBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getTypeBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getTypeGroupBytes());
  }

  /**
   * Test
   * {@link RelationMsgConstructorV1#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}.
   * <p>
   * Method under test:
   * {@link RelationMsgConstructorV1#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}
   */
  @Test
  @DisplayName("Test constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)")
  void testConstructRelationUpdatedMsg3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelationMsgConstructorV1 relationMsgConstructorV1 = new RelationMsgConstructorV1();
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true), 3));
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getTo()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(entityRelation.getFrom()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    relationMsgConstructorV1.constructRelationUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, entityRelation);

    // Assert
    verify(entityRelation, atLeast(1)).getAdditionalInfo();
    verify(entityRelation, atLeast(1)).getFrom();
    verify(entityRelation, atLeast(1)).getTo();
    verify(entityRelation).getType();
    verify(entityRelation, atLeast(1)).getTypeGroup();
  }

  /**
   * Test
   * {@link RelationMsgConstructorV1#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelationMsgConstructorV1#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}
   */
  @Test
  @DisplayName("Test constructRelationUpdatedMsg(UpdateMsgType, EntityRelation); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  void testConstructRelationUpdatedMsg_givenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelationMsgConstructorV1 relationMsgConstructorV1 = new RelationMsgConstructorV1();
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getTo()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(entityRelation.getFrom()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    relationMsgConstructorV1.constructRelationUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, entityRelation);

    // Assert
    verify(entityRelation, atLeast(1)).getAdditionalInfo();
    verify(entityRelation, atLeast(1)).getFrom();
    verify(entityRelation, atLeast(1)).getTo();
    verify(entityRelation).getType();
    verify(entityRelation, atLeast(1)).getTypeGroup();
  }

  /**
   * Test
   * {@link RelationMsgConstructorV1#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then calls {@link EntityRelation#getAdditionalInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelationMsgConstructorV1#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}
   */
  @Test
  @DisplayName("Test constructRelationUpdatedMsg(UpdateMsgType, EntityRelation); given Instance; then calls getAdditionalInfo()")
  void testConstructRelationUpdatedMsg_givenInstance_thenCallsGetAdditionalInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelationMsgConstructorV1 relationMsgConstructorV1 = new RelationMsgConstructorV1();
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getTo()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(entityRelation.getFrom()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    relationMsgConstructorV1.constructRelationUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, entityRelation);

    // Assert
    verify(entityRelation, atLeast(1)).getAdditionalInfo();
    verify(entityRelation, atLeast(1)).getFrom();
    verify(entityRelation, atLeast(1)).getTo();
    verify(entityRelation).getType();
    verify(entityRelation, atLeast(1)).getTypeGroup();
  }

  /**
   * Test
   * {@link RelationMsgConstructorV1#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}.
   * <ul>
   *   <li>Then return TypeGroup is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RelationMsgConstructorV1#constructRelationUpdatedMsg(UpdateMsgType, EntityRelation)}
   */
  @Test
  @DisplayName("Test constructRelationUpdatedMsg(UpdateMsgType, EntityRelation); then return TypeGroup is empty string")
  void testConstructRelationUpdatedMsg_thenReturnTypeGroupIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelationMsgConstructorV1 relationMsgConstructorV1 = new RelationMsgConstructorV1();
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(entityRelation.getTypeGroup()).thenReturn(null);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getTo()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(entityRelation.getFrom()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    RelationUpdateMsg actualConstructRelationUpdatedMsgResult = relationMsgConstructorV1
        .constructRelationUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, entityRelation);

    // Assert
    verify(entityRelation, atLeast(1)).getAdditionalInfo();
    verify(entityRelation, atLeast(1)).getFrom();
    verify(entityRelation, atLeast(1)).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    assertEquals("", actualConstructRelationUpdatedMsgResult.getTypeGroup());
    assertFalse(actualConstructRelationUpdatedMsgResult.hasTypeGroup());
  }
}
