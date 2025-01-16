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
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class QueueUpdateMsgDiffblueTest {
  /**
   * Test {@link QueueUpdateMsg#equals(Object)}, and
   * {@link QueueUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueUpdateMsg#equals(Object)}
   *   <li>{@link QueueUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QueueUpdateMsg defaultInstance = QueueUpdateMsg.getDefaultInstance();
    QueueUpdateMsg defaultInstance2 = QueueUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link QueueUpdateMsg#equals(Object)}, and
   * {@link QueueUpdateMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueUpdateMsg#equals(Object)}
   *   <li>{@link QueueUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QueueUpdateMsg defaultInstance = QueueUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link QueueUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(QueueUpdateMsg.getDefaultInstance(), 1);
  }

  /**
   * Test {@link QueueUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(QueueUpdateMsg.getDefaultInstance(), null);
  }

  /**
   * Test {@link QueueUpdateMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(QueueUpdateMsg.getDefaultInstance(), "Different type to QueueUpdateMsg");
  }

  /**
   * Test {@link QueueUpdateMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link QueueUpdateMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  void testGetDefaultInstanceForType() {
    // Arrange
    QueueUpdateMsg defaultInstance = QueueUpdateMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link QueueUpdateMsg#getEntity()}.
   * <p>
   * Method under test: {@link QueueUpdateMsg#getEntity()}
   */
  @Test
  @DisplayName("Test getEntity()")
  void testGetEntity() {
    // Arrange, Act and Assert
    assertEquals("", QueueUpdateMsg.getDefaultInstance().getEntity());
  }

  /**
   * Test {@link QueueUpdateMsg#getEntityBytes()}.
   * <p>
   * Method under test: {@link QueueUpdateMsg#getEntityBytes()}
   */
  @Test
  @DisplayName("Test getEntityBytes()")
  void testGetEntityBytes() {
    // Arrange
    QueueUpdateMsg defaultInstance = QueueUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualEntityBytes = defaultInstance.getEntityBytes();

    // Assert
    ByteString byteString = actualEntityBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(QueueUpdateMsg.PROCESSINGSTRATEGY_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(QueueUpdateMsg.SUBMITSTRATEGY_FIELD_NUMBER)
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
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getProcessingStrategy().getTypeBytes());
    assertEquals(byteString, actualEntityBytes);
    assertEquals(byteString, defaultInstance.getNameBytes());
    assertEquals(byteString, defaultInstance.getTopicBytes());
    assertEquals(byteString, defaultInstance.getSubmitStrategy().getTypeBytes());
  }

  /**
   * Test {@link QueueUpdateMsg#getMsgType()}.
   * <p>
   * Method under test: {@link QueueUpdateMsg#getMsgType()}
   */
  @Test
  @DisplayName("Test getMsgType()")
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, QueueUpdateMsg.getDefaultInstance().getMsgType());
  }

  /**
   * Test {@link QueueUpdateMsg#getName()}.
   * <p>
   * Method under test: {@link QueueUpdateMsg#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("", QueueUpdateMsg.getDefaultInstance().getName());
  }

  /**
   * Test {@link QueueUpdateMsg#getNameBytes()}.
   * <p>
   * Method under test: {@link QueueUpdateMsg#getNameBytes()}
   */
  @Test
  @DisplayName("Test getNameBytes()")
  void testGetNameBytes() {
    // Arrange
    QueueUpdateMsg defaultInstance = QueueUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualNameBytes = defaultInstance.getNameBytes();

    // Assert
    ByteString byteString = actualNameBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(QueueUpdateMsg.PROCESSINGSTRATEGY_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(QueueUpdateMsg.SUBMITSTRATEGY_FIELD_NUMBER)
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
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getProcessingStrategy().getTypeBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, actualNameBytes);
    assertEquals(byteString, defaultInstance.getTopicBytes());
    assertEquals(byteString, defaultInstance.getSubmitStrategy().getTypeBytes());
  }

  /**
   * Test {@link QueueUpdateMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link QueueUpdateMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, QueueUpdateMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link QueueUpdateMsg#getTopic()}.
   * <p>
   * Method under test: {@link QueueUpdateMsg#getTopic()}
   */
  @Test
  @DisplayName("Test getTopic()")
  void testGetTopic() {
    // Arrange, Act and Assert
    assertEquals("", QueueUpdateMsg.getDefaultInstance().getTopic());
  }

  /**
   * Test {@link QueueUpdateMsg#getTopicBytes()}.
   * <p>
   * Method under test: {@link QueueUpdateMsg#getTopicBytes()}
   */
  @Test
  @DisplayName("Test getTopicBytes()")
  void testGetTopicBytes() {
    // Arrange
    QueueUpdateMsg defaultInstance = QueueUpdateMsg.getDefaultInstance();

    // Act
    ByteString actualTopicBytes = defaultInstance.getTopicBytes();

    // Assert
    ByteString byteString = actualTopicBytes.EMPTY;
    Descriptors.Descriptor descriptorForType = defaultInstance.getDescriptorForType();
    assertEquals(byteString, descriptorForType.toProto().getDefaultInstanceForType().getNameBytes());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.FieldDescriptorProto toProtoResult = fields.get(0).toProto();
    assertEquals(byteString, toProtoResult.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult2 = fields.get(1).toProto();
    assertEquals(byteString, toProtoResult2.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = fields.get(QueueUpdateMsg.PROCESSINGSTRATEGY_FIELD_NUMBER)
        .toProto();
    assertEquals(byteString, toProtoResult3.getDefaultValueBytes());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = fields.get(QueueUpdateMsg.SUBMITSTRATEGY_FIELD_NUMBER)
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
    DescriptorProtos.FileOptions options = descriptorForType.getFile().getOptions();
    assertEquals(byteString, options.getCsharpNamespaceBytes());
    assertEquals(byteString, options.getGoPackageBytes());
    assertEquals(byteString, options.getObjcClassPrefixBytes());
    assertEquals(byteString, options.getPhpClassPrefixBytes());
    assertEquals(byteString, options.getPhpMetadataNamespaceBytes());
    assertEquals(byteString, options.getPhpNamespaceBytes());
    assertEquals(byteString, options.getRubyPackageBytes());
    assertEquals(byteString, options.getSwiftPrefixBytes());
    assertEquals(byteString, defaultInstance.getProcessingStrategy().getTypeBytes());
    assertEquals(byteString, defaultInstance.getEntityBytes());
    assertEquals(byteString, defaultInstance.getNameBytes());
    assertEquals(byteString, actualTopicBytes);
    assertEquals(byteString, defaultInstance.getSubmitStrategy().getTypeBytes());
  }

  /**
   * Test {@link QueueUpdateMsg#hasProcessingStrategy()}.
   * <p>
   * Method under test: {@link QueueUpdateMsg#hasProcessingStrategy()}
   */
  @Test
  @DisplayName("Test hasProcessingStrategy()")
  void testHasProcessingStrategy() {
    // Arrange, Act and Assert
    assertFalse(QueueUpdateMsg.getDefaultInstance().hasProcessingStrategy());
  }

  /**
   * Test {@link QueueUpdateMsg#hasSubmitStrategy()}.
   * <p>
   * Method under test: {@link QueueUpdateMsg#hasSubmitStrategy()}
   */
  @Test
  @DisplayName("Test hasSubmitStrategy()")
  void testHasSubmitStrategy() {
    // Arrange, Act and Assert
    assertFalse(QueueUpdateMsg.getDefaultInstance().hasSubmitStrategy());
  }

  /**
   * Test {@link QueueUpdateMsg#isInitialized()}.
   * <p>
   * Method under test: {@link QueueUpdateMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(QueueUpdateMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link QueueUpdateMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link QueueUpdateMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test newInstance(UnusedPrivateParameter)")
  void testNewInstance() {
    // Arrange
    QueueUpdateMsg defaultInstance = QueueUpdateMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof QueueUpdateMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test
   * {@link QueueUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link QueueUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> QueueUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link QueueUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link QueueUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> QueueUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link QueueUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueueUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return AllFields size is one")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnAllFieldsSizeIsOne() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    QueueUpdateMsg actualParseDelimitedFromResult = QueueUpdateMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    assertEquals(1, actualParseDelimitedFromResult.getAllFields().size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    assertEquals(65L, actualParseDelimitedFromResult.getPackProcessingTimeout());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    ProcessingStrategyProto processingStrategy = actualParseDelimitedFromResult.getProcessingStrategy();
    Descriptors.Descriptor descriptorForType2 = processingStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    SubmitStrategyProto submitStrategy = actualParseDelimitedFromResult.getSubmitStrategy();
    Descriptors.Descriptor descriptorForType3 = submitStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(QueueUpdateMsg.SUBMITSTRATEGY_FIELD_NUMBER);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options3.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options4.getFeaturesOrBuilder());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(features, options5.getFeatures());
    assertSame(features, options5.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(QueueUpdateMsg.PROCESSINGSTRATEGY_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options6 = options.getDescriptorForType().getOptions();
    assertSame(options6, defaultInstanceForType.getOptions());
    assertSame(options6, toProtoResult.getOptions());
    assertSame(options6, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options6, toProtoResult.getOptionsOrBuilder());
    assertSame(options6, options5.getDefaultInstanceForType());
    assertSame(options6, options6);
    assertSame(options6, toProtoResult.getDescriptorForType().getOptions());
    DescriptorProtos.MessageOptions options7 = descriptorForType3.getOptions();
    assertSame(options7, toProtoResult3.getOptions());
    assertSame(options7, toProtoResult3.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult4.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, options3.getDefaultInstanceForType());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult2.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    QueueUpdateMsg defaultInstanceForType2 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, processingStrategy.getUnknownFields());
    assertSame(unknownFields, submitStrategy.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(processingStrategy, processingStrategy.getDefaultInstanceForType());
    assertSame(processingStrategy, defaultInstanceForType2.getProcessingStrategy());
    assertSame(processingStrategy, defaultInstanceForType2.getProcessingStrategyOrBuilder());
    assertSame(processingStrategy, actualParseDelimitedFromResult.getProcessingStrategyOrBuilder());
    assertSame(submitStrategy, defaultInstanceForType2.getSubmitStrategy());
    assertSame(submitStrategy, defaultInstanceForType2.getSubmitStrategyOrBuilder());
    assertSame(submitStrategy, actualParseDelimitedFromResult.getSubmitStrategyOrBuilder());
    assertSame(submitStrategy, submitStrategy.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link QueueUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueueUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(QueueUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test
   * {@link QueueUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueueUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return SerializedSize is zero")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    QueueUpdateMsg actualParseDelimitedFromResult = QueueUpdateMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getPackProcessingTimeout());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseDelimitedFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(allFields, features.getAllFields());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertEquals(allFields, options2.getAllFields());
    assertEquals(allFields, features.getAllFieldsRaw());
    assertEquals(allFields, options2.getAllFieldsRaw());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    ProcessingStrategyProto processingStrategy = actualParseDelimitedFromResult.getProcessingStrategy();
    Descriptors.Descriptor descriptorForType2 = processingStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    SubmitStrategyProto submitStrategy = actualParseDelimitedFromResult.getSubmitStrategy();
    Descriptors.Descriptor descriptorForType3 = submitStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, options2.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(QueueUpdateMsg.SUBMITSTRATEGY_FIELD_NUMBER);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options3.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options4.getFeaturesOrBuilder());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(features, options5.getFeatures());
    assertSame(features, options5.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(QueueUpdateMsg.PROCESSINGSTRATEGY_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options6 = options.getDescriptorForType().getOptions();
    assertSame(options6, defaultInstanceForType.getOptions());
    assertSame(options6, toProtoResult.getOptions());
    assertSame(options6, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options6, toProtoResult.getOptionsOrBuilder());
    assertSame(options6, options5.getDefaultInstanceForType());
    assertSame(options6, options6);
    assertSame(options6, toProtoResult.getDescriptorForType().getOptions());
    DescriptorProtos.MessageOptions options7 = descriptorForType3.getOptions();
    assertSame(options7, toProtoResult3.getOptions());
    assertSame(options7, toProtoResult3.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult4.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, options3.getDefaultInstanceForType());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult2.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, processingStrategy.getUnknownFields());
    assertSame(unknownFields, submitStrategy.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(processingStrategy, processingStrategy.getDefaultInstanceForType());
    assertSame(processingStrategy, actualParseDelimitedFromResult.getProcessingStrategyOrBuilder());
    assertSame(submitStrategy, actualParseDelimitedFromResult.getSubmitStrategyOrBuilder());
    assertSame(submitStrategy, submitStrategy.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link QueueUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueueUpdateMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> QueueUpdateMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link QueueUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> QueueUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link QueueUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return AllFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return AllFields size is one")
  void testParseDelimitedFromWithInput_thenReturnAllFieldsSizeIsOne() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    QueueUpdateMsg actualParseDelimitedFromResult = QueueUpdateMsg.parseDelimitedFrom(input);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    assertEquals(1, actualParseDelimitedFromResult.getAllFields().size());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    assertEquals(65L, actualParseDelimitedFromResult.getPackProcessingTimeout());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    ProcessingStrategyProto processingStrategy = actualParseDelimitedFromResult.getProcessingStrategy();
    Descriptors.Descriptor descriptorForType2 = processingStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    SubmitStrategyProto submitStrategy = actualParseDelimitedFromResult.getSubmitStrategy();
    Descriptors.Descriptor descriptorForType3 = submitStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(QueueUpdateMsg.SUBMITSTRATEGY_FIELD_NUMBER);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options3.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options4.getFeaturesOrBuilder());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(features, options5.getFeatures());
    assertSame(features, options5.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(QueueUpdateMsg.PROCESSINGSTRATEGY_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options6 = options.getDescriptorForType().getOptions();
    assertSame(options6, defaultInstanceForType.getOptions());
    assertSame(options6, toProtoResult.getOptions());
    assertSame(options6, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options6, toProtoResult.getOptionsOrBuilder());
    assertSame(options6, options5.getDefaultInstanceForType());
    assertSame(options6, options6);
    assertSame(options6, toProtoResult.getDescriptorForType().getOptions());
    DescriptorProtos.MessageOptions options7 = descriptorForType3.getOptions();
    assertSame(options7, toProtoResult3.getOptions());
    assertSame(options7, toProtoResult3.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult4.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, options3.getDefaultInstanceForType());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult2.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    QueueUpdateMsg defaultInstanceForType2 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, processingStrategy.getUnknownFields());
    assertSame(unknownFields, submitStrategy.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(processingStrategy, processingStrategy.getDefaultInstanceForType());
    assertSame(processingStrategy, defaultInstanceForType2.getProcessingStrategy());
    assertSame(processingStrategy, defaultInstanceForType2.getProcessingStrategyOrBuilder());
    assertSame(processingStrategy, actualParseDelimitedFromResult.getProcessingStrategyOrBuilder());
    assertSame(submitStrategy, defaultInstanceForType2.getSubmitStrategy());
    assertSame(submitStrategy, defaultInstanceForType2.getSubmitStrategyOrBuilder());
    assertSame(submitStrategy, actualParseDelimitedFromResult.getSubmitStrategyOrBuilder());
    assertSame(submitStrategy, submitStrategy.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link QueueUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(QueueUpdateMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link QueueUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then return SerializedSize is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return SerializedSize is zero")
  void testParseDelimitedFromWithInput_thenReturnSerializedSizeIsZero() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    QueueUpdateMsg actualParseDelimitedFromResult = QueueUpdateMsg.parseDelimitedFrom(input);

    // Assert
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    assertEquals(0L, actualParseDelimitedFromResult.getPackProcessingTimeout());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    Map<Descriptors.FieldDescriptor, Object> allFields = actualParseDelimitedFromResult.getAllFields();
    assertTrue(allFields.isEmpty());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertEquals(allFields, defaultInstanceForType.getAllFields());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertEquals(allFields, features.getAllFields());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertEquals(allFields, options2.getAllFields());
    assertEquals(allFields, features.getAllFieldsRaw());
    assertEquals(allFields, options2.getAllFieldsRaw());
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    ProcessingStrategyProto processingStrategy = actualParseDelimitedFromResult.getProcessingStrategy();
    Descriptors.Descriptor descriptorForType2 = processingStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    SubmitStrategyProto submitStrategy = actualParseDelimitedFromResult.getSubmitStrategy();
    Descriptors.Descriptor descriptorForType3 = submitStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(features, options2.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(QueueUpdateMsg.SUBMITSTRATEGY_FIELD_NUMBER);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options3.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options4.getFeaturesOrBuilder());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(features, options5.getFeatures());
    assertSame(features, options5.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(QueueUpdateMsg.PROCESSINGSTRATEGY_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options6 = options.getDescriptorForType().getOptions();
    assertSame(options6, defaultInstanceForType.getOptions());
    assertSame(options6, toProtoResult.getOptions());
    assertSame(options6, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options6, toProtoResult.getOptionsOrBuilder());
    assertSame(options6, options5.getDefaultInstanceForType());
    assertSame(options6, options6);
    assertSame(options6, toProtoResult.getDescriptorForType().getOptions());
    DescriptorProtos.MessageOptions options7 = descriptorForType3.getOptions();
    assertSame(options7, toProtoResult3.getOptions());
    assertSame(options7, toProtoResult3.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult4.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, options3.getDefaultInstanceForType());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult2.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, processingStrategy.getUnknownFields());
    assertSame(unknownFields, submitStrategy.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(processingStrategy, processingStrategy.getDefaultInstanceForType());
    assertSame(processingStrategy, actualParseDelimitedFromResult.getProcessingStrategyOrBuilder());
    assertSame(submitStrategy, actualParseDelimitedFromResult.getSubmitStrategyOrBuilder());
    assertSame(submitStrategy, submitStrategy.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link QueueUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueUpdateMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then throw IllegalArgumentException")
  void testParseDelimitedFromWithInput_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> QueueUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link QueueUpdateMsg#parseDelimitedFrom(InputStream)} with
   * {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueUpdateMsg#parseDelimitedFrom(InputStream)}
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
    assertThrows(InvalidProtocolBufferException.class, () -> QueueUpdateMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link QueueUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link QueueUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
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
        () -> QueueUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link QueueUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   * with {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueueUpdateMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> QueueUpdateMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link QueueUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> QueueUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link QueueUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> QueueUpdateMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link QueueUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty
   * array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    QueueUpdateMsg actualParseFromResult = QueueUpdateMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    ProcessingStrategyProto processingStrategy = actualParseFromResult.getProcessingStrategy();
    Descriptors.Descriptor descriptorForType2 = processingStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    SubmitStrategyProto submitStrategy = actualParseFromResult.getSubmitStrategy();
    Descriptors.Descriptor descriptorForType3 = submitStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(QueueUpdateMsg.SUBMITSTRATEGY_FIELD_NUMBER);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options3.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options4.getFeaturesOrBuilder());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(features, options5.getFeatures());
    assertSame(features, options5.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(QueueUpdateMsg.PROCESSINGSTRATEGY_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options6 = options.getDescriptorForType().getOptions();
    assertSame(options6, defaultInstanceForType.getOptions());
    assertSame(options6, toProtoResult.getOptions());
    assertSame(options6, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options6, toProtoResult.getOptionsOrBuilder());
    assertSame(options6, options5.getDefaultInstanceForType());
    assertSame(options6, options6);
    assertSame(options6, toProtoResult.getDescriptorForType().getOptions());
    DescriptorProtos.MessageOptions options7 = descriptorForType3.getOptions();
    assertSame(options7, toProtoResult3.getOptions());
    assertSame(options7, toProtoResult3.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult4.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, options3.getDefaultInstanceForType());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult2.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, processingStrategy.getUnknownFields());
    assertSame(unknownFields, submitStrategy.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(processingStrategy, processingStrategy.getDefaultInstanceForType());
    assertSame(processingStrategy, actualParseFromResult.getProcessingStrategyOrBuilder());
    assertSame(submitStrategy, actualParseFromResult.getSubmitStrategyOrBuilder());
    assertSame(submitStrategy, submitStrategy.getDefaultInstanceForType());
  }

  /**
   * Test {@link QueueUpdateMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueUpdateMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    QueueUpdateMsg actualParseFromResult = QueueUpdateMsg.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    assertEquals(1, file.getDependencies().size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(5, enumTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(QueueUpdateMsg.ENTITY_FIELD_NUMBER, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    ProcessingStrategyProto processingStrategy = actualParseFromResult.getProcessingStrategy();
    Descriptors.Descriptor descriptorForType2 = processingStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    SubmitStrategyProto submitStrategy = actualParseFromResult.getSubmitStrategy();
    Descriptors.Descriptor descriptorForType3 = submitStrategy.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult4 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult4.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult4.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options2 = getResult.getOptions();
    assertSame(features, options2.getFeatures());
    Descriptors.FieldDescriptor getResult2 = fields.get(QueueUpdateMsg.SUBMITSTRATEGY_FIELD_NUMBER);
    DescriptorProtos.FieldOptions options3 = getResult2.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options3.getFeaturesOrBuilder());
    DescriptorProtos.FileOptions options4 = file.getOptions();
    assertSame(features, options4.getFeatures());
    assertSame(features, options4.getFeaturesOrBuilder());
    DescriptorProtos.MessageOptions options5 = descriptorForType2.getOptions();
    assertSame(features, options5.getFeatures());
    assertSame(features, options5.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    Descriptors.EnumDescriptor enumType = getResult.getEnumType();
    assertSame(file, enumType.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(4).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(1);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(QueueUpdateMsg.PROCESSINGSTRATEGY_FIELD_NUMBER);
    assertSame(file, getResult4.getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options6 = options.getDescriptorForType().getOptions();
    assertSame(options6, defaultInstanceForType.getOptions());
    assertSame(options6, toProtoResult.getOptions());
    assertSame(options6, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options6, toProtoResult.getOptionsOrBuilder());
    assertSame(options6, options5.getDefaultInstanceForType());
    assertSame(options6, options6);
    assertSame(options6, toProtoResult.getDescriptorForType().getOptions());
    DescriptorProtos.MessageOptions options7 = descriptorForType3.getOptions();
    assertSame(options7, toProtoResult3.getOptions());
    assertSame(options7, toProtoResult3.getOptionsOrBuilder());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(enumType, enumTypes.get(3));
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult.toProto();
    assertSame(options2, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult3.toProto();
    assertSame(options2, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult4.toProto();
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult5.getOptionsOrBuilder());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options2, options3.getDefaultInstanceForType());
    assertSame(options2, getResult3.getOptions());
    assertSame(options2, getResult4.getOptions());
    assertSame(toProtoResult5, fieldList.get(0));
    assertSame(options4, toProtoResult4.getOptions());
    assertSame(options4, toProtoResult4.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult2.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options5.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, getResult2.toProto().getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, processingStrategy.getUnknownFields());
    assertSame(unknownFields, submitStrategy.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(processingStrategy, processingStrategy.getDefaultInstanceForType());
    assertSame(processingStrategy, actualParseFromResult.getProcessingStrategyOrBuilder());
    assertSame(submitStrategy, actualParseFromResult.getSubmitStrategyOrBuilder());
    assertSame(submitStrategy, submitStrategy.getDefaultInstanceForType());
  }
}
