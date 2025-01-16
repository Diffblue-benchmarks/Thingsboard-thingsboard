package org.thingsboard.server.transport.coap.adaptors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.californium.core.coap.Request;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.coap.TbCoapMessageObserver;

class CoapAdaptorUtilsDiffblueTest {
  /**
   * Test {@link CoapAdaptorUtils#toGetAttributeRequestMsg(Request)}.
   * <p>
   * Method under test: {@link CoapAdaptorUtils#toGetAttributeRequestMsg(Request)}
   */
  @Test
  @DisplayName("Test toGetAttributeRequestMsg(Request)")
  void testToGetAttributeRequestMsg() throws AdaptorException {
    // Arrange
    Request inbound = Request.newDelete();
    inbound.addMessageObserver(new TbCoapMessageObserver(1, mock(Consumer.class), mock(Consumer.class)));

    // Act
    TransportProtos.GetAttributeRequestMsg actualToGetAttributeRequestMsgResult = CoapAdaptorUtils
        .toGetAttributeRequestMsg(inbound);

    // Assert
    Descriptors.Descriptor descriptorForType = actualToGetAttributeRequestMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(actualToGetAttributeRequestMsgResult,
        actualToGetAttributeRequestMsgResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
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
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(2);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(3);
    assertSame(file, getResult8.getFile());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult6.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult7.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult8.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualToGetAttributeRequestMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList clientAttributeNamesList = actualToGetAttributeRequestMsgResult.getClientAttributeNamesList();
    assertSame(clientAttributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(clientAttributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(clientAttributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(clientAttributeNamesList, defaultInstanceForType2.getDependencyList());
    assertSame(clientAttributeNamesList, toProtoResult.getDependencyList());
    assertSame(clientAttributeNamesList, actualToGetAttributeRequestMsgResult.getSharedAttributeNamesList());
  }

  /**
   * Test {@link CoapAdaptorUtils#toGetAttributeRequestMsg(Request)}.
   * <ul>
   *   <li>When newDelete.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapAdaptorUtils#toGetAttributeRequestMsg(Request)}
   */
  @Test
  @DisplayName("Test toGetAttributeRequestMsg(Request); when newDelete")
  void testToGetAttributeRequestMsg_whenNewDelete() throws AdaptorException {
    // Arrange and Act
    TransportProtos.GetAttributeRequestMsg actualToGetAttributeRequestMsgResult = CoapAdaptorUtils
        .toGetAttributeRequestMsg(Request.newDelete());

    // Assert
    Descriptors.Descriptor descriptorForType = actualToGetAttributeRequestMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(actualToGetAttributeRequestMsgResult,
        actualToGetAttributeRequestMsgResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
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
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(2);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(3);
    assertSame(file, getResult8.getFile());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult6.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult7.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult8.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualToGetAttributeRequestMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList clientAttributeNamesList = actualToGetAttributeRequestMsgResult.getClientAttributeNamesList();
    assertSame(clientAttributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(clientAttributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(clientAttributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(clientAttributeNamesList, defaultInstanceForType2.getDependencyList());
    assertSame(clientAttributeNamesList, toProtoResult.getDependencyList());
    assertSame(clientAttributeNamesList, actualToGetAttributeRequestMsgResult.getSharedAttributeNamesList());
  }

  /**
   * Test {@link CoapAdaptorUtils#toGetAttributeRequestMsg(Request)}.
   * <ul>
   *   <li>When newFetch.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapAdaptorUtils#toGetAttributeRequestMsg(Request)}
   */
  @Test
  @DisplayName("Test toGetAttributeRequestMsg(Request); when newFetch")
  void testToGetAttributeRequestMsg_whenNewFetch() throws AdaptorException {
    // Arrange and Act
    TransportProtos.GetAttributeRequestMsg actualToGetAttributeRequestMsgResult = CoapAdaptorUtils
        .toGetAttributeRequestMsg(Request.newFetch());

    // Assert
    Descriptors.Descriptor descriptorForType = actualToGetAttributeRequestMsgResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(actualToGetAttributeRequestMsgResult,
        actualToGetAttributeRequestMsgResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
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
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertSame(file, getResult5.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(2);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(3);
    assertSame(file, getResult8.getFile());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult6.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult7.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult8.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualToGetAttributeRequestMsgResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList clientAttributeNamesList = actualToGetAttributeRequestMsgResult.getClientAttributeNamesList();
    assertSame(clientAttributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(clientAttributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(clientAttributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(clientAttributeNamesList, defaultInstanceForType2.getDependencyList());
    assertSame(clientAttributeNamesList, toProtoResult.getDependencyList());
    assertSame(clientAttributeNamesList, actualToGetAttributeRequestMsgResult.getSharedAttributeNamesList());
  }
}
