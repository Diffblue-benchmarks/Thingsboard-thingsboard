package org.thingsboard.server.gen.edge.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class AlarmUpdateMsgDiffblueTest {
  /**
   * Test {@link AlarmUpdateMsg#equals(Object)}, and
   * {@link AlarmUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmUpdateMsg#equals(Object)}
   *   <li>{@link AlarmUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmUpdateMsg defaultInstance = AlarmUpdateMsg.getDefaultInstance();
    AlarmUpdateMsg defaultInstance2 = AlarmUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link AlarmUpdateMsg#equals(Object)}, and
   * {@link AlarmUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmUpdateMsg#equals(Object)}
   *   <li>{@link AlarmUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmUpdateMsg defaultInstance = AlarmUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link AlarmUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AlarmUpdateMsg.getDefaultInstance(), 1);
  }

  /**
   * Test {@link AlarmUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AlarmUpdateMsg.getDefaultInstance(), null);
  }

  /**
   * Test {@link AlarmUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AlarmUpdateMsg.getDefaultInstance(), "Different type to AlarmUpdateMsg");
  }

  /**
   * Test {@link AlarmUpdateMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  void testGetDefaultInstanceForType() {
    // Arrange
    AlarmUpdateMsg defaultInstance = AlarmUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link AlarmUpdateMsg#getDetails()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getDetails()}
   */
  @Test
  @DisplayName("Test getDetails()")
  void testGetDetails() {
    // Arrange, Act and Assert
    assertEquals("", AlarmUpdateMsg.getDefaultInstance().getDetails());
  }

  /**
   * Test {@link AlarmUpdateMsg#getDetailsBytes()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getDetailsBytes()}
   */
  @Test
  @DisplayName("Test getDetailsBytes()")
  void testGetDetailsBytes() {
    // Arrange
    AlarmUpdateMsg defaultInstance = AlarmUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualDetailsBytes = defaultInstance.getDetailsBytes();

    // Assert
    ByteString byteString = actualDetailsBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(AlarmUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(AlarmUpdateMsg.PROPAGATETOOWNER_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(AlarmUpdateMsg.PROPAGATETOTENANT_FIELD_NUMBER)
        .toProto();
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
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualDetailsBytes);
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, defaultInstance.getNameBytes());
    assertEquals(byteString, defaultInstance.getOriginatorNameBytes());
    assertEquals(byteString, defaultInstance.getOriginatorTypeBytes());
    assertEquals(byteString, defaultInstance.getSeverityBytes());
    assertEquals(byteString, defaultInstance.getStatusBytes());
    assertEquals(byteString, defaultInstance.getTypeBytes());
  }

  /**
   * Test {@link AlarmUpdateMsg#getEntity()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  void testGetEntity() {
    // Arrange, Act and Assert
    assertEquals("", AlarmUpdateMsg.getDefaultInstance().getEntity());
  }

  /**
   * Test {@link AlarmUpdateMsg#getEntityBytes()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getEntityBytes()}
   */
  @Test
  @DisplayName("Test getEntityBytes()")
  void testGetEntityBytes() {
    // Arrange
    AlarmUpdateMsg defaultInstance = AlarmUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualEntityBytes = defaultInstance.getEntityBytes();

    // Assert
    ByteString byteString = actualEntityBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(AlarmUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(AlarmUpdateMsg.PROPAGATETOOWNER_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(AlarmUpdateMsg.PROPAGATETOTENANT_FIELD_NUMBER)
        .toProto();
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
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDetailsBytes());
    assertEquals(byteString, actualEntityBytes);
    assertEquals(byteString, defaultInstance.getNameBytes());
    assertEquals(byteString, defaultInstance.getOriginatorNameBytes());
    assertEquals(byteString, defaultInstance.getOriginatorTypeBytes());
    assertEquals(byteString, defaultInstance.getSeverityBytes());
    assertEquals(byteString, defaultInstance.getStatusBytes());
    assertEquals(byteString, defaultInstance.getTypeBytes());
  }

  /**
   * Test {@link AlarmUpdateMsg#getMsgType()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getMsgType()}
   */
  @Test
  @DisplayName("Test getMsgType()")
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, AlarmUpdateMsg.getDefaultInstance().getMsgType());
  }

  /**
   * Test {@link AlarmUpdateMsg#getName()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("", AlarmUpdateMsg.getDefaultInstance().getName());
  }

  /**
   * Test {@link AlarmUpdateMsg#getNameBytes()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getNameBytes()}
   */
  @Test
  @DisplayName("Test getNameBytes()")
  void testGetNameBytes() {
    // Arrange
    AlarmUpdateMsg defaultInstance = AlarmUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(AlarmUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(AlarmUpdateMsg.PROPAGATETOOWNER_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(AlarmUpdateMsg.PROPAGATETOTENANT_FIELD_NUMBER)
        .toProto();
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
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDetailsBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, actualNameBytes);
    assertEquals(byteString, defaultInstance.getOriginatorNameBytes());
    assertEquals(byteString, defaultInstance.getOriginatorTypeBytes());
    assertEquals(byteString, defaultInstance.getSeverityBytes());
    assertEquals(byteString, defaultInstance.getStatusBytes());
    assertEquals(byteString, defaultInstance.getTypeBytes());
  }

  /**
   * Test {@link AlarmUpdateMsg#getOriginatorName()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getOriginatorName()}
   */
  @Test
  @DisplayName("Test getOriginatorName()")
  void testGetOriginatorName() {
    // Arrange, Act and Assert
    assertEquals("", AlarmUpdateMsg.getDefaultInstance().getOriginatorName());
  }

  /**
   * Test {@link AlarmUpdateMsg#getOriginatorNameBytes()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getOriginatorNameBytes()}
   */
  @Test
  @DisplayName("Test getOriginatorNameBytes()")
  void testGetOriginatorNameBytes() {
    // Arrange
    AlarmUpdateMsg defaultInstance = AlarmUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualOriginatorNameBytes = defaultInstance.getOriginatorNameBytes();

    // Assert
    ByteString byteString = actualOriginatorNameBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(AlarmUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(AlarmUpdateMsg.PROPAGATETOOWNER_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(AlarmUpdateMsg.PROPAGATETOTENANT_FIELD_NUMBER)
        .toProto();
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
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDetailsBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, defaultInstance.getNameBytes());
    assertEquals(byteString, actualOriginatorNameBytes);
    assertEquals(byteString, defaultInstance.getOriginatorTypeBytes());
    assertEquals(byteString, defaultInstance.getSeverityBytes());
    assertEquals(byteString, defaultInstance.getStatusBytes());
    assertEquals(byteString, defaultInstance.getTypeBytes());
  }

  /**
   * Test {@link AlarmUpdateMsg#getOriginatorType()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getOriginatorType()}
   */
  @Test
  @DisplayName("Test getOriginatorType()")
  void testGetOriginatorType() {
    // Arrange, Act and Assert
    assertEquals("", AlarmUpdateMsg.getDefaultInstance().getOriginatorType());
  }

  /**
   * Test {@link AlarmUpdateMsg#getOriginatorTypeBytes()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getOriginatorTypeBytes()}
   */
  @Test
  @DisplayName("Test getOriginatorTypeBytes()")
  void testGetOriginatorTypeBytes() {
    // Arrange
    AlarmUpdateMsg defaultInstance = AlarmUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualOriginatorTypeBytes = defaultInstance.getOriginatorTypeBytes();

    // Assert
    ByteString byteString = actualOriginatorTypeBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(AlarmUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(AlarmUpdateMsg.PROPAGATETOOWNER_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(AlarmUpdateMsg.PROPAGATETOTENANT_FIELD_NUMBER)
        .toProto();
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
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDetailsBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, defaultInstance.getNameBytes());
    assertEquals(byteString, defaultInstance.getOriginatorNameBytes());
    assertEquals(byteString, actualOriginatorTypeBytes);
    assertEquals(byteString, defaultInstance.getSeverityBytes());
    assertEquals(byteString, defaultInstance.getStatusBytes());
    assertEquals(byteString, defaultInstance.getTypeBytes());
  }

  /**
   * Test {@link AlarmUpdateMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, AlarmUpdateMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link AlarmUpdateMsg#getSeverity()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getSeverity()}
   */
  @Test
  @DisplayName("Test getSeverity()")
  void testGetSeverity() {
    // Arrange, Act and Assert
    assertEquals("", AlarmUpdateMsg.getDefaultInstance().getSeverity());
  }

  /**
   * Test {@link AlarmUpdateMsg#getSeverityBytes()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getSeverityBytes()}
   */
  @Test
  @DisplayName("Test getSeverityBytes()")
  void testGetSeverityBytes() {
    // Arrange
    AlarmUpdateMsg defaultInstance = AlarmUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualSeverityBytes = defaultInstance.getSeverityBytes();

    // Assert
    ByteString byteString = actualSeverityBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(AlarmUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(AlarmUpdateMsg.PROPAGATETOOWNER_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(AlarmUpdateMsg.PROPAGATETOTENANT_FIELD_NUMBER)
        .toProto();
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
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDetailsBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, defaultInstance.getNameBytes());
    assertEquals(byteString, defaultInstance.getOriginatorNameBytes());
    assertEquals(byteString, defaultInstance.getOriginatorTypeBytes());
    assertEquals(byteString, actualSeverityBytes);
    assertEquals(byteString, defaultInstance.getStatusBytes());
    assertEquals(byteString, defaultInstance.getTypeBytes());
  }

  /**
   * Test {@link AlarmUpdateMsg#getStatus()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getStatus()}
   */
  @Test
  @DisplayName("Test getStatus()")
  void testGetStatus() {
    // Arrange, Act and Assert
    assertEquals("", AlarmUpdateMsg.getDefaultInstance().getStatus());
  }

  /**
   * Test {@link AlarmUpdateMsg#getStatusBytes()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getStatusBytes()}
   */
  @Test
  @DisplayName("Test getStatusBytes()")
  void testGetStatusBytes() {
    // Arrange
    AlarmUpdateMsg defaultInstance = AlarmUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualStatusBytes = defaultInstance.getStatusBytes();

    // Assert
    ByteString byteString = actualStatusBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(AlarmUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(AlarmUpdateMsg.PROPAGATETOOWNER_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(AlarmUpdateMsg.PROPAGATETOTENANT_FIELD_NUMBER)
        .toProto();
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
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDetailsBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, defaultInstance.getNameBytes());
    assertEquals(byteString, defaultInstance.getOriginatorNameBytes());
    assertEquals(byteString, defaultInstance.getOriginatorTypeBytes());
    assertEquals(byteString, defaultInstance.getSeverityBytes());
    assertEquals(byteString, actualStatusBytes);
    assertEquals(byteString, defaultInstance.getTypeBytes());
  }

  /**
   * Test {@link AlarmUpdateMsg#getType()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("", AlarmUpdateMsg.getDefaultInstance().getType());
  }

  /**
   * Test {@link AlarmUpdateMsg#getTypeBytes()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#getTypeBytes()}
   */
  @Test
  @DisplayName("Test getTypeBytes()")
  void testGetTypeBytes() {
    // Arrange
    AlarmUpdateMsg defaultInstance = AlarmUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualTypeBytes = defaultInstance.getTypeBytes();

    // Assert
    ByteString byteString = actualTypeBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(AlarmUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(AlarmUpdateMsg.PROPAGATETOOWNER_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(AlarmUpdateMsg.PROPAGATETOTENANT_FIELD_NUMBER)
        .toProto();
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
    assertEquals(byteString, toProtoResult3.getTypeNameBytes());
    assertEquals(byteString, toProtoResult4.getTypeNameBytes());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto defaultInstanceForType = file.toProto().getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getNameBytes());
    assertEquals(byteString, defaultInstanceForType.getPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSyntaxBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType2.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType2.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType2.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType2.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getDetailsBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, defaultInstance.getNameBytes());
    assertEquals(byteString, defaultInstance.getOriginatorNameBytes());
    assertEquals(byteString, defaultInstance.getOriginatorTypeBytes());
    assertEquals(byteString, defaultInstance.getSeverityBytes());
    assertEquals(byteString, defaultInstance.getStatusBytes());
    assertEquals(byteString, actualTypeBytes);
  }

  /**
   * Test {@link AlarmUpdateMsg#isInitialized()}.
   * <p>
   * Method under test: {@link AlarmUpdateMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(AlarmUpdateMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link AlarmUpdateMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link AlarmUpdateMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test newInstance(UnusedPrivateParameter)")
  void testNewInstance() {
    // Arrange
    AlarmUpdateMsg defaultInstance = AlarmUpdateMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof AlarmUpdateMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test
   * {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class,
        () -> AlarmUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> AlarmUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AlarmUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test
   * {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> AlarmUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> AlarmUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(AlarmUpdateMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AlarmUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateMsg#parseDelimitedFrom(InputStream)}
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
    assertThrows(InvalidProtocolBufferException.class, () -> AlarmUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link AlarmUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link AlarmUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
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
        () -> AlarmUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link AlarmUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AlarmUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link AlarmUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> AlarmUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link AlarmUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> AlarmUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link AlarmUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty
   * array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    AlarmUpdateMsg actualParseFromResult = AlarmUpdateMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(AlarmUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(AlarmUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList expectedReservedNameList = toProtoResult.getReservedNameList();
    assertSame(expectedReservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult2.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult2.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(AlarmUpdateMsg.PROPAGATETOOWNER_FIELD_NUMBER);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType2.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(1);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(56);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(57);
    assertSame(file, getResult6.getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(AlarmUpdateMsg.PROPAGATETOTENANT_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options2.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options5, options.getDescriptorForType().getOptions());
    assertSame(options5, getResult3.getOptions());
    assertSame(options5, getResult4.getOptions());
    assertSame(options5, getResult5.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult7.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult8.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }

  /**
   * Test {@link AlarmUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    AlarmUpdateMsg actualParseFromResult = AlarmUpdateMsg.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(AlarmUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(AlarmUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList expectedReservedNameList = toProtoResult.getReservedNameList();
    assertSame(expectedReservedNameList, defaultInstanceForType.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult2.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult2.getWeakDependencyList());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType2 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(AlarmUpdateMsg.PROPAGATETOOWNER_FIELD_NUMBER);
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, options4.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType2.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    Descriptors.Descriptor getResult3 = messageTypes.get(0);
    assertSame(file, getResult3.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(1);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(56);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(57);
    assertSame(file, getResult6.getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult7 = fields.get(1);
    assertSame(file, getResult7.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult8 = fields.get(AlarmUpdateMsg.PROPAGATETOTENANT_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    DescriptorProtos.MessageOptions options5 = options2.getDescriptorForType().getOptions();
    assertSame(options5, defaultInstanceForType.getOptions());
    assertSame(options5, toProtoResult.getOptions());
    assertSame(options5, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options5, toProtoResult.getOptionsOrBuilder());
    assertSame(options5, options5);
    assertSame(options5, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options5, options.getDescriptorForType().getOptions());
    assertSame(options5, getResult3.getOptions());
    assertSame(options5, getResult4.getOptions());
    assertSame(options5, getResult5.getOptions());
    assertSame(options5, getResult6.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult.toProto();
    assertSame(options3, toProtoResult3.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult7.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult8.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, options4.getDefaultInstanceForType());
    assertSame(options3, getResult7.getOptions());
    assertSame(options3, getResult8.getOptions());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult7.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult8.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
  }
}
