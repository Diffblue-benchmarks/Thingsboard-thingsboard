package org.thingsboard.server.transport.mqtt.util.sparkplug;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto;
import org.thingsboard.server.transport.mqtt.util.sparkplug.SparkplugMetricUtil.File;

class SparkplugMetricUtilDiffblueTest {
  /**
   * Test
   * {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return Datatype is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}
   */
  @Test
  @DisplayName("Test createMetric(Object, long, String, MetricDataType); when 'A'; then return Datatype is one")
  void testCreateMetric_whenA_thenReturnDatatypeIsOne() throws ThingsboardException {
    // Arrange and Act
    SparkplugBProto.Payload.Metric actualCreateMetricResult = SparkplugMetricUtil.createMetric((byte) 'A', 1L, "Key",
        MetricDataType.Int8);

    // Assert
    Descriptors.Descriptor descriptorForType = actualCreateMetricResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.DescriptorProto> nestedTypeList = toProtoResult.getNestedTypeList();
    assertEquals(1, nestedTypeList.size());
    List<Descriptors.Descriptor> nestedTypes = descriptorForType.getNestedTypes();
    assertEquals(1, nestedTypes.size());
    List<Descriptors.OneofDescriptor> realOneofs = descriptorForType.getRealOneofs();
    assertEquals(1, realOneofs.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(1, messageTypes.size());
    assertEquals(1, actualCreateMetricResult.getDatatype());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(10, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(10, oneofs.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(19, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    assertEquals(65, actualCreateMetricResult.getIntValue());
    Descriptors.Descriptor containingType = descriptorForType.getContainingType();
    List<Descriptors.Descriptor> nestedTypes2 = containingType.getNestedTypes();
    assertEquals(7, nestedTypes2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(nestedTypeList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    SparkplugBProto.Payload.DataSet datasetValue = actualCreateMetricResult.getDatasetValue();
    Descriptors.Descriptor descriptorForType2 = datasetValue.getDescriptorForType();
    assertSame(containingType, descriptorForType2.getContainingType());
    SparkplugBProto.Payload.MetaData metadata = actualCreateMetricResult.getMetadata();
    Descriptors.Descriptor descriptorForType3 = metadata.getDescriptorForType();
    assertSame(containingType, descriptorForType3.getContainingType());
    SparkplugBProto.Payload.PropertySet properties = actualCreateMetricResult.getProperties();
    Descriptors.Descriptor descriptorForType4 = properties.getDescriptorForType();
    assertSame(containingType, descriptorForType4.getContainingType());
    SparkplugBProto.Payload.Template templateValue = actualCreateMetricResult.getTemplateValue();
    Descriptors.Descriptor descriptorForType5 = templateValue.getDescriptorForType();
    assertSame(containingType, descriptorForType5.getContainingType());
    assertSame(containingType, messageTypes.get(0));
    assertSame(file, containingType.getFile());
    assertSame(file, descriptorForType2.getFile());
    SparkplugBProto.Payload.Metric.MetricValueExtension extensionValue = actualCreateMetricResult.getExtensionValue();
    Descriptors.Descriptor descriptorForType6 = extensionValue.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(17);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(18);
    assertSame(file, getResult4.getFile());
    Descriptors.OneofDescriptor getResult5 = oneofs.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.OneofDescriptor getResult6 = oneofs.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.OneofDescriptor getResult7 = oneofs.get(8);
    assertSame(file, getResult7.getFile());
    Descriptors.OneofDescriptor getResult8 = oneofs.get(9);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options3 = options.getDescriptorForType().getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult2 = containingType.toProto();
    assertSame(options3, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType6.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, containingType.getOptions());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    Any extensions = datasetValue.getExtensions();
    assertSame(options3, extensions.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, descriptorForType6.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(descriptorForType2, nestedTypes2.get(1));
    assertSame(descriptorForType6, getResult4.getMessageType());
    assertSame(descriptorForType6, nestedTypes.get(0));
    assertSame(descriptorForType3, nestedTypes2.get(5));
    assertSame(descriptorForType5, getResult3.getMessageType());
    assertSame(descriptorForType5, nestedTypes2.get(0));
    assertSame(descriptorForType, descriptorForType6.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    SparkplugBProto.Payload.Metric defaultInstanceForType2 = actualCreateMetricResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes2.get(6));
    UnknownFieldSet unknownFields = actualCreateMetricResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, datasetValue.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, extensionValue.getUnknownFields());
    assertSame(unknownFields, metadata.getUnknownFields());
    assertSame(unknownFields, properties.getUnknownFields());
    assertSame(unknownFields, templateValue.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult5, getResult3.getContainingOneof());
    assertSame(getResult5, getResult4.getContainingOneof());
    assertSame(getResult5, getResult3.getRealContainingOneof());
    assertSame(getResult5, getResult4.getRealContainingOneof());
    assertSame(getResult5, realOneofs.get(0));
    assertSame(getResult6, getResult.getContainingOneof());
    ProtocolStringList columnsList = datasetValue.getColumnsList();
    assertSame(columnsList, defaultInstanceForType.getReservedNameList());
    assertSame(columnsList, toProtoResult2.getReservedNameList());
    assertSame(columnsList, toProtoResult3.getReservedNameList());
    assertSame(columnsList, toProtoResult4.getReservedNameList());
    assertSame(columnsList, toProtoResult.getReservedNameList());
    assertSame(columnsList, properties.getKeysList());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, datasetValue.getExtensionsOrBuilder());
    assertSame(extensions, metadata.getExtensions());
    assertSame(extensions, metadata.getExtensionsOrBuilder());
    assertSame(extensions, extensionValue.getExtensions());
    assertSame(extensions, extensionValue.getExtensionsOrBuilder());
    assertSame(extensions, properties.getExtensions());
    assertSame(extensions, properties.getExtensionsOrBuilder());
    assertSame(extensions, templateValue.getExtensions());
    assertSame(extensions, templateValue.getExtensionsOrBuilder());
    assertSame(datasetValue, datasetValue.getDefaultInstanceForType());
    assertSame(datasetValue, defaultInstanceForType2.getDatasetValue());
    assertSame(datasetValue, defaultInstanceForType2.getDatasetValueOrBuilder());
    assertSame(datasetValue, actualCreateMetricResult.getDatasetValueOrBuilder());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(extensionValue, defaultInstanceForType2.getExtensionValue());
    assertSame(extensionValue, defaultInstanceForType2.getExtensionValueOrBuilder());
    assertSame(extensionValue, actualCreateMetricResult.getExtensionValueOrBuilder());
    assertSame(extensionValue, extensionValue.getDefaultInstanceForType());
    assertSame(metadata, metadata.getDefaultInstanceForType());
    assertSame(metadata, defaultInstanceForType2.getMetadata());
    assertSame(metadata, defaultInstanceForType2.getMetadataOrBuilder());
    assertSame(metadata, actualCreateMetricResult.getMetadataOrBuilder());
    assertSame(properties, defaultInstanceForType2.getProperties());
    assertSame(properties, defaultInstanceForType2.getPropertiesOrBuilder());
    assertSame(properties, actualCreateMetricResult.getPropertiesOrBuilder());
    assertSame(properties, properties.getDefaultInstanceForType());
    assertSame(templateValue, defaultInstanceForType2.getTemplateValue());
    assertSame(templateValue, defaultInstanceForType2.getTemplateValueOrBuilder());
    assertSame(templateValue, actualCreateMetricResult.getTemplateValueOrBuilder());
    assertSame(templateValue, templateValue.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return Datatype is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}
   */
  @Test
  @DisplayName("Test createMetric(Object, long, String, MetricDataType); when forty-two; then return Datatype is three")
  void testCreateMetric_whenFortyTwo_thenReturnDatatypeIsThree() throws ThingsboardException {
    // Arrange and Act
    SparkplugBProto.Payload.Metric actualCreateMetricResult = SparkplugMetricUtil.createMetric(42, 1L, "Key",
        MetricDataType.Int32);

    // Assert
    Descriptors.Descriptor descriptorForType = actualCreateMetricResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.DescriptorProto> nestedTypeList = toProtoResult.getNestedTypeList();
    assertEquals(1, nestedTypeList.size());
    List<Descriptors.Descriptor> nestedTypes = descriptorForType.getNestedTypes();
    assertEquals(1, nestedTypes.size());
    List<Descriptors.OneofDescriptor> realOneofs = descriptorForType.getRealOneofs();
    assertEquals(1, realOneofs.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(1, messageTypes.size());
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(10, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(10, oneofs.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(19, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(19, fields.size());
    assertEquals(3, actualCreateMetricResult.getDatatype());
    assertEquals(42, actualCreateMetricResult.getIntValue());
    Descriptors.Descriptor containingType = descriptorForType.getContainingType();
    List<Descriptors.Descriptor> nestedTypes2 = containingType.getNestedTypes();
    assertEquals(7, nestedTypes2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(nestedTypeList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    SparkplugBProto.Payload.DataSet datasetValue = actualCreateMetricResult.getDatasetValue();
    Descriptors.Descriptor descriptorForType2 = datasetValue.getDescriptorForType();
    assertSame(containingType, descriptorForType2.getContainingType());
    SparkplugBProto.Payload.MetaData metadata = actualCreateMetricResult.getMetadata();
    Descriptors.Descriptor descriptorForType3 = metadata.getDescriptorForType();
    assertSame(containingType, descriptorForType3.getContainingType());
    SparkplugBProto.Payload.PropertySet properties = actualCreateMetricResult.getProperties();
    Descriptors.Descriptor descriptorForType4 = properties.getDescriptorForType();
    assertSame(containingType, descriptorForType4.getContainingType());
    SparkplugBProto.Payload.Template templateValue = actualCreateMetricResult.getTemplateValue();
    Descriptors.Descriptor descriptorForType5 = templateValue.getDescriptorForType();
    assertSame(containingType, descriptorForType5.getContainingType());
    assertSame(containingType, messageTypes.get(0));
    assertSame(file, containingType.getFile());
    assertSame(file, descriptorForType2.getFile());
    SparkplugBProto.Payload.Metric.MetricValueExtension extensionValue = actualCreateMetricResult.getExtensionValue();
    Descriptors.Descriptor descriptorForType6 = extensionValue.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(17);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(18);
    assertSame(file, getResult4.getFile());
    Descriptors.OneofDescriptor getResult5 = oneofs.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.OneofDescriptor getResult6 = oneofs.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.OneofDescriptor getResult7 = oneofs.get(8);
    assertSame(file, getResult7.getFile());
    Descriptors.OneofDescriptor getResult8 = oneofs.get(9);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options3 = options.getDescriptorForType().getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult2 = containingType.toProto();
    assertSame(options3, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType6.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, containingType.getOptions());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    Any extensions = datasetValue.getExtensions();
    assertSame(options3, extensions.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, descriptorForType6.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(descriptorForType2, nestedTypes2.get(1));
    assertSame(descriptorForType6, getResult4.getMessageType());
    assertSame(descriptorForType6, nestedTypes.get(0));
    assertSame(descriptorForType3, nestedTypes2.get(5));
    assertSame(descriptorForType5, getResult3.getMessageType());
    assertSame(descriptorForType5, nestedTypes2.get(0));
    assertSame(descriptorForType, descriptorForType6.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    SparkplugBProto.Payload.Metric defaultInstanceForType2 = actualCreateMetricResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    assertSame(descriptorForType, nestedTypes2.get(6));
    UnknownFieldSet unknownFields = actualCreateMetricResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, extensions.getUnknownFields());
    assertSame(unknownFields, datasetValue.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, extensionValue.getUnknownFields());
    assertSame(unknownFields, metadata.getUnknownFields());
    assertSame(unknownFields, properties.getUnknownFields());
    assertSame(unknownFields, templateValue.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult5, getResult3.getContainingOneof());
    assertSame(getResult5, getResult4.getContainingOneof());
    assertSame(getResult5, getResult3.getRealContainingOneof());
    assertSame(getResult5, getResult4.getRealContainingOneof());
    assertSame(getResult5, realOneofs.get(0));
    assertSame(getResult6, getResult.getContainingOneof());
    ProtocolStringList columnsList = datasetValue.getColumnsList();
    assertSame(columnsList, defaultInstanceForType.getReservedNameList());
    assertSame(columnsList, toProtoResult2.getReservedNameList());
    assertSame(columnsList, toProtoResult3.getReservedNameList());
    assertSame(columnsList, toProtoResult4.getReservedNameList());
    assertSame(columnsList, toProtoResult.getReservedNameList());
    assertSame(columnsList, properties.getKeysList());
    assertSame(extensions, extensions.getDefaultInstanceForType());
    assertSame(extensions, datasetValue.getExtensionsOrBuilder());
    assertSame(extensions, metadata.getExtensions());
    assertSame(extensions, metadata.getExtensionsOrBuilder());
    assertSame(extensions, extensionValue.getExtensions());
    assertSame(extensions, extensionValue.getExtensionsOrBuilder());
    assertSame(extensions, properties.getExtensions());
    assertSame(extensions, properties.getExtensionsOrBuilder());
    assertSame(extensions, templateValue.getExtensions());
    assertSame(extensions, templateValue.getExtensionsOrBuilder());
    assertSame(datasetValue, datasetValue.getDefaultInstanceForType());
    assertSame(datasetValue, defaultInstanceForType2.getDatasetValue());
    assertSame(datasetValue, defaultInstanceForType2.getDatasetValueOrBuilder());
    assertSame(datasetValue, actualCreateMetricResult.getDatasetValueOrBuilder());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(extensionValue, defaultInstanceForType2.getExtensionValue());
    assertSame(extensionValue, defaultInstanceForType2.getExtensionValueOrBuilder());
    assertSame(extensionValue, actualCreateMetricResult.getExtensionValueOrBuilder());
    assertSame(extensionValue, extensionValue.getDefaultInstanceForType());
    assertSame(metadata, metadata.getDefaultInstanceForType());
    assertSame(metadata, defaultInstanceForType2.getMetadata());
    assertSame(metadata, defaultInstanceForType2.getMetadataOrBuilder());
    assertSame(metadata, actualCreateMetricResult.getMetadataOrBuilder());
    assertSame(properties, defaultInstanceForType2.getProperties());
    assertSame(properties, defaultInstanceForType2.getPropertiesOrBuilder());
    assertSame(properties, actualCreateMetricResult.getPropertiesOrBuilder());
    assertSame(properties, properties.getDefaultInstanceForType());
    assertSame(templateValue, defaultInstanceForType2.getTemplateValue());
    assertSame(templateValue, defaultInstanceForType2.getTemplateValueOrBuilder());
    assertSame(templateValue, actualCreateMetricResult.getTemplateValueOrBuilder());
    assertSame(templateValue, templateValue.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}.
   * <ul>
   *   <li>When {@code Unknown}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#createMetric(Object, long, String, MetricDataType)}
   */
  @Test
  @DisplayName("Test createMetric(Object, long, String, MetricDataType); when 'Unknown'; then throw ThingsboardException")
  void testCreateMetric_whenUnknown_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class,
        () -> SparkplugMetricUtil.createMetric(null, 1L, "Key", MetricDataType.Unknown));
  }

  /**
   * Test File getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugMetricUtil.File#File(SparkplugMetricUtil)}
   *   <li>{@link SparkplugMetricUtil.File#setBytes(byte[])}
   *   <li>{@link SparkplugMetricUtil.File#setFileName(String)}
   *   <li>{@link SparkplugMetricUtil.File#toString()}
   *   <li>{@link SparkplugMetricUtil.File#getBytes()}
   *   <li>{@link SparkplugMetricUtil.File#getFileName()}
   * </ul>
   */
  @Test
  @DisplayName("Test File getters and setters")
  void testFileGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    SparkplugMetricUtil.File actualFile = (new SparkplugMetricUtil()).new File();
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    actualFile.setBytes(bytes);
    actualFile.setFileName("foo.txt");
    String actualToStringResult = actualFile.toString();
    byte[] actualBytes = actualFile.getBytes();

    // Assert that nothing has changed
    assertEquals("File [fileName=foo.txt, bytes=[65, 88, 65, 88, 65, 88, 65, 88]]", actualToStringResult);
    assertEquals("foo.txt", actualFile.getFileName());
    assertSame(bytes, actualBytes);
  }

  /**
   * Test File {@link File#File(SparkplugMetricUtil, String, byte[])}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return FileName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil.File#File(SparkplugMetricUtil, String, byte[])}
   */
  @Test
  @DisplayName("Test File new File(SparkplugMetricUtil, String, byte[]); when 'A'; then return FileName is 'null'")
  void testFileNewFile_whenA_thenReturnFileNameIsNull() throws UnsupportedEncodingException {
    // Arrange and Act
    SparkplugMetricUtil.File actualFile = (new SparkplugMetricUtil()).new File(null,
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualFile.getFileName());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualFile.getBytes());
  }

  /**
   * Test File {@link File#File(SparkplugMetricUtil, String, byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return FileName is {@code foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil.File#File(SparkplugMetricUtil, String, byte[])}
   */
  @Test
  @DisplayName("Test File new File(SparkplugMetricUtil, String, byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return FileName is 'foo.txt'")
  void testFileNewFile_whenAxaxaxaxBytesIsUtf8_thenReturnFileNameIsFooTxt() throws UnsupportedEncodingException {
    // Arrange
    SparkplugMetricUtil sparkplugMetricUtil = new SparkplugMetricUtil();

    // Act
    SparkplugMetricUtil.File actualFile = sparkplugMetricUtil.new File("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("foo.txt", actualFile.getFileName());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualFile.getBytes());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#fromSparkplugBMetricToKeyValueProto(String, Metric)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#fromSparkplugBMetricToKeyValueProto(String, SparkplugBProto.Payload.Metric)}
   */
  @Test
  @DisplayName("Test fromSparkplugBMetricToKeyValueProto(String, Metric); when empty string; then return not Present")
  void testFromSparkplugBMetricToKeyValueProto_whenEmptyString_thenReturnNotPresent() throws ThingsboardException {
    // Arrange and Act
    Optional<TransportProtos.KeyValueProto> actualFromSparkplugBMetricToKeyValueProtoResult = SparkplugMetricUtil
        .fromSparkplugBMetricToKeyValueProto("", SparkplugBProto.Payload.Metric.getDefaultInstance());

    // Assert
    assertFalse(actualFromSparkplugBMetricToKeyValueProtoResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#fromSparkplugBMetricToKeyValueProto(String, Metric)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#fromSparkplugBMetricToKeyValueProto(String, SparkplugBProto.Payload.Metric)}
   */
  @Test
  @DisplayName("Test fromSparkplugBMetricToKeyValueProto(String, Metric); when 'Key'; then return not Present")
  void testFromSparkplugBMetricToKeyValueProto_whenKey_thenReturnNotPresent() throws ThingsboardException {
    // Arrange and Act
    Optional<TransportProtos.KeyValueProto> actualFromSparkplugBMetricToKeyValueProtoResult = SparkplugMetricUtil
        .fromSparkplugBMetricToKeyValueProto("Key", SparkplugBProto.Payload.Metric.getDefaultInstance());

    // Assert
    assertFalse(actualFromSparkplugBMetricToKeyValueProtoResult.isPresent());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long)")
  void testGetTsKvProto() throws ThingsboardException {
    // Arrange
    LinkedList<Object> objectList = new LinkedList<>();

    // Act
    TransportProtos.TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    Descriptors.Descriptor descriptorForType = actualTsKvProto.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
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
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(objectList, defaultInstanceForType.findInitializationErrors());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals(objectList, defaultInstanceForType2.findInitializationErrors());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals(objectList, sourceCodeInfo.findInitializationErrors());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(objectList, defaultInstanceForType3.findInitializationErrors());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals(objectList, features.findInitializationErrors());
    TransportProtos.KeyValueProto kv = actualTsKvProto.getKv();
    Descriptors.Descriptor descriptorForType2 = kv.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals(objectList, toProtoResult3.findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(objectList, options3.findInitializationErrors());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertEquals(objectList, toProtoResult4.findInitializationErrors());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult2.toProto();
    assertEquals(objectList, toProtoResult5.findInitializationErrors());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    assertEquals(objectList, toProtoResult6.findInitializationErrors());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertEquals(objectList, reservedNameList);
    assertEquals(objectList, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType3 = options2.getDescriptorForType();
    assertEquals(objectList, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult.getDescriptorForType();
    assertEquals(objectList, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals(objectList, descriptorForType5.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(0);
    assertEquals(objectList, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertEquals(objectList, getResult5.getEnumTypes());
    Descriptors.Descriptor getResult6 = messageTypes.get(178);
    assertEquals(objectList, getResult6.getEnumTypes());
    Descriptors.Descriptor getResult7 = messageTypes.get(179);
    assertEquals(objectList, getResult7.getEnumTypes());
    assertEquals(objectList, descriptorForType3.getExtensions());
    assertEquals(objectList, descriptorForType4.getExtensions());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals(objectList, descriptorForType6.getExtensions());
    assertEquals(objectList, descriptorForType5.getExtensions());
    assertEquals(objectList, getResult4.getExtensions());
    assertEquals(objectList, getResult5.getExtensions());
    assertEquals(objectList, getResult6.getExtensions());
    assertEquals(objectList, getResult7.getExtensions());
    assertEquals(objectList, descriptorForType3.getNestedTypes());
    assertEquals(objectList, descriptorForType6.getNestedTypes());
    assertEquals(objectList, descriptorForType5.getNestedTypes());
    assertEquals(objectList, getResult4.getNestedTypes());
    assertEquals(objectList, getResult5.getNestedTypes());
    assertEquals(objectList, getResult6.getNestedTypes());
    assertEquals(objectList, getResult7.getNestedTypes());
    assertEquals(objectList, descriptorForType3.getOneofs());
    assertEquals(objectList, descriptorForType4.getOneofs());
    assertEquals(objectList, descriptorForType6.getOneofs());
    assertEquals(objectList, descriptorForType5.getOneofs());
    assertEquals(objectList, getResult4.getOneofs());
    assertEquals(objectList, getResult5.getOneofs());
    assertEquals(objectList, getResult6.getOneofs());
    assertEquals(objectList, getResult7.getOneofs());
    assertEquals(objectList, descriptorForType3.getRealOneofs());
    assertEquals(objectList, descriptorForType4.getRealOneofs());
    assertEquals(objectList, descriptorForType6.getRealOneofs());
    assertEquals(objectList, descriptorForType5.getRealOneofs());
    assertEquals(objectList, getResult4.getRealOneofs());
    assertEquals(objectList, getResult5.getRealOneofs());
    assertEquals(objectList, getResult6.getRealOneofs());
    assertEquals(objectList, getResult7.getRealOneofs());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult7.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    Descriptors.OneofDescriptor getResult8 = oneofs.get(0);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType3.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, descriptorForType4.getOptions());
    assertSame(options4, descriptorForType6.getOptions());
    assertSame(options4, descriptorForType5.getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType2, getResult2.getMessageType());
    TransportProtos.TsKvProto defaultInstanceForType4 = actualTsKvProto.getDefaultInstanceForType();
    TransportProtos.KeyValueProto kv2 = defaultInstanceForType4.getKv();
    assertSame(descriptorForType2, kv2.getDescriptorForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualTsKvProto.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, kv2.getUnknownFields());
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult8, getResult3.getContainingOneof());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(kv2, kv2.getDefaultInstanceForType());
    assertSame(kv2, kv.getDefaultInstanceForType());
    assertSame(kv2, defaultInstanceForType4.getKvOrBuilder());
    assertSame(kv, actualTsKvProto.getKvOrBuilder());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long)")
  void testGetTsKvProto2() throws ThingsboardException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true), 3));

    // Act
    TransportProtos.TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    TransportProtos.KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[[]]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[[]]", kv.getJsonV());
    assertEquals(13, kv.getSerializedSize());
    assertEquals(17, actualTsKvProto.getSerializedSize());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long)")
  void testGetTsKvProto3() throws ThingsboardException {
    // Arrange
    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    arrayNode.addArray();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(arrayNode);

    // Act
    TransportProtos.TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    TransportProtos.KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[[[]]]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[[[]]]", kv.getJsonV());
    assertEquals(15, kv.getSerializedSize());
    assertEquals(19, actualTsKvProto.getSerializedSize());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long)")
  void testGetTsKvProto4() throws ThingsboardException {
    // Arrange
    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    arrayNode.addObject();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(arrayNode);

    // Act
    TransportProtos.TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    TransportProtos.KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[[{}]]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[[{}]]", kv.getJsonV());
    assertEquals(15, kv.getSerializedSize());
    assertEquals(19, actualTsKvProto.getSerializedSize());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); given ArrayList(); when ArrayList() add ArrayList()")
  void testGetTsKvProto_givenArrayList_whenArrayListAddArrayList() throws ThingsboardException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    ArrayList<Object> objectList2 = new ArrayList<>();
    objectList.add(objectList2);

    // Act
    TransportProtos.TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    TransportProtos.KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[[]]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[[]]", kv.getJsonV());
    assertEquals(13, kv.getSerializedSize());
    assertEquals(17, actualTsKvProto.getSerializedSize());
    Descriptors.Descriptor descriptorForType = actualTsKvProto.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals(objectList2, toProtoResult.getDefaultInstanceForType().findInitializationErrors());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    assertEquals(objectList2, toProtoResult2.getDefaultInstanceForType().findInitializationErrors());
    assertEquals(objectList2, toProtoResult2.getSourceCodeInfo().findInitializationErrors());
    DescriptorProtos.FileOptions options = file.getOptions();
    assertEquals(objectList2, options.getDefaultInstanceForType().findInitializationErrors());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    assertEquals(objectList2, options2.getFeatures().findInitializationErrors());
    assertEquals(objectList2, kv.getDescriptorForType().toProto().findInitializationErrors());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals(objectList2, options3.findInitializationErrors());
    assertEquals(objectList2, getResult.toProto().findInitializationErrors());
    assertEquals(objectList2, fields.get(1).toProto().findInitializationErrors());
    assertEquals(objectList2, fields.get(2).toProto().findInitializationErrors());
    assertEquals(objectList2, toProtoResult.getReservedNameList());
    assertEquals(objectList2, options3.getTargetsList());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    assertEquals(objectList2, descriptorForType2.getEnumTypes());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals(objectList2, descriptorForType3.getEnumTypes());
    Descriptors.Descriptor descriptorForType4 = toProtoResult2.getDescriptorForType();
    assertEquals(objectList2, descriptorForType4.getEnumTypes());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertEquals(objectList2, getResult2.getEnumTypes());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertEquals(objectList2, getResult3.getEnumTypes());
    Descriptors.Descriptor getResult4 = messageTypes.get(178);
    assertEquals(objectList2, getResult4.getEnumTypes());
    Descriptors.Descriptor getResult5 = messageTypes.get(179);
    assertEquals(objectList2, getResult5.getEnumTypes());
    assertEquals(objectList2, descriptorForType2.getExtensions());
    assertEquals(objectList2, descriptorForType3.getExtensions());
    Descriptors.Descriptor descriptorForType5 = options.getDescriptorForType();
    assertEquals(objectList2, descriptorForType5.getExtensions());
    assertEquals(objectList2, descriptorForType4.getExtensions());
    assertEquals(objectList2, getResult2.getExtensions());
    assertEquals(objectList2, getResult3.getExtensions());
    assertEquals(objectList2, getResult4.getExtensions());
    assertEquals(objectList2, getResult5.getExtensions());
    assertEquals(objectList2, descriptorForType2.getNestedTypes());
    assertEquals(objectList2, descriptorForType5.getNestedTypes());
    assertEquals(objectList2, descriptorForType4.getNestedTypes());
    assertEquals(objectList2, getResult2.getNestedTypes());
    assertEquals(objectList2, getResult3.getNestedTypes());
    assertEquals(objectList2, getResult4.getNestedTypes());
    assertEquals(objectList2, getResult5.getNestedTypes());
    assertEquals(objectList2, descriptorForType2.getOneofs());
    assertEquals(objectList2, descriptorForType3.getOneofs());
    assertEquals(objectList2, descriptorForType5.getOneofs());
    assertEquals(objectList2, descriptorForType4.getOneofs());
    assertEquals(objectList2, getResult2.getOneofs());
    assertEquals(objectList2, getResult3.getOneofs());
    assertEquals(objectList2, getResult4.getOneofs());
    assertEquals(objectList2, getResult5.getOneofs());
    assertEquals(objectList2, descriptorForType2.getRealOneofs());
    assertEquals(objectList2, descriptorForType3.getRealOneofs());
    assertEquals(objectList2, descriptorForType5.getRealOneofs());
    assertEquals(objectList2, descriptorForType4.getRealOneofs());
    assertEquals(objectList2, getResult2.getRealOneofs());
    assertEquals(objectList2, getResult3.getRealOneofs());
    assertEquals(objectList2, getResult4.getRealOneofs());
    assertEquals(objectList2, getResult5.getRealOneofs());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  void testGetTsKvProto_givenArrayNodeWithNfIsWithExactBigDecimalsTrue() throws ThingsboardException {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act
    TransportProtos.TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    TransportProtos.KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[[]]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[[]]", kv.getJsonV());
    assertEquals(13, kv.getSerializedSize());
    assertEquals(17, actualTsKvProto.getSerializedSize());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <ul>
   *   <li>Then return Kv JsonVBytes toStringUtf8 is {@code [[null]]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); then return Kv JsonVBytes toStringUtf8 is '[[null]]'")
  void testGetTsKvProto_thenReturnKvJsonVBytesToStringUtf8IsNull() throws ThingsboardException {
    // Arrange
    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    arrayNode.add(MissingNode.getInstance());

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(arrayNode);

    // Act
    TransportProtos.TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    TransportProtos.KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[[null]]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[[null]]", kv.getJsonV());
    assertEquals(17, kv.getSerializedSize());
    assertEquals(21, actualTsKvProto.getSerializedSize());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <ul>
   *   <li>Then return Kv JsonVBytes toStringUtf8 is {@code [["Pojo"]]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); then return Kv JsonVBytes toStringUtf8 is '[[\"Pojo\"]]'")
  void testGetTsKvProto_thenReturnKvJsonVBytesToStringUtf8IsPojo() throws ThingsboardException {
    // Arrange
    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    arrayNode.addPOJO("Pojo");

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(arrayNode);

    // Act
    TransportProtos.TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", objectList, 1L);

    // Assert
    TransportProtos.KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals("[[\"Pojo\"]]", kv.getJsonVBytes().toStringUtf8());
    assertEquals("[[\"Pojo\"]]", kv.getJsonV());
    assertEquals(19, kv.getSerializedSize());
    assertEquals(23, actualTsKvProto.getSerializedSize());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Kv KeyBytes toStringUtf8 is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); when empty string; then return Kv KeyBytes toStringUtf8 is empty string")
  void testGetTsKvProto_whenEmptyString_thenReturnKvKeyBytesToStringUtf8IsEmptyString() throws ThingsboardException {
    // Arrange and Act
    TransportProtos.TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("", new ArrayList<>(), 1L);

    // Assert
    TransportProtos.KeyValueProto kv = actualTsKvProto.getKv();
    ByteString keyBytes = kv.getKeyBytes();
    assertEquals("", keyBytes.toStringUtf8());
    assertEquals("", kv.getKey());
    Descriptors.Descriptor descriptorForType = actualTsKvProto.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    assertEquals(10, actualTsKvProto.getSerializedSize());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(6, kv.getSerializedSize());
    assertFalse(keyBytes.iterator().hasNext());
    assertTrue(keyBytes.isEmpty());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(keyBytes, defaultInstanceForType.getNameBytes());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertEquals(keyBytes, toProtoResult3.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult2.toProto();
    assertEquals(keyBytes, toProtoResult4.getDefaultValueBytes());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertEquals(keyBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(keyBytes, toProtoResult3.getExtendeeBytes());
    assertEquals(keyBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(keyBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(keyBytes, toProtoResult3.getJsonNameBytes());
    assertEquals(keyBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(keyBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(keyBytes, toProtoResult3.getTypeNameBytes());
    assertEquals(keyBytes, toProtoResult5.getTypeNameBytes());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals(keyBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(keyBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(keyBytes, defaultInstanceForType2.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(keyBytes, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(keyBytes, options.getCsharpNamespaceBytes());
    assertEquals(keyBytes, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(keyBytes, options.getGoPackageBytes());
    assertEquals(keyBytes, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(keyBytes, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(keyBytes, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(keyBytes, options.getObjcClassPrefixBytes());
    assertEquals(keyBytes, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(keyBytes, options.getPhpClassPrefixBytes());
    assertEquals(keyBytes, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(keyBytes, options.getPhpMetadataNamespaceBytes());
    assertEquals(keyBytes, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(keyBytes, options.getPhpNamespaceBytes());
    assertEquals(keyBytes, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(keyBytes, options.getRubyPackageBytes());
    assertEquals(keyBytes, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(keyBytes, options.getSwiftPrefixBytes());
    TransportProtos.TsKvProto defaultInstanceForType4 = actualTsKvProto.getDefaultInstanceForType();
    TransportProtos.KeyValueProto kv2 = defaultInstanceForType4.getKv();
    assertEquals(keyBytes, kv2.getJsonVBytes());
    assertEquals(keyBytes, kv2.getKeyBytes());
    assertEquals(keyBytes, kv2.getStringVBytes());
    assertEquals(keyBytes, kv.getStringVBytes());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor descriptorForType2 = kv.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
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
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getFile());
    assertSame(file, getResult3.getFile());
    Descriptors.OneofDescriptor getResult8 = oneofs.get(0);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType2.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options4, getResult6.getOptions());
    assertSame(options4, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult2.getOptions());
    assertSame(options3, getResult3.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType2, getResult2.getMessageType());
    assertSame(descriptorForType2, kv2.getDescriptorForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualTsKvProto.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, kv2.getUnknownFields());
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult8, getResult3.getContainingOneof());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(kv2, kv2.getDefaultInstanceForType());
    assertSame(kv2, kv.getDefaultInstanceForType());
    assertSame(kv2, defaultInstanceForType4.getKvOrBuilder());
    assertSame(kv, actualTsKvProto.getKvOrBuilder());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <ul>
   *   <li>When forty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); when forty-two")
  void testGetTsKvProto_whenFortyTwo() throws ThingsboardException {
    // Arrange and Act
    TransportProtos.TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", 42, 1L);

    // Assert
    Descriptors.Descriptor descriptorForType = actualTsKvProto.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
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
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    TransportProtos.KeyValueProto kv = actualTsKvProto.getKv();
    Descriptors.Descriptor descriptorForType2 = kv.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
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
    assertSame(file, descriptorForType2.getFile());
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
    Descriptors.OneofDescriptor getResult8 = oneofs.get(0);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
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
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType2, getResult6.getMessageType());
    TransportProtos.TsKvProto defaultInstanceForType4 = actualTsKvProto.getDefaultInstanceForType();
    TransportProtos.KeyValueProto kv2 = defaultInstanceForType4.getKv();
    assertSame(descriptorForType2, kv2.getDescriptorForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualTsKvProto.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, kv2.getUnknownFields());
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult8, getResult7.getContainingOneof());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(kv2, kv2.getDefaultInstanceForType());
    assertSame(kv2, kv.getDefaultInstanceForType());
    assertSame(kv2, defaultInstanceForType4.getKvOrBuilder());
    assertSame(kv, actualTsKvProto.getKvOrBuilder());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <ul>
   *   <li>When forty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); when forty-two")
  void testGetTsKvProto_whenFortyTwo2() throws ThingsboardException {
    // Arrange and Act
    TransportProtos.TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", 42L, 1L);

    // Assert
    Descriptors.Descriptor descriptorForType = actualTsKvProto.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
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
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    TransportProtos.KeyValueProto kv = actualTsKvProto.getKv();
    Descriptors.Descriptor descriptorForType2 = kv.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
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
    assertSame(file, descriptorForType2.getFile());
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
    Descriptors.OneofDescriptor getResult8 = oneofs.get(0);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
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
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType2, getResult6.getMessageType());
    TransportProtos.TsKvProto defaultInstanceForType4 = actualTsKvProto.getDefaultInstanceForType();
    TransportProtos.KeyValueProto kv2 = defaultInstanceForType4.getKv();
    assertSame(descriptorForType2, kv2.getDescriptorForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualTsKvProto.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, kv2.getUnknownFields());
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult8, getResult7.getContainingOneof());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(kv2, kv2.getDefaultInstanceForType());
    assertSame(kv2, kv.getDefaultInstanceForType());
    assertSame(kv2, defaultInstanceForType4.getKvOrBuilder());
    assertSame(kv, actualTsKvProto.getKvOrBuilder());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); when 'null'; then throw ThingsboardException")
  void testGetTsKvProto_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> SparkplugMetricUtil.getTsKvProto(null, null, 1L));
    assertThrows(ThingsboardException.class, () -> SparkplugMetricUtil.getTsKvProto("Key", null, 1L));
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return Kv DoubleV is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); when ten; then return Kv DoubleV is ten")
  void testGetTsKvProto_whenTen_thenReturnKvDoubleVIsTen() throws ThingsboardException {
    // Arrange and Act
    TransportProtos.TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", 10.0d, 1L);

    // Assert
    Descriptors.Descriptor descriptorForType = actualTsKvProto.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    TransportProtos.KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals(10.0d, kv.getDoubleV());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    assertEquals(2, kv.getTypeValue());
    assertEquals(20, actualTsKvProto.getSerializedSize());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(TransportProtos.KeyValueType.DOUBLE_V, kv.getType());
    assertEquals(Short.SIZE, kv.getSerializedSize());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    Descriptors.Descriptor descriptorForType2 = kv.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
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
    assertSame(file, descriptorForType2.getFile());
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
    Descriptors.OneofDescriptor getResult8 = oneofs.get(0);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
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
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType2, getResult6.getMessageType());
    TransportProtos.TsKvProto defaultInstanceForType4 = actualTsKvProto.getDefaultInstanceForType();
    TransportProtos.KeyValueProto kv2 = defaultInstanceForType4.getKv();
    assertSame(descriptorForType2, kv2.getDescriptorForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualTsKvProto.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, kv2.getUnknownFields());
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult8, getResult7.getContainingOneof());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(kv2, kv2.getDefaultInstanceForType());
    assertSame(kv2, kv.getDefaultInstanceForType());
    assertSame(kv2, defaultInstanceForType4.getKvOrBuilder());
    assertSame(kv, actualTsKvProto.getKvOrBuilder());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return Kv TypeValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); when 'true'; then return Kv TypeValue is zero")
  void testGetTsKvProto_whenTrue_thenReturnKvTypeValueIsZero() throws ThingsboardException {
    // Arrange and Act
    TransportProtos.TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", true, 1L);

    // Assert
    TransportProtos.KeyValueProto kv = actualTsKvProto.getKv();
    assertEquals(0, kv.getTypeValue());
    Descriptors.Descriptor descriptorForType = actualTsKvProto.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    assertEquals(11, actualTsKvProto.getSerializedSize());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(7, kv.getSerializedSize());
    assertEquals(TransportProtos.KeyValueType.BOOLEAN_V, kv.getType());
    assertTrue(kv.getBoolV());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    Descriptors.Descriptor descriptorForType2 = kv.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
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
    assertSame(file, descriptorForType2.getFile());
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
    Descriptors.OneofDescriptor getResult8 = oneofs.get(0);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
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
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType2, getResult6.getMessageType());
    TransportProtos.TsKvProto defaultInstanceForType4 = actualTsKvProto.getDefaultInstanceForType();
    TransportProtos.KeyValueProto kv2 = defaultInstanceForType4.getKv();
    assertSame(descriptorForType2, kv2.getDescriptorForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualTsKvProto.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, kv2.getUnknownFields());
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult8, getResult7.getContainingOneof());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(kv2, kv2.getDefaultInstanceForType());
    assertSame(kv2, kv.getDefaultInstanceForType());
    assertSame(kv2, defaultInstanceForType4.getKvOrBuilder());
    assertSame(kv, actualTsKvProto.getKvOrBuilder());
  }

  /**
   * Test {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return Kv StringVBytes toStringUtf8 is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#getTsKvProto(String, Object, long)}
   */
  @Test
  @DisplayName("Test getTsKvProto(String, Object, long); when 'Value'; then return Kv StringVBytes toStringUtf8 is 'Value'")
  void testGetTsKvProto_whenValue_thenReturnKvStringVBytesToStringUtf8IsValue() throws ThingsboardException {
    // Arrange and Act
    TransportProtos.TsKvProto actualTsKvProto = SparkplugMetricUtil.getTsKvProto("Key", "Value", 1L);

    // Assert
    TransportProtos.KeyValueProto kv = actualTsKvProto.getKv();
    ByteString stringVBytes = kv.getStringVBytes();
    assertEquals("Value", stringVBytes.toStringUtf8());
    assertEquals("Value", kv.getStringV());
    Descriptors.Descriptor descriptorForType = actualTsKvProto.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    assertEquals(14, kv.getSerializedSize());
    assertEquals(18, actualTsKvProto.getSerializedSize());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(3, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(3, fields.size());
    assertEquals(3, kv.getTypeValue());
    assertEquals(TransportProtos.KeyValueType.STRING_V, kv.getType());
    assertFalse(stringVBytes.isEmpty());
    ByteString.ByteIterator iteratorResult = stringVBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('V', iteratorResult.next().byteValue());
    assertEquals('a', iteratorResult.next().byteValue());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    Descriptors.Descriptor descriptorForType2 = kv.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
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
    assertSame(file, descriptorForType2.getFile());
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
    Descriptors.OneofDescriptor getResult8 = oneofs.get(0);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
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
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType2, getResult6.getMessageType());
    TransportProtos.TsKvProto defaultInstanceForType4 = actualTsKvProto.getDefaultInstanceForType();
    TransportProtos.KeyValueProto kv2 = defaultInstanceForType4.getKv();
    assertSame(descriptorForType2, kv2.getDescriptorForType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    UnknownFieldSet unknownFields = actualTsKvProto.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, kv2.getUnknownFields());
    assertSame(unknownFields, kv.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult8, getResult7.getContainingOneof());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertSame(kv2, kv2.getDefaultInstanceForType());
    assertSame(kv2, kv.getDefaultInstanceForType());
    assertSame(kv2, defaultInstanceForType4.getKvOrBuilder());
    assertSame(kv, actualTsKvProto.getKvOrBuilder());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto, MetricDataType)}.
   * <ul>
   *   <li>When {@code Boolean}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueByTypeMetric(KeyValueProto, MetricDataType); when 'Boolean'; then return Present")
  void testValidatedValueByTypeMetric_whenBoolean_thenReturnPresent() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult = SparkplugMetricUtil
        .validatedValueByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Boolean);

    // Assert
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto, MetricDataType)}.
   * <ul>
   *   <li>When {@code Bytes}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueByTypeMetric(KeyValueProto, MetricDataType); when 'Bytes'; then return not Present")
  void testValidatedValueByTypeMetric_whenBytes_thenReturnNotPresent() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult = SparkplugMetricUtil
        .validatedValueByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto, MetricDataType)}.
   * <ul>
   *   <li>When {@code DateTime}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueByTypeMetric(KeyValueProto, MetricDataType); when 'DateTime'; then return Present")
  void testValidatedValueByTypeMetric_whenDateTime_thenReturnPresent() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult = SparkplugMetricUtil
        .validatedValueByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.DateTime);

    // Assert
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto, MetricDataType)}.
   * <ul>
   *   <li>When {@code Double}.</li>
   *   <li>Then return {@link Optional#get()} doubleValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueByTypeMetric(KeyValueProto, MetricDataType); when 'Double'; then return get() doubleValue is zero")
  void testValidatedValueByTypeMetric_whenDouble_thenReturnGetDoubleValueIsZero() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult = SparkplugMetricUtil
        .validatedValueByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Double);

    // Assert
    assertEquals(0.0d, ((Double) actualValidatedValueByTypeMetricResult.get()).doubleValue());
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto, MetricDataType)}.
   * <ul>
   *   <li>When {@code Float}.</li>
   *   <li>Then return {@link Optional#get()} floatValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueByTypeMetric(KeyValueProto, MetricDataType); when 'Float'; then return get() floatValue is zero")
  void testValidatedValueByTypeMetric_whenFloat_thenReturnGetFloatValueIsZero() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult = SparkplugMetricUtil
        .validatedValueByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Float);

    // Assert
    assertEquals(0.0f, ((Float) actualValidatedValueByTypeMetricResult.get()).floatValue());
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto, MetricDataType)}.
   * <ul>
   *   <li>When {@code Int8}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueByTypeMetric(KeyValueProto, MetricDataType); when 'Int8'; then return Present")
  void testValidatedValueByTypeMetric_whenInt8_thenReturnPresent() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult = SparkplugMetricUtil
        .validatedValueByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Int8);

    // Assert
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(KeyValueProto, MetricDataType)}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@link Optional#get()} is {@link Boolean#FALSE}
   * toString.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueByTypeMetric(KeyValueProto, MetricDataType); when 'String'; then return get() is FALSE toString")
  void testValidatedValueByTypeMetric_whenString_thenReturnGetIsFalseToString() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValueByTypeMetricResult = SparkplugMetricUtil
        .validatedValueByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.String);

    // Assert
    assertTrue(actualValidatedValueByTypeMetricResult.isPresent());
    String expectedString = Boolean.FALSE.toString();
    assertEquals(expectedString, actualValidatedValueByTypeMetricResult.get());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   * <ul>
   *   <li>When {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when '0'")
  void testValidatedValueJsonByTypeMetric_when0() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("0", MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when '42'")
  void testValidatedValueJsonByTypeMetric_when42() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("42", MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   * <ul>
   *   <li>When {@code Array Node Str}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when 'Array Node Str'")
  void testValidatedValueJsonByTypeMetric_whenArrayNodeStr() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("Array Node Str", MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   * <ul>
   *   <li>When {@code DataSet}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when 'DataSet'")
  void testValidatedValueJsonByTypeMetric_whenDataSet() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("Array Node Str", MetricDataType.DataSet);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when empty string")
  void testValidatedValueJsonByTypeMetric_whenEmptyString() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil.validatedValueJsonByTypeMetric("",
        MetricDataType.Bytes);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}.
   * <ul>
   *   <li>When {@code Int8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValueJsonByTypeMetric(String, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValueJsonByTypeMetric(String, MetricDataType); when 'Int8'")
  void testValidatedValueJsonByTypeMetric_whenInt8() {
    // Arrange and Act
    Optional<Object> actualValidatedValueJsonByTypeMetricResult = SparkplugMetricUtil
        .validatedValueJsonByTypeMetric("Array Node Str", MetricDataType.Int8);

    // Assert
    assertFalse(actualValidatedValueJsonByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} doubleValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType); then return get() doubleValue is zero")
  void testValidatedValuePrimitiveByTypeMetric_thenReturnGetDoubleValueIsZero() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult = SparkplugMetricUtil
        .validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Double);

    // Assert
    assertEquals(0.0d, ((Double) actualValidatedValuePrimitiveByTypeMetricResult.get()).doubleValue());
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)}.
   * <ul>
   *   <li>When {@code Boolean}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType); when 'Boolean'; then return Present")
  void testValidatedValuePrimitiveByTypeMetric_whenBoolean_thenReturnPresent() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult = SparkplugMetricUtil
        .validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(),
            MetricDataType.Boolean);

    // Assert
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)}.
   * <ul>
   *   <li>When {@code DataSet}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType); when 'DataSet'; then return not Present")
  void testValidatedValuePrimitiveByTypeMetric_whenDataSet_thenReturnNotPresent() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult = SparkplugMetricUtil
        .validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(),
            MetricDataType.DataSet);

    // Assert
    assertFalse(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)}.
   * <ul>
   *   <li>When {@code DateTime}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType); when 'DateTime'; then return Present")
  void testValidatedValuePrimitiveByTypeMetric_whenDateTime_thenReturnPresent() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult = SparkplugMetricUtil
        .validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(),
            MetricDataType.DateTime);

    // Assert
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)}.
   * <ul>
   *   <li>When {@code Float}.</li>
   *   <li>Then return {@link Optional#get()} floatValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType); when 'Float'; then return get() floatValue is zero")
  void testValidatedValuePrimitiveByTypeMetric_whenFloat_thenReturnGetFloatValueIsZero() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult = SparkplugMetricUtil
        .validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Float);

    // Assert
    assertEquals(0.0f, ((Float) actualValidatedValuePrimitiveByTypeMetricResult.get()).floatValue());
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)}.
   * <ul>
   *   <li>When {@code Int8}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType); when 'Int8'; then return Present")
  void testValidatedValuePrimitiveByTypeMetric_whenInt8_thenReturnPresent() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult = SparkplugMetricUtil
        .validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.Int8);

    // Assert
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
  }

  /**
   * Test
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType)}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@link Optional#get()} is {@link Boolean#FALSE}
   * toString.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparkplugMetricUtil#validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto, MetricDataType)}
   */
  @Test
  @DisplayName("Test validatedValuePrimitiveByTypeMetric(KeyValueProto, MetricDataType); when 'String'; then return get() is FALSE toString")
  void testValidatedValuePrimitiveByTypeMetric_whenString_thenReturnGetIsFalseToString() throws ThingsboardException {
    // Arrange and Act
    Optional<Object> actualValidatedValuePrimitiveByTypeMetricResult = SparkplugMetricUtil
        .validatedValuePrimitiveByTypeMetric(TransportProtos.KeyValueProto.getDefaultInstance(), MetricDataType.String);

    // Assert
    assertTrue(actualValidatedValuePrimitiveByTypeMetricResult.isPresent());
    String expectedString = Boolean.FALSE.toString();
    assertEquals(expectedString, actualValidatedValuePrimitiveByTypeMetricResult.get());
  }
}
