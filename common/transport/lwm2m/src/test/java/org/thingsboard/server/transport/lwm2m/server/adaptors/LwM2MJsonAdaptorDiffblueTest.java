package org.thingsboard.server.transport.lwm2m.server.adaptors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.gen.transport.TransportProtos;

class LwM2MJsonAdaptorDiffblueTest {
  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement)")
  void testConvertToPostTelemetry() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = lwM2MJsonAdaptor
        .convertToPostTelemetry(new JsonArray(3));

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToPostTelemetryResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    Descriptors.Descriptor messageType = getResult.getMessageType();
    DescriptorProtos.DescriptorProto toProtoResult = messageType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = getResult.toProto();
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    assertEquals("FieldDescriptorProto", descriptorForType2.getName());
    assertEquals("TsKvListProto", toProtoResult.getName());
    assertEquals("TsKvListProto", messageType.getName());
    assertEquals("google.protobuf.FieldDescriptorProto", descriptorForType2.getFullName());
    assertEquals("transport.TsKvListProto", messageType.getFullName());
    assertNull(messageType.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, actualConvertToPostTelemetryResult.getSerializedSize());
    assertEquals(0, actualConvertToPostTelemetryResult.getTsKvListCount());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult3.getFieldList();
    assertEquals(1, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult4.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult4.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(2, toProtoResult.getFieldCount());
    assertEquals(2, messageType.getFields().size());
    assertEquals(4, descriptorForType2.getIndex());
    assertEquals(65, toProtoResult.getSerializedSize());
    assertEquals(8, messageType.getIndex());
    assertFalse(toProtoResult.hasOptions());
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
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
    assertTrue(toProtoResult2.getJsonNameBytes().isEmpty());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(messageType.getEnumTypes().isEmpty());
    assertTrue(messageType.getExtensions().isEmpty());
    assertTrue(messageType.getNestedTypes().isEmpty());
    assertTrue(messageType.getOneofs().isEmpty());
    assertTrue(messageType.getRealOneofs().isEmpty());
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertTrue(tsKvListList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualConvertToPostTelemetryResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult4.getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult4.getSourceCodeInfo();
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(actualConvertToPostTelemetryResult, actualConvertToPostTelemetryResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType3 = toProtoResult3.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5, toProtoResult.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    assertSame(fieldList, toProtoResult3.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult5.getParserForType();
    assertSame(parserForType, defaultInstanceForType4.getParserForType());
    assertSame(parserForType, toProtoResult.getParserForType());
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult5.getReservedNameList(), toProtoResult5.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult3.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult4.getDependencyList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult4.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult4.getMessageTypeOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult4.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, messageType.getFile());
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
    DescriptorProtos.MessageOptions options3 = descriptorForType4.getOptions();
    assertSame(options3, defaultInstanceForType4.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, defaultInstanceForType4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, messageType.getOptions());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType3.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult4.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToPostTelemetryResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(tsKvListList, defaultInstanceForType4.getEnumTypeList());
    assertSame(tsKvListList, toProtoResult.getEnumTypeList());
    assertSame(tsKvListList, toProtoResult6.getEnumTypeList());
    assertSame(tsKvListList, toProtoResult5.getEnumTypeList());
    assertSame(tsKvListList, toProtoResult3.getEnumTypeList());
    assertSame(tsKvListList, defaultInstanceForType4.getEnumTypeOrBuilderList());
    assertSame(tsKvListList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(tsKvListList, toProtoResult6.getEnumTypeOrBuilderList());
    assertSame(tsKvListList, toProtoResult5.getEnumTypeOrBuilderList());
    assertSame(tsKvListList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(tsKvListList, defaultInstanceForType4.getExtensionList());
    assertSame(tsKvListList, toProtoResult.getExtensionList());
    assertSame(tsKvListList, toProtoResult6.getExtensionList());
    assertSame(tsKvListList, toProtoResult5.getExtensionList());
    assertSame(tsKvListList, toProtoResult3.getExtensionList());
    assertSame(tsKvListList, defaultInstanceForType4.getExtensionOrBuilderList());
    assertSame(tsKvListList, toProtoResult.getExtensionOrBuilderList());
    assertSame(tsKvListList, toProtoResult6.getExtensionOrBuilderList());
    assertSame(tsKvListList, toProtoResult5.getExtensionOrBuilderList());
    assertSame(tsKvListList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(tsKvListList, defaultInstanceForType4.getExtensionRangeList());
    assertSame(tsKvListList, toProtoResult.getExtensionRangeList());
    assertSame(tsKvListList, toProtoResult5.getExtensionRangeList());
    assertSame(tsKvListList, toProtoResult3.getExtensionRangeList());
    assertSame(tsKvListList, defaultInstanceForType4.getExtensionRangeOrBuilderList());
    assertSame(tsKvListList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(tsKvListList, toProtoResult5.getExtensionRangeOrBuilderList());
    assertSame(tsKvListList, toProtoResult3.getExtensionRangeOrBuilderList());
    assertSame(tsKvListList, defaultInstanceForType4.getFieldList());
    assertSame(tsKvListList, defaultInstanceForType4.getFieldOrBuilderList());
    assertSame(tsKvListList, defaultInstanceForType4.getNestedTypeList());
    assertSame(tsKvListList, toProtoResult.getNestedTypeList());
    assertSame(tsKvListList, toProtoResult6.getNestedTypeList());
    assertSame(tsKvListList, toProtoResult3.getNestedTypeList());
    assertSame(tsKvListList, defaultInstanceForType4.getNestedTypeOrBuilderList());
    assertSame(tsKvListList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(tsKvListList, toProtoResult6.getNestedTypeOrBuilderList());
    assertSame(tsKvListList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(tsKvListList, defaultInstanceForType4.getOneofDeclList());
    assertSame(tsKvListList, toProtoResult.getOneofDeclList());
    assertSame(tsKvListList, toProtoResult6.getOneofDeclList());
    assertSame(tsKvListList, toProtoResult5.getOneofDeclList());
    assertSame(tsKvListList, toProtoResult3.getOneofDeclList());
    assertSame(tsKvListList, defaultInstanceForType4.getOneofDeclOrBuilderList());
    assertSame(tsKvListList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(tsKvListList, toProtoResult6.getOneofDeclOrBuilderList());
    assertSame(tsKvListList, toProtoResult5.getOneofDeclOrBuilderList());
    assertSame(tsKvListList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(tsKvListList, defaultInstanceForType4.getReservedRangeList());
    assertSame(tsKvListList, toProtoResult.getReservedRangeList());
    assertSame(tsKvListList, toProtoResult5.getReservedRangeList());
    assertSame(tsKvListList, toProtoResult3.getReservedRangeList());
    assertSame(tsKvListList, defaultInstanceForType4.getReservedRangeOrBuilderList());
    assertSame(tsKvListList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(tsKvListList, toProtoResult5.getReservedRangeOrBuilderList());
    assertSame(tsKvListList, toProtoResult3.getReservedRangeOrBuilderList());
    assertSame(tsKvListList, options4.getEditionDefaultsList());
    assertSame(tsKvListList, options4.getEditionDefaultsOrBuilderList());
    assertSame(tsKvListList, options4.getUninterpretedOptionList());
    assertSame(tsKvListList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(tsKvListList, defaultInstanceForType2.getEnumTypeList());
    assertSame(tsKvListList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(tsKvListList, defaultInstanceForType2.getExtensionList());
    assertSame(tsKvListList, toProtoResult4.getExtensionList());
    assertSame(tsKvListList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(tsKvListList, toProtoResult4.getExtensionOrBuilderList());
    assertSame(tsKvListList, defaultInstanceForType2.getMessageTypeList());
    assertSame(tsKvListList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(tsKvListList, defaultInstanceForType2.getServiceList());
    assertSame(tsKvListList, toProtoResult4.getServiceList());
    assertSame(tsKvListList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(tsKvListList, toProtoResult4.getServiceOrBuilderList());
    assertSame(tsKvListList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(tsKvListList, options.getUninterpretedOptionList());
    assertSame(tsKvListList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(tsKvListList, options.getUninterpretedOptionOrBuilderList());
    assertSame(tsKvListList, options2.getUninterpretedOptionList());
    assertSame(tsKvListList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(tsKvListList, sourceCodeInfo.getLocationList());
    assertSame(tsKvListList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(tsKvListList, actualConvertToPostTelemetryResult.getTsKvListOrBuilderList());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement)")
  void testConvertToPostTelemetry2() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = lwM2MJsonAdaptor
        .convertToPostTelemetry(new JsonObject());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToPostTelemetryResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    Descriptors.Descriptor descriptorForType4 = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType2, toProtoResult5.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType4 = toProtoResult6.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType5 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, descriptorForType4.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(1);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(178);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(179);
    assertSame(file, getResult6.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType4, getResult2.getMessageType());
    assertSame(descriptorForType, getResult2.getContainingType());
    TransportProtos.PostTelemetryMsg defaultInstanceForType6 = actualConvertToPostTelemetryResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType6.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConvertToPostTelemetryResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, getResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType6.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType6.getDefaultInstanceForType(),
        defaultInstanceForType6.getDefaultInstanceForType());
    assertSame(tsKvListList, actualConvertToPostTelemetryResult.getTsKvListOrBuilderList());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement)")
  void testConvertToPostTelemetry3() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("ts", new JsonArray(3));
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = lwM2MJsonAdaptor
        .convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<TransportProtos.KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    assertEquals("[]", getResult.getJsonV());
    assertEquals(10, getResult.getSerializedSize());
    assertEquals(4, getResult.getTypeValue());
    assertEquals(TransportProtos.KeyValueType.JSON_V, getResult.getType());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement)")
  void testConvertToPostTelemetry4() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", '\u0001');
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = lwM2MJsonAdaptor
        .convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<TransportProtos.KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    assertEquals("\u0001", getResult.getStringV());
    assertEquals(3, getResult.getTypeValue());
    assertEquals(9, getResult.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.STRING_V, getResult.getType());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement)")
  void testConvertToPostTelemetry5() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("values", new JsonArray(3));
    jsonObject.add("ts", new JsonArray(3));
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException(String)} with
   * {@code ts}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); given IllegalStateException(String) with 'ts'")
  void testConvertToPostTelemetry_givenIllegalStateExceptionWithTs() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenThrow(new IllegalStateException("ts"));
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); given JsonArray(int) with capacity is three")
  void testConvertToPostTelemetry_givenJsonArrayWithCapacityIsThree() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); given JsonObject (default constructor)")
  void testConvertToPostTelemetry_givenJsonObject() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(new JsonObject());
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = lwM2MJsonAdaptor
        .convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    assertEquals(1, actualConvertToPostTelemetryResult.getDescriptorForType().getFields().size());
    assertEquals(1, actualConvertToPostTelemetryResult.getTsKvListList().size());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   * <ul>
   *   <li>Then calls {@link JsonElement#getAsJsonArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); then calls getAsJsonArray()")
  void testConvertToPostTelemetry_thenCallsGetAsJsonArray() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonArray()).thenThrow(new IllegalStateException("foo"));
    when(jsonElement.isJsonArray()).thenReturn(true);
    when(jsonElement.isJsonObject()).thenReturn(false);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
    verify(jsonElement).getAsJsonArray();
    verify(jsonElement).isJsonArray();
    verify(jsonElement).isJsonObject();
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   * <ul>
   *   <li>Then return TsKvListList first KvList first LongV is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); then return TsKvListList first KvList first LongV is one")
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstKvListFirstLongVIsOne() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    Integer value = Integer.valueOf(1);
    jsonObject.addProperty("ts", value);
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = lwM2MJsonAdaptor
        .convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    Descriptors.Descriptor descriptorForType = actualConvertToPostTelemetryResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    List<TransportProtos.KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    TransportProtos.KeyValueProto getResult2 = kvList.get(0);
    assertEquals(1L, getResult2.getLongV());
    assertSame(value, descriptorForType.getOptions().getDescriptorForType().toProto().getExtensionRangeCount());
    assertSame(value, descriptorForType.toProto().getFieldCount());
    Descriptors.FieldDescriptor getResult3 = fields.get(0);
    assertSame(value, getResult3.toProto().getNumber());
    assertSame(value, file.toProto().getDescriptorForType().getIndex());
    assertSame(value, messageTypes.get(1).getIndex());
    assertSame(value, enumTypes.get(1).getIndex());
    assertSame(value, getResult3.getNumber());
    assertSame(value, getResult2.getTypeValue());
    assertSame(value, getResult.getKvCount());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   * <ul>
   *   <li>Then return TsKvListList first KvList first TypeValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); then return TsKvListList first KvList first TypeValue is one")
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstKvListFirstTypeValueIsOne() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", "42");
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = lwM2MJsonAdaptor
        .convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<TransportProtos.KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    assertEquals(1, getResult.getTypeValue());
    assertEquals(42L, getResult.getLongV());
    assertEquals(8, getResult.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.LONG_V, getResult.getType());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   * <ul>
   *   <li>Then return TsKvListList first KvList first TypeValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); then return TsKvListList first KvList first TypeValue is zero")
  void testConvertToPostTelemetry_thenReturnTsKvListListFirstKvListFirstTypeValueIsZero() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("ts", true);
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = lwM2MJsonAdaptor
        .convertToPostTelemetry(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<TransportProtos.KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    assertEquals(0, getResult.getTypeValue());
    assertEquals(6, getResult.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.BOOLEAN_V, getResult.getType());
    assertTrue(getResult.getBoolV());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); when JsonArray(int) with capacity is three add 'true'")
  void testConvertToPostTelemetry_whenJsonArrayWithCapacityIsThreeAddTrue() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(jsonElement));
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   *   <li>Then throw {@link AdaptorException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostTelemetry(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(JsonElement); when JsonNull (default constructor); then throw AdaptorException")
  void testConvertToPostTelemetry_whenJsonNull_thenThrowAdaptorException() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostTelemetry(new JsonNull()));
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement)")
  void testConvertToPostAttributes() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act
    TransportProtos.PostAttributeMsg actualConvertToPostAttributesResult = lwM2MJsonAdaptor
        .convertToPostAttributes(new JsonObject());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToPostAttributesResult.getDescriptorForType();
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
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualConvertToPostAttributesResult, actualConvertToPostAttributesResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = toProtoResult3.getDefaultInstanceForType();
    Descriptors.FieldDescriptor getResult = fields.get(0);
    Descriptors.Descriptor messageType = getResult.getMessageType();
    DescriptorProtos.DescriptorProto toProtoResult4 = messageType.toProto();
    assertSame(defaultInstanceForType2, toProtoResult4.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult5.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult.getDependencyList());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType3.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, messageType.getFile());
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
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, messageType.getOptions());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options4, options4.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToPostAttributesResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, getResult6.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement)")
  void testConvertToPostAttributes2() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("Property", '\u0001');
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    TransportProtos.PostAttributeMsg actualConvertToPostAttributesResult = lwM2MJsonAdaptor
        .convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<TransportProtos.KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    ByteString stringVBytes = getResult.getStringVBytes();
    assertEquals("\u0001", stringVBytes.toStringUtf8());
    assertEquals("\u0001", getResult.getStringV());
    assertEquals(15, getResult.getSerializedSize());
    assertEquals(17, actualConvertToPostAttributesResult.getSerializedSize());
    ByteString.ByteIterator iteratorResult = stringVBytes.iterator();
    assertEquals((byte) 1, iteratorResult.next().byteValue());
    assertEquals(3, getResult.getTypeValue());
    assertEquals(TransportProtos.KeyValueType.STRING_V, getResult.getType());
    assertFalse(stringVBytes.isEmpty());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); given IllegalStateException(String) with 'foo'")
  void testConvertToPostAttributes_givenIllegalStateExceptionWithFoo() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenThrow(new IllegalStateException("foo"));
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); given JsonArray(int) with capacity is three")
  void testConvertToPostAttributes_givenJsonArrayWithCapacityIsThree() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(jsonElement));
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); given JsonObject (default constructor)")
  void testConvertToPostAttributes_givenJsonObject() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(new JsonObject());
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    TransportProtos.PostAttributeMsg actualConvertToPostAttributesResult = lwM2MJsonAdaptor
        .convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    Descriptors.Descriptor descriptorForType = actualConvertToPostAttributesResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualConvertToPostAttributesResult, actualConvertToPostAttributesResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto expectedDefaultInstanceForType = descriptorForType.toProto()
        .getDefaultInstanceForType();
    Descriptors.Descriptor messageType = fields.get(0).getMessageType();
    assertSame(expectedDefaultInstanceForType, messageType.toProto().getDefaultInstanceForType());
    Descriptors.FileDescriptor expectedFile = descriptorForType.getFile();
    assertSame(expectedFile, messageType.getFile());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) add {@code Property} and
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); given JsonObject (default constructor) add 'Property' and 'null'")
  void testConvertToPostAttributes_givenJsonObjectAddPropertyAndNull() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("Property", null);
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    TransportProtos.PostAttributeMsg actualConvertToPostAttributesResult = lwM2MJsonAdaptor
        .convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    Descriptors.Descriptor descriptorForType = actualConvertToPostAttributesResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(actualConvertToPostAttributesResult, actualConvertToPostAttributesResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto expectedDefaultInstanceForType = descriptorForType.toProto()
        .getDefaultInstanceForType();
    Descriptors.Descriptor messageType = fields.get(0).getMessageType();
    assertSame(expectedDefaultInstanceForType, messageType.toProto().getDefaultInstanceForType());
    Descriptors.FileDescriptor expectedFile = descriptorForType.getFile();
    assertSame(expectedFile, messageType.getFile());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   * <ul>
   *   <li>Then calls {@link JsonElement#getAsJsonPrimitive()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); then calls getAsJsonPrimitive()")
  void testConvertToPostAttributes_thenCallsGetAsJsonPrimitive() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    JsonElement value = mock(JsonElement.class);
    when(value.getAsJsonPrimitive()).thenThrow(new IllegalStateException("foo"));
    when(value.isJsonObject()).thenReturn(true);
    when(value.isJsonPrimitive()).thenReturn(true);

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("Property", value);
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(value).getAsJsonPrimitive();
    verify(jsonElement).isJsonObject();
    verify(value).isJsonPrimitive();
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   * <ul>
   *   <li>Then return KvList first JsonVBytes iterator hasNext.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); then return KvList first JsonVBytes iterator hasNext")
  void testConvertToPostAttributes_thenReturnKvListFirstJsonVBytesIteratorHasNext() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    JsonElement value = mock(JsonElement.class);
    when(value.isJsonObject()).thenReturn(true);
    when(value.isJsonPrimitive()).thenReturn(false);

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("Property", value);
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    TransportProtos.PostAttributeMsg actualConvertToPostAttributesResult = lwM2MJsonAdaptor
        .convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    verify(value).isJsonObject();
    verify(value).isJsonPrimitive();
    List<TransportProtos.KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    ByteString.ByteIterator iteratorResult = kvList.get(0).getJsonVBytes().iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('M', iteratorResult.next().byteValue());
    assertEquals('o', iteratorResult.next().byteValue());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   * <ul>
   *   <li>Then return KvList first LongV is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); then return KvList first LongV is one")
  void testConvertToPostAttributes_thenReturnKvListFirstLongVIsOne() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    Integer value = Integer.valueOf(1);
    jsonObject.addProperty("Property", value);
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    TransportProtos.PostAttributeMsg actualConvertToPostAttributesResult = lwM2MJsonAdaptor
        .convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<TransportProtos.KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    Descriptors.Descriptor descriptorForType = actualConvertToPostAttributesResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    assertEquals(1L, getResult.getLongV());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertSame(value, descriptorForType.getOptions().getDescriptorForType().toProto().getExtensionRangeCount());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(value, getResult2.toProto().getNumber());
    assertSame(value, file.toProto().getDescriptorForType().getIndex());
    assertSame(value, messageTypes.get(1).getIndex());
    assertSame(value, enumTypes.get(1).getIndex());
    assertSame(value, fields.get(1).getIndex());
    assertSame(value, getResult2.getNumber());
    assertSame(value, getResult.getTypeValue());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   * <ul>
   *   <li>Then return KvList first TypeValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); then return KvList first TypeValue is one")
  void testConvertToPostAttributes_thenReturnKvListFirstTypeValueIsOne() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("Property", "42");
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    TransportProtos.PostAttributeMsg actualConvertToPostAttributesResult = lwM2MJsonAdaptor
        .convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<TransportProtos.KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    assertEquals(1, getResult.getTypeValue());
    assertEquals(14, getResult.getSerializedSize());
    assertEquals(42L, getResult.getLongV());
    assertEquals(TransportProtos.KeyValueType.LONG_V, getResult.getType());
    assertEquals(Short.SIZE, actualConvertToPostAttributesResult.getSerializedSize());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   * <ul>
   *   <li>Then return KvList first TypeValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); then return KvList first TypeValue is zero")
  void testConvertToPostAttributes_thenReturnKvListFirstTypeValueIsZero() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("Property", true);
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act
    TransportProtos.PostAttributeMsg actualConvertToPostAttributesResult = lwM2MJsonAdaptor
        .convertToPostAttributes(jsonElement);

    // Assert
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    List<TransportProtos.KeyValueProto> kvList = actualConvertToPostAttributesResult.getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    assertEquals(0, getResult.getTypeValue());
    assertEquals(12, getResult.getSerializedSize());
    assertEquals(14, actualConvertToPostAttributesResult.getSerializedSize());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(TransportProtos.KeyValueType.BOOLEAN_V, getResult.getType());
    assertTrue(getResult.getBoolV());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); then throw RuntimeException")
  void testConvertToPostAttributes_thenThrowRuntimeException() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    JsonElement value = mock(JsonElement.class);
    when(value.isJsonObject()).thenReturn(true);
    when(value.isJsonPrimitive()).thenReturn(true);
    JsonElement value2 = mock(JsonElement.class);
    when(value2.isJsonObject()).thenThrow(new RuntimeException("foo"));
    when(value2.isJsonPrimitive()).thenThrow(new RuntimeException("foo"));

    JsonObject jsonObject = new JsonObject();
    jsonObject.add("42", value2);
    jsonObject.add("Property", value);
    JsonElement jsonElement = mock(JsonElement.class);
    when(jsonElement.getAsJsonObject()).thenReturn(jsonObject);
    when(jsonElement.isJsonObject()).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(jsonElement));
    verify(jsonElement).getAsJsonObject();
    verify(jsonElement).isJsonObject();
    verify(value2).isJsonPrimitive();
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); when JsonArray(int) with capacity is three")
  void testConvertToPostAttributes_whenJsonArrayWithCapacityIsThree() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(new JsonArray(3)));
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   *   <li>Then throw {@link AdaptorException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToPostAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(JsonElement); when JsonNull (default constructor); then throw AdaptorException")
  void testConvertToPostAttributes_whenJsonNull_thenThrowAdaptorException() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    // Act and Assert
    assertThrows(AdaptorException.class, () -> lwM2MJsonAdaptor.convertToPostAttributes(new JsonNull()));
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}.
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(Collection, Collection)")
  void testConvertToGetAttributes() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TransportProtos.GetAttributeRequestMsg actualConvertToGetAttributesResult = (new LwM2MJsonAdaptor())
        .convertToGetAttributes(null, null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToGetAttributesResult.getDescriptorForType();
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
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertTrue(toProtoResult3.hasName());
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
    DescriptorProtos.FileOptions options2 = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options2.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
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
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
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
    TransportProtos.GetAttributeRequestMsg defaultInstanceForType4 = actualConvertToGetAttributesResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConvertToGetAttributesResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList clientAttributeNamesList = actualConvertToGetAttributesResult.getClientAttributeNamesList();
    assertSame(clientAttributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(clientAttributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(clientAttributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(clientAttributeNamesList, defaultInstanceForType2.getDependencyList());
    assertSame(clientAttributeNamesList, toProtoResult.getDependencyList());
    assertSame(clientAttributeNamesList, defaultInstanceForType4.getClientAttributeNamesList());
    assertSame(clientAttributeNamesList, defaultInstanceForType4.getSharedAttributeNamesList());
    assertSame(clientAttributeNamesList, actualConvertToGetAttributesResult.getSharedAttributeNamesList());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return SharedAttributeNamesList size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(Collection, Collection); given '42'; then return SharedAttributeNamesList size is two")
  void testConvertToGetAttributes_given42_thenReturnSharedAttributeNamesListSizeIsTwo() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    ArrayList<String> clientKeys = new ArrayList<>();

    ArrayList<String> sharedKeys = new ArrayList<>();
    sharedKeys.add("42");
    sharedKeys.add("foo");

    // Act
    TransportProtos.GetAttributeRequestMsg actualConvertToGetAttributesResult = lwM2MJsonAdaptor
        .convertToGetAttributes(clientKeys, sharedKeys);

    // Assert
    ProtocolStringList sharedAttributeNamesList = actualConvertToGetAttributesResult.getSharedAttributeNamesList();
    assertEquals(2, sharedAttributeNamesList.size());
    assertEquals("42", sharedAttributeNamesList.get(0));
    assertEquals("foo", sharedAttributeNamesList.get(1));
    assertEquals(2, actualConvertToGetAttributesResult.getSharedAttributeNamesCount());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return SharedAttributeNamesList size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(Collection, Collection); given 'foo'; then return SharedAttributeNamesList size is one")
  void testConvertToGetAttributes_givenFoo_thenReturnSharedAttributeNamesListSizeIsOne() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    ArrayList<String> clientKeys = new ArrayList<>();

    ArrayList<String> sharedKeys = new ArrayList<>();
    sharedKeys.add("foo");

    // Act
    TransportProtos.GetAttributeRequestMsg actualConvertToGetAttributesResult = lwM2MJsonAdaptor
        .convertToGetAttributes(clientKeys, sharedKeys);

    // Assert
    ProtocolStringList sharedAttributeNamesList = actualConvertToGetAttributesResult.getSharedAttributeNamesList();
    assertEquals(1, sharedAttributeNamesList.size());
    assertEquals("foo", sharedAttributeNamesList.get(0));
    assertEquals(1, actualConvertToGetAttributesResult.getSharedAttributeNamesCount());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}.
   * <ul>
   *   <li>Then return ClientAttributeNamesList size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(Collection, Collection); then return ClientAttributeNamesList size is one")
  void testConvertToGetAttributes_thenReturnClientAttributeNamesListSizeIsOne() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    LinkedHashSet<String> clientKeys = new LinkedHashSet<>();
    clientKeys.add("Client Keys");

    // Act
    TransportProtos.GetAttributeRequestMsg actualConvertToGetAttributesResult = lwM2MJsonAdaptor
        .convertToGetAttributes(clientKeys, null);

    // Assert
    ProtocolStringList clientAttributeNamesList = actualConvertToGetAttributesResult.getClientAttributeNamesList();
    assertEquals(1, clientAttributeNamesList.size());
    assertEquals("Client Keys", clientAttributeNamesList.get(0));
    assertEquals(1, actualConvertToGetAttributesResult.getClientAttributeNamesCount());
    Descriptors.Descriptor descriptorForType = actualConvertToGetAttributesResult.getDescriptorForType();
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
    TransportProtos.GetAttributeRequestMsg defaultInstanceForType4 = actualConvertToGetAttributesResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConvertToGetAttributesResult.getUnknownFields();
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
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    ProtocolStringList sharedAttributeNamesList = actualConvertToGetAttributesResult.getSharedAttributeNamesList();
    assertSame(sharedAttributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(sharedAttributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(sharedAttributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(sharedAttributeNamesList, defaultInstanceForType2.getDependencyList());
    assertSame(sharedAttributeNamesList, toProtoResult.getDependencyList());
    assertSame(sharedAttributeNamesList, defaultInstanceForType4.getClientAttributeNamesList());
    assertSame(sharedAttributeNamesList, defaultInstanceForType4.getSharedAttributeNamesList());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}.
   * <ul>
   *   <li>Then return ClientAttributeNamesList size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(Collection, Collection); then return ClientAttributeNamesList size is two")
  void testConvertToGetAttributes_thenReturnClientAttributeNamesListSizeIsTwo() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();

    ArrayList<String> clientKeys = new ArrayList<>();
    clientKeys.add("");
    clientKeys.add("foo");

    // Act
    TransportProtos.GetAttributeRequestMsg actualConvertToGetAttributesResult = lwM2MJsonAdaptor
        .convertToGetAttributes(clientKeys, new ArrayList<>());

    // Assert
    ProtocolStringList clientAttributeNamesList = actualConvertToGetAttributesResult.getClientAttributeNamesList();
    assertEquals(2, clientAttributeNamesList.size());
    assertEquals("", clientAttributeNamesList.get(0));
    assertEquals("foo", clientAttributeNamesList.get(1));
    assertEquals(2, actualConvertToGetAttributesResult.getClientAttributeNamesCount());
  }

  /**
   * Test {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MJsonAdaptor#convertToGetAttributes(Collection, Collection)}
   */
  @Test
  @DisplayName("Test convertToGetAttributes(Collection, Collection); when ArrayList(); then return AllFields size is one")
  void testConvertToGetAttributes_whenArrayList_thenReturnAllFieldsSizeIsOne() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MJsonAdaptor lwM2MJsonAdaptor = new LwM2MJsonAdaptor();
    ArrayList<String> clientKeys = new ArrayList<>();

    // Act
    TransportProtos.GetAttributeRequestMsg actualConvertToGetAttributesResult = lwM2MJsonAdaptor
        .convertToGetAttributes(clientKeys, new ArrayList<>());

    // Assert
    assertEquals(1, actualConvertToGetAttributesResult.getAllFields().size());
    assertTrue(actualConvertToGetAttributesResult.getSharedAttributeNamesList().isEmpty());
  }
}
