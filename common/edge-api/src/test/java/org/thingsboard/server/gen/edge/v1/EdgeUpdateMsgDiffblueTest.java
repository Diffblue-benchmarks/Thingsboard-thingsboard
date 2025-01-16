package org.thingsboard.server.gen.edge.v1;

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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EdgeUpdateMsgDiffblueTest {
  /**
   * Test {@link EdgeUpdateMsg#equals(Object)}, and
   * {@link EdgeUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeUpdateMsg#equals(Object)}
   *   <li>{@link EdgeUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeUpdateMsg defaultInstance = EdgeUpdateMsg.getDefaultInstance();
    EdgeUpdateMsg defaultInstance2 = EdgeUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link EdgeUpdateMsg#equals(Object)}, and
   * {@link EdgeUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeUpdateMsg#equals(Object)}
   *   <li>{@link EdgeUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeUpdateMsg defaultInstance = EdgeUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link EdgeUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(EdgeUpdateMsg.getDefaultInstance(), 1);
  }

  /**
   * Test {@link EdgeUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(EdgeUpdateMsg.getDefaultInstance(), null);
  }

  /**
   * Test {@link EdgeUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(EdgeUpdateMsg.getDefaultInstance(), "Different type to EdgeUpdateMsg");
  }

  /**
   * Test {@link EdgeUpdateMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link EdgeUpdateMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  void testGetDefaultInstanceForType() {
    // Arrange
    EdgeUpdateMsg defaultInstance = EdgeUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link EdgeUpdateMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link EdgeUpdateMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, EdgeUpdateMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link EdgeUpdateMsg#hasConfiguration()}.
   * <p>
   * Method under test: {@link EdgeUpdateMsg#hasConfiguration()}
   */
  @Test
  @DisplayName("Test hasConfiguration()")
  void testHasConfiguration() {
    // Arrange, Act and Assert
    assertFalse(EdgeUpdateMsg.getDefaultInstance().hasConfiguration());
  }

  /**
   * Test {@link EdgeUpdateMsg#isInitialized()}.
   * <p>
   * Method under test: {@link EdgeUpdateMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(EdgeUpdateMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link EdgeUpdateMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link EdgeUpdateMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test newInstance(UnusedPrivateParameter)")
  void testNewInstance() {
    // Arrange
    EdgeUpdateMsg defaultInstance = EdgeUpdateMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof EdgeUpdateMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test: {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'")
  void testParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    EdgeUpdateMsg actualParseDelimitedFromResult = EdgeUpdateMsg.parseDelimitedFrom(input);

    // Assert
    EdgeConfiguration configuration = actualParseDelimitedFromResult.getConfiguration();
    UnknownFieldSet unknownFields = configuration.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.ServiceDescriptorProto> serviceList = toProtoResult2.getServiceList();
    assertEquals(1, serviceList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(5, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(58, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertTrue(unknownFields.isInitialized());
    Descriptors.Descriptor descriptorForType2 = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult3.getFieldList();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList2, toProtoResult3.getFieldOrBuilderList());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(serviceList, toProtoResult2.getServiceOrBuilderList());
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
    Descriptors.Descriptor getResult4 = messageTypes.get(56);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(57);
    assertSame(file, getResult5.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(AlarmUpdateMsg.ENDTS_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    Descriptors.FieldDescriptor getResult9 = fields2.get(AlarmUpdateMsg.STARTTS_FIELD_NUMBER);
    assertSame(file, getResult9.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, services.get(0).getFile());
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
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult9.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, getResult9.getContainingType());
    assertSame(descriptorForType2, getResult.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    EdgeUpdateMsg defaultInstanceForType4 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertSame(configuration, defaultInstanceForType4.getConfiguration());
    assertSame(configuration, defaultInstanceForType4.getConfigurationOrBuilder());
    assertSame(configuration, actualParseDelimitedFromResult.getConfigurationOrBuilder());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test: {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'")
  void testParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    EdgeUpdateMsg actualParseDelimitedFromResult = EdgeUpdateMsg.parseDelimitedFrom(input);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    assertEquals("", file.getEditionName());
    assertEquals("google/protobuf/descriptor.proto", file.getFullName());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file2.toProto();
    List<DescriptorProtos.ServiceDescriptorProto> serviceList = toProtoResult2.getServiceList();
    assertEquals(1, serviceList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    assertEquals(1, file2.getDependencies().size());
    List<Descriptors.ServiceDescriptor> services = file2.getServices();
    assertEquals(1, services.size());
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(5, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file2.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(58, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file2.getMessageTypes();
    assertEquals(58, messageTypes.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    EdgeConfiguration configuration = actualParseDelimitedFromResult.getConfiguration();
    Descriptors.Descriptor descriptorForType3 = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult3.getFieldList();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList2, toProtoResult3.getFieldOrBuilderList());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(serviceList, toProtoResult2.getServiceOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file2.getOptions();
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
    assertSame(file2, descriptorForType3.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file2, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(56);
    assertSame(file2, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(57);
    assertSame(file2, getResult5.getFile());
    assertSame(file2, enumTypes.get(0).getFile());
    assertSame(file2, enumTypes.get(1).getFile());
    assertSame(file2, enumTypes.get(3).getFile());
    assertSame(file2, enumTypes.get(4).getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file2, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file2, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(AlarmUpdateMsg.ENDTS_FIELD_NUMBER);
    assertSame(file2, getResult8.getFile());
    Descriptors.FieldDescriptor getResult9 = fields2.get(AlarmUpdateMsg.STARTTS_FIELD_NUMBER);
    assertSame(file2, getResult9.getFile());
    assertSame(file2, getResult.getFile());
    assertSame(file2, services.get(0).getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult9.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType3, getResult6.getContainingType());
    assertSame(descriptorForType3, getResult7.getContainingType());
    assertSame(descriptorForType3, getResult8.getContainingType());
    assertSame(descriptorForType3, getResult9.getContainingType());
    assertSame(descriptorForType3, getResult.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, configuration.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertSame(configuration, actualParseDelimitedFromResult.getConfigurationOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    EdgeUpdateMsg actualParseDelimitedFromResult = EdgeUpdateMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    EdgeConfiguration configuration = actualParseDelimitedFromResult.getConfiguration();
    UnknownFieldSet unknownFields = configuration.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.ServiceDescriptorProto> serviceList = toProtoResult2.getServiceList();
    assertEquals(1, serviceList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(5, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(58, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertTrue(unknownFields.isInitialized());
    Descriptors.Descriptor descriptorForType2 = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult3.getFieldList();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList2, toProtoResult3.getFieldOrBuilderList());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(serviceList, toProtoResult2.getServiceOrBuilderList());
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
    Descriptors.Descriptor getResult4 = messageTypes.get(56);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(57);
    assertSame(file, getResult5.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(AlarmUpdateMsg.ENDTS_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    Descriptors.FieldDescriptor getResult9 = fields2.get(AlarmUpdateMsg.STARTTS_FIELD_NUMBER);
    assertSame(file, getResult9.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, services.get(0).getFile());
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
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult9.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, getResult9.getContainingType());
    assertSame(descriptorForType2, getResult.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    EdgeUpdateMsg defaultInstanceForType4 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType4.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertSame(configuration, defaultInstanceForType4.getConfiguration());
    assertSame(configuration, defaultInstanceForType4.getConfigurationOrBuilder());
    assertSame(configuration, actualParseDelimitedFromResult.getConfigurationOrBuilder());
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    EdgeUpdateMsg actualParseDelimitedFromResult = EdgeUpdateMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType2 = options.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    assertEquals("", file.getEditionName());
    assertEquals("google/protobuf/descriptor.proto", file.getFullName());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    Descriptors.FileDescriptor file2 = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file2.toProto();
    List<DescriptorProtos.ServiceDescriptorProto> serviceList = toProtoResult2.getServiceList();
    assertEquals(1, serviceList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    assertEquals(1, file2.getDependencies().size());
    List<Descriptors.ServiceDescriptor> services = file2.getServices();
    assertEquals(1, services.size());
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(5, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file2.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(58, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file2.getMessageTypes();
    assertEquals(58, messageTypes.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    EdgeConfiguration configuration = actualParseDelimitedFromResult.getConfiguration();
    Descriptors.Descriptor descriptorForType3 = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult3.getFieldList();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList2, toProtoResult3.getFieldOrBuilderList());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(serviceList, toProtoResult2.getServiceOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file2.getOptions();
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
    assertSame(file2, descriptorForType3.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file2, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(56);
    assertSame(file2, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(57);
    assertSame(file2, getResult5.getFile());
    assertSame(file2, enumTypes.get(0).getFile());
    assertSame(file2, enumTypes.get(1).getFile());
    assertSame(file2, enumTypes.get(3).getFile());
    assertSame(file2, enumTypes.get(4).getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file2, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file2, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(AlarmUpdateMsg.ENDTS_FIELD_NUMBER);
    assertSame(file2, getResult8.getFile());
    Descriptors.FieldDescriptor getResult9 = fields2.get(AlarmUpdateMsg.STARTTS_FIELD_NUMBER);
    assertSame(file2, getResult9.getFile());
    assertSame(file2, getResult.getFile());
    assertSame(file2, services.get(0).getFile());
    DescriptorProtos.MessageOptions options4 = descriptorForType2.getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, options2.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType3.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options4, getResult5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult9.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType3, getResult6.getContainingType());
    assertSame(descriptorForType3, getResult7.getContainingType());
    assertSame(descriptorForType3, getResult8.getContainingType());
    assertSame(descriptorForType3, getResult9.getContainingType());
    assertSame(descriptorForType3, getResult.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, configuration.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertSame(configuration, actualParseDelimitedFromResult.getConfigurationOrBuilder());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> EdgeUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(EdgeUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test
   * {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then throw IOException")
  void testParseDelimitedFromWithInputExtensionRegistry_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class,
        () -> EdgeUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> EdgeUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(EdgeUpdateMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw InvalidProtocolBufferException")
  void testParseDelimitedFromWithInput_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> EdgeUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link EdgeUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link EdgeUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'")
  void testParseFromWithInputStreamExtensionRegistryLite() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> EdgeUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link EdgeUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> EdgeUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link EdgeUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> EdgeUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link EdgeUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> EdgeUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link EdgeUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty
   * array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    EdgeUpdateMsg actualParseFromResult = EdgeUpdateMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.ServiceDescriptorProto> serviceList = toProtoResult2.getServiceList();
    assertEquals(1, serviceList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(5, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(58, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    EdgeConfiguration configuration = actualParseFromResult.getConfiguration();
    Descriptors.Descriptor descriptorForType2 = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult3.getFieldList();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList2, toProtoResult3.getFieldOrBuilderList());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(serviceList, toProtoResult2.getServiceOrBuilderList());
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
    Descriptors.Descriptor getResult4 = messageTypes.get(56);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(57);
    assertSame(file, getResult5.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(AlarmUpdateMsg.ENDTS_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    Descriptors.FieldDescriptor getResult9 = fields2.get(AlarmUpdateMsg.STARTTS_FIELD_NUMBER);
    assertSame(file, getResult9.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, services.get(0).getFile());
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
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult9.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, getResult9.getContainingType());
    assertSame(descriptorForType2, getResult.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, configuration.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertSame(configuration, actualParseFromResult.getConfigurationOrBuilder());
  }

  /**
   * Test {@link EdgeUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    EdgeUpdateMsg actualParseFromResult = EdgeUpdateMsg.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.ServiceDescriptorProto> serviceList = toProtoResult2.getServiceList();
    assertEquals(1, serviceList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.ServiceDescriptor> services = file.getServices();
    assertEquals(1, services.size());
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(5, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(58, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    EdgeConfiguration configuration = actualParseFromResult.getConfiguration();
    Descriptors.Descriptor descriptorForType2 = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult3.getFieldList();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList2, toProtoResult3.getFieldOrBuilderList());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(serviceList, toProtoResult2.getServiceOrBuilderList());
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
    Descriptors.Descriptor getResult4 = messageTypes.get(56);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(57);
    assertSame(file, getResult5.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(0);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(1);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(AlarmUpdateMsg.ENDTS_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    Descriptors.FieldDescriptor getResult9 = fields2.get(AlarmUpdateMsg.STARTTS_FIELD_NUMBER);
    assertSame(file, getResult9.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, services.get(0).getFile());
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
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(options3, getResult9.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, getResult9.getContainingType());
    assertSame(descriptorForType2, getResult.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, configuration.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertSame(configuration, actualParseFromResult.getConfigurationOrBuilder());
  }
}
