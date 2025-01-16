package org.thingsboard.server.common.adaptor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.google.common.primitives.UnsignedInteger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.gateway.metrics.GatewayMetadata;
import org.thingsboard.server.gen.transport.TransportProtos;

class JsonConverterDiffblueTest {
  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  void testConvertToTelemetryProtoWithJsonElement() throws JsonSyntaxException {
    // Arrange and Act
    TransportProtos.PostTelemetryMsg actualConvertToTelemetryProtoResult = JsonConverter
        .convertToTelemetryProto(new JsonArray(3));

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToTelemetryProtoResult.getDescriptorForType();
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
    assertEquals(0, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(0, actualConvertToTelemetryProtoResult.getTsKvListCount());
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
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertTrue(tsKvListList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualConvertToTelemetryProtoResult.getAllFields();
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
    assertEquals(actualConvertToTelemetryProtoResult, actualConvertToTelemetryProtoResult.getDefaultInstanceForType());
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
    UnknownFieldSet unknownFields = actualConvertToTelemetryProtoResult.getUnknownFields();
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
    assertSame(tsKvListList, actualConvertToTelemetryProtoResult.getTsKvListOrBuilderList());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  void testConvertToTelemetryProtoWithJsonElement2() throws JsonSyntaxException {
    // Arrange and Act
    TransportProtos.PostTelemetryMsg actualConvertToTelemetryProtoResult = JsonConverter
        .convertToTelemetryProto(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1));

    // Assert
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    List<TransportProtos.KeyValueProto> kvList = getResult.getKvList();
    assertEquals(2, kvList.size());
    TransportProtos.KeyValueProto getResult2 = kvList.get(1);
    assertEquals("", getResult2.getInitializationErrorString());
    assertEquals("", getResult2.getJsonV());
    assertEquals("", getResult2.getStringV());
    TransportProtos.KeyValueProto getResult3 = kvList.get(0);
    assertEquals("Device Name", getResult3.getStringV());
    assertEquals("device", getResult3.getKey());
    assertEquals("reason", getResult2.getKey());
    assertEquals(0.0d, getResult2.getDoubleV());
    Descriptors.Descriptor descriptorForType = actualConvertToTelemetryProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    assertEquals(1, getResult2.getTypeValue());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    assertEquals(12, getResult2.getSerializedSize());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(1L, getResult2.getLongV());
    assertEquals(2, getResult.getKvCount());
    assertEquals(23, getResult3.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.LONG_V, getResult2.getType());
    assertFalse(getResult2.getBoolV());
    assertTrue(getResult2.isInitialized());
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
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, descriptorForType4.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(178);
    assertSame(file, getResult6.getFile());
    Descriptors.Descriptor getResult7 = messageTypes.get(179);
    assertSame(file, getResult7.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(0);
    assertSame(file, getResult8.getFile());
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
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult8.getOptions();
    assertSame(options4, options4.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType4, getResult8.getMessageType());
    TransportProtos.TsKvListProto defaultInstanceForType5 = getResult.getDefaultInstanceForType();
    assertSame(descriptorForType4, defaultInstanceForType5.getDescriptorForType());
    assertSame(descriptorForType, getResult8.getContainingType());
    TransportProtos.PostTelemetryMsg defaultInstanceForType6 = actualConvertToTelemetryProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType6.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConvertToTelemetryProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
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
    assertSame(unknownFields, getResult3.getUnknownFields());
    assertSame(unknownFields, getResult2.getUnknownFields());
    assertSame(unknownFields, getResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType6.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType6.getDefaultInstanceForType(),
        defaultInstanceForType6.getDefaultInstanceForType());
    assertSame(tsKvListList, actualConvertToTelemetryProtoResult.getTsKvListOrBuilderList());
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  void testConvertToTelemetryProtoWithJsonElement3() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive('\u0001')));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  void testConvertToTelemetryProtoWithJsonElement4() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  void testConvertToTelemetryProtoWithJsonElement5() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray(3));

    // Act and Assert
    List<TransportProtos.TsKvListProto> tsKvListList = JsonConverter.convertToTelemetryProto(jsonElement)
        .getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<TransportProtos.KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    assertEquals("[]", getResult.getJsonV());
    assertEquals(10, getResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  void testConvertToTelemetryProtoWithJsonElement6() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");

    // Act and Assert
    List<TransportProtos.TsKvListProto> tsKvListList = JsonConverter.convertToTelemetryProto(jsonElement)
        .getTsKvListList();
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
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  void testConvertToTelemetryProtoWithJsonElement7() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", true);

    // Act and Assert
    List<TransportProtos.TsKvListProto> tsKvListList = JsonConverter.convertToTelemetryProto(jsonElement)
        .getTsKvListList();
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
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  void testConvertToTelemetryProtoWithJsonElement8() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");

    // Act and Assert
    List<TransportProtos.TsKvListProto> tsKvListList = JsonConverter.convertToTelemetryProto(jsonElement)
        .getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<TransportProtos.KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    assertEquals(".", getResult.getStringV());
    assertEquals(9, getResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  void testConvertToTelemetryProtoWithJsonElement9() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "");

    // Act and Assert
    List<TransportProtos.TsKvListProto> tsKvListList = JsonConverter.convertToTelemetryProto(jsonElement)
        .getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<TransportProtos.KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    assertEquals(3, getResult.getTypeValue());
    assertEquals(6, getResult.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.STRING_V, getResult.getType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  void testConvertToTelemetryProtoWithJsonElement10() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  void testConvertToTelemetryProtoWithJsonElement11() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  void testConvertToTelemetryProtoWithJsonElement12() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  void testConvertToTelemetryProtoWithJsonElement13() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonObject());

    // Act and Assert
    List<TransportProtos.TsKvListProto> tsKvListList = JsonConverter.convertToTelemetryProto(jsonElement)
        .getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<TransportProtos.KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    assertEquals("{}", getResult.getJsonV());
    assertEquals(10, getResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'")
  void testConvertToTelemetryProtoWithJsonElement14() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", JsonConverter.toGatewayDeviceDisconnectJson("ts", 1));

    // Act and Assert
    List<TransportProtos.TsKvListProto> tsKvListList = JsonConverter.convertToTelemetryProto(jsonElement)
        .getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<TransportProtos.KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    assertEquals("{\"device\":\"ts\",\"reason\":1}", getResult.getJsonV());
    assertEquals(34, getResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  void testConvertToTelemetryProtoWithJsonElementTs() throws JsonSyntaxException {
    // Arrange and Act
    TransportProtos.PostTelemetryMsg actualConvertToTelemetryProtoResult = JsonConverter
        .convertToTelemetryProto(new JsonArray(3), 1L);

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToTelemetryProtoResult.getDescriptorForType();
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
    assertEquals(0, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(0, actualConvertToTelemetryProtoResult.getTsKvListCount());
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
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertTrue(tsKvListList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualConvertToTelemetryProtoResult.getAllFields();
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
    assertEquals(actualConvertToTelemetryProtoResult, actualConvertToTelemetryProtoResult.getDefaultInstanceForType());
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
    UnknownFieldSet unknownFields = actualConvertToTelemetryProtoResult.getUnknownFields();
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
    assertSame(tsKvListList, actualConvertToTelemetryProtoResult.getTsKvListOrBuilderList());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  void testConvertToTelemetryProtoWithJsonElementTs2() throws JsonSyntaxException {
    // Arrange and Act
    TransportProtos.PostTelemetryMsg actualConvertToTelemetryProtoResult = JsonConverter
        .convertToTelemetryProto(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1), 1L);

    // Assert
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    List<TransportProtos.KeyValueProto> kvList = getResult.getKvList();
    assertEquals(2, kvList.size());
    TransportProtos.KeyValueProto getResult2 = kvList.get(1);
    assertEquals("", getResult2.getInitializationErrorString());
    assertEquals("", getResult2.getJsonV());
    assertEquals("", getResult2.getStringV());
    TransportProtos.KeyValueProto getResult3 = kvList.get(0);
    assertEquals("Device Name", getResult3.getStringV());
    assertEquals("device", getResult3.getKey());
    assertEquals("reason", getResult2.getKey());
    assertEquals(0.0d, getResult2.getDoubleV());
    Descriptors.Descriptor descriptorForType = actualConvertToTelemetryProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    assertEquals(1, getResult2.getTypeValue());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    assertEquals(12, getResult2.getSerializedSize());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(1L, getResult2.getLongV());
    assertEquals(2, getResult.getKvCount());
    assertEquals(23, getResult3.getSerializedSize());
    assertEquals(41, getResult.getSerializedSize());
    assertEquals(43, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.LONG_V, getResult2.getType());
    assertFalse(getResult2.getBoolV());
    assertTrue(getResult2.isInitialized());
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
    DescriptorProtos.FileOptions defaultInstanceForType4 = options2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, descriptorForType4.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(178);
    assertSame(file, getResult6.getFile());
    Descriptors.Descriptor getResult7 = messageTypes.get(179);
    assertSame(file, getResult7.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(0);
    assertSame(file, getResult8.getFile());
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
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult8.getOptions();
    assertSame(options4, options4.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult8.toProto();
    assertSame(toProtoResult6, fieldList.get(0));
    assertSame(descriptorForType4, getResult8.getMessageType());
    TransportProtos.TsKvListProto defaultInstanceForType5 = getResult.getDefaultInstanceForType();
    assertSame(descriptorForType4, defaultInstanceForType5.getDescriptorForType());
    assertSame(descriptorForType, getResult8.getContainingType());
    TransportProtos.PostTelemetryMsg defaultInstanceForType6 = actualConvertToTelemetryProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType6.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConvertToTelemetryProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
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
    assertSame(unknownFields, getResult3.getUnknownFields());
    assertSame(unknownFields, getResult2.getUnknownFields());
    assertSame(unknownFields, getResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType6.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType6.getDefaultInstanceForType(),
        defaultInstanceForType6.getDefaultInstanceForType());
    assertSame(tsKvListList, actualConvertToTelemetryProtoResult.getTsKvListOrBuilderList());
    assertSame(defaultInstanceForType5.getDefaultInstanceForType(),
        defaultInstanceForType5.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  void testConvertToTelemetryProtoWithJsonElementTs3() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive('\u0001'), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  void testConvertToTelemetryProtoWithJsonElementTs4() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  void testConvertToTelemetryProtoWithJsonElementTs5() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray(3));

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToTelemetryProtoResult = JsonConverter
        .convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    List<TransportProtos.KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult2 = kvList.get(0);
    assertEquals("[]", getResult2.getJsonV());
    assertEquals(10, getResult2.getSerializedSize());
    assertEquals(14, getResult.getSerializedSize());
    assertEquals(4, getResult2.getTypeValue());
    assertEquals(TransportProtos.KeyValueType.JSON_V, getResult2.getType());
    assertEquals(Short.SIZE, actualConvertToTelemetryProtoResult.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  void testConvertToTelemetryProtoWithJsonElementTs6() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToTelemetryProtoResult = JsonConverter
        .convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    List<TransportProtos.KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult2 = kvList.get(0);
    assertEquals(1, getResult2.getTypeValue());
    assertEquals(12, getResult.getSerializedSize());
    assertEquals(14, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(42L, getResult2.getLongV());
    assertEquals(8, getResult2.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.LONG_V, getResult2.getType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  void testConvertToTelemetryProtoWithJsonElementTs7() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", true);

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToTelemetryProtoResult = JsonConverter
        .convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    List<TransportProtos.KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult2 = kvList.get(0);
    assertEquals(0, getResult2.getTypeValue());
    assertEquals(10, getResult.getSerializedSize());
    assertEquals(12, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(6, getResult2.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.BOOLEAN_V, getResult2.getType());
    assertTrue(getResult2.getBoolV());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  void testConvertToTelemetryProtoWithJsonElementTs8() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToTelemetryProtoResult = JsonConverter
        .convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    List<TransportProtos.KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    TransportProtos.KeyValueProto getResult2 = kvList.get(0);
    assertEquals(".", getResult2.getStringV());
    assertEquals(13, getResult.getSerializedSize());
    assertEquals(15, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertEquals(9, getResult2.getSerializedSize());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  void testConvertToTelemetryProtoWithJsonElementTs9() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "");

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToTelemetryProtoResult = JsonConverter
        .convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    List<TransportProtos.KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    assertEquals(10, getResult.getSerializedSize());
    assertEquals(12, actualConvertToTelemetryProtoResult.getSerializedSize());
    TransportProtos.KeyValueProto getResult2 = kvList.get(0);
    assertEquals(3, getResult2.getTypeValue());
    assertEquals(6, getResult2.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.STRING_V, getResult2.getType());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  void testConvertToTelemetryProtoWithJsonElementTs10() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'")
  void testConvertToTelemetryProtoWithJsonElementTs11() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given 'A'")
  void testConvertToTelemetryProtoWithJsonElementTs_givenA() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given 'false'")
  void testConvertToTelemetryProtoWithJsonElementTs_givenFalse() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>Given fromIntBits one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given fromIntBits one")
  void testConvertToTelemetryProtoWithJsonElementTs_givenFromIntBitsOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given JsonArray(int) with capacity is three")
  void testConvertToTelemetryProtoWithJsonElementTs_givenJsonArrayWithCapacityIsThree() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given JsonObject (default constructor)")
  void testConvertToTelemetryProtoWithJsonElementTs_givenJsonObject() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>Given {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given NaN")
  void testConvertToTelemetryProtoWithJsonElementTs_givenNaN() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given 'null'")
  void testConvertToTelemetryProtoWithJsonElementTs_givenNull() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", (String) null);

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToTelemetryProtoResult = JsonConverter
        .convertToTelemetryProto(jsonElement, 1L);

    // Assert
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertEquals(1, actualConvertToTelemetryProtoResult.getDescriptorForType().getFields().size());
    assertEquals(1, getResult.getAllFields().size());
    assertEquals(2, getResult.getSerializedSize());
    assertEquals(4, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given one")
  void testConvertToTelemetryProtoWithJsonElementTs_givenOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given one")
  void testConvertToTelemetryProtoWithJsonElementTs_givenOne2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>Given ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given ten")
  void testConvertToTelemetryProtoWithJsonElementTs_givenTen() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>Given ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given ten")
  void testConvertToTelemetryProtoWithJsonElementTs_givenTen2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>Given valueOf one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; given valueOf one")
  void testConvertToTelemetryProtoWithJsonElementTs_givenValueOfOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; when JsonNull (default constructor)")
  void testConvertToTelemetryProtoWithJsonElementTs_whenJsonNull() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(new JsonNull(), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; when JsonObject (default constructor)")
  void testConvertToTelemetryProtoWithJsonElementTs_whenJsonObject() throws JsonSyntaxException {
    // Arrange and Act
    TransportProtos.PostTelemetryMsg actualConvertToTelemetryProtoResult = JsonConverter
        .convertToTelemetryProto(new JsonObject(), 1L);

    // Assert
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertEquals(1, actualConvertToTelemetryProtoResult.getDescriptorForType().getFields().size());
    assertEquals(1, getResult.getAllFields().size());
    assertEquals(2, getResult.getSerializedSize());
    assertEquals(4, actualConvertToTelemetryProtoResult.getSerializedSize());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; when JsonPrimitive(Boolean) with bool is 'true'")
  void testConvertToTelemetryProtoWithJsonElementTs_whenJsonPrimitiveWithBoolIsTrue() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive(true), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement, long)} with
   * {@code jsonElement}, {@code ts}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with
   * {@code String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetryProto(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement, long) with 'jsonElement', 'ts'; when JsonPrimitive(String) with 'String'")
  void testConvertToTelemetryProtoWithJsonElementTs_whenJsonPrimitiveWithString() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive("String"), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given 'A'")
  void testConvertToTelemetryProtoWithJsonElement_givenA() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given 'false'")
  void testConvertToTelemetryProtoWithJsonElement_givenFalse() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>Given fromIntBits one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given fromIntBits one")
  void testConvertToTelemetryProtoWithJsonElement_givenFromIntBitsOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given JsonArray(int) with capacity is three")
  void testConvertToTelemetryProtoWithJsonElement_givenJsonArrayWithCapacityIsThree() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>Given {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given NaN")
  void testConvertToTelemetryProtoWithJsonElement_givenNaN() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given 'null'")
  void testConvertToTelemetryProtoWithJsonElement_givenNull() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", (String) null);

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToTelemetryProtoResult = JsonConverter
        .convertToTelemetryProto(jsonElement);

    // Assert
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertEquals(1, actualConvertToTelemetryProtoResult.getDescriptorForType().getFields().size());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given one")
  void testConvertToTelemetryProtoWithJsonElement_givenOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given one")
  void testConvertToTelemetryProtoWithJsonElement_givenOne2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>Given ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given ten")
  void testConvertToTelemetryProtoWithJsonElement_givenTen() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>Given ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given ten")
  void testConvertToTelemetryProtoWithJsonElement_givenTen2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>Given valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; given valueOf one")
  void testConvertToTelemetryProtoWithJsonElement_givenValueOfOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; when JsonNull (default constructor)")
  void testConvertToTelemetryProtoWithJsonElement_whenJsonNull() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(new JsonNull()));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; when JsonObject (default constructor)")
  void testConvertToTelemetryProtoWithJsonElement_whenJsonObject() throws JsonSyntaxException {
    // Arrange and Act
    TransportProtos.PostTelemetryMsg actualConvertToTelemetryProtoResult = JsonConverter
        .convertToTelemetryProto(new JsonObject());

    // Assert
    List<TransportProtos.TsKvListProto> tsKvListList = actualConvertToTelemetryProtoResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertEquals(1, actualConvertToTelemetryProtoResult.getDescriptorForType().getFields().size());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; when JsonPrimitive(Boolean) with bool is 'true'")
  void testConvertToTelemetryProtoWithJsonElement_whenJsonPrimitiveWithBoolIsTrue() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive(true)));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetryProto(JsonElement)} with
   * {@code jsonElement}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with
   * {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToTelemetryProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToTelemetryProto(JsonElement) with 'jsonElement'; when JsonPrimitive(String) with 'String'")
  void testConvertToTelemetryProtoWithJsonElement_whenJsonPrimitiveWithString() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetryProto(new JsonPrimitive("String")));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long)")
  void testConvertToGatewayTelemetry() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter
        .convertToGatewayTelemetry(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", -1), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long)")
  void testConvertToGatewayTelemetry2() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("ts", new JsonArray(3));

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long)")
  void testConvertToGatewayTelemetry3() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("metadata", new JsonArray(3));

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given empty string")
  void testConvertToGatewayTelemetry_givenEmptyString() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add("");
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given 'false'")
  void testConvertToGatewayTelemetry_givenFalse() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given JsonArray(int) with capacity is three")
  void testConvertToGatewayTelemetry_givenJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given JsonArray(int) with capacity is three add 'false'")
  void testConvertToGatewayTelemetry_givenJsonArrayWithCapacityIsThreeAddFalse() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given JsonArray(int) with capacity is three add 'true'")
  void testConvertToGatewayTelemetry_givenJsonArrayWithCapacityIsThreeAddTrue() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor)")
  void testConvertToGatewayTelemetry_givenJsonObject() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code ts} and
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) addProperty 'ts' and '42'")
  void testConvertToGatewayTelemetry_givenJsonObjectAddPropertyTsAnd42() {
    // Arrange
    JsonObject element = new JsonObject();
    element.addProperty("ts", "42");

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code ts} and
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) addProperty 'ts' and empty string")
  void testConvertToGatewayTelemetry_givenJsonObjectAddPropertyTsAndEmptyString() {
    // Arrange
    JsonObject element = new JsonObject();
    element.addProperty("ts", "");

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor) addProperty {@code ts} and
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given JsonObject (default constructor) addProperty 'ts' and 'true'")
  void testConvertToGatewayTelemetry_givenJsonObjectAddPropertyTsAndTrue() {
    // Arrange
    JsonObject element = new JsonObject();
    element.addProperty("ts", true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given start of heading.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given start of heading")
  void testConvertToGatewayTelemetry_givenStartOfHeading() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add('\u0001');
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given toGatewayDeviceDisconnectJson {@code Device Name} and one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given toGatewayDeviceDisconnectJson 'Device Name' and one")
  void testConvertToGatewayTelemetry_givenToGatewayDeviceDisconnectJsonDeviceNameAndOne() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); given 'true'; when JsonArray(int) with capacity is three add 'true'")
  void testConvertToGatewayTelemetry_givenTrue_whenJsonArrayWithCapacityIsThreeAddTrue() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); when JsonArray(int) with capacity is one")
  void testConvertToGatewayTelemetry_whenJsonArrayWithCapacityIsOne() {
    // Arrange and Act
    TbPair<TransportProtos.PostTelemetryMsg, List<GatewayMetadata>> actualConvertToGatewayTelemetryResult = JsonConverter
        .convertToGatewayTelemetry(new JsonArray(1), 1L);

    // Assert
    TransportProtos.PostTelemetryMsg first = actualConvertToGatewayTelemetryResult.getFirst();
    Descriptors.Descriptor descriptorForType = first.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    assertEquals(first, first.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
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
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, messageType.getOptions());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult6.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    UnknownFieldSet unknownFields = first.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); when JsonArray(int) with capacity is three")
  void testConvertToGatewayTelemetry_whenJsonArrayWithCapacityIsThree() {
    // Arrange and Act
    TbPair<TransportProtos.PostTelemetryMsg, List<GatewayMetadata>> actualConvertToGatewayTelemetryResult = JsonConverter
        .convertToGatewayTelemetry(new JsonArray(3), 1L);

    // Assert
    TransportProtos.PostTelemetryMsg first = actualConvertToGatewayTelemetryResult.getFirst();
    Descriptors.Descriptor descriptorForType = first.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
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
    assertEquals(first, first.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
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
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult4.getParserForType());
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType3 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType3.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult.toProto();
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
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, messageType.getOptions());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult6.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(descriptorForType, getResult.getContainingType());
    UnknownFieldSet unknownFields = first.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   *   <li>Then throw {@link JsonSyntaxException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); when JsonNull (default constructor); then throw JsonSyntaxException")
  void testConvertToGatewayTelemetry_whenJsonNull_thenThrowJsonSyntaxException() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(new JsonNull(), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   *   <li>Then throw {@link JsonSyntaxException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); when JsonObject (default constructor); then throw JsonSyntaxException")
  void testConvertToGatewayTelemetry_whenJsonObject_thenThrowJsonSyntaxException() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(new JsonObject(), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToGatewayTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToGatewayTelemetry(JsonElement, long); when JsonPrimitive(Boolean) with bool is 'true'")
  void testConvertToGatewayTelemetry_whenJsonPrimitiveWithBoolIsTrue() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToGatewayTelemetry(new JsonPrimitive(true), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  void testConvertToTelemetryWithJsonElementSystemTs() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(new JsonPrimitive('\u0001'), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  void testConvertToTelemetryWithJsonElementSystemTs2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  void testConvertToTelemetryWithJsonElementSystemTs3() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof StringDataEntry);
    Optional<String> strValue = getResult2.getStrValue();
    assertEquals("", strValue.get());
    assertEquals("", getResult2.getValueAsString());
    assertEquals("", getResult2.getValue());
    assertEquals(DataType.STRING, getResult2.getDataType());
    assertTrue(strValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  void testConvertToTelemetryWithJsonElementSystemTs4() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'")
  void testConvertToTelemetryWithJsonElementSystemTs5() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(new JsonArray(3), 1L,
        true);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted2() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(new JsonPrimitive(true), 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted3() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetry(new JsonPrimitive('\u0001'), 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted4() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted5() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted6() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray(3));

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals(DataType.JSON, getResult2.getDataType());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted7() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof LongDataEntry);
    assertEquals("42", getResult2.getValueAsString());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(42L, longValue.get().longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    assertTrue(longValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted8() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", true);

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof BooleanDataEntry);
    assertEquals(DataType.BOOLEAN, getResult2.getDataType());
    Optional<Double> doubleValue = getResult2.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertTrue(booleanValue.get());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.TRUE.toString();
    assertEquals(expectedValueAsString, getResult2.getValueAsString());
    assertSame(doubleValue, getResult2.getJsonValue());
    assertSame(doubleValue, getResult2.getLongValue());
    assertSame(doubleValue, getResult2.getStrValue());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted9() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof StringDataEntry);
    Optional<String> strValue = getResult2.getStrValue();
    assertEquals(".", strValue.get());
    assertEquals(".", getResult2.getValueAsString());
    assertEquals(".", getResult2.getValue());
    assertEquals(DataType.STRING, getResult2.getDataType());
    assertTrue(strValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted10() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof StringDataEntry);
    Optional<String> strValue = getResult2.getStrValue();
    assertEquals("", strValue.get());
    assertEquals("", getResult2.getValueAsString());
    assertEquals("", getResult2.getValue());
    assertEquals(DataType.STRING, getResult2.getDataType());
    assertTrue(strValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted11() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted12() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given 'A'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenA() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given 'false'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenFalse() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>Given fromIntBits one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given fromIntBits one")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenFromIntBitsOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given JsonObject (default constructor)")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenJsonObject() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>Given {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given NaN")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenNaN() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given 'null'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenNull() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", (String) null);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given one")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given one")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenOne2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>Given ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given ten")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenTen() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>Given ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given ten")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenTen2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>Given valueOf one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; given valueOf one")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_givenValueOfOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>Then return one size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; then return one size is two")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_thenReturnOneSizeIsTwo() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter
        .convertToTelemetry(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1), 1L, true);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(1);
    assertTrue(getResult2 instanceof LongDataEntry);
    KvEntry getResult3 = getResult.get(0);
    assertTrue(getResult3 instanceof StringDataEntry);
    assertEquals("1", getResult2.getValueAsString());
    assertEquals("Device Name", getResult3.getStrValue().get());
    assertEquals("Device Name", getResult3.getValueAsString());
    assertEquals("Device Name", getResult3.getValue());
    assertEquals("device", getResult3.getKey());
    assertEquals("reason", getResult2.getKey());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(1L, longValue.get().longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    assertTrue(longValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; when 'false'; then return Empty")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_whenFalse_thenReturnEmpty() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(new JsonArray(3), 1L,
        false);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; when JsonNull (default constructor)")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_whenJsonNull() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(new JsonNull(), 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; when JsonObject (default constructor)")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_whenJsonObject() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(new JsonObject(), 1L,
        true);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   * with {@code jsonElement}, {@code systemTs}, {@code sorted}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with
   * {@code String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long, boolean)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long, boolean) with 'jsonElement', 'systemTs', 'sorted'; when JsonPrimitive(String) with 'String'")
  void testConvertToTelemetryWithJsonElementSystemTsSorted_whenJsonPrimitiveWithString() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToTelemetry(new JsonPrimitive("String"), 1L, true));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given 'A'")
  void testConvertToTelemetryWithJsonElementSystemTs_givenA() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given 'false'")
  void testConvertToTelemetryWithJsonElementSystemTs_givenFalse() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Given fromIntBits one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given fromIntBits one")
  void testConvertToTelemetryWithJsonElementSystemTs_givenFromIntBitsOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given JsonArray(int) with capacity is three")
  void testConvertToTelemetryWithJsonElementSystemTs_givenJsonArrayWithCapacityIsThree() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given JsonObject (default constructor)")
  void testConvertToTelemetryWithJsonElementSystemTs_givenJsonObject() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Given {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given NaN")
  void testConvertToTelemetryWithJsonElementSystemTs_givenNaN() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given 'null'")
  void testConvertToTelemetryWithJsonElementSystemTs_givenNull() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", (String) null);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given one")
  void testConvertToTelemetryWithJsonElementSystemTs_givenOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given one")
  void testConvertToTelemetryWithJsonElementSystemTs_givenOne2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Given ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given ten")
  void testConvertToTelemetryWithJsonElementSystemTs_givenTen() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Given ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given ten")
  void testConvertToTelemetryWithJsonElementSystemTs_givenTen2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Given valueOf one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; given valueOf one")
  void testConvertToTelemetryWithJsonElementSystemTs_givenValueOfOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Then one first return {@link BooleanDataEntry}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; then one first return BooleanDataEntry")
  void testConvertToTelemetryWithJsonElementSystemTs_thenOneFirstReturnBooleanDataEntry() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", true);

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof BooleanDataEntry);
    assertEquals(DataType.BOOLEAN, getResult2.getDataType());
    Optional<Double> doubleValue = getResult2.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertTrue(booleanValue.get());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.TRUE.toString();
    assertEquals(expectedValueAsString, getResult2.getValueAsString());
    assertSame(doubleValue, getResult2.getJsonValue());
    assertSame(doubleValue, getResult2.getLongValue());
    assertSame(doubleValue, getResult2.getStrValue());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Then one first return {@link JsonDataEntry}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; then one first return JsonDataEntry")
  void testConvertToTelemetryWithJsonElementSystemTs_thenOneFirstReturnJsonDataEntry() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray(3));

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals(DataType.JSON, getResult2.getDataType());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Then one first return {@link LongDataEntry}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; then one first return LongDataEntry")
  void testConvertToTelemetryWithJsonElementSystemTs_thenOneFirstReturnLongDataEntry() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof LongDataEntry);
    assertEquals("42", getResult2.getValueAsString());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(42L, longValue.get().longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    assertTrue(longValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Then return one first StrValue is {@code .}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; then return one first StrValue is '.'")
  void testConvertToTelemetryWithJsonElementSystemTs_thenReturnOneFirstStrValueIsDot() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");

    // Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(jsonElement, 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof StringDataEntry);
    Optional<String> strValue = getResult2.getStrValue();
    assertEquals(".", strValue.get());
    assertEquals(".", getResult2.getValueAsString());
    assertEquals(".", getResult2.getValue());
    assertEquals(DataType.STRING, getResult2.getDataType());
    assertTrue(strValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>Then return one size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; then return one size is two")
  void testConvertToTelemetryWithJsonElementSystemTs_thenReturnOneSizeIsTwo() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter
        .convertToTelemetry(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1), 1L);

    // Assert
    assertEquals(1, actualConvertToTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(1);
    assertTrue(getResult2 instanceof LongDataEntry);
    KvEntry getResult3 = getResult.get(0);
    assertTrue(getResult3 instanceof StringDataEntry);
    assertEquals("1", getResult2.getValueAsString());
    assertEquals("Device Name", getResult3.getStrValue().get());
    assertEquals("Device Name", getResult3.getValueAsString());
    assertEquals("Device Name", getResult3.getValue());
    assertEquals("device", getResult3.getKey());
    assertEquals("reason", getResult2.getKey());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(1L, longValue.get().longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    assertTrue(longValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonArray(int) with capacity is three")
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonArrayWithCapacityIsThree() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(new JsonArray(3), 1L);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonNull (default constructor)")
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonNull() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(new JsonNull(), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonObject (default constructor); then return Empty")
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonObject_thenReturnEmpty() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToTelemetryResult = JsonConverter.convertToTelemetry(new JsonObject(), 1L);

    // Assert
    assertTrue(actualConvertToTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonPrimitive(Boolean) with bool is 'true'")
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonPrimitiveWithBoolIsTrue() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(new JsonPrimitive(true), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToTelemetry(JsonElement, long)} with
   * {@code jsonElement}, {@code systemTs}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with
   * {@code String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToTelemetry(JsonElement, long) with 'jsonElement', 'systemTs'; when JsonPrimitive(String) with 'String'")
  void testConvertToTelemetryWithJsonElementSystemTs_whenJsonPrimitiveWithString() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToTelemetry(new JsonPrimitive("String"), 1L));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json},
   * {@code clazz}.
   * <ul>
   *   <li>When {@code client}.</li>
   *   <li>Then return {@code client}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when 'client'; then return 'client'")
  void testParseWithJsonClazz_whenClient_thenReturnClient() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("client", JsonConverter.parse("client", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json},
   * {@code clazz}.
   * <ul>
   *   <li>When {@code com.google.gson.JsonElement}.</li>
   *   <li>Then return {@link JsonPrimitive}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when 'com.google.gson.JsonElement'; then return JsonPrimitive")
  void testParseWithJsonClazz_whenComGoogleGsonJsonElement_thenReturnJsonPrimitive() {
    // Arrange
    Class<JsonElement> clazz = JsonElement.class;

    // Act
    Object actualParseResult = JsonConverter.parse("Json", clazz);

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = ((JsonPrimitive) actualParseResult).getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("Json", ((JsonPrimitive) actualParseResult).getAsString());
    assertEquals("Json", asNumber.toString());
    assertEquals('J', ((JsonPrimitive) actualParseResult).getAsCharacter());
    assertFalse(((JsonPrimitive) actualParseResult).isJsonArray());
    assertFalse(((JsonPrimitive) actualParseResult).isJsonNull());
    assertFalse(((JsonPrimitive) actualParseResult).isJsonObject());
    assertFalse(((JsonPrimitive) actualParseResult).getAsBoolean());
    assertFalse(((JsonPrimitive) actualParseResult).isBoolean());
    assertFalse(((JsonPrimitive) actualParseResult).isNumber());
    assertTrue(((JsonPrimitive) actualParseResult).isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualParseResult).isString());
    assertSame(actualParseResult, ((JsonPrimitive) actualParseResult).getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json},
   * {@code clazz}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when '.'; then return '.'")
  void testParseWithJsonClazz_whenDot_thenReturnDot() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(".", JsonConverter.parse(".", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json},
   * {@code clazz}.
   * <ul>
   *   <li>When {@code E}.</li>
   *   <li>Then return {@code E}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when 'E'; then return 'E'")
  void testParseWithJsonClazz_whenE_thenReturnE() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("E", JsonConverter.parse("E", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json},
   * {@code clazz}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return doubleValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when 'java.lang.Object'; then return doubleValue is forty-two")
  void testParseWithJsonClazz_whenJavaLangObject_thenReturnDoubleValueIsFortyTwo() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(42.0d, ((Double) JsonConverter.parse("42", clazz)).doubleValue());
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json},
   * {@code clazz}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when 'java.lang.Object'; then return 'Json'")
  void testParseWithJsonClazz_whenJavaLangObject_thenReturnJson() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("Json", JsonConverter.parse("Json", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json},
   * {@code clazz}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when 'java.lang.Object'; then return 'null'")
  void testParseWithJsonClazz_whenJavaLangObject_thenReturnNull() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(JsonConverter.parse("", clazz));
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json},
   * {@code clazz}.
   * <ul>
   *   <li>When {@link Double#TYPE}.</li>
   *   <li>Then return doubleValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return doubleValue is forty-two")
  void testParseWithJsonClazz_whenType_thenReturnDoubleValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0d, ((Double) JsonConverter.parse("42", Double.TYPE)).doubleValue());
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json},
   * {@code clazz}.
   * <ul>
   *   <li>When {@link Float#TYPE}.</li>
   *   <li>Then return floatValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return floatValue is forty-two")
  void testParseWithJsonClazz_whenType_thenReturnFloatValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0f, ((Float) JsonConverter.parse("42", Float.TYPE)).floatValue());
  }

  /**
   * Test {@link JsonConverter#parse(String, Class)} with {@code json},
   * {@code clazz}.
   * <ul>
   *   <li>When {@link Integer#TYPE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String, Class)}
   */
  @Test
  @DisplayName("Test parse(String, Class) with 'json', 'clazz'; when TYPE; then return 'null'")
  void testParseWithJsonClazz_whenType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.parse("", Integer.TYPE));
    assertNull(JsonConverter.parse("", Float.TYPE));
    assertNull(JsonConverter.parse("", Byte.TYPE));
    assertNull(JsonConverter.parse("", Double.TYPE));
    assertNull(JsonConverter.parse("", Long.TYPE));
    assertNull(JsonConverter.parse("", Character.TYPE));
    assertNull(JsonConverter.parse("", Short.TYPE));
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return AsString is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when '42'; then return AsString is '42'")
  void testParseWithJson_when42_thenReturnAsStringIs42() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("42");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("42", actualParseResult.getAsString());
    assertEquals("42", asNumber.toString());
    BigInteger asBigInteger = actualParseResult.getAsBigInteger();
    assertEquals("42", asBigInteger.toString());
    assertEquals(1, asBigInteger.getLowestSetBit());
    assertEquals(1, asBigInteger.signum());
    assertEquals(42, actualParseResult.getAsInt());
    assertEquals(42L, actualParseResult.getAsLong());
    assertEquals((short) 42, actualParseResult.getAsShort());
    assertFalse(((JsonPrimitive) actualParseResult).isString());
    assertTrue(((JsonPrimitive) actualParseResult).isNumber());
    assertEquals('*', actualParseResult.getAsByte());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
    assertArrayEquals(new byte[]{'*'}, asBigInteger.toByteArray());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   * <ul>
   *   <li>When {@code 42.}.</li>
   *   <li>Then return AsString is {@code 42.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when '42.'; then return AsString is '42.'")
  void testParseWithJson_when42_thenReturnAsStringIs422() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("42.");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("42.", actualParseResult.getAsString());
    assertEquals("42.", asNumber.toString());
    assertEquals(42.0d, actualParseResult.getAsDouble());
    assertEquals(42.0f, actualParseResult.getAsFloat());
    BigDecimal expectedAsBigDecimal = new BigDecimal("42");
    assertEquals(expectedAsBigDecimal, actualParseResult.getAsBigDecimal());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   * <ul>
   *   <li>When {@code 42E}.</li>
   *   <li>Then return AsString is {@code 42E}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when '42E'; then return AsString is '42E'")
  void testParseWithJson_when42e_thenReturnAsStringIs42e() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("42E");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("42E", actualParseResult.getAsString());
    assertEquals("42E", asNumber.toString());
    assertEquals('4', actualParseResult.getAsCharacter());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   * <ul>
   *   <li>When {@code client}.</li>
   *   <li>Then return AsString is {@code client}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when 'client'; then return AsString is 'client'")
  void testParseWithJson_whenClient_thenReturnAsStringIsClient() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("client");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("client", actualParseResult.getAsString());
    assertEquals("client", asNumber.toString());
    assertEquals('c', actualParseResult.getAsCharacter());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return AsString is {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when '.'; then return AsString is '.'")
  void testParseWithJson_whenDot_thenReturnAsStringIsDot() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse(".");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals(".", actualParseResult.getAsString());
    assertEquals(".", asNumber.toString());
    assertEquals('.', actualParseResult.getAsCharacter());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   * <ul>
   *   <li>When {@code E}.</li>
   *   <li>Then return AsString is {@code E}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when 'E'; then return AsString is 'E'")
  void testParseWithJson_whenE_thenReturnAsStringIsE() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("E");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("E", actualParseResult.getAsString());
    assertEquals("E", asNumber.toString());
    assertEquals('E', actualParseResult.getAsCharacter());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@link JsonNull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when empty string; then return JsonNull")
  void testParseWithJson_whenEmptyString_thenReturnJsonNull() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("");

    // Assert
    assertTrue(actualParseResult instanceof JsonNull);
    assertFalse(actualParseResult.isJsonPrimitive());
    assertTrue(actualParseResult.isJsonNull());
    JsonNull expectedAsJsonNull = ((JsonNull) actualParseResult).INSTANCE;
    assertSame(expectedAsJsonNull, actualParseResult.getAsJsonNull());
  }

  /**
   * Test {@link JsonConverter#parse(String)} with {@code json}.
   * <ul>
   *   <li>When {@code Json}.</li>
   *   <li>Then return AsString is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'json'; when 'Json'; then return AsString is 'Json'")
  void testParseWithJson_whenJson_thenReturnAsStringIsJson() {
    // Arrange and Act
    JsonElement actualParseResult = JsonConverter.parse("Json");

    // Assert
    assertTrue(actualParseResult instanceof JsonPrimitive);
    Number asNumber = actualParseResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("Json", actualParseResult.getAsString());
    assertEquals("Json", asNumber.toString());
    assertEquals('J', actualParseResult.getAsCharacter());
    assertSame(actualParseResult, actualParseResult.getAsJsonPrimitive());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).</li>
   *   <li>Then first return {@link Map}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); given JsonObject (default constructor); then first return Map")
  void testFromJson_givenJsonObject_thenFirstReturnMap() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(new JsonObject());
    element.add(true);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertEquals(2, ((List<Object>) actualFromJsonResult).size());
    Object getResult = ((List<Object>) actualFromJsonResult).get(0);
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); given 'true'; then return size is one")
  void testFromJson_givenTrue_thenReturnSizeIsOne() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertEquals(1, ((List<Boolean>) actualFromJsonResult).size());
    assertTrue(((List<Boolean>) actualFromJsonResult).get(0));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>Then empty string return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then empty string return List")
  void testFromJson_thenEmptyStringReturnList() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("", new JsonArray(3));
    element.add("42", new JsonArray(3));
    element.add("Property", new JsonArray(3));
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertEquals(5, ((Map<String, Object>) actualFromJsonResult).size());
    Object getResult = ((Map<String, Object>) actualFromJsonResult).get("");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("device"));
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("reason"));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get("42"));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get("Property"));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>Then empty string return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then empty string return List")
  void testFromJson_thenEmptyStringReturnList2() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("", new JsonArray(3));
    element.add("Property", new JsonArray(3));
    element.add("", new JsonArray(3));
    element.add("42", new JsonArray(3));
    element.add("Property", new JsonArray(3));
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertEquals(5, ((Map<String, Object>) actualFromJsonResult).size());
    Object getResult = ((Map<String, Object>) actualFromJsonResult).get("");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("device"));
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("reason"));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get("42"));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get("Property"));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>Then first return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then first return List")
  void testFromJson_thenFirstReturnList() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(new JsonArray(3));
    element.add(true);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertEquals(2, ((List<Object>) actualFromJsonResult).size());
    Object getResult = ((List<Object>) actualFromJsonResult).get(0);
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>Then {@code Property} return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then 'Property' return List")
  void testFromJson_thenPropertyReturnList() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("Property", new JsonArray(3));
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertEquals(3, ((Map<String, Object>) actualFromJsonResult).size());
    Object getResult = ((Map<String, Object>) actualFromJsonResult).get("Property");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals("Device Name", ((Map<String, Object>) actualFromJsonResult).get("device"));
    assertEquals(1.0d, ((Double) ((Map<String, Object>) actualFromJsonResult).get("reason")).doubleValue());
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>Then return empty string is {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then return empty string is 'Property'")
  void testFromJson_thenReturnEmptyStringIsProperty() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("Property", new JsonArray(3));
    element.add("", new JsonArray(3));
    element.add("42", new JsonArray(3));
    element.add("Property", new JsonArray(3));
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertEquals(5, ((Map<String, Object>) actualFromJsonResult).size());
    Object getResult = ((Map<String, Object>) actualFromJsonResult).get("Property");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("device"));
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("reason"));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get(""));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get("42"));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>Then return {@code Property} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then return 'Property' is 'null'")
  void testFromJson_thenReturnPropertyIsNull() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("Property", null);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals(3, ((Map<String, Object>) actualFromJsonResult).size());
    assertEquals("Device Name", ((Map<String, Object>) actualFromJsonResult).get("device"));
    assertNull(((Map<String, Object>) actualFromJsonResult).get("Property"));
    assertEquals(1.0d, ((Double) ((Map<String, Object>) actualFromJsonResult).get("reason")).doubleValue());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); then return size is four")
  void testFromJson_thenReturnSizeIsFour() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add("42", new JsonArray(3));
    element.add("Property", new JsonArray(3));
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertEquals(4, ((Map<String, Object>) actualFromJsonResult).size());
    Object getResult = ((Map<String, Object>) actualFromJsonResult).get("42");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof Map);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("device"));
    assertTrue(((Map<String, Object>) actualFromJsonResult).containsKey("reason"));
    assertEquals(getResult, ((Map<String, Object>) actualFromJsonResult).get("Property"));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when JsonArray(int) with capacity is one; then return Empty")
  void testFromJson_whenJsonArrayWithCapacityIsOne_thenReturnEmpty() {
    // Arrange
    JsonArray element = new JsonArray(1);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertTrue(((List<Object>) actualFromJsonResult).isEmpty());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code null}.</li>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when JsonArray(int) with capacity is three add 'null'; then return first is 'null'")
  void testFromJson_whenJsonArrayWithCapacityIsThreeAddNull_thenReturnFirstIsNull() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add((JsonElement) null);
    element.add(true);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertEquals(2, ((List<Boolean>) actualFromJsonResult).size());
    assertNull(((List<Boolean>) actualFromJsonResult).get(0));
    assertTrue(((List<Boolean>) actualFromJsonResult).get(1));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when JsonArray(int) with capacity is three; then return Empty")
  void testFromJson_whenJsonArrayWithCapacityIsThree_thenReturnEmpty() {
    // Arrange
    JsonArray element = new JsonArray(3);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertTrue(((List<Object>) actualFromJsonResult).isEmpty());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when JsonNull (default constructor); then return 'null'")
  void testFromJson_whenJsonNull_thenReturnNull() {
    // Arrange
    JsonNull element = new JsonNull();
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(JsonConverter.fromJson(element, type));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when JsonNull (default constructor); then return 'null'")
  void testFromJson_whenJsonNull_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(new JsonNull(), Float.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when JsonNull (default constructor); then return 'null'")
  void testFromJson_whenJsonNull_thenReturnNull3() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(new JsonNull(), Double.TYPE));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor) add empty string and
   * {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when JsonObject (default constructor) add empty string and JsonArray(int) with capacity is three")
  void testFromJson_whenJsonObjectAddEmptyStringAndJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject element = new JsonObject();
    element.add("", new JsonArray(3));
    element.add("42", new JsonArray(3));
    element.add("Property", new JsonArray(3));
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals(3, ((Map<String, ArrayList>) actualFromJsonResult).size());
    ArrayList getResult = ((Map<String, ArrayList>) actualFromJsonResult).get("");
    assertTrue(getResult.isEmpty());
    assertEquals(getResult, ((Map<String, ArrayList>) actualFromJsonResult).get("42"));
    assertEquals(getResult, ((Map<String, ArrayList>) actualFromJsonResult).get("Property"));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when JsonObject (default constructor); then return Empty")
  void testFromJson_whenJsonObject_thenReturnEmpty() {
    // Arrange
    JsonObject element = new JsonObject();
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof Map);
    assertTrue(((Map<Object, Object>) actualFromJsonResult).isEmpty());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with
   * {@code String}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when JsonPrimitive(String) with 'String'; then return 'String'")
  void testFromJson_whenJsonPrimitiveWithString_thenReturnString() {
    // Arrange
    JsonPrimitive element = new JsonPrimitive("String");
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals("String", JsonConverter.fromJson(element, type));
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>When toGatewayDeviceDisconnectJson {@code Device Name} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when toGatewayDeviceDisconnectJson 'Device Name' and one")
  void testFromJson_whenToGatewayDeviceDisconnectJsonDeviceNameAndOne() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = JsonConverter.fromJson(element, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals(2, ((Map<String, Object>) actualFromJsonResult).size());
    assertEquals("Device Name", ((Map<String, Object>) actualFromJsonResult).get("device"));
    assertEquals(1.0d, ((Double) ((Map<String, Object>) actualFromJsonResult).get("reason")).doubleValue());
  }

  /**
   * Test {@link JsonConverter#fromJson(JsonElement, Class)}.
   * <ul>
   *   <li>When {@link Integer#TYPE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#fromJson(JsonElement, Class)}
   */
  @Test
  @DisplayName("Test fromJson(JsonElement, Class); when TYPE; then return 'null'")
  void testFromJson_whenType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(JsonConverter.fromJson(null, Integer.TYPE));
    assertNull(JsonConverter.fromJson(null, Float.TYPE));
    assertNull(JsonConverter.fromJson(null, Byte.TYPE));
    assertNull(JsonConverter.fromJson(null, Double.TYPE));
    assertNull(JsonConverter.fromJson(null, Long.TYPE));
    assertNull(JsonConverter.fromJson(null, Character.TYPE));
    assertNull(JsonConverter.fromJson(null, Boolean.TYPE));
    assertNull(JsonConverter.fromJson(null, Short.TYPE));
    assertNull(JsonConverter.fromJson(null, Void.TYPE));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   * with {@code deviceId}, {@code jsonElement}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'")
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, new JsonArray(3)));
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, new JsonPrimitive(true)));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   * with {@code deviceId}, {@code jsonElement}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'")
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement2() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   * with {@code deviceId}, {@code jsonElement}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'")
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement3() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   * with {@code deviceId}, {@code jsonElement}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given 'A'")
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenA() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   * with {@code deviceId}, {@code jsonElement}.
   * <ul>
   *   <li>Given fromIntBits one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given fromIntBits one")
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenFromIntBitsOne() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   * with {@code deviceId}, {@code jsonElement}.
   * <ul>
   *   <li>Given {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given NaN")
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenNaN() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   * with {@code deviceId}, {@code jsonElement}.
   * <ul>
   *   <li>Given null.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given null")
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenNull() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add('\u0000');

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   * with {@code deviceId}, {@code jsonElement}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given one")
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenOne() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   * with {@code deviceId}, {@code jsonElement}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given one")
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenOne2() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   * with {@code deviceId}, {@code jsonElement}.
   * <ul>
   *   <li>Given ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given ten")
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenTen() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   * with {@code deviceId}, {@code jsonElement}.
   * <ul>
   *   <li>Given ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given ten")
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenTen2() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   * with {@code deviceId}, {@code jsonElement}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; given 'true'")
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_givenTrue() {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);
    jsonElement.add(false);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, jsonElement));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   * with {@code deviceId}, {@code jsonElement}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; when JsonNull (default constructor)")
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_whenJsonNull() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, new JsonNull()));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   * with {@code deviceId}, {@code jsonElement}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with
   * {@code String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, JsonElement)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, JsonElement) with 'deviceId', 'jsonElement'; when JsonPrimitive(String) with 'String'")
  void testConvertToClaimDeviceProtoWithDeviceIdJsonElement_whenJsonPrimitiveWithString() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(null, new JsonPrimitive("String")));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)} with
   * {@code deviceId}, {@code json}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, String) with 'deviceId', 'json'; when '42'")
  void testConvertToClaimDeviceProtoWithDeviceIdJson_when42() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "42"));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)} with
   * {@code deviceId}, {@code json}.
   * <ul>
   *   <li>When {@code client}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, String) with 'deviceId', 'json'; when 'client'")
  void testConvertToClaimDeviceProtoWithDeviceIdJson_whenClient() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "client"));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)} with
   * {@code deviceId}, {@code json}.
   * <ul>
   *   <li>When {@link DeviceId#DeviceId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, String) with 'deviceId', 'json'; when DeviceId(UUID) with id is randomUUID")
  void testConvertToClaimDeviceProtoWithDeviceIdJson_whenDeviceIdWithIdIsRandomUUID() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToClaimDeviceProto(new DeviceId(UUID.randomUUID()), "Json"));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)} with
   * {@code deviceId}, {@code json}.
   * <ul>
   *   <li>When {@code .}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, String) with 'deviceId', 'json'; when '.'")
  void testConvertToClaimDeviceProtoWithDeviceIdJson_whenDot() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "."));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)} with
   * {@code deviceId}, {@code json}.
   * <ul>
   *   <li>When {@code E}.</li>
   *   <li>Then throw {@link JsonSyntaxException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, String) with 'deviceId', 'json'; when 'E'; then throw JsonSyntaxException")
  void testConvertToClaimDeviceProtoWithDeviceIdJson_whenE_thenThrowJsonSyntaxException() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "E"));
  }

  /**
   * Test {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)} with
   * {@code deviceId}, {@code json}.
   * <ul>
   *   <li>When {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToClaimDeviceProto(DeviceId, String)}
   */
  @Test
  @DisplayName("Test convertToClaimDeviceProto(DeviceId, String) with 'deviceId', 'json'; when 'Json'")
  void testConvertToClaimDeviceProtoWithDeviceIdJson_whenJson() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToClaimDeviceProto(null, "Json"));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement)")
  void testConvertToAttributesProto() throws JsonSyntaxException {
    // Arrange and Act
    TransportProtos.PostAttributeMsg actualConvertToAttributesProtoResult = JsonConverter
        .convertToAttributesProto(new JsonObject());

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToAttributesProtoResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    Descriptors.Descriptor messageType = getResult.getMessageType();
    DescriptorProtos.DescriptorProto toProtoResult = messageType.toProto();
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileOptions options = file.getOptions();
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("DescriptorProto", toProtoResult3.getName());
    assertEquals("KeyValueProto", toProtoResult.getName());
    assertEquals("KeyValueProto", messageType.getName());
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    Descriptors.Descriptor descriptorForType3 = options2.getDescriptorForType();
    assertEquals("google.protobuf.FieldOptions", descriptorForType3.getFullName());
    assertEquals("transport.KeyValueProto", messageType.getFullName());
    assertNull(messageType.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, toProtoResult3.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedRangeCount());
    assertEquals(0, toProtoResult3.getReservedRangeCount());
    assertEquals(0, actualConvertToAttributesProtoResult.getKvCount());
    assertEquals(0, actualConvertToAttributesProtoResult.getSerializedSize());
    assertEquals(10, toProtoResult3.getFieldCount());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult4.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    assertEquals(151, toProtoResult.getSerializedSize());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult4.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(2, toProtoResult3.getNestedTypeCount());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(2, fieldList.size());
    assertEquals(4, messageType.getIndex());
    assertEquals(7, toProtoResult.getFieldCount());
    assertEquals(7, messageType.getFields().size());
    assertEquals(825, toProtoResult3.getSerializedSize());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(messageType.isExtendable());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult.hasName());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(messageType.getEnumTypes().isEmpty());
    assertTrue(messageType.getExtensions().isEmpty());
    assertTrue(messageType.getNestedTypes().isEmpty());
    assertTrue(messageType.getOneofs().isEmpty());
    assertTrue(messageType.getRealOneofs().isEmpty());
    List<TransportProtos.KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertTrue(kvList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualConvertToAttributesProtoResult.getAllFields();
    assertTrue(allFields.isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult2.toProto();
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult4.getDefaultInstanceForType();
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getGoPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getObjcClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpClassPrefixBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, options.getPhpNamespaceBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, options.getRubyPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(csharpNamespaceBytes, options.getSwiftPrefixBytes());
    assertEquals(allFields, defaultInstanceForType2.getAllFields());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult4.getSourceCodeInfo();
    assertEquals(allFields, sourceCodeInfo.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFields());
    assertEquals(allFields, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(actualConvertToAttributesProtoResult,
        actualConvertToAttributesProtoResult.getDefaultInstanceForType());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4, toProtoResult.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options3 = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType4 = options3.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult7 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType4, toProtoResult7.getDefaultInstanceForType());
    assertSame(defaultInstanceForType4, defaultInstanceForType4);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult3.getParserForType();
    assertSame(parserForType, defaultInstanceForType.getParserForType());
    assertSame(parserForType, toProtoResult.getParserForType());
    assertSame(parserForType, toProtoResult7.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(toProtoResult3.getReservedNameList(), toProtoResult3.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    assertSame(reservedNameList, toProtoResult7.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult4.getDependencyList());
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
    DescriptorProtos.FeatureSet features = options3.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, messageType.getFile());
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
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType4.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, messageType.getOptions());
    assertSame(options4, features.getDescriptorForType().getOptions());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult4.getDescriptorForType().getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    UnknownFieldSet unknownFields = actualConvertToAttributesProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(kvList, actualConvertToAttributesProtoResult.getKvOrBuilderList());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given 'A'; when JsonArray(int) with capacity is three add 'A'")
  void testConvertToAttributesProto_givenA_whenJsonArrayWithCapacityIsThreeAddA() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add((byte) 'A');
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given 'false'; when JsonArray(int) with capacity is three add 'false'")
  void testConvertToAttributesProto_givenFalse_whenJsonArrayWithCapacityIsThreeAddFalse() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(false);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Given fromIntBits one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given fromIntBits one")
  void testConvertToAttributesProto_givenFromIntBitsOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(UnsignedInteger.fromIntBits(1));
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Given {@link Double#NaN}.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given NaN; when JsonArray(int) with capacity is three add NaN")
  void testConvertToAttributesProto_givenNaN_whenJsonArrayWithCapacityIsThreeAddNaN() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(Double.NaN);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given 'null'")
  void testConvertToAttributesProto_givenNull() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonObject = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    jsonObject.add(".", null);

    // Act
    TransportProtos.PostAttributeMsg actualConvertToAttributesProtoResult = JsonConverter
        .convertToAttributesProto(jsonObject);

    // Assert
    assertEquals(39, actualConvertToAttributesProtoResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType = actualConvertToAttributesProtoResult.getDescriptorForType();
    assertSame(descriptorForType.toProto().getDescriptorForType().toProto().getDefaultInstanceForType(),
        descriptorForType.toProto().getDescriptorForType().toProto().getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertSame(options, options.getFeatures().getDescriptorForType().getOptions());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Given null.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * null.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given null; when JsonArray(int) with capacity is three add null")
  void testConvertToAttributesProto_givenNull_whenJsonArrayWithCapacityIsThreeAddNull() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add('\u0000');
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given one; when JsonArray(int) with capacity is three add one")
  void testConvertToAttributesProto_givenOne_whenJsonArrayWithCapacityIsThreeAddOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(1L);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given one; when JsonArray(int) with capacity is three add one")
  void testConvertToAttributesProto_givenOne_whenJsonArrayWithCapacityIsThreeAddOne2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add((short) 1);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given ten; when JsonArray(int) with capacity is three add ten")
  void testConvertToAttributesProto_givenTen_whenJsonArrayWithCapacityIsThreeAddTen() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(10.0d);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given ten; when JsonArray(int) with capacity is three add ten")
  void testConvertToAttributesProto_givenTen_whenJsonArrayWithCapacityIsThreeAddTen2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(10.0f);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given 'true'; when JsonArray(int) with capacity is three add 'true'")
  void testConvertToAttributesProto_givenTrue_whenJsonArrayWithCapacityIsThreeAddTrue() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); given valueOf one")
  void testConvertToAttributesProto_givenValueOfOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonObject = new JsonArray(3);
    jsonObject.add(Integer.valueOf(1));
    jsonObject.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(jsonObject));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Then return KvList first SerializedSize is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); then return KvList first SerializedSize is ten")
  void testConvertToAttributesProto_thenReturnKvListFirstSerializedSizeIsTen() throws JsonSyntaxException {
    // Arrange and Act
    TransportProtos.PostAttributeMsg actualConvertToAttributesProtoResult = JsonConverter
        .convertToAttributesProto(JsonConverter.toGatewayDeviceDisconnectJson("", 1));

    // Assert
    Descriptors.Descriptor descriptorForType = actualConvertToAttributesProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<TransportProtos.KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertEquals(2, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    assertEquals(10, getResult.getSerializedSize());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(26, actualConvertToAttributesProtoResult.getSerializedSize());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = descriptorForType2.toProto().getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
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
    Descriptors.Descriptor descriptorForType4 = getResult.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
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
    Descriptors.FieldDescriptor getResult6 = fields.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult6.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType4, getResult6.getMessageType());
    TransportProtos.KeyValueProto getResult8 = kvList.get(1);
    assertSame(descriptorForType4, getResult8.getDescriptorForType());
    TransportProtos.KeyValueProto defaultInstanceForType5 = getResult.getDefaultInstanceForType();
    assertSame(descriptorForType4, defaultInstanceForType5.getDescriptorForType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    TransportProtos.PostAttributeMsg defaultInstanceForType6 = actualConvertToAttributesProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType6.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConvertToAttributesProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, getResult.getUnknownFields());
    assertSame(unknownFields, getResult8.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType6.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    TransportProtos.KeyValueProto defaultInstanceForType7 = defaultInstanceForType5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType7, getResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType7, defaultInstanceForType7);
    assertSame(defaultInstanceForType6.getDefaultInstanceForType(),
        defaultInstanceForType6.getDefaultInstanceForType());
    assertSame(kvList, actualConvertToAttributesProtoResult.getKvOrBuilderList());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Then return KvList first TypeValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); then return KvList first TypeValue is one")
  void testConvertToAttributesProto_thenReturnKvListFirstTypeValueIsOne() throws JsonSyntaxException {
    // Arrange and Act
    TransportProtos.PostAttributeMsg actualConvertToAttributesProtoResult = JsonConverter
        .convertToAttributesProto(JsonConverter.toGatewayDeviceDisconnectJson("42", 1));

    // Assert
    List<TransportProtos.KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertEquals(2, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(0);
    assertEquals(1, getResult.getTypeValue());
    Descriptors.Descriptor descriptorForType = actualConvertToAttributesProtoResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    assertEquals(12, getResult.getSerializedSize());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(2, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(2, fields.size());
    assertEquals(28, actualConvertToAttributesProtoResult.getSerializedSize());
    assertEquals(42L, getResult.getLongV());
    assertEquals(TransportProtos.KeyValueType.LONG_V, getResult.getType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult2.getDescriptorForType();
    DescriptorProtos.DescriptorProto defaultInstanceForType2 = descriptorForType2.toProto().getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType2, toProtoResult3.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2, defaultInstanceForType2);
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
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
    Descriptors.Descriptor descriptorForType4 = getResult.getDescriptorForType();
    assertSame(file, descriptorForType4.getFile());
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
    Descriptors.FieldDescriptor getResult6 = fields.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult6.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult6.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult7.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult7.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType4, getResult6.getMessageType());
    TransportProtos.KeyValueProto getResult8 = kvList.get(1);
    assertSame(descriptorForType4, getResult8.getDescriptorForType());
    TransportProtos.KeyValueProto defaultInstanceForType5 = getResult.getDefaultInstanceForType();
    assertSame(descriptorForType4, defaultInstanceForType5.getDescriptorForType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    TransportProtos.PostAttributeMsg defaultInstanceForType6 = actualConvertToAttributesProtoResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType6.getDescriptorForType());
    UnknownFieldSet unknownFields = actualConvertToAttributesProtoResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, getResult.getUnknownFields());
    assertSame(unknownFields, getResult8.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType5.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType6.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    TransportProtos.KeyValueProto defaultInstanceForType7 = defaultInstanceForType5.getDefaultInstanceForType();
    assertSame(defaultInstanceForType7, getResult8.getDefaultInstanceForType());
    assertSame(defaultInstanceForType7, defaultInstanceForType7);
    assertSame(defaultInstanceForType6.getDefaultInstanceForType(),
        defaultInstanceForType6.getDefaultInstanceForType());
    assertSame(kvList, actualConvertToAttributesProtoResult.getKvOrBuilderList());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>Then return KvList third JsonV is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); then return KvList third JsonV is empty string")
  void testConvertToAttributesProto_thenReturnKvListThirdJsonVIsEmptyString() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonObject = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    jsonObject.addProperty(".", true);

    // Act
    TransportProtos.PostAttributeMsg actualConvertToAttributesProtoResult = JsonConverter
        .convertToAttributesProto(jsonObject);

    // Assert
    List<TransportProtos.KeyValueProto> kvList = actualConvertToAttributesProtoResult.getKvList();
    assertEquals(3, kvList.size());
    TransportProtos.KeyValueProto getResult = kvList.get(2);
    assertEquals("", getResult.getJsonV());
    assertEquals(0, getResult.getTypeValue());
    assertEquals(2, getResult.getAllFields().size());
    assertEquals(46, actualConvertToAttributesProtoResult.getSerializedSize());
    assertEquals(5, getResult.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.BOOLEAN_V, getResult.getType());
    assertTrue(getResult.getBoolV());
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); when JsonArray(int) with capacity is three")
  void testConvertToAttributesProto_whenJsonArrayWithCapacityIsThree() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(new JsonArray(3)));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   *   <li>Then throw {@link JsonSyntaxException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); when JsonNull (default constructor); then throw JsonSyntaxException")
  void testConvertToAttributesProto_whenJsonNull_thenThrowJsonSyntaxException() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(new JsonNull()));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); when JsonPrimitive(Boolean) with bool is 'true'")
  void testConvertToAttributesProto_whenJsonPrimitiveWithBoolIsTrue() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(new JsonPrimitive(true)));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with
   * {@code String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); when JsonPrimitive(String) with 'String'")
  void testConvertToAttributesProto_whenJsonPrimitiveWithString() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributesProto(new JsonPrimitive("String")));
  }

  /**
   * Test {@link JsonConverter#convertToAttributesProto(JsonElement)}.
   * <ul>
   *   <li>When toGatewayDeviceDisconnectJson {@code Device Name} and one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToAttributesProto(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributesProto(JsonElement); when toGatewayDeviceDisconnectJson 'Device Name' and one")
  void testConvertToAttributesProto_whenToGatewayDeviceDisconnectJsonDeviceNameAndOne() throws JsonSyntaxException {
    // Arrange and Act
    TransportProtos.PostAttributeMsg actualConvertToAttributesProtoResult = JsonConverter
        .convertToAttributesProto(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1));

    // Assert
    assertEquals(39, actualConvertToAttributesProtoResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType = actualConvertToAttributesProtoResult.getDescriptorForType();
    assertSame(descriptorForType.toProto().getDescriptorForType().toProto().getDefaultInstanceForType(),
        descriptorForType.toProto().getDescriptorForType().toProto().getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    assertSame(options, options.getFeatures().getDescriptorForType().getOptions());
  }

  /**
   * Test {@link JsonConverter#toJson(AttributeUpdateNotificationMsg)} with
   * {@code AttributeUpdateNotificationMsg}.
   * <ul>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#toJson(TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName("Test toJson(AttributeUpdateNotificationMsg) with 'AttributeUpdateNotificationMsg'; then return size is zero")
  void testToJsonWithAttributeUpdateNotificationMsg_thenReturnSizeIsZero() {
    // Arrange and Act
    JsonObject actualToJsonResult = JsonConverter
        .toJson(TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    assertEquals(0, actualToJsonResult.size());
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonNull());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertTrue(actualToJsonResult.isJsonObject());
    assertTrue(actualToJsonResult.isEmpty());
    assertSame(actualToJsonResult, actualToJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toJson(GetAttributeResponseMsg)} with
   * {@code GetAttributeResponseMsg}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#toJson(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test toJson(GetAttributeResponseMsg) with 'GetAttributeResponseMsg'; when DefaultInstance; then return size is zero")
  void testToJsonWithGetAttributeResponseMsg_whenDefaultInstance_thenReturnSizeIsZero() {
    // Arrange and Act
    JsonObject actualToJsonResult = JsonConverter.toJson(TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    assertEquals(0, actualToJsonResult.size());
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonNull());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertTrue(actualToJsonResult.isJsonObject());
    assertTrue(actualToJsonResult.isEmpty());
    assertSame(actualToJsonResult, actualToJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code [false,true]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName("Test toJson(JsonElement) with 'JsonElement'; given 'false'; then return '[false,true]'")
  void testToJsonWithJsonElement_givenFalse_thenReturnFalseTrue() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    // Act and Assert
    assertEquals("[false,true]", JsonConverter.toJson(element));
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   * <ul>
   *   <li>Given null.</li>
   *   <li>Then return {@code ["\u0000",true]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName("Test toJson(JsonElement) with 'JsonElement'; given null; then return '[\"\\u0000\",true]'")
  void testToJsonWithJsonElement_givenNull_thenReturnU0000True() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add('\u0000');
    element.add(true);

    // Act and Assert
    assertEquals("[\"\\u0000\",true]", JsonConverter.toJson(element));
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code [true]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName("Test toJson(JsonElement) with 'JsonElement'; given 'true'; then return '[true]'")
  void testToJsonWithJsonElement_givenTrue_thenReturnTrue() {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    // Act and Assert
    assertEquals("[true]", JsonConverter.toJson(element));
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   * <ul>
   *   <li>Then return {@code {"device":"Device Name","reason":1}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName("Test toJson(JsonElement) with 'JsonElement'; then return '{\"device\":\"Device Name\",\"reason\":1}'")
  void testToJsonWithJsonElement_thenReturnDeviceDeviceNameReason1() {
    // Arrange, Act and Assert
    assertEquals("{\"device\":\"Device Name\",\"reason\":1}",
        JsonConverter.toJson(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1)));
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   * <ul>
   *   <li>Then return {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName("Test toJson(JsonElement) with 'JsonElement'; then return '{}'")
  void testToJsonWithJsonElement_thenReturnLeftCurlyBracketRightCurlyBracket() {
    // Arrange, Act and Assert
    assertEquals("{}", JsonConverter.toJson(new JsonObject()));
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   * <ul>
   *   <li>Then return {@code []}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName("Test toJson(JsonElement) with 'JsonElement'; then return '[]'")
  void testToJsonWithJsonElement_thenReturnLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("[]", JsonConverter.toJson(new JsonArray(3)));
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName("Test toJson(JsonElement) with 'JsonElement'; when JsonNull (default constructor); then return 'null'")
  void testToJsonWithJsonElement_whenJsonNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", JsonConverter.toJson(new JsonNull()));
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is
   * {@code true}.</li>
   *   <li>Then return {@link Boolean#TRUE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName("Test toJson(JsonElement) with 'JsonElement'; when JsonPrimitive(Boolean) with bool is 'true'; then return TRUE toString")
  void testToJsonWithJsonElement_whenJsonPrimitiveWithBoolIsTrue_thenReturnTrueToString() {
    // Arrange and Act
    String actualToJsonResult = JsonConverter.toJson(new JsonPrimitive(true));

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualToJsonResult);
  }

  /**
   * Test {@link JsonConverter#toJson(JsonElement)} with {@code JsonElement}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#toJson(JsonElement)}
   */
  @Test
  @DisplayName("Test toJson(JsonElement) with 'JsonElement'; when 'null'; then return 'null'")
  void testToJsonWithJsonElement_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", JsonConverter.toJson((JsonElement) null));
  }

  /**
   * Test {@link JsonConverter#toJson(ProvisionDeviceResponseMsg, int)} with
   * {@code ProvisionDeviceResponseMsg}, {@code int}.
   * <ul>
   *   <li>Then return size is four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#toJson(TransportProtos.ProvisionDeviceResponseMsg, int)}
   */
  @Test
  @DisplayName("Test toJson(ProvisionDeviceResponseMsg, int) with 'ProvisionDeviceResponseMsg', 'int'; then return size is four")
  void testToJsonWithProvisionDeviceResponseMsgInt_thenReturnSizeIsFour() {
    // Arrange and Act
    JsonObject actualToJsonResult = JsonConverter
        .toJson(TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance(), 1);

    // Assert
    assertEquals(4, actualToJsonResult.size());
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonNull());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertFalse(actualToJsonResult.isEmpty());
    assertTrue(actualToJsonResult.isJsonObject());
    assertSame(actualToJsonResult, actualToJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toJson(ProvisionDeviceResponseMsg)} with
   * {@code ProvisionDeviceResponseMsg}.
   * <ul>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#toJson(TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName("Test toJson(ProvisionDeviceResponseMsg) with 'ProvisionDeviceResponseMsg'; then return size is three")
  void testToJsonWithProvisionDeviceResponseMsg_thenReturnSizeIsThree() {
    // Arrange and Act
    JsonObject actualToJsonResult = JsonConverter
        .toJson(TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    assertEquals(3, actualToJsonResult.size());
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonNull());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertFalse(actualToJsonResult.isEmpty());
    assertTrue(actualToJsonResult.isJsonObject());
    assertSame(actualToJsonResult, actualToJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toJson(ToDeviceRpcRequestMsg, boolean)} with
   * {@code ToDeviceRpcRequestMsg}, {@code boolean}.
   * <ul>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#toJson(TransportProtos.ToDeviceRpcRequestMsg, boolean)}
   */
  @Test
  @DisplayName("Test toJson(ToDeviceRpcRequestMsg, boolean) with 'ToDeviceRpcRequestMsg', 'boolean'; then return size is three")
  void testToJsonWithToDeviceRpcRequestMsgBoolean_thenReturnSizeIsThree() {
    // Arrange and Act
    JsonElement actualToJsonResult = JsonConverter.toJson(TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(),
        true);

    // Assert
    assertTrue(actualToJsonResult instanceof JsonObject);
    assertEquals(3, ((JsonObject) actualToJsonResult).size());
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonNull());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertFalse(((JsonObject) actualToJsonResult).isEmpty());
    assertTrue(actualToJsonResult.isJsonObject());
    assertSame(actualToJsonResult, actualToJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toJson(ToDeviceRpcRequestMsg, boolean)} with
   * {@code ToDeviceRpcRequestMsg}, {@code boolean}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#toJson(TransportProtos.ToDeviceRpcRequestMsg, boolean)}
   */
  @Test
  @DisplayName("Test toJson(ToDeviceRpcRequestMsg, boolean) with 'ToDeviceRpcRequestMsg', 'boolean'; then return size is two")
  void testToJsonWithToDeviceRpcRequestMsgBoolean_thenReturnSizeIsTwo() {
    // Arrange and Act
    JsonElement actualToJsonResult = JsonConverter.toJson(TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(),
        false);

    // Assert
    assertTrue(actualToJsonResult instanceof JsonObject);
    assertEquals(2, ((JsonObject) actualToJsonResult).size());
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonNull());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertFalse(((JsonObject) actualToJsonResult).isEmpty());
    assertTrue(actualToJsonResult.isJsonObject());
    assertSame(actualToJsonResult, actualToJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toJson(ToServerRpcResponseMsg)} with
   * {@code ToServerRpcResponseMsg}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return {@link JsonNull}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#toJson(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName("Test toJson(ToServerRpcResponseMsg) with 'ToServerRpcResponseMsg'; when DefaultInstance; then return JsonNull")
  void testToJsonWithToServerRpcResponseMsg_whenDefaultInstance_thenReturnJsonNull() {
    // Arrange and Act
    JsonElement actualToJsonResult = JsonConverter.toJson(TransportProtos.ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    assertTrue(actualToJsonResult instanceof JsonNull);
    assertFalse(actualToJsonResult.isJsonArray());
    assertFalse(actualToJsonResult.isJsonObject());
    assertFalse(actualToJsonResult.isJsonPrimitive());
    assertTrue(actualToJsonResult.isJsonNull());
    JsonNull expectedAsJsonNull = ((JsonNull) actualToJsonResult).INSTANCE;
    assertSame(expectedAsJsonNull, actualToJsonResult.getAsJsonNull());
  }

  /**
   * Test {@link JsonConverter#toJsonObject(Object)}.
   * <ul>
   *   <li>Then return toGatewayDeviceDisconnectJson {@code Device Name} and
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  @DisplayName("Test toJsonObject(Object); then return toGatewayDeviceDisconnectJson 'Device Name' and one")
  void testToJsonObject_thenReturnToGatewayDeviceDisconnectJsonDeviceNameAndOne() {
    // Arrange
    JsonObject toGatewayDeviceDisconnectJsonResult = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);

    // Act and Assert
    assertEquals(toGatewayDeviceDisconnectJsonResult, JsonConverter.toJsonObject(toGatewayDeviceDisconnectJsonResult));
  }

  /**
   * Test {@link JsonConverter#toJsonObject(Object)}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   *   <li>Then return {@link JsonObject} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#toJsonObject(Object)}
   */
  @Test
  @DisplayName("Test toJsonObject(Object); when JsonObject (default constructor); then return JsonObject (default constructor)")
  void testToJsonObject_whenJsonObject_thenReturnJsonObject() {
    // Arrange
    JsonObject jsonObject = new JsonObject();

    // Act and Assert
    assertEquals(jsonObject, JsonConverter.toJsonObject(jsonObject));
  }

  /**
   * Test
   * {@link JsonConverter#getJsonObjectForGateway(String, AttributeUpdateNotificationMsg)}
   * with {@code deviceName}, {@code notificationMsg}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#getJsonObjectForGateway(String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName("Test getJsonObjectForGateway(String, AttributeUpdateNotificationMsg) with 'deviceName', 'notificationMsg'; then return size is two")
  void testGetJsonObjectForGatewayWithDeviceNameNotificationMsg_thenReturnSizeIsTwo() {
    // Arrange and Act
    JsonObject actualJsonObjectForGateway = JsonConverter.getJsonObjectForGateway("Device Name",
        TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    assertEquals(2, actualJsonObjectForGateway.size());
    assertFalse(actualJsonObjectForGateway.isJsonArray());
    assertFalse(actualJsonObjectForGateway.isJsonNull());
    assertFalse(actualJsonObjectForGateway.isJsonPrimitive());
    assertFalse(actualJsonObjectForGateway.isEmpty());
    assertTrue(actualJsonObjectForGateway.isJsonObject());
    assertSame(actualJsonObjectForGateway, actualJsonObjectForGateway.getAsJsonObject());
  }

  /**
   * Test
   * {@link JsonConverter#getJsonObjectForGateway(String, GetAttributeResponseMsg)}
   * with {@code deviceName}, {@code responseMsg}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#getJsonObjectForGateway(String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test getJsonObjectForGateway(String, GetAttributeResponseMsg) with 'deviceName', 'responseMsg'; then return size is two")
  void testGetJsonObjectForGatewayWithDeviceNameResponseMsg_thenReturnSizeIsTwo() {
    // Arrange and Act
    JsonObject actualJsonObjectForGateway = JsonConverter.getJsonObjectForGateway("Device Name",
        TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    assertEquals(2, actualJsonObjectForGateway.size());
    assertFalse(actualJsonObjectForGateway.isJsonArray());
    assertFalse(actualJsonObjectForGateway.isJsonNull());
    assertFalse(actualJsonObjectForGateway.isJsonPrimitive());
    assertFalse(actualJsonObjectForGateway.isEmpty());
    assertTrue(actualJsonObjectForGateway.isJsonObject());
    assertSame(actualJsonObjectForGateway, actualJsonObjectForGateway.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toGatewayDeviceDisconnectJson(String, int)}.
   * <ul>
   *   <li>When {@code Device Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#toGatewayDeviceDisconnectJson(String, int)}
   */
  @Test
  @DisplayName("Test toGatewayDeviceDisconnectJson(String, int); when 'Device Name'")
  void testToGatewayDeviceDisconnectJson_whenDeviceName() {
    // Arrange and Act
    JsonObject actualToGatewayDeviceDisconnectJsonResult = JsonConverter.toGatewayDeviceDisconnectJson("Device Name",
        1);

    // Assert
    assertEquals(2, actualToGatewayDeviceDisconnectJsonResult.size());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonArray());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonNull());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonPrimitive());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isEmpty());
    assertTrue(actualToGatewayDeviceDisconnectJsonResult.isJsonObject());
    assertSame(actualToGatewayDeviceDisconnectJsonResult, actualToGatewayDeviceDisconnectJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toGatewayDeviceDisconnectJson(String, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#toGatewayDeviceDisconnectJson(String, int)}
   */
  @Test
  @DisplayName("Test toGatewayDeviceDisconnectJson(String, int); when 'null'")
  void testToGatewayDeviceDisconnectJson_whenNull() {
    // Arrange and Act
    JsonObject actualToGatewayDeviceDisconnectJsonResult = JsonConverter.toGatewayDeviceDisconnectJson(null, 1);

    // Assert
    assertEquals(2, actualToGatewayDeviceDisconnectJsonResult.size());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonArray());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonNull());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isJsonPrimitive());
    assertFalse(actualToGatewayDeviceDisconnectJsonResult.isEmpty());
    assertTrue(actualToGatewayDeviceDisconnectJsonResult.isJsonObject());
    assertSame(actualToGatewayDeviceDisconnectJsonResult, actualToGatewayDeviceDisconnectJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toErrorJson(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#toErrorJson(String)}
   */
  @Test
  @DisplayName("Test toErrorJson(String); when 'An error occurred'")
  void testToErrorJson_whenAnErrorOccurred() {
    // Arrange and Act
    JsonElement actualToErrorJsonResult = JsonConverter.toErrorJson("An error occurred");

    // Assert
    assertTrue(actualToErrorJsonResult instanceof JsonObject);
    assertEquals(1, ((JsonObject) actualToErrorJsonResult).size());
    assertFalse(actualToErrorJsonResult.isJsonArray());
    assertFalse(actualToErrorJsonResult.isJsonNull());
    assertFalse(actualToErrorJsonResult.isJsonPrimitive());
    assertFalse(((JsonObject) actualToErrorJsonResult).isEmpty());
    assertTrue(actualToErrorJsonResult.isJsonObject());
    assertSame(actualToErrorJsonResult, actualToErrorJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toErrorJson(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#toErrorJson(String)}
   */
  @Test
  @DisplayName("Test toErrorJson(String); when 'null'")
  void testToErrorJson_whenNull() {
    // Arrange and Act
    JsonElement actualToErrorJsonResult = JsonConverter.toErrorJson(null);

    // Assert
    assertTrue(actualToErrorJsonResult instanceof JsonObject);
    assertEquals(1, ((JsonObject) actualToErrorJsonResult).size());
    assertFalse(actualToErrorJsonResult.isJsonArray());
    assertFalse(actualToErrorJsonResult.isJsonNull());
    assertFalse(actualToErrorJsonResult.isJsonPrimitive());
    assertFalse(((JsonObject) actualToErrorJsonResult).isEmpty());
    assertTrue(actualToErrorJsonResult.isJsonObject());
    assertSame(actualToErrorJsonResult, actualToErrorJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toGatewayJson(String, ProvisionDeviceResponseMsg)}
   * with {@code deviceName}, {@code responseRequest}.
   * <ul>
   *   <li>Then return {@link JsonObject}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#toGatewayJson(String, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName("Test toGatewayJson(String, ProvisionDeviceResponseMsg) with 'deviceName', 'responseRequest'; then return JsonObject")
  void testToGatewayJsonWithDeviceNameResponseRequest_thenReturnJsonObject() {
    // Arrange and Act
    JsonElement actualToGatewayJsonResult = JsonConverter.toGatewayJson("Device Name",
        TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    assertTrue(actualToGatewayJsonResult instanceof JsonObject);
    assertEquals(2, ((JsonObject) actualToGatewayJsonResult).size());
    assertFalse(actualToGatewayJsonResult.isJsonArray());
    assertFalse(actualToGatewayJsonResult.isJsonNull());
    assertFalse(actualToGatewayJsonResult.isJsonPrimitive());
    assertFalse(((JsonObject) actualToGatewayJsonResult).isEmpty());
    assertTrue(actualToGatewayJsonResult.isJsonObject());
    assertSame(actualToGatewayJsonResult, actualToGatewayJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toGatewayJson(String, ProvisionDeviceResponseMsg)}
   * with {@code deviceName}, {@code responseRequest}.
   * <ul>
   *   <li>When {@code device}.</li>
   *   <li>Then return {@link JsonObject}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#toGatewayJson(String, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName("Test toGatewayJson(String, ProvisionDeviceResponseMsg) with 'deviceName', 'responseRequest'; when 'device'; then return JsonObject")
  void testToGatewayJsonWithDeviceNameResponseRequest_whenDevice_thenReturnJsonObject() {
    // Arrange and Act
    JsonElement actualToGatewayJsonResult = JsonConverter.toGatewayJson("device",
        TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    assertTrue(actualToGatewayJsonResult instanceof JsonObject);
    assertEquals(2, ((JsonObject) actualToGatewayJsonResult).size());
    assertFalse(actualToGatewayJsonResult.isJsonArray());
    assertFalse(actualToGatewayJsonResult.isJsonNull());
    assertFalse(actualToGatewayJsonResult.isJsonPrimitive());
    assertFalse(((JsonObject) actualToGatewayJsonResult).isEmpty());
    assertTrue(actualToGatewayJsonResult.isJsonObject());
    assertSame(actualToGatewayJsonResult, actualToGatewayJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#toGatewayJson(String, ToDeviceRpcRequestMsg)} with
   * {@code deviceName}, {@code rpcRequest}.
   * <ul>
   *   <li>Then return {@link JsonObject}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#toGatewayJson(String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName("Test toGatewayJson(String, ToDeviceRpcRequestMsg) with 'deviceName', 'rpcRequest'; then return JsonObject")
  void testToGatewayJsonWithDeviceNameRpcRequest_thenReturnJsonObject() {
    // Arrange and Act
    JsonElement actualToGatewayJsonResult = JsonConverter.toGatewayJson("Device Name",
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    assertTrue(actualToGatewayJsonResult instanceof JsonObject);
    assertEquals(2, ((JsonObject) actualToGatewayJsonResult).size());
    assertFalse(actualToGatewayJsonResult.isJsonArray());
    assertFalse(actualToGatewayJsonResult.isJsonNull());
    assertFalse(actualToGatewayJsonResult.isJsonPrimitive());
    assertFalse(((JsonObject) actualToGatewayJsonResult).isEmpty());
    assertTrue(actualToGatewayJsonResult.isJsonObject());
    assertSame(actualToGatewayJsonResult, actualToGatewayJsonResult.getAsJsonObject());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   * <p>
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement)")
  void testConvertToAttributes() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.addProperty(".", true);

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); given JsonArray(int) with capacity is three")
  void testConvertToAttributes_givenJsonArrayWithCapacityIsThree() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", new JsonArray(3));

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); given JsonObject (default constructor)")
  void testConvertToAttributes_givenJsonObject() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", new JsonObject());

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then throw {@link JsonSyntaxException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); given 'null'; then throw JsonSyntaxException")
  void testConvertToAttributes_givenNull_thenThrowJsonSyntaxException() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", null);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToAttributes(element));
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   * <ul>
   *   <li>Given toGatewayDeviceDisconnectJson {@code .} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); given toGatewayDeviceDisconnectJson '.' and one")
  void testConvertToAttributes_givenToGatewayDeviceDisconnectJsonDotAndOne() {
    // Arrange
    JsonObject element = JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1);
    element.add(".", JsonConverter.toGatewayDeviceDisconnectJson(".", 1));

    // Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter.convertToAttributes(element);

    // Assert
    assertEquals(3, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); when JsonObject (default constructor); then return Empty")
  void testConvertToAttributes_whenJsonObject_thenReturnEmpty() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter.convertToAttributes(new JsonObject());

    // Assert
    assertTrue(actualConvertToAttributesResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   * <ul>
   *   <li>When toGatewayDeviceDisconnectJson {@code 42} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); when toGatewayDeviceDisconnectJson '42' and one")
  void testConvertToAttributes_whenToGatewayDeviceDisconnectJson42AndOne() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter
        .convertToAttributes(JsonConverter.toGatewayDeviceDisconnectJson("42", 1));

    // Assert
    assertEquals(2, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   * <ul>
   *   <li>When toGatewayDeviceDisconnectJson {@code Device Name} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); when toGatewayDeviceDisconnectJson 'Device Name' and one")
  void testConvertToAttributes_whenToGatewayDeviceDisconnectJsonDeviceNameAndOne() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter
        .convertToAttributes(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1));

    // Assert
    assertEquals(2, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   * <ul>
   *   <li>When toGatewayDeviceDisconnectJson {@code .} and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); when toGatewayDeviceDisconnectJson '.' and one")
  void testConvertToAttributes_whenToGatewayDeviceDisconnectJsonDotAndOne() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter
        .convertToAttributes(JsonConverter.toGatewayDeviceDisconnectJson(".", 1));

    // Assert
    assertEquals(2, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToAttributes(JsonElement)}.
   * <ul>
   *   <li>When toGatewayDeviceDisconnectJson empty string and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToAttributes(JsonElement)}
   */
  @Test
  @DisplayName("Test convertToAttributes(JsonElement); when toGatewayDeviceDisconnectJson empty string and one")
  void testConvertToAttributes_whenToGatewayDeviceDisconnectJsonEmptyStringAndOne() {
    // Arrange and Act
    Set<AttributeKvEntry> actualConvertToAttributesResult = JsonConverter
        .convertToAttributes(JsonConverter.toGatewayDeviceDisconnectJson("", 1));

    // Assert
    assertEquals(2, actualConvertToAttributesResult.size());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then one first return {@link LongDataEntry}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given '42'; then one first return LongDataEntry")
  void testConvertToSortedTelemetry_given42_thenOneFirstReturnLongDataEntry() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "42");

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter.convertToSortedTelemetry(jsonElement,
        1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof LongDataEntry);
    assertEquals("42", getResult2.getValueAsString());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(42L, longValue.get().longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    assertTrue(longValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given 'A'; when JsonArray(int) with capacity is three add 'A'")
  void testConvertToSortedTelemetry_givenA_whenJsonArrayWithCapacityIsThreeAddA() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((byte) 'A');
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>Then return one first StrValue is {@code .}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given '.'; then return one first StrValue is '.'")
  void testConvertToSortedTelemetry_givenDot_thenReturnOneFirstStrValueIsDot() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", ".");

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter.convertToSortedTelemetry(jsonElement,
        1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof StringDataEntry);
    Optional<String> strValue = getResult2.getStrValue();
    assertEquals(".", strValue.get());
    assertEquals(".", getResult2.getValueAsString());
    assertEquals(".", getResult2.getValue());
    assertEquals(DataType.STRING, getResult2.getDataType());
    assertTrue(strValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given 'false'; when JsonArray(int) with capacity is three add 'false'")
  void testConvertToSortedTelemetry_givenFalse_whenJsonArrayWithCapacityIsThreeAddFalse() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(false);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given fromIntBits one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given fromIntBits one")
  void testConvertToSortedTelemetry_givenFromIntBitsOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(UnsignedInteger.fromIntBits(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given JsonArray(int) with capacity is three")
  void testConvertToSortedTelemetry_givenJsonArrayWithCapacityIsThree() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonArray(3));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given JsonArray(int) with capacity is three add 'false'")
  void testConvertToSortedTelemetry_givenJsonArrayWithCapacityIsThreeAddFalse() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(false);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given JsonArray(int) with capacity is three add 'true'")
  void testConvertToSortedTelemetry_givenJsonArrayWithCapacityIsThreeAddTrue() throws JsonSyntaxException {
    // Arrange
    JsonArray element = new JsonArray(3);
    element.add(true);

    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(element);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@link JsonObject} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given JsonObject (default constructor)")
  void testConvertToSortedTelemetry_givenJsonObject() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(new JsonObject());
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@link Double#NaN}.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given NaN; when JsonArray(int) with capacity is three add NaN")
  void testConvertToSortedTelemetry_givenNaN_whenJsonArrayWithCapacityIsThreeAddNaN() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Double.NaN);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link JsonObject} (default constructor) addProperty {@code ts} and
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given 'null'; when JsonObject (default constructor) addProperty 'ts' and 'null'")
  void testConvertToSortedTelemetry_givenNull_whenJsonObjectAddPropertyTsAndNull() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", (String) null);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given one; when JsonArray(int) with capacity is three add one")
  void testConvertToSortedTelemetry_givenOne_whenJsonArrayWithCapacityIsThreeAddOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(1L);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given one; when JsonArray(int) with capacity is three add one")
  void testConvertToSortedTelemetry_givenOne_whenJsonArrayWithCapacityIsThreeAddOne2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add((short) 1);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given ten; when JsonArray(int) with capacity is three add ten")
  void testConvertToSortedTelemetry_givenTen_whenJsonArrayWithCapacityIsThreeAddTen() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0d);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given ten; when JsonArray(int) with capacity is three add ten")
  void testConvertToSortedTelemetry_givenTen_whenJsonArrayWithCapacityIsThreeAddTen2() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(10.0f);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given 'true'; when JsonArray(int) with capacity is three add 'true'")
  void testConvertToSortedTelemetry_givenTrue_whenJsonArrayWithCapacityIsThreeAddTrue() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); given valueOf one")
  void testConvertToSortedTelemetry_givenValueOfOne() throws JsonSyntaxException {
    // Arrange
    JsonArray jsonElement = new JsonArray(3);
    jsonElement.add(Integer.valueOf(1));
    jsonElement.add(true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(jsonElement, 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Then one first return {@link BooleanDataEntry}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); then one first return BooleanDataEntry")
  void testConvertToSortedTelemetry_thenOneFirstReturnBooleanDataEntry() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", true);

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter.convertToSortedTelemetry(jsonElement,
        1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof BooleanDataEntry);
    assertEquals(DataType.BOOLEAN, getResult2.getDataType());
    Optional<Double> doubleValue = getResult2.getDoubleValue();
    assertFalse(doubleValue.isPresent());
    Optional<Boolean> booleanValue = getResult2.getBooleanValue();
    assertTrue(booleanValue.get());
    assertTrue(booleanValue.isPresent());
    String expectedValueAsString = Boolean.TRUE.toString();
    assertEquals(expectedValueAsString, getResult2.getValueAsString());
    assertSame(doubleValue, getResult2.getJsonValue());
    assertSame(doubleValue, getResult2.getLongValue());
    assertSame(doubleValue, getResult2.getStrValue());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Then one first return {@link JsonDataEntry}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); then one first return JsonDataEntry")
  void testConvertToSortedTelemetry_thenOneFirstReturnJsonDataEntry() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.add("ts", new JsonArray(3));

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter.convertToSortedTelemetry(jsonElement,
        1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof JsonDataEntry);
    Optional<String> jsonValue = getResult2.getJsonValue();
    assertEquals("[]", jsonValue.get());
    assertEquals("[]", getResult2.getValueAsString());
    assertEquals("[]", getResult2.getValue());
    assertEquals(DataType.JSON, getResult2.getDataType());
    assertTrue(jsonValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Then return one first StrValue is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); then return one first StrValue is empty string")
  void testConvertToSortedTelemetry_thenReturnOneFirstStrValueIsEmptyString() throws JsonSyntaxException {
    // Arrange
    JsonObject jsonElement = new JsonObject();
    jsonElement.addProperty("ts", "");

    // Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter.convertToSortedTelemetry(jsonElement,
        1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(1, getResult.size());
    KvEntry getResult2 = getResult.get(0);
    assertTrue(getResult2 instanceof StringDataEntry);
    Optional<String> strValue = getResult2.getStrValue();
    assertEquals("", strValue.get());
    assertEquals("", getResult2.getValueAsString());
    assertEquals("", getResult2.getValue());
    assertEquals(DataType.STRING, getResult2.getDataType());
    assertTrue(strValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>Then return one size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); then return one size is two")
  void testConvertToSortedTelemetry_thenReturnOneSizeIsTwo() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter
        .convertToSortedTelemetry(JsonConverter.toGatewayDeviceDisconnectJson("Device Name", 1), 1L);

    // Assert
    assertEquals(1, actualConvertToSortedTelemetryResult.size());
    List<KvEntry> getResult = actualConvertToSortedTelemetryResult.get(1L);
    assertEquals(2, getResult.size());
    KvEntry getResult2 = getResult.get(1);
    assertTrue(getResult2 instanceof LongDataEntry);
    KvEntry getResult3 = getResult.get(0);
    assertTrue(getResult3 instanceof StringDataEntry);
    assertEquals("1", getResult2.getValueAsString());
    assertEquals("Device Name", getResult3.getStrValue().get());
    assertEquals("Device Name", getResult3.getValueAsString());
    assertEquals("Device Name", getResult3.getValue());
    assertEquals("device", getResult3.getKey());
    assertEquals("reason", getResult2.getKey());
    Optional<Long> longValue = getResult2.getLongValue();
    assertEquals(1L, longValue.get().longValue());
    assertEquals(DataType.LONG, getResult2.getDataType());
    assertTrue(longValue.isPresent());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); when JsonArray(int) with capacity is three; then return Empty")
  void testConvertToSortedTelemetry_whenJsonArrayWithCapacityIsThree_thenReturnEmpty() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter
        .convertToSortedTelemetry(new JsonArray(3), 1L);

    // Assert
    assertTrue(actualConvertToSortedTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).</li>
   *   <li>Then throw {@link JsonSyntaxException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); when JsonNull (default constructor); then throw JsonSyntaxException")
  void testConvertToSortedTelemetry_whenJsonNull_thenThrowJsonSyntaxException() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(new JsonNull(), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); when JsonObject (default constructor); then return Empty")
  void testConvertToSortedTelemetry_whenJsonObject_thenReturnEmpty() throws JsonSyntaxException {
    // Arrange and Act
    Map<Long, List<KvEntry>> actualConvertToSortedTelemetryResult = JsonConverter
        .convertToSortedTelemetry(new JsonObject(), 1L);

    // Assert
    assertTrue(actualConvertToSortedTelemetryResult.isEmpty());
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Boolean)} with bool is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); when JsonPrimitive(Boolean) with bool is 'true'")
  void testConvertToSortedTelemetry_whenJsonPrimitiveWithBoolIsTrue() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToSortedTelemetry(new JsonPrimitive(true), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(Character)} with c is start of
   * heading.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); when JsonPrimitive(Character) with c is start of heading")
  void testConvertToSortedTelemetry_whenJsonPrimitiveWithCIsStartOfHeading() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToSortedTelemetry(new JsonPrimitive('\u0001'), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}.
   * <ul>
   *   <li>When {@link JsonPrimitive#JsonPrimitive(String)} with
   * {@code String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToSortedTelemetry(JsonElement, long)}
   */
  @Test
  @DisplayName("Test convertToSortedTelemetry(JsonElement, long); when JsonPrimitive(String) with 'String'")
  void testConvertToSortedTelemetry_whenJsonPrimitiveWithString() throws JsonSyntaxException {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> JsonConverter.convertToSortedTelemetry(new JsonPrimitive("String"), 1L));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'")
  void testConvertToProvisionRequestMsgWithJo() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter
        .convertToProvisionRequestMsg(JsonConverter.toGatewayDeviceDisconnectJson("deviceName", -1)));
    assertThrows(RuntimeException.class,
        () -> JsonConverter.convertToProvisionRequestMsg(JsonConverter.toGatewayDeviceDisconnectJson(null, -1)));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given 'A'")
  void testConvertToProvisionRequestMsgWithJo_givenA() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", (byte) 'A');

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given empty string")
  void testConvertToProvisionRequestMsgWithJo_givenEmptyString() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.add("", new JsonArray(3));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given 'false'")
  void testConvertToProvisionRequestMsgWithJo_givenFalse() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", false);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given forty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given forty-two")
  void testConvertToProvisionRequestMsgWithJo_givenFortyTwo() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", 42L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given fromIntBits two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given fromIntBits two")
  void testConvertToProvisionRequestMsgWithJo_givenFromIntBitsTwo() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", UnsignedInteger.fromIntBits(2));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given {@link JsonArray#JsonArray(int)} with capacity is three add
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given JsonArray(int) with capacity is three add 'true'")
  void testConvertToProvisionRequestMsgWithJo_givenJsonArrayWithCapacityIsThreeAddTrue() {
    // Arrange
    JsonArray value = new JsonArray(3);
    value.add(true);

    JsonObject jo = new JsonObject();
    jo.add("deviceName", value);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given {@link Double#NaN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given NaN")
  void testConvertToProvisionRequestMsgWithJo_givenNaN() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", Double.NaN);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given 'Property'")
  void testConvertToProvisionRequestMsgWithJo_givenProperty() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.add("Property", new JsonArray(3));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given {@code provisionDeviceKey}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given 'provisionDeviceKey'")
  void testConvertToProvisionRequestMsgWithJo_givenProvisionDeviceKey() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("provisionDeviceKey", "42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given start of text.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given start of text")
  void testConvertToProvisionRequestMsgWithJo_givenStartOfText() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", '\u0002');

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given ten")
  void testConvertToProvisionRequestMsgWithJo_givenTen() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", 10.0d);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given ten")
  void testConvertToProvisionRequestMsgWithJo_givenTen2() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", 10.0f);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given 'true'")
  void testConvertToProvisionRequestMsgWithJo_givenTrue() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given two")
  void testConvertToProvisionRequestMsgWithJo_givenTwo() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", (short) 2);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>Given valueOf minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; given valueOf minus one")
  void testConvertToProvisionRequestMsgWithJo_givenValueOfMinusOne() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", Integer.valueOf(-1));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor) addProperty
   * {@code deviceName} and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; when JsonObject (default constructor) addProperty 'deviceName' and '42'")
  void testConvertToProvisionRequestMsgWithJo_whenJsonObjectAddPropertyDeviceNameAnd42() {
    // Arrange
    JsonObject jo = new JsonObject();
    jo.addProperty("deviceName", "42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(jo));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)} with
   * {@code jo}.
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonConverter#convertToProvisionRequestMsg(JsonObject)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(JsonObject) with 'jo'; when JsonObject (default constructor); then throw RuntimeException")
  void testConvertToProvisionRequestMsgWithJo_whenJsonObject_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> JsonConverter.convertToProvisionRequestMsg(new JsonObject()));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with
   * {@code json}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when '42'")
  void testConvertToProvisionRequestMsgWithJson_when42() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("42"));
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("42."));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with
   * {@code json}.
   * <ul>
   *   <li>When {@code 42E}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when '42E'")
  void testConvertToProvisionRequestMsgWithJson_when42e() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("42E"));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with
   * {@code json}.
   * <ul>
   *   <li>When {@code client}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when 'client'")
  void testConvertToProvisionRequestMsgWithJson_whenClient() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("client"));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with
   * {@code json}.
   * <ul>
   *   <li>When {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when '.'")
  void testConvertToProvisionRequestMsgWithJson_whenDot() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("."));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with
   * {@code json}.
   * <ul>
   *   <li>When {@code E}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when 'E'")
  void testConvertToProvisionRequestMsgWithJson_whenE() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("E"));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with
   * {@code json}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when empty string")
  void testConvertToProvisionRequestMsgWithJson_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg(""));
  }

  /**
   * Test {@link JsonConverter#convertToProvisionRequestMsg(String)} with
   * {@code json}.
   * <ul>
   *   <li>When {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonConverter#convertToProvisionRequestMsg(String)}
   */
  @Test
  @DisplayName("Test convertToProvisionRequestMsg(String) with 'json'; when 'Json'")
  void testConvertToProvisionRequestMsgWithJson_whenJson() {
    // Arrange, Act and Assert
    assertThrows(JsonSyntaxException.class, () -> JsonConverter.convertToProvisionRequestMsg("Json"));
  }
}
