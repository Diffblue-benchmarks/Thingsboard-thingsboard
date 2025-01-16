package org.thingsboard.server.service.edge.rpc.constructor.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.gen.edge.v1.RuleChainUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class RuleChainMsgConstructorV1DiffblueTest {
  /**
   * Test
   * {@link RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}.
   * <ul>
   *   <li>Then return FirstRuleNodeIdLSB is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName("Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean); then return FirstRuleNodeIdLSB is zero")
  void testConstructRuleChainUpdatedMsg_thenReturnFirstRuleNodeIdLSBIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(UUID.randomUUID());

    RuleChain ruleChain = new RuleChain(new RuleChain());
    ruleChain.setName("");
    ruleChain.setId(ruleChainId);

    // Act
    RuleChainUpdateMsg actualConstructRuleChainUpdatedMsgResult = ruleChainMsgConstructorV1
        .constructRuleChainUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChain, true);

    // Assert
    verify(ruleChainId, atLeast(1)).getId();
    assertEquals(0L, actualConstructRuleChainUpdatedMsgResult.getFirstRuleNodeIdLSB());
    assertEquals(0L, actualConstructRuleChainUpdatedMsgResult.getFirstRuleNodeIdMSB());
    Descriptors.Descriptor descriptorForType = actualConstructRuleChainUpdatedMsgResult.getDescriptorForType();
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
    assertEquals(4, actualConstructRuleChainUpdatedMsgResult.getAllFields().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertFalse(actualConstructRuleChainUpdatedMsgResult.hasFirstRuleNodeIdLSB());
    assertFalse(actualConstructRuleChainUpdatedMsgResult.hasFirstRuleNodeIdMSB());
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
    RuleChainUpdateMsg defaultInstanceForType4 = actualConstructRuleChainUpdatedMsgResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConstructRuleChainUpdatedMsgResult.getUnknownFields();
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
   * {@link RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}.
   * <ul>
   *   <li>When {@link RuleChain} {@link RuleChain#getConfiguration()} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainMsgConstructorV1#constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean)}
   */
  @Test
  @DisplayName("Test constructRuleChainUpdatedMsg(UpdateMsgType, RuleChain, boolean); when RuleChain getConfiguration() return Instance")
  void testConstructRuleChainUpdatedMsg_whenRuleChainGetConfigurationReturnInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleChainMsgConstructorV1 ruleChainMsgConstructorV1 = new RuleChainMsgConstructorV1();
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(UUID.randomUUID());
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChain.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(ruleChain.getConfiguration()).thenReturn(MissingNode.getInstance());
    when(ruleChain.getVersion()).thenReturn(1L);
    when(ruleChain.getName()).thenReturn("Name");
    when(ruleChain.getCreatedTime()).thenReturn(1L);
    when(ruleChain.getExternalId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    when(ruleChain.getId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    when(ruleChain.getFirstRuleNodeId()).thenReturn(new RuleNodeId(UUID.randomUUID()));
    when(ruleChain.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ruleChain.getType()).thenReturn(RuleChainType.CORE);

    RuleChain ruleChain2 = new RuleChain(ruleChain);
    ruleChain2.setName("");
    ruleChain2.setId(ruleChainId);

    // Act
    ruleChainMsgConstructorV1.constructRuleChainUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, ruleChain2, true);

    // Assert
    verify(ruleChain).getAdditionalInfo();
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChain).getConfiguration();
    verify(ruleChain).getCreatedTime();
    verify(ruleChain).getExternalId();
    verify(ruleChain).getFirstRuleNodeId();
    verify(ruleChain).getId();
    verify(ruleChain).getName();
    verify(ruleChain).getTenantId();
    verify(ruleChain).getType();
    verify(ruleChain).getVersion();
    verify(ruleChain).isRoot();
  }
}
