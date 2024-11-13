package org.thingsboard.server.service.edge.rpc.constructor.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.rule.NodeConnectionInfo;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.gen.edge.v1.NodeConnectionInfoProto;
import org.thingsboard.server.gen.edge.v1.RuleChainMetadataUpdateMsg;
import org.thingsboard.server.gen.edge.v1.RuleChainUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class BaseRuleChainMsgConstructorDiffblueTest {
  /**
   * Test
   * {@link BaseRuleChainMsgConstructor#constructRuleChainDeleteMsg(RuleChainId)}.
   * <ul>
   *   <li>Given randomUUID.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMsgConstructor#constructRuleChainDeleteMsg(RuleChainId)}
   */
  @Test
  @DisplayName("Test constructRuleChainDeleteMsg(RuleChainId); given randomUUID; then calls getId()")
  void testConstructRuleChainDeleteMsg_givenRandomUUID_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(UUID.randomUUID());

    // Act
    RuleChainUpdateMsg actualConstructRuleChainDeleteMsgResult = ruleChainMsgConstructorV1
        .constructRuleChainDeleteMsg(ruleChainId);

    // Assert
    verify(ruleChainId, atLeast(1)).getId();
    Descriptors.Descriptor descriptorForType = actualConstructRuleChainDeleteMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(10, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(10, fields.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(2, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    List<Integer> expectedWeakDependencyList = toProtoResult2.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult2.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(8);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
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
    Descriptors.FieldDescriptor getResult8 = fields.get(9);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
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
    RuleChainUpdateMsg defaultInstanceForType4 = actualConstructRuleChainDeleteMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructRuleChainDeleteMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
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
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link BaseRuleChainMsgConstructor#constructRuleChainDeleteMsg(RuleChainId)}.
   * <ul>
   *   <li>When {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMsgConstructor#constructRuleChainDeleteMsg(RuleChainId)}
   */
  @Test
  @DisplayName("Test constructRuleChainDeleteMsg(RuleChainId); when RuleChainId(UUID) with id is randomUUID")
  void testConstructRuleChainDeleteMsg_whenRuleChainIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();

    // Act
    RuleChainUpdateMsg actualConstructRuleChainDeleteMsgResult = ruleChainMsgConstructorV1
        .constructRuleChainDeleteMsg(new RuleChainId(UUID.randomUUID()));

    // Assert
    Descriptors.Descriptor descriptorForType = actualConstructRuleChainDeleteMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(10, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(10, fields.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(2, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    List<Integer> expectedWeakDependencyList = toProtoResult2.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult2.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(8);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
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
    Descriptors.FieldDescriptor getResult8 = fields.get(9);
    assertSame(file, getResult8.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
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
    RuleChainUpdateMsg defaultInstanceForType4 = actualConstructRuleChainDeleteMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructRuleChainDeleteMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
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
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link BaseRuleChainMsgConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}.
   * <ul>
   *   <li>Then return ConnectionsList size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMsgConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion); then return ConnectionsList size is one")
  void testConstructRuleChainMetadataUpdatedMsg_thenReturnConnectionsListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    ArrayList<NodeConnectionInfo> nodeConnectionInfoList = new ArrayList<>();
    nodeConnectionInfoList.add(nodeConnectionInfo);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(1);
    when(ruleChainMetaData.getConnections()).thenReturn(nodeConnectionInfoList);
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    when(ruleChainMetaData.getNodes()).thenReturn(ruleNodeList);
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(UUID.randomUUID()));

    // Act
    RuleChainMetadataUpdateMsg actualConstructRuleChainMetadataUpdatedMsgResult = ruleChainMsgConstructorV1
        .constructRuleChainMetadataUpdatedMsg(tenantId, UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChainMetaData,
            EdgeVersion.V_3_3_0);

    // Assert
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData, atLeast(1)).getFirstNodeIndex();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    List<NodeConnectionInfoProto> connectionsList = actualConstructRuleChainMetadataUpdatedMsgResult
        .getConnectionsList();
    assertEquals(1, connectionsList.size());
    NodeConnectionInfoProto getResult = connectionsList.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertEquals("", options.getInitializationErrorString());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    NodeConnectionInfoProto defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals("", defaultInstanceForType.getType());
    assertEquals("NodeConnectionInfoProto", toProtoResult.getName());
    assertEquals("NodeConnectionInfoProto", descriptorForType.getName());
    ByteString typeBytes = getResult.getTypeBytes();
    assertEquals("Type", typeBytes.toStringUtf8());
    assertEquals("Type", getResult.getType());
    assertEquals("edge.NodeConnectionInfoProto", descriptorForType.getFullName());
    assertNull(descriptorForType.getContainingType());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType.getFromIndex());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, defaultInstanceForType.getToIndex());
    Descriptors.Descriptor descriptorForType2 = actualConstructRuleChainMetadataUpdatedMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(1, getResult.getToIndex());
    assertEquals(1, actualConstructRuleChainMetadataUpdatedMsgResult.getConnectionsCount());
    assertEquals(10, getResult.getSerializedSize());
    assertEquals(13, descriptorForType.getIndex());
    assertEquals(2, options.getSerializedSize());
    assertEquals(3, toProtoResult.getFieldCount());
    assertEquals(3, descriptorForType.getFields().size());
    assertEquals(3, getResult.getAllFields().size());
    assertEquals(4, actualConstructRuleChainMetadataUpdatedMsgResult.getAllFields().size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(79, toProtoResult.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(8, fields.size());
    assertFalse(typeBytes.isEmpty());
    assertFalse(options.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options.getMapEntry());
    assertFalse(options.getMessageSetWireFormat());
    assertFalse(options.getNoStandardDescriptorAccessor());
    assertFalse(options.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options.hasFeatures());
    assertFalse(options.hasMapEntry());
    assertFalse(options.hasMessageSetWireFormat());
    assertFalse(options.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.hasOptions());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(options.getDeprecated());
    assertTrue(options.hasDeprecated());
    assertTrue(options.isInitialized());
    ByteString.ByteIterator iteratorResult = typeBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals(ruleNodeList, defaultInstanceForType2.findInitializationErrors());
    DescriptorProtos.MessageOptions options2 = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals(ruleNodeList, features.findInitializationErrors());
    assertEquals(ruleNodeList, options.findInitializationErrors());
    assertEquals(ruleNodeList, toProtoResult.findInitializationErrors());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertEquals(ruleNodeList, options3.findInitializationErrors());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldOptions options4 = getResult3.getOptions();
    assertEquals(ruleNodeList, options4.findInitializationErrors());
    Descriptors.FieldDescriptor getResult4 = fields.get(6);
    DescriptorProtos.FieldOptions options5 = getResult4.getOptions();
    assertEquals(ruleNodeList, options5.findInitializationErrors());
    assertEquals(ruleNodeList, getResult2.toProto().findInitializationErrors());
    assertEquals(ruleNodeList, getResult3.toProto().findInitializationErrors());
    assertEquals(ruleNodeList, getResult4.toProto().findInitializationErrors());
    assertEquals(ruleNodeList, fields.get(7).toProto().findInitializationErrors());
    assertEquals(ruleNodeList, file.getOptions().findInitializationErrors());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    assertEquals(ruleNodeList, toProtoResult3.findInitializationErrors());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertEquals(ruleNodeList, reservedNameList);
    assertEquals(ruleNodeList, options3.getTargetsList());
    assertEquals(ruleNodeList, options4.getTargetsList());
    assertEquals(ruleNodeList, options5.getTargetsList());
    assertEquals(ruleNodeList, toProtoResult3.getPublicDependencyList());
    Descriptors.Descriptor messageType = getResult4.getMessageType();
    assertEquals(ruleNodeList, messageType.getEnumTypes());
    Descriptors.Descriptor descriptorForType3 = options2.getDescriptorForType();
    assertEquals(ruleNodeList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals(ruleNodeList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(0);
    assertEquals(ruleNodeList, getResult5.getEnumTypes());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertEquals(ruleNodeList, getResult6.getEnumTypes());
    Descriptors.Descriptor getResult7 = messageTypes.get(56);
    assertEquals(ruleNodeList, getResult7.getEnumTypes());
    Descriptors.Descriptor getResult8 = messageTypes.get(57);
    assertEquals(ruleNodeList, getResult8.getEnumTypes());
    assertEquals(ruleNodeList, messageType.getExtensions());
    assertEquals(ruleNodeList, descriptorForType3.getExtensions());
    assertEquals(ruleNodeList, descriptorForType4.getExtensions());
    assertEquals(ruleNodeList, getResult5.getExtensions());
    assertEquals(ruleNodeList, getResult6.getExtensions());
    assertEquals(ruleNodeList, getResult7.getExtensions());
    assertEquals(ruleNodeList, getResult8.getExtensions());
    assertEquals(ruleNodeList, messageType.getNestedTypes());
    assertEquals(ruleNodeList, descriptorForType3.getNestedTypes());
    assertEquals(ruleNodeList, getResult5.getNestedTypes());
    assertEquals(ruleNodeList, getResult6.getNestedTypes());
    assertEquals(ruleNodeList, getResult7.getNestedTypes());
    assertEquals(ruleNodeList, getResult8.getNestedTypes());
    assertEquals(ruleNodeList, messageType.getOneofs());
    assertEquals(ruleNodeList, descriptorForType3.getOneofs());
    assertEquals(ruleNodeList, descriptorForType4.getOneofs());
    assertEquals(ruleNodeList, getResult5.getOneofs());
    assertEquals(ruleNodeList, getResult6.getOneofs());
    assertEquals(ruleNodeList, getResult7.getOneofs());
    assertEquals(ruleNodeList, getResult8.getOneofs());
    assertEquals(ruleNodeList, messageType.getRealOneofs());
    assertEquals(ruleNodeList, descriptorForType3.getRealOneofs());
    assertEquals(ruleNodeList, descriptorForType4.getRealOneofs());
    assertEquals(ruleNodeList, getResult5.getRealOneofs());
    assertEquals(ruleNodeList, getResult6.getRealOneofs());
    assertEquals(ruleNodeList, getResult7.getRealOneofs());
    assertEquals(ruleNodeList, getResult8.getRealOneofs());
    Descriptors.FileDescriptor getResult9 = dependencies.get(0);
    assertEquals(ruleNodeList, getResult9.getDependencies());
    assertEquals(ruleNodeList, getResult9.getExtensions());
    assertEquals(ruleNodeList, getResult9.getPublicDependencies());
    assertEquals(ruleNodeList, getResult9.getServices());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('y', iteratorResult.next().byteValue());
    assertSame(defaultInstanceForType2, toProtoResult.getDefaultInstanceForType());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    assertSame(features, options.getFeatures());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link BaseRuleChainMsgConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}.
   * <ul>
   *   <li>Then return SerializedSize is twenty-four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMsgConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion); then return SerializedSize is twenty-four")
  void testConstructRuleChainMetadataUpdatedMsg_thenReturnSerializedSizeIsTwentyFour() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(1);
    ArrayList<NodeConnectionInfo> nodeConnectionInfoList = new ArrayList<>();
    when(ruleChainMetaData.getConnections()).thenReturn(nodeConnectionInfoList);
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(UUID.randomUUID()));

    // Act
    RuleChainMetadataUpdateMsg actualConstructRuleChainMetadataUpdatedMsgResult = ruleChainMsgConstructorV1
        .constructRuleChainMetadataUpdatedMsg(tenantId, UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChainMetaData,
            EdgeVersion.V_3_3_0);

    // Assert
    int actualSizeResult = actualConstructRuleChainMetadataUpdatedMsgResult.getAllFields().size();
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData, atLeast(1)).getFirstNodeIndex();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    Descriptors.Descriptor descriptorForType = actualConstructRuleChainMetadataUpdatedMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    assertEquals(24, actualConstructRuleChainMetadataUpdatedMsgResult.getSerializedSize());
    assertEquals(3, actualSizeResult);
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals(nodeConnectionInfoList, toProtoResult.getDefaultInstanceForType().findInitializationErrors());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(nodeConnectionInfoList, defaultInstanceForType.findInitializationErrors());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals(nodeConnectionInfoList, features.findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(nodeConnectionInfoList, options3.findInitializationErrors());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertEquals(nodeConnectionInfoList, options4.findInitializationErrors());
    Descriptors.FieldDescriptor getResult3 = fields.get(6);
    DescriptorProtos.FieldOptions options5 = getResult3.getOptions();
    assertEquals(nodeConnectionInfoList, options5.findInitializationErrors());
    assertEquals(nodeConnectionInfoList, getResult.toProto().findInitializationErrors());
    assertEquals(nodeConnectionInfoList, getResult2.toProto().findInitializationErrors());
    assertEquals(nodeConnectionInfoList, getResult3.toProto().findInitializationErrors());
    assertEquals(nodeConnectionInfoList, fields.get(7).toProto().findInitializationErrors());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertEquals(nodeConnectionInfoList, toProtoResult2.findInitializationErrors());
    assertEquals(nodeConnectionInfoList, toProtoResult.getReservedNameList());
    assertEquals(nodeConnectionInfoList, options3.getTargetsList());
    assertEquals(nodeConnectionInfoList, options4.getTargetsList());
    assertEquals(nodeConnectionInfoList, options5.getTargetsList());
    assertEquals(nodeConnectionInfoList, toProtoResult2.getPublicDependencyList());
    Descriptors.Descriptor messageType = getResult3.getMessageType();
    assertEquals(nodeConnectionInfoList, messageType.getEnumTypes());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    assertEquals(nodeConnectionInfoList, descriptorForType2.getEnumTypes());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals(nodeConnectionInfoList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(0);
    assertEquals(nodeConnectionInfoList, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals(nodeConnectionInfoList, getResult5.getEnumTypes());
    Descriptors.Descriptor getResult6 = messageTypes.get(56);
    assertEquals(nodeConnectionInfoList, getResult6.getEnumTypes());
    Descriptors.Descriptor getResult7 = messageTypes.get(57);
    assertEquals(nodeConnectionInfoList, getResult7.getEnumTypes());
    assertEquals(nodeConnectionInfoList, messageType.getExtensions());
    assertEquals(nodeConnectionInfoList, descriptorForType2.getExtensions());
    assertEquals(nodeConnectionInfoList, descriptorForType3.getExtensions());
    Descriptors.Descriptor descriptorForType4 = options.getDescriptorForType();
    assertEquals(nodeConnectionInfoList, descriptorForType4.getExtensions());
    assertEquals(nodeConnectionInfoList, getResult4.getExtensions());
    assertEquals(nodeConnectionInfoList, getResult5.getExtensions());
    assertEquals(nodeConnectionInfoList, getResult6.getExtensions());
    assertEquals(nodeConnectionInfoList, getResult7.getExtensions());
    assertEquals(nodeConnectionInfoList, messageType.getNestedTypes());
    assertEquals(nodeConnectionInfoList, descriptorForType2.getNestedTypes());
    assertEquals(nodeConnectionInfoList, descriptorForType4.getNestedTypes());
    assertEquals(nodeConnectionInfoList, getResult4.getNestedTypes());
    assertEquals(nodeConnectionInfoList, getResult5.getNestedTypes());
    assertEquals(nodeConnectionInfoList, getResult6.getNestedTypes());
    assertEquals(nodeConnectionInfoList, getResult7.getNestedTypes());
    assertEquals(nodeConnectionInfoList, messageType.getOneofs());
    assertEquals(nodeConnectionInfoList, descriptorForType2.getOneofs());
    assertEquals(nodeConnectionInfoList, descriptorForType3.getOneofs());
    assertEquals(nodeConnectionInfoList, descriptorForType4.getOneofs());
    assertEquals(nodeConnectionInfoList, getResult4.getOneofs());
    assertEquals(nodeConnectionInfoList, getResult5.getOneofs());
    assertEquals(nodeConnectionInfoList, getResult6.getOneofs());
    assertEquals(nodeConnectionInfoList, getResult7.getOneofs());
    assertEquals(nodeConnectionInfoList, messageType.getRealOneofs());
    assertEquals(nodeConnectionInfoList, descriptorForType2.getRealOneofs());
    assertEquals(nodeConnectionInfoList, descriptorForType3.getRealOneofs());
    assertEquals(nodeConnectionInfoList, descriptorForType4.getRealOneofs());
    assertEquals(nodeConnectionInfoList, getResult4.getRealOneofs());
    assertEquals(nodeConnectionInfoList, getResult5.getRealOneofs());
    assertEquals(nodeConnectionInfoList, getResult6.getRealOneofs());
    assertEquals(nodeConnectionInfoList, getResult7.getRealOneofs());
    Descriptors.FileDescriptor getResult8 = dependencies.get(0);
    assertEquals(nodeConnectionInfoList, getResult8.getDependencies());
    assertEquals(nodeConnectionInfoList, getResult8.getExtensions());
    assertEquals(nodeConnectionInfoList, getResult8.getPublicDependencies());
    assertEquals(nodeConnectionInfoList, getResult8.getServices());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(features, defaultInstanceForType.getFeatures());
    assertSame(features, defaultInstanceForType.getFeaturesOrBuilder());
    assertSame(file, services.get(0).getFile());
  }
}
