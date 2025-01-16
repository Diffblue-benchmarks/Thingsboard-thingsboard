package org.thingsboard.server.common.msg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.msg.gen.MsgProtos;

class TbMsgProcessingCtxDiffblueTest {
  /**
   * Test {@link TbMsgProcessingCtx#pop()}.
   * <ul>
   *   <li>Given {@link TbMsgProcessingCtx#TbMsgProcessingCtx()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingCtx#pop()}
   */
  @Test
  @DisplayName("Test pop(); given TbMsgProcessingCtx(); then return 'null'")
  void testPop_givenTbMsgProcessingCtx_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TbMsgProcessingCtx()).pop());
  }

  /**
   * Test {@link TbMsgProcessingCtx#pop()}.
   * <ul>
   *   <li>Then return RuleChainId is {@link RuleChainId#RuleChainId(UUID)} with id
   * is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingCtx#pop()}
   */
  @Test
  @DisplayName("Test pop(); then return RuleChainId is RuleChainId(UUID) with id is randomUUID")
  void testPop_thenReturnRuleChainIdIsRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgProcessingCtx tbMsgProcessingCtx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());
    tbMsgProcessingCtx.push(ruleChainId, ruleNodeId);

    // Act
    TbMsgProcessingStackItem actualPopResult = tbMsgProcessingCtx.pop();

    // Assert
    assertSame(ruleChainId, actualPopResult.getRuleChainId());
    assertSame(ruleNodeId, actualPopResult.getRuleNodeId());
  }

  /**
   * Test {@link TbMsgProcessingCtx#toProto()}.
   * <p>
   * Method under test: {@link TbMsgProcessingCtx#toProto()}
   */
  @Test
  @DisplayName("Test toProto()")
  void testToProto() {
    // Arrange and Act
    MsgProtos.TbMsgProcessingCtxProto actualToProtoResult = (new TbMsgProcessingCtx()).toProto();

    // Assert
    Descriptors.Descriptor descriptorForType = actualToProtoResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult = getResult.toProto();
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType2.getName());
    Descriptors.Descriptor messageType = fields.get(1).getMessageType();
    DescriptorProtos.DescriptorProto toProtoResult2 = messageType.toProto();
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult2.getName());
    assertEquals("TbMsgProcessingStackItemProto", messageType.getName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType2.getFullName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", messageType.getFullName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ruleNodeExecCounter", nameBytes.toStringUtf8());
    assertNull(messageType.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionRangeCount());
    assertEquals(0, toProtoResult2.getNestedTypeCount());
    assertEquals(0, toProtoResult2.getOneofDeclCount());
    assertEquals(0, actualToProtoResult.getSerializedSize());
    assertEquals(0, actualToProtoResult.getStackCount());
    assertEquals(1, messageType.getIndex());
    assertEquals(4, toProtoResult2.getFieldCount());
    assertEquals(4, descriptorForType2.getIndex());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    assertEquals(4, toProtoResult3.getMessageTypeList().size());
    assertEquals(4, messageType.getFields().size());
    assertEquals(4, file.getMessageTypes().size());
    assertFalse(nameBytes.isEmpty());
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertFalse(defaultInstanceForType.hasDefaultValue());
    assertFalse(defaultInstanceForType.hasExtendee());
    assertFalse(defaultInstanceForType.hasJsonName());
    assertFalse(defaultInstanceForType.hasLabel());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasNumber());
    assertFalse(defaultInstanceForType.hasOneofIndex());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(defaultInstanceForType.hasProto3Optional());
    assertFalse(defaultInstanceForType.hasType());
    assertFalse(defaultInstanceForType.hasTypeName());
    assertFalse(messageType.isExtendable());
    assertFalse(descriptorForType2.isExtendable());
    assertTrue(defaultInstanceForType.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(messageType.getEnumTypes().isEmpty());
    assertTrue(messageType.getExtensions().isEmpty());
    assertTrue(messageType.getNestedTypes().isEmpty());
    assertTrue(messageType.getOneofs().isEmpty());
    assertTrue(messageType.getRealOneofs().isEmpty());
    List<MsgProtos.TbMsgProcessingStackItemProto> stackList = actualToProtoResult.getStackList();
    assertTrue(stackList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualToProtoResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult3.getSourceCodeInfo();
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(actualToProtoResult, actualToProtoResult.getDefaultInstanceForType());
    assertEquals(TbMsg.EMPTY_STRING, toProtoResult2.getInitializationErrorString());
    assertEquals('r', iteratorResult.next().byteValue());
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult4.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult2.getDefaultInstanceForType());
    assertSame(file, messageType.getFile());
    assertSame(stackList, defaultInstanceForType4.getEnumTypeList());
    assertSame(stackList, toProtoResult2.getEnumTypeList());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult5 = options2.getDescriptorForType().toProto();
    assertSame(stackList, toProtoResult5.getEnumTypeList());
    DescriptorProtos.DescriptorProto toProtoResult6 = toProtoResult4.getDescriptorForType().toProto();
    assertSame(stackList, toProtoResult6.getEnumTypeList());
    assertSame(stackList, toProtoResult4.getEnumTypeList());
    assertSame(stackList, defaultInstanceForType4.getEnumTypeOrBuilderList());
    assertSame(stackList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(stackList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(stackList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(stackList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(stackList, defaultInstanceForType4.getExtensionList());
    assertSame(stackList, toProtoResult2.getExtensionList());
    assertSame(stackList, toProtoResult5.getExtensionList());
    assertSame(stackList, toProtoResult6.getExtensionList());
    assertSame(stackList, toProtoResult4.getExtensionList());
    assertSame(stackList, defaultInstanceForType4.getExtensionOrBuilderList());
    assertSame(stackList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(stackList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(stackList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(stackList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(stackList, defaultInstanceForType4.getExtensionRangeList());
    assertSame(stackList, toProtoResult2.getExtensionRangeList());
    assertSame(stackList, toProtoResult6.getExtensionRangeList());
    assertSame(stackList, toProtoResult4.getExtensionRangeList());
    assertSame(stackList, defaultInstanceForType4.getExtensionRangeOrBuilderList());
    assertSame(stackList, toProtoResult2.getExtensionRangeOrBuilderList());
    assertSame(stackList, toProtoResult6.getExtensionRangeOrBuilderList());
    assertSame(stackList, toProtoResult4.getExtensionRangeOrBuilderList());
    assertSame(stackList, defaultInstanceForType4.getFieldList());
    assertSame(stackList, defaultInstanceForType4.getFieldOrBuilderList());
    assertSame(stackList, defaultInstanceForType4.getNestedTypeList());
    assertSame(stackList, toProtoResult2.getNestedTypeList());
    assertSame(stackList, toProtoResult5.getNestedTypeList());
    assertSame(stackList, toProtoResult4.getNestedTypeList());
    assertSame(stackList, defaultInstanceForType4.getNestedTypeOrBuilderList());
    assertSame(stackList, toProtoResult2.getNestedTypeOrBuilderList());
    assertSame(stackList, toProtoResult5.getNestedTypeOrBuilderList());
    assertSame(stackList, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(stackList, defaultInstanceForType4.getOneofDeclList());
    assertSame(stackList, toProtoResult2.getOneofDeclList());
    assertSame(stackList, toProtoResult5.getOneofDeclList());
    assertSame(stackList, toProtoResult6.getOneofDeclList());
    assertSame(stackList, toProtoResult4.getOneofDeclList());
    assertSame(stackList, defaultInstanceForType4.getOneofDeclOrBuilderList());
    assertSame(stackList, toProtoResult2.getOneofDeclOrBuilderList());
    assertSame(stackList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(stackList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(stackList, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(stackList, defaultInstanceForType4.getReservedRangeList());
    assertSame(stackList, toProtoResult6.getReservedRangeList());
    assertSame(stackList, toProtoResult4.getReservedRangeList());
    assertSame(stackList, defaultInstanceForType4.getReservedRangeOrBuilderList());
    assertSame(stackList, toProtoResult6.getReservedRangeOrBuilderList());
    assertSame(stackList, toProtoResult4.getReservedRangeOrBuilderList());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(stackList, options3.getEditionDefaultsList());
    assertSame(stackList, options3.getEditionDefaultsOrBuilderList());
    assertSame(stackList, options3.getUninterpretedOptionList());
    assertSame(stackList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(stackList, defaultInstanceForType2.getEnumTypeList());
    assertSame(stackList, toProtoResult3.getEnumTypeList());
    assertSame(stackList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(stackList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(stackList, defaultInstanceForType2.getExtensionList());
    assertSame(stackList, toProtoResult3.getExtensionList());
    assertSame(stackList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(stackList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(stackList, defaultInstanceForType2.getMessageTypeList());
    assertSame(stackList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(stackList, defaultInstanceForType2.getServiceList());
    assertSame(stackList, toProtoResult3.getServiceList());
    assertSame(stackList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(stackList, toProtoResult3.getServiceOrBuilderList());
    assertSame(stackList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(stackList, options.getUninterpretedOptionList());
    assertSame(stackList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(stackList, options.getUninterpretedOptionOrBuilderList());
    assertSame(stackList, options2.getUninterpretedOptionList());
    assertSame(stackList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(stackList, sourceCodeInfo.getLocationList());
    assertSame(stackList, sourceCodeInfo.getLocationOrBuilderList());
  }

  /**
   * Test {@link TbMsgProcessingCtx#toProto()}.
   * <ul>
   *   <li>Then return StackList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgProcessingCtx#toProto()}
   */
  @Test
  @DisplayName("Test toProto(); then return StackList size is one")
  void testToProto_thenReturnStackListSizeIsOne() {
    // Arrange
    TbMsgProcessingCtx tbMsgProcessingCtx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    tbMsgProcessingCtx.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));

    // Act
    MsgProtos.TbMsgProcessingCtxProto actualToProtoResult = tbMsgProcessingCtx.toProto();

    // Assert
    List<MsgProtos.TbMsgProcessingStackItemProto> stackList = actualToProtoResult.getStackList();
    assertEquals(1, stackList.size());
    MsgProtos.TbMsgProcessingStackItemProto getResult = stackList.get(0);
    Descriptors.Descriptor descriptorForType = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals("TbMsgProcessingStackItemProto", toProtoResult.getName());
    assertEquals("TbMsgProcessingStackItemProto", descriptorForType.getName());
    assertEquals("msgqueue.TbMsgProcessingStackItemProto", descriptorForType.getFullName());
    assertNull(descriptorForType.getContainingType());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    MsgProtos.TbMsgProcessingStackItemProto defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0L, defaultInstanceForType.getRuleChainIdLSB());
    assertEquals(0L, defaultInstanceForType.getRuleChainIdMSB());
    assertEquals(0L, defaultInstanceForType.getRuleNodeIdLSB());
    assertEquals(0L, defaultInstanceForType.getRuleNodeIdMSB());
    assertEquals(1, descriptorForType.getIndex());
    assertEquals(1, actualToProtoResult.getAllFields().size());
    assertEquals(1, actualToProtoResult.getStackCount());
    assertEquals(125, toProtoResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = actualToProtoResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    assertEquals(4, toProtoResult.getFieldCount());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertEquals(4, toProtoResult2.getMessageTypeList().size());
    assertEquals(4, descriptorForType.getFields().size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(4, messageTypes.size());
    assertEquals(4, getResult.getAllFields().size());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(descriptorForType.isExtendable());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(getResult.findInitializationErrors().isEmpty());
    assertTrue(defaultInstanceForType.findInitializationErrors().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    MsgProtos.TbMsgProcessingCtxProto defaultInstanceForType2 = actualToProtoResult.getDefaultInstanceForType();
    List<MsgProtos.TbMsgProcessingStackItemProto> stackList2 = defaultInstanceForType2.getStackList();
    assertTrue(stackList2.isEmpty());
    assertTrue(defaultInstanceForType.getAllFields().isEmpty());
    assertTrue(getResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertEquals(TbMsg.EMPTY_STRING, toProtoResult.getInitializationErrorString());
    assertEquals(TbMsg.EMPTY_STRING, getResult.getInitializationErrorString());
    assertEquals(TbMsg.EMPTY_STRING, defaultInstanceForType.getInitializationErrorString());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType3 = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3, toProtoResult.getDefaultInstanceForType());
    assertSame(file, descriptorForType.getFile());
    assertSame(descriptorForType, fields.get(1).getMessageType());
    assertSame(descriptorForType, defaultInstanceForType.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(stackList2, defaultInstanceForType3.getEnumTypeList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.DescriptorProto toProtoResult4 = options.getDescriptorForType().toProto();
    assertSame(stackList2, toProtoResult4.getEnumTypeList());
    DescriptorProtos.DescriptorProto toProtoResult5 = toProtoResult3.getDescriptorForType().toProto();
    assertSame(stackList2, toProtoResult5.getEnumTypeList());
    assertSame(stackList2, toProtoResult.getEnumTypeList());
    assertSame(stackList2, toProtoResult3.getEnumTypeList());
    assertSame(stackList2, defaultInstanceForType3.getEnumTypeOrBuilderList());
    assertSame(stackList2, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(stackList2, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(stackList2, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(stackList2, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(stackList2, defaultInstanceForType3.getExtensionList());
    assertSame(stackList2, toProtoResult4.getExtensionList());
    assertSame(stackList2, toProtoResult5.getExtensionList());
    assertSame(stackList2, toProtoResult.getExtensionList());
    assertSame(stackList2, toProtoResult3.getExtensionList());
    assertSame(stackList2, defaultInstanceForType3.getExtensionOrBuilderList());
    assertSame(stackList2, toProtoResult4.getExtensionOrBuilderList());
    assertSame(stackList2, toProtoResult5.getExtensionOrBuilderList());
    assertSame(stackList2, toProtoResult.getExtensionOrBuilderList());
    assertSame(stackList2, toProtoResult3.getExtensionOrBuilderList());
    assertSame(stackList2, defaultInstanceForType3.getExtensionRangeList());
    assertSame(stackList2, toProtoResult5.getExtensionRangeList());
    assertSame(stackList2, toProtoResult.getExtensionRangeList());
    assertSame(stackList2, toProtoResult3.getExtensionRangeList());
    assertSame(stackList2, defaultInstanceForType3.getExtensionRangeOrBuilderList());
    assertSame(stackList2, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(stackList2, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(stackList2, toProtoResult3.getExtensionRangeOrBuilderList());
    assertSame(stackList2, defaultInstanceForType3.getFieldList());
    assertSame(stackList2, defaultInstanceForType3.getFieldOrBuilderList());
    assertSame(stackList2, defaultInstanceForType3.getNestedTypeList());
    assertSame(stackList2, toProtoResult4.getNestedTypeList());
    assertSame(stackList2, toProtoResult.getNestedTypeList());
    assertSame(stackList2, toProtoResult3.getNestedTypeList());
    assertSame(stackList2, defaultInstanceForType3.getNestedTypeOrBuilderList());
    assertSame(stackList2, toProtoResult4.getNestedTypeOrBuilderList());
    assertSame(stackList2, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(stackList2, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(stackList2, defaultInstanceForType3.getOneofDeclList());
    assertSame(stackList2, toProtoResult4.getOneofDeclList());
    assertSame(stackList2, toProtoResult5.getOneofDeclList());
    assertSame(stackList2, toProtoResult.getOneofDeclList());
    assertSame(stackList2, toProtoResult3.getOneofDeclList());
    assertSame(stackList2, defaultInstanceForType3.getOneofDeclOrBuilderList());
    assertSame(stackList2, toProtoResult4.getOneofDeclOrBuilderList());
    assertSame(stackList2, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(stackList2, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(stackList2, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(stackList2, defaultInstanceForType3.getReservedRangeList());
    assertSame(stackList2, toProtoResult5.getReservedRangeList());
    assertSame(stackList2, toProtoResult.getReservedRangeList());
    assertSame(stackList2, toProtoResult3.getReservedRangeList());
    assertSame(stackList2, defaultInstanceForType3.getReservedRangeOrBuilderList());
    assertSame(stackList2, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(stackList2, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(stackList2, toProtoResult3.getReservedRangeOrBuilderList());
    DescriptorProtos.FieldOptions options2 = fields.get(0).getOptions();
    assertSame(stackList2, options2.getEditionDefaultsList());
    assertSame(stackList2, options2.getEditionDefaultsOrBuilderList());
    assertSame(stackList2, options2.getUninterpretedOptionList());
    assertSame(stackList2, options2.getUninterpretedOptionOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType4 = toProtoResult2.getDefaultInstanceForType();
    assertSame(stackList2, defaultInstanceForType4.getEnumTypeList());
    assertSame(stackList2, toProtoResult2.getEnumTypeList());
    assertSame(stackList2, defaultInstanceForType4.getEnumTypeOrBuilderList());
    assertSame(stackList2, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(stackList2, defaultInstanceForType4.getExtensionList());
    assertSame(stackList2, toProtoResult2.getExtensionList());
    assertSame(stackList2, defaultInstanceForType4.getExtensionOrBuilderList());
    assertSame(stackList2, toProtoResult2.getExtensionOrBuilderList());
    assertSame(stackList2, defaultInstanceForType4.getMessageTypeList());
    assertSame(stackList2, defaultInstanceForType4.getMessageTypeOrBuilderList());
    assertSame(stackList2, defaultInstanceForType4.getServiceList());
    assertSame(stackList2, toProtoResult2.getServiceList());
    assertSame(stackList2, defaultInstanceForType4.getServiceOrBuilderList());
    assertSame(stackList2, toProtoResult2.getServiceOrBuilderList());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options3.getDefaultInstanceForType();
    assertSame(stackList2, defaultInstanceForType5.getUninterpretedOptionList());
    assertSame(stackList2, options3.getUninterpretedOptionList());
    assertSame(stackList2, defaultInstanceForType5.getUninterpretedOptionOrBuilderList());
    assertSame(stackList2, options3.getUninterpretedOptionOrBuilderList());
    assertSame(stackList2, options.getUninterpretedOptionList());
    assertSame(stackList2, options.getUninterpretedOptionOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(stackList2, sourceCodeInfo.getLocationList());
    assertSame(stackList2, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(stackList2, defaultInstanceForType2.getStackOrBuilderList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
  }
}
