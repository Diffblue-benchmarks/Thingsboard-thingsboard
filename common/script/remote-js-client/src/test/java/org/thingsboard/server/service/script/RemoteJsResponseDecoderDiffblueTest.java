package org.thingsboard.server.service.script;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.google.api.Advice;
import com.google.api.BackendRule;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.js.JsInvokeProtos;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.common.DefaultTbQueueMsg;
import org.thingsboard.server.queue.common.DefaultTbQueueMsgHeaders;
import org.thingsboard.server.queue.common.TbProtoJsQueueMsg;

class RemoteJsResponseDecoderDiffblueTest {
  /**
   * Test {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}.
   * <p>
   * Method under test: {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg)")
  void testDecode() throws IOException {
    // Arrange
    RemoteJsResponseDecoder remoteJsResponseDecoder = new RemoteJsResponseDecoder();
    UUID key = UUID.randomUUID();
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act and Assert
    JsInvokeProtos.RemoteJsResponse value = remoteJsResponseDecoder
        .decode(new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, defaultInstance, new DefaultTbQueueMsgHeaders())))
        .getValue();
    JsInvokeProtos.JsCompileResponse compileResponse = value.getCompileResponse();
    Descriptors.Descriptor descriptorForType = compileResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.Descriptor descriptorForType2 = value.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(value, value.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    JsInvokeProtos.JsInvokeResponse invokeResponse = value.getInvokeResponse();
    Descriptors.Descriptor descriptorForType3 = invokeResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    JsInvokeProtos.JsReleaseResponse releaseResponse = value.getReleaseResponse();
    Descriptors.Descriptor descriptorForType4 = releaseResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file.toProto();
    assertSame(reservedNameList, toProtoResult5.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult5.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult5.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
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
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options2, toProtoResult8.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, toProtoResult8.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(getResult8.toProto(), fieldList2.get(4));
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(7));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(1));
    UnknownFieldSet unknownFields = value.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, compileResponse.getUnknownFields());
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, value.getCompileResponseOrBuilder());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, value.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, value.getReleaseResponseOrBuilder());
  }

  /**
   * Test {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}.
   * <p>
   * Method under test: {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg)")
  void testDecode2() throws IOException {
    // Arrange
    RemoteJsResponseDecoder remoteJsResponseDecoder = new RemoteJsResponseDecoder();
    UUID key = UUID.randomUUID();

    // Act and Assert
    JsInvokeProtos.RemoteJsResponse value = remoteJsResponseDecoder
        .decode(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance()))
        .getValue();
    JsInvokeProtos.JsCompileResponse compileResponse = value.getCompileResponse();
    Descriptors.Descriptor descriptorForType = compileResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.Descriptor descriptorForType2 = value.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(value, value.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    JsInvokeProtos.JsInvokeResponse invokeResponse = value.getInvokeResponse();
    Descriptors.Descriptor descriptorForType3 = invokeResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    JsInvokeProtos.JsReleaseResponse releaseResponse = value.getReleaseResponse();
    Descriptors.Descriptor descriptorForType4 = releaseResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file.toProto();
    assertSame(reservedNameList, toProtoResult5.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult5.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult5.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
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
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options2, toProtoResult8.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, toProtoResult8.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(getResult8.toProto(), fieldList2.get(4));
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(7));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(1));
    UnknownFieldSet unknownFields = value.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, compileResponse.getUnknownFields());
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, value.getCompileResponseOrBuilder());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, value.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, value.getReleaseResponseOrBuilder());
  }

  /**
   * Test {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}.
   * <p>
   * Method under test: {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg)")
  void testDecode3() throws IOException {
    // Arrange
    RemoteJsResponseDecoder remoteJsResponseDecoder = new RemoteJsResponseDecoder();
    UUID key = UUID.randomUUID();

    // Act and Assert
    JsInvokeProtos.RemoteJsResponse value = remoteJsResponseDecoder
        .decode(new TbProtoJsQueueMsg<>(key, DescriptorProtos.FeatureSetDefaults.getDefaultInstance()))
        .getValue();
    JsInvokeProtos.JsCompileResponse compileResponse = value.getCompileResponse();
    Descriptors.Descriptor descriptorForType = compileResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.Descriptor descriptorForType2 = value.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(value, value.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    JsInvokeProtos.JsInvokeResponse invokeResponse = value.getInvokeResponse();
    Descriptors.Descriptor descriptorForType3 = invokeResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    JsInvokeProtos.JsReleaseResponse releaseResponse = value.getReleaseResponse();
    Descriptors.Descriptor descriptorForType4 = releaseResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file.toProto();
    assertSame(reservedNameList, toProtoResult5.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult5.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult5.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
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
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options2, toProtoResult8.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, toProtoResult8.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(getResult8.toProto(), fieldList2.get(4));
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(7));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(1));
    UnknownFieldSet unknownFields = value.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, compileResponse.getUnknownFields());
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, value.getCompileResponseOrBuilder());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, value.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, value.getReleaseResponseOrBuilder());
  }

  /**
   * Test {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}.
   * <p>
   * Method under test: {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg)")
  void testDecode4() throws IOException {
    // Arrange
    RemoteJsResponseDecoder remoteJsResponseDecoder = new RemoteJsResponseDecoder();
    UUID key = UUID.randomUUID();

    // Act and Assert
    JsInvokeProtos.RemoteJsResponse value = remoteJsResponseDecoder
        .decode(new TbProtoJsQueueMsg<>(key, BackendRule.getDefaultInstance()))
        .getValue();
    JsInvokeProtos.JsCompileResponse compileResponse = value.getCompileResponse();
    Descriptors.Descriptor descriptorForType = compileResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.Descriptor descriptorForType2 = value.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(value, value.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    JsInvokeProtos.JsInvokeResponse invokeResponse = value.getInvokeResponse();
    Descriptors.Descriptor descriptorForType3 = invokeResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    JsInvokeProtos.JsReleaseResponse releaseResponse = value.getReleaseResponse();
    Descriptors.Descriptor descriptorForType4 = releaseResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file.toProto();
    assertSame(reservedNameList, toProtoResult5.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult5.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult5.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
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
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options2, toProtoResult8.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, toProtoResult8.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(getResult8.toProto(), fieldList2.get(4));
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(7));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(1));
    UnknownFieldSet unknownFields = value.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, compileResponse.getUnknownFields());
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, value.getCompileResponseOrBuilder());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, value.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, value.getReleaseResponseOrBuilder());
  }

  /**
   * Test {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}.
   * <ul>
   *   <li>When {@link DefaultTbQueueMsg#DefaultTbQueueMsg(TbQueueMsg)} with msg is
   * {@link TbProtoJsQueueMsg#TbProtoJsQueueMsg(UUID, GeneratedMessageV3)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsResponseDecoder#decode(TbQueueMsg)}
   */
  @Test
  @DisplayName("Test decode(TbQueueMsg); when DefaultTbQueueMsg(TbQueueMsg) with msg is TbProtoJsQueueMsg(UUID, GeneratedMessageV3)")
  void testDecode_whenDefaultTbQueueMsgWithMsgIsTbProtoJsQueueMsg() throws IOException {
    // Arrange
    RemoteJsResponseDecoder remoteJsResponseDecoder = new RemoteJsResponseDecoder();
    UUID key = UUID.randomUUID();

    // Act and Assert
    JsInvokeProtos.RemoteJsResponse value = remoteJsResponseDecoder
        .decode(new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance())))
        .getValue();
    JsInvokeProtos.JsCompileResponse compileResponse = value.getCompileResponse();
    Descriptors.Descriptor descriptorForType = compileResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.Descriptor descriptorForType2 = value.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(5, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(5, fields2.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(8, messageTypes.size());
    assertEquals(value, value.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    JsInvokeProtos.JsInvokeResponse invokeResponse = value.getInvokeResponse();
    Descriptors.Descriptor descriptorForType3 = invokeResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    JsInvokeProtos.JsReleaseResponse releaseResponse = value.getReleaseResponse();
    Descriptors.Descriptor descriptorForType4 = releaseResponse.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file.toProto();
    assertSame(reservedNameList, toProtoResult5.getDependencyList());
    List<Integer> expectedWeakDependencyList = toProtoResult5.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult5.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields2.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
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
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType.getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult8 = getResult7.toProto();
    assertSame(options2, toProtoResult8.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, toProtoResult8.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(toProtoResult6, fieldList2.get(0));
    assertSame(getResult8.toProto(), fieldList2.get(4));
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType3, getResult7.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(7));
    assertSame(descriptorForType4, getResult8.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(1));
    UnknownFieldSet unknownFields = value.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult8.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, compileResponse.getUnknownFields());
    assertSame(unknownFields, invokeResponse.getUnknownFields());
    assertSame(unknownFields, releaseResponse.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(compileResponse, compileResponse.getDefaultInstanceForType());
    assertSame(compileResponse, value.getCompileResponseOrBuilder());
    assertSame(invokeResponse, invokeResponse.getDefaultInstanceForType());
    assertSame(invokeResponse, value.getInvokeResponseOrBuilder());
    assertSame(releaseResponse, releaseResponse.getDefaultInstanceForType());
    assertSame(releaseResponse, value.getReleaseResponseOrBuilder());
  }
}
