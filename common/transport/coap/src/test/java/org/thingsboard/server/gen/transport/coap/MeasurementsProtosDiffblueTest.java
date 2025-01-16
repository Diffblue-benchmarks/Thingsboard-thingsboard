package org.thingsboard.server.gen.transport.coap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.coap.MeasurementsProtos.ProtoChannel;
import org.thingsboard.server.gen.transport.coap.MeasurementsProtos.ProtoMeasurements;

class MeasurementsProtosDiffblueTest {
  /**
   * Test ProtoChannel {@link ProtoChannel#equals(Object)}, and
   * {@link ProtoChannel#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MeasurementsProtos.ProtoChannel#equals(Object)}
   *   <li>{@link MeasurementsProtos.ProtoChannel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoChannel equals(Object), and hashCode(); when other is equal; then return equal")
  void testProtoChannelEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MeasurementsProtos.ProtoChannel defaultInstance = MeasurementsProtos.ProtoChannel.getDefaultInstance();
    MeasurementsProtos.ProtoChannel defaultInstance2 = MeasurementsProtos.ProtoChannel.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#equals(Object)}, and
   * {@link ProtoChannel#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MeasurementsProtos.ProtoChannel#equals(Object)}
   *   <li>{@link MeasurementsProtos.ProtoChannel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoChannel equals(Object), and hashCode(); when other is same; then return equal")
  void testProtoChannelEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MeasurementsProtos.ProtoChannel defaultInstance = MeasurementsProtos.ProtoChannel.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementsProtos.ProtoChannel#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoChannel equals(Object); when other is different; then return not equal")
  void testProtoChannelEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MeasurementsProtos.ProtoChannel.getDefaultInstance(), 1);
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementsProtos.ProtoChannel#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoChannel equals(Object); when other is 'null'; then return not equal")
  void testProtoChannelEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MeasurementsProtos.ProtoChannel.getDefaultInstance(), null);
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MeasurementsProtos.ProtoChannel#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoChannel equals(Object); when other is wrong type; then return not equal")
  void testProtoChannelEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MeasurementsProtos.ProtoChannel.getDefaultInstance(), "Different type to ProtoChannel");
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ProtoChannel getDefaultInstanceForType()")
  void testProtoChannelGetDefaultInstanceForType() {
    // Arrange
    MeasurementsProtos.ProtoChannel defaultInstance = MeasurementsProtos.ProtoChannel.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#getSampleOffsetsCount()}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#getSampleOffsetsCount()}
   */
  @Test
  @DisplayName("Test ProtoChannel getSampleOffsetsCount()")
  void testProtoChannelGetSampleOffsetsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MeasurementsProtos.ProtoChannel.getDefaultInstance().getSampleOffsetsCount());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ProtoChannel getSerializedSize()")
  void testProtoChannelGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MeasurementsProtos.ProtoChannel.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#getType()}.
   * <p>
   * Method under test: {@link MeasurementsProtos.ProtoChannel#getType()}
   */
  @Test
  @DisplayName("Test ProtoChannel getType()")
  void testProtoChannelGetType() {
    // Arrange, Act and Assert
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR,
        MeasurementsProtos.ProtoChannel.getDefaultInstance().getType());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#isInitialized()}.
   * <p>
   * Method under test: {@link MeasurementsProtos.ProtoChannel#isInitialized()}
   */
  @Test
  @DisplayName("Test ProtoChannel isInitialized()")
  void testProtoChannelIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MeasurementsProtos.ProtoChannel.getDefaultInstance().isInitialized());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test ProtoChannel newInstance(UnusedPrivateParameter)")
  void testProtoChannelNewInstance() {
    // Arrange
    MeasurementsProtos.ProtoChannel defaultInstance = MeasurementsProtos.ProtoChannel.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof MeasurementsProtos.ProtoChannel);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream) with 'input'")
  void testProtoChannelParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MeasurementsProtos.ProtoChannel actualParseDelimitedFromResult = MeasurementsProtos.ProtoChannel
        .parseDelimitedFrom(input);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(3);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", toProtoResult2.getPackage());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    assertEquals("", getResult5.getEditionName());
    assertEquals("", file.getPackage());
    assertEquals("", getResult5.getPackage());
    assertEquals(".MeasurementType", toProtoResult4.getTypeName());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertEquals("MeasurementType", enumType.getFullName());
    assertEquals("MeasurementType", enumType.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MeasurementsProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MeasurementsProtos", options.getJavaOuterClassname());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ProtoChannel", nameBytes.toStringUtf8());
    assertEquals("ProtoChannel", toProtoResult.getName());
    assertEquals("ProtoChannel", descriptorForType.getFullName());
    assertEquals("ProtoChannel", descriptorForType.getName());
    assertEquals("ProtoChannel.sample_offsets", getResult2.getFullName());
    assertEquals("ProtoChannel.start_point", getResult4.getFullName());
    assertEquals("ProtoChannel.timestamp", getResult3.getFullName());
    assertEquals("ProtoChannel.type", getResult.getFullName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(2, messageTypes.size());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertEquals("ProtoMeasurements", getResult6.getFullName());
    assertEquals("ProtoMeasurements", getResult6.getName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getFullName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("efento/proto_measurement_types.proto", dependencyList.get(0));
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("efento/proto_measurements.proto", nameBytes2.toStringUtf8());
    assertEquals("efento/proto_measurements.proto", toProtoResult2.getName());
    assertEquals("efento/proto_measurements.proto", file.getFullName());
    assertEquals("efento/proto_measurements.proto", file.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.transport.coap", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.transport.coap", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("sampleOffsets", getResult2.getJsonName());
    assertEquals("sample_offsets", toProtoResult7.getName());
    assertEquals("sample_offsets", getResult2.getName());
    assertEquals("startPoint", getResult4.getJsonName());
    assertEquals("start_point", toProtoResult6.getName());
    assertEquals("start_point", getResult4.getName());
    assertEquals("timestamp", toProtoResult5.getName());
    assertEquals("timestamp", getResult3.getJsonName());
    assertEquals("timestamp", getResult3.getName());
    assertEquals("type", toProtoResult4.getName());
    assertEquals("type", getResult.getJsonName());
    assertEquals("type", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(enumType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options4.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options4.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, enumType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseDelimitedFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getStartPoint());
    assertEquals(0, actualParseDelimitedFromResult.getTimestamp());
    assertEquals(0, actualParseDelimitedFromResult.getTypeValue());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult4.getNumber());
    assertEquals(1, toProtoResult2.getDependencyCount());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, getResult6.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(132, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult5.getNumber());
    assertEquals(2, options4.getSerializedSize());
    assertEquals(2, toProtoResult2.getMessageTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult4.getIndex());
    assertEquals(2, getResult3.getNumber());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(2, messageTypeList.size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
    assertEquals(3, toProtoResult.getReservedRangeCount());
    assertEquals(3, getResult2.getIndex());
    List<DescriptorProtos.DescriptorProto.ReservedRange> reservedRangeList = toProtoResult.getReservedRangeList();
    assertEquals(3, reservedRangeList.size());
    assertEquals(3, toProtoResult.getAllFields().size());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult6.getNumber());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult7.getNumber());
    assertEquals(5, getResult2.getNumber());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(552, toProtoResult2.getSerializedSize());
    assertEquals(63, options.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult5.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_ENUM, toProtoResult4.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options4.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options4.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options4.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult4.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult5.getSyntax());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult4.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult4.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR,
        actualParseDelimitedFromResult.getType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options4.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options4.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options4.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options4.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options4.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options4.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options4.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options4.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options4.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options4.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options4.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options4.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options4.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(options4.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(toProtoResult2.hasPackage());
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
    assertFalse(options.getJavaMultipleFiles());
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
    assertFalse(options.hasJavaMultipleFiles());
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
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(enumType.isClosed());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult2.isOptional());
    assertFalse(getResult.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult7.hasOptions());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult4.hasTypeName());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(options4.getPacked());
    assertTrue(options4.hasPacked());
    assertTrue(options3.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(getResult2.isPackable());
    assertTrue(getResult2.isPacked());
    assertTrue(getResult2.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = syntaxBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseDelimitedFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Integer> sampleOffsetsList = actualParseDelimitedFromResult.getSampleOffsetsList();
    assertTrue(sampleOffsetsList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseDelimitedFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, options4.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getMessageTypes());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult5.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
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
    assertEquals(allFields2, defaultInstanceForType.getAllFields());
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertEquals(ConfigProtos.ProtoConfig.DATA_SERVER_IP_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.MEASUREMENT_PERIOD_FACTOR_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.MEMORY_RESET_REQUEST_FIELD_NUMBER, toProtoResult4.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.PLMN_SELECTION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('M', iteratorResult4.next().byteValue());
    assertEquals('P', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('o', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(reservedRangeList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(uninterpretedOptionList, getResult2.getDefaultValue());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType6.getOptions());
    assertSame(options5, descriptorForType5.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getPublicDependencyList());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getWeakDependencyList());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream) with 'input'")
  void testProtoChannelParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MeasurementsProtos.ProtoChannel.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoChannel
   * {@link ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testProtoChannelParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    MeasurementsProtos.ProtoChannel actualParseDelimitedFromResult = MeasurementsProtos.ProtoChannel
        .parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(3);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseDelimitedFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", toProtoResult2.getPackage());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    assertEquals("", getResult5.getEditionName());
    assertEquals("", file.getPackage());
    assertEquals("", getResult5.getPackage());
    assertEquals(".MeasurementType", toProtoResult4.getTypeName());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertEquals("MeasurementType", enumType.getFullName());
    assertEquals("MeasurementType", enumType.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MeasurementsProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MeasurementsProtos", options.getJavaOuterClassname());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ProtoChannel", nameBytes.toStringUtf8());
    assertEquals("ProtoChannel", toProtoResult.getName());
    assertEquals("ProtoChannel", descriptorForType.getFullName());
    assertEquals("ProtoChannel", descriptorForType.getName());
    assertEquals("ProtoChannel.sample_offsets", getResult2.getFullName());
    assertEquals("ProtoChannel.start_point", getResult4.getFullName());
    assertEquals("ProtoChannel.timestamp", getResult3.getFullName());
    assertEquals("ProtoChannel.type", getResult.getFullName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(2, messageTypes.size());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertEquals("ProtoMeasurements", getResult6.getFullName());
    assertEquals("ProtoMeasurements", getResult6.getName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getFullName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("efento/proto_measurement_types.proto", dependencyList.get(0));
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("efento/proto_measurements.proto", nameBytes2.toStringUtf8());
    assertEquals("efento/proto_measurements.proto", toProtoResult2.getName());
    assertEquals("efento/proto_measurements.proto", file.getFullName());
    assertEquals("efento/proto_measurements.proto", file.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.transport.coap", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.transport.coap", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("sampleOffsets", getResult2.getJsonName());
    assertEquals("sample_offsets", toProtoResult7.getName());
    assertEquals("sample_offsets", getResult2.getName());
    assertEquals("startPoint", getResult4.getJsonName());
    assertEquals("start_point", toProtoResult6.getName());
    assertEquals("start_point", getResult4.getName());
    assertEquals("timestamp", toProtoResult5.getName());
    assertEquals("timestamp", getResult3.getJsonName());
    assertEquals("timestamp", getResult3.getName());
    assertEquals("type", toProtoResult4.getName());
    assertEquals("type", getResult.getJsonName());
    assertEquals("type", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(enumType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options4.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options4.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, enumType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseDelimitedFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getStartPoint());
    assertEquals(0, actualParseDelimitedFromResult.getTimestamp());
    assertEquals(0, actualParseDelimitedFromResult.getTypeValue());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult4.getNumber());
    assertEquals(1, toProtoResult2.getDependencyCount());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, getResult6.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(132, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult5.getNumber());
    assertEquals(2, options4.getSerializedSize());
    assertEquals(2, toProtoResult2.getMessageTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult4.getIndex());
    assertEquals(2, getResult3.getNumber());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(2, messageTypeList.size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
    assertEquals(3, toProtoResult.getReservedRangeCount());
    assertEquals(3, getResult2.getIndex());
    List<DescriptorProtos.DescriptorProto.ReservedRange> reservedRangeList = toProtoResult.getReservedRangeList();
    assertEquals(3, reservedRangeList.size());
    assertEquals(3, toProtoResult.getAllFields().size());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult6.getNumber());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult7.getNumber());
    assertEquals(5, getResult2.getNumber());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(552, toProtoResult2.getSerializedSize());
    assertEquals(63, options.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult5.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_ENUM, toProtoResult4.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options4.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options4.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options4.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult4.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult5.getSyntax());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult4.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult4.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR,
        actualParseDelimitedFromResult.getType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options4.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options4.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options4.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options4.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options4.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options4.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options4.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options4.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options4.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options4.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options4.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options4.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options4.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(options4.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(toProtoResult2.hasPackage());
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
    assertFalse(options.getJavaMultipleFiles());
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
    assertFalse(options.hasJavaMultipleFiles());
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
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(enumType.isClosed());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult2.isOptional());
    assertFalse(getResult.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult7.hasOptions());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult4.hasTypeName());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(options4.getPacked());
    assertTrue(options4.hasPacked());
    assertTrue(options3.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(getResult2.isPackable());
    assertTrue(getResult2.isPacked());
    assertTrue(getResult2.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = syntaxBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseDelimitedFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Integer> sampleOffsetsList = actualParseDelimitedFromResult.getSampleOffsetsList();
    assertTrue(sampleOffsetsList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseDelimitedFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseDelimitedFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, options4.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getMessageTypes());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult5.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
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
    assertEquals(allFields2, defaultInstanceForType.getAllFields());
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    assertEquals(ConfigProtos.ProtoConfig.DATA_SERVER_IP_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.MEASUREMENT_PERIOD_FACTOR_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.MEMORY_RESET_REQUEST_FIELD_NUMBER, toProtoResult4.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.PLMN_SELECTION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('M', iteratorResult4.next().byteValue());
    assertEquals('P', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('o', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(reservedRangeList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(uninterpretedOptionList, getResult2.getDefaultValue());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType6.getOptions());
    assertSame(options5, descriptorForType5.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getPublicDependencyList());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getWeakDependencyList());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test ProtoChannel
   * {@link ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testProtoChannelParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> MeasurementsProtos.ProtoChannel.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoChannel
   * {@link ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testProtoChannelParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MeasurementsProtos.ProtoChannel.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoChannel
   * {@link ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testProtoChannelParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MeasurementsProtos.ProtoChannel.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testProtoChannelParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MeasurementsProtos.ProtoChannel.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testProtoChannelParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MeasurementsProtos.ProtoChannel.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(ByteBuffer)} with
   * {@code ByteBuffer}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseFrom(ByteBuffer)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(ByteBuffer) with 'ByteBuffer'")
  void testProtoChannelParseFromWithByteBuffer() throws InvalidProtocolBufferException {
    // Arrange and Act
    MeasurementsProtos.ProtoChannel actualParseFromResult = MeasurementsProtos.ProtoChannel
        .parseFrom(ByteBuffer.wrap(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(3);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", toProtoResult2.getPackage());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    assertEquals("", getResult5.getEditionName());
    assertEquals("", file.getPackage());
    assertEquals("", getResult5.getPackage());
    assertEquals(".MeasurementType", toProtoResult4.getTypeName());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertEquals("MeasurementType", enumType.getFullName());
    assertEquals("MeasurementType", enumType.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MeasurementsProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MeasurementsProtos", options.getJavaOuterClassname());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ProtoChannel", nameBytes.toStringUtf8());
    assertEquals("ProtoChannel", toProtoResult.getName());
    assertEquals("ProtoChannel", descriptorForType.getFullName());
    assertEquals("ProtoChannel", descriptorForType.getName());
    assertEquals("ProtoChannel.sample_offsets", getResult2.getFullName());
    assertEquals("ProtoChannel.start_point", getResult4.getFullName());
    assertEquals("ProtoChannel.timestamp", getResult3.getFullName());
    assertEquals("ProtoChannel.type", getResult.getFullName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(2, messageTypes.size());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertEquals("ProtoMeasurements", getResult6.getFullName());
    assertEquals("ProtoMeasurements", getResult6.getName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getFullName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("efento/proto_measurement_types.proto", dependencyList.get(0));
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("efento/proto_measurements.proto", nameBytes2.toStringUtf8());
    assertEquals("efento/proto_measurements.proto", toProtoResult2.getName());
    assertEquals("efento/proto_measurements.proto", file.getFullName());
    assertEquals("efento/proto_measurements.proto", file.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.transport.coap", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.transport.coap", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("sampleOffsets", getResult2.getJsonName());
    assertEquals("sample_offsets", toProtoResult7.getName());
    assertEquals("sample_offsets", getResult2.getName());
    assertEquals("startPoint", getResult4.getJsonName());
    assertEquals("start_point", toProtoResult6.getName());
    assertEquals("start_point", getResult4.getName());
    assertEquals("timestamp", toProtoResult5.getName());
    assertEquals("timestamp", getResult3.getJsonName());
    assertEquals("timestamp", getResult3.getName());
    assertEquals("type", toProtoResult4.getName());
    assertEquals("type", getResult.getJsonName());
    assertEquals("type", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(enumType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options4.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options4.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, enumType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult4.getNumber());
    assertEquals(1, toProtoResult2.getDependencyCount());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, getResult6.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(132, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult5.getNumber());
    assertEquals(2, options4.getSerializedSize());
    assertEquals(2, toProtoResult2.getMessageTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult4.getIndex());
    assertEquals(2, getResult3.getNumber());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(2, messageTypeList.size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
    assertEquals(3, toProtoResult.getReservedRangeCount());
    assertEquals(3, getResult2.getIndex());
    List<DescriptorProtos.DescriptorProto.ReservedRange> reservedRangeList = toProtoResult.getReservedRangeList();
    assertEquals(3, reservedRangeList.size());
    assertEquals(3, toProtoResult.getAllFields().size());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult6.getNumber());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult7.getNumber());
    assertEquals(5, getResult2.getNumber());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(552, toProtoResult2.getSerializedSize());
    assertEquals(63, options.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult5.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_ENUM, toProtoResult4.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options4.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options4.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options4.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult4.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult5.getSyntax());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult4.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult4.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options4.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options4.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options4.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options4.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options4.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options4.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options4.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options4.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options4.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options4.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options4.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options4.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options4.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(options4.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(toProtoResult2.hasPackage());
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
    assertFalse(options.getJavaMultipleFiles());
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
    assertFalse(options.hasJavaMultipleFiles());
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
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(enumType.isClosed());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult2.isOptional());
    assertFalse(getResult.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult7.hasOptions());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult4.hasTypeName());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(options4.getPacked());
    assertTrue(options4.hasPacked());
    assertTrue(options3.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(getResult2.isPackable());
    assertTrue(getResult2.isPacked());
    assertTrue(getResult2.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = syntaxBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Integer> sampleOffsetsList = actualParseFromResult.getSampleOffsetsList();
    assertTrue(sampleOffsetsList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, options4.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getMessageTypes());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult5.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
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
    assertEquals(allFields2, defaultInstanceForType.getAllFields());
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(ConfigProtos.ProtoConfig.DATA_SERVER_IP_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.MEASUREMENT_PERIOD_FACTOR_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.MEMORY_RESET_REQUEST_FIELD_NUMBER, toProtoResult4.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.PLMN_SELECTION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('M', iteratorResult4.next().byteValue());
    assertEquals('P', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('o', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(reservedRangeList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(uninterpretedOptionList, getResult2.getDefaultValue());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType6.getOptions());
    assertSame(options5, descriptorForType5.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getPublicDependencyList());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getWeakDependencyList());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
  }

  /**
   * Test ProtoChannel
   * {@link ProtoChannel#parseFrom(ByteBuffer, ExtensionRegistryLite)} with
   * {@code ByteBuffer}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseFrom(ByteBuffer, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(ByteBuffer, ExtensionRegistryLite) with 'ByteBuffer', 'ExtensionRegistryLite'")
  void testProtoChannelParseFromWithByteBufferExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange
    ByteBuffer data = ByteBuffer.wrap(new byte[]{});

    // Act
    MeasurementsProtos.ProtoChannel actualParseFromResult = MeasurementsProtos.ProtoChannel.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(3);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", toProtoResult2.getPackage());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    assertEquals("", getResult5.getEditionName());
    assertEquals("", file.getPackage());
    assertEquals("", getResult5.getPackage());
    assertEquals(".MeasurementType", toProtoResult4.getTypeName());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertEquals("MeasurementType", enumType.getFullName());
    assertEquals("MeasurementType", enumType.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MeasurementsProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MeasurementsProtos", options.getJavaOuterClassname());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ProtoChannel", nameBytes.toStringUtf8());
    assertEquals("ProtoChannel", toProtoResult.getName());
    assertEquals("ProtoChannel", descriptorForType.getFullName());
    assertEquals("ProtoChannel", descriptorForType.getName());
    assertEquals("ProtoChannel.sample_offsets", getResult2.getFullName());
    assertEquals("ProtoChannel.start_point", getResult4.getFullName());
    assertEquals("ProtoChannel.timestamp", getResult3.getFullName());
    assertEquals("ProtoChannel.type", getResult.getFullName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(2, messageTypes.size());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertEquals("ProtoMeasurements", getResult6.getFullName());
    assertEquals("ProtoMeasurements", getResult6.getName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getFullName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("efento/proto_measurement_types.proto", dependencyList.get(0));
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("efento/proto_measurements.proto", nameBytes2.toStringUtf8());
    assertEquals("efento/proto_measurements.proto", toProtoResult2.getName());
    assertEquals("efento/proto_measurements.proto", file.getFullName());
    assertEquals("efento/proto_measurements.proto", file.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.transport.coap", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.transport.coap", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("sampleOffsets", getResult2.getJsonName());
    assertEquals("sample_offsets", toProtoResult7.getName());
    assertEquals("sample_offsets", getResult2.getName());
    assertEquals("startPoint", getResult4.getJsonName());
    assertEquals("start_point", toProtoResult6.getName());
    assertEquals("start_point", getResult4.getName());
    assertEquals("timestamp", toProtoResult5.getName());
    assertEquals("timestamp", getResult3.getJsonName());
    assertEquals("timestamp", getResult3.getName());
    assertEquals("type", toProtoResult4.getName());
    assertEquals("type", getResult.getJsonName());
    assertEquals("type", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(enumType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options4.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options4.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, enumType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult4.getNumber());
    assertEquals(1, toProtoResult2.getDependencyCount());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, getResult6.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(132, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult5.getNumber());
    assertEquals(2, options4.getSerializedSize());
    assertEquals(2, toProtoResult2.getMessageTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult4.getIndex());
    assertEquals(2, getResult3.getNumber());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(2, messageTypeList.size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
    assertEquals(3, toProtoResult.getReservedRangeCount());
    assertEquals(3, getResult2.getIndex());
    List<DescriptorProtos.DescriptorProto.ReservedRange> reservedRangeList = toProtoResult.getReservedRangeList();
    assertEquals(3, reservedRangeList.size());
    assertEquals(3, toProtoResult.getAllFields().size());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult6.getNumber());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult7.getNumber());
    assertEquals(5, getResult2.getNumber());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(552, toProtoResult2.getSerializedSize());
    assertEquals(63, options.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult5.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_ENUM, toProtoResult4.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options4.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options4.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options4.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult4.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult5.getSyntax());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult4.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult4.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options4.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options4.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options4.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options4.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options4.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options4.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options4.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options4.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options4.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options4.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options4.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options4.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options4.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(options4.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(toProtoResult2.hasPackage());
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
    assertFalse(options.getJavaMultipleFiles());
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
    assertFalse(options.hasJavaMultipleFiles());
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
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(enumType.isClosed());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult2.isOptional());
    assertFalse(getResult.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult7.hasOptions());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult4.hasTypeName());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(options4.getPacked());
    assertTrue(options4.hasPacked());
    assertTrue(options3.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(getResult2.isPackable());
    assertTrue(getResult2.isPacked());
    assertTrue(getResult2.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = syntaxBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Integer> sampleOffsetsList = actualParseFromResult.getSampleOffsetsList();
    assertTrue(sampleOffsetsList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, options4.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getMessageTypes());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult5.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
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
    assertEquals(allFields2, defaultInstanceForType.getAllFields());
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(ConfigProtos.ProtoConfig.DATA_SERVER_IP_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.MEASUREMENT_PERIOD_FACTOR_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.MEMORY_RESET_REQUEST_FIELD_NUMBER, toProtoResult4.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.PLMN_SELECTION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('M', iteratorResult4.next().byteValue());
    assertEquals('P', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('o', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(reservedRangeList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(uninterpretedOptionList, getResult2.getDefaultValue());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType6.getOptions());
    assertSame(options5, descriptorForType5.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getPublicDependencyList());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getWeakDependencyList());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
  }

  /**
   * Test ProtoChannel
   * {@link ProtoChannel#parseFrom(byte[], ExtensionRegistryLite)} with
   * {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  void testProtoChannelParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    MeasurementsProtos.ProtoChannel actualParseFromResult = MeasurementsProtos.ProtoChannel.parseFrom(new byte[]{},
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(3);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", toProtoResult2.getPackage());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    assertEquals("", getResult5.getEditionName());
    assertEquals("", file.getPackage());
    assertEquals("", getResult5.getPackage());
    assertEquals(".MeasurementType", toProtoResult4.getTypeName());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertEquals("MeasurementType", enumType.getFullName());
    assertEquals("MeasurementType", enumType.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MeasurementsProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MeasurementsProtos", options.getJavaOuterClassname());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ProtoChannel", nameBytes.toStringUtf8());
    assertEquals("ProtoChannel", toProtoResult.getName());
    assertEquals("ProtoChannel", descriptorForType.getFullName());
    assertEquals("ProtoChannel", descriptorForType.getName());
    assertEquals("ProtoChannel.sample_offsets", getResult2.getFullName());
    assertEquals("ProtoChannel.start_point", getResult4.getFullName());
    assertEquals("ProtoChannel.timestamp", getResult3.getFullName());
    assertEquals("ProtoChannel.type", getResult.getFullName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(2, messageTypes.size());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertEquals("ProtoMeasurements", getResult6.getFullName());
    assertEquals("ProtoMeasurements", getResult6.getName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getFullName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("efento/proto_measurement_types.proto", dependencyList.get(0));
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("efento/proto_measurements.proto", nameBytes2.toStringUtf8());
    assertEquals("efento/proto_measurements.proto", toProtoResult2.getName());
    assertEquals("efento/proto_measurements.proto", file.getFullName());
    assertEquals("efento/proto_measurements.proto", file.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.transport.coap", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.transport.coap", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("sampleOffsets", getResult2.getJsonName());
    assertEquals("sample_offsets", toProtoResult7.getName());
    assertEquals("sample_offsets", getResult2.getName());
    assertEquals("startPoint", getResult4.getJsonName());
    assertEquals("start_point", toProtoResult6.getName());
    assertEquals("start_point", getResult4.getName());
    assertEquals("timestamp", toProtoResult5.getName());
    assertEquals("timestamp", getResult3.getJsonName());
    assertEquals("timestamp", getResult3.getName());
    assertEquals("type", toProtoResult4.getName());
    assertEquals("type", getResult.getJsonName());
    assertEquals("type", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(enumType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options4.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options4.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, enumType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult4.getNumber());
    assertEquals(1, toProtoResult2.getDependencyCount());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, getResult6.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(132, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult5.getNumber());
    assertEquals(2, options4.getSerializedSize());
    assertEquals(2, toProtoResult2.getMessageTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult4.getIndex());
    assertEquals(2, getResult3.getNumber());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(2, messageTypeList.size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
    assertEquals(3, toProtoResult.getReservedRangeCount());
    assertEquals(3, getResult2.getIndex());
    List<DescriptorProtos.DescriptorProto.ReservedRange> reservedRangeList = toProtoResult.getReservedRangeList();
    assertEquals(3, reservedRangeList.size());
    assertEquals(3, toProtoResult.getAllFields().size());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult6.getNumber());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult7.getNumber());
    assertEquals(5, getResult2.getNumber());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(552, toProtoResult2.getSerializedSize());
    assertEquals(63, options.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult5.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_ENUM, toProtoResult4.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options4.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options4.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options4.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult4.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult5.getSyntax());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult4.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult4.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options4.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options4.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options4.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options4.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options4.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options4.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options4.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options4.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options4.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options4.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options4.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options4.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options4.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(options4.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(toProtoResult2.hasPackage());
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
    assertFalse(options.getJavaMultipleFiles());
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
    assertFalse(options.hasJavaMultipleFiles());
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
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(enumType.isClosed());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult2.isOptional());
    assertFalse(getResult.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult7.hasOptions());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult4.hasTypeName());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(options4.getPacked());
    assertTrue(options4.hasPacked());
    assertTrue(options3.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(getResult2.isPackable());
    assertTrue(getResult2.isPacked());
    assertTrue(getResult2.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = syntaxBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Integer> sampleOffsetsList = actualParseFromResult.getSampleOffsetsList();
    assertTrue(sampleOffsetsList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, options4.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getMessageTypes());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult5.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
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
    assertEquals(allFields2, defaultInstanceForType.getAllFields());
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(ConfigProtos.ProtoConfig.DATA_SERVER_IP_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.MEASUREMENT_PERIOD_FACTOR_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.MEMORY_RESET_REQUEST_FIELD_NUMBER, toProtoResult4.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.PLMN_SELECTION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('M', iteratorResult4.next().byteValue());
    assertEquals('P', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('o', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(reservedRangeList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(uninterpretedOptionList, getResult2.getDefaultValue());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType6.getOptions());
    assertSame(options5, descriptorForType5.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getPublicDependencyList());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getWeakDependencyList());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(ByteString)} with
   * {@code ByteString}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseFrom(ByteString)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(ByteString) with 'ByteString'")
  void testProtoChannelParseFromWithByteString() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    MeasurementsProtos.ProtoChannel actualParseFromResult = MeasurementsProtos.ProtoChannel.parseFrom(data);

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(3);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", toProtoResult2.getPackage());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    assertEquals("", getResult5.getEditionName());
    assertEquals("", file.getPackage());
    assertEquals("", getResult5.getPackage());
    assertEquals(".MeasurementType", toProtoResult4.getTypeName());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertEquals("MeasurementType", enumType.getFullName());
    assertEquals("MeasurementType", enumType.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MeasurementsProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MeasurementsProtos", options.getJavaOuterClassname());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ProtoChannel", nameBytes.toStringUtf8());
    assertEquals("ProtoChannel", toProtoResult.getName());
    assertEquals("ProtoChannel", descriptorForType.getFullName());
    assertEquals("ProtoChannel", descriptorForType.getName());
    assertEquals("ProtoChannel.sample_offsets", getResult2.getFullName());
    assertEquals("ProtoChannel.start_point", getResult4.getFullName());
    assertEquals("ProtoChannel.timestamp", getResult3.getFullName());
    assertEquals("ProtoChannel.type", getResult.getFullName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(2, messageTypes.size());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertEquals("ProtoMeasurements", getResult6.getFullName());
    assertEquals("ProtoMeasurements", getResult6.getName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getFullName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("efento/proto_measurement_types.proto", dependencyList.get(0));
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("efento/proto_measurements.proto", nameBytes2.toStringUtf8());
    assertEquals("efento/proto_measurements.proto", toProtoResult2.getName());
    assertEquals("efento/proto_measurements.proto", file.getFullName());
    assertEquals("efento/proto_measurements.proto", file.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.transport.coap", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.transport.coap", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("sampleOffsets", getResult2.getJsonName());
    assertEquals("sample_offsets", toProtoResult7.getName());
    assertEquals("sample_offsets", getResult2.getName());
    assertEquals("startPoint", getResult4.getJsonName());
    assertEquals("start_point", toProtoResult6.getName());
    assertEquals("start_point", getResult4.getName());
    assertEquals("timestamp", toProtoResult5.getName());
    assertEquals("timestamp", getResult3.getJsonName());
    assertEquals("timestamp", getResult3.getName());
    assertEquals("type", toProtoResult4.getName());
    assertEquals("type", getResult.getJsonName());
    assertEquals("type", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(enumType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options4.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options4.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, enumType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult4.getNumber());
    assertEquals(1, toProtoResult2.getDependencyCount());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, getResult6.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(132, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult5.getNumber());
    assertEquals(2, options4.getSerializedSize());
    assertEquals(2, toProtoResult2.getMessageTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult4.getIndex());
    assertEquals(2, getResult3.getNumber());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(2, messageTypeList.size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
    assertEquals(3, toProtoResult.getReservedRangeCount());
    assertEquals(3, getResult2.getIndex());
    List<DescriptorProtos.DescriptorProto.ReservedRange> reservedRangeList = toProtoResult.getReservedRangeList();
    assertEquals(3, reservedRangeList.size());
    assertEquals(3, toProtoResult.getAllFields().size());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult6.getNumber());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult7.getNumber());
    assertEquals(5, getResult2.getNumber());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(552, toProtoResult2.getSerializedSize());
    assertEquals(63, options.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult5.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_ENUM, toProtoResult4.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options4.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options4.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options4.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult4.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult5.getSyntax());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult4.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult4.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options4.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options4.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options4.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options4.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options4.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options4.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options4.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options4.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options4.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options4.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options4.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options4.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options4.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(options4.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(toProtoResult2.hasPackage());
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
    assertFalse(options.getJavaMultipleFiles());
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
    assertFalse(options.hasJavaMultipleFiles());
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
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(enumType.isClosed());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult2.isOptional());
    assertFalse(getResult.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(getResult2.isRequired());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult7.hasOptions());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult4.hasTypeName());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(options4.getPacked());
    assertTrue(options4.hasPacked());
    assertTrue(options3.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(getResult2.isPackable());
    assertTrue(getResult2.isPacked());
    assertTrue(getResult2.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = syntaxBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Integer> sampleOffsetsList = actualParseFromResult.getSampleOffsetsList();
    assertTrue(sampleOffsetsList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, options4.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getMessageTypes());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult5.getServices());
    assertEquals(allFields2, defaultInstanceForType.getAllFields());
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult5.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult6.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult7.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult5.getExtendeeBytes());
    assertEquals(byteString, toProtoResult6.getExtendeeBytes());
    assertEquals(byteString, toProtoResult7.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult5.getJsonNameBytes());
    assertEquals(byteString, toProtoResult6.getJsonNameBytes());
    assertEquals(byteString, toProtoResult7.getJsonNameBytes());
    assertEquals(byteString, toProtoResult5.getTypeNameBytes());
    assertEquals(byteString, toProtoResult6.getTypeNameBytes());
    assertEquals(byteString, toProtoResult7.getTypeNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, toProtoResult2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(ConfigProtos.ProtoConfig.DATA_SERVER_IP_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.MEASUREMENT_PERIOD_FACTOR_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.MEMORY_RESET_REQUEST_FIELD_NUMBER, toProtoResult4.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.PLMN_SELECTION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('M', iteratorResult4.next().byteValue());
    assertEquals('P', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('o', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(reservedRangeList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(uninterpretedOptionList, getResult2.getDefaultValue());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType6.getOptions());
    assertSame(options5, descriptorForType5.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getPublicDependencyList());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getWeakDependencyList());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
  }

  /**
   * Test ProtoChannel
   * {@link ProtoChannel#parseFrom(ByteString, ExtensionRegistryLite)} with
   * {@code ByteString}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseFrom(ByteString, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(ByteString, ExtensionRegistryLite) with 'ByteString', 'ExtensionRegistryLite'")
  void testProtoChannelParseFromWithByteStringExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream codedInputStream = mock(CodedInputStream.class);
    when(codedInputStream.readTag()).thenReturn(0);
    doNothing().when(codedInputStream).checkLastTagWas(anyInt());
    ByteString data = mock(ByteString.class);
    when(data.newCodedInput()).thenReturn(codedInputStream);

    // Act
    MeasurementsProtos.ProtoChannel actualParseFromResult = MeasurementsProtos.ProtoChannel.parseFrom(data,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(data).newCodedInput();
    verify(codedInputStream).checkLastTagWas(eq(0));
    verify(codedInputStream).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(3);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", toProtoResult2.getPackage());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    assertEquals("", getResult5.getEditionName());
    assertEquals("", file.getPackage());
    assertEquals("", getResult5.getPackage());
    assertEquals(".MeasurementType", toProtoResult4.getTypeName());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertEquals("MeasurementType", enumType.getFullName());
    assertEquals("MeasurementType", enumType.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MeasurementsProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MeasurementsProtos", options.getJavaOuterClassname());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ProtoChannel", nameBytes.toStringUtf8());
    assertEquals("ProtoChannel", toProtoResult.getName());
    assertEquals("ProtoChannel", descriptorForType.getFullName());
    assertEquals("ProtoChannel", descriptorForType.getName());
    assertEquals("ProtoChannel.sample_offsets", getResult2.getFullName());
    assertEquals("ProtoChannel.start_point", getResult4.getFullName());
    assertEquals("ProtoChannel.timestamp", getResult3.getFullName());
    assertEquals("ProtoChannel.type", getResult.getFullName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(2, messageTypes.size());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertEquals("ProtoMeasurements", getResult6.getFullName());
    assertEquals("ProtoMeasurements", getResult6.getName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getFullName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("efento/proto_measurement_types.proto", dependencyList.get(0));
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("efento/proto_measurements.proto", nameBytes2.toStringUtf8());
    assertEquals("efento/proto_measurements.proto", toProtoResult2.getName());
    assertEquals("efento/proto_measurements.proto", file.getFullName());
    assertEquals("efento/proto_measurements.proto", file.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.transport.coap", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.transport.coap", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("sampleOffsets", getResult2.getJsonName());
    assertEquals("sample_offsets", toProtoResult7.getName());
    assertEquals("sample_offsets", getResult2.getName());
    assertEquals("startPoint", getResult4.getJsonName());
    assertEquals("start_point", toProtoResult6.getName());
    assertEquals("start_point", getResult4.getName());
    assertEquals("timestamp", toProtoResult5.getName());
    assertEquals("timestamp", getResult3.getJsonName());
    assertEquals("timestamp", getResult3.getName());
    assertEquals("type", toProtoResult4.getName());
    assertEquals("type", getResult.getJsonName());
    assertEquals("type", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(enumType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options4.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options4.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, enumType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult4.getNumber());
    assertEquals(1, toProtoResult2.getDependencyCount());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, getResult6.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(132, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult5.getNumber());
    assertEquals(2, options4.getSerializedSize());
    assertEquals(2, toProtoResult2.getMessageTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult4.getIndex());
    assertEquals(2, getResult3.getNumber());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(2, messageTypeList.size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
    assertEquals(3, toProtoResult.getReservedRangeCount());
    assertEquals(3, getResult2.getIndex());
    List<DescriptorProtos.DescriptorProto.ReservedRange> reservedRangeList = toProtoResult.getReservedRangeList();
    assertEquals(3, reservedRangeList.size());
    assertEquals(3, toProtoResult.getAllFields().size());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult6.getNumber());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult7.getNumber());
    assertEquals(5, getResult2.getNumber());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(552, toProtoResult2.getSerializedSize());
    assertEquals(63, options.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult5.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_ENUM, toProtoResult4.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options4.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options4.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options4.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult4.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult5.getSyntax());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult4.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult4.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options4.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options4.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options4.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options4.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options4.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options4.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options4.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options4.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options4.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options4.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options4.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options4.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options4.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(options4.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(toProtoResult2.hasPackage());
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
    assertFalse(options.getJavaMultipleFiles());
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
    assertFalse(options.hasJavaMultipleFiles());
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
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(enumType.isClosed());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult2.isOptional());
    assertFalse(getResult.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(getResult2.isRequired());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult7.hasOptions());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult4.hasTypeName());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(options4.getPacked());
    assertTrue(options4.hasPacked());
    assertTrue(options3.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(getResult2.isPackable());
    assertTrue(getResult2.isPacked());
    assertTrue(getResult2.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = syntaxBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Integer> sampleOffsetsList = actualParseFromResult.getSampleOffsetsList();
    assertTrue(sampleOffsetsList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, options4.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getMessageTypes());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult5.getServices());
    assertEquals(allFields2, defaultInstanceForType.getAllFields());
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    ByteString byteString = data.EMPTY;
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult5.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult6.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult7.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult5.getExtendeeBytes());
    assertEquals(byteString, toProtoResult6.getExtendeeBytes());
    assertEquals(byteString, toProtoResult7.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult5.getJsonNameBytes());
    assertEquals(byteString, toProtoResult6.getJsonNameBytes());
    assertEquals(byteString, toProtoResult7.getJsonNameBytes());
    assertEquals(byteString, toProtoResult5.getTypeNameBytes());
    assertEquals(byteString, toProtoResult6.getTypeNameBytes());
    assertEquals(byteString, toProtoResult7.getTypeNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getNameBytes());
    assertEquals(byteString, defaultInstanceForType2.getPackageBytes());
    assertEquals(byteString, toProtoResult2.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSyntaxBytes());
    assertEquals(byteString, defaultInstanceForType3.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType3.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType3.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType3.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(ConfigProtos.ProtoConfig.DATA_SERVER_IP_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.MEASUREMENT_PERIOD_FACTOR_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.MEMORY_RESET_REQUEST_FIELD_NUMBER, toProtoResult4.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.PLMN_SELECTION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('M', iteratorResult4.next().byteValue());
    assertEquals('P', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('o', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(reservedRangeList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(uninterpretedOptionList, getResult2.getDefaultValue());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType6.getOptions());
    assertSame(options5, descriptorForType5.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getPublicDependencyList());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getWeakDependencyList());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(CodedInputStream)} with
   * {@code CodedInputStream}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseFrom(CodedInputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(CodedInputStream) with 'CodedInputStream'")
  void testProtoChannelParseFromWithCodedInputStream() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    MeasurementsProtos.ProtoChannel actualParseFromResult = MeasurementsProtos.ProtoChannel.parseFrom(input);

    // Assert
    verify(input).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(3);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", toProtoResult2.getPackage());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    assertEquals("", getResult5.getEditionName());
    assertEquals("", file.getPackage());
    assertEquals("", getResult5.getPackage());
    assertEquals(".MeasurementType", toProtoResult4.getTypeName());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertEquals("MeasurementType", enumType.getFullName());
    assertEquals("MeasurementType", enumType.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MeasurementsProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MeasurementsProtos", options.getJavaOuterClassname());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ProtoChannel", nameBytes.toStringUtf8());
    assertEquals("ProtoChannel", toProtoResult.getName());
    assertEquals("ProtoChannel", descriptorForType.getFullName());
    assertEquals("ProtoChannel", descriptorForType.getName());
    assertEquals("ProtoChannel.sample_offsets", getResult2.getFullName());
    assertEquals("ProtoChannel.start_point", getResult4.getFullName());
    assertEquals("ProtoChannel.timestamp", getResult3.getFullName());
    assertEquals("ProtoChannel.type", getResult.getFullName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(2, messageTypes.size());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertEquals("ProtoMeasurements", getResult6.getFullName());
    assertEquals("ProtoMeasurements", getResult6.getName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getFullName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("efento/proto_measurement_types.proto", dependencyList.get(0));
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("efento/proto_measurements.proto", nameBytes2.toStringUtf8());
    assertEquals("efento/proto_measurements.proto", toProtoResult2.getName());
    assertEquals("efento/proto_measurements.proto", file.getFullName());
    assertEquals("efento/proto_measurements.proto", file.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.transport.coap", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.transport.coap", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("sampleOffsets", getResult2.getJsonName());
    assertEquals("sample_offsets", toProtoResult7.getName());
    assertEquals("sample_offsets", getResult2.getName());
    assertEquals("startPoint", getResult4.getJsonName());
    assertEquals("start_point", toProtoResult6.getName());
    assertEquals("start_point", getResult4.getName());
    assertEquals("timestamp", toProtoResult5.getName());
    assertEquals("timestamp", getResult3.getJsonName());
    assertEquals("timestamp", getResult3.getName());
    assertEquals("type", toProtoResult4.getName());
    assertEquals("type", getResult.getJsonName());
    assertEquals("type", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(enumType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options4.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options4.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, enumType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult4.getNumber());
    assertEquals(1, toProtoResult2.getDependencyCount());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, getResult6.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(132, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult5.getNumber());
    assertEquals(2, options4.getSerializedSize());
    assertEquals(2, toProtoResult2.getMessageTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult4.getIndex());
    assertEquals(2, getResult3.getNumber());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(2, messageTypeList.size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
    assertEquals(3, toProtoResult.getReservedRangeCount());
    assertEquals(3, getResult2.getIndex());
    List<DescriptorProtos.DescriptorProto.ReservedRange> reservedRangeList = toProtoResult.getReservedRangeList();
    assertEquals(3, reservedRangeList.size());
    assertEquals(3, toProtoResult.getAllFields().size());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult6.getNumber());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult7.getNumber());
    assertEquals(5, getResult2.getNumber());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(552, toProtoResult2.getSerializedSize());
    assertEquals(63, options.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult5.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_ENUM, toProtoResult4.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options4.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options4.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options4.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult4.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult5.getSyntax());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult4.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult4.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options4.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options4.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options4.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options4.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options4.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options4.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options4.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options4.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options4.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options4.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options4.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options4.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options4.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(options4.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(toProtoResult2.hasPackage());
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
    assertFalse(options.getJavaMultipleFiles());
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
    assertFalse(options.hasJavaMultipleFiles());
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
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(enumType.isClosed());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult2.isOptional());
    assertFalse(getResult.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult7.hasOptions());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult4.hasTypeName());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(options4.getPacked());
    assertTrue(options4.hasPacked());
    assertTrue(options3.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(getResult2.isPackable());
    assertTrue(getResult2.isPacked());
    assertTrue(getResult2.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = syntaxBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Integer> sampleOffsetsList = actualParseFromResult.getSampleOffsetsList();
    assertTrue(sampleOffsetsList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, options4.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getMessageTypes());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult5.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
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
    assertEquals(allFields2, defaultInstanceForType.getAllFields());
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(ConfigProtos.ProtoConfig.DATA_SERVER_IP_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.MEASUREMENT_PERIOD_FACTOR_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.MEMORY_RESET_REQUEST_FIELD_NUMBER, toProtoResult4.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.PLMN_SELECTION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('M', iteratorResult4.next().byteValue());
    assertEquals('P', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('o', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(reservedRangeList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(uninterpretedOptionList, getResult2.getDefaultValue());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType6.getOptions());
    assertSame(options5, descriptorForType5.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getPublicDependencyList());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getWeakDependencyList());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
  }

  /**
   * Test ProtoChannel
   * {@link ProtoChannel#parseFrom(CodedInputStream, ExtensionRegistryLite)} with
   * {@code CodedInputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseFrom(CodedInputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(CodedInputStream, ExtensionRegistryLite) with 'CodedInputStream', 'ExtensionRegistryLite'")
  void testProtoChannelParseFromWithCodedInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    CodedInputStream input = mock(CodedInputStream.class);
    when(input.readTag()).thenReturn(0);

    // Act
    MeasurementsProtos.ProtoChannel actualParseFromResult = MeasurementsProtos.ProtoChannel.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    verify(input).readTag();
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(3);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", toProtoResult2.getPackage());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    assertEquals("", getResult5.getEditionName());
    assertEquals("", file.getPackage());
    assertEquals("", getResult5.getPackage());
    assertEquals(".MeasurementType", toProtoResult4.getTypeName());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertEquals("MeasurementType", enumType.getFullName());
    assertEquals("MeasurementType", enumType.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MeasurementsProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MeasurementsProtos", options.getJavaOuterClassname());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ProtoChannel", nameBytes.toStringUtf8());
    assertEquals("ProtoChannel", toProtoResult.getName());
    assertEquals("ProtoChannel", descriptorForType.getFullName());
    assertEquals("ProtoChannel", descriptorForType.getName());
    assertEquals("ProtoChannel.sample_offsets", getResult2.getFullName());
    assertEquals("ProtoChannel.start_point", getResult4.getFullName());
    assertEquals("ProtoChannel.timestamp", getResult3.getFullName());
    assertEquals("ProtoChannel.type", getResult.getFullName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(2, messageTypes.size());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertEquals("ProtoMeasurements", getResult6.getFullName());
    assertEquals("ProtoMeasurements", getResult6.getName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getFullName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("efento/proto_measurement_types.proto", dependencyList.get(0));
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("efento/proto_measurements.proto", nameBytes2.toStringUtf8());
    assertEquals("efento/proto_measurements.proto", toProtoResult2.getName());
    assertEquals("efento/proto_measurements.proto", file.getFullName());
    assertEquals("efento/proto_measurements.proto", file.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.transport.coap", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.transport.coap", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("sampleOffsets", getResult2.getJsonName());
    assertEquals("sample_offsets", toProtoResult7.getName());
    assertEquals("sample_offsets", getResult2.getName());
    assertEquals("startPoint", getResult4.getJsonName());
    assertEquals("start_point", toProtoResult6.getName());
    assertEquals("start_point", getResult4.getName());
    assertEquals("timestamp", toProtoResult5.getName());
    assertEquals("timestamp", getResult3.getJsonName());
    assertEquals("timestamp", getResult3.getName());
    assertEquals("type", toProtoResult4.getName());
    assertEquals("type", getResult.getJsonName());
    assertEquals("type", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(enumType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options4.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options4.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, enumType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult4.getNumber());
    assertEquals(1, toProtoResult2.getDependencyCount());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, getResult6.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(132, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult5.getNumber());
    assertEquals(2, options4.getSerializedSize());
    assertEquals(2, toProtoResult2.getMessageTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult4.getIndex());
    assertEquals(2, getResult3.getNumber());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(2, messageTypeList.size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
    assertEquals(3, toProtoResult.getReservedRangeCount());
    assertEquals(3, getResult2.getIndex());
    List<DescriptorProtos.DescriptorProto.ReservedRange> reservedRangeList = toProtoResult.getReservedRangeList();
    assertEquals(3, reservedRangeList.size());
    assertEquals(3, toProtoResult.getAllFields().size());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult6.getNumber());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult7.getNumber());
    assertEquals(5, getResult2.getNumber());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(552, toProtoResult2.getSerializedSize());
    assertEquals(63, options.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult5.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_ENUM, toProtoResult4.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options4.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options4.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options4.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult4.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult5.getSyntax());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult4.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult4.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options4.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options4.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options4.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options4.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options4.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options4.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options4.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options4.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options4.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options4.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options4.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options4.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options4.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(options4.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(toProtoResult2.hasPackage());
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
    assertFalse(options.getJavaMultipleFiles());
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
    assertFalse(options.hasJavaMultipleFiles());
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
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(enumType.isClosed());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult2.isOptional());
    assertFalse(getResult.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult7.hasOptions());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult4.hasTypeName());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(options4.getPacked());
    assertTrue(options4.hasPacked());
    assertTrue(options3.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(getResult2.isPackable());
    assertTrue(getResult2.isPacked());
    assertTrue(getResult2.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = syntaxBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Integer> sampleOffsetsList = actualParseFromResult.getSampleOffsetsList();
    assertTrue(sampleOffsetsList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, options4.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getMessageTypes());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult5.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
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
    assertEquals(allFields2, defaultInstanceForType.getAllFields());
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(ConfigProtos.ProtoConfig.DATA_SERVER_IP_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.MEASUREMENT_PERIOD_FACTOR_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.MEMORY_RESET_REQUEST_FIELD_NUMBER, toProtoResult4.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.PLMN_SELECTION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('M', iteratorResult4.next().byteValue());
    assertEquals('P', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('o', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(reservedRangeList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(uninterpretedOptionList, getResult2.getDefaultValue());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType6.getOptions());
    assertSame(options5, descriptorForType5.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getPublicDependencyList());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getWeakDependencyList());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(InputStream) with 'InputStream'")
  void testProtoChannelParseFromWithInputStream() throws IOException {
    // Arrange and Act
    MeasurementsProtos.ProtoChannel actualParseFromResult = MeasurementsProtos.ProtoChannel
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(2, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(2, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult = messageTypes.get(1);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(3);
    assertSame(file, getResult5.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType2.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult2.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options5 = getResult5.getOptions();
    assertSame(options4, options5.getDefaultInstanceForType());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, getResult5.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoChannel
   * {@link ProtoChannel#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testProtoChannelParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act
    MeasurementsProtos.ProtoChannel actualParseFromResult = MeasurementsProtos.ProtoChannel.parseFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertTrue(getResult.getDefaultValue() instanceof Descriptors.EnumValueDescriptor);
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType2.getInitializationErrorString());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals("", sourceCodeInfo.getInitializationErrorString());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType3.getInitializationErrorString());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertEquals("", features.getInitializationErrorString());
    assertEquals("", options2.getInitializationErrorString());
    Descriptors.Descriptor descriptorForType2 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertEquals("", toProtoResult3.getInitializationErrorString());
    assertEquals("", toProtoResult.getInitializationErrorString());
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertEquals("", options3.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult2 = fields.get(3);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertEquals("", options4.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertEquals("", toProtoResult4.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertEquals("", toProtoResult5.getInitializationErrorString());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertEquals("", toProtoResult6.getInitializationErrorString());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult2.toProto();
    assertEquals("", toProtoResult7.getInitializationErrorString());
    assertEquals("", options.getInitializationErrorString());
    assertEquals("", toProtoResult2.getInitializationErrorString());
    assertEquals("", actualParseFromResult.getInitializationErrorString());
    ByteString csharpNamespaceBytes = options.getCsharpNamespaceBytes();
    assertEquals("", csharpNamespaceBytes.toStringUtf8());
    assertEquals("", defaultInstanceForType.getName());
    assertEquals("", toProtoResult4.getDefaultValue());
    assertEquals("", toProtoResult5.getDefaultValue());
    assertEquals("", toProtoResult6.getDefaultValue());
    assertEquals("", toProtoResult7.getDefaultValue());
    assertEquals("", toProtoResult4.getExtendee());
    assertEquals("", toProtoResult5.getExtendee());
    assertEquals("", toProtoResult6.getExtendee());
    assertEquals("", toProtoResult7.getExtendee());
    assertEquals("", toProtoResult4.getJsonName());
    assertEquals("", toProtoResult5.getJsonName());
    assertEquals("", toProtoResult6.getJsonName());
    assertEquals("", toProtoResult7.getJsonName());
    assertEquals("", toProtoResult5.getTypeName());
    assertEquals("", toProtoResult6.getTypeName());
    assertEquals("", toProtoResult7.getTypeName());
    assertEquals("", defaultInstanceForType2.getName());
    assertEquals("", defaultInstanceForType2.getPackage());
    assertEquals("", toProtoResult2.getPackage());
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
    Descriptors.FileDescriptor file2 = descriptorForType2.getFile();
    assertEquals("", file2.getEditionName());
    assertEquals("", file.getEditionName());
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    Descriptors.FileDescriptor getResult5 = dependencies.get(0);
    assertEquals("", getResult5.getEditionName());
    assertEquals("", file.getPackage());
    assertEquals("", getResult5.getPackage());
    assertEquals(".MeasurementType", toProtoResult4.getTypeName());
    Descriptors.Descriptor descriptorForType3 = toProtoResult.getDescriptorForType();
    assertEquals("DescriptorProto", descriptorForType3.getName());
    Descriptors.Descriptor descriptorForType4 = features.getDescriptorForType();
    assertEquals("FeatureSet", descriptorForType4.getName());
    Descriptors.Descriptor descriptorForType5 = toProtoResult2.getDescriptorForType();
    assertEquals("FileDescriptorProto", descriptorForType5.getName());
    Descriptors.Descriptor descriptorForType6 = options.getDescriptorForType();
    assertEquals("FileOptions", descriptorForType6.getName());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertEquals("MeasurementType", enumType.getFullName());
    assertEquals("MeasurementType", enumType.getName());
    ByteString javaOuterClassnameBytes = options.getJavaOuterClassnameBytes();
    assertEquals("MeasurementsProtos", javaOuterClassnameBytes.toStringUtf8());
    assertEquals("MeasurementsProtos", options.getJavaOuterClassname());
    assertEquals("MessageOptions", toProtoResult3.getName());
    assertEquals("MessageOptions", descriptorForType2.getName());
    ByteString nameBytes = toProtoResult.getNameBytes();
    assertEquals("ProtoChannel", nameBytes.toStringUtf8());
    assertEquals("ProtoChannel", toProtoResult.getName());
    assertEquals("ProtoChannel", descriptorForType.getFullName());
    assertEquals("ProtoChannel", descriptorForType.getName());
    assertEquals("ProtoChannel.sample_offsets", getResult2.getFullName());
    assertEquals("ProtoChannel.start_point", getResult4.getFullName());
    assertEquals("ProtoChannel.timestamp", getResult3.getFullName());
    assertEquals("ProtoChannel.type", getResult.getFullName());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(2, messageTypes.size());
    Descriptors.Descriptor getResult6 = messageTypes.get(1);
    assertEquals("ProtoMeasurements", getResult6.getFullName());
    assertEquals("ProtoMeasurements", getResult6.getName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getFullName());
    assertEquals("efento/proto_measurement_types.proto", getResult5.getName());
    ProtocolStringList dependencyList = toProtoResult2.getDependencyList();
    assertEquals(1, dependencyList.size());
    assertEquals("efento/proto_measurement_types.proto", dependencyList.get(0));
    ByteString nameBytes2 = toProtoResult2.getNameBytes();
    assertEquals("efento/proto_measurements.proto", nameBytes2.toStringUtf8());
    assertEquals("efento/proto_measurements.proto", toProtoResult2.getName());
    assertEquals("efento/proto_measurements.proto", file.getFullName());
    assertEquals("efento/proto_measurements.proto", file.getName());
    assertEquals("google.protobuf", file2.getPackage());
    assertEquals("google.protobuf.DescriptorProto", descriptorForType3.getFullName());
    assertEquals("google.protobuf.FeatureSet", descriptorForType4.getFullName());
    assertEquals("google.protobuf.FileDescriptorProto", descriptorForType5.getFullName());
    assertEquals("google.protobuf.FileOptions", descriptorForType6.getFullName());
    assertEquals("google.protobuf.MessageOptions", descriptorForType2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getFullName());
    assertEquals("google/protobuf/descriptor.proto", file2.getName());
    ByteString javaPackageBytes = options.getJavaPackageBytes();
    assertEquals("org.thingsboard.server.gen.transport.coap", javaPackageBytes.toStringUtf8());
    assertEquals("org.thingsboard.server.gen.transport.coap", options.getJavaPackage());
    ByteString syntaxBytes = toProtoResult2.getSyntaxBytes();
    assertEquals("proto3", syntaxBytes.toStringUtf8());
    assertEquals("proto3", toProtoResult2.getSyntax());
    assertEquals("sampleOffsets", getResult2.getJsonName());
    assertEquals("sample_offsets", toProtoResult7.getName());
    assertEquals("sample_offsets", getResult2.getName());
    assertEquals("startPoint", getResult4.getJsonName());
    assertEquals("start_point", toProtoResult6.getName());
    assertEquals("start_point", getResult4.getName());
    assertEquals("timestamp", toProtoResult5.getName());
    assertEquals("timestamp", getResult3.getJsonName());
    assertEquals("timestamp", getResult3.getName());
    assertEquals("type", toProtoResult4.getName());
    assertEquals("type", getResult.getJsonName());
    assertEquals("type", getResult.getName());
    assertNull(descriptorForType4.getContainingType());
    assertNull(descriptorForType2.getContainingType());
    assertNull(descriptorForType3.getContainingType());
    assertNull(descriptorForType6.getContainingType());
    assertNull(descriptorForType5.getContainingType());
    assertNull(descriptorForType.getContainingType());
    assertNull(getResult6.getContainingType());
    assertNull(enumType.getContainingType());
    assertNull(getResult.getContainingOneof());
    assertNull(getResult3.getContainingOneof());
    assertNull(getResult4.getContainingOneof());
    assertNull(getResult2.getContainingOneof());
    assertNull(getResult.getRealContainingOneof());
    assertNull(getResult3.getRealContainingOneof());
    assertNull(getResult4.getRealContainingOneof());
    assertNull(getResult2.getRealContainingOneof());
    assertEquals(0, defaultInstanceForType.getEnumTypeCount());
    assertEquals(0, toProtoResult3.getEnumTypeCount());
    assertEquals(0, toProtoResult.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType.getExtensionCount());
    assertEquals(0, toProtoResult3.getExtensionCount());
    assertEquals(0, toProtoResult.getExtensionCount());
    assertEquals(0, defaultInstanceForType.getExtensionRangeCount());
    assertEquals(0, toProtoResult.getExtensionRangeCount());
    assertEquals(0, defaultInstanceForType.getFieldCount());
    assertEquals(0, defaultInstanceForType.getNestedTypeCount());
    assertEquals(0, toProtoResult3.getNestedTypeCount());
    assertEquals(0, toProtoResult.getNestedTypeCount());
    assertEquals(0, defaultInstanceForType.getOneofDeclCount());
    assertEquals(0, toProtoResult3.getOneofDeclCount());
    assertEquals(0, toProtoResult.getOneofDeclCount());
    assertEquals(0, defaultInstanceForType.getReservedNameCount());
    assertEquals(0, toProtoResult3.getReservedNameCount());
    assertEquals(0, toProtoResult.getReservedNameCount());
    assertEquals(0, defaultInstanceForType.getReservedRangeCount());
    assertEquals(0, defaultInstanceForType.getSerializedSize());
    assertEquals(0, features.getSerializedSize());
    assertEquals(0, toProtoResult4.getOneofIndex());
    assertEquals(0, toProtoResult5.getOneofIndex());
    assertEquals(0, toProtoResult6.getOneofIndex());
    assertEquals(0, toProtoResult7.getOneofIndex());
    assertEquals(0, options3.getEditionDefaultsCount());
    assertEquals(0, options4.getEditionDefaultsCount());
    assertEquals(0, options3.getSerializedSize());
    assertEquals(0, options3.getTargetsCount());
    assertEquals(0, options4.getTargetsCount());
    assertEquals(0, options3.getUninterpretedOptionCount());
    assertEquals(0, options4.getUninterpretedOptionCount());
    assertEquals(0, defaultInstanceForType2.getDependencyCount());
    assertEquals(0, defaultInstanceForType2.getEnumTypeCount());
    assertEquals(0, toProtoResult2.getEnumTypeCount());
    assertEquals(0, defaultInstanceForType2.getExtensionCount());
    assertEquals(0, toProtoResult2.getExtensionCount());
    assertEquals(0, defaultInstanceForType2.getMessageTypeCount());
    assertEquals(0, defaultInstanceForType2.getPublicDependencyCount());
    assertEquals(0, toProtoResult2.getPublicDependencyCount());
    assertEquals(0, defaultInstanceForType2.getSerializedSize());
    assertEquals(0, defaultInstanceForType2.getServiceCount());
    assertEquals(0, toProtoResult2.getServiceCount());
    assertEquals(0, defaultInstanceForType2.getWeakDependencyCount());
    assertEquals(0, toProtoResult2.getWeakDependencyCount());
    assertEquals(0, defaultInstanceForType3.getSerializedSize());
    assertEquals(0, defaultInstanceForType3.getUninterpretedOptionCount());
    assertEquals(0, options.getUninterpretedOptionCount());
    assertEquals(0, options2.getSerializedSize());
    assertEquals(0, options2.getUninterpretedOptionCount());
    assertEquals(0, sourceCodeInfo.getLocationCount());
    assertEquals(0, sourceCodeInfo.getSerializedSize());
    assertEquals(0, descriptorForType.getIndex());
    assertEquals(0, enumType.getIndex());
    assertEquals(0, getResult.getIndex());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    assertEquals(0, actualParseFromResult.getSampleOffsetsCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    assertEquals(0, actualParseFromResult.getStartPoint());
    assertEquals(0, actualParseFromResult.getTimestamp());
    assertEquals(0, actualParseFromResult.getTypeValue());
    assertEquals(1, toProtoResult3.getExtensionRangeCount());
    assertEquals(1, toProtoResult4.getNumber());
    assertEquals(1, toProtoResult2.getDependencyCount());
    assertEquals(1, descriptorForType5.getIndex());
    assertEquals(1, getResult6.getIndex());
    assertEquals(1, getResult3.getIndex());
    assertEquals(1, getResult.getNumber());
    assertEquals(132, toProtoResult.getSerializedSize());
    assertEquals(2, toProtoResult5.getNumber());
    assertEquals(2, options4.getSerializedSize());
    assertEquals(2, toProtoResult2.getMessageTypeCount());
    assertEquals(2, descriptorForType3.getIndex());
    assertEquals(2, getResult4.getIndex());
    assertEquals(2, getResult3.getNumber());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(2, messageTypeList.size());
    Map<Descriptors.FieldDescriptor, Object> allFields = options.getAllFields();
    assertEquals(2, allFields.size());
    assertEquals(3, toProtoResult.getReservedRangeCount());
    assertEquals(3, getResult2.getIndex());
    List<DescriptorProtos.DescriptorProto.ReservedRange> reservedRangeList = toProtoResult.getReservedRangeList();
    assertEquals(3, reservedRangeList.size());
    assertEquals(3, toProtoResult.getAllFields().size());
    assertEquals(4, toProtoResult.getFieldCount());
    assertEquals(4, toProtoResult6.getNumber());
    assertEquals(4, getResult4.getNumber());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    assertEquals(5, toProtoResult3.getReservedRangeCount());
    assertEquals(5, toProtoResult7.getNumber());
    assertEquals(5, getResult2.getNumber());
    assertEquals(5, toProtoResult2.getAllFields().size());
    assertEquals(500, toProtoResult3.getSerializedSize());
    assertEquals(552, toProtoResult2.getSerializedSize());
    assertEquals(63, options.getSerializedSize());
    assertEquals(7, toProtoResult3.getFieldCount());
    assertEquals(7, descriptorForType2.getFields().size());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, defaultInstanceForType2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, toProtoResult2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file2.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, file.getEdition());
    assertEquals(DescriptorProtos.Edition.EDITION_UNKNOWN, getResult5.getEdition());
    assertEquals(DescriptorProtos.FeatureSet.EnumType.ENUM_TYPE_UNKNOWN, features.getEnumType());
    assertEquals(DescriptorProtos.FeatureSet.FieldPresence.FIELD_PRESENCE_UNKNOWN, features.getFieldPresence());
    assertEquals(DescriptorProtos.FeatureSet.JsonFormat.JSON_FORMAT_UNKNOWN, features.getJsonFormat());
    assertEquals(DescriptorProtos.FeatureSet.MessageEncoding.MESSAGE_ENCODING_UNKNOWN, features.getMessageEncoding());
    assertEquals(DescriptorProtos.FeatureSet.RepeatedFieldEncoding.REPEATED_FIELD_ENCODING_UNKNOWN,
        features.getRepeatedFieldEncoding());
    assertEquals(DescriptorProtos.FeatureSet.Utf8Validation.UTF8_VALIDATION_UNKNOWN, features.getUtf8Validation());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult4.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult5.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL, toProtoResult6.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED, toProtoResult7.getLabel());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_ENUM, toProtoResult4.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_INT32, toProtoResult5.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult6.getType());
    assertEquals(DescriptorProtos.FieldDescriptorProto.Type.TYPE_SINT32, toProtoResult7.getType());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options3.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.CType.STRING, options4.getCtype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options3.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options4.getJstype());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options3.getRetention());
    assertEquals(DescriptorProtos.FieldOptions.OptionRetention.RETENTION_UNKNOWN, options4.getRetention());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, defaultInstanceForType3.getOptimizeFor());
    assertEquals(DescriptorProtos.FileOptions.OptimizeMode.SPEED, options.getOptimizeFor());
    assertEquals(Descriptors.FieldDescriptor.JavaType.ENUM, getResult.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult3.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult4.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.JavaType.INT, getResult2.getJavaType());
    assertEquals(Descriptors.FieldDescriptor.Type.ENUM, getResult.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.INT32, getResult3.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult4.getType());
    assertEquals(Descriptors.FieldDescriptor.Type.SINT32, getResult2.getType());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO2, file2.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, file.getSyntax());
    assertEquals(Descriptors.FileDescriptor.Syntax.PROTO3, getResult5.getSyntax());
    assertEquals(WireFormat.FieldType.ENUM, getResult.getLiteType());
    assertEquals(WireFormat.FieldType.INT32, getResult3.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult4.getLiteType());
    assertEquals(WireFormat.FieldType.SINT32, getResult2.getLiteType());
    assertEquals(WireFormat.JavaType.ENUM, getResult.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult3.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult4.getLiteJavaType());
    assertEquals(WireFormat.JavaType.INT, getResult2.getLiteJavaType());
    assertEquals(MeasurementTypeProtos.MeasurementType.MEASUREMENT_TYPE_NO_SENSOR, actualParseFromResult.getType());
    assertFalse(nameBytes.isEmpty());
    assertFalse(nameBytes2.isEmpty());
    assertFalse(syntaxBytes.isEmpty());
    assertFalse(javaOuterClassnameBytes.isEmpty());
    assertFalse(javaPackageBytes.isEmpty());
    assertFalse(defaultInstanceForType.hasName());
    assertFalse(defaultInstanceForType.hasOptions());
    assertFalse(toProtoResult3.hasOptions());
    assertFalse(toProtoResult.hasOptions());
    assertFalse(features.hasEnumType());
    assertFalse(features.hasFieldPresence());
    assertFalse(features.hasJsonFormat());
    assertFalse(features.hasMessageEncoding());
    assertFalse(features.hasRepeatedFieldEncoding());
    assertFalse(features.hasUtf8Validation());
    assertFalse(toProtoResult4.getProto3Optional());
    assertFalse(toProtoResult5.getProto3Optional());
    assertFalse(toProtoResult6.getProto3Optional());
    assertFalse(toProtoResult7.getProto3Optional());
    assertFalse(toProtoResult4.hasDefaultValue());
    assertFalse(toProtoResult5.hasDefaultValue());
    assertFalse(toProtoResult6.hasDefaultValue());
    assertFalse(toProtoResult7.hasDefaultValue());
    assertFalse(toProtoResult4.hasExtendee());
    assertFalse(toProtoResult5.hasExtendee());
    assertFalse(toProtoResult6.hasExtendee());
    assertFalse(toProtoResult7.hasExtendee());
    assertFalse(toProtoResult4.hasJsonName());
    assertFalse(toProtoResult5.hasJsonName());
    assertFalse(toProtoResult6.hasJsonName());
    assertFalse(toProtoResult7.hasJsonName());
    assertFalse(toProtoResult4.hasOneofIndex());
    assertFalse(toProtoResult5.hasOneofIndex());
    assertFalse(toProtoResult6.hasOneofIndex());
    assertFalse(toProtoResult7.hasOneofIndex());
    assertFalse(toProtoResult4.hasOptions());
    assertFalse(toProtoResult5.hasOptions());
    assertFalse(toProtoResult6.hasOptions());
    assertFalse(toProtoResult4.hasProto3Optional());
    assertFalse(toProtoResult5.hasProto3Optional());
    assertFalse(toProtoResult6.hasProto3Optional());
    assertFalse(toProtoResult7.hasProto3Optional());
    assertFalse(toProtoResult5.hasTypeName());
    assertFalse(toProtoResult6.hasTypeName());
    assertFalse(toProtoResult7.hasTypeName());
    assertFalse(options3.getDebugRedact());
    assertFalse(options4.getDebugRedact());
    assertFalse(options3.getDeprecated());
    assertFalse(options4.getDeprecated());
    assertFalse(options3.getLazy());
    assertFalse(options4.getLazy());
    assertFalse(options3.getPacked());
    assertFalse(options3.getUnverifiedLazy());
    assertFalse(options4.getUnverifiedLazy());
    assertFalse(options3.getWeak());
    assertFalse(options4.getWeak());
    assertFalse(options3.hasCtype());
    assertFalse(options4.hasCtype());
    assertFalse(options3.hasDebugRedact());
    assertFalse(options4.hasDebugRedact());
    assertFalse(options3.hasDeprecated());
    assertFalse(options4.hasDeprecated());
    assertFalse(options3.hasFeatures());
    assertFalse(options4.hasFeatures());
    assertFalse(options3.hasJstype());
    assertFalse(options4.hasJstype());
    assertFalse(options3.hasLazy());
    assertFalse(options4.hasLazy());
    assertFalse(options3.hasPacked());
    assertFalse(options3.hasRetention());
    assertFalse(options4.hasRetention());
    assertFalse(options3.hasUnverifiedLazy());
    assertFalse(options4.hasUnverifiedLazy());
    assertFalse(options3.hasWeak());
    assertFalse(options4.hasWeak());
    assertFalse(defaultInstanceForType2.hasEdition());
    assertFalse(toProtoResult2.hasEdition());
    assertFalse(defaultInstanceForType2.hasName());
    assertFalse(defaultInstanceForType2.hasOptions());
    assertFalse(defaultInstanceForType2.hasPackage());
    assertFalse(toProtoResult2.hasPackage());
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
    assertFalse(options.getJavaMultipleFiles());
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
    assertFalse(options.hasJavaMultipleFiles());
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
    assertFalse(options2.getDeprecated());
    assertFalse(options2.getDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.getMapEntry());
    assertFalse(options2.getMessageSetWireFormat());
    assertFalse(options2.getNoStandardDescriptorAccessor());
    assertFalse(options2.hasDeprecated());
    assertFalse(options2.hasDeprecatedLegacyJsonFieldConflicts());
    assertFalse(options2.hasFeatures());
    assertFalse(options2.hasMapEntry());
    assertFalse(options2.hasMessageSetWireFormat());
    assertFalse(options2.hasNoStandardDescriptorAccessor());
    assertFalse(descriptorForType3.isExtendable());
    assertFalse(descriptorForType5.isExtendable());
    assertFalse(descriptorForType.isExtendable());
    assertFalse(getResult6.isExtendable());
    assertFalse(enumType.isClosed());
    assertFalse(getResult.hasDefaultValue());
    assertFalse(getResult3.hasDefaultValue());
    assertFalse(getResult4.hasDefaultValue());
    assertFalse(getResult2.hasDefaultValue());
    assertFalse(getResult.hasOptionalKeyword());
    assertFalse(getResult3.hasOptionalKeyword());
    assertFalse(getResult4.hasOptionalKeyword());
    assertFalse(getResult2.hasOptionalKeyword());
    assertFalse(getResult.hasPresence());
    assertFalse(getResult3.hasPresence());
    assertFalse(getResult4.hasPresence());
    assertFalse(getResult2.hasPresence());
    assertFalse(getResult.isExtension());
    assertFalse(getResult3.isExtension());
    assertFalse(getResult4.isExtension());
    assertFalse(getResult2.isExtension());
    assertFalse(getResult.isMapField());
    assertFalse(getResult3.isMapField());
    assertFalse(getResult4.isMapField());
    assertFalse(getResult2.isMapField());
    assertFalse(getResult2.isOptional());
    assertFalse(getResult.isPackable());
    assertFalse(getResult3.isPackable());
    assertFalse(getResult4.isPackable());
    assertFalse(getResult.isPacked());
    assertFalse(getResult3.isPacked());
    assertFalse(getResult4.isPacked());
    assertFalse(getResult.isRepeated());
    assertFalse(getResult3.isRepeated());
    assertFalse(getResult4.isRepeated());
    assertFalse(getResult.isRequired());
    assertFalse(getResult3.isRequired());
    assertFalse(getResult4.isRequired());
    assertFalse(getResult2.isRequired());
    assertFalse(csharpNamespaceBytes.iterator().hasNext());
    assertTrue(csharpNamespaceBytes.isEmpty());
    assertTrue(toProtoResult3.hasName());
    assertTrue(toProtoResult.hasName());
    assertTrue(defaultInstanceForType.isInitialized());
    assertTrue(toProtoResult3.isInitialized());
    assertTrue(toProtoResult.isInitialized());
    assertTrue(features.isInitialized());
    assertTrue(toProtoResult4.hasLabel());
    assertTrue(toProtoResult5.hasLabel());
    assertTrue(toProtoResult6.hasLabel());
    assertTrue(toProtoResult7.hasLabel());
    assertTrue(toProtoResult4.hasName());
    assertTrue(toProtoResult5.hasName());
    assertTrue(toProtoResult6.hasName());
    assertTrue(toProtoResult7.hasName());
    assertTrue(toProtoResult4.hasNumber());
    assertTrue(toProtoResult5.hasNumber());
    assertTrue(toProtoResult6.hasNumber());
    assertTrue(toProtoResult7.hasNumber());
    assertTrue(toProtoResult7.hasOptions());
    assertTrue(toProtoResult4.hasType());
    assertTrue(toProtoResult5.hasType());
    assertTrue(toProtoResult6.hasType());
    assertTrue(toProtoResult7.hasType());
    assertTrue(toProtoResult4.hasTypeName());
    assertTrue(toProtoResult4.isInitialized());
    assertTrue(toProtoResult5.isInitialized());
    assertTrue(toProtoResult6.isInitialized());
    assertTrue(toProtoResult7.isInitialized());
    assertTrue(options4.getPacked());
    assertTrue(options4.hasPacked());
    assertTrue(options3.isInitialized());
    assertTrue(options4.isInitialized());
    assertTrue(toProtoResult2.hasName());
    assertTrue(toProtoResult2.hasOptions());
    assertTrue(toProtoResult2.hasSyntax());
    assertTrue(defaultInstanceForType2.isInitialized());
    assertTrue(toProtoResult2.isInitialized());
    assertTrue(defaultInstanceForType3.getCcEnableArenas());
    assertTrue(options.getCcEnableArenas());
    assertTrue(options.hasJavaOuterClassname());
    assertTrue(options.hasJavaPackage());
    assertTrue(defaultInstanceForType3.isInitialized());
    assertTrue(options.isInitialized());
    assertTrue(options2.isInitialized());
    assertTrue(sourceCodeInfo.isInitialized());
    assertTrue(descriptorForType2.isExtendable());
    assertTrue(descriptorForType6.isExtendable());
    assertTrue(getResult.isOptional());
    assertTrue(getResult3.isOptional());
    assertTrue(getResult4.isOptional());
    assertTrue(getResult2.isPackable());
    assertTrue(getResult2.isPacked());
    assertTrue(getResult2.isRepeated());
    assertTrue(unknownFields.isInitialized());
    ByteString.ByteIterator iteratorResult = nameBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    ByteString.ByteIterator iteratorResult2 = nameBytes2.iterator();
    assertTrue(iteratorResult2.hasNext());
    ByteString.ByteIterator iteratorResult3 = syntaxBytes.iterator();
    assertTrue(iteratorResult3.hasNext());
    ByteString.ByteIterator iteratorResult4 = javaOuterClassnameBytes.iterator();
    assertTrue(iteratorResult4.hasNext());
    ByteString.ByteIterator iteratorResult5 = javaPackageBytes.iterator();
    assertTrue(iteratorResult5.hasNext());
    assertTrue(features.findInitializationErrors().isEmpty());
    assertTrue(options2.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
    assertTrue(options.findInitializationErrors().isEmpty());
    assertTrue(toProtoResult2.findInitializationErrors().isEmpty());
    List<String> findInitializationErrorsResult = actualParseFromResult.findInitializationErrors();
    assertTrue(findInitializationErrorsResult.isEmpty());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertTrue(reservedNameList.isEmpty());
    List<DescriptorProtos.UninterpretedOption> uninterpretedOptionList = options2.getUninterpretedOptionList();
    assertTrue(uninterpretedOptionList.isEmpty());
    assertTrue(descriptorForType2.getEnumTypes().isEmpty());
    assertTrue(descriptorForType.getEnumTypes().isEmpty());
    assertTrue(descriptorForType2.getExtensions().isEmpty());
    assertTrue(descriptorForType.getExtensions().isEmpty());
    assertTrue(descriptorForType2.getNestedTypes().isEmpty());
    assertTrue(descriptorForType.getNestedTypes().isEmpty());
    assertTrue(descriptorForType2.getOneofs().isEmpty());
    assertTrue(descriptorForType.getOneofs().isEmpty());
    assertTrue(descriptorForType2.getRealOneofs().isEmpty());
    assertTrue(descriptorForType.getRealOneofs().isEmpty());
    assertTrue(file.getEnumTypes().isEmpty());
    assertTrue(file.getExtensions().isEmpty());
    assertTrue(file.getPublicDependencies().isEmpty());
    assertTrue(file.getServices().isEmpty());
    List<Integer> sampleOffsetsList = actualParseFromResult.getSampleOffsetsList();
    assertTrue(sampleOffsetsList.isEmpty());
    Map<Descriptors.FieldDescriptor, Object> allFields2 = actualParseFromResult.getAllFields();
    assertTrue(allFields2.isEmpty());
    assertTrue(features.getAllFields().isEmpty());
    assertTrue(options2.getAllFields().isEmpty());
    assertTrue(features.getAllFieldsRaw().isEmpty());
    assertTrue(options2.getAllFieldsRaw().isEmpty());
    assertTrue(actualParseFromResult.isInitialized());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType2.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, sourceCodeInfo.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, defaultInstanceForType3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult4.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult5.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult6.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, toProtoResult7.findInitializationErrors());
    assertEquals(findInitializationErrorsResult, options3.getTargetsList());
    assertEquals(findInitializationErrorsResult, options4.getTargetsList());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getEnumTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getEnumTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult6.getExtensions());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getNestedTypes());
    assertEquals(findInitializationErrorsResult, getResult6.getNestedTypes());
    assertEquals(findInitializationErrorsResult, descriptorForType4.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType3.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, descriptorForType5.getRealOneofs());
    assertEquals(findInitializationErrorsResult, getResult6.getRealOneofs());
    assertEquals(findInitializationErrorsResult, file2.getDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getDependencies());
    assertEquals(findInitializationErrorsResult, file2.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getExtensions());
    assertEquals(findInitializationErrorsResult, getResult5.getMessageTypes());
    assertEquals(findInitializationErrorsResult, file2.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, getResult5.getPublicDependencies());
    assertEquals(findInitializationErrorsResult, file2.getServices());
    assertEquals(findInitializationErrorsResult, getResult5.getServices());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType.getNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getDefaultValueBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getExtendeeBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult4.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getJsonNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult5.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult6.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult7.getTypeNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getNameBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, toProtoResult2.getPackageBytes());
    assertEquals(csharpNamespaceBytes, defaultInstanceForType2.getSyntaxBytes());
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
    assertEquals(allFields2, defaultInstanceForType.getAllFields());
    assertEquals(allFields2, defaultInstanceForType2.getAllFields());
    assertEquals(allFields2, sourceCodeInfo.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFields());
    assertEquals(allFields2, options3.getAllFields());
    assertEquals(allFields2, defaultInstanceForType3.getAllFieldsRaw());
    assertEquals(allFields2, options3.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    assertEquals(ConfigProtos.ProtoConfig.DATA_SERVER_IP_FIELD_NUMBER, descriptorForType2.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.MEASUREMENT_PERIOD_FACTOR_FIELD_NUMBER, toProtoResult7.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.MEMORY_RESET_REQUEST_FIELD_NUMBER, toProtoResult4.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.PLMN_SELECTION_FIELD_NUMBER, toProtoResult5.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, toProtoResult6.getSerializedSize());
    assertEquals(ConfigProtos.ProtoConfig.REQUEST_CONFIGURATION_FIELD_NUMBER, descriptorForType4.getIndex());
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, descriptorForType6.getIndex());
    assertEquals('M', iteratorResult4.next().byteValue());
    assertEquals('P', iteratorResult.next().byteValue());
    assertEquals('e', iteratorResult2.next().byteValue());
    assertEquals('o', iteratorResult5.next().byteValue());
    assertEquals('p', iteratorResult3.next().byteValue());
    assertEquals('r', iteratorResult.next().byteValue());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(reservedRangeList, toProtoResult.getReservedRangeOrBuilderList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getFieldOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult3.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult.getOneofDeclOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType.getReservedRangeOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsList());
    assertSame(uninterpretedOptionList, options3.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getEditionDefaultsOrBuilderList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options4.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getExtensionOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getMessageTypeOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceList());
    assertSame(uninterpretedOptionList, defaultInstanceForType2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, toProtoResult2.getServiceOrBuilderList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionList());
    assertSame(uninterpretedOptionList, defaultInstanceForType3.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, options2.getUninterpretedOptionOrBuilderList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationList());
    assertSame(uninterpretedOptionList, sourceCodeInfo.getLocationOrBuilderList());
    assertSame(uninterpretedOptionList, getResult2.getDefaultValue());
    assertSame(file, getResult6.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType6.getOptions());
    assertSame(options5, descriptorForType5.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult3.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getPublicDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getPublicDependencyList());
    assertSame(sampleOffsetsList, defaultInstanceForType2.getWeakDependencyList());
    assertSame(sampleOffsetsList, toProtoResult2.getWeakDependencyList());
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
  }

  /**
   * Test ProtoChannel
   * {@link ProtoChannel#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testProtoChannelParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MeasurementsProtos.ProtoChannel.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoChannel
   * {@link ProtoChannel#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testProtoChannelParseFromWithInputStreamExtensionRegistryLite3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MeasurementsProtos.ProtoChannel.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testProtoChannelParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MeasurementsProtos.ProtoChannel.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testProtoChannelParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MeasurementsProtos.ProtoChannel.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoChannel {@link ProtoChannel#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoChannel#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoChannel parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testProtoChannelParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    MeasurementsProtos.ProtoChannel actualParseFromResult = MeasurementsProtos.ProtoChannel
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(2, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(2, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult = messageTypes.get(1);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(2);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(3);
    assertSame(file, getResult5.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType2.getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, options2.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, getResult.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult2.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options5 = getResult5.getOptions();
    assertSame(options4, options5.getDefaultInstanceForType());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, getResult5.toProto().getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#equals(Object)}, and
   * {@link ProtoMeasurements#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MeasurementsProtos.ProtoMeasurements#equals(Object)}
   *   <li>{@link MeasurementsProtos.ProtoMeasurements#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoMeasurements equals(Object), and hashCode(); when other is equal; then return equal")
  void testProtoMeasurementsEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MeasurementsProtos.ProtoMeasurements defaultInstance = MeasurementsProtos.ProtoMeasurements.getDefaultInstance();
    MeasurementsProtos.ProtoMeasurements defaultInstance2 = MeasurementsProtos.ProtoMeasurements.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#equals(Object)}, and
   * {@link ProtoMeasurements#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MeasurementsProtos.ProtoMeasurements#equals(Object)}
   *   <li>{@link MeasurementsProtos.ProtoMeasurements#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProtoMeasurements equals(Object), and hashCode(); when other is same; then return equal")
  void testProtoMeasurementsEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MeasurementsProtos.ProtoMeasurements defaultInstance = MeasurementsProtos.ProtoMeasurements.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements equals(Object); when other is different; then return not equal")
  void testProtoMeasurementsEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MeasurementsProtos.ProtoMeasurements.getDefaultInstance(), 1);
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements equals(Object); when other is 'null'; then return not equal")
  void testProtoMeasurementsEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MeasurementsProtos.ProtoMeasurements.getDefaultInstance(), null);
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#equals(Object)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements equals(Object); when other is wrong type; then return not equal")
  void testProtoMeasurementsEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MeasurementsProtos.ProtoMeasurements.getDefaultInstance(), "Different type to ProtoMeasurements");
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#getChannelsCount()}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#getChannelsCount()}
   */
  @Test
  @DisplayName("Test ProtoMeasurements getChannelsCount()")
  void testProtoMeasurementsGetChannelsCount() {
    // Arrange, Act and Assert
    assertEquals(0, MeasurementsProtos.ProtoMeasurements.getDefaultInstance().getChannelsCount());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#getCloudToken()}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#getCloudToken()}
   */
  @Test
  @DisplayName("Test ProtoMeasurements getCloudToken()")
  void testProtoMeasurementsGetCloudToken() {
    // Arrange, Act and Assert
    assertEquals("", MeasurementsProtos.ProtoMeasurements.getDefaultInstance().getCloudToken());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#getCloudTokenBytes()}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#getCloudTokenBytes()}
   */
  @Test
  @DisplayName("Test ProtoMeasurements getCloudTokenBytes()")
  void testProtoMeasurementsGetCloudTokenBytes() {
    // Arrange
    MeasurementsProtos.ProtoMeasurements defaultInstance = MeasurementsProtos.ProtoMeasurements.getDefaultInstance();

    // Act
    ByteString actualCloudTokenBytes = defaultInstance.getCloudTokenBytes();

    // Assert
    ByteString byteString = actualCloudTokenBytes.EMPTY;
    assertEquals(byteString, actualCloudTokenBytes);
    List<Descriptors.FieldDescriptor> fields = defaultInstance.getDescriptorForType().getFields();
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, fields.size());
    assertSame(byteString, fields.get(0).getDefaultValue());
    assertSame(byteString, defaultInstance.getSerialNum());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#getDefaultInstanceForType()}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test ProtoMeasurements getDefaultInstanceForType()")
  void testProtoMeasurementsGetDefaultInstanceForType() {
    // Arrange
    MeasurementsProtos.ProtoMeasurements defaultInstance = MeasurementsProtos.ProtoMeasurements.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#getSerializedSize()}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#getSerializedSize()}
   */
  @Test
  @DisplayName("Test ProtoMeasurements getSerializedSize()")
  void testProtoMeasurementsGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, MeasurementsProtos.ProtoMeasurements.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#isInitialized()}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#isInitialized()}
   */
  @Test
  @DisplayName("Test ProtoMeasurements isInitialized()")
  void testProtoMeasurementsIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(MeasurementsProtos.ProtoMeasurements.getDefaultInstance().isInitialized());
  }

  /**
   * Test ProtoMeasurements
   * {@link ProtoMeasurements#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements newInstance(UnusedPrivateParameter)")
  void testProtoMeasurementsNewInstance() {
    // Arrange
    MeasurementsProtos.ProtoMeasurements defaultInstance = MeasurementsProtos.ProtoMeasurements.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof MeasurementsProtos.ProtoMeasurements);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test ProtoMeasurements
   * {@link ProtoMeasurements#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream) with 'input'")
  void testProtoMeasurementsParseDelimitedFromWithInput() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MeasurementsProtos.ProtoMeasurements.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoMeasurements
   * {@link ProtoMeasurements#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream) with 'input'")
  void testProtoMeasurementsParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MeasurementsProtos.ProtoMeasurements.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoMeasurements
   * {@link ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testProtoMeasurementsParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> MeasurementsProtos.ProtoMeasurements.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoMeasurements
   * {@link ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testProtoMeasurementsParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MeasurementsProtos.ProtoMeasurements.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoMeasurements
   * {@link ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testProtoMeasurementsParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> MeasurementsProtos.ProtoMeasurements.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoMeasurements
   * {@link ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testProtoMeasurementsParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(
        MeasurementsProtos.ProtoMeasurements.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoMeasurements
   * {@link ProtoMeasurements#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testProtoMeasurementsParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(MeasurementsProtos.ProtoMeasurements.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test ProtoMeasurements
   * {@link ProtoMeasurements#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseDelimitedFrom(InputStream) with 'input'; then throw IOException")
  void testProtoMeasurementsParseDelimitedFromWithInput_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> MeasurementsProtos.ProtoMeasurements.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(byte[])} with
   * {@code byte[]}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseFrom(byte[])}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(byte[]) with 'byte[]'")
  void testProtoMeasurementsParseFromWithByte() throws InvalidProtocolBufferException {
    // Arrange and Act
    MeasurementsProtos.ProtoMeasurements actualParseFromResult = MeasurementsProtos.ProtoMeasurements
        .parseFrom(new byte[]{});

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    assertEquals(0, descriptorForType.toProto().getDescriptorForType().toProto().getExtensionRangeCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(allFields, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(allFields, toProtoResult.getSourceCodeInfo().getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options = getResult.getOptions();
    assertEquals(allFields, options.getAllFields());
    assertEquals(allFields, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    ByteString serialNum = actualParseFromResult.getSerialNum();
    assertSame(serialNum, getResult.getDefaultValue());
    assertSame(serialNum, actualParseFromResult.getDefaultInstanceForType().getSerialNum());
  }

  /**
   * Test ProtoMeasurements
   * {@link ProtoMeasurements#parseFrom(byte[], ExtensionRegistryLite)} with
   * {@code byte[]}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseFrom(byte[], ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(byte[], ExtensionRegistryLite) with 'byte[]', 'ExtensionRegistryLite'")
  void testProtoMeasurementsParseFromWithByteExtensionRegistryLite() throws InvalidProtocolBufferException {
    // Arrange and Act
    MeasurementsProtos.ProtoMeasurements actualParseFromResult = MeasurementsProtos.ProtoMeasurements
        .parseFrom(new byte[]{}, ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    assertEquals(0, descriptorForType.toProto().getDescriptorForType().toProto().getExtensionRangeCount());
    assertEquals(0, actualParseFromResult.getSerializedSize());
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(allFields, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(allFields, toProtoResult.getSourceCodeInfo().getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options = getResult.getOptions();
    assertEquals(allFields, options.getAllFields());
    assertEquals(allFields, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(allFields, options.getAllFieldsRaw());
    ByteString serialNum = actualParseFromResult.getSerialNum();
    assertSame(serialNum, getResult.getDefaultValue());
    assertSame(serialNum, actualParseFromResult.getDefaultInstanceForType().getSerialNum());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(InputStream) with 'InputStream'")
  void testProtoMeasurementsParseFromWithInputStream() throws IOException {
    // Arrange and Act
    MeasurementsProtos.ProtoMeasurements actualParseFromResult = MeasurementsProtos.ProtoMeasurements
        .parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(2, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(2, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, fields.size());
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(8);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(MeasurementsProtos.ProtoMeasurements.HASH_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
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
    assertSame(options3, getResult.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult2.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult5.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ByteString expectedDefaultValue = actualParseFromResult.getSerialNum();
    assertSame(expectedDefaultValue, getResult2.getDefaultValue());
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(InputStream) with 'InputStream'")
  void testProtoMeasurementsParseFromWithInputStream2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> MeasurementsProtos.ProtoMeasurements.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoMeasurements
   * {@link ProtoMeasurements#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testProtoMeasurementsParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> MeasurementsProtos.ProtoMeasurements.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoMeasurements
   * {@link ProtoMeasurements#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testProtoMeasurementsParseFromWithInputStreamExtensionRegistryLite2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> MeasurementsProtos.ProtoMeasurements.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(InputStream) with 'InputStream'; then throw IOException")
  void testProtoMeasurementsParseFromWithInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> MeasurementsProtos.ProtoMeasurements.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test ProtoMeasurements {@link ProtoMeasurements#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MeasurementsProtos.ProtoMeasurements#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test ProtoMeasurements parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testProtoMeasurementsParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    MeasurementsProtos.ProtoMeasurements actualParseFromResult = MeasurementsProtos.ProtoMeasurements
        .parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(2, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(2, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(ConfigProtos.ProtoConfig.TRANSFER_LIMIT_TIMER_FIELD_NUMBER, fields.size());
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
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
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
    Descriptors.Descriptor getResult = messageTypes.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(8);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(MeasurementsProtos.ProtoMeasurements.HASH_FIELD_NUMBER);
    assertSame(file, getResult5.getFile());
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
    assertSame(options3, getResult.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult2.toProto();
    assertSame(options4, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult3.toProto();
    assertSame(options4, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult4.toProto();
    assertSame(options4, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult5.toProto();
    assertSame(options4, toProtoResult7.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(options4, toProtoResult5.getOptionsOrBuilder());
    assertSame(options4, toProtoResult6.getOptionsOrBuilder());
    assertSame(options4, toProtoResult7.getOptionsOrBuilder());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
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
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ByteString expectedDefaultValue = actualParseFromResult.getSerialNum();
    assertSame(expectedDefaultValue, getResult2.getDefaultValue());
  }
}
