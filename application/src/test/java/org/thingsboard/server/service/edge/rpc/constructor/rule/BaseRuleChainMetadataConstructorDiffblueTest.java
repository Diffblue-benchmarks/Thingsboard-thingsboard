package org.thingsboard.server.service.edge.rpc.constructor.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.NodeConnectionInfo;
import org.thingsboard.server.common.data.rule.RuleChainConnectionInfo;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.gen.edge.v1.NodeConnectionInfoProto;
import org.thingsboard.server.gen.edge.v1.RuleChainConnectionInfoProto;
import org.thingsboard.server.gen.edge.v1.RuleChainMetadataUpdateMsg;
import org.thingsboard.server.gen.edge.v1.RuleNodeProto;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

@ContextConfiguration(classes = {RuleChainMetadataConstructorV330.class})
@ExtendWith(SpringExtension.class)
class BaseRuleChainMetadataConstructorDiffblueTest {
  @Autowired
  private BaseRuleChainMetadataConstructor baseRuleChainMetadataConstructor;

  /**
   * Test
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}
   * with {@code tenantId}, {@code msgType}, {@code ruleChainMetaData},
   * {@code edgeVersion}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion) with 'tenantId', 'msgType', 'ruleChainMetaData', 'edgeVersion'")
  void testConstructRuleChainMetadataUpdatedMsgWithTenantIdMsgTypeRuleChainMetaDataEdgeVersion() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(1);
    ArrayList<NodeConnectionInfo> nodeConnectionInfoList = new ArrayList<>();
    when(ruleChainMetaData.getConnections()).thenReturn(nodeConnectionInfoList);
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    doNothing().when(ruleChainMetaData).setRuleChainId(Mockito.<RuleChainId>any());
    ruleChainMetaData.setRuleChainId(mock(RuleChainId.class));

    // Act
    RuleChainMetadataUpdateMsg actualConstructRuleChainMetadataUpdatedMsgResult = baseRuleChainMetadataConstructor
        .constructRuleChainMetadataUpdatedMsg(tenantId, UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChainMetaData,
            EdgeVersion.V_3_3_0);

    // Assert
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData, atLeast(1)).getFirstNodeIndex();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData).setRuleChainId(isA(RuleChainId.class));
    Descriptors.Descriptor descriptorForType = actualConstructRuleChainMetadataUpdatedMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileOptions options = file.getOptions();
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("EdgeProtos", javaOuterClassnameBytes.toStringUtf8());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    Descriptors.ServiceDescriptor getResult = services.get(0);
    assertEquals("EdgeRpcService", getResult.getName());
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType2.getName());
    assertEquals("edge.EdgeRpcService", getResult.getFullName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.edge.v1", javaPackageBytes.toStringUtf8());
    assertEquals(0, getResult.getIndex());
    assertEquals(10, descriptorForType2.getIndex());
    assertEquals(3, actualConstructRuleChainMetadataUpdatedMsgResult.getAllFields().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertTrue(descriptorForType2.isExtendable());
    ByteString.ByteIterator iteratorResult = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = javaPackageBytes.iterator();
    assertTrue(iteratorResult2.hasNext());
    Descriptors.Descriptor messageType = fields.get(6).getMessageType();
    assertEquals(nodeConnectionInfoList, messageType.getEnumTypes());
    assertEquals(nodeConnectionInfoList, messageType.getExtensions());
    assertEquals(nodeConnectionInfoList, messageType.getNestedTypes());
    assertEquals(nodeConnectionInfoList, descriptorForType2.getNestedTypes());
    assertEquals(nodeConnectionInfoList, messageType.getOneofs());
    assertEquals(nodeConnectionInfoList, descriptorForType2.getOneofs());
    assertEquals(nodeConnectionInfoList, messageType.getRealOneofs());
    assertEquals(nodeConnectionInfoList, descriptorForType2.getRealOneofs());
    assertEquals('E', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult2.next().byteValue());
    assertSame(file, getResult.getFile());
  }

  /**
   * Test
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}
   * with {@code tenantId}, {@code msgType}, {@code ruleChainMetaData},
   * {@code edgeVersion}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion) with 'tenantId', 'msgType', 'ruleChainMetaData', 'edgeVersion'")
  void testConstructRuleChainMetadataUpdatedMsgWithTenantIdMsgTypeRuleChainMetaDataEdgeVersion2() {
    // Arrange
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
    doNothing().when(ruleChainMetaData).setRuleChainId(Mockito.<RuleChainId>any());
    ruleChainMetaData.setRuleChainId(mock(RuleChainId.class));

    // Act
    RuleChainMetadataUpdateMsg actualConstructRuleChainMetadataUpdatedMsgResult = baseRuleChainMetadataConstructor
        .constructRuleChainMetadataUpdatedMsg(tenantId, UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChainMetaData,
            EdgeVersion.V_3_3_0);

    // Assert
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData, atLeast(1)).getFirstNodeIndex();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData).setRuleChainId(isA(RuleChainId.class));
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
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}
   * with {@code tenantId}, {@code msgType}, {@code ruleChainMetaData},
   * {@code edgeVersion}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion)}
   */
  @Test
  @DisplayName("Test constructRuleChainMetadataUpdatedMsg(TenantId, UpdateMsgType, RuleChainMetaData, EdgeVersion) with 'tenantId', 'msgType', 'ruleChainMetaData', 'edgeVersion'")
  void testConstructRuleChainMetadataUpdatedMsgWithTenantIdMsgTypeRuleChainMetaDataEdgeVersion3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(UUID.randomUUID()));
    ruleChainConnectionInfo.setType("Type");

    ArrayList<RuleChainConnectionInfo> ruleChainConnectionInfoList = new ArrayList<>();
    ruleChainConnectionInfoList.add(ruleChainConnectionInfo);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(1);
    ArrayList<NodeConnectionInfo> nodeConnectionInfoList = new ArrayList<>();
    when(ruleChainMetaData.getConnections()).thenReturn(nodeConnectionInfoList);
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(ruleChainConnectionInfoList);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    doNothing().when(ruleChainMetaData).setRuleChainId(Mockito.<RuleChainId>any());
    ruleChainMetaData.setRuleChainId(mock(RuleChainId.class));

    // Act
    RuleChainMetadataUpdateMsg actualConstructRuleChainMetadataUpdatedMsgResult = baseRuleChainMetadataConstructor
        .constructRuleChainMetadataUpdatedMsg(tenantId, UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChainMetaData,
            EdgeVersion.V_3_3_0);

    // Assert
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData, atLeast(1)).getFirstNodeIndex();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData).setRuleChainId(isA(RuleChainId.class));
    List<RuleChainConnectionInfoProto> ruleChainConnectionsList = actualConstructRuleChainMetadataUpdatedMsgResult
        .getRuleChainConnectionsList();
    assertEquals(1, ruleChainConnectionsList.size());
    RuleChainConnectionInfoProto getResult = ruleChainConnectionsList.get(0);
    assertEquals("", getResult.getInitializationErrorString());
    RuleChainConnectionInfoProto defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals("", defaultInstanceForType.getAdditionalInfo());
    assertEquals("", defaultInstanceForType.getType());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    assertEquals("RuleChainConnectionInfoProto", descriptorForType.getName());
    ByteString typeBytes = getResult.getTypeBytes();
    assertEquals("Type", typeBytes.toStringUtf8());
    assertEquals("Type", getResult.getType());
    assertEquals("edge.RuleChainConnectionInfoProto", descriptorForType.getFullName());
    ByteString additionalInfoBytes = getResult.getAdditionalInfoBytes();
    assertEquals("null", additionalInfoBytes.toStringUtf8());
    assertEquals("null", getResult.getAdditionalInfo());
    assertNull(descriptorForType.getContainingType());
    assertEquals(0, defaultInstanceForType.getFromIndex());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getTargetRuleChainIdLSB());
    assertEquals(0L, defaultInstanceForType.getTargetRuleChainIdMSB());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(1, actualConstructRuleChainMetadataUpdatedMsgResult.getRuleChainConnectionsCount());
    assertEquals(14, descriptorForType.getIndex());
    assertEquals(5, getResult.getAllFields().size());
    List<Descriptors.FieldDescriptor> fields = actualConstructRuleChainMetadataUpdatedMsgResult.getDescriptorForType()
        .getFields();
    assertEquals(8, fields.size());
    assertFalse(additionalInfoBytes.isEmpty());
    assertFalse(typeBytes.isEmpty());
    assertFalse(descriptorForType.isExtendable());
    ByteString.ByteIterator iteratorResult = additionalInfoBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = typeBytes.iterator();
    assertTrue(iteratorResult2.hasNext());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(nodeConnectionInfoList, defaultInstanceForType.findInitializationErrors());
    assertEquals(nodeConnectionInfoList, descriptorForType.getEnumTypes());
    assertEquals(nodeConnectionInfoList, descriptorForType.getExtensions());
    assertEquals(nodeConnectionInfoList, descriptorForType.getNestedTypes());
    assertEquals(nodeConnectionInfoList, descriptorForType.getOneofs());
    assertEquals(nodeConnectionInfoList, descriptorForType.getRealOneofs());
    assertEquals('T', iteratorResult2.next().byteValue());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('y', iteratorResult2.next().byteValue());
    assertSame(descriptorForType, fields.get(6).getMessageType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructConnections(List)}.
   * <ul>
   *   <li>Given {@link NodeConnectionInfo} (default constructor) Type is
   * {@code Type}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructConnections(List)}
   */
  @Test
  @DisplayName("Test constructConnections(List); given NodeConnectionInfo (default constructor) Type is 'Type'; then return size is one")
  void testConstructConnections_givenNodeConnectionInfoTypeIsType_thenReturnSizeIsOne() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    connections.add(nodeConnectionInfo);

    // Act
    List<NodeConnectionInfoProto> actualConstructConnectionsResult = baseRuleChainMetadataConstructor
        .constructConnections(connections);

    // Assert
    assertEquals(1, actualConstructConnectionsResult.size());
    NodeConnectionInfoProto getResult = actualConstructConnectionsResult.get(0);
    ByteString typeBytes = getResult.getDefaultInstanceForType().getTypeBytes();
    assertEquals("", typeBytes.toStringUtf8());
    ByteString typeBytes2 = getResult.getTypeBytes();
    assertEquals("Type", typeBytes2.toStringUtf8());
    assertEquals("Type", getResult.getType());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    Descriptors.Descriptor descriptorForType2 = features.getDescriptorForType();
    assertEquals("google.protobuf.FeatureSet", descriptorForType2.getFullName());
    assertNull(descriptorForType2.getContainingType());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(1, getResult.getToIndex());
    assertEquals(10, getResult.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(3, getResult.getAllFields().size());
    DescriptorProtos.DescriptorProto toProtoResult = options.getDescriptorForType().toProto();
    assertEquals(5, toProtoResult.getReservedRangeCount());
    assertEquals(500, toProtoResult.getSerializedSize());
    assertFalse(typeBytes2.isEmpty());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(typeBytes.iterator().hasNext());
    assertTrue(typeBytes.isEmpty());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    ByteString.ByteIterator iteratorResult = typeBytes2.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertEquals(typeBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(0).toProto();
    assertEquals(typeBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(1).toProto();
    assertEquals(typeBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(2).toProto();
    assertEquals(typeBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(typeBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(typeBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(typeBytes, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(typeBytes, defaultInstanceForType.getNameBytes());
    assertEquals(typeBytes, defaultInstanceForType.getPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options2.getDefaultInstanceForType();
    assertEquals(typeBytes, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(typeBytes, options2.getCsharpNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(typeBytes, options2.getGoPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(typeBytes, options2.getObjcClassPrefixBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(typeBytes, options2.getPhpClassPrefixBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(typeBytes, options2.getPhpMetadataNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(typeBytes, options2.getPhpNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(typeBytes, options2.getRubyPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(typeBytes, options2.getSwiftPrefixBytes());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('y', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructConnections(List)}.
   * <ul>
   *   <li>Then calls {@link NodeConnectionInfo#getFromIndex()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructConnections(List)}
   */
  @Test
  @DisplayName("Test constructConnections(List); then calls getFromIndex()")
  void testConstructConnections_thenCallsGetFromIndex() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = mock(NodeConnectionInfo.class);
    when(nodeConnectionInfo.getFromIndex()).thenReturn(1);
    when(nodeConnectionInfo.getToIndex()).thenReturn(1);
    when(nodeConnectionInfo.getType()).thenReturn("Type");
    doNothing().when(nodeConnectionInfo).setFromIndex(anyInt());
    doNothing().when(nodeConnectionInfo).setToIndex(anyInt());
    doNothing().when(nodeConnectionInfo).setType(Mockito.<String>any());
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    connections.add(nodeConnectionInfo);

    // Act
    List<NodeConnectionInfoProto> actualConstructConnectionsResult = baseRuleChainMetadataConstructor
        .constructConnections(connections);

    // Assert
    verify(nodeConnectionInfo).getFromIndex();
    verify(nodeConnectionInfo).getToIndex();
    verify(nodeConnectionInfo).getType();
    verify(nodeConnectionInfo).setFromIndex(eq(1));
    verify(nodeConnectionInfo).setToIndex(eq(1));
    verify(nodeConnectionInfo).setType(eq("Type"));
    assertEquals(1, actualConstructConnectionsResult.size());
    NodeConnectionInfoProto getResult = actualConstructConnectionsResult.get(0);
    ByteString typeBytes = getResult.getDefaultInstanceForType().getTypeBytes();
    assertEquals("", typeBytes.toStringUtf8());
    ByteString typeBytes2 = getResult.getTypeBytes();
    assertEquals("Type", typeBytes2.toStringUtf8());
    assertEquals("Type", getResult.getType());
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    Descriptors.Descriptor descriptorForType2 = features.getDescriptorForType();
    assertEquals("google.protobuf.FeatureSet", descriptorForType2.getFullName());
    assertNull(descriptorForType2.getContainingType());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(1, getResult.getToIndex());
    assertEquals(10, getResult.getSerializedSize());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(3, getResult.getAllFields().size());
    DescriptorProtos.DescriptorProto toProtoResult = options.getDescriptorForType().toProto();
    assertEquals(5, toProtoResult.getReservedRangeCount());
    assertEquals(500, toProtoResult.getSerializedSize());
    assertFalse(typeBytes2.isEmpty());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(typeBytes.iterator().hasNext());
    assertTrue(typeBytes.isEmpty());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    ByteString.ByteIterator iteratorResult = typeBytes2.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertEquals(typeBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(0).toProto();
    assertEquals(typeBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(1).toProto();
    assertEquals(typeBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(2).toProto();
    assertEquals(typeBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(typeBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(typeBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(typeBytes, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(typeBytes, defaultInstanceForType.getNameBytes());
    assertEquals(typeBytes, defaultInstanceForType.getPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options2.getDefaultInstanceForType();
    assertEquals(typeBytes, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(typeBytes, options2.getCsharpNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(typeBytes, options2.getGoPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(typeBytes, options2.getObjcClassPrefixBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(typeBytes, options2.getPhpClassPrefixBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(typeBytes, options2.getPhpMetadataNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(typeBytes, options2.getPhpNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(typeBytes, options2.getRubyPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(typeBytes, options2.getSwiftPrefixBytes());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('y', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructConnections(List)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructConnections(List)}
   */
  @Test
  @DisplayName("Test constructConnections(List); then return size is two")
  void testConstructConnections_thenReturnSizeIsTwo() {
    // Arrange
    NodeConnectionInfo nodeConnectionInfo = new NodeConnectionInfo();
    nodeConnectionInfo.setFromIndex(1);
    nodeConnectionInfo.setToIndex(1);
    nodeConnectionInfo.setType("Type");

    NodeConnectionInfo nodeConnectionInfo2 = new NodeConnectionInfo();
    nodeConnectionInfo2.setFromIndex(-1);
    nodeConnectionInfo2.setToIndex(-1);
    nodeConnectionInfo2.setType("");

    ArrayList<NodeConnectionInfo> connections = new ArrayList<>();
    connections.add(nodeConnectionInfo2);
    connections.add(nodeConnectionInfo);

    // Act
    List<NodeConnectionInfoProto> actualConstructConnectionsResult = baseRuleChainMetadataConstructor
        .constructConnections(connections);

    // Assert
    assertEquals(2, actualConstructConnectionsResult.size());
    NodeConnectionInfoProto getResult = actualConstructConnectionsResult.get(1);
    assertEquals("", getResult.getInitializationErrorString());
    NodeConnectionInfoProto getResult2 = actualConstructConnectionsResult.get(0);
    ByteString typeBytes = getResult2.getTypeBytes();
    assertEquals("", typeBytes.toStringUtf8());
    assertEquals("", getResult2.getType());
    ByteString typeBytes2 = getResult.getTypeBytes();
    assertEquals("Type", typeBytes2.toStringUtf8());
    assertEquals("Type", getResult.getType());
    assertEquals(-1, getResult2.getFromIndex());
    assertEquals(-1, getResult2.getToIndex());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(1, getResult.getToIndex());
    assertEquals(10, getResult.getSerializedSize());
    assertEquals(2, getResult2.getAllFields().size());
    assertEquals(22, getResult2.getSerializedSize());
    Descriptors.Descriptor descriptorForType = getResult2.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(3, getResult.getAllFields().size());
    assertFalse(typeBytes2.isEmpty());
    assertFalse(typeBytes.iterator().hasNext());
    assertTrue(typeBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = typeBytes2.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(typeBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(typeBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(typeBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(2).toProto();
    assertEquals(typeBytes, toProtoResult3.getDefaultValueBytes());
    assertEquals(typeBytes, toProtoResult.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult.getTypeNameBytes());
    assertEquals(typeBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(typeBytes, toProtoResult3.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(typeBytes, defaultInstanceForType.getNameBytes());
    assertEquals(typeBytes, defaultInstanceForType.getPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(typeBytes, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(typeBytes, options.getCsharpNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(typeBytes, options.getGoPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(typeBytes, options.getObjcClassPrefixBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(typeBytes, options.getPhpClassPrefixBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(typeBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(typeBytes, options.getPhpNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(typeBytes, options.getRubyPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(typeBytes, options.getSwiftPrefixBytes());
    NodeConnectionInfoProto defaultInstanceForType3 = getResult2.getDefaultInstanceForType();
    assertEquals(typeBytes, defaultInstanceForType3.getTypeBytes());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('y', iteratorResult.next().byteValue());
    assertSame(descriptorForType, getResult.getDescriptorForType());
    assertSame(defaultInstanceForType3, getResult.getDefaultInstanceForType());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructConnections(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructConnections(List)}
   */
  @Test
  @DisplayName("Test constructConnections(List); when ArrayList(); then return Empty")
  void testConstructConnections_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(baseRuleChainMetadataConstructor.constructConnections(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructNodes(List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructNodes(List)}
   */
  @Test
  @DisplayName("Test constructNodes(List); then return size is one")
  void testConstructNodes_thenReturnSizeIsOne() {
    // Arrange
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenReturn(UUID.randomUUID());

    RuleNode ruleNode = new RuleNode(new RuleNode());
    ruleNode.setConfigurationBytes(new byte[]{});
    ruleNode.setName("Name");
    ruleNode.setType("");
    ruleNode.setId(ruleNodeId);

    ArrayList<RuleNode> nodes = new ArrayList<>();
    nodes.add(ruleNode);

    // Act
    List<RuleNodeProto> actualConstructNodesResult = baseRuleChainMetadataConstructor.constructNodes(nodes);

    // Assert
    verify(ruleNodeId, atLeast(1)).getId();
    assertEquals(1, actualConstructNodesResult.size());
    RuleNodeProto getResult = actualConstructNodesResult.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.MessageOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType4.getInitializationErrorString());
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(9, fields.size());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult3.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(7);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult4.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult5 = fields.get(8);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", getResult.getInitializationErrorString());
    RuleNodeProto defaultInstanceForType5 = getResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType5.getInitializationErrorString());
    ByteString typeBytes = getResult.getTypeBytes();
    assertEquals("", typeBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult3.getDefaultValue());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult3.getExtendee());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult3.getJsonName());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult3.getTypeName());
    assertEquals("", toProtoResult4.getTypeName());
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
    assertEquals("", file.getEditionName());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult6 = dependencies.get(0);
    assertEquals("", getResult6.getEditionName());
    assertEquals("", defaultInstanceForType5.getAdditionalInfo());
    assertEquals("", defaultInstanceForType5.getConfiguration());
    assertEquals("", defaultInstanceForType5.getName());
    assertEquals("", getResult.getType());
    assertEquals("", defaultInstanceForType5.getType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType2.getName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    Descriptors.Descriptor getResult7 = messageTypes.get(57);
    assertEquals("DownlinkMsg", getResult7.getName());
    Descriptors.Descriptor getResult8 = messageTypes.get(56);
    assertEquals("DownlinkResponseMsg", getResult8.getName());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    Descriptors.EnumDescriptor getResult9 = enumTypes.get(4);
    assertEquals("EdgeEntityType", getResult9.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("EdgeProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("EdgeProtos", options.getJavaOuterClassname());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    Descriptors.ServiceDescriptor getResult10 = services.get(0);
    assertEquals("EdgeRpcService", getResult10.getName());
    Descriptors.EnumDescriptor getResult11 = enumTypes.get(0);
    assertEquals("EdgeVersion", getResult11.getName());
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = options2.getDescriptorForType();
    assertEquals("MessageOptions", descriptorForType4.getName());
    ByteString nameBytes = getResult.getNameBytes();
    assertEquals("Name", nameBytes.toStringUtf8());
    assertEquals("Name", getResult.getName());
    Descriptors.Descriptor getResult12 = messageTypes.get(0);
    assertEquals("RequestMsg", getResult12.getName());
    Descriptors.EnumDescriptor getResult13 = enumTypes.get(1);
    assertEquals("RequestMsgType", getResult13.getName());
    Descriptors.Descriptor getResult14 = messageTypes.get(1);
    assertEquals("ResponseMsg", getResult14.getName());
    ByteString nameBytes2 = toProtoResult.getNameBytes();
    assertEquals("RuleNodeProto", nameBytes2.toStringUtf8());
    assertEquals("RuleNodeProto", toProtoResult.getName());
    assertEquals("RuleNodeProto", descriptorForType.getName());
    Descriptors.EnumDescriptor getResult15 = enumTypes.get(3);
    assertEquals("UpdateMsgType", getResult15.getName());
    assertEquals("configurationVersion", toProtoResult6.getName());
    assertEquals("configurationVersion", getResult5.getJsonName());
    assertEquals("configurationVersion", getResult5.getName());
    assertEquals("edge", toProtoResult2.getPackage());
    assertEquals("edge", file.getPackage());
    assertEquals("edge.DownlinkMsg", getResult7.getFullName());
    assertEquals("edge.DownlinkResponseMsg", getResult8.getFullName());
    assertEquals("edge.EdgeEntityType", getResult9.getFullName());
    assertEquals("edge.EdgeRpcService", getResult10.getFullName());
    assertEquals("edge.EdgeVersion", getResult11.getFullName());
    assertEquals("edge.RequestMsg", getResult12.getFullName());
    assertEquals("edge.RequestMsgType", getResult13.getFullName());
    assertEquals("edge.ResponseMsg", getResult14.getFullName());
    assertEquals("edge.RuleNodeProto", descriptorForType.getFullName());
    assertEquals("edge.RuleNodeProto.configurationVersion", getResult5.getFullName());
    assertEquals("edge.RuleNodeProto.idLSB", getResult3.getFullName());
    assertEquals("edge.RuleNodeProto.idMSB", getResult2.getFullName());
    assertEquals("edge.RuleNodeProto.singletonMode", getResult4.getFullName());
    assertEquals("edge.UpdateMsgType", getResult15.getFullName());
    assertEquals("edge.proto", toProtoResult2.getName());
    assertEquals("edge.proto", file.getFullName());
    assertEquals("edge.proto", file.getName());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType2.getFullName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType3.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType4.getFullName());
    assertEquals("idLSB", toProtoResult4.getName());
    assertEquals("idLSB", getResult3.getJsonName());
    assertEquals("idLSB", getResult3.getName());
    assertEquals("idMSB", toProtoResult3.getName());
    assertEquals("idMSB", getResult2.getJsonName());
    assertEquals("idMSB", getResult2.getName());
    ByteString additionalInfoBytes = getResult.getAdditionalInfoBytes();
    assertEquals("null", additionalInfoBytes.toStringUtf8());
    assertEquals("null", getResult.getAdditionalInfo());
    assertEquals("null", getResult.getConfiguration());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.edge.v1", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.edge.v1", options.getJavaPackage());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("queue.proto", getResult6.getFullName());
    assertEquals("queue.proto", getResult6.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("queue.proto", dependencyList.get(0));
    assertEquals("singletonMode", toProtoResult5.getName());
    assertEquals("singletonMode", getResult4.getJsonName());
    assertEquals("singletonMode", getResult4.getName());
    assertEquals("transport", getResult6.getPackage());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult12.getContainingType());
    assertNull(getResult14.getContainingType());
    assertNull(getResult8.getContainingType());
    assertNull(getResult7.getContainingType());
    assertNull(getResult11.getContainingType());
    assertNull(getResult13.getContainingType());
    assertNull(getResult15.getContainingType());
    assertNull(getResult9.getContainingType());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult5.getContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertNull(getResult5.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult3.getOneofIndex());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
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
    assertEquals(0, defaultInstanceForType4.getSerializedSize());
    assertEquals(0, defaultInstanceForType4.getUninterpretedOptionCount());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, getResult12.getIndex());
    assertEquals(0, getResult11.getIndex());
    assertEquals(0, getResult2.getIndex());
    assertEquals(0, getResult10.getIndex());
    UnknownFieldSet unknownFields = getResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, getResult.getConfigurationVersion());
    assertEquals(0, defaultInstanceForType5.getConfigurationVersion());
    assertEquals(0, defaultInstanceForType5.getSerializedSize());
    assertEquals(0L, defaultInstanceForType5.getIdLSB());
    assertEquals(0L, defaultInstanceForType5.getIdMSB());
    assertEquals(1, toProtoResult3.getNumber());
    assertEquals(1, toProtoResult2.getDependencyCount());
    assertEquals(1, toProtoResult2.getServiceCount());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, getResult14.getIndex());
    assertEquals(1, getResult13.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult2.getNumber());
    Map<Descriptors.FieldDescriptor, Object> allFields = options2.getAllFields();
    assertEquals(1, allFields.size());
    assertEquals(10, descriptorForType3.getIndex());
    assertEquals(11, descriptorForType4.getIndex());
    assertEquals(12, descriptorForType.getIndex());
    assertEquals(13, toProtoResult3.getSerializedSize());
    assertEquals(13, toProtoResult4.getSerializedSize());
    assertEquals(17264, toProtoResult2.getSerializedSize());
    assertEquals(196, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult4.getNumber());
    assertEquals(2, options2.getSerializedSize());
    assertEquals(2, descriptorForType2.getIndex());
    assertEquals(2, getResult3.getNumber());
    assertEquals(21, toProtoResult5.getSerializedSize());
    assertEquals(28, toProtoResult6.getSerializedSize());
    assertEquals(3, getResult15.getIndex());
    assertEquals(3, toProtoResult.getAllFields().size());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = options.getAllFields();
    assertEquals(3, allFields2.size());
    assertEquals(4, getResult9.getIndex());
    assertEquals(5, toProtoResult2.getEnumTypeCount());
    assertEquals(5, getResult.getAllFields().size());
    assertEquals(50, options.getSerializedSize());
    assertEquals(56, getResult8.getIndex());
    assertEquals(57, getResult7.getIndex());
    assertEquals(58, toProtoResult2.getMessageTypeCount());
    assertEquals(7, getResult4.getIndex());
    assertEquals(8, toProtoResult5.getNumber());
    assertEquals(8, getResult5.getIndex());
    assertEquals(8, getResult4.getNumber());
    assertEquals(8, toProtoResult2.getAllFields().size());
    assertEquals(9, toProtoResult.getFieldCount());
    assertEquals(9, toProtoResult6.getNumber());
    assertEquals(9, getResult5.getNumber());
    assertEquals(9, toProtoResult.getFieldList().size());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult6.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult3.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_BOOL, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult3.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT64, toProtoResult4.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.BOOLEAN, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult5.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.LONG, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.BOOL, getResult4.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult5.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult2.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT64, getResult3.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult6.getSyntax());
    assertEquals(WireFormat.FieldType.BOOL, getResult4.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult5.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult2.getLiteType());
    assertEquals(WireFormat.FieldType.INT64, getResult3.getLiteType());
    assertEquals(WireFormat.JavaType.BOOLEAN, getResult4.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult5.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult2.getLiteJavaType());
    assertEquals(WireFormat.JavaType.LONG, getResult3.getLiteJavaType());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(additionalInfoBytes.isEmpty());
    assertFalse(nameBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult3.getProto3Optional());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult3.hasDefaultValue());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult3.hasExtendee());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult3.hasJsonName());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult3.hasOneofIndex());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult3.hasProto3Optional());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult3.hasTypeName());
    assertFalse(toProtoResult4.hasTypeName());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
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
    assertFalse(defaultInstanceForType4.getDeprecated());
    assertFalse(defaultInstanceForType4.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(defaultInstanceForType4.getMapEntry());
    assertFalse(options2.getMapEntry());
    assertFalse(defaultInstanceForType4.getMessageSetWireFormat());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(defaultInstanceForType4.getNoStandardDescriptorAccessor());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(defaultInstanceForType4.hasDeprecated());
    assertFalse(defaultInstanceForType4.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(defaultInstanceForType4.hasFeatures());
    assertFalse(options2.hasFeatures());
    assertFalse(defaultInstanceForType4.hasMapEntry());
    assertFalse(options2.hasMapEntry());
    assertFalse(defaultInstanceForType4.hasMessageSetWireFormat());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(defaultInstanceForType4.hasNoStandardDescriptorAccessor());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType2.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult12.isExtendable());
    assertFalse(getResult14.isExtendable());
    assertFalse(getResult8.isExtendable());
    assertFalse(getResult7.isExtendable());
    assertFalse(getResult11.isClosed());
    assertFalse(getResult13.isClosed());
    assertFalse(getResult15.isClosed());
    assertFalse(getResult9.isClosed());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult5.hasDefaultValue());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult5.hasOptionalKeyword());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult5.hasPresence());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult5.isExtension());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult5.isMapField());
    assertFalse(getResult2.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult5.isPackable());
    assertFalse(getResult2.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult5.isPacked());
    assertFalse(getResult2.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult5.isRepeated());
    assertFalse(getResult2.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(getResult5.isRequired());
    assertFalse(typeBytes.iterator().hasNext());
    assertFalse(getResult.getDebugMode());
    assertFalse(defaultInstanceForType5.getDebugMode());
    assertFalse(getResult.getSingletonMode());
    assertFalse(defaultInstanceForType5.getSingletonMode());
    assertTrue(typeBytes.isEmpty());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.hasOptions());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult3.hasLabel());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult3.hasNumber());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult3.hasType());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(options3.isInitialized());
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
    assertTrue(options2.getDeprecated());
    assertTrue(options2.hasDeprecated());
    assertTrue(defaultInstanceForType4.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(descriptorForType4.isExtendable());
    assertTrue(descriptorForType3.isExtendable());
    assertTrue(getResult2.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(getResult5.isOptional());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes2.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = javaPackageBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = additionalInfoBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = nameBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = getResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    assertTrue(defaultInstanceForType5.findInitializationErrors().isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields3 = defaultInstanceForType5.getAllFields();
    assertTrue(allFields3.isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType5.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, features.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    List<Integer> publicDependencyList = toProtoResult2.getPublicDependencyList();
    assertEquals(findInitializationErrorsResult, publicDependencyList);
    assertEquals(findInitializationErrorsResult, descriptorForType4.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult12.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult14.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult8.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult12.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult14.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult8.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult7.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult12.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult14.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult8.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult7.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult12.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult14.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult8.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType2.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult12.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult14.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult8.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult7.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult6.getServices());
    assertEquals(allFields3, defaultInstanceForType.getAllFields());
    assertEquals(allFields3, defaultInstanceForType2.getAllFields());
    assertEquals(allFields3, defaultInstanceForType3.getAllFields());
    assertEquals(allFields3, defaultInstanceForType4.getAllFields());
    assertEquals(allFields3, features.getAllFields());
    assertEquals(allFields3, options3.getAllFields());
    assertEquals(allFields3, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields3, defaultInstanceForType4.getAllFieldsRaw());
    assertEquals(allFields3, features.getAllFieldsRaw());
    assertEquals(allFields3, options3.getAllFieldsRaw());
    assertEquals(allFields, options2.getAllFieldsRaw());
    assertEquals(allFields2, options.getAllFieldsRaw());
    assertEquals(additionalInfoBytes, getResult.getConfigurationBytes());
    assertEquals(typeBytes, defaultInstanceForType.getNameBytes());
    assertEquals(typeBytes, toProtoResult3.getDefaultValueBytes());
    assertEquals(typeBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(typeBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(typeBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(typeBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(typeBytes, toProtoResult4.getTypeNameBytes());
    assertEquals(typeBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(typeBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(typeBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(typeBytes, options.getCsharpNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(typeBytes, options.getGoPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(typeBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(typeBytes, options.getObjcClassPrefixBytes());
    assertEquals(typeBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(typeBytes, options.getPhpClassPrefixBytes());
    assertEquals(typeBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(typeBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(typeBytes, options.getPhpNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(typeBytes, options.getRubyPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(typeBytes, options.getSwiftPrefixBytes());
    assertEquals(typeBytes, defaultInstanceForType5.getAdditionalInfoBytes());
    assertEquals(typeBytes, defaultInstanceForType5.getConfigurationBytes());
    assertEquals(typeBytes, defaultInstanceForType5.getNameBytes());
    assertEquals(typeBytes, defaultInstanceForType5.getTypeBytes());
    assertEquals('E', iteratorResult2.next().byteValue());
    assertEquals('N', iteratorResult5.next().byteValue());
    assertEquals('R', iteratorResult.next().byteValue());
    assertEquals('a', iteratorResult5.next().byteValue());
    assertEquals('n', iteratorResult4.next().byteValue());
    assertEquals('o', iteratorResult3.next().byteValue());
    assertEquals('u', iteratorResult4.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(publicDependencyList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(publicDependencyList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult2.getWeakDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType4.getFeatures());
    assertSame(features, defaultInstanceForType4.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
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
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(file, getResult12.getFile());
    assertSame(file, getResult14.getFile());
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult11.getFile());
    assertSame(file, getResult13.getFile());
    assertSame(file, getResult15.getFile());
    assertSame(file, getResult9.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult10.getFile());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType5.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
  }

  /**
   * Test {@link BaseRuleChainMetadataConstructor#constructNodes(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructNodes(List)}
   */
  @Test
  @DisplayName("Test constructNodes(List); when ArrayList(); then return Empty")
  void testConstructNodes_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(baseRuleChainMetadataConstructor.constructNodes(new ArrayList<>()).isEmpty());
  }

  /**
   * Test
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link TreeSet#TreeSet()} add one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName("Test constructRuleChainConnections(List, NavigableSet); given one; when TreeSet() add one; then return Empty")
  void testConstructRuleChainConnections_givenOne_whenTreeSetAddOne_thenReturnEmpty() {
    // Arrange
    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();

    TreeSet<Integer> removedNodeIndexes = new TreeSet<>();
    removedNodeIndexes.add(1);
    removedNodeIndexes.add(2);

    // Act and Assert
    assertTrue(baseRuleChainMetadataConstructor.constructRuleChainConnections(ruleChainConnections, removedNodeIndexes)
        .isEmpty());
  }

  /**
   * Test
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}.
   * <ul>
   *   <li>Given {@link RuleChainConnectionInfo} (default constructor) Type is
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName("Test constructRuleChainConnections(List, NavigableSet); given RuleChainConnectionInfo (default constructor) Type is 'Type'")
  void testConstructRuleChainConnections_givenRuleChainConnectionInfoTypeIsType() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(UUID.randomUUID()));
    ruleChainConnectionInfo.setType("Type");

    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();
    ruleChainConnections.add(ruleChainConnectionInfo);

    // Act
    List<RuleChainConnectionInfoProto> actualConstructRuleChainConnectionsResult = baseRuleChainMetadataConstructor
        .constructRuleChainConnections(ruleChainConnections, new TreeSet<>());

    // Assert
    assertEquals(1, actualConstructRuleChainConnectionsResult.size());
    RuleChainConnectionInfoProto getResult = actualConstructRuleChainConnectionsResult.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    RuleChainConnectionInfoProto defaultInstanceForType = getResult.getDefaultInstanceForType();
    ByteString additionalInfoBytes = defaultInstanceForType.getAdditionalInfoBytes();
    assertEquals("", additionalInfoBytes.toStringUtf8());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType2.getName());
    ByteString typeBytes = getResult.getTypeBytes();
    assertEquals("Type", typeBytes.toStringUtf8());
    assertEquals("Type", getResult.getType());
    ByteString packageBytes = toProtoResult.getPackageBytes();
    assertEquals("edge", packageBytes.toStringUtf8());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("edge.proto", nameBytes.toStringUtf8());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(1, toProtoResult.getServiceList().size());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(5, toProtoResult.getEnumTypeList().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    assertEquals(5, getResult.getAllFields().size());
    assertEquals(58, toProtoResult.getMessageTypeList().size());
    assertFalse(nameBytes.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(typeBytes.isEmpty());
    assertFalse(descriptorForType2.isExtendable());
    assertFalse(additionalInfoBytes.iterator().hasNext());
    assertTrue(additionalInfoBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = packageBytes.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = typeBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    assertTrue(toProtoResult.getPublicDependencyList().isEmpty());
    assertEquals(additionalInfoBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(0).toProto();
    assertEquals(additionalInfoBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(1).toProto();
    assertEquals(additionalInfoBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(3).toProto();
    assertEquals(additionalInfoBytes, toProtoResult4.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = fields.get(4).toProto();
    assertEquals(additionalInfoBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult5.getTypeNameBytes());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(additionalInfoBytes, options.getGoPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, options.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(additionalInfoBytes, options.getSwiftPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getTypeBytes());
    assertEquals('T', iteratorResult3.next().byteValue());
    assertEquals('e', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('y', iteratorResult3.next().byteValue());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link TreeSet#TreeSet()} add two.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName("Test constructRuleChainConnections(List, NavigableSet); given two; when TreeSet() add two; then return Empty")
  void testConstructRuleChainConnections_givenTwo_whenTreeSetAddTwo_thenReturnEmpty() {
    // Arrange
    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();

    TreeSet<Integer> removedNodeIndexes = new TreeSet<>();
    removedNodeIndexes.add(2);

    // Act and Assert
    assertTrue(baseRuleChainMetadataConstructor.constructRuleChainConnections(ruleChainConnections, removedNodeIndexes)
        .isEmpty());
  }

  /**
   * Test
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}.
   * <ul>
   *   <li>Then calls {@link RuleChainConnectionInfo#getAdditionalInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName("Test constructRuleChainConnections(List, NavigableSet); then calls getAdditionalInfo()")
  void testConstructRuleChainConnections_thenCallsGetAdditionalInfo() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = mock(RuleChainConnectionInfo.class);
    when(ruleChainConnectionInfo.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(ruleChainConnectionInfo.getType()).thenReturn("Type");
    when(ruleChainConnectionInfo.getFromIndex()).thenReturn(1);
    when(ruleChainConnectionInfo.getTargetRuleChainId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    doNothing().when(ruleChainConnectionInfo).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainConnectionInfo).setFromIndex(anyInt());
    doNothing().when(ruleChainConnectionInfo).setTargetRuleChainId(Mockito.<RuleChainId>any());
    doNothing().when(ruleChainConnectionInfo).setType(Mockito.<String>any());
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(UUID.randomUUID()));
    ruleChainConnectionInfo.setType("Type");

    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();
    ruleChainConnections.add(ruleChainConnectionInfo);

    // Act
    List<RuleChainConnectionInfoProto> actualConstructRuleChainConnectionsResult = baseRuleChainMetadataConstructor
        .constructRuleChainConnections(ruleChainConnections, new TreeSet<>());

    // Assert
    verify(ruleChainConnectionInfo).getAdditionalInfo();
    verify(ruleChainConnectionInfo).getFromIndex();
    verify(ruleChainConnectionInfo, atLeast(1)).getTargetRuleChainId();
    verify(ruleChainConnectionInfo).getType();
    verify(ruleChainConnectionInfo).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainConnectionInfo).setFromIndex(eq(1));
    verify(ruleChainConnectionInfo).setTargetRuleChainId(isA(RuleChainId.class));
    verify(ruleChainConnectionInfo).setType(eq("Type"));
    assertEquals(1, actualConstructRuleChainConnectionsResult.size());
    RuleChainConnectionInfoProto getResult = actualConstructRuleChainConnectionsResult.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    RuleChainConnectionInfoProto defaultInstanceForType = getResult.getDefaultInstanceForType();
    ByteString additionalInfoBytes = defaultInstanceForType.getAdditionalInfoBytes();
    assertEquals("", additionalInfoBytes.toStringUtf8());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType2.getName());
    ByteString typeBytes = getResult.getTypeBytes();
    assertEquals("Type", typeBytes.toStringUtf8());
    assertEquals("Type", getResult.getType());
    ByteString packageBytes = toProtoResult.getPackageBytes();
    assertEquals("edge", packageBytes.toStringUtf8());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("edge.proto", nameBytes.toStringUtf8());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(1, toProtoResult.getServiceList().size());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(5, toProtoResult.getEnumTypeList().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    assertEquals(5, getResult.getAllFields().size());
    assertEquals(58, toProtoResult.getMessageTypeList().size());
    assertFalse(nameBytes.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(typeBytes.isEmpty());
    assertFalse(descriptorForType2.isExtendable());
    assertFalse(additionalInfoBytes.iterator().hasNext());
    assertTrue(additionalInfoBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = packageBytes.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = typeBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    assertTrue(toProtoResult.getPublicDependencyList().isEmpty());
    assertEquals(additionalInfoBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(0).toProto();
    assertEquals(additionalInfoBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(1).toProto();
    assertEquals(additionalInfoBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(3).toProto();
    assertEquals(additionalInfoBytes, toProtoResult4.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = fields.get(4).toProto();
    assertEquals(additionalInfoBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult5.getTypeNameBytes());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(additionalInfoBytes, options.getGoPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, options.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(additionalInfoBytes, options.getSwiftPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getTypeBytes());
    assertEquals('T', iteratorResult3.next().byteValue());
    assertEquals('e', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('y', iteratorResult3.next().byteValue());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}.
   * <ul>
   *   <li>Then calls {@link RuleChainConnectionInfo#getAdditionalInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName("Test constructRuleChainConnections(List, NavigableSet); then calls getAdditionalInfo()")
  void testConstructRuleChainConnections_thenCallsGetAdditionalInfo2() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = mock(RuleChainConnectionInfo.class);
    when(ruleChainConnectionInfo.getAdditionalInfo()).thenReturn(NullNode.getInstance());
    when(ruleChainConnectionInfo.getType()).thenReturn("Type");
    when(ruleChainConnectionInfo.getFromIndex()).thenReturn(1);
    when(ruleChainConnectionInfo.getTargetRuleChainId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    doNothing().when(ruleChainConnectionInfo).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainConnectionInfo).setFromIndex(anyInt());
    doNothing().when(ruleChainConnectionInfo).setTargetRuleChainId(Mockito.<RuleChainId>any());
    doNothing().when(ruleChainConnectionInfo).setType(Mockito.<String>any());
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(UUID.randomUUID()));
    ruleChainConnectionInfo.setType("Type");

    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();
    ruleChainConnections.add(ruleChainConnectionInfo);

    // Act
    List<RuleChainConnectionInfoProto> actualConstructRuleChainConnectionsResult = baseRuleChainMetadataConstructor
        .constructRuleChainConnections(ruleChainConnections, new TreeSet<>());

    // Assert
    verify(ruleChainConnectionInfo).getAdditionalInfo();
    verify(ruleChainConnectionInfo).getFromIndex();
    verify(ruleChainConnectionInfo, atLeast(1)).getTargetRuleChainId();
    verify(ruleChainConnectionInfo).getType();
    verify(ruleChainConnectionInfo).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainConnectionInfo).setFromIndex(eq(1));
    verify(ruleChainConnectionInfo).setTargetRuleChainId(isA(RuleChainId.class));
    verify(ruleChainConnectionInfo).setType(eq("Type"));
    assertEquals(1, actualConstructRuleChainConnectionsResult.size());
    RuleChainConnectionInfoProto getResult = actualConstructRuleChainConnectionsResult.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    RuleChainConnectionInfoProto defaultInstanceForType = getResult.getDefaultInstanceForType();
    ByteString additionalInfoBytes = defaultInstanceForType.getAdditionalInfoBytes();
    assertEquals("", additionalInfoBytes.toStringUtf8());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType2.getName());
    ByteString typeBytes = getResult.getTypeBytes();
    assertEquals("Type", typeBytes.toStringUtf8());
    assertEquals("Type", getResult.getType());
    ByteString packageBytes = toProtoResult.getPackageBytes();
    assertEquals("edge", packageBytes.toStringUtf8());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("edge.proto", nameBytes.toStringUtf8());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(1, toProtoResult.getServiceList().size());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(5, toProtoResult.getEnumTypeList().size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    assertEquals(5, getResult.getAllFields().size());
    assertEquals(58, toProtoResult.getMessageTypeList().size());
    assertFalse(nameBytes.isEmpty());
    assertFalse(packageBytes.isEmpty());
    assertFalse(typeBytes.isEmpty());
    assertFalse(descriptorForType2.isExtendable());
    assertFalse(additionalInfoBytes.iterator().hasNext());
    assertTrue(additionalInfoBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = packageBytes.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = typeBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    assertTrue(toProtoResult.getPublicDependencyList().isEmpty());
    assertEquals(additionalInfoBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(0).toProto();
    assertEquals(additionalInfoBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(1).toProto();
    assertEquals(additionalInfoBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(3).toProto();
    assertEquals(additionalInfoBytes, toProtoResult4.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = fields.get(4).toProto();
    assertEquals(additionalInfoBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult4.getTypeNameBytes());
    assertEquals(additionalInfoBytes, toProtoResult5.getTypeNameBytes());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getCsharpNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(additionalInfoBytes, options.getGoPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getObjcClassPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, options.getPhpClassPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, options.getPhpNamespaceBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, options.getRubyPackageBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(additionalInfoBytes, options.getSwiftPrefixBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getTypeBytes());
    assertEquals('T', iteratorResult3.next().byteValue());
    assertEquals('e', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('y', iteratorResult3.next().byteValue());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName("Test constructRuleChainConnections(List, NavigableSet); then return size is two")
  void testConstructRuleChainConnections_thenReturnSizeIsTwo() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(UUID.randomUUID()));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo2.setFromIndex(-1);
    ruleChainConnectionInfo2.setTargetRuleChainId(new RuleChainId(UUID.randomUUID()));
    ruleChainConnectionInfo2.setType("");

    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();
    ruleChainConnections.add(ruleChainConnectionInfo2);
    ruleChainConnections.add(ruleChainConnectionInfo);

    // Act
    List<RuleChainConnectionInfoProto> actualConstructRuleChainConnectionsResult = baseRuleChainMetadataConstructor
        .constructRuleChainConnections(ruleChainConnections, new TreeSet<>());

    // Assert
    assertEquals(2, actualConstructRuleChainConnectionsResult.size());
    RuleChainConnectionInfoProto getResult = actualConstructRuleChainConnectionsResult.get(1);
    assertEquals("", getResult.getInitializationErrorString());
    RuleChainConnectionInfoProto getResult2 = actualConstructRuleChainConnectionsResult.get(0);
    ByteString typeBytes = getResult2.getTypeBytes();
    assertEquals("", typeBytes.toStringUtf8());
    assertEquals("", getResult2.getType());
    ByteString typeBytes2 = getResult.getTypeBytes();
    assertEquals("Type", typeBytes2.toStringUtf8());
    assertEquals("Type", getResult.getType());
    assertEquals("null", getResult.getAdditionalInfo());
    assertEquals(-1, getResult2.getFromIndex());
    assertEquals(1, getResult.getFromIndex());
    assertEquals(4, getResult2.getAllFields().size());
    Descriptors.Descriptor descriptorForType = getResult2.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    assertEquals(5, getResult.getAllFields().size());
    assertFalse(typeBytes2.isEmpty());
    assertFalse(typeBytes.iterator().hasNext());
    assertTrue(typeBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = typeBytes2.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(getResult.isInitialized());
    assertEquals(typeBytes, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(typeBytes, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(typeBytes, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(3).toProto();
    assertEquals(typeBytes, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(4).toProto();
    assertEquals(typeBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(typeBytes, toProtoResult.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult2.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(typeBytes, toProtoResult.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult2.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(typeBytes, toProtoResult.getTypeNameBytes());
    assertEquals(typeBytes, toProtoResult2.getTypeNameBytes());
    assertEquals(typeBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(typeBytes, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(typeBytes, defaultInstanceForType.getNameBytes());
    assertEquals(typeBytes, defaultInstanceForType.getPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(typeBytes, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(typeBytes, options.getCsharpNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(typeBytes, options.getGoPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(typeBytes, options.getObjcClassPrefixBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(typeBytes, options.getPhpClassPrefixBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(typeBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(typeBytes, options.getPhpNamespaceBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(typeBytes, options.getRubyPackageBytes());
    assertEquals(typeBytes, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(typeBytes, options.getSwiftPrefixBytes());
    RuleChainConnectionInfoProto defaultInstanceForType3 = getResult2.getDefaultInstanceForType();
    assertEquals(typeBytes, defaultInstanceForType3.getAdditionalInfoBytes());
    assertEquals(typeBytes, defaultInstanceForType3.getTypeBytes());
    assertEquals('T', iteratorResult.next().byteValue());
    assertEquals('y', iteratorResult.next().byteValue());
    assertSame(descriptorForType, getResult.getDescriptorForType());
    assertSame(defaultInstanceForType3, getResult.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainMetadataConstructor#constructRuleChainConnections(List, NavigableSet)}
   */
  @Test
  @DisplayName("Test constructRuleChainConnections(List, NavigableSet); when ArrayList(); then return Empty")
  void testConstructRuleChainConnections_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<RuleChainConnectionInfo> ruleChainConnections = new ArrayList<>();

    // Act and Assert
    assertTrue(baseRuleChainMetadataConstructor.constructRuleChainConnections(ruleChainConnections, new TreeSet<>())
        .isEmpty());
  }
}
