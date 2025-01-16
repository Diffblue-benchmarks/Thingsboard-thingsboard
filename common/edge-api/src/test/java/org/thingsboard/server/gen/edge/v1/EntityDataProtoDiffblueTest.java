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
import org.thingsboard.server.gen.transport.TransportProtos;

class EntityDataProtoDiffblueTest {
  /**
   * Test {@link EntityDataProto#equals(Object)}, and
   * {@link EntityDataProto#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataProto#equals(Object)}
   *   <li>{@link EntityDataProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityDataProto defaultInstance = EntityDataProto.getDefaultInstance();
    EntityDataProto defaultInstance2 = EntityDataProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link EntityDataProto#equals(Object)}, and
   * {@link EntityDataProto#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataProto#equals(Object)}
   *   <li>{@link EntityDataProto#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityDataProto defaultInstance = EntityDataProto.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link EntityDataProto#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataProto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(EntityDataProto.getDefaultInstance(), 1);
  }

  /**
   * Test {@link EntityDataProto#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataProto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(EntityDataProto.getDefaultInstance(), null);
  }

  /**
   * Test {@link EntityDataProto#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataProto#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(EntityDataProto.getDefaultInstance(), "Different type to EntityDataProto");
  }

  /**
   * Test {@link EntityDataProto#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link EntityDataProto#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  void testGetDefaultInstanceForType() {
    // Arrange
    EntityDataProto defaultInstance = EntityDataProto.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link EntityDataProto#getEntityType()}.
   * <p>
   * Method under test: {@link EntityDataProto#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals("", EntityDataProto.getDefaultInstance().getEntityType());
  }

  /**
   * Test {@link EntityDataProto#getEntityTypeBytes()}.
   * <p>
   * Method under test: {@link EntityDataProto#getEntityTypeBytes()}
   */
  @Test
  @DisplayName("Test getEntityTypeBytes()")
  void testGetEntityTypeBytes() {
    // Arrange
    EntityDataProto defaultInstance = EntityDataProto.getDefaultInstance();

    // Act
    ByteString actualEntityTypeBytes = defaultInstance.getEntityTypeBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    ByteString byteString = actualEntityTypeBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    DescriptorProtos.FileOptions options = defaultInstance.getAttributesUpdatedMsg()
        .getDescriptorForType()
        .getFile()
        .getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    DescriptorProtos.FileOptions options2 = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options2.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options2.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, options2.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getAttributeDeleteMsg().getScopeBytes());
    assertEquals(byteString, actualEntityTypeBytes);
    assertEquals(byteString, defaultInstance.getPostAttributeScopeBytes());
  }

  /**
   * Test {@link EntityDataProto#getPostAttributeScope()}.
   * <p>
   * Method under test: {@link EntityDataProto#getPostAttributeScope()}
   */
  @Test
  @DisplayName("Test getPostAttributeScope()")
  void testGetPostAttributeScope() {
    // Arrange, Act and Assert
    assertEquals("", EntityDataProto.getDefaultInstance().getPostAttributeScope());
  }

  /**
   * Test {@link EntityDataProto#getPostAttributeScopeBytes()}.
   * <p>
   * Method under test: {@link EntityDataProto#getPostAttributeScopeBytes()}
   */
  @Test
  @DisplayName("Test getPostAttributeScopeBytes()")
  void testGetPostAttributeScopeBytes() {
    // Arrange
    EntityDataProto defaultInstance = EntityDataProto.getDefaultInstance();

    // Act
    ByteString actualPostAttributeScopeBytes = defaultInstance.getPostAttributeScopeBytes();

    // Assert
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    ByteString byteString = actualPostAttributeScopeBytes.EMPTY;
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    assertEquals(byteString, toProtoResult.getExtendeeBytes());
    assertEquals(byteString, toProtoResult.getJsonNameBytes());
    DescriptorProtos.FileOptions options = defaultInstance.getAttributesUpdatedMsg()
        .getDescriptorForType()
        .getFile()
        .getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    DescriptorProtos.FileOptions options2 = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options2.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options2.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, options2.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getAttributeDeleteMsg().getScopeBytes());
    assertEquals(byteString, defaultInstance.getEntityTypeBytes());
    assertEquals(byteString, actualPostAttributeScopeBytes);
  }

  /**
   * Test {@link EntityDataProto#getSerializedSize()}.
   * <p>
   * Method under test: {@link EntityDataProto#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, EntityDataProto.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link EntityDataProto#hasAttributeDeleteMsg()}.
   * <p>
   * Method under test: {@link EntityDataProto#hasAttributeDeleteMsg()}
   */
  @Test
  @DisplayName("Test hasAttributeDeleteMsg()")
  void testHasAttributeDeleteMsg() {
    // Arrange, Act and Assert
    assertFalse(EntityDataProto.getDefaultInstance().hasAttributeDeleteMsg());
  }

  /**
   * Test {@link EntityDataProto#hasAttributesUpdatedMsg()}.
   * <p>
   * Method under test: {@link EntityDataProto#hasAttributesUpdatedMsg()}
   */
  @Test
  @DisplayName("Test hasAttributesUpdatedMsg()")
  void testHasAttributesUpdatedMsg() {
    // Arrange, Act and Assert
    assertFalse(EntityDataProto.getDefaultInstance().hasAttributesUpdatedMsg());
  }

  /**
   * Test {@link EntityDataProto#hasPostAttributesMsg()}.
   * <p>
   * Method under test: {@link EntityDataProto#hasPostAttributesMsg()}
   */
  @Test
  @DisplayName("Test hasPostAttributesMsg()")
  void testHasPostAttributesMsg() {
    // Arrange, Act and Assert
    assertFalse(EntityDataProto.getDefaultInstance().hasPostAttributesMsg());
  }

  /**
   * Test {@link EntityDataProto#hasPostTelemetryMsg()}.
   * <p>
   * Method under test: {@link EntityDataProto#hasPostTelemetryMsg()}
   */
  @Test
  @DisplayName("Test hasPostTelemetryMsg()")
  void testHasPostTelemetryMsg() {
    // Arrange, Act and Assert
    assertFalse(EntityDataProto.getDefaultInstance().hasPostTelemetryMsg());
  }

  /**
   * Test {@link EntityDataProto#isInitialized()}.
   * <p>
   * Method under test: {@link EntityDataProto#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(EntityDataProto.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link EntityDataProto#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link EntityDataProto#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test newInstance(UnusedPrivateParameter)")
  void testNewInstance() {
    // Arrange
    EntityDataProto defaultInstance = EntityDataProto.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof EntityDataProto);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test {@link EntityDataProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test: {@link EntityDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'")
  void testParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    EntityDataProto actualParseDelimitedFromResult = EntityDataProto.parseDelimitedFrom(input);

    // Assert
    AttributeDeleteMsg attributeDeleteMsg = actualParseDelimitedFromResult.getAttributeDeleteMsg();
    UnknownFieldSet unknownFields = attributeDeleteMsg.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualParseDelimitedFromResult.getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualParseDelimitedFromResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualParseDelimitedFromResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualParseDelimitedFromResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualParseDelimitedFromResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualParseDelimitedFromResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualParseDelimitedFromResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link EntityDataProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <p>
   * Method under test: {@link EntityDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'")
  void testParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    EntityDataProto actualParseDelimitedFromResult = EntityDataProto.parseDelimitedFrom(input);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options = getResult.getOptions();
    assertEquals("", options.getInitializationErrorString());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualParseDelimitedFromResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualParseDelimitedFromResult.getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(2, fields2.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType3.getFields();
    assertEquals(2, fields3.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options.getJstype());
    assertFalse(options.getLazy());
    assertFalse(options.getPacked());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, options.getFeatures());
    assertSame(features, options.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualParseDelimitedFromResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields3.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields3.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields2.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options2.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options, getResult4.getOptions());
    assertSame(options, getResult5.getOptions());
    assertSame(options, getResult2.getOptions());
    assertSame(options, getResult3.getOptions());
    assertSame(options, getResult6.getOptions());
    assertSame(options, getResult7.getOptions());
    assertSame(options, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, actualParseDelimitedFromResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualParseDelimitedFromResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualParseDelimitedFromResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualParseDelimitedFromResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, actualParseDelimitedFromResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link EntityDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link EntityDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    EntityDataProto actualParseDelimitedFromResult = EntityDataProto.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    AttributeDeleteMsg attributeDeleteMsg = actualParseDelimitedFromResult.getAttributeDeleteMsg();
    UnknownFieldSet unknownFields = attributeDeleteMsg.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualParseDelimitedFromResult.getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualParseDelimitedFromResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    EntityDataProto defaultInstanceForType2 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsg());
    assertSame(attributeDeleteMsg, defaultInstanceForType2.getAttributeDeleteMsgOrBuilder());
    assertSame(attributeDeleteMsg, actualParseDelimitedFromResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualParseDelimitedFromResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualParseDelimitedFromResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, defaultInstanceForType2.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualParseDelimitedFromResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsg());
    assertSame(postTelemetryMsg, defaultInstanceForType2.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, actualParseDelimitedFromResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link EntityDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link EntityDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    EntityDataProto actualParseDelimitedFromResult = EntityDataProto.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(8, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options = getResult.getOptions();
    assertEquals("", options.getInitializationErrorString());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualParseDelimitedFromResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualParseDelimitedFromResult.getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType2.getFields();
    assertEquals(2, fields2.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType3.getFields();
    assertEquals(2, fields3.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    assertEquals(DescriptorProtos.FieldOptions.JSType.JS_NORMAL, options.getJstype());
    assertFalse(options.getLazy());
    assertFalse(options.getPacked());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, options.getFeatures());
    assertSame(features, options.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualParseDelimitedFromResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields3.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields3.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields2.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields2.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options2.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options, getResult4.getOptions());
    assertSame(options, getResult5.getOptions());
    assertSame(options, getResult2.getOptions());
    assertSame(options, getResult3.getOptions());
    assertSame(options, getResult6.getOptions());
    assertSame(options, getResult7.getOptions());
    assertSame(options, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, actualParseDelimitedFromResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualParseDelimitedFromResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualParseDelimitedFromResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualParseDelimitedFromResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, actualParseDelimitedFromResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link EntityDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link EntityDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> EntityDataProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link EntityDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link EntityDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> EntityDataProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link EntityDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(EntityDataProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test
   * {@link EntityDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataProto#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> EntityDataProto.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link EntityDataProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> EntityDataProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link EntityDataProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(EntityDataProto.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link EntityDataProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataProto#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> EntityDataProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link EntityDataProto#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataProto#parseDelimitedFrom(InputStream)}
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
    assertThrows(InvalidProtocolBufferException.class, () -> EntityDataProto.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link EntityDataProto#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link EntityDataProto#parseFrom(InputStream, ExtensionRegistryLite)}
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
        () -> EntityDataProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link EntityDataProto#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityDataProto#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> EntityDataProto.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link EntityDataProto#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> EntityDataProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link EntityDataProto#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> EntityDataProto.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link EntityDataProto#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty
   * array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    EntityDataProto actualParseFromResult = EntityDataProto.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualParseFromResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualParseFromResult.getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualParseFromResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, actualParseFromResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualParseFromResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualParseFromResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualParseFromResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, actualParseFromResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link EntityDataProto#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataProto#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    EntityDataProto actualParseFromResult = EntityDataProto.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.FileDescriptor> dependencies = file.getDependencies();
    assertEquals(1, dependencies.size());
    AttributeDeleteMsg attributeDeleteMsg = actualParseFromResult.getAttributeDeleteMsg();
    Descriptors.Descriptor descriptorForType2 = attributeDeleteMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(2, fieldList.size());
    TransportProtos.PostAttributeMsg attributesUpdatedMsg = actualParseFromResult.getAttributesUpdatedMsg();
    Descriptors.Descriptor descriptorForType3 = attributesUpdatedMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType3.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList2 = toProtoResult2.getFieldList();
    assertEquals(2, fieldList2.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(2, fields.size());
    List<Descriptors.FieldDescriptor> fields2 = descriptorForType3.getFields();
    assertEquals(2, fields2.size());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList3 = toProtoResult3.getFieldList();
    assertEquals(8, fieldList3.size());
    List<Descriptors.FieldDescriptor> fields3 = descriptorForType.getFields();
    assertEquals(8, fields3.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(fieldList2, toProtoResult2.getFieldOrBuilderList());
    assertSame(fieldList3, toProtoResult3.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> publicDependencyList = toProtoResult4.getPublicDependencyList();
    Descriptors.FileDescriptor file2 = descriptorForType3.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult5 = file2.toProto();
    assertSame(publicDependencyList, toProtoResult5.getPublicDependencyList());
    assertSame(publicDependencyList, toProtoResult5.getWeakDependencyList());
    assertSame(publicDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields3.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options3 = file2.getOptions();
    assertSame(features, options3.getFeatures());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    TransportProtos.PostTelemetryMsg postTelemetryMsg = actualParseFromResult.getPostTelemetryMsg();
    Descriptors.Descriptor descriptorForType4 = postTelemetryMsg.getDescriptorForType();
    assertSame(file2, descriptorForType4.getFile());
    Descriptors.FieldDescriptor getResult2 = fields2.get(0);
    assertSame(file2, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields2.get(1);
    assertSame(file2, getResult3.getFile());
    assertSame(file2, dependencies.get(0));
    assertSame(file, descriptorForType2.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(1);
    assertSame(file, getResult5.getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult6 = fields3.get(1);
    assertSame(file, getResult6.getFile());
    Descriptors.FieldDescriptor getResult7 = fields3.get(6);
    assertSame(file, getResult7.getFile());
    Descriptors.FieldDescriptor getResult8 = fields3.get(7);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, toProtoResult2.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(options5, toProtoResult6.getOptions());
    assertSame(options5, toProtoResult3.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, toProtoResult2.getOptionsOrBuilder());
    assertSame(options5, toProtoResult6.getOptionsOrBuilder());
    assertSame(options5, toProtoResult3.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult3.getDescriptorForType().getOptions());
    assertSame(options5, descriptorForType2.getOptions());
    assertSame(options5, descriptorForType3.getOptions());
    assertSame(options5, descriptorForType4.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, getResult4.getOptions());
    assertSame(options2, getResult5.getOptions());
    assertSame(options2, getResult2.getOptions());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult6.getOptions());
    assertSame(options2, getResult7.getOptions());
    assertSame(options2, getResult8.getOptions());
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, getResult5.getContainingType());
    assertSame(descriptorForType2, getResult8.getMessageType());
    assertSame(descriptorForType3, getResult2.getContainingType());
    assertSame(descriptorForType3, getResult3.getContainingType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, attributeDeleteMsg.getUnknownFields());
    assertSame(unknownFields, attributesUpdatedMsg.getUnknownFields());
    assertSame(unknownFields, postTelemetryMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList attributeNamesList = attributeDeleteMsg.getAttributeNamesList();
    assertSame(attributeNamesList, defaultInstanceForType.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult2.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult6.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult3.getReservedNameList());
    assertSame(attributeNamesList, toProtoResult5.getDependencyList());
    assertSame(attributeDeleteMsg, attributeDeleteMsg.getDefaultInstanceForType());
    assertSame(attributeDeleteMsg, actualParseFromResult.getAttributeDeleteMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualParseFromResult.getAttributesUpdatedMsgOrBuilder());
    assertSame(attributesUpdatedMsg, actualParseFromResult.getPostAttributesMsg());
    assertSame(attributesUpdatedMsg, actualParseFromResult.getPostAttributesMsgOrBuilder());
    assertSame(attributesUpdatedMsg, attributesUpdatedMsg.getDefaultInstanceForType());
    assertSame(postTelemetryMsg, actualParseFromResult.getPostTelemetryMsgOrBuilder());
    assertSame(postTelemetryMsg, postTelemetryMsg.getDefaultInstanceForType());
  }
}
