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

class ResponseMsgDiffblueTest {
  /**
   * Test {@link ResponseMsg#equals(Object)}, and {@link ResponseMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResponseMsg#equals(Object)}
   *   <li>{@link ResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ResponseMsg defaultInstance = ResponseMsg.getDefaultInstance();
    ResponseMsg defaultInstance2 = ResponseMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance2);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance2.hashCode());
  }

  /**
   * Test {@link ResponseMsg#equals(Object)}, and {@link ResponseMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ResponseMsg#equals(Object)}
   *   <li>{@link ResponseMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ResponseMsg defaultInstance = ResponseMsg.getDefaultInstance();

    // Act and Assert
    assertEquals(defaultInstance, defaultInstance);
    int expectedHashCodeResult = defaultInstance.hashCode();
    assertEquals(expectedHashCodeResult, defaultInstance.hashCode());
  }

  /**
   * Test {@link ResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ResponseMsg.getDefaultInstance(), 1);
  }

  /**
   * Test {@link ResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ResponseMsg.getDefaultInstance(), null);
  }

  /**
   * Test {@link ResponseMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResponseMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ResponseMsg.getDefaultInstance(), "Different type to ResponseMsg");
  }

  /**
   * Test {@link ResponseMsg#getDefaultInstanceForType()}.
   * <p>
   * Method under test: {@link ResponseMsg#getDefaultInstanceForType()}
   */
  @Test
  @DisplayName("Test getDefaultInstanceForType()")
  void testGetDefaultInstanceForType() {
    // Arrange
    ResponseMsg defaultInstance = ResponseMsg.getDefaultInstance();

    // Act and Assert
    assertSame(defaultInstance, defaultInstance.getDefaultInstanceForType());
  }

  /**
   * Test {@link ResponseMsg#getSerializedSize()}.
   * <p>
   * Method under test: {@link ResponseMsg#getSerializedSize()}
   */
  @Test
  @DisplayName("Test getSerializedSize()")
  void testGetSerializedSize() {
    // Arrange, Act and Assert
    assertEquals(0, ResponseMsg.getDefaultInstance().getSerializedSize());
  }

  /**
   * Test {@link ResponseMsg#hasConnectResponseMsg()}.
   * <p>
   * Method under test: {@link ResponseMsg#hasConnectResponseMsg()}
   */
  @Test
  @DisplayName("Test hasConnectResponseMsg()")
  void testHasConnectResponseMsg() {
    // Arrange, Act and Assert
    assertFalse(ResponseMsg.getDefaultInstance().hasConnectResponseMsg());
  }

  /**
   * Test {@link ResponseMsg#hasDownlinkMsg()}.
   * <p>
   * Method under test: {@link ResponseMsg#hasDownlinkMsg()}
   */
  @Test
  @DisplayName("Test hasDownlinkMsg()")
  void testHasDownlinkMsg() {
    // Arrange, Act and Assert
    assertFalse(ResponseMsg.getDefaultInstance().hasDownlinkMsg());
  }

  /**
   * Test {@link ResponseMsg#hasEdgeUpdateMsg()}.
   * <p>
   * Method under test: {@link ResponseMsg#hasEdgeUpdateMsg()}
   */
  @Test
  @DisplayName("Test hasEdgeUpdateMsg()")
  void testHasEdgeUpdateMsg() {
    // Arrange, Act and Assert
    assertFalse(ResponseMsg.getDefaultInstance().hasEdgeUpdateMsg());
  }

  /**
   * Test {@link ResponseMsg#hasUplinkResponseMsg()}.
   * <p>
   * Method under test: {@link ResponseMsg#hasUplinkResponseMsg()}
   */
  @Test
  @DisplayName("Test hasUplinkResponseMsg()")
  void testHasUplinkResponseMsg() {
    // Arrange, Act and Assert
    assertFalse(ResponseMsg.getDefaultInstance().hasUplinkResponseMsg());
  }

  /**
   * Test {@link ResponseMsg#isInitialized()}.
   * <p>
   * Method under test: {@link ResponseMsg#isInitialized()}
   */
  @Test
  @DisplayName("Test isInitialized()")
  void testIsInitialized() {
    // Arrange, Act and Assert
    assertTrue(ResponseMsg.getDefaultInstance().isInitialized());
  }

  /**
   * Test {@link ResponseMsg#newInstance(UnusedPrivateParameter)}.
   * <p>
   * Method under test:
   * {@link ResponseMsg#newInstance(GeneratedMessageV3.UnusedPrivateParameter)}
   */
  @Test
  @DisplayName("Test newInstance(UnusedPrivateParameter)")
  void testNewInstance() {
    // Arrange
    ResponseMsg defaultInstance = ResponseMsg.getDefaultInstance();

    // Act
    Object actualNewInstanceResult = defaultInstance.newInstance(null);

    // Assert
    assertTrue(actualNewInstanceResult instanceof ResponseMsg);
    assertEquals(defaultInstance, actualNewInstanceResult);
  }

  /**
   * Test {@link ResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'")
  void testParseDelimitedFromWithInput() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ResponseMsg actualParseDelimitedFromResult = ResponseMsg.parseDelimitedFrom(input);

    // Assert
    ConnectResponseMsg connectResponseMsg = actualParseDelimitedFromResult.getConnectResponseMsg();
    UnknownFieldSet unknownFields = connectResponseMsg.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    Descriptors.Descriptor descriptorForType2 = connectResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    DownlinkMsg downlinkMsg = actualParseDelimitedFromResult.getDownlinkMsg();
    Descriptors.Descriptor descriptorForType3 = downlinkMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    EdgeUpdateMsg edgeUpdateMsg = actualParseDelimitedFromResult.getEdgeUpdateMsg();
    Descriptors.Descriptor descriptorForType4 = edgeUpdateMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    UplinkResponseMsg uplinkResponseMsg = actualParseDelimitedFromResult.getUplinkResponseMsg();
    Descriptors.Descriptor descriptorForType5 = uplinkResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult6 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult6.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult6.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    EdgeConfiguration configuration = connectResponseMsg.getConfiguration();
    Descriptors.Descriptor descriptorForType6 = configuration.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    SyncCompletedMsg syncCompletedMsg = downlinkMsg.getSyncCompletedMsg();
    Descriptors.Descriptor descriptorForType7 = syncCompletedMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options3 = options.getDescriptorForType().getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType6.getOptions());
    assertSame(options3, descriptorForType7.getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, toProtoResult6.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult.getMessageType());
    assertSame(descriptorForType3, getResult3.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(57));
    assertSame(descriptorForType4, getResult4.getMessageType());
    assertSame(descriptorForType5, getResult2.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    ResponseMsg defaultInstanceForType2 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, configuration.getUnknownFields());
    assertSame(unknownFields, syncCompletedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, downlinkMsg.getUnknownFields());
    assertSame(unknownFields, edgeUpdateMsg.getUnknownFields());
    assertSame(unknownFields, uplinkResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(configuration, connectResponseMsg.getConfigurationOrBuilder());
    assertSame(configuration, downlinkMsg.getEdgeConfiguration());
    assertSame(configuration, downlinkMsg.getEdgeConfigurationOrBuilder());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertSame(configuration, edgeUpdateMsg.getConfiguration());
    assertSame(configuration, edgeUpdateMsg.getConfigurationOrBuilder());
    assertSame(syncCompletedMsg, downlinkMsg.getSyncCompletedMsgOrBuilder());
    assertSame(syncCompletedMsg, syncCompletedMsg.getDefaultInstanceForType());
    assertSame(connectResponseMsg, connectResponseMsg.getDefaultInstanceForType());
    assertSame(connectResponseMsg, defaultInstanceForType2.getConnectResponseMsg());
    assertSame(connectResponseMsg, defaultInstanceForType2.getConnectResponseMsgOrBuilder());
    assertSame(connectResponseMsg, actualParseDelimitedFromResult.getConnectResponseMsgOrBuilder());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(downlinkMsg, downlinkMsg.getDefaultInstanceForType());
    assertSame(downlinkMsg, defaultInstanceForType2.getDownlinkMsg());
    assertSame(downlinkMsg, defaultInstanceForType2.getDownlinkMsgOrBuilder());
    assertSame(downlinkMsg, actualParseDelimitedFromResult.getDownlinkMsgOrBuilder());
    assertSame(edgeUpdateMsg, edgeUpdateMsg.getDefaultInstanceForType());
    assertSame(edgeUpdateMsg, defaultInstanceForType2.getEdgeUpdateMsg());
    assertSame(edgeUpdateMsg, defaultInstanceForType2.getEdgeUpdateMsgOrBuilder());
    assertSame(edgeUpdateMsg, actualParseDelimitedFromResult.getEdgeUpdateMsgOrBuilder());
    assertSame(uplinkResponseMsg, defaultInstanceForType2.getUplinkResponseMsg());
    assertSame(uplinkResponseMsg, defaultInstanceForType2.getUplinkResponseMsgOrBuilder());
    assertSame(uplinkResponseMsg, actualParseDelimitedFromResult.getUplinkResponseMsgOrBuilder());
    assertSame(uplinkResponseMsg, uplinkResponseMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <p>
   * Method under test: {@link ResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'")
  void testParseDelimitedFromWithInput2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ResponseMsg actualParseDelimitedFromResult = ResponseMsg.parseDelimitedFrom(input);

    // Assert
    ConnectResponseMsg connectResponseMsg = actualParseDelimitedFromResult.getConnectResponseMsg();
    EdgeConfiguration configuration = connectResponseMsg.getConfiguration();
    Descriptors.Descriptor descriptorForType = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals(0, toProtoResult.getReservedNameCount());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(4, fields.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    Descriptors.Descriptor descriptorForType3 = connectResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DownlinkMsg downlinkMsg = actualParseDelimitedFromResult.getDownlinkMsg();
    Descriptors.Descriptor descriptorForType4 = downlinkMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    EdgeUpdateMsg edgeUpdateMsg = actualParseDelimitedFromResult.getEdgeUpdateMsg();
    Descriptors.Descriptor descriptorForType5 = edgeUpdateMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    UplinkResponseMsg uplinkResponseMsg = actualParseDelimitedFromResult.getUplinkResponseMsg();
    Descriptors.Descriptor descriptorForType6 = uplinkResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType6.toProto();
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult7 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult7.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult7.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    SyncCompletedMsg syncCompletedMsg = downlinkMsg.getSyncCompletedMsg();
    Descriptors.Descriptor descriptorForType7 = syncCompletedMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    assertSame(file, descriptorForType6.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options3 = options.getDescriptorForType().getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, descriptorForType7.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options3, descriptorForType6.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(descriptorForType3, getResult.getMessageType());
    assertSame(descriptorForType4, getResult3.getMessageType());
    assertSame(descriptorForType4, messageTypes.get(57));
    assertSame(descriptorForType5, getResult4.getMessageType());
    assertSame(descriptorForType6, getResult2.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult2.getContainingType());
    assertSame(descriptorForType2, getResult3.getContainingType());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, configuration.getUnknownFields());
    assertSame(unknownFields, syncCompletedMsg.getUnknownFields());
    assertSame(unknownFields, connectResponseMsg.getUnknownFields());
    assertSame(unknownFields, downlinkMsg.getUnknownFields());
    assertSame(unknownFields, edgeUpdateMsg.getUnknownFields());
    assertSame(unknownFields, uplinkResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(configuration, connectResponseMsg.getConfigurationOrBuilder());
    assertSame(configuration, downlinkMsg.getEdgeConfiguration());
    assertSame(configuration, downlinkMsg.getEdgeConfigurationOrBuilder());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertSame(configuration, edgeUpdateMsg.getConfiguration());
    assertSame(configuration, edgeUpdateMsg.getConfigurationOrBuilder());
    assertSame(syncCompletedMsg, downlinkMsg.getSyncCompletedMsgOrBuilder());
    assertSame(syncCompletedMsg, syncCompletedMsg.getDefaultInstanceForType());
    assertSame(connectResponseMsg, connectResponseMsg.getDefaultInstanceForType());
    assertSame(connectResponseMsg, actualParseDelimitedFromResult.getConnectResponseMsgOrBuilder());
    assertSame(downlinkMsg, downlinkMsg.getDefaultInstanceForType());
    assertSame(downlinkMsg, actualParseDelimitedFromResult.getDownlinkMsgOrBuilder());
    assertSame(edgeUpdateMsg, edgeUpdateMsg.getDefaultInstanceForType());
    assertSame(edgeUpdateMsg, actualParseDelimitedFromResult.getEdgeUpdateMsgOrBuilder());
    assertSame(uplinkResponseMsg, actualParseDelimitedFromResult.getUplinkResponseMsgOrBuilder());
    assertSame(uplinkResponseMsg, uplinkResponseMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link ResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link ResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{2, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ResponseMsg actualParseDelimitedFromResult = ResponseMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    ConnectResponseMsg connectResponseMsg = actualParseDelimitedFromResult.getConnectResponseMsg();
    UnknownFieldSet unknownFields = connectResponseMsg.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, unknownFields.getSerializedSizeAsMessageSet());
    UnknownFieldSet unknownFields2 = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(2, unknownFields2.getSerializedSize());
    assertEquals(2, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    byte[] byteArray = new byte[5];
    assertEquals(5, input.read(byteArray));
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertTrue(unknownFields.isInitialized());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    Descriptors.Descriptor descriptorForType2 = connectResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    DownlinkMsg downlinkMsg = actualParseDelimitedFromResult.getDownlinkMsg();
    Descriptors.Descriptor descriptorForType3 = downlinkMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    EdgeUpdateMsg edgeUpdateMsg = actualParseDelimitedFromResult.getEdgeUpdateMsg();
    Descriptors.Descriptor descriptorForType4 = edgeUpdateMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    UplinkResponseMsg uplinkResponseMsg = actualParseDelimitedFromResult.getUplinkResponseMsg();
    Descriptors.Descriptor descriptorForType5 = uplinkResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult6 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult6.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult6.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    EdgeConfiguration configuration = connectResponseMsg.getConfiguration();
    Descriptors.Descriptor descriptorForType6 = configuration.getDescriptorForType();
    assertSame(file, descriptorForType6.getFile());
    SyncCompletedMsg syncCompletedMsg = downlinkMsg.getSyncCompletedMsg();
    Descriptors.Descriptor descriptorForType7 = syncCompletedMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    assertSame(file, descriptorForType2.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options3 = options.getDescriptorForType().getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType6.getOptions());
    assertSame(options3, descriptorForType7.getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, toProtoResult6.getOptions());
    assertSame(options2, toProtoResult6.getOptionsOrBuilder());
    assertSame(descriptorForType2, getResult.getMessageType());
    assertSame(descriptorForType3, getResult3.getMessageType());
    assertSame(descriptorForType3, messageTypes.get(57));
    assertSame(descriptorForType4, getResult4.getMessageType());
    assertSame(descriptorForType5, getResult2.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    ResponseMsg defaultInstanceForType2 = actualParseDelimitedFromResult.getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType2.getDescriptorForType());
    assertSame(descriptorForType, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, configuration.getUnknownFields());
    assertSame(unknownFields, syncCompletedMsg.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, downlinkMsg.getUnknownFields());
    assertSame(unknownFields, edgeUpdateMsg.getUnknownFields());
    assertSame(unknownFields, uplinkResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(unknownFields, unknownFields2.getDefaultInstanceForType());
    assertSame(configuration, connectResponseMsg.getConfigurationOrBuilder());
    assertSame(configuration, downlinkMsg.getEdgeConfiguration());
    assertSame(configuration, downlinkMsg.getEdgeConfigurationOrBuilder());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertSame(configuration, edgeUpdateMsg.getConfiguration());
    assertSame(configuration, edgeUpdateMsg.getConfigurationOrBuilder());
    assertSame(syncCompletedMsg, downlinkMsg.getSyncCompletedMsgOrBuilder());
    assertSame(syncCompletedMsg, syncCompletedMsg.getDefaultInstanceForType());
    assertSame(connectResponseMsg, connectResponseMsg.getDefaultInstanceForType());
    assertSame(connectResponseMsg, defaultInstanceForType2.getConnectResponseMsg());
    assertSame(connectResponseMsg, defaultInstanceForType2.getConnectResponseMsgOrBuilder());
    assertSame(connectResponseMsg, actualParseDelimitedFromResult.getConnectResponseMsgOrBuilder());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(downlinkMsg, downlinkMsg.getDefaultInstanceForType());
    assertSame(downlinkMsg, defaultInstanceForType2.getDownlinkMsg());
    assertSame(downlinkMsg, defaultInstanceForType2.getDownlinkMsgOrBuilder());
    assertSame(downlinkMsg, actualParseDelimitedFromResult.getDownlinkMsgOrBuilder());
    assertSame(edgeUpdateMsg, edgeUpdateMsg.getDefaultInstanceForType());
    assertSame(edgeUpdateMsg, defaultInstanceForType2.getEdgeUpdateMsg());
    assertSame(edgeUpdateMsg, defaultInstanceForType2.getEdgeUpdateMsgOrBuilder());
    assertSame(edgeUpdateMsg, actualParseDelimitedFromResult.getEdgeUpdateMsgOrBuilder());
    assertSame(uplinkResponseMsg, defaultInstanceForType2.getUplinkResponseMsg());
    assertSame(uplinkResponseMsg, defaultInstanceForType2.getUplinkResponseMsgOrBuilder());
    assertSame(uplinkResponseMsg, actualParseDelimitedFromResult.getUplinkResponseMsgOrBuilder());
    assertSame(uplinkResponseMsg, uplinkResponseMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link ResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link ResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'")
  void testParseDelimitedFromWithInputExtensionRegistry2() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    ResponseMsg actualParseDelimitedFromResult = ResponseMsg.parseDelimitedFrom(input,
        ExtensionRegistryLite.getEmptyRegistry());

    // Assert
    ConnectResponseMsg connectResponseMsg = actualParseDelimitedFromResult.getConnectResponseMsg();
    EdgeConfiguration configuration = connectResponseMsg.getConfiguration();
    Descriptors.Descriptor descriptorForType = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    assertEquals(0, toProtoResult.getReservedNameCount());
    UnknownFieldSet unknownFields = actualParseDelimitedFromResult.getUnknownFields();
    assertEquals(0, unknownFields.getSerializedSize());
    assertEquals(0, actualParseDelimitedFromResult.getSerializedSize());
    Descriptors.Descriptor descriptorForType2 = actualParseDelimitedFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType2.getFields();
    assertEquals(4, fields.size());
    Descriptors.FileDescriptor file = descriptorForType2.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertEquals(actualParseDelimitedFromResult, actualParseDelimitedFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult2.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    assertSame(reservedNameList, toProtoResult.getReservedNameList());
    Descriptors.Descriptor descriptorForType3 = connectResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DownlinkMsg downlinkMsg = actualParseDelimitedFromResult.getDownlinkMsg();
    Descriptors.Descriptor descriptorForType4 = downlinkMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    EdgeUpdateMsg edgeUpdateMsg = actualParseDelimitedFromResult.getEdgeUpdateMsg();
    Descriptors.Descriptor descriptorForType5 = edgeUpdateMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    UplinkResponseMsg uplinkResponseMsg = actualParseDelimitedFromResult.getUplinkResponseMsg();
    Descriptors.Descriptor descriptorForType6 = uplinkResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType6.toProto();
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult7 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult7.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult7.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType2.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType.getFile());
    SyncCompletedMsg syncCompletedMsg = downlinkMsg.getSyncCompletedMsg();
    Descriptors.Descriptor descriptorForType7 = syncCompletedMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    assertSame(file, descriptorForType6.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options3 = options.getDescriptorForType().getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType.getOptions());
    assertSame(options3, descriptorForType7.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options3, descriptorForType6.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(descriptorForType3, getResult.getMessageType());
    assertSame(descriptorForType4, getResult3.getMessageType());
    assertSame(descriptorForType4, messageTypes.get(57));
    assertSame(descriptorForType5, getResult4.getMessageType());
    assertSame(descriptorForType6, getResult2.getMessageType());
    assertSame(descriptorForType2, getResult.getContainingType());
    assertSame(descriptorForType2, getResult2.getContainingType());
    assertSame(descriptorForType2, getResult3.getContainingType());
    assertSame(descriptorForType2, getResult4.getContainingType());
    assertSame(descriptorForType2, messageTypes.get(1));
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, configuration.getUnknownFields());
    assertSame(unknownFields, syncCompletedMsg.getUnknownFields());
    assertSame(unknownFields, connectResponseMsg.getUnknownFields());
    assertSame(unknownFields, downlinkMsg.getUnknownFields());
    assertSame(unknownFields, edgeUpdateMsg.getUnknownFields());
    assertSame(unknownFields, uplinkResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(configuration, connectResponseMsg.getConfigurationOrBuilder());
    assertSame(configuration, downlinkMsg.getEdgeConfiguration());
    assertSame(configuration, downlinkMsg.getEdgeConfigurationOrBuilder());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertSame(configuration, edgeUpdateMsg.getConfiguration());
    assertSame(configuration, edgeUpdateMsg.getConfigurationOrBuilder());
    assertSame(syncCompletedMsg, downlinkMsg.getSyncCompletedMsgOrBuilder());
    assertSame(syncCompletedMsg, syncCompletedMsg.getDefaultInstanceForType());
    assertSame(connectResponseMsg, connectResponseMsg.getDefaultInstanceForType());
    assertSame(connectResponseMsg, actualParseDelimitedFromResult.getConnectResponseMsgOrBuilder());
    assertSame(downlinkMsg, downlinkMsg.getDefaultInstanceForType());
    assertSame(downlinkMsg, actualParseDelimitedFromResult.getDownlinkMsgOrBuilder());
    assertSame(edgeUpdateMsg, edgeUpdateMsg.getDefaultInstanceForType());
    assertSame(edgeUpdateMsg, actualParseDelimitedFromResult.getEdgeUpdateMsgOrBuilder());
    assertSame(uplinkResponseMsg, actualParseDelimitedFromResult.getUplinkResponseMsgOrBuilder());
    assertSame(uplinkResponseMsg, uplinkResponseMsg.getDefaultInstanceForType());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link ResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <p>
   * Method under test:
   * {@link ResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> ResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test
   * {@link ResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream, ExtensionRegistryLite) with 'input', 'extensionRegistry'; then return 'null'")
  void testParseDelimitedFromWithInputExtensionRegistry_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test
   * {@link ResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
   * with {@code input}, {@code extensionRegistry}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResponseMsg#parseDelimitedFrom(InputStream, ExtensionRegistryLite)}
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
        () -> ResponseMsg.parseDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; given IOException(String) with 'foo'; then throw IOException")
  void testParseDelimitedFromWithInput_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));
    when(input.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> ResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResponseMsg#parseDelimitedFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseDelimitedFrom(InputStream) with 'input'; then return 'null'")
  void testParseDelimitedFromWithInput_thenReturnNull() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});

    // Act and Assert
    assertNull(ResponseMsg.parseDelimitedFrom(input));
    assertEquals(-1, input.read(new byte[]{}));
  }

  /**
   * Test {@link ResponseMsg#parseDelimitedFrom(InputStream)} with {@code input}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResponseMsg#parseDelimitedFrom(InputStream)}
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
    assertThrows(InvalidProtocolBufferException.class, () -> ResponseMsg.parseDelimitedFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(1));
    verify(input).read();
  }

  /**
   * Test {@link ResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <p>
   * Method under test:
   * {@link ResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
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
        () -> ResponseMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)} with
   * {@code InputStream}, {@code ExtensionRegistryLite}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResponseMsg#parseFrom(InputStream, ExtensionRegistryLite)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream, ExtensionRegistryLite) with 'InputStream', 'ExtensionRegistryLite'; then throw IOException")
  void testParseFromWithInputStreamExtensionRegistryLite_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ResponseMsg.parseFrom(input, ExtensionRegistryLite.getEmptyRegistry()));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ResponseMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; given IOException(String) with 'foo'; then throw IOException")
  void testParseFromWithInputStream_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> ResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ResponseMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>Then throw {@link InvalidProtocolBufferException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; then throw InvalidProtocolBufferException")
  void testParseFromWithInputStream_thenThrowInvalidProtocolBufferException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new InvalidProtocolBufferException("The characteristics of someone or something"));

    // Act and Assert
    assertThrows(InvalidProtocolBufferException.class, () -> ResponseMsg.parseFrom(input));
    verify(input).read(isA(byte[].class), eq(0), eq(4096));
  }

  /**
   * Test {@link ResponseMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty
   * array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when ByteArrayInputStream(byte[]) with empty array of byte")
  void testParseFromWithInputStream_whenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange and Act
    ResponseMsg actualParseFromResult = ResponseMsg.parseFrom(new ByteArrayInputStream(new byte[]{}));

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    ConnectResponseMsg connectResponseMsg = actualParseFromResult.getConnectResponseMsg();
    EdgeConfiguration configuration = connectResponseMsg.getConfiguration();
    Descriptors.Descriptor descriptorForType2 = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    Descriptors.Descriptor descriptorForType3 = connectResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DownlinkMsg downlinkMsg = actualParseFromResult.getDownlinkMsg();
    Descriptors.Descriptor descriptorForType4 = downlinkMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    EdgeUpdateMsg edgeUpdateMsg = actualParseFromResult.getEdgeUpdateMsg();
    Descriptors.Descriptor descriptorForType5 = edgeUpdateMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    UplinkResponseMsg uplinkResponseMsg = actualParseFromResult.getUplinkResponseMsg();
    Descriptors.Descriptor descriptorForType6 = uplinkResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType6.toProto();
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult7 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult7.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult7.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    SyncCompletedMsg syncCompletedMsg = downlinkMsg.getSyncCompletedMsg();
    Descriptors.Descriptor descriptorForType7 = syncCompletedMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    assertSame(file, descriptorForType6.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options3 = options.getDescriptorForType().getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, descriptorForType7.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options3, descriptorForType6.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(descriptorForType3, getResult.getMessageType());
    assertSame(descriptorForType4, getResult3.getMessageType());
    assertSame(descriptorForType4, messageTypes.get(57));
    assertSame(descriptorForType5, getResult4.getMessageType());
    assertSame(descriptorForType6, getResult2.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, configuration.getUnknownFields());
    assertSame(unknownFields, syncCompletedMsg.getUnknownFields());
    assertSame(unknownFields, connectResponseMsg.getUnknownFields());
    assertSame(unknownFields, downlinkMsg.getUnknownFields());
    assertSame(unknownFields, edgeUpdateMsg.getUnknownFields());
    assertSame(unknownFields, uplinkResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(configuration, connectResponseMsg.getConfigurationOrBuilder());
    assertSame(configuration, downlinkMsg.getEdgeConfiguration());
    assertSame(configuration, downlinkMsg.getEdgeConfigurationOrBuilder());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertSame(configuration, edgeUpdateMsg.getConfiguration());
    assertSame(configuration, edgeUpdateMsg.getConfigurationOrBuilder());
    assertSame(syncCompletedMsg, downlinkMsg.getSyncCompletedMsgOrBuilder());
    assertSame(syncCompletedMsg, syncCompletedMsg.getDefaultInstanceForType());
    assertSame(connectResponseMsg, connectResponseMsg.getDefaultInstanceForType());
    assertSame(connectResponseMsg, actualParseFromResult.getConnectResponseMsgOrBuilder());
    assertSame(downlinkMsg, downlinkMsg.getDefaultInstanceForType());
    assertSame(downlinkMsg, actualParseFromResult.getDownlinkMsgOrBuilder());
    assertSame(edgeUpdateMsg, edgeUpdateMsg.getDefaultInstanceForType());
    assertSame(edgeUpdateMsg, actualParseFromResult.getEdgeUpdateMsgOrBuilder());
    assertSame(uplinkResponseMsg, actualParseFromResult.getUplinkResponseMsgOrBuilder());
    assertSame(uplinkResponseMsg, uplinkResponseMsg.getDefaultInstanceForType());
  }

  /**
   * Test {@link ResponseMsg#parseFrom(InputStream)} with {@code InputStream}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResponseMsg#parseFrom(InputStream)}
   */
  @Test
  @DisplayName("Test parseFrom(InputStream) with 'InputStream'; when 'null'")
  void testParseFromWithInputStream_whenNull() throws IOException {
    // Arrange and Act
    ResponseMsg actualParseFromResult = ResponseMsg.parseFrom((InputStream) null);

    // Assert
    Descriptors.Descriptor descriptorForType = actualParseFromResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(4, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(4, fields.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(58, messageTypes.size());
    assertEquals(actualParseFromResult, actualParseFromResult.getDefaultInstanceForType());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType.getReservedNameList());
    ConnectResponseMsg connectResponseMsg = actualParseFromResult.getConnectResponseMsg();
    EdgeConfiguration configuration = connectResponseMsg.getConfiguration();
    Descriptors.Descriptor descriptorForType2 = configuration.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType2.toProto();
    assertSame(reservedNameList, toProtoResult2.getReservedNameList());
    Descriptors.Descriptor descriptorForType3 = connectResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType3.toProto();
    assertSame(reservedNameList, toProtoResult3.getReservedNameList());
    DownlinkMsg downlinkMsg = actualParseFromResult.getDownlinkMsg();
    Descriptors.Descriptor descriptorForType4 = downlinkMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType4.toProto();
    assertSame(reservedNameList, toProtoResult4.getReservedNameList());
    EdgeUpdateMsg edgeUpdateMsg = actualParseFromResult.getEdgeUpdateMsg();
    Descriptors.Descriptor descriptorForType5 = edgeUpdateMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType5.toProto();
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    UplinkResponseMsg uplinkResponseMsg = actualParseFromResult.getUplinkResponseMsg();
    Descriptors.Descriptor descriptorForType6 = uplinkResponseMsg.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType6.toProto();
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    DescriptorProtos.FileDescriptorProto toProtoResult7 = file.toProto();
    List<Integer> expectedWeakDependencyList = toProtoResult7.getPublicDependencyList();
    assertSame(expectedWeakDependencyList, toProtoResult7.getWeakDependencyList());
    DescriptorProtos.MessageOptions options = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options2 = file.getOptions();
    assertSame(features, options2.getFeatures());
    assertSame(features, options2.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(file, descriptorForType2.getFile());
    SyncCompletedMsg syncCompletedMsg = downlinkMsg.getSyncCompletedMsg();
    Descriptors.Descriptor descriptorForType7 = syncCompletedMsg.getDescriptorForType();
    assertSame(file, descriptorForType7.getFile());
    assertSame(file, descriptorForType3.getFile());
    assertSame(file, descriptorForType4.getFile());
    assertSame(file, descriptorForType5.getFile());
    assertSame(file, descriptorForType6.getFile());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult2 = fields.get(1);
    assertSame(file, getResult2.getFile());
    Descriptors.FieldDescriptor getResult3 = fields.get(2);
    assertSame(file, getResult3.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(3);
    assertSame(file, getResult4.getFile());
    DescriptorProtos.MessageOptions options3 = options.getDescriptorForType().getOptions();
    assertSame(options3, defaultInstanceForType.getOptions());
    assertSame(options3, toProtoResult2.getOptions());
    assertSame(options3, toProtoResult3.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options3, toProtoResult2.getOptionsOrBuilder());
    assertSame(options3, toProtoResult3.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, options3);
    assertSame(options3, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType2.getOptions());
    assertSame(options3, descriptorForType7.getOptions());
    assertSame(options3, descriptorForType3.getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, descriptorForType5.getOptions());
    assertSame(options3, descriptorForType6.getOptions());
    assertSame(options, options.getDefaultInstanceForType());
    assertSame(options2, toProtoResult7.getOptions());
    assertSame(options2, toProtoResult7.getOptionsOrBuilder());
    assertSame(descriptorForType3, getResult.getMessageType());
    assertSame(descriptorForType4, getResult3.getMessageType());
    assertSame(descriptorForType4, messageTypes.get(57));
    assertSame(descriptorForType5, getResult4.getMessageType());
    assertSame(descriptorForType6, getResult2.getMessageType());
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult2.getContainingType());
    assertSame(descriptorForType, getResult3.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, messageTypes.get(1));
    UnknownFieldSet unknownFields = actualParseFromResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, configuration.getUnknownFields());
    assertSame(unknownFields, syncCompletedMsg.getUnknownFields());
    assertSame(unknownFields, connectResponseMsg.getUnknownFields());
    assertSame(unknownFields, downlinkMsg.getUnknownFields());
    assertSame(unknownFields, edgeUpdateMsg.getUnknownFields());
    assertSame(unknownFields, uplinkResponseMsg.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(configuration, connectResponseMsg.getConfigurationOrBuilder());
    assertSame(configuration, downlinkMsg.getEdgeConfiguration());
    assertSame(configuration, downlinkMsg.getEdgeConfigurationOrBuilder());
    assertSame(configuration, configuration.getDefaultInstanceForType());
    assertSame(configuration, edgeUpdateMsg.getConfiguration());
    assertSame(configuration, edgeUpdateMsg.getConfigurationOrBuilder());
    assertSame(syncCompletedMsg, downlinkMsg.getSyncCompletedMsgOrBuilder());
    assertSame(syncCompletedMsg, syncCompletedMsg.getDefaultInstanceForType());
    assertSame(connectResponseMsg, connectResponseMsg.getDefaultInstanceForType());
    assertSame(connectResponseMsg, actualParseFromResult.getConnectResponseMsgOrBuilder());
    assertSame(downlinkMsg, downlinkMsg.getDefaultInstanceForType());
    assertSame(downlinkMsg, actualParseFromResult.getDownlinkMsgOrBuilder());
    assertSame(edgeUpdateMsg, edgeUpdateMsg.getDefaultInstanceForType());
    assertSame(edgeUpdateMsg, actualParseFromResult.getEdgeUpdateMsgOrBuilder());
    assertSame(uplinkResponseMsg, actualParseFromResult.getUplinkResponseMsgOrBuilder());
    assertSame(uplinkResponseMsg, uplinkResponseMsg.getDefaultInstanceForType());
  }
}
