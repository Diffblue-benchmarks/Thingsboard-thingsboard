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
import com.google.protobuf.ByteString;
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

class ConnectResponseMsgDiffblueTest {
  /**
   * Test {@link ConnectResponseMsg#equals(Object)}, and
   * {@link ConnectResponseMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ConnectResponseMsg#equals(Object)}
   *   <li>{@link ConnectResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConnectResponseMsg defaultInstance = ConnectResponseMsg.getDefaultInstance();
    ConnectResponseMsg defaultInstance2 = ConnectResponseMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link ConnectResponseMsg#equals(Object)}, and
   * {@link ConnectResponseMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ConnectResponseMsg#equals(Object)}
   *   <li>{@link ConnectResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConnectResponseMsg defaultInstance = ConnectResponseMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link ConnectResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ConnectResponseMsg.getDefaultInstance(), 1);
  }

  /**
   * Test {@link ConnectResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ConnectResponseMsg.getDefaultInstance(), null);
  }

  /**
   * Test {@link ConnectResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ConnectResponseMsg.getDefaultInstance(), "Different type to ConnectResponseMsg");
  }

  /**
   * Test {@link ConnectResponseMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ConnectResponseMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  void testGetDefaultInstanceForType() {
    // Arrange
    ConnectResponseMsg defaultInstance = ConnectResponseMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link ConnectResponseMsg#getErrorMsg()}.
   * <p>
   * Method under test: {@link ConnectResponseMsg#getErrorMsg()}
   */
  @Test
  @DisplayName("Test getErrorMsg()")
  void testGetErrorMsg() {
    // Arrange, Act and Assert
    assertEquals("", ConnectResponseMsg.getDefaultInstance().getErrorMsg());
  }

  /**
   * Test {@link ConnectResponseMsg#getErrorMsgBytes()}.
   * <p>
   * Method under test: {@link ConnectResponseMsg#getErrorMsgBytes()}
   */
  @Test
  @DisplayName("Test getErrorMsgBytes()")
  void testGetErrorMsgBytes() {
    // Arrange
    ConnectResponseMsg defaultInstance = ConnectResponseMsg.getDefaultInstance();

    // Act
    ByteString actualErrorMsgBytes = defaultInstance.getErrorMsgBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    ByteString byteString = actualErrorMsgBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(2).toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(3).toProto();
    assertEquals(byteString, toProtoResult4.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult2.getExtendeeBytes());
    assertEquals(byteString, toProtoResult3.getExtendeeBytes());
    assertEquals(byteString, toProtoResult4.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getJsonNameBytes());
    assertEquals(byteString, toProtoResult3.getJsonNameBytes());
    assertEquals(byteString, toProtoResult4.getJsonNameBytes());
    assertEquals(byteString, toProtoResult2.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualErrorMsgBytes);
    EdgeConfiguration configuration = defaultInstance.getConfiguration();
    assertEquals(byteString, configuration.getAdditionalInfoBytes());
    assertEquals(byteString, configuration.getCloudTypeBytes());
    assertEquals(byteString, configuration.getNameBytes());
    assertEquals(byteString, configuration.getRoutingKeyBytes());
    assertEquals(byteString, configuration.getSecretBytes());
    assertEquals(byteString, configuration.getTypeBytes());
  }

  /**
   * Test {@link ConnectResponseMsg#getResponseCode()}.
   * <p>
   * Method under test: {@link ConnectResponseMsg#getResponseCode()}
   */
  @Test
  @DisplayName("Test getResponseCode()")
  void testGetResponseCode() {
    // Arrange, Act and Assert
    assertEquals(ConnectResponseCode.ACCEPTED, ConnectResponseMsg.getDefaultInstance().getResponseCode());
  }

  /**
   * Test {@link ConnectResponseMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link ConnectResponseMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ConnectResponseMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link ConnectResponseMsg#hasConfiguration()}.
   * <p>
   * Method under test: {@link ConnectResponseMsg#hasConfiguration()}
   */
  @Test
  @DisplayName("Test hasConfiguration()")
  void testHasConfiguration() {
    // Arrange, Act and Assert
    assertFalse(ConnectResponseMsg.getDefaultInstance().hasConfiguration());
  }

  /**
   * Test {@link ConnectResponseMsg#hasMaxInboundMessageSize()}.
   * <p>
   * Method under test: {@link ConnectResponseMsg#hasMaxInboundMessageSize()}
   */
  @Test
  @DisplayName("Test hasMaxInboundMessageSize()")
  void testHasMaxInboundMessageSize() {
    // Arrange, Act and Assert
    assertFalse(ConnectResponseMsg.getDefaultInstance().hasMaxInboundMessageSize());
  }

  /**
   * Test {@link ConnectResponseMsg#isInitialized()}.
   * <p>
   * Method under test: {@link ConnectResponseMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ConnectResponseMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link ConnectResponseMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link ConnectResponseMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test newInstance(UnusedPrivateParameter)")
  void testNewInstance() {
    // Arrange
    ConnectResponseMsg defaultInstance = ConnectResponseMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ConnectResponseMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test {@link ConnectResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test: {@link ConnectResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'")
  void testParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ConnectResponseMsg actualParseDelimitedFromResult = ConnectResponseMsg.parseDelimitedFrom(input);

    // Assert
    EdgeConfiguration configuration = actualParseDelimitedFromResult.getConfiguration();
    UnknownFieldSet unknownFields = configuration.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertTrue(unknownFields.isInitialized());
    Descriptors.Descriptor descriptorForType2 = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult3.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult3.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getEnumType().getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    Descriptors.FieldDescriptor getResult4 = fields2.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(AlarmUpdateMsg.ENDTS_FIELD_NUMBER);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(AlarmUpdateMsg.STARTTS_FIELD_NUMBER);
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(1);
    assertSame(file, getResult8.getFile());
    Descriptors.FieldDescriptor getResult9 = fields.get(2);
    assertSame(file, getResult9.getFile());
    Descriptors.FieldDescriptor getResult10 = fields.get(3);
    assertSame(file, getResult10.getFile());
    Descriptors.OneofDescriptor getResult11 = oneofs.get(0);
    assertSame(file, getResult11.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options2, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult8.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult9.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult10.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options2, getResult9.getOptions());
    assertSame(options2, getResult10.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult9.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    assertSame(descriptorForType, getResult11.getContainingType());
    ConnectResponseMsg defaultInstanceForType2 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(getResult11, getResult10.getContainingOneof());
    assertSame(configuration, defaultInstanceForType2.getConfiguration());
    assertSame(configuration, defaultInstanceForType2.getConfigurationOrBuilder());
    assertSame(configuration, actualParseDelimitedFromResult.getConfigurationOrBuilder());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ConnectResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test: {@link ConnectResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'")
  void testParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ConnectResponseMsg actualParseDelimitedFromResult = ConnectResponseMsg.parseDelimitedFrom(input);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    Descriptors.Descriptor getResult = messageTypes.get(56);
    assertEquals("DownlinkResponseMsg", getResult.getName());
    assertEquals("edge.DownlinkResponseMsg", getResult.getFullName());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    assertEquals(1, file.getDependencies().size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    assertEquals(56, getResult.getIndex());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    EdgeConfiguration configuration = actualParseDelimitedFromResult.getConfiguration();
    Descriptors.Descriptor descriptorForType2 = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult3.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult3.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult2.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getEnumType().getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(AlarmUpdateMsg.ENDTS_FIELD_NUMBER);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(AlarmUpdateMsg.STARTTS_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult9 = fields.get(1);
    assertSame(file, getResult9.getFile());
    Descriptors.FieldDescriptor getResult10 = fields.get(2);
    assertSame(file, getResult10.getFile());
    Descriptors.FieldDescriptor getResult11 = fields.get(3);
    assertSame(file, getResult11.getFile());
    Descriptors.OneofDescriptor getResult12 = oneofs.get(0);
    assertSame(file, getResult12.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult2.toProto();
    assertSame(options2, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult9.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult10.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult11.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options2, getResult9.getOptions());
    assertSame(options2, getResult10.getOptions());
    assertSame(options2, getResult11.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, getResult10.getMessageType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    assertSame(descriptorForType, getResult11.getContainingType());
    assertSame(descriptorForType, getResult12.getContainingType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, configuration.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult12, getResult11.getContainingOneof());
    assertSame(configuration, actualParseDelimitedFromResult.getConfigurationOrBuilder());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link ConnectResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link ConnectResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ConnectResponseMsg actualParseDelimitedFromResult = ConnectResponseMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    EdgeConfiguration configuration = actualParseDelimitedFromResult.getConfiguration();
    UnknownFieldSet unknownFields = configuration.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertTrue(unknownFields.isInitialized());
    Descriptors.Descriptor descriptorForType2 = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult3.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult3.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    assertSame(file, getResult.getEnumType().getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    Descriptors.FieldDescriptor getResult4 = fields2.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(AlarmUpdateMsg.ENDTS_FIELD_NUMBER);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(AlarmUpdateMsg.STARTTS_FIELD_NUMBER);
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(1);
    assertSame(file, getResult8.getFile());
    Descriptors.FieldDescriptor getResult9 = fields.get(2);
    assertSame(file, getResult9.getFile());
    Descriptors.FieldDescriptor getResult10 = fields.get(3);
    assertSame(file, getResult10.getFile());
    Descriptors.OneofDescriptor getResult11 = oneofs.get(0);
    assertSame(file, getResult11.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options2, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult8.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult9.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult10.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options2, getResult9.getOptions());
    assertSame(options2, getResult10.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult9.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    assertSame(descriptorForType, getResult11.getContainingType());
    ConnectResponseMsg defaultInstanceForType2 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(getResult11, getResult10.getContainingOneof());
    assertSame(configuration, defaultInstanceForType2.getConfiguration());
    assertSame(configuration, defaultInstanceForType2.getConfigurationOrBuilder());
    assertSame(configuration, actualParseDelimitedFromResult.getConfigurationOrBuilder());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link ConnectResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link ConnectResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ConnectResponseMsg actualParseDelimitedFromResult = ConnectResponseMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    Descriptors.Descriptor getResult = messageTypes.get(56);
    assertEquals("DownlinkResponseMsg", getResult.getName());
    assertEquals("edge.DownlinkResponseMsg", getResult.getFullName());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    assertEquals(1, file.getDependencies().size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    assertEquals(56, getResult.getIndex());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    EdgeConfiguration configuration = actualParseDelimitedFromResult.getConfiguration();
    Descriptors.Descriptor descriptorForType2 = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult3.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult3.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult2.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(1);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult.getFile());
    assertSame(file, getResult2.getEnumType().getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(0);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(AlarmUpdateMsg.ENDTS_FIELD_NUMBER);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields2.get(AlarmUpdateMsg.STARTTS_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult9 = fields.get(1);
    assertSame(file, getResult9.getFile());
    Descriptors.FieldDescriptor getResult10 = fields.get(2);
    assertSame(file, getResult10.getFile());
    Descriptors.FieldDescriptor getResult11 = fields.get(3);
    assertSame(file, getResult11.getFile());
    Descriptors.OneofDescriptor getResult12 = oneofs.get(0);
    assertSame(file, getResult12.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options4, getResult4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult2.toProto();
    assertSame(options2, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult9.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult10.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult11.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options2, getResult9.getOptions());
    assertSame(options2, getResult10.getOptions());
    assertSame(options2, getResult11.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult8.getContainingType());
    assertSame(descriptorForType2, getResult10.getMessageType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    assertSame(descriptorForType, getResult11.getContainingType());
    assertSame(descriptorForType, getResult12.getContainingType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, configuration.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult12, getResult11.getContainingOneof());
    assertSame(configuration, actualParseDelimitedFromResult.getConfigurationOrBuilder());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link ConnectResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link ConnectResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> ConnectResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link ConnectResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link ConnectResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> ConnectResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link ConnectResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConnectResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ConnectResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test
   * {@link ConnectResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConnectResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> ConnectResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ConnectResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ConnectResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ConnectResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ConnectResponseMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ConnectResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ConnectResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ConnectResponseMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseMsg#parseDelimitedFrom(InputStream)}
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
    assertThrows(InvalidProtocolBufferException.class, () -> ConnectResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ConnectResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link ConnectResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
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
        () -> ConnectResponseMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ConnectResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConnectResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class,
        () -> ConnectResponseMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ConnectResponseMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ConnectResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ConnectResponseMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ConnectResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ConnectResponseMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty
   * array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    ConnectResponseMsg actualParseFromResult = ConnectResponseMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    EdgeConfiguration configuration = actualParseFromResult.getConfiguration();
    Descriptors.Descriptor descriptorForType2 = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult3.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult3.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    assertSame(file, messageTypes.get(56).getFile());
    assertSame(file, getResult.getEnumType().getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    Descriptors.FieldDescriptor getResult4 = fields2.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(AlarmUpdateMsg.ENDTS_FIELD_NUMBER);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(AlarmUpdateMsg.STARTTS_FIELD_NUMBER);
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(1);
    assertSame(file, getResult8.getFile());
    Descriptors.FieldDescriptor getResult9 = fields.get(2);
    assertSame(file, getResult9.getFile());
    Descriptors.FieldDescriptor getResult10 = fields.get(3);
    assertSame(file, getResult10.getFile());
    Descriptors.OneofDescriptor getResult11 = oneofs.get(0);
    assertSame(file, getResult11.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options2, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult8.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult9.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult10.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options2, getResult9.getOptions());
    assertSame(options2, getResult10.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult9.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    assertSame(descriptorForType, getResult11.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, configuration.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult11, getResult10.getContainingOneof());
    assertSame(configuration, actualParseFromResult.getConfigurationOrBuilder());
    assertSame(configuration, configuration.getDefaultInstanceForType());
  }

  /**
   * Test {@link ConnectResponseMsg#parseFrom(InputStream)} with
   * {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConnectResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ConnectResponseMsg actualParseFromResult = ConnectResponseMsg.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(1, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(1, oneofs.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    EdgeConfiguration configuration = actualParseFromResult.getConfiguration();
    Descriptors.Descriptor descriptorForType2 = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(AlarmUpdateMsg.ACKTS_FIELD_NUMBER, fields2.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult3 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult3.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult3.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(0);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(1);
    assertSame(file, getResult3.getFile());
    assertSame(file, messageTypes.get(56).getFile());
    assertSame(file, getResult.getEnumType().getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(3).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    Descriptors.FieldDescriptor getResult4 = fields2.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields2.get(AlarmUpdateMsg.ENDTS_FIELD_NUMBER);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields2.get(AlarmUpdateMsg.STARTTS_FIELD_NUMBER);
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(1);
    assertSame(file, getResult8.getFile());
    Descriptors.FieldDescriptor getResult9 = fields.get(2);
    assertSame(file, getResult9.getFile());
    Descriptors.FieldDescriptor getResult10 = fields.get(3);
    assertSame(file, getResult10.getFile());
    Descriptors.OneofDescriptor getResult11 = oneofs.get(0);
    assertSame(file, getResult11.getFile());
    DescriptorProtos.MessageOptions options4 = options.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, toProtoResult.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, toProtoResult.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options2, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult8.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult9.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult10.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult4.getOptionsOrBuilder());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options2, getResult9.getOptions());
    assertSame(options2, getResult10.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult6.getContainingType());
    assertSame(descriptorForType2, getResult7.getContainingType());
    assertSame(descriptorForType2, getResult9.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    assertSame(descriptorForType, getResult11.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, configuration.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult11, getResult10.getContainingOneof());
    assertSame(configuration, actualParseFromResult.getConfigurationOrBuilder());
    assertSame(configuration, configuration.getDefaultInstanceForType());
  }
}
