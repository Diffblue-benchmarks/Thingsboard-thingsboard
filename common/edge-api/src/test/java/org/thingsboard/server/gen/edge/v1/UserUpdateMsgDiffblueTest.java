package org.thingsboard.server.gen.edge.v1;

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

class UserUpdateMsgDiffblueTest {
  /**
   * Test {@link UserUpdateMsg#equals(Object)}, and
   * {@link UserUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserUpdateMsg#equals(Object)}
   *   <li>{@link UserUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserUpdateMsg defaultInstance = UserUpdateMsg.getDefaultInstance();
    UserUpdateMsg defaultInstance2 = UserUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link UserUpdateMsg#equals(Object)}, and
   * {@link UserUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserUpdateMsg#equals(Object)}
   *   <li>{@link UserUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserUpdateMsg defaultInstance = UserUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link UserUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UserUpdateMsg.getDefaultInstance(), 1);
  }

  /**
   * Test {@link UserUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UserUpdateMsg.getDefaultInstance(), null);
  }

  /**
   * Test {@link UserUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UserUpdateMsg.getDefaultInstance(), "Different type to UserUpdateMsg");
  }

  /**
   * Test {@link UserUpdateMsg#getAdditionalInfo()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo()")
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertEquals("", UserUpdateMsg.getDefaultInstance().getAdditionalInfo());
  }

  /**
   * Test {@link UserUpdateMsg#getAdditionalInfoBytes()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getAdditionalInfoBytes()}
   */
  @Test
  @DisplayName("Test getAdditionalInfoBytes()")
  void testGetAdditionalInfoBytes() {
    // Arrange
    UserUpdateMsg defaultInstance = UserUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualAdditionalInfoBytes = defaultInstance.getAdditionalInfoBytes();

    // Assert
    ByteString byteString = actualAdditionalInfoBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(UserUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(UserUpdateMsg.ADDITIONALINFO_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(UserUpdateMsg.LASTNAME_FIELD_NUMBER).toProto();
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
    assertEquals(byteString, file.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, actualAdditionalInfoBytes);
    assertEquals(byteString, defaultInstance.getAuthorityBytes());
    assertEquals(byteString, defaultInstance.getEmailBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, defaultInstance.getFirstNameBytes());
    assertEquals(byteString, defaultInstance.getLastNameBytes());
  }

  /**
   * Test {@link UserUpdateMsg#getAuthority()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getAuthority()}
   */
  @Test
  @DisplayName("Test getAuthority()")
  void testGetAuthority() {
    // Arrange, Act and Assert
    assertEquals("", UserUpdateMsg.getDefaultInstance().getAuthority());
  }

  /**
   * Test {@link UserUpdateMsg#getAuthorityBytes()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getAuthorityBytes()}
   */
  @Test
  @DisplayName("Test getAuthorityBytes()")
  void testGetAuthorityBytes() {
    // Arrange
    UserUpdateMsg defaultInstance = UserUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualAuthorityBytes = defaultInstance.getAuthorityBytes();

    // Assert
    ByteString byteString = actualAuthorityBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(UserUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(UserUpdateMsg.ADDITIONALINFO_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(UserUpdateMsg.LASTNAME_FIELD_NUMBER).toProto();
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
    assertEquals(byteString, file.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, actualAuthorityBytes);
    assertEquals(byteString, defaultInstance.getEmailBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, defaultInstance.getFirstNameBytes());
    assertEquals(byteString, defaultInstance.getLastNameBytes());
  }

  /**
   * Test {@link UserUpdateMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  void testGetDefaultInstanceForType() {
    // Arrange
    UserUpdateMsg defaultInstance = UserUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link UserUpdateMsg#getEmail()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getEmail()}
   */
  @Test
  @DisplayName("Test getEmail()")
  void testGetEmail() {
    // Arrange, Act and Assert
    assertEquals("", UserUpdateMsg.getDefaultInstance().getEmail());
  }

  /**
   * Test {@link UserUpdateMsg#getEmailBytes()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getEmailBytes()}
   */
  @Test
  @DisplayName("Test getEmailBytes()")
  void testGetEmailBytes() {
    // Arrange
    UserUpdateMsg defaultInstance = UserUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualEmailBytes = defaultInstance.getEmailBytes();

    // Assert
    ByteString byteString = actualEmailBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(UserUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(UserUpdateMsg.ADDITIONALINFO_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(UserUpdateMsg.LASTNAME_FIELD_NUMBER).toProto();
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
    assertEquals(byteString, file.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getAuthorityBytes());
    assertEquals(byteString, actualEmailBytes);
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, defaultInstance.getFirstNameBytes());
    assertEquals(byteString, defaultInstance.getLastNameBytes());
  }

  /**
   * Test {@link UserUpdateMsg#getEntity()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  void testGetEntity() {
    // Arrange, Act and Assert
    assertEquals("", UserUpdateMsg.getDefaultInstance().getEntity());
  }

  /**
   * Test {@link UserUpdateMsg#getEntityBytes()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getEntityBytes()}
   */
  @Test
  @DisplayName("Test getEntityBytes()")
  void testGetEntityBytes() {
    // Arrange
    UserUpdateMsg defaultInstance = UserUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualEntityBytes = defaultInstance.getEntityBytes();

    // Assert
    ByteString byteString = actualEntityBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(UserUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(UserUpdateMsg.ADDITIONALINFO_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(UserUpdateMsg.LASTNAME_FIELD_NUMBER).toProto();
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
    assertEquals(byteString, file.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getAuthorityBytes());
    assertEquals(byteString, defaultInstance.getEmailBytes());
    assertEquals(byteString, actualEntityBytes);
    assertEquals(byteString, defaultInstance.getFirstNameBytes());
    assertEquals(byteString, defaultInstance.getLastNameBytes());
  }

  /**
   * Test {@link UserUpdateMsg#getFirstName()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getFirstName()}
   */
  @Test
  @DisplayName("Test getFirstName()")
  void testGetFirstName() {
    // Arrange, Act and Assert
    assertEquals("", UserUpdateMsg.getDefaultInstance().getFirstName());
  }

  /**
   * Test {@link UserUpdateMsg#getFirstNameBytes()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getFirstNameBytes()}
   */
  @Test
  @DisplayName("Test getFirstNameBytes()")
  void testGetFirstNameBytes() {
    // Arrange
    UserUpdateMsg defaultInstance = UserUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualFirstNameBytes = defaultInstance.getFirstNameBytes();

    // Assert
    ByteString byteString = actualFirstNameBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(UserUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(UserUpdateMsg.ADDITIONALINFO_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(UserUpdateMsg.LASTNAME_FIELD_NUMBER).toProto();
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
    assertEquals(byteString, file.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getAuthorityBytes());
    assertEquals(byteString, defaultInstance.getEmailBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, actualFirstNameBytes);
    assertEquals(byteString, defaultInstance.getLastNameBytes());
  }

  /**
   * Test {@link UserUpdateMsg#getLastName()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getLastName()}
   */
  @Test
  @DisplayName("Test getLastName()")
  void testGetLastName() {
    // Arrange, Act and Assert
    assertEquals("", UserUpdateMsg.getDefaultInstance().getLastName());
  }

  /**
   * Test {@link UserUpdateMsg#getLastNameBytes()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getLastNameBytes()}
   */
  @Test
  @DisplayName("Test getLastNameBytes()")
  void testGetLastNameBytes() {
    // Arrange
    UserUpdateMsg defaultInstance = UserUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualLastNameBytes = defaultInstance.getLastNameBytes();

    // Assert
    ByteString byteString = actualLastNameBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(UserUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(UserUpdateMsg.ADDITIONALINFO_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(UserUpdateMsg.LASTNAME_FIELD_NUMBER).toProto();
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
    assertEquals(byteString, file.toProto().getDefaultInstanceForType().getNameBytes());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType = options.getDefaultInstanceForType();
    assertEquals(byteString, defaultInstanceForType.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getGoPackageBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaOuterClassnameBytes());
    assertEquals(byteString, defaultInstanceForType.getJavaPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getPhpNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, defaultInstanceForType.getRubyPackageBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, defaultInstanceForType.getSwiftPrefixBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getAdditionalInfoBytes());
    assertEquals(byteString, defaultInstance.getAuthorityBytes());
    assertEquals(byteString, defaultInstance.getEmailBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, defaultInstance.getFirstNameBytes());
    assertEquals(byteString, actualLastNameBytes);
  }

  /**
   * Test {@link UserUpdateMsg#getMsgType()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getMsgType()}
   */
  @Test
  @DisplayName("Test getMsgType()")
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, UserUpdateMsg.getDefaultInstance().getMsgType());
  }

  /**
   * Test {@link UserUpdateMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, UserUpdateMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link UserUpdateMsg#hasAdditionalInfo()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#hasAdditionalInfo()}
   */
  @Test
  @DisplayName("Test hasAdditionalInfo()")
  void testHasAdditionalInfo() {
    // Arrange, Act and Assert
    assertFalse(UserUpdateMsg.getDefaultInstance().hasAdditionalInfo());
  }

  /**
   * Test {@link UserUpdateMsg#hasCustomerIdLSB()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#hasCustomerIdLSB()}
   */
  @Test
  @DisplayName("Test hasCustomerIdLSB()")
  void testHasCustomerIdLSB() {
    // Arrange, Act and Assert
    assertFalse(UserUpdateMsg.getDefaultInstance().hasCustomerIdLSB());
  }

  /**
   * Test {@link UserUpdateMsg#hasCustomerIdMSB()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#hasCustomerIdMSB()}
   */
  @Test
  @DisplayName("Test hasCustomerIdMSB()")
  void testHasCustomerIdMSB() {
    // Arrange, Act and Assert
    assertFalse(UserUpdateMsg.getDefaultInstance().hasCustomerIdMSB());
  }

  /**
   * Test {@link UserUpdateMsg#hasFirstName()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#hasFirstName()}
   */
  @Test
  @DisplayName("Test hasFirstName()")
  void testHasFirstName() {
    // Arrange, Act and Assert
    assertFalse(UserUpdateMsg.getDefaultInstance().hasFirstName());
  }

  /**
   * Test {@link UserUpdateMsg#hasLastName()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#hasLastName()}
   */
  @Test
  @DisplayName("Test hasLastName()")
  void testHasLastName() {
    // Arrange, Act and Assert
    assertFalse(UserUpdateMsg.getDefaultInstance().hasLastName());
  }

  /**
   * Test {@link UserUpdateMsg#isInitialized()}.
   * <p>
   * Method under test: {@link UserUpdateMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(UserUpdateMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link UserUpdateMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link UserUpdateMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test newInstance(UnusedPrivateParameter)")
  void testNewInstance() {
    // Arrange
    UserUpdateMsg defaultInstance = UserUpdateMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof UserUpdateMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test
   * {@link UserUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link UserUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> UserUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link UserUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link UserUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> UserUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link UserUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UserUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test
   * {@link UserUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> UserUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link UserUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> UserUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link UserUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(UserUpdateMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link UserUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> UserUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link UserUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserUpdateMsg#parseDelimitedFrom(InputStream)}
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
    assertThrows(InvalidProtocolBufferException.class, () -> UserUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link UserUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link UserUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
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
        () -> UserUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link UserUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> UserUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link UserUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> UserUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link UserUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> UserUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link UserUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty
   * array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    UserUpdateMsg actualParseFromResult = UserUpdateMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(5, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(5, oneofs.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(UserUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(UserUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
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
    Descriptors.FieldDescriptor getResult2 = fields.get(UserUpdateMsg.LASTNAME_FIELD_NUMBER);
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
    Descriptors.FieldDescriptor getResult8 = fields.get(UserUpdateMsg.ADDITIONALINFO_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    Descriptors.OneofDescriptor getResult11 = oneofs.get(3);
    assertSame(file, getResult11.getFile());
    Descriptors.OneofDescriptor getResult12 = oneofs.get(4);
    assertSame(file, getResult12.getFile());
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
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    assertSame(descriptorForType, getResult11.getContainingType());
    assertSame(descriptorForType, getResult12.getContainingType());
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
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult12, getResult2.getContainingOneof());
  }

  /**
   * Test {@link UserUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    UserUpdateMsg actualParseFromResult = UserUpdateMsg.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = toProtoResult.getOneofDeclList();
    assertEquals(5, oneofDeclList.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(5, oneofs.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(UserUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(UserUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    assertSame(oneofDeclList, toProtoResult.getOneofDeclOrBuilderList());
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
    Descriptors.FieldDescriptor getResult2 = fields.get(UserUpdateMsg.LASTNAME_FIELD_NUMBER);
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
    Descriptors.FieldDescriptor getResult8 = fields.get(UserUpdateMsg.ADDITIONALINFO_FIELD_NUMBER);
    assertSame(file, getResult8.getFile());
    assertSame(file, getResult2.getFile());
    Descriptors.OneofDescriptor getResult9 = oneofs.get(0);
    assertSame(file, getResult9.getFile());
    Descriptors.OneofDescriptor getResult10 = oneofs.get(1);
    assertSame(file, getResult10.getFile());
    Descriptors.OneofDescriptor getResult11 = oneofs.get(3);
    assertSame(file, getResult11.getFile());
    Descriptors.OneofDescriptor getResult12 = oneofs.get(4);
    assertSame(file, getResult12.getFile());
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
    assertSame(descriptorForType, getResult8.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult9.getContainingType());
    assertSame(descriptorForType, getResult10.getContainingType());
    assertSame(descriptorForType, getResult11.getContainingType());
    assertSame(descriptorForType, getResult12.getContainingType());
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
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(getResult12, getResult2.getContainingOneof());
  }
}
